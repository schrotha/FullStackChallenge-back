package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.GroceryItem;

@Repository
public interface GroceryItemRepo extends JpaRepository<GroceryItem, Long>{
	public Optional<GroceryItem> findByName(String itemName);

}
