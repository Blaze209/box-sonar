package androidx.constraintlayout.compose;

import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstraintLayoutTag.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B.\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u0013*\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/constraintlayout/compose/ConstraintLayoutTag;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/constraintlayout/compose/ConstraintLayoutTagParentData;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "constraintLayoutTag", "", "constraintLayoutId", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getConstraintLayoutId", "()Ljava/lang/String;", "getConstraintLayoutTag", "equals", "", "other", "", "hashCode", "", "toString", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ConstraintLayoutTag extends InspectorValueInfo implements ParentDataModifier, ConstraintLayoutTagParentData {
    private final String constraintLayoutId;
    private final String constraintLayoutTag;

    @Override // androidx.compose.ui.layout.ParentDataModifier
    public Object modifyParentData(Density density, Object obj) {
        return this;
    }

    @Override // androidx.constraintlayout.compose.ConstraintLayoutTagParentData
    public String getConstraintLayoutTag() {
        return this.constraintLayoutTag;
    }

    @Override // androidx.constraintlayout.compose.ConstraintLayoutTagParentData
    public String getConstraintLayoutId() {
        return this.constraintLayoutId;
    }

    public ConstraintLayoutTag(String str, String str2, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.constraintLayoutTag = str;
        this.constraintLayoutId = str2;
    }

    public int hashCode() {
        return getConstraintLayoutTag().hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        ConstraintLayoutTag constraintLayoutTag = other instanceof ConstraintLayoutTag ? (ConstraintLayoutTag) other : null;
        if (constraintLayoutTag == null) {
            return false;
        }
        return Intrinsics.areEqual(getConstraintLayoutTag(), constraintLayoutTag.getConstraintLayoutTag());
    }

    public String toString() {
        return "ConstraintLayoutTag(id=" + getConstraintLayoutTag() + ')';
    }
}
