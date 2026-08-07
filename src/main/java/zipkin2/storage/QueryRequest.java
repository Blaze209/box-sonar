package zipkin2.storage;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import zipkin2.Annotation;
import zipkin2.Span;
import zipkin2.internal.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class QueryRequest {
    final Map<String, String> annotationQuery;
    final long endTs;
    final int limit;
    final long lookback;
    final Long maxDuration;
    final Long minDuration;
    final String remoteServiceName;
    final String serviceName;
    final String spanName;

    @Nullable
    public String serviceName() {
        return this.serviceName;
    }

    @Nullable
    public String remoteServiceName() {
        return this.remoteServiceName;
    }

    @Nullable
    public String spanName() {
        return this.spanName;
    }

    public Map<String, String> annotationQuery() {
        return this.annotationQuery;
    }

    @Nullable
    public Long minDuration() {
        return this.minDuration;
    }

    @Nullable
    public Long maxDuration() {
        return this.maxDuration;
    }

    public long endTs() {
        return this.endTs;
    }

    public long lookback() {
        return this.lookback;
    }

    public int limit() {
        return this.limit;
    }

    @Nullable
    public String annotationQueryString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = annotationQuery().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            sb.append(next.getKey());
            if (!next.getValue().isEmpty()) {
                sb.append('=').append(next.getValue());
            }
            if (it.hasNext()) {
                sb.append(" and ");
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        Map<String, String> annotationQuery;
        long endTs;
        int limit;
        long lookback;
        Long maxDuration;
        Long minDuration;
        String remoteServiceName;
        String serviceName;
        String spanName;

        Builder(QueryRequest queryRequest) {
            this.annotationQuery = Collections.emptyMap();
            this.serviceName = queryRequest.serviceName;
            this.remoteServiceName = queryRequest.remoteServiceName;
            this.spanName = queryRequest.spanName;
            this.annotationQuery = queryRequest.annotationQuery;
            this.minDuration = queryRequest.minDuration;
            this.maxDuration = queryRequest.maxDuration;
            this.endTs = queryRequest.endTs;
            this.lookback = queryRequest.lookback;
            this.limit = queryRequest.limit;
        }

        public Builder serviceName(@Nullable String str) {
            this.serviceName = str;
            return this;
        }

        public Builder remoteServiceName(@Nullable String str) {
            this.remoteServiceName = str;
            return this;
        }

        public Builder spanName(@Nullable String str) {
            this.spanName = str;
            return this;
        }

        public Builder parseAnnotationQuery(@Nullable String str) {
            if (str == null || str.isEmpty()) {
                return this;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str2 : str.split(" and ", 100)) {
                int iIndexOf = str2.indexOf(61);
                if (iIndexOf == -1) {
                    String strTrim = str2.trim();
                    if (!linkedHashMap.containsKey(strTrim)) {
                        linkedHashMap.put(strTrim, "");
                    }
                } else {
                    linkedHashMap.put(str2.substring(0, iIndexOf).trim(), str2.split(SimpleComparison.EQUAL_TO_OPERATION, 2).length >= 2 ? str2.substring(iIndexOf + 1).trim() : "");
                }
            }
            return annotationQuery(linkedHashMap);
        }

        public Builder annotationQuery(Map<String, String> map) {
            if (map == null) {
                throw new NullPointerException("annotationQuery == null");
            }
            this.annotationQuery = map;
            return this;
        }

        public Builder minDuration(@Nullable Long l) {
            this.minDuration = l;
            return this;
        }

        public Builder maxDuration(@Nullable Long l) {
            this.maxDuration = l;
            return this;
        }

        public Builder endTs(long j) {
            this.endTs = j;
            return this;
        }

        public Builder lookback(long j) {
            this.lookback = j;
            return this;
        }

        public Builder limit(int i) {
            this.limit = i;
            return this;
        }

        public final QueryRequest build() {
            String str = this.serviceName;
            if (str != null) {
                this.serviceName = str.toLowerCase(Locale.ROOT);
            }
            String str2 = this.remoteServiceName;
            if (str2 != null) {
                this.remoteServiceName = str2.toLowerCase(Locale.ROOT);
            }
            String str3 = this.spanName;
            if (str3 != null) {
                this.spanName = str3.toLowerCase(Locale.ROOT);
            }
            this.annotationQuery.remove("");
            if ("".equals(this.serviceName)) {
                this.serviceName = null;
            }
            if ("".equals(this.remoteServiceName)) {
                this.remoteServiceName = null;
            }
            if ("".equals(this.spanName) || "all".equals(this.spanName)) {
                this.spanName = null;
            }
            if (this.endTs <= 0) {
                throw new IllegalArgumentException("endTs <= 0");
            }
            if (this.limit <= 0) {
                throw new IllegalArgumentException("limit <= 0");
            }
            if (this.lookback <= 0) {
                throw new IllegalArgumentException("lookback <= 0");
            }
            Long l = this.minDuration;
            if (l != null) {
                if (l.longValue() <= 0) {
                    throw new IllegalArgumentException("minDuration <= 0");
                }
                Long l2 = this.maxDuration;
                if (l2 != null && l2.longValue() < this.minDuration.longValue()) {
                    throw new IllegalArgumentException("maxDuration < minDuration");
                }
            } else if (this.maxDuration != null) {
                throw new IllegalArgumentException("maxDuration is only valid with minDuration");
            }
            return new QueryRequest(this.serviceName, this.remoteServiceName, this.spanName, this.annotationQuery, this.minDuration, this.maxDuration, this.endTs, this.lookback, this.limit);
        }

        Builder() {
            this.annotationQuery = Collections.emptyMap();
        }
    }

    public boolean test(List<Span> list) {
        long jTimestampAsLong = 0;
        for (Span span : list) {
            if (span.timestampAsLong() != 0) {
                if (span.parentId() == null) {
                    jTimestampAsLong = span.timestampAsLong();
                    break;
                }
                if (jTimestampAsLong == 0 || jTimestampAsLong > span.timestampAsLong()) {
                    jTimestampAsLong = span.timestampAsLong();
                }
            }
        }
        if (jTimestampAsLong != 0 && jTimestampAsLong >= (endTs() - lookback()) * 1000 && jTimestampAsLong <= endTs() * 1000) {
            boolean z = minDuration() == null && maxDuration() == null;
            String strServiceName = serviceName();
            String strRemoteServiceName = remoteServiceName();
            String strSpanName = spanName();
            LinkedHashMap linkedHashMap = new LinkedHashMap(annotationQuery());
            for (Span span2 : list) {
                String strLocalServiceName = span2.localServiceName();
                if (serviceName() == null || serviceName().equals(strLocalServiceName)) {
                    for (Annotation annotation : span2.annotations()) {
                        if ("".equals(linkedHashMap.get(annotation.value()))) {
                            linkedHashMap.remove(annotation.value());
                        }
                    }
                    for (Map.Entry<String, String> entry : span2.tags().entrySet()) {
                        String str = (String) linkedHashMap.get(entry.getKey());
                        if (str != null && (str.isEmpty() || str.equals(entry.getValue()))) {
                            linkedHashMap.remove(entry.getKey());
                        }
                    }
                    strServiceName = null;
                    if (strRemoteServiceName != null && strRemoteServiceName.equals(span2.remoteServiceName())) {
                        strRemoteServiceName = null;
                    }
                    if (strSpanName != null && strSpanName.equals(span2.name())) {
                        strSpanName = null;
                    }
                    if (!z) {
                        if (minDuration() == null || maxDuration() == null) {
                            if (minDuration() != null) {
                                z = span2.durationAsLong() >= minDuration().longValue();
                            }
                        } else if (span2.durationAsLong() < minDuration().longValue() || span2.durationAsLong() > maxDuration().longValue()) {
                        }
                    }
                }
            }
            if ((serviceName() == null || strServiceName == null) && strRemoteServiceName == null && strSpanName == null && linkedHashMap.isEmpty() && z) {
                return true;
            }
        }
        return false;
    }

    QueryRequest(@Nullable String str, @Nullable String str2, @Nullable String str3, Map<String, String> map, @Nullable Long l, @Nullable Long l2, long j, long j2, int i) {
        this.serviceName = str;
        this.remoteServiceName = str2;
        this.spanName = str3;
        this.annotationQuery = map;
        this.minDuration = l;
        this.maxDuration = l2;
        this.endTs = j;
        this.lookback = j2;
        this.limit = i;
    }

    public String toString() {
        String str = ("QueryRequest{endTs=" + this.endTs + ", ") + "lookback=" + this.lookback + ", ";
        if (this.serviceName != null) {
            str = str + "serviceName=" + this.serviceName + ", ";
        }
        if (this.remoteServiceName != null) {
            str = str + "remoteServiceName=" + this.remoteServiceName + ", ";
        }
        if (this.spanName != null) {
            str = str + "spanName=" + this.spanName + ", ";
        }
        if (!this.annotationQuery.isEmpty()) {
            str = str + "annotationQuery=" + this.annotationQuery + ", ";
        }
        if (this.minDuration != null) {
            str = str + "minDuration=" + this.minDuration + ", ";
        }
        if (this.maxDuration != null) {
            str = str + "maxDuration=" + this.maxDuration + ", ";
        }
        return str + "limit=" + this.limit + "}";
    }
}
