package it.polito.po.test;
import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

	public static Test suite() {
        TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(TestR1_CatalogoProdotti.class);
		suite.addTestSuite(TestR2_Esposizione.class);
		suite.addTestSuite(TestR3_AcquistiScontrini.class);
		suite.addTestSuite(TestR4_CaricamentoFile.class);
		//$JUnit-END$
		return suite;
	}

}
