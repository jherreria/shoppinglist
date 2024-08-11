package com.example.shoppinglist.model;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Nonnull
    private String name;

    @Builder.Default()
    private Boolean purchased = Boolean.FALSE;

//    @ManyToOne
//    private ShoppingList shoppingList;

    private Long ShoppingListId;
}
