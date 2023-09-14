package com.example.labs.service;

import com.example.labs.dto.Item;

import java.util.Collection;

public interface IShoppingCartService {

    Item add(Integer id);

    void remove(Integer id);

    Item update(Integer id, Integer qty);

    void clear();

    Collection<Item> getItems();

    int getCount();

    Double getAmount();
}
