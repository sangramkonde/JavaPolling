package com.san.poll;

import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.san.poll.beans.Product;

public class Worker implements Callable<Map<Integer, String>> {

	final static Logger logger = Logger.getLogger(Worker.class);
	public Product product;

	public Worker(Product product) {
		this.product = product;
	}

	public Map<Integer, String> call() throws Exception {

		try {
			
			logger.info("Processin for product :: ");
// do some here
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("call() : An error occurred in Copper to Ema sync." + e.getMessage());
		} finally {
		}
		return null;
	}
}
