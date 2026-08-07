package com.pspdfkit.ui.search;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.pspdfkit.R;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.search.SearchConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.i60;
import com.pspdfkit.internal.pn;
import com.pspdfkit.internal.tv;
import com.pspdfkit.internal.uw;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.utils.PdfLog;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: loaded from: classes3.dex */
public class PdfSearchViewLazy extends FrameLayout implements DocumentListener, PdfSearchView {
    private static final String LOG_TAG = "Nutri.PdfSearchViewLazy";
    private WindowInsetsCompat lastInsets;
    private OnViewReadyListener listener;
    private final pn<PdfSearchView> searchView;

    public interface OnViewReadyListener {
        void onViewReady(PdfSearchViewLazy pdfSearchViewLazy, PdfSearchView pdfSearchView);
    }

    public PdfSearchViewLazy(Context context) {
        super(context);
        this.searchView = new pn<>();
        init();
    }

    private void init() {
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda5
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return this.f$0.lambda$init$0(view, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat lambda$init$0(View view, WindowInsetsCompat windowInsetsCompat) {
        this.lastInsets = windowInsetsCompat;
        return windowInsetsCompat;
    }

    static /* synthetic */ void lambda$onPageChanged$7(PdfDocument pdfDocument, int i, PdfSearchView pdfSearchView) {
        if (pdfSearchView instanceof DocumentListener) {
            ((DocumentListener) pdfSearchView).onPageChanged(pdfDocument, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public /* synthetic */ PdfSearchView lambda$prepareForDisplay$8() throws Exception {
        pn<PdfSearchView> pnVar = this.searchView;
        if (pnVar != null && pnVar.b()) {
            return this.searchView.a();
        }
        PdfSearchView pdfSearchViewCreateSearchView = createSearchView();
        uw.b(pdfSearchViewCreateSearchView instanceof View, "Created search view must be a View.");
        addView((View) pdfSearchViewCreateSearchView, -1, -1);
        if ((pdfSearchViewCreateSearchView instanceof PdfSearchViewModular) && this.lastInsets != null) {
            ((PdfSearchViewModular) pdfSearchViewCreateSearchView).fitSystemWindows(new Rect(this.lastInsets.getSystemWindowInsetLeft(), this.lastInsets.getSystemWindowInsetTop(), this.lastInsets.getSystemWindowInsetRight(), this.lastInsets.getSystemWindowInsetBottom()));
        }
        setId(-1);
        this.searchView.a(pdfSearchViewCreateSearchView);
        OnViewReadyListener onViewReadyListener = this.listener;
        if (onViewReadyListener != null) {
            onViewReadyListener.onViewReady(this, pdfSearchViewCreateSearchView);
            this.listener = null;
        }
        return pdfSearchViewCreateSearchView;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void addOnVisibilityChangedListener(final OnVisibilityChangedListener onVisibilityChangedListener) {
        pn<PdfSearchView> pnVar = this.searchView;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda6
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfSearchView) obj).addOnVisibilityChangedListener(onVisibilityChangedListener);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void clearDocument() {
        pn<PdfSearchView> pnVar = this.searchView;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda3
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfSearchView) obj).clearDocument();
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView
    public void clearSearch() {
        pn<PdfSearchView> pnVar = this.searchView;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda11
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfSearchView) obj).clearSearch();
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public PdfSearchView createSearchView() {
        PdfSearchViewModular pdfSearchViewModular = new PdfSearchViewModular(getContext());
        pdfSearchViewModular.setId(R.id.pspdf__activity_search_view_modular);
        return pdfSearchViewModular;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public PSPDFKitViews.Type getPSPDFViewType() {
        return PSPDFKitViews.Type.VIEW_SEARCH;
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView
    public SearchConfiguration getSearchConfiguration() {
        if (this.searchView.b()) {
            return this.searchView.a().getSearchConfiguration();
        }
        throw new IllegalStateException("Search view is not initialized yet.");
    }

    public PdfSearchView getSearchView() {
        prepareForDisplay();
        return this.searchView.a();
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void hide() {
        pn<PdfSearchView> pnVar = this.searchView;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfSearchView) obj).hide();
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public boolean isDisplayed() {
        return this.searchView.b() && this.searchView.a().isDisplayed();
    }

    public boolean isIdle() {
        pn<PdfSearchView> pnVar = this.searchView;
        if (pnVar.c instanceof AbstractPdfSearchView) {
            return ((AbstractPdfSearchView) pnVar.a()).isIdle();
        }
        return true;
    }

    @Override // android.view.View, com.pspdfkit.ui.search.PdfSearchView
    public boolean isShown() {
        return this.searchView.b() && this.searchView.a().isShown();
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onPageChanged(final PdfDocument pdfDocument, final int i) {
        pn<PdfSearchView> pnVar = this.searchView;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda9
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                PdfSearchViewLazy.lambda$onPageChanged$7(pdfDocument, i, (PdfSearchView) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public synchronized PdfSearchView prepareForDisplay() {
        Object objRunBlocking$default;
        pn<PdfSearchView> pnVar = this.searchView;
        if (pnVar != null && pnVar.b()) {
            return this.searchView.a();
        }
        Callable callable = new Callable() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda10
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$prepareForDisplay$8();
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            objRunBlocking$default = callable.call();
            objRunBlocking$default.getClass();
        } else {
            objRunBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new i60(callable, null), 1, null);
            objRunBlocking$default.getClass();
        }
        return (PdfSearchView) objRunBlocking$default;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void removeOnVisibilityChangedListener(final OnVisibilityChangedListener onVisibilityChangedListener) {
        pn<PdfSearchView> pnVar = this.searchView;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda7
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfSearchView) obj).removeOnVisibilityChangedListener(onVisibilityChangedListener);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void setDocument(final PdfDocument pdfDocument, final PdfConfiguration pdfConfiguration) {
        pn<PdfSearchView> pnVar = this.searchView;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda2
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfSearchView) obj).setDocument(pdfDocument, pdfConfiguration);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView
    public void setInputFieldText(final String str, final boolean z) {
        pn<PdfSearchView> pnVar = this.searchView;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda8
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfSearchView) obj).setInputFieldText(str, z);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setOnViewReadyListener(OnViewReadyListener onViewReadyListener) {
        this.listener = onViewReadyListener;
        if (onViewReadyListener == null || !this.searchView.b()) {
            return;
        }
        onViewReadyListener.onViewReady(this, this.searchView.a());
        this.listener = null;
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView
    public void setSearchConfiguration(final SearchConfiguration searchConfiguration) {
        pn<PdfSearchView> pnVar = this.searchView;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda12
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfSearchView) obj).setSearchConfiguration(searchConfiguration);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    @Override // com.pspdfkit.ui.search.PdfSearchView
    public void setSearchViewListener(final PdfSearchView.Listener listener) {
        pn<PdfSearchView> pnVar = this.searchView;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfSearchView) obj).setSearchViewListener(listener);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            prepareForDisplay();
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void show() {
        this.searchView.a(new pn.a() { // from class: com.pspdfkit.ui.search.PdfSearchViewLazy$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfSearchView) obj).show();
            }
        }, true);
        prepareForDisplay();
        try {
            setVisibility(0);
        } catch (Throwable unused) {
            PdfLog.i(LOG_TAG, "Failed to set PdfSearchView visibility. Ignoring exception as the lazy view might not be attached yet.", new Object[0]);
        }
    }

    public PdfSearchViewLazy(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.searchView = new pn<>();
        init();
    }

    public PdfSearchViewLazy(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.searchView = new pn<>();
        init();
    }

    public PdfSearchViewLazy(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.searchView = new pn<>();
        init();
    }
}
