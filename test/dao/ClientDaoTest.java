/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import model.Client;
import model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gemyy
 */
public class ClientDaoTest {
    public String emailPattern = "^[A-Za-z]{5}\\d+@[A-Za-z]+\\.[A-Za-z]{2,6}$"; //valid email -> gemyy555@gmail.com
    public String mobileNumberPattern = "^01[0125][0-9]{8}$"; //maximum 11 digit, must start with 01[0125]
    public String namePattern = "^[A-Z][a-z]*(\\s+[A-Z][a-z]*)*$"; // valid name -> Gamal Ahmed
    public String NI = "^([1-9]{1})([0-9]{2})([0-9]{2})([0-9]{2})([0-9]{2})[0-9]{3}([0-9]{1})[0-9]{1}$";
    public String addressPattern = "^(\\d{1,}) [a-zA-Z0-9\\s]+(,)? [a-zA-Z]+(/s)?+[a-zA-Z]+(,)? [A-Z]{2} [0-9]{5,6}$";
    public String IDPattern = "^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89ab][a-f0-9]{3}-[a-f0-9]{12}$";

    public ClientDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSave() {
        Client client = new Client();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\SaveClient.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            // Get the first sheet
            Sheet sheet = workbook.getSheetAt(0);
            // Iterate over rows
            for (Row row : sheet) {
                // Iterate over cells
                for (Cell cell : row) {
                    // Print cell value
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            data += cell.getStringCellValue() + "*";
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            data += (int) cell.getNumericCellValue() + "*";
                            break;
                        default:
                    }
                }
                str = new StringTokenizer(data, "*");
                client.setClientId(str.nextToken());
                client.setName(str.nextToken());
                client.setCash(Integer.parseInt(str.nextToken()));
                client.setAddress(str.nextToken());
                client.setGender(str.nextToken());
                client.setPhoneno("0" + str.nextToken());
                client.setDateofbirth(str.nextToken());
                client.setNationalId(str.nextToken());
                client.setEmail(str.nextToken());
                client.setNationality(str.nextToken());
                client.setCity(str.nextToken());
                client.setOccupation(str.nextToken());
                client.setRegisterdate(str.nextToken());
                if (client.getClientId().matches(IDPattern) && client.getName().matches(namePattern) && client.getAddress().matches(addressPattern) && client.getPhoneno().matches(mobileNumberPattern) && client.getEmail().matches(emailPattern) && client.getNationalId().matches(NI))
                {
                    assertEquals(true, true);
                    ClientDao.save(client);
                }
                else
                {
                    assertEquals(false, false);
                    ClientDao.save(client);
                }
                data = "";
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.out.println("fail test case");
        }
    }

//    @Test
//    public void testUpdate() {
//        Client client = new Client();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\UpdateClient.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            // Get the first sheet
//            Sheet sheet = workbook.getSheetAt(0);
//            // Iterate over rows
//            for (Row row : sheet) {
//                // Iterate over cells
//                for (Cell cell : row) {
//                    // Print cell value
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_STRING:
//                            data += cell.getStringCellValue() + "*";
//                            break;
//                        case Cell.CELL_TYPE_NUMERIC:
//                            data += (int) cell.getNumericCellValue() + "*";
//                            break;
//                        default:
//                    }
//                }
//                str = new StringTokenizer(data, "*");
//                client.setClientId(str.nextToken());
//                client.setName(str.nextToken());
//                client.setCash(Integer.parseInt(str.nextToken()));
//                client.setAddress(str.nextToken());
//                client.setGender(str.nextToken());
//                client.setPhoneno("0" + str.nextToken());
//                client.setDateofbirth(str.nextToken());
//                client.setNationalId(str.nextToken());
//                client.setEmail(str.nextToken());
//                client.setNationality(str.nextToken());
//                client.setCity(str.nextToken());
//                client.setOccupation(str.nextToken());
//                client.setRegisterdate(str.nextToken());
//                if (client.getClientId().matches(IDPattern) && client.getName().matches(namePattern) && client.getAddress().matches(addressPattern) && client.getPhoneno().matches(mobileNumberPattern) && client.getEmail().matches(emailPattern) && client.getNationalId().matches(NI))
//                {
//                    assertEquals(true, true);
//                    ClientDao.update(client);
//                }
//                else
//                {
//                    assertEquals(false, false);
//                    ClientDao.update(client);
//                }
//                data = "";
//            }
//            workbook.close();
//            file.close();
//        } catch (IOException e) {
//            System.out.println("fail test case");
//        }
//    }

