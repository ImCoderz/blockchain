package hh.ma.ac.inpt.server;

import java.util.logging.Logger;

import hh.ma.ac.inpt.service.ProductsManagerImpl;
import jakarta.xml.ws.Endpoint;

public class ServicePublisher {
	
	private static final Logger LOGGER = Logger.getLogger(ServicePublisher.class.getName());

	public static void main(String[] args) {
		LOGGER.info("starting server ....");
		Endpoint.publish("http://localhost:2020/webservices/ProductManager", new ProductsManagerImpl());
		LOGGER.info("Server started");
		}
	}