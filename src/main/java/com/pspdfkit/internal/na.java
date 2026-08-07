package com.pspdfkit.internal;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.listeners.InternalDocumentListener;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfFragment;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class na implements InternalDocumentListener {
    public final PdfFragment a;
    public final PSPDFKitViews b;
    public final PdfConfiguration c;
    public int d;
    public ma e;

    public na(PdfFragment pdfFragment, PSPDFKitViews pSPDFKitViews, PdfConfiguration pdfConfiguration) {
        DocumentView documentViewA;
        pSPDFKitViews.getClass();
        pdfConfiguration.getClass();
        this.a = pdfFragment;
        this.b = pSPDFKitViews;
        this.c = pdfConfiguration;
        this.d = -1;
        if (pdfConfiguration.getScrollMode() == PageScrollMode.PER_PAGE) {
            a();
            if (this.e == null && (documentViewA = pdfFragment.getInternal().getViewCoordinator().a(false)) != null) {
                ma maVar = new ma(this);
                documentViewA.getContentEditingManager().addOnContentEditingModeChangeListener(maVar);
                this.e = maVar;
                if (documentViewA.getInteractionMode() == DocumentView.d.CONTENT_EDITING) {
                    ab contentEditingHandler = documentViewA.getContentEditingHandler();
                    contentEditingHandler.getClass();
                    maVar.onEnterContentEditingMode(contentEditingHandler);
                }
            }
            pdfFragment.addDocumentListener(this);
        }
    }

    public static final int b(na naVar) {
        PdfFragment pdfFragment = naVar.a;
        return pdfFragment.getSiblingPageIndex(pdfFragment.getPageIndex());
    }

    public final void a() {
        a(this.b.getMainPageCreateTextBlockButton(), new Function0() { // from class: com.pspdfkit.internal.na$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(na.a(this.f$0));
            }
        });
        a(this.b.getSecondPageCreateTextBlockButton(), new Function0() { // from class: com.pspdfkit.internal.na$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(na.b(this.f$0));
            }
        });
        ViewGroup createTextBlockButtonsContainer = this.b.getCreateTextBlockButtonsContainer();
        if (createTextBlockButtonsContainer != null) {
            ViewCompat.setOnApplyWindowInsetsListener(createTextBlockButtonsContainer, new OnApplyWindowInsetsListener() { // from class: com.pspdfkit.internal.na$$ExternalSyntheticLambda3
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    return na.a(view, windowInsetsCompat);
                }
            });
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentLoaded(PdfDocument pdfDocument) {
        DocumentView documentViewA;
        pdfDocument.getClass();
        this.d = this.a.getPageIndex();
        if (this.e == null && (documentViewA = this.a.getInternal().getViewCoordinator().a(false)) != null) {
            ma maVar = new ma(this);
            documentViewA.getContentEditingManager().addOnContentEditingModeChangeListener(maVar);
            this.e = maVar;
            if (documentViewA.getInteractionMode() == DocumentView.d.CONTENT_EDITING) {
                ab contentEditingHandler = documentViewA.getContentEditingHandler();
                contentEditingHandler.getClass();
                maVar.onEnterContentEditingMode(contentEditingHandler);
            }
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onPageChanged(PdfDocument pdfDocument, int i) {
        pdfDocument.getClass();
        this.d = i;
        a(i);
    }

    public final void a(int i) {
        boolean z = this.c.getScrollMode() == PageScrollMode.PER_PAGE && this.a.getSiblingPageIndex(i) >= 0;
        if (this.b.getSecondPageCreateTextBlockButton() == null) {
            return;
        }
        FloatingActionButton secondPageCreateTextBlockButton = this.b.getSecondPageCreateTextBlockButton();
        Object parent = secondPageCreateTextBlockButton != null ? secondPageCreateTextBlockButton.getParent() : null;
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
        FloatingActionButton mainPageCreateTextBlockButton = this.b.getMainPageCreateTextBlockButton();
        if (mainPageCreateTextBlockButton != null) {
            ViewGroup.LayoutParams layoutParams = mainPageCreateTextBlockButton.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.gravity = z ? GravityCompat.START : GravityCompat.END;
                mainPageCreateTextBlockButton.setLayoutParams(layoutParams2);
            }
        }
    }

    public static final int a(na naVar) {
        return naVar.a.getPageIndex();
    }

    public static final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        view.getClass();
        windowInsetsCompat.getClass();
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
        insets.getClass();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.rightMargin = insets.right;
            marginLayoutParams.leftMargin = insets.left;
            view.setLayoutParams(marginLayoutParams);
            return windowInsetsCompat;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void a(FloatingActionButton floatingActionButton, final Function0<Integer> function0) {
        if (floatingActionButton != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.na$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    na.a(function0, this, view);
                }
            });
        }
    }

    public static final void a(Function0 function0, na naVar, View view) {
        ab contentEditingHandler;
        ta taVar;
        int iIntValue = ((Number) function0.invoke()).intValue();
        if (iIntValue >= 0) {
            int i = 0;
            DocumentView documentViewA = naVar.a.getInternal().getViewCoordinator().a(false);
            if (documentViewA == null || (contentEditingHandler = documentViewA.getContentEditingHandler()) == null) {
                return;
            }
            ArrayList<ta> arrayList = contentEditingHandler.i;
            int size = arrayList.size();
            do {
                if (i >= size) {
                    taVar = null;
                    break;
                } else {
                    taVar = arrayList.get(i);
                    i++;
                }
            } while (taVar.c != iIntValue);
            ta taVar2 = taVar;
            if (taVar2 != null) {
                taVar2.a((PointF) null);
            }
        }
    }

    public final void a(FloatingActionButton floatingActionButton, int i) {
        ab contentEditingHandler;
        lm lmVar;
        ta taVar;
        m40 state;
        if (floatingActionButton == null) {
            return;
        }
        int i2 = 4;
        if (i < 0) {
            floatingActionButton.setVisibility(4);
            return;
        }
        DocumentView documentViewA = this.a.getInternal().getViewCoordinator().a(false);
        if (documentViewA != null && (contentEditingHandler = documentViewA.getContentEditingHandler()) != null) {
            ArrayList<ta> arrayList = contentEditingHandler.i;
            int size = arrayList.size();
            int i3 = 0;
            do {
                lmVar = null;
                if (i3 >= size) {
                    taVar = null;
                    break;
                } else {
                    taVar = arrayList.get(i3);
                    i3++;
                }
            } while (taVar.c != i);
            ta taVar2 = taVar;
            if (taVar2 != null && taVar2.D) {
                au auVar = taVar2.n;
                if (auVar != null && (state = auVar.getState()) != null) {
                    lmVar = state.a;
                }
                if (lmVar != null) {
                    i2 = 0;
                }
            }
        }
        floatingActionButton.setVisibility(i2);
    }
}
