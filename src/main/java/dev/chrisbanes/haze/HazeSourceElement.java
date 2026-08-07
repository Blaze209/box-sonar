package dev.chrisbanes.haze;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Haze.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\f\u0010\u0015\u001a\u00020\u0013*\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J)\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Ldev/chrisbanes/haze/HazeSourceElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Ldev/chrisbanes/haze/HazeSourceNode;", "state", "Ldev/chrisbanes/haze/HazeState;", ViewProps.Z_INDEX, "", "key", "", "<init>", "(Ldev/chrisbanes/haze/HazeState;FLjava/lang/Object;)V", "getState", "()Ldev/chrisbanes/haze/HazeState;", "getZIndex", "()F", "getKey", "()Ljava/lang/Object;", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HazeSourceElement extends ModifierNodeElement<HazeSourceNode> {
    public static final int $stable = 0;
    private final Object key;
    private final HazeState state;
    private final float zIndex;

    public static /* synthetic */ HazeSourceElement copy$default(HazeSourceElement hazeSourceElement, HazeState hazeState, float f, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            hazeState = hazeSourceElement.state;
        }
        if ((i & 2) != 0) {
            f = hazeSourceElement.zIndex;
        }
        if ((i & 4) != 0) {
            obj = hazeSourceElement.key;
        }
        return hazeSourceElement.copy(hazeState, f, obj);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HazeState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getZIndex() {
        return this.zIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getKey() {
        return this.key;
    }

    public final HazeSourceElement copy(HazeState state, float zIndex, Object key) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new HazeSourceElement(state, zIndex, key);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HazeSourceElement)) {
            return false;
        }
        HazeSourceElement hazeSourceElement = (HazeSourceElement) other;
        return Intrinsics.areEqual(this.state, hazeSourceElement.state) && Float.compare(this.zIndex, hazeSourceElement.zIndex) == 0 && Intrinsics.areEqual(this.key, hazeSourceElement.key);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = ((this.state.hashCode() * 31) + Float.hashCode(this.zIndex)) * 31;
        Object obj = this.key;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "HazeSourceElement(state=" + this.state + ", zIndex=" + this.zIndex + ", key=" + this.key + ")";
    }

    public /* synthetic */ HazeSourceElement(HazeState hazeState, float f, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hazeState, (i & 2) != 0 ? 0.0f : f, (i & 4) != 0 ? null : obj);
    }

    public final HazeState getState() {
        return this.state;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final Object getKey() {
        return this.key;
    }

    public HazeSourceElement(HazeState state, float f, Object obj) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.zIndex = f;
        this.key = obj;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public HazeSourceNode getNode() {
        return new HazeSourceNode(this.state, this.zIndex, this.key);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(HazeSourceNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setState(this.state);
        node.setZIndex(this.zIndex);
        node.setKey(this.key);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName("hazeSource");
        inspectorInfo.getProperties().set(ViewProps.Z_INDEX, Float.valueOf(this.zIndex));
        inspectorInfo.getProperties().set("key", this.key);
    }
}
