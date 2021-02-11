package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Grocery_List")
public class GroceryList {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long listId;
	
	@Column
	private String listName;
	
	@OneToMany(mappedBy = "gList", fetch=FetchType.EAGER)
	private List<GroceryItem> items;
	
	
}
