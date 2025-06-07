import com.varnit.jain.hr.bl.managers.*;
import com.varnit.jain.hr.bl.interfaces.managers.*;
import com.varnit.jain.hr.bl.interfaces.pojo.*;
import com.varnit.jain.hr.bl.pojo.*;
import com.varnit.jain.hr.bl.exceptions.*;
import java.util.*;
class DesignationManagerRemoveTestCase
{
public static void main(String gg[])
{
int code=Integer.parseInt(gg[0]);
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
designationManager.removeDesignation(code);
System.out.println("Designation removed");
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
