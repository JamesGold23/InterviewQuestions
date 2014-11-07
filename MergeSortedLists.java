
public class MergeSortedLists {
	public static int[] mergeSorted(int[] s1, int[] s2) {
		int i = 0;
		int j = 0;
		int k = 0;
		int[] merged = new int[s1.length+s2.length];
		while (i < s1.length && j < s2.length) {
			if (s1[i] <= s2[j]) {
				merged[k] = s1[i];
				i++;
			} else {
				merged[k] = s2[j];
				j++;
			}
			k++;
		}
		if (i == s1.length) {
			while (j < s2.length){
				merged[k] = s2[j];
				j++;
				k++;
			}
		} else {
			while (i < s1.length){
				merged[k] = s1[i];
				i++;
				k++;
			}
		}
		return merged;
	}
	
	public static void main(String[] args) {
		int[] s1 = {1};
		int[] s2 = {3, 4, 4, 5};
		int[] merged = mergeSorted(s1, s2);
		for (int i = 0; i < merged.length; i++) {
			System.out.print(Integer.toString(merged[i]) + ' ');
		}
	}

}
