package com.example.day73.service;


import com.example.day73.domain.Item;
import com.example.day73.domain.ItemRepository;
import com.example.day73.domain.ItemRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void createItem(ItemRequestDto itemRequestDto){
        Item item = new Item(itemRequestDto);
        itemRepository.save(item);
    }
    public Item oneItem(Long id){
        return itemRepository.findById(id).orElseThrow(() -> new NullPointerException("찾으시는 아이디가 없습니다."));
    }

    public Page<Item> allItem(int page){
        PageRequest pageRequest = PageRequest.of(page,8);
        return itemRepository.findAll(pageRequest);
    }

    public Page<Item> searchItem(String itemName, int page){
        PageRequest pageRequest = PageRequest.of(page,8);
        return itemRepository.findByTitleContainingIgnoreCaseOrDescContainingIgnoreCaseOrShortDescContainingIgnoreCase(itemName,itemName,itemName,pageRequest);
    }

    public Page<Item> categoryItem(String category,int page){
        PageRequest pageRequest = PageRequest.of(page,8);
        return itemRepository.findByCategory(category,pageRequest);
    }
    @Transactional
    public Long updateItem(ItemRequestDto itemRequestDto, Long id){
        Item item = itemRepository.findById(id).orElseThrow(() -> new NullPointerException("찾으시는 아이디가 없습니다."));
        item.update(itemRequestDto);
        return item.getId();
    }
    public Long deleteItem(Long id){
        itemRepository.deleteById(id);
        return id;
    }

}
