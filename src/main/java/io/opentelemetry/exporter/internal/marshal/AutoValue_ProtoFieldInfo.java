package io.opentelemetry.exporter.internal.marshal;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ProtoFieldInfo extends ProtoFieldInfo {
    private final int fieldNumber;
    private final String jsonName;
    private final int tag;
    private final int tagSize;

    AutoValue_ProtoFieldInfo(int i, int i2, int i3, String str) {
        this.fieldNumber = i;
        this.tag = i2;
        this.tagSize = i3;
        if (str == null) {
            throw new NullPointerException("Null jsonName");
        }
        this.jsonName = str;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoFieldInfo
    public int getFieldNumber() {
        return this.fieldNumber;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoFieldInfo
    public int getTag() {
        return this.tag;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoFieldInfo
    public int getTagSize() {
        return this.tagSize;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoFieldInfo
    public String getJsonName() {
        return this.jsonName;
    }

    public String toString() {
        return "ProtoFieldInfo{fieldNumber=" + this.fieldNumber + ", tag=" + this.tag + ", tagSize=" + this.tagSize + ", jsonName=" + this.jsonName + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProtoFieldInfo) {
            ProtoFieldInfo protoFieldInfo = (ProtoFieldInfo) obj;
            if (this.fieldNumber == protoFieldInfo.getFieldNumber() && this.tag == protoFieldInfo.getTag() && this.tagSize == protoFieldInfo.getTagSize() && this.jsonName.equals(protoFieldInfo.getJsonName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.jsonName.hashCode() ^ ((((((this.fieldNumber ^ 1000003) * 1000003) ^ this.tag) * 1000003) ^ this.tagSize) * 1000003);
    }
}
