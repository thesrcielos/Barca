package edu.eci.cvds.productAgent.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class AgentWarning implements Agent{
    private List<String> agentMessages = new ArrayList<>();
    @Override
    public void update(Product product) {
        int quantity = product.getQuantity();
        if(quantity < 5){
            String productMessage = String.format("ALERTA!!! El stock del Producto: %s es muy bajo, solo quedan %d unidades.", product.getName(), quantity);
            agentMessages.add(productMessage);
            System.out.println(productMessage);
        }
    }
}
