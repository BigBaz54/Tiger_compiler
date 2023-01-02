package types;

import java.util.Map;

public class RecordType extends Type {
    private Map<String, Type> fields;
    private String id;

    public RecordType(String id,Map<String, Type> fields) {
        this.fields = fields;
        this.id = id;
    }

    public Map<String, Type> getFields() {
        return fields;
    }
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Type other) {
        if (other instanceof RecordType) {
            RecordType otherRecord = (RecordType) other;
            return fields.equals(otherRecord.getFields());
        } else {
            return false;
        }
    }
}