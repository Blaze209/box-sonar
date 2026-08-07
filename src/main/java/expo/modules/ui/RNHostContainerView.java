package expo.modules.ui;

import android.content.Context;
import android.view.View;
import com.facebook.react.ReactRootView;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.views.ShadowNodeProxy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNHostView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lexpo/modules/ui/RNHostContainerView;", "Lcom/facebook/react/ReactRootView;", "context", "Landroid/content/Context;", "shadowNodeProxy", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/views/ShadowNodeProxy;", "<init>", "(Landroid/content/Context;Ljava/lang/ref/WeakReference;)V", "matchContents", "", "getMatchContents", "()Z", "setMatchContents", "(Z)V", "onLayout", "", "changed", "left", "", ViewProps.TOP, "right", ViewProps.BOTTOM, "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RNHostContainerView extends ReactRootView {
    public static final int $stable = 8;
    private boolean matchContents;
    private final WeakReference<ShadowNodeProxy> shadowNodeProxy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RNHostContainerView(Context context, WeakReference<ShadowNodeProxy> shadowNodeProxy) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shadowNodeProxy, "shadowNodeProxy");
        this.shadowNodeProxy = shadowNodeProxy;
    }

    public final boolean getMatchContents() {
        return this.matchContents;
    }

    public final void setMatchContents(boolean z) {
        this.matchContents = z;
    }

    @Override // com.facebook.react.ReactRootView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.matchContents && getChildCount() > 1) {
            View childAt = getChildAt(0);
            ShadowNodeProxy shadowNodeProxy = this.shadowNodeProxy.get();
            if (shadowNodeProxy != null) {
                shadowNodeProxy.setViewSize(childAt.getWidth(), childAt.getHeight());
                return;
            }
            return;
        }
        ShadowNodeProxy shadowNodeProxy2 = this.shadowNodeProxy.get();
        if (shadowNodeProxy2 != null) {
            shadowNodeProxy2.setViewSize(getWidth(), getHeight());
        }
    }
}
