package com.sys.billing.services;

import com.sys.billing.models.Item;
import com.sys.billing.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public String postItems(List<Item> items) {
        itemRepository.saveAll(items);
        return "Successfully Added";
    }

    public String updateItems(List<Item> items) {
        return postItems(items);
    }

    public String deleteItem(UUID uuid) {
        itemRepository.delete(itemRepository.findItemByItemId(uuid));
        return "Successfully deleted";
    }

    public Item getItemByItemName(String name){
        return itemRepository.findItemByItemName(name);
    }
}
