package com.box.android.domain.utils;

import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SupportedFileExtensions.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0086\u0004¨\u0006\u0005"}, d2 = {"isExtensionInSet", "", "", "extensionSet", "", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SupportedFileExtensionsKt {
    public static final boolean isExtensionInSet(String str, Set<String> extensionSet) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(extensionSet, "extensionSet");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return extensionSet.contains(lowerCase);
    }
}
