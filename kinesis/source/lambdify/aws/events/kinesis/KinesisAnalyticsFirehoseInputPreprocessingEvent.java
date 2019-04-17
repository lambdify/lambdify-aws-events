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

@Data
@AllArgsConstructor @NoArgsConstructor
/**
 * Event model for pre-processing Kinesis Firehose records through Kinesis
 * Analytics Lambda pre-processing function.
 */
public class KinesisAnalyticsFirehoseInputPreprocessingEvent implements Serializable {

    private static final long serialVersionUID = 3372554211277515302L;

    String invocationId;
    String applicationArn;
    String streamArn;
    List<Record> records;

    @Data
    @AllArgsConstructor @NoArgsConstructor
    public static class Record implements Serializable {

        private static final long serialVersionUID = 9130920004800315787L;

        String recordId;
        KinesisFirehoseRecordMetadata kinesisFirehoseRecordMetadata;
        ByteBuffer data;
    }

    @Data
    @AllArgsConstructor @NoArgsConstructor
    public static class KinesisFirehoseRecordMetadata implements Serializable {

        private static final long serialVersionUID = 692430771749481045L;

        Long approximateArrivalTimestamp;
    }
}
