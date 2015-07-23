package entity_managersAL_tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netbuilder.entities.LoginDetails;
import com.netbuilder.entities.Order;
import com.netbuilder.entities.PaymentDetails;
import com.netbuilder.entity_managers.arraylist.PaymentDetailsManagerAL;
import com.netbuilder.entity_managers.interfaces.PaymentDetailsManager;
import com.netbuilder.enums.CardType;
import com.netbuilder.enums.OrderStatus;

/**
 * 
 * @author Alexander Neil
 *
 */
public class PaymentDetailsManagerALTests {

	PaymentDetailsManagerAL paymentDetailsManager;
	PaymentDetails p1;
	PaymentDetails p2;
	PaymentDetails p3;
	
	ArrayList<PaymentDetails> detailsInput;
	
	LoginDetails c1;
	LoginDetails c2;
	byte[] password = {1,2,3};
	byte[] salt = {1,2,3};
	
	Order o1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		paymentDetailsManager = new PaymentDetailsManagerAL();
		
		c1 = new LoginDetails("fooUser", "testEmail1", password, salt);
		c2 = new LoginDetails("fooUser2", "testEmail2", password, salt);
		
		c1.setUserId(1);
		c2.setUserId(2);
		
		o1 = new Order(c2, c1, OrderStatus.placed, "2015-07-07", "2015-07-08", "2015-07-09", "3", true, p1);
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
		
		PaymentDetails output = paymentDetailsManager.findCustomerPaymentDetails(c1.getUserId());
		
		ArrayList<PaymentDetails> paymentDetailsTest = new ArrayList<PaymentDetails>();
		paymentDetailsTest.add(output);
		
		assertTrue(output.equals(detailsInput));
	}

	@Test
	public void testFindExpiredDetails() {

		paymentDetailsManager.persistPaymentDetails(detailsInput);
		
		List<PaymentDetails> output = paymentDetailsManager.findExpiredDetails(c1.getUserId());
		
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
