package com.netbuilder.util;

import javax.faces.bean.ManagedBean;
import javax.inject.Singleton;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Delivery;
import com.netbuilder.entities.DeliveryLine;
import com.netbuilder.entities.Employee;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entities.Product;
import com.netbuilder.entities.Stock;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
import com.netbuilder.enums.OrderStatus;
import com.netbuilder.enums.ProductCategory;

/**
 * 
 * @author ngilbert
 *
 */
@ManagedBean(name = "testData")
@Singleton
public class OrderData {

	byte[] password = { 1, 2, 3 };

	byte[] salt = { 1, 2, 3 };

	public LoginDetails customerLogin = new LoginDetails("fooUser",
			"testEmail1", password, salt);

	public LoginDetails customerLogin2 = new LoginDetails("fooUser3",
			"testEmail3", password, salt);

	public LoginDetails customerLogin3 = new LoginDetails("fooUser4",
			"testEmail4", password, salt);

	public LoginDetails employeeLogin = new LoginDetails("fooUser2",
			"testEmail2", password, salt);

	public PaymentDetails paymentDetails = new PaymentDetails(CardType.visa,
			"3435634734679447", "BOB", "22/07/2020", customerLogin);

	public PaymentDetails paymentDetails2 = new PaymentDetails(CardType.visa,
			"3432334534349464", "HARRY", "11/02/2017", customerLogin2);

	public PaymentDetails paymentDetails3 = new PaymentDetails(CardType.visa,
			"2346546487469332", "PAUL", "10/12/2025", customerLogin3);

	public Order order = new Order(customerLogin, employeeLogin,
			OrderStatus.awaitingdispatch, "10/10/15", "12/10/15",
			"13/10/15", 40, true);

	public Order order2 = new Order(customerLogin2, employeeLogin,
			OrderStatus.basket, "09/08/15", "30/09/15", "01/10/15",
			70, true);

	public Order order3 = new Order(customerLogin3, employeeLogin,
			OrderStatus.wishlist, "08/08/15","10/08/15", "11/08/15",
			80, true);

	public Product product_genID = new Product(1, "img/iomg", "testproduct",
			25.25, 10, 10, 11, 10.50, "test Product gen",
			ProductCategory.accessory);

	public Product product = new Product("img/iomg", "testproduct", 25.25, 10,
			10, 11, 10.50, "test Product", ProductCategory.accessory);

	public Product product2 = new Product("img/iomg", "testproduct2", 29.25,
			53, 90, 15, 15.50, "test Product 2", ProductCategory.gnome);

	public Product product3 = new Product("img/iomg", "testproduct3", 76.25,
			80, 45, 18, 19.50, "test Product 3", ProductCategory.furniture);

	public Address address = new Address(customerLogin, "house", "absolutely",
			"fantastic", "pull", "bounce", "cheese", "LEY76R", false);

	public Address address2 = new Address(customerLogin2, "shed", "banter",
			"hell", "earth", "junit", "java", "ABCDEF", false);

	public Address address3 = new Address(customerLogin3, "mansion", "maybe",
			"staines", "kazakhstan", "meep", "okej", "JKASJS", false);

	public Delivery delivery = new Delivery("AB/BC/CDEF", "BC/DE/EFGH",
			"Gnome Depot", 110.5);

	public Delivery delivery2 = new Delivery("14/04/2015", "17/05/2015",
			"Gnomes 'r' Us", 340.7);

	public Delivery delivery3 = new Delivery("RQ/VD/2018", "VA/AR/2020",
			"Gnarly Gnomes", 230.15);

	public DeliveryLine deliveryLine = new DeliveryLine(product, delivery, 50);

	public DeliveryLine deliveryLine1 = new DeliveryLine(product, delivery, 50);

	public DeliveryLine deliveryLine2 = new DeliveryLine(product, delivery2, 50);

	public DeliveryLine deliveryLine3 = new DeliveryLine(product, delivery2, 50);

	public DeliveryLine deliveryLine4 = new DeliveryLine(product, delivery3, 50);

	public DeliveryLine deliveryLine5 = new DeliveryLine(product, delivery3, 50);

	public Customer customer = new Customer("fName1", "lName1",
			"contactNumber1", true);

	public Customer customer2 = new Customer("fName2", "lName2",
			"contactNumber2", true);

	public Customer customer3 = new Customer("fName3", "lName3",
			"contactNumber3", true);

	public Employee employee = new Employee(EmployeeDepartment.warehouse,
			"Ware", "House", EmployeePermissions.manager);

	public Employee employee2 = new Employee(EmployeeDepartment.warehouse,
			"Slave", "Labor", EmployeePermissions.worker);

	public Employee employee3 = new Employee(EmployeeDepartment.warehouse,
			"Shelf", "Picker", EmployeePermissions.worker);

	public Employee employee4 = new Employee(EmployeeDepartment.sales,
			"Telephone", "House", EmployeePermissions.manager);

	public Stock stock = new Stock(product, 4, 3, "Over there", 10, 2, 5, 10 , 10);

	public Stock stock2 = new Stock(product2, 5, 4, "Right here", 12, 5, 9, 11 , 11);

	public Stock stock3 = new Stock(product3, 8, 1, "Ooch aye the noo", 17, 3,
			8, 15 , 12);

