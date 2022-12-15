package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.ChargeTypePage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.HospitalChargesPage;

public class ChargeTypeTest extends BaseTest{
	public DashboardPage dashboard_page;
	public HospitalChargesPage hospitalcharges;
	public ChargeTypePage chargetype;
	
	 @Test()//------Search Functionality 
	   public void VerifySearchOptionOfCT() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   hospitalcharges=dashboard_page.selectHospitaltLink();
		   chargetype=  hospitalcharges.checkingChargeTypeLink();
			String result=chargetype.searchOperation("Procedures");
			Assert.assertEquals(result, "Procedures");
	   }
	 
	 @Test()//------Search Functionality 
	   public void VerifyaddchargetypeForm() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   hospitalcharges=dashboard_page.selectHospitaltLink();
		   chargetype=  hospitalcharges.checkingChargeTypeLink();
		   chargetype.AddChargeTypeForm("BloodReport");
	   }
}
