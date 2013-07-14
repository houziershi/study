package testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.StringConstansTest;
import test.EnumTest;
import test.CalendarTest;
import test.MathTest;
import test.UserAuthTest;
import test.NumberStringTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	StringConstansTest.class, EnumTest.class, CalendarTest.class, //
	MathTest.class, UserAuthTest.class, NumberStringTest.class 
})
public class AllSuite {

}
