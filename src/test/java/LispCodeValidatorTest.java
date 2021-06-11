import static org.junit.Assert.*;
import org.junit.Test;

public class LispCodeValidatorTest {


    @Test
    public void testValidCode(){
        String testVal = ";; To make QUEUE-NEXT efficient, give the Compiler some hints.\n" +
                "(eval-when (compile eval)\n" +
                "  (proclaim '(inline queue-next))\n" +
                "  (proclaim '(function queue-next (queue fixnum) fixnum))\n" +
                "  )";
        assertTrue(LispCodeValidator.verifyLISPCode(testVal));
    }

    @Test
    public void testNoBeginningOpenParenthesis(){
        String testVal = ";; To make QUEUE-NEXT efficient, give the Compiler some hints.\n" +
                "eval-when (compile eval)\n" +
                "  (proclaim '(inline queue-next))\n" +
                "  (proclaim '(function queue-next (queue fixnum) fixnum))\n" +
                "  )";
        assertFalse(LispCodeValidator.verifyLISPCode(testVal));
    }

    @Test
    public void testMissingCloseParenthesis(){
        String testVal = ";; To make QUEUE-NEXT efficient, give the Compiler some hints.\n" +
                "(eval-when (compile eval)\n" +
                "  (proclaim '(inline queue-next))\n" +
                "  (proclaim '(function queue-next (queue fixnum) fixnum)\n" +
                "  )";
        assertFalse(LispCodeValidator.verifyLISPCode(testVal));
    }

    @Test
    public void testMissingOpenParenthesis(){
        String testVal = ";; To make QUEUE-NEXT efficient, give the Compiler some hints.\n" +
                "(eval-when compile eval)\n" +
                "  (proclaim '(inline queue-next))\n" +
                "  (proclaim '(function queue-next (queue fixnum) fixnum))\n" +
                "  )";
        assertFalse(LispCodeValidator.verifyLISPCode(testVal));
    }

    @Test
    public void testEmptyString(){
        String testVal = "";
        assertTrue(LispCodeValidator.verifyLISPCode(testVal));
    }

    @Test
    public void testNullString(){
        String testVal = null;
        assertTrue(LispCodeValidator.verifyLISPCode(testVal));
    }


}
