package com.pspdfkit.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.microsoft.intune.mam.client.widget.MAMRelativeLayout;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.editor.FilePicker;
import com.pspdfkit.document.editor.PdfDocumentEditor;
import com.pspdfkit.document.editor.PdfDocumentEditorFactory;
import com.pspdfkit.document.editor.page.DialogNewPageFactory;
import com.pspdfkit.document.editor.page.NewPageDialog;
import com.pspdfkit.document.editor.page.NewPageFactory;
import com.pspdfkit.document.editor.page.ValueNewPageFactory;
import com.pspdfkit.document.processor.NewPage;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.bt;
import com.pspdfkit.internal.fd;
import com.pspdfkit.internal.fi;
import com.pspdfkit.internal.gd;
import com.pspdfkit.internal.hd;
import com.pspdfkit.internal.hu;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.jni.NativeDocumentEditor;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.l0;
import com.pspdfkit.internal.l60;
import com.pspdfkit.internal.lc;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.mz;
import com.pspdfkit.internal.n60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView;
import com.pspdfkit.internal.views.document.editor.a;
import com.pspdfkit.internal.views.document.editor.b;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.listeners.OnVisibilityChangedListenerManager;
import com.pspdfkit.ui.drawable.PdfDrawableManager;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import com.pspdfkit.ui.special_mode.manager.DocumentEditingManager;
import com.pspdfkit.ui.toolbar.DocumentEditingToolbar;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class PdfThumbnailGrid extends MAMRelativeLayout implements PSPDFKitViews.PSPDFView, DocumentListener, PdfDrawableManager, bt {
    private static final String RETAINED_STATE_FRAGMENT_TAG = "com.pspdfkit.ui.PSPDFThumbnailGrid.RETAINED_STATE_FRAGMENT";
    private static final long SHOW_ANIMATION_DURATION_MS = 100;
    private int backgroundColor;
    private PdfConfiguration configuration;
    private PdfDocument document;
    final AtomicBoolean documentEditModeActive;
    private final fd documentEditingManager;
    private gd documentEditor;
    private boolean documentEditorEnabled;
    private hd documentEditorSavingToolbarHandler;
    private final hu<PdfDrawableProvider> drawableProviderCollection;
    private Boolean exportEnabled;
    private Drawable fabAddIcon;
    private Drawable fabEditIcon;
    private int fabIconColor;
    private FilePicker filePicker;
    private FloatingActionButton floatingActionButton;
    private int highlightedPageIndex;
    private boolean isDisplayed;
    private boolean isRedactionAnnotationPreviewEnabled;
    private int itemLabelBackgroundDrawableRes;
    private int itemLabelTextStyle;
    private NewPageFactory newPageFactory;
    private final List<OnDocumentSavedListener> onDocumentSavedListeners;
    private final List<OnPageClickListener> onPageClickListeners;
    private ThumbnailGridRecyclerView recyclerView;
    private mz retainedDocumentEditorHolder;
    private NativeDocumentEditor retainedNativeDocumentEditor;
    private Boolean saveAsEnabled;
    private boolean showPageLabels;
    private final OnVisibilityChangedListenerManager thumbnailGridVisibilityListeners;

    public interface OnDocumentSavedListener {
        void onDocumentExported(Uri uri);

        void onDocumentSaved();
    }

    public interface OnPageClickListener {
        void onPageClick(PdfThumbnailGrid pdfThumbnailGrid, int i);
    }

    public class RecyclerViewListener implements ThumbnailGridRecyclerView.a {
        private RecyclerViewListener() {
        }

        @Override // com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView.a
        public void onPageClick(int i) {
            synchronized (PdfThumbnailGrid.this.onPageClickListeners) {
                if (!PdfThumbnailGrid.this.onPageClickListeners.isEmpty()) {
                    Iterator it = PdfThumbnailGrid.this.onPageClickListeners.iterator();
                    while (it.hasNext()) {
                        ((OnPageClickListener) it.next()).onPageClick(PdfThumbnailGrid.this, i);
                    }
                }
            }
        }

        @Override // com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView.a
        public void onPageLongClick(int i) {
            if (PdfThumbnailGrid.this.documentEditModeActive.get()) {
                return;
            }
            PdfThumbnailGrid pdfThumbnailGrid = PdfThumbnailGrid.this;
            if (pdfThumbnailGrid.documentEditorEnabled) {
                pdfThumbnailGrid.enterDocumentEditingMode();
                PdfThumbnailGrid.this.recyclerView.c.a(i);
            }
        }

        @Override // com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView.a
        public void onPageMoved(int i, int i2) {
            if (PdfThumbnailGrid.this.documentEditor == null) {
                throw new AssertionError("Document Editor cannot be null.");
            }
            if (i < 0 || i2 < 0) {
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(i));
            PdfThumbnailGrid.this.documentEditor.movePages(hashSet, i2).blockingGet();
        }

        @Override // com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView.a
        public void onPageSelectionStateChanged() {
            PdfThumbnailGrid pdfThumbnailGrid = PdfThumbnailGrid.this;
            hd hdVar = pdfThumbnailGrid.documentEditorSavingToolbarHandler;
            if (pdfThumbnailGrid.documentEditorEnabled && pdfThumbnailGrid.documentEditModeActive.get() && hdVar != null) {
                PdfThumbnailGrid.this.notifyDocumentEditingPageSelectionChanged(hdVar);
            }
        }

        @Override // com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView.a
        public void onStartDraggingPages() {
            PdfThumbnailGrid.this.animateHideFab();
        }

        @Override // com.pspdfkit.internal.views.document.editor.ThumbnailGridRecyclerView.a
        public void onStopDraggingPages() {
            PdfThumbnailGrid.this.animateShowFab();
            PdfThumbnailGrid pdfThumbnailGrid = PdfThumbnailGrid.this;
            hd hdVar = pdfThumbnailGrid.documentEditorSavingToolbarHandler;
            if (pdfThumbnailGrid.documentEditorEnabled && pdfThumbnailGrid.documentEditModeActive.get() && hdVar != null) {
                PdfThumbnailGrid.this.notifyDocumentEditingPageSelectionChanged(hdVar);
            }
        }
    }

    public PdfThumbnailGrid(Context context) {
        super(context);
        this.saveAsEnabled = null;
        this.exportEnabled = null;
        this.documentEditModeActive = new AtomicBoolean(false);
        this.thumbnailGridVisibilityListeners = new OnVisibilityChangedListenerManager();
        this.documentEditingManager = new fd();
        this.drawableProviderCollection = new hu<>(Schedulers.computation());
        this.onPageClickListeners = Collections.synchronizedList(new ArrayList());
        this.onDocumentSavedListeners = Collections.synchronizedList(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateHideFab() {
        this.floatingActionButton.animate().translationY(this.floatingActionButton.getHeight() + ((ViewGroup.MarginLayoutParams) this.floatingActionButton.getLayoutParams()).bottomMargin).setInterpolator(new AnticipateInterpolator(2.0f)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateShowFab() {
        this.floatingActionButton.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator(2.0f)).start();
    }

    private void applyTheme() {
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.recyclerView;
        if (thumbnailGridRecyclerView != null) {
            thumbnailGridRecyclerView.setBackgroundColor(this.backgroundColor);
            this.recyclerView.setItemLabelTextStyle(this.itemLabelTextStyle);
            this.recyclerView.setItemLabelBackground(this.itemLabelBackgroundDrawableRes);
        }
    }

    private NewPageFactory createDefaultNewPageFactory() {
        gd gdVar;
        FragmentManager fragmentManagerB = a80.b(getContext());
        if (fragmentManagerB == null || (gdVar = this.documentEditor) == null) {
            return new ValueNewPageFactory(NewPage.emptyPage(NewPage.PAGE_SIZE_A4).build());
        }
        this.newPageFactory = new DialogNewPageFactory(fragmentManagerB, gdVar.a(true).getPageCount() > 0 ? this.documentEditor.getRotatedPageSize(0) : null);
        NewPageDialog.restore(fragmentManagerB, getDefaultNewPageDialogCallback());
        return this.newPageFactory;
    }

    private NewPageFactory ensureNewPageFactory() {
        if (this.newPageFactory == null) {
            this.newPageFactory = createDefaultNewPageFactory();
        }
        return this.newPageFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public hd getOrCreateDocumentEditorSavingToolbarHandler() {
        gd gdVar;
        ThumbnailGridRecyclerView thumbnailGridRecyclerView;
        if (!ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            throw new InvalidNutrientLicenseException("Your current license does not allow editing of PDF documents.");
        }
        if (this.documentEditorSavingToolbarHandler == null && (gdVar = this.documentEditor) != null && (thumbnailGridRecyclerView = this.recyclerView) != null) {
            hd hdVar = new hd(this, gdVar, this, thumbnailGridRecyclerView);
            this.documentEditorSavingToolbarHandler = hdVar;
            Boolean bool = this.saveAsEnabled;
            if (bool != null) {
                hdVar.e = bool.booleanValue();
            }
            Boolean bool2 = this.exportEnabled;
            if (bool2 != null) {
                this.documentEditorSavingToolbarHandler.f = bool2.booleanValue();
            }
        }
        return this.documentEditorSavingToolbarHandler;
    }

    private void invalidateFab() {
        if (this.floatingActionButton != null) {
            this.floatingActionButton.setImageDrawable(this.documentEditModeActive.get() ? this.fabAddIcon : this.fabEditIcon);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$prepareForDisplay$0(View view) {
        if (!this.documentEditModeActive.get()) {
            enterDocumentEditingMode();
            return;
        }
        hd orCreateDocumentEditorSavingToolbarHandler = getOrCreateDocumentEditorSavingToolbarHandler();
        if (!this.documentEditorEnabled || orCreateDocumentEditorSavingToolbarHandler == null) {
            return;
        }
        ensureNewPageFactory().onCreateNewPage(orCreateDocumentEditorSavingToolbarHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateViewState$1(List list) throws Throwable {
        this.recyclerView.setDrawableProviders(list);
    }

    private void notifyDocumentEditingModeEntered(hd hdVar) {
        this.documentEditingManager.onEnterDocumentEditingMode(hdVar);
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        i0VarA.a(Analytics.Event.OPEN_DOCUMENT_EDITOR, new Bundle());
    }

    private void notifyDocumentEditingModeExited(hd hdVar) {
        this.documentEditingManager.onExitDocumentEditingMode(hdVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDocumentEditingPageSelectionChanged(hd hdVar) {
        this.documentEditingManager.onDocumentEditingPageSelectionChanged(hdVar);
    }

    private void prepareForDisplay() {
        PdfConfiguration pdfConfiguration;
        if (this.recyclerView != null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, R.styleable.pspdf__ThumbnailGrid, R.attr.pspdf__thumbnailGridStyle, R.style.PSPDFKit_ThumbnailGrid);
        this.backgroundColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ThumbnailGrid_pspdf__backgroundColor, ContextCompat.getColor(getContext(), R.color.pspdf__surfaceDimLight));
        this.itemLabelTextStyle = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__ThumbnailGrid_pspdf__itemLabelTextStyle, R.style.PSPDFKit_ThumbnailGridItemLabelDefStyle);
        this.itemLabelBackgroundDrawableRes = typedArrayObtainStyledAttributes.getResourceId(R.styleable.pspdf__ThumbnailGrid_pspdf__itemLabelBackground, R.drawable.pspdf__grid_list_label_background);
        this.fabIconColor = typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__ThumbnailGrid_pspdf_fabIconColor, ContextCompat.getColor(getContext(), R.color.pspdf__onPrimaryLight));
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.pspdf__thumbnail_grid_view, this);
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = (ThumbnailGridRecyclerView) findViewById(R.id.pspdf__thumbnail_grid_recycler_view);
        this.recyclerView = thumbnailGridRecyclerView;
        thumbnailGridRecyclerView.setThumbnailGridListener(new RecyclerViewListener());
        this.floatingActionButton = (FloatingActionButton) findViewById(R.id.pspdf__fab);
        this.fabEditIcon = a80.a(getContext(), R.drawable.pspdf__ic_edit, this.fabIconColor);
        this.fabAddIcon = a80.a(getContext(), R.drawable.pspdf__ic_add, this.fabIconColor);
        this.floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.PdfThumbnailGrid$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$prepareForDisplay$0(view);
            }
        });
        applyTheme();
        subscribeForCustomDrawableUpdates();
        PdfDocument pdfDocument = this.document;
        if (pdfDocument != null && (pdfConfiguration = this.configuration) != null) {
            setDocument(pdfDocument, pdfConfiguration);
        }
        this.recyclerView.setHighlightedItem(this.highlightedPageIndex);
        this.recyclerView.setRedactionAnnotationPreviewEnabled(this.isRedactionAnnotationPreviewEnabled);
    }

    private hd requireDocumentEditorSavingToolbarHandler() {
        hd orCreateDocumentEditorSavingToolbarHandler = getOrCreateDocumentEditorSavingToolbarHandler();
        if (orCreateDocumentEditorSavingToolbarHandler != null) {
            return orCreateDocumentEditorSavingToolbarHandler;
        }
        throw new AssertionError("Document editor toolbar handler is not ready.");
    }

    private void restoreDocumentEditingMode(NativeDocumentEditor nativeDocumentEditor) {
        RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition;
        uw.a(nativeDocumentEditor, "retainedNativeDocumentEditor", null);
        if (!this.documentEditorEnabled || this.documentEditor == null) {
            return;
        }
        hd hdVarRequireDocumentEditorSavingToolbarHandler = requireDocumentEditorSavingToolbarHandler();
        if (!this.documentEditModeActive.getAndSet(true)) {
            invalidateFab();
            gd gdVar = hdVarRequireDocumentEditorSavingToolbarHandler.b;
            gdVar.c = nativeDocumentEditor;
            ThumbnailGridRecyclerView thumbnailGridRecyclerView = hdVarRequireDocumentEditorSavingToolbarHandler.d;
            NativeDocumentEditor nativeDocumentEditorA = gdVar.a(true);
            if (thumbnailGridRecyclerView.h != null && thumbnailGridRecyclerView.f != null) {
                thumbnailGridRecyclerView.b.attachToRecyclerView(thumbnailGridRecyclerView);
                l60 l60Var = thumbnailGridRecyclerView.f;
                l60Var.m = nativeDocumentEditorA;
                int i = l60Var.l;
                if (i > -1 && (viewHolderFindViewHolderForLayoutPosition = thumbnailGridRecyclerView.findViewHolderForLayoutPosition(i)) != null) {
                    ((n60) ((a) viewHolderFindViewHolderForLayoutPosition).itemView).setHighlighted(false);
                }
                b bVar = thumbnailGridRecyclerView.c;
                bVar.e = true;
                bVar.b();
            }
            notifyDocumentEditingModeEntered(hdVarRequireDocumentEditorSavingToolbarHandler);
        }
        RecyclerView.Adapter adapter = hdVarRequireDocumentEditorSavingToolbarHandler.d.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        ensureNewPageFactory();
    }

    private void subscribeForCustomDrawableUpdates() {
        if (this.recyclerView == null) {
            return;
        }
        hu<PdfDrawableProvider> huVar = this.drawableProviderCollection;
        huVar.a.toObservable().map(huVar.a()).subscribeOn(huVar.c).observeOn(AndroidSchedulers.mainThread()).subscribe(updateViewState());
    }

    private Consumer<List<PdfDrawableProvider>> updateViewState() {
        return new Consumer() { // from class: com.pspdfkit.ui.PdfThumbnailGrid$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$updateViewState$1((List) obj);
            }
        };
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public void addDrawableProvider(PdfDrawableProvider pdfDrawableProvider) {
        uw.a(pdfDrawableProvider, "drawableProvider", null);
        hu<PdfDrawableProvider> huVar = this.drawableProviderCollection;
        huVar.getClass();
        huVar.b.a(pdfDrawableProvider);
    }

    public void addOnDocumentEditingModeChangeListener(DocumentEditingManager.OnDocumentEditingModeChangeListener onDocumentEditingModeChangeListener) {
        if (onDocumentEditingModeChangeListener != null) {
            this.documentEditingManager.a.a(onDocumentEditingModeChangeListener);
        }
    }

    public void addOnDocumentEditingPageSelectionChangeListener(DocumentEditingManager.OnDocumentEditingPageSelectionChangeListener onDocumentEditingPageSelectionChangeListener) {
        if (onDocumentEditingPageSelectionChangeListener != null) {
            this.documentEditingManager.b.a(onDocumentEditingPageSelectionChangeListener);
        }
    }

    public void addOnDocumentSavedListener(OnDocumentSavedListener onDocumentSavedListener) {
        if (onDocumentSavedListener != null) {
            this.onDocumentSavedListeners.add(onDocumentSavedListener);
        }
    }

    public void addOnPageClickListener(OnPageClickListener onPageClickListener) {
        if (onPageClickListener != null) {
            this.onPageClickListeners.add(onPageClickListener);
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void addOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        uw.a(onVisibilityChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.thumbnailGridVisibilityListeners.addOnVisibilityChangedListener(onVisibilityChangedListener);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void clearDocument() {
        hide();
        this.document = null;
        this.configuration = null;
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.recyclerView;
        if (thumbnailGridRecyclerView != null) {
            thumbnailGridRecyclerView.setAdapter(null);
            thumbnailGridRecyclerView.f = null;
        }
    }

    public void enterDocumentEditingMode() {
        RecyclerView.ViewHolder viewHolderFindViewHolderForLayoutPosition;
        if (!this.documentEditorEnabled || this.documentEditor == null || this.documentEditModeActive.getAndSet(true)) {
            return;
        }
        invalidateFab();
        hd hdVarRequireDocumentEditorSavingToolbarHandler = requireDocumentEditorSavingToolbarHandler();
        gd gdVar = hdVarRequireDocumentEditorSavingToolbarHandler.b;
        gdVar.c = NativeDocumentEditor.EditDocument(gdVar.b.y);
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = hdVarRequireDocumentEditorSavingToolbarHandler.d;
        NativeDocumentEditor nativeDocumentEditorA = hdVarRequireDocumentEditorSavingToolbarHandler.b.a(true);
        if (thumbnailGridRecyclerView.h != null && thumbnailGridRecyclerView.f != null) {
            thumbnailGridRecyclerView.b.attachToRecyclerView(thumbnailGridRecyclerView);
            l60 l60Var = thumbnailGridRecyclerView.f;
            l60Var.m = nativeDocumentEditorA;
            int i = l60Var.l;
            if (i > -1 && (viewHolderFindViewHolderForLayoutPosition = thumbnailGridRecyclerView.findViewHolderForLayoutPosition(i)) != null) {
                ((n60) ((a) viewHolderFindViewHolderForLayoutPosition).itemView).setHighlighted(false);
            }
            b bVar = thumbnailGridRecyclerView.c;
            bVar.e = true;
            bVar.b();
        }
        notifyDocumentEditingModeEntered(hdVarRequireDocumentEditorSavingToolbarHandler);
        this.documentEditor.d = Integer.valueOf(this.highlightedPageIndex);
    }

    public void exitDocumentEditingMode() {
        if (!this.documentEditModeActive.getAndSet(false) || this.documentEditor == null || this.recyclerView == null) {
            return;
        }
        invalidateFab();
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.recyclerView;
        if (thumbnailGridRecyclerView.f != null) {
            thumbnailGridRecyclerView.b.attachToRecyclerView(null);
            l60 l60Var = thumbnailGridRecyclerView.f;
            l60Var.m = null;
            l60Var.notifyDataSetChanged();
            b bVar = thumbnailGridRecyclerView.c;
            bVar.e = false;
            bVar.a();
        }
        hd hdVarRequireDocumentEditorSavingToolbarHandler = requireDocumentEditorSavingToolbarHandler();
        notifyDocumentEditingModeExited(hdVarRequireDocumentEditorSavingToolbarHandler);
        gd gdVar = hdVarRequireDocumentEditorSavingToolbarHandler.b;
        NativeDocumentEditor nativeDocumentEditor = gdVar.c;
        gdVar.c = null;
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        setPadding(rect.left, rect.top, rect.right, rect.bottom);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        if (getRootView() == null) {
            return super.focusSearch(view, i);
        }
        DocumentEditingToolbar documentEditingToolbar = (DocumentEditingToolbar) getRootView().findViewById(R.id.pspdf__document_editing_toolbar);
        if (documentEditingToolbar == null) {
            return super.focusSearch(view, i);
        }
        return (((view instanceof FloatingActionButton) && i == 2) || (documentEditingToolbar.getPosition() == ToolbarCoordinatorLayout.LayoutParams.Position.LEFT && i == 17) || (documentEditingToolbar.getPosition() == ToolbarCoordinatorLayout.LayoutParams.Position.RIGHT && i == 66)) ? documentEditingToolbar : super.focusSearch(view, i);
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public NewPageDialog.Callback getDefaultNewPageDialogCallback() {
        return new NewPageDialog.Callback() { // from class: com.pspdfkit.ui.PdfThumbnailGrid.1
            @Override // com.pspdfkit.document.editor.page.NewPageDialog.Callback
            public void onDialogCancelled() {
                PdfThumbnailGrid.this.getOrCreateDocumentEditorSavingToolbarHandler();
                boolean unused = PdfThumbnailGrid.this.documentEditorEnabled;
            }

            @Override // com.pspdfkit.document.editor.page.NewPageDialog.Callback
            public void onDialogConfirmed(NewPage newPage) {
                hd orCreateDocumentEditorSavingToolbarHandler = PdfThumbnailGrid.this.getOrCreateDocumentEditorSavingToolbarHandler();
                if (!PdfThumbnailGrid.this.documentEditorEnabled || orCreateDocumentEditorSavingToolbarHandler == null) {
                    return;
                }
                orCreateDocumentEditorSavingToolbarHandler.onNewPageReady(newPage);
            }
        };
    }

    public DocumentEditingManager getDocumentEditingManager() {
        return this.documentEditingManager;
    }

    public PdfDocumentEditor getDocumentEditor() {
        if (ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            return this.documentEditor;
        }
        throw new InvalidNutrientLicenseException("Your current license does not allow editing of PDF documents.");
    }

    public FilePicker getFilePicker() {
        if (this.filePicker == null) {
            this.filePicker = new lc((AppCompatActivity) a80.a(getContext()), l0.a());
        }
        return this.filePicker;
    }

    public int getItemLabelBackground() {
        return this.itemLabelBackgroundDrawableRes;
    }

    public int getItemLabelTextStyle() {
        return this.itemLabelTextStyle;
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public PSPDFKitViews.Type getPSPDFViewType() {
        return PSPDFKitViews.Type.VIEW_THUMBNAIL_GRID;
    }

    public Set<Integer> getSelectedPages() {
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.recyclerView;
        return thumbnailGridRecyclerView != null ? thumbnailGridRecyclerView.getSelectedPages() : new HashSet();
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void hide() {
        if (this.isDisplayed) {
            this.isDisplayed = false;
            this.thumbnailGridVisibilityListeners.onHide(this);
            exitDocumentEditingMode();
            animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: com.pspdfkit.ui.PdfThumbnailGrid.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PdfThumbnailGrid.this.recyclerView.setAdapter(null);
                    PdfThumbnailGrid.this.setVisibility(4);
                    PdfThumbnailGrid.this.animate().setListener(null);
                }
            });
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public boolean isDisplayed() {
        return this.isDisplayed;
    }

    public boolean isDocumentEditorEnabled() {
        return this.documentEditorEnabled;
    }

    public boolean isRedactionAnnotationPreviewEnabled() {
        return this.isRedactionAnnotationPreviewEnabled;
    }

    public boolean isShowPageLabels() {
        return this.showPageLabels;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.recyclerView;
        if (thumbnailGridRecyclerView != null) {
            thumbnailGridRecyclerView.e = null;
            thumbnailGridRecyclerView.c.c = null;
        }
    }

    @Override // com.pspdfkit.internal.bt
    public void onDocumentExported(Uri uri) {
        exitDocumentEditingMode();
        synchronized (this.onDocumentSavedListeners) {
            if (!this.onDocumentSavedListeners.isEmpty()) {
                Iterator<OnDocumentSavedListener> it = this.onDocumentSavedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDocumentExported(uri);
                }
            }
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoaded(PdfDocument pdfDocument) {
        if (this.documentEditorEnabled) {
            NativeDocumentEditor nativeDocumentEditor = this.retainedNativeDocumentEditor;
            if (nativeDocumentEditor != null) {
                restoreDocumentEditingMode(nativeDocumentEditor);
                this.retainedNativeDocumentEditor = null;
            } else if (a80.b(getContext()) != null) {
                NewPageDialog.hide(a80.b(getContext()));
            }
        }
    }

    @Override // com.pspdfkit.internal.bt
    public void onDocumentSaved() {
        exitDocumentEditingMode();
        synchronized (this.onDocumentSavedListeners) {
            if (!this.onDocumentSavedListeners.isEmpty()) {
                Iterator<OnDocumentSavedListener> it = this.onDocumentSavedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onDocumentSaved();
                }
            }
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onPageChanged(PdfDocument pdfDocument, int i) {
        this.highlightedPageIndex = i;
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.recyclerView;
        if (thumbnailGridRecyclerView != null) {
            thumbnailGridRecyclerView.setHighlightedItem(i);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        gd gdVar;
        if (this.retainedDocumentEditorHolder != null && this.documentEditModeActive.get() && (gdVar = this.documentEditor) != null && gdVar.a(false) != null) {
            mz mzVar = this.retainedDocumentEditorHolder;
            gd gdVar2 = this.documentEditor;
            mz.a aVar = (mz.a) mzVar.a.findFragmentByTag(mzVar.b);
            if (aVar != null) {
                aVar.a = gdVar2;
            } else if (gdVar2 != null) {
                mz.a aVar2 = (mz.a) mzVar.a.findFragmentByTag(mzVar.b);
                if (aVar2 == null) {
                    aVar2 = new mz.a();
                    FragmentManager fragmentManager = mzVar.a;
                    String str = mzVar.b;
                    fragmentManager.getClass();
                    if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                        throw new IllegalStateException("addFragment() may only be called from the main thread.");
                    }
                    if (!aVar2.isAdded()) {
                        FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(aVar2, str);
                        fragmentTransactionAdd.getClass();
                        fragmentTransactionAdd.commitAllowingStateLoss();
                    }
                }
                aVar2.a = gdVar2;
            }
        }
        return super.onSaveInstanceState();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public void removeDrawableProvider(PdfDrawableProvider pdfDrawableProvider) {
        uw.a(pdfDrawableProvider, "drawableProvider", null);
        hu<PdfDrawableProvider> huVar = this.drawableProviderCollection;
        huVar.getClass();
        huVar.b.b(pdfDrawableProvider);
    }

    public boolean removeOnDocumentEditingModeChangeListener(DocumentEditingManager.OnDocumentEditingModeChangeListener onDocumentEditingModeChangeListener) {
        if (onDocumentEditingModeChangeListener == null) {
            return false;
        }
        this.documentEditingManager.a.b(onDocumentEditingModeChangeListener);
        return true;
    }

    public boolean removeOnDocumentEditingPageSelectionChangeListener(DocumentEditingManager.OnDocumentEditingPageSelectionChangeListener onDocumentEditingPageSelectionChangeListener) {
        if (onDocumentEditingPageSelectionChangeListener == null) {
            return false;
        }
        this.documentEditingManager.b.b(onDocumentEditingPageSelectionChangeListener);
        return true;
    }

    public boolean removeOnDocumentSavedListener(OnPageClickListener onPageClickListener) {
        if (onPageClickListener == null) {
            return false;
        }
        return this.onPageClickListeners.remove(onPageClickListener);
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void removeOnVisibilityChangedListener(OnVisibilityChangedListener onVisibilityChangedListener) {
        uw.a(onVisibilityChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.thumbnailGridVisibilityListeners.removeOnVisibilityChangedListener(onVisibilityChangedListener);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.backgroundColor = i;
        applyTheme();
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void setDocument(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration) {
        Object obj;
        uw.a(pdfConfiguration, "configuration", null);
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.recyclerView;
        if (thumbnailGridRecyclerView != null) {
            if (pdfDocument == null) {
                thumbnailGridRecyclerView.setAdapter(null);
                thumbnailGridRecyclerView.f = null;
                this.documentEditor = null;
            } else {
                thumbnailGridRecyclerView.h = (lm) pdfDocument;
                thumbnailGridRecyclerView.i = pdfConfiguration;
                thumbnailGridRecyclerView.f = thumbnailGridRecyclerView.a();
                ThumbnailGridRecyclerView thumbnailGridRecyclerView2 = this.recyclerView;
                boolean z = this.showPageLabels;
                thumbnailGridRecyclerView2.j = z;
                l60 l60Var = thumbnailGridRecyclerView2.f;
                if (l60Var != null) {
                    l60Var.j = z;
                    l60Var.notifyDataSetChanged();
                }
                if (this.isDisplayed) {
                    this.recyclerView.c();
                }
                if (this.documentEditorEnabled) {
                    FragmentManager fragmentManagerB = a80.b(getContext());
                    if (fragmentManagerB != null) {
                        this.retainedDocumentEditorHolder = new mz(fragmentManagerB, RETAINED_STATE_FRAGMENT_TAG);
                        mz.a aVar = (mz.a) fragmentManagerB.findFragmentByTag(RETAINED_STATE_FRAGMENT_TAG);
                        if (aVar != null) {
                            obj = aVar.a;
                            aVar.a = null;
                            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                                throw new IllegalStateException("removeFragmentAllowingStateLoss() may only be called from the main thread.");
                            }
                            Fragment fragmentFindFragmentByTag = fragmentManagerB.findFragmentByTag(RETAINED_STATE_FRAGMENT_TAG);
                            if (fragmentFindFragmentByTag != null) {
                                fi.a(fragmentManagerB, fragmentFindFragmentByTag, true);
                            }
                        } else {
                            obj = null;
                        }
                        gd gdVar = (gd) obj;
                        this.documentEditor = gdVar;
                        if (gdVar != null) {
                            this.retainedNativeDocumentEditor = gdVar.a(true);
                        }
                        mz mzVar = this.retainedDocumentEditorHolder;
                        if (((mz.a) mzVar.a.findFragmentByTag(mzVar.b)) == null) {
                            mz.a aVar2 = new mz.a();
                            FragmentManager fragmentManager = mzVar.a;
                            String str = mzVar.b;
                            fragmentManager.getClass();
                            if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                                throw new IllegalStateException("addFragment() may only be called from the main thread.");
                            }
                            if (!aVar2.isAdded()) {
                                FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(aVar2, str);
                                fragmentTransactionAdd.getClass();
                                fragmentTransactionAdd.commitAllowingStateLoss();
                            }
                        }
                    }
                    gd gdVar2 = this.documentEditor;
                    if (gdVar2 == null || gdVar2.b != pdfDocument) {
                        this.documentEditor = (gd) PdfDocumentEditorFactory.createForDocument(pdfDocument);
                        this.retainedNativeDocumentEditor = null;
                    }
                    hd hdVar = this.documentEditorSavingToolbarHandler;
                    if (hdVar != null) {
                        gd gdVar3 = this.documentEditor;
                        gdVar3.getClass();
                        hdVar.b = gdVar3;
                    }
                    this.floatingActionButton.setVisibility(0);
                }
            }
            if (this.document != pdfDocument) {
                this.highlightedPageIndex = 0;
            }
        }
        this.document = pdfDocument;
        this.configuration = pdfConfiguration;
    }

    public void setDocumentEditorEnabled(boolean z) {
        if (z && !ar.b().a(NativeLicenseFeatures.DOCUMENT_EDITING)) {
            throw new InvalidNutrientLicenseException("Your current license does not allow editing of PDF documents.");
        }
        this.documentEditorEnabled = z;
    }

    public void setDocumentEditorExportEnabled(boolean z) {
        hd orCreateDocumentEditorSavingToolbarHandler = getOrCreateDocumentEditorSavingToolbarHandler();
        if (!this.documentEditorEnabled || orCreateDocumentEditorSavingToolbarHandler == null) {
            this.exportEnabled = Boolean.valueOf(z);
        } else {
            orCreateDocumentEditorSavingToolbarHandler.f = z;
        }
    }

    public void setDocumentEditorSaveAsEnabled(boolean z) {
        hd orCreateDocumentEditorSavingToolbarHandler = getOrCreateDocumentEditorSavingToolbarHandler();
        if (!this.documentEditorEnabled || orCreateDocumentEditorSavingToolbarHandler == null) {
            this.saveAsEnabled = Boolean.valueOf(z);
        } else {
            orCreateDocumentEditorSavingToolbarHandler.e = z;
        }
    }

    public void setFilePicker(FilePicker filePicker) {
        this.filePicker = filePicker;
    }

    public void setItemLabelBackground(int i) {
        this.itemLabelBackgroundDrawableRes = i;
        applyTheme();
    }

    public void setItemLabelTextStyle(int i) {
        this.itemLabelTextStyle = i;
        applyTheme();
    }

    public final void setNewPageFactory(NewPageFactory newPageFactory) {
        if (newPageFactory == null) {
            this.newPageFactory = createDefaultNewPageFactory();
        } else {
            this.newPageFactory = newPageFactory;
        }
    }

    public void setOnPageClickListener(OnPageClickListener onPageClickListener) {
        this.onPageClickListeners.clear();
        if (onPageClickListener != null) {
            this.onPageClickListeners.add(onPageClickListener);
        }
    }

    public void setRedactionAnnotationPreviewEnabled(boolean z) {
        this.isRedactionAnnotationPreviewEnabled = z;
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.recyclerView;
        if (thumbnailGridRecyclerView != null) {
            thumbnailGridRecyclerView.setRedactionAnnotationPreviewEnabled(z);
        }
    }

    public void setShowPageLabels(boolean z) {
        this.showPageLabels = z;
        ThumbnailGridRecyclerView thumbnailGridRecyclerView = this.recyclerView;
        if (thumbnailGridRecyclerView != null) {
            thumbnailGridRecyclerView.j = z;
            l60 l60Var = thumbnailGridRecyclerView.f;
            if (l60Var != null) {
                l60Var.j = z;
                l60Var.notifyDataSetChanged();
            }
        }
    }

    @Override // com.pspdfkit.ui.PSPDFKitViews.PSPDFView
    public void show() {
        if (this.isDisplayed) {
            return;
        }
        prepareForDisplay();
        this.isDisplayed = true;
        this.thumbnailGridVisibilityListeners.onShow(this);
        this.recyclerView.c();
        this.recyclerView.setHighlightedItem(this.highlightedPageIndex);
        this.recyclerView.scrollToPosition(this.highlightedPageIndex);
        if (this.documentEditorEnabled) {
            invalidateFab();
        }
        setVisibility(0);
        animate().setListener(null);
        animate().alpha(1.0f).setDuration(100L);
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        i0VarA.b.onNext(new Pair<>(Analytics.Event.OPEN_THUMBNAIL_GRID, new Bundle()));
    }

    public boolean removeOnDocumentSavedListener(OnDocumentSavedListener onDocumentSavedListener) {
        if (onDocumentSavedListener == null) {
            return false;
        }
        return this.onDocumentSavedListeners.remove(onDocumentSavedListener);
    }

    public PdfThumbnailGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.saveAsEnabled = null;
        this.exportEnabled = null;
        this.documentEditModeActive = new AtomicBoolean(false);
        this.thumbnailGridVisibilityListeners = new OnVisibilityChangedListenerManager();
        this.documentEditingManager = new fd();
        this.drawableProviderCollection = new hu<>(Schedulers.computation());
        this.onPageClickListeners = Collections.synchronizedList(new ArrayList());
        this.onDocumentSavedListeners = Collections.synchronizedList(new ArrayList());
    }

    public PdfThumbnailGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.saveAsEnabled = null;
        this.exportEnabled = null;
        this.documentEditModeActive = new AtomicBoolean(false);
        this.thumbnailGridVisibilityListeners = new OnVisibilityChangedListenerManager();
        this.documentEditingManager = new fd();
        this.drawableProviderCollection = new hu<>(Schedulers.computation());
        this.onPageClickListeners = Collections.synchronizedList(new ArrayList());
        this.onDocumentSavedListeners = Collections.synchronizedList(new ArrayList());
    }

    public PdfThumbnailGrid(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.saveAsEnabled = null;
        this.exportEnabled = null;
        this.documentEditModeActive = new AtomicBoolean(false);
        this.thumbnailGridVisibilityListeners = new OnVisibilityChangedListenerManager();
        this.documentEditingManager = new fd();
        this.drawableProviderCollection = new hu<>(Schedulers.computation());
        this.onPageClickListeners = Collections.synchronizedList(new ArrayList());
        this.onDocumentSavedListeners = Collections.synchronizedList(new ArrayList());
    }
}
