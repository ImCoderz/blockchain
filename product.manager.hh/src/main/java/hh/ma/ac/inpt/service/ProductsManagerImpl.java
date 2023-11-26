package hh.ma.ac.inpt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hh.ma.ac.inpt.domaine.Product;
import hh.ma.ac.inpt.domaine.ProductsWrapper;
import hh.ma.ac.inpt.exceptions.NoSuchProductException;
import jakarta.jws.WebService;

@WebService(endpointInterface = "hh.ma.ac.inpt.service.ProductManager")
public class ProductsManagerImpl implements ProductManager {

    private static long nextProductId = 0;
    private static List<Product> products = new ArrayList<Product>();

    @Override
    public long addProduct(Product product) {
        // Generate a new ID for the product
       
        nextProductId++;
        product.setId(nextProductId);
        products.add(product);

        return product.getId();
    }

    @Override
    public Product getProduct(long id) throws NoSuchProductException {
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        throw new NoSuchProductException("No Such Product");
    }

    @Override
    public double getProductPrice(long id) throws NoSuchProductException {
        Product product = getProduct(id);
        return product.getPrice();
    }

    @Override
    public ProductsWrapper getAllProducts() {
        ProductsWrapper wrapper = new ProductsWrapper();
        wrapper.setProducts(products);
        return wrapper;
    }

    @Override
    public Product updateProduct(long id, Product productUpdates) throws NoSuchProductException {
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (id == product.getId()) {
                // Update the product with the new information
                productUpdates.setId(id);
                products.set(i, productUpdates);
                return productUpdates;
            }
        }
        throw new NoSuchProductException("No Such Product");
    }

    @Override
    public boolean deleteProduct(long id) throws NoSuchProductException {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (id == product.getId()) {
                iterator.remove();
                return true;
            }
        }
        throw new NoSuchProductException("No Such Product");
    }

    @Override
    public boolean deleteAllProducts() {
        products.clear();
        return true;
    }
}
