package io.opentelemetry.instrumentation.api.instrumenter.messaging;

import io.opentelemetry.api.common.AttributeKey;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.codec.language.Soundex;
import sdk.pendo.io.models.SessionDataKt;

/* JADX INFO: loaded from: classes4.dex */
final class CapturedMessageHeadersUtil {
    private static final ConcurrentMap<String, AttributeKey<List<String>>> attributeKeysCache = new ConcurrentHashMap();

    static List<String> lowercase(List<String> list) {
        return Collections.unmodifiableList((List) list.stream().map(new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.messaging.CapturedMessageHeadersUtil$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).toLowerCase(Locale.ROOT);
            }
        }).collect(Collectors.toList()));
    }

    static AttributeKey<List<String>> attributeKey(String str) {
        return attributeKeysCache.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.messaging.CapturedMessageHeadersUtil$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return CapturedMessageHeadersUtil.createKey((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AttributeKey<List<String>> createKey(String str) {
        return AttributeKey.stringArrayKey("messaging.header." + str.replace(Soundex.SILENT_MARKER, SessionDataKt.UNDERSCORE));
    }

    private CapturedMessageHeadersUtil() {
    }
}
