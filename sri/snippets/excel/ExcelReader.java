package sri.snippets.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader
{
	private static final String EXCEPTION_FILE_FORMAT = "Unable to recognize OLE stream";
	
	private static final String EXCEL_FILE_PATH = "F:\\MyWork\\Workspace Eclipse\\Snippets\\src\\sri\\snippets\\excel\\";
	private static final String EXCEL_FILE_NAME = "testfile.xls";

	private static final String BLANK = "";
	
	public static void main(String[] args) throws IOException
	{
		ExcelReader excelReader = new ExcelReader();
		List<ExcelVO> excelVOList = excelReader.readFromExcel(EXCEL_FILE_PATH + EXCEL_FILE_NAME);
		
		System.out.println("Number of records: " + excelVOList.size());
		for (ExcelVO excelVO : excelVOList)
			System.out.println(excelVO.getEmail() + " : " + excelVO.getPasswd() + " : " + excelVO.getFirstName() + " :  " + excelVO.getLastName());
	}

	public List<ExcelVO> readFromExcel(String filenameWithPath) throws IOException
	{
		List<ExcelVO> excelVOList = new ArrayList<ExcelVO>();

		File inputWorkbook = new File(filenameWithPath);
		Workbook w;
		try
		{
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(0);

			ExcelVO excelVO;
			for (int j = 0; j < sheet.getRows(); j++)
			{
				excelVO = new ExcelVO();
				excelVO.setEmail(BLANK + (sheet.getCell(0, j)).getContents());
				excelVO.setPasswd(BLANK + sheet.getCell(1, j).getContents());
				excelVO.setFirstName(BLANK + sheet.getCell(2, j).getContents());
				excelVO.setLastName(BLANK + sheet.getCell(3, j).getContents());
				
				excelVOList.add(excelVO);
			}
		} catch (BiffException e)
		{
			if (EXCEPTION_FILE_FORMAT.equals(e.getMessage()))
				System.out.println("Unrecognized file format. Please ensure the Excel file is well formed, and has the extension XLS.");
			else
				e.printStackTrace();
		}

		return excelVOList;
	}
}
