package com.box.androidsdk.content.utils;

import com.box.androidsdk.content.models.BoxOrder;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLEndpointDateFormat.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/androidsdk/content/utils/GQLEndpointDateFormat;", "", "<init>", "()V", "LOG_TAG", "", "DATE_FORMAT", "dateFormat", "Lorg/apache/commons/lang3/time/FastDateFormat;", "parse", "Ljava/util/Date;", "dateString", "format", BoxOrder.SORT_DATE, "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLEndpointDateFormat {
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final GQLEndpointDateFormat INSTANCE = new GQLEndpointDateFormat();
    private static final String LOG_TAG = "GQLEndpointDateFormat";
    private static final org.apache.commons.lang3.time.FastDateFormat dateFormat;

    private GQLEndpointDateFormat() {
    }

    static {
        org.apache.commons.lang3.time.FastDateFormat fastDateFormat = org.apache.commons.lang3.time.FastDateFormat.getInstance(DATE_FORMAT, TimeZone.getTimeZone("UTC"), Locale.US);
        Intrinsics.checkNotNullExpressionValue(fastDateFormat, "getInstance(...)");
        dateFormat = fastDateFormat;
    }

    public final Date parse(String dateString) {
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        try {
            return dateFormat.parse(dateString);
        } catch (Exception e) {
            BoxLogUtils.w(LOG_TAG, "Could not parse " + dateString + " in GQL endpoint format. Exception: " + e);
            return null;
        }
    }

    public final String format(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String str = dateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
