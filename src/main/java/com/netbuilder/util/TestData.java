package com.netbuilder.util;

import java.math.BigDecimal;

import com.netbuilder.entities.Address;
import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Delivery;
import com.netbuilder.entities.DeliveryLine;
import com.netbuilder.entities.Employee;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
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

public class TestData {
	
	byte[] password = {1,2,3};
	
	byte[] salt = {1,2,3};

	public LoginDetails customerLogin = new LoginDetails("fooUser", "testEmail1", password, salt);
	
	public LoginDetails customerLogin2 = new LoginDetails("fooUser3", "testEmail3", password, salt);
	
	public LoginDetails customerLogin3 = new LoginDetails("fooUser4", "testEmail4", password, salt);
	
	public LoginDetails employeeLogin = new LoginDetails("fooUser2", "testEmail2", password, salt);	
	
	public PaymentDetails paymentDetails = new PaymentDetails(CardType.VISA, "3435634734679447", "BOB", 323, "22/07/2020", customerLogin);	
	
	public PaymentDetails paymentDetails2 = new PaymentDetails(CardType.VISA, "3432334534349464", "HARRY", 684, "11/02/2017", customerLogin2);	
	
	public PaymentDetails paymentDetails3 = new PaymentDetails(CardType.VISA, "2346546487469332", "PAUL", 925, "10/12/2025", customerLogin3);	
		
	
	public Order order = new Order(customerLogin, employeeLogin, OrderStatus.awaitingDispatch,
			"10/10/15", 12380809, "12/10/15", "13/10/15",
			"40", true, paymentDetails);	
	
	public Order order2 = new Order(customerLogin2, employeeLogin, OrderStatus.basket,
			"09/08/15", 64632373, "30/09/15", "01/10/15",
			"70", true, paymentDetails2);	
	
	public Order order3 = new Order(customerLogin3, employeeLogin, OrderStatus.wishlist,
			"08/08/15", 12380809, "10/08/15", "11/08/15",
			"80", true, paymentDetails3);	
	
	public Product product = new Product("img/iomg", "testproduct", 25.25, 10, 10, 11, 10.50, "test Product", ProductCategory.Accessory);	
	
	public Product product2 = new Product("img/iomg", "testproduct2", 29.25, 53, 90, 15, 15.50, "test Product 2", ProductCategory.Gnome);	
	
	public Product product3 = new Product("img/iomg", "testproduct3", 76.25, 80, 45, 18, 19.50, "test Product 3", ProductCategory.Furniture);	
	
	public OrderLine orderLine = new OrderLine(order , product, 50);
	
	public OrderLine orderLine1 = new OrderLine(order , product2, 5);	
	
	public OrderLine orderLine2 = new OrderLine(order , product, 20);	
	
	public OrderLine orderLine3 = new OrderLine(order2 , product, 4);
	
	public OrderLine orderLine4 = new OrderLine(order2 , product3, 3);	
	
	public OrderLine orderLine5 = new OrderLine(order2 , product2, 8);	
	
	public OrderLine orderLine6 = new OrderLine(order3 , product, 6);	
	
	public OrderLine orderLine7 = new OrderLine(order3 , product2, 7);	
	
	public Address address = new Address(customerLogin, "house", "absolutely", "fantastic", "pull", "bounce", "cheese", "LEY76R", false);
	
	public Address address2 = new Address(customerLogin2, "shed", "banter", "hell", "earth", "junit", "java", "ABCDEF", false);
	
	public Address address3 = new Address(customerLogin3, "mansion", "maybe", "staines", "kazakhstan", "meep", "okej", "JKASJS", false);
	
	public Delivery delivery = new Delivery("AB/BC/CDEF", "BC/DE/EFGH", "Gnome Depot", new BigDecimal(110.5));
	
	public Delivery delivery2 = new Delivery("14/04/2015", "17/05/2015", "Gnomes 'r' Us", new BigDecimal(340.7));
	
	public Delivery delivery3 = new Delivery("RQ/VD/2018", "VA/AR/2020", "Gnarly Gnomes", new BigDecimal(230.15));
	
	public DeliveryLine deliveryLine = new DeliveryLine(product, delivery, 50);
	
	public DeliveryLine deliveryLine1 = new DeliveryLine(product, delivery, 50);
	
	public DeliveryLine deliveryLine2 = new DeliveryLine(product, delivery2, 50);
	
	public DeliveryLine deliveryLine3 = new DeliveryLine(product, delivery2, 50);
	
	public DeliveryLine deliveryLine4 = new DeliveryLine(product, delivery3, 50);
	
	public DeliveryLine deliveryLine5 = new DeliveryLine(product, delivery3, 50);
	
	public Customer customer = new Customer("fName1", "lName1", "contactNumber1", true);
	
	public Customer customer2 = new Customer("fName2", "lName2", "contactNumber2", true);
	
	public Customer customer3 = new Customer("fName3", "lName3", "contactNumber3", true);
	
	public Employee employee = new Employee(EmployeeDepartment.WAREHOUSE, "Ware", "House", EmployeePermissions.MANAGER);
	
	public Employee employee2 = new Employee(EmployeeDepartment.WAREHOUSE, "Slave", "Labor", EmployeePermissions.WORKER);
	
	public Employee employee3 = new Employee(EmployeeDepartment.WAREHOUSE, "Shelf", "Picker", EmployeePermissions.WORKER);
	
	public Employee employee4 = new Employee(EmployeeDepartment.SALES, "Telephone", "House", EmployeePermissions.MANAGER);
	
	public Stock stock = new Stock(product, 4, 3, "Over there", 10, 2, 5);
	
	public Stock stock2 = new Stock(product2, 5, 4, "Right here", 12, 5, 9);
	
	public Stock stock3 = new Stock(product3, 8, 1, "Ooch aye the noo", 17, 3, 8);
			
}
