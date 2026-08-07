package io.opentelemetry.instrumentation.api.instrumenter.messaging;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MessagingAttributesExtractorBuilder<REQUEST, RESPONSE> {
    List<String> capturedHeaders = Collections.emptyList();
    final MessagingAttributesGetter<REQUEST, RESPONSE> getter;
    final MessageOperation operation;

    MessagingAttributesExtractorBuilder(MessagingAttributesGetter<REQUEST, RESPONSE> messagingAttributesGetter, MessageOperation messageOperation) {
        this.getter = messagingAttributesGetter;
        this.operation = messageOperation;
    }

    public MessagingAttributesExtractorBuilder<REQUEST, RESPONSE> setCapturedHeaders(List<String> list) {
        this.capturedHeaders = list;
        return this;
    }

    public MessagingAttributesExtractor<REQUEST, RESPONSE> build() {
        return new MessagingAttributesExtractor<>(this.getter, this.operation, this.capturedHeaders);
    }
}
