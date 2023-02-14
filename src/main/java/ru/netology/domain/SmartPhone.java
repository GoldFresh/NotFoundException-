package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SmartPhone extends Product {
    private String producer;

    public SmartPhone(int ID, String name, int price, String producer){
        super(ID, name, price);
        this.producer = producer;
    }
}
