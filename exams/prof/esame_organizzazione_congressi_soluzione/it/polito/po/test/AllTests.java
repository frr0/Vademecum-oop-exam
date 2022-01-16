package it.polito.po.test;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

  public static Test suite() {
    TestSuite suite = new TestSuite("Test for default package");
    //$JUnit-BEGIN$
    suite.addTest(new TestSuite(TestR1_CentriSale.class));
    suite.addTest(new TestSuite(TestR2_Congressi.class));
    suite.addTest(new TestSuite(TestR3_Sessioni.class));
    suite.addTest(new TestSuite(TestR4_Programma.class));
    //$JUnit-END$
    return suite;
  }
}
