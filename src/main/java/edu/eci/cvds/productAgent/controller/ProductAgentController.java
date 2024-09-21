package edu.eci.cvds.productAgent.controller;

import edu.eci.cvds.productAgent.model.Product;
import edu.eci.cvds.productAgent.service.ProductAgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductAgentController {
    private final ProductAgentService service;

    @GetMapping()
    public List<Product> getAllProducts(){
        return service.getAllProduct();
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        System.out.println(product);
        return service.add(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@RequestParam String name, @RequestParam int quantity){
        return service.update(name, quantity);
    }

    @DeleteMapping("/delete/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable String name){
        service.delete(name);
    }

}
