package com.aliamade.store.repository;

import com.aliamade.store.model.Item;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends ReactiveSortingRepository<Item, Integer> {
}
