package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.GroceryItemDto;
import com.example.dto.GroceryListDto;
import com.example.model.GroceryList;
import com.example.service.GroceryListServ;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/list")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class GroceryListController {
	
	private GroceryListServ gListServ;
	
	@CrossOrigin(origins ="http://localhost:4200")
	@GetMapping("/grocery-lists")
	public ResponseEntity<List<GroceryList>> getLists(){
		return new ResponseEntity<>(gListServ.getAllLists(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins ="http://localhost:4200")
	@PostMapping("/grocery-lists")
	public ResponseEntity<String> addList(@RequestBody GroceryListDto gListDto){
		gListServ.addList(gListDto);
		return new ResponseEntity<>("Grocery List Successfully Added", HttpStatus.OK);
	}
	
	@CrossOrigin(origins ="http://localhost:4200")
	@PostMapping("/grocery-lists/items")
	public ResponseEntity<String> addItemToList(@RequestBody GroceryItemDto gItemDto){
		gListServ.addItemToList(gItemDto);
		return new ResponseEntity<>("Item Successfully Added To List", HttpStatus.OK);
	}
	
	@CrossOrigin(origins ="http://localhost:4200")
	@DeleteMapping("/grocery-lists/items/{itemId}")
	public ResponseEntity<String> deleteItem(@PathVariable Long itemId){
		gListServ.removeItem(itemId);
		return new ResponseEntity<>("Item Successfully Deleted", HttpStatus.OK);
	}
	
	@CrossOrigin(origins ="http://localhost:4200/")
	@DeleteMapping("/grocery-lists")
	public ResponseEntity<String> deleteList(@RequestBody GroceryListDto gListDto){
		gListServ.removeList(gListDto);
		return new ResponseEntity<>("List Successfully Deleted", HttpStatus.OK);
	}
	
}
