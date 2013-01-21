package testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ DctTest.class, ClassRefTest.class })
public class AllSuite {

}
