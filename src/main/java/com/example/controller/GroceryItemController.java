package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.GroceryItemServ;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping(value="/item")
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class GroceryItemController {
	public GroceryItemServ gItemServ;
}
