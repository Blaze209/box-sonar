package com.apollographql.apollo3.api;

import com.apollographql.apollo3.api.json.BufferedSinkJsonWriter;
import com.apollographql.apollo3.api.json.JsonWriters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.Buffer;

/* JADX INFO: compiled from: CompiledGraphQL.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001 BK\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\u0010\rJ\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/apollographql/apollo3/api/CompiledField;", "Lcom/apollographql/apollo3/api/CompiledSelection;", "name", "", "type", "Lcom/apollographql/apollo3/api/CompiledType;", "alias", "condition", "", "Lcom/apollographql/apollo3/api/CompiledCondition;", "arguments", "Lcom/apollographql/apollo3/api/CompiledArgument;", "selections", "(Ljava/lang/String;Lcom/apollographql/apollo3/api/CompiledType;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAlias", "()Ljava/lang/String;", "getArguments", "()Ljava/util/List;", "getCondition", "getName", "responseName", "getResponseName", "getSelections", "getType", "()Lcom/apollographql/apollo3/api/CompiledType;", "nameWithArguments", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "newBuilder", "Lcom/apollographql/apollo3/api/CompiledField$Builder;", "resolveArgument", "", "Builder", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CompiledField extends CompiledSelection {
    private final String alias;
    private final List<CompiledArgument> arguments;
    private final List<CompiledCondition> condition;
    private final String name;
    private final List<CompiledSelection> selections;
    private final CompiledType type;

    public final String getName() {
        return this.name;
    }

    public final CompiledType getType() {
        return this.type;
    }

    public final String getAlias() {
        return this.alias;
    }

    public final List<CompiledCondition> getCondition() {
        return this.condition;
    }

    public final List<CompiledArgument> getArguments() {
        return this.arguments;
    }

    public final List<CompiledSelection> getSelections() {
        return this.selections;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CompiledField(String name, CompiledType type, String str, List<CompiledCondition> condition, List<CompiledArgument> arguments, List<? extends CompiledSelection> selections) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(condition, "condition");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(selections, "selections");
        this.name = name;
        this.type = type;
        this.alias = str;
        this.condition = condition;
        this.arguments = arguments;
        this.selections = selections;
    }

    public final String getResponseName() {
        String str = this.alias;
        return str == null ? this.name : str;
    }

    public final Object resolveArgument(String name, Executable.Variables variables) {
        Object next;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variables, "variables");
        Iterator<T> it = this.arguments.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((CompiledArgument) next).getName(), name));
        CompiledArgument compiledArgument = (CompiledArgument) next;
        return CompiledGraphQL.resolveVariables(compiledArgument != null ? compiledArgument.getValue() : null, variables);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String nameWithArguments(Executable.Variables variables) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(variables, "variables");
        List<CompiledArgument> list = this.arguments;
        if ((list instanceof Collection) && list.isEmpty()) {
            arrayList = this.arguments;
            break;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((CompiledArgument) it.next()).getIsPagination()) {
                    List<CompiledArgument> list2 = this.arguments;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : list2) {
                        if (!((CompiledArgument) obj).getIsPagination()) {
                            arrayList2.add(obj);
                        }
                    }
                    arrayList = arrayList2;
                    break;
                }
            } else {
                arrayList = this.arguments;
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return this.name;
        }
        List list3 = arrayList;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list3, 10)), 16));
        for (Object obj2 : list3) {
            linkedHashMap.put(((CompiledArgument) obj2).getName(), obj2);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), ((CompiledArgument) entry.getValue()).getValue());
        }
        Object objResolveVariables = CompiledGraphQL.resolveVariables(linkedHashMap2, variables);
        try {
            Buffer buffer = new Buffer();
            BufferedSinkJsonWriter bufferedSinkJsonWriter = new BufferedSinkJsonWriter(buffer, null, 2, 0 == true ? 1 : 0);
            JsonWriters.writeAny(bufferedSinkJsonWriter, objResolveVariables);
            bufferedSinkJsonWriter.close();
            return this.name + '(' + buffer.readUtf8() + ')';
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    /* JADX INFO: compiled from: CompiledGraphQL.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u0016\u001a\u00020\u0003J\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fJ\u0014\u0010\u0012\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/apollographql/apollo3/api/CompiledField$Builder;", "", "compiledField", "Lcom/apollographql/apollo3/api/CompiledField;", "(Lcom/apollographql/apollo3/api/CompiledField;)V", "name", "", "type", "Lcom/apollographql/apollo3/api/CompiledType;", "(Ljava/lang/String;Lcom/apollographql/apollo3/api/CompiledType;)V", "alias", "arguments", "", "Lcom/apollographql/apollo3/api/CompiledArgument;", "condition", "Lcom/apollographql/apollo3/api/CompiledCondition;", "getName", "()Ljava/lang/String;", "selections", "Lcom/apollographql/apollo3/api/CompiledSelection;", "getType", "()Lcom/apollographql/apollo3/api/CompiledType;", "build", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private String alias;
        private List<CompiledArgument> arguments;
        private List<CompiledCondition> condition;
        private final String name;
        private List<? extends CompiledSelection> selections;
        private final CompiledType type;

        public Builder(String name, CompiledType type) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            this.name = name;
            this.type = type;
            this.condition = CollectionsKt.emptyList();
            this.arguments = CollectionsKt.emptyList();
            this.selections = CollectionsKt.emptyList();
        }

        public final String getName() {
            return this.name;
        }

        public final CompiledType getType() {
            return this.type;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CompiledField compiledField) {
            this(compiledField.getName(), compiledField.getType());
            Intrinsics.checkNotNullParameter(compiledField, "compiledField");
            this.alias = compiledField.getAlias();
            this.condition = compiledField.getCondition();
            this.arguments = compiledField.getArguments();
            this.selections = compiledField.getSelections();
        }

        public final Builder alias(String alias) {
            this.alias = alias;
            return this;
        }

        public final Builder condition(List<CompiledCondition> condition) {
            Intrinsics.checkNotNullParameter(condition, "condition");
            this.condition = condition;
            return this;
        }

        public final Builder arguments(List<CompiledArgument> arguments) {
            Intrinsics.checkNotNullParameter(arguments, "arguments");
            this.arguments = arguments;
            return this;
        }

        public final Builder selections(List<? extends CompiledSelection> selections) {
            Intrinsics.checkNotNullParameter(selections, "selections");
            this.selections = selections;
            return this;
        }

        public final CompiledField build() {
            return new CompiledField(this.name, this.type, this.alias, this.condition, this.arguments, this.selections);
        }
    }
}
