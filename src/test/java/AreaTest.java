import coordinateProcessing.AreaProcessing;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AreaTest {
    AreaProcessing areaProcessing;
    @Before
    public void init(){
        areaProcessing = new AreaProcessing();
    }
    @Test
    public void firstQuarter(){
        assertTrue(areaProcessing.areaCheck(
                0.5,1d,1f
        ));

        assertTrue(areaProcessing.areaCheck(
                0.5d,0.75d,1.5f
        ));

    }
    @Test
    public void secondQuarter(){
        assertTrue(areaProcessing.areaCheck(
                -0.491d,0.44d,2.5f
        ));
        assertFalse(areaProcessing.areaCheck(
                -1.229d,1.199d,2.5f
        ));
    }
    @Test
    @Ignore
    public void bornToDie(){
        assertTrue("Checker of the failing",false);
    }
}
