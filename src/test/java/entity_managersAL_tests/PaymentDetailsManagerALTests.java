package entity_managersAL_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netbuilder.entities.Customer;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.arraylist.PaymentDetailsManagerAL;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.OrderStatus;

public class PaymentDetailsManagerALTests {

	PaymentDetailsManager paymentDetailsManager;
	PaymentDetails p1;
	PaymentDetails p2;
	PaymentDetails p3;
	
	ArrayList<PaymentDetails> detailsInput;
	
	Customer c1;
	Customer c2;
	
	Order o1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		paymentDetailsManager = new PaymentDetailsManagerAL();
		
		c1 = new Customer("Absolutely", "Fantastic", "bounce", "EnterpriseArchitecture", "absolutely.fantastic@mailmail.mail", false);
		c2 = new Customer("Billy", "Bob", "bilbo", "baggins", "billy.bob@mailmail.mail", false);
		
		c1.setCustomerID(1);
		c2.setCustomerID(2);
		
		o1 = new Order(c2, OrderStatus.placed, "2015-07-07", "2015-07-08", "2015-07-09", "3", true);
		o1.setOrderID(1);
		
		p1 = new PaymentDetails(CardType.AMERICANEXPRESS, "12345678912345", "N B Gardens", 123, "03-17", c1);
		p2 = new PaymentDetails(CardType.VISADEBIT, "9876543219876543", "B Back", 987, "04-14", c1);
		p3 = new PaymentDetails(CardType.MASTERCARD, "1478963214789632", "D U Mmy", 456, "06-18", c2, o1);

		detailsInput = new ArrayList<PaymentDetails>();
		detailsInput.add(p1);
		detailsInput.add(p2);
		detailsInput.add(p3);
	}

	@Test
	public void testPersistPaymentDetailsPaymentDetailsAndFindByNumber() {
		
		paymentDetailsManager.persistPaymentDetails(p1);
		
		assertNotNull(paymentDetailsManager.findCardByNumber(p1.getCardNumber()));
	}

	@Test
	public void testPersistPaymentDetailsArrayListOfPaymentDetails() {

		paymentDetailsManager.persistPaymentDetails(detailsInput);
		
		ArrayList<PaymentDetails> output = paymentDetailsManager.findCustomerPaymentDetails(c1.getCustomerID());
		
		assertTrue(output.size()==2);
	}

	@Test
	public void testFindExpiredDetails() {

		paymentDetailsManager.persistPaymentDetails(detailsInput);
		
		ArrayList<PaymentDetails> output = paymentDetailsManager.findExpiredDetails(c1.getCustomerID());
		
		if(output.size()>0){
			PaymentDetails sample = output.get(0);
			
			assertEquals(p2, sample);
		}
		else{
			fail();
		}
	}

	@Test
	public void testFindPaymentDetailsForOrder() {

		paymentDetailsManager.persistPaymentDetails(detailsInput);
		
		PaymentDetails sample = paymentDetailsManager.findPaymentDetailsForOrder(o1.getOrderID());
		
		assertEquals(p3, sample);
	}

	@Test
	public void testRemovePaymentDetails() {
		
		paymentDetailsManager.persistPaymentDetails(detailsInput);
		
		paymentDetailsManager.removePaymentDetails(p1);
		
		assertNull(paymentDetailsManager.findCardByNumber(p1.getCardNumber()));
	}

}