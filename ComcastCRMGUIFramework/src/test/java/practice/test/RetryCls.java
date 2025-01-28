package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest1.BaseClass1;

public class RetryCls extends BaseClass1 {

	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activateSim() {
		System.out.println("execute createInvoiceTest");
		Assert.assertEquals("", "Login");
		System.out.println("s1");
		System.out.println("s2");
		System.out.println("s3");
		System.out.println("s4");
	}
}
