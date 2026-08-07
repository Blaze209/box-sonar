package androidx.compose.runtime.retain;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import androidx.compose.runtime.retain.impl.SafeMultiValueMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManagedRetainedValuesStore.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/retain/ManagedRetainedValuesStore;", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "<init>", "()V", "isEnabled", "", "isDisposed", "isContentComposed", "keptExitedValues", "Landroidx/compose/runtime/retain/impl/SafeMultiValueMap;", "", "Landroidx/collection/MutableScatterMap;", "isRetainingExitedValues", "()Z", "enableRetainingExitedValues", "", "disableRetainingExitedValues", "dispose", "onContentExitComposition", "onContentEnteredComposition", "purgeUnusedExitedValues", "consumeExitedValueOrDefault", "key", "defaultValue", "saveExitingValue", "value", "runtime-retain"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ManagedRetainedValuesStore implements RetainedValuesStore {
    public static final int $stable = 8;
    private boolean isContentComposed;
    private boolean isDisposed;
    private boolean isEnabled = true;
    private final MutableScatterMap<Object, Object> keptExitedValues = SafeMultiValueMap.m6226constructorimpl$default(null, 1, null);

    public final boolean isRetainingExitedValues() {
        return this.isEnabled && !this.isContentComposed;
    }

    public final void enableRetainingExitedValues() {
        if (this.isDisposed) {
            PreconditionsKt.throwIllegalStateException("Cannot call enableRetainingExitedValues on a disposed store");
        }
        this.isEnabled = true;
    }

    public final void disableRetainingExitedValues() {
        this.isEnabled = false;
        purgeUnusedExitedValues();
    }

    public final void dispose() {
        this.isDisposed = true;
        disableRetainingExitedValues();
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public void onContentExitComposition() {
        if (this.isDisposed) {
            return;
        }
        if (!this.isContentComposed) {
            PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to leave composition twice. Is the store installed in multiple places?");
        }
        if (!SafeMultiValueMap.m6233isEmptyimpl(this.keptExitedValues)) {
            PreconditionsKt.throwIllegalStateException("Attempted to start retaining exited values with pending exited values");
        }
        this.isContentComposed = false;
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public void onContentEnteredComposition() {
        if (this.isDisposed) {
            return;
        }
        if (this.isContentComposed) {
            PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
        }
        purgeUnusedExitedValues();
        this.isContentComposed = true;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x006d A[LOOP:0: B:5:0x000f->B:25:0x006d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0070 A[EDGE_INSN: B:29:0x0070->B:26:0x0070 BREAK  A[LOOP:0: B:5:0x000f->B:25:0x006d], SYNTHETIC] */
    private final void purgeUnusedExitedValues() {
        MutableScatterMap<Object, Object> mutableScatterMap = this.keptExitedValues;
        Object[] objArr = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            Object obj = objArr[(i << 3) + i3];
                            if (obj instanceof MutableObjectList) {
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.retain.impl.SafeMultiValueMap>");
                                MutableObjectList mutableObjectList = (MutableObjectList) obj;
                                Object[] objArr2 = mutableObjectList.content;
                                int i4 = mutableObjectList._size;
                                for (int i5 = 0; i5 < i4; i5++) {
                                    Object obj2 = objArr2[i5];
                                    if (obj2 instanceof RetainObserver) {
                                        ((RetainObserver) obj2).onRetired();
                                    }
                                }
                            } else if (obj instanceof RetainObserver) {
                                ((RetainObserver) obj).onRetired();
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        SafeMultiValueMap.m6224clearimpl(this.keptExitedValues);
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public Object consumeExitedValueOrDefault(Object key, Object defaultValue) {
        return SafeMultiValueMap.m6237removeLastimpl(this.keptExitedValues, key, defaultValue);
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public void saveExitingValue(Object key, Object value) {
        if (isRetainingExitedValues()) {
            SafeMultiValueMap.m6222addimpl(this.keptExitedValues, key, value);
        } else if (value instanceof RetainObserver) {
            ((RetainObserver) value).onRetired();
        }
    }
}
