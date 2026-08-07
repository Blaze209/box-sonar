package com.swmansion.rnscreens.gamma.stack.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding;
import com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderType;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubview;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewCollapseMode;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewProviding;
import com.swmansion.rnscreens.utils.DrawableUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 U2\u00020\u0001:\u0001UBH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0002\b/J\u0018\u00100\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0010\u00101\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00102\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0018\u00103\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0010\u00104\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00105\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\fH\u0002J\b\u00107\u001a\u00020\fH\u0002J\u0018\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0016H\u0002J \u0010:\u001a\u00020\f2\u0006\u00109\u001a\u00020\u00142\u0006\u0010;\u001a\u00020<2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0018\u0010=\u001a\u00020\f2\u0006\u00109\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0010\u0010>\u001a\u00020*2\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010?\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0010\u0010@\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0018\u0010A\u001a\u00020\f2\u0006\u00109\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0010\u0010B\u001a\u00020\b2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0010\u0010C\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0018\u0010D\u001a\u00020\f2\u0006\u0010;\u001a\u00020E2\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0010\u0010F\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010G\u001a\u00020\f2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010L\u001a\u00020\f2\u0006\u00109\u001a\u00020\u0014H\u0002J\u0010\u0010M\u001a\u00020\f2\u0006\u00109\u001a\u00020\u0014H\u0002J\b\u0010N\u001a\u00020\fH\u0002J\u0018\u0010O\u001a\u00020\f2\u0006\u00109\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0016H\u0002J\u0018\u0010P\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u0014H\u0002J \u0010R\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0014H\u0002J\u0010\u0010S\u001a\u00020\f2\u0006\u0010;\u001a\u00020<H\u0002J\n\u0010T\u001a\u0004\u0018\u00010'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010#R\u0012\u0010$\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010%R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderCoordinator;", "", "context", "Landroid/content/Context;", "canNavigateBack", "", "onHeaderHeightChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "headerHeight", "", "onNavigationIconClick", "Lkotlin/Function0;", "<init>", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "wrappedContext", "Landroidx/appcompat/view/ContextThemeWrapper;", "appBarLayout", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderAppBarLayout;", "currentConfig", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigProviding;", "lastHeaderType", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;", "lastHidden", "lastTransparent", "attachedLeadingSubview", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewProviding;", "attachedCenterSubview", "attachedTrailingSubview", "attachedBackgroundSubview", "lastBackgroundSubviewCollapseMode", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewCollapseMode;", "lastBackButtonVisible", "Ljava/lang/Boolean;", "lastBackButtonTintColor", "Ljava/lang/Integer;", "lastBackButtonIcon", "Landroid/graphics/drawable/Drawable;", "lastScrollFlags", "managedTitleView", "Landroidx/appcompat/widget/AppCompatTextView;", "applyHeaderConfig", "coordinatorLayout", "Lcom/swmansion/rnscreens/gamma/stack/header/StackHeaderCoordinatorLayout;", "config", "applyHeaderConfig$react_native_screens_release", "updateHeader", "removeHeader", "requiresRebuild", "rebuild", "teardown", "cacheRebuildTriggers", "clearCachedRebuildTriggers", "detachSubviews", "populateAppBar", "appBar", "populateTitleOrCenter", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "populateBackground", "createManagedTitleView", "applyProps", "applyBackgroundCollapseMode", "applyScrollFlags", "computeScrollFlags", "warnInvalidScrollFlagCombinations", "applyBackButton", "Lcom/google/android/material/appbar/MaterialToolbar;", "setContentBehavior", "removeContentBehavior", "appBarOffsetListener", "Lcom/google/android/material/appbar/AppBarLayout$OnOffsetChangedListener;", "appBarLayoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "attachAppBarListeners", "detachAppBarListeners", "syncShadowState", "updateSubviewOffsets", "updateSubviewOffset", "subview", "maybeApplyRTLCollapsingToolbarLayoutWorkaround", "moveDummyViewToFront", "resolveDefaultBackButtonIcon", "Companion", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackHeaderCoordinator {
    private static final String TAG = "StackHeaderCoordinator";
    private StackHeaderAppBarLayout appBarLayout;
    private final View.OnLayoutChangeListener appBarLayoutChangeListener;
    private final AppBarLayout.OnOffsetChangedListener appBarOffsetListener;
    private StackHeaderSubviewProviding attachedBackgroundSubview;
    private StackHeaderSubviewProviding attachedCenterSubview;
    private StackHeaderSubviewProviding attachedLeadingSubview;
    private StackHeaderSubviewProviding attachedTrailingSubview;
    private final boolean canNavigateBack;
    private StackHeaderConfigProviding currentConfig;
    private Drawable lastBackButtonIcon;
    private Integer lastBackButtonTintColor;
    private Boolean lastBackButtonVisible;
    private StackHeaderSubviewCollapseMode lastBackgroundSubviewCollapseMode;
    private StackHeaderType lastHeaderType;
    private boolean lastHidden;
    private Integer lastScrollFlags;
    private boolean lastTransparent;
    private AppCompatTextView managedTitleView;
    private final Function1<Integer, Unit> onHeaderHeightChanged;
    private final Function0<Unit> onNavigationIconClick;
    private final ContextThemeWrapper wrappedContext;

    /* JADX WARN: Multi-variable type inference failed */
    public StackHeaderCoordinator(Context context, boolean z, Function1<? super Integer, Unit> onHeaderHeightChanged, Function0<Unit> onNavigationIconClick) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onHeaderHeightChanged, "onHeaderHeightChanged");
        Intrinsics.checkNotNullParameter(onNavigationIconClick, "onNavigationIconClick");
        this.canNavigateBack = z;
        this.onHeaderHeightChanged = onHeaderHeightChanged;
        this.onNavigationIconClick = onNavigationIconClick;
        this.wrappedContext = new ContextThemeWrapper(context, R.style.Theme_Material3_DayNight_NoActionBar);
        this.appBarOffsetListener = new AppBarLayout.OnOffsetChangedListener() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinator$$ExternalSyntheticLambda2
            @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                this.f$0.syncShadowState();
            }
        };
        this.appBarLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinator$$ExternalSyntheticLambda3
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                this.f$0.syncShadowState();
            }
        };
    }

    public final void applyHeaderConfig$react_native_screens_release(StackHeaderCoordinatorLayout coordinatorLayout, StackHeaderConfigProviding config) {
        Intrinsics.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        this.currentConfig = config;
        if (config != null) {
            updateHeader(coordinatorLayout, config);
        } else {
            removeHeader(coordinatorLayout);
        }
    }

    private final void updateHeader(StackHeaderCoordinatorLayout coordinatorLayout, StackHeaderConfigProviding config) {
        if (requiresRebuild(config)) {
            rebuild(coordinatorLayout, config);
        }
        applyProps(config);
    }

    private final void removeHeader(StackHeaderCoordinatorLayout coordinatorLayout) {
        teardown(coordinatorLayout);
        removeContentBehavior(coordinatorLayout);
        coordinatorLayout.requestLayout();
    }

    private final boolean requiresRebuild(StackHeaderConfigProviding config) {
        if (config.getType() != this.lastHeaderType || config.getHidden() != this.lastHidden || config.getTransparent() != this.lastTransparent || config.getLeadingSubview() != this.attachedLeadingSubview || config.getCenterSubview() != this.attachedCenterSubview || config.getTrailingSubview() != this.attachedTrailingSubview || config.getBackgroundSubview() != this.attachedBackgroundSubview) {
            return true;
        }
        if (!(this.appBarLayout instanceof StackHeaderAppBarLayout.Collapsing)) {
            return false;
        }
        StackHeaderSubviewProviding backgroundSubview = config.getBackgroundSubview();
        return (backgroundSubview != null ? backgroundSubview.getCollapseMode() : null) != this.lastBackgroundSubviewCollapseMode;
    }

    private final void rebuild(StackHeaderCoordinatorLayout coordinatorLayout, StackHeaderConfigProviding config) {
        teardown(coordinatorLayout);
        if (!config.getHidden()) {
            StackHeaderAppBarLayout stackHeaderAppBarLayoutCreate = StackHeaderAppBarLayout.INSTANCE.create(this.wrappedContext, config.getType());
            this.appBarLayout = stackHeaderAppBarLayoutCreate;
            if (config.getTransparent()) {
                removeContentBehavior(coordinatorLayout);
                coordinatorLayout.addView(stackHeaderAppBarLayoutCreate);
            } else {
                coordinatorLayout.addView(stackHeaderAppBarLayoutCreate, 0);
                setContentBehavior(coordinatorLayout);
            }
            stackHeaderAppBarLayoutCreate.requestApplyInsets();
            attachAppBarListeners(stackHeaderAppBarLayoutCreate);
            populateAppBar(stackHeaderAppBarLayoutCreate, config);
            maybeApplyRTLCollapsingToolbarLayoutWorkaround(coordinatorLayout, config, stackHeaderAppBarLayoutCreate);
            stackHeaderAppBarLayoutCreate.getToolbar().requestLayout();
        } else {
            removeContentBehavior(coordinatorLayout);
            coordinatorLayout.requestLayout();
        }
        cacheRebuildTriggers(config);
    }

    private final void teardown(StackHeaderCoordinatorLayout coordinatorLayout) {
        detachSubviews();
        StackHeaderAppBarLayout stackHeaderAppBarLayout = this.appBarLayout;
        if (stackHeaderAppBarLayout != null) {
            detachAppBarListeners(stackHeaderAppBarLayout);
            coordinatorLayout.removeView(stackHeaderAppBarLayout);
        }
        this.appBarLayout = null;
        this.managedTitleView = null;
        this.lastBackButtonVisible = null;
        this.lastBackButtonTintColor = null;
        this.lastBackButtonIcon = null;
        this.lastScrollFlags = null;
        clearCachedRebuildTriggers();
    }

    private final void cacheRebuildTriggers(StackHeaderConfigProviding config) {
        this.lastHeaderType = config.getType();
        this.lastHidden = config.getHidden();
        this.lastTransparent = config.getTransparent();
        this.attachedLeadingSubview = config.getLeadingSubview();
        this.attachedCenterSubview = config.getCenterSubview();
        this.attachedTrailingSubview = config.getTrailingSubview();
        this.attachedBackgroundSubview = config.getBackgroundSubview();
        StackHeaderSubviewProviding backgroundSubview = config.getBackgroundSubview();
        this.lastBackgroundSubviewCollapseMode = backgroundSubview != null ? backgroundSubview.getCollapseMode() : null;
    }

    private final void clearCachedRebuildTriggers() {
        this.lastHeaderType = null;
        this.lastHidden = false;
        this.lastTransparent = false;
        this.attachedLeadingSubview = null;
        this.attachedCenterSubview = null;
        this.attachedTrailingSubview = null;
        this.attachedBackgroundSubview = null;
        this.lastBackgroundSubviewCollapseMode = null;
    }

    private final void detachSubviews() {
        StackHeaderSubviewProviding stackHeaderSubviewProviding;
        StackHeaderAppBarLayout stackHeaderAppBarLayout = this.appBarLayout;
        if (stackHeaderAppBarLayout == null) {
            return;
        }
        StackHeaderSubviewProviding stackHeaderSubviewProviding2 = this.attachedLeadingSubview;
        if (stackHeaderSubviewProviding2 != null) {
            stackHeaderAppBarLayout.getToolbar().removeView(stackHeaderSubviewProviding2.getView());
        }
        StackHeaderSubviewProviding stackHeaderSubviewProviding3 = this.attachedCenterSubview;
        if (stackHeaderSubviewProviding3 != null) {
            stackHeaderAppBarLayout.getToolbar().removeView(stackHeaderSubviewProviding3.getView());
        }
        StackHeaderSubviewProviding stackHeaderSubviewProviding4 = this.attachedTrailingSubview;
        if (stackHeaderSubviewProviding4 != null) {
            stackHeaderAppBarLayout.getToolbar().removeView(stackHeaderSubviewProviding4.getView());
        }
        if (!(stackHeaderAppBarLayout instanceof StackHeaderAppBarLayout.Collapsing) || (stackHeaderSubviewProviding = this.attachedBackgroundSubview) == null) {
            return;
        }
        ViewParent parent = stackHeaderSubviewProviding.getView().getParent();
        FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeView(stackHeaderSubviewProviding.getView());
        ((StackHeaderAppBarLayout.Collapsing) stackHeaderAppBarLayout).getCollapsingToolbarLayout().removeView(frameLayout);
    }

    private final void populateAppBar(StackHeaderAppBarLayout appBar, StackHeaderConfigProviding config) {
        MaterialToolbar toolbar = appBar.getToolbar();
        StackHeaderSubviewProviding leadingSubview = config.getLeadingSubview();
        if (leadingSubview != null) {
            ViewExtKt.detachFromCurrentParent(leadingSubview.getView());
            toolbar.addView(leadingSubview.getView(), new Toolbar.LayoutParams(-2, -2, GravityCompat.START));
        }
        StackHeaderSubviewProviding trailingSubview = config.getTrailingSubview();
        if (trailingSubview != null) {
            ViewExtKt.detachFromCurrentParent(trailingSubview.getView());
            toolbar.addView(trailingSubview.getView(), new Toolbar.LayoutParams(-2, -2, GravityCompat.END));
        }
        populateTitleOrCenter(appBar, toolbar, config);
        populateBackground(appBar, config);
    }

    private final void populateTitleOrCenter(StackHeaderAppBarLayout appBar, Toolbar toolbar, StackHeaderConfigProviding config) {
        StackHeaderSubviewProviding centerSubview = config.getCenterSubview();
        if (centerSubview != null) {
            if (appBar instanceof StackHeaderAppBarLayout.Small) {
                toolbar.removeView(this.managedTitleView);
                this.managedTitleView = null;
                ViewExtKt.detachFromCurrentParent(centerSubview.getView());
                toolbar.addView(centerSubview.getView(), new Toolbar.LayoutParams(-2, -2, 1));
                return;
            }
            Log.e(TAG, "[RNScreens] Center subview is supported only for small header type.");
            return;
        }
        if (appBar instanceof StackHeaderAppBarLayout.Small) {
            AppCompatTextView appCompatTextViewCreateManagedTitleView = createManagedTitleView(toolbar);
            this.managedTitleView = appCompatTextViewCreateManagedTitleView;
            toolbar.addView(appCompatTextViewCreateManagedTitleView, config.isRTL() ? 0 : -1, new Toolbar.LayoutParams(-2, -2, GravityCompat.START));
        }
    }

    private final void populateBackground(StackHeaderAppBarLayout appBar, StackHeaderConfigProviding config) {
        StackHeaderSubviewProviding backgroundSubview = config.getBackgroundSubview();
        if (backgroundSubview == null) {
            return;
        }
        if (!(appBar instanceof StackHeaderAppBarLayout.Collapsing)) {
            Log.e(TAG, "[RNScreens] Background subview is supported only for collapsing header types (medium, large).");
            return;
        }
        ViewExtKt.detachFromCurrentParent(backgroundSubview.getView());
        StackHeaderAppBarLayout.Collapsing collapsing = (StackHeaderAppBarLayout.Collapsing) appBar;
        FrameLayout frameLayout = new FrameLayout(collapsing.getContext());
        frameLayout.setFitsSystemWindows(true);
        frameLayout.addView(backgroundSubview.getView(), new FrameLayout.LayoutParams(-1, -1));
        CollapsingToolbarLayout.LayoutParams layoutParams = new CollapsingToolbarLayout.LayoutParams(-1, -1);
        layoutParams.setCollapseMode(backgroundSubview.getCollapseMode().toNativeCollapseMode$react_native_screens_release());
        Unit unit = Unit.INSTANCE;
        collapsing.getCollapsingToolbarLayout().addView(frameLayout, 0, layoutParams);
    }

    private final AppCompatTextView createManagedTitleView(Toolbar toolbar) {
        AppCompatTextView appCompatTextView = new AppCompatTextView(toolbar.getContext());
        appCompatTextView.setSingleLine();
        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
        TextViewCompat.setTextAppearance(appCompatTextView, R.style.TextAppearance_Material3_TitleLarge);
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -2, GravityCompat.START);
        layoutParams.setMarginStart(toolbar.getTitleMarginStart() + toolbar.getContentInsetStart());
        layoutParams.setMarginEnd(toolbar.getTitleMarginEnd());
        layoutParams.topMargin = toolbar.getTitleMarginTop();
        layoutParams.bottomMargin = toolbar.getTitleMarginBottom();
        appCompatTextView.setLayoutParams(layoutParams);
        return appCompatTextView;
    }

    private final void applyProps(StackHeaderConfigProviding config) {
        StackHeaderAppBarLayout stackHeaderAppBarLayout = this.appBarLayout;
        if (stackHeaderAppBarLayout == null) {
            return;
        }
        if (stackHeaderAppBarLayout instanceof StackHeaderAppBarLayout.Small) {
            AppCompatTextView appCompatTextView = this.managedTitleView;
            if (appCompatTextView != null) {
                appCompatTextView.setText(config.getTitle());
            }
            AppCompatTextView appCompatTextView2 = this.managedTitleView;
            if (appCompatTextView2 != null) {
                appCompatTextView2.requestLayout();
            }
        } else {
            if (!(stackHeaderAppBarLayout instanceof StackHeaderAppBarLayout.Collapsing)) {
                throw new NoWhenBranchMatchedException();
            }
            ((StackHeaderAppBarLayout.Collapsing) stackHeaderAppBarLayout).getCollapsingToolbarLayout().setTitle(config.getTitle());
            applyBackgroundCollapseMode(config);
        }
        applyScrollFlags(stackHeaderAppBarLayout, config);
        applyBackButton(stackHeaderAppBarLayout.getToolbar(), config);
    }

    private final void applyBackgroundCollapseMode(StackHeaderConfigProviding config) {
        int nativeCollapseMode$react_native_screens_release;
        StackHeaderSubviewProviding backgroundSubview = config.getBackgroundSubview();
        if (backgroundSubview == null) {
            return;
        }
        ViewParent parent = backgroundSubview.getView().getParent();
        FrameLayout frameLayout = parent instanceof FrameLayout ? (FrameLayout) parent : null;
        if (frameLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        CollapsingToolbarLayout.LayoutParams layoutParams2 = layoutParams instanceof CollapsingToolbarLayout.LayoutParams ? (CollapsingToolbarLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null || layoutParams2.getCollapseMode() == (nativeCollapseMode$react_native_screens_release = backgroundSubview.getCollapseMode().toNativeCollapseMode$react_native_screens_release())) {
            return;
        }
        layoutParams2.setCollapseMode(nativeCollapseMode$react_native_screens_release);
    }

    private final void applyScrollFlags(StackHeaderAppBarLayout appBar, StackHeaderConfigProviding config) {
        CollapsingToolbarLayout collapsingToolbarLayout;
        int iComputeScrollFlags = computeScrollFlags(config);
        Integer num = this.lastScrollFlags;
        if (num != null && iComputeScrollFlags == num.intValue()) {
            return;
        }
        this.lastScrollFlags = Integer.valueOf(iComputeScrollFlags);
        warnInvalidScrollFlagCombinations(config);
        if (appBar instanceof StackHeaderAppBarLayout.Small) {
            collapsingToolbarLayout = ((StackHeaderAppBarLayout.Small) appBar).getToolbar();
        } else {
            if (!(appBar instanceof StackHeaderAppBarLayout.Collapsing)) {
                throw new NoWhenBranchMatchedException();
            }
            collapsingToolbarLayout = ((StackHeaderAppBarLayout.Collapsing) appBar).getCollapsingToolbarLayout();
        }
        ViewGroup.LayoutParams layoutParams = collapsingToolbarLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
        layoutParams2.setScrollFlags(iComputeScrollFlags);
        collapsingToolbarLayout.setLayoutParams(layoutParams2);
        appBar.setExpanded(true, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    private final int computeScrollFlags(StackHeaderConfigProviding config) {
        boolean scrollFlagScroll = config.getScrollFlagScroll();
        ?? r1 = scrollFlagScroll;
        if (config.getScrollFlagEnterAlways()) {
            r1 = (scrollFlagScroll ? 1 : 0) | 4;
        }
        ?? r2 = r1;
        if (config.getScrollFlagEnterAlwaysCollapsed()) {
            r2 = (r1 == true ? 1 : 0) | 8;
        }
        ?? r3 = r2;
        if (config.getScrollFlagExitUntilCollapsed()) {
            r3 = (r2 == true ? 1 : 0) | 2;
        }
        return config.getScrollFlagSnap() ? r3 | 16 : r3;
    }

    private final void warnInvalidScrollFlagCombinations(StackHeaderConfigProviding config) {
        if ((config.getScrollFlagEnterAlways() || config.getScrollFlagEnterAlwaysCollapsed() || config.getScrollFlagExitUntilCollapsed() || config.getScrollFlagSnap()) && !config.getScrollFlagScroll()) {
            Log.e(TAG, "[RNScreens] scrollFlag* requires scrollFlagScroll to take effect.");
        }
        if (!config.getScrollFlagEnterAlwaysCollapsed() || config.getScrollFlagEnterAlways()) {
            return;
        }
        Log.e(TAG, "[RNScreens] scrollFlagEnterAlwaysCollapsed requires scrollFlagEnterAlways to take effect.");
    }

    private final void applyBackButton(MaterialToolbar toolbar, StackHeaderConfigProviding config) {
        boolean z = this.canNavigateBack && !config.getBackButtonHidden();
        boolean zAreEqual = Intrinsics.areEqual(Boolean.valueOf(z), this.lastBackButtonVisible);
        boolean z2 = config.getBackButtonIcon() != this.lastBackButtonIcon;
        boolean zAreEqual2 = Intrinsics.areEqual(config.getBackButtonTintColor(), this.lastBackButtonTintColor);
        if (zAreEqual && !z2 && zAreEqual2) {
            return;
        }
        this.lastBackButtonVisible = Boolean.valueOf(z);
        this.lastBackButtonIcon = config.getBackButtonIcon();
        this.lastBackButtonTintColor = config.getBackButtonTintColor();
        if (!z) {
            toolbar.setNavigationIcon((Drawable) null);
            toolbar.setNavigationOnClickListener(null);
            return;
        }
        toolbar.clearNavigationIconTint();
        Drawable backButtonIcon = config.getBackButtonIcon();
        if (backButtonIcon == null) {
            backButtonIcon = resolveDefaultBackButtonIcon();
        }
        toolbar.setNavigationIcon(backButtonIcon);
        Integer backButtonTintColor = config.getBackButtonTintColor();
        if (backButtonTintColor != null) {
            toolbar.setNavigationIconTint(backButtonTintColor.intValue());
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinator$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StackHeaderCoordinator.applyBackButton$lambda$12(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyBackButton$lambda$12(StackHeaderCoordinator stackHeaderCoordinator, View view) {
        stackHeaderCoordinator.onNavigationIconClick.invoke();
    }

    private final void setContentBehavior(StackHeaderCoordinatorLayout coordinatorLayout) {
        ViewGroup.LayoutParams layoutParams = coordinatorLayout.getStackScreenWrapper().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        if (layoutParams2.getBehavior() == null) {
            layoutParams2.setBehavior(new StackHeaderScrollingViewBehavior(new Function2() { // from class: com.swmansion.rnscreens.gamma.stack.header.StackHeaderCoordinator$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StackHeaderCoordinator.setContentBehavior$lambda$13(this.f$0, ((Integer) obj).intValue(), (View) obj2);
                }
            }));
            coordinatorLayout.getStackScreenWrapper().setLayoutParams(layoutParams2);
            coordinatorLayout.getStackScreenWrapper().requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setContentBehavior$lambda$13(StackHeaderCoordinator stackHeaderCoordinator, int i, View view) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        stackHeaderCoordinator.onHeaderHeightChanged.invoke(Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    private final void removeContentBehavior(StackHeaderCoordinatorLayout coordinatorLayout) {
        ViewGroup.LayoutParams layoutParams = coordinatorLayout.getStackScreenWrapper().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
        if (layoutParams2.getBehavior() != null) {
            layoutParams2.setBehavior(null);
            coordinatorLayout.getStackScreenWrapper().setLayoutParams(layoutParams2);
            this.onHeaderHeightChanged.invoke(0);
            coordinatorLayout.getStackScreenWrapper().requestLayout();
        }
    }

    private final void attachAppBarListeners(StackHeaderAppBarLayout appBar) {
        appBar.addOnOffsetChangedListener(this.appBarOffsetListener);
        appBar.addOnLayoutChangeListener(this.appBarLayoutChangeListener);
    }

    private final void detachAppBarListeners(StackHeaderAppBarLayout appBar) {
        appBar.removeOnOffsetChangedListener(this.appBarOffsetListener);
        appBar.removeOnLayoutChangeListener(this.appBarLayoutChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncShadowState() {
        StackHeaderAppBarLayout stackHeaderAppBarLayout;
        StackHeaderConfigProviding stackHeaderConfigProviding = this.currentConfig;
        if (stackHeaderConfigProviding == null || (stackHeaderAppBarLayout = this.appBarLayout) == null) {
            return;
        }
        stackHeaderConfigProviding.updateHeaderFrame(stackHeaderAppBarLayout.getWidth(), stackHeaderAppBarLayout.getHeight(), stackHeaderConfigProviding.getTransparent() ? stackHeaderAppBarLayout.getTop() : stackHeaderAppBarLayout.getTop() - stackHeaderAppBarLayout.getBottom());
        updateSubviewOffsets(stackHeaderAppBarLayout, stackHeaderConfigProviding);
    }

    private final void updateSubviewOffsets(StackHeaderAppBarLayout appBar, StackHeaderConfigProviding config) {
        StackHeaderSubviewProviding leadingSubview = config.getLeadingSubview();
        if (leadingSubview != null) {
            updateSubviewOffset(leadingSubview, appBar);
        }
        StackHeaderSubviewProviding centerSubview = config.getCenterSubview();
        if (centerSubview != null) {
            updateSubviewOffset(centerSubview, appBar);
        }
        StackHeaderSubviewProviding trailingSubview = config.getTrailingSubview();
        if (trailingSubview != null) {
            updateSubviewOffset(trailingSubview, appBar);
        }
        StackHeaderSubviewProviding backgroundSubview = config.getBackgroundSubview();
        if (backgroundSubview != null) {
            updateSubviewOffset(backgroundSubview, appBar);
        }
    }

    private final void updateSubviewOffset(StackHeaderSubviewProviding subview, StackHeaderAppBarLayout appBar) {
        View view = subview.getView();
        if (view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        appBar.getLocationInWindow(iArr);
        view.getLocationInWindow(iArr2);
        subview.updateContentOriginOffset(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
    }

    private final void maybeApplyRTLCollapsingToolbarLayoutWorkaround(StackHeaderCoordinatorLayout coordinatorLayout, StackHeaderConfigProviding config, StackHeaderAppBarLayout appBar) {
        if ((appBar instanceof StackHeaderAppBarLayout.Collapsing) && config.isRTL()) {
            appBar.measure(View.MeasureSpec.makeMeasureSpec(coordinatorLayout.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            moveDummyViewToFront(((StackHeaderAppBarLayout.Collapsing) appBar).getToolbar());
        }
    }

    private final void moveDummyViewToFront(Toolbar toolbar) {
        int childCount = toolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = toolbar.getChildAt(i);
            if (!(childAt instanceof StackHeaderSubview)) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                toolbar.removeViewAt(i);
                toolbar.addView(childAt, 0, layoutParams);
                return;
            }
        }
    }

    private final Drawable resolveDefaultBackButtonIcon() {
        return DrawableUtilsKt.resolveDrawableAttr(this.wrappedContext, androidx.appcompat.R.attr.homeAsUpIndicator);
    }
}
