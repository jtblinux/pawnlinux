package carnet.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

import com.fasterxml.jackson.databind.ObjectMapper;

import carnet.bean.Grid;
import carnet.bean.GridHeader;
import carnet.bean.GridRow;

public class MysqlUtil {
	   
       private static String driver;
       private static String url;
       private static String username;
       private static String pwd;
       private static BasicDataSource pool;
       static {
    	   InputStream in=MysqlUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
    	   Properties prop=new Properties();
    	   try {
			prop.load(in);
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
    	   driver=prop.getProperty("driver");
    	   url=prop.getProperty("url");
    	   username=prop.getProperty("username");
    	   pwd=prop.getProperty("pwd");
    	   pool=new BasicDataSource();
    	   pool.setDriverClassName(driver);
    	   pool.setUrl(url);
    	   pool.setUsername(username);
    	   pool.setPassword(pwd);
       }
       public static Connection getConn() {
    	   
    	    try {
				return pool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    return null;
       }
       public static void close(Statement stat,Connection conn,ResultSet rs) {
    	   if(stat!=null) {   		   
    		   try {
				stat.close();
			   } catch (SQLException e) {
			  	// TODO Auto-generated catch block
			  	e.printStackTrace();
			   }
    	   }
    	   if(conn!=null) {
    		   try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   }
    	   if(rs!=null) {
    		   try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	   }
       }
       public static void main(String[] args) {
    	   
    	   Grid grid= MysqlUtil.getGridBySql("select  id,username,password from user");
		   System.out.println(grid);     
	   }
       public static Grid getTableInformation(Connection conn,String tableName){
    	    DatabaseMetaData dbMetaData=null; 
    	    Grid grid=new Grid();
    	    String [] headers={"COLUMN_NAME","TYPE_NAME","COLUMN_SIZE","DECIMAL_DIGITS","NULLABLE"};
    	    List<GridHeader> gridHeaders=new ArrayList<GridHeader>();
    	    for(int i=0;i<headers.length;i++){
    	    	GridHeader gridHeader=new GridHeader();
    	    	gridHeader.setValue(headers[i]);
    	    	gridHeaders.add(gridHeader);
    	    }
    	    
    	    List<GridRow> gridRows=new ArrayList<GridRow>();
    	    
    	     try {
			  dbMetaData=conn.getMetaData();		 
    	      ResultSet rs=dbMetaData.getColumns(null, "%", tableName,
						"%");
    	      int count=0;
    	      while(rs.next()){
    	    	  count++;
    	    	  GridRow gridRow=new GridRow();
    	    	  List<String>   data=new ArrayList<String>();
    	    	  gridRow.setId(count);
    	    	  for(int i=0;i<headers.length;i++){
    	    	         data.add(rs.getString(headers[i])!=null?rs.getString(headers[i]):"null");
    	    	  } 	
    	    	  gridRow.setData(data);
    	    	  gridRows.add(gridRow);
    	      }
    	     
    	      grid.setHead(gridHeaders);
    	      grid.setRows(gridRows);
    	      
    	     } catch (Exception e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			 }
    	     return grid;
       }
       
       public  static void getTableInformation(Connection conn) throws SQLException {
    	     DatabaseMetaData dbMetaData=conn.getMetaData();
    	     ResultSet rs=dbMetaData.getTables(null, null, null,new String [] {"TABLE","VIEW"});
    	     
    	     while(rs.next()) {
    	    	 if (rs.getString(4) != null
    						&& (rs.getString(4).equalsIgnoreCase("TABLE") || rs
    								.getString(4).equalsIgnoreCase("VIEW"))) {
    					String tableName = rs.getString(3).toLowerCase();
    					System.out.print(tableName + "\n");
    					// 根据表名提前表里面信息：
    					ResultSet colRet = dbMetaData.getColumns(null, "%", tableName,
    							"%");
    					while (colRet.next()) {
    						String columnName = colRet.getString("COLUMN_NAME");
    						String columnType = colRet.getString("TYPE_NAME");
    						int datasize = colRet.getInt("COLUMN_SIZE");
    						int digits = colRet.getInt("DECIMAL_DIGITS");
    						int nullable = colRet.getInt("NULLABLE");
    						System.out.println(columnName + " " + columnType + " "+
    						datasize + " " + digits + " " + nullable);
    					}	 
    				}
    	     }
       }
       public static List<String> getTableInfos(Connection conn,String infoType) throws Exception{
    	   DatabaseMetaData dbMetaData=conn.getMetaData();
  	       ResultSet rs=dbMetaData.getTables(null, null, null,new String [] {infoType});
  	       List<String> infos=new ArrayList<String>();
  	       while(rs.next()) {
  	    	 if (rs.getString(4) != null
  						&& rs.getString(4).equalsIgnoreCase(infoType) ) {
  					String tableName = rs.getString(3).toLowerCase();
  					System.out.print(tableName + "\n");
  				    infos.add(tableName);
  				}
  	        }
  	       return infos;       
       }
       public static  String [] getColumns(Connection conn,String tableName) throws SQLException {
    	   DatabaseMetaData dbMetaData=conn.getMetaData();
    	   List<String> columns=new ArrayList<String>();
    	   ResultSet rs=dbMetaData.getColumns(null, "%", tableName,
				"%");
    	   while(rs.next()) {
    		   columns.add(rs.getString("COLUMN_NAME"));
    	   }
    	   
    	   String [] result=new String [columns.size()]; 
    	   for(int i=0;i<columns.size();i++) {
    		   result[i]=columns.get(i);
    	   }
    	   return result;
       }
       
       
       public static  Grid getGridBySql(String sql){
    	     Grid grid=new Grid();  	     
    	     List<GridHeader> gridHeaders=new ArrayList<GridHeader>();
    	     List<GridRow> gridRows=new ArrayList<GridRow>();
    	     
    	     Connection conn=MysqlUtil.getConn();
    	     PreparedStatement ps=null;
    	     ResultSet rs=null;
    	     try{
    	    	 ps=conn.prepareStatement(sql);
    	    	 rs=ps.executeQuery();
    	    	 	    	  
    	    	 ResultSetMetaData metaData=rs.getMetaData();
    	    	 
    	    	 int columnCount= metaData.getColumnCount();
    	    	 for(int i=1;i<columnCount+1;i++){
    	    		 GridHeader gridHeader=new GridHeader();
    	    		 gridHeader.setValue(metaData.getColumnName(i));
    	    		 gridHeaders.add(gridHeader);    	    		
    	    	 }
    	    	 int count=0;
    	    	 while(rs.next()){
    	    		  count++;
    	    		  GridRow gridRow=new GridRow();
    	    		  gridRow.setId(count);
    	    		  List<String> data=new ArrayList<String>();
    	    		   for(int i=1;i<columnCount+1;i++){
    	    			   String result=MysqlUtil.getColumnValueByType(rs, metaData.getColumnTypeName(i),i);
    	    			   data.add(result==null?"null":result);
    	    		   }
    	    		   gridRow.setData(data);
    	    		   gridRows.add(gridRow);
    	    	 }	    	 
    	    	 grid.setHead(gridHeaders);
    	    	 grid.setRows(gridRows);
    	     }catch(Exception ex){
    	    	 GridHeader gridHeader=new GridHeader();
    	    	 gridHeader.setValue("error");
    	    	 GridRow gridRow=new GridRow();
    	    	 List<String> data=new ArrayList<String>();
    	    	 data.add("语句不符合规范");
    	    	 gridRow.setId(0);
    	    	 gridRow.setData(data);
    	    	 gridHeaders.add(gridHeader);
    	    	 gridRows.add(gridRow);
    	    	 grid.setRows(gridRows);
    	    	 grid.setHead(gridHeaders);
    	    	 return grid;	    	
    	     }
    	     return grid;
       }
       public static String getColumnValueByType(ResultSet rs,String type,int columnIndex){
    	   
//    	   BIGINT 
//    	   BINARY 
//    	   BIT 
//    	   CHAR 
//    	   DATE 
//    	   DECIMAL 
//    	   DOUBLE 
//    	   FLOAT 
//    	   INTEGER 
//    	   LONGVARBINARY 
//    	   LONGVARCHAR 
//    	   NULL 
//    	   NUMERIC 
//    	   OTHER 
//    	   REAL 
//    	   SMALLINT 
//    	   TIME 
//    	   TIMESTAMP 
//    	   TINYINT 
//    	   VARBINARY 
//    	   VARCHAR 
    	   
    	     String result=null;
    	 try{
    	      if("INT".equals(type)){
    	    
    	    	     result=String.valueOf(rs.getInt(columnIndex));  	    	  
    	      }
    	      if("VARCHAR".equals(type)){
    	    	     result=rs.getString(columnIndex);
    	      }
    	 }catch(Exception ex){
   		  ex.printStackTrace();
   	     }
    	      return result;
       }
       
       
       public static  Grid TableToGrid(String tableName){
    	      Connection conn=MysqlUtil.getConn();
    	      String sql="select * from "+tableName;
    	      PreparedStatement ps=null;
    	      String [] columns=null;
    	      Grid grid=new Grid();
    	      List<GridHeader> gridHeaders=new ArrayList<GridHeader>();
    	      List<GridRow> gridRows=new ArrayList<GridRow>();
    	      try {
				columns=MysqlUtil.getColumns(conn, tableName);
				
				for(int i=0;i<columns.length;i++){
					 GridHeader gridHeader=new GridHeader();
					 gridHeader.setValue(columns[i]);
					 gridHeaders.add(gridHeader);
				}
					
				
			  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } 	          	      
    	      ResultSet rs=null;
    	      try{
    	    	  ps=conn.prepareStatement(sql);
    	    	  rs=ps.executeQuery();
    	         	    	 
    	    	  while(rs.next()){
    	    		  GridRow gridRow=new GridRow();
    	    		  List<String> data=new ArrayList<String>();
    	    		  
    	    		  for(int i=0;i<columns.length;i++){
    	    		    data.add(String.valueOf(rs.getString(rs.findColumn(columns[i]))));
    	    		  }
    	    		  gridRow.setData(data);
    	    		  gridRow.setId(rs.getInt(rs.findColumn("id")));
    	    		  gridRows.add(gridRow);
    	    	  }
    	    	   grid.setHead(gridHeaders);
    	    	   grid.setRows(gridRows);
    	      }catch(Exception ex){
    	    	  ex.printStackTrace();
    	      }
    	      return grid;
       }
       
}
