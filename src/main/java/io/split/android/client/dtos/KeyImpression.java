package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.impressions.Impression;
import io.split.android.client.storage.common.InBytesSizable;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class KeyImpression implements InBytesSizable, Identifiable {
    static final String FIELD_BUCKETING_KEY = "b";
    static final String FIELD_CHANGE_NUMBER = "c";
    static final String FIELD_KEY_NAME = "k";
    static final String FIELD_LABEL = "r";
    static final String FIELD_PREVIOUS_TIME = "pt";
    static final String FIELD_PROPERTIES = "properties";
    static final String FIELD_TIME = "m";
    static final String FIELD_TREATMENT = "t";

    @SerializedName(FIELD_BUCKETING_KEY)
    public String bucketingKey;

    @SerializedName(FIELD_CHANGE_NUMBER)
    public Long changeNumber;
    public transient String feature;

    @SerializedName("k")
    public String keyName;

    @SerializedName("r")
    public String label;

    @SerializedName(FIELD_PREVIOUS_TIME)
    public Long previousTime;

    @SerializedName("properties")
    public String properties;
    public transient long storageId;

    @SerializedName("m")
    public long time;

    @SerializedName("t")
    public String treatment;

    @Override // io.split.android.client.storage.common.InBytesSizable
    public long getSizeInBytes() {
        return 150L;
    }

    public KeyImpression() {
    }

    public KeyImpression(Impression impression) {
        this.feature = impression.split();
        this.keyName = impression.key();
        this.bucketingKey = impression.bucketingKey();
        this.label = impression.appliedRule();
        this.treatment = impression.treatment();
        this.time = impression.time();
        this.changeNumber = impression.changeNumber();
        this.previousTime = impression.previousTime();
        this.properties = impression.properties();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KeyImpression keyImpression = (KeyImpression) o;
        if (this.time != keyImpression.time || !Objects.equals(this.feature, keyImpression.feature) || !this.keyName.equals(keyImpression.keyName) || !this.treatment.equals(keyImpression.treatment)) {
            return false;
        }
        if (this.bucketingKey == null) {
            return keyImpression.bucketingKey == null;
        }
        if (this.previousTime.equals(keyImpression.previousTime) && Objects.equals(this.properties, keyImpression.properties)) {
            return this.bucketingKey.equals(keyImpression.bucketingKey);
        }
        return false;
    }

    public int hashCode() {
        String str = this.feature;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.keyName.hashCode()) * 31;
        String str2 = this.bucketingKey;
        int iHashCode2 = (((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.treatment.hashCode()) * 31;
        long j = this.time;
        return ((iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31) + this.previousTime.hashCode();
    }

    public static KeyImpression fromImpression(Impression impression) {
        KeyImpression keyImpression = new KeyImpression();
        keyImpression.feature = impression.split();
        keyImpression.keyName = impression.key();
        keyImpression.bucketingKey = impression.bucketingKey();
        keyImpression.time = impression.time();
        keyImpression.changeNumber = impression.changeNumber();
        keyImpression.treatment = impression.treatment();
        keyImpression.label = impression.appliedRule();
        keyImpression.previousTime = impression.previousTime();
        if (impression.properties() != null) {
            keyImpression.properties = impression.properties();
        }
        return keyImpression;
    }

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.storageId;
    }
}
