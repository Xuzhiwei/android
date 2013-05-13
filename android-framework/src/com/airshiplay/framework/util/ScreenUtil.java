package com.airshiplay.framework.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class ScreenUtil {

	public static int[] size;
	public static float density;
	public static int[] resolutionXY;

	public static void init(Context context) {
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		ScreenUtil.density = dm.density;
		ScreenUtil.size = new int[2];
		ScreenUtil.size[0] = dm.widthPixels;
		ScreenUtil.size[1] = dm.heightPixels;
		ScreenUtil.resolutionXY = getScreenResolutionXY(context);
	}

	public static int dp2px(float dp) {
		return (int) (0.5f + ScreenUtil.density * dp);
	}

	public static int dp2px(Context context, int dp) {
		return dp2px(dp);
	}

	public static int[] getScreenResolutionXY(Context context) {
		int[] resolutionXY = new int[2];
		DisplayMetrics dm = new DisplayMetrics();
		((WindowManager) context.getApplicationContext().getSystemService(
				Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
		if (dm.widthPixels < dm.heightPixels) {
			resolutionXY[0] = dm.widthPixels;
			resolutionXY[1] = dm.heightPixels;
		} else {
			resolutionXY[0] = dm.heightPixels;
			resolutionXY[1] = dm.widthPixels;
		}
		return resolutionXY;
	}

}
