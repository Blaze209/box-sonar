package com.pspdfkit.ui.overlay;

import android.content.Context;
import android.view.View;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.uw;
import com.pspdfkit.ui.PageObjectProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class OverlayViewProvider implements PageObjectProvider {
    public static final Set<Integer> ALL_PAGES = Collections.EMPTY_SET;
    private final List<OverlayViewProviderObserver> overlayViewProviderObservers = new ArrayList();

    public interface OverlayViewProviderObserver {
        void onOverlayViewsChanged(OverlayViewProvider overlayViewProvider);

        void onOverlayViewsChanged(OverlayViewProvider overlayViewProvider, int i);
    }

    public OverlayViewProvider() {
        if (!ar.b().a()) {
            throw new InvalidNutrientLicenseException("Using the OverlayViewProvider requires the annotations component.");
        }
    }

    public void addOverlayViewProviderObserver(OverlayViewProviderObserver overlayViewProviderObserver) {
        uw.a(overlayViewProviderObserver, "overlayViewProviderObserver", null);
        synchronized (this.overlayViewProviderObservers) {
            if (!this.overlayViewProviderObservers.contains(overlayViewProviderObserver)) {
                this.overlayViewProviderObservers.add(overlayViewProviderObserver);
            }
        }
    }

    @Override // com.pspdfkit.ui.PageObjectProvider
    public final Set<Integer> getFilteredPages() {
        return getPagesWithViews();
    }

    public Set<Integer> getPagesWithViews() {
        return ALL_PAGES;
    }

    public abstract List<View> getViewsForPage(Context context, PdfDocument pdfDocument, int i);

    public void notifyOverlayViewsChanged() {
        synchronized (this.overlayViewProviderObservers) {
            Iterator<OverlayViewProviderObserver> it = this.overlayViewProviderObservers.iterator();
            while (it.hasNext()) {
                it.next().onOverlayViewsChanged(this);
            }
        }
    }

    public void onViewsHidden(int i, List<View> list) {
    }

    public void onViewsRecycled(int i, List<View> list) {
    }

    public void onViewsShown(int i, List<View> list) {
    }

    public void removeOverlayViewProviderObserver(OverlayViewProviderObserver overlayViewProviderObserver) {
        uw.a(overlayViewProviderObserver, "overlayViewProviderObserver", null);
        synchronized (this.overlayViewProviderObservers) {
            this.overlayViewProviderObservers.remove(overlayViewProviderObserver);
        }
    }

    public void notifyOverlayViewsChanged(int i) {
        synchronized (this.overlayViewProviderObservers) {
            Iterator<OverlayViewProviderObserver> it = this.overlayViewProviderObservers.iterator();
            while (it.hasNext()) {
                it.next().onOverlayViewsChanged(this, i);
            }
        }
    }
}
