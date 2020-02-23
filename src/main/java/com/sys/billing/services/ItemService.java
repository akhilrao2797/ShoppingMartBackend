package com.sys.billing.services;

import com.sys.billing.models.Items;
import com.sys.billing.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Items> getAllItems() {
        return itemRepository.findAll();
    }

    public String postItems(List<Items> items) {
        itemRepository.saveAll(items);
        return "Successfully Added";
    }

    public String updateItems(List<Items> items) {
        return postItems(items);
    }

    public String deleteItem(UUID uuid) {
        itemRepository.delete(itemRepository.findItemsByItemId(uuid));
        return "Successfully deleted";
    }
}
