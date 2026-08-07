package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.z40;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014¨\u0006 "}, d2 = {"Lio/nutrient/data/models/DocumentIdentifiers;", "", "dataProvider", "Lcom/pspdfkit/document/providers/DataProvider;", "permanentId", "", "sourcePdfSha256", "changingId", "layerName", "<init>", "(Lcom/pspdfkit/document/providers/DataProvider;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDataProvider", "()Lcom/pspdfkit/document/providers/DataProvider;", "getPermanentId", "()Ljava/lang/String;", "getSourcePdfSha256", "getChangingId", "getLayerName", "isInstantDocument", "", "()Z", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DocumentIdentifiers {
    public static final int $stable = 8;
    private final String changingId;
    private final DataProvider dataProvider;
    private final String layerName;
    private final String permanentId;
    private final String sourcePdfSha256;

    public DocumentIdentifiers(DataProvider dataProvider, String str, String str2, String str3, String str4) {
        dataProvider.getClass();
        str.getClass();
        this.dataProvider = dataProvider;
        this.permanentId = str;
        this.sourcePdfSha256 = str2;
        this.changingId = str3;
        this.layerName = str4;
    }

    public static /* synthetic */ DocumentIdentifiers copy$default(DocumentIdentifiers documentIdentifiers, DataProvider dataProvider, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            dataProvider = documentIdentifiers.dataProvider;
        }
        if ((i & 2) != 0) {
            str = documentIdentifiers.permanentId;
        }
        if ((i & 4) != 0) {
            str2 = documentIdentifiers.sourcePdfSha256;
        }
        if ((i & 8) != 0) {
            str3 = documentIdentifiers.changingId;
        }
        if ((i & 16) != 0) {
            str4 = documentIdentifiers.layerName;
        }
        String str5 = str4;
        String str6 = str2;
        return documentIdentifiers.copy(dataProvider, str, str6, str3, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DataProvider getDataProvider() {
        return this.dataProvider;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPermanentId() {
        return this.permanentId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSourcePdfSha256() {
        return this.sourcePdfSha256;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getChangingId() {
        return this.changingId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLayerName() {
        return this.layerName;
    }

    public final DocumentIdentifiers copy(DataProvider dataProvider, String permanentId, String sourcePdfSha256, String changingId, String layerName) {
        dataProvider.getClass();
        permanentId.getClass();
        return new DocumentIdentifiers(dataProvider, permanentId, sourcePdfSha256, changingId, layerName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentIdentifiers)) {
            return false;
        }
        DocumentIdentifiers documentIdentifiers = (DocumentIdentifiers) other;
        return Intrinsics.areEqual(this.dataProvider, documentIdentifiers.dataProvider) && Intrinsics.areEqual(this.permanentId, documentIdentifiers.permanentId) && Intrinsics.areEqual(this.sourcePdfSha256, documentIdentifiers.sourcePdfSha256) && Intrinsics.areEqual(this.changingId, documentIdentifiers.changingId) && Intrinsics.areEqual(this.layerName, documentIdentifiers.layerName);
    }

    public final String getChangingId() {
        return this.changingId;
    }

    public final DataProvider getDataProvider() {
        return this.dataProvider;
    }

    public final String getLayerName() {
        return this.layerName;
    }

    public final String getPermanentId() {
        return this.permanentId;
    }

    public final String getSourcePdfSha256() {
        return this.sourcePdfSha256;
    }

    public int hashCode() {
        int iA = z40.a(this.permanentId, this.dataProvider.hashCode() * 31, 31);
        String str = this.sourcePdfSha256;
        int iHashCode = (iA + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.changingId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.layerName;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isInstantDocument() {
        return this.changingId == null;
    }

    public String toString() {
        return "DocumentIdentifiers(dataProvider=" + this.dataProvider + ", permanentId=" + this.permanentId + ", sourcePdfSha256=" + this.sourcePdfSha256 + ", changingId=" + this.changingId + ", layerName=" + this.layerName + ")";
    }
}
