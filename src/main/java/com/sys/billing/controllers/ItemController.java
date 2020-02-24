package com.sys.billing.controllers;

import com.sys.billing.models.Item;
import com.sys.billing.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    public ItemService itemService;

    @GetMapping()
    ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<List<Item>>(itemService.getAllItems(), HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<String> addItems(@Valid @RequestBody List<Item> items) {
        return new ResponseEntity<String>(itemService.postItems(items), HttpStatus.OK);
    }

    @PutMapping()
    ResponseEntity<String> changeItems(@Valid @RequestBody List<Item> items){
        return new ResponseEntity<String>(itemService.updateItems(items), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteItem(@PathVariable("id") final UUID uuid) {
        return new ResponseEntity<String>(itemService.deleteItem(uuid), HttpStatus.OK);
    }
}
