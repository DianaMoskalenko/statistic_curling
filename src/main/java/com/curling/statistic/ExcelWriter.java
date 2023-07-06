package com.curling.statistic;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class ExcelWriter {
    private String filePath;
    private Workbook workbook;
    private Sheet sheet;
    private int gameNumber;
    private String gameDescription;
    GameStats gameStats = new GameStats();


    public ExcelWriter(String filePath) {
        this.filePath = filePath;
        this.workbook = loadWorkbook();
        this.sheet = getOrCreateSheet();
    }
    private Workbook loadWorkbook() {
        File file = new File(filePath);
        Workbook workbook;
        if (file.exists()) {
            try (FileInputStream fileIn = new FileInputStream(file)) {
                workbook = WorkbookFactory.create(fileIn);
            } catch (IOException e) {
                e.printStackTrace();
                workbook = new XSSFWorkbook();
            }
        } else {
            workbook = new XSSFWorkbook();
        }
        return workbook;
    }
    private Sheet getOrCreateSheet() {
        Sheet sheet = workbook.getSheet("Stats");
        if (sheet == null) {
            sheet = workbook.createSheet("Stats");
        }
        return sheet;
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
        this.writeData(gameStat.name());
        this.saveToFile();
    }


}