public class LongestIncreasingSubsequence {
	public static int findLIS(int[] s) {
		return LISlength(s, 0);
	}
	
	public static int LISlength(int[] s, int i) {
		if (i == s.length) {
			return 0;
		}
		int max_length = -1;
		for (int j = i+1; j < s.length; j++) {
			if (s[i] < s[j]) {
				int l = LISlength(s, j);
				if (l > max_length) {
					max_length = l;
				}
			}
		}
		return Math.max(1+max_length, 1);
		
	}
	
	public static int findLISIterative(int[] s) {
		int[] table = new int[s.length];
		table[s.length-1] = 1;
		for (int i = s.length-2; i >= 0; i--) {
			int max_length = -1;
			for (int j = i+1; j < s.length; j++) {
				if (s[i] < s[j] && table[j] > max_length) {
					max_length = table[j];
				}
			}
			table[i] = Math.max(1+max_length, 1);
			max_length = -1;
		}
		for (int k = 0; k < table.length; k++) {
			System.out.print(Integer.toString(table[k]) + ' ');
		}
		return 0;
	}
	
	public static int findLISIterativeConstant(int[] s) { // doesn't work
		int[] table = new int[s.length];
		table[s.length-1] = 1;
		int max_length = 1;
		int start_of_max = s[s.length-1];
		for (int i = s.length-2; i >= 0; i--) {
			if (s[i] < start_of_max) {
				max_length++;
				start_of_max = s[i];
				table[i] = max_length;
			} else {
				table[i] = 1;
			}
		}
		for (int k = 0; k < table.length; k++) {
			System.out.print(Integer.toString(table[k]) + ' ');
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] s = {3, 2, 1};
		System.out.println(findLIS(s));
		int[] a = {2, 1, 2, 3, 4, 3, 4};
		findLISIterativeConstant(a);
	}
}
