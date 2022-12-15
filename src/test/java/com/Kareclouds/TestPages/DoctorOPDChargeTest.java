package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.DoctorOPDChargePage;
import com.Kareclouds.Pages.HospitalChargesPage;

public class DoctorOPDChargeTest extends BaseTest {
	public DashboardPage dashboard_page;
	public HospitalChargesPage hospitalcharges;
	public DoctorOPDChargePage doctor_pod;
	
	@Test()//------Search Functionality 
	   public void VerifySearchOptionofOPD() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   hospitalcharges=dashboard_page.selectHospitaltLink();
		   doctor_pod=  hospitalcharges.checkingDoctorOPDChargeLink();
			String result=doctor_pod.searchOperation("Swapna k");
			Assert.assertEquals(result, "Swapna k");
	   }
	
	@Test()//------Search Functionality 
	   public void VerifyFormDetails() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   hospitalcharges=dashboard_page.selectHospitaltLink();
		   doctor_pod=  hospitalcharges.checkingDoctorOPDChargeLink();
		   doctor_pod.AddChargeForm("6", "500");

	   }
	
}
