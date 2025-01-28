package practice.test;

import org.testng.annotations.DataProvider;

public class CustomizeDataProv {
	@DataProvider(name="LoginData")
	public Object[][] getData()
	{
		Object[][] data= {{"shiva@gmail.com","123"},
				         {"sadhu@gmail.com","456"},
				         {"gouse@gmail.com","789"}};
				         return data;
	}
}
