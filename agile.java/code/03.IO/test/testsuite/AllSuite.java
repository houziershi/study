package testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ReportTest.class, FileTest.class,
	BaseTypeTest.class, ObjectSaveTest.class })
public class AllSuite {

}
