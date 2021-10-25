package com.example.demo.service;

import com.example.demo.dao.ItemDao;
import com.example.demo.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService
{
    private ItemDao itemDao;
    @Autowired
    public ItemServiceImpl(ItemDao itemDao)
    {
        this.itemDao=itemDao;
    }

    @Override
    public List<Item> listItems() {
        List<Item> itemList=itemDao.findAll();
        return itemList;
    }

    @Override
    public Item createItem(Item item) {
        return itemDao.save(item);
    }

    @Override
    public Item getById(Integer id) {
        return itemDao.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
        itemDao.deleteById(id);
    }


}