package edu.eci.cvds.productAgent.service;

import edu.eci.cvds.productAgent.model.Agent;
import edu.eci.cvds.productAgent.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductAgentServiceImpl implements ProductAgentService {
    private Map<String, Product> products;
    private final Agent agentLog;
    private final Agent agentWarning;

    public ProductAgentServiceImpl(@Qualifier("agentLog") Agent agentLog, @Qualifier("agentWarning") Agent agentWarning) {
        products = new HashMap<>();
        this.agentLog = agentLog;
        this.agentWarning = agentWarning;
    }


    @Override
    public Product add(Product product) {
        String name = product.getName();
        if(products.containsKey(name)){
            return  null;
        }
        products.put(name,product);
        return product;
    }

    @Override
    public Product update(String name, int quantity) {
        if(!products.containsKey(name)) {
            return null;
        }
        Product product = products.get(name);
        product.setQuantity(quantity);
        notifyAgents(product);
        return product;
    }

    @Override
    public void delete(String name) {
        products.remove(name);
    }

    @Override
    public List<Product> getAllProduct() {
        return products.values().stream().toList();
    }

    @Override
    public void notifyAgents(Product product) {
        agentLog.update(product);
        agentWarning.update(product);
    }

}
