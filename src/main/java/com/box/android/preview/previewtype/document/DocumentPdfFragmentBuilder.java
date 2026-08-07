package com.box.android.preview.previewtype.document;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.box.android.preview.integration.nutrient.NutrientPdfFragmentBuilder;
import com.box.android.preview.integration.nutrient.PdfUIFragmentWrapper;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.ui.PdfUiFragment;
import com.pspdfkit.ui.PdfUiFragmentBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentPdfFragmentBuilder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPdfFragmentBuilder;", "Lcom/box/android/preview/integration/nutrient/NutrientPdfFragmentBuilder;", "configuration", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "<init>", "(Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;)V", "build", "Lcom/box/android/preview/integration/nutrient/PdfUIFragmentWrapper;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentPdfFragmentBuilder implements NutrientPdfFragmentBuilder {
    public static final int $stable = PdfActivityConfiguration.$stable;
    public static final Parcelable.Creator<DocumentPdfFragmentBuilder> CREATOR = new Creator();
    private final PdfActivityConfiguration configuration;

    /* JADX INFO: compiled from: DocumentPdfFragmentBuilder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentPdfFragmentBuilder> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentPdfFragmentBuilder createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DocumentPdfFragmentBuilder((PdfActivityConfiguration) parcel.readParcelable(DocumentPdfFragmentBuilder.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentPdfFragmentBuilder[] newArray(int i) {
            return new DocumentPdfFragmentBuilder[i];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeParcelable(this.configuration, flags);
    }

    public DocumentPdfFragmentBuilder(PdfActivityConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.configuration = configuration;
    }

    @Override // com.box.android.preview.integration.nutrient.NutrientPdfFragmentBuilder
    public PdfUIFragmentWrapper build(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        PdfUiFragment pdfUiFragmentBuild = PdfUiFragmentBuilder.fromUri(context, uri).fragmentClass(PdfUIFragmentWrapper.class).configuration(this.configuration).build();
        Intrinsics.checkNotNull(pdfUiFragmentBuild, "null cannot be cast to non-null type com.box.android.preview.integration.nutrient.PdfUIFragmentWrapper");
        return (PdfUIFragmentWrapper) pdfUiFragmentBuild;
    }
}
