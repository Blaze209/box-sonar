package com.apollographql.apollo3.api;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.json.MapJsonReader;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: fakeResolver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000F\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a[\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010\u001aR\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001aP\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001aP\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001aY\u0010\u001d\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u001f\u001a$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a$\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a*\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0019*\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010#\u001a\u00020\bH\u0002¨\u0006$"}, d2 = {"buildData", ExifInterface.GPS_DIRECTION_TRUE, "adapter", "Lcom/apollographql/apollo3/api/Adapter;", "selections", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "typename", "", "map", "", "", "resolver", "Lcom/apollographql/apollo3/api/FakeResolver;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "(Lcom/apollographql/apollo3/api/Adapter;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Lcom/apollographql/apollo3/api/FakeResolver;Lcom/apollographql/apollo3/api/CustomScalarAdapters;)Ljava/lang/Object;", "buildFakeObject", "base", "buildFieldOfNonNullType", "path", "id", "mergedField", "Lcom/apollographql/apollo3/api/CompiledField;", "value", "Lcom/apollographql/apollo3/api/Optional;", "type", "Lcom/apollographql/apollo3/api/CompiledType;", "buildFieldOfType", "buildFragmentData", "block", "(Lcom/apollographql/apollo3/api/Adapter;Ljava/util/List;Ljava/lang/String;Ljava/lang/Object;Lcom/apollographql/apollo3/api/FakeResolver;Lcom/apollographql/apollo3/api/CompiledType;Lcom/apollographql/apollo3/api/CustomScalarAdapters;)Ljava/lang/Object;", "collect", "collectAndMerge", "getOrAbsent", "key", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class FakeResolverKt {
    private static final List<CompiledField> collect(List<? extends CompiledSelection> list, String str) {
        List<CompiledField> listEmptyList;
        ArrayList arrayList = new ArrayList();
        for (CompiledSelection compiledSelection : list) {
            if (compiledSelection instanceof CompiledField) {
                listEmptyList = CollectionsKt.listOf(compiledSelection);
            } else if (compiledSelection instanceof CompiledFragment) {
                CompiledFragment compiledFragment = (CompiledFragment) compiledSelection;
                if (compiledFragment.getPossibleTypes().contains(str)) {
                    listEmptyList = collect(compiledFragment.getSelections(), str);
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            CollectionsKt.addAll(arrayList, listEmptyList);
        }
        return arrayList;
    }

    private static final List<CompiledField> collectAndMerge(List<? extends CompiledSelection> list, String str) {
        List<CompiledField> listCollect = collect(list, str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : listCollect) {
            String responseName = ((CompiledField) obj).getResponseName();
            Object obj2 = linkedHashMap.get(responseName);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(responseName, obj2);
            }
            ((List) obj2).add(obj);
        }
        Collection<List> collectionValues = linkedHashMap.values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
        for (List list2 : collectionValues) {
            CompiledField compiledField = (CompiledField) CollectionsKt.first(list2);
            CompiledField.Builder builderAlias = new CompiledField.Builder(compiledField.getName(), compiledField.getType()).alias(compiledField.getAlias());
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList2, ((CompiledField) it.next()).getSelections());
            }
            arrayList.add(builderAlias.selections(arrayList2).build());
        }
        return arrayList;
    }

    private static final Map<String, Object> buildFakeObject(List<? extends CompiledSelection> list, String str, Map<String, ? extends Object> map, FakeResolver fakeResolver, CustomScalarAdapters customScalarAdapters) {
        Object objBuildFieldOfType = buildFieldOfType(CollectionsKt.emptyList(), "", new CompiledField.Builder("data", new CompiledNotNullType(new ObjectType.Builder(str).build())).selections(list).build(), fakeResolver, new Optional.Present(map), new CompiledNotNullType(new ObjectType.Builder(str).build()), customScalarAdapters);
        Intrinsics.checkNotNull(objBuildFieldOfType, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        return (Map) objBuildFieldOfType;
    }

    private static final Optional<Object> getOrAbsent(Map<String, ? extends Object> map, String str) {
        if (map.containsKey(str)) {
            return new Optional.Present(map.get(str));
        }
        return Optional.Absent.INSTANCE;
    }

    private static final Object buildFieldOfType(List<? extends Object> list, String str, CompiledField compiledField, FakeResolver fakeResolver, Optional<? extends Object> optional, CompiledType compiledType, CustomScalarAdapters customScalarAdapters) {
        boolean z = optional instanceof Optional.Present;
        if (z && (((Optional.Present) optional).getValue() instanceof Optional.Absent)) {
            return Optional.Absent.INSTANCE;
        }
        if (compiledType instanceof CompiledNotNullType) {
            return buildFieldOfNonNullType(list, str, compiledField, fakeResolver, optional, ((CompiledNotNullType) compiledType).getOfType(), customScalarAdapters);
        }
        if (z) {
            if (((Optional.Present) optional).getValue() == null) {
                return null;
            }
            return buildFieldOfType(list, str, compiledField, fakeResolver, optional, new CompiledNotNullType(compiledType), customScalarAdapters);
        }
        if (fakeResolver.resolveMaybeNull(new FakeResolverContext(list, str, compiledField))) {
            return null;
        }
        return buildFieldOfType(list, str, compiledField, fakeResolver, optional, new CompiledNotNullType(compiledType), customScalarAdapters);
    }

    private static final Object buildFieldOfNonNullType(List<? extends Object> list, String str, CompiledField compiledField, FakeResolver fakeResolver, Optional<? extends Object> optional, CompiledType compiledType, CustomScalarAdapters customScalarAdapters) {
        Adapter adapterResponseAdapterFor = null;
        if (compiledType instanceof CompiledListType) {
            int i = 0;
            if (optional instanceof Optional.Present) {
                Object value = ((Optional.Present) optional).getValue();
                List list2 = value instanceof List ? (List) value : null;
                if (list2 == null) {
                    throw new IllegalStateException("".toString());
                }
                List list3 = list2;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (Object obj : list3) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList.add(buildFieldOfType(CollectionsKt.plus((Collection<? extends Integer>) list, Integer.valueOf(i)), str, compiledField, fakeResolver, new Optional.Present(obj), ((CompiledListType) compiledType).getOfType(), customScalarAdapters));
                    i = i2;
                }
                return arrayList;
            }
            CompiledField compiledField2 = compiledField;
            IntRange intRangeUntil = RangesKt.until(0, fakeResolver.resolveListSize(new FakeResolverContext(list, str, compiledField2)));
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                CompiledField compiledField3 = compiledField2;
                compiledField2 = compiledField3;
                arrayList2.add(buildFieldOfType(CollectionsKt.plus((Collection<? extends Integer>) list, Integer.valueOf(iNextInt)), str + iNextInt, compiledField3, fakeResolver, Optional.Absent.INSTANCE, ((CompiledListType) compiledType).getOfType(), customScalarAdapters));
            }
            return arrayList2;
        }
        String str2 = str;
        FakeResolver fakeResolver2 = fakeResolver;
        if (compiledType instanceof CompiledNamedType) {
            if (optional instanceof Optional.Present) {
                if (!compiledField.getSelections().isEmpty()) {
                    Object value2 = ((Optional.Present) optional).getValue();
                    Map<String, ? extends Object> map = value2 instanceof Map ? (Map) value2 : null;
                    if (map == null) {
                        throw new IllegalStateException("".toString());
                    }
                    Object obj2 = map.get(GQLCacheConstants.TYPENAME_KEY);
                    String str3 = obj2 instanceof String ? (String) obj2 : null;
                    if (str3 == null) {
                        throw new IllegalStateException("".toString());
                    }
                    String strStableIdForObject = fakeResolver2.stableIdForObject(map, compiledField);
                    if (strStableIdForObject != null) {
                        str2 = strStableIdForObject;
                    }
                    List<CompiledField> listCollectAndMerge = collectAndMerge(compiledField.getSelections(), str3);
                    ArrayList arrayList3 = new ArrayList();
                    for (CompiledField compiledField4 : listCollectAndMerge) {
                        FakeResolver fakeResolver3 = fakeResolver2;
                        Object objBuildFieldOfType = buildFieldOfType(CollectionsKt.plus((Collection<? extends String>) list, compiledField4.getResponseName()), str2 + compiledField4.getResponseName(), compiledField4, fakeResolver3, getOrAbsent(map, compiledField4.getResponseName()), compiledField4.getType(), customScalarAdapters);
                        Pair pair = objBuildFieldOfType instanceof Optional.Absent ? null : TuplesKt.to(compiledField4.getResponseName(), objBuildFieldOfType);
                        if (pair != null) {
                            arrayList3.add(pair);
                        }
                        fakeResolver2 = fakeResolver3;
                    }
                    return MapsKt.toMap(arrayList3);
                }
                return ((Optional.Present) optional).getValue();
            }
            if (!compiledField.getSelections().isEmpty()) {
                String strResolveTypename = fakeResolver2.resolveTypename(new FakeResolverContext(list, str2, compiledField));
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to(GQLCacheConstants.TYPENAME_KEY, strResolveTypename));
                List<CompiledField> listCollectAndMerge2 = collectAndMerge(compiledField.getSelections(), strResolveTypename);
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listCollectAndMerge2, 10)), 16));
                for (CompiledField compiledField5 : listCollectAndMerge2) {
                    List listPlus = CollectionsKt.plus((Collection<? extends String>) list, compiledField5.getResponseName());
                    Pair pair2 = TuplesKt.to(compiledField5.getResponseName(), buildFieldOfType(listPlus, CollectionsKt.joinToString$default(listPlus, null, null, null, 0, null, null, 63, null), compiledField5, fakeResolver2, getOrAbsent(mapMapOf, compiledField5.getResponseName()), compiledField5.getType(), customScalarAdapters));
                    linkedHashMap.put(pair2.getFirst(), pair2.getSecond());
                }
                return linkedHashMap;
            }
            Object objResolveLeaf = fakeResolver2.resolveLeaf(new FakeResolverContext(list, str2, compiledField));
            if (!(compiledType instanceof CustomScalarType)) {
                return objResolveLeaf;
            }
            try {
                adapterResponseAdapterFor = customScalarAdapters.responseAdapterFor((CustomScalarType) compiledType);
            } catch (Exception unused) {
            }
            return adapterResponseAdapterFor != null ? ObjectBuilderKt.adaptValue(adapterResponseAdapterFor, objResolveLeaf) : objResolveLeaf;
        }
        if (compiledType instanceof CompiledNotNullType) {
            throw new IllegalStateException("".toString());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <T> T buildData(Adapter<T> adapter, List<? extends CompiledSelection> selections, String typename, Map<String, ? extends Object> map, FakeResolver resolver, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(selections, "selections");
        Intrinsics.checkNotNullParameter(typename, "typename");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return (T) Adapters.m11186obj(adapter, false).fromJson(new MapJsonReader(buildFakeObject(selections, typename, map, resolver, customScalarAdapters), null, 2, null), CustomScalarAdapters.PassThrough);
    }

    public static /* synthetic */ Object buildFragmentData$default(Adapter adapter, List list, String str, Object obj, FakeResolver fakeResolver, CompiledType compiledType, CustomScalarAdapters customScalarAdapters, int i, Object obj2) {
        if ((i & 8) != 0) {
            obj = null;
        }
        return buildFragmentData(adapter, list, str, obj, fakeResolver, compiledType, customScalarAdapters);
    }

    public static final <T> T buildFragmentData(Adapter<T> adapter, List<? extends CompiledSelection> selections, String typename, Object obj, FakeResolver resolver, CompiledType type, CustomScalarAdapters customScalarAdapters) {
        Map mapMapOf;
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(selections, "selections");
        Intrinsics.checkNotNullParameter(typename, "typename");
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        if (obj == null) {
            mapMapOf = MapsKt.mapOf(TuplesKt.to(GQLCacheConstants.TYPENAME_KEY, resolver.resolveTypename(new FakeResolverContext(CollectionsKt.emptyList(), "fragmentRoot", new CompiledField.Builder("__fragmentRoot", type).build()))));
        } else {
            mapMapOf = (Map) ((Function1) obj).invoke(ObjectBuilderKt.getGlobalBuilder());
        }
        return (T) buildData(adapter, selections, typename, mapMapOf, resolver, customScalarAdapters);
    }
}
