package expo.modules.logbox;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.os.Bundle;
import com.facebook.react.ReactApplication;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoLogBoxPackage.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lexpo/modules/logbox/ExpoLogBoxPackage;", "Lexpo/modules/core/interfaces/Package;", "<init>", "()V", "createReactActivityLifecycleListeners", "", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "activityContext", "Landroid/content/Context;", "expo-log-box_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoLogBoxPackage implements Package {
    @Override // expo.modules.core.interfaces.Package
    public List<ReactActivityLifecycleListener> createReactActivityLifecycleListeners(Context activityContext) {
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: expo.modules.logbox.ExpoLogBoxPackage$createReactActivityLifecycleListeners$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExpoLogBoxPackage.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"expo/modules/logbox/ExpoLogBoxPackage$createReactActivityLifecycleListeners$1", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "expo-log-box_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements ReactActivityLifecycleListener {
        AnonymousClass1() {
        }

        @Override // expo.modules.core.interfaces.ReactActivityLifecycleListener
        public void onCreate(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            ComponentCallbacks2 application = activity.getApplication();
            Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
            ExpoLogBoxReflectionUtilsKt.injectExpoLogBoxDevSupportManager(((ReactApplication) application).getReactHost());
        }
    }
}
