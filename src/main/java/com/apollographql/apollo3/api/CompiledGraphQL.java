package com.apollographql.apollo3.api;

import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CompiledGraphQL.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020 \u001a\u0010\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"*\u00020 \u001a\u0011\u0010$\u001a\u00020%*\u00020&H\u0007¢\u0006\u0002\b'\u001a\u0011\u0010(\u001a\u00020)*\u00020&H\u0007¢\u0006\u0002\b*\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003\"\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003\"\u0016\u0010\u0011\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003\"\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003\"\u0016\u0010\u0015\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0003\"\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0003¨\u0006+"}, d2 = {"CompiledBooleanType", "Lcom/apollographql/apollo3/api/ScalarType;", "getCompiledBooleanType$annotations", "()V", "CompiledDirectiveType", "Lcom/apollographql/apollo3/api/ObjectType;", "getCompiledDirectiveType$annotations", "CompiledEnumValueType", "getCompiledEnumValueType$annotations", "CompiledFieldType", "getCompiledFieldType$annotations", "CompiledFloatType", "getCompiledFloatType$annotations", "CompiledIDType", "getCompiledIDType$annotations", "CompiledInputValueType", "getCompiledInputValueType$annotations", "CompiledIntType", "getCompiledIntType$annotations", "CompiledSchemaType", "getCompiledSchemaType$annotations", "CompiledStringType", "getCompiledStringType$annotations", "CompiledTypeType", "getCompiledTypeType$annotations", "resolveVariables", "", "value", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "isComposite", "", "Lcom/apollographql/apollo3/api/CompiledNamedType;", "keyFields", "", "", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, "Lcom/apollographql/apollo3/api/CompiledListType;", "Lcom/apollographql/apollo3/api/CompiledType;", "-list", "notNull", "Lcom/apollographql/apollo3/api/CompiledNotNullType;", "-notNull", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CompiledGraphQL {
    public static final ScalarType CompiledStringType = new ScalarType("String");
    public static final ScalarType CompiledIntType = new ScalarType("Int");
    public static final ScalarType CompiledFloatType = new ScalarType("Float");
    public static final ScalarType CompiledBooleanType = new ScalarType("Boolean");
    public static final ScalarType CompiledIDType = new ScalarType("ID");
    public static final ObjectType CompiledSchemaType = new ObjectType.Builder("__Schema").build();
    public static final ObjectType CompiledTypeType = new ObjectType.Builder("__Type").build();
    public static final ObjectType CompiledFieldType = new ObjectType.Builder("__Field").build();
    public static final ObjectType CompiledInputValueType = new ObjectType.Builder("__InputValue").build();
    public static final ObjectType CompiledEnumValueType = new ObjectType.Builder("__EnumValue").build();
    public static final ObjectType CompiledDirectiveType = new ObjectType.Builder("__Directive").build();

    @Deprecated(message = "Use the generated CustomScalarType instead")
    public static /* synthetic */ void getCompiledBooleanType$annotations() {
    }

    public static /* synthetic */ void getCompiledDirectiveType$annotations() {
    }

    public static /* synthetic */ void getCompiledEnumValueType$annotations() {
    }

    public static /* synthetic */ void getCompiledFieldType$annotations() {
    }

    @Deprecated(message = "Use the generated CustomScalarType instead")
    public static /* synthetic */ void getCompiledFloatType$annotations() {
    }

    @Deprecated(message = "Use the generated CustomScalarType instead")
    public static /* synthetic */ void getCompiledIDType$annotations() {
    }

    public static /* synthetic */ void getCompiledInputValueType$annotations() {
    }

    @Deprecated(message = "Use the generated CustomScalarType instead")
    public static /* synthetic */ void getCompiledIntType$annotations() {
    }

    public static /* synthetic */ void getCompiledSchemaType$annotations() {
    }

    @Deprecated(message = "Use the generated CustomScalarType instead")
    public static /* synthetic */ void getCompiledStringType$annotations() {
    }

    public static /* synthetic */ void getCompiledTypeType$annotations() {
    }

    /* JADX INFO: renamed from: -notNull, reason: not valid java name */
    public static final CompiledNotNullType m11195notNull(CompiledType compiledType) {
        Intrinsics.checkNotNullParameter(compiledType, "<this>");
        return new CompiledNotNullType(compiledType);
    }

    /* JADX INFO: renamed from: -list, reason: not valid java name */
    public static final CompiledListType m11194list(CompiledType compiledType) {
        Intrinsics.checkNotNullParameter(compiledType, "<this>");
        return new CompiledListType(compiledType);
    }

    @Deprecated(message = "This shouldn't be part of the public API and will be removed in Apollo Kotlin 4. If you needed this, please open an issue.")
    public static final Object resolveVariables(Object obj, Executable.Variables variables) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        if (obj == null) {
            return null;
        }
        if (obj instanceof CompiledVariable) {
            return variables.getValueMap().get(((CompiledVariable) obj).getName());
        }
        if (obj instanceof Map) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            Map map = (Map) obj;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), resolveVariables(entry.getValue(), variables));
            }
            return MapsKt.toMap(CollectionsKt.sortedWith(MapsKt.toList(linkedHashMap), new Comparator() { // from class: com.apollographql.apollo3.api.CompiledGraphQL$resolveVariables$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues((String) ((Pair) t).getFirst(), (String) ((Pair) t2).getFirst());
                }
            }));
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        Iterable iterable = (Iterable) obj;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(resolveVariables(it.next(), variables));
        }
        return arrayList;
    }

    public static final boolean isComposite(CompiledNamedType compiledNamedType) {
        Intrinsics.checkNotNullParameter(compiledNamedType, "<this>");
        if (compiledNamedType instanceof UnionType ? true : compiledNamedType instanceof InterfaceType) {
            return true;
        }
        return compiledNamedType instanceof ObjectType;
    }

    public static final List<String> keyFields(CompiledNamedType compiledNamedType) {
        Intrinsics.checkNotNullParameter(compiledNamedType, "<this>");
        if (compiledNamedType instanceof InterfaceType) {
            return ((InterfaceType) compiledNamedType).getKeyFields();
        }
        return compiledNamedType instanceof ObjectType ? ((ObjectType) compiledNamedType).getKeyFields() : CollectionsKt.emptyList();
    }
}
