import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.hr.dl.dao.*;

public class EmployeeEmployeeIdExistsTestCase
{
public static void main(String gg[])
{
String employeeId=gg[0];
try
{
System.out.println("Employee Id. : "+employeeId+" exists : "+new EmployeeDAO().employeeIdExists(employeeId));
} catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}