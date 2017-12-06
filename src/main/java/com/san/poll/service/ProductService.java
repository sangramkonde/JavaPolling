package com.san.poll.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.san.poll.beans.Product;

public interface ProductService extends Remote {

	// Method to retrieve weather information.
	public Product getProduct(Integer productId);
}
