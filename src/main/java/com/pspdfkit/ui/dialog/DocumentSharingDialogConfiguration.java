package com.pspdfkit.ui.dialog;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.R;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.sharing.ShareAction;
import com.pspdfkit.internal.mv;
import com.pspdfkit.internal.nd;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.ww;
import com.pspdfkit.internal.z40;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001)BC\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u0003J\u0014\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0083\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0006HÖ\u0081\u0004J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015¨\u0006*"}, d2 = {"Lcom/pspdfkit/ui/dialog/DocumentSharingDialogConfiguration;", "Landroid/os/Parcelable;", "currentPage", "", "documentPages", "dialogTitle", "", "positiveButtonText", "initialDocumentName", "isInitialPagesSpinnerAllPages", "", "isSavingFlow", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getCurrentPage", "()I", "getDocumentPages", "getDialogTitle", "()Ljava/lang/String;", "getPositiveButtonText", "getInitialDocumentName", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Builder", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class DocumentSharingDialogConfiguration implements Parcelable {
    private final int currentPage;
    private final String dialogTitle;
    private final int documentPages;
    private final String initialDocumentName;
    private final boolean isInitialPagesSpinnerAllPages;
    private final boolean isSavingFlow;
    private final String positiveButtonText;
    public static final Parcelable.Creator<DocumentSharingDialogConfiguration> CREATOR = new Creator();
    public static final int $stable = 8;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentSharingDialogConfiguration> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentSharingDialogConfiguration createFromParcel(Parcel parcel) {
            parcel.getClass();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            boolean z = true;
            if (parcel.readInt() == 0) {
                z = false;
            }
            return new DocumentSharingDialogConfiguration(i, i2, string, string2, string3, z, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentSharingDialogConfiguration[] newArray(int i) {
            return new DocumentSharingDialogConfiguration[i];
        }
    }

    public DocumentSharingDialogConfiguration(int i, int i2, String str, String str2, String str3, boolean z, boolean z2) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        this.currentPage = i;
        this.documentPages = i2;
        this.dialogTitle = str;
        this.positiveButtonText = str2;
        this.initialDocumentName = str3;
        this.isInitialPagesSpinnerAllPages = z;
        this.isSavingFlow = z2;
    }

    public static /* synthetic */ DocumentSharingDialogConfiguration copy$default(DocumentSharingDialogConfiguration documentSharingDialogConfiguration, int i, int i2, String str, String str2, String str3, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = documentSharingDialogConfiguration.currentPage;
        }
        if ((i3 & 2) != 0) {
            i2 = documentSharingDialogConfiguration.documentPages;
        }
        if ((i3 & 4) != 0) {
            str = documentSharingDialogConfiguration.dialogTitle;
        }
        if ((i3 & 8) != 0) {
            str2 = documentSharingDialogConfiguration.positiveButtonText;
        }
        if ((i3 & 16) != 0) {
            str3 = documentSharingDialogConfiguration.initialDocumentName;
        }
        if ((i3 & 32) != 0) {
            z = documentSharingDialogConfiguration.isInitialPagesSpinnerAllPages;
        }
        if ((i3 & 64) != 0) {
            z2 = documentSharingDialogConfiguration.isSavingFlow;
        }
        boolean z3 = z;
        boolean z4 = z2;
        String str4 = str3;
        String str5 = str;
        return documentSharingDialogConfiguration.copy(i, i2, str5, str2, str4, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCurrentPage() {
        return this.currentPage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDocumentPages() {
        return this.documentPages;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDialogTitle() {
        return this.dialogTitle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPositiveButtonText() {
        return this.positiveButtonText;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getInitialDocumentName() {
        return this.initialDocumentName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsInitialPagesSpinnerAllPages() {
        return this.isInitialPagesSpinnerAllPages;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsSavingFlow() {
        return this.isSavingFlow;
    }

    public final DocumentSharingDialogConfiguration copy(int currentPage, int documentPages, String dialogTitle, String positiveButtonText, String initialDocumentName, boolean isInitialPagesSpinnerAllPages, boolean isSavingFlow) {
        dialogTitle.getClass();
        positiveButtonText.getClass();
        initialDocumentName.getClass();
        return new DocumentSharingDialogConfiguration(currentPage, documentPages, dialogTitle, positiveButtonText, initialDocumentName, isInitialPagesSpinnerAllPages, isSavingFlow);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentSharingDialogConfiguration)) {
            return false;
        }
        DocumentSharingDialogConfiguration documentSharingDialogConfiguration = (DocumentSharingDialogConfiguration) other;
        return this.currentPage == documentSharingDialogConfiguration.currentPage && this.documentPages == documentSharingDialogConfiguration.documentPages && Intrinsics.areEqual(this.dialogTitle, documentSharingDialogConfiguration.dialogTitle) && Intrinsics.areEqual(this.positiveButtonText, documentSharingDialogConfiguration.positiveButtonText) && Intrinsics.areEqual(this.initialDocumentName, documentSharingDialogConfiguration.initialDocumentName) && this.isInitialPagesSpinnerAllPages == documentSharingDialogConfiguration.isInitialPagesSpinnerAllPages && this.isSavingFlow == documentSharingDialogConfiguration.isSavingFlow;
    }

    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final String getDialogTitle() {
        return this.dialogTitle;
    }

    public final int getDocumentPages() {
        return this.documentPages;
    }

    public final String getInitialDocumentName() {
        return this.initialDocumentName;
    }

    public final String getPositiveButtonText() {
        return this.positiveButtonText;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isSavingFlow) + mv.a(this.isInitialPagesSpinnerAllPages, z40.a(this.initialDocumentName, z40.a(this.positiveButtonText, z40.a(this.dialogTitle, nd.a(this.documentPages, Integer.hashCode(this.currentPage) * 31, 31), 31), 31), 31), 31);
    }

    public final boolean isInitialPagesSpinnerAllPages() {
        return this.isInitialPagesSpinnerAllPages;
    }

    public final boolean isSavingFlow() {
        return this.isSavingFlow;
    }

    public String toString() {
        return "DocumentSharingDialogConfiguration(currentPage=" + this.currentPage + ", documentPages=" + this.documentPages + ", dialogTitle=" + this.dialogTitle + ", positiveButtonText=" + this.positiveButtonText + ", initialDocumentName=" + this.initialDocumentName + ", isInitialPagesSpinnerAllPages=" + this.isInitialPagesSpinnerAllPages + ", isSavingFlow=" + this.isSavingFlow + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        dest.getClass();
        dest.writeInt(this.currentPage);
        dest.writeInt(this.documentPages);
        dest.writeString(this.dialogTitle);
        dest.writeString(this.positiveButtonText);
        dest.writeString(this.initialDocumentName);
        dest.writeInt(this.isInitialPagesSpinnerAllPages ? 1 : 0);
        dest.writeInt(this.isSavingFlow ? 1 : 0);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\rJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tJ\u0010\u0010\u000e\u001a\u00020\u00002\b\b\u0001\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0014J\u0016\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u0012\u0010\b\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/pspdfkit/ui/dialog/DocumentSharingDialogConfiguration$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "document", "Lcom/pspdfkit/document/PdfDocument;", "currentPage", "", "(Landroid/content/Context;Lcom/pspdfkit/document/PdfDocument;I)V", "shareAction", "Lcom/pspdfkit/document/sharing/ShareAction;", "(Landroid/content/Context;Lcom/pspdfkit/document/sharing/ShareAction;Lcom/pspdfkit/document/PdfDocument;I)V", "documentPages", "dialogTitle", "", "positiveButtonText", "initialDocumentName", "initialPagesSpinnerAllPages", "", "savingFlow", "setInitialPagesSpinnerAllPages", "allPages", "setSavingFlow", "build", "Lcom/pspdfkit/ui/dialog/DocumentSharingDialogConfiguration;", "getShareDialogTitle", "getShareButtonText", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Builder {
        public static final int $stable = 8;
        private int currentPage;
        private String dialogTitle;
        private int documentPages;
        private String initialDocumentName;
        private boolean initialPagesSpinnerAllPages;
        private String positiveButtonText;
        private boolean savingFlow;

        public Builder(Context context) {
            context.getClass();
            String strA = no.a(context, R.string.pspdf__share, null);
            strA.getClass();
            this.dialogTitle = strA;
            String strA2 = no.a(context, R.string.pspdf__share, null);
            strA2.getClass();
            this.positiveButtonText = strA2;
            this.currentPage = 0;
            this.documentPages = 0;
            this.initialDocumentName = "";
            this.initialPagesSpinnerAllPages = true;
            this.savingFlow = false;
        }

        private final String getShareButtonText(Context context, ShareAction shareAction) {
            if (this.savingFlow) {
                String strA = no.a(context, R.string.pspdf__save, null);
                strA.getClass();
                return strA;
            }
            if (shareAction == ShareAction.VIEW) {
                String strA2 = no.a(context, R.string.pspdf__open, null);
                strA2.getClass();
                return strA2;
            }
            String strA3 = no.a(context, R.string.pspdf__share, null);
            strA3.getClass();
            return strA3;
        }

        private final String getShareDialogTitle(Context context, ShareAction shareAction) {
            if (!this.savingFlow) {
                return no.a(context, shareAction == ShareAction.VIEW ? R.string.pspdf__open : R.string.pspdf__share, null).concat("…");
            }
            String strA = no.a(context, R.string.pspdf__save_as, null);
            strA.getClass();
            return strA;
        }

        public final DocumentSharingDialogConfiguration build() {
            return new DocumentSharingDialogConfiguration(this.currentPage, this.documentPages, this.dialogTitle, this.positiveButtonText, this.initialDocumentName, this.initialPagesSpinnerAllPages, this.savingFlow);
        }

        public final Builder currentPage(int currentPage) {
            this.currentPage = currentPage;
            return this;
        }

        public final Builder dialogTitle(String dialogTitle) {
            dialogTitle.getClass();
            this.dialogTitle = dialogTitle;
            return this;
        }

        public final Builder documentPages(int documentPages) {
            this.documentPages = documentPages;
            return this;
        }

        public final Builder initialDocumentName(String initialDocumentName) {
            initialDocumentName.getClass();
            this.initialDocumentName = initialDocumentName;
            return this;
        }

        public final Builder positiveButtonText(String positiveButtonText) {
            positiveButtonText.getClass();
            this.positiveButtonText = positiveButtonText;
            return this;
        }

        public final Builder setInitialPagesSpinnerAllPages(boolean allPages) {
            this.initialPagesSpinnerAllPages = allPages;
            return this;
        }

        public final Builder setSavingFlow(boolean savingFlow, Context context) {
            context.getClass();
            this.savingFlow = savingFlow;
            String strA = no.a(context, R.string.pspdf__save_as, null);
            strA.getClass();
            this.dialogTitle = strA;
            String strA2 = no.a(context, R.string.pspdf__save, null);
            strA2.getClass();
            this.positiveButtonText = strA2;
            return this;
        }

        public Builder(Context context, PdfDocument pdfDocument, int i) {
            context.getClass();
            pdfDocument.getClass();
            String strA = no.a(context, R.string.pspdf__share, null);
            strA.getClass();
            this.dialogTitle = strA;
            String strA2 = no.a(context, R.string.pspdf__share, null);
            strA2.getClass();
            this.positiveButtonText = strA2;
            this.currentPage = i;
            this.documentPages = pdfDocument.getPageCount();
            this.initialDocumentName = ww.a(context, pdfDocument);
            this.initialPagesSpinnerAllPages = true;
            this.savingFlow = false;
        }

        public Builder(Context context, ShareAction shareAction, PdfDocument pdfDocument, int i) {
            context.getClass();
            shareAction.getClass();
            pdfDocument.getClass();
            this.dialogTitle = getShareDialogTitle(context, shareAction);
            this.positiveButtonText = getShareButtonText(context, shareAction);
            this.currentPage = i;
            this.documentPages = pdfDocument.getPageCount();
            this.initialDocumentName = ww.a(context, pdfDocument);
            this.initialPagesSpinnerAllPages = true;
            this.savingFlow = false;
        }
    }
}
