package com.example.day04.controller;

import com.example.day04.domain.Item;
import com.example.day04.domain.ItemRequestDto;
import com.example.day04.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("postItem")
    public String postItem(){
        return "postItem";
    }

    @PostMapping("/api/item")
    public String saveItem(@ModelAttribute ItemRequestDto itemRequestDto){
        itemService.createItem(itemRequestDto);
        return "redirect:/api/itemList";
    }

    @GetMapping("/api/itemList")
    public String listItem(Model model){
        List<Item> itemList = itemService.allItem();
        model.addAttribute("items",itemList);
        return "itemList";
    }

    @GetMapping("/api/itemOne/{id}")
    public String itemOne(Model model,@PathVariable Long id){
        Item item = itemService.oneItem(id);
        model.addAttribute("item",item);
        return "itemOne";
    }
}
