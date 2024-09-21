package edu.eci.cvds.productAgent.model;

public class AgentLog implements Agent{
    private String productMessage;


    @Override
    public void update(Product product) {
        productMessage = String.format("Producto: %s -> %d unidades disponibles.", product.getName(), product.getQuantity());
        System.out.println(productMessage);
    }
}
