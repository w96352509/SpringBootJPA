package com.example.demo.entity.one2many.twoway;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// 1(Group) <-> 多(Item)
@Entity
@Table(name="meun_group")
public class MenuGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	// 雙向 : 1對多
	// 單方必須使用 mappedBy 來放棄維護關聯 , 如此不用 @joinColumn
	@OneToMany(mappedBy = "menuGroup", cascade = CascadeType.PERSIST , fetch = FetchType.EAGER)
	private Set<MenuItem> items = new LinkedHashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<MenuItem> getItems() {
		return items;
	}

	public void setItems(Set<MenuItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "MenuGroup [id=" + id + ", name=" + name + ", items=" + items + "]";
	} 
	
}
