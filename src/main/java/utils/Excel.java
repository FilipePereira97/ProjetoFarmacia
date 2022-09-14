package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Excel {
    static String path = "C:\\Users\\franc\\Faculdade\\Projetos Pessoais\\TestExcel\\Book1.xlsx";
    static Sheet sheet;
    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    static Date date = new Date();
    static int diaMes = date.getDate() - 1;
    static String nomeMes = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    static String dateForm = formatter.format(date);
    static Calendar cal = Calendar.getInstance();
    static int daysOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    static String nameOfSheet = "User 1";


    public static void main(String[] args) throws IOException {
//        if(diaMes == daysOfMonth) {
//            writeHeader();
//            writeHeader2();
//        }

        //writeHeader();
        writeHeader2();
        writeBody();
    }

    public static void writeHeader() throws IOException {
        FileInputStream input = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(input);

        sheet = workbook.getSheet(nameOfSheet);
        if (sheet == null) {
            sheet = workbook.createSheet(nameOfSheet);
        }



        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = (workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Row header = sheet.createRow(0);
        Cell headerCell = header.createCell(2);

        sheet.addMergedRegion(new CellRangeAddress(0, 1, 2, 4));

        headerCell.setCellValue(nomeMes);
        headerCell.setCellStyle(headerStyle);

        headerCell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);
        headerCell.getCellStyle().setVerticalAlignment(VerticalAlignment.CENTER);


        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
    }


    public static void writeHeader2() throws IOException {
        FileInputStream input = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        sheet = workbook.getSheet(nameOfSheet);
        if (sheet == null) {
            sheet = workbook.createSheet(nameOfSheet);
        }

        Row head = sheet.createRow(3);

        // ---------- DATE ---------------------
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setWrapText(true);
        dateStyle.setFillForegroundColor(IndexedColors.BROWN.getIndex());
        dateStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cellDate = head.createCell(0);
        if (cellDate != null) {
            cellDate.setCellValue("Data");
            cellDate.setCellStyle(dateStyle);
        }

        // ---------- MB ---------------------
        CellStyle mbStyle = workbook.createCellStyle();
        mbStyle.setWrapText(true);
        mbStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        mbStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell = head.createCell(1);
        if (cell != null) {
            cell.setCellValue("Valor MB");
            cell.setCellStyle(mbStyle);
        }

        // ---------- CASH ---------------------
        CellStyle cashStyle = workbook.createCellStyle();
        cashStyle.setWrapText(true);
        cashStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        cashStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell1 = head.createCell(2);
        if (cell1 != null) {
            cell1.setCellValue("Valor Dinheiro");
            cell1.setCellStyle(cashStyle);
        }

        // ---------- OTHER ---------------------
        CellStyle otherStyle = workbook.createCellStyle();
        otherStyle.setWrapText(true);
        otherStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        otherStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell2 = head.createCell(3);
        if (cell2 != null) {
            cell2.setCellValue("Valor Outros");
            cell2.setCellStyle(otherStyle);
        }

        // ---------- VAL TOTAL PREV ---------------------
        CellStyle valTotStyle = workbook.createCellStyle();
        valTotStyle.setWrapText(true);

        valTotStyle.setFillForegroundColor(IndexedColors.PINK.getIndex());
        valTotStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell3 = head.createCell(4);
        if (cell3 != null) {
            cell3.setCellValue("Valor Total Previsto");
            cell3.setCellStyle(valTotStyle);
        }

        // ---------- VAL OBT ---------------------
        CellStyle valObtStyle = workbook.createCellStyle();
        valObtStyle.setWrapText(true);
        valObtStyle.setFillForegroundColor(IndexedColors.PLUM.getIndex());
        valObtStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell4 = head.createCell(5);
        if (cell4 != null) {
            cell4.setCellValue("Valor Obtido");
            cell4.setCellStyle(valObtStyle);
        }

        // ---------- DIF ---------------------
        CellStyle difStyle = workbook.createCellStyle();
        difStyle.setWrapText(true);
        difStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        difStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell5 = head.createCell(6);
        if (cell5 != null) {
            cell5.setCellValue("Valor Desvio");
            cell5.setCellStyle(difStyle);
        }


        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
    }


    public static void writeBody() throws IOException {
        FileInputStream input = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(input);
        sheet = workbook.getSheet(nameOfSheet);
        if (sheet == null) {
            sheet = workbook.createSheet(nameOfSheet);
        }

        // ---------- DATE ---------------------
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setWrapText(true);
        dateStyle.setFillForegroundColor(IndexedColors.BROWN.getIndex());
        dateStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row row = sheet.createRow(diaMes + 5);
        Cell cellDate = row.createCell(0);
        cellDate.setCellValue(dateForm);
        cellDate.setCellStyle(dateStyle);

        // ---------- MB ---------------------
        CellStyle mbStyle = workbook.createCellStyle();
        mbStyle.setWrapText(true);
        mbStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        mbStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell = row.createCell(1);
        if (cell != null) {
            cell.setCellValue("test0.1");
            cell.setCellStyle(mbStyle);
        }

        // ---------- CASH ---------------------
        CellStyle cashStyle = workbook.createCellStyle();
        cashStyle.setWrapText(true);
        cashStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        cashStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell1 = row.createCell(2);
        if (cell1 != null) {
            cell1.setCellValue("test1.1");
            cell1.setCellStyle(cashStyle);
        }

        // ---------- OTHER ---------------------
        CellStyle otherStyle = workbook.createCellStyle();
        otherStyle.setWrapText(true);
        otherStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
        otherStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell2 = row.createCell(3);
        if (cell2 != null) {
            cell2.setCellValue("test2.1");
            cell2.setCellStyle(otherStyle);
        }

        // ---------- VAL TOTAL PREV ---------------------
        CellStyle valTotStyle = workbook.createCellStyle();
        valTotStyle.setWrapText(true);

        valTotStyle.setFillForegroundColor(IndexedColors.PINK.getIndex());
        valTotStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell3 = row.createCell(4);
        if (cell3 != null) {
            cell3.setCellValue("test3.1");
            cell3.setCellStyle(valTotStyle);
        }

        // ---------- VAL OBT ---------------------
        CellStyle valObtStyle = workbook.createCellStyle();
        valObtStyle.setWrapText(true);
        valObtStyle.setFillForegroundColor(IndexedColors.PLUM.getIndex());
        valObtStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell4 = row.createCell(5);
        if (cell4 != null) {
            cell4.setCellValue("test4.1");
            cell4.setCellStyle(valObtStyle);
        }

        // ---------- DIF ---------------------
        CellStyle difStyle = workbook.createCellStyle();
        difStyle.setWrapText(true);
        difStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        difStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell cell5 = row.createCell(6);
        if (cell5 != null) {
            cell5.setCellValue("test5.1");
            cell5.setCellStyle(difStyle);
        }


        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
    }
}
