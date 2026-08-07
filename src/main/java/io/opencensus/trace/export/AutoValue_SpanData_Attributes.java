package io.opencensus.trace.export;

import io.opencensus.trace.AttributeValue;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_SpanData_Attributes extends SpanData.Attributes {
    private final Map<String, AttributeValue> attributeMap;
    private final int droppedAttributesCount;

    AutoValue_SpanData_Attributes(Map<String, AttributeValue> map, int i) {
        if (map == null) {
            throw new NullPointerException("Null attributeMap");
        }
        this.attributeMap = map;
        this.droppedAttributesCount = i;
    }

    @Override // io.opencensus.trace.export.SpanData.Attributes
    public Map<String, AttributeValue> getAttributeMap() {
        return this.attributeMap;
    }

    @Override // io.opencensus.trace.export.SpanData.Attributes
    public int getDroppedAttributesCount() {
        return this.droppedAttributesCount;
    }

    public String toString() {
        return "Attributes{attributeMap=" + this.attributeMap + ", droppedAttributesCount=" + this.droppedAttributesCount + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpanData.Attributes) {
            SpanData.Attributes attributes = (SpanData.Attributes) obj;
            if (this.attributeMap.equals(attributes.getAttributeMap()) && this.droppedAttributesCount == attributes.getDroppedAttributesCount()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.droppedAttributesCount ^ ((this.attributeMap.hashCode() ^ 1000003) * 1000003);
    }
}
