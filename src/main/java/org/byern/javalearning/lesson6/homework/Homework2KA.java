public class Homework2KA {
	
	public static void main(String[] args) {
		String word = "UmpapmU";
		String word2 = "Umpapmu";
		
		System.out.println("Is '"+word+"' Palindrome?");
		System.out.println(isPalindrome(word));
		System.out.println("Is '"+word2+"' Palindrome?");
		System.out.println(isPalindrome(word2));
		
	}
	
	public static boolean isPalindrome(String value) {
		boolean result = false;
		char[] charArray = value.toCharArray();
		int len = charArray.length;
		
		for (int i = 0; i < len; i++) {
			if (charArray[i]==charArray[len-1-i]) {
				result = true;
			} else {
				result = false;
			}
		}
		
		return result;
	}
}
