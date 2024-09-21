package edu.eci.cvds.productAgent.service;

import edu.eci.cvds.productAgent.model.Product;

import java.util.List;

public interface ProductAgentService {
    Product add(Product product);
    Product update(String name, int quantity);
    void delete(String name);
    List<Product> getAllProduct();
    void notifyAgents(Product product);

}
