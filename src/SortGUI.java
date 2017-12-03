
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SortGUI {

	public static void main (String args[]) throws InterruptedException {
		
		JFrame frame = new JFrame("Visual Sort");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		for (int width = 0; width < image.getWidth(); width++) {
			for (int height = 0;  height < image.getHeight(); height++) {	
				image.setRGB(width, height, new Color(0, 0, 0).getRGB());
			}
		}
		ImageIcon icon = new ImageIcon(image);
		JLabel label = new JLabel(icon);
		frame.add(label);
		frame.pack();
		SortGUI sorter = new SortGUI();
		
		//int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		int[] array = sorter.shuffleList(1, 100);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
		sorter.updateImage(array, image, frame);
		
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(array, image, frame); 
		
	}
	
	
	public void updateImage(int[] array, BufferedImage image, JFrame frame) throws InterruptedException {
		int arrayMax = array.length;
		
		int verticalScale = image.getHeight()/arrayMax;	
		int horizontalScale = image.getWidth()/array.length;
		
		//clear canvas
		for (int width = 0; width < image.getWidth(); width++) {
			for (int height = 0;  height < image.getHeight(); height++) {	
				image.setRGB(width, height, new Color(0, 0, 0).getRGB());
			}
		}
		
		//draw state
		for (int i = 0; i < array.length; i++) {
			int x_start = horizontalScale * i;
			int x_end = x_start + horizontalScale - 1;
			int y_start = image.getHeight() - (array[i] * verticalScale - 1);
			int y_end = image.getHeight() - 1;
			
			for (int width = x_start; width <= x_end; width++)
			{
				for (int height = y_start; height <= y_end; height++) {
					image.setRGB(width, height, new Color(255, 255, 255).getRGB());
				}
			}
			
		}

		frame.invalidate();
		frame.validate();
		frame.repaint();
		frame.pack();
		
		//Thread.sleep(10);
		
	}
	
	private int[] shuffleList(int start, int end) {
		ArrayList<Integer> solution = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			solution.add(i);
		}
		Collections.shuffle(solution);

		int[] temp = new int[solution.size()];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = solution.get(i);
		}

		return temp;
	}
	
	
	
}
