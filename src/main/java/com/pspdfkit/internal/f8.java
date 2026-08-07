package com.pspdfkit.internal;

import com.pspdfkit.bookmarks.Bookmark;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f8 {
    public final ot a;
    public final List<Bookmark> b;
    public final int c;
    public final j8 d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final Set<Integer> i;
    public final boolean j;
    public final Bookmark k;
    public final boolean l;
    public final boolean m;
    public final Bookmark n;
    public final boolean o;
    public final boolean p;

    public f8() {
        this(0);
    }

    public static f8 a(f8 f8Var, ot otVar, List list, int i, j8 j8Var, boolean z, boolean z2, boolean z3, boolean z4, Set set, boolean z5, Bookmark bookmark, boolean z6, boolean z7, Bookmark bookmark2, boolean z8, boolean z9, int i2) {
        ot otVar2 = (i2 & 1) != 0 ? f8Var.a : otVar;
        List list2 = (i2 & 2) != 0 ? f8Var.b : list;
        int i3 = (i2 & 4) != 0 ? f8Var.c : i;
        j8 j8Var2 = (i2 & 8) != 0 ? f8Var.d : j8Var;
        boolean z10 = (i2 & 16) != 0 ? f8Var.e : z;
        boolean z11 = (i2 & 32) != 0 ? f8Var.f : z2;
        boolean z12 = (i2 & 64) != 0 ? f8Var.g : z3;
        boolean z13 = (i2 & 128) != 0 ? f8Var.h : z4;
        Set set2 = (i2 & 256) != 0 ? f8Var.i : set;
        boolean z14 = (i2 & 512) != 0 ? f8Var.j : z5;
        Bookmark bookmark3 = (i2 & 1024) != 0 ? f8Var.k : bookmark;
        boolean z15 = (i2 & 2048) != 0 ? f8Var.l : z6;
        boolean z16 = (i2 & 4096) != 0 ? f8Var.m : z7;
        Bookmark bookmark4 = (i2 & 8192) != 0 ? f8Var.n : bookmark2;
        ot otVar3 = otVar2;
        boolean z17 = (i2 & 16384) != 0 ? f8Var.o : z8;
        boolean z18 = (i2 & 32768) != 0 ? f8Var.p : z9;
        f8Var.getClass();
        list2.getClass();
        set2.getClass();
        return new f8(otVar3, list2, i3, j8Var2, z10, z11, z12, z13, set2, z14, bookmark3, z15, z16, bookmark4, z17, z18);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f8)) {
            return false;
        }
        f8 f8Var = (f8) obj;
        return Intrinsics.areEqual(this.a, f8Var.a) && Intrinsics.areEqual(this.b, f8Var.b) && this.c == f8Var.c && Intrinsics.areEqual(this.d, f8Var.d) && this.e == f8Var.e && this.f == f8Var.f && this.g == f8Var.g && this.h == f8Var.h && Intrinsics.areEqual(this.i, f8Var.i) && this.j == f8Var.j && Intrinsics.areEqual(this.k, f8Var.k) && this.l == f8Var.l && this.m == f8Var.m && Intrinsics.areEqual(this.n, f8Var.n) && this.o == f8Var.o && this.p == f8Var.p;
    }

    public final int hashCode() {
        ot otVar = this.a;
        int iA = nd.a(this.c, lv.a(this.b, (otVar == null ? 0 : otVar.hashCode()) * 31, 31), 31);
        j8 j8Var = this.d;
        int iA2 = mv.a(this.j, (this.i.hashCode() + mv.a(this.h, mv.a(this.g, mv.a(this.f, mv.a(this.e, (iA + (j8Var == null ? 0 : j8Var.hashCode())) * 31, 31), 31), 31), 31)) * 31, 31);
        Bookmark bookmark = this.k;
        int iA3 = mv.a(this.m, mv.a(this.l, (iA2 + (bookmark == null ? 0 : bookmark.hashCode())) * 31, 31), 31);
        Bookmark bookmark2 = this.n;
        return Boolean.hashCode(this.p) + mv.a(this.o, (iA3 + (bookmark2 != null ? bookmark2.hashCode() : 0)) * 31, 31);
    }

    public final String toString() {
        return "BookmarkListState(themeConfiguration=" + this.a + ", bookmarks=" + this.b + ", currentPage=" + this.c + ", bookmarkMetadataResolver=" + this.d + ", showPageLabels=" + this.e + ", bookmarkAddingEnabled=" + this.f + ", bookmarkRenamingEnabled=" + this.g + ", bookmarkEditingEnabled=" + this.h + ", dirtyPages=" + this.i + ", isParentVisible=" + this.j + ", addedBookmark=" + this.k + ", isEditing=" + this.l + ", shouldShowRenameDialog=" + this.m + ", clickedBookmark=" + this.n + ", isBookmarkAdded=" + this.o + ", isAddingBookmark=" + this.p + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f8(ot otVar, List<? extends Bookmark> list, int i, j8 j8Var, boolean z, boolean z2, boolean z3, boolean z4, Set<Integer> set, boolean z5, Bookmark bookmark, boolean z6, boolean z7, Bookmark bookmark2, boolean z8, boolean z9) {
        list.getClass();
        this.a = otVar;
        this.b = list;
        this.c = i;
        this.d = j8Var;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = z4;
        this.i = set;
        this.j = z5;
        this.k = bookmark;
        this.l = z6;
        this.m = z7;
        this.n = bookmark2;
        this.o = z8;
        this.p = z9;
    }

    public /* synthetic */ f8(int i) {
        this(null, CollectionsKt.emptyList(), 0, null, false, true, true, true, new LinkedHashSet(), false, null, false, false, null, false, false);
    }
}
