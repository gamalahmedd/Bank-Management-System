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
                if (i == 0)
                {
                    boolean expectedResult = true;
                    boolean result = ClientDao.save(client);
                    assertEquals(expectedResult, result);
                    i++;
                }
                else
                {
                    boolean expectedResult = false;
                    boolean result = ClientDao.save(client);
                    assertEquals(expectedResult, result);
                }
                data = "";
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.out.println("fail test case");
        }
    }

    @Test
    public void testUpdate() {
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
                if (i == 0)
                {
                    boolean expectedResult = true;
                    boolean result = ClientDao.update(client);
                    assertEquals(expectedResult, result);
                    i++;
                }
                else
                {
                    boolean expectedResult = false;
                    boolean result = ClientDao.update(client);
                    assertEquals(expectedResult, result);
                }
                data = "";
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.out.println("fail test case");
        }
    }

    @Test
    public void testUpdateWithNationalID() {
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
                if (i == 0)
                {
                    boolean expectedResult = true;
                    boolean result = ClientDao.updateWithNationalID(client);
                    assertEquals(expectedResult, result);
                    i++;
                }
                else
                {
                    boolean expectedResult = false;
                    boolean result = ClientDao.deleteWithNationalId(client);
                    assertEquals(expectedResult, result);
                }
                data = "";
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.out.println("fail test case");
        }
    }

    @Test
    public void testDelete() {
        Client client = new Client();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\DeleteClient.xlsx");
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
                if (i == 0)
                {
                    boolean expectedResult = true;
                    boolean result = ClientDao.delete(client);
                    assertEquals(expectedResult, result);
                    i++;
                }
                else
                {
                    boolean expectedResult = false;
                    boolean result = ClientDao.delete(client);
                    assertEquals(expectedResult, result);
                }
                data = "";
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.out.println("fail test case");
        }
    }

    @Test
    public void testDeleteWithNationalID() {
        Client client = new Client();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\DeleteClientWithNationalID.xlsx");
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
                client.setNationalId(str.nextToken());
                if (i == 0)
                {
                    boolean expectedResult = true;
                    boolean result = ClientDao.deleteWithNationalId(client);
                    assertEquals(expectedResult, result);
                    i++;
                }
                else
                {
                    boolean expectedResult = false;
                    boolean result = ClientDao.deleteWithNationalId(client);
                    assertEquals(expectedResult, result);
                }
                data = "";
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.out.println("fail test case");
        }
    }


    @Test
    public void testSearchUpdate() {
        Client client = new Client();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\DeleteClient.xlsx");
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
                if (i == 0)
                {
                    ResultSet result = ClientDao.searchUpdate(client.getClientId());
                    assertNotNull(result);
                    i++;
                }
                else
                {
                    ResultSet result = ClientDao.searchUpdate(client.getClientId());
                    assertNull(result);
                }
                data = "";
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.out.println("fail test case");
        }
    }

    @Test
    public void testSearchDelete() {
        Client client = new Client();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\DeleteClient.xlsx");
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
                if (i == 0)
                {
                    ResultSet result = ClientDao.searchDelete(client.getClientId());
                    assertNotNull(result);
                    i++;
                }
                else
                {
                    ResultSet result = ClientDao.searchDelete(client.getClientId());
                    assertNull(result);
                }
                data = "";
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.out.println("fail test case");
        }
    }

    @Test
    public void testGetAllRecords() {
        Client client = new Client();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\GetAllClientRecords.xlsx");
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
                client.setNationalId(str.nextToken());
                if (i == 0)
                {
                    ArrayList<Client> result = ClientDao.getAllRecords(client.getClientId());
                    assertNotNull(result);
                    i++;
                }
                else
                {
                    ArrayList<Client> result = ClientDao.getAllRecords(client.getClientId());
                    assertNull(result);
                }
                data = "";
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.out.println("fail test case");
        }
    }
}
