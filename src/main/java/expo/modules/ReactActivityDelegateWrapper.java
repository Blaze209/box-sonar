package expo.modules;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactDelegate;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.PermissionListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactActivityHandler;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import expo.modules.kotlin.Utils;
import expo.modules.kotlin.exception.Exceptions;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ~2\u00020\u0001:\u0001~B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\tJ\n\u0010-\u001a\u0004\u0018\u00010.H\u0014J\n\u0010/\u001a\u0004\u0018\u000100H\u0014J\n\u00101\u001a\u0004\u0018\u000102H\u0014J\n\u00103\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u00104\u001a\u000205H\u0016J\n\u00106\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u00107\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u00010\u0016H\u0014J\u0012\u00109\u001a\u00020%2\b\u0010:\u001a\u0004\u0018\u00010.H\u0017J\b\u0010;\u001a\u00020%H\u0016J\b\u0010<\u001a\u00020%H\u0016J\b\u0010=\u001a\u00020%H\u0016J\b\u0010>\u001a\u00020%H\u0016J\"\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u0018\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020HH\u0016J\u0018\u0010I\u001a\u00020\u00052\u0006\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020HH\u0016J\u0018\u0010J\u001a\u00020\u00052\u0006\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020HH\u0016J\b\u0010K\u001a\u00020\u0005H\u0016J\u0012\u0010L\u001a\u00020\u00052\b\u0010M\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020\u0005H\u0016J/\u0010P\u001a\u00020%2\u000e\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160R2\u0006\u0010@\u001a\u00020A2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016¢\u0006\u0002\u0010UJ-\u0010V\u001a\u00020%2\u0006\u0010@\u001a\u00020A2\u000e\u0010Q\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160R2\u0006\u0010W\u001a\u00020XH\u0016¢\u0006\u0002\u0010YJ\b\u0010Z\u001a\u00020[H\u0014J\b\u0010\\\u001a\u00020]H\u0014J\b\u0010^\u001a\u00020\u0005H\u0014J\b\u0010_\u001a\u00020\u0005H\u0014J\n\u0010`\u001a\u0004\u0018\u00010.H\u0014J\u0010\u0010a\u001a\u00020%2\u0006\u0010b\u001a\u00020cH\u0016J\u001b\u0010d\u001a\u0002He\"\u0004\b\u0000\u0010e2\u0006\u0010f\u001a\u00020\u0016H\u0002¢\u0006\u0002\u0010gJC\u0010d\u001a\u0002He\"\u0004\b\u0000\u0010e\"\u0004\b\u0001\u0010h2\u0006\u0010f\u001a\u00020\u00162\u0010\u0010i\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030j0R2\f\u0010k\u001a\b\u0012\u0004\u0012\u0002Hh0RH\u0001¢\u0006\u0004\bl\u0010mJ \u0010n\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u00010\u00162\u0006\u0010o\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010pJ\u0018\u0010q\u001a\u00020%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010rJ@\u0010s\u001a\u00020%2\b\b\u0002\u0010t\u001a\u00020u2'\u0010v\u001a#\b\u0001\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0x\u0012\u0006\u0012\u0004\u0018\u00010y0w¢\u0006\u0002\bzH\u0002¢\u0006\u0002\u0010{J\r\u0010|\u001a\u00020%H\u0001¢\u0006\u0002\b}R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00020\u00018AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00130\u00130\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b*\u0010+¨\u0006\u007f"}, d2 = {"Lexpo/modules/ReactActivityDelegateWrapper;", "Lcom/facebook/react/ReactActivityDelegate;", "activity", "Lcom/facebook/react/ReactActivity;", "isNewArchitectureEnabled", "", "delegate", "<init>", "(Lcom/facebook/react/ReactActivity;ZLcom/facebook/react/ReactActivityDelegate;)V", "(Lcom/facebook/react/ReactActivity;Lcom/facebook/react/ReactActivityDelegate;)V", "getDelegate$expo_release", "()Lcom/facebook/react/ReactActivityDelegate;", "setDelegate$expo_release", "(Lcom/facebook/react/ReactActivityDelegate;)V", "reactActivityLifecycleListeners", "", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "kotlin.jvm.PlatformType", "reactActivityHandlers", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "methodMap", "Landroidx/collection/ArrayMap;", "", "Ljava/lang/reflect/Method;", "_reactHost", "Lcom/facebook/react/ReactHost;", "get_reactHost", "()Lcom/facebook/react/ReactHost;", "_reactHost$delegate", "Lkotlin/Lazy;", "delayLoadAppHandler", "Lexpo/modules/core/interfaces/ReactActivityHandler$DelayLoadAppHandler;", "getDelayLoadAppHandler", "()Lexpo/modules/core/interfaces/ReactActivityHandler$DelayLoadAppHandler;", "delayLoadAppHandler$delegate", "loadAppReady", "Lkotlinx/coroutines/CompletableDeferred;", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "applicationCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getApplicationCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "applicationCoroutineScope$delegate", "getLaunchOptions", "Landroid/os/Bundle;", "createRootView", "Lcom/facebook/react/ReactRootView;", "getReactDelegate", "Lcom/facebook/react/ReactDelegate;", "getReactHost", "getReactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "getMainComponentName", "loadApp", "appKey", "onCreate", "savedInstanceState", "onResume", "onPause", "onUserLeaveHint", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyUp", "onKeyLongPress", "onBackPressed", "onNewIntent", "intent", "onWindowFocusChanged", "hasFocus", "requestPermissions", "permissions", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/facebook/react/modules/core/PermissionListener;", "([Ljava/lang/String;ILcom/facebook/react/modules/core/PermissionListener;)V", "onRequestPermissionsResult", "grantResults", "", "(I[Ljava/lang/String;[I)V", "getContext", "Landroid/content/Context;", "getPlainActivity", "Landroid/app/Activity;", "isFabricEnabled", "isWideColorGamutEnabled", "composeLaunchOptions", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "invokeDelegateMethod", ExifInterface.GPS_DIRECTION_TRUE, "name", "(Ljava/lang/String;)Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "argTypes", "Ljava/lang/Class;", "args", "invokeDelegateMethod$expo_release", "(Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "loadAppImpl", "supportsDelayLoad", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDelayLoadAppWhenReady", "(Lexpo/modules/core/interfaces/ReactActivityHandler$DelayLoadAppHandler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchLifecycleScopeWithLock", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)V", "setLoadAppReadyForTesting", "setLoadAppReadyForTesting$expo_release", "Companion", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactActivityDelegateWrapper extends ReactActivityDelegate {
    private static final String TAG = Reflection.getOrCreateKotlinClass(ReactActivityDelegate.class).getSimpleName();

    /* JADX INFO: renamed from: _reactHost$delegate, reason: from kotlin metadata */
    private final Lazy _reactHost;
    private final ReactActivity activity;

    /* JADX INFO: renamed from: applicationCoroutineScope$delegate, reason: from kotlin metadata */
    private final Lazy applicationCoroutineScope;

    /* JADX INFO: renamed from: delayLoadAppHandler$delegate, reason: from kotlin metadata */
    private final Lazy delayLoadAppHandler;
    private ReactActivityDelegate delegate;
    private final boolean isNewArchitectureEnabled;
    private final CompletableDeferred<Unit> loadAppReady;
    private final ArrayMap<String, Method> methodMap;
    private final Mutex mutex;
    private final List<ReactActivityHandler> reactActivityHandlers;
    private final List<ReactActivityLifecycleListener> reactActivityLifecycleListeners;

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$loadAppImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper", f = "ReactActivityDelegateWrapper.kt", i = {0}, l = {420}, m = "loadAppImpl", n = {"appKey"}, s = {"L$0"})
    static final class C18731 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C18731(Continuation<? super C18731> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ReactActivityDelegateWrapper.this.loadAppImpl(null, false, this);
        }
    }

    /* JADX INFO: renamed from: getDelegate$expo_release, reason: from getter */
    public final ReactActivityDelegate getDelegate() {
        return this.delegate;
    }

    public final void setDelegate$expo_release(ReactActivityDelegate reactActivityDelegate) {
        Intrinsics.checkNotNullParameter(reactActivityDelegate, "<set-?>");
        this.delegate = reactActivityDelegate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactActivityDelegateWrapper(ReactActivity activity, boolean z, ReactActivityDelegate delegate) {
        super(activity, (String) null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.activity = activity;
        this.isNewArchitectureEnabled = z;
        this.delegate = delegate;
        List<Package> packageList = ExpoModulesPackage.INSTANCE.getPackageList();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = packageList.iterator();
        while (it.hasNext()) {
            List<? extends ReactActivityLifecycleListener> listCreateReactActivityLifecycleListeners = ((Package) it.next()).createReactActivityLifecycleListeners(this.activity);
            Intrinsics.checkNotNullExpressionValue(listCreateReactActivityLifecycleListeners, "createReactActivityLifecycleListeners(...)");
            CollectionsKt.addAll(arrayList, listCreateReactActivityLifecycleListeners);
        }
        this.reactActivityLifecycleListeners = arrayList;
        List<Package> packageList2 = ExpoModulesPackage.INSTANCE.getPackageList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it2 = packageList2.iterator();
        while (it2.hasNext()) {
            List<? extends ReactActivityHandler> listCreateReactActivityHandlers = ((Package) it2.next()).createReactActivityHandlers(this.activity);
            Intrinsics.checkNotNullExpressionValue(listCreateReactActivityHandlers, "createReactActivityHandlers(...)");
            CollectionsKt.addAll(arrayList2, listCreateReactActivityHandlers);
        }
        this.reactActivityHandlers = arrayList2;
        this.methodMap = new ArrayMap<>();
        this._reactHost = LazyKt.lazy(new Function0() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReactActivityDelegateWrapper._reactHost_delegate$lambda$2(this.f$0);
            }
        });
        this.delayLoadAppHandler = LazyKt.lazy(new Function0() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReactActivityDelegateWrapper.delayLoadAppHandler_delegate$lambda$4(this.f$0);
            }
        });
        this.loadAppReady = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.applicationCoroutineScope = LazyKt.lazy(new Function0() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReactActivityDelegateWrapper.applicationCoroutineScope_delegate$lambda$5();
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ReactActivityDelegateWrapper(ReactActivity activity, ReactActivityDelegate delegate) {
        this(activity, false, delegate);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    private final ReactHost get_reactHost() {
        return (ReactHost) this._reactHost.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReactHost _reactHost_delegate$lambda$2(ReactActivityDelegateWrapper reactActivityDelegateWrapper) {
        return reactActivityDelegateWrapper.delegate.getReactHost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReactActivityHandler.DelayLoadAppHandler getDelayLoadAppHandler() {
        return (ReactActivityHandler.DelayLoadAppHandler) this.delayLoadAppHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReactActivityHandler.DelayLoadAppHandler delayLoadAppHandler_delegate$lambda$4(final ReactActivityDelegateWrapper reactActivityDelegateWrapper) {
        return (ReactActivityHandler.DelayLoadAppHandler) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(reactActivityDelegateWrapper.reactActivityHandlers), new Function1() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactActivityDelegateWrapper.delayLoadAppHandler_delegate$lambda$4$lambda$3(this.f$0, (ReactActivityHandler) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReactActivityHandler.DelayLoadAppHandler delayLoadAppHandler_delegate$lambda$4$lambda$3(ReactActivityDelegateWrapper reactActivityDelegateWrapper, ReactActivityHandler reactActivityHandler) {
        return reactActivityHandler.getDelayLoadAppHandler(reactActivityDelegateWrapper.activity, reactActivityDelegateWrapper.getReactHost());
    }

    private final CoroutineScope getApplicationCoroutineScope() {
        return (CoroutineScope) this.applicationCoroutineScope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope applicationCoroutineScope_delegate$lambda$5() {
        return CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected Bundle getLaunchOptions() {
        return (Bundle) invokeDelegateMethod("getLaunchOptions");
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected ReactRootView createRootView() {
        return (ReactRootView) invokeDelegateMethod("createRootView");
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected ReactDelegate getReactDelegate() {
        return (ReactDelegate) invokeDelegateMethod("getReactDelegate");
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public ReactHost getReactHost() {
        return get_reactHost();
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public ReactInstanceManager getReactInstanceManager() {
        ReactInstanceManager reactInstanceManager = this.delegate.getReactInstanceManager();
        Intrinsics.checkNotNullExpressionValue(reactInstanceManager, "getReactInstanceManager(...)");
        return reactInstanceManager;
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public String getMainComponentName() {
        return this.delegate.getMainComponentName();
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$loadApp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$loadApp$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    static final class C18721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18721(String str, Continuation<? super C18721> continuation) {
            super(2, continuation);
            this.$appKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C18721(this.$appKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppImpl(this.$appKey, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
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

    @Override // com.facebook.react.ReactActivityDelegate
    protected void loadApp(String appKey) {
        launchLifecycleScopeWithLock(CoroutineStart.UNDISPATCHED, new C18721(appKey, null));
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onCreate(Bundle savedInstanceState) throws IllegalAccessException, NoSuchFieldException {
        ReactActivityDelegate reactActivityDelegate = (ReactActivityDelegate) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactActivityHandlers), new Function1() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ReactActivityDelegateWrapper.onCreate$lambda$6(this.f$0, (ReactActivityHandler) obj);
            }
        }));
        Iterator<T> it = this.reactActivityHandlers.iterator();
        while (it.hasNext()) {
            ((ReactActivityHandler) it.next()).onDidCreateReactActivityDelegateNotification(this.activity, reactActivityDelegate);
        }
        if (reactActivityDelegate != null && !Intrinsics.areEqual(reactActivityDelegate, this)) {
            Field declaredField = ReactActivity.class.getDeclaredField("mDelegate");
            declaredField.setAccessible(true);
            Field declaredField2 = Field.class.getDeclaredField("accessFlags");
            declaredField2.setAccessible(true);
            declaredField2.setInt(declaredField, declaredField.getModifiers() & (-17));
            declaredField.set(this.activity, reactActivityDelegate);
            this.delegate = reactActivityDelegate;
            reactActivityDelegate.onCreate(savedInstanceState);
        } else {
            launchLifecycleScopeWithLock(CoroutineStart.UNDISPATCHED, new AnonymousClass2(null));
        }
        Iterator<T> it2 = this.reactActivityLifecycleListeners.iterator();
        while (it2.hasNext()) {
            ((ReactActivityLifecycleListener) it2.next()).onCreate(this.activity, savedInstanceState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReactActivityDelegate onCreate$lambda$6(ReactActivityDelegateWrapper reactActivityDelegateWrapper, ReactActivityHandler reactActivityHandler) {
        return reactActivityHandler.onDidCreateReactActivityDelegate(reactActivityDelegateWrapper.activity, reactActivityDelegateWrapper);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onCreate$2", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {Token.COLONCOLON, Token.METHOD}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x009e, code lost:
        
            if (r8.loadAppImpl(r8.getMainComponentName(), false, r7) == r0) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1f
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.ResultKt.throwOnFailure(r8)
                goto La1
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L1b:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L34
            L1f:
                kotlin.ResultKt.throwOnFailure(r8)
                expo.modules.ReactActivityDelegateWrapper r8 = expo.modules.ReactActivityDelegateWrapper.this
                expo.modules.core.interfaces.ReactActivityHandler$DelayLoadAppHandler r1 = expo.modules.ReactActivityDelegateWrapper.access$getDelayLoadAppHandler(r8)
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r7.label = r3
                java.lang.Object r8 = expo.modules.ReactActivityDelegateWrapper.access$awaitDelayLoadAppWhenReady(r8, r1, r4)
                if (r8 != r0) goto L34
                goto La0
            L34:
                expo.modules.ReactActivityDelegateWrapper r8 = expo.modules.ReactActivityDelegateWrapper.this
                kotlinx.coroutines.CompletableDeferred r8 = expo.modules.ReactActivityDelegateWrapper.access$getLoadAppReady$p(r8)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                r8.complete(r1)
                expo.modules.ReactActivityDelegateWrapper r8 = expo.modules.ReactActivityDelegateWrapper.this
                boolean r8 = r8.isWideColorGamutEnabled()
                if (r8 == 0) goto L54
                expo.modules.ReactActivityDelegateWrapper r8 = expo.modules.ReactActivityDelegateWrapper.this
                com.facebook.react.ReactActivity r8 = expo.modules.ReactActivityDelegateWrapper.access$getActivity$p(r8)
                android.view.Window r8 = r8.getWindow()
                r8.setColorMode(r3)
            L54:
                expo.modules.ReactActivityDelegateWrapper r8 = expo.modules.ReactActivityDelegateWrapper.this
                android.os.Bundle r8 = r8.composeLaunchOptions()
                com.facebook.react.ReactDelegate r1 = new com.facebook.react.ReactDelegate
                expo.modules.ReactActivityDelegateWrapper r4 = expo.modules.ReactActivityDelegateWrapper.this
                android.app.Activity r4 = r4.getPlainActivity()
                expo.modules.ReactActivityDelegateWrapper r5 = expo.modules.ReactActivityDelegateWrapper.this
                com.facebook.react.ReactHost r5 = r5.getReactHost()
                expo.modules.ReactActivityDelegateWrapper r6 = expo.modules.ReactActivityDelegateWrapper.this
                java.lang.String r6 = r6.getMainComponentName()
                r1.<init>(r4, r5, r6, r8)
                java.lang.Class<com.facebook.react.ReactActivityDelegate> r8 = com.facebook.react.ReactActivityDelegate.class
                java.lang.String r4 = "mReactDelegate"
                java.lang.reflect.Field r8 = r8.getDeclaredField(r4)
                r8.setAccessible(r3)
                expo.modules.ReactActivityDelegateWrapper r3 = expo.modules.ReactActivityDelegateWrapper.this
                com.facebook.react.ReactActivityDelegate r3 = r3.getDelegate()
                r8.set(r3, r1)
                expo.modules.ReactActivityDelegateWrapper r8 = expo.modules.ReactActivityDelegateWrapper.this
                java.lang.String r8 = r8.getMainComponentName()
                if (r8 == 0) goto La1
                expo.modules.ReactActivityDelegateWrapper r8 = expo.modules.ReactActivityDelegateWrapper.this
                java.lang.String r1 = r8.getMainComponentName()
                r3 = r7
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r7.label = r2
                r7 = 0
                java.lang.Object r7 = expo.modules.ReactActivityDelegateWrapper.access$loadAppImpl(r8, r1, r7, r3)
                if (r7 != r0) goto La1
            La0:
                return r0
            La1:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.ReactActivityDelegateWrapper.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onResume$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
    static final class C18791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C18791(Continuation<? super C18791> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C18791(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onResume();
            List list = ReactActivityDelegateWrapper.this.reactActivityLifecycleListeners;
            ReactActivityDelegateWrapper reactActivityDelegateWrapper = ReactActivityDelegateWrapper.this;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ReactActivityLifecycleListener) it.next()).onResume(reactActivityDelegateWrapper.activity);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onResume() {
        launchLifecycleScopeWithLock$default(this, null, new C18791(null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onPause$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onPause$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {ContextualToolbar.DRAG_BUTTON_ALPHA}, m = "invokeSuspend", n = {}, s = {})
    static final class C18771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C18771(Continuation<? super C18771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C18771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = ReactActivityDelegateWrapper.this.reactActivityLifecycleListeners;
            ReactActivityDelegateWrapper reactActivityDelegateWrapper = ReactActivityDelegateWrapper.this;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ReactActivityLifecycleListener) it.next()).onPause(reactActivityDelegateWrapper.activity);
            }
            if (ReactActivityDelegateWrapper.this.getDelayLoadAppHandler() != null) {
                try {
                    ReactActivityDelegateWrapper.this.getDelegate().onPause();
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    Boxing.boxInt(Log.e(ReactActivityDelegateWrapper.TAG, "Exception occurred during onPause with delayed app loading", e));
                }
            } else {
                ReactActivityDelegateWrapper.this.getDelegate().onPause();
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onPause() {
        launchLifecycleScopeWithLock$default(this, null, new C18771(null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onUserLeaveHint$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onUserLeaveHint$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
    static final class C18801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C18801(Continuation<? super C18801> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C18801(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            List list = ReactActivityDelegateWrapper.this.reactActivityLifecycleListeners;
            ReactActivityDelegateWrapper reactActivityDelegateWrapper = ReactActivityDelegateWrapper.this;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((ReactActivityLifecycleListener) it.next()).onUserLeaveHint(reactActivityDelegateWrapper.activity);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onUserLeaveHint();
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onUserLeaveHint() {
        launchLifecycleScopeWithLock$default(this, null, new C18801(null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onDestroy$1", f = "ReactActivityDelegateWrapper.kt", i = {0, 1}, l = {478, 221}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    static final class C18761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C18761(Continuation<? super C18761> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C18761(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0071 A[Catch: all -> 0x001b, LOOP:0: B:22:0x006b->B:24:0x0071, LOOP_END, TryCatch #1 {all -> 0x001b, blocks: (B:7:0x0017, B:21:0x0061, B:22:0x006b, B:24:0x0071, B:25:0x0081, B:27:0x0087, B:32:0x00a9, B:31:0x00a2, B:30:0x0092), top: B:41:0x0017, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x00a2 A[Catch: all -> 0x001b, TryCatch #1 {all -> 0x001b, blocks: (B:7:0x0017, B:21:0x0061, B:22:0x006b, B:24:0x0071, B:25:0x0081, B:27:0x0087, B:32:0x00a9, B:31:0x00a2, B:30:0x0092), top: B:41:0x0017, inners: #2 }] */
        /* JADX WARN: Code duplicated, block: B:43:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Mutex mutex;
            ReactActivityDelegateWrapper reactActivityDelegateWrapper;
            Throwable th;
            Mutex mutex2;
            ReactActivityDelegateWrapper reactActivityDelegateWrapper2;
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = ReactActivityDelegateWrapper.this.mutex;
                    reactActivityDelegateWrapper = ReactActivityDelegateWrapper.this;
                    this.L$0 = mutex;
                    this.L$1 = reactActivityDelegateWrapper;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    reactActivityDelegateWrapper2 = (ReactActivityDelegateWrapper) this.L$1;
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        it = reactActivityDelegateWrapper2.reactActivityLifecycleListeners.iterator();
                        while (it.hasNext()) {
                            ((ReactActivityLifecycleListener) it.next()).onDestroy(reactActivityDelegateWrapper2.activity);
                        }
                        if (reactActivityDelegateWrapper2.getDelayLoadAppHandler() != null) {
                            try {
                                reactActivityDelegateWrapper2.getDelegate().onDestroy();
                                Unit unit = Unit.INSTANCE;
                            } catch (Exception e) {
                                Boxing.boxInt(Log.e(ReactActivityDelegateWrapper.TAG, "Exception occurred during onDestroy with delayed app loading", e));
                            }
                        } else {
                            reactActivityDelegateWrapper2.getDelegate().onDestroy();
                        }
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                reactActivityDelegateWrapper = (ReactActivityDelegateWrapper) this.L$1;
                Mutex mutex3 = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                CompletableDeferred completableDeferred = reactActivityDelegateWrapper.loadAppReady;
                this.L$0 = mutex;
                this.L$1 = reactActivityDelegateWrapper;
                this.label = 2;
                if (completableDeferred.await(this) != coroutine_suspended) {
                    mutex2 = mutex;
                    reactActivityDelegateWrapper2 = reactActivityDelegateWrapper;
                    it = reactActivityDelegateWrapper2.reactActivityLifecycleListeners.iterator();
                    while (it.hasNext()) {
                        ((ReactActivityLifecycleListener) it.next()).onDestroy(reactActivityDelegateWrapper2.activity);
                    }
                    if (reactActivityDelegateWrapper2.getDelayLoadAppHandler() != null) {
                        reactActivityDelegateWrapper2.getDelegate().onDestroy();
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        reactActivityDelegateWrapper2.getDelegate().onDestroy();
                    }
                    Unit unit4 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onDestroy() {
        BuildersKt__Builders_commonKt.launch$default(getApplicationCoroutineScope(), null, null, new C18761(null), 3, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onActivityResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onActivityResult$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {257}, m = "invokeSuspend", n = {}, s = {})
    static final class C18741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $data;
        final /* synthetic */ int $requestCode;
        final /* synthetic */ int $resultCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18741(int i, int i2, Intent intent, Continuation<? super C18741> continuation) {
            super(2, continuation);
            this.$requestCode = i;
            this.$resultCode = i2;
            this.$data = intent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C18741(this.$requestCode, this.$resultCode, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onActivityResult(this.$requestCode, this.$resultCode, this.$data);
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        launchLifecycleScopeWithLock$default(this, null, new C18741(requestCode, resultCode, data, null), 1, null);
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.loadAppReady.isCompleted()) {
            return false;
        }
        List<ReactActivityHandler> list = this.reactActivityHandlers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((ReactActivityHandler) it.next()).onKeyDown(keyCode, event)));
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                if (z || zBooleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onKeyDown(keyCode, event);
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.loadAppReady.isCompleted()) {
            return false;
        }
        List<ReactActivityHandler> list = this.reactActivityHandlers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((ReactActivityHandler) it.next()).onKeyUp(keyCode, event)));
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                if (z || zBooleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onKeyUp(keyCode, event);
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.loadAppReady.isCompleted()) {
            return false;
        }
        List<ReactActivityHandler> list = this.reactActivityHandlers;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((ReactActivityHandler) it.next()).onKeyLongPress(keyCode, event)));
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                if (z || zBooleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onKeyLongPress(keyCode, event);
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public boolean onBackPressed() {
        boolean z;
        if (!this.loadAppReady.isCompleted()) {
            return false;
        }
        List<ReactActivityLifecycleListener> list = this.reactActivityLifecycleListeners;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((ReactActivityLifecycleListener) it.next()).onBackPressed()));
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                if (z || zBooleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onBackPressed();
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public boolean onNewIntent(Intent intent) {
        boolean z;
        if (!this.loadAppReady.isCompleted()) {
            return false;
        }
        List<ReactActivityLifecycleListener> list = this.reactActivityLifecycleListeners;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((ReactActivityLifecycleListener) it.next()).onNewIntent(intent)));
        }
        Iterator it2 = arrayList.iterator();
        loop1: while (true) {
            z = false;
            while (true) {
                if (!it2.hasNext()) {
                    break loop1;
                }
                boolean zBooleanValue = ((Boolean) it2.next()).booleanValue();
                if (z || zBooleanValue) {
                    z = true;
                }
            }
        }
        return z || this.delegate.onNewIntent(intent);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onWindowFocusChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onWindowFocusChanged$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {319}, m = "invokeSuspend", n = {}, s = {})
    static final class C18811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $hasFocus;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18811(boolean z, Continuation<? super C18811> continuation) {
            super(2, continuation);
            this.$hasFocus = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C18811(this.$hasFocus, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onWindowFocusChanged(this.$hasFocus);
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onWindowFocusChanged(boolean hasFocus) {
        launchLifecycleScopeWithLock$default(this, null, new C18811(hasFocus, null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$requestPermissions$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$requestPermissions$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {326}, m = "invokeSuspend", n = {}, s = {})
    static final class C18821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PermissionListener $listener;
        final /* synthetic */ String[] $permissions;
        final /* synthetic */ int $requestCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18821(String[] strArr, int i, PermissionListener permissionListener, Continuation<? super C18821> continuation) {
            super(2, continuation);
            this.$permissions = strArr;
            this.$requestCode = i;
            this.$listener = permissionListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C18821(this.$permissions, this.$requestCode, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().requestPermissions(this.$permissions, this.$requestCode, this.$listener);
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void requestPermissions(String[] permissions, int requestCode, PermissionListener listener) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        launchLifecycleScopeWithLock$default(this, null, new C18821(permissions, requestCode, listener, null), 1, null);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onRequestPermissionsResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onRequestPermissionsResult$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
    static final class C18781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int[] $grantResults;
        final /* synthetic */ String[] $permissions;
        final /* synthetic */ int $requestCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18781(int i, String[] strArr, int[] iArr, Continuation<? super C18781> continuation) {
            super(2, continuation);
            this.$requestCode = i;
            this.$permissions = strArr;
            this.$grantResults = iArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C18781(this.$requestCode, this.$permissions, this.$grantResults, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onRequestPermissionsResult(this.$requestCode, this.$permissions, this.$grantResults);
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        launchLifecycleScopeWithLock$default(this, null, new C18781(requestCode, permissions, grantResults, null), 1, null);
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected Context getContext() {
        return (Context) invokeDelegateMethod("getContext");
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected Activity getPlainActivity() {
        return (Activity) invokeDelegateMethod("getPlainActivity");
    }

    @Override // com.facebook.react.ReactActivityDelegate
    /* JADX INFO: renamed from: isFabricEnabled */
    protected boolean getFabricEnabled() {
        return ((Boolean) invokeDelegateMethod("isFabricEnabled")).booleanValue();
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected boolean isWideColorGamutEnabled() {
        return ((Boolean) invokeDelegateMethod("isWideColorGamutEnabled")).booleanValue();
    }

    @Override // com.facebook.react.ReactActivityDelegate
    protected Bundle composeLaunchOptions() {
        return (Bundle) invokeDelegateMethod("composeLaunchOptions");
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$onConfigurationChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$onConfigurationChanged$1", f = "ReactActivityDelegateWrapper.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
    static final class C18751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Configuration $newConfig;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18751(Configuration configuration, Continuation<? super C18751> continuation) {
            super(2, continuation);
            this.$newConfig = configuration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ReactActivityDelegateWrapper.this.new C18751(this.$newConfig, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C18751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ReactActivityDelegateWrapper.this.loadAppReady.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ReactActivityDelegateWrapper.this.getDelegate().onConfigurationChanged(this.$newConfig);
            return Unit.INSTANCE;
        }
    }

    @Override // com.facebook.react.ReactActivityDelegate
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        launchLifecycleScopeWithLock$default(this, null, new C18751(newConfig, null), 1, null);
    }

    private final <T> T invokeDelegateMethod(String name) throws NoSuchMethodException {
        Method declaredMethod = this.methodMap.get(name);
        if (declaredMethod == null) {
            declaredMethod = ReactActivityDelegate.class.getDeclaredMethod(name, new Class[0]);
            declaredMethod.setAccessible(true);
            this.methodMap.put(name, declaredMethod);
        }
        Intrinsics.checkNotNull(declaredMethod);
        return (T) declaredMethod.invoke(this.delegate, new Object[0]);
    }

    public final <T, A> T invokeDelegateMethod$expo_release(String name, Class<?>[] argTypes, A[] args) throws NoSuchMethodException {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(argTypes, "argTypes");
        Intrinsics.checkNotNullParameter(args, "args");
        Method declaredMethod = this.methodMap.get(name);
        if (declaredMethod == null) {
            declaredMethod = ReactActivityDelegate.class.getDeclaredMethod(name, (Class[]) Arrays.copyOf(argTypes, argTypes.length));
            declaredMethod.setAccessible(true);
            this.methodMap.put(name, declaredMethod);
        }
        Intrinsics.checkNotNull(declaredMethod);
        return (T) declaredMethod.invoke(this.delegate, Arrays.copyOf(args, args.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object loadAppImpl(String str, boolean z, Continuation<? super Unit> continuation) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        C18731 c18731;
        if (continuation instanceof C18731) {
            c18731 = (C18731) continuation;
            if ((c18731.label & Integer.MIN_VALUE) != 0) {
                c18731.label -= Integer.MIN_VALUE;
            } else {
                c18731 = new C18731(continuation);
            }
        } else {
            c18731 = new C18731(continuation);
        }
        Object obj = c18731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18731.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ViewGroup viewGroup = (ViewGroup) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactActivityHandlers), new Function1() { // from class: expo.modules.ReactActivityDelegateWrapper$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ReactActivityDelegateWrapper.loadAppImpl$lambda$18(this.f$0, (ReactActivityHandler) obj2);
                }
            }));
            if (viewGroup != null) {
                Field declaredField = ReactActivityDelegate.class.getDeclaredField("mReactDelegate");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(this.delegate);
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.facebook.react.ReactDelegate");
                ReactDelegate reactDelegate = (ReactDelegate) obj2;
                if (str != null) {
                    reactDelegate.loadApp(str);
                    ReactRootView reactRootView = reactDelegate.getReactRootView();
                    ViewParent parent = reactRootView != null ? reactRootView.getParent() : null;
                    ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(reactRootView);
                    }
                    viewGroup.addView(reactRootView, -1);
                    this.activity.setContentView(viewGroup);
                    Iterator<T> it = this.reactActivityLifecycleListeners.iterator();
                    while (it.hasNext()) {
                        ((ReactActivityLifecycleListener) it.next()).onContentChanged(this.activity);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            if (z) {
                ReactActivityHandler.DelayLoadAppHandler delayLoadAppHandler = getDelayLoadAppHandler();
                c18731.L$0 = str;
                c18731.label = 1;
                if (awaitDelayLoadAppWhenReady(delayLoadAppHandler, c18731) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                invokeDelegateMethod$expo_release("loadApp", new Class[]{String.class}, new String[]{str});
                Iterator<T> it2 = this.reactActivityLifecycleListeners.iterator();
                while (it2.hasNext()) {
                    ((ReactActivityLifecycleListener) it2.next()).onContentChanged(this.activity);
                }
                return Unit.INSTANCE;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) c18731.L$0;
            ResultKt.throwOnFailure(obj);
        }
        invokeDelegateMethod$expo_release("loadApp", new Class[]{String.class}, new String[]{str});
        Iterator<T> it3 = this.reactActivityLifecycleListeners.iterator();
        while (it3.hasNext()) {
            ((ReactActivityLifecycleListener) it3.next()).onContentChanged(this.activity);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewGroup loadAppImpl$lambda$18(ReactActivityDelegateWrapper reactActivityDelegateWrapper, ReactActivityHandler reactActivityHandler) {
        return reactActivityHandler.createReactRootViewContainer(reactActivityDelegateWrapper.activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitDelayLoadAppWhenReady(ReactActivityHandler.DelayLoadAppHandler delayLoadAppHandler, Continuation<? super Unit> continuation) {
        if (delayLoadAppHandler == null) {
            return Unit.INSTANCE;
        }
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        delayLoadAppHandler.whenReady(new Runnable() { // from class: expo.modules.ReactActivityDelegateWrapper$awaitDelayLoadAppWhenReady$2$1
            @Override // java.lang.Runnable
            public final void run() throws Exceptions.IncorrectThreadException {
                Utils utils = Utils.INSTANCE;
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    Continuation<Unit> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m14780constructorimpl(Unit.INSTANCE));
                } else {
                    String name = Thread.currentThread().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String name2 = Looper.getMainLooper().getThread().getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    throw new Exceptions.IncorrectThreadException(name, name2);
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? orThrow : Unit.INSTANCE;
    }

    static /* synthetic */ void launchLifecycleScopeWithLock$default(ReactActivityDelegateWrapper reactActivityDelegateWrapper, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        reactActivityDelegateWrapper.launchLifecycleScopeWithLock(coroutineStart, function2);
    }

    /* JADX INFO: renamed from: expo.modules.ReactActivityDelegateWrapper$launchLifecycleScopeWithLock$1, reason: invalid class name */
    /* JADX INFO: compiled from: ReactActivityDelegateWrapper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ReactActivityDelegateWrapper$launchLifecycleScopeWithLock$1", f = "ReactActivityDelegateWrapper.kt", i = {0, 0, 1}, l = {478, 452}, m = "invokeSuspend", n = {"$this$launch", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ReactActivityDelegateWrapper.this.new AnonymousClass1(this.$block, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CoroutineScope coroutineScope;
            Mutex mutex;
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2;
            Throwable th;
            Mutex mutex2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineScope = (CoroutineScope) this.L$0;
                    mutex = ReactActivityDelegateWrapper.this.mutex;
                    function2 = this.$block;
                    this.L$0 = coroutineScope;
                    this.L$1 = mutex;
                    this.L$2 = function2;
                    this.label = 1;
                    if (mutex.lock(null, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutex2 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        Unit unit = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        mutex2.unlock(null);
                        throw th;
                    }
                }
                function2 = (Function2) this.L$2;
                Mutex mutex3 = (Mutex) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutex = mutex3;
                this.L$0 = mutex;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (function2.invoke(coroutineScope, this) != coroutine_suspended) {
                    mutex2 = mutex;
                    Unit unit2 = Unit.INSTANCE;
                    mutex2.unlock(null);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                Mutex mutex4 = mutex;
                th = th3;
                mutex2 = mutex4;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    private final void launchLifecycleScopeWithLock(CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.activity), null, start, new AnonymousClass1(block, null), 1, null);
    }

    public final void setLoadAppReadyForTesting$expo_release() {
        this.loadAppReady.complete(Unit.INSTANCE);
    }
}
