package expo.modules.kotlin.views;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.uimanager.StateWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShadowNodeProxy.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u001f\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0011R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00030\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lexpo/modules/kotlin/views/ShadowNodeProxy;", "", "expoView", "Lexpo/modules/kotlin/views/ExpoView;", "<init>", "(Lexpo/modules/kotlin/views/ExpoView;)V", "weakExpoView", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getWeakExpoView", "()Ljava/lang/ref/WeakReference;", "setViewSize", "", "width", "", "height", "setStyleSize", "(Ljava/lang/Double;Ljava/lang/Double;)V", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShadowNodeProxy {
    public static final int $stable = 8;
    private final WeakReference<ExpoView> weakExpoView;

    public ShadowNodeProxy(ExpoView expoView) {
        Intrinsics.checkNotNullParameter(expoView, "expoView");
        this.weakExpoView = new WeakReference<>(expoView);
    }

    public final WeakReference<ExpoView> getWeakExpoView() {
        return this.weakExpoView;
    }

    public final void setViewSize(double width, double height) {
        StateWrapper stateWrapper;
        ExpoView expoView = this.weakExpoView.get();
        if (expoView == null || (stateWrapper = expoView.getStateWrapper()) == null) {
            return;
        }
        stateWrapper.updateState(Arguments.makeNativeMap((Map<String, ? extends Object>) MapsKt.mapOf(TuplesKt.to("width", Double.valueOf(width)), TuplesKt.to("height", Double.valueOf(height)))));
    }

    public final void setStyleSize(Double width, Double height) {
        StateWrapper stateWrapper;
        ExpoView expoView = this.weakExpoView.get();
        if (expoView == null || (stateWrapper = expoView.getStateWrapper()) == null) {
            return;
        }
        stateWrapper.updateState(Arguments.makeNativeMap((Map<String, ? extends Object>) MapsKt.mapOf(TuplesKt.to("styleWidth", width), TuplesKt.to("styleHeight", height))));
    }
}
