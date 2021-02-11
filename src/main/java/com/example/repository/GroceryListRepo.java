package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.GroceryItem;
import com.example.model.GroceryList;

@Repository
public interface GroceryListRepo extends JpaRepository<GroceryList, Long>{
	public Optional<GroceryList> findByListName(String listName);
}
