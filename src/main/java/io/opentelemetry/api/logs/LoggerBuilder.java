package io.opentelemetry.api.logs;

/* JADX INFO: loaded from: classes4.dex */
public interface LoggerBuilder {
    Logger build();

    LoggerBuilder setEventDomain(String str);

    LoggerBuilder setInstrumentationVersion(String str);

    LoggerBuilder setSchemaUrl(String str);
}
