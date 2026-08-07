package com.box.brownfieldApi.featuresNavigator;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipientIdGenerator.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"generateRecipientId", "", "brownfieldApi_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class RecipientIdGeneratorKt {
    public static final String generateRecipientId() {
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
