package com.microsoft.identity.common.java.nativeauth.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ILoggable.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0005H'¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/java/nativeauth/util/ILoggable;", "", "containsPii", "", "toString", "", "toUnsanitizedString", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ILoggable {
    boolean containsPii();

    String toString();

    String toUnsanitizedString();

    /* JADX INFO: compiled from: ILoggable.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean containsPii(ILoggable iLoggable) {
            return !Intrinsics.areEqual(iLoggable.toString(), iLoggable.toUnsanitizedString());
        }
    }
}
