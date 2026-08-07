package dev.chrisbanes.haze;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HazeChild.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u001b\b\u0002\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\f\u0010\u0017\u001a\u00020\n*\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u001c\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bHÆ\u0003J:\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001b\b\u0002\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Ldev/chrisbanes/haze/HazeEffectNodeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Ldev/chrisbanes/haze/HazeEffectNode;", "state", "Ldev/chrisbanes/haze/HazeState;", "style", "Ldev/chrisbanes/haze/HazeStyle;", "block", "Lkotlin/Function1;", "Ldev/chrisbanes/haze/HazeEffectScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Ldev/chrisbanes/haze/HazeState;Ldev/chrisbanes/haze/HazeStyle;Lkotlin/jvm/functions/Function1;)V", "getState", "()Ldev/chrisbanes/haze/HazeState;", "getStyle", "()Ldev/chrisbanes/haze/HazeStyle;", "getBlock", "()Lkotlin/jvm/functions/Function1;", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "haze_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final /* data */ class HazeEffectNodeElement extends ModifierNodeElement<HazeEffectNode> {
    private final Function1<HazeEffectScope, Unit> block;
    private final HazeState state;
    private final HazeStyle style;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HazeEffectNodeElement copy$default(HazeEffectNodeElement hazeEffectNodeElement, HazeState hazeState, HazeStyle hazeStyle, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            hazeState = hazeEffectNodeElement.state;
        }
        if ((i & 2) != 0) {
            hazeStyle = hazeEffectNodeElement.style;
        }
        if ((i & 4) != 0) {
            function1 = hazeEffectNodeElement.block;
        }
        return hazeEffectNodeElement.copy(hazeState, hazeStyle, function1);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HazeState getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final HazeStyle getStyle() {
        return this.style;
    }

    public final Function1<HazeEffectScope, Unit> component3() {
        return this.block;
    }

    public final HazeEffectNodeElement copy(HazeState state, HazeStyle style, Function1<? super HazeEffectScope, Unit> block) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(style, "style");
        return new HazeEffectNodeElement(state, style, block);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HazeEffectNodeElement)) {
            return false;
        }
        HazeEffectNodeElement hazeEffectNodeElement = (HazeEffectNodeElement) other;
        return Intrinsics.areEqual(this.state, hazeEffectNodeElement.state) && Intrinsics.areEqual(this.style, hazeEffectNodeElement.style) && Intrinsics.areEqual(this.block, hazeEffectNodeElement.block);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int iHashCode = ((this.state.hashCode() * 31) + this.style.hashCode()) * 31;
        Function1<HazeEffectScope, Unit> function1 = this.block;
        return iHashCode + (function1 == null ? 0 : function1.hashCode());
    }

    public String toString() {
        return "HazeEffectNodeElement(state=" + this.state + ", style=" + this.style + ", block=" + this.block + ")";
    }

    public final HazeState getState() {
        return this.state;
    }

    public /* synthetic */ HazeEffectNodeElement(HazeState hazeState, HazeStyle hazeStyle, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(hazeState, (i & 2) != 0 ? HazeStyle.INSTANCE.getUnspecified() : hazeStyle, (i & 4) != 0 ? null : function1);
    }

    public final HazeStyle getStyle() {
        return this.style;
    }

    public final Function1<HazeEffectScope, Unit> getBlock() {
        return this.block;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HazeEffectNodeElement(HazeState state, HazeStyle style, Function1<? super HazeEffectScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(style, "style");
        this.state = state;
        this.style = style;
        this.block = function1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public HazeEffectNode getNode() {
        return new HazeEffectNode(this.state, this.style, this.block);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(HazeEffectNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        node.setState(this.state);
        node.setStyle(this.style);
        node.setBlock(this.block);
        node.update$haze_release();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "<this>");
        inspectorInfo.setName(HazeEffectNode.TAG);
    }
}
