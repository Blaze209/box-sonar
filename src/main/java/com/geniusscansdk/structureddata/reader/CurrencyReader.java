package com.geniusscansdk.structureddata.reader;

import com.box.android.data.api.models.MetadataReservedKeys;
import com.facebook.hermes.intl.Constants;
import com.geniusscansdk.ocr.SpatialText;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CurrencyReader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/structureddata/reader/CurrencyReader;", "", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/util/Locale;)V", FirebaseAnalytics.Param.CURRENCY, "", "spatialText", "Lcom/geniusscansdk/ocr/SpatialText;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CurrencyReader {
    private final Locale locale;

    public CurrencyReader(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.locale = locale;
    }

    public final String currency(SpatialText spatialText) {
        Intrinsics.checkNotNullParameter(spatialText, "spatialText");
        Currency currency = NumberFormat.getCurrencyInstance(this.locale).getCurrency();
        String currencyCode = currency != null ? currency.getCurrencyCode() : null;
        String str = "EUR";
        if (spatialText.toLowercaseWords().contains("eur")) {
            return "EUR";
        }
        if (spatialText.toLowercaseWords().contains("mxn") || spatialText.toLowercaseWords().contains("mxn$")) {
            return "MXN";
        }
        if (spatialText.toLowercaseWords().contains("aud") || StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "AUD$", false, 2, (Object) null)) {
            return "AUD";
        }
        if (spatialText.toLowercaseWords().contains("usd") || StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "USD$", false, 2, (Object) null)) {
            return "USD";
        }
        if (spatialText.toLowercaseWords().contains("cad") || StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "CAD$", false, 2, (Object) null)) {
            return "CAD";
        }
        if (spatialText.toLowercaseWords().contains("nzd") || StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "NZ$", false, 2, (Object) null)) {
            return "NZD";
        }
        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "R$", false, 2, (Object) null)) {
            return "BRL";
        }
        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "NT$", false, 2, (Object) null)) {
            return "TWD";
        }
        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "J$", false, 2, (Object) null)) {
            return "JMD";
        }
        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "TT$", false, 2, (Object) null)) {
            return "TTD";
        }
        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "RD$", false, 2, (Object) null)) {
            return "DOP";
        }
        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "BZ$", false, 2, (Object) null)) {
            return "BZD";
        }
        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "C$", false, 2, (Object) null)) {
            return "NIO";
        }
        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "$U", false, 2, (Object) null)) {
            return "UYU";
        }
        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "$b", false, 2, (Object) null)) {
            return "BOB";
        }
        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) MetadataReservedKeys.PREFIX, false, 2, (Object) null)) {
            if (!CollectionsKt.contains(SetsKt.setOf((Object[]) new String[]{"ARS", "AUD", "BBD", "BMD", "BND", "BOB", "BRL", "BSD", "BZD", "CAD", "CLP", "COP", "DOP", "FJD", "GYD", "HKD", "JMD", "KYD", "LRD", "MXN", "NAD", "NIO", "NZD", "SBD", "SGD", "SRD", "TTD", "TWD", "UYU", "XCD", "ZWL"}), currencyCode)) {
                return "USD";
            }
        } else {
            if (!StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "€", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "EUR", false, 2, (Object) null)) {
                if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "GBP", false, 2, (Object) null)) {
                    return "GBP";
                }
                if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "£", false, 2, (Object) null)) {
                    if (!CollectionsKt.contains(SetsKt.setOf((Object[]) new String[]{"EGP", "FKP", "GIP", "LBP", "SHP", "SYP", "SDG"}), currencyCode)) {
                        return "GBP";
                    }
                } else {
                    if (spatialText.toLowercaseWords().contains("nok")) {
                        return "NOK";
                    }
                    str = "DKK";
                    if (spatialText.toLowercaseWords().contains("dkk")) {
                        return "DKK";
                    }
                    if (spatialText.toLowercaseWords().contains("sek")) {
                        return "SEK";
                    }
                    if (spatialText.toLowercaseWords().contains("isk")) {
                        return "ISK";
                    }
                    if (spatialText.toLowercaseWords().contains("kr") || spatialText.toLowercaseWords().contains("kr.")) {
                        if (CollectionsKt.contains(SetsKt.setOf((Object[]) new String[]{"NOK", "DKK", "SEK", "ISK"}), currencyCode)) {
                        }
                    } else {
                        if (spatialText.toLowercaseWords().contains("hkd")) {
                            return "HKD";
                        }
                        if (spatialText.toLowercaseWords().contains("chf")) {
                            return "CHF";
                        }
                        if (spatialText.toLowercaseWords().contains("zar")) {
                            return "ZAR";
                        }
                        if (spatialText.toLowercaseWords().contains(Constants.COLLATION_EXTENSION_PARAM_NUMERIC_SHORT)) {
                            return "HRK";
                        }
                        if (StringsKt.contains$default((CharSequence) spatialText.getRawText(), (CharSequence) "¥", false, 2, (Object) null) && !CollectionsKt.contains(SetsKt.setOf((Object[]) new String[]{"CNY", "JPY"}), currencyCode)) {
                            return "CNY";
                        }
                    }
                }
            }
            return str;
        }
        return currencyCode;
    }
}
