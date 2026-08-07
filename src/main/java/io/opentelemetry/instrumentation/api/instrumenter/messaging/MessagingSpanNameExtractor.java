package io.opentelemetry.instrumentation.api.instrumenter.messaging;

import io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor;

/* JADX INFO: loaded from: classes4.dex */
public final class MessagingSpanNameExtractor<REQUEST> implements SpanNameExtractor<REQUEST> {
    private final MessagingAttributesGetter<REQUEST, ?> getter;
    private final MessageOperation operation;

    public static <REQUEST> SpanNameExtractor<REQUEST> create(MessagingAttributesGetter<REQUEST, ?> messagingAttributesGetter, MessageOperation messageOperation) {
        return new MessagingSpanNameExtractor(messagingAttributesGetter, messageOperation);
    }

    private MessagingSpanNameExtractor(MessagingAttributesGetter<REQUEST, ?> messagingAttributesGetter, MessageOperation messageOperation) {
        this.getter = messagingAttributesGetter;
        this.operation = messageOperation;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanNameExtractor
    public String extract(REQUEST request) {
        String strDestination;
        if (this.getter.temporaryDestination(request)) {
            strDestination = "(temporary)";
        } else {
            strDestination = this.getter.destination(request);
        }
        if (strDestination == null) {
            strDestination = "unknown";
        }
        return strDestination + " " + this.operation.operationName();
    }
}
