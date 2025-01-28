package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest1.BaseClass1;
@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class InvoiceTest  extends BaseClass1{
	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		String actTit=driver.getTitle();
		Assert.assertEquals(actTit, "Login");
		System.out.println("s1");
		System.out.println("s2");
		System.out.println("s3");
		System.out.println("s4");
		
		
	}
@Test
public void createInvoicewithContactTest() {
	System.out.println("execute  createInvoicewithContactTest ");
	System.out.println();
	
}
}
