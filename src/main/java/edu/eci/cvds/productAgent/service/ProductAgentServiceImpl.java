package edu.eci.cvds.productAgent.service;

import edu.eci.cvds.productAgent.model.Agent;
import edu.eci.cvds.productAgent.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
/**
 * This class implements the necessary methods to make a service por the products
 */
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
        if(!productOk(product)) return null;
        String name = product.getName();
        if(products.containsKey(name)){
            return  null;
        }
        products.put(name,product);
        return product;
    }

    @Override
    public Product update(String name, int quantity) {
        if(quantity < 0) return null;
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

    private boolean productOk(Product product){

        if (product == null) return false;

        String name = product.getName();
        BigDecimal price = product.getPrice();
        int quantity = product.getQuantity();
        String category = product.getCategory();

        if (!validateString(name) || !validateString(category)) {
            return false;
        }

        if (quantity < 0) return false;

        if (price.intValue() < 0) return false;

        return true;
    }

    private boolean validateString(String param){
        return param != null && !param.isEmpty();
    }
}
