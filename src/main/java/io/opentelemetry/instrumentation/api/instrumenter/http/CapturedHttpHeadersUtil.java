package io.opentelemetry.instrumentation.api.instrumenter.http;

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
final class CapturedHttpHeadersUtil {
    private static final ConcurrentMap<String, AttributeKey<List<String>>> requestKeysCache = new ConcurrentHashMap();
    private static final ConcurrentMap<String, AttributeKey<List<String>>> responseKeysCache = new ConcurrentHashMap();

    static List<String> lowercase(List<String> list) {
        return Collections.unmodifiableList((List) list.stream().map(new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.CapturedHttpHeadersUtil$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).toLowerCase(Locale.ROOT);
            }
        }).collect(Collectors.toList()));
    }

    static AttributeKey<List<String>> requestAttributeKey(String str) {
        return requestKeysCache.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.CapturedHttpHeadersUtil$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return CapturedHttpHeadersUtil.createKey("request", (String) obj);
            }
        });
    }

    static AttributeKey<List<String>> responseAttributeKey(String str) {
        return responseKeysCache.computeIfAbsent(str, new Function() { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.CapturedHttpHeadersUtil$$ExternalSyntheticLambda2
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return CapturedHttpHeadersUtil.createKey("response", (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AttributeKey<List<String>> createKey(String str, String str2) {
        return AttributeKey.stringArrayKey("http." + str + ".header." + str2.replace(Soundex.SILENT_MARKER, SessionDataKt.UNDERSCORE));
    }

    private CapturedHttpHeadersUtil() {
    }
}
