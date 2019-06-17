package ua.lviv.lgs.max;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Commodity {

	private String name;
	private double width;
	private double length;
	private double weight;

	Set<Commodity> setOfCommodity = new HashSet();

	public Set<Commodity> getSetOfCommodity() {
		return setOfCommodity;
	}

	public void setSetOfCommodity(Set<Commodity> setOfCommodity) {
		this.setOfCommodity = setOfCommodity;
	}

	public Commodity(String name, double width, double length, double weight) {
		super();
		this.name = name;
		this.width = width;
		this.length = length;
		this.weight = weight;
	}

	public void addCommodity() {
		Supplier<Commodity> createCommodity = () -> {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Введіть товар, який хочете додати");
			System.out.println();
			System.out.println("Спочатку введіть назву");
			String name = scanner.next();

			System.out.println("Тепер введіть ширину");
			scanner = new Scanner(System.in);
			double width = scanner.nextDouble();

			System.out.println("Тепер введіть довжину");
			scanner = new Scanner(System.in);
			double length = scanner.nextDouble();

			System.out.println("Тепер введіть вагу");
			scanner = new Scanner(System.in);
			double weight = scanner.nextDouble();

			Commodity commodity = new Commodity(name, width, length, weight);

			setOfCommodity.add(commodity);
			System.out.println("Ви додали новий товар : \n" + commodity);
			System.out.println();
			System.out.println("setOfCommodity містить: \n" + setOfCommodity);
			return commodity;
		};
		createCommodity.get();
	}

	public void removeCommodity() {
		System.out.println("Введіть назву товару, який хочете видалити");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();

		Optional<Commodity> removedCommodity = setOfCommodity.stream().filter(c -> c.getName().equalsIgnoreCase(name))
				.findFirst().map(c -> {
					setOfCommodity.remove(c);
					return c;
				});

		if (removedCommodity.isPresent()) {
			System.out.println("Ви видалили товар " + removedCommodity.get());
			System.out.println();
			System.out.println("setOfCommodity містить: \n" + setOfCommodity);
		} else {
			System.out.println("Такого товару не знайдено");
		}
	}

	public void commoditySubstitution() {
		removeCommodity();
		addCommodity();
	}

	public void sortByLength() {
		Set<Commodity> sortedByLength = setOfCommodity.stream().sorted(new CommodityLengthComparator())
				.collect(Collectors.toSet());
		System.out.println(sortedByLength);
	}

	public void sortByWidth() {
		Set<Commodity> sortedByWidth = setOfCommodity.stream().sorted(new CommodityWidthComparator())
				.collect(Collectors.toSet());
		System.out.println(sortedByWidth);
	}

	public void sortByWeight() {
		Set<Commodity> sortedByWeight = setOfCommodity.stream().sorted(new CommodityWeightComparator())
				.collect(Collectors.toSet());
		System.out.println(sortedByWeight);
	}

	public void sortByName() {
		Set<Commodity> sortedByName = setOfCommodity.stream().sorted(new CommodityNameComparator())
				.collect(Collectors.toSet());
		System.out.println(sortedByName);
	}

	public void showElement() {
		System.out.println("Введіть номер елемента, який ви хочете побачитти");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		List<Commodity> listOfCommodity = setOfCommodity.stream().collect(Collectors.toList());

		System.out.println("Під номмером " + number + " находится елемент " + listOfCommodity.get(number));
		System.out.println(setOfCommodity);
	}

	public void exit() {
		System.out.println("Ви вийшли з програми");
		System.exit(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Commodity [name=" + name + ", width=" + width + ", length=" + length + ", weight=" + weight + "]";
	}

}
