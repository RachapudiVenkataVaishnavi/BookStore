package com.bookstore.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bookstore.common.util.DataConstants;

public class DBConnection {
	
	public static Connection getDBConnection()
	{
	Connection conn=null;
	try
	{
	
		Class.forName(DataConstants.DBDriver);
		conn = DriverManager.getConnection(DataConstants.URL,DataConstants.DBUserName,DataConstants.DBPassword);
	}
	catch(Exception e)
	{
	
		e.printStackTrace();
		conn=null;
	}
	return conn;
	}
	
	
	public static void closeConnection(Connection con)
    {
        try
        {
            if(con != null && !con.isClosed())
            {
                con.close();
                con = null;
            }
        }
        catch(SQLException sqlex)
        {
           sqlex.printStackTrace();
        }
        catch(Exception genExp)
        {
          genExp.printStackTrace();
        }
        
    }

    public static void closeStatement(Statement stmt)
    {
        try
        {
            if(stmt != null)
            {
                stmt.close();
                stmt = null;
            }
        }
        catch(SQLException sqlex)
        {
        	 sqlex.printStackTrace();
        }
        catch(Exception genExp)
        {
          genExp.printStackTrace();
        }
        
    }

    public static void closeResultSet(ResultSet rs)
    {
        try
        {
            if(rs != null)
            {
                rs.close();
                rs = null;
            }
        }
        catch(SQLException sqlex)
        {
        	 sqlex.printStackTrace();
        }
        catch(Exception genExp)
        {
          genExp.printStackTrace();
        }
    }
	
	
	
	

}
