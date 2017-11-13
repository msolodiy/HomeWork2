import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EvaluateByStringTest {

    private String expression;
    private String expressionResult;
    private static EvaluateByString service;

    public EvaluateByStringTest(String expressionResult, String expression) {
        this.expression = expression;
        this.expressionResult = expressionResult;
    }

    @BeforeClass
    public static void setUp() throws EvaluateCalculationException {
        service = new EvaluateByString();
    }

    @AfterClass
    public static void tearDown() throws EvaluateCalculationException {
        service = null;
    }

    @Test()
    public void testEvaluate(){
        Assert.assertEquals(expressionResult, service.evaluate(expression));
    }


    @Parameterized.Parameters(name = "expression = {1}")
    public static Collection<Object[]> dataProvider()
    {
        return Arrays.asList(new Object[][]{
                {"3.0", "1+2"},
                {"4.0", "2*2"},
                {"1.0", "2/2"},
                {"0.0", "2-2"}

        });
    }

}
