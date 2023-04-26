package Assignment.Assess;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUploadMethod {

	public ArrayList<String> getData(String keyName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		/* Pick Sheet from System */
		FileInputStream fis = new FileInputStream("./src/main/resources/TestData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		/* To read sheet 1 only */

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				/* Identify Testcases coloum by scanning the entire 1st row */

				Iterator<Row> rows = sheet.iterator(); // sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> cells = firstrow.cellIterator(); // row is collection of cells
				cells.next();
				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("Value")) {
						// desired column
						column = k;
					}
					k++;
				}

				while (rows.hasNext()) {

					Row r = rows.next();

					if (CellUtil.getCell(r, column).getStringCellValue().equalsIgnoreCase(keyName)) {

						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {

							Cell c = cv.next();
							if (c.getCellTypeEnum() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}

						}
					}

				}
			}
		}
		return a;
	}

}
