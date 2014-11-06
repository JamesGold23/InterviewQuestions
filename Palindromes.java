
public class Palindromes {
	private static int[][] table;
	
	public static int longestPalindromeRecursive(String s, int i, int j) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return 1;
		}
		if (s.charAt(i) == s.charAt(j)) {
			int inside = longestPalindromeRecursive(s, i+1, j-1);
			if (inside == j-1 - (i+1) + 1) {
				return inside + 2;
			}
		}
		return Math.max(longestPalindromeRecursive(s, i+1, j), longestPalindromeRecursive(s, i, j-1));		
	}
	
	public static int longestPalindromeIterative(String s) {
		table = new int[s.length()][s.length()];
		for (int i = 1; i < s.length(); i++) {
			for (int j = 0; j < i; j++) {
				table[i][j] = 0;
			}
		}
		for (int start = 0; start < s.length(); start++) {
			for (int i = 0, j = start; j < s.length(); i++, j++) {
				if (i == j) {
					table[i][j] = 1;
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						int inside = table[i+1][j-1];
						if (inside == j-1 - (i+1) + 1) {
							table[i][j] = inside + 2;
							continue;
						}
					}
					table[i][j] = Math.max(table[i+1][j], table[i][j-1]);					
				}				
			}
		}
		return table[0][s.length()-1];
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(longestPalindromeRecursive("racecar", 0, 6));
		System.out.println(longestPalindromeIterative("x"));
	}

}
