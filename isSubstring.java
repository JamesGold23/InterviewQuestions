
public class isSubstring {
	public static boolean isSubstringRecursive(String s1, String s2) {
		for (int i = 0; i <= s1.length() - s2.length(); i++) {
			if (isSubstringRecursive(s1, s2, 0, i)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isSubstringRecursive(String s1, String s2, int i, int j) {
		if (i > s1.length()) {
			return true;
		}if (j >= s2.length()) {
			return false;
		}
		return s1.charAt(i) == s2.charAt(j) && isSubstringRecursive(s1, s2, i+1, j+1);
	}
	
	public static void main(String[] args) {
		System.out.println(isSubstringRecursive("paper", "px"));
	}
}
