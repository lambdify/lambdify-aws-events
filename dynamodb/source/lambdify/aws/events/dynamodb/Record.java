package lambdify.aws.events.dynamodb;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlTransient;
import lombok.*;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Record implements Serializable {
    private String eventID;
    private String eventName;
    private String eventVersion;
    private String eventSource;
    private String awsRegion;
    private StreamRecord dynamodb;
    private Identity userIdentity;

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventID() {
        return this.eventID;
    }

    public Record withEventID(String eventID) {
        this.setEventID(eventID);
        return this;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return this.eventName;
    }

    public Record withEventName(String eventName) {
        this.setEventName(eventName);
        return this;
    }

    @XmlTransient
    public void setEventNam(OperationType eventName) {
        this.eventName = eventName.toString();
    }

    public Record withEventName(OperationType eventName) {
        this.setEventNam(eventName);
        return this;
    }

    public void setEventVersion(String eventVersion) {
        this.eventVersion = eventVersion;
    }

    public String getEventVersion() {
        return this.eventVersion;
    }

    public Record withEventVersion(String eventVersion) {
        this.setEventVersion(eventVersion);
        return this;
    }

    public void setEventSource(String eventSource) {
        this.eventSource = eventSource;
    }

    public String getEventSource() {
        return this.eventSource;
    }

    public Record withEventSource(String eventSource) {
        this.setEventSource(eventSource);
        return this;
    }

    public void setAwsRegion(String awsRegion) {
        this.awsRegion = awsRegion;
    }

    public String getAwsRegion() {
        return this.awsRegion;
    }

    public Record withAwsRegion(String awsRegion) {
        this.setAwsRegion(awsRegion);
        return this;
    }

    public void setDynamodb(StreamRecord dynamodb) {
        this.dynamodb = dynamodb;
    }

    public StreamRecord getDynamodb() {
        return this.dynamodb;
    }

    public Record withDynamodb(StreamRecord dynamodb) {
        this.setDynamodb(dynamodb);
        return this;
    }

    public void setUserIdentity(Identity userIdentity) {
        this.userIdentity = userIdentity;
    }

    public Identity getUserIdentity() {
        return this.userIdentity;
    }

    public Record withUserIdentity(Identity userIdentity) {
        this.setUserIdentity(userIdentity);
        return this;
    }
}
