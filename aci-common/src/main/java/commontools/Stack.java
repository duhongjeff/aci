package commontools;

import java.util.Arrays;

public class Stack {
	
	private String [] targetArray;
	
	
	public Stack(String target) {
		targetArray=target.split(";");
	}

	public String pop() {
		String toBeReturned= targetArray[0];
		Arrays.copyOfRange(targetArray, 1, targetArray.length);
		return toBeReturned;
	}
	
	public void push() {
		 String[] newArray = new String[targetArray.length + 1];
		 System.arraycopy(targetArray, 0, newArray, 0, targetArray.length);
	}

	public String[] getTargetArray() {
		return targetArray;
	}

	public void setTargetArray(String[] targetArray) {
		this.targetArray = targetArray;
	}
	
}
