package com.splunk.rum;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* JADX INFO: loaded from: classes3.dex */
public final class StandardAttributes {
    public static final AttributeKey<String> APP_VERSION = AttributeKey.stringKey("app.version");
    public static final AttributeKey<String> APP_BUILD_TYPE = AttributeKey.stringKey("app.build.type");
    public static final AttributeKey<String> HTTP_URL = SemanticAttributes.HTTP_URL;

    private StandardAttributes() {
    }
}
