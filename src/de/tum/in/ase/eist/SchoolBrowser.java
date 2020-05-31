package de.tum.in.ase.eist;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class SchoolBrowser {

	private static final int TEACHER_ID_MRS_SCHNEIDER = 934543895;
	private static final int TEACHER_ID_MR_MUELLER = 37984283;

	private SchoolBrowser() {
	}

	public static void main(String[] args) throws MalformedURLException {
		Set<String> blacklistedHosts = Stream.of("www.facebook.com", "www.instagram.com").collect(Collectors.toSet());
		Set<Integer> teacherIDs = Stream.of(TEACHER_ID_MRS_SCHNEIDER, TEACHER_ID_MR_MUELLER).collect(Collectors.toSet());
		System.out.println("The SchoolBrowser does not allow connections to the following hosts: " + blacklistedHosts);
		URL redirectPage = new URL("https://www.exzellenz.tum.de/startseite/");

		/*
		SchoolProxy schoolProxy = new SchoolProxy(blacklistedHosts, redirectPage, teacherIDs);

		schoolProxy.connect(new URL("https://www.google.com/search?q=pinguine"));
		schoolProxy.disconnect();

		// this page is not allowed for students
		schoolProxy.connect(new URL("https://www.facebook.com/TU.Muenchen"));
		schoolProxy.disconnect();

		// authorize as teacher in order to access pages of blacklisted host
		schoolProxy.login(TEACHER_ID_MRS_SCHNEIDER);
		schoolProxy.connect(new URL("https://www.facebook.com/TU.Muenchen"));
		schoolProxy.disconnect();
		 */
	}
}
