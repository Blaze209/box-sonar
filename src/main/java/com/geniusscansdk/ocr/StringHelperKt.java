package com.geniusscansdk.ocr;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StringHelper.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"replacingLettersConfusedWithDigits", "", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class StringHelperKt {
    public static final String replacingLettersConfusedWithDigits(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "O", "0", false, 4, (Object) null), "I", "1", false, 4, (Object) null), CmcdData.STREAM_TYPE_LIVE, "1", false, 4, (Object) null);
    }
}
