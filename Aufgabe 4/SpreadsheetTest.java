import org.junit.*;

import static org.junit.Assert.*;

public class SpreadsheetTest {
    @Test
    public void testSetget1() {
        Spreadsheet sheet = new Spreadsheet(2, 2);
        sheet.set(1, 1, 42);
        assertEquals("Value not correctly set in cell 1,1", 42, sheet.get(1, 1));
    }

    @Test
    public void testSetget2() {
        Spreadsheet sheet = new Spreadsheet(101, 101);
        for (int j=1; j<=100; j++) {
            for (int i=1; i<=100; i++) {
                sheet.set(i, j, i+j);
            }
        }

        for (int j=1; j<=100; j++) {
            for (int i=1; i<=100; i++) {
                assertEquals("Value not correctly set in cell " + i + ", " + j, i+j, sheet.get(i, j));
            }
        }
    }

    @Test
    public void testSum1() {
        Spreadsheet sheet = new Spreadsheet(4,4);
        sheet.set(1, 1, 1);
        sheet.set(1, 2, 2);
        sheet.setSumCalculation(1, 3, 1, 1, 1, 2);
        assertEquals("Wrong initial sum value", 3, sheet.get(1, 3));
    }

    @Test
    public void testSum2() {
        Spreadsheet sheet = new Spreadsheet(5,5);
        sheet.set(1, 1, 1);
        sheet.set(1, 2, 1);
        sheet.set(1, 3, 1);
        sheet.setSumCalculation(1, 4, 1, 1, 1, 3);
        assertEquals("Wrong initial sum value", 3, sheet.get(1, 4));
        sheet.set(1, 2, 2);
        assertEquals("Wrong sum value after change", 4, sheet.get(1, 4));
        sheet.set(1, 3, 3);
        assertEquals("Wrong sum value after change", 6, sheet.get(1, 4));
    }

    @Test
    public void testSum3() {
        Spreadsheet sheet = new Spreadsheet(5,5);
        sheet.set(1, 1, 10);
        sheet.set(2, 1, 20);
        sheet.set(1, 2, 30);
        sheet.set(2, 2, 40);
        sheet.setSumCalculation(1, 3, 1, 1, 1, 2);
        sheet.setSumCalculation(2, 3, 2, 1, 2, 2);
        sheet.setSumCalculation(3, 3, 3, 1, 3, 2);
        sheet.setSumCalculation(3, 1, 1, 1, 2, 1);
        sheet.setSumCalculation(3, 2, 1, 2, 2, 2);
        assertEquals(40, sheet.get(1, 3));
        assertEquals(60, sheet.get(2, 3));
        assertEquals(30, sheet.get(3, 1));
        assertEquals(70, sheet.get(3, 2));
        assertEquals(100, sheet.get(3, 3));
    }

    @Test
    public void testSum4() {
        Spreadsheet sheet = new Spreadsheet(5,5);
        sheet.set(1, 1, 10);
        sheet.set(2, 1, 20);
        sheet.set(1, 2, 30);
        sheet.set(2, 2, 40);
        sheet.setSumCalculation(3, 3, 3, 1, 3, 2);
        sheet.setSumCalculation(3, 1, 1, 1, 2, 1);
        sheet.setSumCalculation(3, 2, 1, 2, 2, 2);
        sheet.setSumCalculation(1, 3, 1, 1, 1, 2);
        sheet.setSumCalculation(2, 3, 2, 1, 2, 2);
        assertEquals(40, sheet.get(1, 3));
        assertEquals(60, sheet.get(2, 3));
        assertEquals(30, sheet.get(3, 1));
        assertEquals(70, sheet.get(3, 2));
        assertEquals(100, sheet.get(3, 3));
    }
}
