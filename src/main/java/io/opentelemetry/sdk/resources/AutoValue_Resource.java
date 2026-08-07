package io.opentelemetry.sdk.resources;

import io.opentelemetry.api.common.Attributes;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_Resource extends Resource {
    private final Attributes attributes;
    private final String schemaUrl;

    AutoValue_Resource(@Nullable String str, Attributes attributes) {
        this.schemaUrl = str;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
    }

    @Override // io.opentelemetry.sdk.resources.Resource
    @Nullable
    public String getSchemaUrl() {
        return this.schemaUrl;
    }

    @Override // io.opentelemetry.sdk.resources.Resource
    public Attributes getAttributes() {
        return this.attributes;
    }

    public String toString() {
        return "Resource{schemaUrl=" + this.schemaUrl + ", attributes=" + this.attributes + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Resource) {
            Resource resource = (Resource) obj;
            String str = this.schemaUrl;
            if (str != null ? str.equals(resource.getSchemaUrl()) : resource.getSchemaUrl() == null) {
                if (this.attributes.equals(resource.getAttributes())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.schemaUrl;
        return this.attributes.hashCode() ^ (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003);
    }
}
