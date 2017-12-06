package com.san.poll;

import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.log4j.Logger;
import com.san.poll.beans.Product;
import com.san.poll.service.ProductServiceImpl;

public class JavaPollMain {

	final static Logger logger = Logger.getLogger(JavaPollMain.class);
	public static ProductServiceImpl productService = new ProductServiceImpl();

	public static void main(String args[]) {// throws {

		try {
			startSyncProcess();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(" " + e.getMessage());
		}
		logger.info("sync process ends..");
	}

	private static void startSyncProcess() throws SQLException {

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Worker worker = null;
		Product product = null;
		while (true) {
// do some here
			worker = new Worker(product);
			executor.submit(worker);

			try {
				Thread.sleep(3000L);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("An error occured in Sync." + e.getMessage());
			}

			System.out.println("startSyncProcess() : Finished all threads");
		} // end While loop
	}

}
