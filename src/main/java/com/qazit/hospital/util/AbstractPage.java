package  com.qazit.hospital.util;



public  class AbstractPage {
	
	protected int pageSize=10;//页面大小 
	
	protected int currentPage;//当前页
	
	protected boolean isPage = true;
	
	protected int totalCount;//总数
	
	public int firstRecord;//起始记录
	
	public int lastRecord;//终止记录
	
	public int getFirstRecord() {
		return ((currentPage - 1) * pageSize) > 0 ? ((currentPage - 1) * pageSize): 0 ;
	}

	public void setFirstRecord(int firstRecord) {
		this.firstRecord = firstRecord;
	}

	public int getLastRecord() {
		return ((currentPage) * pageSize) > 0 ? ((currentPage) * pageSize) : pageSize ;
	}

	public void setLastRecord(int lastRecord) {
		this.lastRecord = lastRecord;
	}



	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	

	public boolean isPage() {
		return isPage;
	}

	public void setPage(boolean isPage) {
		this.isPage = isPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	/**
	 * 返回Page对象自身的setPageSize函数,可用于连续设置。
	 */
	public AbstractPage pageSize(final int thePageSize) {
		setPageSize(thePageSize);
		return this;
	}

	/**
	 * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置,序号从0开始.
	 */
	public int getFirst() {
		return ((currentPage - 1) * pageSize) > 0 ? ((currentPage - 1) * pageSize) : 0 ;
	}

}
