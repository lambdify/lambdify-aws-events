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
 * Created by adsuresh on 7/13/17.
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class KinesisFirehoseEvent implements Serializable, Cloneable {

    private static final long serialVersionUID = -2890373471008001695L;

    String invocationId;
    String deliveryStreamArn;
    String region;
    List<Record> records;

    @Data
    @AllArgsConstructor @NoArgsConstructor
    public static class Record implements Serializable, Cloneable {

        private static final long serialVersionUID = -7231161900431910379L;

        /**
         * The data blob, which is base64-encoded when the blob is serialized. The maximum size of the data blob, before
         * base64-encoding, is 1,000 KB.
         */
        ByteBuffer data;

        String recordId;
        Long approximateArrivalEpoch;
        Long approximateArrivalTimestamp;
        Map<String, String> kinesisRecordMetadata;
    }
}