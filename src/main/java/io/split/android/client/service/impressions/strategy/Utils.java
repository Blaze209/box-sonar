package io.split.android.client.service.impressions.strategy;

import io.split.android.client.impressions.Impression;

/* JADX INFO: loaded from: classes4.dex */
class Utils {
    Utils() {
    }

    static boolean hasProperties(Impression impression) {
        String strProperties;
        return (impression == null || (strProperties = impression.properties()) == null || strProperties.isEmpty()) ? false : true;
    }
}
