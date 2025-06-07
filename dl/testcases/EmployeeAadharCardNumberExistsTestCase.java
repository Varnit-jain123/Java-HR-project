import com.varnit.jain.hr.dl.exceptions.*;
import com.varnit.jain.hr.dl.interfaces.dto.*;
import com.varnit.jain.hr.dl.interfaces.dao.*;
import com.varnit.jain.hr.dl.dto.*;
import com.varnit.jain.hr.dl.dao.*;

public class EmployeeAadharCardNumberExistsTestCase
{
public static void main(String gg[])
{
String aadharCardNumber=gg[0];
try
{
System.out.println("Aadhar card Number : "+aadharCardNumber+" exists : "+new EmployeeDAO().aadharCardNumberExists(aadharCardNumber));
} catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}