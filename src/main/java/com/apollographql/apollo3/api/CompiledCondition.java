package com.apollographql.apollo3.api;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompiledGraphQL.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001a\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/apollographql/apollo3/api/CompiledCondition;", "", "name", "", "inverted", "", "(Ljava/lang/String;Z)V", "defaultValue", "(Ljava/lang/String;ZZ)V", "getDefaultValue", "()Z", "getInverted", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final /* data */ class CompiledCondition {
    private final boolean defaultValue;
    private final boolean inverted;
    private final String name;

    public static /* synthetic */ CompiledCondition copy$default(CompiledCondition compiledCondition, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = compiledCondition.name;
        }
        if ((i & 2) != 0) {
            z = compiledCondition.inverted;
        }
        if ((i & 4) != 0) {
            z2 = compiledCondition.defaultValue;
        }
        return compiledCondition.copy(str, z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getInverted() {
        return this.inverted;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final CompiledCondition copy(String name, boolean inverted, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new CompiledCondition(name, inverted, defaultValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompiledCondition)) {
            return false;
        }
        CompiledCondition compiledCondition = (CompiledCondition) other;
        return Intrinsics.areEqual(this.name, compiledCondition.name) && this.inverted == compiledCondition.inverted && this.defaultValue == compiledCondition.defaultValue;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + Boolean.hashCode(this.inverted)) * 31) + Boolean.hashCode(this.defaultValue);
    }

    public String toString() {
        return "CompiledCondition(name=" + this.name + ", inverted=" + this.inverted + ", defaultValue=" + this.defaultValue + ')';
    }

    public CompiledCondition(String name, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.inverted = z;
        this.defaultValue = z2;
    }

    public final boolean getDefaultValue() {
        return this.defaultValue;
    }

    public final boolean getInverted() {
        return this.inverted;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CompiledCondition(String name, boolean z) {
        this(name, z, true);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    public static /* synthetic */ CompiledCondition copy$default(CompiledCondition compiledCondition, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = compiledCondition.name;
        }
        if ((i & 2) != 0) {
            z = compiledCondition.inverted;
        }
        return compiledCondition.copy(str, z);
    }

    public final CompiledCondition copy(String name, boolean inverted) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new CompiledCondition(name, inverted, this.defaultValue);
    }
}
