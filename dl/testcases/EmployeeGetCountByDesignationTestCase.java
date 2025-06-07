import com.varnit.jain.hr.dl.exceptions.*;
import com.varnit.jain.hr.dl.interfaces.dto.*;
import com.varnit.jain.hr.dl.interfaces.dao.*;
import com.varnit.jain.hr.dl.dto.*;
import com.varnit.jain.hr.dl.dao.*;

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