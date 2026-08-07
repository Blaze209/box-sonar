package com.pspdfkit.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.OutlineElement;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.files.EmbeddedFile;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.at;
import com.pspdfkit.internal.f8;
import com.pspdfkit.internal.h8;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.i8;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.mt;
import com.pspdfkit.internal.nt;
import com.pspdfkit.internal.ot;
import com.pspdfkit.internal.pn;
import com.pspdfkit.internal.qd;
import com.pspdfkit.internal.tr;
import com.pspdfkit.internal.tv;
import com.pspdfkit.internal.ud;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.views.utils.OutlinePagerTabView;
import com.pspdfkit.internal.views.utils.a;
import com.pspdfkit.internal.yf;
import com.pspdfkit.internal.z2;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.listeners.OnVisibilityChangedListenerManager;
import com.pspdfkit.ui.documentinfo.OnDocumentInfoViewModeChangeListener;
import com.pspdfkit.ui.documentinfo.OnDocumentInfoViewSaveListener;
import com.pspdfkit.ui.drawable.PdfDrawableManager;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import com.pspdfkit.ui.outline.BookmarkViewAdapter;
import com.pspdfkit.undo.UndoManager;
import io.reactivex.rxjava3.core.Single;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes3.dex */
public class PdfOutlineView extends FrameLayout implements nt.a, PSPDFKitViews.PSPDFView, PdfDrawableManager {
    private boolean displayAnnotationListView;
    private boolean displayBookmarkListView;
    private boolean displayEmbeddedFilesView;
    private boolean displayInfoListView;
    private boolean displayOutlineView;
    private final DocumentListener documentListener;
    private boolean isDisplayed;
    private final OnVisibilityChangedListenerManager listeners;
    private boolean mayContainDocumentInfoView;
    private OnAnnotationTapListener onAnnotationTapListener;
    private at onEditRecordedListener;
    private OnEmbeddedFileTapListener onEmbeddedFileTapListener;
    private View.OnLayoutChangeListener onLayoutChangeListener;
    private OnOutlineElementTapListener onOutlineElementTapListener;
    private ViewPager pager;
    private final pn<OutlinePagerAdapter> pagerAdapter;
    private OutlinePagerTabView pagerTabs;
    private int shadowHeightPx;
    private ot themeConfiguration;
    private ViewModelStoreOwner viewModelStoreOwner;
    private static final GradientDrawable leftShadow = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, new int[]{Color.argb(70, 80, 80, 80), 0});
    private static final GradientDrawable bottomShadow = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(70, 80, 80, 80), 0});

    /* JADX INFO: renamed from: com.pspdfkit.ui.PdfOutlineView$3, reason: invalid class name */
    public class AnonymousClass3 implements DocumentListener {
        public AnonymousClass3() {
        }

        static void lambda$onPageUpdated$1(int i, OutlinePagerAdapter outlinePagerAdapter) {
            f8 value;
            f8 f8Var;
            Set<Integer> set;
            i8 i8Var = outlinePagerAdapter.bookmarkListView.d;
            if (i8Var != null) {
                MutableStateFlow<f8> mutableStateFlow = i8Var.d;
                do {
                    value = mutableStateFlow.getValue();
                    f8Var = value;
                    set = f8Var.i;
                    set.add(Integer.valueOf(i));
                    Unit unit = Unit.INSTANCE;
                } while (!mutableStateFlow.compareAndSet(value, f8.a(f8Var, null, null, 0, null, false, false, false, false, set, false, null, false, false, null, false, false, 65279)));
            }
        }

        @Override // com.pspdfkit.listeners.DocumentListener
        public void onPageChanged(PdfDocument pdfDocument, final int i) {
            pn pnVar = PdfOutlineView.this.pagerAdapter;
            pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$3$$ExternalSyntheticLambda0
                @Override // com.pspdfkit.internal.pn.a
                public final void apply(Object obj) {
                    ((PdfOutlineView.OutlinePagerAdapter) obj).bookmarkListView.setCurrentPageIndex(i);
                }
            };
            tv.a(pnVar, aVar, aVar, false);
        }

        @Override // com.pspdfkit.listeners.DocumentListener
        public void onPageUpdated(PdfDocument pdfDocument, final int i) {
            pn pnVar = PdfOutlineView.this.pagerAdapter;
            pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$3$$ExternalSyntheticLambda1
                @Override // com.pspdfkit.internal.pn.a
                public final void apply(Object obj) {
                    PdfOutlineView.AnonymousClass3.lambda$onPageUpdated$1(i, (PdfOutlineView.OutlinePagerAdapter) obj);
                }
            };
            tv.a(pnVar, aVar, aVar, false);
        }
    }

    public interface DocumentOutlineProvider {
        Single<List<OutlineElement>> getOutlineElements();
    }

    public interface OnAnnotationTapListener {
        void onAnnotationTap(PdfOutlineView pdfOutlineView, Annotation annotation);
    }

    public interface OnEmbeddedFileTapListener {
        void onEmbeddedFileTap(PdfOutlineView pdfOutlineView, EmbeddedFile embeddedFile);
    }

    public interface OnOutlineElementTapListener {
        void onOutlineElementTap(PdfOutlineView pdfOutlineView, OutlineElement outlineElement);
    }

    public final class OutlinePagerAdapter extends ViewStatePagerAdapter implements ViewPager.OnPageChangeListener {
        private static final int MAX_NUMBER_OF_ITEMS = 5;
        private final z2 annotationListView;
        private final h8 bookmarkListView;
        private PdfDocument document;
        private final qd documentInfoListView;
        private final yf embeddedFilesListView;
        private final List<nt<?>> items;
        private final mt outlineListView;
        private final List<nt<?>> visibleItems;

        public OutlinePagerAdapter(at atVar) {
            super(5);
            ArrayList arrayList = new ArrayList(5);
            this.items = arrayList;
            this.visibleItems = new ArrayList(5);
            PdfOutlineView.this.pager.addOnPageChangeListener(this);
            mt mtVar = new mt(PdfOutlineView.this.getContext(), new nt.b() { // from class: com.pspdfkit.ui.PdfOutlineView$OutlinePagerAdapter$$ExternalSyntheticLambda0
                @Override // com.pspdfkit.internal.nt.b
                public final void a(nt ntVar, Object obj) {
                    this.f$0.lambda$new$0(ntVar, (OutlineElement) obj);
                }
            });
            this.outlineListView = mtVar;
            z2 z2Var = new z2(PdfOutlineView.this.getContext(), new nt.b() { // from class: com.pspdfkit.ui.PdfOutlineView$OutlinePagerAdapter$$ExternalSyntheticLambda1
                @Override // com.pspdfkit.internal.nt.b
                public final void a(nt ntVar, Object obj) {
                    this.f$0.lambda$new$1(ntVar, (Annotation) obj);
                }
            }, atVar, PdfOutlineView.this.viewModelStoreOwner);
            this.annotationListView = z2Var;
            yf yfVar = new yf(PdfOutlineView.this.getContext(), new nt.b() { // from class: com.pspdfkit.ui.PdfOutlineView$OutlinePagerAdapter$$ExternalSyntheticLambda2
                @Override // com.pspdfkit.internal.nt.b
                public final void a(nt ntVar, Object obj) {
                    this.f$0.lambda$new$2(ntVar, (EmbeddedFile) obj);
                }
            }, PdfOutlineView.this.viewModelStoreOwner);
            this.embeddedFilesListView = yfVar;
            h8 h8Var = new h8(PdfOutlineView.this.getContext(), PdfOutlineView.this.viewModelStoreOwner);
            this.bookmarkListView = h8Var;
            qd qdVarCreateDocumentInfoListView = PdfOutlineView.this.createDocumentInfoListView(PdfOutlineView.this.getContext());
            this.documentInfoListView = qdVarCreateDocumentInfoListView;
            arrayList.add(mtVar);
            arrayList.add(h8Var);
            arrayList.add(z2Var);
            arrayList.add(yfVar);
            if (qdVarCreateDocumentInfoListView != null) {
                arrayList.add(qdVarCreateDocumentInfoListView);
            }
            refreshItemsVisibility();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void applyTheme(ot otVar) {
            Iterator<nt<?>> it = this.items.iterator();
            while (it.hasNext()) {
                it.next().a(otVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(nt ntVar, OutlineElement outlineElement) {
            PdfOutlineView pdfOutlineView = PdfOutlineView.this;
            OnOutlineElementTapListener onOutlineElementTapListener = pdfOutlineView.onOutlineElementTapListener;
            if (onOutlineElementTapListener != null) {
                onOutlineElementTapListener.onOutlineElementTap(pdfOutlineView, outlineElement);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(nt ntVar, Annotation annotation) {
            PdfOutlineView pdfOutlineView = PdfOutlineView.this;
            OnAnnotationTapListener onAnnotationTapListener = pdfOutlineView.onAnnotationTapListener;
            if (onAnnotationTapListener != null) {
                onAnnotationTapListener.onAnnotationTap(pdfOutlineView, annotation);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2(nt ntVar, EmbeddedFile embeddedFile) {
            PdfOutlineView pdfOutlineView = PdfOutlineView.this;
            OnEmbeddedFileTapListener onEmbeddedFileTapListener = pdfOutlineView.onEmbeddedFileTapListener;
            if (onEmbeddedFileTapListener != null) {
                onEmbeddedFileTapListener.onEmbeddedFileTap(pdfOutlineView, embeddedFile);
            }
        }

        private void notifyDataSetChangedRetainingCurrentItem() {
            ViewPager viewPager = PdfOutlineView.this.pager;
            if (viewPager == null || viewPager.getCurrentItem() >= this.visibleItems.size()) {
                notifyDataSetChanged();
                return;
            }
            int itemTabButtonId = getItemTabButtonId(PdfOutlineView.this.pager.getCurrentItem());
            notifyDataSetChanged();
            for (int i = 0; i < getCount(); i++) {
                if (this.visibleItems.get(i).getTabButtonId() == itemTabButtonId) {
                    PdfOutlineView.this.pager.setCurrentItem(i);
                    if (i == PdfOutlineView.this.pager.getCurrentItem()) {
                        onPageSelected(i);
                        return;
                    }
                    return;
                }
            }
        }

        @Override // com.pspdfkit.ui.ViewStatePagerAdapter
        public View createView(ViewGroup viewGroup, int i) {
            nt<?> ntVar = this.visibleItems.get(i);
            viewGroup.removeView(ntVar);
            return ntVar;
        }

        @Override // com.pspdfkit.ui.ViewStatePagerAdapter
        public void destroyView(ViewGroup viewGroup, int i, View view) {
            if (viewGroup instanceof nt) {
                viewGroup.removeView(viewGroup);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.visibleItems.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            if ((obj instanceof nt) && this.visibleItems.contains(obj)) {
                return this.visibleItems.indexOf(obj);
            }
            return -2;
        }

        public int getItemTabButtonId(int i) {
            return this.visibleItems.get(i).getTabButtonId();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            return this.visibleItems.get(i).getTitle();
        }

        public int getPositionOfItemWithTabButtonId(int i) {
            for (nt<?> ntVar : this.visibleItems) {
                if (ntVar.getTabButtonId() == i) {
                    return this.visibleItems.indexOf(ntVar);
                }
            }
            return -1;
        }

        public boolean isDocumentInfoListViewAvailable() {
            return this.documentInfoListView != null;
        }

        public boolean isOutlineListViewAvailable() {
            PdfDocument pdfDocument;
            return this.outlineListView.getDocumentOutlineProvider() != null || (pdfDocument = this.document) == null || pdfDocument.hasOutline();
        }

        public void onHide() {
            Iterator<nt<?>> it = this.visibleItems.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            int i2 = 0;
            while (i2 < this.visibleItems.size()) {
                this.visibleItems.get(i2).setPageSelected(i == i2);
                i2++;
            }
        }

        public void onShow() {
            Iterator<nt<?>> it = this.visibleItems.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        public void refreshItemsVisibility() {
            if (PdfOutlineView.this.isDestroyed()) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.visibleItems.size());
            if (PdfOutlineView.this.shouldDisplayOutlineView()) {
                arrayList.add(this.outlineListView);
            }
            if (PdfOutlineView.this.shouldDisplayBookmarkListView()) {
                arrayList.add(this.bookmarkListView);
            }
            if (PdfOutlineView.this.shouldDisplayAnnotationListView()) {
                arrayList.add(this.annotationListView);
            }
            if (PdfOutlineView.this.shouldDisplayDocumentInfoListView()) {
                arrayList.add(this.documentInfoListView);
            }
            if (PdfOutlineView.this.shouldDisplayEmbeddedFilesView()) {
                arrayList.add(this.embeddedFilesListView);
            }
            if (!this.visibleItems.equals(arrayList)) {
                this.visibleItems.clear();
                this.visibleItems.addAll(arrayList);
                notifyDataSetChangedRetainingCurrentItem();
            }
            PdfOutlineView pdfOutlineView = PdfOutlineView.this;
            if (pdfOutlineView.isDisplayed) {
                pdfOutlineView.pagerTabs.a();
            }
        }

        public void setDocument(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration, nt.a aVar) {
            uw.a(aVar, "onHideListener", null);
            this.document = pdfDocument;
            for (nt<?> ntVar : this.items) {
                ntVar.a((lm) pdfDocument, pdfConfiguration);
                ntVar.setOnHideListener(aVar);
            }
        }
    }

    public PdfOutlineView(Context context) {
        super(context);
        this.listeners = new OnVisibilityChangedListenerManager();
        this.mayContainDocumentInfoView = true;
        this.displayOutlineView = true;
        this.displayEmbeddedFilesView = true;
        this.displayAnnotationListView = true;
        this.displayBookmarkListView = true;
        this.displayInfoListView = false;
        this.pagerAdapter = new pn<>();
        this.onLayoutChangeListener = null;
        this.documentListener = new AnonymousClass3();
        this.viewModelStoreOwner = null;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public qd createDocumentInfoListView(Context context) {
        if (this.mayContainDocumentInfoView) {
            return new qd(context, this.viewModelStoreOwner);
        }
        return null;
    }

    private void init() {
        this.themeConfiguration = new ot(getContext());
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.ui.PdfOutlineView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PdfOutlineView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                PdfOutlineView pdfOutlineView = PdfOutlineView.this;
                pdfOutlineView.setTranslationY(-pdfOutlineView.getHeight());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDestroyed() {
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(this);
        return lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycleRegistry()) == null || lifecycle.getState() == Lifecycle.State.DESTROYED;
    }

    static void lambda$addOnDocumentInfoViewModeChangeListener$13(OnDocumentInfoViewModeChangeListener onDocumentInfoViewModeChangeListener, OutlinePagerAdapter outlinePagerAdapter) {
        qd qdVar = outlinePagerAdapter.documentInfoListView;
        if (qdVar != null) {
            qdVar.getClass();
            onDocumentInfoViewModeChangeListener.getClass();
            qdVar.e.a(onDocumentInfoViewModeChangeListener);
            ud udVar = qdVar.d;
            udVar.getClass();
            udVar.f.a(onDocumentInfoViewModeChangeListener);
        }
    }

    static void lambda$addOnDocumentInfoViewSaveListener$15(OnDocumentInfoViewSaveListener onDocumentInfoViewSaveListener, OutlinePagerAdapter outlinePagerAdapter) {
        qd qdVar = outlinePagerAdapter.documentInfoListView;
        if (qdVar != null) {
            qdVar.getClass();
            onDocumentInfoViewSaveListener.getClass();
            qdVar.f.a(onDocumentInfoViewSaveListener);
            ud udVar = qdVar.d;
            udVar.getClass();
            udVar.g.a(onDocumentInfoViewSaveListener);
        }
    }

    static void lambda$removeOnDocumentInfoViewModeChangeListener$14(OnDocumentInfoViewModeChangeListener onDocumentInfoViewModeChangeListener, OutlinePagerAdapter outlinePagerAdapter) {
        qd qdVar = outlinePagerAdapter.documentInfoListView;
        if (qdVar != null) {
            qdVar.getClass();
            onDocumentInfoViewModeChangeListener.getClass();
            qdVar.e.b(onDocumentInfoViewModeChangeListener);
            ud udVar = qdVar.d;
            udVar.getClass();
            udVar.f.b(onDocumentInfoViewModeChangeListener);
        }
    }

    static void lambda$removeOnDocumentInfoViewSaveListener$16(OnDocumentInfoViewSaveListener onDocumentInfoViewSaveListener, OutlinePagerAdapter outlinePagerAdapter) {
        qd qdVar = outlinePagerAdapter.documentInfoListView;
        if (qdVar != null) {
            qdVar.getClass();
            onDocumentInfoViewSaveListener.getClass();
            qdVar.f.b(onDocumentInfoViewSaveListener);
            ud udVar = qdVar.d;
            udVar.getClass();
            udVar.g.b(onDocumentInfoViewSaveListener);
        }
    }

    static /* synthetic */ void lambda$setBookmarkAdapter$9(BookmarkViewAdapter bookmarkViewAdapter, OutlinePagerAdapter outlinePagerAdapter) {
        outlinePagerAdapter.bookmarkListView.setBookmarkViewAdapter(bookmarkViewAdapter);
        outlinePagerAdapter.refreshItemsVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDocument$2(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration, OutlinePagerAdapter outlinePagerAdapter) {
        outlinePagerAdapter.setDocument(pdfDocument, pdfConfiguration, this);
        refreshViewPager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDocumentOutlineProvider$3(DocumentOutlineProvider documentOutlineProvider, OutlinePagerAdapter outlinePagerAdapter) {
        outlinePagerAdapter.outlineListView.setDocumentOutlineProvider(documentOutlineProvider);
        refreshViewPager();
    }

    static /* synthetic */ void lambda$setShowPageLabels$10(boolean z, OutlinePagerAdapter outlinePagerAdapter) {
        outlinePagerAdapter.outlineListView.setShowPageLabels(z);
        outlinePagerAdapter.bookmarkListView.setShowPageLabels(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupLayoutChangeListener$0(FrameLayout.LayoutParams layoutParams) {
        setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupLayoutChangeListener$1(View view, View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int width;
        int i9 = this.themeConfiguration.K;
        if (i9 <= 0 || ((width = view.getWidth()) >= 0 && width < i9)) {
            i9 = -1;
        }
        final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i9, -1);
        layoutParams.gravity = GravityCompat.END;
        if (getLayoutParams().width != layoutParams.width) {
            post(new Runnable() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setupLayoutChangeListener$0(layoutParams);
                }
            });
        }
    }

    private void setupLayoutChangeListener() {
        final View view = (View) getParent();
        if (view == null) {
            return;
        }
        View.OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
        if (onLayoutChangeListener != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
        View.OnLayoutChangeListener onLayoutChangeListener2 = new View.OnLayoutChangeListener() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda19
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.lambda$setupLayoutChangeListener$1(view, view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        this.onLayoutChangeListener = onLayoutChangeListener2;
        view.addOnLayoutChangeListener(onLayoutChangeListener2);
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public void addDrawableProvider(final PdfDrawableProvider pdfDrawableProvider) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda9
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfOutlineView.OutlinePagerAdapter) obj).bookmarkListView.addDrawableProvider(pdfDrawableProvider);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void addOnDocumentInfoViewModeChangeListener(final OnDocumentInfoViewModeChangeListener onDocumentInfoViewModeChangeListener) {
        uw.a(onDocumentInfoViewModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                PdfOutlineView.lambda$addOnDocumentInfoViewModeChangeListener$13(onDocumentInfoViewModeChangeListener, (PdfOutlineView.OutlinePagerAdapter) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void addOnDocumentInfoViewSaveListener(final OnDocumentInfoViewSaveListener onDocumentInfoViewSaveListener) {
        uw.a(onDocumentInfoViewSaveListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda14
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                PdfOutlineView.lambda$addOnDocumentInfoViewSaveListener$15(onDocumentInfoViewSaveListener, (PdfOutlineView.OutlinePagerAdapter) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void addOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        uw.a(onVisibilityChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.listeners.addOnVisibilityChangedListener(onVisibilityChangedListener);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void clearDocument() {
        hide();
    }

    public OutlinePagerAdapter ensureInitialized() {
        boolean zB = this.pagerAdapter.b();
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        if (zB) {
            return pnVar.a();
        }
        OutlinePagerAdapter outlinePagerAdapter = pnVar.c;
        View viewInflate = View.inflate(getContext(), R.layout.pspdf__outline_view, this);
        int i = 0;
        getChildAt(0).setBackgroundColor(this.themeConfiguration.a);
        this.pager = (ViewPager) viewInflate.findViewById(R.id.pspdf__outline_pager);
        OutlinePagerAdapter outlinePagerAdapter2 = new OutlinePagerAdapter(this.onEditRecordedListener);
        outlinePagerAdapter2.applyTheme(this.themeConfiguration);
        this.pager.setAdapter(outlinePagerAdapter2);
        OutlinePagerTabView outlinePagerTabView = (OutlinePagerTabView) viewInflate.findViewById(R.id.pspdf__view_pager_tab_view);
        this.pagerTabs = outlinePagerTabView;
        ViewPager viewPager = this.pager;
        outlinePagerTabView.getClass();
        PagerAdapter adapter = viewPager.getAdapter();
        if (!(adapter instanceof OutlinePagerAdapter)) {
            throw new IllegalArgumentException("bindViewPager() was called with ViewPager that does not have an OutlinePagerAdapter set.");
        }
        outlinePagerTabView.c = (OutlinePagerAdapter) adapter;
        outlinePagerTabView.b = viewPager;
        viewPager.addOnPageChangeListener(outlinePagerTabView);
        adapter.registerDataSetObserver(new a(outlinePagerTabView));
        OutlinePagerTabView outlinePagerTabView2 = this.pagerTabs;
        ot otVar = this.themeConfiguration;
        outlinePagerTabView2.a.setBackgroundColor(otVar.E);
        ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{android.R.attr.state_checked}, new int[0]}, new int[]{otVar.D, otVar.C});
        outlinePagerTabView2.a.setItemIconTintList(colorStateList);
        outlinePagerTabView2.a.setItemTextColor(colorStateList);
        ArrayList arrayList = outlinePagerTabView2.d;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            MenuItem menuItem = (MenuItem) obj;
            if (menuItem.getItemId() == R.id.pspdf__menu_pdf_outline_view_outline) {
                menuItem.setIcon(otVar.x);
            } else if (menuItem.getItemId() == R.id.pspdf__menu_pdf_outline_view_bookmarks) {
                menuItem.setIcon(otVar.y);
            } else if (menuItem.getItemId() == R.id.pspdf__menu_pdf_outline_view_annotations) {
                menuItem.setIcon(otVar.z);
            } else if (menuItem.getItemId() == R.id.pspdf__menu_pdf_outline_view_document_info) {
                menuItem.setIcon(otVar.B);
            } else if (menuItem.getItemId() == R.id.pspdf__menu_pdf_outline_embedded_documents) {
                menuItem.setIcon(otVar.A);
            }
        }
        setupLayoutChangeListener();
        this.pagerAdapter.a(outlinePagerAdapter2);
        refreshViewPager();
        return outlinePagerAdapter2;
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        setPadding(rect.left, 0, rect.right, 0);
        return false;
    }

    public DocumentListener getDocumentListener() {
        return this.documentListener;
    }

    public boolean getMayContainDocumentInfoView() {
        return this.mayContainDocumentInfoView;
    }

    public PSPDFKitViews.Type getPSPDFViewType() {
        return PSPDFKitViews.Type.VIEW_OUTLINE;
    }

    @Override // com.pspdfkit.internal.nt.a, com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void hide() {
        if (this.isDisplayed) {
            this.isDisplayed = false;
            this.listeners.onHide(this);
            animate().translationY(-getHeight()).setInterpolator(new AccelerateInterpolator()).setListener(new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.PdfOutlineView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PdfOutlineView.this.isDisplayed) {
                        return;
                    }
                    super.onAnimationEnd(animator);
                    PdfOutlineView.this.setVisibility(4);
                }
            });
            if (this.pagerAdapter.b()) {
                this.pagerAdapter.a().onHide();
            }
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public boolean isDisplayed() {
        return this.isDisplayed;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.shadowHeightPx = tr.a(a80.a((View) this));
    }

    public void onDestroy() {
        setDocument(null, null);
        setOnAnnotationTapListener(null);
        setOnEmbeddedFileTapListener(null);
        setOnOutlineElementTapListener(null);
        setBookmarkAdapter(null);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + this.shadowHeightPx);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1 && motionEvent.getX() < getChildAt(0).getLeft()) {
            performClick();
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        hide();
        return true;
    }

    public void refreshViewPager() {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda12
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfOutlineView.OutlinePagerAdapter) obj).refreshItemsVisibility();
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public void removeDrawableProvider(final PdfDrawableProvider pdfDrawableProvider) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfOutlineView.OutlinePagerAdapter) obj).bookmarkListView.removeDrawableProvider(pdfDrawableProvider);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void removeOnDocumentInfoViewModeChangeListener(final OnDocumentInfoViewModeChangeListener onDocumentInfoViewModeChangeListener) {
        uw.a(onDocumentInfoViewModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda16
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                PdfOutlineView.lambda$removeOnDocumentInfoViewModeChangeListener$14(onDocumentInfoViewModeChangeListener, (PdfOutlineView.OutlinePagerAdapter) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void removeOnDocumentInfoViewSaveListener(final OnDocumentInfoViewSaveListener onDocumentInfoViewSaveListener) {
        uw.a(onDocumentInfoViewSaveListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda17
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                PdfOutlineView.lambda$removeOnDocumentInfoViewSaveListener$16(onDocumentInfoViewSaveListener, (PdfOutlineView.OutlinePagerAdapter) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void removeOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        uw.a(onVisibilityChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.listeners.removeOnVisibilityChangedListener(onVisibilityChangedListener);
    }

    public void setAnnotationEditingEnabled(final boolean z) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda6
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfOutlineView.OutlinePagerAdapter) obj).annotationListView.setAnnotationEditingEnabled(z);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setAnnotationListReorderingEnabled(final boolean z) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda7
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfOutlineView.OutlinePagerAdapter) obj).annotationListView.setAnnotationListReorderingEnabled(z);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setAnnotationListViewEnabled(boolean z) {
        setAnnotationListViewEnabled(z, true);
    }

    public void setBookmarkAdapter(final BookmarkViewAdapter bookmarkViewAdapter) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda2
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                PdfOutlineView.lambda$setBookmarkAdapter$9(bookmarkViewAdapter, (PdfOutlineView.OutlinePagerAdapter) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setBookmarkAddingEnabled(final boolean z) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda15
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfOutlineView.OutlinePagerAdapter) obj).bookmarkListView.setBookmarkAddingEnabled(z);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setBookmarkEditingEnabled(final boolean z) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda5
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfOutlineView.OutlinePagerAdapter) obj).bookmarkListView.setBookmarkEditingEnabled(z);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setBookmarkRenamingEnabled(final boolean z) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfOutlineView.OutlinePagerAdapter) obj).bookmarkListView.setBookmarkRenamingEnabled(z);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setBookmarkViewEnabled(boolean z) {
        setBookmarkViewEnabled(z, true);
    }

    public void setDisplayEmbeddedFilesViewEnabled(boolean z) {
        this.displayEmbeddedFilesView = z;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void setDocument(final PdfDocument pdfDocument, final PdfConfiguration pdfConfiguration) {
        if (pdfDocument != null) {
            uw.a(pdfConfiguration, "configuration", null);
        }
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda8
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                this.f$0.lambda$setDocument$2(pdfDocument, pdfConfiguration, (PdfOutlineView.OutlinePagerAdapter) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setDocumentInfoViewEnabled(boolean z) {
        setDocumentInfoViewEnabled(z, true);
    }

    public void setDocumentOutlineProvider(final DocumentOutlineProvider documentOutlineProvider) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda10
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                this.f$0.lambda$setDocumentOutlineProvider$3(documentOutlineProvider, (PdfOutlineView.OutlinePagerAdapter) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setListedAnnotationTypes(final EnumSet<AnnotationType> enumSet) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda13
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfOutlineView.OutlinePagerAdapter) obj).annotationListView.setListedAnnotationTypes(enumSet);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setMayContainDocumentInfoView(boolean z) {
        this.mayContainDocumentInfoView = z;
    }

    public void setOnAnnotationTapListener(OnAnnotationTapListener onAnnotationTapListener) {
        this.onAnnotationTapListener = onAnnotationTapListener;
    }

    public void setOnEmbeddedFileTapListener(OnEmbeddedFileTapListener onEmbeddedFileTapListener) {
        this.onEmbeddedFileTapListener = onEmbeddedFileTapListener;
    }

    public void setOnOutlineElementTapListener(OnOutlineElementTapListener onOutlineElementTapListener) {
        this.onOutlineElementTapListener = onOutlineElementTapListener;
    }

    public void setOutlinePagerTabView(OutlinePagerTabView outlinePagerTabView) {
        this.pagerTabs = outlinePagerTabView;
    }

    public void setOutlineViewEnabled(boolean z) {
        setOutlineViewEnabled(z, true);
    }

    public void setRedactionAnnotationPreviewEnabled(final boolean z) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda11
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                ((PdfOutlineView.OutlinePagerAdapter) obj).bookmarkListView.setRedactionAnnotationPreviewEnabled(z);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setShowPageLabels(final boolean z) {
        pn<OutlinePagerAdapter> pnVar = this.pagerAdapter;
        pn.a aVar = new pn.a() { // from class: com.pspdfkit.ui.PdfOutlineView$$ExternalSyntheticLambda18
            @Override // com.pspdfkit.internal.pn.a
            public final void apply(Object obj) {
                PdfOutlineView.lambda$setShowPageLabels$10(z, (PdfOutlineView.OutlinePagerAdapter) obj);
            }
        };
        tv.a(pnVar, aVar, aVar, false);
    }

    public void setUndoManager(UndoManager undoManager) {
        if (undoManager instanceof at) {
            this.onEditRecordedListener = (at) undoManager;
        }
    }

    public void setViewModelStoreOwner(ViewModelStoreOwner viewModelStoreOwner) {
        this.viewModelStoreOwner = viewModelStoreOwner;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 0) {
            ensureInitialized();
        }
        super.setVisibility(i);
    }

    public boolean shouldDisplayAnnotationListView() {
        return this.displayAnnotationListView;
    }

    public boolean shouldDisplayBookmarkListView() {
        return this.displayBookmarkListView;
    }

    public boolean shouldDisplayDocumentInfoListView() {
        OutlinePagerAdapter outlinePagerAdapter = this.pagerAdapter.c;
        return this.displayInfoListView && outlinePagerAdapter != null && outlinePagerAdapter.isDocumentInfoListViewAvailable();
    }

    public boolean shouldDisplayEmbeddedFilesView() {
        return this.displayEmbeddedFilesView && this.pagerAdapter.c != null;
    }

    public boolean shouldDisplayOutlineView() {
        OutlinePagerAdapter outlinePagerAdapter = this.pagerAdapter.c;
        return this.displayOutlineView && outlinePagerAdapter != null && outlinePagerAdapter.isOutlineListViewAvailable();
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void show() {
        if (this.isDisplayed) {
            return;
        }
        OutlinePagerAdapter outlinePagerAdapterEnsureInitialized = ensureInitialized();
        this.isDisplayed = true;
        this.listeners.onShow(this);
        setVisibility(0);
        animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).setListener(null);
        outlinePagerAdapterEnsureInitialized.onShow();
        this.pagerTabs.a();
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        i0VarA.b.onNext(new Pair<>(Analytics.Event.OPEN_OUTLINE_VIEW, new Bundle()));
    }

    public void setAnnotationListViewEnabled(boolean z, boolean z2) {
        this.displayAnnotationListView = z;
        if (z2) {
            refreshViewPager();
        }
    }

    public void setBookmarkViewEnabled(boolean z, boolean z2) {
        this.displayBookmarkListView = z;
        if (z2) {
            refreshViewPager();
        }
    }

    public void setDocumentInfoViewEnabled(boolean z, boolean z2) {
        if (getMayContainDocumentInfoView()) {
            this.displayInfoListView = z;
        } else {
            this.displayInfoListView = false;
        }
        if (z2) {
            refreshViewPager();
        }
    }

    public void setOutlineViewEnabled(boolean z, boolean z2) {
        this.displayOutlineView = z;
        if (z2) {
            refreshViewPager();
        }
    }

    public PdfOutlineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.listeners = new OnVisibilityChangedListenerManager();
        this.mayContainDocumentInfoView = true;
        this.displayOutlineView = true;
        this.displayEmbeddedFilesView = true;
        this.displayAnnotationListView = true;
        this.displayBookmarkListView = true;
        this.displayInfoListView = false;
        this.pagerAdapter = new pn<>();
        this.onLayoutChangeListener = null;
        this.documentListener = new AnonymousClass3();
        this.viewModelStoreOwner = null;
        init();
    }

    public PdfOutlineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.listeners = new OnVisibilityChangedListenerManager();
        this.mayContainDocumentInfoView = true;
        this.displayOutlineView = true;
        this.displayEmbeddedFilesView = true;
        this.displayAnnotationListView = true;
        this.displayBookmarkListView = true;
        this.displayInfoListView = false;
        this.pagerAdapter = new pn<>();
        this.onLayoutChangeListener = null;
        this.documentListener = new AnonymousClass3();
        this.viewModelStoreOwner = null;
        init();
    }

    public PdfOutlineView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.listeners = new OnVisibilityChangedListenerManager();
        this.mayContainDocumentInfoView = true;
        this.displayOutlineView = true;
        this.displayEmbeddedFilesView = true;
        this.displayAnnotationListView = true;
        this.displayBookmarkListView = true;
        this.displayInfoListView = false;
        this.pagerAdapter = new pn<>();
        this.onLayoutChangeListener = null;
        this.documentListener = new AnonymousClass3();
        this.viewModelStoreOwner = null;
        init();
    }
}
