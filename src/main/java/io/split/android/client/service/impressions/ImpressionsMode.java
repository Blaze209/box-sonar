package io.split.android.client.service.impressions;

/* JADX INFO: loaded from: classes4.dex */
public enum ImpressionsMode {
    OPTIMIZED,
    DEBUG,
    NONE;

    public static ImpressionsMode fromString(String value) {
        if (value != null) {
            value = value.toUpperCase();
        }
        if ("DEBUG".equals(value)) {
            return DEBUG;
        }
        if ("NONE".equals(value)) {
            return NONE;
        }
        return OPTIMIZED;
    }
}
