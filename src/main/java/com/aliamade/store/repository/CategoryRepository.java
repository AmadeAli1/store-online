package com.aliamade.store.repository;

import com.aliamade.store.model.Category;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveSortingRepository<Category, Integer> {

}
