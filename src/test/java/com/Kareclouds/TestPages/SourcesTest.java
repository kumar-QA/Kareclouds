package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.FrontOfficePage;
import com.Kareclouds.Pages.SourcePage;

public class SourcesTest extends BaseTest {

	public DashboardPage dashboard_page;
	public FrontOfficePage frontofficepage;
	public SourcePage srcpage;
	
	@Test()
	public void VerifyComplainTypeSearchFun() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		frontofficepage=dashboard_page.selectFrontOfficeLink();
		srcpage=frontofficepage.checkSourceLink();
		String result=srcpage.searchOperation("Online advertising");
		Assert.assertEquals(result, "Online advertising");
	}
	
	
	@Test()//------form Functionality 
	   public void VerifyaddSourcesForm() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   frontofficepage=dashboard_page.selectFrontOfficeLink();
		   srcpage=  frontofficepage.checkSourceLink();
		   srcpage.AddSourceseForm("online ", "online resources");
	   }
}
