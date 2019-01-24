package com.catstore.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.catstore.dao.OrderDao;
import com.catstore.domain.Order;
import com.catstore.domain.OrderItem;
import com.catstore.domain.Product;
import com.catstore.utils.JDBCUtils;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void saveOrder(Connection conn, Order order) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into orders values (?,?,?,?,?,?,?,?)";
		Object[] params = { order.getOid(), order.getOrdertime(), order.getTotal(), order.getState(),
				order.getAddress(), order.getName(), order.getTelephone(), order.getUser().getUid() };
		queryRunner.update(conn, sql, params);
	}

	@Override
	public void saveOrderItem(Connection conn, OrderItem orderItem) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "insert into orderitem values (?,?,?,?,?)";
		Object[] params = { orderItem.getItemid(), orderItem.getCount(), orderItem.getSubtotal(),
				orderItem.getProduct().getPid(), orderItem.getOrder().getOid() };
		queryRunner.update(conn, sql, params);
	}

	/*
	 * 查询订单总数
	 * 
	 * @see com.catstore.dao.OrderDao#findCountByUid(java.lang.String)
	 */
	@Override
	public Integer findCountByUid(String uid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select count(*) from orders where uid = ?";
		Long count = (Long) queryRunner.query(sql, new ScalarHandler(), uid);
		return count.intValue();
	}
	/*
	 * 查询页数
	 * 
	 * @see com.catstore.dao.OrderDao#findCountByUid(java.lang.String)
	 */
	@Override
	public List<Order> findPageByUid(String uid, int begin, Integer pageSize) throws Exception{
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from orders where uid = ? order by ordertime desc limit ?,?";
		List<Order> list = queryRunner.query(sql, new BeanListHandler<Order>(Order.class), uid,begin,pageSize);
		for (Order order : list) {
			sql = "SELECT * FROM orderitem o,product p WHERE o.pid = p.pid AND o.oid = ?";
			List<Map<String,Object>> oList = queryRunner.query(sql, new MapListHandler(), order.getOid());
			// 遍历LIst的Map集合:获取每条记录，封装到不同的对象中.
			for (Map<String, Object> map : oList) {
				Product product = new Product();
				//product.setPname(map.get("pname"));
				BeanUtils.populate(product, map);
				OrderItem orderItem = new OrderItem();
				BeanUtils.populate(orderItem, map);
				
				orderItem.setProduct(product);
				
				order.getOrderItems().add(orderItem);
			}
		}
		return list;
	}

	@Override
	public Order findByOid(String oid) throws Exception {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from orders where oid = ?";
		Order order = queryRunner.query(sql, new BeanHandler<Order>(Order.class), oid);
		sql = "SELECT * FROM orderitem o,product p WHERE o.pid = p.pid AND o.oid = ?";
		List<Map<String,Object>> oList = queryRunner.query(sql, new MapListHandler(), oid);
		for (Map<String, Object> map : oList) {
			Product product = new Product();
			BeanUtils.populate(product, map);
			
			OrderItem orderItem = new OrderItem();
			BeanUtils.populate(orderItem, map);
			
			orderItem.setProduct(product);
			
			order.getOrderItems().add(orderItem);
		}
		return order;
	}

	@Override
	public void update(Order order) throws Exception {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update orders set total = ?,state = ? ,address = ?,name=?,telephone = ? where oid = ?";
		Object[] params = {order.getTotal(),order.getState(),order.getAddress(),order.getName(),order.getTelephone() ,order.getOid()};
		queryRunner.update(sql,params);
		
	}

}
