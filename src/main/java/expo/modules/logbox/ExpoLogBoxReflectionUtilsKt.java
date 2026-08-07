package expo.modules.logbox;

import android.content.Context;
import android.util.Log;
import com.facebook.react.ReactHost;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.ReactInstanceDevHelper;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PausedInDebuggerOverlayManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.runtime.ReactHostImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoLogBoxReflectionUtils.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\b\u0002\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t¨\u0006\n"}, d2 = {"injectExpoLogBoxDevSupportManager", "", "reactHost", "Lcom/facebook/react/ReactHost;", "createExpoLogBoxBridgelessDevSupportManager", "Lexpo/modules/logbox/ExpoLogBoxDevSupportManager;", "currentDevSupportManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "devManagerClass", "Ljava/lang/Class;", "expo-log-box_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ExpoLogBoxReflectionUtilsKt {
    public static final void injectExpoLogBoxDevSupportManager(ReactHost reactHost) {
        DevSupportManager devSupportManager = reactHost != null ? reactHost.getDevSupportManager() : null;
        if (devSupportManager == null) {
            Log.w("ExpoLogBox", "ReactHost initialized without a dev support manager, ExpoLogBox can't be initialized.");
            return;
        }
        if (devSupportManager instanceof ExpoLogBoxDevSupportManager) {
            Log.i("ExpoLogBox", "DevSupportManager is already `ExpoDevSupportManagerWithLogBoxOverride`, skipping initialization.");
            return;
        }
        try {
            ExpoLogBoxReflectionExtensionsKt.setProtectedDeclaredField$default(ReactHostImpl.class, reactHost, "devSupportManager", createExpoLogBoxBridgelessDevSupportManager$default(devSupportManager, null, 2, null), null, 8, null);
        } catch (Exception e) {
            Log.i("ExpoLogBox", "Couldn't inject `ExpoDevSupportManagerWithLogBoxOverride`.", e);
        }
    }

    public static /* synthetic */ ExpoLogBoxDevSupportManager createExpoLogBoxBridgelessDevSupportManager$default(DevSupportManager devSupportManager, Class cls, int i, Object obj) {
        if ((i & 2) != 0) {
            cls = DevSupportManagerBase.class;
        }
        return createExpoLogBoxBridgelessDevSupportManager(devSupportManager, cls);
    }

    public static final ExpoLogBoxDevSupportManager createExpoLogBoxBridgelessDevSupportManager(DevSupportManager currentDevSupportManager, Class<?> devManagerClass) {
        Intrinsics.checkNotNullParameter(currentDevSupportManager, "currentDevSupportManager");
        Intrinsics.checkNotNullParameter(devManagerClass, "devManagerClass");
        return new ExpoLogBoxDevSupportManager((Context) ExpoLogBoxReflectionExtensionsKt.getProtectedFieldValue(devManagerClass, currentDevSupportManager, "applicationContext"), (ReactInstanceDevHelper) ExpoLogBoxReflectionExtensionsKt.getProtectedFieldValue(devManagerClass, currentDevSupportManager, "reactInstanceDevHelper"), (String) ExpoLogBoxReflectionExtensionsKt.getProtectedFieldValue(devManagerClass, currentDevSupportManager, "jsAppBundleName"), true, (RedBoxHandler) ExpoLogBoxReflectionExtensionsKt.getProtectedFieldValue(devManagerClass, currentDevSupportManager, "redBoxHandler"), (DevBundleDownloadListener) ExpoLogBoxReflectionExtensionsKt.getProtectedFieldValue(devManagerClass, currentDevSupportManager, "devBundleDownloadListener"), 1, (Map) ExpoLogBoxReflectionExtensionsKt.getProtectedFieldValue(devManagerClass, currentDevSupportManager, "customPackagerCommandHandlers"), (SurfaceDelegateFactory) ExpoLogBoxReflectionExtensionsKt.getProtectedFieldValue(devManagerClass, currentDevSupportManager, "surfaceDelegateFactory"), (DevLoadingViewManager) ExpoLogBoxReflectionExtensionsKt.getProtectedFieldValue(devManagerClass, currentDevSupportManager, "devLoadingViewManager"), (PausedInDebuggerOverlayManager) ExpoLogBoxReflectionExtensionsKt.getProtectedFieldValue(devManagerClass, currentDevSupportManager, "pausedInDebuggerOverlayManager"));
    }
}
