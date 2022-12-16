package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.ComplainTypePage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.FrontOfficePage;

public class ComplainTypeTest extends BaseTest {
	public DashboardPage dashboard_page;
	public FrontOfficePage frontofficepage;
	public ComplainTypePage complaintypepage;
	
	@Test()
	public void VerifyComplainTypeSearchFun() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		frontofficepage=dashboard_page.selectFrontOfficeLink();
		complaintypepage=frontofficepage.checkComplainTypeLink();
		String result=complaintypepage.searchOperation("Food quality");
		Assert.assertEquals(result, "Food quality");
	}
	
	
	@Test()//------form Functionality 
	   public void VerifyComplainTypeForm() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   frontofficepage=dashboard_page.selectFrontOfficeLink();
		   complaintypepage=  frontofficepage.checkComplainTypeLink();
		   complaintypepage.AddComplainTypeForm("FoodQuality", "Food quality need to improve");;
	   }
}
