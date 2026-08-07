package expo.modules.kotlin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.core.errors.ContextDestroyedException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.logging.Logger;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.activityresult.ActivityResultsManager;
import expo.modules.kotlin.activityresult.DefaultAppContextActivityResultCaller;
import expo.modules.kotlin.defaultmodules.JSLoggerModule;
import expo.modules.kotlin.defaultmodules.NativeModulesProxyModule;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.KEventEmitterWrapper;
import expo.modules.kotlin.events.KModuleEventEmitterWrapper;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import expo.modules.kotlin.runtime.MainRuntime;
import expo.modules.kotlin.runtime.WorkletRuntime;
import expo.modules.kotlin.services.AppDirectoriesService;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.services.Service;
import expo.modules.kotlin.services.ServicesRegistry;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: compiled from: AppContext.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010=\u001a\u00020>J\b\u0010?\u001a\u00020>H\u0002J\u0006\u0010@\u001a\u00020>J\u0018\u0010A\u001a\u0004\u0018\u0001HB\"\u0006\b\u0000\u0010B\u0018\u0001H\u0086\b¢\u0006\u0002\u0010CJ\u001c\u0010D\u001a\u0004\u0018\u0001HE\"\n\b\u0000\u0010E\u0018\u0001*\u00020FH\u0086\b¢\u0006\u0002\u0010GJ%\u0010D\u001a\u0004\u0018\u0001HE\"\b\b\u0000\u0010E*\u00020F2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HE0I¢\u0006\u0002\u0010JJ\u0010\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010j\u001a\u00020kJ\r\u0010|\u001a\u00020>H\u0000¢\u0006\u0002\b}J\r\u0010~\u001a\u00020>H\u0000¢\u0006\u0002\b\u007fJ\u000f\u0010\u0080\u0001\u001a\u00020>H\u0000¢\u0006\u0003\b\u0081\u0001J\u000f\u0010\u0082\u0001\u001a\u00020>H\u0000¢\u0006\u0003\b\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020>H\u0000¢\u0006\u0003\b\u0085\u0001J9\u0010\u0086\u0001\u001a\u00020>2\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u008a\u00012\b\u0010\u008b\u0001\u001a\u00030\u008a\u00012\n\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0000¢\u0006\u0003\b\u008e\u0001J\u001b\u0010\u008f\u0001\u001a\u00020>2\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008d\u0001H\u0000¢\u0006\u0003\b\u0091\u0001J&\u0010\u0092\u0001\u001a\u0004\u0018\u0001HE\"\t\b\u0000\u0010E*\u00030\u0093\u00012\b\u0010\u0094\u0001\u001a\u00030\u008a\u0001H\u0007¢\u0006\u0003\u0010\u0095\u0001J\u001f\u0010\u0096\u0001\u001a\u00020>2\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020>0\u0098\u0001H\u0000¢\u0006\u0003\b\u0099\u0001J\u000f\u0010\u009a\u0001\u001a\u00020>H\u0000¢\u0006\u0003\b\u009b\u0001J\u0013\u0010\u009c\u0001\u001a\u00020>2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010'\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\"\u00101\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020:X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0011\u0010K\u001a\u00020L8F¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020P8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0011\u0010S\u001a\u00020T8F¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0011\u0010W\u001a\u00020T8F¢\u0006\u0006\u001a\u0004\bX\u0010VR\u0013\u0010Y\u001a\u0004\u0018\u00010Z8F¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0013\u0010]\u001a\u0004\u0018\u00010^8F¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0013\u0010a\u001a\u0004\u0018\u00010b8F¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0011\u0010e\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0016\u0010l\u001a\u0004\u0018\u00010i8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR)\u0010o\u001a\n\u0018\u00010pj\u0004\u0018\u0001`q8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bu\u0010v\u0012\u0004\br\u0010\u0010\u001a\u0004\bs\u0010tR\u001d\u0010w\u001a\u0004\u0018\u00010x8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010v\u001a\u0004\by\u0010zR\u001a\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0088\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001R\u0015\u0010¢\u0001\u001a\u00030\u0088\u00018F¢\u0006\b\u001a\u0006\b£\u0001\u0010¡\u0001¨\u0006¤\u0001"}, d2 = {"Lexpo/modules/kotlin/AppContext;", "Lexpo/modules/kotlin/providers/CurrentActivityProvider;", "modulesProvider", "Lexpo/modules/kotlin/ModulesProvider;", "legacyModuleRegistry", "Lexpo/modules/core/ModuleRegistry;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lexpo/modules/kotlin/ModulesProvider;Lexpo/modules/core/ModuleRegistry;Ljava/lang/ref/WeakReference;)V", "getLegacyModuleRegistry", "()Lexpo/modules/core/ModuleRegistry;", "hostingRuntimeContext", "Lexpo/modules/kotlin/runtime/MainRuntime;", "getHostingRuntimeContext$annotations", "()V", "getHostingRuntimeContext", "()Lexpo/modules/kotlin/runtime/MainRuntime;", "runtime", "getRuntime", "uiRuntimeHolder", "Lkotlin/Lazy;", "Lexpo/modules/kotlin/runtime/WorkletRuntime;", "uiRuntime", "getUiRuntime", "()Lexpo/modules/kotlin/runtime/WorkletRuntime;", "reactLifecycleDelegate", "Lexpo/modules/kotlin/ReactLifecycleDelegate;", "hostWasDestroyed", "", "modulesQueueDispatcher", "Lkotlinx/coroutines/android/HandlerDispatcher;", "backgroundCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getBackgroundCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "modulesQueue", "getModulesQueue", "mainQueue", "getMainQueue", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "services", "Lexpo/modules/kotlin/services/ServicesRegistry;", "getServices", "()Lexpo/modules/kotlin/services/ServicesRegistry;", "legacyModulesProxyHolder", "Lexpo/modules/adapters/react/NativeModulesProxy;", "getLegacyModulesProxyHolder$expo_modules_core_release", "()Ljava/lang/ref/WeakReference;", "setLegacyModulesProxyHolder$expo_modules_core_release", "(Ljava/lang/ref/WeakReference;)V", "activityResultsManager", "Lexpo/modules/kotlin/activityresult/ActivityResultsManager;", "appContextActivityResultCaller", "Lexpo/modules/kotlin/activityresult/DefaultAppContextActivityResultCaller;", "getAppContextActivityResultCaller$expo_modules_core_release", "()Lexpo/modules/kotlin/activityresult/DefaultAppContextActivityResultCaller;", "onCreate", "", "registerInlineModulesList", "installJSIInterop", "legacyModule", "Module", "()Ljava/lang/Object;", NotificationCompat.CATEGORY_SERVICE, ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/services/Service;", "()Lexpo/modules/kotlin/services/Service;", "serviceClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lexpo/modules/kotlin/services/Service;", "filePermission", "Lexpo/modules/kotlin/services/FilePermissionService;", "getFilePermission", "()Lexpo/modules/kotlin/services/FilePermissionService;", "appDirectories", "Lexpo/modules/kotlin/services/AppDirectoriesService;", "getAppDirectories", "()Lexpo/modules/kotlin/services/AppDirectoriesService;", "persistentFilesDirectory", "Ljava/io/File;", "getPersistentFilesDirectory", "()Ljava/io/File;", "cacheDirectory", "getCacheDirectory", "permissions", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissions", "()Lexpo/modules/interfaces/permissions/Permissions;", "activityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "getActivityProvider", "()Lexpo/modules/core/interfaces/ActivityProvider;", "reactContext", "Landroid/content/Context;", "getReactContext", "()Landroid/content/Context;", "hasActiveReactInstance", "getHasActiveReactInstance", "()Z", "eventEmitter", "Lexpo/modules/kotlin/events/EventEmitter;", "module", "Lexpo/modules/kotlin/modules/Module;", "callbackInvoker", "getCallbackInvoker$expo_modules_core_release", "()Lexpo/modules/kotlin/events/EventEmitter;", "errorManager", "Lexpo/modules/kotlin/defaultmodules/JSLoggerModule;", "Lexpo/modules/kotlin/defaultmodules/ErrorManagerModule;", "getErrorManager$annotations", "getErrorManager", "()Lexpo/modules/kotlin/defaultmodules/JSLoggerModule;", "errorManager$delegate", "Lkotlin/Lazy;", "jsLogger", "Lexpo/modules/core/logging/Logger;", "getJsLogger", "()Lexpo/modules/core/logging/Logger;", "jsLogger$delegate", "onDestroy", "onDestroy$expo_modules_core_release", "onHostResume", "onHostResume$expo_modules_core_release", "onHostPause", "onHostPause$expo_modules_core_release", "onUserLeaveHint", "onUserLeaveHint$expo_modules_core_release", "onHostDestroy", "onHostDestroy$expo_modules_core_release", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onActivityResult$expo_modules_core_release", "onNewIntent", "intent", "onNewIntent$expo_modules_core_release", "findView", "Landroid/view/View;", "viewTag", "(I)Landroid/view/View;", "dispatchOnMainUsingUIManager", "block", "Lkotlin/Function0;", "dispatchOnMainUsingUIManager$expo_modules_core_release", "assertMainThread", "assertMainThread$expo_modules_core_release", "executeOnJavaScriptThread", "runnable", "Ljava/lang/Runnable;", "currentActivity", "getCurrentActivity", "()Landroid/app/Activity;", "throwingActivity", "getThrowingActivity", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppContext implements CurrentActivityProvider {
    public static final int $stable = 8;
    private final ActivityResultsManager activityResultsManager;
    private final DefaultAppContextActivityResultCaller appContextActivityResultCaller;
    private final CoroutineScope backgroundCoroutineScope;

    /* JADX INFO: renamed from: errorManager$delegate, reason: from kotlin metadata */
    private final Lazy errorManager;
    private boolean hostWasDestroyed;
    private final MainRuntime hostingRuntimeContext;

    /* JADX INFO: renamed from: jsLogger$delegate, reason: from kotlin metadata */
    private final Lazy jsLogger;
    private final expo.modules.core.ModuleRegistry legacyModuleRegistry;
    private WeakReference<NativeModulesProxy> legacyModulesProxyHolder;
    private final CoroutineScope mainQueue;
    private final CoroutineScope modulesQueue;
    private final HandlerDispatcher modulesQueueDispatcher;
    private final ReactLifecycleDelegate reactLifecycleDelegate;
    private final ModuleRegistry registry;
    private final ServicesRegistry services;
    private final Lazy<WorkletRuntime> uiRuntimeHolder;

    @Deprecated(message = "Use AppContext.jsLogger instead")
    public static /* synthetic */ void getErrorManager$annotations() {
    }

    @Deprecated(message = "Use AppContext.runtimeContext instead", replaceWith = @ReplaceWith(expression = "runtime", imports = {}))
    public static /* synthetic */ void getHostingRuntimeContext$annotations() {
    }

    public AppContext(ModulesProvider modulesProvider, expo.modules.core.ModuleRegistry legacyModuleRegistry, final WeakReference<ReactApplicationContext> reactContextHolder) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(legacyModuleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.legacyModuleRegistry = legacyModuleRegistry;
        this.hostingRuntimeContext = new MainRuntime(this, reactContextHolder);
        this.uiRuntimeHolder = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppContext.uiRuntimeHolder$lambda$0(this.f$0, reactContextHolder);
            }
        });
        ReactLifecycleDelegate reactLifecycleDelegate = new ReactLifecycleDelegate(this);
        this.reactLifecycleDelegate = reactLifecycleDelegate;
        HandlerThread handlerThread = new HandlerThread("expo.modules.AsyncFunctionQueue");
        handlerThread.start();
        HandlerDispatcher handlerDispatcherFrom$default = HandlerDispatcherKt.from$default(new Handler(handlerThread.getLooper()), null, 1, null);
        this.modulesQueueDispatcher = handlerDispatcherFrom$default;
        this.backgroundCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.BackgroundCoroutineScope")));
        this.modulesQueue = CoroutineScopeKt.CoroutineScope(handlerDispatcherFrom$default.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.AsyncFunctionQueue")));
        this.mainQueue = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.MainQueue")));
        ModuleRegistry moduleRegistry = new ModuleRegistry(UtilsKt.weak(this));
        this.registry = moduleRegistry;
        ServicesRegistry servicesRegistry = new ServicesRegistry(UtilsKt.weak(this));
        this.services = servicesRegistry;
        ActivityResultsManager activityResultsManager = new ActivityResultsManager(this);
        this.activityResultsManager = activityResultsManager;
        this.appContextActivityResultCaller = new DefaultAppContextActivityResultCaller(activityResultsManager);
        ReactApplicationContext reactApplicationContext = reactContextHolder.get();
        if (reactApplicationContext == null) {
            throw new IllegalArgumentException("The app context should be created with valid react context.".toString());
        }
        ReactApplicationContext reactApplicationContext2 = reactApplicationContext;
        legacyModuleRegistry.setAppContext(this);
        reactApplicationContext2.addLifecycleEventListener(reactLifecycleDelegate);
        reactApplicationContext2.addActivityEventListener(reactLifecycleDelegate);
        servicesRegistry.register(FilePermissionService.class);
        servicesRegistry.register(AppDirectoriesService.class);
        servicesRegistry.register(modulesProvider.getServices());
        moduleRegistry.register(new NativeModulesProxyModule(), null);
        moduleRegistry.register(new JSLoggerModule(), null);
        moduleRegistry.register(modulesProvider);
        registerInlineModulesList();
        CoreLoggerKt.getLogger().info("✅ AppContext was initialized");
        this.errorManager = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppContext.errorManager_delegate$lambda$7(this.f$0);
            }
        });
        this.jsLogger = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppContext.jsLogger_delegate$lambda$8(this.f$0);
            }
        });
    }

    public final expo.modules.core.ModuleRegistry getLegacyModuleRegistry() {
        return this.legacyModuleRegistry;
    }

    public final MainRuntime getHostingRuntimeContext() {
        return this.hostingRuntimeContext;
    }

    public final MainRuntime getRuntime() {
        return this.hostingRuntimeContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkletRuntime uiRuntimeHolder$lambda$0(AppContext appContext, WeakReference weakReference) {
        return new WorkletRuntime(appContext, weakReference);
    }

    public final WorkletRuntime getUiRuntime() {
        return this.uiRuntimeHolder.getValue();
    }

    public final CoroutineScope getBackgroundCoroutineScope() {
        return this.backgroundCoroutineScope;
    }

    public final CoroutineScope getModulesQueue() {
        return this.modulesQueue;
    }

    public final CoroutineScope getMainQueue() {
        return this.mainQueue;
    }

    public final ModuleRegistry getRegistry() {
        return this.registry;
    }

    public final ServicesRegistry getServices() {
        return this.services;
    }

    public final WeakReference<NativeModulesProxy> getLegacyModulesProxyHolder$expo_modules_core_release() {
        return this.legacyModulesProxyHolder;
    }

    public final void setLegacyModulesProxyHolder$expo_modules_core_release(WeakReference<NativeModulesProxy> weakReference) {
        this.legacyModulesProxyHolder = weakReference;
    }

    /* JADX INFO: renamed from: getAppContextActivityResultCaller$expo_modules_core_release, reason: from getter */
    public final DefaultAppContextActivityResultCaller getAppContextActivityResultCaller() {
        return this.appContextActivityResultCaller;
    }

    private final void registerInlineModulesList() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        try {
            Object objNewInstance = Class.forName("inline.modules.ExpoInlineModulesList").getConstructor(new Class[0]).newInstance(new Object[0]);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type expo.modules.kotlin.ModulesProvider");
            this.registry.register((ModulesProvider) objNewInstance);
        } catch (ClassNotFoundException unused) {
        }
    }

    public final void installJSIInterop() {
        getRuntime().install$expo_modules_core_release();
    }

    public final /* synthetic */ <Module> Module legacyModule() {
        try {
            expo.modules.core.ModuleRegistry legacyModuleRegistry = getLegacyModuleRegistry();
            Intrinsics.reifiedOperationMarker(4, "Module");
            return (Module) legacyModuleRegistry.getModule(Object.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final /* synthetic */ <T extends Service> T service() {
        Map<Class<? extends Service>, Service> registry = getServices().getRegistry();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Service service = registry.get(Service.class);
        Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) service;
    }

    public final <T extends Service> T service(Class<T> serviceClass) {
        Intrinsics.checkNotNullParameter(serviceClass, "serviceClass");
        Service service = this.services.getRegistry().get(serviceClass);
        if (service instanceof Service) {
            return (T) service;
        }
        return null;
    }

    public final File getPersistentFilesDirectory() {
        return getAppDirectories().getPersistentFilesDirectory();
    }

    public final File getCacheDirectory() {
        return getAppDirectories().getCacheDirectory();
    }

    public final Context getReactContext() {
        return getRuntime().getReactContext();
    }

    public final boolean getHasActiveReactInstance() {
        ReactApplicationContext reactContext = getRuntime().getReactContext();
        return reactContext != null && reactContext.hasActiveReactInstance();
    }

    public final JSLoggerModule getErrorManager() {
        return (JSLoggerModule) this.errorManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSLoggerModule errorManager_delegate$lambda$7(AppContext appContext) {
        Object next;
        Module module;
        Iterator<T> it = appContext.registry.getRegistry().values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            module = ((ModuleHolder) next).getModule();
        } while (!(module != null ? module instanceof JSLoggerModule : true));
        ModuleHolder moduleHolder = (ModuleHolder) next;
        Module module2 = moduleHolder != null ? moduleHolder.getModule() : null;
        return (JSLoggerModule) (module2 instanceof JSLoggerModule ? module2 : null);
    }

    public final Logger getJsLogger() {
        return (Logger) this.jsLogger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Logger jsLogger_delegate$lambda$8(AppContext appContext) {
        Object next;
        Iterator<T> it = appContext.registry.getRegistry().values().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((ModuleHolder) next).getModule() instanceof JSLoggerModule));
        ModuleHolder moduleHolder = (ModuleHolder) next;
        Module module = moduleHolder != null ? moduleHolder.getModule() : null;
        if (!(module instanceof JSLoggerModule)) {
            module = null;
        }
        JSLoggerModule jSLoggerModule = (JSLoggerModule) module;
        if (jSLoggerModule != null) {
            return jSLoggerModule.getLogger();
        }
        return null;
    }

    public final void onHostResume$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        if (!(currentActivity instanceof AppCompatActivity)) {
            Activity currentActivity2 = getCurrentActivity();
            throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + (currentActivity2 != null ? currentActivity2.getLocalClassName() : null)).toString());
        }
        if (this.hostWasDestroyed) {
            this.hostWasDestroyed = false;
            this.registry.registerActivityContracts$expo_modules_core_release();
        }
        this.activityResultsManager.onHostResume((AppCompatActivity) currentActivity);
        this.registry.post(EventName.ACTIVITY_ENTERS_FOREGROUND);
    }

    public final void onHostPause$expo_modules_core_release() {
        this.registry.post(EventName.ACTIVITY_ENTERS_BACKGROUND);
    }

    public final void onUserLeaveHint$expo_modules_core_release() {
        this.registry.post(EventName.ON_USER_LEAVES_ACTIVITY);
    }

    public final void onHostDestroy$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if (!(currentActivity instanceof AppCompatActivity)) {
                Activity currentActivity2 = getCurrentActivity();
                throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + (currentActivity2 != null ? currentActivity2.getLocalClassName() : null)).toString());
            }
            this.activityResultsManager.onHostDestroy((AppCompatActivity) currentActivity);
        }
        this.registry.post(EventName.ACTIVITY_DESTROYS);
        this.hostWasDestroyed = true;
    }

    public final void onActivityResult$expo_modules_core_release(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityResultsManager.onActivityResult(requestCode, resultCode, data);
        this.registry.post(EventName.ON_ACTIVITY_RESULT, activity, new OnActivityResultPayload(requestCode, resultCode, data));
    }

    public final void onNewIntent$expo_modules_core_release(Intent intent) {
        this.registry.post(EventName.ON_NEW_INTENT, intent);
    }

    public final <T extends View> T findView(int viewTag) {
        ReactApplicationContext reactContext = getRuntime().getReactContext();
        if (reactContext == null) {
            return null;
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactContext, viewTag);
        T t = uIManagerForReactTag != null ? (T) uIManagerForReactTag.resolveView(viewTag) : null;
        if (t instanceof View) {
            return t;
        }
        return null;
    }

    public final void dispatchOnMainUsingUIManager$expo_modules_core_release(final Function0<Unit> block) throws Exceptions.ReactContextLost {
        Intrinsics.checkNotNullParameter(block, "block");
        ReactApplicationContext reactContext = getRuntime().getReactContext();
        if (reactContext == null) {
            throw new Exceptions.ReactContextLost();
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactContext, 1);
        Intrinsics.checkNotNull(uIManagerForReactTag, "null cannot be cast to non-null type com.facebook.react.uimanager.UIManagerModule");
        ((UIManagerModule) uIManagerForReactTag).addUIBlock(new UIBlock() { // from class: expo.modules.kotlin.AppContext$$ExternalSyntheticLambda3
            @Override // com.facebook.react.uimanager.UIBlock
            public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                AppContext.dispatchOnMainUsingUIManager$lambda$15(block, nativeViewHierarchyManager);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchOnMainUsingUIManager$lambda$15(Function0 function0, NativeViewHierarchyManager it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
    }

    public final void assertMainThread$expo_modules_core_release() throws Exceptions.IncorrectThreadException {
        Utils utils = Utils.INSTANCE;
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return;
        }
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String name2 = Looper.getMainLooper().getThread().getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        throw new Exceptions.IncorrectThreadException(name, name2);
    }

    @Deprecated(message = "Use RuntimeContext.schedule instead", replaceWith = @ReplaceWith(expression = "runtime.schedule(runnable)", imports = {}))
    public final void executeOnJavaScriptThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ReactApplicationContext reactContext = getRuntime().getReactContext();
        if (reactContext != null) {
            reactContext.runOnJSQueueThread(runnable);
        }
    }

    @Override // expo.modules.kotlin.providers.CurrentActivityProvider
    public Activity getCurrentActivity() {
        Activity currentActivity;
        ActivityProvider activityProvider = getActivityProvider();
        if (activityProvider != null && (currentActivity = activityProvider.getCurrentActivity()) != null) {
            return currentActivity;
        }
        Context reactContext = getReactContext();
        ReactApplicationContext reactApplicationContext = reactContext instanceof ReactApplicationContext ? (ReactApplicationContext) reactContext : null;
        if (reactApplicationContext != null) {
            return reactApplicationContext.getCurrentActivity();
        }
        return null;
    }

    public final Activity getThrowingActivity() throws Exceptions.MissingActivity {
        Activity currentActivity;
        ActivityProvider activityProvider = getActivityProvider();
        if (activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null) {
            Context reactContext = getReactContext();
            ReactApplicationContext reactApplicationContext = reactContext instanceof ReactApplicationContext ? (ReactApplicationContext) reactContext : null;
            currentActivity = reactApplicationContext != null ? reactApplicationContext.getCurrentActivity() : null;
        }
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    public final void onCreate() {
        Trace.beginSection("[ExpoModulesCore] AppContext.onCreate");
        try {
            getRegistry().postOnCreate();
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final FilePermissionService getFilePermission() {
        Service service = getServices().getRegistry().get(FilePermissionService.class);
        if (!(service instanceof FilePermissionService)) {
            service = null;
        }
        FilePermissionService filePermissionService = (FilePermissionService) service;
        if (filePermissionService != null) {
            return filePermissionService;
        }
        throw new IllegalStateException("FilePermissionService is not registered in the ServicesRegistry.");
    }

    private final AppDirectoriesService getAppDirectories() {
        Service service = getServices().getRegistry().get(AppDirectoriesService.class);
        if (!(service instanceof AppDirectoriesService)) {
            service = null;
        }
        AppDirectoriesService appDirectoriesService = (AppDirectoriesService) service;
        if (appDirectoriesService != null) {
            return appDirectoriesService;
        }
        throw new IllegalStateException("AppDirectoriesService is not registered in the ServicesRegistry.");
    }

    public final Permissions getPermissions() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(Permissions.class);
        } catch (Exception unused) {
            module = null;
        }
        return (Permissions) module;
    }

    public final ActivityProvider getActivityProvider() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(ActivityProvider.class);
        } catch (Exception unused) {
            module = null;
        }
        return (ActivityProvider) module;
    }

    public final EventEmitter eventEmitter(Module module) {
        Object module2;
        Intrinsics.checkNotNullParameter(module, "module");
        try {
            module2 = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            module2 = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) module2;
        if (eventEmitter == null) {
            return null;
        }
        ModuleHolder moduleHolder = this.registry.getModuleHolder(module);
        if (moduleHolder != null) {
            return new KModuleEventEmitterWrapper(moduleHolder, eventEmitter, getRuntime().getReactContextHolder());
        }
        throw new IllegalArgumentException(("Cannot create an event emitter for module " + module.getClass() + " that isn't present in the module registry. Available modules: [" + CollectionsKt.joinToString$default(this.registry.getRegistry().keySet(), ", ", null, null, 0, null, null, 62, null) + "].").toString());
    }

    public final EventEmitter getCallbackInvoker$expo_modules_core_release() {
        Object module;
        try {
            module = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            module = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) module;
        if (eventEmitter == null) {
            return null;
        }
        return new KEventEmitterWrapper(eventEmitter, getRuntime().getReactContextHolder());
    }

    public final void onDestroy$expo_modules_core_release() {
        Trace.beginSection("[ExpoModulesCore] AppContext.onDestroy");
        try {
            ReactApplicationContext reactContext = getRuntime().getReactContext();
            if (reactContext != null) {
                reactContext.removeLifecycleEventListener(this.reactLifecycleDelegate);
                reactContext.removeActivityEventListener(this.reactLifecycleDelegate);
            }
            ModuleRegistry registry = getRegistry();
            registry.post(EventName.MODULE_DESTROY);
            registry.cleanUp();
            CoroutineScopeKt.cancel(getModulesQueue(), new ContextDestroyedException(null, 1, null));
            CoroutineScopeKt.cancel(getMainQueue(), new ContextDestroyedException(null, 1, null));
            CoroutineScopeKt.cancel(getBackgroundCoroutineScope(), new ContextDestroyedException(null, 1, null));
            getRuntime().deallocate$expo_modules_core_release();
            if (this.uiRuntimeHolder.isInitialized()) {
                getUiRuntime().deallocate$expo_modules_core_release();
            }
            CoreLoggerKt.getLogger().info("✅ AppContext was destroyed");
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
