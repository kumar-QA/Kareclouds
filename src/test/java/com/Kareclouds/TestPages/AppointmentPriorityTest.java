package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.AppointmentPriorityPage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.FrontOfficePage;

public class AppointmentPriorityTest extends BaseTest {

	
	public DashboardPage dashboard_page;
	public FrontOfficePage frontofficepage;
	public AppointmentPriorityPage appointmentpage;
	
	@Test()
	public void VerifyComplainTypeSearchFun() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		frontofficepage=dashboard_page.selectFrontOfficeLink();
		appointmentpage=frontofficepage.checkAppointmentPriorityLink();
		String result=appointmentpage.searchOperation("Urgent");
		Assert.assertEquals(result, "Urgent");
	}
	
	
	@Test()//------form Functionality 
	   public void VerifyComplainTypeForm() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   frontofficepage=dashboard_page.selectFrontOfficeLink();
		   appointmentpage= frontofficepage.checkAppointmentPriorityLink();
		   appointmentpage.addPriorityForm("Emergency");
	   }
}
