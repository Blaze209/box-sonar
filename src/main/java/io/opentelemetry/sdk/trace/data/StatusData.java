package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.trace.StatusCode;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface StatusData {
    String getDescription();

    StatusCode getStatusCode();

    static StatusData ok() {
        return ImmutableStatusData.OK;
    }

    static StatusData unset() {
        return ImmutableStatusData.UNSET;
    }

    static StatusData error() {
        return ImmutableStatusData.ERROR;
    }

    static StatusData create(StatusCode statusCode, @Nullable String str) {
        if (str == null) {
            str = "";
        }
        return ImmutableStatusData.create(statusCode, str);
    }
}
