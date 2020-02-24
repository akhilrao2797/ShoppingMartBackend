package com.sys.billing.services;

import com.sys.billing.models.Inventory;
import com.sys.billing.models.Item;
import com.sys.billing.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    private ItemService itemService;
    private InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(ItemService itemService, InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
        this.itemService = itemService;
    }

    @Scheduled(cron = "0 0 10 * * *")
    public List<Item> getItemsNearToFinish(){
        List<Item> items = itemService.getAllItems()
                .stream()
                .filter(item -> {
                    int value = item.getInventory().getTotalQuantity() - item.getInventory().getThresholdQuantity();
                    return (value > 0)? false:true;
                })
                .collect(Collectors.toList());
        return items;
    }

    public Inventory addItemToInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public Inventory updateItemInInventory(String itemName){
        Inventory inventory = itemService.getItemByItemName(itemName).getInventory();
        return inventoryRepository.save(inventory);
    }

    public String deleteItemFromInventory(String itemName) {
        Item item = itemService.getItemByItemName(itemName);
        inventoryRepository.delete(item.getInventory());
        return "Successfully deleted";
    }

    public Inventory getItemInventory(String itemName){
        return itemService.getItemByItemName(itemName).getInventory();
    }
}