	public ContactUsDetails contactUs = new ContactUsDetails("04066457482",
			"NB Gardens", "66 James Close", "Ravenwood", "Staines", "ST43LE",
			"NBGardens@hotmail.com");

	/*
	 * public List<OrderLine> orderLines = new ArrayList<OrderLine>() {{ Order
	 * orderTest = new Order(customerLogin, employeeLogin,
	 * OrderStatus.awaitingDispatch, "10/10/15", 12380809, "12/10/15",
	 * "13/10/15", "40", true, paymentDetails);
	 * 
	 * Product productTest = new Product("img/iomg", "testproduct", 25.25, 10,
	 * 10, 11, 10.50, "test Product", ProductCategory.Accessory);
	 * 
	 * OrderLine orderLine = new OrderLine(orderTest , productTest, 50);
	 * 
	 * //OrderLine orderLine1 = new OrderLine(order , product2, 5);
	 * 
	 * //OrderLine orderLine2 = new OrderLine(order , product, 20);
	 * 
	 * //OrderLine orderLine3 = new OrderLine(order2 , product, 4);
	 * 
	 * //OrderLine orderLine4 = new OrderLine(order2 , product3, 3);
	 * 
	 * //OrderLine orderLine5 = new OrderLine(order2 , product2, 8);
	 * 
	 * //OrderLine orderLine6 = new OrderLine(order3 , product, 6);
	 * 
	 * //OrderLine orderLine7 = new OrderLine(order3 , product2, 7);
	 * 
	 * orderLines.add(orderLine);
	 * 
	 * }};
	 * 
	 * 
	 * public List<OrderLine> getOrderLines() { return orderLines; }
	 * 
	 * 
	 * /**
	 * 
	 * @return the password
	 */

	public byte[] getPassword() {
		return password;
	}

	/**
	 * @return the salt
	 */
	public byte[] getSalt() {
		return salt;
	}

	/**
	 * @return the customerLogin
	 */
	public LoginDetails getCustomerLogin() {
		return customerLogin;
	}

	/**
	 * @return the customerLogin2
	 */
	public LoginDetails getCustomerLogin2() {
		return customerLogin2;
	}

	/**
	 * @return the customerLogin3
	 */
	public LoginDetails getCustomerLogin3() {
		return customerLogin3;
	}

	/**
	 * @return the employeeLogin
	 */
	public LoginDetails getEmployeeLogin() {
		return employeeLogin;
	}

	/**
	 * @return the paymentDetails
	 */
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	/**
	 * @return the paymentDetails2
	 */
	public PaymentDetails getPaymentDetails2() {
		return paymentDetails2;
	}

	/**
	 * @return the paymentDetails3
	 */
	public PaymentDetails getPaymentDetails3() {
		return paymentDetails3;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @return the order2
	 */
	public Order getOrder2() {
		return order2;
	}

	/**
	 * @return the order3
	 */
	public Order getOrder3() {
		return order3;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product_genID;
	}

	/**
	 * @return the product2
	 */
	public Product getProduct2() {
		return product2;
	}

	/**
	 * @return the product3
	 */
	public Product getProduct3() {
		return product3;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @return the address2
	 */
	public Address getAddress2() {
		return address2;
	}

	/**
	 * @return the address3
	 */
	public Address getAddress3() {
		return address3;
	}

	/**
	 * @return the delivery
	 */
	public Delivery getDelivery() {
		return delivery;
	}

	/**
	 * @return the delivery2
	 */
	public Delivery getDelivery2() {
		return delivery2;
	}

	/**
	 * @return the delivery3
	 */
	public Delivery getDelivery3() {
		return delivery3;
	}

	/**
	 * @return the deliveryLine
	 */
	public DeliveryLine getDeliveryLine() {
		return deliveryLine;
	}

	/**
	 * @return the deliveryLine1
	 */
	public DeliveryLine getDeliveryLine1() {
		return deliveryLine1;
	}

	/**
	 * @return the deliveryLine2
	 */
	public DeliveryLine getDeliveryLine2() {
		return deliveryLine2;
	}

	/**
	 * @return the deliveryLine3
	 */
	public DeliveryLine getDeliveryLine3() {
		return deliveryLine3;
	}

	/**
	 * @return the deliveryLine4
	 */
	public DeliveryLine getDeliveryLine4() {
		return deliveryLine4;
	}

	/**
	 * @return the deliveryLine5
	 */
	public DeliveryLine getDeliveryLine5() {
		return deliveryLine5;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the customer2
	 */
	public Customer getCustomer2() {
		return customer2;
	}

	/**
	 * @return the customer3
	 */
	public Customer getCustomer3() {
		return customer3;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @return the employee2
	 */
	public Employee getEmployee2() {
		return employee2;
	}

	/**
	 * @return the employee3
	 */
	public Employee getEmployee3() {
		return employee3;
	}

	/**
	 * @return the employee4
	 */
	public Employee getEmployee4() {
		return employee4;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @return the stock2
	 */
	public Stock getStock2() {
		return stock2;
	}

	/**
	 * @return the stock3
	 */
	public Stock getStock3() {
		return stock3;
	}

	public ContactUsDetails getContactUs() {
		return contactUs;
	}

}
