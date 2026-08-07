package com.microsoft.identity.common.java.util;

import com.microsoft.identity.common.java.exception.ClientException;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ArgUtils.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/common/java/util/ArgUtils;", "", "()V", "validateNonNullArg", "", "o", "argName", "", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ArgUtils {
    public static final ArgUtils INSTANCE = new ArgUtils();

    private ArgUtils() {
    }

    public final void validateNonNullArg(Object o, String argName) throws ClientException {
        Intrinsics.checkNotNullParameter(argName, "argName");
        if (o == null || (((o instanceof char[]) && ((char[]) o).length == 0) || (((o instanceof CharSequence) && StringsKt.isBlank((CharSequence) o)) || (((o instanceof String) && StringsKt.isBlank((CharSequence) o)) || (((o instanceof List) && ((List) o).isEmpty()) || ((o instanceof Map) && ((Map) o).isEmpty())))))) {
            throw new ClientException(argName, argName + " cannot be null or empty");
        }
    }
}
