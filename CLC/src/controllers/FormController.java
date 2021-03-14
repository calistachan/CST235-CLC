package controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.OrdersInterface;
import beans.Order;
import beans.Orders;


@ManagedBean(name = "formController", eager = true)
@ViewScoped
public class FormController {
	
	public User login;

	@ManagedProperty(value = "#{user}")
	public User user;
	@ManagedProperty(value = "#{order}")
	public Order order;
	
	@Inject
	@Default
	public OrdersInterface cart;
	
	public void setCart(OrdersInterface cart) {
		this.cart = cart;
	}
	
	public OrdersInterface getCart()  {
		return cart;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public String onSubmit(User user) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		login = user;
		return "LoginSuccess.xhtml";
	}

	public String loginAttempt(User userIn) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", userIn);
		return "LoginSuccess.xhtml";
	}
	
	public String addToCart(Order order) {
		cart.add(order);
		return "ShowCart.xhtml";
	}
}
