package com.pspdfkit.undo.edit;

import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0082\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/pspdfkit/undo/edit/CompoundEdit;", "Lcom/pspdfkit/undo/edit/Edit;", "edits", "", "<init>", "(Ljava/util/List;)V", "getEdits", "()Ljava/util/List;", "equals", "", "other", "", "hashCode", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CompoundEdit implements Edit {
    public static final int $stable = 8;
    private final List<Edit> edits;

    /* JADX WARN: Multi-variable type inference failed */
    public CompoundEdit(List<? extends Edit> list) {
        list.getClass();
        this.edits = list;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CompoundEdit) {
            return Intrinsics.areEqual(this.edits, ((CompoundEdit) other).edits);
        }
        return false;
    }

    public final List<Edit> getEdits() {
        return this.edits;
    }

    public int hashCode() {
        return Objects.hash(this.edits);
    }
}
