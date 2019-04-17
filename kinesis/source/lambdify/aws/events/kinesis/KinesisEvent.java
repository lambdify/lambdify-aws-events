/*
 * This class was copied and rewritten from Amazon's default library. If you are interested on the original
 * class instead, please proceed to the original repository: https://git.io/fjYVv
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
package lambdify.aws.events.kinesis;

import lombok.*;

import java.io.*;
import java.nio.*;
import java.util.*;

/**
 * Represents an Amazon Kinesis event.
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class KinesisEvent implements Serializable, Cloneable {

    private static final long serialVersionUID = 8145257839787754632L;

    List<KinesisEventRecord> records;

    /**
     * Kinesis event records provide contextual data about a Kinesis record
     */
    @Data
    @AllArgsConstructor @NoArgsConstructor
    public static class KinesisEventRecord implements Serializable, Cloneable {

        private static final long serialVersionUID = -3855723544907905206L;

        private String eventSource;

        private Record kinesis;

        private String eventID;

        private String invokeIdentityArn;

        private String eventName;

        private String eventVersion;

        private String eventSourceARN;

        private String awsRegion;
    }

    /**
     * The unit of data of an Amazon Kinesis stream
     */
    @Data
    @AllArgsConstructor @NoArgsConstructor
    public static class Record implements Serializable, Cloneable {

        private static final long serialVersionUID = 7856672931457425976L;

        String kinesisSchemaVersion;
        String sequenceNumber;
        Date approximateArrivalTimestamp;
        ByteBuffer data;
        String partitionKey;
        String encryptionType;
    }
}