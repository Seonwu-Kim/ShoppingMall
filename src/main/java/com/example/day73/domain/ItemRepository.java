package com.example.day73.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
    Page<Item> findByCategory(String category, PageRequest pageRequest);
    // Containing은 해당 문자열을 포함한다
    // IgnoreCase는 대,소문자를 구분하지 않는다.
    Page<Item> findByTitleContainingIgnoreCaseOrDescContainingIgnoreCaseOrShortDescContainingIgnoreCase(String title,String desc,String shortDesc,PageRequest pageRequest);
}
