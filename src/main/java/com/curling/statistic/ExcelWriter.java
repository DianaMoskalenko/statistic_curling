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
    public void writeData(String position) {
        Row row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("POSITION");
        Row positionRow = sheet.createRow(NextRowNumber());

        Cell cell = positionRow.createCell(0);
        cell.setCellValue(position);

    }

    private int NextRowNumber() {
        if (sheet.getLastRowNum() == 0) {
            return sheet.getFirstRowNum() - 1;
        } else {
            return sheet.getLastRowNum() + 1;
        }
    }


    private String getPositionValue(HelloApplication.GameStats gameStat) {
        switch (gameStat) {
            case POSITION_LEAD:
                return "Lead";
            case POSITION_SECOND:
                return "Second";
            case POSITION_THIRD:
                return "Third";
            case POSITION_FOURTH:
                return "Fourth";

        }
        return null;
    }
    public void saveToFile() {
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void handleButtonAction(HelloApplication.GameStats gameStat) {
        String position = getPositionValue(gameStat);
        this.writeData(position);
        this.saveToFile();
    }


}