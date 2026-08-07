package expo.modules.logbox;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.widget.FrameLayout;
import androidx.navigation.compose.DialogNavigator;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.StackFrame;
import io.split.android.client.network.HttpRequestImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ExpoLogBoxSurfaceDelegate.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\u0014\u001aB\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\u0016\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0012\u0004\u0012\u00020\t0\u0016\u0012\u0004\u0012\u00020\t0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lexpo/modules/logbox/ExpoLogBoxSurfaceDelegate;", "Lcom/facebook/react/common/SurfaceDelegate;", "devSupportManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "<init>", "(Lcom/facebook/react/devsupport/interfaces/DevSupportManager;)V", DialogNavigator.NAME, "Landroid/app/Dialog;", "createContentView", "", "appKey", "", "isContentViewReady", "", "destroyContentView", "show", "hide", "isShowing", "onReload", "Lkotlin/Function0;", "fetchTextAsync", "Lkotlin/Function5;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Companion", "expo-log-box_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoLogBoxSurfaceDelegate implements SurfaceDelegate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DevSupportManager devSupportManager;
    private Dialog dialog;
    private final Function5<String, String, String, Function1<? super String, Unit>, Function1<? super Exception, Unit>, Unit> fetchTextAsync;
    private final Function0<Unit> onReload;

    @Override // com.facebook.react.common.SurfaceDelegate
    public void createContentView(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void destroyContentView() {
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public boolean isContentViewReady() {
        return true;
    }

    public ExpoLogBoxSurfaceDelegate(DevSupportManager devSupportManager) {
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.devSupportManager = devSupportManager;
        this.onReload = new Function0() { // from class: expo.modules.logbox.ExpoLogBoxSurfaceDelegate$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ExpoLogBoxSurfaceDelegate.onReload$lambda$4(this.f$0);
            }
        };
        this.fetchTextAsync = new Function5() { // from class: expo.modules.logbox.ExpoLogBoxSurfaceDelegate$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return ExpoLogBoxSurfaceDelegate.fetchTextAsync$lambda$5((String) obj, (String) obj2, (String) obj3, (Function1) obj4, (Function1) obj5);
            }
        };
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void show() {
        ArrayList arrayList;
        Activity currentActivity = this.devSupportManager.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        if (currentActivity.isFinishing()) {
            ReactContext currentReactContext = this.devSupportManager.getCurrentReactContext();
            if (currentReactContext != null) {
                INSTANCE.runAfterHostResume(currentReactContext, new Runnable() { // from class: expo.modules.logbox.ExpoLogBoxSurfaceDelegate$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.show();
                    }
                });
                return;
            }
            return;
        }
        Activity activity = currentActivity;
        this.dialog = new Dialog(activity, R.style.Theme.NoTitleBar);
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setFitsSystemWindows(true);
        String lastErrorTitle = this.devSupportManager.getLastErrorTitle();
        StackFrame[] lastErrorStack = this.devSupportManager.getLastErrorStack();
        if (lastErrorStack != null) {
            ArrayList arrayList2 = new ArrayList(lastErrorStack.length);
            for (StackFrame stackFrame : lastErrorStack) {
                arrayList2.add(MapsKt.mapOf(TuplesKt.to("file", stackFrame.getFile()), TuplesKt.to("methodName", stackFrame.getMethod()), TuplesKt.to("arguments", new String[0]), TuplesKt.to("lineNumber", Integer.valueOf(stackFrame.getLine())), TuplesKt.to("column", Integer.valueOf(stackFrame.getColumn())), TuplesKt.to("collapse", Boolean.valueOf(stackFrame.getIsCollapsed()))));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        frameLayout.addView(new ExpoLogBoxWebViewWrapper(new ExpoLogBoxWebViewWrapper.Actions(new ExpoLogBoxWebViewWrapper.Actions.OnReload(this.onReload, null, 2, null), new ExpoLogBoxWebViewWrapper.Actions.FetchTextAsync(this.fetchTextAsync, null, 2, null)), MapsKt.mapOf(TuplesKt.to("platform", "android"), TuplesKt.to("nativeLogs", new Map[]{MapsKt.mapOf(TuplesKt.to("message", lastErrorTitle), TuplesKt.to(StackTraceHelper.STACK_KEY, arrayList))})), currentActivity).getWebView());
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.setContentView(frameLayout);
        }
        Dialog dialog2 = this.dialog;
        if (dialog2 != null) {
            dialog2.show();
        }
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public void hide() {
        Dialog dialog = this.dialog;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // com.facebook.react.common.SurfaceDelegate
    public boolean isShowing() {
        Dialog dialog = this.dialog;
        return dialog != null && dialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onReload$lambda$4(ExpoLogBoxSurfaceDelegate expoLogBoxSurfaceDelegate) {
        expoLogBoxSurfaceDelegate.devSupportManager.handleReloadJS();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchTextAsync$lambda$5(String url, String method, String body, final Function1 onResult, final Function1 onFailure) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        OkHttpClient okHttpClient = new OkHttpClient();
        String upperCase = method.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        RequestBody requestBodyCreate = !Intrinsics.areEqual(upperCase, "GET") ? RequestBody.INSTANCE.create(body, MediaType.INSTANCE.parse(HttpRequestImpl.APPLICATION_JSON_CHARSET_UTF_8)) : null;
        Request.Builder builderUrl = new Request.Builder().url(url);
        String upperCase2 = method.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        okHttpClient.newCall(builderUrl.method(upperCase2, requestBodyCreate).build()).enqueue(new Callback() { // from class: expo.modules.logbox.ExpoLogBoxSurfaceDelegate$fetchTextAsync$1$1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                onFailure.invoke(e);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                String strString;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Response response2 = response;
                Function1<String, Unit> function1 = onResult;
                try {
                    ResponseBody responseBodyBody = response2.body();
                    if (responseBodyBody == null || (strString = responseBodyBody.string()) == null) {
                        strString = "{}";
                    }
                    function1.invoke(strString);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(response2, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(response2, th);
                        throw th2;
                    }
                }
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: ExpoLogBoxSurfaceDelegate.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"Lexpo/modules/logbox/ExpoLogBoxSurfaceDelegate$Companion;", "", "<init>", "()V", "runAfterHostResume", "", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "runnable", "Ljava/lang/Runnable;", "expo-log-box_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void runAfterHostResume(final ReactContext reactContext, final Runnable runnable) {
            reactContext.addLifecycleEventListener(new LifecycleEventListener() { // from class: expo.modules.logbox.ExpoLogBoxSurfaceDelegate$Companion$runAfterHostResume$1
                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostDestroy() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostPause() {
                }

                @Override // com.facebook.react.bridge.LifecycleEventListener
                public void onHostResume() {
                    runnable.run();
                    reactContext.removeLifecycleEventListener(this);
                }
            });
        }
    }
}
