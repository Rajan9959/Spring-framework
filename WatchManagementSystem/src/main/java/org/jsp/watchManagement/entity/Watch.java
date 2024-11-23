package org.jsp.watchManagement.entity;

import java.io.Serializable;

public class Watch implements Serializable
{
	// PROPERTIES
	private String brand;
	private String type;
	private double price;
	private String color;
	private String model;
	
	// No-Argument Constructor
	public Watch() 
	{
		
	}
	
	// Getter and Setter
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
	
	@Override
	public String toString() {
		return "Watch [brand=" + brand + ", type=" + type + ", price=" + price + ", color=" + color + ", model=" + model
				+ "]";
	}
	
	
	
}
