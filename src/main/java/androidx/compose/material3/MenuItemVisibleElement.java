package androidx.compose.material3;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FloatingActionButtonMenu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\f\u0010\f\u001a\u00020\n*\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/MenuItemVisibleElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/MenuItemVisibilityModifier;", "isVisible", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class MenuItemVisibleElement extends ModifierNodeElement<MenuItemVisibilityModifier> {
    private final Function0<Boolean> isVisible;

    public MenuItemVisibleElement(Function0<Boolean> function0) {
        this.isVisible = function0;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: create */
    public MenuItemVisibilityModifier getNode() {
        return new MenuItemVisibilityModifier(this.isVisible);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(MenuItemVisibilityModifier node) {
        node.setVisible(this.isVisible);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("itemVisible");
        inspectorInfo.setValue(this.isVisible.invoke());
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other != null && getClass() == other.getClass() && this.isVisible == ((MenuItemVisibleElement) other).isVisible;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.isVisible.hashCode();
    }
}
