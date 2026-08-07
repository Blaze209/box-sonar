package androidx.compose.material3;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ListItemDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/material3/ListItemElevation;", "", "elevation", "Landroidx/compose/ui/unit/Dp;", "draggedElevation", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getElevation-D9Ej5fM", "()F", "F", "getDraggedElevation-D9Ej5fM", "equals", "", "other", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ListItemElevation {
    public static final int $stable = 0;
    private final float draggedElevation;
    private final float elevation;

    public /* synthetic */ ListItemElevation(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    private ListItemElevation(float f, float f2) {
        this.elevation = f;
        this.draggedElevation = f2;
    }

    /* JADX INFO: renamed from: getDraggedElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getDraggedElevation() {
        return this.draggedElevation;
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name and from getter */
    public final float getElevation() {
        return this.elevation;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof ListItemElevation)) {
            return false;
        }
        ListItemElevation listItemElevation = (ListItemElevation) other;
        return Dp.m9692equalsimpl0(this.elevation, listItemElevation.elevation) && Dp.m9692equalsimpl0(this.draggedElevation, listItemElevation.draggedElevation);
    }

    public int hashCode() {
        return (Dp.m9693hashCodeimpl(this.elevation) * 31) + Dp.m9693hashCodeimpl(this.draggedElevation);
    }
}
