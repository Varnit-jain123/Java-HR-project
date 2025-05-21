import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.hr.dl.dao.*;

public class EmployeePANNumberExistsTestCase
{
public static void main(String gg[])
{
String PANNumber=gg[0];
try
{
System.out.println("PAN Number : "+PANNumber+" exists : "+new EmployeeDAO().panNumberExists(PANNumber));
} catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}