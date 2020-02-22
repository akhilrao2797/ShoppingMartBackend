package com.sys.billing.controllers;

import com.sys.billing.models.Items;
import com.sys.billing.repositories.ItemRepository;
import com.sys.billing.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    public ItemService itemService;

    @GetMapping()
    List<Items> getItems() {
        return itemService.getAllItems();
    }

    @PostMapping()
    String addItems(@RequestBody List<Items> items) {
        return itemService.postItems(items);
    }

    @PutMapping()
    String changeItems(@RequestBody List<Items> items){
        return itemService.updateItems(items);
    }

    @DeleteMapping("/{id}")
    String deleteItem(@PathVariable("id") final UUID uuid) {
        return itemService.deleteItem(uuid);
    }
}
