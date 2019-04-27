package cn.oy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Util.dbUtil;
import cn.oy.pojo.User;

public class implD implements userDao{
		dbUtil du=new dbUtil();
		Connection con=null;
		PreparedStatement psta=null;
		ResultSet rs=null;
		User u=null;
		
	
		
		/**
		 * 查询用户总数
		 */
	public int getTotalDao(String dire,String uname,String uid) {
		int count=-1;
		try {			
			con=du.getCon();
			String sql="select sum(1) from t_user";		//sum取的第一个字段非null的，count包括null的
			if(uname!=null||uid!=null) {
				if(uname!=null) {
					sql+=" where uname like ?";
				}else if(uid!=null){
					sql+=" where uid=?";
				}
				if(dire!=null) {
					sql+=" where dire=?";
				}
			}else {
				if(dire!=null) {
					sql+=" where dire=?";
				}
			}		
			System.out.println("总数这里用户名为="+uname);
			psta=con.prepareStatement(sql);
					if(uname!=null||uid!=null) {
					if(uname!=null) {
						psta.setString(1, "%"+uname+"%");						
					}else if(uid!=null){
						int id=Integer.parseInt(uid);
						psta.setInt(1, id);
					}
					if(dire!=null) {
						psta.setString(2, dire);
					}
					}else {
						if(dire!=null) {
						psta.setString(1, dire);
						}
					}			
			rs=psta.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
				rs.close();
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		return count;
	}
		

	/**
	 * 查询某一页
	 * 
	 * 第1页：select *from t_user limit 0,10;
	 * 第2页：select *from t_user limit 10,10;
	 * 第3页：select *from t_user limit 20,10;
	 * 第n页：select *from t_user limit n*10,10;
	 * select *from t_user limit 页数*页面大小，页面大小
	 */
	
	@Override
	public List<User> queryUserDao(int currentPage, int pageSize,String dire,String uname,String uid) {
		List<User> list=new ArrayList<>();
		
		try {			
			con=du.getCon();
			String sql="select * from t_user";
			if(uname==null&&uid==null) {
			if(dire!=null) {
			sql+=" where dire=?";		//sum取的第一个字段非null的，count包括null的
			}
			}else {
				if(uname!=null) {
					sql+=" where uname like ?";
				}else{
					sql+=" where uid=?";
				}
			}
			sql+=" limit ?,?";			
			psta=con.prepareStatement(sql);
			if(uname==null&&uid==null) {
			if(dire!=null) {
				psta.setString(1, dire);
				psta.setInt(2, currentPage*pageSize );
				psta.setInt(3, pageSize);
			}else {
			psta.setInt(1, currentPage*pageSize );
			psta.setInt(2, pageSize);
				}
			}else {
				if(uname!=null) {
					psta.setString(1, "%"+uname+"%");		
				}else{
					psta.setString(1, uid);
				}			
					psta.setInt(2, currentPage*pageSize );
					psta.setInt(3, pageSize);
		}		
//			System.out.println("页数这里方向为:  "+dire);
			System.out.println("总数这里用户名为="+uname);
			rs=psta.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getString("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));				
				u.setDire(rs.getString("dire"));
				u.setGrade(rs.getString("grade"));
				u.setStatus(rs.getString("sta"));
				u.setIntro(rs.getString("intro"));
				u.setTel(rs.getString("tel"));
				list.add(u);	
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
				rs.close();
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		return list;
	}
		
		
		/**
		 * 根据用户名和密码查询用户信息
		 */
	@Override
	public User checkUserLogin(String uid, String upwd) {
			
			try {
				con=du.getCon();
				//创建Sql命令
				String sql="select *from t_user where uid =? and upwd=MD5(?)";	// 
				//创建Sql命令对象
				psta=(PreparedStatement) con.prepareStatement(sql);
				//给占位符赋值
				psta.setString(1, uid);
				psta.setString(2, upwd);
				//执行，执行多少条语句，返回值则为多少
				rs=psta.executeQuery();
				System.out.println("调用了登录校验方法");
				//遍历执行结果
				if(rs.next()) {   //只有一个，因此不需要用while，用if 	
					//给变量赋值
					u=new User();
					u.setId(rs.getString("uid"));
					u.setUname(rs.getString("uname"));
					u.setUpwd(rs.getString("upwd"));
					u.setAge(rs.getInt("age"));
					u.setSex(rs.getString("sex"));
					u.setGrade(rs.getString("grade"));
					u.setDire(rs.getString("dire"));
					u.setIntro(rs.getString("intro"));
					u.setTel(rs.getString("tel"));
					u.setStatus(rs.getString("sta"));
				}
			} catch (SQLException e) {	
				e.printStackTrace();
			}catch(Exception e2) {
				e2.printStackTrace();
			}finally {
				try {	//关闭资源
					rs.close();
					du.close(psta, con);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}catch(Exception e3) {
					e3.printStackTrace();
				}
			}
			//返回
			return u;
		}
	

	
	

	
	/**
	 * 根据用户id修改用户密码
	 * 
	 */
	@Override
	public int changePwdDao(String newpwd, String uid) {
			int result=-1;
		try {
			
			con=du.getCon();
			String sql="update t_user set upwd=MD5(?) where uid=?";
			psta=con.prepareStatement(sql);
			psta.setString(1, newpwd);
			psta.setString(2, uid);
			result=psta.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
			
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * 获取所有用户信息
	 */
	@Override
	public List<User> showServiceDao() {
	
		List<User> list=null;	//创建一个容器存放User
		try {
			con=du.getCon();
			//创建Sql命令
			String sql="select *from t_user";	// 得到所有用户
			//创建Sql命令对象
			psta=con.prepareStatement(sql);
			//给占位符赋值
			//执行，执行多少条语句，返回值则为多少
			
			rs=psta.executeQuery();			
			list=new ArrayList<>();		
			//遍历执行结果
			while(rs.next()) {   //只有一个，因此不需要用while，用if 	
				//给变量赋值
				u=new User();		//创建User把每个用户信息存进去
				u.setId(rs.getString("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getString("sex"));
				u.setGrade(rs.getString("grade"));
				u.setIntro(rs.getString("intro"));
				u.setDire(rs.getString("dire"));
				u.setTel(rs.getString("tel"));
				u.setStatus(rs.getString("sta"));
				System.out.println(u);
				list.add(u);		//再把存了每个用户信息的User放进list里返回就能得到每个用户的信息并在页面显示
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
				rs.close();
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		//返回
		return list;
	}

	
	/**
	 * 用户注册
	 */
	@Override
	public int regServiceDao(User user) {
		int result=-1;
		try {
			con=du.getCon();
			//创建Sql命令
			String sql="insert into t_user (uid,uname,upwd,sex,age,grade,intro,dire,tel,id,sta) values(?,?,MD5(?),?,?,?,?,?,?,default,0)";	//注册用户
			//创建Sql命令对象
			psta=con.prepareStatement(sql);
			//给占位符赋值
			psta.setString(1, user.getId());
			psta.setString(2, user.getUname());
			psta.setString(3, user.getUpwd());
			psta.setString(4, user.getSex());
			psta.setInt(5, user.getAge());
			psta.setString(6, user.getGrade());
			psta.setString(7, user.getDire());
			psta.setString(8, user.getIntro());
			psta.setString(9, user.getTel());
			//执行，执行多少条语句，返回值则为多少						
			result=psta.executeUpdate();
		}catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 用户个人修改信息
	 */
	@Override
	public int changeUserinfo(User user) {
		int result=-1;
		try {
			con=du.getCon();
			//创建Sql命令
			String sql="update t_user set uname=?,age=?,sex=?,grade=?,intro=?,dire=?,tel=? where uid=?";	
			//创建Sql命令对象
			psta=con.prepareStatement(sql);
			//给占位符赋值
			psta.setString(1, user.getUname());
			psta.setInt(2, user.getAge());
			psta.setString(3, user.getSex());
			psta.setString(4, user.getGrade());
			psta.setString(5, user.getIntro());
			psta.setString(6, user.getDire());
			psta.setString(7, user.getTel());
			psta.setString(8, user.getId());
			//执行，执行多少条语句，返回值则为多少						
			result=psta.executeUpdate();
		}catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * 删除用户
	 */
	@Override
	public int deleteServiceDao(String uid) {
			int result=-1;
			try {
				con=du.getCon();
				//创建Sql命令
				String sql="delete from t_user  where uid=?";	
				//创建Sql命令对象
				psta=con.prepareStatement(sql);
				//给占位符赋值
				psta.setString(1, uid);
				//执行，执行多少条语句，返回值则为多少						
				result=psta.executeUpdate();
			}catch (SQLException e) {	
				e.printStackTrace();
			}catch(Exception e2) {
				e2.printStackTrace();
			}finally {
				try {	//关闭资源
					du.close(psta, con);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}catch(Exception e3) {
					e3.printStackTrace();
				}
			}
			
			return result;
	}

	/**
	 * 添加用户
	 */
	@Override
	public int addUserServiceDao(User user) {
		int result=-1;
		try {
			con=du.getCon();
			//创建Sql命令
			String sql="insert into t_user (uid,uname,upwd,sex,age,grade,intro,dire,tel,id,sta) values(?,?,MD5(?),?,?,?,?,?,?,default,0)";	//添加用户
			//创建Sql命令对象
			psta=con.prepareStatement(sql);
			//给占位符赋值
			psta.setString(1, user.getId());
			psta.setString(2, user.getUname());
			psta.setString(3, user.getUpwd());
			psta.setString(4, user.getSex());
			psta.setInt(5, user.getAge());
			psta.setString(6, user.getGrade());
			psta.setString(7, user.getDire());
			psta.setString(8, user.getIntro());
			psta.setString(9, user.getTel());

			//执行，执行多少条语句，返回值则为多少						
			result=psta.executeUpdate();
		}catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源

				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 查询用户①
	 */
	@Override
	public List<User> inquireUserServiceDao(String uid,String uname) {
		
		String sql="select * from t_user where";
		List<User> list=new ArrayList<>();
		try {			
			con=du.getCon();
			if(uid!=null) {
			sql+=" uid=?";
			}else {
			sql+=" uname like ?";		
			}
			psta=con.prepareStatement(sql);	
			
			if(uid!=null) {
			int id=Integer.parseInt(uid);
			psta.setInt(1, id);
			}else {
			psta.setString(1, "%"+uname+"%");
			}
			rs=psta.executeQuery();
			System.out.println("查询结果为：");
			System.out.println("语句为："+sql);
			while(rs.next()) {
				u=new User();
				u.setId(rs.getString("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getString("sex"));
				u.setGrade(rs.getString("grade"));
				u.setIntro(rs.getString("intro"));
				u.setDire(rs.getString("dire"));
				u.setTel(rs.getString("tel"));
				u.setStatus(rs.getString("sta"));
				System.out.println("查询结果为："+u);
				list.add(u);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
				rs.close();
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		
		return list;
	}

	/**
	 * 用户分类
	 */
	@Override
	public List<User> classUserServiceDao(String dire) {
		
		List<User> list=new ArrayList<>();
		try {			
			con=du.getCon();
			String sql="select *from t_user where dire=?";
			psta=con.prepareStatement(sql);	
			psta.setString(1, dire);
			rs=psta.executeQuery();
			System.out.println("查询结果为：");
			while(rs.next()) {
				System.out.println("调用了1");
				u=new User();
				u.setId(rs.getString("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpwd(rs.getString("upwd"));
				u.setAge(rs.getInt("age"));
				u.setSex(rs.getString("sex"));
				u.setGrade(rs.getString("grade"));
				u.setIntro(rs.getString("intro"));
				u.setDire(rs.getString("dire"));
				u.setTel(rs.getString("tel"));
				u.setStatus(rs.getString("sta"));
				System.out.println("查询结果为："+u);
				list.add(u);
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
				rs.close();
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		
		return list;
	}

	
	/**
	 * 管理员修改用户信息
	 */
	@Override
	public int modifyUserServiceDao(User user) {
		int result=-1;
		try {
			con=du.getCon();
			//创建Sql命令
			String sql="update t_user set age=?,sex=?,grade=?,intro=?,dire=?,uname=?,tel=? where uid=?";	
			//创建Sql命令对象
			psta=con.prepareStatement(sql);
			//给占位符赋值
			
			psta.setInt(1, user.getAge());
			psta.setString(2, user.getSex());
			psta.setString(3, user.getGrade());
			psta.setString(4, user.getIntro());
			psta.setString(5, user.getDire());
			psta.setString(6, user.getUname());
			psta.setString(7, user.getTel());
			psta.setString(8, user.getId());
			//执行，执行多少条语句，返回值则为多少						
			result=psta.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		
		return result;
	}

	
	/**
	 * 找回密码
	 * @throws Exception 
	 */
	@Override
	public User checkFindServiceDao(String uid, String uname, String tel){
		
		try {
		con=du.getCon();
		String sql="select * from t_user where uid=? and uname=? and tel=?";
		psta=con.prepareStatement(sql);
		
		psta.setString(1, uid);
		psta.setString(2, uname);
		psta.setString(3, tel);
		
		rs=psta.executeQuery();
		if(rs.next()) {
			u=new User();
			u.setId(rs.getString("uid"));
			u.setUname(rs.getString("uname"));
			u.setUpwd(rs.getString("upwd"));
			u.setAge(rs.getInt("age"));
			u.setSex(rs.getString("sex"));
			u.setGrade(rs.getString("grade"));
			u.setIntro(rs.getString("intro"));
			u.setDire(rs.getString("dire"));
			u.setTel(rs.getString("tel"));		
			u.setStatus(rs.getString("sta"));
			System.out.println(u);
		}
		}catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
				rs.close();
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}
		return u;
	}

	/**
	 * 更改登录状态
	 */
	@Override
	public int updateStaDao(String uid, String i) {
		int result=-1;
		try {
			con=du.getCon();
			//创建Sql命令
			String sql="update t_user set sta=? where uid=?";	
			//创建Sql命令对象
			psta=con.prepareStatement(sql);
			//给占位符赋值
			psta.setString(1, i);
			psta.setString(2, uid);
			
			//执行，执行多少条语句，返回值则为多少						
			result=psta.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		}catch(Exception e2) {
			e2.printStackTrace();
		}finally {
			try {	//关闭资源
				du.close(psta, con);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}catch(Exception e3) {
				e3.printStackTrace();
			}
		}		
		return result;
	}
	
	/**
	 * 修改页面得到修改的用户信息
	 */
	@Override
	public User checkUserDao(String uid) {
			
			try {
				con=du.getCon();
				//创建Sql命令
				String sql="select *from t_user where uid =?";	// 
				//创建Sql命令对象
				psta=(PreparedStatement) con.prepareStatement(sql);
				//给占位符赋值
				psta.setString(1, uid);
				
				//执行，执行多少条语句，返回值则为多少
				rs=psta.executeQuery();
				System.out.println("调用了登录校验方法");
				//遍历执行结果
				if(rs.next()) {   //只有一个，因此不需要用while，用if 	
					//给变量赋值
					u=new User();
					u.setId(rs.getString("uid"));
					u.setUname(rs.getString("uname"));
					u.setUpwd(rs.getString("upwd"));
					u.setAge(rs.getInt("age"));
					u.setSex(rs.getString("sex"));
					u.setGrade(rs.getString("grade"));
					u.setDire(rs.getString("dire"));
					u.setIntro(rs.getString("intro"));
					u.setTel(rs.getString("tel"));
					u.setStatus(rs.getString("sta"));
				}
			} catch (SQLException e) {	
				e.printStackTrace();
			}catch(Exception e2) {
				e2.printStackTrace();
			}finally {
				try {	//关闭资源
					rs.close();
					du.close(psta, con);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}catch(Exception e3) {
					e3.printStackTrace();
				}
			}
			//返回
			return u;
		}
	
	 
}
	

