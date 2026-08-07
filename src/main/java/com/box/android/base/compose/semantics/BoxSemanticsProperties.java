package com.box.android.base.compose.semantics;

import androidx.compose.ui.semantics.SemanticsPropertyKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BoxSemanticsProperties.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/box/android/base/compose/semantics/BoxSemanticsProperties;", "", "<init>", "()V", "Drawable", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "", "getDrawable", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "FolderName", "", "getFolderName", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxSemanticsProperties {
    public static final BoxSemanticsProperties INSTANCE = new BoxSemanticsProperties();
    private static final SemanticsPropertyKey<Integer> Drawable = new SemanticsPropertyKey<>("Drawable", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<String> FolderName = new SemanticsPropertyKey<>("FolderName", (Function2) null, 2, (DefaultConstructorMarker) null);
    public static final int $stable = SemanticsPropertyKey.$stable | SemanticsPropertyKey.$stable;

    private BoxSemanticsProperties() {
    }

    public final SemanticsPropertyKey<Integer> getDrawable() {
        return Drawable;
    }

    public final SemanticsPropertyKey<String> getFolderName() {
        return FolderName;
    }
}
