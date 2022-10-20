package tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// TEst class i utulities class a baglamak icin @Listeners annotation u kullanilir
@Listeners(utilities.Listeners.class)
public class ListenersTest1 {

    @Test
    public void test01() {
        System.out.println("Test case 1 - PASSED");
        Assert.assertTrue(true);  // pass
    }

    @Test
    public void test02() {
        System.out.println("Test case 2 - FAILED");
        Assert.assertTrue(false); // fail
    }

    @Test
    public void test03() {

        System.out.println("Test case 3 - SKİPPED");
        throw new SkipException("Skip edilecek"); // skip

    }
}
