package zipkin2.v1;

import zipkin2.Endpoint;
import zipkin2.internal.Nullable;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class V1BinaryAnnotation implements Comparable<V1BinaryAnnotation> {
    public static final int TYPE_BOOLEAN = 0;
    public static final int TYPE_STRING = 6;
    final Endpoint endpoint;
    final String key;
    final String stringValue;
    final int type;

    public static V1BinaryAnnotation createAddress(String str, Endpoint endpoint) {
        if (endpoint == null) {
            throw new NullPointerException("endpoint == null");
        }
        return new V1BinaryAnnotation(str, null, endpoint);
    }

    public static V1BinaryAnnotation createString(String str, String str2, Endpoint endpoint) {
        if (str2 == null) {
            throw new NullPointerException("value == null");
        }
        return new V1BinaryAnnotation(str, str2, endpoint);
    }

    public String key() {
        return this.key;
    }

    public int type() {
        return this.type;
    }

    @Nullable
    public String stringValue() {
        return this.stringValue;
    }

    public Endpoint endpoint() {
        return this.endpoint;
    }

    V1BinaryAnnotation(String str, String str2, Endpoint endpoint) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        this.key = str;
        this.stringValue = str2;
        this.type = str2 != null ? 6 : 0;
        this.endpoint = endpoint;
    }

    public boolean equals(Object obj) {
        String str;
        Endpoint endpoint;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof V1BinaryAnnotation)) {
            return false;
        }
        V1BinaryAnnotation v1BinaryAnnotation = (V1BinaryAnnotation) obj;
        return this.key.equals(v1BinaryAnnotation.key) && ((str = this.stringValue) != null ? str.equals(v1BinaryAnnotation.stringValue) : v1BinaryAnnotation.stringValue == null) && ((endpoint = this.endpoint) != null ? endpoint.equals(v1BinaryAnnotation.endpoint) : v1BinaryAnnotation.endpoint == null);
    }

    public int hashCode() {
        int iHashCode = (this.key.hashCode() ^ 1000003) * 1000003;
        String str = this.stringValue;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Endpoint endpoint = this.endpoint;
        return iHashCode2 ^ (endpoint != null ? endpoint.hashCode() : 0);
    }

    @Override // java.lang.Comparable
    public int compareTo(V1BinaryAnnotation v1BinaryAnnotation) {
        if (this == v1BinaryAnnotation) {
            return 0;
        }
        return this.key.compareTo(v1BinaryAnnotation.key);
    }
}
