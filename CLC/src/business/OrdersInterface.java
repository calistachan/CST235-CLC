package business;

import java.util.List;

import javax.ejb.Local;

import beans.Order;

@Local
public interface OrdersInterface {
	
	public void add(Order order);
	
	public List<Order> getOrders();
	
	public void setOrders(List<Order> orders);
	
}
