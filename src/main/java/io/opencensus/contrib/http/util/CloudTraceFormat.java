package io.opencensus.contrib.http.util;

import com.amplitude.api.Constants;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedInts;
import com.google.common.primitives.UnsignedLongs;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.TraceId;
import io.opencensus.trace.TraceOptions;
import io.opencensus.trace.Tracestate;
import io.opencensus.trace.propagation.SpanContextParseException;
import io.opencensus.trace.propagation.TextFormat;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class CloudTraceFormat extends TextFormat {
    static final int CLOUD_TRACE_IS_SAMPLED = 1;
    static final int MIN_HEADER_SIZE = 34;
    static final String NOT_SAMPLED = "0";
    static final String SAMPLED = "1";
    static final char SPAN_ID_DELIMITER = '/';
    static final int SPAN_ID_START_POS = 33;
    static final int TRACE_ID_SIZE = 32;
    static final String HEADER_NAME = "X-Cloud-Trace-Context";
    static final List<String> FIELDS = Collections.singletonList(HEADER_NAME);
    static final TraceOptions OPTIONS_SAMPLED = TraceOptions.builder().setIsSampled(true).build();
    static final TraceOptions OPTIONS_NOT_SAMPLED = TraceOptions.DEFAULT;
    static final String TRACE_OPTION_DELIMITER = ";o=";
    static final int TRACE_OPTION_DELIMITER_SIZE = TRACE_OPTION_DELIMITER.length();
    private static final Tracestate TRACESTATE_DEFAULT = Tracestate.builder().build();

    CloudTraceFormat() {
    }

    @Override // io.opencensus.trace.propagation.TextFormat
    public List<String> fields() {
        return FIELDS;
    }

    @Override // io.opencensus.trace.propagation.TextFormat
    public <C> void inject(SpanContext spanContext, C c, TextFormat.Setter<C> setter) {
        Preconditions.checkNotNull(spanContext, "spanContext");
        Preconditions.checkNotNull(setter, "setter");
        Preconditions.checkNotNull(c, Constants.AMP_TRACKING_OPTION_CARRIER);
        setter.put(c, HEADER_NAME, spanContext.getTraceId().toLowerBase16() + '/' + UnsignedLongs.toString(spanIdToLong(spanContext.getSpanId())) + TRACE_OPTION_DELIMITER + (spanContext.getTraceOptions().isSampled() ? "1" : "0"));
    }

    @Override // io.opencensus.trace.propagation.TextFormat
    public <C> SpanContext extract(C c, TextFormat.Getter<C> getter) throws SpanContextParseException {
        Preconditions.checkNotNull(c, Constants.AMP_TRACKING_OPTION_CARRIER);
        Preconditions.checkNotNull(getter, "getter");
        try {
            String str = getter.get(c, HEADER_NAME);
            if (str == null || str.length() < 34) {
                throw new SpanContextParseException("Missing or too short header: X-Cloud-Trace-Context");
            }
            Preconditions.checkArgument(str.charAt(32) == '/', "Invalid TRACE_ID size");
            TraceId traceIdFromLowerBase16 = TraceId.fromLowerBase16(str.subSequence(0, 32));
            int iIndexOf = str.indexOf(TRACE_OPTION_DELIMITER, 32);
            SpanId spanIdLongToSpanId = longToSpanId(UnsignedLongs.parseUnsignedLong(str.subSequence(33, iIndexOf < 0 ? str.length() : iIndexOf).toString(), 10));
            TraceOptions traceOptions = OPTIONS_NOT_SAMPLED;
            if (iIndexOf > 0 && (UnsignedInts.parseUnsignedInt(str.substring(iIndexOf + TRACE_OPTION_DELIMITER_SIZE), 10) & 1) != 0) {
                traceOptions = OPTIONS_SAMPLED;
            }
            return SpanContext.create(traceIdFromLowerBase16, spanIdLongToSpanId, traceOptions, TRACESTATE_DEFAULT);
        } catch (IllegalArgumentException e) {
            throw new SpanContextParseException("Invalid input", e);
        }
    }

    private static SpanId longToSpanId(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putLong(j);
        return SpanId.fromBytes(byteBufferAllocate.array());
    }

    private static long spanIdToLong(SpanId spanId) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.put(spanId.getBytes());
        return byteBufferAllocate.getLong(0);
    }
}
