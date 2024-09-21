package edu.eci.cvds.productAgent.service;

import edu.eci.cvds.productAgent.model.Product;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    private Map<String, Product> products;


    @Override
    public Product add(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void notifyAgents(Product product) {

    }
}
