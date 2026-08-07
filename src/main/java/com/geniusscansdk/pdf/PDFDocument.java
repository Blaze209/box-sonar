package com.geniusscansdk.pdf;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.utils.SupportedFileExtensions;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PDFDocument.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003JU\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006'"}, d2 = {"Lcom/geniusscansdk/pdf/PDFDocument;", "", SupportedFileExtensions.PAGES_EXTENSION, "", "Lcom/geniusscansdk/pdf/PDFPage;", "title", "", "password", "keywords", "creationDate", "Ljava/util/Date;", "updateDate", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "getPages", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "getPassword", "getKeywords", "getCreationDate", "()Ljava/util/Date;", "getUpdateDate", "toJNI", "Lcom/geniusscansdk/pdf/JNIPDFDocument;", "toJNI$gssdk_release", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class PDFDocument {
    private final Date creationDate;
    private final String keywords;
    private final List<PDFPage> pages;
    private final String password;
    private final String title;
    private final Date updateDate;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PDFDocument(List<PDFPage> pages) {
        this(pages, null, null, null, null, null, 62, null);
        Intrinsics.checkNotNullParameter(pages, "pages");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PDFDocument(List<PDFPage> pages, String str) {
        this(pages, str, null, null, null, null, 60, null);
        Intrinsics.checkNotNullParameter(pages, "pages");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PDFDocument(List<PDFPage> pages, String str, String str2) {
        this(pages, str, str2, null, null, null, 56, null);
        Intrinsics.checkNotNullParameter(pages, "pages");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PDFDocument(List<PDFPage> pages, String str, String str2, String str3) {
        this(pages, str, str2, str3, null, null, 48, null);
        Intrinsics.checkNotNullParameter(pages, "pages");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PDFDocument(List<PDFPage> pages, String str, String str2, String str3, Date date) {
        this(pages, str, str2, str3, date, null, 32, null);
        Intrinsics.checkNotNullParameter(pages, "pages");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PDFDocument copy$default(PDFDocument pDFDocument, List list, String str, String str2, String str3, Date date, Date date2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = pDFDocument.pages;
        }
        if ((i & 2) != 0) {
            str = pDFDocument.title;
        }
        if ((i & 4) != 0) {
            str2 = pDFDocument.password;
        }
        if ((i & 8) != 0) {
            str3 = pDFDocument.keywords;
        }
        if ((i & 16) != 0) {
            date = pDFDocument.creationDate;
        }
        if ((i & 32) != 0) {
            date2 = pDFDocument.updateDate;
        }
        Date date3 = date;
        Date date4 = date2;
        return pDFDocument.copy(list, str, str2, str3, date3, date4);
    }

    public final List<PDFPage> component1() {
        return this.pages;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getKeywords() {
        return this.keywords;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Date getCreationDate() {
        return this.creationDate;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Date getUpdateDate() {
        return this.updateDate;
    }

    public final PDFDocument copy(List<PDFPage> pages, String title, String password, String keywords, Date creationDate, Date updateDate) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        return new PDFDocument(pages, title, password, keywords, creationDate, updateDate);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PDFDocument)) {
            return false;
        }
        PDFDocument pDFDocument = (PDFDocument) other;
        return Intrinsics.areEqual(this.pages, pDFDocument.pages) && Intrinsics.areEqual(this.title, pDFDocument.title) && Intrinsics.areEqual(this.password, pDFDocument.password) && Intrinsics.areEqual(this.keywords, pDFDocument.keywords) && Intrinsics.areEqual(this.creationDate, pDFDocument.creationDate) && Intrinsics.areEqual(this.updateDate, pDFDocument.updateDate);
    }

    public int hashCode() {
        int iHashCode = this.pages.hashCode() * 31;
        String str = this.title;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.password;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.keywords;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Date date = this.creationDate;
        int iHashCode5 = (iHashCode4 + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.updateDate;
        return iHashCode5 + (date2 != null ? date2.hashCode() : 0);
    }

    public String toString() {
        return "PDFDocument(pages=" + this.pages + ", title=" + this.title + ", password=" + this.password + ", keywords=" + this.keywords + ", creationDate=" + this.creationDate + ", updateDate=" + this.updateDate + ")";
    }

    public PDFDocument(List<PDFPage> pages, String str, String str2, String str3, Date date, Date date2) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        this.pages = pages;
        this.title = str;
        this.password = str2;
        this.keywords = str3;
        this.creationDate = date;
        this.updateDate = date2;
    }

    public /* synthetic */ PDFDocument(List list, String str, String str2, String str3, Date date, Date date2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : date, (i & 32) != 0 ? null : date2);
    }

    public final List<PDFPage> getPages() {
        return this.pages;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getPassword() {
        return this.password;
    }

    public final String getKeywords() {
        return this.keywords;
    }

    public final Date getCreationDate() {
        return this.creationDate;
    }

    public final Date getUpdateDate() {
        return this.updateDate;
    }

    public final JNIPDFDocument toJNI$gssdk_release() {
        String str = this.title;
        String str2 = this.password;
        String str3 = this.keywords;
        Date date = this.creationDate;
        Date date2 = this.updateDate;
        List<PDFPage> list = this.pages;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PDFPage) it.next()).toJNI$gssdk_release());
        }
        return new JNIPDFDocument(str, str2, str3, date, date2, new ArrayList(arrayList));
    }
}
