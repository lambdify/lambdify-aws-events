/*
 * This class was copied and rewritten from Amazon's default library. If you are interested on the original
 * class instead, please proceed to the original repository: https://git.io/fjYVB
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package lambdify.aws.events.sqs;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.io.*;
import java.nio.*;
import java.util.*;

/**
 * Represents an Amazon SQS event.
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class SQSEvent implements Serializable, Cloneable {

    private static final long serialVersionUID = -5663700178408796225L;

    @JsonProperty("Records")
    List<SQSMessage> records;

    @Data
    @AllArgsConstructor @NoArgsConstructor
    public static class SQSMessage implements Serializable, Cloneable {

        private static final long serialVersionUID = -2300083946005987098L;

        String messageId;
        String receiptHandle;
        String body;
        String md5OfBody;
        String md5OfMessageAttributes;
        String eventSourceArn;
        String eventSource;
        String awsRegion;
        Map<String, String> attributes;
        Map<String, MessageAttribute> messageAttributes;
    }

    @Data
    @AllArgsConstructor @NoArgsConstructor
    public static class MessageAttribute implements Serializable, Cloneable {

        private static final long serialVersionUID = -1602746537669100978L;

        String stringValue;
        ByteBuffer binaryValue;
        List<String> stringListValues;
        List<ByteBuffer> binaryListValues;
        String dataType;
    }
}