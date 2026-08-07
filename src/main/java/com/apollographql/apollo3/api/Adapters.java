package com.apollographql.apollo3.api;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.json.BufferedSinkJsonWriter;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonReaders;
import com.apollographql.apollo3.api.json.JsonWriter;
import com.apollographql.apollo3.api.json.JsonWriters;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

/* JADX INFO: compiled from: Adapters.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a#\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u001e\"\u0004\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0\u0001H\u0007¢\u0006\u0002\b \u001a'\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001f0\u0015\"\b\b\u0000\u0010\u001f*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u001f0\u0001H\u0007¢\u0006\u0002\b\"\u001a-\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u001f0$\"\u0004\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0\u00012\b\b\u0002\u0010%\u001a\u00020\u0006H\u0007¢\u0006\u0002\b&\u001a#\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u001f0(\"\u0004\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0\u0001H\u0007¢\u0006\u0002\b)\u001a#\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u001f0(\"\u0004\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0\u0001H\u0007¢\u0006\u0002\b+\u001a=\u0010,\u001a\u00020\f\"\u0004\b\u0000\u0010\u001f*\b\u0012\u0004\u0012\u0002H\u001f0\u00012\u0006\u0010-\u001a\u0002H\u001f2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b1\u00102\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00158\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"AnyAdapter", "Lcom/apollographql/apollo3/api/Adapter;", "", "ApolloOptionalAnyAdapter", "Lcom/apollographql/apollo3/api/ApolloOptionalAdapter;", "ApolloOptionalBooleanAdapter", "", "ApolloOptionalDoubleAdapter", "", "ApolloOptionalIntAdapter", "", "ApolloOptionalStringAdapter", "", "BooleanAdapter", "DoubleAdapter", "FloatAdapter", "", "IntAdapter", "LongAdapter", "", "NullableAnyAdapter", "Lcom/apollographql/apollo3/api/NullableAdapter;", "NullableBooleanAdapter", "NullableDoubleAdapter", "NullableIntAdapter", "NullableStringAdapter", "StringAdapter", "UploadAdapter", "Lcom/apollographql/apollo3/api/Upload;", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST, "Lcom/apollographql/apollo3/api/ListAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "-list", "nullable", "-nullable", "obj", "Lcom/apollographql/apollo3/api/ObjectAdapter;", "buffered", "-obj", "optional", "Lcom/apollographql/apollo3/api/PresentAdapter;", "-optional", "present", "-present", "toJsonString", "value", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", BoxNoteConstants.BOX_NOTE_STYLE_TYPE_INDENT, "-toJson", "(Lcom/apollographql/apollo3/api/Adapter;Ljava/lang/Object;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Ljava/lang/String;)Ljava/lang/String;", "apollo-api"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class Adapters {
    public static final Adapter<Object> AnyAdapter;
    public static final ApolloOptionalAdapter<Object> ApolloOptionalAnyAdapter;
    public static final ApolloOptionalAdapter<Boolean> ApolloOptionalBooleanAdapter;
    public static final ApolloOptionalAdapter<Double> ApolloOptionalDoubleAdapter;
    public static final ApolloOptionalAdapter<Integer> ApolloOptionalIntAdapter;
    public static final ApolloOptionalAdapter<String> ApolloOptionalStringAdapter;
    public static final Adapter<Boolean> BooleanAdapter;
    public static final Adapter<Double> DoubleAdapter;
    public static final Adapter<Float> FloatAdapter;
    public static final Adapter<Integer> IntAdapter;
    public static final Adapter<Long> LongAdapter;
    public static final NullableAdapter<Object> NullableAnyAdapter;
    public static final NullableAdapter<Boolean> NullableBooleanAdapter;
    public static final NullableAdapter<Double> NullableDoubleAdapter;
    public static final NullableAdapter<Integer> NullableIntAdapter;
    public static final NullableAdapter<String> NullableStringAdapter;
    public static final Adapter<String> StringAdapter;
    public static final Adapter<Upload> UploadAdapter;

    /* JADX INFO: renamed from: -toJson, reason: not valid java name */
    public static final <T> String m11190toJson(Adapter<T> adapter, T t) {
        Intrinsics.checkNotNullParameter(adapter, "<this>");
        return m11193toJson$default(adapter, t, null, null, 6, null);
    }

    /* JADX INFO: renamed from: -toJson, reason: not valid java name */
    public static final <T> String m11191toJson(Adapter<T> adapter, T t, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(adapter, "<this>");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return m11193toJson$default(adapter, t, customScalarAdapters, null, 4, null);
    }

    static {
        Adapter<String> adapter = new Adapter<String>() { // from class: com.apollographql.apollo3.api.Adapters$StringAdapter$1
            @Override // com.apollographql.apollo3.api.Adapter
            public String fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                String strNextString = reader.nextString();
                Intrinsics.checkNotNull(strNextString);
                return strNextString;
            }

            @Override // com.apollographql.apollo3.api.Adapter
            public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, String value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                Intrinsics.checkNotNullParameter(value, "value");
                writer.value(value);
            }
        };
        StringAdapter = adapter;
        Adapter<Integer> adapter2 = new Adapter<Integer>() { // from class: com.apollographql.apollo3.api.Adapters$IntAdapter$1
            @Override // com.apollographql.apollo3.api.Adapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, CustomScalarAdapters customScalarAdapters, Integer num) throws IOException {
                toJson(jsonWriter, customScalarAdapters, num.intValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.apollographql.apollo3.api.Adapter
            public Integer fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                return Integer.valueOf(reader.nextInt());
            }

            public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, int value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                writer.value(value);
            }
        };
        IntAdapter = adapter2;
        Adapter<Double> adapter3 = new Adapter<Double>() { // from class: com.apollographql.apollo3.api.Adapters$DoubleAdapter$1
            @Override // com.apollographql.apollo3.api.Adapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, CustomScalarAdapters customScalarAdapters, Double d) throws IOException {
                toJson(jsonWriter, customScalarAdapters, d.doubleValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.apollographql.apollo3.api.Adapter
            public Double fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                return Double.valueOf(reader.nextDouble());
            }

            public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, double value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                writer.value(value);
            }
        };
        DoubleAdapter = adapter3;
        FloatAdapter = new Adapter<Float>() { // from class: com.apollographql.apollo3.api.Adapters$FloatAdapter$1
            @Override // com.apollographql.apollo3.api.Adapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, CustomScalarAdapters customScalarAdapters, Float f) throws IOException {
                toJson(jsonWriter, customScalarAdapters, f.floatValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.apollographql.apollo3.api.Adapter
            public Float fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                return Float.valueOf((float) reader.nextDouble());
            }

            public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, float value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                writer.value(value);
            }
        };
        LongAdapter = new Adapter<Long>() { // from class: com.apollographql.apollo3.api.Adapters$LongAdapter$1
            @Override // com.apollographql.apollo3.api.Adapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, CustomScalarAdapters customScalarAdapters, Long l) throws IOException {
                toJson(jsonWriter, customScalarAdapters, l.longValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.apollographql.apollo3.api.Adapter
            public Long fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                return Long.valueOf(reader.nextLong());
            }

            public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, long value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                writer.value(value);
            }
        };
        Adapter<Boolean> adapter4 = new Adapter<Boolean>() { // from class: com.apollographql.apollo3.api.Adapters$BooleanAdapter$1
            @Override // com.apollographql.apollo3.api.Adapter
            public /* bridge */ /* synthetic */ void toJson(JsonWriter jsonWriter, CustomScalarAdapters customScalarAdapters, Boolean bool) throws IOException {
                toJson(jsonWriter, customScalarAdapters, bool.booleanValue());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.apollographql.apollo3.api.Adapter
            public Boolean fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                return Boolean.valueOf(reader.nextBoolean());
            }

            public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, boolean value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                writer.value(value);
            }
        };
        BooleanAdapter = adapter4;
        Adapter<Object> adapter5 = new Adapter<Object>() { // from class: com.apollographql.apollo3.api.Adapters$AnyAdapter$1
            public final Object fromJson(JsonReader reader) throws IOException {
                Intrinsics.checkNotNullParameter(reader, "reader");
                Object any = JsonReaders.readAny(reader);
                Intrinsics.checkNotNull(any);
                return any;
            }

            public final void toJson(JsonWriter writer, Object value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(value, "value");
                JsonWriters.writeAny(writer, value);
            }

            @Override // com.apollographql.apollo3.api.Adapter
            public Object fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                return fromJson(reader);
            }

            @Override // com.apollographql.apollo3.api.Adapter
            public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, Object value) {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                Intrinsics.checkNotNullParameter(value, "value");
                toJson(writer, value);
            }
        };
        AnyAdapter = adapter5;
        UploadAdapter = new Adapter<Upload>() { // from class: com.apollographql.apollo3.api.Adapters$UploadAdapter$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.apollographql.apollo3.api.Adapter
            public Upload fromJson(JsonReader reader, CustomScalarAdapters customScalarAdapters) {
                Intrinsics.checkNotNullParameter(reader, "reader");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                throw new IllegalStateException("File Upload used in output position".toString());
            }

            @Override // com.apollographql.apollo3.api.Adapter
            public void toJson(JsonWriter writer, CustomScalarAdapters customScalarAdapters, Upload value) throws IOException {
                Intrinsics.checkNotNullParameter(writer, "writer");
                Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
                Intrinsics.checkNotNullParameter(value, "value");
                writer.value(value);
            }
        };
        NullableStringAdapter = m11185nullable(adapter);
        NullableDoubleAdapter = m11185nullable(adapter3);
        NullableIntAdapter = m11185nullable(adapter2);
        NullableBooleanAdapter = m11185nullable(adapter4);
        NullableAnyAdapter = m11185nullable(adapter5);
        ApolloOptionalStringAdapter = new ApolloOptionalAdapter<>(adapter);
        ApolloOptionalDoubleAdapter = new ApolloOptionalAdapter<>(adapter3);
        ApolloOptionalIntAdapter = new ApolloOptionalAdapter<>(adapter2);
        ApolloOptionalBooleanAdapter = new ApolloOptionalAdapter<>(adapter4);
        ApolloOptionalAnyAdapter = new ApolloOptionalAdapter<>(adapter5);
    }

    /* JADX INFO: renamed from: -nullable, reason: not valid java name */
    public static final <T> NullableAdapter<T> m11185nullable(Adapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<this>");
        return new NullableAdapter<>(adapter);
    }

    /* JADX INFO: renamed from: -list, reason: not valid java name */
    public static final <T> ListAdapter<T> m11184list(Adapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<this>");
        return new ListAdapter<>(adapter);
    }

    /* JADX INFO: renamed from: -obj, reason: not valid java name */
    public static final <T> ObjectAdapter<T> m11186obj(Adapter<T> adapter, boolean z) {
        Intrinsics.checkNotNullParameter(adapter, "<this>");
        return new ObjectAdapter<>(adapter, z);
    }

    /* JADX INFO: renamed from: -obj$default, reason: not valid java name */
    public static /* synthetic */ ObjectAdapter m11187obj$default(Adapter adapter, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return m11186obj(adapter, z);
    }

    @Deprecated(message = "Use present instead", replaceWith = @ReplaceWith(expression = "present()", imports = {}))
    /* JADX INFO: renamed from: -optional, reason: not valid java name */
    public static final <T> PresentAdapter<T> m11188optional(Adapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<this>");
        return new PresentAdapter<>(adapter);
    }

    /* JADX INFO: renamed from: -present, reason: not valid java name */
    public static final <T> PresentAdapter<T> m11189present(Adapter<T> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "<this>");
        return new PresentAdapter<>(adapter);
    }

    /* JADX INFO: renamed from: -toJson$default, reason: not valid java name */
    public static /* synthetic */ String m11193toJson$default(Adapter adapter, Object obj, CustomScalarAdapters customScalarAdapters, String str, int i, Object obj2) {
        if ((i & 2) != 0) {
            customScalarAdapters = CustomScalarAdapters.Empty;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        return m11192toJson(adapter, obj, customScalarAdapters, str);
    }

    /* JADX INFO: renamed from: -toJson, reason: not valid java name */
    public static final <T> String m11192toJson(Adapter<T> adapter, T t, CustomScalarAdapters customScalarAdapters, String str) throws IOException {
        Intrinsics.checkNotNullParameter(adapter, "<this>");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        Buffer buffer = new Buffer();
        adapter.toJson(new BufferedSinkJsonWriter(buffer, str), customScalarAdapters, t);
        return buffer.readUtf8();
    }
}
