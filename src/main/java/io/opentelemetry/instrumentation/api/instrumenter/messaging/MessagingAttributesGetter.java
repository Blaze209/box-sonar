package io.opentelemetry.instrumentation.api.instrumenter.messaging;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface MessagingAttributesGetter<REQUEST, RESPONSE> {
    @Nullable
    String conversationId(REQUEST request);

    @Nullable
    String destination(REQUEST request);

    @Nullable
    String destinationKind(REQUEST request);

    @Nullable
    String messageId(REQUEST request, @Nullable RESPONSE response);

    @Nullable
    Long messagePayloadCompressedSize(REQUEST request);

    @Nullable
    Long messagePayloadSize(REQUEST request);

    @Nullable
    String protocol(REQUEST request);

    @Nullable
    String protocolVersion(REQUEST request);

    @Nullable
    String system(REQUEST request);

    boolean temporaryDestination(REQUEST request);

    @Nullable
    String url(REQUEST request);

    default List<String> header(REQUEST request, String str) {
        return Collections.emptyList();
    }
}
