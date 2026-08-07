package zipkin2.v1;

import zipkin2.Endpoint;
import zipkin2.internal.Nullable;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class V1Annotation implements Comparable<V1Annotation> {
    final Endpoint endpoint;
    final long timestamp;
    final String value;

    public static V1Annotation create(long j, String str, @Nullable Endpoint endpoint) {
        return new V1Annotation(j, str, endpoint);
    }

    public long timestamp() {
        return this.timestamp;
    }

    public String value() {
        return this.value;
    }

    @Nullable
    public Endpoint endpoint() {
        return this.endpoint;
    }

    V1Annotation(long j, String str, @Nullable Endpoint endpoint) {
        this.timestamp = j;
        if (str == null) {
            throw new NullPointerException("value == null");
        }
        this.value = str;
        this.endpoint = endpoint;
    }

    public boolean equals(Object obj) {
        Endpoint endpoint;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1Annotation)) {
            return false;
        }
        V1Annotation v1Annotation = (V1Annotation) obj;
        return this.timestamp == v1Annotation.timestamp && this.value.equals(v1Annotation.value) && ((endpoint = this.endpoint) != null ? endpoint.equals(v1Annotation.endpoint) : v1Annotation.endpoint == null);
    }

    public int hashCode() {
        long j = this.timestamp;
        int iHashCode = (((((int) (((long) 1000003) ^ (j ^ (j >>> 32)))) ^ 1000003) * 1000003) ^ this.value.hashCode()) * 1000003;
        Endpoint endpoint = this.endpoint;
        return (endpoint == null ? 0 : endpoint.hashCode()) ^ iHashCode;
    }

    @Override // java.lang.Comparable
    public int compareTo(V1Annotation v1Annotation) {
        int i = 0;
        if (this == v1Annotation) {
            return 0;
        }
        long j = this.timestamp;
        long j2 = v1Annotation.timestamp;
        if (j < j2) {
            i = -1;
        } else if (j != j2) {
            i = 1;
        }
        return i != 0 ? i : this.value.compareTo(v1Annotation.value);
    }
}
