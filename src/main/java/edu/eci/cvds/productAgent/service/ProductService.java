package edu.eci.cvds.productAgent.service;

import edu.eci.cvds.productAgent.model.Product;

public interface ProductService {
    Product add(Product product);
    Product update(Product product);
    void notifyAgents(Product product);
}
