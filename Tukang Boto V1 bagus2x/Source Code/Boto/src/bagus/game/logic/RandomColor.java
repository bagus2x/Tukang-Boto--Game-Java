// bagus2x Oct 18, 2019
package bagus.game.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomColor {
	Random rand = new Random();
    public List<List<Integer>> getColor() {
    	List<List<Integer>> b;
    	int cR, cG, cB;
		b = new ArrayList<List<Integer>>();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 10; j++) {
			    cR = rand.nextInt(255);
			    cG = rand.nextInt(255);
			    cB = rand.nextInt(255);
			    if(cR < 150 && cG < 150 && cB < 150) {
				    cR = 200 + rand.nextInt(50);
				    cG = 200 + rand.nextInt(50);
				    cB = 190 +  rand.nextInt(60);
			    }
				b.add(Arrays.asList(cR , cG, cB));			
			}
		}	
		return b;
    }
}
