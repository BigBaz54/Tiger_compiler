package types;

import java.util.Map;

public class RecordType extends Type {
    private Map<String, Type> fields;

    public RecordType(Map<String, Type> fields) {
        this.fields = fields;
    }

    public Map<String, Type> getFields() {
        return fields;
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