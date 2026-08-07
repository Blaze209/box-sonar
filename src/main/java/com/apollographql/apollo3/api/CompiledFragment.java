package com.apollographql.apollo3.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompiledGraphQL.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0010B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/apollographql/apollo3/api/CompiledFragment;", "Lcom/apollographql/apollo3/api/CompiledSelection;", "typeCondition", "", "possibleTypes", "", "condition", "Lcom/apollographql/apollo3/api/CompiledCondition;", "selections", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCondition", "()Ljava/util/List;", "getPossibleTypes", "getSelections", "getTypeCondition", "()Ljava/lang/String;", "Builder", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CompiledFragment extends CompiledSelection {
    private final List<CompiledCondition> condition;
    private final List<String> possibleTypes;
    private final List<CompiledSelection> selections;
    private final String typeCondition;

    public final String getTypeCondition() {
        return this.typeCondition;
    }

    public final List<String> getPossibleTypes() {
        return this.possibleTypes;
    }

    public final List<CompiledCondition> getCondition() {
        return this.condition;
    }

    public final List<CompiledSelection> getSelections() {
        return this.selections;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CompiledFragment(String typeCondition, List<String> possibleTypes, List<CompiledCondition> condition, List<? extends CompiledSelection> selections) {
        super(null);
        Intrinsics.checkNotNullParameter(typeCondition, "typeCondition");
        Intrinsics.checkNotNullParameter(possibleTypes, "possibleTypes");
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(selections, "selections");
        this.typeCondition = typeCondition;
        this.possibleTypes = possibleTypes;
        this.condition = condition;
        this.selections = selections;
    }

    /* JADX INFO: compiled from: CompiledGraphQL.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0007\u001a\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005J\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/apollographql/apollo3/api/CompiledFragment$Builder;", "", "typeCondition", "", "possibleTypes", "", "(Ljava/lang/String;Ljava/util/List;)V", "condition", "Lcom/apollographql/apollo3/api/CompiledCondition;", "getCondition", "()Ljava/util/List;", "setCondition", "(Ljava/util/List;)V", "getPossibleTypes", "selections", "Lcom/apollographql/apollo3/api/CompiledSelection;", "getSelections", "setSelections", "getTypeCondition", "()Ljava/lang/String;", "build", "Lcom/apollographql/apollo3/api/CompiledFragment;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private List<CompiledCondition> condition;
        private final List<String> possibleTypes;
        private List<? extends CompiledSelection> selections;
        private final String typeCondition;

        public Builder(String typeCondition, List<String> possibleTypes) {
            Intrinsics.checkNotNullParameter(typeCondition, "typeCondition");
            Intrinsics.checkNotNullParameter(possibleTypes, "possibleTypes");
            this.typeCondition = typeCondition;
            this.possibleTypes = possibleTypes;
            this.condition = CollectionsKt.emptyList();
            this.selections = CollectionsKt.emptyList();
        }

        public final List<String> getPossibleTypes() {
            return this.possibleTypes;
        }

        public final String getTypeCondition() {
            return this.typeCondition;
        }

        public final List<CompiledCondition> getCondition() {
            return this.condition;
        }

        public final void setCondition(List<CompiledCondition> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.condition = list;
        }

        public final List<CompiledSelection> getSelections() {
            return this.selections;
        }

        public final void setSelections(List<? extends CompiledSelection> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.selections = list;
        }

        public final Builder condition(List<CompiledCondition> condition) {
            Intrinsics.checkNotNullParameter(condition, "condition");
            this.condition = condition;
            return this;
        }

        public final Builder selections(List<? extends CompiledSelection> selections) {
            Intrinsics.checkNotNullParameter(selections, "selections");
            this.selections = selections;
            return this;
        }

        public final CompiledFragment build() {
            return new CompiledFragment(this.typeCondition, this.possibleTypes, this.condition, this.selections);
        }
    }
}
