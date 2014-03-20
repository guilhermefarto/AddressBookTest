package com.deitel.addressbook.test.util;

import java.lang.reflect.Method;
import com.deitel.addressbook.test.AddressBookCaseTest;

// Guilherme
public class TestCaseUtil {

	public static void executeTestCase(AddressBookCaseTest classCaseTest, String cesOne) throws Exception {
		String[] events = cesOne.split(",");

		for (int index = 1; index < events.length - 1; index++) {
			String event = events[index].trim();

			Method method = AddressBookCaseTest.class.getDeclaredMethod(event);

			if (method != null) {
				method.invoke(classCaseTest);
			}
		}
	}

}
