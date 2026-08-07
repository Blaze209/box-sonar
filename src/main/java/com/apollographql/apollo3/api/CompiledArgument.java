package com.apollographql.apollo3.api;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompiledGraphQL.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0011B#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u001c\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/apollographql/apollo3/api/CompiledArgument;", "", "name", "", "value", "isKey", "", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "isPagination", "(Ljava/lang/String;Ljava/lang/Object;ZZ)V", "()Z", "isPagination$annotations", "()V", "getName", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "Builder", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CompiledArgument {
    private final boolean isKey;
    private final boolean isPagination;
    private final String name;
    private final Object value;

    public /* synthetic */ CompiledArgument(String str, Object obj, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, z, z2);
    }

    public static /* synthetic */ void isPagination$annotations() {
    }

    private CompiledArgument(String str, Object obj, boolean z, boolean z2) {
        this.name = str;
        this.value = obj;
        this.isKey = z;
        this.isPagination = z2;
    }

    /* synthetic */ CompiledArgument(String str, Object obj, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    public final String getName() {
        return this.name;
    }

    public final Object getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: isKey, reason: from getter */
    public final boolean getIsKey() {
        return this.isKey;
    }

    /* JADX INFO: renamed from: isPagination, reason: from getter */
    public final boolean getIsPagination() {
        return this.isPagination;
    }

    public /* synthetic */ CompiledArgument(String str, Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i & 4) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use the Builder instead", replaceWith = @ReplaceWith(expression = "CompiledArgument.Builder(name = name, value = value).isKey(isKey).build()", imports = {}))
    public CompiledArgument(String name, Object obj, boolean z) {
        this(name, obj, z, false);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX INFO: compiled from: CompiledGraphQL.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/apollographql/apollo3/api/CompiledArgument$Builder;", "", "name", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "isKey", "", "isPagination", "build", "Lcom/apollographql/apollo3/api/CompiledArgument;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private boolean isKey;
        private boolean isPagination;
        private final String name;
        private final Object value;

        public Builder(String name, Object obj) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.value = obj;
        }

        public final Builder isKey(boolean isKey) {
            this.isKey = isKey;
            return this;
        }

        public final Builder isPagination(boolean isPagination) {
            this.isPagination = isPagination;
            return this;
        }

        public final CompiledArgument build() {
            return new CompiledArgument(this.name, this.value, this.isKey, this.isPagination, (DefaultConstructorMarker) null);
        }
    }
}
