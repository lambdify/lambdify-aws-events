package lambdify.aws.events.commons;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 */
public interface Commons {

	String DATE_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	DateTimeFormatter FORMATTER_ISO_8601 = DateTimeFormatter.ofPattern( DATE_ISO_8601 );

	static LocalDateTime parseToLocalTimezone( String date ) {
		return LocalDateTime.parse( date, FORMATTER_ISO_8601 );
	}
}
