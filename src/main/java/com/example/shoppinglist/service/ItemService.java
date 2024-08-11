package com.example.shoppinglist.service;

import com.example.shoppinglist.exception.ShoppingListException;
import com.example.shoppinglist.model.Item;
import com.example.shoppinglist.model.ShoppingList;
import com.example.shoppinglist.repository.ItemRepository;
import com.example.shoppinglist.repository.ShoppingListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ShoppingListRepository shoppingListRepository;



    public List<Item> findAll(){
        return  itemRepository.findAll();
    }

    public Optional<Item> findById(Long id){
        return itemRepository.findById(id);
    }

    public Item save(Item item){
        //add item to shopping cart
        Long shoppingListId = item.getShoppingListId();
        Optional<ShoppingList> opShoppingListId = shoppingListRepository.findById(shoppingListId);
        if(opShoppingListId.isEmpty()){
             throw new ShoppingListException("Not shopping cart found","SHPL-0001");
        }
        ShoppingList shoppingList = opShoppingListId.get();
        shoppingList.getItems().add(item);
        shoppingListRepository.save((shoppingList));
        return itemRepository.save(item);
    }

    public void deleteById(Long id){
        itemRepository.deleteById(id);
    }
}
