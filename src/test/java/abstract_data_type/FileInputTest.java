package abstract_data_type;

import org.junit.Test;

import static org.junit.Assert.*;
import java.io.File;

public class FileInputTest {
    @Test
    public void testReadFileSuccess() {
        File fileName = new File("a2Titles2.txt");
        boolean fileExist = false;
        if (fileName.exists())
        {
            fileExist = true;
        }
        assertEquals(true, fileExist);
    }

    @Test
    public void testReadFileFail() {
        File fileName = new File("Titles2.txt");
        boolean fileExist = false;
        if (fileName.exists())
        {
            fileExist = true;
        }
        assertEquals(false, fileExist);
    }
}