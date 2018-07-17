package com.entrevista.demo.od.utils;

import java.util.Calendar;
import java.util.Date;

public final class DateUtils {

	private DateUtils() {
	}
	
	public static Date obtenerFechaActual() {
		return Calendar.getInstance().getTime();
	}
}
