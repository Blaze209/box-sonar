package com.apollographql.apollo3.api;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.internal.Version2CustomTypeAdapterToAdapter;
import com.box.android.observability.DiagnosisParams;
import com.pspdfkit.annotations.NoteAnnotation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomScalarAdapters.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB/\b\u0002\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0005\"\b\b\u0000\u0010\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH\u0007R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "Lcom/apollographql/apollo3/api/ExecutionContext$Element;", "customScalarAdapters", "", "", "Lcom/apollographql/apollo3/api/Adapter;", "adapterContext", "Lcom/apollographql/apollo3/api/AdapterContext;", "unsafe", "", "(Ljava/util/Map;Lcom/apollographql/apollo3/api/AdapterContext;Z)V", "getAdapterContext", "()Lcom/apollographql/apollo3/api/AdapterContext;", "adaptersMap", "key", "Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "getKey", "()Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "newBuilder", "Lcom/apollographql/apollo3/api/CustomScalarAdapters$Builder;", "responseAdapterFor", ExifInterface.GPS_DIRECTION_TRUE, "", "customScalar", "Lcom/apollographql/apollo3/api/CustomScalarType;", "variables", "", "Builder", NoteAnnotation.KEY, "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomScalarAdapters implements ExecutionContext.Element {
    private final C0868AdapterContext adapterContext;
    private final Map<String, Adapter<?>> adaptersMap;
    private final boolean unsafe;

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final CustomScalarAdapters Empty = new Builder().build();
    public static final CustomScalarAdapters PassThrough = new Builder().unsafe(true).build();

    public /* synthetic */ CustomScalarAdapters(Map map, C0868AdapterContext c0868AdapterContext, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, c0868AdapterContext, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CustomScalarAdapters(Map<String, ? extends Adapter<?>> map, C0868AdapterContext c0868AdapterContext, boolean z) {
        this.adapterContext = c0868AdapterContext;
        this.unsafe = z;
        this.adaptersMap = map;
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public <R> R fold(R r, Function2<? super R, ? super ExecutionContext.Element, ? extends R> function2) {
        return (R) ExecutionContext.Element.DefaultImpls.fold(this, r, function2);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public <E extends ExecutionContext.Element> E get(ExecutionContext.Key<E> key) {
        return (E) ExecutionContext.Element.DefaultImpls.get(this, key);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public ExecutionContext minusKey(ExecutionContext.Key<?> key) {
        return ExecutionContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext
    public ExecutionContext plus(ExecutionContext executionContext) {
        return ExecutionContext.Element.DefaultImpls.plus(this, executionContext);
    }

    public final C0868AdapterContext getAdapterContext() {
        return this.adapterContext;
    }

    public final <T> Adapter<T> responseAdapterFor(CustomScalarType customScalar) {
        PassThroughAdapter passThroughAdapter;
        Intrinsics.checkNotNullParameter(customScalar, "customScalar");
        if (this.adaptersMap.get(customScalar.getName()) != null) {
            passThroughAdapter = (Adapter<T>) this.adaptersMap.get(customScalar.getName());
        } else if (Intrinsics.areEqual(customScalar.getClassName(), "com.apollographql.apollo3.api.Upload")) {
            passThroughAdapter = (Adapter<T>) Adapters.UploadAdapter;
        } else if (CollectionsKt.listOf((Object[]) new String[]{"kotlin.String", "java.lang.String"}).contains(customScalar.getClassName())) {
            passThroughAdapter = (Adapter<T>) Adapters.StringAdapter;
        } else if (CollectionsKt.listOf((Object[]) new String[]{"kotlin.Boolean", "java.lang.Boolean"}).contains(customScalar.getClassName())) {
            passThroughAdapter = (Adapter<T>) Adapters.BooleanAdapter;
        } else if (CollectionsKt.listOf((Object[]) new String[]{"kotlin.Int", "java.lang.Int"}).contains(customScalar.getClassName())) {
            passThroughAdapter = (Adapter<T>) Adapters.IntAdapter;
        } else if (CollectionsKt.listOf((Object[]) new String[]{"kotlin.Double", "java.lang.Double"}).contains(customScalar.getClassName())) {
            passThroughAdapter = (Adapter<T>) Adapters.DoubleAdapter;
        } else if (CollectionsKt.listOf((Object[]) new String[]{"kotlin.Long", "java.lang.Long"}).contains(customScalar.getClassName())) {
            passThroughAdapter = (Adapter<T>) Adapters.LongAdapter;
        } else if (CollectionsKt.listOf((Object[]) new String[]{"kotlin.Float", "java.lang.Float"}).contains(customScalar.getClassName())) {
            passThroughAdapter = (Adapter<T>) Adapters.FloatAdapter;
        } else if (CollectionsKt.listOf((Object[]) new String[]{"kotlin.Any", "java.lang.Object"}).contains(customScalar.getClassName())) {
            passThroughAdapter = (Adapter<T>) Adapters.AnyAdapter;
        } else {
            if (!this.unsafe) {
                throw new IllegalStateException(("Can't map GraphQL type: `" + customScalar.getName() + "` to: `" + customScalar.getClassName() + "`. Did you forget to add a CustomScalarAdapter?").toString());
            }
            passThroughAdapter = new PassThroughAdapter();
        }
        Intrinsics.checkNotNull(passThroughAdapter, "null cannot be cast to non-null type com.apollographql.apollo3.api.Adapter<T of com.apollographql.apollo3.api.CustomScalarAdapters.responseAdapterFor>");
        return passThroughAdapter;
    }

    @Deprecated(message = "Use adapterContext.variables() instead", replaceWith = @ReplaceWith(expression = "adapterContext.variables()", imports = {}))
    public final Set<String> variables() {
        return this.adapterContext.variables();
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element
    public ExecutionContext.Key<?> getKey() {
        return INSTANCE;
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.api.CustomScalarAdapters$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: CustomScalarAdapters.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/apollographql/apollo3/api/CustomScalarAdapters$Key;", "Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "()V", "Empty", "PassThrough", "getPassThrough$annotations", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion implements ExecutionContext.Key<CustomScalarAdapters> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPassThrough$annotations() {
        }

        private Companion() {
        }
    }

    public final Builder newBuilder() {
        return new Builder().addAll(this);
    }

    /* JADX INFO: compiled from: CustomScalarAdapters.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\"\u0010\u000b\u001a\u00020\u0000\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\f0\bJ$\u0010\u000b\u001a\u00020\u0000\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\f0\u0011H\u0007J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/apollographql/apollo3/api/CustomScalarAdapters$Builder;", "", "()V", "adapterContext", "Lcom/apollographql/apollo3/api/AdapterContext;", "adaptersMap", "", "", "Lcom/apollographql/apollo3/api/Adapter;", "unsafe", "", "add", ExifInterface.GPS_DIRECTION_TRUE, "customScalarType", "Lcom/apollographql/apollo3/api/CustomScalarType;", "customScalarAdapter", "customTypeAdapter", "Lcom/apollographql/apollo3/api/CustomTypeAdapter;", "addAll", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "build", DiagnosisParams.CLEAR_ON_LOGOUT, "", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private boolean unsafe;
        private final Map<String, Adapter<?>> adaptersMap = new LinkedHashMap();
        private C0868AdapterContext adapterContext = new C0868AdapterContext.Builder().build();

        public final <T> Builder add(CustomScalarType customScalarType, Adapter<T> customScalarAdapter) {
            Intrinsics.checkNotNullParameter(customScalarType, "customScalarType");
            Intrinsics.checkNotNullParameter(customScalarAdapter, "customScalarAdapter");
            this.adaptersMap.put(customScalarType.getName(), customScalarAdapter);
            return this;
        }

        @Deprecated(message = "Used for backward compatibility with 2.x")
        public final <T> Builder add(CustomScalarType customScalarType, CustomTypeAdapter<T> customTypeAdapter) {
            Intrinsics.checkNotNullParameter(customScalarType, "customScalarType");
            Intrinsics.checkNotNullParameter(customTypeAdapter, "customTypeAdapter");
            this.adaptersMap.put(customScalarType.getName(), new Version2CustomTypeAdapterToAdapter(customTypeAdapter));
            return this;
        }

        public final Builder addAll(CustomScalarAdapters customScalarAdapters) {
            Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
            this.adaptersMap.putAll(customScalarAdapters.adaptersMap);
            return this;
        }

        public final Builder unsafe(boolean unsafe) {
            this.unsafe = unsafe;
            return this;
        }

        public final void clear() {
            this.adaptersMap.clear();
        }

        public final CustomScalarAdapters build() {
            return new CustomScalarAdapters(this.adaptersMap, this.adapterContext, this.unsafe, null);
        }

        public final Builder adapterContext(C0868AdapterContext adapterContext) {
            Intrinsics.checkNotNullParameter(adapterContext, "adapterContext");
            this.adapterContext = adapterContext;
            return this;
        }

        @Deprecated(message = "Use AdapterContext.Builder.variables() instead")
        public final Builder variables(Executable.Variables variables) {
            Intrinsics.checkNotNullParameter(variables, "variables");
            this.adapterContext = this.adapterContext.newBuilder().variables(variables).build();
            return this;
        }
    }
}
