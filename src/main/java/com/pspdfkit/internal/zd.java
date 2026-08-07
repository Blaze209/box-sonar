package com.pspdfkit.internal;

import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import com.pspdfkit.R;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.listeners.OnPreparePopupToolbarListener;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PopupToolbar;
import com.pspdfkit.ui.toolbar.popup.PopupToolbarMenuItem;
import com.pspdfkit.ui.toolbar.popup.TextSelectionPopupToolbar;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class zd {
    public final PdfFragment a;
    public final zb b;
    public final Function1<PdfFragment, TextSelectionPopupToolbar> c;
    public final Handler d;
    public final Lazy e;
    public final Lazy f;
    public a60 g;
    public PopupToolbar h;
    public OnPreparePopupToolbarListener i;
    public final Runnable j;
    public final Runnable k;

    /* JADX WARN: Multi-variable type inference failed */
    public zd(PdfFragment pdfFragment, zb zbVar, Function1<? super PdfFragment, ? extends TextSelectionPopupToolbar> function1, Handler handler) {
        pdfFragment.getClass();
        zbVar.getClass();
        function1.getClass();
        this.a = pdfFragment;
        this.b = zbVar;
        this.c = function1;
        this.d = handler;
        this.e = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.zd$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return zd.a(this.f$0);
            }
        });
        this.f = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.zd$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return zd.d(this.f$0);
            }
        });
        this.j = new Runnable() { // from class: com.pspdfkit.internal.zd$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                zd.c(this.f$0);
            }
        };
        this.k = new Runnable() { // from class: com.pspdfkit.internal.zd$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                zd.b(this.f$0);
            }
        };
    }

    public static final TextSelectionPopupToolbar a(PdfFragment pdfFragment) {
        pdfFragment.getClass();
        if (pdfFragment.getConfiguration().isTextSelectionPopupToolbarEnabled()) {
            return new TextSelectionPopupToolbar(pdfFragment);
        }
        return null;
    }

    public static final void b(zd zdVar) {
        PopupToolbar popupToolbar = zdVar.h;
        if (popupToolbar != null) {
            popupToolbar.showAgain();
        }
    }

    public static final void c(zd zdVar) {
        y50 y50Var;
        TextSelectionPopupToolbar textSelectionPopupToolbar = (TextSelectionPopupToolbar) zdVar.f.getValue();
        if (textSelectionPopupToolbar == null) {
            return;
        }
        a60 a60Var = zdVar.g;
        if (a60Var == null || (y50Var = a60Var.k) == null || y50Var.t == y50.b.NO_DRAG) {
            textSelectionPopupToolbar.showForSelectedText();
            zdVar.h = textSelectionPopupToolbar;
        }
    }

    public static final TextSelectionPopupToolbar d(zd zdVar) {
        return zdVar.c.invoke(zdVar.a);
    }

    public static final PopupToolbar a(zd zdVar) {
        if (zdVar.a.getContext() == null) {
            return null;
        }
        return new PopupToolbar(zdVar.a);
    }

    public final void a(y50.b bVar) {
        bVar.getClass();
        TextSelectionPopupToolbar textSelectionPopupToolbar = (TextSelectionPopupToolbar) this.f.getValue();
        if (textSelectionPopupToolbar == null) {
            return;
        }
        int iOrdinal = bVar.ordinal();
        if (iOrdinal != 1 && iOrdinal != 2) {
            this.h = textSelectionPopupToolbar;
            this.d.removeCallbacks(this.j);
            this.d.postDelayed(this.j, 300L);
        } else {
            this.d.removeCallbacks(this.j);
            textSelectionPopupToolbar.dismiss();
            this.h = textSelectionPopupToolbar;
        }
    }

    public final void a(final int i, final float f, final float f2) {
        final PopupToolbar popupToolbar;
        ArrayList arrayList = new ArrayList();
        final ub copyPasteManager = this.b.getCopyPasteManager();
        if (copyPasteManager != null && copyPasteManager.a() && this.a.getConfiguration().isCopyPasteEnabled()) {
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_paste_annotation, R.string.pspdf__paste, R.drawable.pspdf__ic_content_paste, true));
        }
        if (this.a.getConfiguration().isAnnotationEditingEnabled() && !this.a.isInSpecialMode()) {
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_annotate, R.string.pspdf__annotate, R.drawable.pspdf__ic_edit_annotations, true));
        }
        tg tgVarB = ar.b();
        PdfConfiguration configuration = this.a.getConfiguration();
        configuration.getClass();
        if (tgVarB.d(configuration) && !this.a.isInSpecialMode()) {
            arrayList.add(new PopupToolbarMenuItem(R.id.pspdf__text_selection_toolbar_item_content_editing, R.string.pspdf__contentediting_title, R.drawable.pspdf__ic_edit_content, true));
        }
        if (arrayList.isEmpty() || (popupToolbar = (PopupToolbar) this.e.getValue()) == null) {
            return;
        }
        popupToolbar.setMenuItems(arrayList);
        popupToolbar.setDefaultItemHandler(new PopupToolbar.DefaultItemHandler() { // from class: com.pspdfkit.internal.zd$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.ui.PopupToolbar.DefaultItemHandler
            public final boolean onItemClicked(PopupToolbarMenuItem popupToolbarMenuItem) {
                return zd.a(copyPasteManager, f, f2, i, popupToolbar, this, popupToolbarMenuItem);
            }
        });
        OnPreparePopupToolbarListener onPreparePopupToolbarListener = this.i;
        if (onPreparePopupToolbarListener != null) {
            onPreparePopupToolbarListener.onPrepareLongPressPopupToolbar(popupToolbar, i, new PointF(f, f2));
        }
        if (popupToolbar.getMenuItems().isEmpty()) {
            return;
        }
        a();
        popupToolbar.show(i, f, f2);
        this.h = popupToolbar;
    }

    public /* synthetic */ zd(PdfFragment pdfFragment, DocumentView documentView) {
        this(pdfFragment, documentView, new Function1() { // from class: com.pspdfkit.internal.zd$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return zd.a((PdfFragment) obj);
            }
        }, new Handler(Looper.getMainLooper()));
    }

    public static final boolean a(ub ubVar, float f, float f2, int i, PopupToolbar popupToolbar, zd zdVar, PopupToolbarMenuItem popupToolbarMenuItem) {
        popupToolbarMenuItem.getClass();
        int id = popupToolbarMenuItem.getId();
        if (id == R.id.pspdf__text_selection_toolbar_item_paste_annotation) {
            if (ubVar != null && ubVar.a()) {
                ubVar.a(i, new PointF(f, f2)).subscribe();
            }
            popupToolbar.dismiss();
            return true;
        }
        if (id == R.id.pspdf__text_selection_toolbar_item_annotate) {
            popupToolbar.dismiss();
            zdVar.a.enterAnnotatingMode();
            return true;
        }
        if (id != R.id.pspdf__text_selection_toolbar_item_content_editing) {
            return true;
        }
        popupToolbar.dismiss();
        zdVar.a.enterContentEditingMode();
        return true;
    }

    public final void a() {
        this.d.removeCallbacks(this.j);
        this.d.removeCallbacks(this.k);
        PopupToolbar popupToolbar = this.h;
        if (popupToolbar != null) {
            popupToolbar.dismiss();
        }
        this.h = null;
    }
}
