package io.opentelemetry.sdk.common;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
final class AutoValue_InstrumentationLibraryInfo extends InstrumentationLibraryInfo {
    private final String name;
    private final String schemaUrl;
    private final String version;

    AutoValue_InstrumentationLibraryInfo(String str, @Nullable String str2, @Nullable String str3) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        this.version = str2;
        this.schemaUrl = str3;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationLibraryInfo
    public String getName() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationLibraryInfo
    @Nullable
    public String getVersion() {
        return this.version;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationLibraryInfo
    @Nullable
    public String getSchemaUrl() {
        return this.schemaUrl;
    }

    public String toString() {
        return "InstrumentationLibraryInfo{name=" + this.name + ", version=" + this.version + ", schemaUrl=" + this.schemaUrl + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstrumentationLibraryInfo) {
            InstrumentationLibraryInfo instrumentationLibraryInfo = (InstrumentationLibraryInfo) obj;
            if (this.name.equals(instrumentationLibraryInfo.getName()) && ((str = this.version) != null ? str.equals(instrumentationLibraryInfo.getVersion()) : instrumentationLibraryInfo.getVersion() == null) && ((str2 = this.schemaUrl) != null ? str2.equals(instrumentationLibraryInfo.getSchemaUrl()) : instrumentationLibraryInfo.getSchemaUrl() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.name.hashCode() ^ 1000003) * 1000003;
        String str = this.version;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.schemaUrl;
        return iHashCode2 ^ (str2 != null ? str2.hashCode() : 0);
    }
}
