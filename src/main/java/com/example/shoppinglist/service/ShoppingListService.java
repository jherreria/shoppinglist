package com.example.shoppinglist.service;

import com.example.shoppinglist.model.ShoppingList;
import com.example.shoppinglist.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public List<ShoppingList> findAll() {
        return shoppingListRepository.findAll();
    }

    public Optional<ShoppingList> findById(Long id) {
        return shoppingListRepository.findById(id);
    }

    public ShoppingList save(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public void deleteById(Long id) {
        shoppingListRepository.deleteById(id);
    }
}
