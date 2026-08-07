package com.geniusscansdk.structureddata.reader;

import com.box.androidsdk.content.models.BoxOrder;
import com.geniusscansdk.ocr.SpatialText;
import com.geniusscansdk.ocr.StringHelperKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: DateReader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bJ2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u000f*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/geniusscansdk/structureddata/reader/DateReader;", "", "locale", "Ljava/util/Locale;", "additionalDateReader", "Lcom/geniusscansdk/structureddata/reader/AdditionalDateReader;", "<init>", "(Ljava/util/Locale;Lcom/geniusscansdk/structureddata/reader/AdditionalDateReader;)V", BoxOrder.SORT_DATE, "Ljava/util/Date;", "fullText", "Lcom/geniusscansdk/ocr/SpatialText;", "dateRegexp", "", "rawText", "", "regex", "Lkotlin/text/Regex;", "groupIndexMap", "", "", "getDateToIntValue", "Lkotlin/text/MatchResult;", FirebaseAnalytics.Param.INDEX, "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DateReader {
    private final AdditionalDateReader additionalDateReader;
    private final Locale locale;

    public DateReader(Locale locale, AdditionalDateReader additionalDateReader) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.locale = locale;
        this.additionalDateReader = additionalDateReader;
    }

    public /* synthetic */ DateReader(Locale locale, AdditionalDateReader additionalDateReader, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale, (i & 2) != 0 ? null : additionalDateReader);
    }

    public final Date date(SpatialText fullText) {
        Object next;
        AdditionalDateReader additionalDateReader;
        SpatialText fullText2 = fullText;
        Intrinsics.checkNotNullParameter(fullText2, "fullText");
        ArrayList arrayList = new ArrayList();
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{"\\-", "\\/", "\\."});
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            linkedHashMap.put("year", 1);
            linkedHashMap.put("month", 2);
            linkedHashMap.put("day", 3);
            String rawText = fullText2.getRawText();
            Iterator it2 = it;
            Pattern patternCompile = Pattern.compile("(?<![\\d" + str + "])(?<year>[OIl0-9]{4})" + str + "(?<month>[OIl0-9]{1,2})" + str + "(?<day>[OIl0-9]{1,2})(?!" + str + "|\\d)");
            Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
            arrayList.addAll(dateRegexp(rawText, new Regex(patternCompile), linkedHashMap));
            if (Intrinsics.areEqual(this.locale, Locale.US)) {
                linkedHashMap.put("year", 3);
                linkedHashMap.put("month", 1);
                linkedHashMap.put("day", 2);
                String rawText2 = fullText.getRawText();
                Pattern patternCompile2 = Pattern.compile("(?<![\\d" + str + "])(?<month>\\b[OIl0-9]{1,2}\\b)" + str + "(?<day>[OIl0-9]{1,2})" + str + "(?<year>[OIl0-9]{2,4})(?!" + str + ")");
                Intrinsics.checkNotNullExpressionValue(patternCompile2, "compile(...)");
                arrayList.addAll(dateRegexp(rawText2, new Regex(patternCompile2), linkedHashMap));
            } else {
                linkedHashMap.put("year", 3);
                linkedHashMap.put("month", 2);
                linkedHashMap.put("day", 1);
                String rawText3 = fullText.getRawText();
                Pattern patternCompile3 = Pattern.compile("(?<![\\d" + str + "])(?<day>\\b[OIl0-9]{1,2}\\b)" + str + "(?<month>[OIl0-9]{1,2})" + str + "(?<year>[OIl0-9]{2,4})(?!" + str + ")");
                Intrinsics.checkNotNullExpressionValue(patternCompile3, "compile(...)");
                arrayList.addAll(dateRegexp(rawText3, new Regex(patternCompile3), linkedHashMap));
            }
            fullText2 = fullText;
            it = it2;
        }
        if (arrayList.isEmpty() && (additionalDateReader = this.additionalDateReader) != null) {
            arrayList.addAll(additionalDateReader.date(fullText, this.locale));
        }
        Iterator it3 = CollectionsKt.sorted(arrayList).iterator();
        while (it3.hasNext()) {
            next = it3.next();
            if (((Date) next).after(new Date(new Date().getTime() - 315576000000L))) {
                return (Date) next;
            }
        }
        next = null;
        return (Date) next;
    }

    private final List<Date> dateRegexp(String rawText, Regex regex, Map<String, Integer> groupIndexMap) {
        int i;
        ArrayList arrayList = new ArrayList();
        for (MatchResult matchResult : regex.findAll(rawText, 0)) {
            Integer num = groupIndexMap.get("day");
            Intrinsics.checkNotNull(num);
            String dateToIntValue = getDateToIntValue(matchResult, num.intValue());
            if (dateToIntValue == null) {
                break;
            }
            int i2 = Integer.parseInt(dateToIntValue);
            Integer num2 = groupIndexMap.get("month");
            Intrinsics.checkNotNull(num2);
            String dateToIntValue2 = getDateToIntValue(matchResult, num2.intValue());
            if (dateToIntValue2 == null) {
                break;
            }
            int i3 = Integer.parseInt(dateToIntValue2);
            if (i3 <= 12) {
                i3 = i2;
                i2 = i3;
            }
            Integer num3 = groupIndexMap.get("year");
            Intrinsics.checkNotNull(num3);
            String dateToIntValue3 = getDateToIntValue(matchResult, num3.intValue());
            if (dateToIntValue3 == null) {
                break;
            }
            if (dateToIntValue3.length() == 2) {
                i = Integer.parseInt(dateToIntValue3) + 2000;
            } else {
                i = Integer.parseInt(dateToIntValue3);
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(i, i2 - 1, i3);
            arrayList.add(new Date(calendar.getTimeInMillis()));
        }
        return arrayList;
    }

    private final String getDateToIntValue(MatchResult matchResult, int i) {
        String value;
        MatchGroup matchGroup = matchResult.getGroups().get(i);
        if (matchGroup == null || (value = matchGroup.getValue()) == null) {
            return null;
        }
        return StringHelperKt.replacingLettersConfusedWithDigits(value);
    }
}
