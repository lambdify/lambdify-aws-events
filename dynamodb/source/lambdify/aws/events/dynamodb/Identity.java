package lambdify.aws.events.dynamodb;

import java.io.Serializable;
import lombok.*;

@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Identity implements Serializable {

    private String principalId;
    private String type;

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public String getPrincipalId() {
        return this.principalId;
    }

    public Identity withPrincipalId(String principalId) {
        this.setPrincipalId(principalId);
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public Identity withType(String type) {
        this.setType(type);
        return this;
    }
}