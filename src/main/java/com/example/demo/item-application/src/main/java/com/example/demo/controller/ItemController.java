package com.example.demo.controller;

import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }
    @GetMapping("/list")
    public String listAllItem(Model model)
    {
        List<Item> list=itemService.listItems();
        model.addAttribute("item",list);
        return "list-item";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
// create model attribute to bind form data
       Item theItem = new Item();
        theModel.addAttribute("item", theItem);
        return "item-form";
    }
    @PostMapping("/save")
    public String saveItem(
            @ModelAttribute("item") @Valid Item theItem,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "item-form";
        }
        else {
            // save the employee
            itemService.createItem(theItem);

            // use a redirect to prevent duplicate submissions
            return "redirect:/Item/list";
        }
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("itemId") int theId,
                                    Model theModel) {
// get the employee from the service
        Item theItem = itemService.getById(theId);
// set employee as a model attribute to pre-populate the form
        theModel.addAttribute("item", theItem);
// send over to our form
        return "item-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("itemId") int theId) {

        // delete the employee
        itemService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/item/list";

    }
}
