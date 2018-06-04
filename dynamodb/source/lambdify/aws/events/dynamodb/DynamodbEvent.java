/*
 * Copyright Lambdify 2018.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Deeply inspired on (or just a refactoring from) the same class
 * found at https://github.com/aws/aws-lambda-java-libs.
 */
package lambdify.aws.events.dynamodb;

import java.io.Serializable;
import java.util.List;
import lombok.*;

/**
 * Represents an Amazon DynamoDB event
 */
@EqualsAndHashCode @ToString
public class DynamodbEvent implements Serializable, Cloneable {

    private static final long serialVersionUID = -2354616079899981231L;

    private List<DynamodbStreamRecord> records;

    /**
     * The unit of data of an Amazon DynamoDB event
     */
    @EqualsAndHashCode(callSuper = true) @ToString
    public static class DynamodbStreamRecord extends Record {

        private static final long serialVersionUID = 3638381544604354963L;

        private String eventSourceARN;

        /**
         * default constructor
         * (Not available in v1)
         */
        public DynamodbStreamRecord() {}

        /**
         * Gets the event source arn of DynamoDB
         * @return event source arn
         */
        public String getEventSourceARN() {
            return eventSourceARN;
        }

        /**
         * Sets the event source arn of DynamoDB
         * @param eventSourceARN A string containing the event source arn
         */
        public void setEventSourceARN(String eventSourceARN) {
            this.eventSourceARN = eventSourceARN;
        }
    }

    /**
     * default constructor
     * (Not available in v1)
     */
    public DynamodbEvent() {}

    /**
     * Gets the list of DynamoDB event records
     * @return list of dynamodb event records
     */
    public List<DynamodbStreamRecord> getRecords() {
        return records;
    }

    /**
     * Sets the list of DynamoDB event records
     * @param records a list of DynamoDb event records
     */
    public void setRecords(List<DynamodbStreamRecord> records) {
        this.records = records;
    }
}
