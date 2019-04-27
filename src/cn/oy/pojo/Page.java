package cn.oy.pojo;

import java.util.List;

public class Page {
		//当前页面 currentPage
		private int currentPage;
		//页面大小 pageSize
		private int pageSize;
		//总数居 totalCount
		private int totalCount;
		//总页数 totalPage
		private int totalPage;
		//当前页的数据集合 users
		private List<User> users;
		
		public Page() {
		}
		public Page(int currentPage, int pageSize, int totalCount, int totalPage, List<User> users) {
			super();
			this.currentPage = currentPage;
			this.pageSize = pageSize;
			this.totalCount = totalCount;
			this.totalPage = totalPage;
			this.users = users;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getPageSize() {
			return pageSize;
		}
		

		public void setPageSize(int pageSize) {
			this.pageSize=pageSize ;
			//对于这个显示有多少页数，可以通过传进的总数居和页面大小来自动计算
//			ps:注意顺序，如果先set的是页面大小，而总数据没得到，则   总数据/页面大小   会造成空指针
//			总数居%页面大小==0？：总数据/页面大小：总数据/页面大小+1；
			if(this.totalCount/this.pageSize==0) {
				this.totalPage=0;				
			}else {
			this.totalPage = this.totalCount%this.pageSize==0?(this.totalCount/this.pageSize)-1:(this.totalCount/this.pageSize);
			}
		}
		public int getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}
		public int getTotalPage() {
			return totalPage;
		}

		public void setTotalPage(int totalPage) {
			this.totalPage =totalPage;
	}
		public List<User> getUsers() {
			return users;
		}
		public void setUsers(List<User> users) {
			this.users = users;
		}
}

