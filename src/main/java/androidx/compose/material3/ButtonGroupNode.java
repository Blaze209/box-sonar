package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\n\u001a\u00020\u000b*\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/ButtonGroupNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "weight", "", "<init>", "(F)V", "getWeight", "()F", "setWeight", "modifyParentData", "Landroidx/compose/material3/ButtonGroupParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ButtonGroupNode extends Modifier.Node implements ParentDataModifierNode {
    public static final int $stable = 8;
    private float weight;

    public ButtonGroupNode(float f) {
        this.weight = f;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final void setWeight(float f) {
        this.weight = f;
    }

    @Override // androidx.compose.ui.node.ParentDataModifierNode
    public ButtonGroupParentData modifyParentData(Density density, Object obj) {
        ButtonGroupParentData buttonGroupParentData = obj instanceof ButtonGroupParentData ? (ButtonGroupParentData) obj : null;
        if (buttonGroupParentData == null) {
            buttonGroupParentData = new ButtonGroupParentData(0.0f, null, null, 7, null);
        }
        buttonGroupParentData.setWeight(this.weight);
        return buttonGroupParentData;
    }
}
