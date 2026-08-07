package com.swmansion.rnscreens.gamma.stack.header.config;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.swmansion.rnscreens.gamma.common.ShadowStateProxy;
import com.swmansion.rnscreens.gamma.helpers.ImageLoaderKt;
import com.swmansion.rnscreens.gamma.helpers.SystemDrawableKt;
import com.swmansion.rnscreens.gamma.stack.header.subview.OnStackHeaderSubviewChangeListener;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubview;
import com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewType;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StackHeaderConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010G\u001a\u00020HH\u0000¢\u0006\u0002\bIJ \u0010`\u001a\u00020H2\u0006\u0010a\u001a\u00020#2\u0006\u0010b\u001a\u00020#2\u0006\u0010c\u001a\u00020#H\u0016J\u0012\u0010g\u001a\u00020H2\b\u0010h\u001a\u0004\u0018\u00010fH\u0016J\r\u0010i\u001a\u00020HH\u0000¢\u0006\u0002\bjJ\b\u0010k\u001a\u00020HH\u0016J\u0015\u0010l\u001a\u00020H2\u0006\u0010m\u001a\u00020JH\u0000¢\u0006\u0002\bnJ\u0015\u0010o\u001a\u00020H2\u0006\u0010m\u001a\u00020JH\u0000¢\u0006\u0002\bpJ\u0015\u0010q\u001a\u00020H2\u0006\u0010r\u001a\u00020#H\u0000¢\u0006\u0002\bsJ\r\u0010t\u001a\u00020HH\u0000¢\u0006\u0002\buJ\u0017\u0010y\u001a\u0004\u0018\u00010J2\u0006\u0010r\u001a\u00020#H\u0000¢\u0006\u0002\bzR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR$\u0010 \u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR*\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\n\u001a\u0004\u0018\u00010#@PX\u0096\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R(\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\n\u001a\u0004\u0018\u00010*@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR$\u00103\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001a\"\u0004\b5\u0010\u001cR$\u00106\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001a\"\u0004\b8\u0010\u001cR$\u00109\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001a\"\u0004\b;\u0010\u001cR$\u0010<\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001a\"\u0004\b>\u0010\u001cR\u001c\u0010?\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0014\"\u0004\bA\u0010\u0016R\u001c\u0010B\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0014\"\u0004\bD\u0010\u0016R\u0010\u0010E\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010K\u001a\u0004\u0018\u00010J2\b\u0010\n\u001a\u0004\u0018\u00010J@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\"\u0010N\u001a\u0004\u0018\u00010J2\b\u0010\n\u001a\u0004\u0018\u00010J@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bO\u0010MR\"\u0010P\u001a\u0004\u0018\u00010J2\b\u0010\n\u001a\u0004\u0018\u00010J@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010MR\"\u0010R\u001a\u0004\u0018\u00010J2\b\u0010\n\u001a\u0004\u0018\u00010J@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010MR\u0014\u0010T\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u001aR\u000e\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010W\u001a\u0004\u0018\u00010X8@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_*\u0004\bZ\u0010[R\u0016\u0010d\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010v\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bw\u0010x¨\u0006{"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfigProviding;", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/OnStackHeaderSubviewChangeListener;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "<init>", "(Lcom/facebook/react/bridge/ReactContext;)V", "getReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "value", "Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;", "type", "getType", "()Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;", "setType$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderType;)V", "", "title", "getTitle", "()Ljava/lang/String;", "setTitle$react_native_screens_release", "(Ljava/lang/String;)V", "", ViewProps.HIDDEN, "getHidden", "()Z", "setHidden$react_native_screens_release", "(Z)V", "transparent", "getTransparent", "setTransparent$react_native_screens_release", "backButtonHidden", "getBackButtonHidden", "setBackButtonHidden$react_native_screens_release", "", "backButtonTintColor", "getBackButtonTintColor", "()Ljava/lang/Integer;", "setBackButtonTintColor$react_native_screens_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Landroid/graphics/drawable/Drawable;", "backButtonIcon", "getBackButtonIcon", "()Landroid/graphics/drawable/Drawable;", "setBackButtonIcon$react_native_screens_release", "(Landroid/graphics/drawable/Drawable;)V", "scrollFlagScroll", "getScrollFlagScroll", "setScrollFlagScroll$react_native_screens_release", "scrollFlagEnterAlways", "getScrollFlagEnterAlways", "setScrollFlagEnterAlways$react_native_screens_release", "scrollFlagEnterAlwaysCollapsed", "getScrollFlagEnterAlwaysCollapsed", "setScrollFlagEnterAlwaysCollapsed$react_native_screens_release", "scrollFlagExitUntilCollapsed", "getScrollFlagExitUntilCollapsed", "setScrollFlagExitUntilCollapsed$react_native_screens_release", "scrollFlagSnap", "getScrollFlagSnap", "setScrollFlagSnap$react_native_screens_release", "backButtonDrawableIconResourceName", "getBackButtonDrawableIconResourceName$react_native_screens_release", "setBackButtonDrawableIconResourceName$react_native_screens_release", "backButtonImageIconUri", "getBackButtonImageIconUri$react_native_screens_release", "setBackButtonImageIconUri$react_native_screens_release", "lastResolvedDrawableIconResourceName", "lastResolvedImageIconUri", "resolveBackButtonIconIfNeeded", "", "resolveBackButtonIconIfNeeded$react_native_screens_release", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", "backgroundSubview", "getBackgroundSubview", "()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", "leadingSubview", "getLeadingSubview", "centerSubview", "getCenterSubview", "trailingSubview", "getTrailingSubview", "isRTL", "shadowStateProxy", "Lcom/swmansion/rnscreens/gamma/common/ShadowStateProxy;", "<set-?>", "Lcom/facebook/react/uimanager/StateWrapper;", "stateWrapper", "getStateWrapper$react_native_screens_release$delegate", "(Lcom/swmansion/rnscreens/gamma/stack/header/config/StackHeaderConfig;)Ljava/lang/Object;", "getStateWrapper$react_native_screens_release", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper$react_native_screens_release", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "updateHeaderFrame", "width", "height", "contentOffsetY", "onConfigChangeListener", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/rnscreens/gamma/stack/header/config/OnHeaderConfigChangeListener;", "setOnConfigChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "notifyConfigChanged", "notifyConfigChanged$react_native_screens_release", "onStackHeaderSubviewChange", "addConfigSubview", "headerSubview", "addConfigSubview$react_native_screens_release", "removeConfigSubview", "removeConfigSubview$react_native_screens_release", "removeConfigSubviewAt", FirebaseAnalytics.Param.INDEX, "removeConfigSubviewAt$react_native_screens_release", "removeAllConfigSubviews", "removeAllConfigSubviews$react_native_screens_release", "configSubviewsCount", "getConfigSubviewsCount$react_native_screens_release", "()I", "getConfigSubviewAt", "getConfigSubviewAt$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackHeaderConfig extends ReactViewGroup implements StackHeaderConfigProviding, OnStackHeaderSubviewChangeListener {
    private String backButtonDrawableIconResourceName;
    private boolean backButtonHidden;
    private Drawable backButtonIcon;
    private String backButtonImageIconUri;
    private Integer backButtonTintColor;
    private StackHeaderSubview backgroundSubview;
    private StackHeaderSubview centerSubview;
    private boolean hidden;
    private String lastResolvedDrawableIconResourceName;
    private String lastResolvedImageIconUri;
    private StackHeaderSubview leadingSubview;
    private WeakReference<OnHeaderConfigChangeListener> onConfigChangeListener;
    private final ReactContext reactContext;
    private boolean scrollFlagEnterAlways;
    private boolean scrollFlagEnterAlwaysCollapsed;
    private boolean scrollFlagExitUntilCollapsed;
    private boolean scrollFlagScroll;
    private boolean scrollFlagSnap;
    private final ShadowStateProxy shadowStateProxy;
    private String title;
    private StackHeaderSubview trailingSubview;
    private boolean transparent;
    private StackHeaderType type;

    /* JADX INFO: compiled from: StackHeaderConfig.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackHeaderSubviewType.values().length];
            try {
                iArr[StackHeaderSubviewType.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackHeaderSubviewType.LEADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[StackHeaderSubviewType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[StackHeaderSubviewType.TRAILING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final ReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackHeaderConfig(ReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.type = StackHeaderType.SMALL;
        this.title = "";
        this.shadowStateProxy = new ShadowStateProxy(false, 1, null);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public StackHeaderType getType() {
        return this.type;
    }

    public void setType$react_native_screens_release(StackHeaderType stackHeaderType) {
        Intrinsics.checkNotNullParameter(stackHeaderType, "<set-?>");
        this.type = stackHeaderType;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public String getTitle() {
        return this.title;
    }

    public void setTitle$react_native_screens_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public boolean getHidden() {
        return this.hidden;
    }

    public void setHidden$react_native_screens_release(boolean z) {
        this.hidden = z;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public boolean getTransparent() {
        return this.transparent;
    }

    public void setTransparent$react_native_screens_release(boolean z) {
        this.transparent = z;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public boolean getBackButtonHidden() {
        return this.backButtonHidden;
    }

    public void setBackButtonHidden$react_native_screens_release(boolean z) {
        this.backButtonHidden = z;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public Integer getBackButtonTintColor() {
        return this.backButtonTintColor;
    }

    public void setBackButtonTintColor$react_native_screens_release(Integer num) {
        this.backButtonTintColor = num;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public Drawable getBackButtonIcon() {
        return this.backButtonIcon;
    }

    public void setBackButtonIcon$react_native_screens_release(Drawable drawable) {
        this.backButtonIcon = drawable;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public boolean getScrollFlagScroll() {
        return this.scrollFlagScroll;
    }

    public void setScrollFlagScroll$react_native_screens_release(boolean z) {
        this.scrollFlagScroll = z;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public boolean getScrollFlagEnterAlways() {
        return this.scrollFlagEnterAlways;
    }

    public void setScrollFlagEnterAlways$react_native_screens_release(boolean z) {
        this.scrollFlagEnterAlways = z;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public boolean getScrollFlagEnterAlwaysCollapsed() {
        return this.scrollFlagEnterAlwaysCollapsed;
    }

    public void setScrollFlagEnterAlwaysCollapsed$react_native_screens_release(boolean z) {
        this.scrollFlagEnterAlwaysCollapsed = z;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public boolean getScrollFlagExitUntilCollapsed() {
        return this.scrollFlagExitUntilCollapsed;
    }

    public void setScrollFlagExitUntilCollapsed$react_native_screens_release(boolean z) {
        this.scrollFlagExitUntilCollapsed = z;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public boolean getScrollFlagSnap() {
        return this.scrollFlagSnap;
    }

    public void setScrollFlagSnap$react_native_screens_release(boolean z) {
        this.scrollFlagSnap = z;
    }

    /* JADX INFO: renamed from: getBackButtonDrawableIconResourceName$react_native_screens_release, reason: from getter */
    public final String getBackButtonDrawableIconResourceName() {
        return this.backButtonDrawableIconResourceName;
    }

    public final void setBackButtonDrawableIconResourceName$react_native_screens_release(String str) {
        this.backButtonDrawableIconResourceName = str;
    }

    /* JADX INFO: renamed from: getBackButtonImageIconUri$react_native_screens_release, reason: from getter */
    public final String getBackButtonImageIconUri() {
        return this.backButtonImageIconUri;
    }

    public final void setBackButtonImageIconUri$react_native_screens_release(String str) {
        this.backButtonImageIconUri = str;
    }

    public final void resolveBackButtonIconIfNeeded$react_native_screens_release() {
        String str = this.backButtonDrawableIconResourceName;
        final String str2 = this.backButtonImageIconUri;
        if (Intrinsics.areEqual(str, this.lastResolvedDrawableIconResourceName) && Intrinsics.areEqual(str2, this.lastResolvedImageIconUri)) {
            return;
        }
        this.lastResolvedDrawableIconResourceName = str;
        this.lastResolvedImageIconUri = str2;
        if (str != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            setBackButtonIcon$react_native_screens_release(SystemDrawableKt.getSystemDrawableResource(context, str));
        } else {
            if (str2 != null) {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                ImageLoaderKt.loadImage(context2, str2, new Function1() { // from class: com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfig$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StackHeaderConfig.resolveBackButtonIconIfNeeded$lambda$0(str2, this, (Drawable) obj);
                    }
                });
                return;
            }
            setBackButtonIcon$react_native_screens_release(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveBackButtonIconIfNeeded$lambda$0(String str, StackHeaderConfig stackHeaderConfig, Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (Intrinsics.areEqual(str, stackHeaderConfig.lastResolvedImageIconUri)) {
            stackHeaderConfig.setBackButtonIcon$react_native_screens_release(drawable);
            stackHeaderConfig.notifyConfigChanged$react_native_screens_release();
        }
        return Unit.INSTANCE;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public StackHeaderSubview getBackgroundSubview() {
        return this.backgroundSubview;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public StackHeaderSubview getLeadingSubview() {
        return this.leadingSubview;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public StackHeaderSubview getCenterSubview() {
        return this.centerSubview;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public StackHeaderSubview getTrailingSubview() {
        return this.trailingSubview;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public boolean isRTL() {
        return getLayoutDirection() == 1;
    }

    public final StateWrapper getStateWrapper$react_native_screens_release() {
        return this.shadowStateProxy.getStateWrapper();
    }

    public final void setStateWrapper$react_native_screens_release(StateWrapper stateWrapper) {
        this.shadowStateProxy.setStateWrapper$react_native_screens_release(stateWrapper);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public void updateHeaderFrame(int width, int height, int contentOffsetY) {
        ShadowStateProxy.updateStateIfNeeded$default(this.shadowStateProxy, Integer.valueOf(width), Integer.valueOf(height), null, Integer.valueOf(contentOffsetY), 4, null);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.config.StackHeaderConfigProviding
    public void setOnConfigChangeListener(OnHeaderConfigChangeListener listener) {
        this.onConfigChangeListener = listener != null ? new WeakReference<>(listener) : null;
    }

    public final void notifyConfigChanged$react_native_screens_release() {
        OnHeaderConfigChangeListener onHeaderConfigChangeListener;
        WeakReference<OnHeaderConfigChangeListener> weakReference = this.onConfigChangeListener;
        if (weakReference == null || (onHeaderConfigChangeListener = weakReference.get()) == null) {
            return;
        }
        onHeaderConfigChangeListener.onHeaderConfigChange(this);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.subview.OnStackHeaderSubviewChangeListener
    public void onStackHeaderSubviewChange() {
        notifyConfigChanged$react_native_screens_release();
    }

    public final void addConfigSubview$react_native_screens_release(StackHeaderSubview headerSubview) {
        Intrinsics.checkNotNullParameter(headerSubview, "headerSubview");
        int i = WhenMappings.$EnumSwitchMapping$0[headerSubview.getType().ordinal()];
        if (i == 1) {
            this.backgroundSubview = headerSubview;
        } else if (i == 2) {
            this.leadingSubview = headerSubview;
        } else if (i == 3) {
            this.centerSubview = headerSubview;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            this.trailingSubview = headerSubview;
        }
        headerSubview.setOnStackHeaderSubviewChangeListener$react_native_screens_release(new WeakReference<>(this));
        notifyConfigChanged$react_native_screens_release();
    }

    public final void removeConfigSubview$react_native_screens_release(StackHeaderSubview headerSubview) {
        Intrinsics.checkNotNullParameter(headerSubview, "headerSubview");
        headerSubview.setOnStackHeaderSubviewChangeListener$react_native_screens_release(null);
        int i = WhenMappings.$EnumSwitchMapping$0[headerSubview.getType().ordinal()];
        if (i == 1) {
            this.backgroundSubview = null;
        } else if (i == 2) {
            this.leadingSubview = null;
        } else if (i == 3) {
            this.centerSubview = null;
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            this.trailingSubview = null;
        }
        notifyConfigChanged$react_native_screens_release();
    }

    public final void removeConfigSubviewAt$react_native_screens_release(int index) {
        StackHeaderSubview configSubviewAt$react_native_screens_release = getConfigSubviewAt$react_native_screens_release(index);
        if (configSubviewAt$react_native_screens_release != null) {
            removeConfigSubview$react_native_screens_release(configSubviewAt$react_native_screens_release);
        }
    }

    public final void removeAllConfigSubviews$react_native_screens_release() {
        StackHeaderSubview backgroundSubview = getBackgroundSubview();
        if (backgroundSubview != null) {
            removeConfigSubview$react_native_screens_release(backgroundSubview);
        }
        StackHeaderSubview leadingSubview = getLeadingSubview();
        if (leadingSubview != null) {
            removeConfigSubview$react_native_screens_release(leadingSubview);
        }
        StackHeaderSubview centerSubview = getCenterSubview();
        if (centerSubview != null) {
            removeConfigSubview$react_native_screens_release(centerSubview);
        }
        StackHeaderSubview trailingSubview = getTrailingSubview();
        if (trailingSubview != null) {
            removeConfigSubview$react_native_screens_release(trailingSubview);
        }
    }

    public final int getConfigSubviewsCount$react_native_screens_release() {
        return CollectionsKt.listOfNotNull((Object[]) new StackHeaderSubview[]{getBackgroundSubview(), getLeadingSubview(), getCenterSubview(), getTrailingSubview()}).size();
    }

    public final StackHeaderSubview getConfigSubviewAt$react_native_screens_release(int index) {
        return (StackHeaderSubview) CollectionsKt.getOrNull(CollectionsKt.listOfNotNull((Object[]) new StackHeaderSubview[]{getBackgroundSubview(), getLeadingSubview(), getCenterSubview(), getTrailingSubview()}), index);
    }
}
