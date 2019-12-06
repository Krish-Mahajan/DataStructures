package datastructure.stringarray;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class TestStringArray { 
	
	
	// test LinkList representation
	@Test
	public void testIsStringUnique() {
		
		StringArray test = new StringArray();
		System.out.println(test.isStringUnique("krish"));
		System.out.println(test.isStringUnique("krishk"));
	}
	
	
	// test LinkList representation
	@Test
	public void testIsPalindrome() {
		
		StringArray test = new StringArray();
		System.out.println(test.isPermutation("krish","mahajan"));
		System.out.println(test.isPermutation("god","dog"));
	}

	
	
	
}
