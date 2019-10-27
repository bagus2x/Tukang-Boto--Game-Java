// bagus2x Oct 17, 2019

package bagus.game.logic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Draw {


	public static List<List<Integer>> arrayFa(){
		
		List<List<Integer>> b;
		b = new ArrayList<List<Integer>>();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 10; j++) {
				b.add(Arrays.asList(3+j*60 , 3+i*20));				
			}
		}		
		return b;
	}
	
	public static List<List<Integer>> arrayF(){
		
		List<List<Integer>> b;
		b = new ArrayList<List<Integer>>();
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 10; j++) {			
				b.add(Arrays.asList(3+j*60 , 3+i*20));			
			}
		}
		return b;
	}
	
	
	public void bricks(Graphics g,int[] itc, List<List<Integer>> array,List<List<Integer>> randomColor, boolean play) {
		for(int i =0; i<array.size(); i++) {
			if(itc[0] == array.get(i).get(0) && itc[1] == array.get(i).get(1)) {
				if(play) {
					array.remove(i);
				}		
			}
		}
			
		for(int i = 0; i <array.size(); i++) {
			g.setColor(new Color(randomColor.get(i).get(0), randomColor.get(i).get(1), randomColor.get(i).get(2)));
			g.drawRect(array.get(i).get(0), array.get(i).get(1), 57, 17);
		}		
	}
}
