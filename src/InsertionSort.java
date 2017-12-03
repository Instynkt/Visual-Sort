
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import javax.security.auth.kerberos.KerberosKey;
import javax.swing.JFrame;
import javax.xml.transform.Templates;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		int[] a = insertionSort.shuffleList(1, 5);
		System.out.println();
		insertionSort.sort(a);
	}

	public void sort(int[] a) {

		// start time
		double startTime = System.nanoTime();

		for (int i = 0; i < a.length; i++) {
			int j = i - 1;
			while (j >= 0 && a[i] < a[j]) {

				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i--;
				j--;
			}
		}

		// end time
		double endTime = System.nanoTime();
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		// Runtime result
		System.out.println(
				"-----------------------------------" + "\n" + "Runtime: " + (endTime - startTime) / 1000000 + "ms");
	}

	public void sort(int[] a, BufferedImage image, JFrame frame) throws InterruptedException {

		for (int i = 0; i < a.length; i++) {
			int j = i - 1;
			int temp = a[i];
			while (j >= 0 && temp < a[j]) {
				a[j + 1] = a[j];
				j = j - 1;
				new SortGUI().updateImage(a, image, frame);
			}
			a[j + 1] = temp;
			new SortGUI().updateImage(a, image, frame);
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
