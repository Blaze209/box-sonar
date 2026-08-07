package com.squareup.sqldelight.db;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SqlDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/squareup/sqldelight/db/AfterVersion;", "", "afterVersion", "", "block", "Lkotlin/Function0;", "", "(ILkotlin/jvm/functions/Function0;)V", "getAfterVersion$runtime", "()I", "getBlock$runtime", "()Lkotlin/jvm/functions/Function0;", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AfterVersion {
    private final int afterVersion;
    private final Function0<Unit> block;

    public AfterVersion(int i, Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.afterVersion = i;
        this.block = block;
    }

    /* JADX INFO: renamed from: getAfterVersion$runtime, reason: from getter */
    public final int getAfterVersion() {
        return this.afterVersion;
    }

    public final Function0<Unit> getBlock$runtime() {
        return this.block;
    }
}
