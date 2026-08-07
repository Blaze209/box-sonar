package io.opentelemetry.api.trace.propagation.internal;

import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.api.trace.TraceStateBuilder;
import java.util.function.BiConsumer;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class W3CTraceContextEncoding {
    private static final char TRACESTATE_ENTRY_DELIMITER = ',';
    private static final Pattern TRACESTATE_ENTRY_DELIMITER_SPLIT_PATTERN = Pattern.compile("[ \t]*,[ \t]*");
    private static final char TRACESTATE_KEY_VALUE_DELIMITER = '=';
    private static final int TRACESTATE_MAX_MEMBERS = 32;
    private static final int TRACESTATE_MAX_SIZE = 512;

    private W3CTraceContextEncoding() {
    }

    public static TraceState decodeTraceState(String str) {
        TraceStateBuilder traceStateBuilderBuilder = TraceState.builder();
        String[] strArrSplit = TRACESTATE_ENTRY_DELIMITER_SPLIT_PATTERN.split(str);
        Utils.checkArgument(strArrSplit.length <= 32, "TraceState has too many elements.");
        for (int length = strArrSplit.length - 1; length >= 0; length--) {
            String str2 = strArrSplit[length];
            int iIndexOf = str2.indexOf(61);
            Utils.checkArgument(iIndexOf != -1, "Invalid TraceState list-member format.");
            traceStateBuilderBuilder.put(str2.substring(0, iIndexOf), str2.substring(iIndexOf + 1));
        }
        TraceState traceStateBuild = traceStateBuilderBuilder.build();
        return traceStateBuild.size() != strArrSplit.length ? TraceState.getDefault() : traceStateBuild;
    }

    public static String encodeTraceState(TraceState traceState) {
        if (traceState.isEmpty()) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(512);
        traceState.forEach(new BiConsumer() { // from class: io.opentelemetry.api.trace.propagation.internal.W3CTraceContextEncoding$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                W3CTraceContextEncoding.lambda$encodeTraceState$0(sb, (String) obj, (String) obj2);
            }
        });
        return sb.toString();
    }

    static /* synthetic */ void lambda$encodeTraceState$0(StringBuilder sb, String str, String str2) {
        if (sb.length() != 0) {
            sb.append(',');
        }
        sb.append(str).append(TRACESTATE_KEY_VALUE_DELIMITER).append(str2);
    }
}
