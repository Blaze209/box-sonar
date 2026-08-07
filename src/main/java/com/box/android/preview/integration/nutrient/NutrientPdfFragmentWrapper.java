package com.box.android.preview.integration.nutrient;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.base.presentation.views.TouchInterceptorViewGroup;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.ui.PdfFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NutrientPdfFragmentWrapper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/box/android/preview/integration/nutrient/NutrientPdfFragmentWrapper;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "isInitialized", "", "()Z", "setInitialized", "(Z)V", "documentListener", "Lcom/pspdfkit/listeners/DocumentListener;", "pdfUiFragment", "Lcom/box/android/preview/integration/nutrient/PdfUIFragmentWrapper;", "getPdfUiFragment", "()Lcom/box/android/preview/integration/nutrient/PdfUIFragmentWrapper;", "setPdfUiFragment", "(Lcom/box/android/preview/integration/nutrient/PdfUIFragmentWrapper;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "addDocumentListener", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NutrientPdfFragmentWrapper extends Fragment {
    public static final String BUILDER_ARG = "NutrientPdfFragmentWrapper:Builder";
    private static final String FRAGMENT_TAG = "NUTRIENT_FRAGMENT_TAG";
    public static final String URI_ARG = "NutrientPdfFragmentWrapper:Uri";
    private DocumentListener documentListener;
    private boolean isInitialized;
    public PdfUIFragmentWrapper pdfUiFragment;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: isInitialized, reason: from getter */
    public final boolean getIsInitialized() {
        return this.isInitialized;
    }

    public final void setInitialized(boolean z) {
        this.isInitialized = z;
    }

    public final PdfUIFragmentWrapper getPdfUiFragment() {
        PdfUIFragmentWrapper pdfUIFragmentWrapper = this.pdfUiFragment;
        if (pdfUIFragmentWrapper != null) {
            return pdfUIFragmentWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pdfUiFragment");
        return null;
    }

    public final void setPdfUiFragment(PdfUIFragmentWrapper pdfUIFragmentWrapper) {
        Intrinsics.checkNotNullParameter(pdfUIFragmentWrapper, "<set-?>");
        this.pdfUiFragment = pdfUIFragmentWrapper;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        NutrientPdfFragmentBuilder nutrientPdfFragmentBuilder;
        Uri uri;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        TouchInterceptorViewGroup touchInterceptorViewGroup = new TouchInterceptorViewGroup(contextRequireContext);
        touchInterceptorViewGroup.addFragmentContainerView(1);
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        if (Build.VERSION.SDK_INT >= 33) {
            nutrientPdfFragmentBuilder = (Parcelable) bundleRequireArguments.getParcelable(BUILDER_ARG, NutrientPdfFragmentBuilder.class);
        } else {
            Parcelable parcelable = bundleRequireArguments.getParcelable(BUILDER_ARG);
            if (!(parcelable instanceof NutrientPdfFragmentBuilder)) {
                parcelable = null;
            }
            nutrientPdfFragmentBuilder = (NutrientPdfFragmentBuilder) parcelable;
        }
        Intrinsics.checkNotNull(nutrientPdfFragmentBuilder);
        NutrientPdfFragmentBuilder nutrientPdfFragmentBuilder2 = (NutrientPdfFragmentBuilder) nutrientPdfFragmentBuilder;
        if (Build.VERSION.SDK_INT >= 33) {
            uri = (Parcelable) bundleRequireArguments.getParcelable(URI_ARG, Uri.class);
        } else {
            Parcelable parcelable2 = bundleRequireArguments.getParcelable(URI_ARG);
            if (!(parcelable2 instanceof Uri)) {
                parcelable2 = null;
            }
            uri = (Uri) parcelable2;
        }
        Intrinsics.checkNotNull(uri);
        Uri uri2 = (Uri) uri;
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        PdfUIFragmentWrapper pdfUIFragmentWrapperBuild = fragmentFindFragmentByTag instanceof PdfUIFragmentWrapper ? (PdfUIFragmentWrapper) fragmentFindFragmentByTag : null;
        if (pdfUIFragmentWrapperBuild == null) {
            Context contextRequireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
            pdfUIFragmentWrapperBuild = nutrientPdfFragmentBuilder2.build(contextRequireContext2, uri2);
        }
        setPdfUiFragment(pdfUIFragmentWrapperBuild);
        getChildFragmentManager().beginTransaction().replace(1, getPdfUiFragment(), FRAGMENT_TAG).commit();
        return touchInterceptorViewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (this.documentListener != null) {
            PdfFragment pdfFragmentRequirePdfFragment = getPdfUiFragment().requirePdfFragment();
            DocumentListener documentListener = this.documentListener;
            if (documentListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("documentListener");
                documentListener = null;
            }
            pdfFragmentRequirePdfFragment.removeDocumentListener(documentListener);
        }
    }

    public final void addDocumentListener(DocumentListener documentListener) {
        Intrinsics.checkNotNullParameter(documentListener, "documentListener");
        this.documentListener = documentListener;
        getPdfUiFragment().requirePdfFragment().addDocumentListener(documentListener);
    }
}
