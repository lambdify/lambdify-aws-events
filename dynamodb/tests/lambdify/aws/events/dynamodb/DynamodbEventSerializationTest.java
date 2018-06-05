package lambdify.aws.events.dynamodb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.FileInputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.junit.jupiter.api.Test;

/**
 *
 */
public class DynamodbEventSerializationTest {

	final ObjectMapper mapper = new ObjectMapper();

	@SneakyThrows
	@Test void canSerializeDynamoDBEvent(){
		try ( val input = new FileInputStream( "tests-resources/dynamo-event.json" ) ){
			val ddbEvent = mapper.readValue( input, DynamodbEvent.class );
			assertNotNull( ddbEvent );
			assertEquals( 3, ddbEvent.getRecords().size() );
			val key = ddbEvent.getRecords().get( 0 ).getDynamodb().getKeys().get( "Id" ).getN();
			assertEquals( "101", key );
		}
	}
}
