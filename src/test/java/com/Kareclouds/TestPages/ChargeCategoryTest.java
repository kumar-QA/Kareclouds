package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.ChargeCategoryPage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.HospitalChargesPage;

public class ChargeCategoryTest extends BaseTest{

	public DashboardPage dashboard_page;
	public HospitalChargesPage hospitalcharges;
	public ChargeCategoryPage chargecategory;
	
	 @Test()//------Search Functionality 
	   public void VerifySearchOptionOfCCP() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   hospitalcharges=dashboard_page.selectHospitaltLink();
		   chargecategory=  hospitalcharges.checkingChargeCategoryLink();
			String result=chargecategory.searchOperation("MRI scan");
			Assert.assertEquals(result, "MRI scan");
	   }
	 
	 @Test()//------Add form Details Functionality 
	   public void VerifyFormDetails() throws InterruptedException {
		   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		   hospitalcharges=dashboard_page.selectHospitaltLink();
		   chargecategory=  hospitalcharges.checkingChargeCategoryLink();
		   chargecategory.addchargecategoryFormDetails("tet", "eee", "Procedures");
	   }
	 
	 
}
