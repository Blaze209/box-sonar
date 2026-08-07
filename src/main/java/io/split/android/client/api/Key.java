package io.split.android.client.api;

import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class Key {
    private final String mBucketingKey;
    private final String mMatchingKey;

    public Key(String matchingKey, String bucketingKey) {
        this.mMatchingKey = matchingKey;
        this.mBucketingKey = bucketingKey;
    }

    public Key(String matchingKey) {
        this(matchingKey, null);
    }

    public String matchingKey() {
        return this.mMatchingKey;
    }

    public String bucketingKey() {
        return this.mBucketingKey;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Key)) {
            return false;
        }
        Key key = (Key) o;
        return this.mMatchingKey.equals(key.mMatchingKey) && Objects.equals(this.mBucketingKey, key.mBucketingKey);
    }

    public int hashCode() {
        int iHashCode = (this.mMatchingKey.hashCode() ^ 17000051) * 1000003;
        String str = this.mBucketingKey;
        return str != null ? str.hashCode() ^ iHashCode : iHashCode;
    }

    public String toString() {
        return this.mMatchingKey + ", " + this.mBucketingKey;
    }
}
