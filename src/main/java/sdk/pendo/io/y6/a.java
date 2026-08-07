package sdk.pendo.io.y6;

import android.app.Activity;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.k;
import sdk.pendo.io.s7.m;
import sdk.pendo.io.s7.x;
import sdk.pendo.io.sdk.xamarin.XamarinBridge;
import sdk.pendo.io.sdk.xamarin.XamarinFlyoutPageListener;
import sdk.pendo.io.x6.e;
import sdk.pendo.io.x6.i;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001\nB\u0019\u0012\u0006\u0010%\u001a\u00020$\u0012\b\b\u0002\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J.\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002Jl\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001b\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0012H\u0090@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\u00020\u0016H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001d\u001a\u00020\u0002H\u0090@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001bJ\u0013\u0010\u001f\u001a\u00020\u0016H\u0090@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001bJ\u0012\u0010\"\u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0013\u0010\n\u001a\u00020\u0016H\u0087@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u001bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lsdk/pendo/io/y6/a;", "Lsdk/pendo/io/x6/e;", "", "currentScreenId", "Lsdk/pendo/io/s7/e1$a;", "rootViewData", "Lsdk/pendo/io/sdk/xamarin/XamarinBridge;", Pendo.PendoOptions.XAMARIN_BRIDGE, "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "drawerListener", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/x6/b;", "fragmentHelper", "Ljava/util/HashMap;", "", "Lsdk/pendo/io/x6/c;", "Lkotlin/collections/HashMap;", "fragmentsInfoHashMap", "Landroid/app/Activity;", "activity", "", "isOldScreenIdFormat", "", "onActivityResumedInternal$pendoIO_release", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActivityResumedInternal", "handleGlobalLayoutChangeEvent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateScreenId$pendoIO_release", "calculateScreenId", "handleNewScreenIdentified$pendoIO_release", "handleNewScreenIdentified", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "response", "onGetAccessTokenResponseReceived", "Lsdk/pendo/io/sdk/xamarin/XamarinBridge;", "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "Lsdk/pendo/io/s7/m;", "defaultDispatcherProvider", "<init>", "(Lsdk/pendo/io/Pendo$PendoOptions;Lsdk/pendo/io/s7/m;)V", "b", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class a extends e {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final XamarinBridge xamarinBridge;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.xamarin.XamarinScreenManager", f = "XamarinScreenManager.kt", i = {0, 0, 0}, l = {50}, m = "calculateScreenId$pendoIO_release", n = {"this", "activity", "drawerListener"}, s = {"L$0", "L$1", "L$2"})
    static final class b extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int f;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return a.this.calculateScreenId$pendoIO_release(this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.xamarin.XamarinScreenManager", f = "XamarinScreenManager.kt", i = {0}, l = {73, 77}, m = "handleNewScreenIdentified$pendoIO_release", n = {"this"}, s = {"L$0"})
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
            return a.this.handleNewScreenIdentified$pendoIO_release(this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.xamarin.XamarinScreenManager$onGetAccessTokenResponseReceived$1", f = "XamarinScreenManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ GetAuthToken.GetAuthTokenResponse b;
        final /* synthetic */ a c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse, a aVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = getAuthTokenResponse;
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
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
                this.c.getScreenManagerPolicy().b(getAuthTokenResponse.getUseOnlyXamarinBridgeProvidedScreenId());
            }
            a.super.onGetAccessTokenResponseReceived(this.b);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Pendo.PendoOptions pendoOptions, m defaultDispatcherProvider) {
        super(pendoOptions, defaultDispatcherProvider);
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        Intrinsics.checkNotNullParameter(defaultDispatcherProvider, "defaultDispatcherProvider");
        Map<String, Object> additionalOptions = pendoOptions.getAdditionalOptions();
        XamarinBridge xamarinBridge = null;
        if (additionalOptions != null) {
            Object obj = additionalOptions.get(Pendo.PendoOptions.XAMARIN_BRIDGE);
            xamarinBridge = (XamarinBridge) (obj instanceof XamarinBridge ? obj : null);
        }
        this.xamarinBridge = xamarinBridge;
        if (xamarinBridge != null) {
            xamarinBridge.addFlyoutListener(new XamarinFlyoutPageListener());
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    public Object calculateScreenId$pendoIO_release(Continuation<? super String> continuation) {
        b bVar;
        a aVar;
        Activity activity;
        PendoDrawerListener pendoDrawerListener;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.f = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.f;
        Unit unit = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Activity activity2 = getCurrentActivityRef$pendoIO_release().get();
            WeakReference<PendoDrawerListener> pendoDrawerListenerRef$pendoIO_release = getPendoDrawerListenerRef$pendoIO_release();
            PendoDrawerListener pendoDrawerListener2 = pendoDrawerListenerRef$pendoIO_release != null ? pendoDrawerListenerRef$pendoIO_release.get() : null;
            if (getScreenManagerPolicy().getUseOnlyXamarinBridgeProvidedScreenId()) {
                return a(getCurrentScreenId$pendoIO_release(), getCurrentRootViewData(), this.xamarinBridge, pendoDrawerListener2);
            }
            sdk.pendo.io.x6.b fragmentHelper = getFragmentHelper();
            Activity activity3 = getCurrentActivityRef$pendoIO_release().get();
            boolean ignoreDynamicFragmentsInScrollView = getScreenManagerPolicy().getIgnoreDynamicFragmentsInScrollView();
            bVar.a = this;
            bVar.b = activity2;
            bVar.c = pendoDrawerListener2;
            bVar.f = 1;
            Object objA = fragmentHelper.a(activity3, ignoreDynamicFragmentsInScrollView, bVar);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            aVar = this;
            activity = activity2;
            obj = objA;
            pendoDrawerListener = pendoDrawerListener2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            PendoDrawerListener pendoDrawerListener3 = (PendoDrawerListener) bVar.c;
            Activity activity4 = (Activity) bVar.b;
            a aVar2 = (a) bVar.a;
            ResultKt.throwOnFailure(obj);
            pendoDrawerListener = pendoDrawerListener3;
            aVar = aVar2;
            activity = activity4;
        }
        HashMap<Integer, sdk.pendo.io.x6.c> map = (HashMap) obj;
        if (map != null) {
            aVar.setFragmentsInfoHashMap$pendoIO_release(map);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            aVar.getFragmentsInfoHashMap$pendoIO_release().clear();
        }
        return aVar.a(aVar.getFragmentHelper(), aVar.getFragmentsInfoHashMap$pendoIO_release(), activity, aVar.getCurrentRootViewData(), aVar.getScreenManagerPolicy().getIsOldScreenIdFormat(), aVar.getCurrentScreenId$pendoIO_release(), aVar.xamarinBridge, pendoDrawerListener);
    }

    @Override // sdk.pendo.io.x6.e
    public Object handleGlobalLayoutChangeEvent(Continuation<? super Unit> continuation) {
        XamarinBridge xamarinBridge = this.xamarinBridge;
        if (xamarinBridge != null) {
            xamarinBridge.onLayoutChanged();
        }
        Object objHandleGlobalLayoutChangeEvent = super.handleGlobalLayoutChangeEvent(continuation);
        return objHandleGlobalLayoutChangeEvent == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objHandleGlobalLayoutChangeEvent : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
    
        if (a(r0) == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
    
        if (super.handleNewScreenIdentified$pendoIO_release(r0) == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006e, code lost:
    
        return r1;
     */
    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object handleNewScreenIdentified$pendoIO_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof sdk.pendo.io.y6.a.c
            if (r0 == 0) goto L13
            r0 = r6
            sdk.pendo.io.y6.a$c r0 = (sdk.pendo.io.y6.a.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            sdk.pendo.io.y6.a$c r0 = new sdk.pendo.io.y6.a$c
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
            goto L6f
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            java.lang.Object r5 = r0.a
            sdk.pendo.io.y6.a r5 = (sdk.pendo.io.y6.a) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L4a
            goto L63
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.a = r5     // Catch: java.lang.Exception -> L4a
            r0.d = r4     // Catch: java.lang.Exception -> L4a
            java.lang.Object r6 = r5.a(r0)     // Catch: java.lang.Exception -> L4a
            if (r6 != r1) goto L63
            goto L6e
        L4a:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Error reading from xamarin forms bridge: "
            r2.<init>(r4)
            java.lang.StringBuilder r6 = r2.append(r6)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r2 = "XamarinScreenManager"
            sdk.pendo.io.logging.PendoLogger.d(r2, r6)
        L63:
            r6 = 0
            r0.a = r6
            r0.d = r3
            java.lang.Object r5 = super.handleNewScreenIdentified$pendoIO_release(r0)
            if (r5 != r1) goto L6f
        L6e:
            return r1
        L6f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y6.a.handleNewScreenIdentified$pendoIO_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.x6.i
    public Object onActivityResumedInternal$pendoIO_release(Activity activity, Continuation<? super Unit> continuation) {
        XamarinBridge xamarinBridge = this.xamarinBridge;
        if (xamarinBridge != null) {
            xamarinBridge.onLayoutChanged();
        }
        Object objOnActivityResumedInternal$pendoIO_release = super.onActivityResumedInternal$pendoIO_release(activity, continuation);
        return objOnActivityResumedInternal$pendoIO_release == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objOnActivityResumedInternal$pendoIO_release : Unit.INSTANCE;
    }

    @Override // sdk.pendo.io.x6.e, sdk.pendo.io.f6.d
    public void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse response) {
        x.a(getSmCoroutineScope(), getScreenManagerMutex(), null, null, new d(response, this, null), 6, null);
    }

    public /* synthetic */ a(Pendo.PendoOptions pendoOptions, m mVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(pendoOptions, (i & 2) != 0 ? new k() : mVar);
    }

    private final String a(sdk.pendo.io.x6.b fragmentHelper, HashMap<Integer, sdk.pendo.io.x6.c> fragmentsInfoHashMap, Activity activity, e1.a rootViewData, boolean isOldScreenIdFormat, String currentScreenId, XamarinBridge xamarinBridge, PendoDrawerListener drawerListener) {
        if (drawerListener != null && drawerListener.isDrawerOpened()) {
            return i.DRAWER_ID;
        }
        StringBuilder sb = new StringBuilder("");
        if (activity == null) {
            PendoLogger.w("ScreenManagerHelper.calculateOldXamarinScreenId -> activity is null", new Object[0]);
            return currentScreenId;
        }
        if (xamarinBridge != null) {
            sb.append((CharSequence) new StringBuilder(xamarinBridge.getScreenId()));
        } else {
            PendoLogger.w("ScreenManagerHelper.calculateOldXamarinScreenId -> xamarinBridge is null", new Object[0]);
            sb.append((CharSequence) new StringBuilder(activity.getClass().getSimpleName()));
        }
        sb.append(fragmentHelper.b(fragmentsInfoHashMap, isOldScreenIdFormat));
        if ((rootViewData != null ? sb.append(getDialogAndPanelForScreenId(rootViewData.g(), rootViewData.i())) : null) == null) {
            PendoLogger.w("ScreenManagerHelper.calculateOldXamarinScreenId -> root view is null", new Object[0]);
        }
        return i.INSTANCE.a().replace(sb, "");
    }

    private final String a(String currentScreenId, e1.a rootViewData, XamarinBridge xamarinBridge, PendoDrawerListener drawerListener) {
        if (drawerListener != null && drawerListener.isDrawerOpened()) {
            return i.DRAWER_ID;
        }
        if (rootViewData != null && rootViewData.g()) {
            return i.DIALOG_ID;
        }
        if (rootViewData != null && rootViewData.i()) {
            return i.PANEL_ID;
        }
        if (xamarinBridge != null) {
            return xamarinBridge.getScreenId();
        }
        PendoLogger.w("XamarinScreenManager", "calculateXamarinScreenId -> xamarinBridge is null");
        return currentScreenId;
    }

    public final Object a(Continuation<? super Unit> continuation) {
        XamarinBridge xamarinBridge = this.xamarinBridge;
        if (xamarinBridge == null || !xamarinBridge.isFlyoutPage() || !Intrinsics.areEqual(getPreviousScreenId(), i.DRAWER_ID)) {
            return Unit.INSTANCE;
        }
        Object objDelay = DelayKt.delay(300L, continuation);
        return objDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelay : Unit.INSTANCE;
    }
}
