package it.polito.po.test;
import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

	public static Test suite() {
        TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestR1_Palinsesti.class);
		suite.addTestSuite(TestR2_Programmi.class);
		suite.addTestSuite(TestR3_Programmazione.class);
		suite.addTestSuite(TestR4_LetturaDaFile.class);
		//$JUnit-END$
		return suite;
	}

}
