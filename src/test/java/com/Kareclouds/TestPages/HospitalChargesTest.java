package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.ChargeCategoryPage;
import com.Kareclouds.Pages.ChargeTypePage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.DoctorOPDChargePage;
import com.Kareclouds.Pages.HospitalChargesPage;

public class HospitalChargesTest extends BaseTest {
	public DashboardPage dashboard_page;
	public HospitalChargesPage hospital;
	public ChargeCategoryPage chargecategory;
	public DoctorOPDChargePage doctor_opd;
	public ChargeTypePage chargetype;
	
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
	@Test()
	public void verifyChargeCategoryLink() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		hospital=dashboard_page.selectHospitaltLink();
		chargecategory=hospital.checkingChargeCategoryLink();
		String result=chargecategory.checkPageTitle();
		Assert.assertEquals(result, "Charge Category List");
	}
	@Test()
	public void verifyDoctorOPDChargeLink() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		hospital=dashboard_page.selectHospitaltLink();
		doctor_opd=hospital.checkingDoctorOPDChargeLink();
		String result=doctor_opd.checkPageTitle();
		Assert.assertEquals(result, "Doctor OPD Charge");
	}
	
	@Test()
	public void verifyChargeTypeLink() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		hospital=dashboard_page.selectHospitaltLink();
		chargetype=hospital.checkingChargeTypeLink();
		String result=chargetype.checkPageTitle();
		Assert.assertEquals(result, "Charge Type List");
	}
	
}