//    @Test
//    public void testUpdateWithNationalID() {
//        Client client = new Client();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\UpdateClient.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            // Get the first sheet
//            Sheet sheet = workbook.getSheetAt(0);
//            // Iterate over rows
//            for (Row row : sheet) {
//                // Iterate over cells
//                for (Cell cell : row) {
//                    // Print cell value
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_STRING:
//                            data += cell.getStringCellValue() + "*";
//                            break;
//                        case Cell.CELL_TYPE_NUMERIC:
//                            data += (int) cell.getNumericCellValue() + "*";
//                            break;
//                        default:
//                    }
//                }
//                str = new StringTokenizer(data, "*");
//                client.setClientId(str.nextToken());
//                client.setName(str.nextToken());
//                client.setCash(Integer.parseInt(str.nextToken()));
//                client.setAddress(str.nextToken());
//                client.setGender(str.nextToken());
//                client.setPhoneno("0" + str.nextToken());
//                client.setDateofbirth(str.nextToken());
//                client.setNationalId(str.nextToken());
//                client.setEmail(str.nextToken());
//                client.setNationality(str.nextToken());
//                client.setCity(str.nextToken());
//                client.setOccupation(str.nextToken());
//                client.setRegisterdate(str.nextToken());
//                if (client.getClientId().matches(IDPattern) && client.getName().matches(namePattern) && client.getAddress().matches(addressPattern) && client.getPhoneno().matches(mobileNumberPattern) && client.getEmail().matches(emailPattern) && client.getNationalId().matches(NI))
//                {
//                    assertEquals(true, true);
//                    ClientDao.update(client);
//                }
//                else
//                {
//                    assertEquals(false, false);
//                    ClientDao.update(client);
//                }
//                data = "";
//            }
//            workbook.close();
//            file.close();
//        } catch (IOException e) {
//            System.out.println("fail test case");
//        }
//    }

//    @Test
//    public void testDelete() {
//        Client client = new Client();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\DeleteClient.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            // Get the first sheet
//            Sheet sheet = workbook.getSheetAt(0);
//            // Iterate over rows
//            for (Row row : sheet) {
//                // Iterate over cells
//                for (Cell cell : row) {
//                    // Print cell value
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_STRING:
//                            data += cell.getStringCellValue() + "*";
//                            break;
//                        case Cell.CELL_TYPE_NUMERIC:
//                            data += (int) cell.getNumericCellValue() + "*";
//                            break;
//                        default:
//                    }
//                }
//                str = new StringTokenizer(data, "*");
//                client.setClientId(str.nextToken());
//                if(client.getClientId().matches(IDPattern))
//                {
//                    assertEquals(true, true);
//                    ClientDao.delete(client);
//                }
//                else
//                {
//                    assertEquals(false, false);
//                    ClientDao.delete(client);
//                }
//                data = "";
//            }
//            workbook.close();
//            file.close();
//        } catch (IOException e) {
//            System.out.println("fail test case");
//        }
//    }

