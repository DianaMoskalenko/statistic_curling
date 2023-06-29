package com.curling.statistic;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import java.io.FileOutputStream;
import java.io.IOException;
public class ExcelWriter {
    private String filePath;
    private Workbook workbook;
    private Sheet sheet;
    GameStats gameStats = new GameStats();
    public static void main(String[] args) throws IOException {
       FileOutputStream fos = new FileOutputStream("statistic.xlsx");

    }

    public ExcelWriter(String filePath) {
        this.filePath = filePath;
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet("Stats");
    }

    public void writeData(String buttonName) {
        Row row = sheet.createRow(sheet.getLastRowNum() + 1);
        Cell cell = row.createCell(0);
        cell.setCellValue(buttonName);
    }

    public void saveToFile() {
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleButtonAction(HelloApplication.GameStats gameStat) {

        System.out.println(gameStat.name());

        ExcelWriter excelWriter = new ExcelWriter("statistic.xlsx");

        excelWriter.writeData(gameStat.name());

        excelWriter.saveToFile();
    }
}