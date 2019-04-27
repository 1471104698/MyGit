package cn.oy.dao;
import java.util.List;

import cn.oy.pojo.User;

public interface userDao {	
	/**
	 * 查询用户总数
	 */
	int getTotalDao(String dire,String uname,String uid);
	/**
	 * 查询某一页
	 */
	List<User> queryUserDao(int currentPage,int pageSize,String dire,String uname,String uid);	
	/**
	 * 根据用户名和密码查询用户信息
	 * @param uname 用户名
	 * @param upwd	密码 
	 * @return 返回查询到的用户信息
	 */
	User checkUserLogin(String uid,String upwd);	
	/**
	 * 根据用户id修改用户密码
	 * @param newpwd
	 * @param uid
	 * @return
	 */
	int changePwdDao(String newpwd, String uid);	
	/**
	 * 获取所有用户信息
	 * @return
	 */
	List<User> showServiceDao();	
	/**
	 * 注册用户
	 */
	int regServiceDao(User user);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int changeUserinfo(User user);
	/**
	 * 删除用户
	 * @param uid
	 * @return
	 */
	int deleteServiceDao(String uid);	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	int addUserServiceDao(User user);	
	/**
	 * 查询用户
	 * @param uid
	 * @param uname
	 * @return
	 */
	List<User> inquireUserServiceDao(String uid,String uname);	
	/**
	 * 用户分类
	 */
	List<User> classUserServiceDao(String dire);	
	/**
	 * 管理员修改用户信息
	 */
	int modifyUserServiceDao(User user);	
	/**
	 * 找回密码
	 */
	User checkFindServiceDao(String uid, String uname, String tel);	
	/**
	 * 更改用户登录状态
	 */
	int updateStaDao(String uid,String i);
	
	/**
	 * 修改页面得到修改的用户信息
	 */
	User checkUserDao(String uid);

}
