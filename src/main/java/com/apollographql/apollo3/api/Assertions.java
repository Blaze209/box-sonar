package com.apollographql.apollo3.api;

import com.apollographql.apollo3.exception.ApolloException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Assertions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"checkFieldNotMissing", "", "value", "", "name", "", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class Assertions {
    public static final void checkFieldNotMissing(Object obj, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (obj == null) {
            throw new ApolloException("Field " + name + " is missing", null, 2, null);
        }
    }
}
