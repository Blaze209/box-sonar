package com.geniusscansdk.structureddata.reader;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.data.api.models.MetadataReservedKeys;
import com.geniusscansdk.ocr.RectangleF;
import com.geniusscansdk.ocr.SpatialFloat;
import com.geniusscansdk.ocr.SpatialString;
import com.geniusscansdk.ocr.SpatialStringKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: TotalReader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\tJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/geniusscansdk/structureddata/reader/TotalReader;", "", "<init>", "()V", "total", "", "spatialText", "", "Lcom/geniusscansdk/ocr/SpatialString;", "(Ljava/util/List;)Ljava/lang/Double;", "findTotalByTotalText", "distancePrivilegingXAxis", "", TypedValues.TransitionType.S_FROM, "Lcom/geniusscansdk/ocr/RectangleF;", TypedValues.TransitionType.S_TO, "findTotalByLargestCurrencyAmount", "findTotalByLargestDecimalNumber", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TotalReader {
    public final Double total(List<SpatialString> spatialText) {
        Intrinsics.checkNotNullParameter(spatialText, "spatialText");
        Double dFindTotalByTotalText = findTotalByTotalText(spatialText);
        if (dFindTotalByTotalText != null) {
            return dFindTotalByTotalText;
        }
        Double dFindTotalByLargestCurrencyAmount = findTotalByLargestCurrencyAmount(spatialText);
        if (dFindTotalByLargestCurrencyAmount != null) {
            return dFindTotalByLargestCurrencyAmount;
        }
        Double dFindTotalByLargestDecimalNumber = findTotalByLargestDecimalNumber(spatialText);
        if (dFindTotalByLargestDecimalNumber != null) {
            return dFindTotalByLargestDecimalNumber;
        }
        return null;
    }

    private final Double findTotalByTotalText(List<SpatialString> spatialText) {
        Map.Entry entry;
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{"total", "otal", "betale", "fuel total", "gas total", "take-out total", "debit", "summe", "totaal", "amount", "grand total", "zu zahlen", "gesamtbetrag", "betrag", "importo", "visa", "american express", "payement", "balance"});
        List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{"saved", "subtotal", "sub total"});
        List<SpatialString> list = spatialText;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            SpatialString spatialString = (SpatialString) obj;
            for (String str : listListOf) {
                String lowerCase = spatialString.getString().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.startsWith$default(StringsKt.trim((CharSequence) lowerCase).toString(), str, false, 2, (Object) null)) {
                    arrayList.add(obj);
                    break;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            String lowerCase2 = ((SpatialString) obj2).getString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (!listListOf2.contains(lowerCase2)) {
                arrayList2.add(obj2);
            }
        }
        ArrayList<SpatialString> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            SpatialFloat spatialFloat = SpatialStringKt.toSpatialFloat((SpatialString) it.next());
            if (spatialFloat != null) {
                arrayList4.add(spatialFloat);
            }
        }
        ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList();
        for (SpatialString spatialString2 : arrayList3) {
            ArrayList arrayList7 = !arrayList5.isEmpty() ? arrayList5 : null;
            if (arrayList7 != null) {
                ArrayList arrayList8 = arrayList7;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList8, 10)), 16));
                for (Object obj3 : arrayList8) {
                    LinkedHashMap linkedHashMap2 = linkedHashMap;
                    SpatialFloat spatialFloat2 = (SpatialFloat) obj3;
                    RectangleF boundingBox = spatialString2.getBoundingBox();
                    if (boundingBox == null) {
                        boundingBox = new RectangleF();
                    }
                    RectangleF boundingBox2 = spatialFloat2.getBoundingBox();
                    if (boundingBox2 == null) {
                        boundingBox2 = new RectangleF();
                    }
                    linkedHashMap2.put(obj3, Float.valueOf(distancePrivilegingXAxis(boundingBox, boundingBox2)));
                }
                Iterator it2 = linkedHashMap.entrySet().iterator();
                if (!it2.hasNext()) {
                    throw new NoSuchElementException();
                }
                Object next = it2.next();
                if (it2.hasNext()) {
                    float fFloatValue = ((Number) ((Map.Entry) next).getValue()).floatValue();
                    do {
                        Object next2 = it2.next();
                        float fFloatValue2 = ((Number) ((Map.Entry) next2).getValue()).floatValue();
                        if (Float.compare(fFloatValue, fFloatValue2) > 0) {
                            next = next2;
                            fFloatValue = fFloatValue2;
                        }
                    } while (it2.hasNext());
                }
                entry = (Map.Entry) next;
            } else {
                entry = null;
            }
            if (entry != null) {
                arrayList6.add(entry);
            }
        }
        ArrayList arrayList9 = arrayList6;
        int size = arrayList9.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return Double.valueOf(((SpatialFloat) ((Map.Entry) CollectionsKt.first((List) arrayList9)).getKey()).getValue());
        }
        Iterator it3 = arrayList9.iterator();
        if (!it3.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next3 = it3.next();
        if (it3.hasNext()) {
            double value = ((SpatialFloat) ((Map.Entry) next3).getKey()).getValue();
            do {
                Object next4 = it3.next();
                double value2 = ((SpatialFloat) ((Map.Entry) next4).getKey()).getValue();
                if (Double.compare(value, value2) < 0) {
                    next3 = next4;
                    value = value2;
                }
            } while (it3.hasNext());
        }
        return Double.valueOf(((SpatialFloat) ((Map.Entry) next3).getKey()).getValue());
    }

    private final float distancePrivilegingXAxis(RectangleF from, RectangleF to) {
        return ((from.centerX() - to.centerX()) * (from.centerX() - to.centerX())) + ((from.centerY() - to.centerY()) * (from.centerY() - to.centerY()) * (from.centerY() - to.centerY()) * (from.centerY() - to.centerY()));
    }

    private final Double findTotalByLargestCurrencyAmount(List<SpatialString> spatialText) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : spatialText) {
            SpatialString spatialString = (SpatialString) obj;
            if (StringsKt.contains$default((CharSequence) spatialString.getString(), (CharSequence) MetadataReservedKeys.PREFIX, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) spatialString.getString(), (CharSequence) "€", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) spatialString.getString(), (CharSequence) "£", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) spatialString.getString(), (CharSequence) "USD", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) spatialString.getString(), (CharSequence) "EUR", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) spatialString.getString(), (CharSequence) "GBP", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) spatialString.getString(), (CharSequence) "CAD", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) spatialString.getString(), (CharSequence) "AUS", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SpatialFloat spatialFloat = SpatialStringKt.toSpatialFloat((SpatialString) it.next());
            Double dValueOf = spatialFloat != null ? Double.valueOf(spatialFloat.getValue()) : null;
            if (dValueOf != null) {
                arrayList2.add(dValueOf);
            }
        }
        return CollectionsKt.maxOrNull((Iterable) arrayList2);
    }

    private final Double findTotalByLargestDecimalNumber(List<SpatialString> spatialText) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : spatialText) {
            SpatialString spatialString = (SpatialString) obj;
            if (StringsKt.contains$default((CharSequence) spatialString.getString(), (CharSequence) ".", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) spatialString.getString(), (CharSequence) ",", false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            SpatialFloat spatialFloat = SpatialStringKt.toSpatialFloat((SpatialString) it.next());
            Double dValueOf = spatialFloat != null ? Double.valueOf(spatialFloat.getValue()) : null;
            if (dValueOf != null) {
                arrayList2.add(dValueOf);
            }
        }
        return CollectionsKt.maxOrNull((Iterable) arrayList2);
    }
}
