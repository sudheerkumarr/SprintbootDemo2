package com.example;

record Person(String name, int age) {}


public class Test {
	public static void main(String[] args) {
		
		// Record class example
		Person p1 = new Person("Raj", 12);
		Person p2 = new Person("Sam", 12);
		
		System.out.println(p1);
		System.out.println(p1.name());
		System.out.println(p2.age());
		
	   // Text block (""")
	   String str = """ 
	   		\n{\n\t"name": "Raj",\n\t"age" : 12
			}
	   		""";
	   System.out.println(str);
	   		
	}
}
