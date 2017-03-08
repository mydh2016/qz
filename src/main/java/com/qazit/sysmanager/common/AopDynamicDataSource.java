package com.qazit.sysmanager.common;

public class AopDynamicDataSource {

	
	public void getClientDataSource(){
		DynamicDataSourceHolder.setDataSourceType(DataSourceConst.CLIENT);
	}
	
	public void getServerDataSource(){
		DynamicDataSourceHolder.setDataSourceType(DataSourceConst.SERVER);
	}


}
