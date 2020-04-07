/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw07.exercise2test;

import sw03.exercise1.MathHelper;
import static org.junit.Assert.*;

/**
 *
 * @author yannk
 */
public class MathHelperTest {
    @Test
    public void testMaxInt() {
        int result = MathHelper.max(1,2);
        assertEquals(result, 2);
    }
}
