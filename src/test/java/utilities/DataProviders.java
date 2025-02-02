package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException 

	{
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		
		ExcelUtility xlutil= new ExcelUtility(path);     // creating object for XLutility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]= new String[totalrows][totalcols];   // created for two dimension array
		
		for(int i=1;i<=totalrows;i++)     // read the data from xl storing in 2 demnsional array
		{
			for(int j=0;j<totalcols;j++)   
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;	
	}
}




// data provuider2 
