package com.huoli.checkin.design.pattern.collections;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator {
	ArrayList<String> items;
	int position = 0;
 
	public PancakeHouseMenuIterator(ArrayList<String> items) {
		this.items = items;
	}
 
	public String next() {
		String menuItem = (String) items.get(position);
		position = position + 1;
		return menuItem;
	}
 
    public boolean hasNext() {
        //		if (position >= items.size()) {
        //			return false;
        //		} else {
        //			return true;
        //		}
        return position >= items.size() ? false : true;
    }
}