import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EvaluateByStringNegativeTest {


    private String expression;
    private static EvaluateByString service;

    public EvaluateByStringNegativeTest(String expression) {
        this.expression = expression;
    }

    @BeforeClass
    public static void setUp() throws EvaluateCalculationException {
        service = new EvaluateByString();
    }

    @AfterClass
    public static void tearDown() throws EvaluateCalculationException {
        service = null;
    }

    @Test(expected = EvaluateCalculationException.class)
    public void testEvaluate(){
        service.evaluate(expression);
    }


    @Parameterized.Parameters(name = "expression = {0}")
    public static Collection<Object[]> dataProvider()
    {
        return Arrays.asList(new Object[][]{
                {"qwereqr"},
                {"2/0"}

        });
    }

}
