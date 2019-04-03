package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FwUtil extends BaseTest {
	
	public static void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public static String getXLData(String Path, String Sheet, int r, int c) {
		String v = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(Path));
			v = wb.getSheet(Sheet).getRow(r).getCell(c).toString();
		} catch (Exception e) {
		}
		return v;
	}

	public static int getXLRowCount(String path, String Sheet) {
		int count = 0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(path));
			count = wb.getSheet(Sheet).getLastRowNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public static void setXLData(String Path, String Sheet, int r, int c, int v) {
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(Path));
			wb.getSheet(Sheet).getRow(r).getCell(c).setCellValue(v);
			wb.write(new FileOutputStream(Path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getPhoto(WebDriver driver, String Path) {
		try {
			TakesScreenshot t = (TakesScreenshot) driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			File destFile = new File(Path);
			FileUtils.copyFile(srcFile,destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
