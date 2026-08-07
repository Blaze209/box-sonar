package com.squareup.sqldelight.db;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SqlDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/squareup/sqldelight/db/AfterVersionWithDriver;", "", "afterVersion", "", "block", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/db/SqlDriver;", "", "(ILkotlin/jvm/functions/Function1;)V", "getAfterVersion$runtime", "()I", "getBlock$runtime", "()Lkotlin/jvm/functions/Function1;", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AfterVersionWithDriver {
    private final int afterVersion;
    private final Function1<SqlDriver, Unit> block;

    /* JADX WARN: Multi-variable type inference failed */
    public AfterVersionWithDriver(int i, Function1<? super SqlDriver, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.afterVersion = i;
        this.block = block;
    }

    /* JADX INFO: renamed from: getAfterVersion$runtime, reason: from getter */
    public final int getAfterVersion() {
        return this.afterVersion;
    }

    public final Function1<SqlDriver, Unit> getBlock$runtime() {
        return this.block;
    }
}
