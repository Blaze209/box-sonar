package io.split.android.client.service.impressions;

import io.split.android.client.impressions.Impression;
import io.split.android.client.utils.MurmurHash3;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionHasher {
    private static final int OFFSET = 0;
    private static final int SEED = 0;
    private static final String UNKNOWN = "UNKNOWN";

    private static String unknownIfNull(String s) {
        return s == null ? UNKNOWN : s;
    }

    private static Long zeroIfNull(Long l) {
        return Long.valueOf(l == null ? 0L : l.longValue());
    }

    public static Long process(Impression impression) {
        if (impression == null) {
            return null;
        }
        String str = unknownIfNull(impression.key()) + ":" + unknownIfNull(impression.split()) + ":" + unknownIfNull(impression.treatment()) + ":" + unknownIfNull(impression.appliedRule()) + ":" + zeroIfNull(impression.changeNumber());
        return Long.valueOf(MurmurHash3.murmurhash3_x86_32(str, 0, str.length(), 0));
    }
}
