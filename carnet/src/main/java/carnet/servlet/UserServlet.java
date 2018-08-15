package carnet.servlet;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dhtmlx.connector.GridConfiguration;
import com.dhtmlx.connector.GridConnector;
import com.dhtmlx.connector.ThreadSafeConnectorServlet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import carnet.bean.Coach;
import carnet.bean.Grid;
import carnet.bean.ResponseResult;
import carnet.bean.TableInfo;
import carnet.bean.User;
import carnet.bean.UserResult;
import carnet.dao.CoachDao;
import carnet.service.UserService;
import carnet.util.MysqlUtil;


public class UserServlet extends ThreadSafeConnectorServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7717164295015877519L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    req.setCharacterEncoding("utf-8");
		String uri=req.getRequestURI();
		String mapping=uri.substring(uri.lastIndexOf("/"));
		if(mapping!=null) {
			if(mapping.equals("/showLogin.do"))
			{
		      resp.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
		      return;
			}
			if(mapping.equals("/login.do")) {
				 UserService userService=new UserService();		
				 try {
				     User user=userService.login(req.getParameter("username"), req.getParameter("password"));
				     HttpSession session=req.getSession();
				     session.setAttribute("user",user);
				     req.getRequestDispatcher("/jsp/index.jsp").forward(req,resp);
				     return;
				 }catch(Exception ex) {
					 req.setAttribute("error",ex.getMessage());
					 req.getRequestDispatcher("/jsp/error.jsp").forward(req,resp);
					 return;
				 }
			}
			if(mapping.equals("/showRegister.do")) {
				  resp.sendRedirect(req.getContextPath()+"/jsp/register.jsp");
			      return;
			}
			if(mapping.equals("/register.do")) {
				  UserService userService=new UserService();	
				  ResponseResult<Void> rr=new ResponseResult<Void>();
				try { 
				 userService.register(req.getParameter("username")
						 ,req.getParameter("password")
						 ,req.getParameter("spassword")
						 ,req.getParameter("email")
						 ,req.getParameter("phone"));
				
				   rr.setState(0);
				   rr.setMsg("注册成功");
				}catch(Exception ex) {
					   ex.printStackTrace();
					   rr.setState(1);
					   rr.setMsg(ex.getMessage());
				}
				//用jackson将返回的数据转成json格式。				
				resp.setContentType("application/json;charset=utf-8");	
				Writer writer=resp.getWriter();	
				ObjectMapper mapper=new ObjectMapper();		      
			    writer.write(mapper.writeValueAsString(rr));
			    return;
			}
			if(mapping.equals("/logout.do")) {
				 //把session重置 
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath()+"/jsp/login.jsp");
				return ;
			}
			if(mapping.equals("/showIndex.do")) {
				req.getRequestDispatcher("/jsp/index.jsp").forward(req,resp);
				return;
			}
			if(mapping.equals("/showAppoint.do")) {
				req.getRequestDispatcher("/jsp/appoint.jsp").forward(req,resp);
				return;
			}
			if(mapping.equals("/showMyappoint.do")) {
				req.getRequestDispatcher("/jsp/myappoint.jsp").forward(req,resp);
				return;
			}
			if(mapping.equals("/showPersoninfo.do")) {
				req.getRequestDispatcher("/jsp/personinfo.jsp").forward(req,resp);
				return;
			}
			System.out.println(mapping);
			
			if(mapping.equals("/sqlQuery.do")){
				  String sql=req.getParameter("sql");
				 
				  Grid grid= MysqlUtil.getGridBySql(sql);
				  ObjectMapper mapper=new ObjectMapper();
				  resp.setCharacterEncoding("utf-8");
				  Writer writer=resp.getWriter();
				  writer.write(mapper.writeValueAsString(grid));
			}
			
			if(mapping.equals("/listTablenames.do")) {
				 //查出数据库名，和表明
				   Connection conn=MysqlUtil.getConn();
				   try {
					   //列出所有的表信息
					 List<String> tableNames=MysqlUtil.getTableInfos(conn,"TABLE");
					  //主树。
					 TableInfo datas=new TableInfo();
					      datas.setId(0);
					      datas.setText("TREE");
					      List<TableInfo> trees=new ArrayList<TableInfo>();
		                //第一个树杈
					    TableInfo firstTree=new TableInfo();
					       firstTree.setText("database");
					       firstTree.setId(1);
					       firstTree.setChild(1);
					          //挂到树上。
					       trees.add(firstTree);
					       
					 
					 List<TableInfo> tableItems=new ArrayList<TableInfo>();
					 for(int i=0;i<tableNames.size();i++) {
						  TableInfo tableItem=new TableInfo();
						  tableItem.setId(i+1);
						  tableItem.setText(tableNames.get(i));
						  tableItems.add(tableItem);
					 }					 
					 firstTree.setItem(tableItems);
					    //设置最终的树。
					 datas.setItem(trees);					 
					 ObjectMapper mapper=new ObjectMapper();
					 String json=mapper.writeValueAsString(datas);
					 System.out.println("result:"+json);	
					 Writer writer=resp.getWriter();
					 writer.write(json);
				   } catch (Exception e) {
					// TODO Auto-generated catch block
					 e.printStackTrace();
				   }
			}
			if(mapping.equals("/getStructure.do")){
				
				String tableName=req.getParameter("tableName");
				 Connection conn=MysqlUtil.getConn();
				 Grid grid=MysqlUtil.getTableInformation(conn,tableName);
				 ObjectMapper mapper=new ObjectMapper();
				 String json=mapper.writeValueAsString(grid);
				 Writer writer=resp.getWriter();
				 writer.write(json);
			}
			
			if(mapping.equals("/listData.do")){
				    String tableName=req.getParameter("tableName");
			      	Writer writer =resp.getWriter();
			      	Grid grid=MysqlUtil.TableToGrid(tableName);
			      	ObjectMapper mapper=new ObjectMapper();
			      	System.out.println(mapper.writeValueAsString(grid));
			      	writer.write(mapper.writeValueAsString(grid));
			}
		
			
			if(mapping.equals("/listUser.do")) {
				 configure(req,resp);
			}
			if(mapping.equals("/insertUser.do")){
				  
				  UserService userService=new UserService();
				  User user=new User();
				  String username=req.getParameter("username");
				  String password=req.getParameter("password");
				  String phone=req.getParameter("phone");
				  String email=req.getParameter("email");
				 
			      user.setUsername(username);
			      user.setPassword(password);
			      user.setPhone(phone);
			      user.setEmail(email);
			      user.setGender(0);
				  userService.addUser(user);
				  return;
			}
		    if(mapping.equals("/updateUser.do")){
//				//从前台传送过来的ids 是不固定的，可能是一个，可能是多个。
//				UserService  userService=new UserService();	
//				String id=req.getParameter("ids");
//			    String [] ids=id.split("[,]");   
//			    User user=new User();
//				for(int i=0;i<ids.length;i++){  
//				  String username=req.getParameter(ids[i]+"_username");
//				  String password=req.getParameter(ids[i]+"_password");
//				  String email=req.getParameter(ids[i]+"_email");
//				  String phone=req.getParameter(ids[i]+"_phone");
//				  int gender=0;
//			      user.setId(Integer.parseInt(ids[i]));
//			      user.setUsername(username);
//			      user.setPassword(password);
//			      user.setPhone(phone);
//			      user.setEmail(email);
//			      user.setGender(gender);
//			      userService.updateUser(user);
//				} 
		    	  System.out.println(req.getParameter("gr_id"));
		    	  
				  return;
			}
			if(mapping.equals("/deleteUser.do")){
				   String id=req.getParameter("id");
				   UserService userService=new UserService();
				   userService.deleteUserById(Integer.parseInt(id));
				   return;
			}
			if(mapping.equals("/listCoach.do")) {
				  CoachDao coachDao=new CoachDao();
		    	  List<Coach> coaches=coachDao.listCoaches();
		    	  List<UserResult> userResults=new ArrayList<UserResult>();
		    	  List<String> results=null;
		    	  for(Coach coach:coaches) {
		    		   UserResult userResult=new UserResult();
		    		   results=new ArrayList<String>();		   
		    		   userResult.setId(coach.getId());
		    		   results.add(coach.getUsername());
		    		   results.add(coach.getPassword());
		    		   results.add(coach.getName());
		    		   userResult.setData(results);
		    		   userResults.add(userResult);
		    	  }
		    	  ObjectMapper mapper=new ObjectMapper();
		    	  try {
					String s=mapper.writeValueAsString(userResults);
					s="{rows:"+s+"}";
					resp.setContentType("application/json;charset=utf-8");	
					Writer writer=resp.getWriter();
					System.out.println(s);
					writer.write(s);
					return;
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(mapping.equals("/insertCoach.do")){
				  
				  CoachDao coachDao=new CoachDao();
				  Coach coach=new Coach();
				  String username=req.getParameter("username");
				  String password=req.getParameter("password");
				  String name=req.getParameter("name");
				 				 
				  coach.setUsername(username);
				  coach.setPassword(password);
				  coach.setName(name);		   
				  coachDao.addCoach(coach);
				  return;
			}
			if(mapping.equals("/updateCoach.do")){
//				//从前台传送过来的ids 是不固定的，可能是一个，可能是多个。
//				CoachDao coachDao=new CoachDao();	
//				String id=req.getParameter("ids");
//			    String [] ids=id.split("[,]");   
//			    Coach coach=new Coach();
//				for(int i=0;i<ids.length;i++){  
//				  String username=req.getParameter(ids[i]+"_username");
//				  String password=req.getParameter(ids[i]+"_password");
//				  String name=req.getParameter(ids[i]+"_name");
//				
//			      coach.setId(Integer.parseInt(ids[i]));
//			      coach.setUsername(username);
//			      coach.setPassword(password);
//			      coach.setName(name);
//			     
//			      coachDao.updateCoach(coach);
//				} 
//				  //数据列的取值，规则是id+'_'+列ID;			
//				  req.getRequestDispatcher("/listCoach.do").forward(req,resp);
//				  return;
			}
			if(mapping.equals("/deleteCoach.do")){
				    String id=req.getParameter("id");
					CoachDao coachDao=new CoachDao();	
				    coachDao.deleteCoachById(Integer.parseInt(id));
				    return;
			}
			
			
		}		
	}
   
	@Override
	protected void configure(HttpServletRequest req, HttpServletResponse res) {
		
		// TODO Auto-generated method stub
		    String tableName=req.getParameter("tableName");		    
		    System.out.println("tableName:"+tableName);
		    Connection conn=MysqlUtil.getConn();
		    GridConnector c=new GridConnector(conn);
		    
		    //配置列名
		    c.dynamic_loading(100);  //动态加载
		    c.servlet(req, res);		    
//		    GridConfiguration  config=new GridConfiguration();		    
//		    try {
//		      config.addHeader(new String [] {"c1","c2","c3","c4","c5"});
//		      
//		    }catch(Exception ex) {
//		    	ex.printStackTrace();
//		    }
//		    c.setConfiguration(config);	
		    c.render_table("user","id","username,password,email,phone,gender");
		  
	}   
}
