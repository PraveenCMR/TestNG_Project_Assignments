package testng_assign;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Excel_reader {
	private static final String FILE_NAME = "C:/Users/harishp/Documents/Test.xlsx";

	@Test
	public void testBankEmployeeOperations() {
		try {
			// Read data from the Excel file
			FileInputStream inputStream = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);

			// Iterate through rows to get employee details
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row row = sheet.getRow(i);
				String name = row.getCell(0).getStringCellValue();
				int age = (int) row.getCell(1).getNumericCellValue();
				//age=Integer.parseInt(row.getCell(int));
				String position = row.getCell(2).getStringCellValue();
				double salary = row.getCell(3).getNumericCellValue();
				//double d = Cell.getNumericCellValue();

				// Create BankEmployee object and perform operations
				BankEmployee employee = new BankEmployee(name, age, position, salary);
				employee.validate();
				employee.modify();
				employee.validate();
				employee.delete();
			}

			// Write back to the Excel file
			FileOutputStream outputStream = new FileOutputStream(new File(FILE_NAME));
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// BankEmployee class for operations
	private static class BankEmployee {
		String name;
		int age;
		String position;
		double salary;

		public BankEmployee(String name, int age, String position, double salary) {
			this.name = name;
			this.age = age;
			this.position = position;
			this.salary = salary;
		}

		public void validate() {
			// Add validation logic
			System.out.println("Validating employee: " + name);
		}

		public void modify() {
			// Add modification logic
			System.out.println("Modifying employee: " + name);
		}

		public void delete() {
			// Add deletion logic
			System.out.println("Deleting employee: " + name);
		}
	}
}
