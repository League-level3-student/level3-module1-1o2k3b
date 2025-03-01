package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
ArrayList<String> hello = new ArrayList();
String yes = "yes";
String no = "no";
String maybe = "maybe";
String askmelater = "ask me later";
String Idontcompute = "I dont compute";
        // 2. Add five Strings to your list
hello.add(yes);
hello.add(no);
hello.add(maybe);
hello.add(Idontcompute);
hello.add(askmelater);
        // 3. Print all the Strings using a standard for-loop
for(int i = 0; i<hello.size(); i++) {
System.out.println(hello.get(i));
}
        // 4. Print all the Strings using a for-each loop
for(String h:hello) {
	System.out.println(h);
}
       
for(int i = 0; i<hello.size(); i++) {
	 // 5. Print only the even numbered elements in the list.
	if(i%2 == 0) {
		System.out.println(hello.get(i));
	}
	// 7. Print only the Strings that have the letter 'e' in them.
	if(hello.get(i).contains("e")) {
		System.out.println(hello.get(i));
	}
}
//6. Print all the Strings in reverse order.
for(int i = hello.size(); i>0; i--) {
	System.out.println(hello.get(i));
}
       

        
        
    }
}
