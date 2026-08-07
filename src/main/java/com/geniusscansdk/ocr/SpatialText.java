package com.geniusscansdk.ocr;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SpatialText.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0013HÖ\u0001J\t\u0010\u001b\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/geniusscansdk/ocr/SpatialText;", "", "spatialString", "", "Lcom/geniusscansdk/ocr/SpatialString;", "<init>", "(Ljava/util/List;)V", "getSpatialString", "()Ljava/util/List;", "rawText", "", "getRawText", "()Ljava/lang/String;", "topPositionsOfText", "Lkotlin/Pair;", "", "toLowercaseWords", "", "countOfDecimalDigits", "", "characterCount", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SpatialText {
    private final String rawText;
    private final List<SpatialString> spatialString;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SpatialText copy$default(SpatialText spatialText, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = spatialText.spatialString;
        }
        return spatialText.copy(list);
    }

    public final List<SpatialString> component1() {
        return this.spatialString;
    }

    public final SpatialText copy(List<SpatialString> spatialString) {
        Intrinsics.checkNotNullParameter(spatialString, "spatialString");
        return new SpatialText(spatialString);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SpatialText) && Intrinsics.areEqual(this.spatialString, ((SpatialText) other).spatialString);
    }

    public int hashCode() {
        return this.spatialString.hashCode();
    }

    public String toString() {
        return "SpatialText(spatialString=" + this.spatialString + ")";
    }

    public SpatialText(List<SpatialString> spatialString) {
        Intrinsics.checkNotNullParameter(spatialString, "spatialString");
        this.spatialString = spatialString;
        this.rawText = CollectionsKt.joinToString$default(spatialString, "\n", null, null, 0, null, new Function1() { // from class: com.geniusscansdk.ocr.SpatialText$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SpatialText.rawText$lambda$0((SpatialString) obj);
            }
        }, 30, null);
    }

    public final List<SpatialString> getSpatialString() {
        return this.spatialString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence rawText$lambda$0(SpatialString it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getString();
    }

    public final String getRawText() {
        return this.rawText;
    }

    public final Pair<Float, Float> topPositionsOfText() {
        List<SpatialString> list = this.spatialString;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            RectangleF boundingBox = ((SpatialString) it.next()).getBoundingBox();
            Float fValueOf = boundingBox != null ? Float.valueOf(boundingBox.getTop()) : null;
            if (fValueOf != null) {
                arrayList.add(fValueOf);
            }
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.geniusscansdk.ocr.SpatialText$topPositionsOfText$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Float.valueOf(((Number) t).floatValue()), Float.valueOf(((Number) t2).floatValue()));
            }
        });
        if (!listSortedWith.isEmpty()) {
            return new Pair<>(listSortedWith.get(0), listSortedWith.get(CollectionsKt.getLastIndex(listSortedWith)));
        }
        return new Pair<>(Float.valueOf(0.0f), Float.valueOf(this.spatialString.get(0).getDocumentSize().getHeight()));
    }

    public final Set<String> toLowercaseWords() {
        Pattern patternCompile = Pattern.compile("\\s+|\\R+");
        String lowerCase = StringsKt.trim((CharSequence) this.rawText).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String[] strArrSplit = patternCompile.split(lowerCase);
        Intrinsics.checkNotNullExpressionValue(strArrSplit, "split(...)");
        return ArraysKt.toSet(strArrSplit);
    }

    public final int countOfDecimalDigits() {
        String str = this.rawText;
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (Character.isDigit(str.charAt(i2))) {
                i++;
            }
        }
        return i;
    }

    public final int characterCount() {
        Iterator<T> it = this.spatialString.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += ((SpatialString) it.next()).getString().length();
        }
        return length;
    }
}
