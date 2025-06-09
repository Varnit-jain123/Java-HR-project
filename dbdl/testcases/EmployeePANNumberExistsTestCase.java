import com.varnit.jain.hr.dl.exceptions.*;
import com.varnit.jain.hr.dl.interfaces.dto.*;
import com.varnit.jain.hr.dl.interfaces.dao.*;
import com.varnit.jain.hr.dl.dto.*;
import com.varnit.jain.hr.dl.dao.*;

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