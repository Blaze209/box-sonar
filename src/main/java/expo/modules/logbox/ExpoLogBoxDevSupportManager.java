package expo.modules.logbox;

import android.content.Context;
import com.facebook.fbreact.specs.NativeRedBoxSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.ReactInstanceDevHelper;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.packagerconnection.RequestHandler;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoLogBoxDevSupportManager.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\"H\u0016J$\u0010#\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u000fH\u0016J%\u0010'\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002¢\u0006\u0002\u0010+R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lexpo/modules/logbox/ExpoLogBoxDevSupportManager;", "Lexpo/modules/logbox/ExpoBridgelessDevSupportManager;", "applicationContext", "Landroid/content/Context;", "reactInstanceManagerHelper", "Lcom/facebook/react/devsupport/ReactInstanceDevHelper;", "packagerPathForJSBundleName", "", "enableOnCreate", "", "redBoxHandler", "Lcom/facebook/react/devsupport/interfaces/RedBoxHandler;", "devBundleDownloadListener", "Lcom/facebook/react/devsupport/interfaces/DevBundleDownloadListener;", "minNumShakes", "", "customPackagerCommandHandlers", "", "Lcom/facebook/react/packagerconnection/RequestHandler;", "surfaceDelegateFactory", "Lcom/facebook/react/common/SurfaceDelegateFactory;", "devLoadingViewManager", "Lcom/facebook/react/devsupport/interfaces/DevLoadingViewManager;", "pausedInDebuggerOverlayManager", "Lcom/facebook/react/devsupport/interfaces/PausedInDebuggerOverlayManager;", "<init>", "(Landroid/content/Context;Lcom/facebook/react/devsupport/ReactInstanceDevHelper;Ljava/lang/String;ZLcom/facebook/react/devsupport/interfaces/RedBoxHandler;Lcom/facebook/react/devsupport/interfaces/DevBundleDownloadListener;ILjava/util/Map;Lcom/facebook/react/common/SurfaceDelegateFactory;Lcom/facebook/react/devsupport/interfaces/DevLoadingViewManager;Lcom/facebook/react/devsupport/interfaces/PausedInDebuggerOverlayManager;)V", "redBoxSurfaceDelegate", "Lcom/facebook/react/common/SurfaceDelegate;", "hideRedboxDialog", "", "showNewJavaError", "message", "e", "", "showNewJSError", "details", "Lcom/facebook/react/bridge/ReadableArray;", "errorCookie", "showNewError", StackTraceHelper.STACK_KEY, "", "Lcom/facebook/react/devsupport/interfaces/StackFrame;", "(Ljava/lang/String;[Lcom/facebook/react/devsupport/interfaces/StackFrame;)V", "expo-log-box_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoLogBoxDevSupportManager extends ExpoBridgelessDevSupportManager {
    private SurfaceDelegate redBoxSurfaceDelegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpoLogBoxDevSupportManager(Context applicationContext, ReactInstanceDevHelper reactInstanceManagerHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map<String, ? extends RequestHandler> map, SurfaceDelegateFactory surfaceDelegateFactory, DevLoadingViewManager devLoadingViewManager, PausedInDebuggerOverlayManager pausedInDebuggerOverlayManager) {
        super(applicationContext, reactInstanceManagerHelper, str, z, redBoxHandler, devBundleDownloadListener, i, map, surfaceDelegateFactory, devLoadingViewManager, pausedInDebuggerOverlayManager);
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(reactInstanceManagerHelper, "reactInstanceManagerHelper");
    }

    @Override // com.facebook.react.devsupport.DevSupportManagerBase, com.facebook.react.devsupport.interfaces.DevSupportManager
    public void hideRedboxDialog() {
        SurfaceDelegate surfaceDelegate = this.redBoxSurfaceDelegate;
        if (surfaceDelegate != null) {
            surfaceDelegate.hide();
        }
    }

    @Override // com.facebook.react.devsupport.DevSupportManagerBase, com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showNewJavaError(String message, Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        showNewError(message, StackTraceHelper.convertJavaStackTrace(e));
    }

    @Override // com.facebook.react.devsupport.DevSupportManagerBase, com.facebook.react.devsupport.interfaces.DevSupportManager
    public void showNewJSError(String message, ReadableArray details, int errorCookie) {
        showNewError(message, StackTraceHelper.convertJsStackTrace(details));
    }

    private final void showNewError(final String message, final StackFrame[] stack) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: expo.modules.logbox.ExpoLogBoxDevSupportManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExpoLogBoxDevSupportManager.showNewError$lambda$1(this.f$0, message, stack);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showNewError$lambda$1(ExpoLogBoxDevSupportManager expoLogBoxDevSupportManager, String str, StackFrame[] stackFrameArr) {
        SurfaceDelegate surfaceDelegate;
        expoLogBoxDevSupportManager.setLastErrorTitle(str);
        expoLogBoxDevSupportManager.setLastErrorStack(stackFrameArr);
        if (expoLogBoxDevSupportManager.redBoxSurfaceDelegate == null) {
            ExpoLogBoxSurfaceDelegate expoLogBoxSurfaceDelegateCreateSurfaceDelegate = expoLogBoxDevSupportManager.createSurfaceDelegate(NativeRedBoxSpec.NAME);
            if (expoLogBoxSurfaceDelegateCreateSurfaceDelegate == null) {
                ExpoLogBoxSurfaceDelegate expoLogBoxSurfaceDelegate = new ExpoLogBoxSurfaceDelegate(expoLogBoxDevSupportManager);
                expoLogBoxSurfaceDelegate.createContentView(NativeRedBoxSpec.NAME);
                expoLogBoxSurfaceDelegateCreateSurfaceDelegate = expoLogBoxSurfaceDelegate;
            }
            expoLogBoxDevSupportManager.redBoxSurfaceDelegate = expoLogBoxSurfaceDelegateCreateSurfaceDelegate;
        }
        SurfaceDelegate surfaceDelegate2 = expoLogBoxDevSupportManager.redBoxSurfaceDelegate;
        if ((surfaceDelegate2 == null || !surfaceDelegate2.isShowing()) && (surfaceDelegate = expoLogBoxDevSupportManager.redBoxSurfaceDelegate) != null) {
            surfaceDelegate.show();
        }
    }
}
