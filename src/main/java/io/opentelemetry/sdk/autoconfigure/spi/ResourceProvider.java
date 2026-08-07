package io.opentelemetry.sdk.autoconfigure.spi;

import io.opentelemetry.sdk.resources.Resource;

/* JADX INFO: loaded from: classes4.dex */
public interface ResourceProvider extends Ordered {
    Resource createResource(ConfigProperties configProperties);
}
