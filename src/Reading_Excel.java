/**
 * 
 */

/**
 * @author Vivek
 *
 */

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map;

	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;


	public class Reading_Excel {
		private Map<String,String> dataObjectMap= new HashMap<String,String>();
		public Reading_Excel (String name){
			try{
				String excelFilePath=name;
				FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
				Workbook workbook = new HSSFWorkbook(inputStream);
				Sheet firstsheet = workbook.getSheetAt(0);
				Iterator<Row> iterator = firstsheet.iterator();// every access in row with help of iterator
				int count =0;
				while (iterator.hasNext()){// iterator has row 
					Row nextRow = iterator.next();// row has many cells
					if(count == 0){ // heading wala part  to ignore heading then move to second row
						count++;
						continue;
					}
					count++;
					Iterator<Cell>cellIterator = nextRow.cellIterator();
					int cellCount =0;
					String key ="";
					while (cellIterator.hasNext()){// cking whether row has cell or not
						Cell cell =cellIterator.next();
						cell.setCellType(Cell.CELL_TYPE_STRING);// all data in cell will be taken as string
						cellCount = cell.getColumnIndex();// current col index
						if(cellCount==0){
							key = cell.getStringCellValue();
						}
						else
						{
							System.out.println("key:"+key+"Value : "+cell.getStringCellValue());
							dataObjectMap.put(key,cell.getStringCellValue());// map is nothiing but store for key value pair  // map can store many thing compared with arrary store 1 index 
							// what ever data we have read we are storing in map
						}
					
							}
								}
				inputStream.close();
						}catch(FileNotFoundException e){
							e.printStackTrace();
						}catch(IOException e){
							e.printStackTrace();
						}
			//return null;
		}
	public String getData(String key){
		return dataObjectMap.get(key);
		
		
	}
	}


