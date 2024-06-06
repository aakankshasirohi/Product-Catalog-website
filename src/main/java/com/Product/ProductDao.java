package com.nagarro;



import org.hibernate.query.Query;



import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



public class ProductDao {



	public void insertData(ProductModel pm, SessionFactory factory) {



		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(pm);
		tx.commit();
		session.close();



	}



	public List<ProductModel> getData(SessionFactory factory) {
		String hql = "From ProductModel";
		Session session = factory.openSession();
		Query query = session.createQuery(hql);
		List<ProductModel> productList = query.list();
		return productList;



	}



}