package com.nt.service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class LinksServiceImpl implements ILinksService {

	public String generateWishMessage() {
		// get system date and time
		LocalDateTime dt = LocalDateTime.now();
		// get current hours of the day
		int hour = dt.getHour();
		if (hour < 12)
			return "Good Morning";
		else if (hour < 16)
			return "Good Afternoon";
		else if (hour < 20)
			return "Good Evening";
		else
			return "Good Night";
	}

	public Set<String> fetchAllLanguages() {
		Locale locale[] = Locale.getAvailableLocales();
		Set<String> langSet = new HashSet<String>();
		for (Locale l : locale) {
			langSet.add(l.getDisplayLanguage());
		}
		return langSet;
	}

}