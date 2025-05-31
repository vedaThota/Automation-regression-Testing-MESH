package com.utility;

import org.testng.annotations.DataProvider;

public class DataProviderPack {
	//{"Under Review"}, {"Submitted but not determined complete"}
	@DataProvider (name = "data_provider_SDP")
    public Object[][] dpMethod(){
	 return new Object[][] {{"Under Review"}, {"Submitted but not determined complete"}};
    }
	
	

}
