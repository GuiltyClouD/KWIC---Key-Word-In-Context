package abstract_data_type;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShifterClassTest {
    @Test
    public void testGetShiftedLines() {
        String[] array = {"The Day after Tomorrow", "Fast and Furious"};
        String[] arrayIgnored = {"is", "the", "and"};
        String[] arrayRequired = {"Day" , "Furious"};
        String[] arraySearchWord = {"Day" , "Furious"};
        List<String> lines = Arrays.asList(array);
        List<String> ignoredLines = Arrays.asList(arrayIgnored);
        List<String> requiredLines = Arrays.asList(arrayRequired);
        List<String> searchLines = Arrays.asList(arraySearchWord);

        CircularShift shifter = new ShifterClass(lines, ignoredLines, requiredLines, searchLines);
        List<String> result = shifter.getShiftedLines();
        //System.out.println(result);

        assertEquals("Day after Tomorrow The", result.get(0));
        assertEquals("Furious Fast and", result.get(1));
    }
}
