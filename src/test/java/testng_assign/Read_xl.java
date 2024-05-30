package testng_assign;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;

import java.io.FileInputStream;

public class Read_xl {
	@Test
	public void read_and_print_simple_xl() {
		try {

			String XLfilepath = "C:/Users/harishp/Documents/Test.xlsx";
			FileInputStream myxlfile = new FileInputStream(XLfilepath);
			Workbook W_book = new XSSFWorkbook(myxlfile);
			Sheet sheet = W_book.getSheet("Sheet1");
			int lastrow = sheet.getLastRowNum();
			System.out.println("The last row which has data==" + lastrow);

			// loop for Row Iteration
			for (int i = 0; i <= lastrow; i++) {
				Row row = sheet.getRow(i);
				//get the last column which has data

				int lastcell = row.getLastCellNum();

				for (int j = 0; j < lastcell; j++) {
					Cell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.println("the xl value is " + value);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();


		}

	}
}
