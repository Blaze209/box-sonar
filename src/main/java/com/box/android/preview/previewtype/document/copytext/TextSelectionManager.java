package com.box.android.preview.previewtype.document.copytext;

import com.pspdfkit.BuildConfig;
import com.pspdfkit.ui.PdfUiFragment;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextSelectionManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/box/android/preview/previewtype/document/copytext/TextSelectionManager;", "", "<init>", "()V", BuildConfig.FLAVOR, "Lcom/pspdfkit/ui/PdfUiFragment;", "getFragment", "()Lcom/pspdfkit/ui/PdfUiFragment;", "setFragment", "(Lcom/pspdfkit/ui/PdfUiFragment;)V", "exitTextSelection", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextSelectionManager {
    public static final int $stable = 8;
    public PdfUiFragment fragment;

    @Inject
    public TextSelectionManager() {
    }

    public final PdfUiFragment getFragment() {
        PdfUiFragment pdfUiFragment = this.fragment;
        if (pdfUiFragment != null) {
            return pdfUiFragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException(BuildConfig.FLAVOR);
        return null;
    }

    public final void setFragment(PdfUiFragment pdfUiFragment) {
        Intrinsics.checkNotNullParameter(pdfUiFragment, "<set-?>");
        this.fragment = pdfUiFragment;
    }

    public final void exitTextSelection() {
        getFragment().requirePdfFragment().exitCurrentlyActiveMode();
    }
}
