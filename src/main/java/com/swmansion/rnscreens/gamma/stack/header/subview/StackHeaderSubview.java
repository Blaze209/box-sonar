package com.swmansion.rnscreens.gamma.stack.header.subview;

import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.rnscreens.ext.ViewExtKt;
import com.swmansion.rnscreens.gamma.common.ShadowStateProxy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: StackHeaderSubview.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0018\u00104\u001a\u00020'2\u0006\u00105\u001a\u00020)2\u0006\u00106\u001a\u00020)H\u0014J\b\u00107\u001a\u00020'H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@PX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001e8@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%*\u0004\b \u0010!R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewProviding;", "reactContext", "Lcom/facebook/react/bridge/ReactContext;", "<init>", "(Lcom/facebook/react/bridge/ReactContext;)V", "getReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "value", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewType;", "type", "getType", "()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewType;", "setType$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewType;)V", "<set-?>", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewCollapseMode;", "collapseMode", "getCollapseMode", "()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewCollapseMode;", "setCollapseMode$react_native_screens_release", "(Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewCollapseMode;)V", "collapseMode$delegate", "Lkotlin/properties/ReadWriteProperty;", "view", "getView", "()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;", "shadowStateProxy", "Lcom/swmansion/rnscreens/gamma/common/ShadowStateProxy;", "Lcom/facebook/react/uimanager/StateWrapper;", "stateWrapper", "getStateWrapper$react_native_screens_release$delegate", "(Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubview;)Ljava/lang/Object;", "getStateWrapper$react_native_screens_release", "()Lcom/facebook/react/uimanager/StateWrapper;", "setStateWrapper$react_native_screens_release", "(Lcom/facebook/react/uimanager/StateWrapper;)V", "updateContentOriginOffset", "", "x", "", "y", "onStackHeaderSubviewChangeListener", "Ljava/lang/ref/WeakReference;", "Lcom/swmansion/rnscreens/gamma/stack/header/subview/OnStackHeaderSubviewChangeListener;", "getOnStackHeaderSubviewChangeListener$react_native_screens_release", "()Ljava/lang/ref/WeakReference;", "setOnStackHeaderSubviewChangeListener$react_native_screens_release", "(Ljava/lang/ref/WeakReference;)V", "yogaWidth", "yogaHeight", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "requestLayout", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StackHeaderSubview extends ReactViewGroup implements StackHeaderSubviewProviding {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(StackHeaderSubview.class, "collapseMode", "getCollapseMode()Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewCollapseMode;", 0))};

    /* JADX INFO: renamed from: collapseMode$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty collapseMode;
    private WeakReference<OnStackHeaderSubviewChangeListener> onStackHeaderSubviewChangeListener;
    private final ReactContext reactContext;
    private final ShadowStateProxy shadowStateProxy;
    private StackHeaderSubviewType type;
    private final StackHeaderSubview view;
    private int yogaHeight;
    private int yogaWidth;

    public final ReactContext getReactContext() {
        return this.reactContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StackHeaderSubview(ReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        this.type = StackHeaderSubviewType.CENTER;
        Delegates delegates = Delegates.INSTANCE;
        final StackHeaderSubviewCollapseMode stackHeaderSubviewCollapseMode = StackHeaderSubviewCollapseMode.OFF;
        this.collapseMode = new ObservableProperty<StackHeaderSubviewCollapseMode>(stackHeaderSubviewCollapseMode) { // from class: com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubview$special$$inlined$observable$1
            @Override // kotlin.properties.ObservableProperty
            protected void afterChange(KProperty<?> property, StackHeaderSubviewCollapseMode oldValue, StackHeaderSubviewCollapseMode newValue) {
                WeakReference<OnStackHeaderSubviewChangeListener> onStackHeaderSubviewChangeListener$react_native_screens_release;
                OnStackHeaderSubviewChangeListener onStackHeaderSubviewChangeListener;
                Intrinsics.checkNotNullParameter(property, "property");
                if (oldValue == newValue || (onStackHeaderSubviewChangeListener$react_native_screens_release = this.getOnStackHeaderSubviewChangeListener$react_native_screens_release()) == null || (onStackHeaderSubviewChangeListener = onStackHeaderSubviewChangeListener$react_native_screens_release.get()) == null) {
                    return;
                }
                onStackHeaderSubviewChangeListener.onStackHeaderSubviewChange();
            }
        };
        this.view = this;
        this.shadowStateProxy = new ShadowStateProxy(false);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewProviding
    public StackHeaderSubviewType getType() {
        return this.type;
    }

    public void setType$react_native_screens_release(StackHeaderSubviewType stackHeaderSubviewType) {
        Intrinsics.checkNotNullParameter(stackHeaderSubviewType, "<set-?>");
        this.type = stackHeaderSubviewType;
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewProviding
    public StackHeaderSubviewCollapseMode getCollapseMode() {
        return (StackHeaderSubviewCollapseMode) this.collapseMode.getValue(this, $$delegatedProperties[0]);
    }

    public void setCollapseMode$react_native_screens_release(StackHeaderSubviewCollapseMode stackHeaderSubviewCollapseMode) {
        Intrinsics.checkNotNullParameter(stackHeaderSubviewCollapseMode, "<set-?>");
        this.collapseMode.setValue(this, $$delegatedProperties[0], stackHeaderSubviewCollapseMode);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewProviding
    public StackHeaderSubview getView() {
        return this.view;
    }

    public final StateWrapper getStateWrapper$react_native_screens_release() {
        return this.shadowStateProxy.getStateWrapper();
    }

    public final void setStateWrapper$react_native_screens_release(StateWrapper stateWrapper) {
        this.shadowStateProxy.setStateWrapper$react_native_screens_release(stateWrapper);
    }

    @Override // com.swmansion.rnscreens.gamma.stack.header.subview.StackHeaderSubviewProviding
    public void updateContentOriginOffset(int x, int y) {
        ShadowStateProxy.updateStateIfNeeded$default(this.shadowStateProxy, null, null, Integer.valueOf(x), Integer.valueOf(y), 3, null);
    }

    public final WeakReference<OnStackHeaderSubviewChangeListener> getOnStackHeaderSubviewChangeListener$react_native_screens_release() {
        return this.onStackHeaderSubviewChangeListener;
    }

    public final void setOnStackHeaderSubviewChangeListener$react_native_screens_release(WeakReference<OnStackHeaderSubviewChangeListener> weakReference) {
        this.onStackHeaderSubviewChangeListener = weakReference;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean z;
        int size;
        int size2;
        boolean z2 = true;
        if (View.MeasureSpec.getMode(widthMeasureSpec) != 1073741824 || (size2 = View.MeasureSpec.getSize(widthMeasureSpec)) == this.yogaWidth) {
            z = false;
        } else {
            this.yogaWidth = size2;
            z = true;
        }
        if (View.MeasureSpec.getMode(heightMeasureSpec) != 1073741824 || (size = View.MeasureSpec.getSize(heightMeasureSpec)) == this.yogaHeight) {
            z2 = z;
        } else {
            this.yogaHeight = size;
        }
        setMeasuredDimension(this.yogaWidth, this.yogaHeight);
        if (!z2 || isInLayout()) {
            return;
        }
        requestLayout();
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        forceLayout();
        View viewParentAsView = ViewExtKt.parentAsView(this);
        if (viewParentAsView != null) {
            viewParentAsView.requestLayout();
        }
    }
}
