import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CheckItTest  {

    private String getOutputOfCheckIt(boolean a, boolean b, boolean c) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        CheckIt.checkIt(a, b, c);
        System.setOut(System.out);
        return outContent.toString().trim();
    }

    @Test
    public void testPredicateTrueCoverage() {
        assertEquals("P is true", getOutputOfCheckIt(false, true, true));

    }
    @Test
    public void testPredicateFalseCoverage() {
        assertEquals("P isn't true", getOutputOfCheckIt(false, true, false));
    }
    @Test
    public void testClauseAllTrueCoverage() {
        assertEquals("P is true", getOutputOfCheckIt(true, true, true));
    }
    @Test
    public void testClauseAllFalseCoverage() {
        assertEquals("P isn't true", getOutputOfCheckIt(false, false, false));
    }
    @Test
    public void testCACC_MajorClauseA_isTrue() {
        assertEquals("P is true", getOutputOfCheckIt(true, false, true));
    }
    @Test
    public void testCACC_MajorClauseA_isFalse() {
        assertEquals("P isn't true", getOutputOfCheckIt(false, false, false));
    }
    @Test
    public void testRACC_MajorClauseA_isTrue() {
        assertEquals("P is true", getOutputOfCheckIt(true, false, true));
    }
    @Test
    public void testRACC_MajorClauseA_isFalse() {
        assertEquals("P isn't true", getOutputOfCheckIt(false, false, true));
    }

}
