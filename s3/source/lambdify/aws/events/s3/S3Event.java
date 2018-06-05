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
package lambdify.aws.events.s3;

import java.io.Serializable;
import java.util.List;
import lombok.*;

/**
 * Represents and AmazonS3 event.
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class S3Event extends S3EventNotification implements Serializable, Cloneable {

    private static final long serialVersionUID = -8046575090948662044L;

    /**
     * Create a new instance of S3Event
     * @param records A list of S3 event notification records
     */
    public S3Event(List<S3EventNotificationRecord> records) {
        super(records);
    }
}
