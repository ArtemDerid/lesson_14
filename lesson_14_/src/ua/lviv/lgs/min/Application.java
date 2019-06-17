package ua.lviv.lgs.min;

import java.util.TreeSet;

public class Application {

	public static void main(String[] args) {

		TreeSet<Dog> dogSet = new TreeSet<>();

		dogSet.add(new Dog("Sam", 7));
		dogSet.add(new Dog("Rex", 7));
		dogSet.add(new Dog("Pet", 2));
		dogSet.add(new Dog("Jim", 1));
		dogSet.add(new Dog("Bim", 12));
		dogSet.add(new Dog("Bars", 4));
		dogSet.add(new Dog("Pit", 4));
		dogSet.add(new Dog("Joe", 8));
		dogSet.add(new Dog("Bark", 3));
		dogSet.add(new Dog("Jim", 6));
		dogSet.add(new Dog("Bark", 7));

		System.out.println("Comparable sorting");
		for (Dog dog : dogSet) {
			System.out.println(dog);
		}

		System.out.println();

		TreeSet<Dog> dogSet1 = new TreeSet<>(new DogAllFieldsComparator());

		dogSet1.add(new Dog("Sam", 7));
		dogSet1.add(new Dog("Rex", 7));
		dogSet1.add(new Dog("Pet", 2));
		dogSet1.add(new Dog("Jim", 1));
		dogSet1.add(new Dog("Bim", 12));
		dogSet1.add(new Dog("Bars", 4));
		dogSet1.add(new Dog("Pit", 4));
		dogSet1.add(new Dog("Joe", 8));
		dogSet1.add(new Dog("Bark", 3));
		dogSet1.add(new Dog("Jim", 6));
		dogSet1.add(new Dog("Bark", 7));

		System.out.println("Comparator sorting");
		for (Dog dog : dogSet1) {
			System.out.println(dog);
		}

	}

}
