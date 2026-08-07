package com.pspdfkit.internal;

import com.pspdfkit.document.files.EmbeddedFile;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ag {
    public final List<EmbeddedFile> a;
    public final List<vf> b;
    public final boolean c;
    public final int d;
    public final int e;
    public final Throwable f;
    public final ot g;

    public ag() {
        this(0);
    }

    public static ag a(ag agVar, List list, List list2, boolean z, int i, int i2, Throwable th, ot otVar, int i3) {
        if ((i3 & 1) != 0) {
            list = agVar.a;
        }
        List list3 = list;
        if ((i3 & 2) != 0) {
            list2 = agVar.b;
        }
        List list4 = list2;
        if ((i3 & 4) != 0) {
            z = agVar.c;
        }
        boolean z2 = z;
        if ((i3 & 8) != 0) {
            i = agVar.d;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = agVar.e;
        }
        int i5 = i2;
        if ((i3 & 32) != 0) {
            th = agVar.f;
        }
        Throwable th2 = th;
        if ((i3 & 64) != 0) {
            otVar = agVar.g;
        }
        agVar.getClass();
        list4.getClass();
        return new ag(list3, list4, z2, i4, i5, th2, otVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ag)) {
            return false;
        }
        ag agVar = (ag) obj;
        return Intrinsics.areEqual(this.a, agVar.a) && Intrinsics.areEqual(this.b, agVar.b) && this.c == agVar.c && this.d == agVar.d && this.e == agVar.e && Intrinsics.areEqual(this.f, agVar.f) && Intrinsics.areEqual(this.g, agVar.g);
    }

    public final int hashCode() {
        List<EmbeddedFile> list = this.a;
        int iA = nd.a(this.e, nd.a(this.d, mv.a(this.c, lv.a(this.b, (list == null ? 0 : list.hashCode()) * 31, 31), 31), 31), 31);
        Throwable th = this.f;
        int iHashCode = (iA + (th == null ? 0 : th.hashCode())) * 31;
        ot otVar = this.g;
        return iHashCode + (otVar != null ? otVar.hashCode() : 0);
    }

    public final String toString() {
        return "EmbeddedFilesState(embeddedFiles=" + this.a + ", embeddedFileGroups=" + this.b + ", isLoading=" + this.c + ", currentPage=" + this.d + ", totalPages=" + this.e + ", error=" + this.f + ", themeConfiguration=" + this.g + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ag(List<? extends EmbeddedFile> list, List<vf> list2, boolean z, int i, int i2, Throwable th, ot otVar) {
        list2.getClass();
        this.a = list;
        this.b = list2;
        this.c = z;
        this.d = i;
        this.e = i2;
        this.f = th;
        this.g = otVar;
    }

    public /* synthetic */ ag(int i) {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), false, 0, 0, null, null);
    }
}
