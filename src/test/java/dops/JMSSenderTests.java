package dops;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.netbuilder.dops.jms.MessageSender;
import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.OrderLine;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entities.Product;
import com.netbuilder.entity_managers.arraylist.OrderLineManagerAL;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.EmployeeDepartment;
import com.netbuilder.enums.EmployeePermissions;
import com.netbuilder.enums.OrderStatus;

public class JMSSenderTests {

	
	MessageSender sender;
	
	private Order order;
	private LoginDetails testCustomer1;
	private PaymentDetails paymentDetails;
	byte[] password = {1,2,3};
	byte[] salt = {1,2,3};
	
	
	@Before
	public void setUp() throws Exception {
				
		testCustomer1 = new LoginDetails("fooUser", "testEmail1", password, salt);
		
		paymentDetails = new PaymentDetails(CardType.VISA, "3435634734679447", "BOB", 323, "22/07/2020", testCustomer1);
			
		order = new Order(testCustomer1, OrderStatus.awaitingDispatch, paymentDetails);
		
		sender = new MessageSender();
	}

	@Test
	public void test() {
		sender.sendOrderMessage(order, 1);
	}

}
