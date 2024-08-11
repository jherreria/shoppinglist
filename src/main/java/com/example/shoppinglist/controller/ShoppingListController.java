package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.ShoppingList;
import com.example.shoppinglist.service.ShoppingListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shopping-lists")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping
    public List<ShoppingList> getAllShoppingLists() {
        return shoppingListService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingList> getShoppingListById(@PathVariable Long id) {
        Optional<ShoppingList> shoppingList = shoppingListService.findById(id);
        return shoppingList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ShoppingList> createShoppingList(@RequestBody ShoppingList shoppingList) {
        ShoppingList savedShoppingList = shoppingListService.save(shoppingList);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShoppingList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingList> updateShoppingList(@PathVariable Long id, @RequestBody ShoppingList shoppingList) {
        if (!shoppingListService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        shoppingList.setId(id);
        ShoppingList updatedShoppingList = shoppingListService.save(shoppingList);
        return ResponseEntity.ok(updatedShoppingList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingList(@PathVariable Long id) {
        if (!shoppingListService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        shoppingListService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}