package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Book extends Product {
    private String author;

    public Book(int ID, String name, int price, String author){
        super(ID, name, price);
        this.author = author;
    }
}
