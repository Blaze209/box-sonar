package com.apollographql.apollo3.cache.normalized.api.internal;

import com.apollographql.apollo3.api.CompiledField;
import com.apollographql.apollo3.api.CompiledFragment;
import com.apollographql.apollo3.api.CompiledGraphQL;
import com.apollographql.apollo3.api.CompiledListType;
import com.apollographql.apollo3.api.CompiledNamedType;
import com.apollographql.apollo3.api.CompiledNotNullType;
import com.apollographql.apollo3.api.CompiledSelection;
import com.apollographql.apollo3.api.CompiledType;
import com.apollographql.apollo3.api.Executable;
import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.CacheKeyGenerator;
import com.apollographql.apollo3.cache.normalized.api.CacheKeyGeneratorContext;
import com.apollographql.apollo3.cache.normalized.api.Record;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Normalizer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001%B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ<\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J.\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010\u0015\u001a\u00020\u00182\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J>\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u000f2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0005J,\u0010\u001d\u001a\u0004\u0018\u00010\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0016\u0010#\u001a\u00020\u0005*\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u0005H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/Normalizer;", "", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "rootKey", "", "cacheKeyGenerator", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;", "(Lcom/apollographql/apollo3/api/Executable$Variables;Ljava/lang/String;Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;)V", "records", "", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "buildRecord", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "obj", "", "key", "selections", "", "Lcom/apollographql/apollo3/api/CompiledSelection;", "parentType", "collectFields", "Lcom/apollographql/apollo3/api/CompiledField;", "typename", "", "state", "Lcom/apollographql/apollo3/cache/normalized/api/internal/Normalizer$CollectState;", "normalize", "map", "replaceObjects", "value", "field", "type_", "Lcom/apollographql/apollo3/api/CompiledType;", "path", "append", ES6Iterator.NEXT_METHOD, "CollectState", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class Normalizer {
    private final CacheKeyGenerator cacheKeyGenerator;
    private final Map<String, Record> records;
    private final String rootKey;
    private final Executable.Variables variables;

    public Normalizer(Executable.Variables variables, String rootKey, CacheKeyGenerator cacheKeyGenerator) {
        Intrinsics.checkNotNullParameter(variables, "variables");
        Intrinsics.checkNotNullParameter(rootKey, "rootKey");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        this.variables = variables;
        this.rootKey = rootKey;
        this.cacheKeyGenerator = cacheKeyGenerator;
        this.records = new LinkedHashMap();
    }

    public final Map<String, Record> normalize(Map<String, ? extends Object> map, List<? extends CompiledSelection> selections, String parentType) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(selections, "selections");
        Intrinsics.checkNotNullParameter(parentType, "parentType");
        buildRecord(map, this.rootKey, selections, parentType);
        return this.records;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0065  */
    private final CacheKey buildRecord(Map<String, ? extends Object> obj, String key, List<? extends CompiledSelection> selections, String parentType) {
        Pair pair;
        Object obj2 = obj.get(GQLCacheConstants.TYPENAME_KEY);
        List<CompiledField> listCollectFields = collectFields(selections, parentType, obj2 instanceof String ? (String) obj2 : null);
        Set<Map.Entry<String, ? extends Object>> setEntrySet = obj.entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : listCollectFields) {
                if (Intrinsics.areEqual(((CompiledField) obj3).getResponseName(), entry.getKey())) {
                    arrayList2.add(obj3);
                }
            }
            ArrayList arrayList3 = arrayList2;
            if (arrayList3.isEmpty()) {
                pair = null;
            } else {
                ArrayList arrayList4 = new ArrayList();
                for (Object obj4 : arrayList3) {
                    if (!ShouldSkipKt.shouldSkip((CompiledField) obj4, this.variables.getValueMap())) {
                        arrayList4.add(obj4);
                    }
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5.isEmpty()) {
                    pair = null;
                } else {
                    CompiledField.Builder builderNewBuilder = ((CompiledField) CollectionsKt.first((List) arrayList5)).newBuilder();
                    ArrayList arrayList6 = new ArrayList();
                    Iterator it2 = arrayList5.iterator();
                    while (it2.hasNext()) {
                        CollectionsKt.addAll(arrayList6, ((CompiledField) it2.next()).getSelections());
                    }
                    CompiledField compiledFieldBuild = builderNewBuilder.selections(arrayList6).condition(CollectionsKt.emptyList()).build();
                    String strNameWithArguments = compiledFieldBuild.nameWithArguments(this.variables);
                    pair = TuplesKt.to(strNameWithArguments, replaceObjects(entry.getValue(), compiledFieldBuild, compiledFieldBuild.getType(), append(Intrinsics.areEqual(key, CacheKey.INSTANCE.rootKey().getKey()) ? null : key, strNameWithArguments)));
                }
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        Record record = new Record(key, MapsKt.toMap(arrayList), null, 4, null);
        Record record2 = this.records.get(key);
        if (record2 != null) {
            record = record2.mergeWith(record).getFirst();
        }
        this.records.put(key, record);
        return new CacheKey(key);
    }

    private final Object replaceObjects(Object value, CompiledField field, CompiledType type_, String path) {
        String key;
        if (type_ instanceof CompiledNotNullType) {
            if (value == null) {
                throw new IllegalStateException("Check failed.".toString());
            }
            type_ = ((CompiledNotNullType) type_).getOfType();
        } else if (value == null) {
            return null;
        }
        if (type_ instanceof CompiledListType) {
            if (!(value instanceof List)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            Iterable iterable = (Iterable) value;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            int i = 0;
            for (Object obj : iterable) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(replaceObjects(obj, field, ((CompiledListType) type_).getOfType(), append(path, String.valueOf(i))));
                i = i2;
            }
            return arrayList;
        }
        if (!(type_ instanceof CompiledNamedType) || !CompiledGraphQL.isComposite((CompiledNamedType) type_)) {
            return value;
        }
        if (!(value instanceof Map)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Map<String, ? extends Object> map = (Map) value;
        CacheKey cacheKeyCacheKeyForObject = this.cacheKeyGenerator.cacheKeyForObject(map, new CacheKeyGeneratorContext(field, this.variables));
        if (cacheKeyCacheKeyForObject != null && (key = cacheKeyCacheKeyForObject.getKey()) != null) {
            path = key;
        }
        return buildRecord(map, path, field.getSelections(), field.getType().rawType().getName());
    }

    /* JADX INFO: compiled from: Normalizer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/api/internal/Normalizer$CollectState;", "", "()V", "fields", "", "Lcom/apollographql/apollo3/api/CompiledField;", "getFields", "()Ljava/util/List;", "apollo-normalized-cache-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class CollectState {
        private final List<CompiledField> fields = new ArrayList();

        public final List<CompiledField> getFields() {
            return this.fields;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void collectFields(List<? extends CompiledSelection> selections, String parentType, String typename, CollectState state) {
        for (CompiledSelection compiledSelection : selections) {
            if (compiledSelection instanceof CompiledField) {
                state.getFields().add(compiledSelection);
            } else if (compiledSelection instanceof CompiledFragment) {
                CompiledFragment compiledFragment = (CompiledFragment) compiledSelection;
                if (CollectionsKt.contains(compiledFragment.getPossibleTypes(), typename) || Intrinsics.areEqual(compiledFragment.getTypeCondition(), parentType)) {
                    collectFields(compiledFragment.getSelections(), parentType, typename, state);
                }
            }
        }
    }

    private final List<CompiledField> collectFields(List<? extends CompiledSelection> selections, String parentType, String typename) {
        CollectState collectState = new CollectState();
        collectFields(selections, parentType, typename, collectState);
        return collectState.getFields();
    }

    private final String append(String str, String str2) {
        return str == null ? str2 : str + '.' + str2;
    }
}
