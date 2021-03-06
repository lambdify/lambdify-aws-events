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
import java.util.*;

/**
 * Response model for Kinesis Analytics Preprocessing Lambda function.
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class KinesisAnalyticsInputPreprocessingResponse implements Serializable {

    private static final long serialVersionUID = -4651154757825854471L;

    List<Record> records;

    @Data
    @AllArgsConstructor @NoArgsConstructor
    public static class Record implements Serializable {

        private static final long serialVersionUID = -1583558686451236985L;

        String recordId;
        Result result;
    }

    public enum Result {

        /**
         * Indicates that processing of this item succeeded.
         */
        Ok,

        /**
         * Indicate that the processing of this item failed
         */
        ProcessingFailed,

        /**
         * Indicates that this item should be silently dropped
         */
        Dropped
    }
}