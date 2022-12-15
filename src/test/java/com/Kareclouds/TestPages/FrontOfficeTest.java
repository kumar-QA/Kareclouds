package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.AppointmentPriorityPage;
import com.Kareclouds.Pages.ComplainTypePage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.FrontOfficePage;
import com.Kareclouds.Pages.SourcePage;

public class FrontOfficeTest extends BaseTest{

	public DashboardPage dashboard_page;
	public ComplainTypePage complaintypepage;
	public SourcePage srcpage;
	public AppointmentPriorityPage appointmentpage;
	public FrontOfficePage frontofficepage;
	
	@Test()
	public void VerifyComplainTypePageLink() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		frontofficepage=dashboard_page.selectFrontOfficeLink();
		complaintypepage=frontofficepage.checkComplainTypeLink();
		String result=complaintypepage.checkPageTitle();
		Assert.assertEquals(result, "Complain Type List");
	}
	
	@Test()
	public void VerifySourcePageLink() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		frontofficepage=dashboard_page.selectFrontOfficeLink();
		srcpage=frontofficepage.checkSourceLink();
		String result=srcpage.checkPageTitle();
		Assert.assertEquals(result, "Source");
	}
	
	@Test()
	public void VerifyAppointmentPriorityPageLink() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		frontofficepage=dashboard_page.selectFrontOfficeLink();
		appointmentpage=frontofficepage.checkAppointmentPriorityLink();
		String result=appointmentpage.checkPageTitle();
		Assert.assertEquals(result, "Appointment Priority List");
	}
	
	
	
}
