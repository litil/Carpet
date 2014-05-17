package com.matelli.carpet.utils;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.matelli.carpet.R;

/**
 * Created by camstyles on 09/10/13.
 */
public class DateUtils {
	public static String SIMPLE_DATE_FORMAT_DEFAULT = "yyyy-MM-dd'T'HH:mm:ssZ";
	public static String SIMPLE_DATE_FORMAT_DISPLAY_DEFAULT = "EEEE dd MMM yyyy, HH:mm";

	public static class TimestampDeserializer implements JsonDeserializer<Timestamp> {
		@Override
		public Timestamp deserialize(JsonElement json, Type typeOfT,
				JsonDeserializationContext context) throws JsonParseException {

			try {
				long time = Long.parseLong(json.getAsString());
				return new Timestamp(time);
				
			} catch (Exception e) {
				SimpleDateFormat dateFormatter = new SimpleDateFormat(SIMPLE_DATE_FORMAT_DEFAULT);

				try {
					return new Timestamp(dateFormatter.parse(json.getAsString()).getTime());
				} catch (ParseException pe) {
					Log.w("DateUtils", "Error while formating date", pe);
				}
			}

			return new Timestamp(new Date().getTime());
		}
	}

	public static class DateDeserializer implements JsonDeserializer<Date> {
		@Override
		public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			SimpleDateFormat dateFormatter = new SimpleDateFormat(SIMPLE_DATE_FORMAT_DEFAULT);

			try {
				return dateFormatter.parse(json.getAsString());
			} catch (ParseException e) {
				Log.w("DateUtils", "Error while formating date", e);
			}

			return new Date();
		}
	}
}
