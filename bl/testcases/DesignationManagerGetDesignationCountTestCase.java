import com.varnit.jain.hr.bl.interfaces.managers.*;
import com.varnit.jain.hr.bl.interfaces.pojo.*;
import com.varnit.jain.hr.bl.exceptions.*;
import com.varnit.jain.hr.bl.pojo.*;
import com.varnit.jain.hr.bl.managers.*;
import java.util.*;
class DesignationManagerGetDesignationCountTestCase
{
public static void main(String gg[])
{
try{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
System.out.printf("Number of designation : "+designationManager.getDesignationCount());
} catch(BLException blException)
{
List<String> properties=blException.getProperties();
properties.forEach((property)->{
System.out.println(blException.getException(property));
});
}
}
}