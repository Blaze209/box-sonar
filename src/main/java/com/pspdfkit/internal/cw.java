package com.pspdfkit.internal;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.SieveCacheKt;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelStoreOwner;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import com.microsoft.intune.mam.client.view.MAMWindowManagement;
import com.pspdfkit.Nutrient;
import com.pspdfkit.ai.AiAssistantHelpersKt;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.activity.TabBarHidingMode;
import com.pspdfkit.configuration.activity.ThumbnailBarMode;
import com.pspdfkit.configuration.activity.UserInterfaceViewMode;
import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.configuration.search.SearchConfiguration;
import com.pspdfkit.configuration.search.SearchType;
import com.pspdfkit.configuration.sharing.ShareFeatures;
import com.pspdfkit.configuration.theming.ThemeMode;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.editor.PdfDocumentEditor;
import com.pspdfkit.document.printing.DocumentPrintManager;
import com.pspdfkit.document.printing.PrintOptions;
import com.pspdfkit.document.printing.PrintOptionsProvider;
import com.pspdfkit.document.search.SearchResult;
import com.pspdfkit.document.sharing.SharingOptionsProvider;
import com.pspdfkit.exceptions.InvalidLayoutException;
import com.pspdfkit.exceptions.InvalidThemeException;
import com.pspdfkit.exceptions.NutrientNotInitializedException;
import com.pspdfkit.instant.ui.InstantPdfFragment;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.InternalDocumentListener;
import com.pspdfkit.listeners.OnToolbarMenuChangedListener;
import com.pspdfkit.listeners.OnVisibilityChangedListener;
import com.pspdfkit.listeners.PdfActivityListener;
import com.pspdfkit.listeners.scrolling.DocumentScrollListener;
import com.pspdfkit.listeners.scrolling.ScrollState;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.AnnotationCreatorInputDialogFragment;
import com.pspdfkit.ui.DocumentCoordinator;
import com.pspdfkit.ui.DocumentDescriptor;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfActivity;
import com.pspdfkit.ui.PdfDocumentInfoView;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfOutlineView;
import com.pspdfkit.ui.PdfThumbnailBar;
import com.pspdfkit.ui.PdfThumbnailGrid;
import com.pspdfkit.ui.PdfUi;
import com.pspdfkit.ui.UiVisibleCallback;
import com.pspdfkit.ui.actionmenu.ActionMenuListener;
import com.pspdfkit.ui.actionmenu.SharingMenu;
import com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener;
import com.pspdfkit.ui.annotations.OnAnnotationSelectedListener;
import com.pspdfkit.ui.audio.AudioModeListeners;
import com.pspdfkit.ui.audio.AudioPlaybackController;
import com.pspdfkit.ui.audio.AudioRecordingController;
import com.pspdfkit.ui.audio.AudioView;
import com.pspdfkit.ui.contentediting.ContentEditingStylingBar;
import com.pspdfkit.ui.dialog.DocumentPrintDialog;
import com.pspdfkit.ui.dialog.DocumentPrintDialogFactory;
import com.pspdfkit.ui.dialog.DocumentSharingDialog;
import com.pspdfkit.ui.dialog.DocumentSharingDialogFactory;
import com.pspdfkit.ui.documentinfo.OnDocumentInfoViewSaveListener;
import com.pspdfkit.ui.forms.FormEditingBar;
import com.pspdfkit.ui.inspector.PropertyInspector;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayout;
import com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController;
import com.pspdfkit.ui.inspector.annotation.AnnotatingInspectorController;
import com.pspdfkit.ui.inspector.annotation.DefaultAnnotationCreationInspectorController;
import com.pspdfkit.ui.inspector.annotation.DefaultAnnotationEditingInspectorController;
import com.pspdfkit.ui.inspector.contentediting.DefaultContentEditingInspectorController;
import com.pspdfkit.ui.inspector.forms.FormEditingInspectorController;
import com.pspdfkit.ui.navigation.NavigationBackStack;
import com.pspdfkit.ui.note.AnnotationNoteHinter;
import com.pspdfkit.ui.outline.DefaultBookmarkAdapter;
import com.pspdfkit.ui.outline.DefaultOutlineViewListener;
import com.pspdfkit.ui.redaction.RedactionView;
import com.pspdfkit.ui.scale.MeasurementScaleView;
import com.pspdfkit.ui.search.PdfSearchView;
import com.pspdfkit.ui.search.PdfSearchViewInline;
import com.pspdfkit.ui.search.PdfSearchViewLazy;
import com.pspdfkit.ui.search.PdfSearchViewModular;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import com.pspdfkit.ui.search.SimpleSearchResultListener;
import com.pspdfkit.ui.settings.SettingsDialog;
import com.pspdfkit.ui.settings.SettingsDialogListener;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.ui.special_mode.controller.ContentEditingController;
import com.pspdfkit.ui.special_mode.controller.ContentEditingInspectorController;
import com.pspdfkit.ui.special_mode.controller.DocumentEditingController;
import com.pspdfkit.ui.special_mode.controller.FormEditingController;
import com.pspdfkit.ui.special_mode.controller.TextSelectionController;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import com.pspdfkit.ui.special_mode.manager.DocumentEditingManager;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import com.pspdfkit.ui.special_mode.manager.TextSelectionManager;
import com.pspdfkit.ui.tabs.PdfTabBar;
import com.pspdfkit.ui.thumbnail.PdfThumbnailBarController;
import com.pspdfkit.ui.toolbar.AnnotationToolbar;
import com.pspdfkit.ui.toolbar.ContentEditingToolbar;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import com.pspdfkit.ui.toolbar.DocumentEditingToolbar;
import com.pspdfkit.ui.toolbar.TextSelectionToolbar;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import com.pspdfkit.utils.PdfLog;
import io.nutrient.domain.ConnectivityObserver;
import io.nutrient.ui.settings.SettingsOptions;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt__JobKt;

/* JADX INFO: loaded from: classes3.dex */
public class cw implements DocumentListener, OnVisibilityChangedListener, OnAnnotatingModeChangeListener, ContentEditingManager.OnContentEditingModeChangeListener, ContentEditingManager.OnContentEditingContentChangeListener, TextSelectionManager.OnTextSelectionModeChangeListener, FormManager.OnFormElementEditingModeChangeListener, DocumentEditingManager.OnDocumentEditingModeChangeListener, dv.b, ToolbarCoordinatorLayout.OnContextualToolbarPositionListener, SettingsDialogListener, k70, OnDocumentInfoViewSaveListener, gn.a, TextSelectionController.OnSearchSelectedTextListener, AudioModeListeners.AudioPlaybackModeChangeListener, AudioModeListeners.AudioRecordingModeChangeListener, lm.c, PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener {
    public static final String DEFAULT_PDF_FRAGMENT_TAG = "Nutrient.Fragment";
    public static final String PARAM_ACTIVITY_STATE = "activityState";
    private static final String STATE_ACTIVE_VIEW_ITEM = "Nutrient.ActiveMenuOption";
    private static final String STATE_ANNOTATION_CREATION_ACTIVE = "PdfUiImpl.AnnotationCreationActive";
    private static final String STATE_ANNOTATION_CREATION_INSPECTOR = "PdfActivity.AnnotationCreationInspector";
    private static final String STATE_ANNOTATION_EDITING_INSPECTOR = "PdfActivity.AnnotationEditingInspector";
    private static final String STATE_CONFIGURATION = "PdfActivity.Configuration";
    private static final String STATE_CONTENT_EDITING_ACTIVE = "PdfUiImpl.ContentEditingActive";
    private static final String STATE_CONTENT_EDITING_INSPECTOR = "PdfActivity.ContentEditingInspector";
    private static final String STATE_DOCUMENT_COORDINATOR = "PdfActivity.PdfDocumentCoordinatorState";
    private static final String STATE_FORM_EDITING_INSPECTOR = "PdfActivity.FormEditingInspector";
    private static final String STATE_FRAGMENT = "PdfActivity.FragmentState";
    private static final String STATE_FRAGMENT_CONTAINER_ID = "PdfActivity.FragmentContainerId";
    private static final String STATE_LAST_ENABLED_UI_STATE = "PdfActivity.LastEnabledUiState";
    private static final String STATE_PENDING_INITIAL_PAGE = "PdfActivity.PendingInitialPage";
    private static final String STATE_SCREEN_TIMEOUT = "PdfUiImpl.ScreenTimeout";
    private static final String STATE_UI_STATE = "PdfActivity.UiState";
    private static final long USER_INTERFACE_ENABLED_REFRESH_DELAY = 100;
    public static PdfDocument retainedDocument;
    private yu actionResolver;
    protected final AppCompatActivity activity;
    private final PdfActivityListener activityListener;
    private AnnotatingInspectorController annotationCreationInspectorController;
    private AnnotatingInspectorController annotationEditingInspectorController;
    private AnnotationNoteHinter annotationNoteHinter;
    private AnnotationToolbar annotationToolbar;
    private PdfActivityConfiguration configuration;
    private ConnectivityObserver connectivityObserver;
    private ContentEditingInspectorController contentEditingInspectorController;
    private ContentEditingToolbar contentEditingToolBar;
    protected lm document;
    private DocumentEditingToolbar documentEditingToolbar;
    private DocumentPrintDialogFactory documentPrintDialogFactory;
    private DocumentSharingDialogFactory documentSharingDialogFactory;
    private FormEditingInspectorController formEditingInspectorController;
    protected PdfFragment fragment;
    private int fragmentContainerId;
    private final sm internalPdfUi;
    private gn keyEventContract;
    private Bundle lastEnabledUiState;
    private bv menuConfiguration;
    private av menuManager;
    private final PdfUi pdfUi;
    private ToolbarCoordinatorLayout.OnContextualToolbarPositionListener positionListener;
    private PrintOptionsProvider printOptionsProvider;
    PropertyInspectorCoordinatorLayout propertyInspectorCoordinatorLayout;
    private final PSPDFKitPreferences pspdfKitPreferences;
    private wx redactionApplicator;
    private View rootView;
    private o00 selectedMeasurementValueConfigurationController;
    s10 sharingMenuFragment;
    private ActionMenuListener sharingMenuListener;
    private SharingOptionsProvider sharingOptionsProvider;
    private TextSelectionToolbar textSelectionToolbar;
    private Toolbar toolbar;
    protected ToolbarCoordinatorLayout toolbarCoordinatorLayout;
    private float toolbarElevation;
    private OnToolbarMenuChangedListener toolbarMenuListener;
    private dv userInterfaceCoordinator;
    private Runnable userInterfaceEnabledRunnable;
    im views;
    private final String LOG_TAG = "Nutri.PdfUiImpl";
    private int pendingInitialPage = -1;
    private boolean isInAnnotationCreationMode = false;
    private boolean isInContentEditingMode = false;
    private long screenTimeoutMillis = 0;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean userInterfaceEnabled = false;
    private boolean documentInteractionEnabled = true;
    private final OnAnnotationSelectedListener annotationSelectionListener = new a();
    private final dn activityJsPlatformDelegate = new zu(this);
    private final bw documentCoordinator = new bw(this);
    private final DocumentScrollListener documentScrollListener = new c();
    private d thumbnailBarListener = null;
    private ContentEditingController currentContentEditingController = null;
    private String currentlyEditedBlockID = null;

    public class a implements OnAnnotationSelectedListener {
        public a() {
        }

        @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
        public final void onAnnotationSelected(Annotation annotation, boolean z) {
            PSPDFKitViews.Type activeView = cw.this.getActiveView();
            PSPDFKitViews.Type type = PSPDFKitViews.Type.VIEW_SEARCH;
            cw cwVar = cw.this;
            if (activeView == type) {
                cwVar.toggleView(PSPDFKitViews.Type.VIEW_NONE);
                return;
            }
            PdfSearchView pdfSearchView = ((jv) cwVar.views).u;
            if (pdfSearchView != null) {
                pdfSearchView.clearSearch();
            }
        }

        @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
        public final void onAnnotationSelectionFinished(List<Annotation> list, boolean z) {
            boolean z2;
            DocumentView documentViewA;
            AnnotationTool annotationTool;
            int i;
            cw cwVar = cw.this;
            if (!cwVar.isInAnnotationCreationMode) {
                cwVar.ensureEditingInspectorBound();
            }
            list.getClass();
            if (!list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    } else if (((Annotation) it.next()).isMeasurement()) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            cw cwVar2 = cw.this;
            if (z2) {
                cwVar2.showMeasurementScaleUiForSelection();
                return;
            }
            if (!cwVar2.isInAnnotationCreationMode || (documentViewA = cwVar2.fragment.getInternal().getViewCoordinator().a(false)) == null || (annotationTool = documentViewA.getAnnotatingHandler().s) == null || !((i = p10.a.b[annotationTool.ordinal()]) == 1 || i == 2 || i == 3 || i == 4 || i == 5)) {
                cw.this.hideMeasurementScaleUi();
            }
        }

        @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
        public final void onAnnotationWritingModeChanged(boolean z) {
            dv dvVar = cw.this.userInterfaceCoordinator;
            if (dvVar != null) {
                dvVar.m = z;
            }
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PSPDFKitViews.Type.values().length];
            a = iArr;
            try {
                iArr[PSPDFKitViews.Type.VIEW_THUMBNAIL_GRID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PSPDFKitViews.Type.VIEW_OUTLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PSPDFKitViews.Type.VIEW_READER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PSPDFKitViews.Type.VIEW_SEARCH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class c implements DocumentScrollListener {
        public c() {
        }

        @Override // com.pspdfkit.listeners.scrolling.DocumentScrollListener
        public final void onDocumentScrolled(int i, int i2, int i3, int i4, int i5, int i6) {
        }

        @Override // com.pspdfkit.listeners.scrolling.DocumentScrollListener
        public final void onScrollStateChanged(ScrollState scrollState) {
            dv dvVar;
            if (scrollState != ScrollState.DRAGGED || (dvVar = cw.this.userInterfaceCoordinator) == null) {
                return;
            }
            dvVar.hideUserInterface();
        }
    }

    public class d implements PdfThumbnailBar.OnPageChangedListener {
        public boolean a = false;
        public Disposable b = null;

        public d() {
        }

        public final /* synthetic */ void a(Long l) throws Throwable {
            cw.this.fragment.endNavigation();
            this.a = false;
        }

        @Override // com.pspdfkit.ui.PdfThumbnailBar.OnPageChangedListener
        public final void onPageChanged(PdfThumbnailBarController pdfThumbnailBarController, int i) {
            i0 i0VarA = ar.a();
            i0VarA.getClass();
            Bundle bundle = new Bundle();
            bundle.putInt(Analytics.Data.PAGE_INDEX, i);
            i0VarA.a(Analytics.Event.NAVIGATE_THUMBNAIL_BAR, bundle);
            if (!this.a) {
                cw.this.fragment.beginNavigation();
                this.a = true;
            }
            cw.this.fragment.setPageIndex(i);
            yz.a(this.b);
            this.b = Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.internal.cw$d$$ExternalSyntheticLambda0
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.a((Long) obj);
                }
            });
        }
    }

    public class e implements PdfThumbnailGrid.OnPageClickListener, PdfThumbnailGrid.OnDocumentSavedListener {
        public e() {
        }

        public final void a(DocumentDescriptor documentDescriptor, boolean z) {
            HashSet hashSet;
            Bundle activityState = cw.this.getActivityState(true, false);
            PdfThumbnailGrid pdfThumbnailGrid = ((jv) cw.this.views).k;
            Integer num = null;
            hashSet = null;
            HashSet hashSet2 = null;
            if (pdfThumbnailGrid != null) {
                PdfDocumentEditor documentEditor = pdfThumbnailGrid.getDocumentEditor();
                boolean z2 = documentEditor instanceof gd;
                Integer num2 = z2 ? ((gd) documentEditor).d : null;
                if (z && z2) {
                    hashSet2 = ((gd) documentEditor).a;
                }
                hashSet = hashSet2;
                num = num2;
            } else {
                hashSet = null;
            }
            if (num == null || num.intValue() >= cw.this.fragment.getPageCount() || (hashSet != null && !hashSet.contains(num))) {
                num = 0;
            }
            Bundle bundle = activityState.getBundle(cw.STATE_FRAGMENT);
            if (bundle != null) {
                int iIntValue = num.intValue();
                x70 x70Var = (x70) bundle.getParcelable("Nutrient.ViewState");
                if (x70Var != null) {
                    bundle.putParcelable("Nutrient.ViewState", new x70(x70Var.a, iIntValue, x70Var.c));
                }
                activityState.putBundle(cw.STATE_FRAGMENT, bundle);
            }
            documentDescriptor.setState(activityState);
        }

