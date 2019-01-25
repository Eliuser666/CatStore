package com.catstore.service;

import java.util.List;

import com.catstore.domain.Order;
import com.catstore.domain.OrderItem;
import com.catstore.domain.PageBean;

public interface OrderService {

	void save(Order order);

	PageBean<Order> findByUid(String uid, Integer currPage) throws Exception;

	Order findByOid(String oid) throws Exception;

	void update(Order order) throws Exception;

	List<Order> findAll() throws Exception;

	List<Order> findByState(int pstate) throws Exception;

	List<OrderItem> showDetail(String oid) throws Exception;

}
