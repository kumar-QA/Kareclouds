package com.Kareclouds.TestPages;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.DisabledPatientPage;
import com.Kareclouds.Pages.PatientPage;

public class PatientPageTest extends BaseTest{
	public DashboardPage dashboard_page;
	public PatientPage patient_page;
	public DisabledPatientPage disabledPatient_pg;
	
   @Test()//-------From Details Functionality
   public void verifyFormDetails() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.enterFormDetails("pavan", "pradeep","Male","March 1998","12","O+","Single","C:\\Users\\prasannakumar\\Pictures\\t.jpg","9123456795","kumar@gmail.com","Hno:12 hyderbad","nothing","No allergies");
		Assert.assertEquals(result,"Record Saved Successfully");
	
   }
   
   @Test()//------Search Functionality 
   public void VerifySearchOption() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.searchOperation("1050");
		Assert.assertEquals(result, "1050");
   }
   
   @Test()//------------Disable Patient link Functionality
   public void verifyDisabledPatientLink() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		disabledPatient_pg=patient_page.gotoDisabledPatientPage();
		String title=disabledPatient_pg.checkPageTitle();
		Assert.assertEquals(title, "Disabled Patient List");
   }
   
 @Test()//---------------------Table sorting
 public void verifySortingColumnTabel() throws InterruptedException {
	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
	 		patient_page=dashboard_page.selectPatientLink();
	 		List<List<String>> result=patient_page.sortingEachColumn("patientname",2);
	 		Assert.assertEquals(result.get(0), result.get(1));
 }
   

   
   @Test()//---------------------Action column in Table
   public void verifyActionColumnInTable() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
//		patient_page.checkActionColumn();
		boolean result=patient_page.checkActionColumn("1070","kumar");
		Assert.assertEquals(result, true);
   }
   
   @Test()//---------------------Inside Action column OPD Link
   public void verifyActionCol_ListOPDLink() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.checklistBtnOPD();
		Assert.assertEquals(result, "mohan krishna");
   }
   
   @Test()//---------------------Inside Action column PharamacyLink
   public void verifyActionCol_ListPharamacyLink() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.checklistBtnPharamacy();
		Assert.assertEquals(result, "Pharmacy Bill");
   }
   
   @Test()//---------------------Inside Action column OpeartionTheater Link
   public void verifyActionCol_ListOpeartionTheater() throws InterruptedException {
	   dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		patient_page=dashboard_page.selectPatientLink();
		String result=patient_page.checklistBtnOT();
		Assert.assertEquals(result, "Operation Theatre Patient");
   }
   
   
   
// @Test()
// public void verifyPatientIdAscendingOrder() throws InterruptedException {
//	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
//	 		patient_page=dashboard_page.selectPatientLink();
//	 		String result=patient_page.patientIdAscendingSorting("1077");
//	 		System.out.println("order changed  to :"+result);
//	 		Assert.assertEquals(result, "Ascending order");
// }
 

// @Test()
// public void verifTableColumnSorting() throws InterruptedException {
//		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
//		patient_page=dashboard_page.selectPatientLink();
//		String result=patient_page.checkTableColumnSorting("phone","7444654641");
//		Assert.assertEquals(result, "Descending order");
// }
   
   
   //--------Differnt ways-----------
//   @Test()
//   public void verifyPatientIdOrder_1stWay() throws InterruptedException {
//	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
//	 		patient_page=dashboard_page.selectPatientLink();
//	 		boolean result=patient_page.sortingPatientID_1stway();
//	 		Assert.assertTrue(result);
//   }
//   
//   @Test()
//   public void verifyPatientIdOrder_2ndWay() throws InterruptedException {
//	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
//	 		patient_page=dashboard_page.selectPatientLink();
//	 	List<List<String>> data=patient_page.sortingPatientID_2ndway();
//	 	Assert.assertEquals(data.get(0), data.get(1));	
//	 	
//	 	Assert.assertEquals(data.get(0), data.get(1));
//   }
//   
//   @Test()
//   public void verifyPatientnameOrder_1stWay() throws InterruptedException {
//	   		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
//	 		patient_page=dashboard_page.selectPatientLink();
//	 		boolean result=patient_page.sortingPatientname_1stway();
//	 		Assert.assertTrue(result);
//   }
   

   
}
   
   
   
   
   
   