package cn.oy.service;

import java.util.List;

import cn.oy.pojo.User;

public interface UserService {	
	/**
	 * 查询用户总数
	 */
	int getTotaService(String dire,String uname,String uid);	
	/**
	 * 查询某一页
	 */
	List<User> queryUserService(int currentPage,int pageSize,String dire,String uname,String uid);	
	/**
	 * 返回查询的用户信息 
	 * @param uname
	 * @param upwd
	 * @return  
	 */
	User checkLoginService(String uid,String upwd);
	/*
	 * */
	/**
	 *  修改用户密码
	 * @param newpwd
	 * @param uid
	 * @return
	 */
	int changePwdService(String newpwd, String uid);		
	/**
	 * 获取所有用户信息
	 * @return
	 */
	List<User> showService();
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	int regService(User user);	
	/**
	 * 修改用户信息
	 * @param uid
	 * @param age
	 * @param sex
	 * @param intro
	 * @param intro2 
	 * @return
	 */
	int upinfoService(User user);	
	/**
	 * 删除用户
	 * @param uid
	 * @return
	 */
	int deleteService(String uid);	
	/**
	 * 增加用户
	 */
	int addUserService(User user);	
	/**
	 * 查询用户
	 * @param uid
	 * @param uname
	 * @return
	 */
	List<User> inquireUserService(String uid,String uname);	
	/**
	 * 用户分类
	 */
	List<User> classUserService(String dire);	
	/**
	 * 管理员修改用户信息
	 */
	int modifyUserService(User user);	
	/**
	 * 找回密码
	 */
	User checkFindService(String uid,String uname,String tel);	
	/**
	 * 更改用户登录状态
	 */
	int updateSta(String uid,String i);
	/**
	 * 修改页面得到修改的用户信息
	 */
	User cheUserService(String uid);

}