package com.nagarro;



import java.util.ArrayList;



public class ProductView {
	public void viewProducts(ArrayList<ProductModel> productList) {
		System.out.println("\n \t\t ***** PRODUCT INFORMATION *****");
		System.out.println("Id|Name|Color|Gender| Size|Price|Rating|Availability");
		for (ProductModel p : productList) {
			System.out.print(" " + p.getId());
			System.out.print("\t |\t" + p.getName());
			System.out.print("\t |\t" + p.getColor());
			System.out.print("\t |\t" + p.getGender());
			System.out.print("\t |\t" + p.getSize());
			System.out.print("\t |\t" + p.getPrice());
			System.out.print("\t |\t" + p.getRating());
			System.out.print("\t |\t" + p.getAvailability());
			System.out.println("\n");
		}
		if (productList.isEmpty()) {
			System.out.println("Products Are Not Available.");
		}
	}
}