package api.utilities;

import static org.testng.Assert.*;
import io.restassured.response.Response;

public class AssertUtils {
	public static void verifyStatusCode(Response res, int expectedStatus) {
        assertEquals(res.getStatusCode(), expectedStatus, "Status code mismatch");
    }
public static void verifyResponseTime(Response response, long maxTime) {
    assertTrue(response.getTime() < maxTime,
            "Response time is greater than expected: " + response.getTime());
}
public static void verifyJsonField(Response response, String key, Object expectedValue) {
    assertEquals(response.jsonPath().get(key), expectedValue,
            "Mismatch in field: " + key);
}

// 🔹 Header Assertion
public static void verifyHeader(Response response, String headerName, String expectedValue) {
    assertEquals(response.getHeader(headerName), expectedValue,
            "Header mismatch: " + headerName);
}

// 🔹 Header Contains
public static void verifyHeaderContains(Response response, String headerName, String expectedValue) {
    assertTrue(response.getHeader(headerName).contains(expectedValue),
            "Header does not contain expected value: " + headerName);
}

// 🔹 Cookie Assertion
public static void verifyCookie(Response response, String cookieName) {
    assertTrue(response.getCookies().containsKey(cookieName),
            "Cookie not found: " + cookieName);
}

// 🔹 Cookie Value
public static void verifyCookieValue(Response response, String cookieName, String expectedValue) {
    assertEquals(response.getCookie(cookieName), expectedValue,
            "Cookie value mismatch: " + cookieName);
}

// 🔹 Authorization Token Present
public static void verifyAuthToken(Response response) {
    String token = response.getHeader("Authorization");
    assertNotNull(token, "Authorization token is missing");
    assertFalse(token.isEmpty(), "Authorization token is empty");
}

// 🔹 Response Contains Text
public static void verifyResponseContains(Response response, String expectedText) {
    assertTrue(response.asString().contains(expectedText),
            "Response does not contain expected text");
}

}
