package com.swmansion.rnscreens;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Animation;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.swmansion.rnscreens.bottomsheet.BottomSheetTransitionCoordinator;
import com.swmansion.rnscreens.bottomsheet.BottomSheetWindowInsetListenerChain;
import com.swmansion.rnscreens.bottomsheet.DimmingViewManager;
import com.swmansion.rnscreens.bottomsheet.SheetDelegate;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.events.ScreenDismissedEvent;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout;
import com.swmansion.rnscreens.utils.DeviceUtils;
import com.swmansion.rnscreens.utils.ViewBackgroundUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenStackFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\b\u0010:\u001a\u00020\rH\u0016J\b\u0010;\u001a\u00020\u001fH\u0016J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\rH\u0016J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\rH\u0016J\b\u0010B\u001a\u00020\u001fH\u0016J\b\u0010C\u001a\u00020\u001fH\u0016J\b\u0010D\u001a\u00020\u001fH\u0002J\r\u0010E\u001a\u00020\u001fH\u0000¢\u0006\u0002\bFJ\r\u0010G\u001a\u00020\u001fH\u0000¢\u0006\u0002\bHJ\u0012\u0010I\u001a\u00020\u001f2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J$\u0010L\u001a\u00020\u00142\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u001a\u0010Q\u001a\u00020\u001f2\u0006\u0010R\u001a\u00020\u00142\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010S\u001a\u00020\u001fH\u0016J\"\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020WH\u0016J\"\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\r2\u0006\u0010Y\u001a\u00020WH\u0016J\b\u0010\\\u001a\u00020[H\u0002J\b\u0010]\u001a\u00020[H\u0002J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00040_H\u0002J\u0017\u0010`\u001a\u0004\u0018\u00010W2\u0006\u0010a\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010bJ\u0010\u0010c\u001a\u00020\u001f2\u0006\u0010a\u001a\u00020\u0004H\u0002J\b\u0010d\u001a\u00020\u001fH\u0016J\b\u0010e\u001a\u00020\u001fH\u0016J\u0010\u0010f\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020hH\u0016J\u0018\u0010i\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020h2\u0006\u0010M\u001a\u00020jH\u0016J\b\u0010k\u001a\u00020\rH\u0002J\u0010\u0010l\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020hH\u0002J\n\u0010m\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010n\u001a\u00020\rH\u0016J\b\u0010o\u001a\u00020\u001fH\u0016J\u0010\u0010p\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010q\u001a\u00020\u001f2\u0006\u0010r\u001a\u000209H\u0002J\u0012\u0010s\u001a\u00020+2\b\b\u0002\u0010t\u001a\u00020\rH\u0002J\b\u0010u\u001a\u00020-H\u0002J\r\u0010v\u001a\u000203H\u0000¢\u0006\u0002\bwR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR7\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006x"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackFragment;", "Lcom/swmansion/rnscreens/ScreenFragment;", "Lcom/swmansion/rnscreens/ScreenStackFragmentWrapper;", "screenView", "Lcom/swmansion/rnscreens/Screen;", "<init>", "(Lcom/swmansion/rnscreens/Screen;)V", "()V", "appBarLayout", "Lcom/google/android/material/appbar/AppBarLayout;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "isToolbarShadowHidden", "", "isToolbarTranslucent", "lastActiveHeaderConfig", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "sheetTransitionCoordinator", "Lcom/swmansion/rnscreens/bottomsheet/BottomSheetTransitionCoordinator;", "lastFocusedChild", "Landroid/view/View;", "searchView", "Lcom/swmansion/rnscreens/CustomSearchView;", "getSearchView", "()Lcom/swmansion/rnscreens/CustomSearchView;", "setSearchView", "(Lcom/swmansion/rnscreens/CustomSearchView;)V", "onSearchViewCreate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnSearchViewCreate", "()Lkotlin/jvm/functions/Function1;", "setOnSearchViewCreate", "(Lkotlin/jvm/functions/Function1;)V", "coordinatorLayout", "Lcom/swmansion/rnscreens/stack/views/ScreensCoordinatorLayout;", "screenStack", "Lcom/swmansion/rnscreens/ScreenStack;", "getScreenStack", "()Lcom/swmansion/rnscreens/ScreenStack;", "dimmingDelegate", "Lcom/swmansion/rnscreens/bottomsheet/DimmingViewManager;", "sheetDelegate", "Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate;", "getSheetDelegate$react_native_screens_release", "()Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate;", "setSheetDelegate$react_native_screens_release", "(Lcom/swmansion/rnscreens/bottomsheet/SheetDelegate;)V", "bottomSheetWindowInsetListenerChain", "Lcom/swmansion/rnscreens/bottomsheet/BottomSheetWindowInsetListenerChain;", "getBottomSheetWindowInsetListenerChain$react_native_screens_release", "()Lcom/swmansion/rnscreens/bottomsheet/BottomSheetWindowInsetListenerChain;", "setBottomSheetWindowInsetListenerChain$react_native_screens_release", "(Lcom/swmansion/rnscreens/bottomsheet/BottomSheetWindowInsetListenerChain;)V", "lastInsetsCompat", "Landroidx/core/view/WindowInsetsCompat;", "isTranslucent", "removeToolbar", "setToolbar", "Lcom/swmansion/rnscreens/CustomToolbar;", "setToolbarShadowHidden", ViewProps.HIDDEN, "setToolbarTranslucent", "translucent", "onContainerUpdate", "onViewAnimationEnd", "notifyViewAppearTransitionEnd", "dismissSelf", "dismissSelf$react_native_screens_release", "onSheetCornerRadiusChange", "onSheetCornerRadiusChange$react_native_screens_release", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onDestroyView", "onCreateAnimation", "Landroid/view/animation/Animation;", "transit", "", "enter", "nextAnim", "onCreateAnimator", "Landroid/animation/Animator;", "createSheetEnterAnimator", "createSheetExitAnimator", "createBottomSheetBehaviour", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "resolveBackgroundColor", "screen", "(Lcom/swmansion/rnscreens/Screen;)Ljava/lang/Integer;", "attachShapeToScreen", "onStart", "onStop", "onPrepareOptionsMenu", "menu", "Landroid/view/Menu;", "onCreateOptionsMenu", "Landroid/view/MenuInflater;", "shouldShowSearchBar", "updateToolbarMenu", "findLastFocusedChild", "canNavigateBack", "dismissFromContainer", "attachInsetsAndLayoutListenersToBottomSheet", "handleInsetsUpdateAndNotifyTransition", "insetsCompat", "requireDimmingDelegate", "forceCreation", "requireSheetDelegate", "requireBottomSheetWindowInsetsListenerChain", "requireBottomSheetWindowInsetsListenerChain$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenStackFragment extends ScreenFragment implements ScreenStackFragmentWrapper {
    private AppBarLayout appBarLayout;
    private BottomSheetWindowInsetListenerChain bottomSheetWindowInsetListenerChain;
    private ScreensCoordinatorLayout coordinatorLayout;
    private DimmingViewManager dimmingDelegate;
    private boolean isToolbarShadowHidden;
    private boolean isToolbarTranslucent;
    private ScreenStackHeaderConfig lastActiveHeaderConfig;
    private View lastFocusedChild;
    private WindowInsetsCompat lastInsetsCompat;
    private Function1<? super CustomSearchView, Unit> onSearchViewCreate;
    private CustomSearchView searchView;
    private SheetDelegate sheetDelegate;
    private BottomSheetTransitionCoordinator sheetTransitionCoordinator;
    private Toolbar toolbar;

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return null;
    }

    public final CustomSearchView getSearchView() {
        return this.searchView;
    }

    public final void setSearchView(CustomSearchView customSearchView) {
        this.searchView = customSearchView;
    }

    public final Function1<CustomSearchView, Unit> getOnSearchViewCreate() {
        return this.onSearchViewCreate;
    }

    public final void setOnSearchViewCreate(Function1<? super CustomSearchView, Unit> function1) {
        this.onSearchViewCreate = function1;
    }

    private final ScreenStack getScreenStack() {
        ScreenContainer container = getScreen().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
        }
        return (ScreenStack) container;
    }

    /* JADX INFO: renamed from: getSheetDelegate$react_native_screens_release, reason: from getter */
    public final SheetDelegate getSheetDelegate() {
        return this.sheetDelegate;
    }

    public final void setSheetDelegate$react_native_screens_release(SheetDelegate sheetDelegate) {
        this.sheetDelegate = sheetDelegate;
    }

    /* JADX INFO: renamed from: getBottomSheetWindowInsetListenerChain$react_native_screens_release, reason: from getter */
    public final BottomSheetWindowInsetListenerChain getBottomSheetWindowInsetListenerChain() {
        return this.bottomSheetWindowInsetListenerChain;
    }

    public final void setBottomSheetWindowInsetListenerChain$react_native_screens_release(BottomSheetWindowInsetListenerChain bottomSheetWindowInsetListenerChain) {
        this.bottomSheetWindowInsetListenerChain = bottomSheetWindowInsetListenerChain;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenStackFragment(Screen screenView) {
        super(screenView);
        Intrinsics.checkNotNullParameter(screenView, "screenView");
    }

    public ScreenStackFragment() {
        throw new IllegalStateException("ScreenStack fragments should never be restored. Follow instructions from https://github.com/software-mansion/react-native-screens/issues/17#issuecomment-424704067 to properly configure your main activity.");
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, com.swmansion.rnscreens.ScreenFragmentWrapper
    public boolean isTranslucent() {
        return getScreen().isTranslucent();
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void removeToolbar() {
        Toolbar toolbar;
        AppBarLayout appBarLayout = this.appBarLayout;
        if (appBarLayout != null && (toolbar = this.toolbar) != null && toolbar.getParent() == appBarLayout) {
            appBarLayout.removeView(toolbar);
        }
        this.toolbar = null;
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbar(CustomToolbar toolbar) {
        Intrinsics.checkNotNullParameter(toolbar, "toolbar");
        this.lastActiveHeaderConfig = toolbar.getConfig();
        AppBarLayout appBarLayout = this.appBarLayout;
        if (appBarLayout != null) {
            appBarLayout.addView(toolbar);
        }
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
        layoutParams.setScrollFlags(0);
        toolbar.setLayoutParams(layoutParams);
        this.toolbar = toolbar;
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbarShadowHidden(boolean hidden) {
        if (this.isToolbarShadowHidden != hidden) {
            AppBarLayout appBarLayout = this.appBarLayout;
            if (appBarLayout != null) {
                appBarLayout.setElevation(hidden ? 0.0f : PixelUtil.toPixelFromDIP(4.0f));
            }
            AppBarLayout appBarLayout2 = this.appBarLayout;
            if (appBarLayout2 != null) {
                appBarLayout2.setStateListAnimator(null);
            }
            this.isToolbarShadowHidden = hidden;
        }
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void setToolbarTranslucent(boolean translucent) {
        if (this.isToolbarTranslucent != translucent) {
            ViewGroup.LayoutParams layoutParams = getScreen().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(translucent ? null : new AppBarLayout.ScrollingViewBehavior());
            this.isToolbarTranslucent = translucent;
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onContainerUpdate() {
        super.onContainerUpdate();
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        if (headerConfig != null) {
            headerConfig.onUpdate();
        }
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, com.swmansion.rnscreens.ScreenFragmentWrapper
    public void onViewAnimationEnd() {
        super.onViewAnimationEnd();
        notifyViewAppearTransitionEnd();
        getScreen().endRemovalTransition();
    }

    private final void notifyViewAppearTransitionEnd() {
        View view = getView();
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent instanceof ScreenStack) {
            ((ScreenStack) parent).onViewAppearTransitionEnd();
        }
    }

    public final void dismissSelf$react_native_screens_release() {
        if (isRemoving() && isDetached()) {
            return;
        }
        ThemedReactContext reactContext = getScreen().getReactContext();
        int surfaceId = UIManagerHelper.getSurfaceId(reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getScreen().getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new ScreenDismissedEvent(surfaceId, getScreen().getId()));
        }
    }

    public final void onSheetCornerRadiusChange$react_native_screens_release() {
        getScreen().onSheetCornerRadiusChange$react_native_screens_release();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.swmansion.rnscreens.ScreenFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AppBarLayout.ScrollingViewBehavior scrollingViewBehavior;
        AppBarLayout appBarLayout;
        AppBarLayout appBarLayout2;
        AppBarLayout appBarLayout3;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.coordinatorLayout = new ScreensCoordinatorLayout(contextRequireContext, this);
        Screen screen = getScreen();
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        ScreensCoordinatorLayout screensCoordinatorLayout = null;
        if (SheetUtilsKt.usesFormSheetPresentation(getScreen())) {
            scrollingViewBehavior = createBottomSheetBehaviour();
        } else {
            scrollingViewBehavior = this.isToolbarTranslucent ? null : new AppBarLayout.ScrollingViewBehavior();
        }
        layoutParams.setBehavior(scrollingViewBehavior);
        screen.setLayoutParams(layoutParams);
        ScreensCoordinatorLayout screensCoordinatorLayout2 = this.coordinatorLayout;
        if (screensCoordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
            screensCoordinatorLayout2 = null;
        }
        screensCoordinatorLayout2.addView(ViewExtKt.recycle(getScreen()));
        if (!SheetUtilsKt.usesFormSheetPresentation(getScreen())) {
            Context context = getContext();
            if (context != null) {
                appBarLayout = new AppBarLayout(context);
                appBarLayout.setBackgroundColor(0);
                appBarLayout.setLayoutParams(new AppBarLayout.LayoutParams(-1, -2));
            } else {
                appBarLayout = null;
            }
            this.appBarLayout = appBarLayout;
            ScreensCoordinatorLayout screensCoordinatorLayout3 = this.coordinatorLayout;
            if (screensCoordinatorLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout3 = null;
            }
            screensCoordinatorLayout3.addView(this.appBarLayout);
            if (this.isToolbarShadowHidden && (appBarLayout3 = this.appBarLayout) != null) {
                appBarLayout3.setTargetElevation(0.0f);
            }
            Toolbar toolbar = this.toolbar;
            if (toolbar != null && (appBarLayout2 = this.appBarLayout) != null) {
                appBarLayout2.addView(ViewExtKt.recycle(toolbar));
            }
            setHasOptionsMenu(true);
        } else {
            getScreen().setClipToOutline(true);
            attachShapeToScreen(getScreen());
            getScreen().setElevation(getScreen().getSheetElevation());
            final SheetDelegate sheetDelegateRequireSheetDelegate = requireSheetDelegate();
            BottomSheetBehavior<Screen> sheetBehavior = getScreen().getSheetBehavior();
            Intrinsics.checkNotNull(sheetBehavior);
            SheetDelegate.configureBottomSheetBehaviour$react_native_screens_release$default(sheetDelegateRequireSheetDelegate, sheetBehavior, null, 0, 6, null);
            DimmingViewManager dimmingViewManagerRequireDimmingDelegate = requireDimmingDelegate(true);
            Screen screen2 = getScreen();
            ScreensCoordinatorLayout screensCoordinatorLayout4 = this.coordinatorLayout;
            if (screensCoordinatorLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout4 = null;
            }
            dimmingViewManagerRequireDimmingDelegate.onViewHierarchyCreated(screen2, screensCoordinatorLayout4);
            Screen screen3 = getScreen();
            BottomSheetBehavior<Screen> sheetBehavior2 = getScreen().getSheetBehavior();
            Intrinsics.checkNotNull(sheetBehavior2);
            dimmingViewManagerRequireDimmingDelegate.onBehaviourAttached(screen3, sheetBehavior2);
            if (!getScreen().getSheetShouldOverflowTopInset()) {
                BottomSheetTransitionCoordinator bottomSheetTransitionCoordinator = new BottomSheetTransitionCoordinator();
                this.sheetTransitionCoordinator = bottomSheetTransitionCoordinator;
                attachInsetsAndLayoutListenersToBottomSheet(bottomSheetTransitionCoordinator);
            }
            ScreenContainer container2 = getScreen().getContainer();
            Intrinsics.checkNotNull(container2);
            ScreensCoordinatorLayout screensCoordinatorLayout5 = this.coordinatorLayout;
            if (screensCoordinatorLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout5 = null;
            }
            screensCoordinatorLayout5.measure(View.MeasureSpec.makeMeasureSpec(container2.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(container2.getHeight(), 1073741824));
            ScreensCoordinatorLayout screensCoordinatorLayout6 = this.coordinatorLayout;
            if (screensCoordinatorLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout6 = null;
            }
            screensCoordinatorLayout6.layout(0, 0, container2.getWidth(), container2.getHeight());
            ViewCompat.setWindowInsetsAnimationCallback(getScreen(), new WindowInsetsAnimationCompat.Callback() { // from class: com.swmansion.rnscreens.ScreenStackFragment$onCreateView$insetsAnimationCallback$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
                public void onPrepare(WindowInsetsAnimationCompat animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onPrepare(animation);
                    if ((animation.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                        sheetDelegateRequireSheetDelegate.notifyKeyboardAnimationStart$react_native_screens_release();
                    }
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
                public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
                    Intrinsics.checkNotNullParameter(insets, "insets");
                    Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                    sheetDelegateRequireSheetDelegate.handleKeyboardInsetsProgress$react_native_screens_release(insets);
                    return insets;
                }

                @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
                public void onEnd(WindowInsetsAnimationCompat animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    super.onEnd(animation);
                    if ((animation.getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                        sheetDelegateRequireSheetDelegate.notifyKeyboardAnimationEnd$react_native_screens_release();
                    }
                    this.getScreen().onSheetYTranslationChanged$react_native_screens_release();
                }
            });
        }
        ScreensCoordinatorLayout screensCoordinatorLayout7 = this.coordinatorLayout;
        if (screensCoordinatorLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
        } else {
            screensCoordinatorLayout = screensCoordinatorLayout7;
        }
        return screensCoordinatorLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreateView$lambda$8(SheetDelegate sheetDelegate, View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        sheetDelegate.handleKeyboardInsetsProgress$react_native_screens_release(windowInsets);
        return windowInsets;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ScreenStackHeaderConfig screenStackHeaderConfig = this.lastActiveHeaderConfig;
        if (screenStackHeaderConfig != null) {
            FragmentActivity activity = getActivity();
            screenStackHeaderConfig.clearActionBarIfOwned$react_native_screens_release(activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null);
        }
        this.lastActiveHeaderConfig = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        if (SheetUtilsKt.usesFormSheetPresentation(getScreen())) {
            return enter ? createSheetEnterAnimator() : createSheetExitAnimator();
        }
        return null;
    }

    private final Animator createSheetEnterAnimator() {
        SheetDelegate sheetDelegateRequireSheetDelegate = requireSheetDelegate();
        ScreensCoordinatorLayout screensCoordinatorLayout = null;
        DimmingViewManager dimmingViewManagerRequireDimmingDelegate$default = requireDimmingDelegate$default(this, false, 1, null);
        Screen screen = getScreen();
        ScreensCoordinatorLayout screensCoordinatorLayout2 = this.coordinatorLayout;
        if (screensCoordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
        } else {
            screensCoordinatorLayout = screensCoordinatorLayout2;
        }
        return sheetDelegateRequireSheetDelegate.createSheetEnterAnimator$react_native_screens_release(new SheetDelegate.SheetAnimationContext(this, screen, screensCoordinatorLayout, dimmingViewManagerRequireDimmingDelegate$default));
    }

    private final Animator createSheetExitAnimator() {
        SheetDelegate sheetDelegateRequireSheetDelegate = requireSheetDelegate();
        ScreensCoordinatorLayout screensCoordinatorLayout = null;
        DimmingViewManager dimmingViewManagerRequireDimmingDelegate$default = requireDimmingDelegate$default(this, false, 1, null);
        Screen screen = getScreen();
        ScreensCoordinatorLayout screensCoordinatorLayout2 = this.coordinatorLayout;
        if (screensCoordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
        } else {
            screensCoordinatorLayout = screensCoordinatorLayout2;
        }
        return sheetDelegateRequireSheetDelegate.createSheetExitAnimator$react_native_screens_release(new SheetDelegate.SheetAnimationContext(this, screen, screensCoordinatorLayout, dimmingViewManagerRequireDimmingDelegate$default));
    }

    private final BottomSheetBehavior<Screen> createBottomSheetBehaviour() {
        return new BottomSheetBehavior<>();
    }

    private final Integer resolveBackgroundColor(Screen screen) {
        Integer numValueOf;
        ColorStateList tintList;
        Drawable background = screen.getBackground();
        ColorDrawable colorDrawable = background instanceof ColorDrawable ? (ColorDrawable) background : null;
        if (colorDrawable != null) {
            numValueOf = Integer.valueOf(colorDrawable.getColor());
        } else {
            Drawable background2 = screen.getBackground();
            MaterialShapeDrawable materialShapeDrawable = background2 instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) background2 : null;
            numValueOf = (materialShapeDrawable == null || (tintList = materialShapeDrawable.getTintList()) == null) ? null : Integer.valueOf(tintList.getDefaultColor());
        }
        if (numValueOf != null) {
            return numValueOf;
        }
        ScreenContentWrapper contentWrapper = screen.getContentWrapper();
        if (contentWrapper == null) {
            return null;
        }
        return ViewBackgroundUtilsKt.resolveBackgroundColor(contentWrapper);
    }

    private final void attachShapeToScreen(Screen screen) {
        float fMax = Math.max(PixelUtil.toPixelFromDIP(screen.getSheetCornerRadius()), 0.0f);
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        builder.setTopLeftCorner(0, fMax);
        builder.setTopRightCorner(0, fMax);
        ShapeAppearanceModel shapeAppearanceModelBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(shapeAppearanceModelBuild, "build(...)");
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModelBuild);
        Integer numResolveBackgroundColor = resolveBackgroundColor(screen);
        materialShapeDrawable.setTint(numResolveBackgroundColor != null ? numResolveBackgroundColor.intValue() : 0);
        screen.setBackground(materialShapeDrawable);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        View view = this.lastFocusedChild;
        if (view != null) {
            view.requestFocus();
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        if (DeviceUtils.INSTANCE.isPlatformAndroidTV(getContext())) {
            this.lastFocusedChild = findLastFocusedChild();
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        ScreenStackHeaderConfig headerConfig;
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (!getScreen().isTranslucent() || ((headerConfig = getScreen().getHeaderConfig()) != null && !headerConfig.getIsHeaderHidden())) {
            updateToolbarMenu(menu);
        }
        super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        updateToolbarMenu(menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private final boolean shouldShowSearchBar() {
        ScreenStackHeaderConfig headerConfig = getScreen().getHeaderConfig();
        int configSubviewsCount = headerConfig != null ? headerConfig.getConfigSubviewsCount() : 0;
        if (headerConfig != null && configSubviewsCount > 0) {
            for (int i = 0; i < configSubviewsCount; i++) {
                if (headerConfig.getConfigSubview(i).getType() == ScreenStackHeaderSubview.Type.SEARCH_BAR) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void updateToolbarMenu(Menu menu) {
        menu.clear();
        if (shouldShowSearchBar()) {
            Context context = getContext();
            if (this.searchView == null && context != null) {
                CustomSearchView customSearchView = new CustomSearchView(context, this);
                this.searchView = customSearchView;
                Function1<? super CustomSearchView, Unit> function1 = this.onSearchViewCreate;
                if (function1 != null) {
                    function1.invoke(customSearchView);
                }
            }
            MenuItem menuItemAdd = menu.add("");
            menuItemAdd.setShowAsAction(2);
            menuItemAdd.setActionView(this.searchView);
        }
    }

    private final View findLastFocusedChild() {
        Screen screen = getScreen();
        while (screen != null) {
            if (screen.isFocused()) {
                return screen;
            }
            screen = screen instanceof ViewGroup ? ((ViewGroup) screen).getFocusedChild() : null;
        }
        return null;
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public boolean canNavigateBack() {
        ScreenContainer container = getScreen().getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container".toString());
        }
        if (!Intrinsics.areEqual(((ScreenStack) container).getRootScreen(), getScreen())) {
            return true;
        }
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof ScreenStackFragment) {
            return ((ScreenStackFragment) parentFragment).canNavigateBack();
        }
        return false;
    }

    @Override // com.swmansion.rnscreens.ScreenStackFragmentWrapper
    public void dismissFromContainer() {
        getScreenStack().dismiss(this);
    }

    private final void attachInsetsAndLayoutListenersToBottomSheet(final BottomSheetTransitionCoordinator sheetTransitionCoordinator) {
        final ScreenContainer container = getScreen().getContainer();
        if (container != null) {
            container.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.swmansion.rnscreens.ScreenStackFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return ScreenStackFragment.attachInsetsAndLayoutListenersToBottomSheet$lambda$14$lambda$12(container, this, view, windowInsets);
                }
            });
        }
        ScreenContainer container2 = getScreen().getContainer();
        if (container2 != null) {
            container2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.swmansion.rnscreens.ScreenStackFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    ScreenStackFragment.attachInsetsAndLayoutListenersToBottomSheet$lambda$15(sheetTransitionCoordinator, this, view, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets attachInsetsAndLayoutListenersToBottomSheet$lambda$14$lambda$12(ScreenContainer screenContainer, ScreenStackFragment screenStackFragment, View view, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(insets, screenContainer);
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(...)");
        screenStackFragment.handleInsetsUpdateAndNotifyTransition(windowInsetsCompat);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat attachInsetsAndLayoutListenersToBottomSheet$lambda$14$lambda$13(ScreenStackFragment screenStackFragment, View view, WindowInsetsCompat windowInsets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        screenStackFragment.handleInsetsUpdateAndNotifyTransition(windowInsets);
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachInsetsAndLayoutListenersToBottomSheet$lambda$15(BottomSheetTransitionCoordinator bottomSheetTransitionCoordinator, ScreenStackFragment screenStackFragment, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        bottomSheetTransitionCoordinator.onScreenContainerLayoutChanged$react_native_screens_release(screenStackFragment.getScreen());
    }

    private final void handleInsetsUpdateAndNotifyTransition(WindowInsetsCompat insetsCompat) {
        if (Intrinsics.areEqual(this.lastInsetsCompat, insetsCompat)) {
            return;
        }
        this.lastInsetsCompat = insetsCompat;
        SheetDelegate sheetDelegateRequireSheetDelegate = requireSheetDelegate();
        BottomSheetBehavior<Screen> sheetBehavior = getScreen().getSheetBehavior();
        Intrinsics.checkNotNull(sheetBehavior);
        sheetDelegateRequireSheetDelegate.updateBottomSheetMetrics$react_native_screens_release(sheetBehavior);
        ScreenContainer container = getScreen().getContainer();
        BottomSheetTransitionCoordinator bottomSheetTransitionCoordinator = null;
        if (container != null) {
            ScreensCoordinatorLayout screensCoordinatorLayout = this.coordinatorLayout;
            if (screensCoordinatorLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout = null;
            }
            screensCoordinatorLayout.forceLayout();
            ScreensCoordinatorLayout screensCoordinatorLayout2 = this.coordinatorLayout;
            if (screensCoordinatorLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout2 = null;
            }
            screensCoordinatorLayout2.measure(View.MeasureSpec.makeMeasureSpec(container.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(container.getHeight(), 1073741824));
            ScreensCoordinatorLayout screensCoordinatorLayout3 = this.coordinatorLayout;
            if (screensCoordinatorLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("coordinatorLayout");
                screensCoordinatorLayout3 = null;
            }
            screensCoordinatorLayout3.layout(0, 0, container.getWidth(), container.getHeight());
        }
        getScreen().onBottomSheetBehaviorDidLayout$react_native_screens_release(true);
        BottomSheetTransitionCoordinator bottomSheetTransitionCoordinator2 = this.sheetTransitionCoordinator;
        if (bottomSheetTransitionCoordinator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sheetTransitionCoordinator");
        } else {
            bottomSheetTransitionCoordinator = bottomSheetTransitionCoordinator2;
        }
        bottomSheetTransitionCoordinator.onScreenContainerInsetsApplied$react_native_screens_release(getScreen());
    }

    static /* synthetic */ DimmingViewManager requireDimmingDelegate$default(ScreenStackFragment screenStackFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return screenStackFragment.requireDimmingDelegate(z);
    }

    private final DimmingViewManager requireDimmingDelegate(boolean forceCreation) {
        DimmingViewManager dimmingViewManager = this.dimmingDelegate;
        if (dimmingViewManager == null || forceCreation) {
            if (dimmingViewManager != null) {
                dimmingViewManager.invalidate(getScreen().getSheetBehavior());
            }
            this.dimmingDelegate = new DimmingViewManager(getScreen().getReactContext(), getScreen());
        }
        DimmingViewManager dimmingViewManager2 = this.dimmingDelegate;
        Intrinsics.checkNotNull(dimmingViewManager2);
        return dimmingViewManager2;
    }

    private final SheetDelegate requireSheetDelegate() {
        if (this.sheetDelegate == null) {
            this.sheetDelegate = new SheetDelegate(getScreen());
        }
        SheetDelegate sheetDelegate = this.sheetDelegate;
        Intrinsics.checkNotNull(sheetDelegate);
        return sheetDelegate;
    }

    public final BottomSheetWindowInsetListenerChain requireBottomSheetWindowInsetsListenerChain$react_native_screens_release() {
        if (this.bottomSheetWindowInsetListenerChain == null) {
            this.bottomSheetWindowInsetListenerChain = new BottomSheetWindowInsetListenerChain();
        }
        BottomSheetWindowInsetListenerChain bottomSheetWindowInsetListenerChain = this.bottomSheetWindowInsetListenerChain;
        Intrinsics.checkNotNull(bottomSheetWindowInsetListenerChain);
        return bottomSheetWindowInsetListenerChain;
    }
}
