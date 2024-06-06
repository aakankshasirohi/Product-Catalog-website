package com.nagarro;



import java.io.FileNotFoundException;



import java.util.InputMismatchException;
import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class ProductMain {



	public static void main(String[] args) throws FileNotFoundException {



		Csv csv = new Csv();
		Thread t1 = new Thread(csv);
		t1.start();



		// taking user inputs



		Scanner sc = new Scanner(System.in);
		try {



			String color, size, gender;
			int choiceCode;



			System.out.print("Enter Color : ");
			color = sc.nextLine().toUpperCase();
			System.out.print("Enter Size : ");
			size = sc.nextLine().toUpperCase();
			System.out.print("Enter Gender : ");
			gender = sc.nextLine().toUpperCase();
			System.out.print(
					"Enter Output Preference : 1. Price \t 2. Rating \t 3. Price and Rating \nEnter Preference Choice Code : ");
			choiceCode = sc.nextInt();
			sc.close();



			// controller
			ProductController pc = new ProductController();



			pc.searchProduct(csv.productList(), color, size, gender);
			pc.updateView(choiceCode);



		} catch (InputMismatchException e) {
			System.out.println("Enter a number in Integer Format " + e);
		}



	}



}