package hh.ma.ac.inpt.service;

import hh.ma.ac.inpt.domaine.Product;
import hh.ma.ac.inpt.domaine.ProductsWrapper;
import hh.ma.ac.inpt.exceptions.NoSuchProductException;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)

public interface ProductManager {
	
	@WebResult(name = "productId")
	public long addProduct(@WebParam(name = "productId") Product product ) throws NoSuchProductException;

	@WebResult(name = "product")
	public Product getProduct(@WebParam(name = "productId") long id ) throws NoSuchProductException;
	
	@WebResult(name = "price")
	public double getProductPrice(@WebParam(name = "productId") long id ) throws NoSuchProductException;
	
	@WebResult(name = "products")
	public ProductsWrapper getAllProducts();
	
	@WebResult(name = "product")
	public Product updateProduct(@WebParam(name = "productId") long id ,
		 @WebParam(name = "productUpdates") Product productUpdates ) throws NoSuchProductException;
	
	public boolean deleteProduct(@WebParam(name = "ProductId") long id) throws NoSuchProductException;

	public boolean deleteAllProducts();
}
