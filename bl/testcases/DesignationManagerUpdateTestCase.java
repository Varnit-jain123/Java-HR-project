import com.varnit.jain.hr.bl.managers.*;
import com.varnit.jain.hr.bl.interfaces.managers.*;
import com.varnit.jain.hr.bl.interfaces.pojo.*;
import com.varnit.jain.hr.bl.pojo.*;
import com.varnit.jain.hr.bl.exceptions.*;
import java.util.*;
class DesignationManagerUpdateTestCase
{
public static void main(String gg[])
{
DesignationInterface designation=new Designation();
designation.setCode(1);	
designation.setTitle("Clerk");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
designationManager.updateDesignation(designation);
System.out.println("Designation updated");
}catch(BLException blException)
{
if(blException.hasGenericException()) System.out.println(blException.getGenericException());
List<String> properties=blException.getProperties();
for(String property: properties)
{
System.out.println(blException.getException(property));
}
}
}
}
