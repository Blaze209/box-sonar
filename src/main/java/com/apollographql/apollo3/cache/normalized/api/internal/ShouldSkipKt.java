package com.apollographql.apollo3.cache.normalized.api.internal;

import com.apollographql.apollo3.api.CompiledCondition;
import com.apollographql.apollo3.api.CompiledField;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShouldSkip.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0000¨\u0006\u0007"}, d2 = {"shouldSkip", "", "Lcom/apollographql/apollo3/api/CompiledField;", "variableValues", "", "", "", "apollo-normalized-cache-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ShouldSkipKt {
    public static final boolean shouldSkip(CompiledField compiledField, Map<String, ? extends Object> variableValues) {
        boolean zBooleanValue;
        Intrinsics.checkNotNullParameter(compiledField, "<this>");
        Intrinsics.checkNotNullParameter(variableValues, "variableValues");
        Iterator<T> it = compiledField.getCondition().iterator();
        do {
            if (!it.hasNext()) {
                return false;
            }
            CompiledCondition compiledCondition = (CompiledCondition) it.next();
            Object obj = variableValues.get(compiledCondition.getName());
            Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
            zBooleanValue = bool != null ? bool.booleanValue() : false;
            if (compiledCondition.getInverted()) {
                zBooleanValue = !zBooleanValue;
            }
        } while (zBooleanValue);
        return true;
    }
}