        @Override // com.pspdfkit.ui.PdfThumbnailGrid.OnDocumentSavedListener
        public final void onDocumentExported(Uri uri) {
            PSPDFKitViews.Type activeView = cw.this.getActiveView();
            PSPDFKitViews.Type type = PSPDFKitViews.Type.VIEW_THUMBNAIL_GRID;
            if (activeView == type) {
                cw.this.toggleView(type);
            }
            lm lmVar = cw.this.document;
            if (lmVar != null) {
                DocumentDescriptor documentDescriptorFromUri = DocumentDescriptor.fromUri(uri, lmVar.A.get(0).getPassword());
                a(documentDescriptorFromUri, true);
                cw.this.getDocumentCoordinator().addDocument(documentDescriptorFromUri);
                cw.this.getDocumentCoordinator().setVisibleDocument(documentDescriptorFromUri);
            }
        }

        @Override // com.pspdfkit.ui.PdfThumbnailGrid.OnDocumentSavedListener
        public final void onDocumentSaved() {
            PSPDFKitViews.Type activeView = cw.this.getActiveView();
            PSPDFKitViews.Type type = PSPDFKitViews.Type.VIEW_THUMBNAIL_GRID;
            if (activeView == type) {
                cw.this.toggleView(type);
            }
            cw cwVar = cw.this;
            if (cwVar.document != null) {
                cwVar.fragment.getNavigationHistory().replaceWith(new NavigationBackStack<>());
                DocumentDescriptor documentDescriptorFromDocumentSource = DocumentDescriptor.fromDocumentSource(cw.this.document.A.get(0));
                a(documentDescriptorFromDocumentSource, false);
                cw.this.getDocumentCoordinator().setDocument(documentDescriptorFromDocumentSource);
            }
        }

        @Override // com.pspdfkit.ui.PdfThumbnailGrid.OnPageClickListener
        public final void onPageClick(PdfThumbnailGrid pdfThumbnailGrid, int i) {
            cw.this.fragment.beginNavigation();
            cw.this.fragment.setPageIndex(i);
            cw.this.fragment.endNavigation();
            pdfThumbnailGrid.hide();
        }
    }

    public class f extends SimpleSearchResultListener {
        public final SearchResultHighlighter a;

        public f(SearchResultHighlighter searchResultHighlighter) {
            this.a = searchResultHighlighter;
        }

        @Override // com.pspdfkit.ui.search.SimpleSearchResultListener, com.pspdfkit.ui.search.PdfSearchView.Listener
        public final void onMoreSearchResults(List<SearchResult> list) {
            this.a.addSearchResults(list);
        }

        @Override // com.pspdfkit.ui.search.SimpleSearchResultListener, com.pspdfkit.ui.search.PdfSearchView.Listener
        public final void onSearchCleared() {
            this.a.clearSearchResults();
        }

        @Override // com.pspdfkit.ui.search.SimpleSearchResultListener, com.pspdfkit.ui.search.PdfSearchView.Listener
        public final void onSearchResultSelected(SearchResult searchResult) {
            this.a.setSelectedSearchResult(searchResult);
            if (searchResult != null) {
                RectF rectFA = ip.a(searchResult.textBlock.pageRects);
                rectFA.inset((-rectFA.width()) * 0.1f, (-rectFA.height()) * 0.1f);
                cw.this.fragment.scrollTo(rectFA, searchResult.pageIndex, 200L, false);
            }
        }
    }

    public cw(AppCompatActivity appCompatActivity, PdfUi pdfUi, sm smVar) {
        uw.a(pdfUi, "pdfUi", null);
        this.pdfUi = pdfUi;
        this.internalPdfUi = smVar;
        this.activity = appCompatActivity;
        this.activityListener = pdfUi;
        this.configuration = new PdfActivityConfiguration.Builder(appCompatActivity).build();
        this.pspdfKitPreferences = PSPDFKitPreferences.get(appCompatActivity);
        this.connectivityObserver = new da(appCompatActivity);
    }

    public static void applyConfigurationToParamsAndState(PdfActivityConfiguration pdfActivityConfiguration, Bundle bundle, Bundle bundle2) {
        bundle.putParcelable("Nutri.Configuration", pdfActivityConfiguration);
        if (bundle2 != null) {
            bundle2.putParcelable(STATE_CONFIGURATION, pdfActivityConfiguration);
            bundle2.putBundle(STATE_FRAGMENT, bundle2.getBundle(STATE_FRAGMENT));
        }
    }

    private void cleanupRedactionApplicator() {
        setupRedactionApplicator(null);
    }

    private d createThumbnailBarListener() {
        disposeThumbnailBarListener();
        d dVar = new d();
        this.thumbnailBarListener = dVar;
        return dVar;
    }

