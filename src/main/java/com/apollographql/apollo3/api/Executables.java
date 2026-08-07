package com.apollographql.apollo3.api;

import com.apollographql.apollo3.api.json.BufferedSinkJsonWriter;
import com.apollographql.apollo3.api.json.MapJsonWriter;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* JADX INFO: compiled from: Executables.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\"\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\u0007\u001a\u00020\u0001\u001a,\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a\"\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\u0004*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\u0007\u001a\u00020\u0001¨\u0006\f"}, d2 = {"serializeVariablesWithDefaultBooleanValues", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "variables", "Lcom/apollographql/apollo3/api/Executable$Variables;", "D", "Lcom/apollographql/apollo3/api/Executable$Data;", "Lcom/apollographql/apollo3/api/Executable;", "customScalarAdapters", "withDefaultBooleanValues", "", "variablesJson", "", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class Executables {
    public static final <D extends Executable.Data> Executable.Variables variables(Executable<D> executable, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(executable, "<this>");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return variables(executable, customScalarAdapters, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <D extends Executable.Data> String variablesJson(Executable<D> executable, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(executable, "<this>");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        Buffer buffer = new Buffer();
        BufferedSinkJsonWriter bufferedSinkJsonWriter = new BufferedSinkJsonWriter(buffer, null, 2, 0 == true ? 1 : 0);
        bufferedSinkJsonWriter.beginObject();
        executable.serializeVariables(bufferedSinkJsonWriter, serializeVariablesWithDefaultBooleanValues(customScalarAdapters));
        bufferedSinkJsonWriter.endObject();
        return buffer.readUtf8();
    }

    public static final <D extends Executable.Data> Executable.Variables variables(Executable<D> executable, CustomScalarAdapters customScalarAdapters, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(executable, "<this>");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        MapJsonWriter mapJsonWriter = new MapJsonWriter();
        mapJsonWriter.beginObject();
        MapJsonWriter mapJsonWriter2 = mapJsonWriter;
        if (z) {
            customScalarAdapters = serializeVariablesWithDefaultBooleanValues(customScalarAdapters);
        }
        executable.serializeVariables(mapJsonWriter2, customScalarAdapters);
        mapJsonWriter.endObject();
        Object objRoot = mapJsonWriter.root();
        Intrinsics.checkNotNull(objRoot, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
        return new Executable.Variables((Map) objRoot);
    }

    private static final CustomScalarAdapters serializeVariablesWithDefaultBooleanValues(CustomScalarAdapters customScalarAdapters) {
        return customScalarAdapters.newBuilder().adapterContext(customScalarAdapters.getAdapterContext().newBuilder().serializeVariablesWithDefaultBooleanValues(true).build()).build();
    }
}
