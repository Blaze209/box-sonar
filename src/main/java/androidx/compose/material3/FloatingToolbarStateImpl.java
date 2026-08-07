package androidx.compose.material3;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R+\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR+\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/FloatingToolbarStateImpl;", "Landroidx/compose/material3/FloatingToolbarState;", "initialOffsetLimit", "", "initialOffset", "initialContentOffset", "<init>", "(FFF)V", "<set-?>", "offsetLimit", "getOffsetLimit", "()F", "setOffsetLimit", "(F)V", "offsetLimit$delegate", "Landroidx/compose/runtime/MutableFloatState;", "newOffset", "offset", "getOffset", "setOffset", "contentOffset", "getContentOffset", "setContentOffset", "contentOffset$delegate", "_offset", "Landroidx/compose/runtime/MutableFloatState;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FloatingToolbarStateImpl implements FloatingToolbarState {
    private MutableFloatState _offset;

    /* JADX INFO: renamed from: contentOffset$delegate, reason: from kotlin metadata */
    private final MutableFloatState contentOffset;

    /* JADX INFO: renamed from: offsetLimit$delegate, reason: from kotlin metadata */
    private final MutableFloatState offsetLimit;

    public FloatingToolbarStateImpl(float f, float f2, float f3) {
        this.offsetLimit = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.contentOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f3);
        this._offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(f2);
    }

    @Override // androidx.compose.material3.FloatingToolbarState
    public float getOffsetLimit() {
        return this.offsetLimit.getFloatValue();
    }

    @Override // androidx.compose.material3.FloatingToolbarState
    public void setOffsetLimit(float f) {
        this.offsetLimit.setFloatValue(f);
    }

    @Override // androidx.compose.material3.FloatingToolbarState
    public float getOffset() {
        return this._offset.getFloatValue();
    }

    @Override // androidx.compose.material3.FloatingToolbarState
    public void setOffset(float f) {
        this._offset.setFloatValue(RangesKt.coerceIn(f, getOffsetLimit(), 0.0f));
    }

    @Override // androidx.compose.material3.FloatingToolbarState
    public float getContentOffset() {
        return this.contentOffset.getFloatValue();
    }

    @Override // androidx.compose.material3.FloatingToolbarState
    public void setContentOffset(float f) {
        this.contentOffset.setFloatValue(f);
    }
}
