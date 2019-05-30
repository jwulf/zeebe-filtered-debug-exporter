package io.zeebe;

import io.zeebe.exporter.api.context.Context;
import io.zeebe.protocol.clientapi.RecordType;
import io.zeebe.protocol.clientapi.ValueType;

public class DebugRecordFilter implements Context.RecordFilter {

    DebugRecordFilter() {

    }

    public boolean acceptType(RecordType recordType) {
        return true;
    }

    // Ignore all JOB_BATCH events
    public boolean acceptValue(ValueType valueType) {
        return !valueType.equals(ValueType.JOB_BATCH);
    }
}