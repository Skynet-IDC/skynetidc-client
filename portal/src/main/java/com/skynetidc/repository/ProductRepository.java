package com.skynetidc.repository;

import com.skynetidc.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {

	Optional<List<Product>> findByGid(long gid);

}
