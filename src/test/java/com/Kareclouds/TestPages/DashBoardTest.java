package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.FrontOfficePage;
import com.Kareclouds.Pages.HospitalChargesPage;
import com.Kareclouds.Pages.MainBedPage;
import com.Kareclouds.Pages.PatientPage;

public class DashBoardTest extends BaseTest {
	public DashboardPage dbp;
	public PatientPage patientpage;
	public HospitalChargesPage hospital;
	public MainBedPage mainbedpage;
	public FrontOfficePage frontofficepage;

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
	@Test()
	public void clickAndVerifyBedtLink() throws InterruptedException {
		dbp=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		mainbedpage=dbp.selectBedLink();
		String result=mainbedpage.checkPageTitle();
		Assert.assertEquals(result,"Bed Status");
	}
	@Test()
	public void clickAndVerifyFrontOfficeLink() throws InterruptedException {
		dbp=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		frontofficepage=dbp.selectFrontOfficeLink();
		String result=frontofficepage.checkPageTitle();
		Assert.assertEquals(result,"Purpose List");
	}
	
}
