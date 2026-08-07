package io.split.android.client.service.impressions;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.dtos.Identifiable;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionsCountPerFeature implements Identifiable {
    private static final String FIELD_COUNT = "rc";
    private static final String FIELD_FEATURE = "f";
    private static final String FIELD_TIMEFRAME = "m";

    @SerializedName(FIELD_COUNT)
    public final int count;

    @SerializedName(FIELD_FEATURE)
    public final String feature;
    public transient long storageId;

    @SerializedName("m")
    public final long timeframe;

    public ImpressionsCountPerFeature(String feature, long timeframe, int count) {
        this.feature = feature;
        this.timeframe = timeframe;
        this.count = count;
    }

    public int hashCode() {
        return String.format("%s%d%d", this.feature, Long.valueOf(this.timeframe), Integer.valueOf(this.count)).hashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            ImpressionsCountPerFeature impressionsCountPerFeature = (ImpressionsCountPerFeature) o;
            if (this.feature.equals(impressionsCountPerFeature.feature) && this.timeframe == impressionsCountPerFeature.timeframe && this.count == impressionsCountPerFeature.count) {
                return true;
            }
        }
        return false;
    }

    @Override // io.split.android.client.dtos.Identifiable
    public long getId() {
        return this.storageId;
    }
}
