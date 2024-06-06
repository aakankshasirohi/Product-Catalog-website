package com.nagarro;



import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class ProductController {



	ArrayList<ProductModel> arr = new ArrayList<ProductModel>();
	ProductView view = new ProductView();



	public void searchProduct(List<ProductModel> productList, String color, String size, String gender) {
		for (ProductModel p : productList) {
			if (p.getColor().equalsIgnoreCase(color) && p.getSize().equalsIgnoreCase(size)
					&& p.getGender().equalsIgnoreCase(gender)) {
				arr.add(p);
			}
		}



	}



	public void updateView(int choiceCode) {



		if (choiceCode == 1) {



			List<ProductModel> productList = arr;
			Collections.sort(productList, new Comparator<ProductModel>() {
				public int compare(ProductModel o1, ProductModel o2) {
					return (int) (o1.getPrice() - o2.getPrice());
				}
			});
		}



		else if (choiceCode == 2) {
			List<ProductModel> productList = arr;
			Collections.sort(productList, new Comparator<ProductModel>() {
				public int compare(ProductModel o1, ProductModel o2) {
					return (int) (o1.getRating() - o2.getRating());
				}
			});



		}



		else if (choiceCode == 3) {
			List<ProductModel> productList = arr;
			Collections.sort(productList, new Comparator<ProductModel>() {
				public int compare(ProductModel o1, ProductModel o2) {
					double flag = (double) (o1.getPrice() - o2.getPrice());
					if (flag == 0)
						flag = Float.compare(o1.getRating(),o2.getRating());



					return (int) flag;
				}
			});
		}



		else {
			System.out.println("Wrong Choice");
			return;
		}



		view.viewProducts(arr);



	}



}