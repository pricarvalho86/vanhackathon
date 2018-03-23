package com.skipthedishes.vanhackathon.product;

import com.skipthedishes.vanhackathon.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Product")
public class ProductResource {

    private ProductService service;

    @Autowired
    public ProductResource(ProductService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Iterable<Product> list() {
        return service.list();
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public Product get(@PathVariable("productId") Long productId) {
        return service.findById(productId).get();
    }

    //TODO SOLR/ELASTICSEARCH ?
    @RequestMapping(value = "/search/{searchText}", method = RequestMethod.GET)
    public ResponseEntity<String> search(@PathVariable("searchText") String searchText) {
        return ResponseEntity.ok().body("Searching " +searchText );
    }

}
