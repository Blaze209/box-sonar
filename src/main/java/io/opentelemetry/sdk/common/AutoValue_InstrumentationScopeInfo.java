package io.opentelemetry.sdk.common;

import io.opentelemetry.api.common.Attributes;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_InstrumentationScopeInfo extends InstrumentationScopeInfo {
    private final Attributes attributes;
    private final String name;
    private final String schemaUrl;
    private final String version;

    AutoValue_InstrumentationScopeInfo(String str, @Nullable String str2, @Nullable String str3, Attributes attributes) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        this.version = str2;
        this.schemaUrl = str3;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationScopeInfo
    public String getName() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationScopeInfo
    @Nullable
    public String getVersion() {
        return this.version;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationScopeInfo
    @Nullable
    public String getSchemaUrl() {
        return this.schemaUrl;
    }

    @Override // io.opentelemetry.sdk.common.InstrumentationScopeInfo
    public Attributes getAttributes() {
        return this.attributes;
    }

    public String toString() {
        return "InstrumentationScopeInfo{name=" + this.name + ", version=" + this.version + ", schemaUrl=" + this.schemaUrl + ", attributes=" + this.attributes + "}";
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstrumentationScopeInfo) {
            InstrumentationScopeInfo instrumentationScopeInfo = (InstrumentationScopeInfo) obj;
            if (this.name.equals(instrumentationScopeInfo.getName()) && ((str = this.version) != null ? str.equals(instrumentationScopeInfo.getVersion()) : instrumentationScopeInfo.getVersion() == null) && ((str2 = this.schemaUrl) != null ? str2.equals(instrumentationScopeInfo.getSchemaUrl()) : instrumentationScopeInfo.getSchemaUrl() == null) && this.attributes.equals(instrumentationScopeInfo.getAttributes())) {
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
        return this.attributes.hashCode() ^ ((iHashCode2 ^ (str2 != null ? str2.hashCode() : 0)) * 1000003);
    }
}
