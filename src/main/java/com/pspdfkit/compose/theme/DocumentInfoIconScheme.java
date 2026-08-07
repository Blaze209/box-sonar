package com.pspdfkit.compose.theme;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.internal.nd;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/pspdfkit/compose/theme/DocumentInfoIconScheme;", "", "documentInfoContentIcon", "", "documentInfoChangesIcon", "documentInfoSizeIcon", "documentInfoFabEditIcon", "documentInfoFabDoneIcon", "<init>", "(IIIII)V", "getDocumentInfoContentIcon", "()I", "getDocumentInfoChangesIcon", "getDocumentInfoSizeIcon", "getDocumentInfoFabEditIcon", "getDocumentInfoFabDoneIcon", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DocumentInfoIconScheme {
    public static final int $stable = 0;
    private final int documentInfoChangesIcon;
    private final int documentInfoContentIcon;
    private final int documentInfoFabDoneIcon;
    private final int documentInfoFabEditIcon;
    private final int documentInfoSizeIcon;

    public DocumentInfoIconScheme(int i, int i2, int i3, int i4, int i5) {
        this.documentInfoContentIcon = i;
        this.documentInfoChangesIcon = i2;
        this.documentInfoSizeIcon = i3;
        this.documentInfoFabEditIcon = i4;
        this.documentInfoFabDoneIcon = i5;
    }

    public static /* synthetic */ DocumentInfoIconScheme copy$default(DocumentInfoIconScheme documentInfoIconScheme, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = documentInfoIconScheme.documentInfoContentIcon;
        }
        if ((i6 & 2) != 0) {
            i2 = documentInfoIconScheme.documentInfoChangesIcon;
        }
        if ((i6 & 4) != 0) {
            i3 = documentInfoIconScheme.documentInfoSizeIcon;
        }
        if ((i6 & 8) != 0) {
            i4 = documentInfoIconScheme.documentInfoFabEditIcon;
        }
        if ((i6 & 16) != 0) {
            i5 = documentInfoIconScheme.documentInfoFabDoneIcon;
        }
        int i7 = i5;
        int i8 = i3;
        return documentInfoIconScheme.copy(i, i2, i8, i4, i7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDocumentInfoContentIcon() {
        return this.documentInfoContentIcon;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDocumentInfoChangesIcon() {
        return this.documentInfoChangesIcon;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDocumentInfoSizeIcon() {
        return this.documentInfoSizeIcon;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDocumentInfoFabEditIcon() {
        return this.documentInfoFabEditIcon;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getDocumentInfoFabDoneIcon() {
        return this.documentInfoFabDoneIcon;
    }

    public final DocumentInfoIconScheme copy(int documentInfoContentIcon, int documentInfoChangesIcon, int documentInfoSizeIcon, int documentInfoFabEditIcon, int documentInfoFabDoneIcon) {
        return new DocumentInfoIconScheme(documentInfoContentIcon, documentInfoChangesIcon, documentInfoSizeIcon, documentInfoFabEditIcon, documentInfoFabDoneIcon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentInfoIconScheme)) {
            return false;
        }
        DocumentInfoIconScheme documentInfoIconScheme = (DocumentInfoIconScheme) other;
        return this.documentInfoContentIcon == documentInfoIconScheme.documentInfoContentIcon && this.documentInfoChangesIcon == documentInfoIconScheme.documentInfoChangesIcon && this.documentInfoSizeIcon == documentInfoIconScheme.documentInfoSizeIcon && this.documentInfoFabEditIcon == documentInfoIconScheme.documentInfoFabEditIcon && this.documentInfoFabDoneIcon == documentInfoIconScheme.documentInfoFabDoneIcon;
    }

    public final int getDocumentInfoChangesIcon() {
        return this.documentInfoChangesIcon;
    }

    public final int getDocumentInfoContentIcon() {
        return this.documentInfoContentIcon;
    }

    public final int getDocumentInfoFabDoneIcon() {
        return this.documentInfoFabDoneIcon;
    }

    public final int getDocumentInfoFabEditIcon() {
        return this.documentInfoFabEditIcon;
    }

    public final int getDocumentInfoSizeIcon() {
        return this.documentInfoSizeIcon;
    }

    public int hashCode() {
        return Integer.hashCode(this.documentInfoFabDoneIcon) + nd.a(this.documentInfoFabEditIcon, nd.a(this.documentInfoSizeIcon, nd.a(this.documentInfoChangesIcon, Integer.hashCode(this.documentInfoContentIcon) * 31, 31), 31), 31);
    }

    public String toString() {
        return "DocumentInfoIconScheme(documentInfoContentIcon=" + this.documentInfoContentIcon + ", documentInfoChangesIcon=" + this.documentInfoChangesIcon + ", documentInfoSizeIcon=" + this.documentInfoSizeIcon + ", documentInfoFabEditIcon=" + this.documentInfoFabEditIcon + ", documentInfoFabDoneIcon=" + this.documentInfoFabDoneIcon + ")";
    }
}
