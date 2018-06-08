package lambdify.aws.events.s3;

import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.jsoniter.JsonIterator;
import com.jsoniter.extra.JacksonCompatibilityMode;
import com.jsoniter.spi.JsoniterSpi;
import lombok.*;
import org.junit.jupiter.api.*;

/**
 *
 */
public class S3SerializationTest {

	@BeforeEach
	void setupJacksonSupport(){
		val config = new JacksonCompatibilityMode.Builder().build();
		JsoniterSpi.setCurrentConfig( config );
	}

	@SneakyThrows
	@Test void serializationTest(){
		try ( InputStream input = new FileInputStream( "tests-resources/s3-event.json" ) ){
			val inputAsString = readAsString( input );
			S3Event ddbEvent = JsonIterator.deserialize( inputAsString, S3Event.class );
			assertNotNull( ddbEvent );
			assertEquals( 1, ddbEvent.getRecords().size() );
			val record = ddbEvent.getRecords().get( 0 );
			assertEquals( "HappyFace.jpg", record.getS3().getObject().getKey() );
			assertEquals( "sourcebucket", record.getS3().getBucket().getName() );
		}
	}

	private static String readAsString( InputStream inputStream ) throws IOException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}
		return result.toString("UTF-8");
	}
}
