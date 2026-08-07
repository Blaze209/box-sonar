package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FloatingActionButtonMenu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/MenuItemVisibilityModifier;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "isVisible", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", ViewProps.VISIBLE, "getVisible", "()Lkotlin/jvm/functions/Function0;", "setVisible", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "shouldClearDescendantSemantics", "getShouldClearDescendantSemantics", "()Z", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MenuItemVisibilityModifier extends Modifier.Node implements ParentDataModifierNode, SemanticsModifierNode {
    private Function0<Boolean> visible;

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public Object modifyParentData(Density density, Object obj) {
        return this;
    }

    public MenuItemVisibilityModifier(Function0<Boolean> function0) {
        this.visible = function0;
    }

    public final Function0<Boolean> getVisible() {
        return this.visible;
    }

    public final void setVisible(Function0<Boolean> function0) {
        this.visible = function0;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    /* JADX INFO: renamed from: getShouldClearDescendantSemantics */
    public boolean getIsClearingSemantics() {
        return !this.visible.invoke().booleanValue();
    }
}
