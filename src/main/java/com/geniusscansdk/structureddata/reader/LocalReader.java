package com.geniusscansdk.structureddata.reader;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocalReader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/geniusscansdk/structureddata/reader/LocalReader;", "", "fallbackLocale", "Ljava/util/Locale;", "<init>", "(Ljava/util/Locale;)V", "locale", FirebaseAnalytics.Param.CURRENCY, "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LocalReader {
    private final Locale fallbackLocale;

    /* JADX WARN: Multi-variable type inference failed */
    public LocalReader() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public LocalReader(Locale fallbackLocale) {
        Intrinsics.checkNotNullParameter(fallbackLocale, "fallbackLocale");
        this.fallbackLocale = fallbackLocale;
    }

    public /* synthetic */ LocalReader(Locale locale, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Locale.FRENCH : locale);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final Locale locale(String currency) {
        if (currency != null) {
            switch (currency.hashCode()) {
                case 65168:
                    if (currency.equals("AUD")) {
                        Locale localeForLanguageTag = Locale.forLanguageTag("en-AU");
                        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
                        return localeForLanguageTag;
                    }
                    break;
                case 66470:
                    if (currency.equals("CAD")) {
                        Locale CANADA = Locale.CANADA;
                        Intrinsics.checkNotNullExpressionValue(CANADA, "CANADA");
                        return CANADA;
                    }
                    break;
                case 69026:
                    if (currency.equals("EUR")) {
                        Locale FRENCH = Locale.FRENCH;
                        Intrinsics.checkNotNullExpressionValue(FRENCH, "FRENCH");
                        return FRENCH;
                    }
                    break;
                case 70357:
                    if (currency.equals("GBP")) {
                        Locale UK = Locale.UK;
                        Intrinsics.checkNotNullExpressionValue(UK, "UK");
                        return UK;
                    }
                    break;
                case 76803:
                    if (currency.equals("MXN")) {
                        Locale localeForLanguageTag2 = Locale.forLanguageTag("es-MX");
                        Intrinsics.checkNotNullExpressionValue(localeForLanguageTag2, "forLanguageTag(...)");
                        return localeForLanguageTag2;
                    }
                    break;
                case 84326:
                    if (currency.equals("USD")) {
                        Locale US = Locale.US;
                        Intrinsics.checkNotNullExpressionValue(US, "US");
                        return US;
                    }
                    break;
            }
        }
        return this.fallbackLocale;
    }
}
