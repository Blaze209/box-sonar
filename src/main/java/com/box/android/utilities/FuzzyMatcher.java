package com.box.android.utilities;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FuzzyMatcher.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¨\u0006\u0010"}, d2 = {"Lcom/box/android/utilities/FuzzyMatcher;", "", "<init>", "()V", "getMatch", "", "actual", "", TypedValues.Custom.S_REFERENCE, "threshold", "normalizeText", "raw", "levenshtein", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FuzzyMatcher {
    public static final int $stable = 0;

    public static /* synthetic */ double getMatch$default(FuzzyMatcher fuzzyMatcher, String str, String str2, double d, int i, Object obj) {
        if ((i & 4) != 0) {
            d = 0.7d;
        }
        return fuzzyMatcher.getMatch(str, str2, d);
    }

    public final double getMatch(String actual, String reference, double threshold) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        Intrinsics.checkNotNullParameter(reference, "reference");
        String lowerCase = normalizeText(actual).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = normalizeText(reference).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        int i = 0;
        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
            return 1.0d;
        }
        int length = lowerCase2.length();
        if (lowerCase.length() < length) {
            return 1.0d - (((double) RangesKt.coerceAtMost(levenshtein(lowerCase, lowerCase2), length)) / ((double) length));
        }
        int length2 = lowerCase.length() - length;
        double d = 0.0d;
        if (length2 >= 0) {
            while (true) {
                String strSubstring = lowerCase.substring(i, i + length);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                double dCoerceAtMost = 1.0d - (((double) RangesKt.coerceAtMost(levenshtein(strSubstring, lowerCase2), length)) / ((double) length));
                if (dCoerceAtMost > d) {
                    d = dCoerceAtMost;
                }
                if (d >= threshold || i == length2) {
                    break;
                }
                i++;
            }
        }
        return d;
    }

    public final String normalizeText(String raw) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        return StringsKt.trim((CharSequence) new Regex("[,\\s]+").replace(StringsKt.replace$default(raw, "\n", " ", false, 4, (Object) null), " ")).toString();
    }

    private final int levenshtein(String a, String b) {
        int length = a.length() + 1;
        int[][] iArr = new int[length][];
        for (int i = 0; i < length; i++) {
            iArr[i] = new int[b.length() + 1];
        }
        int length2 = a.length();
        if (length2 >= 0) {
            int i2 = 0;
            while (true) {
                iArr[i2][0] = i2;
                if (i2 == length2) {
                    break;
                }
                i2++;
            }
        }
        int length3 = b.length();
        if (length3 >= 0) {
            int i3 = 0;
            while (true) {
                iArr[0][i3] = i3;
                if (i3 == length3) {
                    break;
                }
                i3++;
            }
        }
        int length4 = a.length();
        if (1 <= length4) {
            int i4 = 1;
            while (true) {
                int length5 = b.length();
                if (1 <= length5) {
                    int i5 = 1;
                    while (true) {
                        int i6 = i4 - 1;
                        int i7 = i5 - 1;
                        int i8 = a.charAt(i6) == b.charAt(i7) ? 0 : 1;
                        int[] iArr2 = iArr[i4];
                        int[] iArr3 = iArr[i6];
                        iArr2[i5] = Math.min(iArr3[i5] + 1, Math.min(iArr2[i7] + 1, iArr3[i7] + i8));
                        if (i5 == length5) {
                            break;
                        }
                        i5++;
                    }
                }
                if (i4 == length4) {
                    break;
                }
                i4++;
            }
        }
        return iArr[a.length()][b.length()];
    }
}
