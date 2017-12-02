
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

	public static void main (String args[]) {
		
		JFrame frame = new JFrame("Visual Sort");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		BufferedImage image = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
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
		sorter.paint(new BubbleSort(), sorter.shuffleList(1, 500), frame, label, image);
		
	}
	
	//Image icon inside buffered image inside JPanel inside JFrame
	private void paint(Sort sort, int[] array, JFrame frame, JLabel label, BufferedImage image) {
		
		drawCurrentState(array, image);
		applySort();
		frame.pack();
			
		
	}
	
	private void drawCurrentState(int[] array, BufferedImage image) {
		int arrayMax = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > arrayMax) arrayMax = array[i];
		}
		
		int verticalScale = image.getHeight()/arrayMax;	
		int horizontalScale = image.getWidth()/array.length;
		
		
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
		
	}

	private void applySort() {
		
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
