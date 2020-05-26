package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productServiceImp = new ProductServiceImpl();
    List<Product> listProducts;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                viewAllProduct(req,resp);
            case "delete":
                deleteProduct(req,resp);
                break;
            case "add":
                showAddProductForm(req,resp);
                break;
            case "update":
                showUpdateProductForm(req,resp);
                break;
        }
    }

    private void showUpdateProductForm(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("productId");
        Product handler = productServiceImp.getProductById(id);
        req.setAttribute("product");
        String productName = req.getParameter("productName");
        float productPrice = Float.parseFloat(req.getParameter("productPrice"));
        int productQuantity =Integer.parseInt(req.getParameter("productQuantity"));
        String productColor = req.getParameter("productColor");
        String productDescription = req.getParameter("productDescription");
        int productCategoryId = Integer.parseInt(req.getParameter("productCategoryId"));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateProductForm.jsp");
    }

    private void showAddProductForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("addProductForm.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        int productId = Integer.parseInt(req.getParameter("productId"));
        productServiceImp.deleteProductById(productId);
        listProducts = productServiceImp.getAllProduct();
        req.setAttribute("products",listProducts);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewAllProduct.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewAllProduct(HttpServletRequest req, HttpServletResponse resp) {

        listProducts = productServiceImp.getAllProduct();
        req.setAttribute("products",listProducts);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewAllProduct.jsp");
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                viewAllProduct(req,resp);
            case "add":
                addProduct(req,resp);
                break;

        }
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) {
        String productName = req.getParameter("productName");
        float productPrice = Float.parseFloat(req.getParameter("productPrice"));
        int productQuantity =Integer.parseInt(req.getParameter("productQuantity"));
        String productColor = req.getParameter("productColor");
        String productDescription = req.getParameter("productDescription");
        int productCategoryId = Integer.parseInt(req.getParameter("productCategoryId"));
        Product handler = new Product(productName,productPrice,productQuantity,productColor,productDescription,productCategoryId);
        productServiceImp.addProduct(handler);
        viewAllProduct(req,resp);
    }


}
