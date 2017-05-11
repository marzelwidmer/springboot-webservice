package ch.keepcalm.web.infrastructure.bootstrap;

import ch.keepcalm.web.store.model.Product;
import ch.keepcalm.web.store.repository.ProductRepository;
import ch.keepcalm.web.store.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by marcelwidmer on 26.09.16.
 */
@Slf4j
public class DatabaseBootstrap implements InitializingBean {

    private ProductRepository repository;
    private ProductService productService;



    @Autowired
    public void setDatabaseBootstrap(ProductRepository repository, ProductService productService) {
        this.repository = repository;
        this.productService = productService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // add some products directly via repoository
        repository.save(Product.builder().sku("IPHONE.5").materialName("iPhone 5").availability(1).price(555.90).build());
        repository.insert(Product.builder().sku("IPHONE.6").materialName("iPhone 6").availability(1).price(835.20).build());

        List<Product> products = productService.getSku("IPHONE.5");
        products.forEach(product -> log.info(product.toString()));

        log.info("Bootstrap finish initialized.");
    }
}
