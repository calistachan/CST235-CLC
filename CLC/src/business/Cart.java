package business;

import beans.Order;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Cart
 */
@Stateless
@Local(OrdersInterface.class)
@LocalBean
public class Cart implements OrdersInterface {

	private List<Order> orders = new ArrayList<Order>();
	
    /**
     * Default constructor. 
     */
    public Cart() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see OrdersInterface#getOrders()
     */
    public List<Order> getOrders() {
        // TODO Auto-generated method stub
			return orders;
    }

	/**
     * @see OrdersInterface#setOrders(List<Order>)
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

	/**
     * @see OrdersInterface#add(Order)
     */
    public void add(Order order) {
        orders.add(order);
    }

}
