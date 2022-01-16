package it.polito.po.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite(AllTests.class.getName());
        //$JUnit-BEGIN$
        suite.addTestSuite(TestR1_ElementiTopografici.class);
        suite.addTestSuite(TestR2_Monumenti.class);
        suite.addTestSuite(TestR3_Incroci.class);
        suite.addTestSuite(TestR4_CaricamentoDaFile.class);
        //$JUnit-END$
        return suite;
    }

}
