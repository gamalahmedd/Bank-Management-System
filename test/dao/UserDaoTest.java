/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bank.DbOperations;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
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
import org.mockito.Matchers;
import static org.mockito.Matchers.anyString;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.powermock.api.mockito.PowerMockito;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

/**
 *
 * @author gemyy
 */
public class UserDaoTest {
    
    public UserDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp()
    {
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSave() {
        UserDao operations = new UserDao();
        User userMock = mock(User.class);
        DbOperations dbMock = mock(DbOperations.class);
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\SaveUser.xlsx");
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
                when(userMock.getName()).thenReturn(str.nextToken());
                when(userMock.getEmail()).thenReturn(str.nextToken());
                when(userMock.getMobileNumber()).thenReturn("0" + str.nextToken());
                when(userMock.getAddress()).thenReturn(str.nextToken());
                when(userMock.getPassword()).thenReturn(str.nextToken());
                when(userMock.getSecurityQuestion()).thenReturn(str.nextToken());
                when(userMock.getAnswer()).thenReturn(str.nextToken());
                when(userMock.getStatus()).thenReturn("false");
                when(dbMock.setDataOrDelete(anyString(), anyString())).thenReturn(true);
                boolean expResult = true;
                boolean result = operations.save(userMock);
                assertEquals(expResult, result);
                verify(dbMock, times(1)).setDataOrDelete(anyString(), anyString());
                data = "";
            }
            workbook.close();
            file.close();
        } catch (IOException e) {
            System.out.println("fail test case");
        }
    }
    
//    @Test
//    public void testLogin() {
//            User user = new User();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\LoginUser.xlsx");
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
//                user.setEmail(str.nextToken());
//                user.setPassword(str.nextToken());
//                if(i == 0)
//                {
//                    User result = UserDao.login(user.getEmail(), user.getPassword());
//                    assertNotNull(result);
//                    i++;
//                }
//                else
//                {
//                    User result = UserDao.login(user.getEmail(), user.getPassword());
//                    assertNull(result);
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
//    public void testGetSecurityQuestion() {
//        User user = new User();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\GetSecurityQuestion.xlsx");
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
//                user.setEmail(str.nextToken());
//                if (i == 0) {
//                    User result = UserDao.getSecurityQuestion(user.getEmail());
//                    assertNotNull(result);
//                    i++;
//                } else {
//                    User result = UserDao.getSecurityQuestion(user.getEmail());
//                    assertNull(result);
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
//    public void testUpdate() {
//        User user = new User();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\UpdateNewPassword.xlsx");
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
//                user.setEmail(str.nextToken());
//                user.setPassword(str.nextToken());
//                if (i == 0) {
//                    boolean expectedResult = true;
//                    boolean result = UserDao.update(user.getEmail(), user.getPassword());
//                    i++;
//                } else {
//                    boolean expectedResult = false;
//                    boolean result = UserDao.update(user.getEmail(), user.getPassword());
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
//        User user = new User();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\GetAllRecords.xlsx");
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
//                user.setEmail(str.nextToken());
//                if (i == 0) {
//                    ArrayList<User> result = UserDao.getAllRecords(user.getEmail());
//                    assertNotNull(result);
//                    i++;
//                } else {
//                    ArrayList<User> result = UserDao.getAllRecords(user.getEmail());
//                    assertNull(result);
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
//    public void testChangeStatus() {
//        User user = new User();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\ChangeStatus.xlsx");
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
//                        case Cell.CELL_TYPE_BOOLEAN:
//                            data += cell.getBooleanCellValue() + "*";
//                            break;
//                        default:
//                    }
//                }
//                str = new StringTokenizer(data, "*");
//                user.setEmail(str.nextToken());
//                user.setStatus(str.nextToken());
//                if (i == 0) {
//                    boolean expectedResult = true;
//                    boolean result = UserDao.changeStatus(user.getEmail(), user.getStatus());
//                    assertEquals(expectedResult, result);
//                    i++;
//                } else {
//                    boolean expectedResult = false;
//                    boolean result = UserDao.changeStatus(user.getEmail(), user.getStatus());
//                    assertEquals(expectedResult, result);
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
//    public void testDelete() {
//        User user = new User();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\Delete.xlsx");
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
//                user.setEmail(str.nextToken());
//                {
//                    if (i == 0) {
//                        boolean expectedResult = true;
//                        boolean result = UserDao.delete(user.getEmail());
//                        assertEquals(expectedResult, result);
//                        i++;
//                    } else {
//                        boolean expectedResult = false;
//                        boolean result = UserDao.delete(user.getEmail());
//                        assertEquals(expectedResult, result);
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
