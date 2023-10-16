package abstract_data_type;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlphabetizerClassTest {
    @Test
    public void testGetSortedLines() {
        String[] array = {"A test", "a test", "Testing simple","simple testing"};
        List<String> lines = Arrays.asList(array);

        Alphabetizer alphabetizer = new AlphabetizerClass(lines);
        List<String> result = alphabetizer.getLines();
        //System.out.println(result);

        assertTrue(lines.size() == 4);
        assertEquals("A test", result.get(0));
        assertEquals("a test", result.get(1));
        assertEquals("simple testing", result.get(2));
        assertEquals("Testing simple", result.get(3));
    }

}
