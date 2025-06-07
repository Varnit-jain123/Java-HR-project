import com.varnit.jain.hr.dl.exceptions.*;
import com.varnit.jain.hr.dl.interfaces.dto.*;
import com.varnit.jain.hr.dl.interfaces.dao.*;
import com.varnit.jain.hr.dl.dto.*;
import com.varnit.jain.hr.dl.dao.*;

public class EmployeeGetCountTestCase
{
public static void main(String gg[])
{
try
{
System.out.println("Number of Employees : "+new EmployeeDAO().getCount());
} catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}