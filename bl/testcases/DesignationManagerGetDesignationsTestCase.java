import com.varnit.jain.hr.bl.interfaces.managers.*;
import com.varnit.jain.hr.bl.interfaces.pojo.*;
import com.varnit.jain.hr.bl.exceptions.*;
import com.varnit.jain.hr.bl.pojo.*;
import com.varnit.jain.hr.bl.managers.*;
import java.util.*;
class DesignationManagerGetDesignationsTestCase
{
public static void main(String gg[])
{
try{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
Set<DesignationInterface> designations;
designations=designationManager.getDesignations();
designations.forEach((designation)->{
System.out.printf("Code : %d , Title : %s\n",designation.getCode(),designation.getTitle());
});
} catch(BLException blException)
{
List<String> properties=blException.getProperties();
properties.forEach((property)->{
System.out.println(blException.getException(property));
});
}
}
}