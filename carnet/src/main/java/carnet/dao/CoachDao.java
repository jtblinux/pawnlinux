package carnet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import carnet.bean.Coach;

import carnet.util.MysqlUtil;

public class CoachDao {
	  //新增用户。
    public int  addCoach(Coach coach) {
 	     Connection conn=MysqlUtil.getConn();
 	     String sql="insert into coach(username,password,name) values(?,?,?)";
 	     int result=-1;
 	     PreparedStatement ps=null;
 	     try {
				ps=conn.prepareStatement(sql);
				ps.setString(1,coach.getUsername());
				ps.setString(2,coach.getPassword());
				ps.setString(3,coach.getName());			
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
  
    
    //查询所有的用户。
    public List<Coach> listCoaches(){
 	   Connection conn=MysqlUtil.getConn();
 	   String sql="select * from coach";
 	   List<Coach> coaches=null;
 	   PreparedStatement ps=null;
 	   ResultSet rs=null;
 	   try {
			  ps=conn.prepareStatement(sql);
			  rs=ps.executeQuery();
			  coaches=new ArrayList<Coach>();
			  while(rs.next()) {
				   Coach coach=new Coach();
				   coach.setId(rs.getInt(rs.findColumn("id")));
				   coach.setUsername(rs.getString(rs.findColumn("username")));
				   coach.setPassword(rs.getString(rs.findColumn("password")));
				   coach.setName(rs.getString(rs.findColumn("name")));
				   coaches.add(coach);
			  }
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   }finally {
			   MysqlUtil.close(ps, conn, rs);
		   }
  	   return coaches;
    }
     //新增用户
    public int updateCoach(Coach coach){
 	   Connection conn=MysqlUtil.getConn();
 	   String sql="update coach set username=?,password=?,name=? where id=?";
 	   PreparedStatement ps=null;
 	   int result=-1;
 	   try {
			ps=conn.prepareStatement(sql);
			ps.setString(1,coach.getUsername());
			ps.setString(2,coach.getPassword());
			ps.setString(3,coach.getName());
			ps.setInt(4,coach.getId());
			result=ps.executeUpdate();
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
 	   return result;
    }
    //删除用户
    public int deleteCoachById(int id){
 	   Connection conn=MysqlUtil.getConn();
 	   String sql="delete from coach where id=?";
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
