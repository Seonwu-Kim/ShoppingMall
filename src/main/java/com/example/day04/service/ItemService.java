package com.example.day04.service;

import com.example.day04.domain.Item;
import com.example.day04.domain.ItemRepository;
import com.example.day04.domain.ItemRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

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