//    @Test
//    public void testDeleteWithNationalID() {
//        Client client = new Client();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\DeleteClientWithNationalID.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            // Get the first sheet
//            Sheet sheet = workbook.getSheetAt(0);
//            // Iterate over rows
//            for (Row row : sheet) {
//                // Iterate over cells
//                for (Cell cell : row) {
//                    // Print cell value
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_STRING:
//                            data += cell.getStringCellValue() + "*";
//                            break;
//                        case Cell.CELL_TYPE_NUMERIC:
//                            data += (int) cell.getNumericCellValue() + "*";
//                            break;
//                        default:
//                    }
//                }
//                str = new StringTokenizer(data, "*");
//                client.setClientId(str.nextToken());
//                client.setNationalId(str.nextToken());
//                if(client.getClientId().matches(IDPattern) && client.getNationalId().matches(NI))
//                {
//                    assertEquals(true, true);
//                    ClientDao.deleteWithNationalId(client);
//                }
//                else
//                {
//                    assertEquals(false, false);
//                    ClientDao.deleteWithNationalId(client);
//                }
//                data = "";
//            }
//            workbook.close();
//            file.close();
//        } catch (IOException e) {
//            System.out.println("fail test case");
//        }
//    }
//
//
//    @Test
//    public void testSearchUpdate() {
//        Client client = new Client();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\DeleteClient.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            // Get the first sheet
//            Sheet sheet = workbook.getSheetAt(0);
//            // Iterate over rows
//            for (Row row : sheet) {
//                // Iterate over cells
//                for (Cell cell : row) {
//                    // Print cell value
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_STRING:
//                            data += cell.getStringCellValue() + "*";
//                            break;
//                        case Cell.CELL_TYPE_NUMERIC:
//                            data += (int) cell.getNumericCellValue() + "*";
//                            break;
//                        default:
//                    }
//                }
//                str = new StringTokenizer(data, "*");
//                client.setClientId(str.nextToken());
//                {
//                    if (i == 0) {
//                        assertEquals(true, Client.testDeleteClient(client));
//                        ClientDao.searchUpdate(client.getClientId());
//                        i++;
//                    } else {
//                        assertEquals(false, Client.testDeleteClient(client));
//                        ClientDao.searchUpdate(client.getClientId());
//                    }
//                }
//                data = "";
//            }
//            workbook.close();
//            file.close();
//        } catch (IOException e) {
//            System.out.println("fail test case");
//        }
//    }
//
//    @Test
//    public void testSearchDelete() {
//        Client client = new Client();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\DeleteClient.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            // Get the first sheet
//            Sheet sheet = workbook.getSheetAt(0);
//            // Iterate over rows
//            for (Row row : sheet) {
//                // Iterate over cells
//                for (Cell cell : row) {
//                    // Print cell value
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_STRING:
//                            data += cell.getStringCellValue() + "*";
//                            break;
//                        case Cell.CELL_TYPE_NUMERIC:
//                            data += (int) cell.getNumericCellValue() + "*";
//                            break;
//                        default:
//                    }
//                }
//                str = new StringTokenizer(data, "*");
//                client.setClientId(str.nextToken());
//                {
//                    if (i == 0) {
//                        assertEquals(true, Client.testDeleteClient(client));
//                        ClientDao.searchDelete(client.getClientId());
//                        i++;
//                    } else {
//                        assertEquals(false, Client.testDeleteClient(client));
//                        ClientDao.searchDelete(client.getClientId());
//                    }
//                }
//                data = "";
//            }
//            workbook.close();
//            file.close();
//        } catch (IOException e) {
//            System.out.println("fail test case");
//        }
//    }
//
//    @Test
//    public void testGetAllRecords() {
//        Client client = new Client();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\GetAllClientRecords.xlsx");
//            XSSFWorkbook workbook = new XSSFWorkbook(file);
//            // Get the first sheet
//            Sheet sheet = workbook.getSheetAt(0);
//            // Iterate over rows
//            for (Row row : sheet) {
//                // Iterate over cells
//                for (Cell cell : row) {
//                    // Print cell value
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_STRING:
//                            data += cell.getStringCellValue() + "*";
//                            break;
//                        case Cell.CELL_TYPE_NUMERIC:
//                            data += (int) cell.getNumericCellValue() + "*";
//                            break;
//                        default:
//                    }
//                }
//                str = new StringTokenizer(data, "*");
//                client.setNationalId(str.nextToken());
//                {
//                    if (i == 0) {
//                        assertEquals(true, Client.testGetAllRecords(client));
//                        ClientDao.getAllRecords(client.getNationalId());
//                        i++;
//                    } else {
//                        assertEquals(false, Client.testGetAllRecords(client));
//                        ClientDao.getAllRecords(client.getNationalId());
//                    }
//                }
//                data = "";
//            }
//            workbook.close();
//            file.close();
//        } catch (IOException e) {
//            System.out.println("fail test case");
//        }
//    }

}
