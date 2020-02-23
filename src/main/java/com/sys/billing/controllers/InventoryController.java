package com.sys.billing.controllers;

import com.sys.billing.models.Inventory;
import com.sys.billing.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping()
    ResponseEntity<Inventory> insertItemToInventory(@Valid @RequestBody final Inventory inventory){
        return new ResponseEntity<Inventory>(inventoryService.addItemToInventory(inventory), HttpStatus.CREATED);
    }

    @PutMapping("/{itemName}")
    ResponseEntity<Inventory> updateItemInInventory(@PathVariable("itemName") final String itemName){
        return new ResponseEntity<Inventory>(inventoryService.updateItemInInventory(itemName), HttpStatus.OK);
    }

    @DeleteMapping("/{itemName}")
    ResponseEntity<String> deleteItemFromInventory(@PathVariable("itemName") final String itemName){
        return new ResponseEntity<String>(inventoryService.deleteItemFromInventory(itemName), HttpStatus.OK);
    }
}
