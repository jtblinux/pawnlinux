package carnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import carnet.bean.User;
import carnet.util.MysqlUtil;

public class UserDao {
	   //新增用户。
       public int  addUser(User user) {
    	     Connection conn=MysqlUtil.getConn();
    	     String sql="insert into user(username,password,gender,email,phone) values(?,?,0,?,?)";
    	     int result=-1;
    	     PreparedStatement ps=null;
    	     try {
				ps=conn.prepareStatement(sql);
				ps.setString(1,user.getUsername());
				ps.setString(2,user.getPassword());
				ps.setString(3,user.getEmail());
				ps.setString(4,user.getPhone());
				result=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw  new RuntimeException("新增用户异常");
			}finally {
				MysqlUtil.close(ps, conn,null);
			}
    	   return result;
       }
       //根据用户名查询用户,（防止用户名重复）。
       public User selectUserByUsername(String username) {
    	   Connection conn=MysqlUtil.getConn();
    	   String sql="select * from user where username=?";
    	   User user=null;
    	   PreparedStatement ps=null;
    	   ResultSet rs=null;
    	   try {
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, username);
			  rs=ps.executeQuery();
			  while(rs.next()) {
				   user=new User();
				   user.setId(rs.getInt(rs.findColumn("id")));
				   user.setUsername(username);
				   user.setPassword(rs.getString(rs.findColumn("password")));
				   user.setGender(rs.getInt(rs.findColumn("gender")));
				   user.setEmail(rs.getString(rs.findColumn("email")));
				   user.setPhone(rs.getString(rs.findColumn("phone")));
			  }
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   }finally {
			   MysqlUtil.close(ps, conn, rs);
		   }
    	   return user;
        }
       //根据用户id查找用户。
       public User selectUserById(int id) {
    	   Connection conn=MysqlUtil.getConn();
    	   String sql="select * from user where id=?";
    	   User user=null;
    	   PreparedStatement ps=null;
    	   ResultSet rs=null;
    	   try {
			  ps=conn.prepareStatement(sql);
			  rs=ps.executeQuery();
			  while(rs.next()) {
				   user=new User();
				   user.setId(id);
				   user.setUsername(rs.getString(rs.findColumn("username")));
				   user.setPassword(rs.getString(rs.findColumn("password")));
				   user.setGender(rs.getInt(rs.findColumn("gender")));
				   user.setEmail(rs.getString(rs.findColumn("email")));
				   user.setPhone(rs.getString(rs.findColumn("phone")));
			  }
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			    e.printStackTrace();
		   }finally {
			   MysqlUtil.close(ps, conn, rs);
		   }
    	   return user;
        }
       //查询所有的用户。
       public List<User> listUsers(){
    	   Connection conn=MysqlUtil.getConn();
    	   String sql="select * from user";
    	   List<User> users=null;
    	   PreparedStatement ps=null;
    	   ResultSet rs=null;
    	   try {
 			  ps=conn.prepareStatement(sql);
 			  rs=ps.executeQuery();
 			  users=new ArrayList<User>();
 			  while(rs.next()) {
 				   User user=new User();
 				   user.setId(rs.getInt(rs.findColumn("id")));
 				   user.setUsername(rs.getString(rs.findColumn("username")));
 				   user.setPassword(rs.getString(rs.findColumn("password")));
 				   user.setGender(rs.getInt(rs.findColumn("gender")));
 				   user.setEmail(rs.getString(rs.findColumn("email")));
 				   user.setPhone(rs.getString(rs.findColumn("phone")));
 				   users.add(user);
 			  }
 		   } catch (SQLException e) {
 			// TODO Auto-generated catch block
 			   e.printStackTrace();
 		   }finally {
 			   MysqlUtil.close(ps, conn, rs);
 		   }
     	   return users;
       }
        //新增用户
       public int updateUser(User user){
    	   Connection conn=MysqlUtil.getConn();
    	   String sql="update user set username=?,password=?,email=?,phone=?,gender=? where id=?";
    	   PreparedStatement ps=null;
    	   int result=-1;
    	   try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getEmail());
			ps.setString(4,user.getPhone());
			ps.setInt(5,user.getGender());
			ps.setInt(6,user.getId());
			result=ps.executeUpdate();
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
    	   return result;
       }
       //删除用户
       public int deleteUserById(int id){
    	   Connection conn=MysqlUtil.getConn();
    	   String sql="delete from user where id=?";
    	   PreparedStatement ps=null;
    	   int result=-1;
    	   try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			result=ps.executeUpdate();
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
    	    return result;
       }
       
}
