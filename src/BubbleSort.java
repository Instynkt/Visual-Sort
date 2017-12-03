
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import javax.print.attribute.standard.PrinterLocation;
import javax.swing.JFrame;

public class BubbleSort {

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int[] a = bubbleSort.shuffleList(1, 5);
		bubbleSort.sort(a);
	}

	// Bubble sort - iterate through an array of numbers and return an ordered
	// array from smallest to largest
	public void sort(int[] a) {

		// start time
		double startTime = System.nanoTime();

		// bubble sort

		// you iterate n-1 times and each time iterates n-1-i times
		// where i is one less than the total iterations done
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				// swap the numbers if the lower index one is greater than the
				// higher index one
				if (a[j] > a[j + 1]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;
				}
			}
		}

		// end time
		double endTime = System.nanoTime();

		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i]);
		// }
		System.out.println();
		// Runtime result
		System.out.println(
				"-----------------------------------" + "\n" + "Runtime: " + (endTime - startTime) / 1000000 + "ms");
	}

	public void sort(int[] a, BufferedImage image, JFrame frame) throws InterruptedException {

		// bubble sort

		// you iterate n-1 times and each time iterates n-1-i times
		// where i is one less than the total iterations done
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				// swap the numbers if the lower index one is greater than the
				// higher index one
				if (a[j] > a[j + 1]) {
					int temp = a[j + 1];
					a[j + 1] = a[j];
					a[j] = temp;

					new SortGUI().updateImage(a, image, frame);
				}
			}
		}
	}

	// returns a shuffled array given a start and an end
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
