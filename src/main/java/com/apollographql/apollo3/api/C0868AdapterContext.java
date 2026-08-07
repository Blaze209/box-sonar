package com.apollographql.apollo3.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.apollographql.apollo3.api.AdapterContext, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AdapterContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B)\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001e\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/apollographql/apollo3/api/AdapterContext;", "", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "mergedDeferredFragmentIds", "", "Lcom/apollographql/apollo3/api/DeferredFragmentIdentifier;", "serializeVariablesWithDefaultBooleanValues", "", "(Lcom/apollographql/apollo3/api/Executable$Variables;Ljava/util/Set;Z)V", "getSerializeVariablesWithDefaultBooleanValues", "()Z", "hasDeferredFragment", "path", "", "label", "", "newBuilder", "Lcom/apollographql/apollo3/api/AdapterContext$Builder;", "Builder", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class C0868AdapterContext {
    private final Set<DeferredFragmentIdentifier> mergedDeferredFragmentIds;
    private final boolean serializeVariablesWithDefaultBooleanValues;
    private final Executable.Variables variables;

    public /* synthetic */ C0868AdapterContext(Executable.Variables variables, Set set, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(variables, set, z);
    }

    private C0868AdapterContext(Executable.Variables variables, Set<DeferredFragmentIdentifier> set, boolean z) {
        this.variables = variables;
        this.mergedDeferredFragmentIds = set;
        this.serializeVariablesWithDefaultBooleanValues = z;
    }

    public final boolean getSerializeVariablesWithDefaultBooleanValues() {
        return this.serializeVariablesWithDefaultBooleanValues;
    }

    public final Builder newBuilder() {
        return new Builder().variables(this.variables).mergedDeferredFragmentIds(this.mergedDeferredFragmentIds).serializeVariablesWithDefaultBooleanValues(Boolean.valueOf(this.serializeVariablesWithDefaultBooleanValues));
    }

    public final Set<String> variables() {
        Executable.Variables variables = this.variables;
        if (variables == null) {
            return SetsKt.emptySet();
        }
        Map<String, Object> valueMap = variables.getValueMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : valueMap.entrySet()) {
            if (Intrinsics.areEqual(entry.getValue(), (Object) false)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap.keySet();
    }

    public final boolean hasDeferredFragment(List<? extends Object> path, String label) {
        Intrinsics.checkNotNullParameter(path, "path");
        Set<DeferredFragmentIdentifier> set = this.mergedDeferredFragmentIds;
        if (set == null) {
            return true;
        }
        return set.contains(new DeferredFragmentIdentifier(path, label));
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.api.AdapterContext$Builder */
    /* JADX INFO: compiled from: AdapterContext.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J\u0015\u0010\u0006\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/apollographql/apollo3/api/AdapterContext$Builder;", "", "()V", "mergedDeferredFragmentIds", "", "Lcom/apollographql/apollo3/api/DeferredFragmentIdentifier;", "serializeVariablesWithDefaultBooleanValues", "", "Ljava/lang/Boolean;", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "build", "Lcom/apollographql/apollo3/api/AdapterContext;", "(Ljava/lang/Boolean;)Lcom/apollographql/apollo3/api/AdapterContext$Builder;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private Set<DeferredFragmentIdentifier> mergedDeferredFragmentIds;
        private Boolean serializeVariablesWithDefaultBooleanValues;
        private Executable.Variables variables;

        public final Builder variables(Executable.Variables variables) {
            this.variables = variables;
            return this;
        }

        public final Builder mergedDeferredFragmentIds(Set<DeferredFragmentIdentifier> mergedDeferredFragmentIds) {
            this.mergedDeferredFragmentIds = mergedDeferredFragmentIds;
            return this;
        }

        public final Builder serializeVariablesWithDefaultBooleanValues(Boolean serializeVariablesWithDefaultBooleanValues) {
            this.serializeVariablesWithDefaultBooleanValues = serializeVariablesWithDefaultBooleanValues;
            return this;
        }

        public final C0868AdapterContext build() {
            return new C0868AdapterContext(this.variables, this.mergedDeferredFragmentIds, Intrinsics.areEqual((Object) this.serializeVariablesWithDefaultBooleanValues, (Object) true), null);
        }
    }
}
