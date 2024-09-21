package edu.eci.cvds.productAgent.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class AgentLog implements Agent{
    private List<String> agentMessages = new ArrayList<>();

    @Override
    public void update(Product product) {
        String productMessage = String.format("Producto: %s -> %d unidades disponibles.", product.getName(), product.getQuantity());
        agentMessages.add(productMessage);
        System.out.println(productMessage);
    }
}
