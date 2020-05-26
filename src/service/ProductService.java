package service;

import model.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();
    public void updateProductById(int id, Product product);
    public void deleteProductById(int id);
    public void addProduct(Product product);

}
