package com.pspdfkit.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pspdfkit.R;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.activity.TabBarHidingMode;
import com.pspdfkit.configuration.activity.ThumbnailBarMode;
import com.pspdfkit.configuration.activity.UserInterfaceViewMode;
import com.pspdfkit.configuration.search.SearchType;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.exceptions.InvalidLayoutException;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfDocumentInfoView;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfOutlineView;
import com.pspdfkit.ui.PdfReaderView;
import com.pspdfkit.ui.PdfThumbnailBar;
import com.pspdfkit.ui.PdfThumbnailGrid;
import com.pspdfkit.ui.audio.AudioView;
import com.pspdfkit.ui.contentediting.ContentEditingStylingBar;
import com.pspdfkit.ui.forms.FormEditingBar;
import com.pspdfkit.ui.redaction.RedactionView;
import com.pspdfkit.ui.scale.MeasurementScaleView;
import com.pspdfkit.ui.search.PdfSearchView;
import com.pspdfkit.ui.search.PdfSearchViewInline;
import com.pspdfkit.ui.search.PdfSearchViewLazy;
import com.pspdfkit.ui.search.PdfSearchViewModular;
import com.pspdfkit.ui.tabs.PdfTabBar;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class jv implements im {
    public PdfFragment a;
    public final TextView b;
    public final TextView c;
    public final PdfTabBar d;
    public final View e;
    public final View f;
    public final boolean g;
    public final ArrayList h;
    public final PdfActivityConfiguration i;
    public final PdfThumbnailBar j;
    public final PdfThumbnailGrid k;
    public final PdfOutlineView l;
    public final PdfDocumentInfoView m;
    public final PdfReaderView n;
    public final FormEditingBar o;
    public final ContentEditingStylingBar p;
    public final RedactionView q;
    public final MeasurementScaleView r;
    public final AudioView s;
    public final View t;
    public PdfSearchView u;
    public final ViewGroup v;
    public final FloatingActionButton w;
    public final FloatingActionButton x;
    public final SparseBooleanArray y = new SparseBooleanArray();

    public class a extends PdfSearchViewLazy {
        public final /* synthetic */ View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, View view) {
            super(context);
            this.a = view;
        }

        @Override // com.pspdfkit.ui.search.PdfSearchViewLazy
        public final PdfSearchView createSearchView() {
            PdfSearchViewInline pdfSearchViewInline = new PdfSearchViewInline(this.a.getContext());
            pdfSearchViewInline.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            pdfSearchViewInline.setId(R.id.pspdf__search_view_inline);
            return pdfSearchViewInline;
        }
    }

    public class b implements OnVisibilityChangedListener {
        public b() {
        }

        @Override // com.pspdfkit.listeners.OnVisibilityChangedListener
        public final void onHide(View view) {
            jv.this.a(true);
        }

        @Override // com.pspdfkit.listeners.OnVisibilityChangedListener
        public final void onShow(View view) {
            jv.this.a(false);
        }
    }

    public jv(View view, PdfActivityConfiguration pdfActivityConfiguration) {
        ViewGroup.LayoutParams layoutParams;
        uw.a(view, "rootView", null);
        uw.a(pdfActivityConfiguration, "configuration", null);
        this.h = new ArrayList();
        this.i = pdfActivityConfiguration;
        this.g = pdfActivityConfiguration.isDocumentEditorEnabled() && ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pspdf__activity_content);
        if (!pdfActivityConfiguration.isDefaultToolbarEnabled()) {
            frameLayout.setPadding(0, 0, 0, 0);
        }
        try {
            this.b = (TextView) a(R.id.pspdf__activity_page_overlay, view, pdfActivityConfiguration.isShowPageNumberOverlay(), "R.id.pspdf__activity_page_overlay", "page number overlay");
            try {
                TextView textView = (TextView) a(R.id.pspdf__activity_title_overlay, view, pdfActivityConfiguration.isShowDocumentTitleOverlayEnabled(), "R.id.pspdf__activity_title_overlay", "document title overlay");
                this.c = textView;
                if (textView != null) {
                    yo yoVar = (yo) new l(view.getContext()).c.getValue();
                    textView.setTextColor(yoVar.d);
                    textView.setBackgroundColor(yoVar.a);
                }
                try {
                    int i = R.id.pspdf__activity_tab_bar;
                    TabBarHidingMode tabBarHidingMode = pdfActivityConfiguration.getTabBarHidingMode();
                    TabBarHidingMode tabBarHidingMode2 = TabBarHidingMode.HIDE;
                    PdfTabBar pdfTabBar = (PdfTabBar) a(i, view, tabBarHidingMode != tabBarHidingMode2, "R.id.pspdf__activity_tab_bar", "the tab bar");
                    this.d = pdfTabBar;
                    if (pdfTabBar != null && (pdfActivityConfiguration.getUserInterfaceViewMode() == UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_HIDDEN || pdfActivityConfiguration.getTabBarHidingMode() == tabBarHidingMode2 || pdfActivityConfiguration.getTabBarHidingMode() == TabBarHidingMode.AUTOMATIC_HIDE_SINGLE)) {
                        pdfTabBar.setVisibility(8);
                    }
                    try {
                        this.e = a(R.id.pspdf__navigate_back, view, pdfActivityConfiguration.isShowNavigationButtonsEnabled(), "R.id.pspdf__navigate_back", "navigation buttons");
                        try {
                            this.f = a(R.id.pspdf__navigate_forward, view, pdfActivityConfiguration.isShowNavigationButtonsEnabled(), "R.id.pspdf__navigate_forward", "navigation buttons");
                            try {
                                this.j = (PdfThumbnailBar) a(R.id.pspdf__activity_thumbnail_bar, view, pdfActivityConfiguration.getThumbnailBarMode() != ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE, "R.id.pspdf__activity_thumbnail_bar", "the thumbnail bar");
                                try {
                                    this.k = (PdfThumbnailGrid) a(R.id.pspdf__activity_thumbnail_grid, view, pdfActivityConfiguration.isThumbnailGridEnabled(), "R.id.pspdf__activity_thumbnail_grid", "the thumbnail grid");
                                    try {
                                        PdfOutlineView pdfOutlineView = (PdfOutlineView) a(R.id.pspdf__activity_outline_view, view, pdfActivityConfiguration.isOutlineEnabled(), "R.id.pspdf__activity_outline_view", "the document outline");
                                        this.l = pdfOutlineView;
                                        if (view.findViewById(R.id.pspdf__activity_document_info_view) == null && pdfActivityConfiguration.isDocumentInfoViewSeparated()) {
                                            PdfDocumentInfoView pdfDocumentInfoView = new PdfDocumentInfoView(view.getContext());
                                            this.m = pdfDocumentInfoView;
                                            if (pdfOutlineView != null) {
                                                frameLayout = (FrameLayout) pdfOutlineView.getParent();
                                                layoutParams = pdfOutlineView.getLayoutParams();
                                                pdfDocumentInfoView.setClipToPadding(pdfOutlineView.getClipToPadding());
                                                pdfDocumentInfoView.setVisibility(pdfOutlineView.getVisibility());
                                            } else {
                                                layoutParams = new ViewGroup.LayoutParams(-1, -1);
                                                pdfDocumentInfoView.setClipToPadding(false);
                                                pdfDocumentInfoView.setVisibility(4);
                                            }
                                            pdfDocumentInfoView.setLayoutParams(layoutParams);
                                            if (frameLayout == null) {
                                                frameLayout = (FrameLayout) view.findViewById(R.id.pspdf__activity_content);
                                                if (!pdfActivityConfiguration.isDefaultToolbarEnabled()) {
                                                    frameLayout.setPadding(0, 0, 0, 0);
                                                }
                                            }
                                            if (frameLayout != null) {
                                                frameLayout.addView(pdfDocumentInfoView);
                                            }
                                        } else {
                                            try {
                                                this.m = (PdfDocumentInfoView) a(R.id.pspdf__activity_document_info_view, view, pdfActivityConfiguration.isDocumentInfoViewEnabled() && pdfActivityConfiguration.isDocumentInfoViewSeparated(), "R.id.pspdf__activity_document_info_view", "the document info");
                                            } catch (ClassCastException e) {
                                                throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_document_info_view' has to be of type com.pspdfkit.ui.PSPDFDocumentInfoView.", e);
                                            }
                                        }
                                        try {
                                            this.n = (PdfReaderView) a(R.id.pspdf__activity_reader_view, view, pdfActivityConfiguration.isReaderViewEnabled(), "R.id.pspdf__activity_reader_view", "the document reader view");
                                            if (pdfActivityConfiguration.isSearchEnabled()) {
                                                if (pdfActivityConfiguration.getSearchType() == SearchType.MODULAR) {
                                                    try {
                                                        this.u = (PdfSearchView) a(R.id.pspdf__activity_search_view_modular, view, pdfActivityConfiguration.isSearchEnabled(), "R.id.pspdf__activity_search_view_modular", "the modular search");
                                                    } catch (ClassCastException e2) {
                                                        throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_search_view_modular' has to be of type com.pspdfkit.ui.search.PdfSearchViewModular or com.pspdfkit.ui.search.PdfSearchViewLazy.", e2);
                                                    }
                                                } else {
                                                    this.u = new a(view.getContext(), view);
                                                }
                                                PdfSearchView pdfSearchView = this.u;
                                                if (pdfSearchView instanceof PdfSearchViewLazy) {
                                                    ((PdfSearchViewLazy) pdfSearchView).setOnViewReadyListener(new PdfSearchViewLazy.OnViewReadyListener() { // from class: com.pspdfkit.internal.jv$$ExternalSyntheticLambda0
                                                        @Override // com.pspdfkit.ui.search.PdfSearchViewLazy.OnViewReadyListener
                                                        public final void onViewReady(PdfSearchViewLazy pdfSearchViewLazy, PdfSearchView pdfSearchView2) {
                                                            this.f$0.a(pdfSearchViewLazy, pdfSearchView2);
                                                        }
                                                    });
                                                }
                                            } else {
                                                this.u = null;
                                            }
                                            try {
                                                this.o = (FormEditingBar) a(R.id.pspdf__activity_form_editing_bar, view, pdfActivityConfiguration.getConfiguration().isFormEditingEnabled(), "R.id.pspdf__activity_form_editing_bar", "the form editing");
                                                boolean zD = ar.b().d(pdfActivityConfiguration.getConfiguration());
                                                try {
                                                    this.p = (ContentEditingStylingBar) a(R.id.pspdf__activity_content_editing_bar, view, zD, "R.id.pspdf__activity_content_editing_bar", "the content editing");
                                                    try {
                                                        this.v = (ViewGroup) a(R.id.pspdf__content_editing_create_textblock_button_container, view, zD, "R.id.pspdf__content_editing_create_textblock_button_container", "the content editing");
                                                    } catch (ClassCastException unused) {
                                                        PdfLog.w("Nutri.PdfActivityViews", "View with id 'pspdf__content_editing_create_textblock_button_container' of type android.view.ViewGroup not found.", new Object[0]);
                                                    }
                                                    try {
                                                        this.w = (FloatingActionButton) a(R.id.pspdf__content_editing_create_textblock_fab_main_page, view, zD, "R.id.pspdf__content_editing_create_textblock_fab_main_page", "the content editing");
                                                    } catch (ClassCastException unused2) {
                                                        PdfLog.w("Nutri.PdfActivityViews", "View with id 'pspdf__content_editing_create_textblock_fab_main_page' of type com.google.android.material.floatingactionbutton.FloatingActionButton not found.", new Object[0]);
                                                    }
                                                    try {
                                                        this.x = (FloatingActionButton) a(R.id.pspdf__content_editing_create_textblock_fab_second_page, view, zD, "R.id.pspdf__content_editing_create_textblock_fab_second_page", "the content editing");
                                                    } catch (ClassCastException unused3) {
                                                        PdfLog.w("Nutri.PdfActivityViews", "View with id 'pspdf__content_editing_create_textblock_fab_second_page' of type com.google.android.material.floatingactionbutton.FloatingActionButton not found.", new Object[0]);
                                                    }
                                                    try {
                                                        this.s = (AudioView) a(R.id.pspdf__activity_audio_inspector, view, false, "R.id.pspdf__activity_audio_inspector", "the sound annotations");
                                                        try {
                                                            this.q = (RedactionView) a(R.id.pspdf__redaction_view, view, pdfActivityConfiguration.isRedactionUiEnabled() && ar.b().a(NativeLicenseFeatures.REDACTION), "R.id.pspdf__redaction_view", "the redaction UI");
                                                            try {
                                                                this.r = (MeasurementScaleView) a(R.id.pspdf__measurement_scale_view, view, ar.b().f(pdfActivityConfiguration.getConfiguration()), "R.id.pspdf__measurement_scale_view", "the measurement scale UI");
                                                                View viewFindViewById = view.findViewById(R.id.pspdf__activity_empty_view);
                                                                this.t = viewFindViewById;
                                                                if (viewFindViewById != null) {
                                                                    viewFindViewById.setVisibility(8);
                                                                }
                                                                this.h.add(this.j);
                                                                this.h.add(this.k);
                                                                this.h.add(this.n);
                                                                this.h.add(this.l);
                                                                this.h.add(this.m);
                                                                this.h.add(this.u);
                                                                b bVar = new b();
                                                                PdfReaderView pdfReaderView = this.n;
                                                                if (pdfReaderView != null) {
                                                                    pdfReaderView.addOnVisibilityChangedListener(bVar);
                                                                }
                                                                PdfOutlineView pdfOutlineView2 = this.l;
                                                                if (pdfOutlineView2 != null) {
                                                                    pdfOutlineView2.addOnVisibilityChangedListener(bVar);
                                                                }
                                                                PdfDocumentInfoView pdfDocumentInfoView2 = this.m;
                                                                if (pdfDocumentInfoView2 != null) {
                                                                    pdfDocumentInfoView2.addOnVisibilityChangedListener(bVar);
                                                                }
                                                                PdfThumbnailGrid pdfThumbnailGrid = this.k;
                                                                if (pdfThumbnailGrid != null) {
                                                                    pdfThumbnailGrid.addOnVisibilityChangedListener(bVar);
                                                                }
                                                            } catch (ClassCastException e3) {
                                                                throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__measurement_scale_view' has to be of type com.pspdfkit.ui.scale.MeasurementScaleView", e3);
                                                            }
                                                        } catch (ClassCastException e4) {
                                                            throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__redaction_view' has to be of type com.pspdfkit.ui.redaction.RedactionView", e4);
                                                        }
                                                    } catch (ClassCastException e5) {
                                                        throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_audio_inspector' has to be of type com.pspdfkit.ui.audio.AudioInspector", e5);
                                                    }
                                                } catch (ClassCastException e6) {
                                                    throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'pspdf__activity_content_editing_bar' has to be of type com.pspdfkit.ui.contentediting.ContentEditingStylingBar", e6);
                                                }
                                            } catch (ClassCastException e7) {
                                                throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_form_input_bar' has to be of type com.pspdfkit.ui.forms.FormEditingBar", e7);
                                            }
                                        } catch (ClassCastException e8) {
                                            throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_reader_view' has to be of type com.pspdfkit.ui.PdfReaderView.", e8);
                                        }
                                    } catch (ClassCastException e9) {
                                        throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_outline_view' has to be of type com.pspdfkit.ui.PSPDFOutlineView.", e9);
                                    }
                                } catch (ClassCastException e10) {
                                    throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_thumbnail_grid' has to be of type com.pspdfkit.ui.PSPDFThumbnailGrid.", e10);
                                }
                            } catch (ClassCastException e11) {
                                throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_thumbnail_bar' has to be of type com.pspdfkit.ui.PSPDFThumbnailBar.", e11);
                            }
                        } catch (ClassCastException e12) {
                            throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__navigate_forward' has to be of type android.view.View.", e12);
                        }
                    } catch (ClassCastException e13) {
                        throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__navigate_back' has to be of type android.view.View.", e13);
                    }
                } catch (ClassCastException e14) {
                    throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_tab_bar' has to be of type com.pspdfkit.ui.tabs.PdfTabsBar.", e14);
                }
            } catch (ClassCastException e15) {
                throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_title_overlay' has to be of type android.widget.TextView.", e15);
            }
        } catch (ClassCastException e16) {
            throw new InvalidLayoutException("Exception while inflating activity layout. View with id 'R.id.pspdf__activity_page_overlay' has to be of type android.widget.TextView.", e16);
        }
    }

    public final /* synthetic */ void a(PdfSearchViewLazy pdfSearchViewLazy, PdfSearchView pdfSearchView) {
        this.u = pdfSearchView;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final void addOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        uw.a(onVisibilityChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            PSPDFKitViews.PSPDFView pSPDFView = (PSPDFKitViews.PSPDFView) obj;
            if (pSPDFView != null) {
                pSPDFView.addOnVisibilityChangedListener(onVisibilityChangedListener);
            }
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final PSPDFKitViews.Type getActiveViewType() {
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            PSPDFKitViews.PSPDFView pSPDFView = (PSPDFKitViews.PSPDFView) obj;
            if (pSPDFView != null && pSPDFView.isDisplayed() && pSPDFView.getPSPDFViewType() != PSPDFKitViews.Type.VIEW_THUMBNAIL_BAR) {
                return pSPDFView.getPSPDFViewType();
            }
        }
        return PSPDFKitViews.Type.VIEW_NONE;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final AudioView getAudioInspector() {
        return this.s;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final ContentEditingStylingBar getContentEditingStylingBarView() {
        return this.p;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final ViewGroup getCreateTextBlockButtonsContainer() {
        return this.v;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final PdfDocumentInfoView getDocumentInfoView() {
        return this.m;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final TextView getDocumentTitleOverlayView() {
        if (this.i.isDefaultToolbarEnabled()) {
            return this.c;
        }
        return null;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final View getEmptyView() {
        return this.t;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final FormEditingBar getFormEditingBarView() {
        return this.o;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final FloatingActionButton getMainPageCreateTextBlockButton() {
        return this.w;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final MeasurementScaleView getMeasurementScaleView() {
        return this.r;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final View getNavigateBackButton() {
        return this.e;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final View getNavigateForwardButton() {
        return this.f;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final PdfOutlineView getOutlineView() {
        return this.l;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final TextView getPageNumberOverlayView() {
        return this.b;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final PdfReaderView getReaderView() {
        return this.n;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final RedactionView getRedactionView() {
        return this.q;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final PdfSearchView getSearchView() {
        PdfSearchView pdfSearchView = this.u;
        return pdfSearchView instanceof PdfSearchViewLazy ? ((PdfSearchViewLazy) pdfSearchView).prepareForDisplay() : pdfSearchView;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final FloatingActionButton getSecondPageCreateTextBlockButton() {
        return this.x;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final PdfTabBar getTabBar() {
        return this.d;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final PdfThumbnailBar getThumbnailBarView() {
        return this.j;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final PdfThumbnailGrid getThumbnailGridView() {
        return this.k;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final PSPDFKitViews.PSPDFView getViewByType(PSPDFKitViews.Type type) {
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            PSPDFKitViews.PSPDFView pSPDFView = (PSPDFKitViews.PSPDFView) obj;
            if (pSPDFView != null && pSPDFView.getPSPDFViewType() == type) {
                return pSPDFView;
            }
        }
        return null;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final void onRestoreViewHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("PSPDFKitViews.HierarchyState");
        if (sparseParcelableArray == null || sparseParcelableArray.size() == 0) {
            return;
        }
        PdfSearchView pdfSearchView = this.u;
        if (pdfSearchView instanceof PdfSearchViewInline) {
            ((PdfSearchViewInline) pdfSearchView).restoreHierarchyState(sparseParcelableArray);
            return;
        }
        if (!(pdfSearchView instanceof PdfSearchViewLazy)) {
            if (pdfSearchView instanceof PdfSearchViewModular) {
                ((PdfSearchViewModular) pdfSearchView).restoreHierarchyState(sparseParcelableArray);
                return;
            }
            return;
        }
        PdfSearchView searchView = ((PdfSearchViewLazy) pdfSearchView).getSearchView();
        if (searchView instanceof PdfSearchViewModular) {
            ((PdfSearchViewModular) searchView).restoreHierarchyState(sparseParcelableArray);
        } else if (searchView instanceof PdfSearchViewInline) {
            ((PdfSearchViewInline) searchView).restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final void onSaveViewHierarchyState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        PdfSearchView pdfSearchView = this.u;
        if (pdfSearchView instanceof PdfSearchViewInline) {
            ((PdfSearchViewInline) pdfSearchView).saveHierarchyState(sparseArray);
        } else if (pdfSearchView instanceof PdfSearchViewModular) {
            ((PdfSearchViewModular) pdfSearchView).saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("PSPDFKitViews.HierarchyState", sparseArray);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final void removeOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        uw.a(onVisibilityChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            PSPDFKitViews.PSPDFView pSPDFView = (PSPDFKitViews.PSPDFView) obj;
            if (pSPDFView != null) {
                pSPDFView.removeOnVisibilityChangedListener(onVisibilityChangedListener);
            }
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final void resetDocument() {
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            PSPDFKitViews.PSPDFView pSPDFView = (PSPDFKitViews.PSPDFView) obj;
            if (pSPDFView != null) {
                pSPDFView.clearDocument();
            }
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final boolean showView(PSPDFKitViews.Type type) {
        PSPDFKitViews.Type activeViewType;
        if (type == PSPDFKitViews.Type.VIEW_THUMBNAIL_BAR || type == PSPDFKitViews.Type.VIEW_NONE || (activeViewType = getActiveViewType()) == type) {
            return false;
        }
        PSPDFKitViews.PSPDFView viewByType = getViewByType(activeViewType);
        PSPDFKitViews.PSPDFView viewByType2 = getViewByType(type);
        if (viewByType2 != null) {
            viewByType2.show();
            if (viewByType == null) {
                return true;
            }
            viewByType.hide();
            return true;
        }
        return false;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final boolean toggleView(PSPDFKitViews.Type type) {
        return toggleView(type, 0L);
    }

    public static View a(int i, View view, boolean z, String str, String str2) {
        View viewFindViewById = view.findViewById(i);
        if (viewFindViewById == null && z) {
            throw new InvalidLayoutException("The activity layout was missing a View with id '" + str + "'. Add this view to your layout file or deactivate " + str2 + " in your PdfActivityConfiguration.");
        }
        return viewFindViewById;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final void setDocument(PdfDocument pdfDocument) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("setDocument() must be called on the main thread.");
        }
        uw.a(pdfDocument, "document", null);
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            PSPDFKitViews.PSPDFView pSPDFView = (PSPDFKitViews.PSPDFView) obj;
            if (pSPDFView != null) {
                pSPDFView.setDocument(pdfDocument, this.i.getConfiguration());
            }
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews
    public final boolean toggleView(PSPDFKitViews.Type type, long j) {
        if (type == PSPDFKitViews.Type.VIEW_THUMBNAIL_BAR) {
            return false;
        }
        PSPDFKitViews.PSPDFView viewByType = getViewByType(getActiveViewType());
        if (viewByType != null) {
            viewByType.hide();
            if (type == viewByType.getPSPDFViewType() || type == PSPDFKitViews.Type.VIEW_NONE) {
                return true;
            }
        }
        final PSPDFKitViews.PSPDFView viewByType2 = getViewByType(type);
        if (viewByType2 == null) {
            return false;
        }
        new Handler().postDelayed(new Runnable() { // from class: com.pspdfkit.internal.jv$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                viewByType2.show();
            }
        }, j);
        return true;
    }

    public final void a(boolean z) {
        ArrayList arrayList = new ArrayList();
        PdfFragment pdfFragment = this.a;
        if (pdfFragment != null && pdfFragment.getView() != null) {
            arrayList.add(this.a.getView());
        }
        PdfTabBar pdfTabBar = this.d;
        if (pdfTabBar != null) {
            arrayList.add(pdfTabBar);
        }
        View view = this.e;
        if (view != null) {
            arrayList.add(view);
        }
        View view2 = this.f;
        if (view2 != null) {
            arrayList.add(view2);
        }
        RedactionView redactionView = this.q;
        if (redactionView != null) {
            arrayList.add(redactionView);
        }
        MeasurementScaleView measurementScaleView = this.r;
        if (measurementScaleView != null) {
            arrayList.add(measurementScaleView);
        }
        PdfThumbnailBar pdfThumbnailBar = this.j;
        if (pdfThumbnailBar != null) {
            arrayList.add(pdfThumbnailBar);
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            View view3 = (View) obj;
            if (view3 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view3;
                if (z) {
                    viewGroup.setDescendantFocusability(262144);
                    view3.setFocusable(this.y.get(view3.getId(), false));
                } else {
                    this.y.put(view3.getId(), view3.isFocusable());
                    view3.setFocusable(false);
                    viewGroup.setDescendantFocusability(393216);
                }
            }
        }
    }
}
