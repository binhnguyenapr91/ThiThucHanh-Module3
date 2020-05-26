package service;

import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{
    public static final String GET_PRODUCT_BY_NAME = "select * from products where productName = ?";
    public final String GET_ALL_PRODUCT = "select productId, productName, productPrice, productQuantity,productColor,productDescription,categories.categoryName, categories.categoryId from products join categories on products.productCategoryId = categories.categoryId;";
    public final String DEL_PRODUCT_BY_ID = "delete from products where productId = ?;";
    public final String UPDATE_PRODUCT_BY_ID = "update products set productName = ?,productPrice = ?,productQuantity = ?,productColor=?,productDescription=? ,productCategoryId = ? where productId = ?;";
    public final String ADD_PRODUCT = "insert into products (productName,productPrice,productQuantity,productColor,productDescription,productCategoryId) values (?,?,?,?,?,?)";
    @Override
    public List<Product> getAllProduct() {
        List<Product> results = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ALL_PRODUCT);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int productId = rs.getInt("productId");
                String productName = rs.getString("productName");
                float productPrice = rs.getFloat("productPrice");
                int productQuantity = rs.getInt("productQuantity");
                String productColor = rs.getString("productColor");
                String productDescription = rs.getString("productDescription");
                int productCategoryId = Integer.parseInt(rs.getString("categoryId"));
                results.add(new Product(productId,productName,productPrice,productQuantity,productColor,productDescription,productCategoryId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return results;
    }
    @Override
    public void updateProductById(int id, Product product) {
    Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT_BY_ID);
            ps.setInt(7,product.getProductId());
            ps.setString(1,product.getProductName());
            ps.setFloat(2,product.getProductPrice());
            ps.setInt(3,product.getProductQuantity());
            ps.setString(4,product.getProductColor());
            ps.setString(5,product.getProductDescription());
            ps.setInt(6,product.getProductCategoryId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteProductById(int id) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(DEL_PRODUCT_BY_ID);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addProduct(Product product) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_PRODUCT);
            ps.setString(1,product.getProductName());
            ps.setFloat(2,product.getProductPrice());
            ps.setInt(3,product.getProductQuantity());
            ps.setString(4,product.getProductColor());
            ps.setString(5,product.getProductDescription());
            ps.setInt(6,product.getProductCategoryId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int id) {
         Connection conn = DBConnection.getConnection();
         Product product = null;
         try {
            PreparedStatement ps = conn.prepareStatement("select * from products where productId = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
                 while (rs.next()){
                       int productId = rs.getInt("productId");
                       String productName = rs.getString("productName");
                       float productPrice = rs.getFloat("productPrice");
                       int productQuantity = rs.getInt("productQuantity");
                       String productColor = rs.getString("productColor");
                       String productDescription = rs.getString("productDescription");
                       int productCategoryId = rs.getInt("productCategoryId");
                       product = new Product(productId,productName,productPrice,productQuantity,productColor,productDescription,productCategoryId);
                 }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    public List<Product> getProductByName(String in_productName) {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(GET_PRODUCT_BY_NAME);
            ps.setString(1,in_productName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                 int productId = rs.getInt("productId");
                 String productName = rs.getString("productName");
                 float productPrice = rs.getFloat("productPrice");
                 int productQuantity = rs.getInt("productQuantity");
                 String productColor = rs.getString("productColor");
                 String productDescription = rs.getString("productDescription");
                 int productCategoryId = rs.getInt("productCategoryId");
                 products.add(new Product(productId,productName,productPrice,productQuantity,productColor,productDescription,productCategoryId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}
