/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import model.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
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
        System.out.println("save");
        User user = new User();
        String data = "";
        StringTokenizer str = null;
        try {
            File file = new File("C:\\Users\\gemyy\\OneDrive\\Desktop\\SaveUsers.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            itr.next();
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            data += cell.getStringCellValue() + ",";
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            data += (int) cell.getNumericCellValue() + ",";
                            break;
                        default:
                    }
                }
                str = new StringTokenizer(data, ",");
                user.setId(Integer.parseInt(str.nextToken()));
                user.setName(str.nextToken());
                user.setEmail(str.nextToken());
                user.setMobileNumber(str.nextToken());
                user.setAddress(str.nextToken());
                user.setPassword(str.nextToken());
                user.setSecurityQuestion(str.nextToken());
                user.setAnswer(str.nextToken());
                user.setStatus("false");
                data = "";
                UserDao.save(user);
            }
        } catch (Exception e) {
            fail("The test case failed");
        }
    }

//    @Test
//    public void testLogin() {
//        System.out.println("login");
//        String email = "";
//        String password = "";
//        User expResult = null;
//        User result = UserDao.login(email, password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetSecurityQuestion() {
//        System.out.println("getSecurityQuestion");
//        String email = "";
//        User expResult = null;
//        User result = UserDao.getSecurityQuestion(email);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        String email = "";
//        String newPassword = "";
//        UserDao.update(email, newPassword);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testGetAllRecords() {
//        System.out.println("getAllRecords");
//        String email = "";
//        ArrayList<User> expResult = null;
//        ArrayList<User> result = UserDao.getAllRecords(email);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testChangeStatus() {
//        System.out.println("changeStatus");
//        String email = "";
//        String status = "";
//        UserDao.changeStatus(email, status);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testDelete() {
//        System.out.println("delete");
//        String email = "";
//        UserDao.delete(email);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
