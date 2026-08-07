package expo.modules.adapters.react.apploader;

import android.content.Context;
import android.os.Handler;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import expo.modules.apploader.HeadlessAppLoader;
import expo.modules.core.interfaces.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: RNHeadlessAppLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0017J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006\u0013"}, d2 = {"Lexpo/modules/adapters/react/apploader/RNHeadlessAppLoader;", "Lexpo/modules/apploader/HeadlessAppLoader;", "<init>", "()V", "loadApp", "", "context", "Landroid/content/Context;", SerializedNames.PARAMS, "Lexpo/modules/apploader/HeadlessAppLoader$Params;", "alreadyRunning", "Ljava/lang/Runnable;", "callback", "Lexpo/modules/core/interfaces/Consumer;", "", "invalidateApp", "appScopeKey", "", "isRunning", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RNHeadlessAppLoader implements HeadlessAppLoader {
    public static final int $stable = 0;

    @Override // expo.modules.apploader.HeadlessAppLoader
    public void loadApp(Context context, final HeadlessAppLoader.Params params, Runnable alreadyRunning, final Consumer<Boolean> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (params == null || params.getAppScopeKey() == null) {
            throw new IllegalArgumentException("Params must be set with appScopeKey!");
        }
        if (context.getApplicationContext() instanceof ReactApplication) {
            if (RNHeadlessAppLoaderKt.appRecords.containsKey(params.getAppScopeKey())) {
                if (alreadyRunning != null) {
                    alreadyRunning.run();
                    return;
                }
                return;
            }
            Object applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
            final ReactHost reactHost = ((ReactApplication) applicationContext).getReactHost();
            if (reactHost == null) {
                throw new IllegalStateException("Your application does not have a valid reactHost");
            }
            reactHost.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: expo.modules.adapters.react.apploader.RNHeadlessAppLoader.loadApp.1
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(ReactContext context2) {
                    Intrinsics.checkNotNullParameter(context2, "context");
                    reactHost.removeReactInstanceEventListener(this);
                    RNHeadlessAppLoaderKt.appRecords.put(params.getAppScopeKey(), context2);
                    Consumer<Boolean> consumer = callback;
                    if (consumer != null) {
                        consumer.apply(true);
                    }
                }
            });
            new Handler(context.getMainLooper()).post(new Runnable() { // from class: expo.modules.adapters.react.apploader.RNHeadlessAppLoader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    reactHost.start();
                }
            });
            return;
        }
        throw new IllegalStateException("Your application must implement ReactApplication");
    }

    @Override // expo.modules.apploader.HeadlessAppLoader
    public boolean invalidateApp(final String appScopeKey) {
        ReactContext reactContext;
        if (!RNHeadlessAppLoaderKt.appRecords.containsKey(appScopeKey) || RNHeadlessAppLoaderKt.appRecords.get(appScopeKey) == null || (reactContext = (ReactContext) RNHeadlessAppLoaderKt.appRecords.get(appScopeKey)) == null) {
            return false;
        }
        Object applicationContext = reactContext.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
        final ReactHost reactHost = ((ReactApplication) applicationContext).getReactHost();
        if (reactHost == null) {
            throw new IllegalStateException("Your application does not have a valid reactHost");
        }
        new Handler(reactContext.getMainLooper()).post(new Runnable() { // from class: expo.modules.adapters.react.apploader.RNHeadlessAppLoader$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RNHeadlessAppLoader.invalidateApp$lambda$1(reactHost, appScopeKey);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidateApp$lambda$1(ReactHost reactHost, String str) {
        if (reactHost.getLifecycleState() == LifecycleState.BEFORE_CREATE) {
            reactHost.destroy("Closing headless task app", null);
        }
        TypeIntrinsics.asMutableMap(RNHeadlessAppLoaderKt.appRecords).remove(str);
    }

    @Override // expo.modules.apploader.HeadlessAppLoader
    public boolean isRunning(String appScopeKey) {
        return RNHeadlessAppLoaderKt.appRecords.get(appScopeKey) != null;
    }
}
