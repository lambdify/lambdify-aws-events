package lambdify.aws.events.dynamodb;

import lombok.*;

@RequiredArgsConstructor
public enum OperationType {
    INSERT("INSERT"),
    MODIFY("MODIFY"),
    REMOVE("REMOVE");

    final String value;

    public String toString() {
        return this.value;
    }

    public static OperationType fromValue(String value) {
        if (value != null && !"".equals(value)) {
            OperationType[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                OperationType enumEntry = var1[var3];
                if (enumEntry.toString().equals(value)) {
                    return enumEntry;
                }
            }

            throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
        } else {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
    }
}