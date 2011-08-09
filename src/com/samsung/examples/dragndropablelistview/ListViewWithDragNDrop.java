package com.samsung.examples.dragndropablelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.widget.ListView;

public class ListViewWithDragNDrop extends ListView {

	public ListViewWithDragNDrop(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ListViewWithDragNDrop(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ListViewWithDragNDrop(Context context) {
		super(context);
	}

	@Override
	public boolean onDragEvent(DragEvent event) {

		String eventName = "NO_NAME";

		final int SCROLLING_SIZE = 50;

		switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED :
				eventName = "DRAG_STARTED";
				break;
			case DragEvent.ACTION_DRAG_ENDED :
				eventName = "DRAG_ENDED";
				break;
			case DragEvent.ACTION_DRAG_ENTERED :
				eventName = "DRAG_ENTERED";
				break;
			case DragEvent.ACTION_DRAG_EXITED :
				eventName = "DRAG_EXITED";
				break;
			case DragEvent.ACTION_DRAG_LOCATION :
				eventName = "DRAG_LOCATION";

				if (event.getY() > getHeight() - SCROLLING_SIZE) {
					Log.e("SCROLL", "DOWN");

					smoothScrollByOffset(10);
				} else if (event.getY() < SCROLLING_SIZE) {
					Log.e("SCROLL", "UP");
					smoothScrollByOffset(-10);
				}

				break;
			case DragEvent.ACTION_DROP :
				eventName = "DROP";
				break;
			default :
				throw new IllegalStateException("Unreached code.");
		}

		Log.e("DRAG_N_DROP", "DragEvent: " + eventName + " " + event.toString());

		return true;
	}
}
