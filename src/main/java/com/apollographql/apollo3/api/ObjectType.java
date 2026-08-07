package com.apollographql.apollo3.api;

import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompiledGraphQL.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B/\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bB9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\nJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/apollographql/apollo3/api/ObjectType;", "Lcom/apollographql/apollo3/api/CompiledNamedType;", "name", "", "keyFields", "", "implements", "Lcom/apollographql/apollo3/api/InterfaceType;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "embeddedFields", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getEmbeddedFields", "()Ljava/util/List;", "getImplements", "getKeyFields", "newBuilder", "Lcom/apollographql/apollo3/api/ObjectType$Builder;", "Builder", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ObjectType extends CompiledNamedType {
    private final List<String> embeddedFields;
    private final List<InterfaceType> implements;
    private final List<String> keyFields;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObjectType(String name, List<String> keyFields, List<InterfaceType> list, List<String> embeddedFields) {
        super(name, null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(keyFields, "keyFields");
        Intrinsics.checkNotNullParameter(list, "implements");
        Intrinsics.checkNotNullParameter(embeddedFields, "embeddedFields");
        this.keyFields = keyFields;
        this.implements = list;
        this.embeddedFields = embeddedFields;
    }

    public final List<String> getKeyFields() {
        return this.keyFields;
    }

    public final List<InterfaceType> getImplements() {
        return this.implements;
    }

    public final List<String> getEmbeddedFields() {
        return this.embeddedFields;
    }

    public /* synthetic */ ObjectType(String str, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use the Builder instead", replaceWith = @ReplaceWith(expression = "ObjectType.Builder().keyFields(keyFields).implements(implements).build()", imports = {}))
    public ObjectType(String name, List<String> keyFields, List<InterfaceType> list) {
        this(name, keyFields, list, CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(keyFields, "keyFields");
        Intrinsics.checkNotNullParameter(list, "implements");
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    /* JADX INFO: compiled from: CompiledGraphQL.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0003J\u0014\u0010\b\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tJ\u0014\u0010\u0010\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tJ\u0014\u0010\f\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\tR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/apollographql/apollo3/api/ObjectType$Builder;", "", "objectType", "Lcom/apollographql/apollo3/api/ObjectType;", "(Lcom/apollographql/apollo3/api/ObjectType;)V", "name", "", "(Ljava/lang/String;)V", "embeddedFields", "", "implements", "Lcom/apollographql/apollo3/api/InterfaceType;", "keyFields", "getName$apollo_api", "()Ljava/lang/String;", "build", "interfaces", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private List<String> embeddedFields;
        private List<InterfaceType> implements;
        private List<String> keyFields;
        private final String name;

        public Builder(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.keyFields = CollectionsKt.emptyList();
            this.implements = CollectionsKt.emptyList();
            this.embeddedFields = CollectionsKt.emptyList();
        }

        /* JADX INFO: renamed from: getName$apollo_api, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ObjectType objectType) {
            this(objectType.getName());
            Intrinsics.checkNotNullParameter(objectType, "objectType");
            this.keyFields = objectType.getKeyFields();
            this.implements = objectType.getImplements();
            this.embeddedFields = objectType.getEmbeddedFields();
        }

        public final Builder keyFields(List<String> keyFields) {
            Intrinsics.checkNotNullParameter(keyFields, "keyFields");
            this.keyFields = keyFields;
            return this;
        }

        public final Builder interfaces(List<InterfaceType> list) {
            Intrinsics.checkNotNullParameter(list, "implements");
            this.implements = list;
            return this;
        }

        public final Builder embeddedFields(List<String> embeddedFields) {
            Intrinsics.checkNotNullParameter(embeddedFields, "embeddedFields");
            this.embeddedFields = embeddedFields;
            return this;
        }

        public final ObjectType build() {
            return new ObjectType(this.name, this.keyFields, this.implements, this.embeddedFields);
        }
    }
}
