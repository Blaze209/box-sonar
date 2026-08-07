package com.pspdfkit.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.C;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.microsoft.intune.mam.client.view.MAMWindowManagement;
import com.pspdfkit.R;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.configuration.activity.TabBarHidingMode;
import com.pspdfkit.configuration.activity.ThumbnailBarMode;
import com.pspdfkit.configuration.activity.UserInterfaceViewMode;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.configuration.search.SearchType;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.listeners.DocumentListener;
import com.pspdfkit.ui.DocumentCoordinator;
import com.pspdfkit.ui.DocumentDescriptor;
import com.pspdfkit.ui.PSPDFKitViews;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.ui.PdfThumbnailBar;
import com.pspdfkit.ui.UiVisibleCallback;
import com.pspdfkit.ui.audio.AudioView;
import com.pspdfkit.ui.contentediting.ContentEditingStylingBar;
import com.pspdfkit.ui.forms.FormEditingBar;
import com.pspdfkit.ui.navigation.NavigationBackStack;
import com.pspdfkit.ui.redaction.RedactionView;
import com.pspdfkit.ui.scale.MeasurementScaleView;
import com.pspdfkit.ui.search.PdfSearchView;
import com.pspdfkit.ui.special_mode.controller.ContentEditingController;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import com.pspdfkit.ui.tabs.PdfTabBar;
import com.pspdfkit.ui.toolbar.AnnotationToolbar;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public final class dv implements DocumentListener, ToolbarCoordinatorLayout.OnContextualToolbarPositionListener, FormEditingBar.OnFormEditingBarLifecycleListener, ContentEditingStylingBar.OnContentEditingBarLifecycleListener, AudioView.AudioInspectorLifecycleListener {
    public boolean A;
    public UiVisibleCallback B;
    public final iy C;
    public final AudioView D;
    public final PdfThumbnailBar E;
    public Disposable F;
    public final ev G;
    public final Runnable H;
    public final gv I;
    public View.OnLayoutChangeListener J;
    public final AppCompatActivity a;
    public final im b;
    public final ToolbarCoordinatorLayout c;
    public final DocumentCoordinator d;
    public final PdfActivityConfiguration e;
    public cw f;
    public final Toolbar g;
    public final fk h;
    public final Handler i;
    public PdfFragment j;
    public hn.c k;
    public boolean l;
    public boolean m;
    public boolean n;
    public UserInterfaceViewMode o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public na v;
    public AnimatorSet w;
    public final long x;
    public final ReplaySubject<Integer> y;
    public boolean z;

    public static final class a {
        public final String a;
        public final int b;

        public a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && this.b == aVar.b;
        }

        public final int hashCode() {
            String str = this.a;
            return Integer.hashCode(this.b) + ((str == null ? 0 : str.hashCode()) * 31);
        }

        public final String toString() {
            return "PageNumberOverlayData(pageLabel=" + this.a + ", pageCount=" + this.b + ")";
        }
    }

    public interface b {
        void onBindToUserInterfaceCoordinator(dv dvVar);

        void onUserInterfaceViewModeChanged(UserInterfaceViewMode userInterfaceViewMode);

        void onUserInterfaceVisibilityChanged(boolean z);
    }

    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[UserInterfaceViewMode.values().length];
            try {
                iArr[UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_VISIBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_HIDDEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
            int[] iArr2 = new int[PSPDFKitViews.Type.values().length];
            try {
                iArr2[PSPDFKitViews.Type.VIEW_DOCUMENT_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[PSPDFKitViews.Type.VIEW_OUTLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            b = iArr2;
            int[] iArr3 = new int[TabBarHidingMode.values().length];
            try {
                iArr3[TabBarHidingMode.AUTOMATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[TabBarHidingMode.AUTOMATIC_HIDE_SINGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[TabBarHidingMode.SHOW.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[TabBarHidingMode.HIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            c = iArr3;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function0<Unit> a;

        public d(Function0<Unit> function0) {
            this.a = function0;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            this.a.invoke();
        }
    }

    public static final class e<T> implements Consumer {
        public static final e<T> a = new e<>();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Object obj) {
            Throwable th = (Throwable) obj;
            th.getClass();
            PdfLog.e("Nutri.PdfAUICoordinator", th, th.getMessage(), new Object[0]);
        }
    }

    public static final class f implements DocumentView.g {
        public final /* synthetic */ PdfDocument b;
        public final /* synthetic */ DocumentView c;

        public f(PdfDocument pdfDocument, DocumentView documentView) {
            this.b = pdfDocument;
            this.c = documentView;
        }

        @Override // com.pspdfkit.internal.views.document.DocumentView.g
        public final void a() {
            iy iyVar = dv.this.C;
            PdfDocument pdfDocument = this.b;
            iyVar.getClass();
            pdfDocument.getClass();
            Job job = iyVar.d;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            iyVar.e.clear();
            if (pdfDocument.getPageCount() > 2000) {
                PdfLog.w("Nutri.RedactUiCoord", "Only checking first 2000 pages for redactions.", new Object[0]);
            }
            iyVar.d = BuildersKt__Builders_commonKt.launch$default(iyVar.c, null, null, new hy(pdfDocument, iyVar, null), 3, null);
            iyVar.b = pdfDocument;
            this.c.l0.b(this);
        }
    }

    public static final class g implements ContentEditingManager.OnContentEditingModeChangeListener {
        public g() {
        }

        @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingModeChangeListener
        public final void onEnterContentEditingMode(ContentEditingController contentEditingController) {
            contentEditingController.getClass();
            dv.this.I.onBackStackChanged();
        }

        @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingModeChangeListener
        public final void onExitContentEditingMode(ContentEditingController contentEditingController) {
            contentEditingController.getClass();
            dv.this.I.onBackStackChanged();
        }
    }

    public static final class h extends AnimatorListenerAdapter {
        public h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            animator.getClass();
            dv dvVar = dv.this;
            if (dvVar.w == null || dvVar.a.isChangingConfigurations()) {
                return;
            }
            dv.this.n();
            AnimatorSet animatorSet = dv.this.w;
            if (animatorSet != null) {
                animatorSet.removeListener(this);
            }
        }
    }

    public dv(AppCompatActivity appCompatActivity, im imVar, ToolbarCoordinatorLayout toolbarCoordinatorLayout, DocumentCoordinator documentCoordinator, PdfActivityConfiguration pdfActivityConfiguration, jy jyVar, cw cwVar, Toolbar toolbar) {
        appCompatActivity.getClass();
        imVar.getClass();
        toolbarCoordinatorLayout.getClass();
        documentCoordinator.getClass();
        pdfActivityConfiguration.getClass();
        toolbar.getClass();
        this.a = appCompatActivity;
        this.b = imVar;
        this.c = toolbarCoordinatorLayout;
        this.d = documentCoordinator;
        this.e = pdfActivityConfiguration;
        this.f = cwVar;
        this.g = toolbar;
        this.i = new Handler(Looper.getMainLooper());
        this.l = true;
        this.n = true;
        this.o = UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_AUTOMATIC;
        this.x = a80.a();
        ReplaySubject<Integer> replaySubjectCreate = ReplaySubject.create(1);
        replaySubjectCreate.getClass();
        this.y = replaySubjectCreate;
        this.A = true;
        this.B = new hv();
        ev evVar = new ev(this);
        this.G = evVar;
        this.H = new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                dv.d(this.f$0);
            }
        };
        this.I = new gv(this);
        iy iyVar = (jyVar.a && jyVar.b) ? new iy(this) : null;
        this.C = iyVar;
        if (iyVar != null) {
            DocumentCoordinator documentCoordinator2 = iyVar.f;
            if (documentCoordinator2 != null) {
                documentCoordinator2.removeOnDocumentVisibleListener(iyVar);
            }
            documentCoordinator.addOnDocumentVisibleListener(iyVar);
            iyVar.f = documentCoordinator;
        }
        jv jvVar = (jv) imVar;
        this.D = jvVar.s;
        this.E = pdfActivityConfiguration.getThumbnailBarMode() != ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE ? jvVar.j : null;
        fk fkVar = new fk(appCompatActivity, this);
        this.h = fkVar;
        final boolean zIsImmersiveModeEnabled = pdfActivityConfiguration.isImmersiveModeEnabled();
        fkVar.a(zIsImmersiveModeEnabled);
        s();
        cw cwVar2 = this.f;
        if (cwVar2 != null) {
            cwVar2.onBindToUserInterfaceCoordinator(this);
        }
        View decorView = appCompatActivity.getWindow().getDecorView();
        decorView.getClass();
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new y70(decorView, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda9
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                dv.a(this.f$0, zIsImmersiveModeEnabled);
            }
        }));
        View view = jvVar.f;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    dv.a(this.f$0, view2);
                }
            });
            ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda12
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                    return dv.a(this.f$0, view2, windowInsetsCompat);
                }
            });
        }
        View view2 = jvVar.e;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    dv.b(this.f$0, view3);
                }
            });
            ViewCompat.setOnApplyWindowInsetsListener(view2, new OnApplyWindowInsetsListener() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda14
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view3, WindowInsetsCompat windowInsetsCompat) {
                    return dv.b(this.f$0, view3, windowInsetsCompat);
                }
            });
        }
        if (jvVar.d != null) {
            documentCoordinator.addOnDocumentsChangedListener(evVar);
            if (this.l && g()) {
                k(true);
            } else {
                e(true);
            }
        }
        AudioView audioView = jvVar.s;
        if (audioView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(audioView, new OnApplyWindowInsetsListener() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda15
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view3, WindowInsetsCompat windowInsetsCompat) {
                    return dv.a(view3, windowInsetsCompat);
                }
            });
        }
    }

    public static final Unit a(dv dvVar) {
        if (!dvVar.j()) {
            dvVar.a(false, false, false);
        }
        return Unit.INSTANCE;
    }

    public static final void b(dv dvVar, View view) {
        NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> navigationHistory;
        PdfFragment pdfFragment = dvVar.j;
        if (pdfFragment == null || (navigationHistory = pdfFragment.getNavigationHistory()) == null) {
            return;
        }
        navigationHistory.goBack();
    }

    public static final void d(dv dvVar) {
        PdfFragment pdfFragment = dvVar.j;
        if (pdfFragment == null || pdfFragment.isInSpecialMode()) {
            return;
        }
        dvVar.toggleUserInterface();
    }

    public static final void g(dv dvVar) {
        dvVar.n();
    }

    public final void c(boolean z) {
        final TextView documentTitleOverlayView = ((jv) this.b).getDocumentTitleOverlayView();
        if (documentTitleOverlayView == null) {
            return;
        }
        documentTitleOverlayView.animate().cancel();
        documentTitleOverlayView.animate().setDuration(z ? 250 : 0).setInterpolator(new AccelerateInterpolator(1.5f)).translationY(-documentTitleOverlayView.getHeight()).withStartAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                dv.b(this.f$0);
            }
        }).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                dv.a(documentTitleOverlayView);
            }
        }).start();
    }

    public final boolean e() {
        ContentEditingStylingBar contentEditingStylingBar = ((jv) this.b).p;
        return contentEditingStylingBar != null && contentEditingStylingBar.isDisplayed();
    }

    public final boolean f() {
        FormEditingBar formEditingBar = ((jv) this.b).o;
        return formEditingBar != null && formEditingBar.isDisplayed();
    }

    public final void h(boolean z) {
        AnimatorSet animatorSetA;
        if (this.n == z || (animatorSetA = a(z)) == null) {
            return;
        }
        this.n = z;
        AnimatorSet animatorSetB = b();
        a(animatorSetB != null ? CollectionsKt.listOf((Object[]) new Animator[]{animatorSetA, animatorSetB}) : CollectionsKt.listOf(animatorSetA), z, false);
    }

    public final void hideUserInterface() {
        if (!this.l || k()) {
            if (this.l) {
                return;
            }
            this.B.isUiVisible(false);
            return;
        }
        int i = c.b[((jv) this.b).getActiveViewType().ordinal()];
        if (i == 1 || i == 2) {
            jv jvVar = (jv) this.b;
            jvVar.toggleView(jvVar.getActiveViewType(), 0L);
        }
        a(false, false, true);
    }

    public final boolean i() {
        return this.E != null && this.n && h();
    }

    public final boolean j() {
        UserInterfaceViewMode userInterfaceViewMode = this.o;
        if (userInterfaceViewMode == UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_MANUAL) {
            return this.l;
        }
        return (this.r || userInterfaceViewMode == UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_HIDDEN || f() || e()) ? false : true;
    }

    public final boolean k() {
        UserInterfaceViewMode userInterfaceViewMode;
        UserInterfaceViewMode userInterfaceViewMode2;
        if (this.r && (userInterfaceViewMode2 = this.o) != UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_VISIBLE && userInterfaceViewMode2 != UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_MANUAL) {
            return false;
        }
        PdfSearchView pdfSearchView = ((jv) this.b).u;
        boolean z = pdfSearchView != null && pdfSearchView.isShown() && this.e.getSearchType() == SearchType.INLINE;
        if (!this.p && !z) {
            PdfFragment pdfFragment = this.j;
            if ((pdfFragment != null ? pdfFragment.getSelectedFormElement() : null) == null && !this.c.isDisplayingContextualToolbar() && (userInterfaceViewMode = this.o) != UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_VISIBLE && userInterfaceViewMode != UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_MANUAL && !this.m) {
                return false;
            }
        }
        return true;
    }

    public final void l() {
        this.z = true;
        this.y.onNext(0);
        this.y.onComplete();
    }

    public final void m() {
        Context context;
        DocumentDescriptor visibleDocument;
        if (this.e.isDefaultToolbarEnabled()) {
            if (g() || (!this.a.getResources().getBoolean(R.bool.pspdf__display_document_title_in_actionbar) && this.e.isShowDocumentTitleOverlayEnabled())) {
                this.g.setTitle("");
                return;
            }
            Toolbar toolbar = this.g;
            String activityTitle = this.e.getActivityTitle();
            if (activityTitle == null) {
                PdfFragment pdfFragment = this.j;
                activityTitle = (pdfFragment == null || (context = pdfFragment.getContext()) == null || (visibleDocument = this.d.getVisibleDocument()) == null) ? null : visibleDocument.getTitle(context);
            }
            Charset charset = u40.a;
            toolbar.setTitle(activityTitle != null ? activityTitle.toString() : "");
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    public final void n() {
        hn.c cVar;
        int height;
        PdfThumbnailBar pdfThumbnailBar;
        PdfFragment pdfFragment = this.j;
        if (pdfFragment == null) {
            return;
        }
        if (!this.s) {
            pdfFragment.addInsets(0, -this.t, 0, -this.u);
            this.u = 0;
            this.t = 0;
            return;
        }
        int iB = b(true);
        if (this.l && i() && (pdfThumbnailBar = this.E) != null) {
            if (pdfThumbnailBar.isBackgroundTransparent()) {
                height = 0;
            } else {
                height = this.E.getHeight();
            }
        } else if (f()) {
            FormEditingBar formEditingBar = ((jv) this.b).o;
            if (formEditingBar != null) {
                height = formEditingBar.getHeight();
            } else {
                height = 0;
            }
        } else if (e()) {
            ContentEditingStylingBar contentEditingStylingBar = ((jv) this.b).p;
            if (contentEditingStylingBar != null) {
                height = contentEditingStylingBar.getHeight();
            } else {
                height = 0;
            }
        } else if (!this.h.c || (cVar = this.k) == null) {
            height = 0;
        } else {
            height = cVar.g;
        }
        pdfFragment.addInsets(0, iB - this.t, 0, height - this.u);
        this.t = iB;
        this.u = height;
    }

    public final void o() {
        boolean z;
        ContextualToolbar currentlyDisplayedContextualToolbar;
        UserInterfaceViewMode userInterfaceViewMode;
        boolean z2 = this.e.getHideUserInterfaceWhenCreatingAnnotations() && ((userInterfaceViewMode = this.o) == UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_AUTOMATIC || userInterfaceViewMode == UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_AUTOMATIC_BORDER_PAGES);
        if (!this.q || !z2 || (currentlyDisplayedContextualToolbar = this.c.getCurrentlyDisplayedContextualToolbar()) == null || currentlyDisplayedContextualToolbar.getPosition() == ToolbarCoordinatorLayout.LayoutParams.Position.TOP) {
            z = false;
        } else {
            g(false);
            z = true;
        }
        if (!this.e.isDefaultToolbarEnabled()) {
            if (this.q && z2) {
                ContextualToolbar currentlyDisplayedContextualToolbar2 = this.c.getCurrentlyDisplayedContextualToolbar();
                if (currentlyDisplayedContextualToolbar2 != null) {
                    g(currentlyDisplayedContextualToolbar2.getPosition() == ToolbarCoordinatorLayout.LayoutParams.Position.TOP);
                    z = true;
                }
            } else {
                g(false);
            }
        }
        this.r = z;
        if (z) {
            hideUserInterface();
        } else {
            showUserInterface();
        }
        if (t()) {
            i(true);
        } else {
            c(true);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        configuration.getClass();
        fk fkVar = this.h;
        fkVar.a(fkVar.c);
        this.i.postDelayed(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda25
            @Override // java.lang.Runnable
            public final void run() {
                dv.c(this.f$0);
            }
        }, 100L);
    }

    @Override // com.pspdfkit.ui.toolbar.ToolbarCoordinatorLayout.OnContextualToolbarPositionListener
    public final void onContextualToolbarPositionChanged(ContextualToolbar<?> contextualToolbar, ToolbarCoordinatorLayout.LayoutParams.Position position, ToolbarCoordinatorLayout.LayoutParams.Position position2) {
        contextualToolbar.getClass();
        position2.getClass();
        if (contextualToolbar instanceof AnnotationToolbar) {
            o();
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioView.AudioInspectorLifecycleListener
    public final void onDisplayAudioInspector(AudioView audioView) {
        audioView.getClass();
    }

    @Override // com.pspdfkit.ui.contentediting.ContentEditingStylingBar.OnContentEditingBarLifecycleListener
    public final void onDisplayContentEditingBar(ContentEditingStylingBar contentEditingStylingBar) {
        contentEditingStylingBar.getClass();
        g(true);
    }

    @Override // com.pspdfkit.ui.forms.FormEditingBar.OnFormEditingBarLifecycleListener
    public final void onDisplayFormEditingBar(FormEditingBar formEditingBar) {
        formEditingBar.getClass();
        g(true);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentLoadFailed(Throwable th) {
        th.getClass();
        PdfThumbnailBar pdfThumbnailBar = this.E;
        if (pdfThumbnailBar != null) {
            pdfThumbnailBar.setVisibility(4);
        }
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onDocumentLoaded(PdfDocument pdfDocument) {
        PdfThumbnailBar pdfThumbnailBar;
        DocumentView documentViewA;
        PdfSearchView pdfSearchView;
        pdfDocument.getClass();
        PdfFragment pdfFragment = this.j;
        if (pdfFragment == null) {
            return;
        }
        NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> navigationHistory = pdfFragment.getNavigationHistory();
        navigationHistory.getClass();
        navigationHistory.addBackStackListener(this.I);
        View view = ((jv) this.b).e;
        if (view != null) {
            view.setVisibility(4);
        }
        View view2 = ((jv) this.b).f;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        j(false);
        if (this.l) {
            int pageIndex = pdfFragment.getPageIndex();
            a(pageIndex, pageIndex > -1 ? pdfFragment.getSiblingPageIndex(pageIndex) : -1, true);
        }
        if (this.l && ((pdfSearchView = ((jv) this.b).u) == null || pdfSearchView == null || !pdfSearchView.isShown())) {
            i(!this.p);
        }
        if (this.l) {
            k(!this.p);
        }
        if (this.C != null && (documentViewA = pdfFragment.getInternal().getViewCoordinator().a(false)) != null) {
            documentViewA.l0.a(new f(pdfDocument, documentViewA));
            documentViewA.o();
            documentViewA.getContentEditingManager().addOnContentEditingModeChangeListener(new g());
        }
        if (this.e.getThumbnailBarMode() != ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE && (pdfThumbnailBar = this.E) != null && pdfThumbnailBar != null) {
            View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda19
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    dv.a(this.f$0, view3, i, i2, i3, i4, i5, i6, i7, i8);
                }
            };
            this.J = onLayoutChangeListener;
            this.E.addOnLayoutChangeListener(onLayoutChangeListener);
        }
        n();
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public final void onPageChanged(PdfDocument pdfDocument, int i) {
        pdfDocument.getClass();
        PdfFragment pdfFragment = this.j;
        if (pdfFragment == null) {
            return;
        }
        if (this.o == UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_AUTOMATIC_BORDER_PAGES && (i == 0 || i == pdfDocument.getPageCount() - 1)) {
            showUserInterface();
        }
        if (u()) {
            a(i, pdfFragment.getSiblingPageIndex(i), true);
        }
        FloatingActionButton floatingActionButton = ((jv) this.b).x;
        if (floatingActionButton == null) {
            return;
        }
        ViewParent parent = floatingActionButton.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup == null) {
            return;
        }
        if (pdfFragment.getSiblingPageIndex(i) <= 0) {
            viewGroup.setVisibility(8);
        } else {
            viewGroup.setVisibility(0);
        }
    }

    @Override // com.pspdfkit.ui.audio.AudioView.AudioInspectorLifecycleListener
    public final void onPrepareAudioInspector(AudioView audioView) {
        audioView.getClass();
        f(true);
    }

    @Override // com.pspdfkit.ui.contentediting.ContentEditingStylingBar.OnContentEditingBarLifecycleListener
    public final void onPrepareContentEditingBar(ContentEditingStylingBar contentEditingStylingBar) {
        contentEditingStylingBar.getClass();
        if (this.l) {
            a(false, (Runnable) null);
        }
        f(true);
    }

    @Override // com.pspdfkit.ui.forms.FormEditingBar.OnFormEditingBarLifecycleListener
    public final void onPrepareFormEditingBar(FormEditingBar formEditingBar) {
        formEditingBar.getClass();
        if (this.l) {
            a(false, (Runnable) null);
        }
        f(true);
    }

    @Override // com.pspdfkit.ui.audio.AudioView.AudioInspectorLifecycleListener
    public final void onRemoveAudioInspector(AudioView audioView) {
        audioView.getClass();
        f(false);
    }

    @Override // com.pspdfkit.ui.contentediting.ContentEditingStylingBar.OnContentEditingBarLifecycleListener
    public final void onRemoveContentEditingBar(ContentEditingStylingBar contentEditingStylingBar) {
        contentEditingStylingBar.getClass();
        n();
        if (this.l && !contentEditingStylingBar.wasInImmersiveModeBeforeShowing()) {
            a(true, (Runnable) null);
        }
        f(false);
    }

    @Override // com.pspdfkit.ui.forms.FormEditingBar.OnFormEditingBarLifecycleListener
    public final void onRemoveFormEditingBar(FormEditingBar formEditingBar) {
        formEditingBar.getClass();
        g(false);
        if (this.l && !formEditingBar.wasInImmersiveModeBeforeShowing()) {
            a(true, (Runnable) null);
        }
        f(false);
    }

    public final void p() {
        DocumentView documentViewA;
        ContentEditingManager contentEditingManager;
        PdfFragment pdfFragment = this.j;
        if (pdfFragment != null) {
            pdfFragment.removeDocumentListener(this);
            pdfFragment.getNavigationHistory().removeBackStackListener(this.I);
            iy iyVar = this.C;
            if (iyVar != null) {
                pdfFragment.removeOnAnnotationUpdatedListener(iyVar);
            }
        }
        FormEditingBar formEditingBar = ((jv) this.b).o;
        if (formEditingBar != null) {
            formEditingBar.removeOnFormEditingBarLifecycleListener(this);
        }
        ContentEditingStylingBar contentEditingStylingBar = ((jv) this.b).p;
        if (contentEditingStylingBar != null) {
            contentEditingStylingBar.removeOnContentEditingBarLifecycleListener(this);
        }
        AudioView audioView = ((jv) this.b).s;
        if (audioView != null) {
            audioView.removeOnAudioInspectorLifecycleListener(this);
        }
        View.OnLayoutChangeListener onLayoutChangeListener = this.J;
        if (onLayoutChangeListener != null) {
            PdfThumbnailBar pdfThumbnailBar = ((jv) this.b).j;
            if (pdfThumbnailBar != null) {
                pdfThumbnailBar.removeOnLayoutChangeListener(onLayoutChangeListener);
            }
            this.J = null;
        }
        na naVar = this.v;
        if (naVar != null) {
            naVar.a.removeDocumentListener(naVar);
            ma maVar = naVar.e;
            if (maVar != null && (documentViewA = naVar.a.getInternal().getViewCoordinator().a(false)) != null && (contentEditingManager = documentViewA.getContentEditingManager()) != null) {
                contentEditingManager.removeOnContentEditingModeChangeListener(maVar);
            }
        }
        this.v = null;
    }

    public final void q() {
        jv jvVar;
        RedactionView redactionView;
        View view;
        if (!uc.d(this.a) || (redactionView = (jvVar = (jv) this.b).q) == null || (view = jvVar.f) == null) {
            return;
        }
        if (redactionView.isRedactionButtonExpanded()) {
            view.animate().translationX(-redactionView.getRedactionButtonWidth());
        } else if (redactionView.isButtonRedactionButtonVisible()) {
            view.animate().translationX(-a80.a((Context) this.a, 48));
        } else {
            view.animate().translationX(-0);
        }
    }

    public final void r() {
        this.p = true;
        this.i.postDelayed(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                dv.e(this.f$0);
            }
        }, 500L);
    }

    public final void s() {
        hn.c cVar = this.k;
        if (cVar != null) {
            cVar.b();
        }
        AppCompatActivity appCompatActivity = this.a;
        hn.d dVar = new hn.d() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda4
            @Override // com.pspdfkit.internal.hn.d
            public final void a(boolean z) {
                dv.b(this.f$0, z);
            }
        };
        WeakHashMap weakHashMap = hn.a;
        this.k = new hn.c(appCompatActivity, dVar);
    }

    public final void setUserInterfaceViewMode(UserInterfaceViewMode userInterfaceViewMode) {
        userInterfaceViewMode.getClass();
        if (this.o == userInterfaceViewMode) {
            return;
        }
        this.o = userInterfaceViewMode;
        this.c.setMainToolbarEnabled(this.e.isDefaultToolbarEnabled());
        int i = c.a[userInterfaceViewMode.ordinal()];
        boolean z = true;
        if (i == 1) {
            showUserInterface();
        } else if (i == 2) {
            if (this.j != null) {
                this.p = false;
                a(new Function0() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return dv.a(this.f$0);
                    }
                });
            }
            this.c.setMainToolbarEnabled(false);
        }
        if (this.o != UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_VISIBLE && !f() && !e() && (((jv) this.b).getActiveViewType() != PSPDFKitViews.Type.VIEW_SEARCH || this.e.getSearchType() != SearchType.INLINE)) {
            z = false;
        }
        g(z);
        cw cwVar = this.f;
        if (cwVar != null) {
            cwVar.onUserInterfaceViewModeChanged(userInterfaceViewMode);
        }
    }

    public final void showUserInterface() {
        if (this.l || !j()) {
            return;
        }
        a(false, true, true);
    }

    public final boolean t() {
        if (!this.l || ((jv) this.b).getDocumentTitleOverlayView() == null || !this.e.isShowDocumentTitleOverlayEnabled() || this.c.isDisplayingContextualToolbar() || ((jv) this.b).getActiveViewType() != PSPDFKitViews.Type.VIEW_NONE || this.a.getResources().getBoolean(R.bool.pspdf__display_document_title_in_actionbar)) {
            return false;
        }
        return (this.l && g()) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0030  */
    /* JADX WARN: Code duplicated, block: B:26:0x0059 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    public final void toggleUserInterface() {
        View currentFocus;
        if (!j() && !gk.d(this.h.b)) {
            this.h.b(false);
        }
        if (!this.l) {
            if (((jv) this.b).getActiveViewType() == PSPDFKitViews.Type.VIEW_NONE) {
            }
            currentFocus = this.a.getCurrentFocus();
            if (currentFocus == null) {
                return;
            }
            hn.c(currentFocus);
            return;
        }
        int i = c.b[((jv) this.b).getActiveViewType().ordinal()];
        if (i != 1 && i != 2) {
            if (((jv) this.b).getActiveViewType() == PSPDFKitViews.Type.VIEW_NONE || this.c.isDisplayingContextualToolbar()) {
                currentFocus = this.a.getCurrentFocus();
                if (currentFocus == null) {
                    return;
                }
                hn.c(currentFocus);
                return;
            }
        }
        if (this.l) {
            hideUserInterface();
        } else {
            showUserInterface();
        }
    }

    public final boolean u() {
        if (!this.e.isShowPageNumberOverlay() || ((jv) this.b).b == null) {
            return false;
        }
        PdfFragment pdfFragment = this.j;
        return (pdfFragment != null ? pdfFragment.getDocument() : null) != null;
    }

    public final void v() {
        iy iyVar;
        final PdfFragment pdfFragment = this.j;
        if (pdfFragment != null && this.A && ((jv) this.b).q != null && (iyVar = this.C) != null && !iyVar.e.isEmpty() && this.e.isRedactionUiEnabled() && ar.b().a(NativeLicenseFeatures.REDACTION) && ((jv) this.b).getActiveViewType() == PSPDFKitViews.Type.VIEW_NONE) {
            final boolean z = true;
            a(new Function0() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return dv.a(this.f$0, pdfFragment, z);
                }
            });
        }
    }

    public final boolean w() {
        Context context;
        DocumentDescriptor visibleDocument;
        if (!t()) {
            return false;
        }
        PdfFragment pdfFragment = this.j;
        String title = null;
        if ((pdfFragment != null ? pdfFragment.getDocument() : null) == null) {
            return false;
        }
        String activityTitle = this.e.getActivityTitle();
        if (activityTitle != null) {
            title = activityTitle;
        } else {
            PdfFragment pdfFragment2 = this.j;
            if (pdfFragment2 != null && (context = pdfFragment2.getContext()) != null && (visibleDocument = this.d.getVisibleDocument()) != null) {
                title = visibleDocument.getTitle(context);
            }
        }
        TextView documentTitleOverlayView = ((jv) this.b).getDocumentTitleOverlayView();
        if (documentTitleOverlayView != null) {
            Charset charset = u40.a;
            documentTitleOverlayView.setText(title == null ? "" : title.toString());
        }
        return !TextUtils.isEmpty(title);
    }

    public static final WindowInsetsCompat b(dv dvVar, View view, WindowInsetsCompat windowInsetsCompat) {
        view.getClass();
        windowInsetsCompat.getClass();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.getClass();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).left;
        if (dvVar.e.getThumbnailBarMode() == ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE) {
            marginLayoutParams.bottomMargin = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        }
        return windowInsetsCompat;
    }

    public final boolean g() {
        if (((jv) this.b).d == null) {
            return false;
        }
        int i = c.c[this.e.getTabBarHidingMode().ordinal()];
        if (i == 1) {
            List<DocumentDescriptor> documents = this.d.getDocuments();
            documents.getClass();
            return !documents.isEmpty();
        }
        if (i == 2) {
            return this.d.getDocuments().size() > 1;
        }
        if (i == 3) {
            return true;
        }
        if (i == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void i(final boolean z) {
        final TextView documentTitleOverlayView;
        PdfFragment pdfFragment = this.j;
        if (pdfFragment != null) {
            if ((pdfFragment != null ? pdfFragment.getDocument() : null) == null || (documentTitleOverlayView = ((jv) this.b).getDocumentTitleOverlayView()) == null) {
                return;
            }
            if (!t()) {
                c(z);
            } else if (w()) {
                a(new Function0() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return dv.a(documentTitleOverlayView, z, this);
                    }
                });
            }
        }
    }

    public static final void a(final dv dvVar, boolean z) {
        if (dvVar.h.a(z)) {
            View decorView = dvVar.a.getWindow().getDecorView();
            decorView.getClass();
            decorView.getViewTreeObserver().addOnGlobalLayoutListener(new y70(decorView, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda22
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    this.f$0.l();
                }
            }));
            return;
        }
        dvVar.l();
    }

    public static final Unit d(dv dvVar, boolean z) {
        final PdfTabBar pdfTabBar = ((jv) dvVar.b).d;
        if (pdfTabBar == null) {
            return Unit.INSTANCE;
        }
        pdfTabBar.animate().cancel();
        pdfTabBar.animate().setDuration(z ? 250 : 0).setInterpolator(new DecelerateInterpolator(1.5f)).translationY(dvVar.c()).withStartAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda31
            @Override // java.lang.Runnable
            public final void run() {
                dv.b(pdfTabBar);
            }
        }).start();
        return Unit.INSTANCE;
    }

    public static final void e(dv dvVar) {
        dvVar.p = false;
    }

    public static final void f(dv dvVar) {
        PdfFragment pdfFragment = dvVar.j;
        dvVar.g((pdfFragment != null ? pdfFragment.getContentEditingState() : null) != null);
        dvVar.h.b();
    }

    public final void l(boolean z) {
        RedactionView redactionView = ((jv) this.b).q;
        if (redactionView != null) {
            ViewGroup.LayoutParams layoutParams = redactionView.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12, z ? -1 : 0);
                redactionView.setLayoutParams(layoutParams);
            }
        }
        MeasurementScaleView measurementScaleView = ((jv) this.b).r;
        if (measurementScaleView != null) {
            ViewGroup.LayoutParams layoutParams2 = measurementScaleView.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams2).addRule(12, z ? -1 : 0);
                measurementScaleView.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void e(boolean z) {
        final PdfTabBar pdfTabBar = ((jv) this.b).d;
        if (pdfTabBar == null) {
            return;
        }
        pdfTabBar.animate().cancel();
        pdfTabBar.animate().setDuration(z ? 250 : 0).setInterpolator(new AccelerateInterpolator(1.5f)).translationY(-pdfTabBar.getHeight()).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                dv.a(pdfTabBar);
            }
        }).start();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    public final AnimatorSet b() {
        ContentEditingStylingBar contentEditingStylingBar;
        int height;
        View view;
        AudioView audioView;
        ArrayList arrayList = new ArrayList();
        if (h()) {
            PdfThumbnailBar pdfThumbnailBar = this.E;
            if (pdfThumbnailBar != null) {
                height = pdfThumbnailBar.getHeight();
            } else {
                height = 0;
            }
        } else if (f()) {
            FormEditingBar formEditingBar = ((jv) this.b).o;
            if (formEditingBar != null) {
                height = formEditingBar.getHeight();
            } else {
                height = 0;
            }
        } else if (!e() || (contentEditingStylingBar = ((jv) this.b).p) == null) {
            height = 0;
        } else {
            height = contentEditingStylingBar.getHeight();
        }
        float f2 = height;
        boolean z = i() || f() || e();
        float audioInspectorHeight = (this.D == null || (audioView = ((jv) this.b).s) == null || !audioView.isVisible()) ? 0.0f : this.D.getAudioInspectorHeight();
        AudioView audioView2 = this.D;
        if (audioView2 != null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(audioView2, "translationY", audioView2.getTranslationY(), z ? (this.D.getHeight() - this.D.getAudioInspectorHeight()) - f2 : 0.0f);
            objectAnimatorOfFloat.getClass();
            arrayList.add(objectAnimatorOfFloat);
        }
        if (this.e.isShowPageNumberOverlay()) {
            jv jvVar = (jv) this.b;
            if (jvVar.b != null) {
                TextView textView = jvVar.b;
                if (textView == null) {
                    return null;
                }
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, "translationY", textView.getTranslationY(), (z ? 0.0f : f2) - audioInspectorHeight);
                objectAnimatorOfFloat2.getClass();
                arrayList.add(objectAnimatorOfFloat2);
            }
        }
        jv jvVar2 = (jv) this.b;
        if (jvVar2.e != null && jvVar2.f != null && this.e.isShowNavigationButtonsEnabled()) {
            jv jvVar3 = (jv) this.b;
            View view2 = jvVar3.e;
            if (view2 == null || (view = jvVar3.f) == null) {
                return null;
            }
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, "translationY", view2.getTranslationY(), (z ? 0.0f : f2) - audioInspectorHeight);
            objectAnimatorOfFloat3.getClass();
            arrayList.add(objectAnimatorOfFloat3);
            float translationY = view.getTranslationY();
            if (z) {
                f2 = 0.0f;
            }
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view, "translationY", translationY, f2 - audioInspectorHeight);
            objectAnimatorOfFloat4.getClass();
            arrayList.add(objectAnimatorOfFloat4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    public final void f(boolean z) {
        AnimatorSet animatorSetB = b();
        if (animatorSetB == null) {
            return;
        }
        a(CollectionsKt.listOf(animatorSetB), z, true);
    }

    public final void g(boolean z) {
        if (z || (this.o != UserInterfaceViewMode.USER_INTERFACE_VIEW_MODE_VISIBLE && !f() && !e() && (((jv) this.b).getActiveViewType() != PSPDFKitViews.Type.VIEW_SEARCH || this.e.getSearchType() != SearchType.INLINE))) {
            this.s = z;
        }
        n();
    }

    public final void j(final boolean z) {
        PdfFragment pdfFragment;
        NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> navigationHistory;
        if (this.l && this.A) {
            jv jvVar = (jv) this.b;
            if (jvVar.e == null || jvVar.f == null || !this.e.isShowNavigationButtonsEnabled() || ((jv) this.b).getActiveViewType() != PSPDFKitViews.Type.VIEW_NONE) {
                return;
            }
            PdfFragment pdfFragment2 = this.j;
            NavigationBackStack.NavigationItem<Integer> backItem = null;
            if ((pdfFragment2 != null ? pdfFragment2.getContentEditingState() : null) == null && (pdfFragment = this.j) != null) {
                NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> navigationHistory2 = pdfFragment.getNavigationHistory();
                if ((navigationHistory2 != null ? navigationHistory2.getForwardItem() : null) == null) {
                    PdfFragment pdfFragment3 = this.j;
                    if (pdfFragment3 != null && (navigationHistory = pdfFragment3.getNavigationHistory()) != null) {
                        backItem = navigationHistory.getBackItem();
                    }
                    if (backItem == null) {
                        return;
                    }
                }
                a(new Function0() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return dv.c(this.f$0, z);
                    }
                });
            }
        }
    }

    public static final Unit c(final dv dvVar, boolean z) {
        jv jvVar = (jv) dvVar.b;
        final View view = jvVar.e;
        if (view == null) {
            return Unit.INSTANCE;
        }
        final View view2 = jvVar.f;
        if (view2 == null) {
            return Unit.INSTANCE;
        }
        view.animate().cancel();
        view2.animate().cancel();
        view.animate().setDuration(z ? 250 : 0).setInterpolator(new DecelerateInterpolator(1.5f)).scaleX(1.0f).scaleY(1.0f).withStartAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda26
            @Override // java.lang.Runnable
            public final void run() {
                dv.c(this.f$0, view);
            }
        }).withEndAction(null);
        view2.animate().setDuration(z ? 250 : 0).setInterpolator(new DecelerateInterpolator(1.5f)).scaleX(1.0f).scaleY(1.0f).withStartAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                dv.d(this.f$0, view2);
            }
        }).withEndAction(null);
        dvVar.q();
        return Unit.INSTANCE;
    }

    public final boolean h() {
        if (this.E == null || f() || e()) {
            return false;
        }
        hn.c cVar = this.k;
        return cVar == null || cVar.g <= 0;
    }

    public static final void d(dv dvVar, View view) {
        NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> navigationHistory;
        PdfFragment pdfFragment = dvVar.j;
        if (((pdfFragment == null || (navigationHistory = pdfFragment.getNavigationHistory()) == null) ? null : navigationHistory.getForwardItem()) != null) {
            view.setVisibility(0);
        }
    }

    public static final void h(dv dvVar) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAlpha;
        ViewPropertyAnimator duration;
        TextView textView = ((jv) dvVar.b).b;
        if (textView == null || (viewPropertyAnimatorAnimate = textView.animate()) == null || (viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(0.0f)) == null || (duration = viewPropertyAnimatorAlpha.setDuration(dvVar.x)) == null) {
            return;
        }
        duration.setListener(null);
    }

    public final void d(boolean z) {
        final View view;
        jv jvVar = (jv) this.b;
        final View view2 = jvVar.e;
        if (view2 == null || (view = jvVar.f) == null) {
            return;
        }
        view2.animate().cancel();
        view.animate().cancel();
        view2.animate().setDuration(z ? 250 : 0).setInterpolator(new AccelerateInterpolator(1.4f)).scaleX(0.0f).scaleY(0.0f).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                dv.a(view2);
            }
        }).withStartAction(null);
        view.animate().setDuration(z ? 250 : 0).setInterpolator(new AccelerateInterpolator(1.4f)).scaleX(0.0f).scaleY(0.0f).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                dv.b(view);
            }
        }).withStartAction(null);
        q();
    }

    public final void k(final boolean z) {
        if (this.l && g()) {
            a(new Function0() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return dv.d(this.f$0, z);
                }
            });
        }
    }

    public final void d() {
        final RedactionView redactionView = ((jv) this.b).q;
        if (redactionView == null) {
            return;
        }
        final boolean z = true;
        a(new Function0() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return dv.a(redactionView, z);
            }
        });
    }

    public static final void c(dv dvVar, View view) {
        NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> navigationHistory;
        PdfFragment pdfFragment = dvVar.j;
        if (((pdfFragment == null || (navigationHistory = pdfFragment.getNavigationHistory()) == null) ? null : navigationHistory.getBackItem()) != null) {
            view.setVisibility(0);
        }
    }

    public final int c() {
        ContextualToolbar currentlyDisplayedContextualToolbar = this.c.getCurrentlyDisplayedContextualToolbar();
        if (!this.l && (currentlyDisplayedContextualToolbar == null || currentlyDisplayedContextualToolbar.getPosition() != ToolbarCoordinatorLayout.LayoutParams.Position.TOP || (this.e.isDefaultToolbarEnabled() && currentlyDisplayedContextualToolbar.isDraggable()))) {
            if (this.h.c) {
                return gk.b(this.a);
            }
            return 0;
        }
        return this.c.getToolbarInset();
    }

    public static final void c(dv dvVar) {
        dvVar.m();
        dvVar.a(true, dvVar.l, false);
    }

    public static final void b(dv dvVar) {
        dvVar.n();
    }

    public static final void b(PdfTabBar pdfTabBar) {
        pdfTabBar.setVisibility(0);
    }

    public static final void b(View view) {
        view.setVisibility(4);
    }

    public final int b(boolean z) {
        TextView documentTitleOverlayView;
        ContextualToolbar currentlyDisplayedContextualToolbar = this.c.getCurrentlyDisplayedContextualToolbar();
        boolean z2 = currentlyDisplayedContextualToolbar != null && currentlyDisplayedContextualToolbar.getPosition() == ToolbarCoordinatorLayout.LayoutParams.Position.TOP;
        PdfSearchView pdfSearchView = ((jv) this.b).u;
        int iC = (this.e.isDefaultToolbarEnabled() || z2 || (pdfSearchView != null && pdfSearchView.isShown() && this.e.getSearchType() == SearchType.INLINE)) ? c() : 0;
        boolean z3 = this.l;
        if (z3 && z3 && g()) {
            PdfTabBar pdfTabBar = ((jv) this.b).d;
            iC += pdfTabBar != null ? pdfTabBar.getHeight() : 0;
        }
        if (!z || !this.l || !t() || ((jv) this.b).getDocumentTitleOverlayView() == null || (documentTitleOverlayView = ((jv) this.b).getDocumentTitleOverlayView()) == null || documentTitleOverlayView.getVisibility() != 0) {
            return iC;
        }
        TextView documentTitleOverlayView2 = ((jv) this.b).getDocumentTitleOverlayView();
        return iC + (documentTitleOverlayView2 != null ? documentTitleOverlayView2.getHeight() : 0);
    }

    public static final void b(final dv dvVar, boolean z) {
        if (dvVar.q) {
            dvVar.o();
        }
        if (z) {
            dvVar.h(false);
            dvVar.g(true);
            fk fkVar = dvVar.h;
            if (fkVar.c) {
                MAMWindowManagement.clearFlags(fkVar.b.getWindow(), C.BUFFER_FLAG_FIRST_SAMPLE);
                return;
            }
            return;
        }
        if (!dvVar.f() && !dvVar.e()) {
            if (dvVar.l) {
                dvVar.a(true, new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda30
                    @Override // java.lang.Runnable
                    public final void run() {
                        dv.f(this.f$0);
                    }
                });
            } else {
                PdfFragment pdfFragment = dvVar.j;
                dvVar.g((pdfFragment != null ? pdfFragment.getContentEditingState() : null) != null);
                dvVar.h.b();
            }
            fk fkVar2 = dvVar.h;
            if (fkVar2.c) {
                if (uc.a(fkVar2.b, 540) || !uc.d(fkVar2.b)) {
                    fkVar2.b.getWindow().addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
                    return;
                }
                return;
            }
            return;
        }
        dvVar.g(true);
    }

    public static final void a(dv dvVar, View view) {
        NavigationBackStack<NavigationBackStack.NavigationItem<Integer>> navigationHistory;
        PdfFragment pdfFragment = dvVar.j;
        if (pdfFragment == null || (navigationHistory = pdfFragment.getNavigationHistory()) == null) {
            return;
        }
        navigationHistory.goForward();
    }

    public static final WindowInsetsCompat a(dv dvVar, View view, WindowInsetsCompat windowInsetsCompat) {
        view.getClass();
        windowInsetsCompat.getClass();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.getClass();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.rightMargin = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).right;
        if (dvVar.e.getThumbnailBarMode() == ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE) {
            marginLayoutParams.bottomMargin = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        }
        return windowInsetsCompat;
    }

    public static final WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
        view.getClass();
        windowInsetsCompat.getClass();
        view.setPadding(0, 0, 0, 0);
        return windowInsetsCompat;
    }

    public final void a(Function0<Unit> function0) {
        g60 g60VarC;
        if (this.z && Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
            return;
        }
        Single<Integer> singleFirstOrError = this.y.firstOrError();
        synchronized (ar.class) {
            g60VarC = q10.c();
        }
        singleFirstOrError.subscribeOn(((m0) g60VarC).a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(function0), e.a).getClass();
    }

    public final void a(boolean z, boolean z2, boolean z3) {
        boolean z4;
        PdfFragment pdfFragment;
        PdfFragment pdfFragment2;
        if (z || this.l != z2) {
            this.l = z2;
            this.B.isUiVisible(z2);
            a();
            if (this.e.isDefaultToolbarEnabled()) {
                z4 = z2;
                this.c.toggleMainToolbarVisibility(z4, 0L, z3 ? 250 : 0);
            } else {
                z4 = z2;
            }
            if (z4) {
                r();
                this.h.a();
            } else {
                View currentFocus = this.a.getCurrentFocus();
                if (currentFocus != null) {
                    hn.c(currentFocus);
                }
                this.h.b(false);
                n();
            }
            ArrayList arrayList = new ArrayList();
            if (z4) {
                j(z3);
            } else {
                d(z3);
            }
            AnimatorSet animatorSetA = a(z4);
            if (animatorSetA != null) {
                this.n = z4;
                arrayList.add(animatorSetA);
            }
            AnimatorSet animatorSetB = b();
            if (animatorSetB != null) {
                arrayList.add(animatorSetB);
            }
            if (u() && (pdfFragment = this.j) != null) {
                if (z4) {
                    int pageIndex = pdfFragment.getPageIndex();
                    int siblingPageIndex = -1;
                    if (pageIndex > -1 && (pdfFragment2 = this.j) != null) {
                        siblingPageIndex = pdfFragment2.getSiblingPageIndex(pageIndex);
                    }
                    a(pageIndex, siblingPageIndex, z3);
                } else {
                    TextView textView = ((jv) this.b).b;
                    if (textView != null) {
                        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "alpha", textView.getAlpha(), 0.0f);
                        objectAnimatorOfFloat.getClass();
                        arrayList.add(objectAnimatorOfFloat);
                    }
                }
            }
            if (z4) {
                i(z3);
            } else {
                c(z3);
            }
            if (z4) {
                k(z3);
            } else {
                e(z3);
            }
            cw cwVar = this.f;
            if (cwVar != null) {
                cwVar.onUserInterfaceVisibilityChanged(z4);
            }
            a(arrayList, z4, z3);
        }
    }

    public final void a(List<? extends Animator> list, boolean z, boolean z2) {
        TimeInterpolator accelerateInterpolator;
        if (list.isEmpty()) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        int i = 0;
        animatorSet.setDuration(z2 ? 250 : 0);
        if (z2 && !z) {
            i = 100;
        }
        animatorSet.setStartDelay(i);
        if (z) {
            accelerateInterpolator = new DecelerateInterpolator(1.5f);
        } else {
            accelerateInterpolator = new AccelerateInterpolator(1.5f);
        }
        animatorSet.setInterpolator(accelerateInterpolator);
        animatorSet.playTogether(list);
        if (z) {
            animatorSet.addListener(new h());
        }
        animatorSet.start();
        this.w = animatorSet;
    }

    public final AnimatorSet a(boolean z) {
        PdfThumbnailBar pdfThumbnailBar;
        if (z && !h()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.E != null && this.e.getThumbnailBarMode() != ThumbnailBarMode.THUMBNAIL_BAR_MODE_NONE && (pdfThumbnailBar = this.E) != null) {
            if (z) {
                pdfThumbnailBar.setVisibility(0);
                this.E.setAlpha(1.0f);
                PdfThumbnailBar pdfThumbnailBar2 = this.E;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(pdfThumbnailBar2, "translationY", pdfThumbnailBar2.getTranslationY(), 0.0f);
                objectAnimatorOfFloat.getClass();
                arrayList.add(objectAnimatorOfFloat);
            } else {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(pdfThumbnailBar, "translationY", 0.0f, pdfThumbnailBar.getHeight());
                objectAnimatorOfFloat2.addListener(new fv(this));
                arrayList.add(objectAnimatorOfFloat2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }

    public final void a(boolean z, final Runnable runnable) {
        PdfThumbnailBar pdfThumbnailBar = this.E;
        if (pdfThumbnailBar == null) {
            return;
        }
        if (z) {
            if (!h() || i()) {
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            }
            h(true);
            pdfThumbnailBar.setAlpha(0.0f);
            pdfThumbnailBar.animate().alpha(1.0f);
            if (runnable != null) {
                pdfThumbnailBar.getViewTreeObserver().addOnGlobalLayoutListener(new y70(pdfThumbnailBar, new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda20
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        dv.a(runnable);
                    }
                }));
                return;
            }
            return;
        }
        pdfThumbnailBar.animate().alpha(0.0f).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                dv.a(this.f$0, runnable);
            }
        });
    }

    public static final void a(Runnable runnable) {
        runnable.run();
    }

    public static final void a(dv dvVar, Runnable runnable) {
        dvVar.h(false);
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void a() {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator viewPropertyAnimatorAnimate2;
        ViewPropertyAnimator viewPropertyAnimatorAnimate3;
        ViewPropertyAnimator viewPropertyAnimatorAnimate4;
        ViewPropertyAnimator viewPropertyAnimatorAnimate5;
        TextView textView = ((jv) this.b).b;
        if (textView != null && (viewPropertyAnimatorAnimate5 = textView.animate()) != null) {
            viewPropertyAnimatorAnimate5.cancel();
        }
        View view = ((jv) this.b).e;
        if (view != null && (viewPropertyAnimatorAnimate4 = view.animate()) != null) {
            viewPropertyAnimatorAnimate4.cancel();
        }
        View view2 = ((jv) this.b).f;
        if (view2 != null && (viewPropertyAnimatorAnimate3 = view2.animate()) != null) {
            viewPropertyAnimatorAnimate3.cancel();
        }
        TextView documentTitleOverlayView = ((jv) this.b).getDocumentTitleOverlayView();
        if (documentTitleOverlayView != null && (viewPropertyAnimatorAnimate2 = documentTitleOverlayView.animate()) != null) {
            viewPropertyAnimatorAnimate2.cancel();
        }
        PdfTabBar pdfTabBar = ((jv) this.b).d;
        if (pdfTabBar != null && (viewPropertyAnimatorAnimate = pdfTabBar.animate()) != null) {
            viewPropertyAnimatorAnimate.cancel();
        }
        AnimatorSet animatorSet = this.w;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.w = null;
    }

    public final void a(int i, int i2, boolean z) {
        final dv dvVar;
        TextView textView;
        if (u()) {
            PdfFragment pdfFragment = this.j;
            if (pdfFragment == null || pdfFragment.getDocument() == null || i < 0 || !u() || (textView = ((jv) this.b).b) == null) {
                dvVar = this;
            } else {
                boolean z2 = i2 != -1;
                PdfDocument document = pdfFragment.getDocument();
                document.getClass();
                lm lmVar = (lm) document;
                dvVar = this;
                iv ivVar = new iv(lmVar, i, dvVar, textView, i2, z2, null);
                PageRenderConfiguration pageRenderConfiguration = lm.Q;
                lmVar.a(EmptyCoroutineContext.INSTANCE, ivVar);
            }
            TextView textView2 = ((jv) dvVar.b).b;
            if (textView2 == null) {
                return;
            }
            textView2.animate().cancel();
            textView2.animate().alpha(1.0f).setStartDelay(0L).setDuration(z ? dvVar.x : 0L);
            yz.a(dvVar.F);
            dvVar.F = null;
            dvVar.F = Completable.timer(1500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda29
                @Override // io.reactivex.rxjava3.functions.Action
                public final void run() {
                    dv.h(this.f$0);
                }
            });
        }
    }

    public static final void a(dv dvVar, TextView textView, int i, int i2, boolean z, String str, int i3) {
        View view;
        if (str != null && dvVar.e.isShowPageLabels() && !z) {
            int i4 = i + 1;
            boolean zAreEqual = Intrinsics.areEqual(String.valueOf(i4), str);
            AppCompatActivity appCompatActivity = dvVar.a;
            if (zAreEqual) {
                textView.setText(no.a(appCompatActivity, R.string.pspdf__page_overlay, textView, Integer.valueOf(i4), Integer.valueOf(i3)));
            } else {
                textView.setText(no.a(appCompatActivity, R.string.pspdf__page_overlay_with_label, textView, str, Integer.valueOf(i4), Integer.valueOf(i3)));
            }
        } else if (!z) {
            textView.setText(no.a(dvVar.a, R.string.pspdf__page_overlay, textView, Integer.valueOf(i + 1), Integer.valueOf(i3)));
        } else {
            int iMin = Math.min(i, i2);
            textView.setText(no.a(dvVar.a, R.string.pspdf__page_overlay_double_page, textView, Integer.valueOf(iMin + 1), Integer.valueOf(iMin + 2), Integer.valueOf(i3)));
        }
        PdfFragment pdfFragment = dvVar.j;
        if (pdfFragment == null || (view = pdfFragment.getView()) == null) {
            return;
        }
        view.announceForAccessibility(no.a(dvVar.a, R.string.pspdf__page_with_number, (View) null, Integer.valueOf(i + 1)));
    }

    public static final Unit a(TextView textView, boolean z, final dv dvVar) {
        textView.setVisibility(0);
        textView.animate().cancel();
        textView.animate().setDuration(z ? 250 : 0).setInterpolator(new DecelerateInterpolator(1.5f)).alpha(1.0f).translationY(dvVar.b(false)).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda28
            @Override // java.lang.Runnable
            public final void run() {
                dv.g(this.f$0);
            }
        }).start();
        return Unit.INSTANCE;
    }

    public static final void a(TextView textView) {
        textView.setVisibility(8);
    }

    public static final void a(PdfTabBar pdfTabBar) {
        pdfTabBar.setVisibility(8);
    }

    public static final void a(View view) {
        view.setVisibility(4);
    }

    public static final Unit a(dv dvVar, final PdfFragment pdfFragment, final boolean z) {
        final RedactionView redactionView = ((jv) dvVar.b).q;
        if (redactionView == null) {
            return Unit.INSTANCE;
        }
        redactionView.animate().translationY(0.0f).withEndAction(new Runnable() { // from class: com.pspdfkit.internal.dv$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                dv.a(redactionView, pdfFragment, z);
            }
        });
        return Unit.INSTANCE;
    }

    public static final void a(RedactionView redactionView, PdfFragment pdfFragment, boolean z) {
        redactionView.setRedactionAnnotationPreviewEnabled(pdfFragment.isRedactionAnnotationPreviewEnabled());
        redactionView.lambda$setRedactionButtonVisible$5(true, z);
    }

    public static final Unit a(RedactionView redactionView, boolean z) {
        redactionView.clearAnimation();
        redactionView.animate().cancel();
        redactionView.lambda$setRedactionButtonVisible$5(false, z);
        return Unit.INSTANCE;
    }

    public static final void a(dv dvVar, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i4 - i2;
        if (i8 - i6 != i9) {
            dvVar.E.setTranslationY((dvVar.i() || dvVar.f() || dvVar.e()) ? 0.0f : i9);
            dvVar.f(dvVar.i() || dvVar.f() || dvVar.e());
        }
    }
}
