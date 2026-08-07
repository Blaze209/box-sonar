package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.trace.StatusCode;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ImmutableStatusData extends ImmutableStatusData {
    private final String description;
    private final StatusCode statusCode;

    AutoValue_ImmutableStatusData(StatusCode statusCode, String str) {
        if (statusCode == null) {
            throw new NullPointerException("Null statusCode");
        }
        this.statusCode = statusCode;
        if (str == null) {
            throw new NullPointerException("Null description");
        }
        this.description = str;
    }

    @Override // io.opentelemetry.sdk.trace.data.StatusData
    public StatusCode getStatusCode() {
        return this.statusCode;
    }

    @Override // io.opentelemetry.sdk.trace.data.StatusData
    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "ImmutableStatusData{statusCode=" + this.statusCode + ", description=" + this.description + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableStatusData) {
            ImmutableStatusData immutableStatusData = (ImmutableStatusData) obj;
            if (this.statusCode.equals(immutableStatusData.getStatusCode()) && this.description.equals(immutableStatusData.getDescription())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.description.hashCode() ^ ((this.statusCode.hashCode() ^ 1000003) * 1000003);
    }
}
