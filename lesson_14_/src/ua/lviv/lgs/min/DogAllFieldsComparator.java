package ua.lviv.lgs.min;

import java.util.Comparator;

public class DogAllFieldsComparator implements Comparator<Dog>{

	@Override
	public int compare(Dog o1, Dog o2) {
		if(o1.getAge()>o2.getAge()) {
			return 1;
		}else if(o1.getAge()<o2.getAge()) {
			return -1;
		}else {
			if(o1.getName().compareTo(o2.getName())>0) {
				return 1;
			}else if(o1.getName().compareTo(o2.getName())<0) {
				return -1;
			}
		}
		return 0;
	}

}
