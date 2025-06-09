package com.varnit.jain.hr.dl.dao;
import com.varnit.jain.hr.dl.dto.*;
import com.varnit.jain.hr.dl.interfaces.dto.*;
import com.varnit.jain.hr.dl.interfaces.dao.*;
import com.varnit.jain.hr.dl.exceptions.*;
import java.util.*;
import java.io.*;
import java.sql.*;


public class DesignationDAO implements DesignationDAOInterface
{
private final static String FILE_NAME="designation.data";

public void add(DesignationDTOInterface designationDTO) throws DAOException
{
if(designationDTO==null) throw new DAOException("Designation is null"); 
String title=designationDTO.getTitle();
if(title==null) throw new DAOException("Designation is null"); 
title=title.trim();
if(title.length()==0) throw new DAOException("Length of designation is zero");
try 
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select code from designation where title=?");
preparedStatement.setString(1,title);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{	
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Designation : "+title+" exists.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into designation (title) values(?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,title);
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
int code=resultSet.getInt(1);
resultSet.close();
preparedStatement.close();
connection.close();
designationDTO.setCode(code);
} catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}

public void update(DesignationDTOInterface designationDTO) throws DAOException
{
if(designationDTO==null) throw new DAOException("Designation is null"); 
int code=designationDTO.getCode();
if(code<=0) throw new DAOException("Invalid Code : "+code);
String title=designationDTO.getTitle();
if(title==null) throw new DAOException("Designation is null"); 
title=title.trim();
if(title.length()==0) throw new DAOException("Length of designation is zero");
try
{
Connection connection=DAOConnection.getConnection();
String vTitle=designationDTO.getTitle();
int vCode=designationDTO.getCode();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select *from designation where code=?");
preparedStatement.setInt(1,vCode);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Code : "+vCode);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from designation where title=? and code!=?");
preparedStatement.setString(1,vTitle);
preparedStatement.setInt(2,vCode);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException(vTitle+ " already Exists");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("update designation set title=? where code =?");
preparedStatement.setString(1,vTitle);
preparedStatement.setInt(2,vCode);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
} catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}

public void delete(int code) throws DAOException
{
if(code<=0) throw new DAOException("Invalid Code : "+code);
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select *from designation where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Code : "+code);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from designation where code=?");
preparedStatement.setInt(1,code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
} catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}

public Set<DesignationDTOInterface> getAll() throws DAOException
{
Set<DesignationDTOInterface> designations;
designations=new TreeSet<>();
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet=statement.executeQuery("Select * from designation");
DesignationDTOInterface designationDTO;
while(resultSet.next())
{
designationDTO=new DesignationDTO();
designationDTO.setCode(resultSet.getInt("code"));
designationDTO.setTitle(resultSet.getString("title").trim());
designations.add(designationDTO);
}
resultSet.close();
statement.close();
connection.close();
return designations;
} catch(SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}

public DesignationDTOInterface getByCode(int code) throws DAOException
{
if(code<=0)  throw new DAOException("Invalid Code : "+code);
DesignationDTOInterface designationDTO;
designationDTO=new DesignationDTO();
try
{
Connection connection=DAOConnection.getConnection();
int dCode=code;
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,dCode);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Code : "+dCode);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,dCode);
resultSet=preparedStatement.executeQuery();
String title="";
if(resultSet.next())
{
title=resultSet.getString("title").trim();
}
resultSet.close();
preparedStatement.close();
connection.close();
designationDTO.setCode(dCode);
designationDTO.setTitle(title);
return designationDTO;
} catch (SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}

public DesignationDTOInterface getByTitle(String title) throws DAOException
{
if(title==null || title.trim().length()==0)  throw new DAOException("Invalid Title : "+title);
DesignationDTOInterface designationDTO;
designationDTO=new DesignationDTO();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where title=?");
preparedStatement.setString(1,title);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Designation");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select * from designation where title=?");
preparedStatement.setString(1,title);
resultSet=preparedStatement.executeQuery();
int code=0;
if(resultSet.next())
{
code=resultSet.getInt("code");
}
resultSet.close();
preparedStatement.close();
connection.close();
designationDTO.setCode(code);
designationDTO.setTitle(title);
return designationDTO;
} catch (SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}

public boolean codeExists(int code) throws DAOException
{
if(code<=0) return false;
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
return false;
}
resultSet.close();
preparedStatement.close();
connection.close();
return true;
} catch (SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}

public boolean titleExists(String title) throws DAOException
{
if(title==null || title.trim().length()==0) return false;
title=title.trim();
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where title=?");
preparedStatement.setString(1,title);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
return false;
}
resultSet.close();
preparedStatement.close();
connection.close();
return true;
} catch (SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}

public int getCount() throws DAOException
{
int count=0;
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("Select * from designation");
while(resultSet.next())
{
count++;
}
resultSet.close();
statement.close();
connection.close();
return count;
}catch (SQLException sqlException)
{
throw new DAOException(sqlException.getMessage());
}
}
}