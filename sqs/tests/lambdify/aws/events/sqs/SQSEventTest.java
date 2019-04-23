package lambdify.aws.events.sqs;

import com.jsoniter.*;
import com.jsoniter.extra.*;
import com.jsoniter.spi.*;
import lombok.*;
import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class SQSEventTest {

    @DisplayName("Can deserialize an SQS Event")
    @Test void canDeserializeSQSEvent() throws IOException {
        val file = Paths.get("tests-resources/sqs-events.json");
        val bytes = Files.readAllBytes(file);

        val options = new JacksonCompatibilityMode.Builder().build();
        val sqsEvent = JsonIterator.deserialize( options, bytes, SQSEvent.class);
        assertNotNull(sqsEvent.records);
        assertEquals(1, sqsEvent.records.size());
    }

    static {
        JsoniterSpi.registerTypeDecoder( ByteBuffer.class, new Decoder() {
            public Object decode(JsonIterator iter) throws IOException {
                Slice slice = iter.readStringAsSlice();
                byte[] bytes = Base64.getDecoder().decode( slice.toString() );
                return ByteBuffer.wrap( bytes );
            }
        } );
    }

}