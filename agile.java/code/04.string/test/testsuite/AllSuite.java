package testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.StringConstansTest;
import test.EnumTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	StringConstansTest.class, EnumTest.class
})
public class AllSuite {

}
