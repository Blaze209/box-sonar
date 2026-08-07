package com.apollographql.apollo3.api;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BooleanExpression.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003J$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/apollographql/apollo3/api/BVariable;", "Lcom/apollographql/apollo3/api/BTerm;", "name", "", "(Ljava/lang/String;)V", "defaultValue", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getDefaultValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/apollographql/apollo3/api/BVariable;", "equals", "other", "", "hashCode", "", "toString", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class BVariable extends BTerm {
    private final Boolean defaultValue;
    private final String name;

    public static /* synthetic */ BVariable copy$default(BVariable bVariable, String str, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bVariable.name;
        }
        if ((i & 2) != 0) {
            bool = bVariable.defaultValue;
        }
        return bVariable.copy(str, bool);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final BVariable copy(String name, Boolean defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new BVariable(name, defaultValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BVariable)) {
            return false;
        }
        BVariable bVariable = (BVariable) other;
        return Intrinsics.areEqual(this.name, bVariable.name) && Intrinsics.areEqual(this.defaultValue, bVariable.defaultValue);
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        Boolean bool = this.defaultValue;
        return iHashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "BVariable(name=" + this.name + ", defaultValue=" + this.defaultValue + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BVariable(String name, Boolean bool) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.defaultValue = bool;
    }

    public final Boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BVariable(String name) {
        this(name, true);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public static /* synthetic */ BVariable copy$default(BVariable bVariable, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bVariable.name;
        }
        return bVariable.copy(str);
    }

    public final BVariable copy(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new BVariable(name, this.defaultValue);
    }
}
