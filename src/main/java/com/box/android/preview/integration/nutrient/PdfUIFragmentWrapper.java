package com.box.android.preview.integration.nutrient;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import com.pspdfkit.R;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.ui.PdfUiFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfUIFragmentWrapper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0002R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/preview/integration/nutrient/PdfUIFragmentWrapper;", "Lcom/pspdfkit/ui/PdfUiFragment;", "<init>", "()V", "onDocumentLoaded", "Lkotlin/Function1;", "", "getOnDocumentLoaded", "()Lkotlin/jvm/functions/Function1;", "setOnDocumentLoaded", "(Lkotlin/jvm/functions/Function1;)V", "onPasswordViewVisible", "Lkotlin/Function0;", "getOnPasswordViewVisible", "()Lkotlin/jvm/functions/Function0;", "setOnPasswordViewVisible", "(Lkotlin/jvm/functions/Function0;)V", "layoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "document", "Lcom/pspdfkit/document/PdfDocument;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "removeLayoutListener", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PdfUIFragmentWrapper extends PdfUiFragment {
    public static final int $stable = 8;
    private Function0<Unit> onPasswordViewVisible;
    private Function1<? super PdfUIFragmentWrapper, Unit> onDocumentLoaded = new Function1() { // from class: com.box.android.preview.integration.nutrient.PdfUIFragmentWrapper$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return PdfUIFragmentWrapper.onDocumentLoaded$lambda$0((PdfUIFragmentWrapper) obj);
        }
    };
    private final ViewTreeObserver.OnGlobalLayoutListener layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.box.android.preview.integration.nutrient.PdfUIFragmentWrapper$$ExternalSyntheticLambda1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            PdfUIFragmentWrapper.layoutListener$lambda$0(this.f$0);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDocumentLoaded$lambda$0(PdfUIFragmentWrapper it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<PdfUIFragmentWrapper, Unit> getOnDocumentLoaded() {
        return this.onDocumentLoaded;
    }

    public final void setOnDocumentLoaded(Function1<? super PdfUIFragmentWrapper, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onDocumentLoaded = function1;
    }

    public final Function0<Unit> getOnPasswordViewVisible() {
        return this.onPasswordViewVisible;
    }

    public final void setOnPasswordViewVisible(Function0<Unit> function0) {
        this.onPasswordViewVisible = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutListener$lambda$0(PdfUIFragmentWrapper pdfUIFragmentWrapper) {
        View view;
        if (pdfUIFragmentWrapper.onPasswordViewVisible == null || (view = pdfUIFragmentWrapper.getView()) == null || view.findViewById(R.id.pspdf__fragment_password_view) == null) {
            return;
        }
        pdfUIFragmentWrapper.removeLayoutListener();
        Function0<Unit> function0 = pdfUIFragmentWrapper.onPasswordViewVisible;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoaded(PdfDocument document) {
        Intrinsics.checkNotNullParameter(document, "document");
        super.onDocumentLoaded(document);
        removeLayoutListener();
        this.onDocumentLoaded.invoke(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.getViewTreeObserver().addOnGlobalLayoutListener(this.layoutListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        removeLayoutListener();
        super.onDestroyView();
    }

    private final void removeLayoutListener() {
        ViewTreeObserver viewTreeObserver;
        View view = getView();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this.layoutListener);
    }
}
