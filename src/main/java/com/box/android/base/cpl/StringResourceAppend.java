package com.box.android.base.cpl;

import com.box.android.common.utilities.CommonBoxUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringResourceParams.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/box/android/base/cpl/StringResourceAppend;", "Lcom/box/android/base/cpl/StringResourceWrapper;", "stringResource", "", "append", "", "<init>", "(ILjava/lang/String;)V", "getStringResource", "()I", "getAppend", "()Ljava/lang/String;", "hashCode", "equals", "", "other", "", "getString", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StringResourceAppend implements StringResourceWrapper {
    public static final int $stable = 0;
    private final String append;
    private final int stringResource;

    public StringResourceAppend(int i, String append) {
        Intrinsics.checkNotNullParameter(append, "append");
        this.stringResource = i;
        this.append = append;
    }

    public final String getAppend() {
        return this.append;
    }

    public final int getStringResource() {
        return this.stringResource;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object other) {
        return Intrinsics.areEqual(toString(), String.valueOf(other));
    }

    @Override // com.box.android.base.cpl.StringResourceWrapper
    public String getString() {
        return CommonBoxUtil.LS(this.stringResource) + this.append;
    }

    public String toString() {
        return "Resource:" + this.stringResource + " Append:" + this.append;
    }
}
