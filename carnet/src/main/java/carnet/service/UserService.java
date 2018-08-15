package carnet.service;

import java.util.List;

import carnet.bean.User;
import carnet.dao.UserDao;
import carnet.exception.PasswordNotMatchedException;
import carnet.exception.UsernameNotFoundException;

public class UserService {
  	//登录:
      public User login(String username,String password) {
    	     UserDao userDao=new UserDao();
    	     User user=userDao.selectUserByUsername(username);
    	     if(user!=null) {
    	    	 if(password!=null&&password.equals(user.getPassword())) {
    	    		     return user;
    	    	 }else {
    	    		 throw new PasswordNotMatchedException("密码错误");
    	    	 }
    	     }else {
    	    	throw new UsernameNotFoundException("用户名不存在");
    	     }
      }
    //注册:
      public void register(String username,String password,String spassword,String email,String phone) {
    	     UserDao userDao=new UserDao();
    	     User user;
    	     if(password!=null&&password.equals(spassword)) {
    	    	    //如果两次输入密码一致。
    	    	  user=userDao.selectUserByUsername(username);
    	    	  if(user==null) {
    	    	     user=new User();
       	    	     user.setUsername(username);
       	    	     user.setPassword(password);
       	    	     user.setEmail(email);
       	    	     user.setPhone(phone);
       	    	     userDao.addUser(user);  
    	    	  }else {
    	    		  throw new UsernameNotFoundException("用户名已存在");
    	    	  }
    	     }else {
    	    	 throw new PasswordNotMatchedException("两次输入密码不一致");
    	     }
      }
     //查询所有用户
      public List<User> listUser() {
    	    UserDao userDao=new UserDao();
    	    List<User> users=null;
    	    try { 
    	      	
    	       users=userDao.listUsers();
    	    }catch(Exception ex) {
    	    	throw new  RuntimeException("数据查询异常");
    	    }
            return users;
      }
      //更新用户
      public int  updateUser(User user){
    	   UserDao userDao=new UserDao();
    	   int result=-1;
    	   try{
    		   result=userDao.updateUser(user);
    	   }catch(Exception ex){
    		   throw new  RuntimeException("更新失败");
    	   }
    	   return result;
      }
      //新增用户
      public int addUser(User user){
    	  UserDao userDao=new UserDao();
    	  int result=-1;
    	  try{
    		  result=userDao.addUser(user);
    	  }catch(Exception ex){
    		  throw new  RuntimeException("新增失败");
    	  }
    	  return result;
      }
      //删除用户
      public int deleteUserById(int id){
    	   UserDao userDao=new UserDao();
    	   int result=-1;
    	   try{
    		   result=userDao.deleteUserById(id);
    	   }catch(Exception ex){
    		   throw new  RuntimeException("删除失败"); 
    	   }
    	   return result;
      }
      //
      public User selectUserById(int id) {
    	  UserDao userDao=new UserDao();
    	  User user=userDao.selectUserById(id);
    	  return user;
      }
      
}