    private void disposeThumbnailBarListener() {
        d dVar = this.thumbnailBarListener;
        if (dVar != null) {
            yz.a(dVar.b);
            dVar.b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureEditingInspectorBound() {
        AnnotatingInspectorController editingInspectorController;
        DocumentView documentViewA = this.fragment.getInternal().getViewCoordinator().a(false);
        if (documentViewA == null || (editingInspectorController = getEditingInspectorController()) == null) {
            return;
        }
        editingInspectorController.bindController(documentViewA.getAnnotatingHandler());
    }

    private void ensureSharingMenuFragment() {
        if (this.sharingMenuFragment == null) {
            FragmentManager fragmentManager = this.internalPdfUi.getFragmentManager();
            PdfActivityConfiguration pdfActivityConfiguration = this.configuration;
            PdfFragment pdfFragment = this.fragment;
            int i = s10.s;
            s10 s10Var = (s10) fragmentManager.findFragmentByTag("com.pspdfkit.ui.SharingMenuFragment.FRAGMENT_TAG");
            if (s10Var == null) {
                s10Var = new s10();
            }
            s10Var.a = pdfFragment;
            if (pdfFragment.getDocument() != null) {
                s10Var.a();
            } else {
                pdfFragment.addDocumentListener(s10Var.r);
            }
            s10Var.g = pdfActivityConfiguration.getConfiguration().getEnabledShareFeatures().contains(ShareFeatures.DOCUMENT_SHARING);
            s10Var.h = DocumentPrintManager.get().isPrintingAvailable(pdfActivityConfiguration);
            s10Var.i = pdfActivityConfiguration.getActivityTitle();
            if (!s10Var.isAdded()) {
                FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
                fragmentTransactionBeginTransaction.add(s10Var, "com.pspdfkit.ui.SharingMenuFragment.FRAGMENT_TAG");
                fragmentTransactionBeginTransaction.commitNow();
            }
            this.sharingMenuFragment = s10Var;
        }
    }

    private ContentEditingInspectorController getContentEditingInspectorController() {
        if (this.contentEditingInspectorController == null && ar.b().d(this.configuration.getConfiguration())) {
            this.contentEditingInspectorController = new DefaultContentEditingInspectorController(this.activity, this.propertyInspectorCoordinatorLayout);
        }
        return this.contentEditingInspectorController;
    }

    private ContentEditingToolbar getContentEditingToolBar() {
        if (this.contentEditingToolBar == null && ar.b().d(this.configuration.getConfiguration())) {
            ContentEditingToolbar contentEditingToolbar = new ContentEditingToolbar(this.activity);
            this.contentEditingToolBar = contentEditingToolbar;
            ViewCompat.setElevation(contentEditingToolbar, this.toolbarElevation);
        }
        return this.contentEditingToolBar;
    }

    private AnnotatingInspectorController getCreationInspectorController() {
        if (this.annotationCreationInspectorController == null && this.configuration.getConfiguration().isAnnotationInspectorEnabled()) {
            this.annotationCreationInspectorController = new DefaultAnnotationCreationInspectorController(this.activity, this.propertyInspectorCoordinatorLayout);
        }
        return this.annotationCreationInspectorController;
    }

    private DocumentEditingToolbar getDocumentEditingToolbar() {
        if (this.documentEditingToolbar == null) {
            DocumentEditingToolbar documentEditingToolbar = new DocumentEditingToolbar(this.activity);
            this.documentEditingToolbar = documentEditingToolbar;
            ViewCompat.setElevation(documentEditingToolbar, this.toolbarElevation);
        }
        return this.documentEditingToolbar;
    }

    private AnnotatingInspectorController getEditingInspectorController() {
        if (this.annotationEditingInspectorController == null && this.configuration.getConfiguration().isAnnotationInspectorEnabled()) {
            this.annotationEditingInspectorController = new DefaultAnnotationEditingInspectorController(this.activity, this.propertyInspectorCoordinatorLayout);
        }
        return this.annotationEditingInspectorController;
    }

    private FormEditingInspectorController getFormEditingInspectorController() {
        if (this.formEditingInspectorController == null && this.configuration.getConfiguration().isFormEditingEnabled()) {
            this.formEditingInspectorController = new FormEditingInspectorController(this.activity, this.propertyInspectorCoordinatorLayout);
        }
        return this.formEditingInspectorController;
    }

    private int getManifestTheme() {
        try {
            return MAMPackageManagement.getActivityInfo(this.activity.getPackageManager(), this.activity.getComponentName(), 0).theme;
        } catch (PackageManager.NameNotFoundException unused) {
            throw new IllegalStateException("com.pspdfkit.ui.PdfActivity not found");
        }
    }

    private TextSelectionToolbar getTextSelectionToolbar() {
        if (this.textSelectionToolbar == null && !this.configuration.getConfiguration().isTextSelectionPopupToolbarEnabled()) {
            TextSelectionToolbar textSelectionToolbar = new TextSelectionToolbar(this.activity);
            this.textSelectionToolbar = textSelectionToolbar;
            ViewCompat.setElevation(textSelectionToolbar, this.toolbarElevation);
        }
        return this.textSelectionToolbar;
    }

    private void hideActions() {
        this.menuManager.d = false;
    }

    private void hideContentEditingStylingBar() {
        final ContentEditingStylingBar contentEditingStylingBar = ((jv) this.views).p;
        if (contentEditingStylingBar != null) {
            contentEditingStylingBar.post(new Runnable() { // from class: com.pspdfkit.internal.cw$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    contentEditingStylingBar.unbindController();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideMeasurementScaleUi() {
        o00 o00Var = this.selectedMeasurementValueConfigurationController;
        if (o00Var == null || ((jv) this.views).r == null) {
            return;
        }
        o00Var.b.setMeasurementScaleViewVisibility(false, true);
        ((jv) this.views).r.unbindController();
        this.userInterfaceCoordinator.v();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0037  */
    /* JADX WARN: Code duplicated, block: B:24:0x003d  */
    private void initSelectedMeasurementValueConfigurationController() {
        o00 o00Var;
        MeasurementScaleView measurementScaleView;
        lm lmVar = this.document;
        if (lmVar != null && (measurementScaleView = ((jv) this.views).r) != null) {
            this.selectedMeasurementValueConfigurationController = new o00(lmVar, measurementScaleView);
            return;
        }
        o00 o00Var2 = this.selectedMeasurementValueConfigurationController;
        if (o00Var2 != null) {
            if (e60.b == o00Var2) {
                if (Intrinsics.areEqual(e60.a, (Object) null)) {
                    MeasurementValueConfiguration measurementValueConfiguration = e60.a;
                    if (!Intrinsics.areEqual(measurementValueConfiguration != null ? measurementValueConfiguration.getName() : null, (Object) null)) {
                        e60.a = null;
                        o00Var = e60.b;
                        if (o00Var != null) {
                            o00Var.a(null);
                        }
                    }
                } else {
                    e60.a = null;
                    o00Var = e60.b;
                    if (o00Var != null) {
                        o00Var.a(null);
                    }
                }
                e60.b = null;
            }
            this.selectedMeasurementValueConfigurationController = null;
        }
    }

    private static boolean isInfiniteTimeout(long j) {
        return j >= SieveCacheKt.NodeLinkMask;
    }

    private boolean isUsingCustomFragmentTag() {
        Bundle pdfParameters = getPdfParameters();
        if (pdfParameters == null) {
            return false;
        }
        return !DEFAULT_PDF_FRAGMENT_TAG.equals(pdfParameters.getString("Nutri.PdfFragmentTag", DEFAULT_PDF_FRAGMENT_TAG));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onUserInterfaceEnabled$1(boolean z) {
        this.userInterfaceEnabled = z;
        refreshOptionsMenu();
        Bundle bundle = this.lastEnabledUiState;
        if (z) {
            if (bundle != null) {
                lm lmVar = this.document;
                if (lmVar != null) {
                    ((jv) this.views).setDocument(lmVar);
                }
                restoreUserInterfaceState(this.lastEnabledUiState);
                this.lastEnabledUiState = null;
            }
        } else if (bundle == null && this.document != null) {
            Bundle bundle2 = new Bundle();
            this.lastEnabledUiState = bundle2;
            saveUserInterfaceState(bundle2);
        }
        dv dvVar = this.userInterfaceCoordinator;
        dvVar.A = z;
        if (z) {
            dvVar.v();
            dvVar.j(true);
        } else {
            dvVar.d();
            dvVar.d(true);
        }
        PdfThumbnailBar pdfThumbnailBar = dvVar.E;
        if (pdfThumbnailBar != null) {
            pdfThumbnailBar.setEnabled(z);
        }
    }

    static /* synthetic */ PrintOptions lambda$performPrint$0(PrintOptions printOptions, PdfDocument pdfDocument, int i) {
        return printOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setFragment$2(MenuItem menuItem) {
        OnToolbarMenuChangedListener onToolbarMenuChangedListener = this.toolbarMenuListener;
        if (onToolbarMenuChangedListener == null || !onToolbarMenuChangedListener.onToolbarMenuItemClick(menuItem)) {
            return this.activity.onOptionsItemSelected(menuItem);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setFragment$3(MenuItem menuItem) {
        OnToolbarMenuChangedListener onToolbarMenuChangedListener = this.toolbarMenuListener;
        if (onToolbarMenuChangedListener == null || !onToolbarMenuChangedListener.onToolbarMenuItemClick(menuItem)) {
            return onOptionsItemSelected(menuItem);
        }
        return true;
    }

    private void refreshOptionsMenu() {
        AppCompatActivity appCompatActivity = this.activity;
        boolean z = appCompatActivity instanceof PdfUi;
        Toolbar toolbar = this.toolbar;
        if (z) {
            appCompatActivity.onPrepareOptionsMenu(toolbar.getMenu());
        } else {
            onPrepareOptionsMenu(toolbar.getMenu());
        }
        OnToolbarMenuChangedListener onToolbarMenuChangedListener = this.toolbarMenuListener;
        if (onToolbarMenuChangedListener != null) {
            onToolbarMenuChangedListener.onPrepareToolbarMenu(this.toolbar.getMenu());
        }
    }

    private void refreshPropertyInspectorCoordinatorLayout(dv dvVar) {
        this.propertyInspectorCoordinatorLayout.setDrawUnderBottomInset(!(dvVar.l && this.configuration.getThumbnailBarMode() == ThumbnailBarMode.THUMBNAIL_BAR_MODE_PINNED && dvVar.i()));
    }

    private void registerDocumentEditingToolbarListener(PdfThumbnailGrid pdfThumbnailGrid) {
        pdfThumbnailGrid.getDocumentEditingManager().addOnDocumentEditingModeChangeListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeKeepScreenOn() {
        MAMWindowManagement.clearFlags(this.activity.getWindow(), 128);
    }

    private void resetUI() {
        FragmentActivity fragmentActivity;
        FragmentActivity fragmentActivity2;
        s10 s10Var = this.sharingMenuFragment;
        if (s10Var != null) {
            SharingMenu sharingMenu = s10Var.j;
            if (sharingMenu != null) {
                sharingMenu.dismiss();
                s10Var.j = null;
            }
            se seVar = s10Var.k;
            if (seVar != null && (fragmentActivity2 = seVar.f) != null) {
                DocumentSharingDialog.hide(fragmentActivity2.getSupportFragmentManager());
            }
            be beVar = s10Var.l;
            if (beVar != null && (fragmentActivity = beVar.b) != null) {
                DocumentPrintDialog.hide(fragmentActivity.getSupportFragmentManager());
            }
        }
        this.toolbarCoordinatorLayout.removeContextualToolbar(false);
        AnnotationCreatorInputDialogFragment.hide(this.internalPdfUi.getFragmentManager());
    }

    private void restoreUserInterfaceState(Bundle bundle) {
        ContentEditingInspectorController contentEditingInspectorController;
        FormEditingInspectorController formEditingInspectorController;
        AnnotatingInspectorController editingInspectorController;
        AnnotatingInspectorController creationInspectorController;
        dv dvVar = this.userInterfaceCoordinator;
        dvVar.getClass();
        bundle.getClass();
        String string = bundle.getString("userInterfaceViewMode", dvVar.e.getUserInterfaceViewMode().toString());
        if (string == null) {
            string = dvVar.e.getUserInterfaceViewMode().toString();
        }
        dvVar.setUserInterfaceViewMode(UserInterfaceViewMode.valueOf(string));
        ((jv) this.views).onRestoreViewHierarchyState(bundle);
        this.isInAnnotationCreationMode = bundle.getBoolean(STATE_ANNOTATION_CREATION_ACTIVE);
        this.isInContentEditingMode = bundle.getBoolean(STATE_CONTENT_EDITING_ACTIVE);
        updateMenuIcons();
        PSPDFKitViews.Type type = PSPDFKitViews.Type.VIEW_NONE;
        PSPDFKitViews.Type typeValueOf = PSPDFKitViews.Type.valueOf(bundle.getString(STATE_ACTIVE_VIEW_ITEM, type.name()));
        im imVar = this.views;
        if (typeValueOf == type) {
            ((jv) imVar).toggleView(typeValueOf, 0L);
        } else {
            ((jv) imVar).showView(typeValueOf);
        }
        Bundle bundle2 = bundle.getBundle(STATE_ANNOTATION_CREATION_INSPECTOR);
        if (bundle2 != null && (creationInspectorController = getCreationInspectorController()) != null) {
            creationInspectorController.onRestoreInstanceState(bundle2);
        }
        Bundle bundle3 = bundle.getBundle(STATE_ANNOTATION_EDITING_INSPECTOR);
        if (bundle3 != null && (editingInspectorController = getEditingInspectorController()) != null) {
            editingInspectorController.onRestoreInstanceState(bundle3);
        }
        Bundle bundle4 = bundle.getBundle(STATE_FORM_EDITING_INSPECTOR);
        if (bundle4 != null && (formEditingInspectorController = getFormEditingInspectorController()) != null) {
            formEditingInspectorController.onRestoreInstanceState(bundle4);
        }
        Bundle bundle5 = bundle.getBundle(STATE_CONTENT_EDITING_INSPECTOR);
        if (bundle5 == null || (contentEditingInspectorController = getContentEditingInspectorController()) == null) {
            return;
        }
        contentEditingInspectorController.onRestoreInstanceState(bundle5);
    }

    private void saveUserInterfaceState(Bundle bundle) {
        dv dvVar = this.userInterfaceCoordinator;
        if (dvVar != null) {
            dvVar.getClass();
            bundle.getClass();
            bundle.putString("userInterfaceViewMode", dvVar.o.toString());
        }
        ((jv) this.views).onSaveViewHierarchyState(bundle);
        bundle.putString(STATE_ACTIVE_VIEW_ITEM, getActiveView().toString());
        bundle.putBoolean(STATE_ANNOTATION_CREATION_ACTIVE, this.isInAnnotationCreationMode);
        bundle.putBoolean(STATE_CONTENT_EDITING_ACTIVE, this.isInContentEditingMode);
        if (this.annotationCreationInspectorController != null) {
            Bundle bundle2 = new Bundle();
            this.annotationCreationInspectorController.onSaveInstanceState(bundle2);
            bundle.putBundle(STATE_ANNOTATION_CREATION_INSPECTOR, bundle2);
        }
        if (this.annotationEditingInspectorController != null) {
            Bundle bundle3 = new Bundle();
            this.annotationEditingInspectorController.onSaveInstanceState(bundle3);
            bundle.putBundle(STATE_ANNOTATION_EDITING_INSPECTOR, bundle3);
        }
        if (this.formEditingInspectorController != null) {
            Bundle bundle4 = new Bundle();
            this.formEditingInspectorController.onSaveInstanceState(bundle4);
            bundle.putBundle(STATE_FORM_EDITING_INSPECTOR, bundle4);
        }
        if (this.contentEditingInspectorController != null) {
            Bundle bundle5 = new Bundle();
            this.contentEditingInspectorController.onSaveInstanceState(bundle5);
            bundle.putBundle(STATE_CONTENT_EDITING_INSPECTOR, bundle5);
        }
    }

    private void setMeasurementScaleUi(AnnotatingController annotatingController) {
        MeasurementScaleView measurementScaleView;
        int i;
        if (this.selectedMeasurementValueConfigurationController == null || (measurementScaleView = ((jv) this.views).r) == null) {
            return;
        }
        measurementScaleView.bindController(annotatingController);
        AnnotationTool activeAnnotationTool = annotatingController.getActiveAnnotationTool();
        boolean z = activeAnnotationTool != null && ((i = p10.a.b[activeAnnotationTool.ordinal()]) == 1 || i == 2 || i == 3 || i == 4 || i == 5);
        o00 o00Var = this.selectedMeasurementValueConfigurationController;
        o00Var.b.setMeasurementScaleViewVisibility(z, true);
        if (z) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new p00(o00Var, null), 3, null);
        }
    }

    private void setupRedactionApplicator(wx wxVar) {
        this.redactionApplicator = wxVar;
        RedactionView redactionView = ((jv) this.views).q;
        if (redactionView != null) {
            redactionView.setListener(wxVar);
        }
    }

    private void showActions() {
        this.menuManager.d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showContentEditingStylingBar() {
        ContentEditingController contentEditingController;
        jv jvVar = (jv) this.views;
        if (jvVar.p == null || (contentEditingController = this.currentContentEditingController) == null) {
            return;
        }
        jvVar.p.bindController(contentEditingController);
    }

    private void showEditorsForSelectedAnnotation(AnnotatingController annotatingController) {
        if (annotatingController.hasCurrentlySelectedAnnotations()) {
            Annotation currentSingleSelectedAnnotation = annotatingController.getCurrentSingleSelectedAnnotation();
            if ((currentSingleSelectedAnnotation instanceof LineAnnotation) && ((LineAnnotation) currentSingleSelectedAnnotation).isCalibration()) {
                annotatingController.toggleAnnotationInspector();
            } else {
                if (currentSingleSelectedAnnotation == null || !currentSingleSelectedAnnotation.getInternal().isInstantCommentThreadRoot()) {
                    return;
                }
                annotatingController.showAnnotationEditor(currentSingleSelectedAnnotation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMeasurementScaleUiForSelection() {
        DocumentView documentViewA;
        if (this.selectedMeasurementValueConfigurationController == null || ((jv) this.views).r == null || (documentViewA = this.fragment.getInternal().getViewCoordinator().a(false)) == null) {
            return;
        }
        ((jv) this.views).r.bindController(documentViewA.getAnnotatingHandler());
        o00 o00Var = this.selectedMeasurementValueConfigurationController;
        o00Var.b.setMeasurementScaleViewVisibility(true, true);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new p00(o00Var, null), 3, null);
        this.userInterfaceCoordinator.d();
    }

    private void showSettingsDialog() {
        PdfConfiguration configuration = this.configuration.getConfiguration();
        SettingsDialog.show(this.internalPdfUi.getFragmentManager(), this, new SettingsOptions(configuration.getScrollDirection(), configuration.getScrollMode(), configuration.getLayoutMode(), configuration.getThemeMode(), this.screenTimeoutMillis, this.configuration.getSettingsMenuItemShown(), this.pspdfKitPreferences.isMeasurementSnappingEnabled().booleanValue(), this.pspdfKitPreferences.isSnapToSelfEnabled().booleanValue(), this.pspdfKitPreferences.isSmartGuidesEnabled().booleanValue()));
    }

    private void toggleAnnotationCreationMode() {
        if (this.fragment.getActiveAnnotationTool() != null) {
            this.fragment.exitCurrentlyActiveMode();
        } else {
            toggleView(PSPDFKitViews.Type.VIEW_NONE);
            this.fragment.clearSelectedAnnotations();
            this.fragment.enterAnnotatingMode();
        }
        updateMenuIcons();
    }

    private void toggleContentEditMode() {
        toggleView(PSPDFKitViews.Type.VIEW_NONE);
        this.fragment.enterContentEditingMode();
        updateMenuIcons();
    }

    private void toggleSignatureCreationMode() {
        if (this.fragment.getActiveAnnotationTool() != null) {
            this.fragment.exitCurrentlyActiveMode();
            this.isInAnnotationCreationMode = false;
        } else {
            toggleView(PSPDFKitViews.Type.VIEW_NONE);
            this.fragment.clearSelectedAnnotations();
            this.fragment.enterAnnotatingMode(AnnotationTool.SIGNATURE, AnnotationToolVariant.defaultVariant());
            this.isInAnnotationCreationMode = true;
        }
        updateMenuIcons();
    }

    private void toggleView(PSPDFKitViews.Type type, long j) {
        uw.a(type, "viewType", null);
        this.fragment.exitCurrentlyActiveMode();
        ((jv) this.views).toggleView(type, j);
    }

    private void unbindToolbarControllers() {
        ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
        if (toolbarCoordinatorLayout != null) {
            toolbarCoordinatorLayout.removeContextualToolbar(false);
        }
        AnnotationToolbar annotationToolbar = this.annotationToolbar;
        if (annotationToolbar != null) {
            annotationToolbar.unbindController();
        }
        DocumentEditingToolbar documentEditingToolbar = this.documentEditingToolbar;
        if (documentEditingToolbar != null) {
            documentEditingToolbar.unbindController();
        }
        TextSelectionToolbar textSelectionToolbar = this.textSelectionToolbar;
        if (textSelectionToolbar != null) {
            textSelectionToolbar.unbindController();
        }
        ContentEditingToolbar contentEditingToolbar = this.contentEditingToolBar;
        if (contentEditingToolbar != null) {
            contentEditingToolbar.unbindController();
        }
        AnnotatingInspectorController annotatingInspectorController = this.annotationCreationInspectorController;
        if (annotatingInspectorController != null) {
            annotatingInspectorController.unbindController();
        }
        AnnotatingInspectorController annotatingInspectorController2 = this.annotationEditingInspectorController;
        if (annotatingInspectorController2 != null) {
            annotatingInspectorController2.unbindController();
        }
    }

    private void updateMenuIcons() {
        bv.a aVar;
        int i = b.a[getActiveView().ordinal()];
        if (i == 1) {
            aVar = bv.a.THUMBNAIL_GRID;
        } else if (i == 2) {
            aVar = bv.a.OUTLINE;
        } else if (i == 3) {
            aVar = bv.a.READER_VIEW;
        } else if (i == 4) {
            aVar = bv.a.SEARCH;
        } else if (this.isInAnnotationCreationMode) {
            aVar = bv.a.ANNOTATION_CREATION;
        } else {
            aVar = this.isInContentEditingMode ? bv.a.CONTENT_EDITING : bv.a.NONE;
        }
        bv bvVar = this.menuConfiguration;
        bvVar.getClass();
        bvVar.e = aVar;
        refreshOptionsMenu();
    }

    private void updateRedactionUiForActiveTool(AnnotatingController annotatingController) {
        int i;
        AnnotationTool activeAnnotationTool = annotatingController.getActiveAnnotationTool();
        if (activeAnnotationTool == null || !((i = p10.a.b[activeAnnotationTool.ordinal()]) == 1 || i == 2 || i == 3 || i == 4 || i == 5)) {
            this.userInterfaceCoordinator.v();
        } else {
            this.userInterfaceCoordinator.d();
        }
    }

    private void updateTaskDescription() {
        TypedValue typedValue = new TypedValue();
        if (this.activity.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            this.activity.setTaskDescription(new ActivityManager.TaskDescription((String) null, 0, typedValue.data));
        }
    }

    @Override // com.pspdfkit.internal.gn.a
    public boolean attemptPrinting() {
        if (this.document == null || !DocumentPrintManager.get().isPrintingEnabled(this.configuration, this.document)) {
            return false;
        }
        ensureSharingMenuFragment();
        this.sharingMenuFragment.performPrint();
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.keyEventContract.a(keyEvent);
    }

    public void exitCurrentState() {
        this.fragment.exitCurrentlyActiveMode();
        toggleView(PSPDFKitViews.Type.VIEW_NONE);
    }

    public PSPDFKitViews.Type getActiveView() {
        return ((jv) this.views).getActiveViewType();
    }

    public Bundle getActivityState(boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        onSaveInstanceState(bundle, z, z2);
        return bundle;
    }

    public AnnotationToolbar getAnnotationToolbar() {
        if (this.annotationToolbar == null) {
            AnnotationToolbar annotationToolbar = new AnnotationToolbar(this.activity);
            this.annotationToolbar = annotationToolbar;
            ViewCompat.setElevation(annotationToolbar, this.toolbarElevation);
        }
        return this.annotationToolbar;
    }

    public PdfActivityConfiguration getConfiguration() {
        return this.configuration;
    }

    public int getContextualToolbarSizePx() {
        return this.toolbarCoordinatorLayout.getContextualToolbarSizePx();
    }

    public lm getDocument() {
        return this.document;
    }

    public DocumentCoordinator getDocumentCoordinator() {
        return this.documentCoordinator;
    }

    public PdfFragment getFragment() {
        return this.fragment;
    }

    public AppCompatActivity getHostingActivity() {
        return this.activity;
    }

    public Menu getMenu() {
        return this.toolbar.getMenu();
    }

    public int getPageIndex() {
        return this.fragment.getPageIndex();
    }

    public Bundle getPdfParameters() {
        return this.internalPdfUi.getPdfParameters();
    }

    public PropertyInspectorCoordinatorLayout getPropertyInspectorCoordinatorLayout() {
        return this.propertyInspectorCoordinatorLayout;
    }

    public long getScreenTimeout() {
        return this.screenTimeoutMillis;
    }

    public int getSiblingPageIndex(int i) {
        return this.fragment.getSiblingPageIndex(i);
    }

    public dv getUserInterfaceCoordinator() {
        return this.userInterfaceCoordinator;
    }

    public im getViews() {
        return this.views;
    }

    public void hideMainToolbar() {
        this.toolbar.setVisibility(8);
    }

    public void invalidateMenu() {
        Menu menu = this.toolbar.getMenu();
        if (menu != null) {
            menu.clear();
            AppCompatActivity appCompatActivity = this.activity;
            if (appCompatActivity instanceof PdfUi) {
                appCompatActivity.onCreateOptionsMenu(menu);
                this.activity.onPrepareOptionsMenu(menu);
            } else {
                onCreateOptionsMenu(menu);
                onPrepareOptionsMenu(menu);
            }
            OnToolbarMenuChangedListener onToolbarMenuChangedListener = this.toolbarMenuListener;
            if (onToolbarMenuChangedListener != null) {
                onToolbarMenuChangedListener.onCreateToolbarMenu(menu);
                this.toolbarMenuListener.onPrepareToolbarMenu(menu);
            }
        }
    }

    public boolean isDefaultViewerActive() {
        jv jvVar = (jv) this.views;
        PSPDFKitViews.PSPDFView viewByType = jvVar.getViewByType(jvVar.getActiveViewType());
        return viewByType == null || viewByType.getPSPDFViewType() == PSPDFKitViews.Type.VIEW_NONE;
    }

    public boolean isDocumentInteractionEnabled() {
        return this.documentInteractionEnabled;
    }

    public boolean isUserInterfaceEnabled() {
        return this.userInterfaceEnabled;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    @Override // com.pspdfkit.internal.gn.a
    public void navigateNextPage() {
        int i;
        lm lmVar = this.document;
        if (lmVar == null) {
            return;
        }
        AppCompatActivity appCompatActivity = this.activity;
        PdfConfiguration configuration = this.configuration.getConfiguration();
        appCompatActivity.getClass();
        lmVar.getClass();
        configuration.getClass();
        if (configuration.getScrollMode() == PageScrollMode.PER_PAGE) {
            boolean z = false;
            boolean z2 = configuration.getLayoutMode() == PageLayoutMode.DOUBLE;
            if (uc.d(appCompatActivity) && uc.a(appCompatActivity, 540) && configuration.getLayoutMode() == PageLayoutMode.AUTO) {
                z = true;
            }
            if (lmVar.getPageCount() <= 1 || !(z2 || z)) {
                i = 1;
            } else {
                i = 2;
            }
        } else {
            i = 1;
        }
        int iMin = Math.min(this.document.s - 1, this.fragment.getPageIndex() + i);
        if (iMin < this.document.s) {
            this.fragment.setPageIndex(iMin);
        }
    }

    @Override // com.pspdfkit.internal.gn.a
    public void navigatePreviousPage() {
        lm lmVar = this.document;
        if (lmVar == null) {
            return;
        }
        AppCompatActivity appCompatActivity = this.activity;
        PdfConfiguration configuration = this.configuration.getConfiguration();
        appCompatActivity.getClass();
        lmVar.getClass();
        configuration.getClass();
        int i = 1;
        if (configuration.getScrollMode() == PageScrollMode.PER_PAGE) {
            boolean z = configuration.getLayoutMode() == PageLayoutMode.DOUBLE;
            boolean z2 = uc.d(appCompatActivity) && uc.a(appCompatActivity, 540) && configuration.getLayoutMode() == PageLayoutMode.AUTO;
            if (lmVar.getPageCount() > 1 && (z || z2)) {
                i = 2;
            }
        }
        this.fragment.setPageIndex(Math.max(0, this.fragment.getPageIndex() - i));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public boolean onBackPressed() {
        ContextualToolbar currentlyDisplayedContextualToolbar = this.toolbarCoordinatorLayout.getCurrentlyDisplayedContextualToolbar();
        if (currentlyDisplayedContextualToolbar != null) {
            return currentlyDisplayedContextualToolbar.onBackPressed();
        }
        return ((jv) this.views).toggleView(getActiveView(), 0L);
    }

    @Override // com.pspdfkit.internal.dv.b
    public void onBindToUserInterfaceCoordinator(dv dvVar) {
        refreshPropertyInspectorCoordinatorLayout(dvVar);
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
    public void onChangeAnnotatingMode(AnnotatingController annotatingController) {
        setMeasurementScaleUi(annotatingController);
        updateRedactionUiForActiveTool(annotatingController);
        showEditorsForSelectedAnnotation(annotatingController);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioPlaybackModeChangeListener
    public void onChangeAudioPlaybackMode(AudioPlaybackController audioPlaybackController) {
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioRecordingModeChangeListener
    public void onChangeAudioRecordingMode(AudioRecordingController audioRecordingController) {
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public void onChangeFormElementEditingMode(FormEditingController formEditingController) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.userInterfaceCoordinator.onConfigurationChanged(configuration);
    }

    @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout.OnContextualToolbarPositionListener
    public void onContextualToolbarPositionChanged(ContextualToolbar contextualToolbar, ToolbarCoordinatorLayout.LayoutParams.Position position, ToolbarCoordinatorLayout.LayoutParams.Position position2) {
        ToolbarCoordinatorLayout.OnContextualToolbarPositionListener onContextualToolbarPositionListener = this.positionListener;
        if (onContextualToolbarPositionListener != null) {
            onContextualToolbarPositionListener.onContextualToolbarPositionChanged(contextualToolbar, position, position2);
        }
        this.userInterfaceCoordinator.onContextualToolbarPositionChanged(contextualToolbar, position, position2);
    }

    public void onCreate(Bundle bundle) {
        Bundle bundleRequirePdfParameters = requirePdfParameters();
        if (bundle == null) {
            bundle = bundleRequirePdfParameters.getBundle(PARAM_ACTIVITY_STATE);
        }
        try {
            PdfActivityConfiguration pdfActivityConfiguration = bundle != null ? (PdfActivityConfiguration) bundle.getParcelable(STATE_CONFIGURATION) : (PdfActivityConfiguration) bundleRequirePdfParameters.getParcelable("Nutri.Configuration");
            if (pdfActivityConfiguration == null) {
                throw new NullPointerException("Configuration is null");
            }
            this.configuration = pdfActivityConfiguration;
            SettingsDialog.restore(this.internalPdfUi.getFragmentManager(), this);
            try {
                AppCompatActivity appCompatActivity = this.activity;
                List<String> list = j00.a;
                appCompatActivity.getClass();
                if (!Nutrient.isInitialized()) {
                    j00.a(appCompatActivity).onErrorComplete().blockingAwait();
                    if (!Nutrient.isInitialized()) {
                        throw new NutrientNotInitializedException("Nutrient is not initialized!");
                    }
                }
                ThemeMode themeMode = this.configuration.getConfiguration().getThemeMode();
                ThemeMode themeMode2 = ThemeMode.NIGHT;
                PdfActivityConfiguration pdfActivityConfiguration2 = this.configuration;
                if (themeMode == themeMode2) {
                    if (pdfActivityConfiguration2.getDarkTheme() != -1) {
                        this.activity.setTheme(this.configuration.getDarkTheme());
                    } else if (getManifestTheme() == 0) {
                        this.activity.setTheme(com.pspdfkit.R.style.PSPDFKit_Theme_Dark);
                    }
                } else if (pdfActivityConfiguration2.getTheme() != -1) {
                    this.activity.setTheme(this.configuration.getTheme());
                } else if (getManifestTheme() == 0) {
                    this.activity.setTheme(com.pspdfkit.R.style.PSPDFKit_Theme_Default);
                }
                updateTaskDescription();
                try {
                    n70.a(this.activity);
                    this.activity.getTheme().applyStyle(com.pspdfkit.R.style.PSPDFKit_DefaultStyles, false);
                    View viewInflate = LayoutInflater.from(this.activity).inflate(this.configuration.getLayout(), (ViewGroup) null);
                    this.rootView = viewInflate;
                    if (viewInflate == null) {
                        throw new InvalidLayoutException("Root PDF activity view is null.");
                    }
                    ToolbarCoordinatorLayout toolbarCoordinatorLayout = (ToolbarCoordinatorLayout) viewInflate.findViewById(com.pspdfkit.R.id.pspdf__toolbar_coordinator);
                    this.toolbarCoordinatorLayout = toolbarCoordinatorLayout;
                    if (toolbarCoordinatorLayout == null) {
                        throw new InvalidLayoutException("The activity layout is missing the required ToolbarCoordinatorLayout with id 'R.id.pspdf__toolbar_coordinator'.");
                    }
                    toolbarCoordinatorLayout.setOnContextualToolbarPositionListener(this);
                    this.toolbarElevation = this.activity.getResources().getDimension(com.pspdfkit.R.dimen.pspdf__toolbar_elevation);
                    Toolbar toolbar = (Toolbar) this.rootView.findViewById(com.pspdfkit.R.id.pspdf__toolbar_main);
                    this.toolbar = toolbar;
                    if (toolbar == null) {
                        throw new InvalidLayoutException("The activity is missing the required Toolbar widget with id 'R.id.pspdf__toolbar_main'.");
                    }
                    if (!this.configuration.isDefaultToolbarEnabled()) {
                        hideMainToolbar();
                    }
                    Toolbar toolbar2 = this.toolbar;
                    toolbar2.setOverflowIcon(ContextCompat.getDrawable(toolbar2.getContext(), com.pspdfkit.R.drawable.pspdf__ic_more));
                    PropertyInspectorCoordinatorLayout propertyInspectorCoordinatorLayout = (PropertyInspectorCoordinatorLayout) this.rootView.findViewById(com.pspdfkit.R.id.pspdf__inspector_coordinator);
                    this.propertyInspectorCoordinatorLayout = propertyInspectorCoordinatorLayout;
                    if (propertyInspectorCoordinatorLayout == null) {
                        throw new InvalidLayoutException("The activity layout is missing the required PropertyInspectorCoordinatorLayout with id 'R.id.pspdf__inspector_coordinator'.");
                    }
                    bv bvVar = new bv(this.activity, this.pdfUi.getConfiguration());
                    this.menuConfiguration = bvVar;
                    PdfUi pdfUi = this.pdfUi;
                    this.menuManager = new av(bvVar, pdfUi, pdfUi);
                    this.actionResolver = new yu(this);
                    this.internalPdfUi.setPdfView(this.rootView);
                    String string = bundleRequirePdfParameters.getString("Nutri.PdfFragmentTag", DEFAULT_PDF_FRAGMENT_TAG);
                    if (this.rootView.findViewById(com.pspdfkit.R.id.pspdf__activity_fragment_container) == null) {
                        throw new InvalidLayoutException("The activity layout is missing the required ViewGroup with id 'R.id.pspdf__activity_fragment_container'.");
                    }
                    if (isUsingCustomFragmentTag()) {
                        if (bundle != null) {
                            this.fragmentContainerId = bundle.getInt(STATE_FRAGMENT_CONTAINER_ID);
                        } else {
                            this.fragmentContainerId = View.generateViewId();
                        }
                        FrameLayout frameLayout = new FrameLayout(getHostingActivity());
                        frameLayout.setId(this.fragmentContainerId);
                        ((FrameLayout) this.rootView.findViewById(com.pspdfkit.R.id.pspdf__activity_fragment_container)).addView(frameLayout, -1, -1);
                    } else {
                        this.fragmentContainerId = com.pspdfkit.R.id.pspdf__activity_fragment_container;
                    }
                    if (bundle == null) {
                        this.pendingInitialPage = this.configuration.getPage() != 0 ? this.configuration.getPage() : -1;
                        setDocument(bundleRequirePdfParameters);
                    } else {
                        this.pendingInitialPage = bundle.getInt(STATE_PENDING_INITIAL_PAGE);
                        PdfFragment pdfFragment = (PdfFragment) this.internalPdfUi.getFragmentManager().findFragmentByTag(string);
                        this.fragment = pdfFragment;
                        if (retainedDocument == null && pdfFragment != null && this.configuration.getConfiguration().equals(this.fragment.getConfiguration())) {
                            setFragment(this.fragment);
                        } else {
                            PdfDocument pdfDocument = retainedDocument;
                            if (pdfDocument != null) {
                                setDocument(pdfDocument);
                            } else {
                                PdfFragment pdfFragment2 = this.fragment;
                                if (pdfFragment2 == null) {
                                    setFragment(null);
                                } else if (pdfFragment2.getDocument() != null) {
                                    setDocument(this.fragment.getDocument());
                                } else {
                                    setDocument(bundleRequirePdfParameters);
                                }
                            }
                        }
                        setActivityState(bundle);
                    }
                    PdfOutlineView pdfOutlineView = ((jv) getViews()).l;
                    PdfUi pdfUi2 = this.pdfUi;
                    ViewModelStoreOwner viewModelStoreOwner = pdfUi2 instanceof ViewModelStoreOwner ? (ViewModelStoreOwner) pdfUi2 : this.activity;
                    if (pdfOutlineView != null) {
                        pdfOutlineView.setViewModelStoreOwner(viewModelStoreOwner);
                        pdfOutlineView.addOnDocumentInfoViewSaveListener(this);
                    }
                    PdfDocumentInfoView pdfDocumentInfoView = ((jv) getViews()).m;
                    if (pdfDocumentInfoView != null) {
                        pdfDocumentInfoView.setViewModelStoreOwner(viewModelStoreOwner);
                        pdfDocumentInfoView.addOnDocumentInfoViewSaveListener(this);
                    }
                    if (((jv) this.views).d != null && this.configuration.getTabBarHidingMode() != TabBarHidingMode.HIDE) {
                        ((jv) this.views).d.bindToDocumentCoordinator(this.documentCoordinator);
                    }
                    retainedDocument = null;
                    this.keyEventContract = new gn(this, this.configuration);
                    this.propertyInspectorCoordinatorLayout.addPropertyInspectorLifecycleListener(this);
                } catch (InvalidThemeException e2) {
                    this.activity.finish();
                    throw e2;
                }
            } catch (NutrientNotInitializedException e3) {
                this.activity.finish();
                throw e3;
            }
        } catch (Exception e4) {
            this.configuration = new PdfActivityConfiguration.Builder(this.activity).build();
            PdfLog.e("Nutri.PdfUiImpl", e4, "Failed creating a PDF Activity configuration from the saved state.  Creating a default configuration instead.", new Object[0]);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        int i;
        av avVar = this.menuManager;
        avVar.getClass();
        menu.getClass();
        if (menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
        menu.clear();
        List<Integer> listOnGenerateMenuItemIds = avVar.b.onGenerateMenuItemIds(avVar.a.a());
        listOnGenerateMenuItemIds.getClass();
        Iterator<Integer> it = listOnGenerateMenuItemIds.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Integer next = it.next();
            if (next != null) {
                menu.add(0, next.intValue(), 0, "");
            }
        }
        ArrayList arrayListA = avVar.a.a();
        int size = arrayListA.size();
        while (i < size) {
            Object obj = arrayListA.get(i);
            i++;
            int iIntValue = ((Number) obj).intValue();
            MenuItem menuItemFindItem = menu.findItem(iIntValue);
            if (menuItemFindItem != null) {
                menuItemFindItem.setTitle(avVar.a.b(iIntValue));
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00cb  */
    public void onDestroy() {
        o00 o00Var;
        dv dvVar = this.userInterfaceCoordinator;
        if (dvVar != null) {
            dvVar.a();
            dvVar.p();
            dvVar.d.removeOnDocumentsChangedListener(dvVar.G);
            hn.c cVar = dvVar.k;
            if (cVar != null) {
                cVar.b();
            }
            dvVar.k = null;
            yz.a(dvVar.F);
            dvVar.F = null;
            if (dvVar.e.getThumbnailBarMode() != ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE && dvVar.E != null) {
                dvVar.h(true);
            }
            iy iyVar = dvVar.C;
            if (iyVar != null) {
                DocumentCoordinator documentCoordinator = iyVar.f;
                if (documentCoordinator != null) {
                    documentCoordinator.removeOnDocumentVisibleListener(iyVar);
                }
                JobKt__JobKt.cancelChildren$default(iyVar.c.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
                iyVar.d = null;
                iyVar.e.clear();
            }
            dvVar.f = null;
            dvVar.j = null;
        }
        PdfFragment pdfFragment = this.fragment;
        if (pdfFragment != null) {
            removeListeners(pdfFragment);
        }
        this.propertyInspectorCoordinatorLayout.removePropertyInspectorLifecycleListener(this);
        cleanupRedactionApplicator();
        disposeThumbnailBarListener();
        jv jvVar = (jv) this.views;
        RedactionView redactionView = jvVar.q;
        if (redactionView != null) {
            redactionView.setListener(null);
        }
        PdfTabBar pdfTabBar = jvVar.d;
        if (pdfTabBar != null) {
            pdfTabBar.unbindDocumentCoordinator();
        }
        PdfOutlineView pdfOutlineView = jvVar.l;
        if (pdfOutlineView != null) {
            pdfOutlineView.onDestroy();
        }
        PdfThumbnailBar pdfThumbnailBar = jvVar.j;
        if (pdfThumbnailBar != null) {
            pdfThumbnailBar.setOnPageChangedListener(null);
        }
        ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
        if (toolbarCoordinatorLayout != null) {
            toolbarCoordinatorLayout.setOnContextualToolbarPositionListener(null);
        }
        ArrayList<DocumentDescriptor> arrayList = this.documentCoordinator.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            DocumentDescriptor documentDescriptor = arrayList.get(i);
            i++;
            documentDescriptor.setDocument(null);
        }
        unbindToolbarControllers();
        if (e60.b == this.selectedMeasurementValueConfigurationController) {
            if (Intrinsics.areEqual(e60.a, (Object) null)) {
                MeasurementValueConfiguration measurementValueConfiguration = e60.a;
                if (!Intrinsics.areEqual(measurementValueConfiguration != null ? measurementValueConfiguration.getName() : null, (Object) null)) {
                    e60.a = null;
                    o00Var = e60.b;
                    if (o00Var != null) {
                        o00Var.a(null);
                    }
                }
            } else {
                e60.a = null;
                o00Var = e60.b;
                if (o00Var != null) {
                    o00Var.a(null);
                }
            }
            e60.b = null;
        }
        lm lmVar = this.document;
        if (lmVar != null) {
            lmVar.K.b(this);
        }
        this.fragment = null;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onDisplayPropertyInspector(PropertyInspector propertyInspector) {
        if (this.isInContentEditingMode) {
            hideContentEditingStylingBar();
        }
        ((jv) this.views).a(false);
        this.toolbarCoordinatorLayout.setDescendantFocusability(393216);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public boolean onDocumentClick() {
        if (this.fragment.isInSpecialMode() || !this.fragment.getSelectedAnnotations().isEmpty()) {
            return false;
        }
        dv userInterfaceCoordinator = getUserInterfaceCoordinator();
        userInterfaceCoordinator.i.removeCallbacks(userInterfaceCoordinator.H);
        userInterfaceCoordinator.i.postDelayed(userInterfaceCoordinator.H, 100L);
        return false;
    }

    @Override // com.pspdfkit.ui.documentinfo.OnDocumentInfoViewSaveListener
    public void onDocumentInfoChangesSaved(PdfDocument pdfDocument) {
        refreshDocumentTitle(pdfDocument);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoadFailed(Throwable th) {
        refreshOptionsMenu();
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoaded(PdfDocument pdfDocument) {
        lm lmVar = (lm) pdfDocument;
        this.document = lmVar;
        lmVar.getClass();
        lmVar.K.a(this);
        bw bwVar = this.documentCoordinator;
        DocumentDescriptor documentDescriptor = bwVar.c;
        if (documentDescriptor != null) {
            documentDescriptor.setDocument(pdfDocument);
            DocumentDescriptor documentDescriptor2 = bwVar.c;
            Iterator<DocumentCoordinator.OnDocumentsChangedListener> it = bwVar.d.iterator();
            while (it.hasNext()) {
                it.next().onDocumentUpdated(documentDescriptor2);
            }
        }
        this.activityListener.onSetActivityTitle(this.configuration, pdfDocument);
        ((jv) this.views).setDocument(pdfDocument);
        if (this.pendingInitialPage > -1) {
            if (!this.fragment.getInternal().isLastViewedPageRestorationActiveAndIsConfigChange()) {
                this.fragment.setPageIndex(this.pendingInitialPage, false);
            }
            this.pendingInitialPage = -1;
        }
        PdfThumbnailGrid pdfThumbnailGrid = ((jv) this.views).k;
        if (pdfThumbnailGrid != null) {
            registerDocumentEditingToolbarListener(pdfThumbnailGrid);
        }
        if (((jv) this.views).q != null && this.configuration.isRedactionUiEnabled()) {
            AppCompatActivity appCompatActivity = this.activity;
            a70 a70Var = this.fragment.getConfiguration().isUndoEnabled() ? (a70) this.fragment.getUndoManager() : null;
            lm lmVar2 = this.document;
            setupRedactionApplicator(new wx(appCompatActivity, a70Var, lmVar2, lmVar2.getAnnotationProvider(), new lc(this.activity, l0.a()), this.pdfUi));
        }
        if (this.configuration.getConfiguration().isJavaScriptEnabled()) {
            an anVar = this.document.l;
            dn dnVar = this.activityJsPlatformDelegate;
            anVar.getClass();
            dnVar.getClass();
            or orVar = anVar.b;
            orVar.getClass();
            orVar.a.addFirst(dnVar);
        }
        refreshOptionsMenu();
        initSelectedMeasurementValueConfigurationController();
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
    public void onEnterAnnotatingMode(AnnotatingController annotatingController) {
        AnnotatingInspectorController editingInspectorController;
        AnnotatingInspectorController creationInspectorController = getCreationInspectorController();
        if (creationInspectorController != null) {
            creationInspectorController.bindController(annotatingController);
        }
        DocumentView documentViewA = this.fragment.getInternal().getViewCoordinator().a(false);
        if (documentViewA != null && (editingInspectorController = getEditingInspectorController()) != null) {
            editingInspectorController.bindController(documentViewA.getAnnotatingHandler());
        }
        getAnnotationToolbar().bindController(annotatingController);
        ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
        if (toolbarCoordinatorLayout != null) {
            toolbarCoordinatorLayout.displayContextualToolbar(getAnnotationToolbar(), true);
        }
        this.isInAnnotationCreationMode = true;
        updateMenuIcons();
        dv dvVar = this.userInterfaceCoordinator;
        if (true != dvVar.q) {
            dvVar.q = true;
            dvVar.o();
        }
        setMeasurementScaleUi(annotatingController);
        updateRedactionUiForActiveTool(annotatingController);
        showEditorsForSelectedAnnotation(annotatingController);
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioPlaybackModeChangeListener
    public void onEnterAudioPlaybackMode(AudioPlaybackController audioPlaybackController) {
        jv jvVar = (jv) this.views;
        if (jvVar.s != null) {
            jvVar.s.bindController(audioPlaybackController);
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioRecordingModeChangeListener
    public void onEnterAudioRecordingMode(AudioRecordingController audioRecordingController) {
        jv jvVar = (jv) this.views;
        if (jvVar.s != null) {
            jvVar.s.bindController(audioRecordingController);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingModeChangeListener
    public void onEnterContentEditingMode(ContentEditingController contentEditingController) {
        this.isInContentEditingMode = true;
        ContentEditingToolbar contentEditingToolBar = getContentEditingToolBar();
        if (contentEditingToolBar != null) {
            contentEditingToolBar.bindController(contentEditingController);
            ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
            if (toolbarCoordinatorLayout != null) {
                toolbarCoordinatorLayout.displayContextualToolbar(contentEditingToolBar, true);
                this.userInterfaceCoordinator.showUserInterface();
            }
            this.userInterfaceCoordinator.c(true);
            this.userInterfaceCoordinator.g(true);
            this.currentContentEditingController = contentEditingController;
            ContentEditingInspectorController contentEditingInspectorController = getContentEditingInspectorController();
            if (contentEditingInspectorController != null) {
                contentEditingInspectorController.bindContentEditingController(contentEditingController);
            }
            if (this.configuration.isDefaultToolbarEnabled()) {
                return;
            }
            this.userInterfaceCoordinator.B.isUiVisible(true);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.DocumentEditingManager.OnDocumentEditingModeChangeListener
    public void onEnterDocumentEditingMode(DocumentEditingController documentEditingController) {
        getDocumentEditingToolbar().bindController(documentEditingController);
        ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
        if (toolbarCoordinatorLayout != null) {
            toolbarCoordinatorLayout.displayContextualToolbar(getDocumentEditingToolbar(), true);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public void onEnterFormElementEditingMode(FormEditingController formEditingController) {
        PSPDFKitViews.Type activeViewType = ((jv) this.views).getActiveViewType();
        PSPDFKitViews.Type type = PSPDFKitViews.Type.VIEW_NONE;
        if (activeViewType != type) {
            ((jv) this.views).toggleView(type, 0L);
        }
        FormEditingInspectorController formEditingInspectorController = getFormEditingInspectorController();
        if (formEditingInspectorController != null) {
            formEditingInspectorController.setFormEditingBarEnabled(((jv) this.views).o != null);
            formEditingInspectorController.bindFormEditingController(formEditingController);
        }
        jv jvVar = (jv) this.views;
        if (jvVar.o != null) {
            jvVar.o.bindController(formEditingController);
        }
        this.userInterfaceCoordinator.c(true);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager.OnTextSelectionModeChangeListener
    public void onEnterTextSelectionMode(TextSelectionController textSelectionController) {
        TextSelectionToolbar textSelectionToolbar = getTextSelectionToolbar();
        if (textSelectionToolbar != null) {
            textSelectionToolbar.bindController(textSelectionController);
            ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
            if (toolbarCoordinatorLayout != null) {
                toolbarCoordinatorLayout.displayContextualToolbar(textSelectionToolbar, true);
                this.userInterfaceCoordinator.showUserInterface();
            }
            this.userInterfaceCoordinator.c(true);
        }
        textSelectionController.setOnSearchSelectedTextListener(this);
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener
    public void onExitAnnotatingMode(AnnotatingController annotatingController) {
        ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
        if (toolbarCoordinatorLayout != null) {
            toolbarCoordinatorLayout.removeContextualToolbar(true);
        }
        AnnotationToolbar annotationToolbar = this.annotationToolbar;
        if (annotationToolbar != null) {
            annotationToolbar.unbindController();
        }
        AnnotatingInspectorController annotatingInspectorController = this.annotationCreationInspectorController;
        if (annotatingInspectorController != null) {
            annotatingInspectorController.unbindController();
        }
        AnnotatingInspectorController annotatingInspectorController2 = this.annotationEditingInspectorController;
        if (annotatingInspectorController2 != null) {
            annotatingInspectorController2.unbindController();
        }
        MeasurementScaleView measurementScaleView = ((jv) this.views).r;
        if (measurementScaleView != null) {
            measurementScaleView.unbindController();
        }
        this.isInAnnotationCreationMode = false;
        updateMenuIcons();
        dv dvVar = this.userInterfaceCoordinator;
        if (dvVar.q) {
            dvVar.q = false;
            dvVar.o();
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioPlaybackModeChangeListener
    public void onExitAudioPlaybackMode(AudioPlaybackController audioPlaybackController) {
        jv jvVar = (jv) this.views;
        if (jvVar.s != null) {
            jvVar.s.unbindController();
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioModeListeners.AudioRecordingModeChangeListener
    public void onExitAudioRecordingMode(AudioRecordingController audioRecordingController) {
        jv jvVar = (jv) this.views;
        if (jvVar.s != null) {
            jvVar.s.unbindController();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingModeChangeListener
    public void onExitContentEditingMode(ContentEditingController contentEditingController) {
        if (this.contentEditingToolBar != null) {
            ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
            if (toolbarCoordinatorLayout != null) {
                toolbarCoordinatorLayout.removeContextualToolbar(true);
            }
            jv jvVar = (jv) this.views;
            if (jvVar.p != null) {
                jvVar.p.unbindController();
            }
            this.contentEditingToolBar.unbindController();
            this.userInterfaceCoordinator.i(true);
            this.userInterfaceCoordinator.g(false);
        }
        if (!this.configuration.isDefaultToolbarEnabled()) {
            this.userInterfaceCoordinator.B.isUiVisible(false);
        }
        ContentEditingInspectorController contentEditingInspectorController = this.contentEditingInspectorController;
        if (contentEditingInspectorController != null) {
            contentEditingInspectorController.unbindContentEditingController();
        }
        this.currentContentEditingController = null;
        this.isInContentEditingMode = false;
        updateMenuIcons();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.DocumentEditingManager.OnDocumentEditingModeChangeListener
    public void onExitDocumentEditingMode(DocumentEditingController documentEditingController) {
        ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
        if (toolbarCoordinatorLayout != null) {
            toolbarCoordinatorLayout.removeContextualToolbar(true);
        }
        DocumentEditingToolbar documentEditingToolbar = this.documentEditingToolbar;
        if (documentEditingToolbar != null) {
            documentEditingToolbar.unbindController();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementEditingModeChangeListener
    public void onExitFormElementEditingMode(FormEditingController formEditingController) {
        FormEditingInspectorController formEditingInspectorController = this.formEditingInspectorController;
        if (formEditingInspectorController != null) {
            formEditingInspectorController.unbindFormEditingController();
        }
        jv jvVar = (jv) this.views;
        if (jvVar.o != null) {
            jvVar.o.unbindController();
        }
        this.userInterfaceCoordinator.i(true);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager.OnTextSelectionModeChangeListener
    public void onExitTextSelectionMode(TextSelectionController textSelectionController) {
        textSelectionController.setOnSearchSelectedTextListener(null);
        if (this.textSelectionToolbar != null) {
            ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
            if (toolbarCoordinatorLayout != null) {
                toolbarCoordinatorLayout.removeContextualToolbar(true);
            }
            this.textSelectionToolbar.unbindController();
            this.userInterfaceCoordinator.i(true);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public void onFinishEditingContentBlock(String str) {
        String str2 = this.currentlyEditedBlockID;
        if (str == str2 || str2 == null) {
            hideContentEditingStylingBar();
            this.currentlyEditedBlockID = null;
        }
    }

    @Override // com.pspdfkit.listeners.OnVisibilityChangedListener
    public void onHide(View view) {
        if (view instanceof PdfSearchViewInline) {
            showActions();
            boolean zIsDefaultToolbarEnabled = this.configuration.isDefaultToolbarEnabled();
            Toolbar toolbar = this.toolbar;
            if (zIsDefaultToolbarEnabled) {
                toolbar.removeView(view);
                refreshOptionsMenu();
                this.userInterfaceCoordinator.m();
            } else {
                toolbar.removeView(view);
                this.toolbar.setVisibility(8);
                this.userInterfaceCoordinator.B.isUiVisible(false);
            }
            this.userInterfaceCoordinator.g(false);
            this.userInterfaceCoordinator.i(true);
        }
        updateMenuIcons();
    }

    @Override // com.pspdfkit.internal.lm.c
    public void onInternalDocumentSaveFailed(lm lmVar, Throwable th) {
    }

    @Override // com.pspdfkit.internal.lm.c
    public void onInternalDocumentSaved(lm lmVar) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return onOptionsItemSelectedById(menuItem.getItemId());
    }

    public boolean onOptionsItemSelectedById(int i) {
        if (i == PdfActivity.MENU_OPTION_THUMBNAIL_GRID) {
            toggleView(PSPDFKitViews.Type.VIEW_THUMBNAIL_GRID);
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_SEARCH) {
            toggleView(PSPDFKitViews.Type.VIEW_SEARCH, this.configuration.getSearchType() == SearchType.INLINE ? 300L : 0L);
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_OUTLINE) {
            toggleView(PSPDFKitViews.Type.VIEW_OUTLINE);
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_DOCUMENT_INFO) {
            toggleView(PSPDFKitViews.Type.VIEW_DOCUMENT_INFO);
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_READER_VIEW) {
            toggleView(PSPDFKitViews.Type.VIEW_READER);
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_EDIT_ANNOTATIONS) {
            toggleAnnotationCreationMode();
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_SIGNATURE) {
            toggleSignatureCreationMode();
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_EDIT_CONTENT) {
            toggleContentEditMode();
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_SETTINGS) {
            showSettingsDialog();
            return true;
        }
        if (i == PdfActivity.MENU_OPTION_SHARE) {
            showSharingMenu();
            return true;
        }
        if (i != PdfActivity.MENU_OPTION_AI_ASSISTANT) {
            return false;
        }
        AiAssistantHelpersKt.showAiAssistant(this.fragment.requireActivity(), null);
        return true;
    }

    @Override // com.pspdfkit.internal.lm.c
    public void onPageBindingChanged() {
        setConfiguration(getConfiguration(), true);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onPageChanged(PdfDocument pdfDocument, int i) {
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public boolean onPageClick(PdfDocument pdfDocument, int i, MotionEvent motionEvent, PointF pointF, Annotation annotation) {
        if (annotation != null || this.fragment.isInSpecialMode() || !this.fragment.getSelectedAnnotations().isEmpty()) {
            return false;
        }
        dv userInterfaceCoordinator = getUserInterfaceCoordinator();
        userInterfaceCoordinator.i.removeCallbacks(userInterfaceCoordinator.H);
        userInterfaceCoordinator.i.postDelayed(userInterfaceCoordinator.H, 100L);
        return false;
    }

    @Override // com.pspdfkit.internal.lm.c
    public void onPageRotationOffsetChanged() {
    }

    public void onPause() {
        this.handler.removeCallbacks(new cw$$ExternalSyntheticLambda1(this));
        MAMWindowManagement.clearFlags(this.activity.getWindow(), 128);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        PdfSearchView pdfSearchView;
        Drawable drawable;
        bv bvVar = this.menuConfiguration;
        PdfFragment pdfFragment = this.fragment;
        bvVar.d = (pdfFragment == null || !pdfFragment.isUserInterfaceEnabled()) ? null : this.document;
        av avVar = this.menuManager;
        avVar.getClass();
        menu.getClass();
        ArrayList arrayListA = avVar.a.a();
        int size = arrayListA.size();
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= size) {
                break;
            }
            Object obj = arrayListA.get(i);
            i++;
            int iIntValue = ((Number) obj).intValue();
            MenuItem menuItemFindItem = menu.findItem(iIntValue);
            if (menuItemFindItem != null) {
                bv bvVar2 = avVar.a;
                if (iIntValue == PdfActivity.MENU_OPTION_EDIT_ANNOTATIONS) {
                    boolean zC = bvVar2.c(iIntValue);
                    cv cvVar = bvVar2.c;
                    drawable = zC ? cvVar.k : cvVar.i;
                } else if (iIntValue == PdfActivity.MENU_OPTION_AI_ASSISTANT) {
                    drawable = bvVar2.c.j;
                } else if (iIntValue == PdfActivity.MENU_OPTION_EDIT_CONTENT) {
                    boolean zC2 = bvVar2.c(iIntValue);
                    cv cvVar2 = bvVar2.c;
                    drawable = zC2 ? cvVar2.m : cvVar2.l;
                } else if (iIntValue == PdfActivity.MENU_OPTION_SIGNATURE) {
                    boolean zC3 = bvVar2.c(iIntValue);
                    cv cvVar3 = bvVar2.c;
                    drawable = zC3 ? cvVar3.o : cvVar3.n;
                } else if (iIntValue == PdfActivity.MENU_OPTION_OUTLINE) {
                    boolean zC4 = bvVar2.c(iIntValue);
                    cv cvVar4 = bvVar2.c;
                    drawable = zC4 ? cvVar4.f : cvVar4.e;
                } else if (iIntValue == PdfActivity.MENU_OPTION_SEARCH) {
                    boolean zC5 = bvVar2.c(iIntValue);
                    cv cvVar5 = bvVar2.c;
                    drawable = zC5 ? cvVar5.h : cvVar5.g;
                } else if (iIntValue == PdfActivity.MENU_OPTION_SETTINGS) {
                    boolean zC6 = bvVar2.c(iIntValue);
                    cv cvVar6 = bvVar2.c;
                    drawable = zC6 ? cvVar6.s : cvVar6.r;
                } else if (iIntValue == PdfActivity.MENU_OPTION_READER_VIEW) {
                    boolean zC7 = bvVar2.c(iIntValue);
                    cv cvVar7 = bvVar2.c;
                    drawable = zC7 ? cvVar7.w : cvVar7.v;
                } else if (iIntValue == PdfActivity.MENU_OPTION_SHARE) {
                    boolean zContains = bvVar2.b.getConfiguration().getEnabledShareFeatures().contains(ShareFeatures.DOCUMENT_SHARING);
                    cv cvVar8 = bvVar2.c;
                    drawable = zContains ? cvVar8.p : cvVar8.q;
                } else if (iIntValue == PdfActivity.MENU_OPTION_THUMBNAIL_GRID) {
                    boolean zC8 = bvVar2.c(iIntValue);
                    cv cvVar9 = bvVar2.c;
                    drawable = zC8 ? cvVar9.d : cvVar9.c;
                } else if (iIntValue == PdfActivity.MENU_OPTION_DOCUMENT_INFO) {
                    boolean zC9 = bvVar2.c(iIntValue);
                    cv cvVar10 = bvVar2.c;
                    drawable = zC9 ? cvVar10.u : cvVar10.t;
                } else {
                    drawable = null;
                }
                if (drawable != null) {
                    drawable.setAlpha(bvVar2.d(iIntValue) ? 255 : 128);
                    boolean zC10 = bvVar2.c(iIntValue);
                    cv cvVar11 = bvVar2.c;
                    DrawableCompat.setTint(drawable, zC10 ? cvVar11.b : cvVar11.a);
                }
                menuItemFindItem.setIcon(drawable);
                av.a aVar = avVar.c;
                if (iIntValue == PdfActivity.MENU_OPTION_DOCUMENT_INFO || iIntValue == PdfActivity.MENU_OPTION_SETTINGS) {
                    i2 = 0;
                } else if (iIntValue != PdfActivity.MENU_OPTION_SHARE) {
                    i2 = 2;
                }
                menuItemFindItem.setShowAsAction(aVar.onGetShowAsAction(iIntValue, i2));
                menuItemFindItem.setEnabled(avVar.a.d(iIntValue));
            }
        }
        int size2 = menu.size();
        for (int i3 = 0; i3 < size2; i3++) {
            menu.getItem(i3).setVisible(avVar.d);
        }
        if (this.configuration.getSearchType() == SearchType.INLINE && (pdfSearchView = ((jv) this.views).u) != null && pdfSearchView.isShown()) {
            hideActions();
        }
        Drawable overflowIcon = this.toolbar.getOverflowIcon();
        if (overflowIcon != null) {
            overflowIcon.setTint(this.menuConfiguration.c.a);
        }
        return true;
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onPreparePropertyInspector(PropertyInspector propertyInspector) {
    }

    @Override // com.pspdfkit.ui.inspector.PropertyInspectorCoordinatorLayoutController.PropertyInspectorLifecycleListener
    public void onRemovePropertyInspector(PropertyInspector propertyInspector) {
        ContentEditingStylingBar contentEditingStylingBar;
        ((jv) this.views).a(true);
        this.toolbarCoordinatorLayout.setDescendantFocusability(262144);
        if (!this.isInContentEditingMode || this.currentlyEditedBlockID == null || (contentEditingStylingBar = ((jv) this.views).p) == null) {
            return;
        }
        contentEditingStylingBar.post(new Runnable() { // from class: com.pspdfkit.internal.cw$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showContentEditingStylingBar();
            }
        });
    }

    public void onResume() {
        setScreenTimeout(this.screenTimeoutMillis);
        FragmentManager fragmentManager = this.internalPdfUi.getFragmentManager();
        PdfActivityConfiguration pdfActivityConfiguration = this.configuration;
        PdfFragment pdfFragment = this.fragment;
        ActionMenuListener actionMenuListener = this.sharingMenuListener;
        DocumentSharingDialogFactory documentSharingDialogFactory = this.documentSharingDialogFactory;
        DocumentPrintDialogFactory documentPrintDialogFactory = this.documentPrintDialogFactory;
        SharingOptionsProvider sharingOptionsProvider = this.sharingOptionsProvider;
        PrintOptionsProvider printOptionsProvider = this.printOptionsProvider;
        int i = s10.s;
        s10 s10Var = (s10) fragmentManager.findFragmentByTag("com.pspdfkit.ui.SharingMenuFragment.FRAGMENT_TAG");
        if (s10Var != null) {
            s10Var.b = actionMenuListener;
            s10Var.e = documentSharingDialogFactory;
            s10Var.f = documentPrintDialogFactory;
            s10Var.c = sharingOptionsProvider;
            s10Var.d = printOptionsProvider;
            s10Var.g = pdfActivityConfiguration.getConfiguration().getEnabledShareFeatures().contains(ShareFeatures.DOCUMENT_SHARING);
            s10Var.h = DocumentPrintManager.get().isPrintingAvailable(pdfActivityConfiguration);
            s10Var.i = pdfActivityConfiguration.getActivityTitle();
            s10Var.a = pdfFragment;
            if (pdfFragment.getDocument() != null) {
                s10Var.a();
            } else {
                pdfFragment.addDocumentListener(s10Var.r);
            }
        }
        this.sharingMenuFragment = s10Var;
    }

    public void onSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle, false, true);
    }

    @Override // com.pspdfkit.ui.special_mode.controller.TextSelectionController.OnSearchSelectedTextListener
    public void onSearchSelectedText(String str) {
        this.userInterfaceCoordinator.showUserInterface();
        jv jvVar = (jv) this.views;
        if (jvVar.u != null && !jvVar.u.isDisplayed()) {
            toggleView(PSPDFKitViews.Type.VIEW_SEARCH);
        }
        PdfSearchView pdfSearchView = ((jv) this.views).u;
        if (pdfSearchView != null) {
            pdfSearchView.setInputFieldText(str, true);
        }
    }

    public void onSetActivityTitle(PdfDocument pdfDocument) {
        dv dvVar = this.userInterfaceCoordinator;
        if (dvVar != null) {
            dvVar.m();
        }
    }

    @Override // com.pspdfkit.ui.settings.SettingsDialogListener
    public void onSettingsClose() {
    }

    @Override // com.pspdfkit.ui.settings.SettingsDialogListener
    public void onSettingsSave(SettingsOptions settingsOptions) {
        setScreenTimeout(settingsOptions.getScreenTimeoutMillis());
        PdfConfiguration pdfConfigurationBuild = new PdfConfiguration.Builder(this.configuration.getConfiguration()).scrollDirection(settingsOptions.getScrollDirection()).scrollMode(settingsOptions.getScrollMode()).layoutMode(settingsOptions.getLayoutMode()).build();
        if (this.pspdfKitPreferences.isMeasurementSnappingEnabled().booleanValue() != settingsOptions.getSnapToPoint()) {
            this.pspdfKitPreferences.setMeasurementSnappingEnabled(settingsOptions.getSnapToPoint());
        }
        if (this.pspdfKitPreferences.isSnapToSelfEnabled().booleanValue() != settingsOptions.getSnapToSelf()) {
            this.pspdfKitPreferences.setSnapToSelfEnabled(settingsOptions.getSnapToSelf());
        }
        if (this.pspdfKitPreferences.isSmartGuidesEnabled().booleanValue() != settingsOptions.getShowSmartGuides()) {
            this.pspdfKitPreferences.setSmartGuidesEnabled(settingsOptions.getShowSmartGuides());
        }
        setConfiguration(new PdfActivityConfiguration.Builder(this.configuration).configuration(pdfConfigurationBuild).themeMode(settingsOptions.getThemeMode()).build());
    }

    @Override // com.pspdfkit.listeners.OnVisibilityChangedListener
    public void onShow(View view) {
        PdfFragment pdfFragment = this.fragment;
        if (pdfFragment != null) {
            pdfFragment.exitCurrentlyActiveMode();
        }
        this.userInterfaceCoordinator.showUserInterface();
        if ((view instanceof PdfSearchViewInline) || ((view instanceof PdfSearchViewLazy) && this.configuration.getSearchType() == SearchType.INLINE)) {
            hideActions();
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.toolbar;
            if (parent == toolbar) {
                toolbar.removeView(view);
            } else if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.toolbar.addView(view, new Toolbar.LayoutParams(-1, -1));
            if (!this.configuration.isDefaultToolbarEnabled()) {
                this.toolbar.setVisibility(0);
                this.userInterfaceCoordinator.B.isUiVisible(true);
            }
            this.userInterfaceCoordinator.g(true);
            this.userInterfaceCoordinator.c(true);
        }
        if (view instanceof PdfThumbnailGrid) {
            registerDocumentEditingToolbarListener((PdfThumbnailGrid) view);
        }
        updateMenuIcons();
    }

    public void onStart() {
        k kVar;
        synchronized (ar.class) {
            if (ar.e == null) {
                ar.e = new k();
            }
            kVar = ar.e;
        }
        AppCompatActivity appCompatActivity = this.activity;
        fk fkVar = this.userInterfaceCoordinator.h;
        Map<Class, WeakReference<Object>> map = kVar.a.get(appCompatActivity);
        if (map == null) {
            map = new HashMap<>();
            kVar.a.put(appCompatActivity, map);
        }
        map.put(fk.class, new WeakReference<>(fkVar));
        dv dvVar = this.userInterfaceCoordinator;
        if (dvVar != null) {
            if (dvVar.k == null) {
                dvVar.s();
            }
            dvVar.r();
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingContentChangeListener
    public void onStartEditingContentBlock(String str) {
        this.currentlyEditedBlockID = str;
        showContentEditingStylingBar();
    }

    public void onStop() {
        k kVar;
        synchronized (ar.class) {
            if (ar.e == null) {
                ar.e = new k();
            }
            kVar = ar.e;
        }
        kVar.a.remove(this.activity);
        dv dvVar = this.userInterfaceCoordinator;
        if (dvVar != null) {
            hn.c cVar = dvVar.k;
            if (cVar != null) {
                cVar.b();
            }
            dvVar.k = null;
        }
    }

    public void onTrimMemory(int i) {
        if (i == 10 || i == 15) {
            bw bwVar = this.documentCoordinator;
            ArrayList<DocumentDescriptor> arrayList = bwVar.b;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                DocumentDescriptor documentDescriptor = arrayList.get(i2);
                i2++;
                DocumentDescriptor documentDescriptor2 = documentDescriptor;
                if (documentDescriptor2 != bwVar.c) {
                    documentDescriptor2.setDocument(null);
                }
            }
        }
    }

    public void onUserInteraction() {
        setScreenTimeout(this.screenTimeoutMillis);
    }

    @Override // com.pspdfkit.internal.k70
    public void onUserInterfaceEnabled(final boolean z) {
        Runnable runnable = this.userInterfaceEnabledRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.pspdfkit.internal.cw$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onUserInterfaceEnabled$1(z);
            }
        };
        this.userInterfaceEnabledRunnable = runnable2;
        if (z) {
            runnable2.run();
        } else {
            this.handler.postDelayed(runnable2, 100L);
        }
    }

    @Override // com.pspdfkit.internal.dv.b
    public void onUserInterfaceViewModeChanged(UserInterfaceViewMode userInterfaceViewMode) {
        if (userInterfaceViewMode == UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_HIDDEN) {
            PSPDFKitViews.Type activeViewType = ((jv) this.views).getActiveViewType();
            PSPDFKitViews.Type type = PSPDFKitViews.Type.VIEW_NONE;
            if (activeViewType != type) {
                toggleView(type);
            }
        }
    }

    @Override // com.pspdfkit.internal.dv.b
    public void onUserInterfaceVisibilityChanged(boolean z) {
        refreshPropertyInspectorCoordinatorLayout(this.userInterfaceCoordinator);
        this.activityListener.onUserInterfaceVisibilityChanged(z);
    }

    public void onWindowFocusChanged(boolean z) {
        dv dvVar = this.userInterfaceCoordinator;
        if (dvVar != null) {
            fk fkVar = dvVar.h;
            if (z) {
                fkVar.b();
            } else {
                fkVar.getClass();
            }
        }
    }

    public void performPrint(final PrintOptions printOptions) {
        uw.a(printOptions, "printOptions", null);
        this.fragment.exitCurrentlyActiveMode();
        ((jv) this.views).toggleView(PSPDFKitViews.Type.VIEW_NONE, 0L);
        ensureSharingMenuFragment();
        this.sharingMenuFragment.d = new PrintOptionsProvider() { // from class: com.pspdfkit.internal.cw$$ExternalSyntheticLambda6
            @Override // com.pspdfkit.document.printing.PrintOptionsProvider
            public final PrintOptions createPrintOptions(PdfDocument pdfDocument, int i) {
                return cw.lambda$performPrint$0(printOptions, pdfDocument, i);
            }
        };
        this.sharingMenuFragment.performPrint();
    }

    public void refreshDocumentTitle(PdfDocument pdfDocument) {
        this.pdfUi.onSetActivityTitle(this.configuration, pdfDocument);
        dv dvVar = this.userInterfaceCoordinator;
        if (dvVar != null) {
            dvVar.w();
        }
        bw bwVar = this.documentCoordinator;
        ArrayList<DocumentDescriptor> arrayList = bwVar.b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            DocumentDescriptor documentDescriptor = arrayList.get(i);
            i++;
            DocumentDescriptor documentDescriptor2 = documentDescriptor;
            if (documentDescriptor2.getDocument() == pdfDocument) {
                Iterator<DocumentCoordinator.OnDocumentsChangedListener> it = bwVar.d.iterator();
                while (it.hasNext()) {
                    it.next().onDocumentUpdated(documentDescriptor2);
                }
                return;
            }
        }
    }

    public void removeListeners(PdfFragment pdfFragment) {
        pdfFragment.removeOnAnnotatingModeChangeListener(this);
        pdfFragment.removeOnTextSelectionModeChangeListener(this);
        pdfFragment.removeOnFormElementEditingModeChangeListener(this);
        pdfFragment.removeOnContentEditingModeChangeListener(this);
        pdfFragment.removeOnContentEditingContentChangeListener(this);
        pdfFragment.getAudioModeManager().removeAudioPlaybackModeChangeListener(this);
        pdfFragment.getAudioModeManager().removeAudioRecordingModeChangeListener(this);
        pdfFragment.removeDocumentListener(this);
        pdfFragment.getInternal().removeUserInterfaceListener(this);
        pdfFragment.removeDocumentActionListener(this.actionResolver);
        pdfFragment.removeDocumentListener(this.activityListener);
        pdfFragment.removeOnAnnotationSelectedListener(this.annotationSelectionListener);
        pdfFragment.removeDocumentScrollListener(this.documentScrollListener);
        AnnotationNoteHinter annotationNoteHinter = this.annotationNoteHinter;
        if (annotationNoteHinter != null) {
            pdfFragment.removeOnAnnotationUpdatedListener(annotationNoteHinter);
        }
        lm lmVar = this.document;
        if (lmVar != null) {
            an anVar = lmVar.l;
            dn dnVar = this.activityJsPlatformDelegate;
            anVar.getClass();
            dnVar.getClass();
            or orVar = anVar.b;
            orVar.getClass();
            orVar.a.b(dnVar);
        }
    }

    public Bundle requirePdfParameters() {
        Bundle pdfParameters = getPdfParameters();
        if (pdfParameters != null && pdfParameters.containsKey("Nutri.DocumentDescriptors") && pdfParameters.containsKey("Nutri.Configuration")) {
            return pdfParameters;
        }
        StringBuilder sb = new StringBuilder();
        if (pdfParameters != null) {
            if (!pdfParameters.containsKey("Nutri.DocumentDescriptors")) {
                sb.append("- Neither file paths nor data providers were set.\n");
            }
            if (!pdfParameters.containsKey("Nutri.Configuration")) {
                sb.append("- No configuration was passed.\n");
            }
        } else {
            sb.append("- Extras bundle was missing entirely.\n");
        }
        throw new IllegalArgumentException("PdfActivity was not initialized with proper arguments:\n" + ((Object) sb));
    }

    public void setActivityState(Bundle bundle) {
        Bundle bundle2;
        this.lastEnabledUiState = bundle.getBundle(STATE_LAST_ENABLED_UI_STATE);
        this.pendingInitialPage = bundle.getInt(STATE_PENDING_INITIAL_PAGE);
        Bundle bundle3 = bundle.getBundle(STATE_DOCUMENT_COORDINATOR);
        if (bundle3 != null) {
            bw bwVar = this.documentCoordinator;
            bwVar.getClass();
            ArrayList parcelableArrayList = bundle3.getParcelableArrayList("PdfActivityDocumentCoordinator.Documents");
            if (parcelableArrayList != null) {
                bwVar.b.clear();
                int size = parcelableArrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = parcelableArrayList.get(i);
                    i++;
                    bwVar.addDocument((DocumentDescriptor) obj);
                }
            }
            int i2 = bundle3.getInt("PdfActivityDocumentCoordinator.VisibleDocumentIndex", -1);
            if (i2 >= 0 && i2 < bwVar.b.size()) {
                DocumentDescriptor documentDescriptor = bwVar.b.get(i2);
                bwVar.c = documentDescriptor;
                Iterator<DocumentCoordinator.OnDocumentVisibleListener> it = bwVar.e.iterator();
                while (it.hasNext()) {
                    it.next().onDocumentVisible(documentDescriptor);
                }
            }
        }
        if (this.fragment != null && (bundle2 = bundle.getBundle(STATE_FRAGMENT)) != null) {
            this.fragment.setState(bundle2);
        }
        Bundle bundle4 = bundle.getBundle(STATE_UI_STATE);
        if (bundle4 != null) {
            restoreUserInterfaceState(bundle4);
        }
        setScreenTimeout(bundle.getLong(STATE_SCREEN_TIMEOUT, 0L));
    }

    public void setConfiguration(PdfActivityConfiguration pdfActivityConfiguration) {
        uw.a(pdfActivityConfiguration, "configuration", null);
        setConfiguration(pdfActivityConfiguration, false);
    }

    public void setContentViewTopPadding(int i) {
        this.toolbarCoordinatorLayout.setContentViewTopPadding(i);
    }

    public void setCreationInspectorController(AnnotatingInspectorController annotatingInspectorController) {
        uw.a(annotatingInspectorController, "creationInspectorController", null);
        this.annotationCreationInspectorController = annotatingInspectorController;
    }

    public void setDocument(Bundle bundle) {
        ArrayList parcelableArrayList;
        int i = 0;
        try {
            parcelableArrayList = bundle.getParcelableArrayList("Nutri.DocumentDescriptors");
        } catch (BadParcelableException e2) {
            PdfLog.e("Nutri.PdfUiImpl", e2, "Couldn't read previous state document descriptors. Falling back to empty list.", new Object[0]);
            parcelableArrayList = null;
        }
        int i2 = bundle.getInt("Nutri.VisibleDocumentDescriptorIndex", 0);
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            setFragment(null);
            return;
        }
        bw bwVar = this.documentCoordinator;
        bwVar.b.clear();
        int size = parcelableArrayList.size();
        while (i < size) {
            Object obj = parcelableArrayList.get(i);
            i++;
            bwVar.addDocument((DocumentDescriptor) obj);
        }
        this.documentCoordinator.setVisibleDocument((DocumentDescriptor) parcelableArrayList.get(i2));
    }

    public void setDocumentInteractionEnabled(boolean z) {
        this.documentInteractionEnabled = z;
        PdfFragment pdfFragment = this.fragment;
        if (pdfFragment != null) {
            pdfFragment.setDocumentInteractionEnabled(z);
        }
    }

    public void setDocumentPrintDialogFactory(DocumentPrintDialogFactory documentPrintDialogFactory) {
        this.documentPrintDialogFactory = documentPrintDialogFactory;
        s10 s10Var = this.sharingMenuFragment;
        if (s10Var != null) {
            s10Var.f = documentPrintDialogFactory;
        }
    }

    public void setDocumentSharingDialogFactory(DocumentSharingDialogFactory documentSharingDialogFactory) {
        this.documentSharingDialogFactory = documentSharingDialogFactory;
        s10 s10Var = this.sharingMenuFragment;
        if (s10Var != null) {
            s10Var.e = documentSharingDialogFactory;
        }
    }

    public void setEditingInspectorController(AnnotatingInspectorController annotatingInspectorController) {
        uw.a(annotatingInspectorController, "editingInspectorController", null);
        this.annotationEditingInspectorController = annotatingInspectorController;
    }

    public void setFragment(PdfFragment pdfFragment) {
        boolean zIsRedactionAnnotationPreviewEnabled;
        cw cwVar;
        PdfFragment pdfFragment2;
        Single<DocumentView> singleObserveOn;
        if (this.rootView == null) {
            throw new IllegalStateException("Root PdfActivity view is null. Something went wrong in onCreate.");
        }
        lm lmVar = this.document;
        if (lmVar != null) {
            lmVar.K.b(this);
        }
        this.document = null;
        PdfFragment pdfFragment3 = this.fragment;
        if (pdfFragment3 != null) {
            zIsRedactionAnnotationPreviewEnabled = pdfFragment3.isRedactionAnnotationPreviewEnabled();
            uv viewCoordinator = this.fragment.getInternal().getViewCoordinator();
            if (viewCoordinator.m.b()) {
                pn<DocumentView> pnVar = viewCoordinator.m;
                DocumentView documentView = pnVar.c;
                DocumentView documentView2 = documentView;
                if (documentView2 != null) {
                    singleObserveOn = Single.just(documentView2);
                } else if (documentView != null) {
                    singleObserveOn = Single.just(documentView);
                    singleObserveOn.getClass();
                } else {
                    singleObserveOn = pnVar.a.firstOrError().subscribeOn(pnVar.b).observeOn(AndroidSchedulers.mainThread());
                    singleObserveOn.getClass();
                }
                singleObserveOn.blockingGet().exitCurrentlyActiveMode();
                this.fragment.getAudioModeManager().exitActiveAudioMode();
            }
            removeListeners(this.fragment);
        } else {
            zIsRedactionAnnotationPreviewEnabled = false;
        }
        if (this.views == null) {
            jv jvVar = new jv(this.rootView, this.configuration);
            this.views = jvVar;
            jvVar.addOnVisibilityChangedListener(this);
            boolean z = this.activity instanceof PdfUi;
            Toolbar toolbar = this.toolbar;
            if (z) {
                toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.pspdfkit.internal.cw$$ExternalSyntheticLambda3
                    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        return this.f$0.lambda$setFragment$2(menuItem);
                    }
                });
            } else {
                toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() { // from class: com.pspdfkit.internal.cw$$ExternalSyntheticLambda4
                    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        return this.f$0.lambda$setFragment$3(menuItem);
                    }
                });
            }
            AppCompatActivity appCompatActivity = this.activity;
            boolean z2 = appCompatActivity instanceof PdfUi;
            Toolbar toolbar2 = this.toolbar;
            if (z2) {
                appCompatActivity.onCreateOptionsMenu(toolbar2.getMenu());
            } else {
                onCreateOptionsMenu(toolbar2.getMenu());
            }
            OnToolbarMenuChangedListener onToolbarMenuChangedListener = this.toolbarMenuListener;
            if (onToolbarMenuChangedListener != null) {
                onToolbarMenuChangedListener.onCreateToolbarMenu(this.toolbar.getMenu());
                this.toolbarMenuListener.onPrepareToolbarMenu(this.toolbar.getMenu());
            }
            PdfThumbnailGrid pdfThumbnailGrid = ((jv) this.views).k;
            if (pdfThumbnailGrid != null) {
                e eVar = new e();
                pdfThumbnailGrid.addOnPageClickListener(eVar);
                pdfThumbnailGrid.addOnDocumentSavedListener(eVar);
                registerDocumentEditingToolbarListener(pdfThumbnailGrid);
            }
            RedactionView redactionView = ((jv) this.views).q;
            if (redactionView != null) {
                redactionView.setRedactionAnnotationPreviewEnabled(zIsRedactionAnnotationPreviewEnabled);
            }
        }
        if (this.userInterfaceCoordinator == null) {
            cwVar = this;
            cwVar.userInterfaceCoordinator = new dv(this.activity, this.views, this.toolbarCoordinatorLayout, this.documentCoordinator, this.configuration, new jy(this.configuration.isRedactionUiEnabled(), ar.b().a(NativeLicenseFeatures.REDACTION)), cwVar, this.toolbar);
        } else {
            cwVar = this;
        }
        if (pdfFragment == null) {
            im imVar = cwVar.views;
            if (imVar != null) {
                ((jv) imVar).resetDocument();
                View view = ((jv) cwVar.views).t;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
            if (cwVar.fragment != null) {
                cwVar.internalPdfUi.getFragmentManager().beginTransaction().remove(cwVar.fragment).commitAllowingStateLoss();
            }
            cwVar.fragment = null;
            cwVar.activityListener.onSetActivityTitle(cwVar.configuration, null);
            cwVar.onUserInterfaceEnabled(false);
            cwVar.refreshOptionsMenu();
            return;
        }
        if (cwVar.configuration.isAnnotationNoteHintingEnabled()) {
            if (cwVar.annotationNoteHinter == null) {
                cwVar.annotationNoteHinter = new AnnotationNoteHinter(cwVar.activity);
            }
            pdfFragment.addDrawableProvider(cwVar.annotationNoteHinter);
        }
        cwVar.setupListeners(pdfFragment);
        pdfFragment.setUserInterfaceEnabled(cwVar.userInterfaceEnabled);
        pdfFragment.setDocumentInteractionEnabled(cwVar.documentInteractionEnabled);
        if (cwVar.fragment != pdfFragment) {
            pdfFragment.setRedactionAnnotationPreviewEnabled(zIsRedactionAnnotationPreviewEnabled);
            PdfFragment pdfFragment4 = cwVar.fragment;
            if (pdfFragment4 != null) {
                for (DocumentListener documentListener : pdfFragment4.getInternal().getDocumentListeners()) {
                    if (!(documentListener instanceof InternalDocumentListener)) {
                        pdfFragment.getInternal().getDocumentListeners().a(documentListener);
                    }
                }
            }
            if (cwVar.views != null && pdfFragment.getDocument() == null) {
                ((jv) cwVar.views).resetDocument();
            }
            cwVar.fragment = pdfFragment;
            s10 s10Var = cwVar.sharingMenuFragment;
            if (s10Var != null) {
                s10Var.a = pdfFragment;
                if (pdfFragment.getDocument() != null) {
                    s10Var.a();
                } else {
                    pdfFragment.addDocumentListener(s10Var.r);
                }
            }
            Bundle pdfParameters = cwVar.getPdfParameters();
            String string = DEFAULT_PDF_FRAGMENT_TAG;
            if (pdfParameters != null) {
                string = pdfParameters.getString("Nutri.PdfFragmentTag", DEFAULT_PDF_FRAGMENT_TAG);
            }
            cwVar.internalPdfUi.getFragmentManager().beginTransaction().replace(cwVar.fragmentContainerId, pdfFragment, string).commitAllowingStateLoss();
        }
        jv jvVar2 = (jv) cwVar.views;
        jvVar2.a = pdfFragment;
        if (jvVar2.j != null) {
            ThumbnailBarMode thumbnailBarMode = jvVar2.i.getThumbnailBarMode();
            ThumbnailBarMode thumbnailBarMode2 = ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE;
            PdfThumbnailBar pdfThumbnailBar = jvVar2.j;
            if (thumbnailBarMode != thumbnailBarMode2) {
                pdfThumbnailBar.setThumbnailBarMode(jvVar2.i.getThumbnailBarMode());
                jvVar2.a.addDocumentListener(jvVar2.j.getDocumentListener());
            } else {
                pdfThumbnailBar.setVisibility(8);
            }
        }
        PdfThumbnailGrid pdfThumbnailGrid2 = jvVar2.k;
        if (pdfThumbnailGrid2 != null && (pdfFragment2 = jvVar2.a) != null) {
            pdfFragment2.addDocumentListener(pdfThumbnailGrid2);
            boolean zIsThumbnailGridEnabled = jvVar2.i.isThumbnailGridEnabled();
            PdfThumbnailGrid pdfThumbnailGrid3 = jvVar2.k;
            if (zIsThumbnailGridEnabled) {
                pdfThumbnailGrid3.setShowPageLabels(jvVar2.i.isShowPageLabels());
                jvVar2.k.setDocumentEditorEnabled(jvVar2.g);
            } else {
                pdfThumbnailGrid3.setVisibility(8);
            }
        }
        if (jvVar2.u != null && jvVar2.a != null && jvVar2.i.isSearchEnabled()) {
            SearchConfiguration searchConfiguration = jvVar2.i.getSearchConfiguration();
            if (searchConfiguration == null) {
                searchConfiguration = new SearchConfiguration();
            }
            jvVar2.u.setSearchConfiguration(searchConfiguration);
            PdfSearchView pdfSearchView = jvVar2.u;
            if (pdfSearchView instanceof PdfSearchViewModular) {
                ((PdfSearchViewModular) pdfSearchView).setShowPageLabels(jvVar2.i.isShowPageLabels());
            }
            PdfSearchView pdfSearchView2 = jvVar2.u;
            if (pdfSearchView2 instanceof DocumentListener) {
                jvVar2.a.addDocumentListener((DocumentListener) pdfSearchView2);
            }
        }
        if (jvVar2.l != null && jvVar2.a != null) {
            boolean z3 = jvVar2.i.isDocumentInfoViewEnabled() && !jvVar2.i.isDocumentInfoViewSeparated();
            jvVar2.l.setMayContainDocumentInfoView(!jvVar2.i.isDocumentInfoViewSeparated());
            if (jvVar2.i.isOutlineEnabled() || jvVar2.i.isAnnotationListEnabled() || jvVar2.i.isBookmarkListEnabled() || z3) {
                PdfFragment pdfFragment5 = jvVar2.a;
                if (!(pdfFragment5 instanceof InstantPdfFragment)) {
                    jvVar2.l.setUndoManager(pdfFragment5.getUndoManager());
                }
                jvVar2.l.setOutlineViewEnabled(jvVar2.i.isOutlineEnabled(), false);
                jvVar2.l.setDocumentInfoViewEnabled(z3, false);
                jvVar2.l.setAnnotationListViewEnabled(jvVar2.i.isAnnotationListEnabled(), false);
                jvVar2.l.setBookmarkViewEnabled(jvVar2.i.isBookmarkListEnabled(), false);
                jvVar2.l.setDisplayEmbeddedFilesViewEnabled(jvVar2.i.isEmbeddedFilesViewEnabled());
                jvVar2.l.refreshViewPager();
                jvVar2.l.setShowPageLabels(jvVar2.i.isShowPageLabels());
                jvVar2.l.setListedAnnotationTypes(jvVar2.i.getListedAnnotationTypes());
                jvVar2.l.setAnnotationListReorderingEnabled(jvVar2.i.isAnnotationListReorderingEnabled());
            } else {
                jvVar2.l.setVisibility(8);
            }
            DefaultOutlineViewListener defaultOutlineViewListener = new DefaultOutlineViewListener(jvVar2.a);
            if (jvVar2.i.isAnnotationListEnabled()) {
                jvVar2.l.setOnAnnotationTapListener(defaultOutlineViewListener);
            }
            if (jvVar2.i.isOutlineEnabled()) {
                jvVar2.l.setOnOutlineElementTapListener(defaultOutlineViewListener);
            }
            if (jvVar2.i.isBookmarkListEnabled()) {
                jvVar2.l.setBookmarkAdapter(new DefaultBookmarkAdapter(jvVar2.a));
                jvVar2.a.addDocumentListener(jvVar2.l.getDocumentListener());
            }
            if (jvVar2.i.isEmbeddedFilesViewEnabled()) {
                jvVar2.l.setOnEmbeddedFileTapListener(defaultOutlineViewListener);
            }
        }
        PdfDocumentInfoView pdfDocumentInfoView = jvVar2.m;
        if (pdfDocumentInfoView != null && jvVar2.a != null) {
            pdfDocumentInfoView.setDocumentInfoViewEnabled(jvVar2.i.isDocumentInfoViewEnabled(), false);
        }
        cwVar.refreshOptionsMenu();
        PdfThumbnailBar pdfThumbnailBar2 = ((jv) cwVar.views).j;
        if (pdfThumbnailBar2 != null) {
            pdfThumbnailBar2.setOnPageChangedListener(cwVar.createThumbnailBarListener());
        }
        View view2 = ((jv) cwVar.views).t;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        if (((jv) cwVar.views).u != null) {
            SearchResultHighlighter searchResultHighlighter = new SearchResultHighlighter(cwVar.activity);
            pdfFragment.addDrawableProvider(searchResultHighlighter);
            ((jv) cwVar.views).u.setSearchViewListener(cwVar.new f(searchResultHighlighter));
        }
        if (((jv) cwVar.views).q != null) {
            cwVar.cleanupRedactionApplicator();
            ((jv) cwVar.views).q.lambda$setRedactionButtonVisible$5(false, true);
            ((jv) cwVar.views).q.setRedactionAnnotationPreviewEnabled(pdfFragment.isRedactionAnnotationPreviewEnabled());
            View view3 = ((jv) cwVar.views).f;
            if (view3 != null) {
                view3.animate().translationX(0.0f);
            }
        }
        dv dvVar = cwVar.userInterfaceCoordinator;
        dvVar.getClass();
        dvVar.p();
        boolean z4 = dvVar.j != null;
        dvVar.j = pdfFragment;
        if (!z4) {
            dvVar.setUserInterfaceViewMode(dvVar.e.getUserInterfaceViewMode());
        }
        PdfFragment pdfFragment6 = dvVar.j;
        if (pdfFragment6 != null) {
            pdfFragment6.addDocumentListener(dvVar);
            FormEditingBar formEditingBar = ((jv) dvVar.b).o;
            if (formEditingBar != null) {
                formEditingBar.addOnFormEditingBarLifecycleListener(dvVar);
            }
            ContentEditingStylingBar contentEditingStylingBar = ((jv) dvVar.b).p;
            if (contentEditingStylingBar != null) {
                contentEditingStylingBar.addOnContentEditingBarLifecycleListener(dvVar);
            }
            AudioView audioView = ((jv) dvVar.b).s;
            if (audioView != null) {
                audioView.addOnAudioInspectorLifecycleListener(dvVar);
            }
            iy iyVar = dvVar.C;
            if (iyVar != null) {
                pdfFragment6.addOnAnnotationUpdatedListener(iyVar);
            }
        }
        pdfFragment.setInsets(0, 0, 0, 0);
        dvVar.v = new na(pdfFragment, dvVar.b, dvVar.e.getConfiguration());
        pdfFragment.setDocumentCoordinator(cwVar.documentCoordinator);
        cwVar.activityListener.onSetActivityTitle(cwVar.configuration, null);
        PdfThumbnailGrid pdfThumbnailGrid4 = ((jv) cwVar.views).k;
        if (pdfThumbnailGrid4 != null) {
            pdfThumbnailGrid4.setOnPageClickListener(cwVar.new e());
        }
        cwVar.resetUI();
    }

    public void setOnContextualToolbarLifecycleListener(ToolbarCoordinatorLayout.OnContextualToolbarLifecycleListener onContextualToolbarLifecycleListener) {
        ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
        if (toolbarCoordinatorLayout != null) {
            toolbarCoordinatorLayout.setOnContextualToolbarLifecycleListener(onContextualToolbarLifecycleListener);
        }
    }

    public void setOnContextualToolbarMovementListener(ToolbarCoordinatorLayout.OnContextualToolbarMovementListener onContextualToolbarMovementListener) {
        ToolbarCoordinatorLayout toolbarCoordinatorLayout = this.toolbarCoordinatorLayout;
        if (toolbarCoordinatorLayout != null) {
            toolbarCoordinatorLayout.setOnContextualToolbarMovementListener(onContextualToolbarMovementListener);
        }
    }

    public void setOnContextualToolbarPositionListener(ToolbarCoordinatorLayout.OnContextualToolbarPositionListener onContextualToolbarPositionListener) {
        this.positionListener = onContextualToolbarPositionListener;
    }

    public void setOnToolbarMenuChangedListener(OnToolbarMenuChangedListener onToolbarMenuChangedListener) {
        this.toolbarMenuListener = onToolbarMenuChangedListener;
    }

    public void setPageIndex(int i) {
        this.fragment.setPageIndex(i);
    }

    public void setPrintOptionsProvider(PrintOptionsProvider printOptionsProvider) {
        this.printOptionsProvider = printOptionsProvider;
        s10 s10Var = this.sharingMenuFragment;
        if (s10Var != null) {
            s10Var.d = printOptionsProvider;
        }
    }

    public void setScreenTimeout(long j) {
        if (this.screenTimeoutMillis != j) {
            if (j < 0) {
                PdfLog.e("Nutri.PdfUiImpl", "screenTimeoutMillis cannot be a negative number", new Object[0]);
                return;
            }
            this.screenTimeoutMillis = j;
            if (j == 0) {
                MAMWindowManagement.clearFlags(this.activity.getWindow(), 128);
            } else if (isInfiniteTimeout(j)) {
                this.activity.getWindow().addFlags(128);
            }
        }
        if (j == 0 || isInfiniteTimeout(j)) {
            return;
        }
        this.handler.removeCallbacks(new cw$$ExternalSyntheticLambda1(this));
        this.activity.getWindow().addFlags(128);
        this.handler.postDelayed(new cw$$ExternalSyntheticLambda1(this), j);
    }

    public void setSharingActionMenuListener(ActionMenuListener actionMenuListener) {
        this.sharingMenuListener = actionMenuListener;
        s10 s10Var = this.sharingMenuFragment;
        if (s10Var != null) {
            s10Var.b = actionMenuListener;
        }
    }

    public void setSharingOptionsProvider(SharingOptionsProvider sharingOptionsProvider) {
        this.sharingOptionsProvider = sharingOptionsProvider;
        s10 s10Var = this.sharingMenuFragment;
        if (s10Var != null) {
            s10Var.c = sharingOptionsProvider;
        }
    }

    public void setUiVisibleCallback(UiVisibleCallback uiVisibleCallback) {
        dv dvVar = this.userInterfaceCoordinator;
        dvVar.getClass();
        uiVisibleCallback.getClass();
        dvVar.B = uiVisibleCallback;
    }

    public void setUserInterfaceEnabled(boolean z) {
        this.userInterfaceEnabled = z;
        PdfFragment pdfFragment = this.fragment;
        if (pdfFragment != null) {
            pdfFragment.setUserInterfaceEnabled(z);
        }
    }

    public void setupListeners(PdfFragment pdfFragment) {
        pdfFragment.addOnAnnotatingModeChangeListener(this);
        pdfFragment.addOnTextSelectionModeChangeListener(this);
        pdfFragment.addOnContentEditingModeChangeListener(this);
        pdfFragment.addOnContentEditingContentChangeListener(this);
        pdfFragment.addOnFormElementEditingModeChangeListener(this);
        pdfFragment.getAudioModeManager().addAudioPlaybackModeChangeListener(this);
        pdfFragment.getAudioModeManager().addAudioRecordingModeChangeListener(this);
        pdfFragment.addDocumentListener(this);
        pdfFragment.getInternal().addUserInterfaceListener(this);
        pdfFragment.addDocumentActionListener(this.actionResolver);
        pdfFragment.addDocumentListener(this.activityListener);
        pdfFragment.addOnAnnotationSelectedListener(this.annotationSelectionListener);
        pdfFragment.addDocumentScrollListener(this.documentScrollListener);
        AnnotationNoteHinter annotationNoteHinter = this.annotationNoteHinter;
        if (annotationNoteHinter != null) {
            pdfFragment.addOnAnnotationUpdatedListener(annotationNoteHinter);
        }
    }

    public void showPrintDialog() {
        this.fragment.exitCurrentlyActiveMode();
        ((jv) this.views).toggleView(PSPDFKitViews.Type.VIEW_NONE, 0L);
        ensureSharingMenuFragment();
        s10 s10Var = this.sharingMenuFragment;
        s10Var.d = this.printOptionsProvider;
        s10Var.f = this.documentPrintDialogFactory;
        s10Var.performPrint();
    }

    public void showSaveAsDialog() {
        this.fragment.exitCurrentlyActiveMode();
        ((jv) this.views).toggleView(PSPDFKitViews.Type.VIEW_NONE, 0L);
        ensureSharingMenuFragment();
        s10 s10Var = this.sharingMenuFragment;
        s10Var.c = this.sharingOptionsProvider;
        s10Var.e = this.documentSharingDialogFactory;
        s10Var.performSaveAs();
    }

    @Override // com.pspdfkit.internal.gn.a
    public void showSearchView() {
        jv jvVar = (jv) this.views;
        if (jvVar.u == null || jvVar.u.isDisplayed()) {
            return;
        }
        toggleView(PSPDFKitViews.Type.VIEW_SEARCH);
    }

    public void showSharingMenu() {
        this.fragment.exitCurrentlyActiveMode();
        if (this.fragment.getConfiguration().isAutosaveEnabled()) {
            this.fragment.save();
        }
        ((jv) this.views).toggleView(PSPDFKitViews.Type.VIEW_NONE, 0L);
        ensureSharingMenuFragment();
        s10 s10Var = this.sharingMenuFragment;
        s10Var.b = this.sharingMenuListener;
        s10Var.e = this.documentSharingDialogFactory;
        s10Var.f = this.documentPrintDialogFactory;
        s10Var.c = this.sharingOptionsProvider;
        s10Var.d = this.printOptionsProvider;
        s10Var.b();
    }

    public void testMenu() {
        Menu menu = this.toolbar.getMenu();
        this.toolbar.getMenu().clear();
        this.toolbar.invalidateMenu();
        this.activity.onCreateOptionsMenu(menu);
    }

    public void onSaveInstanceState(Bundle bundle, boolean z, boolean z2) {
        Bundle bundle2 = this.lastEnabledUiState;
        if (bundle2 != null && !bundle2.isEmpty()) {
            bundle.putBundle(STATE_LAST_ENABLED_UI_STATE, this.lastEnabledUiState);
        }
        Bundle bundle3 = new Bundle();
        saveUserInterfaceState(bundle3);
        bundle.putBundle(STATE_UI_STATE, bundle3);
        bundle.putParcelable(STATE_CONFIGURATION, this.configuration);
        bundle.putInt(STATE_PENDING_INITIAL_PAGE, this.pendingInitialPage);
        PdfFragment pdfFragment = this.fragment;
        if (pdfFragment != null && z) {
            bundle.putBundle(STATE_FRAGMENT, pdfFragment.getState());
        }
        if (z2) {
            Bundle bundle4 = new Bundle();
            bw bwVar = this.documentCoordinator;
            DocumentDescriptor documentDescriptor = bwVar.c;
            if (documentDescriptor != null) {
                documentDescriptor.setState(null);
            }
            bundle4.putParcelableArrayList("PdfActivityDocumentCoordinator.Documents", bwVar.b);
            DocumentDescriptor documentDescriptor2 = bwVar.c;
            bundle4.putInt("PdfActivityDocumentCoordinator.VisibleDocumentIndex", documentDescriptor2 != null ? bwVar.b.indexOf(documentDescriptor2) : -1);
            bundle.putBundle(STATE_DOCUMENT_COORDINATOR, bundle4);
        }
        bundle.putLong(STATE_SCREEN_TIMEOUT, getScreenTimeout());
        bundle.putInt(STATE_FRAGMENT_CONTAINER_ID, this.fragmentContainerId);
    }

    public void setPageIndex(int i, boolean z) {
        this.fragment.setPageIndex(i, z);
    }

    private void setConfiguration(PdfActivityConfiguration pdfActivityConfiguration, boolean z) {
        if (!pdfActivityConfiguration.equals(this.configuration) || z) {
            this.configuration = pdfActivityConfiguration;
            this.internalPdfUi.performApplyConfiguration(pdfActivityConfiguration);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleView(PSPDFKitViews.Type type) {
        toggleView(type, 0L);
    }

    public void setDocument(PdfDocument pdfDocument) {
        this.documentCoordinator.setDocument(DocumentDescriptor.fromDocument(pdfDocument));
    }
}
