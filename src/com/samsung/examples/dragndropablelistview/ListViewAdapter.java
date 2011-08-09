package com.samsung.examples.dragndropablelistview;

import java.util.Arrays;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ListViewAdapter extends BaseAdapter {

	private static final String[] base_array = {"String 1", "String 2", "String 3", "String 4", "String 5", "String 6"};
	private static final String[] array;

	private static int COPY_TIMES = 5;

	static {

		array = new String[base_array.length * COPY_TIMES];

		for (int i = 0; i < COPY_TIMES; i++) {
			for (int j = 0; j < base_array.length; j++) {
				array[i * base_array.length + j] = base_array[j];
			}
		}
	}

	@Override
	public int getCount() {
		return array.length;
	}

	@Override
	public Object getItem(int position) {
		return array[position];
	}

	@Override
	public long getItemId(int position) {
		return array[position].hashCode();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return new ListViewElement(parent.getContext(), array[position]);
	}
}