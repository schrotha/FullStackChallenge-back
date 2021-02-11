package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dto.GroceryItemDto;
import com.example.dto.GroceryListDto;
import com.example.model.GroceryItem;
import com.example.model.GroceryList;
import com.example.repository.GroceryItemRepo;
import com.example.repository.GroceryListRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class GroceryListServ {

	private GroceryListRepo gListRepo;
	private GroceryItemRepo gItemRepo;
	
	public List<GroceryList> getAllLists(){
		return gListRepo.findAll();
	}
	
	public void addList(GroceryListDto gListDto) {
		GroceryList newList = new GroceryList();
		newList.setListName(gListDto.getName());
		gListRepo.save(newList);
	}
	
	public void addItemToList(GroceryItemDto gItemDto) {
		GroceryItem newItem = new GroceryItem();
		newItem.setName(gItemDto.getName());
		newItem.setPrice(gItemDto.getPrice());
		newItem.setType(gItemDto.getType());
		
		GroceryList gList = gListRepo.findById(gItemDto.getListId()).orElse(null);
		newItem.setGList(gList);
		
		List<GroceryItem> itemList = gList.getItems();
		itemList.add(newItem);
		gList.setItems(itemList);
		
		gItemRepo.save(newItem);
		gListRepo.save(gList);
		
	}
	
	public void removeItem(Long itemId) {
		GroceryItem gItem = gItemRepo.findById(itemId).orElse(null);
		GroceryList gList = gItem.getGList();
		List<GroceryItem> itemList = gList.getItems();
		itemList.remove(gItem);
		gList.setItems(itemList);
		gListRepo.save(gList);
		gItemRepo.deleteById(itemId);
	}
	
	public void removeList(GroceryListDto gListDto) {
		GroceryList gList = gListRepo.findByListName(gListDto.getName()).orElse(null);
		List<GroceryItem> itemList = gList.getItems();
		gList.setItems(null);
		gListRepo.save(gList);
		for(GroceryItem item:itemList) {
			gItemRepo.delete(item);
		}
		gListRepo.delete(gList);
	}
	
}
