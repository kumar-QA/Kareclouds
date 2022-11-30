package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.HospitalChargesPage;

public class HospitalChargesTest extends BaseTest {
	public DashboardPage dashboard_page;
	public HospitalChargesPage hospital;
	
	@Test()
	public void verifyForrmdetaislWithError() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		hospital=dashboard_page.selectHospitaltLink();
		String data=hospital.addChargeFormDetailsWithError("Investigations","200", "500", "Blood report ");
		Assert.assertEquals(data, "The Charge Category field is required.");
	}
	
	@Test()
	public void verifyTableData() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		hospital=dashboard_page.selectHospitaltLink();
		boolean result=hospital.checkTabelDataWithSearch("200");
		Assert.assertTrue(result);
	}
}