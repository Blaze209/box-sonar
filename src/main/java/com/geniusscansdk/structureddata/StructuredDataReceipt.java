package com.geniusscansdk.structureddata;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxOrder;
import com.geniusscansdk.structureddata.reader.Receipt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StructuredDataReceipt.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\r\u0010\u0011J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\fHÆ\u0003JV\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, d2 = {"Lcom/geniusscansdk/structureddata/StructuredDataReceipt;", "Ljava/io/Serializable;", "locale", "Ljava/util/Locale;", "merchant", "", "amount", "", FirebaseAnalytics.Param.CURRENCY, BoxOrder.SORT_DATE, "Ljava/util/Date;", "category", "Lcom/geniusscansdk/structureddata/ReceiptCategory;", "<init>", "(Ljava/util/Locale;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/util/Date;Lcom/geniusscansdk/structureddata/ReceiptCategory;)V", "receipt", "Lcom/geniusscansdk/structureddata/reader/Receipt;", "(Lcom/geniusscansdk/structureddata/reader/Receipt;)V", "getLocale", "()Ljava/util/Locale;", "getMerchant", "()Ljava/lang/String;", "getAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCurrency", "getDate", "()Ljava/util/Date;", "getCategory", "()Lcom/geniusscansdk/structureddata/ReceiptCategory;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/util/Locale;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/util/Date;Lcom/geniusscansdk/structureddata/ReceiptCategory;)Lcom/geniusscansdk/structureddata/StructuredDataReceipt;", "equals", "", "other", "", "hashCode", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class StructuredDataReceipt implements Serializable {
    private final Double amount;
    private final ReceiptCategory category;
    private final String currency;
    private final Date date;
    private final Locale locale;
    private final String merchant;

    public static /* synthetic */ StructuredDataReceipt copy$default(StructuredDataReceipt structuredDataReceipt, Locale locale, String str, Double d, String str2, Date date, ReceiptCategory receiptCategory, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = structuredDataReceipt.locale;
        }
        if ((i & 2) != 0) {
            str = structuredDataReceipt.merchant;
        }
        if ((i & 4) != 0) {
            d = structuredDataReceipt.amount;
        }
        if ((i & 8) != 0) {
            str2 = structuredDataReceipt.currency;
        }
        if ((i & 16) != 0) {
            date = structuredDataReceipt.date;
        }
        if ((i & 32) != 0) {
            receiptCategory = structuredDataReceipt.category;
        }
        Date date2 = date;
        ReceiptCategory receiptCategory2 = receiptCategory;
        return structuredDataReceipt.copy(locale, str, d, str2, date2, receiptCategory2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Locale getLocale() {
        return this.locale;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMerchant() {
        return this.merchant;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getAmount() {
        return this.amount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final ReceiptCategory getCategory() {
        return this.category;
    }

    public final StructuredDataReceipt copy(Locale locale, String merchant, Double amount, String currency, Date date, ReceiptCategory category) {
        return new StructuredDataReceipt(locale, merchant, amount, currency, date, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StructuredDataReceipt)) {
            return false;
        }
        StructuredDataReceipt structuredDataReceipt = (StructuredDataReceipt) other;
        return Intrinsics.areEqual(this.locale, structuredDataReceipt.locale) && Intrinsics.areEqual(this.merchant, structuredDataReceipt.merchant) && Intrinsics.areEqual((Object) this.amount, (Object) structuredDataReceipt.amount) && Intrinsics.areEqual(this.currency, structuredDataReceipt.currency) && Intrinsics.areEqual(this.date, structuredDataReceipt.date) && this.category == structuredDataReceipt.category;
    }

    public int hashCode() {
        Locale locale = this.locale;
        int iHashCode = (locale == null ? 0 : locale.hashCode()) * 31;
        String str = this.merchant;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Double d = this.amount;
        int iHashCode3 = (iHashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        String str2 = this.currency;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Date date = this.date;
        int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
        ReceiptCategory receiptCategory = this.category;
        return iHashCode5 + (receiptCategory != null ? receiptCategory.hashCode() : 0);
    }

    public StructuredDataReceipt(Locale locale, String str, Double d, String str2, Date date, ReceiptCategory receiptCategory) {
        this.locale = locale;
        this.merchant = str;
        this.amount = d;
        this.currency = str2;
        this.date = date;
        this.category = receiptCategory;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final String getMerchant() {
        return this.merchant;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final Date getDate() {
        return this.date;
    }

    public final ReceiptCategory getCategory() {
        return this.category;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StructuredDataReceipt(Receipt receipt) {
        this(receipt.getLocale(), receipt.getMerchant(), receipt.getAmount(), receipt.getCurrency(), receipt.getDate(), receipt.getCategory());
        Intrinsics.checkNotNullParameter(receipt, "receipt");
    }

    public String toString() {
        String str;
        Locale locale = this.locale;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        Date date = this.date;
        if (date == null || (str = simpleDateFormat.format(date)) == null) {
            str = "not found";
        }
        Locale locale2 = this.locale;
        String lowerCase = String.valueOf(this.category).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return "Locale: " + locale2 + "\nDate: " + str + "\nCategory: " + lowerCase + "\nMerchant: " + this.merchant + "\nCurrency: " + this.currency + "\nAmount: " + this.amount;
    }
}
