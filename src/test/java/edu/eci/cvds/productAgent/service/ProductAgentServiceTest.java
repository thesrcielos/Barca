package edu.eci.cvds.productAgent.service;

import edu.eci.cvds.productAgent.model.Agent;
import edu.eci.cvds.productAgent.model.AgentLog;
import edu.eci.cvds.productAgent.model.AgentWarning;
import static org.junit.jupiter.api.Assertions.*;

import edu.eci.cvds.productAgent.model.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ProductAgentServiceTest {

    @Test
    public void addProductTest(){
        ProductAgentService service = createService();
        Product product = new Product("ps5", BigDecimal.valueOf(10),10,"electronic");
        assertEquals(product,service.add(product));
    }

    @Test
    public void updateProductTest(){
        ProductAgentService service = createService();
        Product product = addProductToService(service);
        int quantity = 4;
        assertEquals(product, service.update(product.getName(),quantity));
    }

    @Test
    public void shouldntAddAProuductIfAlreadyExists(){
        ProductAgentService service = createService();
        Product product = addProductToService(service);
        assertNull(service.add(product));
    }

    @Test
    public void shouldntUpdateAProductIfNotExists(){
        ProductAgentService service = createService();
        assertNull(service.update("example-name",10));
    }

    @Test
    public void shouldntCreateAProductWithoutAName(){
        ProductAgentService service = createService();
        Product product = new Product(null, BigDecimal.valueOf(10),10,"electronic");
        assertNull(service.add(product));
    }

    @Test
    public void shouldntCreateAProductWithANegativeQuantity(){
        ProductAgentService service = createService();
        Product product = new Product("product", BigDecimal.valueOf(10),-10,"electronic");
        assertNull(service.add(product));
    }

    @Test
    public void deleteProductTest(){
        ProductAgentService service = createService();
        Product product = addProductToService(service);
        service.delete(product.getName());
        assertTrue(service.getAllProduct().isEmpty());
    }

    @Test
    public void shouldntCreateAProductWithoutACategory(){
        ProductAgentService service = createService();
        Product product = new Product("product", BigDecimal.valueOf(10),10,null);
        assertNull(service.add(product));
    }
    private ProductAgentService createService(){
        Agent agentLog = new AgentLog();
        Agent agentWarning = new AgentWarning();
        return new ProductAgentServiceImpl(agentLog,agentWarning);
    }

    private Product addProductToService(ProductAgentService productAgentService){
        Product product = new Product("ps5", BigDecimal.valueOf(10),10,"electronic");
        productAgentService.add(product);
        return product;
    }
}
