package com.cucumber.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    private String name;

    public Product(String name) {
        this.name = name;
    }
}
