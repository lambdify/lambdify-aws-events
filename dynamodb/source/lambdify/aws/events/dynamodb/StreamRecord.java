/*
 * Copyright 2013-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package lambdify.aws.events.dynamodb;

import java.io.Serializable;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@ToString @EqualsAndHashCode
public class StreamRecord implements Serializable {

    private Date approximateCreationDateTime;
    private Map<String, AttributeValue> keys;
    private Map<String, AttributeValue> newImage;
    private Map<String, AttributeValue> oldImage;
    private String sequenceNumber;
    private Long sizeBytes;
    private String streamViewType;

    public StreamRecord() {
    }

    @JsonProperty("ApproximateCreationDateTime") public void setApproximateCreationDateTime(Date approximateCreationDateTime) {
        this.approximateCreationDateTime = approximateCreationDateTime;
    }

    @JsonProperty("ApproximateCreationDateTime") public Date getApproximateCreationDateTime() {
        return this.approximateCreationDateTime;
    }

    public StreamRecord withApproximateCreationDateTime(Date approximateCreationDateTime) {
        this.setApproximateCreationDateTime(approximateCreationDateTime);
        return this;
    }

    @JsonProperty("Keys") public Map<String, AttributeValue> getKeys() {
        return this.keys;
    }

    @JsonProperty("Keys") public void setKeys(Map<String, AttributeValue> keys) {
        this.keys = keys;
    }

    public StreamRecord withKeys(Map<String, AttributeValue> keys) {
        this.setKeys(keys);
        return this;
    }

    public StreamRecord addKeysEntry(String key, AttributeValue value) {
        if (null == this.keys) {
            this.keys = new HashMap();
        }

        if (this.keys.containsKey(key)) {
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        } else {
            this.keys.put(key, value);
            return this;
        }
    }

    public StreamRecord clearKeysEntries() {
        this.keys = null;
        return this;
    }

    @JsonProperty("NewImage") public Map<String, AttributeValue> getNewImage() {
        return this.newImage;
    }

    @JsonProperty("NewImage") public void setNewImage(Map<String, AttributeValue> newImage) {
        this.newImage = newImage;
    }

    public StreamRecord withNewImage(Map<String, AttributeValue> newImage) {
        this.setNewImage(newImage);
        return this;
    }

    public StreamRecord addNewImageEntry(String key, AttributeValue value) {
        if (null == this.newImage) {
            this.newImage = new HashMap();
        }

        if (this.newImage.containsKey(key)) {
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        } else {
            this.newImage.put(key, value);
            return this;
        }
    }

    public StreamRecord clearNewImageEntries() {
        this.newImage = null;
        return this;
    }

    @JsonProperty("OldImage") public Map<String, AttributeValue> getOldImage() {
        return this.oldImage;
    }

    @JsonProperty("OldImage") public void setOldImage(Map<String, AttributeValue> oldImage) {
        this.oldImage = oldImage;
    }

    public StreamRecord withOldImage(Map<String, AttributeValue> oldImage) {
        this.setOldImage(oldImage);
        return this;
    }

    public StreamRecord addOldImageEntry(String key, AttributeValue value) {
        if (null == this.oldImage) {
            this.oldImage = new HashMap();
        }

        if (this.oldImage.containsKey(key)) {
            throw new IllegalArgumentException("Duplicated keys (" + key.toString() + ") are provided.");
        } else {
            this.oldImage.put(key, value);
            return this;
        }
    }

    public StreamRecord clearOldImageEntries() {
        this.oldImage = null;
        return this;
    }

    @JsonProperty("SequenceNumber") public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @JsonProperty("SequenceNumber") public String getSequenceNumber() {
        return this.sequenceNumber;
    }

    public StreamRecord withSequenceNumber(String sequenceNumber) {
        this.setSequenceNumber(sequenceNumber);
        return this;
    }

    @JsonProperty("SizeBytes") public void setSizeBytes(Long sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    @JsonProperty("SizeBytes") public Long getSizeBytes() {
        return this.sizeBytes;
    }

    public StreamRecord withSizeBytes(Long sizeBytes) {
        this.setSizeBytes(sizeBytes);
        return this;
    }

    @JsonProperty("StreamViewType") public void setStreamViewType(String streamViewType) {
        this.streamViewType = streamViewType;
    }

    @JsonProperty("StreamViewType") public String getStreamViewType() {
        return this.streamViewType;
    }

    public StreamRecord withStreamViewType(String streamViewType) {
        this.setStreamViewType(streamViewType);
        return this;
    }

    public StreamRecord withStreamViewType(StreamViewType streamViewType) {
        this.setStreamViewType(streamViewType.toString());
        return this;
    }
}