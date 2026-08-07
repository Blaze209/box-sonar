package com.pspdfkit.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.method.ScrollingMovementMethod;
import android.util.Pair;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.Nutrient;
import com.pspdfkit.R;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationProviderRxJava;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.LinkAnnotation;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.annotations.actions.ActionResolver;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.ActionType;
import com.pspdfkit.annotations.actions.UriAction;
import com.pspdfkit.annotations.configuration.AnnotationConfigurationRegistry;
import com.pspdfkit.annotations.defaults.AnnotationPreferencesManager;
import com.pspdfkit.annotations.measurements.MeasurementValueConfiguration;
import com.pspdfkit.annotations.measurements.MeasurementValueConfigurationEditor;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.contentediting.inspector.ContentEditingFillColorConfiguration;
import com.pspdfkit.contentediting.inspector.defaults.ContentEditingPreferencesManager;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.datastructures.TextSelectionRectangles;
import com.pspdfkit.document.DocumentActionListener;
import com.pspdfkit.document.DocumentSaveOptions;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.ImageDocument;
import com.pspdfkit.document.ImageDocumentLoader;
import com.pspdfkit.document.ImageDocumentUtils;
import com.pspdfkit.document.OutlineElementState;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.PdfDocumentLoader;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.document.providers.ProgressDataProvider;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.exceptions.InvalidPasswordException;
import com.pspdfkit.exceptions.NutrientException;
import com.pspdfkit.exceptions.NutrientNotInitializedException;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormField;
import com.pspdfkit.forms.FormListeners;
import com.pspdfkit.forms.SignatureFormElement;
import com.pspdfkit.internal.a70;
import com.pspdfkit.internal.a80;
import com.pspdfkit.internal.an;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.at;
import com.pspdfkit.internal.au;
import com.pspdfkit.internal.b20;
import com.pspdfkit.internal.b30;
import com.pspdfkit.internal.bx;
import com.pspdfkit.internal.c5;
import com.pspdfkit.internal.c60;
import com.pspdfkit.internal.ca;
import com.pspdfkit.internal.cb;
import com.pspdfkit.internal.ci;
import com.pspdfkit.internal.db;
import com.pspdfkit.internal.dd;
import com.pspdfkit.internal.de;
import com.pspdfkit.internal.dq;
import com.pspdfkit.internal.e5;
import com.pspdfkit.internal.e60;
import com.pspdfkit.internal.eb;
import com.pspdfkit.internal.ed;
import com.pspdfkit.internal.f3;
import com.pspdfkit.internal.f60;
import com.pspdfkit.internal.fb;
import com.pspdfkit.internal.g60;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.gu;
import com.pspdfkit.internal.h6;
import com.pspdfkit.internal.h60;
import com.pspdfkit.internal.ho;
import com.pspdfkit.internal.hq;
import com.pspdfkit.internal.hu;
import com.pspdfkit.internal.i;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.i6;
import com.pspdfkit.internal.ie;
import com.pspdfkit.internal.j;
import com.pspdfkit.internal.j00;
import com.pspdfkit.internal.j6;
import com.pspdfkit.internal.je;
import com.pspdfkit.internal.jni.NativeDocumentData;
import com.pspdfkit.internal.jni.NativeDocumentDataStore;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativePageCache;
import com.pspdfkit.internal.jni.NativeRectDescriptor;
import com.pspdfkit.internal.jni.NativeTextParser;
import com.pspdfkit.internal.jni.NativeTextRange;
import com.pspdfkit.internal.jq;
import com.pspdfkit.internal.k70;
import com.pspdfkit.internal.l3;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.ln;
import com.pspdfkit.internal.m0;
import com.pspdfkit.internal.m30;
import com.pspdfkit.internal.mh;
import com.pspdfkit.internal.n30;
import com.pspdfkit.internal.n5;
import com.pspdfkit.internal.nb;
import com.pspdfkit.internal.o00;
import com.pspdfkit.internal.o3;
import com.pspdfkit.internal.or;
import com.pspdfkit.internal.p30;
import com.pspdfkit.internal.pn;
import com.pspdfkit.internal.q0;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.q7;
import com.pspdfkit.internal.r10;
import com.pspdfkit.internal.rm;
import com.pspdfkit.internal.s6;
import com.pspdfkit.internal.sv;
import com.pspdfkit.internal.t;
import com.pspdfkit.internal.t6;
import com.pspdfkit.internal.u;
import com.pspdfkit.internal.u40;
import com.pspdfkit.internal.ut;
import com.pspdfkit.internal.uv;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.v0;
import com.pspdfkit.internal.vb;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.internal.vt;
import com.pspdfkit.internal.vu;
import com.pspdfkit.internal.w4;
import com.pspdfkit.internal.w70;
import com.pspdfkit.internal.wa;
import com.pspdfkit.internal.wb;
import com.pspdfkit.internal.wu;
import com.pspdfkit.internal.ww;
import com.pspdfkit.internal.x50;
import com.pspdfkit.internal.x6;
import com.pspdfkit.internal.x70;
import com.pspdfkit.internal.xa;
import com.pspdfkit.internal.y5;
import com.pspdfkit.internal.y6;
import com.pspdfkit.internal.y7;
import com.pspdfkit.internal.yh;
import com.pspdfkit.internal.yz;
import com.pspdfkit.internal.z50;
import com.pspdfkit.internal.z60;
import com.pspdfkit.internal.z8;
import com.pspdfkit.internal.zd;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.listeners.OnDocumentLongPressListener;
import com.pspdfkit.listeners.OnPreparePopupToolbarListener;
import com.pspdfkit.listeners.scrolling.DocumentScrollListener;
import com.pspdfkit.listeners.scrolling.ScrollState;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.projection.ViewProjection;
import com.pspdfkit.signatures.storage.SignatureStorage;
import com.pspdfkit.ui.annotations.AnnotationViewsListener;
import com.pspdfkit.ui.annotations.OnAnnotatingModeChangeListener;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.annotations.OnAnnotationSelectedListener;
import com.pspdfkit.ui.audio.AudioModeManager;
import com.pspdfkit.ui.drawable.PdfDrawableManager;
import com.pspdfkit.ui.drawable.PdfDrawableProvider;
import com.pspdfkit.ui.navigation.NavigationBackStack;
import com.pspdfkit.ui.navigation.PageNavigator;
import com.pspdfkit.ui.overlay.OverlayViewProvider;
import com.pspdfkit.ui.rendering.AnnotationOverlayRenderStrategy;
import com.pspdfkit.ui.search.SearchResultHighlighter;
import com.pspdfkit.ui.special_mode.controller.AnnotationSelectionController;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import com.pspdfkit.ui.special_mode.manager.FormManager;
import com.pspdfkit.ui.special_mode.manager.TextSelectionManager;
import com.pspdfkit.undo.UndoManager;
import com.pspdfkit.undo.edit.Edit;
import com.pspdfkit.undo.edit.PageEdit;
import com.pspdfkit.utils.PdfLog;
import io.nutrient.domain.ai.AiAssistantProvider;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: loaded from: classes3.dex */
public class PdfFragment extends Fragment implements DocumentListener, DocumentScrollListener, PdfDrawableManager, ContentEditingManager, FormManager, TextSelectionManager, m30, PageNavigator, OnAnnotationSelectedListener, ActionResolver, FormManager.OnFormElementSelectedListener, FormManager.OnFormElementDeselectedListener, de.a, vb {
    public static final float DEFAULT_ZOOM = 1.0f;
    public static final String DOCUMENTSTORE_KEY_LAST_VIEWED_PAGE_INDEX = "Nutrient.lastViewedPage";
    public static final int DOCUMENT_VIEW_ID = R.id.pspdf__document_view;
    public static final float MAX_ZOOM = 26.0f;
    public static final float MIN_ZOOM = 0.9f;
    private static final String PARAM_AUDIO_MANAGER_STATE = "Nutrient.AudioManagerState";
    public static final String PARAM_CONFIGURATION = "Nutrient.Configuration";
    private static final String PARAM_CURRENT_VIEW_STATE = "Nutrient.ViewState";
    private static final String PARAM_DOCUMENT_LOADING_PROGRESS = "Nutrient.DocumentLoadingProgress";
    private static final String PARAM_FRAGMENT_STATE = "Nutrient.PSPDFFragmentState";
    public static final String PARAM_IMAGE_DOCUMENT_SOURCE = "Nutrient.ImageDocument.Source";
    private static final String PARAM_LAST_ENABLED_SPECIAL_MODE_STATE = "Nutrient.LastEnabledSpecialModeState";
    private static final String PARAM_MEDIA_CONTENT_STATES = "Nutrient.MediaContentStates";
    private static final String PARAM_NAVIGATION_HISTORY = "Nutrient.NavigationHistory";
    private static final String PARAM_PASSWORD = "Nutrient.UserP";
    private static final String PARAM_REDACTION_PREVIEW_STATE = "Nutrient.RedactionPreviewState";
    public static final String PARAM_SOURCES = "Nutrient.Sources";
    private static final String PARAM_SPECIAL_MODE_STATE = "Nutrient.SpecialModeState";
    private final u aiAssistantHighLighter;
    private AiAssistantProvider aiAssistantProvider;
    private Boolean animatePageTransition;
    private final y5 audioModeManager;
    private PdfConfiguration configuration;
    private final a70 contentEditingUndoManager;
    private final OnDocumentLongPressListener defaultOnDocumentLongPressListener;
    private int displayedPage;
    private lm document;
    private DocumentCoordinator documentCoordinator;
    private go<DocumentListener> documentListeners;
    private Disposable documentLoadDisposable;
    private Disposable documentLoadingProgressDisposable;
    de documentSaver;
    private final go<DocumentScrollListener> documentScrollListeners;
    List<DocumentSource> documentSources;
    private final FormListeners.OnFormFieldUpdatedListener formFieldUpdatedListener;
    private Bundle fragmentState;
    private boolean historyActionInProgress;
    private ImageDocument imageDocument;
    private DocumentSource imageDocumentSource;
    private int insetsBottom;
    private int insetsLeft;
    private int insetsRight;
    private int insetsTop;
    private final rm internalAPI;
    private final InternalDocumentListener internalDocumentListener;
    private boolean isDocumentInteractionEnabled;
    private boolean isUserInterfaceEnabled;
    private final sv javaScriptPlatformDelegate;
    private n30 lastEnabledSpecialModeState;
    private Disposable lastViewedPageRestorationDisposable;
    private CompositeDisposable lifecycleDisposable;
    private MeasurementValueConfigurationEditor measurementValueConfigurationEditor;
    private final q7.a<? super PageEdit> navigateOnUndoListener;
    private Integer navigationEndPage;
    private final NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> navigationHistory;
    private final NavigationBackStack.BackStackListener<NavigationBackStack.NavigationItem<Integer>> navigationItemBackStackListener;
    private Integer navigationStartPage;
    private OnDocumentLongPressListener onDocumentLongPressListener;
    private BehaviorSubject<Integer> pageChangeSubject;
    private String password;
    private final b20 signatureFormSigningHandler;
    private SignatureStorage signatureStorage;
    private float startZoomScale;
    private final a70 undoManager;
    private go<k70> userInterfaceListeners;
    private final uv viewCoordinator;
    private final ViewProjection viewProjectionImpl;
    private WeakReference<go<DocumentListener>> weakDocumentListeners;
    private final String LOG_TAG = "Nutri.PdfFragment";
    private boolean redactionAnnotationPreviewEnabled = false;

    public class InternalDocumentListener implements lm.c {
        private InternalDocumentListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInternalDocumentSaveFailed$2(lm lmVar, Throwable th) {
            PdfFragment.this.onDocumentSaveFailed(lmVar, th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInternalDocumentSaved$1(lm lmVar) {
            PdfFragment.this.onDocumentSaved(lmVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPageRotationOffsetChanged$0(int i, DocumentView documentView) {
            PdfFragment pdfFragment = PdfFragment.this;
            documentView.b(pdfFragment.document, pdfFragment);
            PdfFragment.this.setPageIndex(i, false);
        }

        @Override // com.pspdfkit.internal.lm.c
        public void onInternalDocumentSaveFailed(final lm lmVar, final Throwable th) {
            PdfFragment pdfFragment = PdfFragment.this;
            if (pdfFragment.document != lmVar) {
                return;
            }
            de deVar = pdfFragment.documentSaver;
            if (deVar == null || !deVar.c) {
                h60.a(new Runnable() { // from class: com.pspdfkit.ui.PdfFragment$InternalDocumentListener$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onInternalDocumentSaveFailed$2(lmVar, th);
                    }
                });
            }
        }

        @Override // com.pspdfkit.internal.lm.c
        public void onInternalDocumentSaved(final lm lmVar) {
            PdfFragment pdfFragment = PdfFragment.this;
            if (pdfFragment.document != lmVar) {
                return;
            }
            de deVar = pdfFragment.documentSaver;
            if (deVar == null || !deVar.c) {
                h60.a(new Runnable() { // from class: com.pspdfkit.ui.PdfFragment$InternalDocumentListener$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onInternalDocumentSaved$1(lmVar);
                    }
                });
            }
        }

        @Override // com.pspdfkit.internal.lm.c
        public final void onPageBindingChanged() {
        }

        @Override // com.pspdfkit.internal.lm.c
        public final void onPageRotationOffsetChanged() {
            PdfFragment pdfFragment = PdfFragment.this;
            if (pdfFragment.document != null) {
                pdfFragment.undoManager.clearHistory();
                final int pageIndex = PdfFragment.this.getPageIndex();
                PdfFragment.this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$InternalDocumentListener$$ExternalSyntheticLambda0
                    @Override // com.pspdfkit.internal.uv.c
                    public final void a(DocumentView documentView) {
                        this.f$0.lambda$onPageRotationOffsetChanged$0(pageIndex, documentView);
                    }
                }, false);
            }
        }
    }

