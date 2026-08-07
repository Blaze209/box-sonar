package com.geniusscansdk.structureddata.reader;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxOrder;
import com.geniusscansdk.structureddata.ReceiptCategory;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReceiptReader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010&\u001a\u00020\u0005H\u0016J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\fHÆ\u0003JV\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u00064"}, d2 = {"Lcom/geniusscansdk/structureddata/reader/Receipt;", "", "locale", "Ljava/util/Locale;", "merchant", "", "amount", "", FirebaseAnalytics.Param.CURRENCY, BoxOrder.SORT_DATE, "Ljava/util/Date;", "category", "Lcom/geniusscansdk/structureddata/ReceiptCategory;", "<init>", "(Ljava/util/Locale;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/util/Date;Lcom/geniusscansdk/structureddata/ReceiptCategory;)V", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "getMerchant", "()Ljava/lang/String;", "setMerchant", "(Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Double;", "setAmount", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getCurrency", "setCurrency", "getDate", "()Ljava/util/Date;", "setDate", "(Ljava/util/Date;)V", "getCategory", "()Lcom/geniusscansdk/structureddata/ReceiptCategory;", "setCategory", "(Lcom/geniusscansdk/structureddata/ReceiptCategory;)V", "toString", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/util/Locale;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/util/Date;Lcom/geniusscansdk/structureddata/ReceiptCategory;)Lcom/geniusscansdk/structureddata/reader/Receipt;", "equals", "", "other", "hashCode", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class Receipt {
    private Double amount;
    private ReceiptCategory category;
    private String currency;
    private Date date;
    private Locale locale;
    private String merchant;

    public static /* synthetic */ Receipt copy$default(Receipt receipt, Locale locale, String str, Double d, String str2, Date date, ReceiptCategory receiptCategory, int i, Object obj) {
        if ((i & 1) != 0) {
            locale = receipt.locale;
        }
        if ((i & 2) != 0) {
            str = receipt.merchant;
        }
        if ((i & 4) != 0) {
            d = receipt.amount;
        }
        if ((i & 8) != 0) {
            str2 = receipt.currency;
        }
        if ((i & 16) != 0) {
            date = receipt.date;
        }
        if ((i & 32) != 0) {
            receiptCategory = receipt.category;
        }
        Date date2 = date;
        ReceiptCategory receiptCategory2 = receiptCategory;
        return receipt.copy(locale, str, d, str2, date2, receiptCategory2);
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

    public final Receipt copy(Locale locale, String merchant, Double amount, String currency, Date date, ReceiptCategory category) {
        return new Receipt(locale, merchant, amount, currency, date, category);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Receipt)) {
            return false;
        }
        Receipt receipt = (Receipt) other;
        return Intrinsics.areEqual(this.locale, receipt.locale) && Intrinsics.areEqual(this.merchant, receipt.merchant) && Intrinsics.areEqual((Object) this.amount, (Object) receipt.amount) && Intrinsics.areEqual(this.currency, receipt.currency) && Intrinsics.areEqual(this.date, receipt.date) && this.category == receipt.category;
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

    public Receipt(Locale locale, String str, Double d, String str2, Date date, ReceiptCategory receiptCategory) {
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

    public final void setLocale(Locale locale) {
        this.locale = locale;
    }

    public final String getMerchant() {
        return this.merchant;
    }

    public final void setMerchant(String str) {
        this.merchant = str;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final void setAmount(Double d) {
        this.amount = d;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final Date getDate() {
        return this.date;
    }

    public final void setDate(Date date) {
        this.date = date;
    }

    public final ReceiptCategory getCategory() {
        return this.category;
    }

    public final void setCategory(ReceiptCategory receiptCategory) {
        this.category = receiptCategory;
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
