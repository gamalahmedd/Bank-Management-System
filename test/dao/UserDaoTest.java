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
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
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

    public String emailPattern = "^[A-Za-z]{5}\\d+@[A-Za-z]+\\.[A-Za-z]{2,6}$"; //valid email -> gemyy555@gmail.com
    public String mobileNumberPattern = "^1[0125][0-9]{8}$"; //-> Valid Number 01153212712
    public String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"; // at least one digit, at least 8 characters, at least one lowercase, at least uppercase, at least one special character
    public String namePattern = "^[A-Z][a-z]*(\\s+[A-Z][a-z]*)*$"; // valid name -> Gamal Ahmed
    public String addressPattern = "^(\\d{1,}) [a-zA-Z0-9\\s]+(,)? [a-zA-Z]+(/s)?+[a-zA-Z]+(,)? [A-Z]{2} [0-9]{5,6}$";

    private static User userMock;
    
    public UserDaoTest() {
    }

    @BeforeClass
    public static void setUpClass()
    {
        userMock = mock(User.class);
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
                System.out.println(data);
                when(userMock.getName()).thenReturn(str.nextToken());
                when(userMock.getEmail()).thenReturn(str.nextToken());
                when(userMock.getMobileNumber()).thenReturn("0" + str.nextToken());
                when(userMock.getAddress()).thenReturn(str.nextToken());
                when(userMock.getPassword()).thenReturn(str.nextToken());
                when(userMock.getSecurityQuestion()).thenReturn(str.nextToken());
                when(userMock.getAnswer()).thenReturn(str.nextToken());
                when(userMock.getStatus()).thenReturn("false");
                when(UserDao.save(userMock)).thenReturn(true);
                if(i == 0)
                {
                    boolean expResult = true;
                    boolean result = UserDao.save(userMock);
                    assertEquals(expResult, result);
                    i++;
                }
                else
                {
                    boolean expResult = false;
                    boolean result = UserDao.save(userMock);
                    assertEquals(expResult, result);
                }
                UserDao.save(userMock);
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
//                when(userMock.getEmail()).thenReturn(str.nextToken());
//                when(userMock.getPassword()).thenReturn(str.nextToken());
//                if(i == 0)
//                {
//                    User result = UserDao.login(userMock.getEmail(), userMock.getPassword());
//                    assertNotNull(result);
//                    i++;
//                }
//                else
//                {
//                    User result = UserDao.login(userMock.getEmail(), userMock.getPassword());
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

//    @Test
//    public void testGetSecurityQuestion() {
//        User user = new User();
//        String data = "";
//        int i = 0;
//        StringTokenizer str = null;
//        try {
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\GetSecurityQuestionUser.xlsx");
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
//                System.out.println(user.getEmail());
//                if(i == 0)
//                {
//                    User result = UserDao.getSecurityQuestion(user.getEmail());
//                    assertNotNull(result);
//                    i++;
//                }
//                else
//                {
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
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\UpdateUser.xlsx");
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
//                if(user.getEmail().matches(emailPattern) && user.getPassword().matches(passwordPattern))
//                {
//                    assertEquals(true, true);
//                    UserDao.update(user.getEmail(), user.getPassword());
//                }
//                else
//                {
//                    assertEquals(false, false);
//                    UserDao.update(user.getEmail(), user.getPassword());
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
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\GetAllUserRecords.xlsx");
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
//                if(user.getEmail().matches(emailPattern))
//                {
//                    assertEquals(true, true);
//                    UserDao.getAllRecords(user.getEmail());
//                }
//                else
//                {
//                    assertEquals(false, false);
//                    UserDao.getAllRecords(user.getEmail());
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
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\ChangeStatusUser.xlsx");
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
//                if(user.getEmail().matches(emailPattern))
//                {
//                    assertEquals(true, true);
//                    UserDao.changeStatus(user.getEmail(), user.getStatus());
//                }
//                else
//                {
//                    assertEquals(false, false);
//                    UserDao.changeStatus(user.getEmail(), user.getStatus());
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
//            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\DeleteUser.xlsx");
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
//                if(user.getEmail().matches(emailPattern))
//                {
//                    assertEquals(true, true);
//                    UserDao.delete(user.getEmail());
//                }
//                else
//                {
//                    assertEquals(false, false);
//                    UserDao.delete(user.getEmail());
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
