/* Author: truonganhdung
 * Created Date: 10/24/2018
 * Modified Date: ../../2018
 * */

package III_X_Data_Driven.testCases;

import java.util.Properties;

import III_X_Data_Driven.operation.ReadObject;
import III_X_Data_Driven.operation.UIOperation;
import III_X_Data_Driven.excelExportAndFileIO.ReadGuru99ExcelFile;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * THIS IS THE EXAMPLE OF KEYWORD DRIVEN TEST CASE
 *
 */
public class ExecuteTest {
	WebDriver driver;
	
    @Test
	public void testLogin() throws Exception {
    	driver = new FirefoxDriver();
       
    	ReadGuru99ExcelFile file = new ReadGuru99ExcelFile();
        ReadObject object = new ReadObject();
        Properties allObjects =  object.getObjectRepository();
        UIOperation operation = new UIOperation(driver);
        
        Sheet guru99Sheet = file.readExcel(System.getProperty("user.dir") + "\\src\\guru99\\III_X_Data_Driven\\testCases", "TestCase.xlsx", "KeywordFramework");

    	int rowCount = guru99Sheet.getLastRowNum() - guru99Sheet.getFirstRowNum();

    	for (int i = 1; i < rowCount+1; i++) {
    		Row row = guru99Sheet.getRow(i);

    		if(row.getCell(0).toString().length()==0){
    			System.out.println(row.getCell(1).toString() + "----"+ row.getCell(2).toString() + "----"+
    			row.getCell(3).toString() + "----"+ row.getCell(4).toString());

    			operation.perform(allObjects, row.getCell(1).toString(), row.getCell(2).toString(),
    				row.getCell(3).toString(), row.getCell(4).toString());
    	    }
    		else{
    			System.out.println("New Testcase->" + row.getCell(0).toString() + " Started");
    		}
    	}
	}
    
    //( ._.')----------------------------------------------------
  	@AfterClass
  	public void afterClass() {
  		driver.quit();
  	}
}