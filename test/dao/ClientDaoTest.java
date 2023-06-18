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


//    @Test
//    public void testSave() {
//        Client client = new Client();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\SaveClient.xlsx");
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
//                {
//                    if (i == 0) {
//                        assertEquals(true, Client.testSaveClient(client));
//                        ClientDao.save(client);
//                        i++;
//                    } else {
//                        assertEquals(false, Client.testSaveClient(client));
//                        ClientDao.save(client);
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
//                {
//                    if (i == 0) {
//                        assertEquals(true, Client.testUpdateClient(client));
//                        ClientDao.update(client);
//                        i++;
//                    } else {
//                        assertEquals(false, Client.testUpdateClient(client));
//                        ClientDao.update(client);
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

    @Test
    public void testUpdateWithoutNationalID() {
        Client client = new Client();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\UpdateClient.xlsx");
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
                {
                    if (i == 0) {
                        assertEquals(true, Client.testUpdateClient(client));
                        ClientDao.updateWithoutNationalID(client);
                        i++;
                    } else {
                        assertEquals(false, Client.testUpdateClient(client));
                        ClientDao.updateWithoutNationalID(client);
                    }
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
//    public void testDelete() {
//        System.out.println("delete");
//        Client client = null;
//        ClientDao.delete(client);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
// 
//    @Test
//    public void testSearchUpdate() {
//        System.out.println("searchUpdate");
//        String flag = "";
//        ResultSet expResult = null;
//        ResultSet result = ClientDao.searchUpdate(flag);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//
//    @Test
//    public void testSearchDelete() {
//        System.out.println("searchDelete");
//        String flag = "";
//        ResultSet expResult = null;
//        ResultSet result = ClientDao.searchDelete(flag);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//
//    @Test
//    public void testGetAllRecords() {
//        System.out.println("getAllRecords");
//        String nationalID = "";
//        ArrayList<Client> expResult = null;
//        ArrayList<Client> result = ClientDao.getAllRecords(nationalID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
