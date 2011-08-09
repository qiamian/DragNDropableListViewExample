package com.samsung.examples.dragndropablelistview;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewElement extends FrameLayout {

	private static final OurDragShadowBuilder OUR_DRAG_SHADOW_BUILDER = new OurDragShadowBuilder();

	private TextView tv;

	public ListViewElement(Context context, String data) {
		super(context);

		LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, this);
		tv = (TextView) findViewById(android.R.id.text1);

		init(data);
	}

	private void init(final String data) {
		tv.setText(data);

		setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				Toast.makeText(getContext(), "Long click", Toast.LENGTH_SHORT).show();
				startDrag(ClipData.newPlainText("label", data), OUR_DRAG_SHADOW_BUILDER, null, 0);
				return true;
			}
		});

		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getContext(), "Click", Toast.LENGTH_SHORT).show();
			}
		});
	}

	public void convert(String data) {
		init(data);
	}

}