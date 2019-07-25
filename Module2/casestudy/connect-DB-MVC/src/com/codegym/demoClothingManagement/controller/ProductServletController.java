package com.codegym.demoClothingManagement.controller;

import com.codegym.demoClothingManagement.model.Producer;
import com.codegym.demoClothingManagement.model.Product;
import com.codegym.demoClothingManagement.service.IProducerDAO;
import com.codegym.demoClothingManagement.service.IProductDAO;
import com.codegym.demoClothingManagement.service.ProducerDAOImlp;
import com.codegym.demoClothingManagement.service.ProductDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "ProductServletController", urlPatterns = "/products")
public class ProductServletController extends HttpServlet {

    private IProductDAO productDAO = new ProductDAOImpl();
    private IProducerDAO producerDAO = new ProducerDAOImlp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
            Product deleteProduct = this.productDAO.getProductById(id);
        this.productDAO.deleteProduct(deleteProduct);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String sellPrice = request.getParameter("sellPrice");
        String cost = request.getParameter("cost");
        int type = Integer.parseInt(request.getParameter("idType"));
        int species = Integer.parseInt(request.getParameter("idSpecies"));
        int producer = Integer.parseInt(request.getParameter("idProducer"));

        Product product = this.productDAO.getProductById(id);
        RequestDispatcher requestDispatcher;
        product.setProductName(productName);
        product.setDescription(description);
        product.setAmount(amount);
        product.setSellPrice(sellPrice);
        product.setCost(cost);
        product.setIdType(type);
        product.setIdSpecies(species);
        product.setIdProducer(producer);
        this.productDAO.updateProduct(id, product);
        request.setAttribute("products", product);
        request.setAttribute("message", "Product information was updated");
        requestDispatcher = request.getRequestDispatcher("product/edit.jsp");

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String sellPrice = request.getParameter("sellPrice");
        String cost = request.getParameter("cost");
        int type = Integer.parseInt(request.getParameter("idType"));
        int species = Integer.parseInt(request.getParameter("idSpecies"));
        int producer = Integer.parseInt(request.getParameter("idProducer"));

        Product product = new Product(0, productName, description, amount, sellPrice, cost, type,
                species, producer);
        this.productDAO.createProduct(product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "New product was created");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewProducts(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void viewProducts(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productDAO.getProductById(id);
        request.setAttribute("products", product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/view.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product deleteProduct = this.productDAO.getProductById(id);
        RequestDispatcher requestDispatcher;
        request.setAttribute("products", deleteProduct);
        requestDispatcher = request.getRequestDispatcher("product/delete.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = this.productDAO.getProductById(id);
        Producer respectiveProducer = this.producerDAO.getProducerById(id);
        request.setAttribute("products", existingProduct);
        request.setAttribute("producers", respectiveProducer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productDAO.getAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
