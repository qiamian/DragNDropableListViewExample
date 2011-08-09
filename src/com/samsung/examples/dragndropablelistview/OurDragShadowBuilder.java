package com.samsung.examples.dragndropablelistview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.Log;
import android.view.View.DragShadowBuilder;

public class OurDragShadowBuilder extends DragShadowBuilder {

	static final Paint paint = new Paint();

	static {
		paint.setColor(Color.RED);
		paint.setAlpha(255 / 2);
	}

	@Override
	public void onDrawShadow(Canvas canvas) {

		Log.e("ON_DRAW_SHADOW", "onDrawShadow called");

		canvas.drawOval(new RectF(0, 0, canvas.getWidth(), canvas.getHeight()), paint);
	}

	@Override
	public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
		shadowSize.set(100, 100);
		shadowTouchPoint.set(50, 50);
		super.onProvideShadowMetrics(shadowSize, shadowTouchPoint);
	}
}
