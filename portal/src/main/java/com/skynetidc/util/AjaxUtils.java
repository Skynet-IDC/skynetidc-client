package com.skynetidc.util;

public class AjaxUtils {

	private AjaxUtils() {
	}

	public static boolean isAjaxRequest(final String requested) {

		return "XMLHttpRequest".equals(requested);
	}

}
