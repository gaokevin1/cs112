	
public class StringListTester 
{

	public static void main(String[] args) 
	{
		int passed = 0;
		int total = 0;
		
		StringList sl = new StringList(2);

		//test isEmpty with empty list
		boolean actualBoolean = sl.isEmpty();		
		boolean expectedBoolean = true;
		String passFail = (actualBoolean == expectedBoolean)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test isEmpty [" + passFail + "] - EXPECTED: " + expectedBoolean + " ACTUAL: " + actualBoolean);
		total++;
		
		//test size with empty list
		int actualInt = sl.size();		
		int expectedInt = 0;
		passFail = (actualInt == expectedInt)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test size empty list [" + passFail + "] - EXPECTED: " + expectedInt + " ACTUAL: " + actualInt);
		total++;
		
		//test toString with empty list
		String actualString = sl.toString();
		String expectedString = "{}";
		passFail = (actualString.equals(expectedString))?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test toString [" + passFail + "] - EXPECTED: " + expectedString + " ACTUAL: " + actualString);
		total++;
		
		sl.add("a");
		sl.add("b");
		sl.add("c");

		//test add
		actualString = sl.toString();
		expectedString = "{a,b,c}";
		passFail = (actualString.equals(expectedString))?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test add [" + passFail + "] - EXPECTED: " + expectedString + " ACTUAL: " + actualString);
		total++;
		
		//test add at index
		sl.add(3, "d");
		actualString = sl.toString();
		expectedString = "{a,b,c,d}";
		passFail = (actualString.equals(expectedString))?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test add at index [" + passFail + "] - EXPECTED: " + expectedString + " ACTUAL: " + actualString);
		total++;
		
		//test add at index - bad index
		sl.add(30, "e");
		actualString = sl.toString();
		expectedString = "{a,b,c,d}";
		passFail = (actualString.equals(expectedString))?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test add bad index [" + passFail + "] - EXPECTED: " + expectedString + " ACTUAL: " + actualString);
		total++;
		
		//test contains true
		actualBoolean = sl.contains("b");		
		expectedBoolean = true;
		passFail = (actualBoolean == expectedBoolean)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test contains true [" + passFail + "] - EXPECTED: " + expectedBoolean + " ACTUAL: " + actualBoolean);
		total++;
		
		//test contains false
		actualBoolean = sl.contains("z");		
		expectedBoolean = false;
		passFail = (actualBoolean == expectedBoolean)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test contains false [" + passFail + "] - EXPECTED: " + expectedBoolean + " ACTUAL: " + actualBoolean);
		total++;
		
		//test contains last
		actualBoolean = sl.contains("d");		
		expectedBoolean = true;
		passFail = (actualBoolean == expectedBoolean)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test contains (last item) [" + passFail + "] - EXPECTED: " + expectedBoolean + " ACTUAL: " + actualBoolean);
		total++;
		
		//test contains first
		actualBoolean = sl.contains("a");		
		expectedBoolean = true;
		passFail = (actualBoolean == expectedBoolean)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test contains (first item) [" + passFail + "] - EXPECTED: " + expectedBoolean + " ACTUAL: " + actualBoolean);
		total++;
		
		//test size
		actualInt = sl.size();		
		expectedInt = 4;
		passFail = (actualInt == expectedInt)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test size empty list [" + passFail + "] - EXPECTED: " + expectedInt + " ACTUAL: " + actualInt);
		total++;
		
		//test isEmpty with non-empty list
		actualBoolean = sl.isEmpty();		
		expectedBoolean = false;
		passFail = (actualBoolean == expectedBoolean)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test isEmpty [" + passFail + "] - EXPECTED: " + expectedBoolean + " ACTUAL: " + actualBoolean);
		total++;
		
		
		//test indexOf first
		actualInt = sl.indexOf("a");		
		expectedInt = 0;
		passFail = (actualInt == expectedInt)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test indexOf (first item) [" + passFail + "] - EXPECTED: " + expectedInt + " ACTUAL: " + actualInt);
		total++;
		
		//test indexOf last
		actualInt = sl.indexOf("d");		
		expectedInt = 3;
		passFail = (actualInt == expectedInt)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test indexOf (last item) [" + passFail + "] - EXPECTED: " + expectedInt + " ACTUAL: " + actualInt);
		total++;
		
		//test indexOf bad item
		actualInt = sl.indexOf("z");		
		expectedInt = -1;
		passFail = (actualInt == expectedInt)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test indexOf (bad item) [" + passFail + "] - EXPECTED: " + expectedInt + " ACTUAL: " + actualInt);
		total++;
		
		//test lastIndexOf 
		actualInt = sl.lastIndexOf("c");		
		expectedInt = 2;
		passFail = (actualInt == expectedInt)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test lastIndexOf [" + passFail + "] - EXPECTED: " + expectedInt + " ACTUAL: " + actualInt);
		total++;
		
		sl.add("b");
		//test lastIndexOf repeated
		actualInt = sl.lastIndexOf("b");		
		expectedInt = 4;
		passFail = (actualInt == expectedInt)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test lastIndexOf (repeated item) [" + passFail + "] - EXPECTED: " + expectedInt + " ACTUAL: " + actualInt);
		total++;
		
		//test lastIndexOf repeated
		actualInt = sl.lastIndexOf("b");		
		expectedInt = 4;
		passFail = (actualInt == expectedInt)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test lastIndexOf (repeated item) [" + passFail + "] - EXPECTED: " + expectedInt + " ACTUAL: " + actualInt);
		total++;

		//test remove item
		actualBoolean = sl.remove("b");		
		expectedBoolean = true;
		passFail = (actualBoolean == expectedBoolean)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test remove item [" + passFail + "] - EXPECTED: " + expectedBoolean + " ACTUAL: " + actualBoolean);
		total++;

		
		//test remove nonexistent item 
		actualBoolean = sl.remove("z");		
		expectedBoolean = false;
		passFail = (actualBoolean == expectedBoolean)?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test remove nonexistent item [" + passFail + "] - EXPECTED: " + expectedBoolean + " ACTUAL: " + actualBoolean);
		total++;
		
		//test toString		
		actualString = sl.toString();
		expectedString = "{a,c,d,b}";
		passFail = (actualString.equals(expectedString))?"PASS":"FAIL";
		if(passFail.equals("PASS")) passed++;
		System.out.println("test toString [" + passFail + "] - EXPECTED: " + expectedString + " ACTUAL: " + actualString);
		total++;
		
		System.out.println("=============");
		System.out.printf("Tests Passed: %d of %d\n", passed, total);
		System.out.println("=============");

	}

}