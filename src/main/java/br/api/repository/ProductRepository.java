package br.api.repository;

import br.api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Dewes on 23/07/2016.
 */

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
}
