package br.api.resources;

import br.api.models.Product;
import br.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Dewes on 23/07/2016.
 */

@RestController
@ResponseBody
@RequestMapping(value = "/api/product")
public class ProductResource {

    @Autowired private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        HttpStatus httpStatus;
        if(productRepository.exists(id)){
            product.setId(id);
            productRepository.save(product);
            httpStatus = HttpStatus.OK;
        }
        else {
            httpStatus = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(product, httpStatus);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Product>> list(@RequestParam(defaultValue = "0", required = false) int page) {
        List<Product> products = productRepository.findAll();
        products.forEach(p -> {
            p.setSelfLink(linkTo(methodOn(ProductResource.class).getById(p.getId())).toString());
        });
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product product = productRepository.findOne(id);
        HttpStatus httpStatus;
        if (product != null) {
            product.setSelfLink(linkTo(methodOn(ProductResource.class).getById(product.getId())).toString());
            httpStatus = HttpStatus.OK;
        }
        else {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(product, httpStatus);
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.DELETE} )
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        productRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
