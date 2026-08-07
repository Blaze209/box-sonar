package io.opentelemetry.exporter.internal.marshal;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ProtoEnumInfo extends ProtoEnumInfo {
    private final int enumNumber;
    private final String jsonName;

    AutoValue_ProtoEnumInfo(int i, String str) {
        this.enumNumber = i;
        if (str == null) {
            throw new NullPointerException("Null jsonName");
        }
        this.jsonName = str;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoEnumInfo
    public int getEnumNumber() {
        return this.enumNumber;
    }

    @Override // io.opentelemetry.exporter.internal.marshal.ProtoEnumInfo
    public String getJsonName() {
        return this.jsonName;
    }

    public String toString() {
        return "ProtoEnumInfo{enumNumber=" + this.enumNumber + ", jsonName=" + this.jsonName + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProtoEnumInfo) {
            ProtoEnumInfo protoEnumInfo = (ProtoEnumInfo) obj;
            if (this.enumNumber == protoEnumInfo.getEnumNumber() && this.jsonName.equals(protoEnumInfo.getJsonName())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.jsonName.hashCode() ^ ((this.enumNumber ^ 1000003) * 1000003);
    }
}
