package Project_2026_grotechMid.grotechMid_2026;

import java.io.IOException;

import org.apache.poi.hssf.record.HideObjRecord;
import org.testng.annotations.Test;

public class testCase1 extends baseClass
{

	@Test
	public void testcase1() throws IOException
	{
		HomePage objHomePage = new HomePage(driver);
		objHomePage.regApp();
		objHomePage.findLinks();
		
	}
}
