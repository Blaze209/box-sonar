package io.opentelemetry.api.logs;

/* JADX INFO: loaded from: classes4.dex */
public interface Logger {
    EventBuilder eventBuilder(String str);

    LogRecordBuilder logRecordBuilder();
}
