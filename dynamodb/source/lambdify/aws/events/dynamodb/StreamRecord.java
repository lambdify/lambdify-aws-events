package lambdify.aws.events.dynamodb;

import java.io.Serializable;
import java.util.*;
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

    public void setApproximateCreationDateTime(Date approximateCreationDateTime) {
        this.approximateCreationDateTime = approximateCreationDateTime;
    }

    public Date getApproximateCreationDateTime() {
        return this.approximateCreationDateTime;
    }

    public StreamRecord withApproximateCreationDateTime(Date approximateCreationDateTime) {
        this.setApproximateCreationDateTime(approximateCreationDateTime);
        return this;
    }

    public Map<String, AttributeValue> getKeys() {
        return this.keys;
    }

    public void setKeys(Map<String, AttributeValue> keys) {
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

    public Map<String, AttributeValue> getNewImage() {
        return this.newImage;
    }

    public void setNewImage(Map<String, AttributeValue> newImage) {
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

    public Map<String, AttributeValue> getOldImage() {
        return this.oldImage;
    }

    public void setOldImage(Map<String, AttributeValue> oldImage) {
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

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getSequenceNumber() {
        return this.sequenceNumber;
    }

    public StreamRecord withSequenceNumber(String sequenceNumber) {
        this.setSequenceNumber(sequenceNumber);
        return this;
    }

    public void setSizeBytes(Long sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    public Long getSizeBytes() {
        return this.sizeBytes;
    }

    public StreamRecord withSizeBytes(Long sizeBytes) {
        this.setSizeBytes(sizeBytes);
        return this;
    }

    public void setStreamViewType(String streamViewType) {
        this.streamViewType = streamViewType;
    }

    public String getStreamViewType() {
        return this.streamViewType;
    }

    public StreamRecord withStreamViewType(String streamViewType) {
        this.setStreamViewType(streamViewType);
        return this;
    }

    public void setStreamViewType(StreamViewType streamViewType) {
        this.streamViewType = streamViewType.toString();
    }

    public StreamRecord withStreamViewType(StreamViewType streamViewType) {
        this.setStreamViewType(streamViewType);
        return this;
    }
}