package ch.keepcalm.web.store.controller;

import ch.keepcalm.web.store.model.Product;
import ch.keepcalm.web.store.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by marcelwidmer on 06.05.17.
 */
@RestController
@RequestMapping(value = "/api/products", produces = "application/hal+json")
@Slf4j
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity getProducts() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity(products, HttpStatus.OK);
    }

}
