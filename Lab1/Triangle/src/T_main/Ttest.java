package T_main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ttest {

	 Tmain tmain = new Tmain();

	    @Test
	    public void testCheck() {
	        int temp = tmain.check(2, 2, 5 );
	        assertEquals( -1 , temp );
	        temp = tmain.check(2, 2, 2);
	        assertEquals( 1 , temp );
	        temp = tmain.check(2, 2, 3 );
	        assertEquals( 2 , temp );
	        temp = tmain.check(3, 4, 5);
	        assertEquals ( 3 , temp );
	        temp = tmain.check(2, 3, 4);
	        assertEquals ( 0 , temp );
	    }
}
