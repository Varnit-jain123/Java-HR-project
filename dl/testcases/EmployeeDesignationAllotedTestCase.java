import com.varnit.jain.hr.dl.exceptions.*;
import com.varnit.jain.hr.dl.interfaces.dto.*;
import com.varnit.jain.hr.dl.interfaces.dao.*;
import com.varnit.jain.hr.dl.dto.*;
import com.varnit.jain.hr.dl.dao.*;
import java.text.*;
import java.util.*;
public class EmployeeDesignationAllotedTestCase
{
public static void main(String gg[])
{
int designationCode=Integer.parseInt(gg[0]);
try
{
EmployeeDAOInterface employeeDAO;
employeeDAO=new EmployeeDAO();
System.out.println("Employee With designation code "+designationCode+" exists : "+employeeDAO.isDesignationAlloted(designationCode));
} catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}