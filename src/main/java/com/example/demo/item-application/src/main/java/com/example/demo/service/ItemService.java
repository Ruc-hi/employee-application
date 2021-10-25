package com.example.demo.service;

import com.example.demo.entity.Item;

import java.util.List;

public interface ItemService {

    public List<Item> listItems();
    public Item createItem(Item Item);

    public Item getById(Integer id);

    public void deleteById(Integer id);


}
