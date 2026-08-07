package io.opentelemetry.instrumentation.okhttp.v3_0;

import io.opentelemetry.context.propagation.TextMapSetter;
import javax.annotation.Nullable;
import okhttp3.Request;

/* JADX INFO: loaded from: classes4.dex */
enum RequestHeaderSetter implements TextMapSetter<Request.Builder> {
    INSTANCE;

    @Override // io.opentelemetry.context.propagation.TextMapSetter
    public void set(@Nullable Request.Builder builder, String str, String str2) {
        if (builder == null) {
            return;
        }
        builder.header(str, str2);
    }
}
