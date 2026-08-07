package sdk.pendo.io.x6;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.viewpager.widget.ViewPager;
import androidx.window.core.layout.WindowSizeClass;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.x;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u008a\u0001B\u001f\u0012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001\u0012\n\b\u0002\u0010\u0086\u0001\u001a\u00030\u0085\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\n\u001a\u00020\u00022\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0004H\u0002J\u0013\u0010\u000b\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002JZ\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002Jb\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J#\u0010%\u001a\n $*\u0004\u0018\u00010#0#2\u0006\u0010\u0018\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020\rH\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J(\u0010-\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0007H\u0002J\u001b\u0010/\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0090@ø\u0001\u0000¢\u0006\u0004\b.\u0010&J\u0013\u00100\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b0\u0010\fJ\u000f\u00103\u001a\u00020\u0002H\u0010¢\u0006\u0004\b1\u00102J\u0013\u00105\u001a\u00020\u0002H\u0090@ø\u0001\u0000¢\u0006\u0004\b4\u0010\fJ\u0013\u00106\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b6\u0010\fJ\u0013\u00108\u001a\u00020\u0005H\u0090@ø\u0001\u0000¢\u0006\u0004\b7\u0010\fJ#\u0010>\u001a\u00020;2\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\rH\u0090@ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0012\u0010A\u001a\u00020\u00022\b\u0010@\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010D\u001a\u00020\u00022\u0006\u0010C\u001a\u00020BH\u0016J\u0016\u0010G\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\rJ\b\u0010H\u001a\u00020\u0002H\u0017J\b\u0010I\u001a\u00020\u0002H\u0014J\b\u0010J\u001a\u00020\u0002H\u0014J\u0013\u0010K\u001a\u00020\u0002H\u0097@ø\u0001\u0000¢\u0006\u0004\bK\u0010\fJ\b\u0010L\u001a\u00020\u0002H\u0014J\u0013\u0010M\u001a\u00020\u0002H\u0094@ø\u0001\u0000¢\u0006\u0004\bM\u0010\fJ#\u0010N\u001a\n $*\u0004\u0018\u00010#0#2\u0006\u0010\u0018\u001a\u00020\u0017H\u0087@ø\u0001\u0000¢\u0006\u0004\bN\u0010&J!\u0010S\u001a\u0004\u0018\u00010P2\u0006\u0010O\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\bQ\u0010RJ\u000f\u0010V\u001a\u00020\rH\u0010¢\u0006\u0004\bT\u0010UJ\u001f\u0010[\u001a\u00020\u00022\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020P\u0018\u00010WH\u0010¢\u0006\u0004\bY\u0010ZJ\b\u0010\\\u001a\u00020\rH\u0017R$\u0010^\u001a\u0004\u0018\u00010]8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u001e\u0010k\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010n\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u001e\u0010p\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010lR\u0018\u0010q\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010oR\u0016\u0010r\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010sR\"\u0010\u0011\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xRV\u0010y\u001a>\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0012j\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b`\u00158\u0000X\u0080\u0004¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R>\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014`\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010z\u001a\u0004\b}\u0010|\"\u0004\b~\u0010\u007fR\u001a\u0010\u0081\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008b\u0001"}, d2 = {"Lsdk/pendo/io/x6/e;", "Lsdk/pendo/io/x6/i;", "", "onScrollChangeEvent", "", "", "Ljava/util/ArrayList;", "Lsdk/pendo/io/x6/h$c;", "Lkotlin/collections/ArrayList;", "newSpecialViewsMap", "populateSpecialViewsMap", "onDialogAppear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isDialogOnScreen", "isPanelOnScreen", "Lsdk/pendo/io/x6/b;", "fragmentHelper", "Ljava/util/HashMap;", "", "Lsdk/pendo/io/x6/c;", "Lkotlin/collections/HashMap;", "fragmentsInfoMap", "Landroid/app/Activity;", "activity", "Lsdk/pendo/io/s7/e1$a;", "rootViewData", "currentScreenId", "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "drawerListener", "calculateNativeViewScreenId", "fragmentsInfoHashMap", "isOldScreenIdFormat", "calculateOldNativeViewScreenId", "initScrollChangeListener", "Landroid/view/ViewTreeObserver;", "kotlin.jvm.PlatformType", "unregisterScreenContentChangeListeners", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifySpecialViewsAndTextsToIdentifyNewScreen", "loopViewsForChanges", "type", "count", "selectedIndex", "specialViewItem", "handleChangesInSpecialView", "onActivityResumedInternal$pendoIO_release", "onActivityResumedInternal", "clearInternal", "cancelScreenManagerCoroutineJobs$pendoIO_release", "()V", "cancelScreenManagerCoroutineJobs", "handleNewScreenIdentified$pendoIO_release", "handleNewScreenIdentified", "handleSameScreenIdentified", "calculateScreenId$pendoIO_release", "calculateScreenId", "includeText", "isForCapture", "Lorg/json/JSONObject;", "getScreenData$pendoIO_release", "(ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getScreenData", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "response", "onGetAccessTokenResponseReceived", "Lsdk/pendo/io/x6/g;", "triggerEvent", "onGlobalLayoutChangeEvent", "isDialogType", "isPopupWindowType", "getDialogAndPanelForScreenId", "initGlobalLayoutChangeListener", "initWindowFocusChangeListener", "initGlobalLayoutChangeFlow", "handleGlobalLayoutChangeEvent", "initScrollChangeFlow", "handleScrollChangeEvent", "registerScreenContentChangeListeners", "item", "Landroid/view/View;", "fetchView$pendoIO_release", "(Lsdk/pendo/io/x6/h$c;Landroid/app/Activity;)Landroid/view/View;", "fetchView", "shouldHandleGlobalLayoutChanges$pendoIO_release", "()Z", "shouldHandleGlobalLayoutChanges", "Ljava/lang/ref/WeakReference;", "rootViewWeakReference", "setFocusListener$pendoIO_release", "(Ljava/lang/ref/WeakReference;)V", "setFocusListener", "shouldCollectDynamicChanges", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayoutChangeListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "getOnGlobalLayoutChangeListener$pendoIO_release", "()Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "setOnGlobalLayoutChangeListener$pendoIO_release", "(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "onScrollChangeListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "onWindowFocusChangeListener", "Landroid/view/ViewTreeObserver$OnWindowFocusChangeListener;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "globalLayoutChangeEventsFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/Job;", "globalLayoutChangeEventsCollectionJob", "Lkotlinx/coroutines/Job;", "scrollChangeEventsFlow", "scrollChangeEventsCollectionJob", "shouldHandleViewPagerChanges", "Z", "Lsdk/pendo/io/x6/b;", "getFragmentHelper$pendoIO_release", "()Lsdk/pendo/io/x6/b;", "setFragmentHelper$pendoIO_release", "(Lsdk/pendo/io/x6/b;)V", "specialViewsMap", "Ljava/util/HashMap;", "getSpecialViewsMap$pendoIO_release", "()Ljava/util/HashMap;", "getFragmentsInfoHashMap$pendoIO_release", "setFragmentsInfoHashMap$pendoIO_release", "(Ljava/util/HashMap;)V", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "viewPagerOnPageChangeListener", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "Lsdk/pendo/io/s7/m;", "dispatcherProvider", "<init>", "(Lsdk/pendo/io/Pendo$PendoOptions;Lsdk/pendo/io/s7/m;)V", "Companion", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public class e extends sdk.pendo.io.x6.i {
    public static final long GLOBAL_LAYOUT_CHANGE_TIMEOUT = 300;
    public static final long SCROLL_CHANGE_EVENTS_TIMEOUT = 100;
    private static final String TAG = "NativeScreenManager";
    private sdk.pendo.io.x6.b fragmentHelper;
    private HashMap<Integer, sdk.pendo.io.x6.c> fragmentsInfoHashMap;
    private Job globalLayoutChangeEventsCollectionJob;
    private MutableSharedFlow<sdk.pendo.io.x6.g> globalLayoutChangeEventsFlow;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutChangeListener;
    private ViewTreeObserver.OnScrollChangedListener onScrollChangeListener;
    private ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener;
    private Job scrollChangeEventsCollectionJob;
    private MutableSharedFlow<Unit> scrollChangeEventsFlow;
    private boolean shouldHandleViewPagerChanges;
    private final HashMap<String, ArrayList<sdk.pendo.io.x6.h.c>> specialViewsMap;
    private ViewPager.OnPageChangeListener viewPagerOnPageChangeListener;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager", f = "NativeScreenManager.kt", i = {0}, l = {Token.GENEXPR}, m = "calculateScreenId$suspendImpl", n = {"$this"}, s = {"L$0"})
    static final class b extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return e.calculateScreenId$suspendImpl(e.this, this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager", f = "NativeScreenManager.kt", i = {0}, l = {118, 121}, m = "clearInternal$suspendImpl", n = {"$this"}, s = {"L$0"})
    static final class c extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return e.clearInternal$suspendImpl(e.this, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager", f = "NativeScreenManager.kt", i = {0}, l = {206}, m = "getScreenData$suspendImpl", n = {"$this"}, s = {"L$0"})
    static final class d extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return e.getScreenData$suspendImpl(e.this, false, false, this);
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.x6.e$e, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager", f = "NativeScreenManager.kt", i = {0}, l = {135, Token.SCRIPT}, m = "handleNewScreenIdentified$suspendImpl", n = {"$this"}, s = {"L$0"})
    static final class C0521e extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        int d;

        C0521e(Continuation<? super C0521e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return e.handleNewScreenIdentified$suspendImpl(e.this, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager", f = "NativeScreenManager.kt", i = {0, 0}, l = {Token.TO_DOUBLE, Token.ARRAYCOMP}, m = "handleSameScreenIdentified$suspendImpl", n = {"$this", "handleAsScreenChange"}, s = {"L$0", "Z$0"})
    static final class f extends ContinuationImpl {
        Object a;
        Object b;
        boolean c;
        /* synthetic */ Object d;
        int f;

        f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return e.handleSameScreenIdentified$suspendImpl(e.this, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$initGlobalLayoutChangeFlow$1", f = "NativeScreenManager.kt", i = {}, l = {437}, m = "invokeSuspend", n = {}, s = {})
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lsdk/pendo/io/x6/g;", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/x6/g;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
        static final class a<T> implements FlowCollector {
            final /* synthetic */ e a;

            /* JADX INFO: renamed from: sdk.pendo.io.x6.e$g$a$a, reason: collision with other inner class name */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$initGlobalLayoutChangeFlow$1$2", f = "NativeScreenManager.kt", i = {0}, l = {444}, m = "emit", n = {"it"}, s = {"L$0"})
            static final class C0522a extends ContinuationImpl {
                Object a;
                /* synthetic */ Object b;
                final /* synthetic */ a<T> c;
                int d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0522a(a<? super T> aVar, Continuation<? super C0522a> continuation) {
                    super(continuation);
                    this.c = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.b = obj;
                    this.d |= Integer.MIN_VALUE;
                    return this.c.emit(null, this);
                }
            }

            a(e eVar) {
                this.a = eVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(sdk.pendo.io.x6.g gVar, Continuation<? super Unit> continuation) {
                C0522a c0522a;
                if (continuation instanceof C0522a) {
                    c0522a = (C0522a) continuation;
                    int i = c0522a.d;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        c0522a.d = i - Integer.MIN_VALUE;
                    } else {
                        c0522a = new C0522a(this, continuation);
                    }
                } else {
                    c0522a = new C0522a(this, continuation);
                }
                Object obj = c0522a.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = c0522a.d;
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        PendoLogger.d(e.TAG, "globalLayoutChangeEventsFlow COLLECT " + gVar + ", after " + this.a.getScreenManagerPolicy().getGlobalLayoutChangeEventsDebouncer() + " debounce and 300 timeout ms ");
                        if (this.a.shouldHandleGlobalLayoutChanges$pendoIO_release()) {
                            e eVar = this.a;
                            c0522a.a = gVar;
                            c0522a.d = 1;
                            if (eVar.handleGlobalLayoutChangeEvent(c0522a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        gVar = (sdk.pendo.io.x6.g) c0522a.a;
                        ResultKt.throwOnFailure(obj);
                    }
                } catch (CancellationException e) {
                    throw e;
                } catch (Throwable th) {
                    PendoLogger.e(e.TAG, "globalLayoutChangeEventsFlow COLLECT " + gVar + ", error - " + th);
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 9, 0})
        public static final class b implements Flow<sdk.pendo.io.x6.g> {
            final /* synthetic */ Flow a;
            final /* synthetic */ e b;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class a<T> implements FlowCollector {
                final /* synthetic */ FlowCollector a;
                final /* synthetic */ e b;

                /* JADX INFO: renamed from: sdk.pendo.io.x6.e$g$b$a$a, reason: collision with other inner class name */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$initGlobalLayoutChangeFlow$1$invokeSuspend$$inlined$filter$1$2", f = "NativeScreenManager.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class C0523a extends ContinuationImpl {
                    /* synthetic */ Object a;
                    int b;

                    public C0523a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= Integer.MIN_VALUE;
                        return a.this.emit(null, this);
                    }
                }

                public a(FlowCollector flowCollector, e eVar) {
                    this.a = flowCollector;
                    this.b = eVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    C0523a c0523a;
                    if (continuation instanceof C0523a) {
                        c0523a = (C0523a) continuation;
                        int i = c0523a.b;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            c0523a.b = i - Integer.MIN_VALUE;
                        } else {
                            c0523a = new C0523a(continuation);
                        }
                    } else {
                        c0523a = new C0523a(continuation);
                    }
                    Object obj2 = c0523a.a;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = c0523a.b;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.a;
                        if (this.b.shouldListenToAppChanges$pendoIO_release()) {
                            c0523a.b = 1;
                            if (flowCollector.emit(obj, c0523a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public b(Flow flow, e eVar) {
                this.a = flow;
                this.b = eVar;
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super sdk.pendo.io.x6.g> flowCollector, Continuation continuation) {
                Object objCollect = this.a.collect(new a(flowCollector, this.b), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }

        g(Continuation<? super g> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new g(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Flow flowA;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = e.this.globalLayoutChangeEventsFlow;
                if (mutableSharedFlow != null && (flowA = x.a(mutableSharedFlow, e.this.getScreenManagerPolicy().getGlobalLayoutChangeEventsDebouncer(), 300L)) != null) {
                    b bVar = new b(flowA, e.this);
                    a aVar = new a(e.this);
                    this.a = 1;
                    if (bVar.collect(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$initScrollChangeFlow$1", f = "NativeScreenManager.kt", i = {}, l = {WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;

        @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "it", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0})
        static final class a<T> implements FlowCollector {
            final /* synthetic */ e a;

            /* JADX INFO: renamed from: sdk.pendo.io.x6.e$h$a$a, reason: collision with other inner class name */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$initScrollChangeFlow$1$2", f = "NativeScreenManager.kt", i = {}, l = {486}, m = "emit", n = {}, s = {})
            static final class C0524a extends ContinuationImpl {
                /* synthetic */ Object a;
                final /* synthetic */ a<T> b;
                int c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0524a(a<? super T> aVar, Continuation<? super C0524a> continuation) {
                    super(continuation);
                    this.b = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.c |= Integer.MIN_VALUE;
                    return this.b.emit(null, this);
                }
            }

            a(e eVar) {
                this.a = eVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                C0524a c0524a;
                if (continuation instanceof C0524a) {
                    c0524a = (C0524a) continuation;
                    int i = c0524a.c;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        c0524a.c = i - Integer.MIN_VALUE;
                    } else {
                        c0524a = new C0524a(this, continuation);
                    }
                } else {
                    c0524a = new C0524a(this, continuation);
                }
                Object obj = c0524a.a;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = c0524a.c;
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        PendoLogger.d(e.TAG, "scrollChangeEventsFlow COLLECT after 100 debounce ms");
                        e eVar = this.a;
                        c0524a.c = 1;
                        if (eVar.handleScrollChangeEvent(c0524a) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                } catch (CancellationException e) {
                    throw e;
                } catch (Throwable th) {
                    PendoLogger.e(e.TAG, "scrollChangeEventsFlow COLLECT error - " + th);
                }
                return Unit.INSTANCE;
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 9, 0})
        public static final class b implements Flow<Unit> {
            final /* synthetic */ Flow a;
            final /* synthetic */ e b;

            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class a<T> implements FlowCollector {
                final /* synthetic */ FlowCollector a;
                final /* synthetic */ e b;

                /* JADX INFO: renamed from: sdk.pendo.io.x6.e$h$b$a$a, reason: collision with other inner class name */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$initScrollChangeFlow$1$invokeSuspend$$inlined$filter$1$2", f = "NativeScreenManager.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class C0525a extends ContinuationImpl {
                    /* synthetic */ Object a;
                    int b;

                    public C0525a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.a = obj;
                        this.b |= Integer.MIN_VALUE;
                        return a.this.emit(null, this);
                    }
                }

                public a(FlowCollector flowCollector, e eVar) {
                    this.a = flowCollector;
                    this.b = eVar;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    C0525a c0525a;
                    if (continuation instanceof C0525a) {
                        c0525a = (C0525a) continuation;
                        int i = c0525a.b;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            c0525a.b = i - Integer.MIN_VALUE;
                        } else {
                            c0525a = new C0525a(continuation);
                        }
                    } else {
                        c0525a = new C0525a(continuation);
                    }
                    Object obj2 = c0525a.a;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = c0525a.b;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.a;
                        if (this.b.shouldListenToAppChanges$pendoIO_release()) {
                            c0525a.b = 1;
                            if (flowCollector.emit(obj, c0525a) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            public b(Flow flow, e eVar) {
                this.a = flow;
                this.b = eVar;
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Unit> flowCollector, Continuation continuation) {
                Object objCollect = this.a.collect(new a(flowCollector, this.b), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }

        h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new h(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Flow flowDebounce;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = e.this.scrollChangeEventsFlow;
                if (mutableSharedFlow != null && (flowDebounce = FlowKt.debounce(mutableSharedFlow, 100L)) != null) {
                    b bVar = new b(flowDebounce, e.this);
                    a aVar = new a(e.this);
                    this.a = 1;
                    if (bVar.collect(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager", f = "NativeScreenManager.kt", i = {0, 0}, l = {112, 113}, m = "onActivityResumedInternal$suspendImpl", n = {"$this", "activity"}, s = {"L$0", "L$1"})
    static final class i extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int e;

        i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return e.onActivityResumedInternal$suspendImpl(e.this, (Activity) null, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$onDialogAppear$2", f = "NativeScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        private /* synthetic */ Object b;

        j(Continuation<? super j> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            j jVar = e.this.new j(continuation);
            jVar.b = obj;
            return jVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            WeakReference<View> weakReference;
            View view;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            e1.a currentRootViewData = e.this.getCurrentRootViewData();
            if (currentRootViewData == null || (weakReference = currentRootViewData.a) == null || (view = weakReference.get()) == null) {
                unit = null;
            } else {
                e eVar = e.this;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (eVar.getOnGlobalLayoutChangeListener() != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(eVar.getOnGlobalLayoutChangeListener());
                    viewTreeObserver.addOnGlobalLayoutListener(eVar.getOnGlobalLayoutChangeListener());
                }
                if (eVar.onScrollChangeListener != null) {
                    viewTreeObserver.removeOnScrollChangedListener(eVar.onScrollChangeListener);
                    viewTreeObserver.addOnScrollChangedListener(eVar.onScrollChangeListener);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                PendoLogger.w("Screen Manager onDialogAppear -> current root view is null", new Object[0]);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$onGetAccessTokenResponseReceived$1", f = "NativeScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ GetAuthToken.GetAuthTokenResponse b;
        final /* synthetic */ e c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse, e eVar, Continuation<? super k> continuation) {
            super(2, continuation);
            this.b = getAuthTokenResponse;
            this.c = eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new k(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            GetAuthToken.GetAuthTokenResponse getAuthTokenResponse = this.b;
            if (getAuthTokenResponse != null) {
                this.c.getScreenManagerPolicy().a(getAuthTokenResponse.getUseModifiedScreenDataForNativeTransientUIComponent());
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/ViewTreeObserver;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$registerScreenContentChangeListeners$2", f = "NativeScreenManager.kt", i = {}, l = {512}, m = "invokeSuspend", n = {}, s = {})
    static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ViewTreeObserver>, Object> {
        int a;
        final /* synthetic */ Activity c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(Activity activity, Continuation<? super l> continuation) {
            super(2, continuation);
            this.c = activity;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ViewTreeObserver> continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new l(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                e eVar = e.this;
                Activity activity = this.c;
                this.a = 1;
                if (eVar.unregisterScreenContentChangeListeners(activity, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ViewTreeObserver viewTreeObserver = this.c.getWindow().getDecorView().getViewTreeObserver();
            e eVar2 = e.this;
            if (eVar2.getOnGlobalLayoutChangeListener() != null) {
                PendoLogger.d(e.TAG, "registerScreenContentChangeListeners -> addOnGlobalLayoutListener");
                viewTreeObserver.addOnGlobalLayoutListener(eVar2.getOnGlobalLayoutChangeListener());
            }
            if (eVar2.onScrollChangeListener != null) {
                PendoLogger.d(e.TAG, "registerScreenContentChangeListeners -> addOnScrollChangedListener");
                viewTreeObserver.addOnScrollChangedListener(eVar2.onScrollChangeListener);
            }
            if (eVar2.onWindowFocusChangeListener != null) {
                PendoLogger.d(e.TAG, "registerScreenContentChangeListeners -> addOnWindowFocusChangeListener");
                viewTreeObserver.addOnWindowFocusChangeListener(eVar2.onWindowFocusChangeListener);
            }
            return viewTreeObserver;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$setFocusListener$1$1", f = "NativeScreenManager.kt", i = {}, l = {714}, m = "invokeSuspend", n = {}, s = {})
    static final class m extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ View c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(View view, Continuation<? super m> continuation) {
            super(2, continuation);
            this.c = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new m(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                a focusHandler = e.this.getFocusHandler();
                if (focusHandler != null) {
                    ViewTreeObserver viewTreeObserver = ((ViewGroup) this.c).getViewTreeObserver();
                    Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "getViewTreeObserver(...)");
                    WeakReference<ViewGroup> weakReference = new WeakReference<>(this.c);
                    this.a = 1;
                    if (focusHandler.a(viewTreeObserver, weakReference, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/view/ViewTreeObserver;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.NativeScreenManager$unregisterScreenContentChangeListeners$2", f = "NativeScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class n extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ViewTreeObserver>, Object> {
        int a;
        final /* synthetic */ Activity b;
        final /* synthetic */ e c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(Activity activity, e eVar, Continuation<? super n> continuation) {
            super(2, continuation);
            this.b = activity;
            this.c = eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ViewTreeObserver> continuation) {
            return ((n) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new n(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ViewTreeObserver viewTreeObserver = this.b.getWindow().getDecorView().getViewTreeObserver();
            e eVar = this.c;
            if (eVar.getOnGlobalLayoutChangeListener() != null) {
                PendoLogger.d(e.TAG, "unregisterScreenContentChangeListeners -> removeOnGlobalLayoutListener");
                viewTreeObserver.removeOnGlobalLayoutListener(eVar.getOnGlobalLayoutChangeListener());
            }
            if (eVar.onScrollChangeListener != null) {
                PendoLogger.d(e.TAG, "unregisterScreenContentChangeListeners -> removeOnScrollChangedListener");
                viewTreeObserver.removeOnScrollChangedListener(eVar.onScrollChangeListener);
            }
            if (eVar.onWindowFocusChangeListener != null) {
                PendoLogger.d(e.TAG, "unregisterScreenContentChangeListeners -> removeOnWindowFocusChangeListener");
                viewTreeObserver.removeOnWindowFocusChangeListener(eVar.onWindowFocusChangeListener);
            }
            return viewTreeObserver;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"sdk/pendo/io/x6/e$o", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", ViewProps.POSITION, "", "positionOffset", "positionOffsetPixels", "", "onPageScrolled", "onPageSelected", "state", "onPageScrollStateChanged", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class o implements ViewPager.OnPageChangeListener {
        o() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            e.this.shouldHandleViewPagerChanges = state == 0;
            if (e.this.shouldHandleViewPagerChanges) {
                e.this.onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g.ON_VIEW_PAGER_SCROLL_STATE_CHANGED);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            if (e.this.getSpecialViewsMap$pendoIO_release().containsKey("TabLayout") || e.this.getSpecialViewsMap$pendoIO_release().containsKey("BottomNavigationView")) {
                e.this.onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g.ON_VIEW_PAGER_PAGE_SELECTED);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Pendo.PendoOptions pendoOptions, sdk.pendo.io.s7.m dispatcherProvider) {
        super(pendoOptions, dispatcherProvider);
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        Intrinsics.checkNotNullParameter(dispatcherProvider, "dispatcherProvider");
        this.shouldHandleViewPagerChanges = true;
        this.fragmentHelper = new sdk.pendo.io.x6.b();
        this.specialViewsMap = new HashMap<>();
        this.fragmentsInfoHashMap = new HashMap<>();
        this.viewPagerOnPageChangeListener = new o();
    }

    private final String calculateNativeViewScreenId(sdk.pendo.io.x6.b fragmentHelper, HashMap<Integer, sdk.pendo.io.x6.c> fragmentsInfoMap, Activity activity, e1.a rootViewData, String currentScreenId, PendoDrawerListener drawerListener) {
        if (drawerListener != null && drawerListener.isDrawerOpenedAndRelatesToCurrentScreen(activity)) {
            return sdk.pendo.io.x6.i.DRAWER_ID;
        }
        if (rootViewData != null) {
            if (rootViewData.g()) {
                return sdk.pendo.io.x6.i.DIALOG_ID;
            }
            if (rootViewData.i()) {
                return sdk.pendo.io.x6.i.PANEL_ID;
            }
        }
        if (activity == null) {
            PendoLogger.w("ScreenIdGenerator.calculateNativeViewScreenId -> activity is null", new Object[0]);
            return currentScreenId;
        }
        StringBuilder sb = new StringBuilder("");
        sb.append(activity.getClass().getSimpleName());
        sb.append(sdk.pendo.io.x6.b.a(fragmentHelper, fragmentsInfoMap, false, 2, null));
        sdk.pendo.io.x6.i.INSTANCE.a().replace(sb, "");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    private final String calculateOldNativeViewScreenId(sdk.pendo.io.x6.b fragmentHelper, HashMap<Integer, sdk.pendo.io.x6.c> fragmentsInfoHashMap, Activity activity, e1.a rootViewData, boolean isOldScreenIdFormat, String currentScreenId, PendoDrawerListener drawerListener) {
        StringBuilder sbAppend;
        if (drawerListener != null && drawerListener.isDrawerOpenedAndRelatesToCurrentScreen(activity)) {
            return sdk.pendo.io.x6.i.DRAWER_ID;
        }
        StringBuilder sb = new StringBuilder("");
        if (activity != null) {
            sb.append(activity.getClass().getSimpleName());
            sbAppend = sb.append(fragmentHelper.b(fragmentsInfoHashMap, isOldScreenIdFormat));
        } else {
            sbAppend = null;
        }
        if (sbAppend == null) {
            PendoLogger.w("ScreenIdGenerator.calculateOldNativeViewScreenId -> activity is null", new Object[0]);
            return currentScreenId;
        }
        if ((rootViewData != null ? sb.append(getDialogAndPanelForScreenId(rootViewData.g(), rootViewData.i())) : null) == null) {
            PendoLogger.w("ScreenManagerHelper.calculateNativeScreenId -> root view is null", new Object[0]);
        }
        return sdk.pendo.io.x6.i.INSTANCE.a().replace(sb, "");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    static /* synthetic */ Object calculateScreenId$suspendImpl(e eVar, Continuation<? super String> continuation) {
        b bVar;
        Unit unit;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i2 = bVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bVar.d = i2 - Integer.MIN_VALUE;
            } else {
                bVar = eVar.new b(continuation);
            }
        } else {
            bVar = eVar.new b(continuation);
        }
        Object objA = bVar.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = bVar.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objA);
            sdk.pendo.io.x6.b bVar2 = eVar.fragmentHelper;
            Activity activity = eVar.getCurrentActivityRef$pendoIO_release().get();
            boolean ignoreDynamicFragmentsInScrollView = eVar.getScreenManagerPolicy().getIgnoreDynamicFragmentsInScrollView();
            bVar.a = eVar;
            bVar.d = 1;
            objA = bVar2.a(activity, ignoreDynamicFragmentsInScrollView, bVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar = (e) bVar.a;
            ResultKt.throwOnFailure(objA);
        }
        e eVar2 = eVar;
        HashMap<Integer, sdk.pendo.io.x6.c> map = (HashMap) objA;
        if (map != null) {
            eVar2.fragmentsInfoHashMap = map;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            eVar2.fragmentsInfoHashMap.clear();
        }
        Activity activity2 = eVar2.getCurrentActivityRef$pendoIO_release().get();
        WeakReference<PendoDrawerListener> pendoDrawerListenerRef$pendoIO_release = eVar2.getPendoDrawerListenerRef$pendoIO_release();
        PendoDrawerListener pendoDrawerListener = pendoDrawerListenerRef$pendoIO_release != null ? pendoDrawerListenerRef$pendoIO_release.get() : null;
        boolean useModifiedScreenDataForNativeTransientUIComponent = eVar2.getScreenManagerPolicy().getSdk.pendo.io.Pendo.PendoOptions.USE_MODIFIED_SCREEN_DATA_FOR_NATIVE_TRANSIENT_UI_COMPONENT java.lang.String();
        sdk.pendo.io.x6.b bVar3 = eVar2.fragmentHelper;
        HashMap<Integer, sdk.pendo.io.x6.c> map2 = eVar2.fragmentsInfoHashMap;
        e1.a currentRootViewData = eVar2.getCurrentRootViewData();
        return useModifiedScreenDataForNativeTransientUIComponent ? eVar2.calculateNativeViewScreenId(bVar3, map2, activity2, currentRootViewData, eVar2.getCurrentScreenId$pendoIO_release(), pendoDrawerListener) : eVar2.calculateOldNativeViewScreenId(bVar3, map2, activity2, currentRootViewData, eVar2.getScreenManagerPolicy().getIsOldScreenIdFormat(), eVar2.getCurrentScreenId$pendoIO_release(), pendoDrawerListener);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
    
        if (r6 == r1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        if (super.clearInternal(r0) == r1) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object clearInternal$suspendImpl(sdk.pendo.io.x6.e r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof sdk.pendo.io.x6.e.c
            if (r0 == 0) goto L13
            r0 = r6
            sdk.pendo.io.x6.e$c r0 = (sdk.pendo.io.x6.e.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            sdk.pendo.io.x6.e$c r0 = new sdk.pendo.io.x6.e$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L64
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.a
            sdk.pendo.io.x6.e r5 = (sdk.pendo.io.x6.e) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L56
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.ref.WeakReference r6 = r5.getCurrentActivityRef$pendoIO_release()
            java.lang.Object r6 = r6.get()
            android.app.Activity r6 = (android.app.Activity) r6
            if (r6 == 0) goto L58
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = r5.unregisterScreenContentChangeListeners(r6, r0)
            if (r6 != r1) goto L56
            goto L63
        L56:
            android.view.ViewTreeObserver r6 = (android.view.ViewTreeObserver) r6
        L58:
            r6 = 0
            r0.a = r6
            r0.d = r3
            java.lang.Object r5 = super.clearInternal(r0)
            if (r5 != r1) goto L64
        L63:
            return r1
        L64:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.e.clearInternal$suspendImpl(sdk.pendo.io.x6.e, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    static /* synthetic */ Object getScreenData$suspendImpl(e eVar, boolean z, boolean z2, Continuation<? super JSONObject> continuation) {
        d dVar;
        WeakReference<View> weakReference;
        View view;
        e eVar2 = eVar;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i2 = dVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                dVar.d = i2 - Integer.MIN_VALUE;
            } else {
                dVar = eVar2.new d(continuation);
            }
        } else {
            dVar = eVar2.new d(continuation);
        }
        d dVar2 = dVar;
        Object objA = dVar2.b;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = dVar2.d;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objA);
            sdk.pendo.io.x6.h hVar = new sdk.pendo.io.x6.h(eVar2.fragmentsInfoHashMap, eVar2.viewPagerOnPageChangeListener, eVar2.getScreenManagerPolicy().getIsRespondToScrollChangeEventsForScreenId(), eVar2.getScreenManagerPolicy().includeNestedText, z, z2);
            e1.a currentRootViewData = eVar2.getCurrentRootViewData();
            Set<View> currentScreenContentRoots = (currentRootViewData == null || (weakReference = currentRootViewData.a) == null || (view = weakReference.get()) == null) ? null : eVar2.getCurrentScreenContentRoots(view);
            String currentScreenId$pendoIO_release = eVar2.getCurrentScreenId$pendoIO_release();
            WeakReference<Activity> currentActivityRef$pendoIO_release = eVar2.getCurrentActivityRef$pendoIO_release();
            sdk.pendo.io.x6.b bVar = eVar2.fragmentHelper;
            boolean useModifiedScreenDataForNativeTransientUIComponent = eVar2.getScreenManagerPolicy().getSdk.pendo.io.Pendo.PendoOptions.USE_MODIFIED_SCREEN_DATA_FOR_NATIVE_TRANSIENT_UI_COMPONENT java.lang.String();
            dVar2.a = eVar2;
            dVar2.d = 1;
            objA = hVar.a(currentScreenId$pendoIO_release, currentActivityRef$pendoIO_release, currentScreenContentRoots, bVar, useModifiedScreenDataForNativeTransientUIComponent, dVar2);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar2 = (e) dVar2.a;
            ResultKt.throwOnFailure(objA);
        }
        sdk.pendo.io.x6.h.b bVar2 = (sdk.pendo.io.x6.h.b) objA;
        e1.a currentRootViewData2 = eVar2.getCurrentRootViewData();
        eVar2.setFocusListener$pendoIO_release(currentRootViewData2 != null ? currentRootViewData2.a : null);
        eVar2.populateSpecialViewsMap(bVar2.b());
        return bVar2.getScreenDataJson();
    }

    private final boolean handleChangesInSpecialView(String type, int count, int selectedIndex, sdk.pendo.io.x6.h.c specialViewItem) {
        if (count == 0 || specialViewItem.getLastKnownSelectedIndex() < 0 || selectedIndex == specialViewItem.getLastKnownSelectedIndex()) {
            return false;
        }
        PendoLogger.d("NativeScreenManager-> handleChangesInSpecialView " + type + " significantly changed, selectedIndex = " + selectedIndex, new Object[0]);
        return Intrinsics.areEqual(type, "TabLayout") || Intrinsics.areEqual(type, "BottomNavigationView");
    }

    static /* synthetic */ Object handleGlobalLayoutChangeEvent$suspendImpl(e eVar, Continuation<? super Unit> continuation) {
        MutableSharedFlow<Unit> screenContentChangeFlow$pendoIO_release = eVar.getScreenContentChangeFlow$pendoIO_release();
        if (screenContentChangeFlow$pendoIO_release != null) {
            Boxing.boxBoolean(screenContentChangeFlow$pendoIO_release.tryEmit(Unit.INSTANCE));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
    
        if (super.handleNewScreenIdentified$pendoIO_release(r0) == r1) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object handleNewScreenIdentified$suspendImpl(sdk.pendo.io.x6.e r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof sdk.pendo.io.x6.e.C0521e
            if (r0 == 0) goto L13
            r0 = r6
            sdk.pendo.io.x6.e$e r0 = (sdk.pendo.io.x6.e.C0521e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            sdk.pendo.io.x6.e$e r0 = new sdk.pendo.io.x6.e$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L62
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.a
            sdk.pendo.io.x6.e r5 = (sdk.pendo.io.x6.e) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L56
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.isDialogOnScreen()
            if (r6 != 0) goto L4b
            boolean r6 = r5.isPanelOnScreen()
            if (r6 == 0) goto L56
        L4b:
            r0.a = r5
            r0.d = r4
            java.lang.Object r6 = r5.onDialogAppear(r0)
            if (r6 != r1) goto L56
            goto L61
        L56:
            r6 = 0
            r0.a = r6
            r0.d = r3
            java.lang.Object r5 = super.handleNewScreenIdentified$pendoIO_release(r0)
            if (r5 != r1) goto L62
        L61:
            return r1
        L62:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.e.handleNewScreenIdentified$suspendImpl(sdk.pendo.io.x6.e, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:29:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d6, code lost:
    
        if (super.handleSameScreenIdentified(r0) == r1) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object handleSameScreenIdentified$suspendImpl(sdk.pendo.io.x6.e r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.e.handleSameScreenIdentified$suspendImpl(sdk.pendo.io.x6.e, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object handleScrollChangeEvent$suspendImpl(e eVar, Continuation<? super Unit> continuation) {
        eVar.getScreenLayoutChangedSameScreenIdSubject().onNext(eVar.getCurrentScreenId$pendoIO_release());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initGlobalLayoutChangeListener$lambda$12(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g.ON_GLOBAL_LAYOUT_CHANGED);
    }

    private final void initScrollChangeListener() {
        if (this.onScrollChangeListener == null) {
            this.onScrollChangeListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: sdk.pendo.io.x6.e$$ExternalSyntheticLambda1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    e.initScrollChangeListener$lambda$13(this.f$0);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initScrollChangeListener$lambda$13(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onScrollChangeEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initWindowFocusChangeListener$lambda$14(e this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g.ON_WINDOW_FOCUS_CHANGED);
    }

    private final boolean isDialogOnScreen() {
        return StringsKt.contains$default((CharSequence) getCurrentScreenId$pendoIO_release(), (CharSequence) sdk.pendo.io.x6.i.DIALOG_ID, false, 2, (Object) null);
    }

    private final boolean isPanelOnScreen() {
        return StringsKt.contains$default((CharSequence) getCurrentScreenId$pendoIO_release(), (CharSequence) sdk.pendo.io.x6.i.PANEL_ID, false, 2, (Object) null);
    }

    private final boolean loopViewsForChanges(Activity activity) {
        try {
            boolean zHandleChangesInSpecialView = false;
            for (Map.Entry<String, ArrayList<sdk.pendo.io.x6.h.c>> entry : this.specialViewsMap.entrySet()) {
                for (sdk.pendo.io.x6.h.c cVar : entry.getValue()) {
                    Intrinsics.checkNotNull(cVar);
                    View viewFetchView$pendoIO_release = fetchView$pendoIO_release(cVar, activity);
                    if (viewFetchView$pendoIO_release == null) {
                        PendoLogger.d("NativeScreenManager-> loopViewsForChanges " + ((Object) entry.getKey()) + " significantly changed, type changed", new Object[0]);
                        return true;
                    }
                    if (Intrinsics.areEqual(entry.getKey(), "TabLayout") && (viewFetchView$pendoIO_release instanceof TabLayout)) {
                        zHandleChangesInSpecialView = handleChangesInSpecialView("TabLayout", ((TabLayout) viewFetchView$pendoIO_release).getTabCount(), ((TabLayout) viewFetchView$pendoIO_release).getSelectedTabPosition(), cVar);
                        if (zHandleChangesInSpecialView) {
                            return true;
                        }
                    } else if (Intrinsics.areEqual(entry.getKey(), "BottomNavigationView") && (viewFetchView$pendoIO_release instanceof BottomNavigationView)) {
                        zHandleChangesInSpecialView = handleChangesInSpecialView("BottomNavigationView", ((BottomNavigationView) viewFetchView$pendoIO_release).getMenu().size(), ((BottomNavigationView) viewFetchView$pendoIO_release).getSelectedItemId(), cVar);
                        if (zHandleChangesInSpecialView) {
                            return true;
                        }
                    } else if (!Intrinsics.areEqual(entry.getKey(), "MapView")) {
                        PendoLogger.d("NativeScreenManager -> loopViewsForChanges - the view type (" + ((Object) entry.getKey()) + " vs. " + viewFetchView$pendoIO_release.getClass().getCanonicalName() + ") did not match any of the special views!", new Object[0]);
                        return true;
                    }
                }
            }
            return zHandleChangesInSpecialView;
        } catch (Exception e) {
            PendoLogger.w(e, "NativeScreenManager -> loopViewsForChanges - An exception was caught, will signal for re-scanning the screen", new Object[0]);
            return true;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
    
        if (super.onActivityResumedInternal$pendoIO_release(r6, r0) == r1) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object onActivityResumedInternal$suspendImpl(sdk.pendo.io.x6.e r5, android.app.Activity r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof sdk.pendo.io.x6.e.i
            if (r0 == 0) goto L13
            r0 = r7
            sdk.pendo.io.x6.e$i r0 = (sdk.pendo.io.x6.e.i) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            sdk.pendo.io.x6.e$i r0 = new sdk.pendo.io.x6.e$i
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6e
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.b
            r6 = r5
            android.app.Activity r6 = (android.app.Activity) r6
            java.lang.Object r5 = r0.a
            sdk.pendo.io.x6.e r5 = (sdk.pendo.io.x6.e) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L60
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            r5.initGlobalLayoutChangeListener()
            r5.initGlobalLayoutChangeFlow()
            r5.initScrollChangeListener()
            r5.initScrollChangeFlow()
            r5.initWindowFocusChangeListener()
            r0.a = r5
            r0.b = r6
            r0.e = r4
            java.lang.Object r7 = r5.registerScreenContentChangeListeners(r6, r0)
            if (r7 != r1) goto L60
            goto L6d
        L60:
            r7 = 0
            r0.a = r7
            r0.b = r7
            r0.e = r3
            java.lang.Object r5 = super.onActivityResumedInternal$pendoIO_release(r6, r0)
            if (r5 != r1) goto L6e
        L6d:
            return r1
        L6e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.e.onActivityResumedInternal$suspendImpl(sdk.pendo.io.x6.e, android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onDialogAppear(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(getDispatcherProvider().getMain().plus(new CoroutineName("onDialogAppear")), new j(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    private final void onScrollChangeEvent() {
        MutableSharedFlow mutableSharedFlow;
        Object obj;
        if (getScreenManagerPolicy().getIsRespondToScrollChangeEventsForScreenId()) {
            mutableSharedFlow = this.globalLayoutChangeEventsFlow;
            if (mutableSharedFlow == null) {
                return;
            } else {
                obj = sdk.pendo.io.x6.g.ON_SCROLL;
            }
        } else {
            mutableSharedFlow = this.scrollChangeEventsFlow;
            if (mutableSharedFlow == null) {
                return;
            } else {
                obj = Unit.INSTANCE;
            }
        }
        mutableSharedFlow.tryEmit(obj);
    }

    private final void populateSpecialViewsMap(Map<String, ? extends ArrayList<sdk.pendo.io.x6.h.c>> newSpecialViewsMap) {
        this.specialViewsMap.clear();
        for (Map.Entry<String, ? extends ArrayList<sdk.pendo.io.x6.h.c>> entry : newSpecialViewsMap.entrySet()) {
            String key = entry.getKey();
            ArrayList<sdk.pendo.io.x6.h.c> value = entry.getValue();
            if (this.specialViewsMap.containsKey(key)) {
                ArrayList<sdk.pendo.io.x6.h.c> arrayList = this.specialViewsMap.get(key);
                if (arrayList != null) {
                    arrayList.addAll(value);
                }
            } else {
                this.specialViewsMap.put(key, value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object unregisterScreenContentChangeListeners(Activity activity, Continuation<? super ViewTreeObserver> continuation) {
        return BuildersKt.withContext(getDispatcherProvider().getMain().plus(new CoroutineName("unregisterScreenContentChangeListeners")), new n(activity, this, null), continuation);
    }

    private final boolean verifySpecialViewsAndTextsToIdentifyNewScreen() {
        if (getCurrentScreenData() != null) {
            Activity activityA = sdk.pendo.io.d6.c.h().a();
            if (activityA != null) {
                Intrinsics.checkNotNull(activityA);
                return loopViewsForChanges(activityA);
            }
            PendoLogger.e("ScreenManager.getUpdatedScreenData, activity is null", new Object[0]);
        }
        return false;
    }

    @Override // sdk.pendo.io.x6.i
    public Object calculateScreenId$pendoIO_release(Continuation<? super String> continuation) {
        return calculateScreenId$suspendImpl(this, continuation);
    }

    @Override // sdk.pendo.io.x6.i
    public void cancelScreenManagerCoroutineJobs$pendoIO_release() {
        super.cancelScreenManagerCoroutineJobs$pendoIO_release();
        this.globalLayoutChangeEventsCollectionJob = null;
        this.scrollChangeEventsCollectionJob = null;
        this.globalLayoutChangeEventsFlow = null;
        this.scrollChangeEventsFlow = null;
    }

    @Override // sdk.pendo.io.x6.i
    public Object clearInternal(Continuation<? super Unit> continuation) {
        return clearInternal$suspendImpl(this, continuation);
    }

    public final View fetchView$pendoIO_release(sdk.pendo.io.x6.h.c item, Activity activity) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(activity, "activity");
        View view = item.c().get();
        return view == null ? activity.findViewById(item.getViewId()) : view;
    }

    public final String getDialogAndPanelForScreenId(boolean isDialogType, boolean isPopupWindowType) {
        StringBuilder sb = new StringBuilder("");
        if (isDialogType) {
            sb.append(sdk.pendo.io.x6.i.DIALOG_ID + sdk.pendo.io.b8.b.a.a());
        }
        if (isPopupWindowType) {
            sb.append(sdk.pendo.io.x6.i.PANEL_ID + sdk.pendo.io.b8.b.a.a());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: renamed from: getFragmentHelper$pendoIO_release, reason: from getter */
    public final sdk.pendo.io.x6.b getFragmentHelper() {
        return this.fragmentHelper;
    }

    public final HashMap<Integer, sdk.pendo.io.x6.c> getFragmentsInfoHashMap$pendoIO_release() {
        return this.fragmentsInfoHashMap;
    }

    /* JADX INFO: renamed from: getOnGlobalLayoutChangeListener$pendoIO_release, reason: from getter */
    public final ViewTreeObserver.OnGlobalLayoutListener getOnGlobalLayoutChangeListener() {
        return this.onGlobalLayoutChangeListener;
    }

    @Override // sdk.pendo.io.x6.i
    public Object getScreenData$pendoIO_release(boolean z, boolean z2, Continuation<? super JSONObject> continuation) {
        return getScreenData$suspendImpl(this, z, z2, continuation);
    }

    public final HashMap<String, ArrayList<sdk.pendo.io.x6.h.c>> getSpecialViewsMap$pendoIO_release() {
        return this.specialViewsMap;
    }

    public Object handleGlobalLayoutChangeEvent(Continuation<? super Unit> continuation) {
        return handleGlobalLayoutChangeEvent$suspendImpl(this, continuation);
    }

    @Override // sdk.pendo.io.x6.i
    public Object handleNewScreenIdentified$pendoIO_release(Continuation<? super Unit> continuation) {
        return handleNewScreenIdentified$suspendImpl(this, continuation);
    }

    @Override // sdk.pendo.io.x6.i
    public Object handleSameScreenIdentified(Continuation<? super Unit> continuation) {
        return handleSameScreenIdentified$suspendImpl(this, continuation);
    }

    protected Object handleScrollChangeEvent(Continuation<? super Unit> continuation) {
        return handleScrollChangeEvent$suspendImpl(this, continuation);
    }

    protected void initGlobalLayoutChangeFlow() {
        if (this.globalLayoutChangeEventsFlow == null) {
            this.globalLayoutChangeEventsFlow = SharedFlowKt.MutableSharedFlow(1, 1, BufferOverflow.DROP_LATEST);
        }
        Job job = this.globalLayoutChangeEventsCollectionJob;
        if (job == null || job == null || !job.isActive()) {
            this.globalLayoutChangeEventsCollectionJob = BuildersKt__Builders_commonKt.launch$default(getSmCoroutineScope(), new CoroutineName("globalLayoutChangeEventsCollectionCoroutine"), null, new g(null), 2, null);
        }
    }

    public void initGlobalLayoutChangeListener() {
        if (this.onGlobalLayoutChangeListener == null) {
            this.onGlobalLayoutChangeListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: sdk.pendo.io.x6.e$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    e.initGlobalLayoutChangeListener$lambda$12(this.f$0);
                }
            };
        }
    }

    protected void initScrollChangeFlow() {
        if (this.scrollChangeEventsFlow == null) {
            this.scrollChangeEventsFlow = SharedFlowKt.MutableSharedFlow(1, 1, BufferOverflow.DROP_LATEST);
        }
        Job job = this.scrollChangeEventsCollectionJob;
        if (job == null || job == null || !job.isActive()) {
            this.scrollChangeEventsCollectionJob = BuildersKt__Builders_commonKt.launch$default(getSmCoroutineScope(), new CoroutineName("scrollChangeEventsCollectionCoroutine"), null, new h(null), 2, null);
        }
    }

    protected void initWindowFocusChangeListener() {
        if (this.onWindowFocusChangeListener == null) {
            this.onWindowFocusChangeListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: sdk.pendo.io.x6.e$$ExternalSyntheticLambda2
                @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                public final void onWindowFocusChanged(boolean z) {
                    e.initWindowFocusChangeListener$lambda$14(this.f$0, z);
                }
            };
        }
    }

    @Override // sdk.pendo.io.x6.i
    public Object onActivityResumedInternal$pendoIO_release(Activity activity, Continuation<? super Unit> continuation) {
        return onActivityResumedInternal$suspendImpl(this, activity, continuation);
    }

    @Override // sdk.pendo.io.f6.d
    public void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse response) {
        x.a(getSmCoroutineScope(), getScreenManagerMutex(), null, null, new k(response, this, null), 6, null);
    }

    @Override // sdk.pendo.io.x6.i, sdk.pendo.io.x6.d
    public void onGlobalLayoutChangeEvent(sdk.pendo.io.x6.g triggerEvent) {
        Intrinsics.checkNotNullParameter(triggerEvent, "triggerEvent");
        MutableSharedFlow<sdk.pendo.io.x6.g> mutableSharedFlow = this.globalLayoutChangeEventsFlow;
        if (mutableSharedFlow != null) {
            mutableSharedFlow.tryEmit(triggerEvent);
        }
    }

    public final Object registerScreenContentChangeListeners(Activity activity, Continuation<? super ViewTreeObserver> continuation) {
        return BuildersKt.withContext(getDispatcherProvider().getMain().plus(new CoroutineName("registerScreenContentChangeListeners")), new l(activity, null), continuation);
    }

    public void setFocusListener$pendoIO_release(WeakReference<View> rootViewWeakReference) {
        View view;
        if (rootViewWeakReference == null || (view = rootViewWeakReference.get()) == null || !(view instanceof ViewGroup)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(getSmCoroutineScope(), new CoroutineName("setFocusListener"), null, new m(view, null), 2, null);
    }

    public final void setFragmentHelper$pendoIO_release(sdk.pendo.io.x6.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.fragmentHelper = bVar;
    }

    public final void setFragmentsInfoHashMap$pendoIO_release(HashMap<Integer, sdk.pendo.io.x6.c> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.fragmentsInfoHashMap = map;
    }

    public final void setOnGlobalLayoutChangeListener$pendoIO_release(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.onGlobalLayoutChangeListener = onGlobalLayoutListener;
    }

    public boolean shouldCollectDynamicChanges() {
        return !shouldIgnoreChangesInApp$pendoIO_release();
    }

    public boolean shouldHandleGlobalLayoutChanges$pendoIO_release() {
        PendoLogger.d("NativeScreenManager shouldHandleGlobalLayoutChanges -> shouldHandleViewPagerChanges: " + this.shouldHandleViewPagerChanges + " shouldForceHandleGlobalLayoutChange: " + getScreenManagerPolicy().getShouldForceHandleGlobalLayoutChange(), new Object[0]);
        return this.shouldHandleViewPagerChanges || getScreenManagerPolicy().getShouldForceHandleGlobalLayoutChange();
    }

    public /* synthetic */ e(Pendo.PendoOptions pendoOptions, sdk.pendo.io.s7.m mVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendoOptions, (i2 & 2) != 0 ? new sdk.pendo.io.s7.k() : mVar);
    }
}
