package com.box.android.preview.previewtype.document;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.ui.PdfUiFragment;
import com.pspdfkit.ui.PdfUiFragmentBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentPdfFragmentFactory.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/preview/previewtype/document/DocumentPdfFragmentFactory;", "Landroidx/fragment/app/FragmentFactory;", "context", "Landroid/content/Context;", "documentUri", "Landroid/net/Uri;", "configuration", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "<init>", "(Landroid/content/Context;Landroid/net/Uri;Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;)V", "instantiate", "Landroidx/fragment/app/Fragment;", "classLoader", "Ljava/lang/ClassLoader;", "className", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DocumentPdfFragmentFactory extends FragmentFactory {
    public static final int $stable = 8;
    private final PdfActivityConfiguration configuration;
    private final Context context;
    private final Uri documentUri;

    public DocumentPdfFragmentFactory(Context context, Uri documentUri, PdfActivityConfiguration configuration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(documentUri, "documentUri");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.context = context;
        this.documentUri = documentUri;
        this.configuration = configuration;
    }

    @Override // androidx.fragment.app.FragmentFactory
    public Fragment instantiate(ClassLoader classLoader, String className) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(className, "className");
        if (Intrinsics.areEqual(className, PdfUiFragment.class.getName())) {
            PdfUiFragment pdfUiFragmentBuild = PdfUiFragmentBuilder.fromUri(this.context, this.documentUri).configuration(this.configuration).build();
            Intrinsics.checkNotNullExpressionValue(pdfUiFragmentBuild, "build(...)");
            return pdfUiFragmentBuild;
        }
        Fragment fragmentInstantiate = super.instantiate(classLoader, className);
        Intrinsics.checkNotNullExpressionValue(fragmentInstantiate, "instantiate(...)");
        return fragmentInstantiate;
    }
}
