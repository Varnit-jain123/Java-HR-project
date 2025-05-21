import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.hr.dl.dao.*;

public class EmployeeGetCountByDesignationTestCase
{
public static void main(String gg[])
{
int designationCode=Integer.parseInt(gg[0]);
try
{
System.out.println("Number of Employees whose designation code is : "+designationCode+"  is : "+new EmployeeDAO().getCountByDesignation(designationCode)) ;
} catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}