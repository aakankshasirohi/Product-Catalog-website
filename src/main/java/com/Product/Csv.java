package com.nagarro;



import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;



// this class is used to fetch the data from the csv file
public class Csv implements Runnable {



	private static final String pm = null;
	List<ProductModel> list = new ArrayList<ProductModel>();
	List<ProductModel> productList;
	ProductDao pd = new ProductDao();



	/* Method for fetching data from csv files and storing into a list */
	public List<ProductModel> getArray(SessionFactory factory) {



		CSVParser csvParser = new CSVParserBuilder().withSeparator('|').build();



		File dir = new File("src\\main\\resources\\Assigment Links");
		File[] file = dir.listFiles();
		for (File f : file) {
			System.out.println(f.getName());



			try {
				CSVReader csvReader = new CSVReaderBuilder(new FileReader(f.getAbsolutePath())).withCSVParser(csvParser)
						.withSkipLines(1).build();



				String[] record = null;
				while ((record = csvReader.readNext()) != null) {
					ProductModel pm = new ProductModel(record[0], record[1], record[2], record[3], record[4],
							Float.parseFloat(record[5]), Float.parseFloat(record[6]), record[7]);
					// list.add(pm);
					pd.insertData(pm, factory);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list; // return data in a list
	}



	public void run() {



		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();



		getArray(factory);
		productList = pd.getData(factory);



	}



	public List<ProductModel> productList() {
		return productList;



	}



}