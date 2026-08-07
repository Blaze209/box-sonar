package com.box.android.base.cpl;

import com.box.android.common.utilities.CommonBoxUtil;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StringResourceParams.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/box/android/base/cpl/StringResourceParams;", "Lcom/box/android/base/cpl/StringResourceWrapper;", "stringResource", "", SerializedNames.PARAMS, "", "", "<init>", "(I[Ljava/lang/String;)V", "getStringResource", "()I", "getParams", "()[Ljava/lang/String;", "[Ljava/lang/String;", "hashCode", "equals", "", "other", "", "getString", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StringResourceParams implements StringResourceWrapper {
    public static final int $stable = 8;
    private final String[] params;
    private final int stringResource;

    public StringResourceParams(int i, String... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.stringResource = i;
        this.params = params;
    }

    public final String[] getParams() {
        return this.params;
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
        int i = this.stringResource;
        String[] strArr = this.params;
        return CommonBoxUtil.LS(i, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public String toString() {
        return "Resource:" + this.stringResource + " Params:" + ArraysKt.joinToString$default(this.params, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
    }
}
