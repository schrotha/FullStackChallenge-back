package com.example.service;

import org.springframework.stereotype.Service;

import com.example.repository.GroceryItemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
public class GroceryItemServ {

	private GroceryItemRepo gItemRepo;
	
}
