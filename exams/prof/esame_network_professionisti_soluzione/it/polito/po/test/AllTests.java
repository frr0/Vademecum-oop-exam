package it.polito.po.test;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

  public static Test suite() {
    TestSuite suite = new TestSuite("Test for default package");
    //$JUnit-BEGIN$
    suite.addTest(new TestSuite(TestR1_Iscritti.class));
    suite.addTest(new TestSuite(TestR2_Entita.class));
    suite.addTest(new TestSuite(TestR3_Periodi.class));
    suite.addTest(new TestSuite(TestR4_Connessioni.class));
    //$JUnit-END$
    return suite;
  }
}
