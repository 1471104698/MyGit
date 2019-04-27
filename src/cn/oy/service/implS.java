package cn.oy.service;

import java.util.List;

import cn.oy.dao.implD;
import cn.oy.dao.userDao;
import cn.oy.pojo.User;

public class implS implements UserService{	
//	声明dao对象，后面返回得到查询到的信息给service进行处理	即实现从
//	用户通过登录--得到数据给Servlet--再调service--再调dao--再完成数据库操作--然后将数据通过这个返回到service用一个User对象进行接受处理
	userDao ud=new implD();	
	/**
	 * 查询用户总数
	 */
	@Override
	public int getTotaService(String dire,String uname,String uid) {
		return ud.getTotalDao(dire,uname,uid);
	}	
	/**
	 * 查询某一页
	 */
	//currentPage:当前页 pageSize:页面大小（每页显示的数据条数）
	@Override
	public List<User> queryUserService(int currentPage,int pageSize,String dire,String uname,String uid){
		return ud.queryUserDao(currentPage, pageSize,dire,uname,uid);
	}	
	/**
	 * 登录处理
	 */
	@Override
	public User checkLoginService(String uid, String upwd) {
		return ud.checkUserLogin(uid, upwd);
	}		
	/**
	 * 根据用户ID改密码
	 */
	@Override
	public int changePwdService(String newpwd, String uid) {
		int result=-1;
		result=ud.changePwdDao(newpwd, uid);
		return result;
	}
	/**
	 * 获取所有的用户信息
	 */
	@Override
	public List<User> showService() {
		return ud.showServiceDao();
	}	
	/**
	 * 注册用户
	 */
	public int regService(User user) {
		return ud.regServiceDao(user);
	}
	/**
	 * 修改用户信息
	 */
	@Override
	public int upinfoService(User user) {
		
		return ud.changeUserinfo(user);
	}
	/**
	 * 删除用户
	 */
	@Override
	public int deleteService(String uid) {
		return ud.deleteServiceDao(uid);
	}
	/**
	 * 添加用户
	 */
	@Override
	public int addUserService(User user) {
		return ud.addUserServiceDao(user);
	}
	/**
	 * 查询用户
	 * @param uid
	 * @param uname
	 * @return
	 */
	@Override
	public List<User> inquireUserService(String uid,String uname) {
		return ud.inquireUserServiceDao(uid,uname);
	}
	/**
	 * 用户分类
	 */
	@Override
	public List<User> classUserService(String dire) {
		return ud.classUserServiceDao(dire);
	}
	/**
	 * 管理员修改用户信息
	 */
	@Override
	public int modifyUserService(User user) {
		return ud.modifyUserServiceDao(user);
	}
	/**
	 * 找回密码
	 */
	@Override
	public User checkFindService(String uid, String uname, String tel) {		
		return ud.checkFindServiceDao(uid,uname,tel);
	}	
	/**
	 * 更改用户登录状态
	 */
	@Override
	public int updateSta(String uid,String i) {
		return ud.updateStaDao(uid,i);
	}
	
	/**
	 * 修改页面得到修改的用户信息
	 */
	@Override
	public User cheUserService(String uid) {
		return ud.checkUserDao(uid);
	}

}
