import com.varnit.jain.hr.dl.exceptions.*;
import com.varnit.jain.hr.dl.interfaces.dto.*;
import com.varnit.jain.hr.dl.interfaces.dao.*;
import com.varnit.jain.hr.dl.dto.*;
import com.varnit.jain.hr.dl.dao.*;
import java.text.*;
import java.util.*;
public class EmployeeDeleteTestCase
{
public static void main(String gg[])
{
String employeeId=gg[0];
try
{
EmployeeDAOInterface employeeDAO;
employeeDAO=new EmployeeDAO();
employeeDAO.delete(employeeId);
System.out.println("Employee Deleted with id :. "+employeeId);
} catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}