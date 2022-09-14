package utils;

import controller.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Excel {
    String path = "ProjetoEdgar\\teste.xlsx";
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    String dateForm = formatter.format(date);


    // CRIAR: se não existir nenhum ficheiro tem de criar um novo com um
    // nome que o user escolher bem como a localização
    // (ou então mete tudo predefinido e dps diz o path onde está e o nome)



    public void write() throws IOException {
        FileInputStream input = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(input);

        Sheet sheet = workbook.createSheet("Person 1"); //vai buscar o nome da pessoa que deu login
        sheet.setColumnWidth(0, 60);
        sheet.setColumnWidth(1, 40);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = (workbook).createFont();

        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);


        //Calendar cal = Calendar.getInstance();
        //int daysOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        Row row = sheet.createRow(0);
        Cell cellDate = row.createCell(LoginController.dayOfLogin()); //numero do dia do mês
        cellDate.setCellValue(Calendar.DAY_OF_MONTH);
        cellDate.setCellStyle(style);



        Row row1 = sheet.createRow(1);
        Cell cell = row1.createCell(0);
        cell.setCellValue(Controller.mbValor()); //valor do MB
        cell.setCellStyle(style);

        Cell cell1 = row1.createCell(1);
        cell1.setCellValue(Controller.cashValor()); //valor do cash
        cell1.setCellStyle(style);

        Cell cell2 = row1.createCell(2);
        cell2.setCellValue(Controller.otherValor()); //valor do outros
        cell2.setCellStyle(style);

        Cell cell3 = row1.createCell(3);
        cell3.setCellValue(Controller.totalPrev()); //valor previsto
        cell3.setCellStyle(style);

        Cell cell4 = row1.createCell(4);
        cell4.setCellValue(Calculos.totalObtido()); //valor obtido
        cell4.setCellStyle(style);

        Cell cell5 = row1.createCell(5);
        cell5.setCellValue(Calculos.desvio()); //valor da diferença
        cell5.setCellStyle(style);


        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
    }



    public void read() throws IOException {
        FileInputStream input = new FileInputStream(path);
        XSSFWorkbook book = new XSSFWorkbook(input);

        Sheet sheet = book.getSheet("Person 1"); //vai buscar o nome da pessoa que deu login
        Row row = sheet.getRow(0);
        System.out.print(row.getCell(0));
    }
}
