package com.example.day73.controller;


import com.example.day73.domain.*;
import com.example.day73.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final MemberRepository memberRepository;

    @GetMapping("/admin/postItem")
    public String postItem(){
        return "postItem";
    }

    @PostMapping("/admin/item")
    public String saveItem(@ModelAttribute ItemRequestDto itemRequestDto){
        itemService.createItem(itemRequestDto);
        return "redirect:/api/itemList/0";
    }
    @GetMapping("/api/itemList/{page}")
    public String listItem(Model model,@PathVariable int page){
        Page<Item> itemList = itemService.allItem(page);
        model.addAttribute("items",itemList);
        page+=1;
        int totalPage = itemList.getTotalPages();
        int startPage = Math.max(page-4,1);
        int endPage = Math.min(page+4,totalPage);
        //아무 상품도 없으면 0페이지만 나오도록 설정
        if(totalPage==0) endPage=0;
        model.addAttribute("nowPage",page);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("pageType","all");
        return "index";
    }
    @GetMapping("/api/searchList/{page}")
    public String searchList(Model model,@RequestParam("itemName") String itemName, @PathVariable int page){
        Page<Item> itemList = itemService.searchItem(itemName,page);
        model.addAttribute("items",itemList);
        page+=1;
        int totalPage = itemList.getTotalPages();
        int startPage = Math.max(page-4,1);
        int endPage = Math.min(page+4,totalPage);
        //아무 상품도 없으면 0페이지만 나오도록 설정
        if(totalPage==0) endPage=0;
        model.addAttribute("nowPage",page);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("pageType","search");
        model.addAttribute("itemName",itemName);
        return "index";
    }

    @GetMapping("/api/itemList/{category}/{page}")
    public String categoryList(Model model,@PathVariable String category, @PathVariable int page){
        Page<Item> itemList = itemService.categoryItem(category,page);
        model.addAttribute("items",itemList);
        page+=1;
        int totalPage = itemList.getTotalPages();
        int startPage = Math.max(page-4,1);
        int endPage = Math.min(page+4,totalPage);
//        model.addAttribute("totalPage",totalPage);
        model.addAttribute("nowPage",page);
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("category",category);
        return "categoryList";
    }

    @GetMapping("/api/itemOne/{id}")
    public String itemOne(Model model, @PathVariable Long id, @AuthenticationPrincipal Member member){

        Item item = itemService.oneItem(id);
        model.addAttribute("item",item);
        model.addAttribute("member",member);
        return "itemOne";
    }
}
