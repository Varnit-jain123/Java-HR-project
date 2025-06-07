import com.varnit.jain.hr.bl.interfaces.managers.*;
import com.varnit.jain.hr.bl.interfaces.pojo.*;
import com.varnit.jain.hr.bl.exceptions.*;
import com.varnit.jain.hr.bl.pojo.*;
import com.varnit.jain.hr.bl.managers.*;
import java.util.*;
class DesignationManagerDesignationCodeExistsTestCase
{
public static void main(String gg[])
{
int code=Integer.parseInt(gg[0]);
try{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
System.out.printf(code + " exists : "+designationManager.designationCodeExists(code));
} catch(BLException blException)
{
List<String> properties=blException.getProperties();
properties.forEach((property)->{
System.out.println(blException.getException(property));
});
}
}
}