    public PdfFragment() {
        a70 a70Var = new a70();
        this.undoManager = a70Var;
        this.contentEditingUndoManager = new a70();
        y5 y5Var = new y5(this, a70Var);
        this.audioModeManager = y5Var;
        this.documentScrollListeners = new go<>();
        b20 b20Var = new b20(this);
        this.signatureFormSigningHandler = b20Var;
        uv uvVar = new uv(this, a70Var, b20Var, y5Var);
        this.viewCoordinator = uvVar;
        this.defaultOnDocumentLongPressListener = new OnDocumentLongPressListener() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda11
            @Override // com.pspdfkit.listeners.OnDocumentLongPressListener
            public final boolean onDocumentLongPress(PdfDocument pdfDocument, int i, MotionEvent motionEvent, PointF pointF, Annotation annotation) {
                return this.f$0.lambda$new$0(pdfDocument, i, motionEvent, pointF, annotation);
            }
        };
        this.documentListeners = new go<>();
        this.weakDocumentListeners = new WeakReference<>(this.documentListeners);
        this.configuration = new PdfConfiguration.Builder().build();
        this.displayedPage = 0;
        this.startZoomScale = 1.0f;
        this.animatePageTransition = null;
        this.signatureStorage = null;
        this.measurementValueConfigurationEditor = null;
        this.formFieldUpdatedListener = new FormListeners.OnFormFieldUpdatedListener() { // from class: com.pspdfkit.ui.PdfFragment.1
            @Override // com.pspdfkit.forms.FormListeners.OnFormFieldUpdatedListener
            public void onFormFieldReset(FormField formField, FormElement formElement) {
            }

            @Override // com.pspdfkit.forms.FormListeners.OnFormFieldUpdatedListener
            public void onFormFieldUpdated(FormField formField) {
                DocumentView documentViewA = PdfFragment.this.viewCoordinator.a(false);
                if (documentViewA != null) {
                    documentViewA.a(formField);
                }
            }
        };
        this.javaScriptPlatformDelegate = new sv(this);
        this.userInterfaceListeners = new go<>();
        this.lastViewedPageRestorationDisposable = null;
        this.lifecycleDisposable = new CompositeDisposable();
        this.historyActionInProgress = false;
        this.navigationHistory = new NavigationBackStack<>();
        this.navigationStartPage = null;
        this.navigationEndPage = null;
        this.navigateOnUndoListener = new q7.a() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda12
            @Override // com.pspdfkit.internal.q7.a
            public final void a(q7 q7Var, Edit edit) {
                this.f$0.lambda$new$1(q7Var, (PageEdit) edit);
            }
        };
        this.navigationItemBackStackListener = new NavigationBackStack.BackStackListener<NavigationBackStack.NavigationItem<Integer>>() { // from class: com.pspdfkit.ui.PdfFragment.2
            @Override // com.pspdfkit.ui.navigation.NavigationBackStack.BackStackListener
            public void onBackStackChanged() {
            }

            @Override // com.pspdfkit.ui.navigation.NavigationBackStack.BackStackListener
            public void visitedItem(NavigationBackStack.NavigationItem<Integer> navigationItem) {
                PdfFragment pdfFragment = PdfFragment.this;
                pdfFragment.historyActionInProgress = true;
                pdfFragment.navigationHistory.addItem(navigationItem.getInverse());
                PdfFragment.this.setPageIndex(navigationItem.item.intValue(), false);
            }
        };
        this.isUserInterfaceEnabled = false;
        this.isDocumentInteractionEnabled = true;
        this.viewProjectionImpl = new w70(this, uvVar);
        this.internalDocumentListener = new InternalDocumentListener();
        this.internalAPI = new rm() { // from class: com.pspdfkit.ui.PdfFragment.3
            @Override // com.pspdfkit.internal.rm
            public void addUserInterfaceListener(k70 k70Var) {
                PdfFragment.this.userInterfaceListeners.a(k70Var);
            }

            @Override // com.pspdfkit.internal.rm
            public go<DocumentListener> getDocumentListeners() {
                return PdfFragment.this.documentListeners;
            }

            @Override // com.pspdfkit.internal.rm
            public uv getViewCoordinator() {
                return PdfFragment.this.viewCoordinator;
            }

            @Override // com.pspdfkit.internal.rm
            public boolean isLastViewedPageRestorationActiveAndIsConfigChange() {
                boolean z;
                Disposable disposable = PdfFragment.this.lastViewedPageRestorationDisposable;
                if (disposable == null || disposable.isDisposed()) {
                    return false;
                }
                synchronized (ar.class) {
                    z = ar.k;
                }
                return z;
            }

            @Override // com.pspdfkit.internal.rm
            public void removeUserInterfaceListener(k70 k70Var) {
                PdfFragment.this.userInterfaceListeners.b(k70Var);
            }

            @Override // com.pspdfkit.internal.rm
            public void setDocument(PdfDocument pdfDocument) {
                PdfFragment.this.resetDocument();
                PdfFragment.this.internalSetAndDisplayDocument((lm) pdfDocument, false);
            }
        };
        this.aiAssistantHighLighter = new u();
    }

    private void cancelRestorePagePosition() {
        yz.a(this.lastViewedPageRestorationDisposable);
        this.lastViewedPageRestorationDisposable = null;
    }

    private void copyUri(Context context, UriAction uriAction) {
        z8.a(uriAction.getUri(), "Link annotation URL", context, R.string.pspdf__text_copied_to_clipboard, 48);
    }

    private void displayDocument(lm lmVar) {
        this.viewCoordinator.c();
        this.viewCoordinator.a(lmVar);
        this.viewCoordinator.a(new uv.d() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda87
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                this.f$0.lambda$displayDocument$24(bVar);
            }
        }, false);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x002f  */
    private vt getPageEditorForCurrentPage() {
        au auVarB;
        DocumentView documentView = this.viewCoordinator.n;
        int iMax = Math.max(documentView == null ? -1 : documentView.getPage(), 0);
        uv uvVar = this.viewCoordinator;
        if (iMax >= 0) {
            DocumentView documentView2 = uvVar.n;
            if (documentView2 != null && documentView2.getDocument() != null) {
                auVarB = uvVar.n.b(iMax);
            }
            if (auVarB == null) {
                return null;
            }
            return auVarB.getPageEditor();
        }
        uvVar.getClass();
        auVarB = null;
        if (auVarB == null) {
            return null;
        }
        return auVarB.getPageEditor();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:14:0x001e  */
    private vt getPageEditorForPage(int i) {
        au auVarB;
        uv uvVar = this.viewCoordinator;
        if (i >= 0) {
            DocumentView documentView = uvVar.n;
            if (documentView != null && documentView.getDocument() != null) {
                auVarB = uvVar.n.b(i);
            }
            if (auVarB == null) {
                return null;
            }
            return auVarB.getPageEditor();
        }
        uvVar.getClass();
        auVarB = null;
        if (auVarB == null) {
            return null;
        }
        return auVarB.getPageEditor();
    }

    private n30 getSpecialModeState() {
        return new n30(getActiveAnnotationTool(), getActiveAnnotationToolVariant(), getSelectedAnnotations(), getSelectedFormElement(), getTextSelection(), getContentEditingState());
    }

    private void handleDocumentLoadingError(final Throwable th, final boolean z) {
        final String message = th == null ? "" : th.getMessage();
        this.viewCoordinator.c();
        this.viewCoordinator.a(new uv.d() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda32
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                this.f$0.lambda$handleDocumentLoadingError$23(message, z, th, bVar);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void internalSetAndDisplayDocument(lm lmVar, boolean z) {
        this.document = lmVar;
        InternalDocumentListener internalDocumentListener = this.internalDocumentListener;
        lmVar.getClass();
        internalDocumentListener.getClass();
        lmVar.K.a(internalDocumentListener);
        setEditListenerForAnnotationProvider(this.document.getAnnotationProvider());
        if (ar.b().a(NativeLicenseFeatures.MEASUREMENT_TOOLS)) {
            this.measurementValueConfigurationEditor = new dq(this.document, this, this.undoManager);
        }
        if (z) {
            this.document.invalidateCache();
        }
        lm lmVar2 = this.document;
        OutlineElementState outlineElementState = this.configuration.getOutlineElementState();
        lmVar2.getClass();
        outlineElementState.getClass();
        lmVar2.n = outlineElementState;
        if (this.viewCoordinator.a(false) != null) {
            displayDocument(this.document);
        }
    }

    private boolean isContentEditingActive() {
        return getContentEditingState() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$addAnnotationToPage$27(Annotation annotation, boolean z, Runnable runnable) throws Throwable {
        int pageIndex;
        vt pageEditorForPage;
        i0 i0VarA = ar.a();
        Bundle bundleA = z50.a(i0VarA);
        bundleA.putString(Analytics.Data.ANNOTATION_TYPE, annotation.getType().name());
        bundleA.putInt(Analytics.Data.PAGE_INDEX, annotation.getPageIndex());
        i0VarA.a(Analytics.Event.CREATE_ANNOTATION, bundleA);
        if (z && (pageIndex = annotation.getPageIndex()) >= 0 && (pageEditorForPage = getPageEditorForPage(pageIndex)) != null) {
            pageEditorForPage.a(true, (Collection<? extends Annotation>) Collections.singletonList(annotation));
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addAnnotationToPage$28(Throwable th) throws Throwable {
        PdfLog.e("Nutri.PdfFragment", th, "Unable to add annotation to page", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addAnnotationToPage$29(final Annotation annotation, final boolean z, final Runnable runnable, DocumentView documentView) {
        lm lmVar = this.document;
        if (lmVar == null) {
            return;
        }
        this.lifecycleDisposable.add(AnnotationProviderRxJava.addAnnotationToPageCompletable(lmVar.getAnnotationProvider(), annotation).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda66
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.lambda$addAnnotationToPage$27(annotation, z, runnable);
            }
        }, new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda67
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$addAnnotationToPage$28((Throwable) obj);
            }
        }));
    }

    static void lambda$addAnnotationViewsListener$100(AnnotationViewsListener annotationViewsListener, DocumentView documentView) {
        c5 c5Var = documentView.h0;
        if (c5Var == null) {
            throw new NullPointerException("annotationViewsFactory");
        }
        annotationViewsListener.getClass();
        c5Var.s.a(annotationViewsListener);
    }

    static /* synthetic */ void lambda$addDocumentActionListener$45(DocumentActionListener documentActionListener, DocumentView documentView) {
        ActionResolver actionResolver = documentView.getActionResolver();
        if (actionResolver != null) {
            actionResolver.addDocumentActionListener(documentActionListener);
        }
    }

    static void lambda$addOnAnnotatingModeChangeListener$64(OnAnnotatingModeChangeListener onAnnotatingModeChangeListener, DocumentView documentView) {
        q0 annotatingHandler = documentView.getAnnotatingHandler();
        annotatingHandler.getClass();
        onAnnotatingModeChangeListener.getClass();
        annotatingHandler.k.a(onAnnotatingModeChangeListener);
    }

    static void lambda$addOnAnnotatingModeSettingsChangeListener$66(OnAnnotatingModeSettingsChangeListener onAnnotatingModeSettingsChangeListener, DocumentView documentView) {
        q0 annotatingHandler = documentView.getAnnotatingHandler();
        annotatingHandler.getClass();
        onAnnotatingModeSettingsChangeListener.getClass();
        annotatingHandler.l.a(onAnnotatingModeSettingsChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$addOnAnnotationUpdatedListener$63(AnnotationProvider.OnAnnotationUpdatedListener onAnnotationUpdatedListener, DocumentView documentView) {
        lm lmVar = this.document;
        if (lmVar == null) {
            throw new IllegalStateException("Document has not yet been set. Cannot add listener.");
        }
        o3 annotationProvider = lmVar.getAnnotationProvider();
        annotationProvider.getClass();
        onAnnotationUpdatedListener.getClass();
        annotationProvider.h.a(onAnnotationUpdatedListener);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static void lambda$addOverlayViewProvider$59(OverlayViewProvider overlayViewProvider, DocumentView documentView) {
        documentView.getClass();
        uw.a(overlayViewProvider, "overlayViewProvider", null);
        hu<OverlayViewProvider> huVar = documentView.f;
        huVar.getClass();
        huVar.b.a(overlayViewProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$displayDocument$24(uv.b bVar) {
        if (this.onDocumentLongPressListener == null) {
            bVar.b.setOnDocumentLongPressListener(this.defaultOnDocumentLongPressListener);
        }
        this.viewCoordinator.d(false);
        this.viewCoordinator.b(false);
        refreshUserInterfaceState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$enterAnnotatingMode$73(final AnnotationTool annotationTool, final AnnotationToolVariant annotationToolVariant, final DocumentView documentView) {
        if (!ar.b().a(this.configuration)) {
            throw new NutrientException("Entering annotation creation mode for " + annotationTool + " is not permitted, either by the license or configuration.");
        }
        if (getAnnotationPreferences().isAnnotationCreatorSet()) {
            documentView.enterAnnotatingMode(annotationTool, annotationToolVariant);
            return;
        }
        AnnotationCreatorInputDialogFragment.show(getParentFragmentManager(), null, new AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener() { // from class: com.pspdfkit.ui.PdfFragment.6
            @Override // com.pspdfkit.ui.AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener
            public void onAbort() {
            }

            @Override // com.pspdfkit.ui.AnnotationCreatorInputDialogFragment.OnAnnotationCreatorSetListener
            public void onAnnotationCreatorSet(String str) {
                documentView.enterAnnotatingMode(annotationTool, annotationToolVariant);
            }
        });
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        i0VarA.a(Analytics.Event.SHOW_ANNOTATION_CREATOR_DIALOG, new Bundle());
    }

    static void lambda$enterFormEditingMode$77(FormElement formElement, DocumentView documentView) {
        documentView.getClass();
        if (ar.b().b(documentView.T, documentView.S) && ww.a(formElement)) {
            DocumentView.d dVar = documentView.D;
            DocumentView.d dVar2 = DocumentView.d.FORM_EDITING;
            if (dVar != dVar2) {
                if (dVar == DocumentView.d.ANNOTATING) {
                    documentView.E = true;
                } else {
                    documentView.E = false;
                    documentView.exitCurrentlyActiveMode();
                }
            }
            documentView.D = dVar2;
            documentView.J.a(formElement);
        }
    }

    static /* synthetic */ void lambda$executeAction$44(com.pspdfkit.annotations.actions.Action action, ActionSender actionSender, DocumentView documentView) {
        ActionResolver actionResolver = documentView.getActionResolver();
        if (actionResolver != null) {
            actionResolver.executeAction(action, actionSender);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleDocumentLoadingError$22(PdfPasswordView pdfPasswordView, String str) {
        setPassword(str);
        load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$handleDocumentLoadingError$23(String str, boolean z, Throwable th, uv.b bVar) {
        Single<uv.b> singleObserveOn;
        i0 i0VarA = ar.a();
        Bundle bundleA = z50.a(i0VarA);
        Charset charset = u40.a;
        bundleA.putString("value", str == null ? "" : str.toString());
        i0VarA.a(Analytics.Event.FAILED_DOCUMENT_LOAD, bundleA);
        this.viewCoordinator.c(false);
        if (!z) {
            bVar.b.setVisibility(4);
            this.viewCoordinator.d(false);
            this.viewCoordinator.b(true);
            if (th != null) {
                try {
                    Exceptions.throwIfFatal(th);
                } catch (Throwable th2) {
                    PdfLog.e("Nutri.PdfFragment", th2, "Fatal error while loading document.", new Object[0]);
                    if (getActivity() != null) {
                        getActivity().finish();
                    }
                    Thread threadCurrentThread = Thread.currentThread();
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadCurrentThread.getUncaughtExceptionHandler();
                    if (uncaughtExceptionHandler == null) {
                        throw th2;
                    }
                    uncaughtExceptionHandler.uncaughtException(threadCurrentThread, th);
                }
            }
            Iterator<DocumentListener> it = this.documentListeners.iterator();
            while (it.hasNext()) {
                it.next().onDocumentLoadFailed(th != null ? th : new RuntimeException(str));
            }
            PdfLog.e("Nutri.PdfFragment", th, "Failed to open document.", new Object[0]);
            return;
        }
        pn<uv.b> pnVar = this.viewCoordinator.l;
        uv.b bVar2 = pnVar.c;
        if (bVar2 != null) {
            singleObserveOn = Single.just(bVar2);
            singleObserveOn.getClass();
        } else {
            singleObserveOn = pnVar.a.firstOrError().subscribeOn(pnVar.b).observeOn(AndroidSchedulers.mainThread());
            singleObserveOn.getClass();
        }
        uv.b bVarBlockingGet = singleObserveOn.blockingGet();
        if (bVarBlockingGet.d == null) {
            PdfPasswordView pdfPasswordView = new PdfPasswordView(bVarBlockingGet.a.getContext());
            bVarBlockingGet.d = pdfPasswordView;
            pdfPasswordView.setId(R.id.pspdf__fragment_password_view);
            bVarBlockingGet.d.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            bVarBlockingGet.d.setVisibility(8);
        }
        PdfPasswordView pdfPasswordView2 = bVarBlockingGet.d;
        if (pdfPasswordView2.getVisibility() == 0) {
            pdfPasswordView2.showPasswordError();
        }
        bVar.b.setVisibility(4);
        this.viewCoordinator.b(false);
        this.viewCoordinator.d(true);
        pdfPasswordView2.setOnPasswordSubmitListener(new PdfPasswordView.OnPasswordSubmitListener() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda42
            @Override // com.pspdfkit.ui.PdfPasswordView.OnPasswordSubmitListener
            public final void onPasswordSubmit(PdfPasswordView pdfPasswordView3, String str2) {
                this.f$0.lambda$handleDocumentLoadingError$22(pdfPasswordView3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$highlight$19(Context context, List list, int i, uv.b bVar) {
        u uVar = this.aiAssistantHighLighter;
        uVar.getClass();
        context.getClass();
        list.getClass();
        if (uVar.c == null) {
            uVar.c = new SearchResultHighlighter(context);
        }
        if (!Intrinsics.areEqual(uVar.b, this)) {
            uVar.b = this;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new t(uVar, this, i, list, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$13() throws Throwable {
        this.documentLoadDisposable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$14(ImageDocument imageDocument, Throwable th) throws Throwable {
        try {
            if (th != null) {
                throw th;
            }
            if (imageDocument == null || imageDocument.getDocument() == null) {
                handleDocumentLoadingError(null, false);
            } else {
                internalSetAndDisplayDocument((lm) imageDocument.getDocument(), true);
                this.imageDocument = imageDocument;
            }
            Disposable disposable = this.documentLoadingProgressDisposable;
            if (disposable != null) {
                disposable.dispose();
                this.documentLoadingProgressDisposable = null;
                this.viewCoordinator.a();
            }
        } catch (Throwable th2) {
            handleDocumentLoadingError(th2, false);
        }
    }

    static /* synthetic */ Double lambda$load$15(Object[] objArr) throws Throwable {
        double dDoubleValue = 0.0d;
        for (Object obj : objArr) {
            dDoubleValue += ((Double) obj).doubleValue();
        }
        return Double.valueOf(dDoubleValue / ((double) objArr.length));
    }

    static /* synthetic */ void lambda$load$16(Throwable th) throws Throwable {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$17() throws Throwable {
        this.documentLoadDisposable = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$18(PdfDocument pdfDocument, Throwable th) throws Throwable {
        if (pdfDocument != null) {
            internalSetAndDisplayDocument((lm) pdfDocument, true);
        } else {
            handleDocumentLoadingError(th, (th instanceof InvalidPasswordException) && this.documentSources.size() == 1);
        }
        Disposable disposable = this.documentLoadingProgressDisposable;
        if (disposable != null) {
            disposable.dispose();
            this.documentLoadingProgressDisposable = null;
            this.viewCoordinator.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(PdfDocument pdfDocument, int i, MotionEvent motionEvent, PointF pointF, Annotation annotation) {
        com.pspdfkit.annotations.actions.Action action;
        if (annotation != null && getView() != null) {
            getView().performHapticFeedback(0);
            if ((annotation instanceof LinkAnnotation) && (action = ((LinkAnnotation) annotation).getAction()) != null && action.getType() == ActionType.URI) {
                previewUri(requireContext(), (UriAction) action);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(q7 q7Var, PageEdit pageEdit) {
        if (pageEdit.getPageIndex() != getPageIndex()) {
            beginNavigation();
            setPageIndex(pageEdit.getPageIndex());
            endNavigation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAnnotationsCopied$53() {
        Toast.makeText(getContext(), R.string.pspdf__annotation_copied, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAnnotationsCut$55() {
        Toast.makeText(getContext(), R.string.pspdf__annotation_cut, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAnnotationsPasted$54(List list) {
        setSelectedAnnotations(list);
        Toast.makeText(getContext(), R.string.pspdf__annotation_pasted, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConfigurationChanged$8(Bundle bundle, DocumentView documentView) {
        setState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer lambda$onDocumentLoaded$47(PdfDocument pdfDocument, ed edVar) throws Throwable {
        edVar.getClass();
        String uid = pdfDocument.getUid();
        NativeDocumentDataStore nativeDocumentDataStore = edVar.a;
        NativeDocumentData nativeDocumentData = nativeDocumentDataStore.get(uid);
        dd ddVar = new dd(nativeDocumentDataStore, nativeDocumentData);
        int iIntValue = this.displayedPage;
        synchronized (ddVar) {
            Integer num = nativeDocumentData.getInt(DOCUMENTSTORE_KEY_LAST_VIEWED_PAGE_INDEX);
            if (num != null) {
                iIntValue = num.intValue();
            }
        }
        return Integer.valueOf(iIntValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDocumentLoaded$48(PdfDocument pdfDocument, Integer num) throws Throwable {
        this.displayedPage = (num.intValue() < 0 || num.intValue() >= pdfDocument.getPageCount()) ? this.displayedPage : num.intValue();
        restorePagePosition(pdfDocument);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDocumentLoaded$49(Throwable th) throws Throwable {
        PdfLog.e("Nutri.PdfFragment", th, "Unable to initialize document data store to restore the last viewed page.", new Object[0]);
    }

    static void lambda$onDocumentLoaded$50(PdfDocument pdfDocument, ed edVar) throws Throwable {
        edVar.getClass();
        String uid = pdfDocument.getUid();
        NativeDocumentDataStore nativeDocumentDataStore = edVar.a;
        NativeDocumentData nativeDocumentData = nativeDocumentDataStore.get(uid);
        synchronized (new dd(nativeDocumentDataStore, nativeDocumentData)) {
            nativeDocumentData.clearKey(DOCUMENTSTORE_KEY_LAST_VIEWED_PAGE_INDEX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDocumentLoaded$51(Throwable th) throws Throwable {
        PdfLog.e("Nutri.PdfFragment", th, "Unable to initialize document data store to clear the last viewed page.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onDocumentLoaded$52(final PdfDocument pdfDocument, lm lmVar, DocumentView documentView) throws Throwable {
        de deVar = this.documentSaver;
        if (deVar == null || deVar.a != pdfDocument) {
            this.documentSaver = new de(lmVar, this);
        }
        prepareUndoManager(pdfDocument);
        refreshUserInterfaceState();
        pdfDocument.initPageCache();
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        i0VarA.a(Analytics.Event.LOAD_DOCUMENT, new Bundle());
        Bundle bundle = this.fragmentState;
        if (bundle != null) {
            setState(bundle);
            this.fragmentState = null;
        } else {
            PSPDFKitPreferences.get(requireContext()).setLastAnnotationTool(AnnotationTool.NONE);
            if (this.configuration.isLastViewedPageRestorationEnabled()) {
                this.lastViewedPageRestorationDisposable = ed.b().map(new Function() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda75
                    @Override // io.reactivex.rxjava3.functions.Function
                    public final Object apply(Object obj) {
                        return this.f$0.lambda$onDocumentLoaded$47(pdfDocument, (ed) obj);
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda76
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(Object obj) throws Throwable {
                        this.f$0.lambda$onDocumentLoaded$48(pdfDocument, (Integer) obj);
                    }
                }, new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda77
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(Object obj) throws Throwable {
                        this.f$0.lambda$onDocumentLoaded$49((Throwable) obj);
                    }
                });
            } else {
                ed.b().subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda78
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(Object obj) throws Throwable {
                        PdfFragment.lambda$onDocumentLoaded$50(pdfDocument, (ed) obj);
                    }
                }, new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda79
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(Object obj) throws Throwable {
                        this.f$0.lambda$onDocumentLoaded$51((Throwable) obj);
                    }
                });
                restorePagePosition(pdfDocument);
            }
        }
        pdfDocument.getFormProvider().addOnFormFieldUpdatedListener(this.formFieldUpdatedListener);
        lmVar.getClass();
        lmVar.o = new wb(lmVar, this);
        lmVar.l.setJavaScriptEnabled(this.configuration.isJavaScriptEnabled());
        if (this.configuration.isJavaScriptEnabled()) {
            an anVar = lmVar.l;
            sv svVar = this.javaScriptPlatformDelegate;
            anVar.getClass();
            svVar.getClass();
            or orVar = anVar.b;
            orVar.getClass();
            orVar.a.addFirst(svVar);
        }
        Iterator<DocumentListener> it = this.documentListeners.iterator();
        while (it.hasNext()) {
            it.next().onDocumentLoaded(pdfDocument);
        }
        pdfDocument.getFormProvider().addOnFormFieldUpdatedListener(this.formFieldUpdatedListener);
    }

    static CompletableSource lambda$onStop$10(PdfDocument pdfDocument, Boolean bool) throws Throwable {
        if (!bool.booleanValue()) {
            return new CompletableSource() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda63
                @Override // io.reactivex.rxjava3.core.CompletableSource
                public final void subscribe(CompletableObserver completableObserver) {
                    completableObserver.onComplete();
                }
            };
        }
        ut utVar = q10.b;
        if (utVar == null) {
            utVar = new ut(NativePageCache.create(15728640));
            q10.b = utVar;
        }
        return utVar.a(pdfDocument.getUid(), pdfDocument.getPageCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$prepareContentEditingUndoManager$56(DocumentView documentView) {
        a70 a70Var = this.contentEditingUndoManager;
        wa waVar = new wa(documentView.getContentEditingHandler(), this.navigateOnUndoListener);
        synchronized (a70Var) {
            z60 z60Var = a70Var.d;
            z60Var.getClass();
            z60Var.a.put(waVar.a, waVar);
        }
        this.contentEditingUndoManager.a(new fb(documentView.getContentEditingHandler(), this.navigateOnUndoListener));
        this.contentEditingUndoManager.a(new db(documentView.getContentEditingHandler(), this.navigateOnUndoListener));
        this.contentEditingUndoManager.a(new eb(documentView.getContentEditingHandler(), this.navigateOnUndoListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewUri$42(UriAction uriAction, AlertDialog alertDialog, View view) {
        executeAction(uriAction);
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewUri$43(Context context, UriAction uriAction, AlertDialog alertDialog, View view) {
        copyUri(context, uriAction);
        alertDialog.dismiss();
    }

    static void lambda$refreshPages$7(List list, uv.b bVar) {
        if (list.isEmpty()) {
            DocumentView documentView = bVar.b;
            if (documentView.getChildCount() == 0) {
                documentView.e();
            }
            documentView.l();
            documentView.k();
            if (documentView.a0 == -1) {
                documentView.a0 = documentView.getPage();
            }
            documentView.f(documentView.a0);
        }
    }

    static void lambda$removeAnnotationViewsListener$101(AnnotationViewsListener annotationViewsListener, DocumentView documentView) {
        c5 c5Var = documentView.h0;
        if (c5Var == null) {
            return;
        }
        annotationViewsListener.getClass();
        c5Var.s.b(annotationViewsListener);
    }

    static /* synthetic */ void lambda$removeDocumentActionListener$46(DocumentActionListener documentActionListener, DocumentView documentView) {
        ActionResolver actionResolver = documentView.getActionResolver();
        if (actionResolver != null) {
            actionResolver.removeDocumentActionListener(documentActionListener);
        }
    }

    static void lambda$removeOnAnnotatingModeChangeListener$65(OnAnnotatingModeChangeListener onAnnotatingModeChangeListener, DocumentView documentView) {
        q0 annotatingHandler = documentView.getAnnotatingHandler();
        if (annotatingHandler != null) {
            onAnnotatingModeChangeListener.getClass();
            annotatingHandler.k.b(onAnnotatingModeChangeListener);
        }
    }

    static void lambda$removeOnAnnotatingModeSettingsChangeListener$67(OnAnnotatingModeSettingsChangeListener onAnnotatingModeSettingsChangeListener, DocumentView documentView) {
        q0 annotatingHandler = documentView.getAnnotatingHandler();
        annotatingHandler.getClass();
        onAnnotatingModeSettingsChangeListener.getClass();
        annotatingHandler.l.b(onAnnotatingModeSettingsChangeListener);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static void lambda$removeOverlayViewProvider$60(OverlayViewProvider overlayViewProvider, DocumentView documentView) {
        documentView.getClass();
        uw.a(overlayViewProvider, "overlayViewProvider", null);
        hu<OverlayViewProvider> huVar = documentView.f;
        huVar.getClass();
        huVar.b.b(overlayViewProvider);
    }

    static boolean lambda$restoreContentEditing$5(cb cbVar, Integer num) throws Throwable {
        return num.intValue() == cbVar.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restoreContentEditing$6(Integer num) throws Throwable {
        enterContentEditingMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restoreSelectedAnnotations$2(List list) throws Throwable {
        if (list.isEmpty()) {
            return;
        }
        setSelectedAnnotations(list);
    }

    static /* synthetic */ boolean lambda$restoreTextSelection$3(TextSelection textSelection, Integer num) throws Throwable {
        return num.intValue() == textSelection.pageIndex;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restoreTextSelection$4(TextSelection textSelection, Integer num) throws Throwable {
        enterTextSelectionMode(textSelection.pageIndex, textSelection.textRange);
    }

    static void lambda$scrollTo$38(RectF rectF, int i, long j, boolean z, DocumentView documentView) {
        ln lnVar = documentView.C;
        if (lnVar != null) {
            lnVar.a(rectF, i, j, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$selectAnnotationsForEditingInternal$76(List list, DocumentView documentView) {
        if (list.isEmpty()) {
            documentView.a();
        } else {
            if (!ar.b().a(this.configuration)) {
                throw new NutrientException("Selecting annotations for editing " + list + " is not permitted, either by the license or configuration.");
            }
            documentView.setSelectedAnnotations(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCustomPdfSources$39(uv.b bVar) {
        load();
    }

    static void lambda$setDocumentInsets$72(int i, int i2, int i3, int i4, DocumentView documentView) {
        ViewGroup.LayoutParams layoutParams = documentView.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            throw new IllegalStateException("Can't add document insets if DocumentView parent does not support margins.");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams.topMargin == i2 && marginLayoutParams.bottomMargin == i4 && marginLayoutParams.leftMargin == i && marginLayoutParams.rightMargin == i3) {
            return;
        }
        marginLayoutParams.setMargins(i, i2, i3, i4);
        documentView.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDocumentInteractionEnabled$20(boolean z, uv.b bVar) {
        this.isDocumentInteractionEnabled = z;
        bVar.b.setEnabled(z && this.isUserInterfaceEnabled);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setOnDocumentLongPressListener$40(OnDocumentLongPressListener onDocumentLongPressListener, uv.b bVar) {
        if (onDocumentLongPressListener != null) {
            bVar.b.setOnDocumentLongPressListener(onDocumentLongPressListener);
            this.onDocumentLongPressListener = onDocumentLongPressListener;
        } else {
            bVar.b.setOnDocumentLongPressListener(this.defaultOnDocumentLongPressListener);
            this.onDocumentLongPressListener = this.defaultOnDocumentLongPressListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$setPageIndex$33(int i, boolean z, DocumentView documentView) {
        lm lmVar = this.document;
        if (lmVar == null) {
            return;
        }
        if (i < 0 || i > lmVar.s - 1) {
            throw new IllegalArgumentException("Invalid page index " + i + " - valid page indexes are [0, " + (this.document.s - 1) + "]");
        }
        documentView.a(i, Boolean.valueOf(z));
        this.animatePageTransition = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setRedactionAnnotationPreviewEnabled$99(boolean z, DocumentView documentView) {
        this.redactionAnnotationPreviewEnabled = z;
        documentView.setRedactionAnnotationPreviewEnabled(z);
    }

    static /* synthetic */ boolean lambda$setSelectedAnnotations$25(int i, Integer num) throws Throwable {
        return num.intValue() == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$setSelectedAnnotations$26(Collection collection, Integer num) throws Throwable {
        vt pageEditorForCurrentPage = getPageEditorForCurrentPage();
        if (pageEditorForCurrentPage != null) {
            collection.getClass();
            pageEditorForCurrentPage.a(false, (Collection<? extends Annotation>) collection);
        }
    }

    static /* synthetic */ boolean lambda$setSelectedFormElement$30(int i, Integer num) throws Throwable {
        return num.intValue() == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x001e  */
    /* JADX WARN: Code duplicated, block: B:16:0x0024  */
    /* JADX WARN: Code duplicated, block: B:18:? A[RETURN, SYNTHETIC] */
    public void lambda$setSelectedFormElement$31(int i, FormElement formElement, Integer num) throws Throwable {
        au auVarB;
        mh formEditor;
        uv uvVar = this.viewCoordinator;
        if (i >= 0) {
            DocumentView documentView = uvVar.n;
            if (documentView != null && documentView.getDocument() != null) {
                auVarB = uvVar.n.b(i);
            }
            formEditor = auVarB != null ? auVarB.getFormEditor() : null;
            if (formEditor != null) {
                formEditor.c(formElement);
            }
        }
        uvVar.getClass();
        auVarB = null;
        if (auVarB != null) {
        }
        if (formEditor != null) {
            formEditor.c(formElement);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0045  */
    public void lambda$setUserInterfaceEnabledInternal$21(boolean z, boolean z2, uv.b bVar) {
        boolean z3;
        View view;
        PdfPasswordView pdfPasswordView;
        this.isUserInterfaceEnabled = z;
        if (z && this.viewCoordinator.o) {
            z3 = false;
        } else {
            uv uvVar = this.viewCoordinator;
            if (uvVar.l.b() && (pdfPasswordView = uvVar.l.a().d) != null && pdfPasswordView.getVisibility() == 0) {
                z3 = false;
            } else {
                uv uvVar2 = this.viewCoordinator;
                if (uvVar2.l.b() && (view = uvVar2.l.a().c) != null && view.getVisibility() == 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            }
        }
        this.viewCoordinator.c(z3);
        if (this.document == null || !(z2 || z)) {
            bVar.b.setVisibility(4);
        } else {
            bVar.b.setVisibility(0);
        }
        bVar.b.setEnabled(this.isDocumentInteractionEnabled && z);
        if (z && this.document != null) {
            n30 n30Var = this.lastEnabledSpecialModeState;
            if (n30Var != null) {
                setSpecialModeState(n30Var);
                this.lastEnabledSpecialModeState = null;
            }
            Iterator<k70> it = this.userInterfaceListeners.iterator();
            while (it.hasNext()) {
                it.next().onUserInterfaceEnabled(true);
            }
            return;
        }
        Iterator<k70> it2 = this.userInterfaceListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onUserInterfaceEnabled(false);
        }
        if (bVar.b.i() && this.lastEnabledSpecialModeState == null) {
            this.lastEnabledSpecialModeState = getSpecialModeState();
            exitCurrentlyActiveMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setViewState$34(x70 x70Var, DocumentView documentView) {
        if (this.document != null) {
            documentView.setViewState(x70Var);
        }
    }

    static void lambda$storeLastViewedPageInDocumentDataStoreIfNeeded$11(lm lmVar, int i, ed edVar) throws Throwable {
        edVar.getClass();
        String uid = lmVar.getUid();
        NativeDocumentDataStore nativeDocumentDataStore = edVar.a;
        NativeDocumentData nativeDocumentData = nativeDocumentDataStore.get(uid);
        synchronized (new dd(nativeDocumentDataStore, nativeDocumentData)) {
            nativeDocumentData.putInt(DOCUMENTSTORE_KEY_LAST_VIEWED_PAGE_INDEX, Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$storeLastViewedPageInDocumentDataStoreIfNeeded$12(Throwable th) throws Throwable {
        PdfLog.e("Nutri.PdfFragment", th, "Unable to initialize document data store to save the last viewed page.", new Object[0]);
    }

    static void lambda$zoomBy$35(int i, int i2, int i3, float f, long j, DocumentView documentView) {
        ln lnVar = documentView.C;
        if (lnVar != null) {
            lnVar.a(i, i2, i3, f, j);
        }
    }

    static void lambda$zoomTo$36(int i, int i2, int i3, float f, long j, DocumentView documentView) {
        ln lnVar = documentView.C;
        if (lnVar != null) {
            lnVar.b(i, i2, i3, f, j);
        }
    }

    static void lambda$zoomTo$37(RectF rectF, int i, long j, DocumentView documentView) {
        ln lnVar = documentView.C;
        if (lnVar != null) {
            lnVar.a(rectF, i, j);
        }
    }

    private void load() {
        if (!Nutrient.isInitialized()) {
            PdfLog.w("Nutri.PdfFragment", "Load invoked without initializing Nutrient, skipping...", new Object[0]);
            return;
        }
        if (this.document == null || shouldReloadDocument()) {
            Disposable disposable = this.documentLoadDisposable;
            if (disposable == null || disposable.isDisposed()) {
                if (this.imageDocumentSource != null) {
                    Single<ImageDocument> singleOpenImageDocumentAsync = openImageDocumentAsync();
                    synchronized (ar.class) {
                        q10.c();
                    }
                    Scheduler schedulerIo = Schedulers.io();
                    schedulerIo.getClass();
                    Disposable disposableSubscribe = singleOpenImageDocumentAsync.subscribeOn(schedulerIo).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda68
                        @Override // io.reactivex.rxjava3.functions.Action
                        public final void run() throws Throwable {
                            this.f$0.lambda$load$13();
                        }
                    }).subscribe(new BiConsumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda69
                        @Override // io.reactivex.rxjava3.functions.BiConsumer
                        public final void accept(Object obj, Object obj2) throws Throwable {
                            this.f$0.lambda$load$14((ImageDocument) obj, (Throwable) obj2);
                        }
                    });
                    this.documentLoadDisposable = disposableSubscribe;
                    this.lifecycleDisposable.add(disposableSubscribe);
                    return;
                }
                List<Flowable<Double>> documentLoadingProgressObservables = getDocumentLoadingProgressObservables();
                if (!documentLoadingProgressObservables.isEmpty()) {
                    Flowable flowableCombineLatest = Flowable.combineLatest(documentLoadingProgressObservables, new Function() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda70
                        @Override // io.reactivex.rxjava3.functions.Function
                        public final Object apply(Object obj) {
                            return PdfFragment.lambda$load$15((Object[]) obj);
                        }
                    }, 1);
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    this.documentLoadingProgressDisposable = flowableCombineLatest.delaySubscription(2000L, timeUnit).subscribeOn(Schedulers.io()).sample(16L, timeUnit, true).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Double>() { // from class: com.pspdfkit.ui.PdfFragment.4
                        boolean first = true;

                        @Override // io.reactivex.rxjava3.functions.Consumer
                        public void accept(Double d) {
                            uv uvVar;
                            ho hoVar;
                            if (this.first && d.doubleValue() < 1.0d && (hoVar = (uvVar = PdfFragment.this.viewCoordinator).j) != null) {
                                hoVar.c();
                                ProgressBar progressBar = uvVar.j.getProgressBar();
                                if (progressBar != null) {
                                    progressBar.setId(R.id.pspdf__fragment_progressbar);
                                }
                            }
                            this.first = false;
                            uv uvVar2 = PdfFragment.this.viewCoordinator;
                            double dDoubleValue = d.doubleValue();
                            ho hoVar2 = uvVar2.j;
                            if (hoVar2 != null) {
                                hoVar2.setLoadingProgress(dDoubleValue);
                            }
                        }
                    }, new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda71
                        @Override // io.reactivex.rxjava3.functions.Consumer
                        public final void accept(Object obj) throws Throwable {
                            PdfFragment.lambda$load$16((Throwable) obj);
                        }
                    });
                }
                Single<? extends PdfDocument> singleOpenDocumentAsync = openDocumentAsync();
                ar.d();
                Scheduler schedulerIo2 = Schedulers.io();
                schedulerIo2.getClass();
                Disposable disposableSubscribe2 = singleOpenDocumentAsync.subscribeOn(schedulerIo2).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda72
                    @Override // io.reactivex.rxjava3.functions.Action
                    public final void run() throws Throwable {
                        this.f$0.lambda$load$17();
                    }
                }).subscribe(new BiConsumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda74
                    @Override // io.reactivex.rxjava3.functions.BiConsumer
                    public final void accept(Object obj, Object obj2) throws Throwable {
                        this.f$0.lambda$load$18((PdfDocument) obj, (Throwable) obj2);
                    }
                });
                this.documentLoadDisposable = disposableSubscribe2;
                this.lifecycleDisposable.add(disposableSubscribe2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0034  */
    private boolean mayEnterAnnotationEditingMode(List<Annotation> list) {
        boolean zA;
        au auVarB;
        DocumentView documentViewA = this.viewCoordinator.a(false);
        if (documentViewA != null) {
            if (!documentViewA.i()) {
                zA = true;
            } else if (list.isEmpty() || (auVarB = documentViewA.b(list.get(0).getPageIndex())) == null) {
                zA = false;
            } else {
                gu currentMode = auVarB.getSpecialModeView().getCurrentMode();
                if (currentMode == null) {
                    zA = true;
                } else {
                    zA = currentMode.a();
                }
            }
            if (zA) {
                return true;
            }
        }
        return false;
    }

    public static PdfFragment newImageInstance(Uri uri, PdfConfiguration pdfConfiguration) {
        uw.a(uri, "documentUri", null);
        uw.a(pdfConfiguration, "configuration", null);
        return newImageInstance(new DocumentSource(uri), pdfConfiguration);
    }

    public static PdfFragment newInstance(Uri uri, String str, String str2, PdfConfiguration pdfConfiguration) {
        uw.a(uri, "documentUri", null);
        uw.a(pdfConfiguration, "configuration", null);
        return newInstanceFromDocumentSources(Collections.singletonList(new DocumentSource(uri, str, str2)), pdfConfiguration);
    }

    public static PdfFragment newInstanceFromDocumentSources(List<DocumentSource> list, PdfConfiguration pdfConfiguration) {
        int i;
        boolean z;
        Bundle bundle = new Bundle();
        bundle.putParcelable(PARAM_CONFIGURATION, pdfConfiguration);
        Iterator<DocumentSource> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            if (!vu.a(it.next())) {
                z = false;
                break;
            }
        }
        if (z) {
            vu[] vuVarArr = new vu[list.size()];
            for (i = 0; i < list.size(); i++) {
                vuVarArr[i] = new vu(list.get(i));
            }
            bundle.putParcelableArray(PARAM_SOURCES, vuVarArr);
        }
        PdfFragment pdfFragment = new PdfFragment();
        pdfFragment.setArguments(bundle);
        if (!z) {
            pdfFragment.setCustomPdfSources(list);
        }
        return pdfFragment;
    }

    public static PdfFragment newInstanceFromSources(List<DataProvider> list, List<String> list2, List<String> list3, PdfConfiguration pdfConfiguration) {
        uw.a(list, "sources", null);
        uw.a(pdfConfiguration, "configuration", null);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            arrayList.add(new DocumentSource(list.get(i), (list2 != null && list2.size() > i) ? list2.get(i) : null, (list3 != null && list3.size() > i) ? list3.get(i) : null));
            i++;
        }
        return newInstanceFromDocumentSources(arrayList, pdfConfiguration);
    }

    private void onRestoreInstanceState(Bundle bundle) {
        this.startZoomScale = 1.0f;
        this.fragmentState = (Bundle) bundle.getParcelable(PARAM_FRAGMENT_STATE);
        String string = bundle.getString(PARAM_PASSWORD);
        if (string != null) {
            setPassword(string);
        }
        b20 b20Var = this.signatureFormSigningHandler;
        b20Var.getClass();
        b20Var.c = (wu) bundle.getParcelable("SignatureFormSigningHandler.FormElementBeingSigned");
        Bundle bundle2 = this.fragmentState;
        if (bundle2 == null) {
            return;
        }
        setDocumentLoadingProgressState(bundle2.getDouble(PARAM_DOCUMENT_LOADING_PROGRESS, 1.0d));
    }

    private Single<ImageDocument> openImageDocumentAsync() {
        return ImageDocumentLoader.openDocumentAsync(requireContext(), this.imageDocumentSource);
    }

    private void prepareAnnotationUndoManager(PdfDocument pdfDocument) {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a70 a70Var = this.undoManager;
        lm lmVar = (lm) pdfDocument;
        v0 v0Var = new v0(lmVar.getAnnotationProvider(), sparseIntArray, this.navigateOnUndoListener);
        synchronized (a70Var) {
            z60 z60Var = a70Var.d;
            z60Var.getClass();
            z60Var.a.put(v0Var.a, v0Var);
        }
        this.undoManager.a(new l3(lmVar.getAnnotationProvider(), sparseIntArray, this.navigateOnUndoListener));
        this.undoManager.a(new x6(lmVar.getAnnotationProvider(), sparseIntArray, this.navigateOnUndoListener));
        this.undoManager.a(new e5(lmVar.getAnnotationProvider(), sparseIntArray, this.navigateOnUndoListener));
        this.undoManager.a(new hq(this));
    }

    private void prepareContentEditingUndoManager() {
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda10
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                this.f$0.lambda$prepareContentEditingUndoManager$56(documentView);
            }
        }, false);
    }

    private void prepareUndoManager(PdfDocument pdfDocument) {
        prepareAnnotationUndoManager(pdfDocument);
        prepareContentEditingUndoManager();
    }

    private void previewUri(final Context context, final UriAction uriAction) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(R.layout.pspdf__preview_uri_dialog);
        final AlertDialog alertDialogCreate = builder.create();
        alertDialogCreate.show();
        TextView textView = (TextView) Objects.requireNonNull((TextView) alertDialogCreate.findViewById(R.id.pspdf__uri_item_link));
        TextView textView2 = (TextView) Objects.requireNonNull((TextView) alertDialogCreate.findViewById(R.id.pspdf__uri_item_open));
        TextView textView3 = (TextView) Objects.requireNonNull((TextView) alertDialogCreate.findViewById(R.id.pspdf__uri_item_copy));
        textView.setScroller(new Scroller(context));
        textView.setVerticalScrollBarEnabled(true);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(uriAction.getUri());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda57
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$previewUri$42(uriAction, alertDialogCreate, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$previewUri$43(context, uriAction, alertDialogCreate, view);
            }
        });
    }

    private void refreshUserInterfaceState() {
        de deVar;
        setUserInterfaceEnabledInternal((this.document == null || (deVar = this.documentSaver) == null || deVar.c) ? false : true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetDocument() {
        lm lmVar = this.document;
        if (lmVar != null) {
            InternalDocumentListener internalDocumentListener = this.internalDocumentListener;
            internalDocumentListener.getClass();
            lmVar.K.b(internalDocumentListener);
            this.document.l.b.a.clear();
            this.document.g.removeOnFormFieldUpdatedListener(this.formFieldUpdatedListener);
            lm lmVar2 = this.document;
            lmVar2.o = null;
            JobKt.cancelChildren(lmVar2.b.getCoroutineContext(), new CancellationException("Document reset"));
            lmVar2.e.f.a.evictAll();
            this.document = null;
        }
    }

    private void restoreContentEditing(n30 n30Var) {
        final cb cbVar = n30Var.f;
        if (cbVar == null) {
            return;
        }
        if (cbVar.a == 0) {
            enterContentEditingMode();
        } else {
            this.lifecycleDisposable.add(this.pageChangeSubject.filter(new Predicate() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda99
                @Override // io.reactivex.rxjava3.functions.Predicate
                public final boolean test(Object obj) {
                    return PdfFragment.lambda$restoreContentEditing$5(cbVar, (Integer) obj);
                }
            }).firstOrError().subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda100
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.lambda$restoreContentEditing$6((Integer) obj);
                }
            }));
        }
    }

    private void restorePagePosition(PdfDocument pdfDocument) {
        float f = this.startZoomScale;
        Boolean bool = this.animatePageTransition;
        if (f != 1.0f) {
            zoomTo(((int) pdfDocument.getPageSize(this.displayedPage).width) / 2, ((int) pdfDocument.getPageSize(this.displayedPage).height) / 2, this.displayedPage, this.startZoomScale, (bool == null || !bool.booleanValue()) ? 0 : 200);
            return;
        }
        int i = this.displayedPage;
        if (bool == null) {
            setPageIndex(i);
        } else {
            setPageIndex(i, bool.booleanValue());
        }
    }

    private boolean restoreSelectedAnnotations(n30 n30Var) {
        g60 g60VarC;
        Single list;
        if (n30Var.c.isEmpty()) {
            return false;
        }
        CompositeDisposable compositeDisposable = this.lifecycleDisposable;
        lm lmVar = this.document;
        if (n30Var.c.isEmpty()) {
            list = Single.just(CollectionsKt.emptyList());
            list.getClass();
        } else {
            Observable observableFromIterable = Observable.fromIterable(n30Var.c);
            synchronized (ar.class) {
                g60VarC = q10.c();
            }
            list = observableFromIterable.subscribeOn(((m0) g60VarC).a()).flatMapMaybe(new p30(lmVar)).toList();
            list.getClass();
        }
        compositeDisposable.add(list.observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda19
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$restoreSelectedAnnotations$2((List) obj);
            }
        }));
        return true;
    }

    private boolean restoreSelectedFormElements(n30 n30Var) {
        if (n30Var.d == null) {
            return false;
        }
        this.lifecycleDisposable.add(n30Var.a(this.document).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda93
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) {
                this.f$0.setSelectedFormElement((FormElement) obj);
            }
        }));
        return true;
    }

    private boolean restoreTextSelection(n30 n30Var) {
        final TextSelection textSelection = n30Var.e;
        if (textSelection == null) {
            return false;
        }
        int i = textSelection.pageIndex;
        if (i == 0) {
            enterTextSelectionMode(i, textSelection.textRange);
            return true;
        }
        this.lifecycleDisposable.add(this.pageChangeSubject.filter(new Predicate() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda29
            @Override // io.reactivex.rxjava3.functions.Predicate
            public final boolean test(Object obj) {
                return PdfFragment.lambda$restoreTextSelection$3(textSelection, (Integer) obj);
            }
        }).firstOrError().subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda40
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$restoreTextSelection$4(textSelection, (Integer) obj);
            }
        }));
        return true;
    }

    private void selectAnnotationsForEditingInternal(final List<Annotation> list) {
        uw.a(list, "annotations", null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda0
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                this.f$0.lambda$selectAnnotationsForEditingInternal$76(list, documentView);
            }
        }, false);
    }

    private void setDocumentInsets(final int i, final int i2, final int i3, final int i4) {
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda95
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$setDocumentInsets$72(i, i2, i3, i4, documentView);
            }
        }, false);
    }

    private void setDocumentLoadingProgressState(double d) {
        uv uvVar;
        ho hoVar;
        if (d < 1.0d) {
            ho hoVar2 = this.viewCoordinator.j;
            if (hoVar2 != null) {
                hoVar2.setLoadingProgress(d);
            }
            Disposable disposable = this.documentLoadingProgressDisposable;
            if (disposable == null || disposable.isDisposed() || (hoVar = (uvVar = this.viewCoordinator).j) == null) {
                return;
            }
            hoVar.c();
            ProgressBar progressBar = uvVar.j.getProgressBar();
            if (progressBar != null) {
                progressBar.setId(R.id.pspdf__fragment_progressbar);
            }
        }
    }

    private void setFragmentUiState(Bundle bundle) {
        x70 x70Var = (x70) bundle.getParcelable(PARAM_CURRENT_VIEW_STATE);
        if (x70Var != null) {
            setViewState(x70Var);
        }
        setSpecialModeState((n30) bundle.getParcelable(PARAM_SPECIAL_MODE_STATE));
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(PARAM_MEDIA_CONTENT_STATES);
        if (parcelableArrayList == null) {
            parcelableArrayList = new ArrayList();
        }
        setMediaContentStates(parcelableArrayList);
        y6 y6Var = (y6) bundle.getParcelable(PARAM_AUDIO_MANAGER_STATE);
        if (y6Var != null) {
            y5 y5Var = this.audioModeManager;
            y5Var.getClass();
            PdfDocument document = y5Var.b.getDocument();
            lm lmVar = document instanceof lm ? (lm) document : null;
            if (lmVar != null) {
                if (y6Var.c) {
                    t6 t6Var = y5Var.d;
                    Context contextRequireContext = y5Var.b.requireContext();
                    contextRequireContext.getClass();
                    t6Var.getClass();
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new s6(y6Var, lmVar, t6Var, contextRequireContext, null), 3, null);
                } else {
                    i6 i6Var = y5Var.c;
                    Context contextRequireContext2 = y5Var.b.requireContext();
                    contextRequireContext2.getClass();
                    i6Var.getClass();
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new h6(y6Var, lmVar, i6Var, contextRequireContext2, null), 3, null);
                }
            }
        }
        setDocumentLoadingProgressState(bundle.getDouble(PARAM_DOCUMENT_LOADING_PROGRESS, 1.0d));
    }

    private void setPassword(String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<DocumentSource> it = this.documentSources.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().cloneWithPassword(str));
        }
        this.documentSources = arrayList;
        this.password = str;
    }

    private void setSpecialModeState(n30 n30Var) {
        if (n30Var == null) {
            return;
        }
        AnnotationTool annotationTool = n30Var.a;
        if (annotationTool != null) {
            AnnotationToolVariant annotationToolVariantDefaultVariant = n30Var.b;
            if (annotationToolVariantDefaultVariant == null) {
                annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
            }
            enterAnnotatingMode(annotationTool, annotationToolVariantDefaultVariant);
            return;
        }
        if (restoreSelectedAnnotations(n30Var) || restoreSelectedFormElements(n30Var) || restoreTextSelection(n30Var)) {
            return;
        }
        restoreContentEditing(n30Var);
    }

    private void setUserInterfaceEnabledInternal(final boolean z, final boolean z2) {
        this.viewCoordinator.a(new uv.d() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda105
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                this.f$0.lambda$setUserInterfaceEnabledInternal$21(z, z2, bVar);
            }
        }, true);
    }

    private void storeLastViewedPageInDocumentDataStoreIfNeeded() {
        final lm lmVar = this.document;
        if (lmVar == null || !this.configuration.isLastViewedPageRestorationEnabled()) {
            return;
        }
        DocumentView documentView = this.viewCoordinator.n;
        final int page = documentView == null ? -1 : documentView.getPage();
        if (page > -1) {
            ed.b().subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda28
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    PdfFragment.lambda$storeLastViewedPageInDocumentDataStoreIfNeeded$11(lmVar, page, (ed) obj);
                }
            }, new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda30
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.lambda$storeLastViewedPageInDocumentDataStoreIfNeeded$12((Throwable) obj);
                }
            });
        }
    }

    private void withDocumentView(uv.c cVar) {
        DocumentView documentViewA = this.viewCoordinator.a(false);
        if (documentViewA == null) {
            return;
        }
        cVar.a(documentViewA);
    }

    public void addAnnotationToPage(Annotation annotation, boolean z) {
        addAnnotationToPage(annotation, z, null);
    }

    public void addAnnotationViewsListener(final AnnotationViewsListener annotationViewsListener) {
        uw.a(annotationViewsListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda31
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$addAnnotationViewsListener$100(annotationViewsListener, documentView);
            }
        }, false);
    }

    @Override // com.pspdfkit.annotations.actions.ActionResolver
    public void addDocumentActionListener(final DocumentActionListener documentActionListener) {
        uw.a(documentActionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda27
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$addDocumentActionListener$45(documentActionListener, documentView);
            }
        }, false);
    }

    public void addDocumentListener(DocumentListener documentListener) {
        uw.a(documentListener, "documentListener", null);
        this.documentListeners.a(documentListener);
    }

    public void addDocumentScrollListener(DocumentScrollListener documentScrollListener) {
        uw.a(documentScrollListener, "documentScrollListener", null);
        this.documentScrollListeners.a(documentScrollListener);
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public void addDrawableProvider(final PdfDrawableProvider pdfDrawableProvider) {
        uw.a(pdfDrawableProvider, "drawableProvider", null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda51
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.addDrawableProvider(pdfDrawableProvider);
            }
        }, false);
    }

    public void addInsets(int i, int i2, int i3, int i4) {
        int i5 = this.insetsLeft + i;
        this.insetsLeft = i5;
        int i6 = this.insetsTop + i2;
        this.insetsTop = i6;
        int i7 = this.insetsRight + i3;
        this.insetsRight = i7;
        int i8 = this.insetsBottom + i4;
        this.insetsBottom = i8;
        setDocumentInsets(i5, i6, i7, i8);
    }

    public void addOnAnnotatingModeChangeListener(final OnAnnotatingModeChangeListener onAnnotatingModeChangeListener) {
        uw.a(onAnnotatingModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda41
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$addOnAnnotatingModeChangeListener$64(onAnnotatingModeChangeListener, documentView);
            }
        }, false);
    }

    public void addOnAnnotatingModeSettingsChangeListener(final OnAnnotatingModeSettingsChangeListener onAnnotatingModeSettingsChangeListener) {
        uw.a(onAnnotatingModeSettingsChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda64
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$addOnAnnotatingModeSettingsChangeListener$66(onAnnotatingModeSettingsChangeListener, documentView);
            }
        }, false);
    }

    public void addOnAnnotationSelectedListener(final OnAnnotationSelectedListener onAnnotationSelectedListener) {
        uw.a(onAnnotationSelectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda50
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.i.a(onAnnotationSelectedListener);
            }
        }, false);
    }

    public void addOnAnnotationUpdatedListener(final AnnotationProvider.OnAnnotationUpdatedListener onAnnotationUpdatedListener) {
        uw.a(onAnnotationUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        lm lmVar = this.document;
        if (lmVar == null) {
            this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda37
                @Override // com.pspdfkit.internal.uv.c
                public final void a(DocumentView documentView) {
                    this.f$0.lambda$addOnAnnotationUpdatedListener$63(onAnnotationUpdatedListener, documentView);
                }
            }, false);
            return;
        }
        o3 annotationProvider = lmVar.getAnnotationProvider();
        annotationProvider.getClass();
        annotationProvider.h.a(onAnnotationUpdatedListener);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager
    public void addOnContentEditingContentChangeListener(final ContentEditingManager.OnContentEditingContentChangeListener onContentEditingContentChangeListener) {
        uw.a(onContentEditingContentChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda80
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getContentEditingManager().addOnContentEditingContentChangeListener(onContentEditingContentChangeListener);
            }
        }, false);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager
    public void addOnContentEditingModeChangeListener(final ContentEditingManager.OnContentEditingModeChangeListener onContentEditingModeChangeListener) {
        uw.a(onContentEditingModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda1
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getContentEditingManager().addOnContentEditingModeChangeListener(onContentEditingModeChangeListener);
            }
        }, false);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void addOnFormElementClickedListener(final FormManager.OnFormElementClickedListener onFormElementClickedListener) {
        uw.a(onFormElementClickedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda96
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().e.addFirst(onFormElementClickedListener);
            }
        }, false);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void addOnFormElementDeselectedListener(final FormManager.OnFormElementDeselectedListener onFormElementDeselectedListener) {
        uw.a(onFormElementDeselectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda5
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().b.a(onFormElementDeselectedListener);
            }
        }, false);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void addOnFormElementEditingModeChangeListener(final FormManager.OnFormElementEditingModeChangeListener onFormElementEditingModeChangeListener) {
        uw.a(onFormElementEditingModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda55
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().d.a(onFormElementEditingModeChangeListener);
            }
        }, false);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void addOnFormElementSelectedListener(final FormManager.OnFormElementSelectedListener onFormElementSelectedListener) {
        uw.a(onFormElementSelectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda49
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().a.a(onFormElementSelectedListener);
            }
        }, false);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void addOnFormElementUpdatedListener(final FormManager.OnFormElementUpdatedListener onFormElementUpdatedListener) {
        uw.a(onFormElementUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda20
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().c.a(onFormElementUpdatedListener);
            }
        }, false);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void addOnFormElementViewUpdatedListener(final FormManager.OnFormElementViewUpdatedListener onFormElementViewUpdatedListener) {
        uw.a(onFormElementViewUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda44
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().f.a(onFormElementViewUpdatedListener);
            }
        }, false);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void addOnTextFormElementSuggestionRequestListener(final FormManager.OnTextFormElementSuggestionRequestListener onTextFormElementSuggestionRequestListener) {
        uw.a(onTextFormElementSuggestionRequestListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda82
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().g.a(onTextFormElementSuggestionRequestListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager
    public void addOnTextSelectionChangeListener(final TextSelectionManager.OnTextSelectionChangeListener onTextSelectionChangeListener) {
        uw.a(onTextSelectionChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda88
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getTextSelectionListeners().b.a(onTextSelectionChangeListener);
            }
        }, false);
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager
    public void addOnTextSelectionModeChangeListener(final TextSelectionManager.OnTextSelectionModeChangeListener onTextSelectionModeChangeListener) {
        uw.a(onTextSelectionModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda22
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getTextSelectionListeners().a.a(onTextSelectionModeChangeListener);
            }
        }, false);
    }

    public void addOverlayViewProvider(final OverlayViewProvider overlayViewProvider) {
        if (!ar.b().a(NativeLicenseFeatures.ANNOTATION_EDITING)) {
            throw new InvalidNutrientLicenseException("Using addOverlayViewProvider() requires the annotations component.");
        }
        uw.a(overlayViewProvider, "overlayViewProvider", null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda59
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$addOverlayViewProvider$59(overlayViewProvider, documentView);
            }
        }, false);
    }

    @Override // com.pspdfkit.ui.navigation.PageNavigator
    public void beginNavigation() {
        this.navigationStartPage = Integer.valueOf(getPageIndex());
    }

    @Override // com.pspdfkit.ui.navigation.PageNavigator
    public void endNavigation() {
        Integer num;
        Integer num2 = this.navigationStartPage;
        if (num2 != null && (num = this.navigationEndPage) != null && !num2.equals(num)) {
            this.navigationHistory.addItem(new NavigationBackStack.NavigationItem<>(this.navigationStartPage, this.navigationEndPage));
        }
        this.navigationStartPage = null;
        this.navigationEndPage = null;
    }

    @Override // com.pspdfkit.internal.m30
    public void enterAnnotatingMode(final AnnotationTool annotationTool, final AnnotationToolVariant annotationToolVariant) {
        uw.a(annotationTool, "annotationTool", null);
        uw.a(annotationToolVariant, "annotationToolVariant", null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda61
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                this.f$0.lambda$enterAnnotatingMode$73(annotationTool, annotationToolVariant, documentView);
            }
        }, true);
    }

    @Deprecated
    public void enterAnnotationCreationMode() {
        enterAnnotatingMode();
    }

    @Deprecated
    public void enterAnnotationEditingMode(List<Annotation> list) {
        selectAnnotationsForEditingInternal(list);
    }

    public void enterContentEditingMode() {
        lm lmVar = this.document;
        if (lmVar != null && lmVar.isWritableAndCanSave()) {
            if (this.configuration.isAutosaveEnabled() && lmVar.wasModified()) {
                save();
            }
            this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda48
                @Override // com.pspdfkit.internal.uv.c
                public final void a(DocumentView documentView) {
                    documentView.d();
                }
            }, false);
        }
    }

    public void enterFormEditingMode(final FormElement formElement) {
        uw.a(formElement, "formElement", null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda21
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$enterFormEditingMode$77(formElement, documentView);
            }
        }, true);
    }

    public void enterTextSelectionMode(final int i, final Range range) {
        uw.b(this.document != null, "Document must be loaded before entering text selection mode.");
        if (i < 0 || i >= this.document.s) {
            throw new IllegalArgumentException("Invalid page index " + i + ". Valid page indexes are [0, " + (this.document.s - 1) + "]");
        }
        if (range.getEndPosition() > this.document.getPageTextLength(i)) {
            throw new IllegalArgumentException("Invalid textRange " + range + ". Range exceeds text on page.");
        }
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda24
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.a(i, range);
            }
        }, true);
    }

    @Override // com.pspdfkit.annotations.actions.ActionResolver
    public void executeAction(final com.pspdfkit.annotations.actions.Action action, final ActionSender actionSender) {
        uw.a(action, Analytics.Data.ACTION, null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda13
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$executeAction$44(action, actionSender, documentView);
            }
        }, false);
    }

    @Override // com.pspdfkit.internal.m30
    public void exitCurrentlyActiveMode() {
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda2
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.exitCurrentlyActiveMode();
            }
        }, false);
    }

    public AnnotationTool getActiveAnnotationTool() {
        DocumentView documentView = this.viewCoordinator.n;
        if (documentView == null) {
            return null;
        }
        return documentView.getActiveAnnotationTool();
    }

    public AnnotationToolVariant getActiveAnnotationToolVariant() {
        DocumentView documentView = this.viewCoordinator.n;
        if (documentView == null) {
            return null;
        }
        return documentView.getActiveAnnotationToolVariant();
    }

    public AiAssistantProvider getAiAssistantListener() {
        return this.aiAssistantProvider;
    }

    public AnnotationConfigurationRegistry getAnnotationConfiguration() {
        Context context = getContext();
        if (context == null) {
            throw new IllegalStateException("getAnnotationConfiguration() must be called after views are created.");
        }
        uv uvVar = this.viewCoordinator;
        if (uvVar.r == null) {
            uvVar.r = new f3(context);
        }
        return uvVar.r.d;
    }

    @Override // com.pspdfkit.internal.vb
    public String getAnnotationCreator() {
        String annotationCreator = PSPDFKitPreferences.get(requireContext()).getAnnotationCreator("");
        return annotationCreator == null ? "" : annotationCreator;
    }

    public AnnotationOverlayRenderStrategy.Strategy getAnnotationOverlayRenderStrategy(Annotation annotation) {
        uv uvVar = this.viewCoordinator;
        c5 c5Var = uvVar.f;
        if (c5Var == null) {
            AnnotationOverlayRenderStrategy annotationOverlayRenderStrategy = uvVar.g;
            return annotationOverlayRenderStrategy != null ? annotationOverlayRenderStrategy.getOverlayRenderStrategy(annotation) : c5.t.getOverlayRenderStrategy(annotation);
        }
        annotation.getClass();
        AnnotationOverlayRenderStrategy.Strategy overlayRenderStrategy = c5Var.e.getOverlayRenderStrategy(annotation);
        overlayRenderStrategy.getClass();
        return overlayRenderStrategy;
    }

    public AnnotationPreferencesManager getAnnotationPreferences() {
        Context context = getContext();
        if (context == null) {
            throw new IllegalStateException("getAnnotationPreferences() must be called after views are created.");
        }
        uv uvVar = this.viewCoordinator;
        if (uvVar.r == null) {
            uvVar.r = new f3(context);
        }
        return uvVar.r;
    }

    public AudioModeManager getAudioModeManager() {
        return this.audioModeManager;
    }

    public int getBackgroundColor() {
        uv uvVar = this.viewCoordinator;
        int i = uvVar.b;
        return i != -1 ? i : ContextCompat.getColor(uvVar.a.requireContext(), R.color.pspdf__color_gray_light);
    }

    @Override // com.pspdfkit.internal.vb
    public PdfConfiguration getConfiguration() {
        return this.configuration;
    }

    public ContentEditingFillColorConfiguration getContentEditingConfiguration() {
        Context context = getContext();
        if (context == null) {
            throw new IllegalStateException("getContentEditingConfiguration() must be called after views are created.");
        }
        uv uvVar = this.viewCoordinator;
        if (uvVar.s == null) {
            uvVar.s = new xa(context);
        }
        return uvVar.s.b;
    }

    public ContentEditingPreferencesManager getContentEditingPreferences() {
        Context context = getContext();
        if (context == null) {
            throw new IllegalStateException("getContentEditingPreferences() must be called after views are created.");
        }
        uv uvVar = this.viewCoordinator;
        if (uvVar.s == null) {
            uvVar.s = new xa(context);
        }
        return uvVar.s;
    }

    public cb getContentEditingState() {
        DocumentView documentView = this.viewCoordinator.n;
        if (documentView == null) {
            return null;
        }
        return documentView.getContentEditingState();
    }

    public UndoManager getContentEditingUndoManager() {
        return this.contentEditingUndoManager;
    }

    public PdfDocument getDocument() {
        return this.document;
    }

    public DocumentCoordinator getDocumentCoordinator() {
        return this.documentCoordinator;
    }

    public List<Flowable<Double>> getDocumentLoadingProgressObservables() {
        ArrayList arrayList = new ArrayList(this.documentSources.size());
        Iterator<DocumentSource> it = this.documentSources.iterator();
        while (it.hasNext()) {
            DataProvider dataProvider = it.next().getDataProvider();
            if (dataProvider instanceof ProgressDataProvider) {
                arrayList.add(((ProgressDataProvider) dataProvider).observeProgress().startWithItem(Double.valueOf(0.0d)));
            }
        }
        return arrayList;
    }

    public ImageDocument getImageDocument() {
        return this.imageDocument;
    }

    public rm getInternal() {
        return this.internalAPI;
    }

    public MeasurementValueConfigurationEditor getMeasurementValueConfigurationEditor() {
        return this.measurementValueConfigurationEditor;
    }

    @Override // com.pspdfkit.ui.navigation.PageNavigator
    public NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> getNavigationHistory() {
        return this.navigationHistory;
    }

    public EnumSet<AnnotationType> getOverlaidAnnotationTypes() {
        DocumentView documentViewA = this.viewCoordinator.a(true);
        if (documentViewA != null) {
            return documentViewA.getOverlaidAnnotationTypes();
        }
        throw new IllegalStateException("getOverlaidAnnotationTypes() must be called after views are created.");
    }

    @Deprecated
    public List<Annotation> getOverlaidAnnotations() {
        return Collections.EMPTY_LIST;
    }

    @Override // com.pspdfkit.ui.navigation.PageNavigator
    public int getPageCount() {
        lm lmVar = this.document;
        if (lmVar == null) {
            return -1;
        }
        return lmVar.s;
    }

    @Override // com.pspdfkit.ui.navigation.PageNavigator
    public int getPageIndex() {
        if (this.document == null) {
            return -1;
        }
        DocumentView documentView = this.viewCoordinator.n;
        int page = documentView == null ? -1 : documentView.getPage();
        return page == -1 ? this.displayedPage : page;
    }

    public PdfPasswordView getPasswordView() {
        Single<uv.b> singleObserveOn;
        pn<uv.b> pnVar = this.viewCoordinator.l;
        uv.b bVar = pnVar.c;
        if (bVar != null) {
            singleObserveOn = Single.just(bVar);
            singleObserveOn.getClass();
        } else {
            singleObserveOn = pnVar.a.firstOrError().subscribeOn(pnVar.b).observeOn(AndroidSchedulers.mainThread());
            singleObserveOn.getClass();
        }
        uv.b bVarBlockingGet = singleObserveOn.blockingGet();
        if (bVarBlockingGet.d == null) {
            PdfPasswordView pdfPasswordView = new PdfPasswordView(bVarBlockingGet.a.getContext());
            bVarBlockingGet.d = pdfPasswordView;
            pdfPasswordView.setId(R.id.pspdf__fragment_password_view);
            bVarBlockingGet.d.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            bVarBlockingGet.d.setVisibility(8);
        }
        return bVarBlockingGet.d;
    }

    @Override // com.pspdfkit.internal.vb
    public at getRecordedListener() {
        return this.undoManager;
    }

    public List<Annotation> getSelectedAnnotations() {
        DocumentView documentView = this.viewCoordinator.n;
        return documentView != null ? documentView.getSelectedAnnotations() : Collections.EMPTY_LIST;
    }

    public FormElement getSelectedFormElement() {
        DocumentView documentView = this.viewCoordinator.n;
        if (documentView != null) {
            return documentView.getSelectedFormElement();
        }
        return null;
    }

    public int getSiblingPageIndex(int i) {
        ln lnVar;
        DocumentView documentView = this.viewCoordinator.n;
        if (documentView == null || (lnVar = documentView.C) == null) {
            return -1;
        }
        return lnVar.e(i);
    }

    public SignatureStorage getSignatureStorage() {
        return this.signatureStorage;
    }

    public Bundle getState() {
        Bundle bundle = this.fragmentState;
        if (bundle != null) {
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        DocumentView documentView = this.viewCoordinator.n;
        y6 y6Var = null;
        bundle2.putParcelable(PARAM_CURRENT_VIEW_STATE, documentView == null ? null : documentView.getViewState());
        bundle2.putParcelable(PARAM_SPECIAL_MODE_STATE, getSpecialModeState());
        if (this.lastEnabledSpecialModeState != null) {
            bundle2.putParcelable(PARAM_LAST_ENABLED_SPECIAL_MODE_STATE, getSpecialModeState());
        }
        bundle2.putBoolean(PARAM_REDACTION_PREVIEW_STATE, this.redactionAnnotationPreviewEnabled);
        List<jq> mediaContentStates = getMediaContentStates();
        if (!mediaContentStates.isEmpty()) {
            bundle2.putParcelableArrayList(PARAM_MEDIA_CONTENT_STATES, (ArrayList) mediaContentStates);
        }
        y5 y5Var = this.audioModeManager;
        i6 i6Var = y5Var.c;
        SoundAnnotation soundAnnotation = i6Var.c;
        if (soundAnnotation == null) {
            t6 t6Var = y5Var.d;
            SoundAnnotation soundAnnotation2 = t6Var.e;
            if (soundAnnotation2 != null && soundAnnotation2 != null) {
                y6Var = new y6(soundAnnotation2, true, t6Var.isResumed(), 0);
            }
        } else if (soundAnnotation != null) {
            y6Var = new y6(soundAnnotation, false, i6Var.isResumed(), i6Var.getCurrentPosition());
        }
        if (y6Var != null) {
            bundle2.putParcelable(PARAM_AUDIO_MANAGER_STATE, y6Var);
        }
        bundle2.putParcelable(PARAM_NAVIGATION_HISTORY, this.navigationHistory);
        ho hoVar = this.viewCoordinator.j;
        bundle2.putDouble(PARAM_DOCUMENT_LOADING_PROGRESS, hoVar != null ? hoVar.getLoadingProgress() : 1.0d);
        boolean z = getActivity() != null && getActivity().isChangingConfigurations();
        synchronized (ar.class) {
            ar.k = z;
        }
        return bundle2;
    }

    public TextSelection getTextSelection() {
        DocumentView documentView = this.viewCoordinator.n;
        if (documentView == null) {
            return null;
        }
        return documentView.getTextSelection();
    }

    public UndoManager getUndoManager() {
        return this.undoManager;
    }

    public ViewProjection getViewProjection() {
        return this.viewProjectionImpl;
    }

    public List<Integer> getVisiblePages() {
        DocumentView documentView = this.viewCoordinator.n;
        return documentView != null ? documentView.getVisiblePages() : new ArrayList();
    }

    public boolean getVisiblePdfRect(RectF rectF, int i) {
        uw.a(rectF, "targetRect", null);
        DocumentView documentView = this.viewCoordinator.n;
        return documentView != null && documentView.a(rectF, i);
    }

    public float getZoomScale(int i) {
        ln lnVar;
        DocumentView documentView = this.viewCoordinator.n;
        if (documentView == null || (lnVar = documentView.C) == null) {
            return 1.0f;
        }
        return lnVar.h(i);
    }

    public void highlight(final Context context, final List<RectF> list, final int i) {
        this.viewCoordinator.a(new uv.d() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda3
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                this.f$0.lambda$highlight$19(context, list, i, bVar);
            }
        }, false);
    }

    public void invalidate() {
        ((DocumentView) Objects.requireNonNull(this.viewCoordinator.a(false))).invalidate();
    }

    public boolean isAnnotationOverlayAboveOverlayViews() {
        DocumentView documentViewA = this.viewCoordinator.a(true);
        if (documentViewA != null) {
            return documentViewA.g0;
        }
        throw new IllegalStateException("isAnnotationOverlayAboveOverlayViews() must be called after views are created.");
    }

    public boolean isAnnotationOverlayEnabled() {
        DocumentView documentViewA = this.viewCoordinator.a(true);
        if (documentViewA != null) {
            return documentViewA.f0;
        }
        throw new IllegalStateException("isAnnotationOverlayEnabled() must be called after views are created.");
    }

    public boolean isDocumentInteractionEnabled() {
        return this.isDocumentInteractionEnabled;
    }

    public boolean isIdle() {
        ln lnVar;
        Disposable disposable;
        Job job;
        Disposable disposable2 = this.documentLoadDisposable;
        if (disposable2 == null || disposable2.isDisposed()) {
            DocumentView documentView = this.viewCoordinator.n;
            if (documentView != null) {
                q0 q0Var = documentView.G;
                boolean z = q0Var == null || q0Var.q.get() == 0;
                if (documentView.M || documentView.O || documentView.n0 || (lnVar = documentView.C) == null || lnVar.m || lnVar.a() || (((disposable = lnVar.z) != null && !disposable.isDisposed()) || !lnVar.A.isEmpty() || lnVar.l != null || (((job = lnVar.D) != null && job.isActive()) || lnVar.E != null || !z))) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean isImageDocument() {
        lm lmVar = this.document;
        if (lmVar != null) {
            return lmVar.r != null;
        }
        if (this.imageDocumentSource != null) {
            return true;
        }
        Bundle arguments = getArguments();
        return arguments != null && arguments.containsKey(PARAM_IMAGE_DOCUMENT_SOURCE);
    }

    public boolean isInSpecialMode() {
        DocumentView documentViewA = this.viewCoordinator.a(false);
        return documentViewA != null && documentViewA.i();
    }

    public boolean isRedactionAnnotationPreviewEnabled() {
        return this.redactionAnnotationPreviewEnabled;
    }

    public boolean isScrollingEnabled() {
        DocumentView documentView = this.viewCoordinator.n;
        return documentView != null && documentView.K;
    }

    public boolean isUserInterfaceEnabled() {
        return this.isUserInterfaceEnabled;
    }

    public boolean isZoomingEnabled() {
        DocumentView documentView = this.viewCoordinator.n;
        return documentView != null && documentView.L;
    }

    public void notifyAnnotationHasChanged(Annotation annotation) {
        uw.a(annotation, "annotation", null);
        notifyAnnotationsHaveChanged(Collections.singletonList(annotation));
    }

    public void notifyAnnotationsHaveChanged(List<? extends Annotation> list) {
        uw.a(list, "annotation", null);
        DocumentView documentViewA = this.viewCoordinator.a(false);
        if (documentViewA != null) {
            documentViewA.a(list);
        }
    }

    public void notifyLayoutChanged() {
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda60
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.n();
            }
        }, true);
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public void onAnnotationDeselected(Annotation annotation, boolean z) {
        if (z) {
            return;
        }
        DocumentView documentViewA = this.viewCoordinator.a(false);
        if (documentViewA == null || documentViewA.getInteractionMode() != DocumentView.d.ANNOTATING) {
            exitCurrentlyActiveMode();
        }
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public void onAnnotationSelected(Annotation annotation, boolean z) {
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public void onAnnotationSelectionFinished(List<Annotation> list, boolean z) {
        if (mayEnterAnnotationEditingMode(list)) {
            selectAnnotationsForEditingInternal(list);
        }
    }

    @Override // com.pspdfkit.internal.vb
    public void onAnnotationsCopied(List<? extends Annotation> list) {
        h60.a(new Runnable() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda104
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAnnotationsCopied$53();
            }
        });
    }

    @Override // com.pspdfkit.internal.vb
    public void onAnnotationsCut(List<? extends Annotation> list) {
        h60.a(new Runnable() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda101
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAnnotationsCut$55();
            }
        });
    }

    @Override // com.pspdfkit.internal.vb
    public void onAnnotationsPasted(final List<? extends Annotation> list) {
        h60.a(new Runnable() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda84
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onAnnotationsPasted$54(list);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.weakDocumentListeners = new WeakReference<>(this.documentListeners);
        j.a = new WeakReference<>(a80.a(context));
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final Bundle state = getState();
        state.remove(PARAM_CURRENT_VIEW_STATE);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda54
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                this.f$0.lambda$onConfigurationChanged$8(state, documentView);
            }
        }, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getParentFragment() == null) {
            setRetainInstance(true);
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            throw new IllegalArgumentException("PdfFragment was missing the arguments bundle!");
        }
        PdfConfiguration pdfConfiguration = (PdfConfiguration) arguments.getParcelable(PARAM_CONFIGURATION);
        if (pdfConfiguration == null) {
            throw new IllegalArgumentException("PdfFragment was missing the PdfConfiguration argument!");
        }
        this.configuration = pdfConfiguration;
        if (pdfConfiguration.isAiAssistantEnabled() && (requireActivity() instanceof AiAssistantProvider)) {
            this.aiAssistantProvider = (AiAssistantProvider) requireActivity();
        }
        if (this.documentSources == null) {
            Parcelable[] parcelableArray = getArguments().getParcelableArray(PARAM_SOURCES);
            vu vuVar = (vu) getArguments().getParcelable(PARAM_IMAGE_DOCUMENT_SOURCE);
            if (parcelableArray != null) {
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    vu vuVar2 = (vu) parcelable;
                    if (vuVar2 != null) {
                        arrayList.add(vuVar2.a);
                    } else {
                        PdfLog.e("vu", "Failed to unparcel DocumentSource", new Object[0]);
                    }
                }
                this.documentSources = arrayList;
            } else if (vuVar != null) {
                this.imageDocumentSource = vuVar.a;
            } else {
                this.documentSources = Collections.EMPTY_LIST;
            }
        }
        this.startZoomScale = this.configuration.getStartZoomScale();
        Context contextRequireContext = requireContext();
        List<String> list = j00.a;
        contextRequireContext.getClass();
        if (!Nutrient.isInitialized()) {
            j00.a(contextRequireContext).onErrorComplete().blockingAwait();
            if (!Nutrient.isInitialized()) {
                throw new NutrientNotInitializedException("Nutrient is not initialized!");
            }
        }
        ut utVarA = q10.a.a();
        int memoryCacheSize = this.configuration.getMemoryCacheSize();
        synchronized (utVarA) {
            utVarA.a.setSize(memoryCacheSize);
        }
        this.pageChangeSubject = BehaviorSubject.create();
        if (bundle == null) {
            this.navigationHistory.addBackStackListener(this.navigationItemBackStackListener);
        } else {
            onRestoreInstanceState(bundle);
        }
        a70.a aVar = this.configuration.isUndoEnabled() ? this.configuration.isRedoEnabled() ? a70.a.UNDO_AND_REDO : a70.a.ONLY_UNDO : a70.a.NONE;
        this.undoManager.a(aVar);
        this.contentEditingUndoManager.a(aVar);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Context context = layoutInflater.getContext();
        ca.a = new w4(context);
        ca.b = new ci(context);
        TypedArray typedArrayObtainStyledAttributes = layoutInflater.getContext().obtainStyledAttributes(new int[]{R.attr.pspdf__backgroundColor});
        int color = typedArrayObtainStyledAttributes.getColor(0, ContextCompat.getColor(layoutInflater.getContext(), R.color.pspdf__color_gray_light));
        typedArrayObtainStyledAttributes.recycle();
        setBackgroundColor(color);
        uv uvVar = this.viewCoordinator;
        uvVar.getClass();
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        uvVar.i = frameLayout;
        DocumentView documentView = (DocumentView) layoutInflater.inflate(R.layout.pspdf__document_view, (ViewGroup) frameLayout, false);
        frameLayout.addView(documentView, 0);
        uvVar.n = documentView;
        PdfConfiguration configuration = uvVar.a.getConfiguration();
        Integer loadingProgressDrawable = configuration.getLoadingProgressDrawable();
        ho hoVar = new ho(layoutInflater.getContext(), loadingProgressDrawable, f60.a(layoutInflater.getContext(), android.R.attr.colorBackground, R.color.pspdf__onPrimaryLight), configuration.isInvertColors(), configuration.isToGrayscale());
        uvVar.j = hoVar;
        hoVar.setId(R.id.pspdf__fragment_loading_view);
        uvVar.j.getThrobber().setId(R.id.pspdf__fragment_throbber);
        if (loadingProgressDrawable == null) {
            uvVar.j.setVisibility(8);
        }
        frameLayout.addView(uvVar.j, -1, -1);
        uvVar.j.setBackgroundColor(f60.a(uvVar.a.requireContext(), R.attr.pspdf__loading_view_background_color, R.color.pspdf__onPrimaryLight));
        Drawable drawable = uvVar.e;
        if (drawable != null) {
            uvVar.a(drawable);
        }
        b20 b20Var = this.signatureFormSigningHandler;
        b20Var.a.addDocumentListener(b20Var.e);
        lm lmVar = this.document;
        if (lmVar == null) {
            load();
            return frameLayout;
        }
        displayDocument(lmVar);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycleDisposable.dispose();
        this.lifecycleDisposable = new CompositeDisposable();
        this.javaScriptPlatformDelegate.c.clear();
        yz.a(this.documentLoadDisposable);
        this.documentLoadDisposable = null;
        yz.a(this.documentLoadingProgressDisposable);
        this.documentLoadingProgressDisposable = null;
        resetDocument();
        y7 y7Var = q10.c;
        if (y7Var == null) {
            y7Var = new y7();
            q10.c = y7Var;
        }
        y7Var.a();
        this.audioModeManager.exitActiveAudioMode();
        this.navigationHistory.removeBackStackListener(this.navigationItemBackStackListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        b20 b20Var = this.signatureFormSigningHandler;
        Job job = b20Var.f;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        b20Var.a.removeDocumentListener(b20Var.e);
        cancelRestorePagePosition();
        DocumentView documentView = this.viewCoordinator.n;
        this.displayedPage = Math.max(documentView == null ? -1 : documentView.getPage(), 0);
        removeOnAnnotationSelectedListener(this);
        removeOnFormElementSelectedListener(this);
        removeOnFormElementDeselectedListener(this);
        uv uvVar = this.viewCoordinator;
        yz.a(uvVar.p);
        uvVar.p = null;
        bx bxVar = uvVar.q;
        if (bxVar != null) {
            bxVar.b();
            try {
                bxVar.b.awaitTermination(5000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                PdfLog.i("Nutri.PriorityScheduler", "Awaiting for the scheduler's termination failed but the exception was ignored. Maybe it's already terminated?", new Object[0]);
            }
            uvVar.q = null;
        }
        pn<DocumentView> pnVar = uvVar.m;
        boolean zB = pnVar.b();
        pnVar.c = null;
        pnVar.d.clear();
        if (zB) {
            pnVar.a.onComplete();
        }
        ReplaySubject<T> replaySubjectCreate = ReplaySubject.create(1);
        replaySubjectCreate.getClass();
        pnVar.a = replaySubjectCreate;
        pn<uv.b> pnVar2 = uvVar.l;
        boolean zB2 = pnVar2.b();
        pnVar2.c = null;
        pnVar2.d.clear();
        if (zB2) {
            pnVar2.a.onComplete();
        }
        ReplaySubject<T> replaySubjectCreate2 = ReplaySubject.create(1);
        replaySubjectCreate2.getClass();
        pnVar2.a = replaySubjectCreate2;
        DocumentView documentView2 = uvVar.n;
        if (documentView2 != null) {
            documentView2.i.clear();
            q0 q0Var = documentView2.G;
            if (q0Var != null) {
                q0Var.k.clear();
                q0Var.l.clear();
            }
            lm lmVar = documentView2.S;
            if (lmVar != null) {
                o3 annotationProvider = lmVar.getAnnotationProvider();
                annotationProvider.getClass();
                annotationProvider.h.b(documentView2);
            }
            yh yhVar = documentView2.o;
            yhVar.a.clear();
            yhVar.b.clear();
            yhVar.c.clear();
            yhVar.d.clear();
            yhVar.e.clear();
            yhVar.f.clear();
            x50 x50Var = documentView2.p;
            x50Var.b.clear();
            x50Var.a.clear();
            i iVar = documentView2.z;
            if (iVar != null) {
                iVar.b.clear();
            }
            nb nbVar = documentView2.n;
            nbVar.a.clear();
            nbVar.b.clear();
            documentView2.setDocumentListener(null);
            documentView2.l0.clear();
            documentView2.setOnDocumentInteractionListener(null);
            documentView2.setDocumentScrollListener(null);
            documentView2.setOnDocumentLongPressListener(null);
            if (documentView2.a != null) {
                documentView2.setOnPreparePopupToolbarListener(null);
            }
            zd zdVar = documentView2.a;
            if (zdVar != null) {
                zdVar.a();
            }
            documentView2.q();
        }
        uvVar.n = null;
        c5 c5Var = uvVar.f;
        if (c5Var != null) {
            c5Var.d.clear();
            c5Var.s.clear();
            c5Var.i.clear();
            Iterator it = c5Var.h.values().iterator();
            while (it.hasNext()) {
                Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
            }
            c5Var.h.clear();
            c5Var.f.a.clear();
            JobKt__JobKt.cancelChildren$default(c5Var.g.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
            uvVar.f = null;
        }
        FrameLayout frameLayout = uvVar.i;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            uvVar.i = null;
        }
        uvVar.m = new pn<>();
        uvVar.j = null;
        uvVar.k = null;
        uvVar.o = false;
        this.pageChangeSubject = BehaviorSubject.create();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.documentListeners = new go<>();
        this.documentScrollListeners.clear();
        this.userInterfaceListeners = new go<>();
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public boolean onDocumentClick() {
        Iterator<DocumentListener> it = this.documentListeners.iterator();
        boolean zOnDocumentClick = false;
        while (it.hasNext()) {
            zOnDocumentClick |= it.next().onDocumentClick();
        }
        return zOnDocumentClick;
    }

    public void onDocumentLoaded(final PdfDocument pdfDocument) {
        Single<DocumentView> singleObserveOn;
        final lm lmVar = (lm) pdfDocument;
        if (this.configuration.isJavaScriptEnabled()) {
            try {
                lmVar.l.executeDocumentLevelScriptsAsync().blockingAwait();
            } catch (RuntimeException e) {
                if (!(e.getCause() instanceof InterruptedException)) {
                    throw e;
                }
                PdfLog.w("Nutri.PdfFragment", "JavaScript execution interrupted during document load (likely during test teardown)", e.getCause());
                Thread.currentThread().interrupt();
                return;
            }
        }
        CompositeDisposable compositeDisposable = this.lifecycleDisposable;
        pn<DocumentView> pnVar = this.viewCoordinator.m;
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
        compositeDisposable.add(singleObserveOn.subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda102
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$onDocumentLoaded$52(pdfDocument, lmVar, (DocumentView) obj);
            }
        }));
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public boolean onDocumentSave(PdfDocument pdfDocument, DocumentSaveOptions documentSaveOptions) {
        boolean z;
        go<DocumentListener> goVar = this.weakDocumentListeners.get();
        if (goVar == null) {
            return true;
        }
        Iterator<DocumentListener> it = goVar.iterator();
        loop0: while (true) {
            z = true;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                DocumentListener next = it.next();
                boolean zOnDocumentSave = next.onDocumentSave(pdfDocument, documentSaveOptions);
                if (!zOnDocumentSave) {
                    PdfLog.d("Nutri.PdfFragment", "Document save has been cancelled by " + next, new Object[0]);
                }
                if (!z || !zOnDocumentSave) {
                    z = false;
                }
            }
        }
        if (z) {
            refreshUserInterfaceState();
        }
        return z;
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentSaveCancelled(PdfDocument pdfDocument) {
        refreshUserInterfaceState();
        go<DocumentListener> goVar = this.weakDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<DocumentListener> it = goVar.iterator();
        while (it.hasNext()) {
            it.next().onDocumentSaveCancelled(pdfDocument);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentSaveFailed(PdfDocument pdfDocument, Throwable th) {
        g60 g60VarC;
        refreshUserInterfaceState();
        Completable completableA = q10.a.a().a(pdfDocument.getUid(), pdfDocument.getPageCount());
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        completableA.subscribeOn(((m0) g60VarC).a()).subscribe();
        PdfLog.d("Nutri.PdfFragment", "Document saving failed, clearing the document cache.", new Object[0]);
        go<DocumentListener> goVar = this.weakDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<DocumentListener> it = goVar.iterator();
        while (it.hasNext()) {
            it.next().onDocumentSaveFailed(pdfDocument, th);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentSaved(PdfDocument pdfDocument) {
        refreshUserInterfaceState();
        Context context = getContext();
        if (context == null && (context = n5.a) == null) {
            throw new IllegalStateException("The application context should not be null. Please call fun setApplicationContext(context: Context) first");
        }
        ImageDocument imageDocument = this.imageDocument;
        if (imageDocument != null) {
            ImageDocumentUtils.refreshMediaStore(context, imageDocument);
        }
        go<DocumentListener> goVar = this.weakDocumentListeners.get();
        if (goVar == null) {
            return;
        }
        Iterator<DocumentListener> it = goVar.iterator();
        while (it.hasNext()) {
            it.next().onDocumentSaved(pdfDocument);
        }
    }

    @Override // com.pspdfkit.listeners.scrolling.DocumentScrollListener
    public void onDocumentScrolled(int i, int i2, int i3, int i4, int i5, int i6) {
        Iterator<DocumentScrollListener> it = this.documentScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onDocumentScrolled(i, i2, i3, i4, i5, i6);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentZoomed(PdfDocument pdfDocument, int i, float f) {
        Iterator<DocumentListener> it = this.documentListeners.iterator();
        while (it.hasNext()) {
            it.next().onDocumentZoomed(pdfDocument, i, f);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementDeselectedListener
    public void onFormElementDeselected(FormElement formElement, boolean z) {
        if (z) {
            return;
        }
        exitCurrentlyActiveMode();
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager.OnFormElementSelectedListener
    public void onFormElementSelected(FormElement formElement) {
        enterFormEditingMode(formElement);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onPageChanged(PdfDocument pdfDocument, int i) {
        BehaviorSubject<Integer> behaviorSubject = this.pageChangeSubject;
        if (behaviorSubject != null) {
            behaviorSubject.onNext(Integer.valueOf(i));
        }
        Iterator<DocumentListener> it = this.documentListeners.iterator();
        while (it.hasNext()) {
            it.next().onPageChanged(pdfDocument, i);
        }
        if (!this.historyActionInProgress) {
            this.navigationHistory.resetForwardList();
        }
        this.historyActionInProgress = false;
        this.displayedPage = i;
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public boolean onPageClick(PdfDocument pdfDocument, int i, MotionEvent motionEvent, PointF pointF, Annotation annotation) {
        Iterator<DocumentListener> it = this.documentListeners.iterator();
        boolean zOnPageClick = false;
        while (it.hasNext()) {
            PdfDocument pdfDocument2 = pdfDocument;
            zOnPageClick |= it.next().onPageClick(pdfDocument2, i, motionEvent, pointF, annotation);
            pdfDocument = pdfDocument2;
        }
        return zOnPageClick;
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onPageUpdated(PdfDocument pdfDocument, int i) {
        Iterator<DocumentListener> it = this.documentListeners.iterator();
        while (it.hasNext()) {
            it.next().onPageUpdated(pdfDocument, i);
        }
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotationSelectedListener
    public boolean onPrepareAnnotationSelection(AnnotationSelectionController annotationSelectionController, Annotation annotation, boolean z) {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        refreshUserInterfaceState();
        this.javaScriptPlatformDelegate.getClass();
        ar.b().a(NativeLicenseFeatures.ACRO_FORMS);
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        b20 b20Var = this.signatureFormSigningHandler;
        b20Var.getClass();
        bundle.getClass();
        SignatureFormElement signatureFormElement = b20Var.d;
        if (signatureFormElement != null) {
            WidgetAnnotation annotation = signatureFormElement.getAnnotation();
            annotation.getClass();
            wu wuVar = new wu(annotation.getPageIndex(), annotation.getInternal().getUuid(), annotation.getObjectNumber());
            wuVar.d = annotation;
            bundle.putParcelable("SignatureFormSigningHandler.FormElementBeingSigned", wuVar);
        }
        bundle.putParcelable(PARAM_FRAGMENT_STATE, getState());
        String str = this.password;
        if (str != null) {
            bundle.putString(PARAM_PASSWORD, str);
        }
    }

    @Override // com.pspdfkit.listeners.scrolling.DocumentScrollListener
    public void onScrollStateChanged(ScrollState scrollState) {
        Iterator<DocumentScrollListener> it = this.documentScrollListeners.iterator();
        while (it.hasNext()) {
            it.next().onScrollStateChanged(scrollState);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        final lm lmVar = this.document;
        boolean z = getContentEditingState() != null;
        if (lmVar != null) {
            if (!this.configuration.isAutosaveEnabled() || z) {
                Single.fromCallable(new Callable() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda46
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return Boolean.valueOf(lmVar.getAnnotationProvider().hasUnsavedChanges());
                    }
                }).subscribeOn(((m0) ar.d()).a()).flatMapCompletable(new Function() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda47
                    @Override // io.reactivex.rxjava3.functions.Function
                    public final Object apply(Object obj) {
                        return PdfFragment.lambda$onStop$10(lmVar, (Boolean) obj);
                    }
                }).subscribe();
            } else {
                de deVar = this.documentSaver;
                if (deVar != null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    synchronized (deVar) {
                        timeUnit.getClass();
                        if (!deVar.c) {
                            deVar.c = true;
                            try {
                                ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new je(deVar, null), 1, null)).getClass();
                            } catch (TimeoutCancellationException unused) {
                                deVar.c = false;
                                PdfLog.d("Nutri.DocumentSaver", "Save with timeout (%d %s) did not complete.", 4L, timeUnit);
                            } catch (Exception e) {
                                deVar.a(e);
                            }
                        }
                    }
                }
            }
            storeLastViewedPageInDocumentDataStoreIfNeeded();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isChangingConfigurations()) {
            return;
        }
        y5 y5Var = this.audioModeManager;
        j6 j6Var = y5Var.c.e;
        if (j6Var != null) {
            j6Var.a();
            j6Var.a.pause();
            j6.b bVar = j6.b.PAUSED;
            if (j6Var.c != bVar) {
                j6Var.c = bVar;
                j6.a aVar = j6Var.d;
                if (aVar != null) {
                    aVar.a(bVar);
                }
            }
        }
        y5Var.d.pause();
        c60.a aVar2 = c60.a;
        if (aVar2 != null) {
            aVar2.a();
            c60.a = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.viewCoordinator.c();
        addOnAnnotationSelectedListener(this);
        addOnFormElementSelectedListener(this);
        addOnFormElementDeselectedListener(this);
        if (bundle != null) {
            onRestoreInstanceState(bundle);
        }
    }

    public Single<? extends PdfDocument> openDocumentAsync() {
        return PdfDocumentLoader.openDocumentsAsync(requireContext(), this.documentSources, this.configuration.isMultithreadedRenderingEnabled());
    }

    public void refreshPages() {
        if (this.document == null || this.viewCoordinator.a(false) == null) {
            return;
        }
        final List<Integer> visiblePages = this.viewCoordinator.a(false).getVisiblePages();
        this.viewCoordinator.a(new uv.d() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda9
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                PdfFragment.lambda$refreshPages$7(visiblePages, bVar);
            }
        }, false);
    }

    public void removeAnnotationViewsListener(final AnnotationViewsListener annotationViewsListener) {
        uw.a(annotationViewsListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda73
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$removeAnnotationViewsListener$101(annotationViewsListener, documentView);
            }
        });
    }

    @Override // com.pspdfkit.annotations.actions.ActionResolver
    public void removeDocumentActionListener(final DocumentActionListener documentActionListener) {
        uw.a(documentActionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda23
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$removeDocumentActionListener$46(documentActionListener, documentView);
            }
        });
    }

    public void removeDocumentListener(DocumentListener documentListener) {
        uw.a(documentListener, "documentListener", null);
        this.documentListeners.b(documentListener);
    }

    public void removeDocumentScrollListener(DocumentScrollListener documentScrollListener) {
        uw.a(documentScrollListener, "documentScrollListener", null);
        this.documentScrollListeners.b(documentScrollListener);
    }

    @Override // com.pspdfkit.ui.drawable.PdfDrawableManager
    public void removeDrawableProvider(final PdfDrawableProvider pdfDrawableProvider) {
        uw.a(pdfDrawableProvider, "drawableProvider", null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda81
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.removeDrawableProvider(pdfDrawableProvider);
            }
        }, false);
    }

    public void removeOnAnnotatingModeChangeListener(final OnAnnotatingModeChangeListener onAnnotatingModeChangeListener) {
        uw.a(onAnnotatingModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda106
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$removeOnAnnotatingModeChangeListener$65(onAnnotatingModeChangeListener, documentView);
            }
        });
    }

    public void removeOnAnnotatingModeSettingsChangeListener(final OnAnnotatingModeSettingsChangeListener onAnnotatingModeSettingsChangeListener) {
        uw.a(onAnnotatingModeSettingsChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda91
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$removeOnAnnotatingModeSettingsChangeListener$67(onAnnotatingModeSettingsChangeListener, documentView);
            }
        });
    }

    public void removeOnAnnotationSelectedListener(final OnAnnotationSelectedListener onAnnotationSelectedListener) {
        uw.a(onAnnotationSelectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda92
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.i.b(onAnnotationSelectedListener);
            }
        });
    }

    public void removeOnAnnotationUpdatedListener(AnnotationProvider.OnAnnotationUpdatedListener onAnnotationUpdatedListener) {
        uw.a(onAnnotationUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        lm lmVar = this.document;
        if (lmVar != null) {
            o3 annotationProvider = lmVar.getAnnotationProvider();
            annotationProvider.getClass();
            annotationProvider.h.b(onAnnotationUpdatedListener);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager
    public void removeOnContentEditingContentChangeListener(final ContentEditingManager.OnContentEditingContentChangeListener onContentEditingContentChangeListener) {
        uw.a(onContentEditingContentChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda43
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getContentEditingManager().removeOnContentEditingContentChangeListener(onContentEditingContentChangeListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager
    public void removeOnContentEditingModeChangeListener(final ContentEditingManager.OnContentEditingModeChangeListener onContentEditingModeChangeListener) {
        uw.a(onContentEditingModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda89
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getContentEditingManager().removeOnContentEditingModeChangeListener(onContentEditingModeChangeListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void removeOnFormElementClickedListener(final FormManager.OnFormElementClickedListener onFormElementClickedListener) {
        uw.a(onFormElementClickedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda8
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().e.b(onFormElementClickedListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void removeOnFormElementDeselectedListener(final FormManager.OnFormElementDeselectedListener onFormElementDeselectedListener) {
        uw.a(onFormElementDeselectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda45
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().b.b(onFormElementDeselectedListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void removeOnFormElementEditingModeChangeListener(final FormManager.OnFormElementEditingModeChangeListener onFormElementEditingModeChangeListener) {
        uw.a(onFormElementEditingModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda34
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().d.b(onFormElementEditingModeChangeListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void removeOnFormElementSelectedListener(final FormManager.OnFormElementSelectedListener onFormElementSelectedListener) {
        uw.a(onFormElementSelectedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda26
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().a.b(onFormElementSelectedListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void removeOnFormElementUpdatedListener(final FormManager.OnFormElementUpdatedListener onFormElementUpdatedListener) {
        uw.a(onFormElementUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda90
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().c.b(onFormElementUpdatedListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void removeOnFormElementViewUpdatedListener(final FormManager.OnFormElementViewUpdatedListener onFormElementViewUpdatedListener) {
        uw.a(onFormElementViewUpdatedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda25
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().f.b(onFormElementViewUpdatedListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.FormManager
    public void removeOnTextFormElementSuggestionRequestListener(final FormManager.OnTextFormElementSuggestionRequestListener onTextFormElementSuggestionRequestListener) {
        uw.a(onTextFormElementSuggestionRequestListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda38
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getFormListeners().g.b(onTextFormElementSuggestionRequestListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager
    public void removeOnTextSelectionChangeListener(final TextSelectionManager.OnTextSelectionChangeListener onTextSelectionChangeListener) {
        uw.a(onTextSelectionChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda15
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getTextSelectionListeners().b.b(onTextSelectionChangeListener);
            }
        });
    }

    @Override // com.pspdfkit.ui.special_mode.manager.TextSelectionManager
    public void removeOnTextSelectionModeChangeListener(final TextSelectionManager.OnTextSelectionModeChangeListener onTextSelectionModeChangeListener) {
        uw.a(onTextSelectionModeChangeListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        withDocumentView(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda33
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.getTextSelectionListeners().a.b(onTextSelectionModeChangeListener);
            }
        });
    }

    public void removeOverlayViewProvider(final OverlayViewProvider overlayViewProvider) {
        if (!ar.b().a(NativeLicenseFeatures.ANNOTATION_EDITING)) {
            throw new InvalidNutrientLicenseException("Using removeOverlayViewProvider() requires the annotations component.");
        }
        uw.a(overlayViewProvider, "overlayViewProvider", null);
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda52
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$removeOverlayViewProvider$60(overlayViewProvider, documentView);
            }
        }, false);
    }

    public boolean save() {
        de deVar = this.documentSaver;
        if (deVar == null) {
            return false;
        }
        synchronized (deVar) {
            if (deVar.c) {
                return false;
            }
            deVar.c = true;
            try {
                return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new ie(deVar, null), 1, null)).booleanValue();
            } catch (Exception e) {
                deVar.a(e);
                return false;
            }
        }
    }

    public void saveAsync() {
        if (this.documentSaver == null) {
            return;
        }
        this.documentSaver.a().subscribe(new b30<Boolean>(this.weakDocumentListeners.get()) { // from class: com.pspdfkit.ui.PdfFragment.5
            final go<DocumentListener> listenerReference;
            final /* synthetic */ go val$listeners;

            {
                this.val$listeners = goVar;
                this.listenerReference = goVar;
            }
        });
    }

    public void scrollTo(final RectF rectF, final int i, final long j, final boolean z) {
        cancelRestorePagePosition();
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$scrollTo$38(rectF, i, j, z, documentView);
            }
        }, false);
    }

    public void setAnnotationOverlayAboveOverlayViews(final boolean z) {
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda65
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.setAnnotationOverlayAboveOverlayViews(z);
            }
        }, false);
    }

    public void setAnnotationOverlayEnabled(final boolean z) {
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda103
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.setAnnotationOverlayEnabled(z);
            }
        }, false);
    }

    public void setAnnotationOverlayRenderStrategy(AnnotationOverlayRenderStrategy annotationOverlayRenderStrategy) {
        uv uvVar = this.viewCoordinator;
        synchronized (uvVar) {
            uvVar.g = annotationOverlayRenderStrategy;
            c5 c5Var = uvVar.f;
            if (c5Var != null) {
                if (annotationOverlayRenderStrategy != null) {
                    c5Var.e = annotationOverlayRenderStrategy;
                } else {
                    c5Var.e = c5.t;
                }
            }
        }
    }

    public void setBackgroundColor(int i) {
        this.viewCoordinator.a(i);
    }

    public void setCustomPdfSource(DocumentSource documentSource) {
        uw.a(documentSource, "source", null);
        setCustomPdfSources(Collections.singletonList(documentSource));
    }

    public void setCustomPdfSources(List<DocumentSource> list) {
        uw.a(list, "sources", null);
        storeLastViewedPageInDocumentDataStoreIfNeeded();
        this.documentSources = new ArrayList(list);
        resetDocument();
        this.viewCoordinator.c();
        this.viewCoordinator.a(new uv.d() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda94
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                this.f$0.lambda$setCustomPdfSources$39(bVar);
            }
        }, false);
    }

    public void setDocumentCoordinator(DocumentCoordinator documentCoordinator) {
        this.documentCoordinator = documentCoordinator;
    }

    public void setDocumentInteractionEnabled(final boolean z) {
        this.viewCoordinator.a(new uv.d() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda36
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                this.f$0.lambda$setDocumentInteractionEnabled$20(z, bVar);
            }
        }, false);
    }

    public void setEditListenerForAnnotationProvider(o3 o3Var) {
        o3Var.e = this.undoManager;
    }

    public void setInsets(int i, int i2, int i3, int i4) {
        this.insetsLeft = i;
        this.insetsTop = i2;
        this.insetsRight = i3;
        this.insetsBottom = i4;
        setDocumentInsets(i, i2, i3, i4);
    }

    public void setOnDocumentLongPressListener(final OnDocumentLongPressListener onDocumentLongPressListener) {
        this.viewCoordinator.a(new uv.d() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda17
            @Override // com.pspdfkit.internal.uv.d
            public final void a(uv.b bVar) {
                this.f$0.lambda$setOnDocumentLongPressListener$40(onDocumentLongPressListener, bVar);
            }
        }, false);
    }

    public void setOnPreparePopupToolbarListener(final OnPreparePopupToolbarListener onPreparePopupToolbarListener) {
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda86
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.setOnPreparePopupToolbarListener(onPreparePopupToolbarListener);
            }
        }, false);
    }

    public void setOverlaidAnnotationTypes(EnumSet<AnnotationType> enumSet) {
        uw.a(enumSet, "getOverlaidAnnotationTypes", null);
        final EnumSet<E> enumSetClone = enumSet.clone();
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda56
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.setOverlaidAnnotationTypes(enumSetClone);
            }
        }, false);
    }

    @Deprecated
    public void setOverlaidAnnotations(List<Annotation> list) {
    }

    @Override // com.pspdfkit.ui.navigation.PageNavigator
    public void setPageIndex(final int i) {
        cancelRestorePagePosition();
        this.displayedPage = i;
        this.animatePageTransition = null;
        lm lmVar = this.document;
        if (lmVar == null) {
            return;
        }
        if (i < 0 || i > lmVar.s - 1) {
            throw new IllegalArgumentException("Invalid page index " + i + " - valid page indexes are [0, " + (this.document.s - 1) + "]");
        }
        if (this.navigationStartPage != null) {
            this.navigationEndPage = Integer.valueOf(i);
        }
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda39
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                documentView.setPage(i);
            }
        }, false);
    }

    public void setPageLoadingDrawable(Drawable drawable) {
        this.viewCoordinator.a(drawable);
    }

    public void setPasswordView(PdfPasswordView pdfPasswordView) {
        Single<uv.b> singleObserveOn;
        uw.a(pdfPasswordView, "pdfPasswordView", null);
        pn<uv.b> pnVar = this.viewCoordinator.l;
        uv.b bVar = pnVar.c;
        if (bVar != null) {
            singleObserveOn = Single.just(bVar);
            singleObserveOn.getClass();
        } else {
            singleObserveOn = pnVar.a.firstOrError().subscribeOn(pnVar.b).observeOn(AndroidSchedulers.mainThread());
            singleObserveOn.getClass();
        }
        singleObserveOn.blockingGet().d = pdfPasswordView;
    }

    public void setRedactionAnnotationPreviewEnabled(final boolean z) {
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda16
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                this.f$0.lambda$setRedactionAnnotationPreviewEnabled$99(z, documentView);
            }
        }, false);
    }

    public void setScrollingEnabled(boolean z) {
        this.viewCoordinator.e(z);
    }

    public void setSelectedMeasurementValueConfiguration(MeasurementValueConfiguration measurementValueConfiguration) {
        if (Intrinsics.areEqual(e60.a, measurementValueConfiguration)) {
            MeasurementValueConfiguration measurementValueConfiguration2 = e60.a;
            if (Intrinsics.areEqual(measurementValueConfiguration2 != null ? measurementValueConfiguration2.getName() : null, measurementValueConfiguration != null ? measurementValueConfiguration.getName() : null)) {
                return;
            }
        }
        e60.a = measurementValueConfiguration;
        o00 o00Var = e60.b;
        if (o00Var != null) {
            o00Var.a(measurementValueConfiguration);
        }
    }

    public void setSignatureStorage(SignatureStorage signatureStorage) {
        this.signatureStorage = signatureStorage;
    }

    public void setUserInterfaceEnabled(boolean z) {
        setUserInterfaceEnabledInternal(z, true);
    }

    public void setViewState(final x70 x70Var) {
        if (this.document == null) {
            return;
        }
        cancelRestorePagePosition();
        this.displayedPage = x70Var.b;
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda62
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                this.f$0.lambda$setViewState$34(x70Var, documentView);
            }
        }, false);
    }

    public void setZoomingEnabled(boolean z) {
        this.viewCoordinator.f(z);
    }

    public boolean shouldReloadDocument() {
        lm lmVar = this.document;
        if (lmVar == null) {
            return true;
        }
        List listUnmodifiableList = Collections.unmodifiableList(lmVar.A);
        listUnmodifiableList.getClass();
        return !listUnmodifiableList.equals(this.documentSources);
    }

    public void zoomBy(final int i, final int i2, final int i3, final float f, final long j) {
        cancelRestorePagePosition();
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda14
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$zoomBy$35(i, i2, i3, f, j, documentView);
            }
        }, false);
    }

    public void zoomTo(final int i, final int i2, final int i3, final float f, final long j) {
        cancelRestorePagePosition();
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda53
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$zoomTo$36(i, i2, i3, f, j, documentView);
            }
        }, false);
    }

    private List<jq> getMediaContentStates() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PdfFragment#getMediaContentStates() may only be called from the main thread.");
        }
        DocumentView documentView = this.viewCoordinator.n;
        return documentView != null ? documentView.getMediaContentStates() : new ArrayList();
    }

    private void setMediaContentStates(List<jq> list) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PdfFragment#setMediaContentStates() may only be called from the main thread.");
        }
        DocumentView documentView = this.viewCoordinator.n;
        if (documentView != null) {
            documentView.setMediaContentStates(list);
        }
    }

    public void addAnnotationToPage(final Annotation annotation, final boolean z, final Runnable runnable) {
        uw.b(this.document != null, "PdfFragment#addAnnotationToPage() may only be called after document has been loaded.");
        uw.a(annotation, "annotation", null);
        if (annotation.isAttached()) {
            return;
        }
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda97
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                this.f$0.lambda$addAnnotationToPage$29(annotation, z, runnable, documentView);
            }
        }, false);
    }

    public boolean clearSelectedAnnotations() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PdfFragment#clearSelectedAnnotations() may only be called from the main thread.");
        }
        DocumentView documentView = this.viewCoordinator.n;
        return documentView != null && documentView.a();
    }

    @Deprecated
    public void enterAnnotationCreationMode(AnnotationTool annotationTool) {
        enterAnnotatingMode(annotationTool);
    }

    @Deprecated
    public void enterAnnotationEditingMode(Annotation annotation) {
        enterAnnotationEditingMode(Collections.singletonList(annotation));
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0041  */
    /* JADX WARN: Code duplicated, block: B:20:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    public void hideAnnotationPopupToolbar() {
        au auVarB;
        vt pageEditor;
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PdfFragment#hideAnnotationPopupToolbar() may only be called from the main thread.");
        }
        List<Annotation> selectedAnnotations = getSelectedAnnotations();
        if (selectedAnnotations.isEmpty()) {
            return;
        }
        uv uvVar = this.viewCoordinator;
        int pageIndex = selectedAnnotations.get(0).getPageIndex();
        if (pageIndex >= 0) {
            DocumentView documentView = uvVar.n;
            if (documentView != null && documentView.getDocument() != null) {
                auVarB = uvVar.n.b(pageIndex);
            }
            pageEditor = auVarB != null ? auVarB.getPageEditor() : null;
            if (pageEditor != null) {
                pageEditor.D.a();
            }
        }
        uvVar.getClass();
        auVarB = null;
        if (auVarB != null) {
        }
        if (pageEditor != null) {
            pageEditor.D.a();
        }
    }

    public void setSelectedAnnotation(Annotation annotation) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PdfFragment#setSelectedAnnotation() may only be called from the main thread.");
        }
        uw.a(annotation, "annotation", null);
        setSelectedAnnotations(Collections.singletonList(annotation));
    }

    public void setSelectedAnnotations(final Collection<? extends Annotation> collection) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PdfFragment#setSelectedAnnotations() may only be called from the main thread.");
        }
        if (collection.isEmpty()) {
            clearSelectedAnnotations();
            return;
        }
        Iterator<? extends Annotation> it = collection.iterator();
        final int pageIndex = it.next().getPageIndex();
        while (it.hasNext()) {
            if (it.next().getPageIndex() != pageIndex) {
                throw new IllegalArgumentException("You may only select annotations that are on the same document page.");
            }
        }
        vt pageEditorForPage = getPageEditorForPage(pageIndex);
        if (pageEditorForPage != null) {
            pageEditorForPage.a(false, collection);
        } else {
            this.lifecycleDisposable.add(this.pageChangeSubject.filter(new Predicate() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda6
                @Override // io.reactivex.rxjava3.functions.Predicate
                public final boolean test(Object obj) {
                    return PdfFragment.lambda$setSelectedAnnotations$25(pageIndex, (Integer) obj);
                }
            }).firstOrError().subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda7
                @Override // io.reactivex.rxjava3.functions.Consumer
                public final void accept(Object obj) throws Throwable {
                    this.f$0.lambda$setSelectedAnnotations$26(collection, (Integer) obj);
                }
            }));
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034  */
    public void setSelectedFormElement(final FormElement formElement) {
        au auVarB;
        mh formEditor;
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PdfFragment#setSelectedFormElement() may only be called from the main thread.");
        }
        final int pageIndex = formElement.getAnnotation().getPageIndex();
        uv uvVar = this.viewCoordinator;
        if (pageIndex >= 0) {
            DocumentView documentView = uvVar.n;
            if (documentView != null && documentView.getDocument() != null) {
                auVarB = uvVar.n.b(pageIndex);
            }
            formEditor = auVarB != null ? auVarB.getFormEditor() : null;
            if (formEditor == null && pageIndex == getPageIndex()) {
                formEditor.c(formElement);
                return;
            } else {
                this.lifecycleDisposable.add(this.pageChangeSubject.filter(new Predicate() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda83
                    @Override // io.reactivex.rxjava3.functions.Predicate
                    public final boolean test(Object obj) {
                        return PdfFragment.lambda$setSelectedFormElement$30(pageIndex, (Integer) obj);
                    }
                }).firstOrError().subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda85
                    @Override // io.reactivex.rxjava3.functions.Consumer
                    public final void accept(Object obj) throws Throwable {
                        this.f$0.lambda$setSelectedFormElement$31(pageIndex, formElement, (Integer) obj);
                    }
                }));
                setPageIndex(pageIndex, true);
            }
        }
        uvVar.getClass();
        auVarB = null;
        if (auVarB != null) {
        }
        if (formEditor == null) {
        }
        this.lifecycleDisposable.add(this.pageChangeSubject.filter(new Predicate() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda83
            @Override // io.reactivex.rxjava3.functions.Predicate
            public final boolean test(Object obj) {
                return PdfFragment.lambda$setSelectedFormElement$30(pageIndex, (Integer) obj);
            }
        }).firstOrError().subscribe(new Consumer() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda85
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$setSelectedFormElement$31(pageIndex, formElement, (Integer) obj);
            }
        }));
        setPageIndex(pageIndex, true);
    }

    public void setState(Bundle bundle) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PdfFragment#setState() may only be called from the main thread.");
        }
        NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> navigationBackStack = (NavigationBackStack) bundle.getParcelable(PARAM_NAVIGATION_HISTORY);
        if (navigationBackStack != null) {
            this.navigationHistory.replaceWith(navigationBackStack);
            this.navigationHistory.addBackStackListener(this.navigationItemBackStackListener);
        }
        x70 x70Var = (x70) bundle.getParcelable(PARAM_CURRENT_VIEW_STATE);
        if (x70Var != null && x70Var.b != getPageIndex()) {
            this.historyActionInProgress = true;
        }
        this.lastEnabledSpecialModeState = (n30) bundle.getParcelable(PARAM_LAST_ENABLED_SPECIAL_MODE_STATE);
        setRedactionAnnotationPreviewEnabled(bundle.getBoolean(PARAM_REDACTION_PREVIEW_STATE));
        if (this.viewCoordinator.m.b()) {
            setFragmentUiState(bundle);
        } else {
            this.fragmentState = bundle;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0041  */
    /* JADX WARN: Code duplicated, block: B:20:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    public void showAnnotationPopupToolbar() {
        au auVarB;
        vt pageEditor;
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PdfFragment#showAnnotationPopupToolbar() may only be called from the main thread.");
        }
        List<Annotation> selectedAnnotations = getSelectedAnnotations();
        if (selectedAnnotations.isEmpty()) {
            return;
        }
        uv uvVar = this.viewCoordinator;
        int pageIndex = selectedAnnotations.get(0).getPageIndex();
        if (pageIndex >= 0) {
            DocumentView documentView = uvVar.n;
            if (documentView != null && documentView.getDocument() != null) {
                auVarB = uvVar.n.b(pageIndex);
            }
            pageEditor = auVarB != null ? auVarB.getPageEditor() : null;
            if (pageEditor != null) {
                pageEditor.D.b();
            }
        }
        uvVar.getClass();
        auVarB = null;
        if (auVarB != null) {
        }
        if (pageEditor != null) {
            pageEditor.D.b();
        }
    }

    @Deprecated
    public void enterAnnotationCreationMode(AnnotationTool annotationTool, AnnotationToolVariant annotationToolVariant) {
        enterAnnotatingMode(annotationTool, annotationToolVariant);
    }

    public static PdfFragment newImageInstance(DataProvider dataProvider, PdfConfiguration pdfConfiguration) {
        uw.a(dataProvider, "source", null);
        uw.a(pdfConfiguration, "configuration", null);
        return newImageInstance(new DocumentSource(dataProvider), pdfConfiguration);
    }

    public void enterAnnotatingMode() {
        List<Pair<AnnotationTool, AnnotationToolVariant>> lastAnnotationTools = PSPDFKitPreferences.get(requireContext()).getLastAnnotationTools();
        AnnotationTool annotationTool = lastAnnotationTools.isEmpty() ? AnnotationTool.NONE : (AnnotationTool) lastAnnotationTools.get(0).first;
        AnnotationToolVariant annotationToolVariantDefaultVariant = lastAnnotationTools.isEmpty() ? AnnotationToolVariant.defaultVariant() : (AnnotationToolVariant) lastAnnotationTools.get(0).second;
        if (!ar.b().a(this.configuration, annotationTool)) {
            annotationTool = AnnotationTool.NONE;
        }
        enterAnnotatingMode(annotationTool, annotationToolVariantDefaultVariant);
    }

    @Override // com.pspdfkit.annotations.actions.ActionResolver
    public void executeAction(com.pspdfkit.annotations.actions.Action action) {
        executeAction(action, null);
    }

    public void zoomTo(final RectF rectF, final int i, final long j) {
        cancelRestorePagePosition();
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda35
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                PdfFragment.lambda$zoomTo$37(rectF, i, j, documentView);
            }
        }, false);
    }

    public static PdfFragment newInstance(DataProvider dataProvider, String str, String str2, PdfConfiguration pdfConfiguration) {
        uw.a(dataProvider, "source", null);
        uw.a(pdfConfiguration, "configuration", null);
        return newInstanceFromDocumentSources(Collections.singletonList(new DocumentSource(dataProvider, str, str2)), pdfConfiguration);
    }

    public static PdfFragment newImageInstance(DocumentSource documentSource, PdfConfiguration pdfConfiguration) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(PARAM_CONFIGURATION, pdfConfiguration);
        if (vu.a(documentSource)) {
            bundle.putParcelable(PARAM_IMAGE_DOCUMENT_SOURCE, new vu(documentSource));
        }
        PdfFragment pdfFragment = new PdfFragment();
        pdfFragment.setArguments(bundle);
        if (!vu.a(documentSource)) {
            pdfFragment.imageDocumentSource = documentSource;
        }
        return pdfFragment;
    }

    public static PdfFragment newInstance(List<Uri> list, List<String> list2, List<String> list3, PdfConfiguration pdfConfiguration) {
        uw.a(list, "documentUris", null);
        uw.a(pdfConfiguration, "configuration", null);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        while (i < size) {
            arrayList.add(new DocumentSource(list.get(i), (list2 != null && list2.size() > i) ? list2.get(i) : null, (list3 != null && list3.size() > i) ? list3.get(i) : null));
            i++;
        }
        return newInstanceFromDocumentSources(arrayList, pdfConfiguration);
    }

    public void enterAnnotatingMode(AnnotationTool annotationTool) {
        enterAnnotatingMode(annotationTool, AnnotationToolVariant.defaultVariant());
    }

    public void enterTextSelectionMode(final int i, TextSelectionRectangles textSelectionRectangles) {
        List listA;
        List listA2;
        uw.b(this.document != null, "Document must be loaded before entering text selection mode.");
        if (i >= 0) {
            lm lmVar = this.document;
            if (i < lmVar.s) {
                NativeTextParser nativeTextParserA = lmVar.c.b(i).a();
                if (nativeTextParserA == null) {
                    listA = CollectionsKt.emptyList();
                } else {
                    NativeTextRange nativeTextRangeTextRects = nativeTextParserA.textRects();
                    nativeTextRangeTextRects.getClass();
                    ArrayList<NativeRectDescriptor> rects = nativeTextRangeTextRects.getRects();
                    rects.getClass();
                    listA = r10.a(rects);
                }
                NativeTextParser nativeTextParserA2 = this.document.c.b(i).a();
                if (nativeTextParserA2 == null) {
                    listA2 = CollectionsKt.emptyList();
                } else {
                    NativeTextRange nativeTextRangeTextRects2 = nativeTextParserA2.textRects();
                    nativeTextRangeTextRects2.getClass();
                    ArrayList<NativeRectDescriptor> markupRects = nativeTextRangeTextRects2.getMarkupRects();
                    markupRects.getClass();
                    listA2 = r10.a(markupRects);
                }
                final ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < listA.size(); i2++) {
                    RectF rectF = (RectF) listA.get(i2);
                    for (RectF rectF2 : textSelectionRectangles.getMarkupRectangles()) {
                        if (rectF.left < rectF2.right && rectF2.left < rectF.right && rectF.top > rectF2.bottom && rectF2.top > rectF.bottom) {
                            arrayList.add(rectF);
                            arrayList2.add((RectF) listA2.get(i2));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda98
                        @Override // com.pspdfkit.internal.uv.c
                        public final void a(DocumentView documentView) {
                            documentView.a(i, new TextSelectionRectangles(arrayList, arrayList2));
                        }
                    }, true);
                    return;
                }
                throw new IllegalArgumentException("Invalid list of touched rectangles " + textSelectionRectangles + ". Text rectangles on page don't contain any of the touchedTextRects.");
            }
        }
        throw new IllegalArgumentException("Invalid page index " + i + ". Valid page indexes are [0, " + (this.document.s - 1) + "]");
    }

    @Override // com.pspdfkit.ui.navigation.PageNavigator
    public void setPageIndex(final int i, final boolean z) {
        cancelRestorePagePosition();
        this.displayedPage = i;
        this.animatePageTransition = Boolean.valueOf(z);
        if (this.document == null) {
            return;
        }
        if (this.navigationStartPage != null) {
            this.navigationEndPage = Integer.valueOf(i);
        }
        this.viewCoordinator.a(new uv.c() { // from class: com.pspdfkit.ui.PdfFragment$$ExternalSyntheticLambda18
            @Override // com.pspdfkit.internal.uv.c
            public final void a(DocumentView documentView) {
                this.f$0.lambda$setPageIndex$33(i, z, documentView);
            }
        }, false);
    }

    public static PdfFragment newInstanceFromSources(List<DataProvider> list, PdfConfiguration pdfConfiguration) {
        return newInstanceFromSources(list, null, null, pdfConfiguration);
    }

    public static PdfFragment newInstanceFromSources(List<DataProvider> list, List<String> list2, PdfConfiguration pdfConfiguration) {
        return newInstanceFromSources(list, list2, null, pdfConfiguration);
    }

    public static PdfFragment newInstance(Uri uri, PdfConfiguration pdfConfiguration) {
        return newInstance(uri, (String) null, pdfConfiguration);
    }

    public static PdfFragment newInstance(Uri uri, String str, PdfConfiguration pdfConfiguration) {
        return newInstance(uri, str, (String) null, pdfConfiguration);
    }

    public static PdfFragment newInstance(List<Uri> list, PdfConfiguration pdfConfiguration) {
        return newInstance(list, (List<String>) null, pdfConfiguration);
    }

    public static PdfFragment newInstance(List<Uri> list, List<String> list2, PdfConfiguration pdfConfiguration) {
        return newInstance(list, list2, (List<String>) null, pdfConfiguration);
    }

    public static PdfFragment newInstance(DataProvider dataProvider, String str, PdfConfiguration pdfConfiguration) {
        return newInstance(dataProvider, str, (String) null, pdfConfiguration);
    }

    public static PdfFragment newInstance(PdfDocument pdfDocument, PdfConfiguration pdfConfiguration) {
        PdfFragment pdfFragmentNewInstanceFromDocumentSources = newInstanceFromDocumentSources(pdfDocument.getDocumentSources(), pdfConfiguration);
        pdfFragmentNewInstanceFromDocumentSources.getInternal().setDocument(pdfDocument);
        return pdfFragmentNewInstanceFromDocumentSources;
    }

    public static PdfFragment newInstance(PdfFragment pdfFragment, PdfConfiguration pdfConfiguration) {
        Bundle state = pdfFragment.getState();
        if (pdfFragment.getDocument() != null) {
            PdfFragment pdfFragmentNewInstance = newInstance(pdfFragment.getDocument(), pdfConfiguration);
            pdfFragmentNewInstance.setState(state);
            return pdfFragmentNewInstance;
        }
        PdfFragment pdfFragmentNewInstanceFromDocumentSources = newInstanceFromDocumentSources(pdfFragment.documentSources, pdfConfiguration);
        pdfFragmentNewInstanceFromDocumentSources.setState(state);
        return pdfFragmentNewInstanceFromDocumentSources;
    }
}
