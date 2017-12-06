package com.san.poll.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.hibernate.Session;

import com.san.poll.beans.Product;
import com.san.poll.persistence.HibernatePersistence;

public class ProductServiceImpl implements ProductService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductServiceImpl() {
		super();
	}

	public Product getProduct(Integer productId) {

		Session session = HibernatePersistence.getSessionFactory().openSession();

		session.beginTransaction();
		Product product = null;

		// get data from database
		product = (Product) session.get(Product.class, productId);
		System.out.println(product);

		// close session
		HibernatePersistence.shutdown();

		return product;
	}

}
