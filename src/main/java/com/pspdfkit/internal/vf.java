package com.pspdfkit.internal;

import com.pspdfkit.document.files.EmbeddedFile;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class vf {
    public final int a;
    public final List<EmbeddedFile> b;

    /* JADX WARN: Multi-variable type inference failed */
    public vf(int i, List<? extends EmbeddedFile> list) {
        list.getClass();
        this.a = i;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vf)) {
            return false;
        }
        vf vfVar = (vf) obj;
        return this.a == vfVar.a && Intrinsics.areEqual(this.b, vfVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "EmbeddedFileGroup(pageIndex=" + this.a + ", files=" + this.b + ")";
    }
}
