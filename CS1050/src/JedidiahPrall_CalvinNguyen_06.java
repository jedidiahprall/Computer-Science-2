import java.util.Arrays;

public class JedidiahPrall_CalvinNguyen_06 {
	private int array[];
	private int length;

	public static void main(String[] args) {
		JedidiahPrall_CalvinNguyen_06 sorter = new JedidiahPrall_CalvinNguyen_06();
		int nums[] = { 7, -5, 3, 2, 1, 0, 45 };
		System.out.println("Original Array:");
		System.out.println(Arrays.toString(nums));
		sorter.shellSort(nums);
		System.out.println("Sorted Array:");
		System.out.println(Arrays.toString(nums));
		sorter.quickSort(nums);
		for (int i:nums) {
			System.out.print(i);
			System.out.print(", ");
		}

	}

	private void shellSort(int[] array) {
		int increment = array.length / 2;
		while (increment > 0) {
			for (int i = increment; i < array.length; i++) {
				int j = i;
				int temp = array[i];
				while (j >= increment && array[j - increment] > temp) {
					array[j] = array[j - increment];
					j = j - increment;
				}
				array[j] = temp;
			}
			if (increment == 2) {
				increment = 1;
			} else {
				increment *= (5.0 / 11);
			}
		}
	}

	private void quickSort(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}
		this.array = array;
		length = array.length;
		sort(0, array.length - 1);
	}

	private void sort(int lowIndex, int highIndex) {
		int low = lowIndex;
		int high = highIndex;
		int pivot = array[low + (high - low) / 2];

		while (low <= high) {
			while (array[low] < pivot) {
				low++;
			}
			while (array[high] > pivot) {
				high--;
			}
			if (low <= high) {
				swap(low,high);
				low++;
				high--;
			}
		}
		if (low < high)
			sort(lowIndex, high);
		if (low < high) {
			sort(low, highIndex);
		}

	}

	private void swap(int lowIndex, int highIndex) {
		int temp = array[lowIndex];
		array[lowIndex] = array[highIndex];
		array[highIndex] = temp;
	}
}
