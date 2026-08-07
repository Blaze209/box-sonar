package com.apollographql.apollo3.api.http.internal;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: UrlEncode.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0002\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0005H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083D¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"RESERVED_CHARS", "", "getRESERVED_CHARS$annotations", "()V", "percentEncode", "", "urlEncode", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class UrlEncodeKt {
    private static final String RESERVED_CHARS = "!#$&'\"()*+,/:;=?@[]{}% ";

    private static /* synthetic */ void getRESERVED_CHARS$annotations() {
    }

    public static final String urlEncode(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder();
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            char cCharAt = str2.charAt(i);
            if (StringsKt.contains$default((CharSequence) RESERVED_CHARS, cCharAt, false, 2, (Object) null)) {
                sb.append(percentEncode(cCharAt));
            } else {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private static final String percentEncode(char c) {
        StringBuilder sb = new StringBuilder("%");
        String string = Integer.toString(c, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String upperCase = sb.append(string).toString().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
