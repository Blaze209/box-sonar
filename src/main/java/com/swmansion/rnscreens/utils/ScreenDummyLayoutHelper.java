package com.swmansion.rnscreens.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.media3.common.MimeTypes;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.material.appbar.AppBarLayout;
import com.swmansion.rnscreens.ScreenStackHeaderConfig;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenDummyLayoutHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u0019H\u0003J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010$\u001a\u00020\u00032\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0002J\b\u0010)\u001a\u00020\u001bH\u0016J\b\u0010*\u001a\u00020\u001bH\u0016J\b\u0010+\u001a\u00020\u001bH\u0016J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/swmansion/rnscreens/utils/ScreenDummyLayoutHelper;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "coordinatorLayout", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "dummyContentView", "Landroid/view/View;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "defaultFontSize", "", "defaultContentInsetStartWithNavigation", "", SemanticAttributes.DbSystemValues.CACHE, "Lcom/swmansion/rnscreens/utils/CacheEntry;", "reactContextRef", "Ljava/lang/ref/WeakReference;", "activityLifecycleCallbacks", "Landroid/app/Application$ActivityLifecycleCallbacks;", "maybeInitDummyLayoutWithHeader", "", "initDummyLayoutWithHeader", "", "contextWithTheme", "Landroid/content/Context;", "computeDummyLayout", "fontSize", "isTitleEmpty", "registerActivityLifecycleListener", "activity", "Landroid/app/Activity;", "requireReactContext", "lazyMessage", "Lkotlin/Function0;", "", "isLayoutInitialized", "onHostResume", "onHostPause", "onHostDestroy", "cleanUpViews", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenDummyLayoutHelper implements LifecycleEventListener {
    private static final String DEFAULT_HEADER_TITLE = "FontSize123!#$";
    public static final int FONT_SIZE_UNSET = -1;
    public static final String LIBRARY_NAME = "react_codegen_rnscreens";
    public static final String TAG = "ScreenDummyLayoutHelper";
    private Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
    private AppBarLayout appBarLayout;
    private CacheEntry cache;
    private CoordinatorLayout coordinatorLayout;
    private int defaultContentInsetStartWithNavigation;
    private float defaultFontSize;
    private View dummyContentView;
    private volatile boolean isLayoutInitialized;
    private WeakReference<ReactApplicationContext> reactContextRef;
    private Toolbar toolbar;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static WeakReference<ScreenDummyLayoutHelper> weakInstance = new WeakReference<>(null);

    @JvmStatic
    public static final ScreenDummyLayoutHelper getInstance() {
        return INSTANCE.getInstance();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    public ScreenDummyLayoutHelper(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.cache = CacheEntry.INSTANCE.getEMPTY();
        this.reactContextRef = new WeakReference<>(reactContext);
        try {
            System.loadLibrary(LIBRARY_NAME);
        } catch (UnsatisfiedLinkError unused) {
            Log.w(TAG, "[RNScreens] Failed to load react_codegen_rnscreens library.");
        }
        weakInstance = new WeakReference<>(this);
        maybeInitDummyLayoutWithHeader(reactContext);
        reactContext.addLifecycleEventListener(this);
    }

    private final boolean maybeInitDummyLayoutWithHeader(ReactApplicationContext reactContext) {
        if (this.isLayoutInitialized) {
            return true;
        }
        if (!reactContext.hasCurrentActivity()) {
            return false;
        }
        Activity currentActivity = reactContext.getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalArgumentException("[RNScreens] Attempt to use context detached from activity. This could happen only due to race-condition.".toString());
        }
        synchronized (this) {
            if (this.isLayoutInitialized) {
                return true;
            }
            initDummyLayoutWithHeader(currentActivity);
            registerActivityLifecycleListener(currentActivity);
            Unit unit = Unit.INSTANCE;
            return true;
        }
    }

    private final void initDummyLayoutWithHeader(Context contextWithTheme) {
        CoordinatorLayout coordinatorLayout = new CoordinatorLayout(contextWithTheme);
        AppBarLayout appBarLayout = new AppBarLayout(contextWithTheme);
        appBarLayout.setLayoutParams(new CoordinatorLayout.LayoutParams(-1, -2));
        Toolbar toolbar = new Toolbar(contextWithTheme);
        toolbar.setTitle(DEFAULT_HEADER_TITLE);
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(0);
        toolbar.setLayoutParams(layoutParams);
        TextView textViewFindTitleTextViewInToolbar = ScreenStackHeaderConfig.INSTANCE.findTitleTextViewInToolbar(toolbar);
        if (textViewFindTitleTextViewInToolbar == null) {
            throw new IllegalStateException("[RNScreens] Failed to find TextView in children of Toolbar".toString());
        }
        this.defaultFontSize = textViewFindTitleTextViewInToolbar.getTextSize();
        this.defaultContentInsetStartWithNavigation = toolbar.getContentInsetStartWithNavigation();
        appBarLayout.addView(toolbar);
        View view = new View(contextWithTheme);
        view.setLayoutParams(new CoordinatorLayout.LayoutParams(-1, -1));
        coordinatorLayout.addView(appBarLayout);
        coordinatorLayout.addView(view);
        this.coordinatorLayout = coordinatorLayout;
        this.appBarLayout = appBarLayout;
        this.toolbar = toolbar;
        this.dummyContentView = view;
        this.isLayoutInitialized = true;
    }

    private final synchronized float computeDummyLayout(int fontSize, boolean isTitleEmpty) {
        if (!this.isLayoutInitialized && !maybeInitDummyLayoutWithHeader(requireReactContext(new Function0() { // from class: com.swmansion.rnscreens.utils.ScreenDummyLayoutHelper$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScreenDummyLayoutHelper.computeDummyLayout$lambda$8();
            }
        }))) {
            Log.e(TAG, "[RNScreens] Failed to late-init layout while computing header height. This is most likely a race-condition-bug in react-native-screens, please file an issue at https://github.com/software-mansion/react-native-screens/issues");
            return 0.0f;
        }
        if (this.cache.hasKey(new CacheKey(fontSize, isTitleEmpty))) {
            return this.cache.getHeaderHeight();
        }
        CoordinatorLayout coordinatorLayout = this.coordinatorLayout;
        AppBarLayout appBarLayout = this.appBarLayout;
        Toolbar toolbar = this.toolbar;
        ReactApplicationContext reactApplicationContext = this.reactContextRef.get();
        Activity currentActivity = reactApplicationContext != null ? reactApplicationContext.getCurrentActivity() : null;
        if (coordinatorLayout != null && appBarLayout != null && toolbar != null && currentActivity != null) {
            View decorView = currentActivity.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            int decorViewTopInset = DecorViewInsetsUtilsKt.getDecorViewTopInset(decorView);
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            if (isTitleEmpty) {
                toolbar.setTitle("");
                toolbar.setContentInsetStartWithNavigation(0);
            } else {
                toolbar.setTitle(DEFAULT_HEADER_TITLE);
                toolbar.setContentInsetStartWithNavigation(this.defaultContentInsetStartWithNavigation);
            }
            TextView textViewFindTitleTextViewInToolbar = ScreenStackHeaderConfig.INSTANCE.findTitleTextViewInToolbar(toolbar);
            if (textViewFindTitleTextViewInToolbar != null) {
                textViewFindTitleTextViewInToolbar.setTextSize(fontSize != -1 ? fontSize : this.defaultFontSize);
            }
            coordinatorLayout.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            coordinatorLayout.layout(0, 0, width, height);
            float dIPFromPixel = PixelUtil.toDIPFromPixel(appBarLayout.getHeight() + decorViewTopInset);
            this.cache = new CacheEntry(new CacheKey(fontSize, isTitleEmpty), dIPFromPixel);
            return dIPFromPixel;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object computeDummyLayout$lambda$8() {
        return "[RNScreens] Context was null-ed before dummy layout was initialized";
    }

    private final void registerActivityLifecycleListener(final Activity activity) {
        if (this.activityLifecycleCallbacks != null) {
            return;
        }
        this.activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.swmansion.rnscreens.utils.ScreenDummyLayoutHelper.registerActivityLifecycleListener.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity2, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity2, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity2, Bundle outState) {
                Intrinsics.checkNotNullParameter(activity2, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity destroyedActivity) {
                Intrinsics.checkNotNullParameter(destroyedActivity, "destroyedActivity");
                if (destroyedActivity == activity) {
                    ScreenDummyLayoutHelper screenDummyLayoutHelper = this;
                    Application application = destroyedActivity.getApplication();
                    Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
                    screenDummyLayoutHelper.cleanUpViews(application);
                }
            }
        };
        activity.getApplication().registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ ReactApplicationContext requireReactContext$default(ScreenDummyLayoutHelper screenDummyLayoutHelper, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        return screenDummyLayoutHelper.requireReactContext(function0);
    }

    private final ReactApplicationContext requireReactContext(Function0<? extends Object> lazyMessage) {
        ReactApplicationContext reactApplicationContext = this.reactContextRef.get();
        if (lazyMessage == null) {
            lazyMessage = new Function0() { // from class: com.swmansion.rnscreens.utils.ScreenDummyLayoutHelper$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ScreenDummyLayoutHelper.requireReactContext$lambda$9();
                }
            };
        }
        if (reactApplicationContext != null) {
            return reactApplicationContext;
        }
        throw new IllegalArgumentException(lazyMessage.invoke().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object requireReactContext$lambda$9() {
        return "[RNScreens] Attempt to require missing react context";
    }

    /* JADX INFO: compiled from: ScreenDummyLayoutHelper.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/swmansion/rnscreens/utils/ScreenDummyLayoutHelper$Companion;", "", "<init>", "()V", "TAG", "", "LIBRARY_NAME", "FONT_SIZE_UNSET", "", "DEFAULT_HEADER_TITLE", "weakInstance", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/rnscreens/utils/ScreenDummyLayoutHelper;", "getInstance", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ScreenDummyLayoutHelper getInstance() {
            return (ScreenDummyLayoutHelper) ScreenDummyLayoutHelper.weakInstance.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onHostResume$lambda$10() {
        return "[RNScreens] ReactContext missing in onHostResume! This should not happen.";
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        ReactApplicationContext reactApplicationContextRequireReactContext = requireReactContext(new Function0() { // from class: com.swmansion.rnscreens.utils.ScreenDummyLayoutHelper$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ScreenDummyLayoutHelper.onHostResume$lambda$10();
            }
        });
        if (maybeInitDummyLayoutWithHeader(reactApplicationContextRequireReactContext)) {
            reactApplicationContextRequireReactContext.removeLifecycleEventListener(this);
        } else {
            Log.w(TAG, "[RNScreens] Failed to initialise dummy layout in onHostResume.");
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        ReactApplicationContext reactApplicationContext = this.reactContextRef.get();
        if (reactApplicationContext != null) {
            reactApplicationContext.removeLifecycleEventListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void cleanUpViews(Application application) {
        this.coordinatorLayout = null;
        this.appBarLayout = null;
        this.dummyContentView = null;
        this.toolbar = null;
        this.cache = CacheEntry.INSTANCE.getEMPTY();
        this.isLayoutInitialized = false;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.activityLifecycleCallbacks;
        if (activityLifecycleCallbacks != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.activityLifecycleCallbacks = null;
        }
    }
}
