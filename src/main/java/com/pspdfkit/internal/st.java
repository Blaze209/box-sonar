package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Looper;
import android.view.View;
import com.pspdfkit.R;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.ui.overlay.OverlayViewProvider;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes3.dex */
public final class st extends dw implements OverlayViewProvider.OverlayViewProviderObserver {
    public static final int h = R.id.pspdf__tag_key_overlay_provider;
    public final au d;
    public m40 e;
    public boolean f;
    public final LinkedHashMap g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public st(Context context, au auVar) {
        super(context);
        context.getClass();
        this.d = auVar;
        this.g = new LinkedHashMap();
    }

    @Override // com.pspdfkit.internal.dw
    public final Matrix a(Matrix matrix) {
        return this.d.a(matrix);
    }

    @Override // com.pspdfkit.internal.dw
    public RectF getPdfRect() {
        return this.d.getPdfRect();
    }

    @Override // com.pspdfkit.internal.dw
    public float getZoomScale() {
        return this.d.getZoomScale();
    }

    @Override // com.pspdfkit.ui.overlay.OverlayViewProvider.OverlayViewProviderObserver
    public final void onOverlayViewsChanged(OverlayViewProvider overlayViewProvider, int i) {
        overlayViewProvider.getClass();
        m40 m40Var = this.e;
        if (m40Var == null || (m40Var != null && i == m40Var.b)) {
            onOverlayViewsChanged(overlayViewProvider);
        }
    }

    public final void setCurrentOverlayViewProviders(List<? extends OverlayViewProvider> list) {
        list.getClass();
        m40 m40Var = this.e;
        if (m40Var == null) {
            throw new IllegalStateException("setCurrentOverlayViewProviders() should be called after bind() was called.");
        }
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("Overlay views touched from non-main thread.");
        }
        a();
        for (OverlayViewProvider overlayViewProvider : list) {
            overlayViewProvider.addOverlayViewProviderObserver(this);
            a(m40Var, overlayViewProvider);
        }
        measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    public final void a(m40 m40Var, OverlayViewProvider overlayViewProvider) {
        List<View> viewsForPage = overlayViewProvider.getViewsForPage(getContext(), m40Var.a, m40Var.b);
        if (viewsForPage == null) {
            viewsForPage = CollectionsKt.emptyList();
        }
        for (View view : viewsForPage) {
            if (view != null) {
                if (view.getParent() != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    throw new IllegalArgumentException(String.format("You can't add views that already have a parent. (%s)", Arrays.copyOf(new Object[]{view}, 1)));
                }
                if (view.getLayoutParams() == null || !(view.getLayoutParams() instanceof OverlayLayoutParams)) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    throw new IllegalArgumentException(String.format("You need to set OverlayLayoutParams on the view before returning it. (%s)", Arrays.copyOf(new Object[]{view}, 1)));
                }
                addView(view, view.getLayoutParams());
                view.setTag(h, overlayViewProvider);
            }
        }
        if (this.f) {
            overlayViewProvider.onViewsShown(m40Var.b, viewsForPage);
        }
        this.g.put(overlayViewProvider, viewsForPage);
    }

    @Override // com.pspdfkit.ui.overlay.OverlayViewProvider.OverlayViewProviderObserver
    public final void onOverlayViewsChanged(OverlayViewProvider overlayViewProvider) {
        overlayViewProvider.getClass();
        m40 m40Var = this.e;
        if (m40Var == null) {
            return;
        }
        List<View> listEmptyList = (List) this.g.get(overlayViewProvider);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Iterator<View> it = listEmptyList.iterator();
        while (it.hasNext()) {
            removeView(it.next());
        }
        overlayViewProvider.onViewsRecycled(m40Var.b, listEmptyList);
        a(m40Var, overlayViewProvider);
        measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    public final void a() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            for (Map.Entry entry : this.g.entrySet()) {
                OverlayViewProvider overlayViewProvider = (OverlayViewProvider) entry.getKey();
                List<View> list = (List) entry.getValue();
                overlayViewProvider.removeOverlayViewProviderObserver(this);
                Iterator<View> it = list.iterator();
                while (it.hasNext()) {
                    removeView(it.next());
                }
                m40 m40Var = this.e;
                overlayViewProvider.onViewsRecycled(m40Var != null ? m40Var.b : 0, list);
            }
            this.g.clear();
            return;
        }
        throw new IllegalStateException("Overlay views touched from non-main thread.");
    }
}
