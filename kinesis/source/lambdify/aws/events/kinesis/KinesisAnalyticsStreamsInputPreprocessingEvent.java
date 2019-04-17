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
 * Event model for pre-processing Kinesis Streams records through Kinesis
 * Analytics Lambda pre-processing function.
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class KinesisAnalyticsStreamsInputPreprocessingEvent implements Serializable {

    private static final long serialVersionUID = 1770320710876513596L;

    String invocationId;
    String applicationArn;
    String streamArn;
    List<Record> records;

    @Data
    @AllArgsConstructor @NoArgsConstructor
    public static class Record implements Serializable {

        private static final long serialVersionUID = -2070268774061223434L;

        String recordId;
        ByteBuffer data;
        KinesisStreamRecordMetadata kinesisStreamRecordMetadata;
    }

    @Data
    @AllArgsConstructor @NoArgsConstructor
    public static class KinesisStreamRecordMetadata implements Serializable {

        private static final long serialVersionUID = 8831719215562345916L;

        String sequenceNumber;
        String partitionKey;
        String shardId;
        Long approximateArrivalTimestamp;
    }
}