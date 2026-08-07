package com.geniusscansdk.structureddata.reader;

import com.geniusscansdk.ocr.SpatialString;
import com.geniusscansdk.ocr.SpatialText;
import com.geniusscansdk.structureddata.ReceiptCategory;
import com.geniusscansdk.structureddata.data.MerchantData;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReceiptReader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ \u0010\f\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/geniusscansdk/structureddata/reader/ReceiptReader;", "", "fallbackLocale", "Ljava/util/Locale;", "additionalDateReader", "Lcom/geniusscansdk/structureddata/reader/AdditionalDateReader;", "maximumWordsThreshold", "", "minProportionOfDigits", "", "<init>", "(Ljava/util/Locale;Lcom/geniusscansdk/structureddata/reader/AdditionalDateReader;ID)V", "read", "Lcom/geniusscansdk/structureddata/reader/Receipt;", "spatialString", "", "Lcom/geniusscansdk/ocr/SpatialString;", "strict", "", "isReceipt", "receipt", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReceiptReader {
    private static final int DEFAULT_MAXIMUM_WORD_THRESHOLD = 275;
    private static final double DEFAULT_MINIMUM_PROPORTION_OF_DIGITS = 0.1d;
    private final AdditionalDateReader additionalDateReader;
    private final Locale fallbackLocale;
    private final int maximumWordsThreshold;
    private final double minProportionOfDigits;

    public ReceiptReader(Locale fallbackLocale, AdditionalDateReader additionalDateReader, int i, double d) {
        Intrinsics.checkNotNullParameter(fallbackLocale, "fallbackLocale");
        this.fallbackLocale = fallbackLocale;
        this.additionalDateReader = additionalDateReader;
        this.maximumWordsThreshold = i;
        this.minProportionOfDigits = d;
    }

    public /* synthetic */ ReceiptReader(Locale locale, AdditionalDateReader additionalDateReader, int i, double d, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale, (i2 & 2) != 0 ? null : additionalDateReader, (i2 & 4) != 0 ? DEFAULT_MAXIMUM_WORD_THRESHOLD : i, (i2 & 8) != 0 ? DEFAULT_MINIMUM_PROPORTION_OF_DIGITS : d);
    }

    public static /* synthetic */ Receipt read$default(ReceiptReader receiptReader, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return receiptReader.read(list, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Receipt read(List<SpatialString> spatialString, boolean strict) {
        Intrinsics.checkNotNullParameter(spatialString, "spatialString");
        SpatialText spatialText = new SpatialText(spatialString);
        MerchantData merchantData = null;
        Object[] objArr = 0;
        if (strict && spatialText.toLowercaseWords().size() > this.maximumWordsThreshold) {
            return null;
        }
        if (strict && spatialText.countOfDecimalDigits() < this.minProportionOfDigits * ((double) spatialText.characterCount())) {
            return null;
        }
        String strCurrency = new CurrencyReader(this.fallbackLocale).currency(spatialText);
        Locale locale = new LocalReader(this.fallbackLocale).locale(strCurrency);
        Double d = new TotalReader().total(spatialText.getSpatialString());
        ReceiptCategory receiptCategoryCategory = new CategoryReader(null, 1, null).category(spatialText);
        Receipt receipt = new Receipt(locale, MerchantReader.merchant$default(new MerchantReader(merchantData, 1, objArr == true ? 1 : 0), spatialText, receiptCategoryCategory, null, 4, null), d, strCurrency, new DateReader(locale, this.additionalDateReader).date(spatialText), receiptCategoryCategory);
        if (!strict || isReceipt(receipt)) {
            return receipt;
        }
        return null;
    }

    private final boolean isReceipt(Receipt receipt) {
        return receipt.getAmount() != null;
    }
}
