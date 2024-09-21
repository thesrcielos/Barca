package edu.eci.cvds.productAgent.model;

public class AgentWarning implements Agent{
    private String productMessage;
    @Override
    public void update(Product product) {
        int quantity = product.getQuantity();
        if(quantity < 5){
            productMessage = String.format("ALERTA!!! El stock del Prodcto: %s es muy bajo, solo quedan %d unidades.", product.getName(), quantity);
            System.out.println(productMessage);
        }
    }
}
