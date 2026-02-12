package com.skynetidc.repository;

import com.skynetidc.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {

}
