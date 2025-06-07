import com.varnit.jain.hr.bl.managers.*;
import com.varnit.jain.hr.bl.interfaces.managers.*;
import com.varnit.jain.hr.bl.interfaces.pojo.*;
import com.varnit.jain.hr.bl.pojo.*;
import com.varnit.jain.hr.bl.exceptions.*;
import java.util.*;
class DesignationManagerAddTestCase
{
public static void main(String gg[])
{
DesignationInterface designation=new Designation();	
designation.setTitle("manager");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
designationManager.addDesignation(designation);
System.out.println("Designation added with code as : "+designation.getCode());
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
