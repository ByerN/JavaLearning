public class Homework1KA {
	
	public static void main(String[] args) {
		String[] initArray = {"Ala", "ma", "kota"};
		
		for(String word : initArray) {
			System.out.print(word+" ");
		}
		
		System.out.println();
		initArray = addToArray(initArray, "Filemona");
		
		for(String word : initArray) {
			System.out.print(word+" ");
		}
		
	}
	
	public static String[] addToArray(String[] initialArray, String newElement) {
		int length = initialArray.length;
		String[] newArray = new String[length+1];
		
		for(int i = 0; i < length; i++) {
			newArray[i] = initialArray[i];
		}
		newArray[length] = newElement;
		
		return newArray;
	}
}
