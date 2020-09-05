package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String eveName,eveType,city;
	private int price,tickets;
	public Event() {
		
	}
	public Event(String eveName, String eveType, String city, int price, int tickets) {
		super();
//		this.id=id;
		this.eveName = eveName;
		this.eveType = eveType;
		this.city = city;
		this.price = price;
		this.tickets = tickets;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", eveName=" + eveName + ", eveType=" + eveType + ", city=" + city + ", price="
				+ price + ", tickets=" + tickets + "]";
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public String getEveName() {
		return eveName;
	}
	public void setEveName(String eveName) {
		this.eveName = eveName;
	}
	public String getEveType() {
		return eveType;
	}
	public void setEveType(String eveType) {
		this.eveType = eveType;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

}
