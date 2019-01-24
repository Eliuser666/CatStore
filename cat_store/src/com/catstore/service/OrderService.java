package com.catstore.service;

import com.catstore.domain.Order;
import com.catstore.domain.PageBean;

public interface OrderService {

	void save(Order order);

	PageBean<Order> findByUid(String uid, Integer currPage) throws Exception;

	Order findByOid(String oid) throws Exception;

	void update(Order order) throws Exception;

}
