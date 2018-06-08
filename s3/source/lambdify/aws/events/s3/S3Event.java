/*
 * Copyright 2014-2017 Amazon Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */
package lambdify.aws.events.s3;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.*;
import lambdify.aws.events.commons.Commons;
import lombok.*;

/**
* A helper class that represents a strongly typed S3 EventNotification item sent
* to SQS, SNS, or Lambda.
*/
@EqualsAndHashCode @ToString
public class S3Event {
    private static final String DEFAULT_ENCODING = "UTF-8";

    private List<S3EventNotificationRecord> records;

    /**
     * @return the records in this notification
     */
    @JsonProperty(value = "Records")
    public List<S3EventNotificationRecord> getRecords() {
        return records;
    }

    @JsonProperty(value = "Records")
    public void setRecords(List<S3EventNotificationRecord> records) {
        this.records = records;
    }

    @EqualsAndHashCode @ToString
    public static class UserIdentityEntity {

        private final String principalId;

        @JsonCreator
        public UserIdentityEntity(
                @JsonProperty(value = "principalId") String principalId) {
            this.principalId = principalId;
        }

        public String getPrincipalId() {
            return principalId;
        }
    }

    @EqualsAndHashCode @ToString
    public static class S3BucketEntity {

        private final String name;
        private final UserIdentityEntity ownerIdentity;
        private final String arn;

        @JsonCreator
        public S3BucketEntity(
                @JsonProperty(value = "name") String name,
                @JsonProperty(value = "ownerIdentity") UserIdentityEntity ownerIdentity,
                @JsonProperty(value = "arn") String arn)
        {
            this.name = name;
            this.ownerIdentity = ownerIdentity;
            this.arn = arn;
        }

        public String getName() {
            return name;
        }

        public UserIdentityEntity getOwnerIdentity() {
            return ownerIdentity;
        }

        public String getArn() {
            return arn;
        }
    }

    @EqualsAndHashCode @ToString
    public static class S3ObjectEntity {

        private final String key;
        private final Long size;
        private final String eTag;
        private final String versionId;
        private final String sequencer;

        @JsonCreator
        public S3ObjectEntity(
                @JsonProperty(value = "key") String key,
                @JsonProperty(value = "size") Long size,
                @JsonProperty(value = "eTag") String eTag,
                @JsonProperty(value = "versionId") String versionId,
                @JsonProperty(value = "sequencer") String sequencer)
        {
            this.key = key;
            this.size = size;
            this.eTag = eTag;
            this.versionId = versionId;
            this.sequencer = sequencer;
        }

        public String getKey() {
            return key;
        }

        /**
         * S3 URL encodes the key of the object involved in the event. This is
         * a convenience method to automatically URL decode the key.
         * @return The URL decoded object key.
         */
        public String getUrlDecodedKey() {
            try {
                return URLDecoder.decode(getKey(), DEFAULT_ENCODING);
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex);
            }
        }

        /**
         * @deprecated use {@link #getSizeAsLong()} instead.
         */
        @Deprecated
        @JsonIgnore
        public Integer getSize() {
            return size == null ? null : size.intValue();
        }

        @JsonProperty(value = "size")
        public Long getSizeAsLong() {
            return size;
        }

        public String geteTag() {
            return eTag;
        }

        public String getVersionId() {
            return versionId;
        }

        public String getSequencer() {
            return sequencer;
        }
    }

    @EqualsAndHashCode @ToString
    public static class S3Entity {

        private final String configurationId;
        private final S3BucketEntity bucket;
        private final S3ObjectEntity object;
        private final String s3SchemaVersion;

        @JsonCreator
        public S3Entity(
                @JsonProperty(value = "configurationId") String configurationId,
                @JsonProperty(value = "bucket") S3BucketEntity bucket,
                @JsonProperty(value = "object") S3ObjectEntity object,
                @JsonProperty(value = "s3SchemaVersion") String s3SchemaVersion)
        {
            this.configurationId = configurationId;
            this.bucket = bucket;
            this.object = object;
            this.s3SchemaVersion = s3SchemaVersion;
        }

        public String getConfigurationId() {
            return configurationId;
        }

        public S3BucketEntity getBucket() {
            return bucket;
        }

        public S3ObjectEntity getObject() {
            return object;
        }

        public String getS3SchemaVersion() {
            return s3SchemaVersion;
        }
    }

    @EqualsAndHashCode @ToString
    public static class RequestParametersEntity {

        private final String sourceIPAddress;

        @JsonCreator
        public RequestParametersEntity(
                @JsonProperty(value = "sourceIPAddress") String sourceIPAddress)
        {
            this.sourceIPAddress = sourceIPAddress;
        }

        public String getSourceIPAddress() {
            return sourceIPAddress;
        }
    }

    @EqualsAndHashCode @ToString
    public static class ResponseElementsEntity {

        private final String xAmzId2;
        private final String xAmzRequestId;

        @JsonCreator
        public ResponseElementsEntity(
                @JsonProperty(value = "x-amz-id-2") String xAmzId2,
                @JsonProperty(value = "x-amz-request-id") String xAmzRequestId)
        {
            this.xAmzId2 = xAmzId2;
            this.xAmzRequestId = xAmzRequestId;
        }

        @JsonProperty("x-amz-id-2")
        public String getxAmzId2() {
            return xAmzId2;
        }

        @JsonProperty("x-amz-request-id")
        public String getxAmzRequestId() {
            return xAmzRequestId;
        }
    }

    @Data
    public static class S3EventNotificationRecord
    {
        private String awsRegion;
        private String eventName;
        private String eventSource;
        private String eventTime;
        private String eventVersion;
        private RequestParametersEntity requestParameters;
        private ResponseElementsEntity responseElements;
        private S3Entity s3;
        private UserIdentityEntity userIdentity;

        public LocalDateTime eventTimeAsDateTime(){
            return eventTime != null
                ? Commons.parseToLocalTimezone(eventTime)
                : null;
        }
    }
}
