package com.example.labs.service.impl;

import com.example.labs.dto.Item;
import com.example.labs.service.IShoppingCartService;
import com.example.labs.util.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements IShoppingCartService {
    @Autowired
    private DB db;

    Map<Integer, Item> map = new HashMap<>();

    @Override
    public Item add(Integer id) {
        Item item = db.findOneById(id);
        if (map.containsKey(id)) {
            item.setQuantity(item.getQuantity() + 1);
        } else {
            item.setQuantity(1);
            map.put(id, item);
        }
        return item;
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public Item update(Integer id, Integer qty) {
        Item item = db.findOneById(id);
        item.setQuantity(qty);
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.values().size();
    }

    @Override
    public Double getAmount() {
        return map.values().stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
    }
}
