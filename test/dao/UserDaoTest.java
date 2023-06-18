/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSave() {
        User user = new User();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\Save.xlsx");
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
                user.setName(str.nextToken());
                user.setEmail(str.nextToken());
                user.setMobileNumber(str.nextToken());
                user.setAddress(str.nextToken());
                user.setPassword(str.nextToken());
                user.setSecurityQuestion(str.nextToken());
                user.setAnswer(str.nextToken());
                user.setStatus("false");
                {
                    if (i == 0) {
                        assertEquals(true, User.testUser(user));
                        UserDao.save(user);
                        i++;
                    } else {
                        assertEquals(false, User.testUser(user));
                        UserDao.save(user);
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
    @Test
    public void testLogin() {
        User user = new User();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\Login.xlsx");
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
                user.setEmail(str.nextToken());
                user.setPassword(str.nextToken());
                System.out.println(user.getEmail());
                {
                    if (i == 0) {
                        assertEquals(true, User.testUpdateUser(user));
                        UserDao.login(user.getEmail(), user.getPassword());
                        i++;
                    } else {
                        assertEquals(false, User.testUpdateUser(user));
                        UserDao.login(user.getEmail(), user.getPassword());
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

    @Test
    public void testGetSecurityQuestion() {
        User user = new User();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\GetSecurityQuestion.xlsx");
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
                user.setEmail(str.nextToken());
                System.out.println(user.getEmail());
                {
                    if (i == 0) {
                        assertEquals(true, User.testUpdateUser(user));
                        UserDao.getSecurityQuestion(user.getEmail());
                        i++;
                    } else {
                        assertEquals(false, User.testUpdateUser(user));
                        UserDao.getSecurityQuestion(user.getEmail());
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

    @Test
    public void testUpdate() {
        User user = new User();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\UpdateNewPassword.xlsx");
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
                user.setEmail(str.nextToken());
                user.setPassword(str.nextToken());
                System.out.println(user.getEmail());
                {
                    if (i == 0) {
                        assertEquals(true, User.testUpdateUser(user));
                        UserDao.update(user.getEmail(), user.getPassword());
                        i++;
                    } else {
                        assertEquals(false, User.testUpdateUser(user));
                        UserDao.update(user.getEmail(), user.getPassword());
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

    @Test
    public void testGetAllRecords() {
        User user = new User();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\GetAllRecords.xlsx");
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
                user.setEmail(str.nextToken());
                System.out.println(user.getEmail());
                {
                    if (i == 0) {
                        assertEquals(true, User.testEmailUser(user));
                        UserDao.getAllRecords(user.getEmail());
                        i++;
                    } else {
                        assertEquals(false, User.testEmailUser(user));
                        UserDao.getAllRecords(user.getEmail());
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

    @Test
    public void testChangeStatus() {
        User user = new User();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\ChangeStatus.xlsx");
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
                        case Cell.CELL_TYPE_BOOLEAN:
                            data += cell.getBooleanCellValue() + "*";
                            break;
                        default:
                    }
                }
                str = new StringTokenizer(data, "*");
                System.out.println(data);
                user.setEmail(str.nextToken());
                user.setStatus(str.nextToken());
                System.out.println(user.getEmail());
                {
                    if (i == 0) {
                        assertEquals(true, User.testEmailUser(user));
                        UserDao.changeStatus(user.getEmail(), user.getStatus());
                        i++;
                    } else {
                        assertEquals(false, User.testEmailUser(user));
                        UserDao.changeStatus(user.getEmail(), user.getStatus());
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

    @Test
    public void testDelete() {
        User user = new User();
        String data = "";
        int i = 0;
        StringTokenizer str = null;
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\gemyy\\OneDrive\\Desktop\\Test\\Delete.xlsx");
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
                user.setEmail(str.nextToken());
                System.out.println(user.getEmail());
                {
                    if (i == 0) {
                        assertEquals(true, User.testEmailUser(user));
                        UserDao.delete(user.getEmail());
                        i++;
                    } else {
                        assertEquals(false, User.testEmailUser(user));
                        UserDao.getAllRecords(user.getEmail());
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
}
