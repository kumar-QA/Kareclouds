package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.HospitalChargesPage;
import com.Kareclouds.Pages.PatientPage;

public class DashBoardTest extends BaseTest {
	public DashboardPage dbp;
	public PatientPage patientpage;
	public HospitalChargesPage hospital;

	@Test()
	public void clickAndVerifytPatientLink() throws InterruptedException {
		dbp=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patientpage=dbp.selectPatientLink();
		String result=patientpage.checkPageTitle();
		Assert.assertEquals(result,"Patient List");
	}
	
	@Test()
	public void clickAndVerifyHospialtLink() throws InterruptedException {
		dbp=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		hospital=dbp.selectHospitaltLink();
		String result=hospital.checkPageTitle();
		Assert.assertEquals(result,"Charges Details");
	}
}
