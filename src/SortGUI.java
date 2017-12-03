
import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SortGUI {

	public static void main(String args[]) throws InterruptedException {

		JFrame frame = new JFrame("Visual Sort");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

		BufferedImage image = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
		ImageIcon icon = new ImageIcon(image);
		JLabel label = new JLabel(icon);
		frame.add(label);
		frame.pack();
		SortGUI sorter = new SortGUI();

		new BubbleSort().sort(sorter.shuffleList(1, 100), image, frame);

		new InsertionSort().sort(sorter.shuffleList(1, 100), image, frame);

	}

	public void updateImage(int[] array, BufferedImage initialImage, JFrame frame) throws InterruptedException {

		BufferedImage newImage = new BufferedImage(initialImage.getWidth(), initialImage.getHeight(),
				initialImage.getType());

		int arrayMax = array.length;

		int verticalScale = newImage.getHeight() / arrayMax;
		int horizontalScale = newImage.getWidth() / array.length;

		// make canvas black
		for (int width = 0; width < newImage.getWidth(); width++) {
			for (int height = 0; height < newImage.getHeight(); height++) {
				newImage.setRGB(width, height, new Color(0, 0, 0).getRGB());
			}
		}

		// draw state
		for (int i = 0; i < array.length; i++) {
			int x_start = horizontalScale * i;
			int x_end = x_start + horizontalScale - 1;
			int y_start = newImage.getHeight() - (array[i] * verticalScale - 1);
			int y_end = newImage.getHeight() - 1;

			for (int width = x_start; width <= x_end; width++) {
				for (int height = y_start; height <= y_end; height++) {
					newImage.setRGB(width, height, new Color(255, 255, 255).getRGB());
				}
			}

		}

		// update frame
		frame.getContentPane().removeAll();
		ImageIcon icon = new ImageIcon(newImage);
		JLabel label = new JLabel(icon);
		frame.add(label);
		frame.validate();
		frame.pack();

		// Thread.sleep(10);

	}

	// creates a shuffled array that contains integers from start to end
	// inclusive
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
