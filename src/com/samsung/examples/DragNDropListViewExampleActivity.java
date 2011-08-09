package com.samsung.examples;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.samsung.examples.dragndropablelistview.ListViewAdapter;

public class DragNDropListViewExampleActivity extends Activity {

	private ListView listView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(getAdapter());
	}

	private ListAdapter getAdapter() {
		return new ListViewAdapter();
	}
}