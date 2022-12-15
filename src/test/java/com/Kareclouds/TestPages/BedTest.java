package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.BedPage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.MainBedPage;

public class BedTest extends BaseTest {

	public DashboardPage dashboard_page;
	public MainBedPage mainbedpage;
	public BedPage bedpage;
	
	 @Test()//------Search Functionality 
	   public void VerifySearchOptionOfCCP() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   hospitalcharges=dashboard_page.selectHospitaltLink();
		   chargecategory=  hospitalcharges.checkingChargeCategoryLink();
			String result=chargecategory.searchOperation("MRI scan");
			Assert.assertEquals(result, "MRI scan");
	   }
}
