import com.varnit.jain.hr.bl.managers.*;
import com.varnit.jain.hr.bl.interfaces.managers.*;
import com.varnit.jain.hr.bl.interfaces.pojo.*;
import com.varnit.jain.hr.bl.pojo.*;
import com.varnit.jain.hr.bl.exceptions.*;
import java.util.*;
import java.text.*;
import java.math.*;
import com.varnit.jain.enums.*;
class EmployeeManagerUpdateTestCase
{
public static void main(String gg[])
{
try{
String employeeId="A10000001";
String name="Sameer Joshi";
DesignationInterface designation=new Designation();
designation.setCode(3);
Date dateOfBirth=new Date();
boolean isIndian=false;
BigDecimal basicSalary=new BigDecimal("300000");
String panNumber="AMWF125125";
String aadharCardNumber="UID125125";
EmployeeInterface employee;
employee=new Employee();
employee.setEmployeeId(employeeId);
employee.setName(name);
employee.setDesignation(designation);
employee.setDateOfBirth(dateOfBirth);
employee.setGender(GENDER.MALE);
employee.setIsIndian(isIndian);
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
employeeManager.updateEmployee(employee);
System.out.printf("Employee updated with employee id : %s\n",employee.getEmployeeId());	
} catch(BLException blException)
{
if(blException.hasGenericException()) System.out.println(blException.getGenericException());
List<String> properties=blException.getProperties();
for(String property : properties)
{
System.out.println(blException.getException(property));
}
}
}
}