package com.Kareclouds.TestPages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Kareclouds.Pages.BedGroupPage;
import com.Kareclouds.Pages.BedPage;
import com.Kareclouds.Pages.BedTypePage;
import com.Kareclouds.Pages.DashboardPage;
import com.Kareclouds.Pages.FloorPage;
import com.Kareclouds.Pages.MainBedPage;

public class MainBedTest extends BaseTest{
	public DashboardPage dashboard_page;
	public MainBedPage mainbedpage;
	public BedPage bedpage;
	public BedTypePage bedtype;
	public BedGroupPage bedgrouppage;
	public FloorPage floor;
	
	@Test()
	public void VerifyBedLink() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		mainbedpage=dashboard_page.selectBedLink();
		bedpage=mainbedpage.checkBedPageLink();
		String result=bedpage.checkPageTitle();
		Assert.assertEquals(result, "Bed List");
	}
	
	@Test()
	public void VerifyBedTypeLink() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		mainbedpage=dashboard_page.selectBedLink();
		bedtype=mainbedpage.checkBedTypeLink();
		String result=bedtype.checkPageTitle();
		Assert.assertEquals(result, "Bed Type List");
	}
	@Test()
	public void VerifyBedGroupLink() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		mainbedpage=dashboard_page.selectBedLink();
		bedgrouppage=mainbedpage.checkBedGroupLink();
		String result=bedgrouppage.checkPageTitle();
		Assert.assertEquals(result, "Bed Group List");
	}
	
	@Test()
	public void VerifyFloorLink() throws InterruptedException {
		dashboard_page=login_page.loginWithValidCredentials("superadmin@gmail.com", "Admin@123");
		mainbedpage=dashboard_page.selectBedLink();
		floor=mainbedpage.checkFloorLink();
		String result=floor.checkPageTitle();
		Assert.assertEquals(result, "Floor List");
	}
}
