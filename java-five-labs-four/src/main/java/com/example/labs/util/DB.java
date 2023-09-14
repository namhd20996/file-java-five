package com.example.labs.util;

import com.example.labs.dto.Account;
import com.example.labs.dto.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DB {
    public static Map<Integer, Item> items = new HashMap<>();

    static {
        items.put(1, new Item(1, "Samsung", 10.0, 0));
        items.put(2, new Item(2, "Nokia 2021", 20.50, 0));
        items.put(3, new Item(3, "iPhone 20", 90.49, 0));
        items.put(4, new Item(4, "Motorola", 15.55, 0));
        items.put(5, new Item(5, "Seamen", 8.99, 0));
    }

    public static Item findOneById(Integer id) {
        for (Item item : items.values()) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public int findAccountByUsername(List<Account> list, String username) {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUsername().equals(username)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
