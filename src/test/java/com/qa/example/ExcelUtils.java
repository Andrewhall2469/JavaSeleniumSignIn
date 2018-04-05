package com.qa.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {

    String name = "";
    String email = "";
    String password = "";

    private static final String FILE_NAME = System.getProperty("user.dir") + "\\ExcelExample.xlsx";

    public void initialise() {

        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            name = datatypeSheet.getRow(1).getCell(0).getStringCellValue();
            email = datatypeSheet.getRow(1).getCell(1).getStringCellValue();
            password = datatypeSheet.getRow(1).getCell(2).getStringCellValue();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public void printLine() {
        System.out.println(getName());
        System.out.println(getEmail());
        System.out.println(getPassword());
    }
}