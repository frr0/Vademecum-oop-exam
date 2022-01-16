package it.polito.po.test;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

  public static Test suite() {
    TestSuite suite = new TestSuite("Test for default package");
    //$JUnit-BEGIN$
    suite.addTest(new TestSuite(TestR1_Schede.class));
    suite.addTest(new TestSuite(TestR2_Ricerche.class));
    suite.addTest(new TestSuite(TestR3_ClientiTransazioni.class));
    suite.addTest(new TestSuite(TestR4_Introiti.class));
    suite.addTest(new TestSuite(TestR5_LetturaDaFile.class));
    //$JUnit-END$
    return suite;
  }
}
