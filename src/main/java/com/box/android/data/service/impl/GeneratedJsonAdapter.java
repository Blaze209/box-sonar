package com.box.android.data.service.impl;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.box.android.data.service.impl.ForceUpdateConfigSynchronizer_ForceUpdateConfigJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: ForceUpdateConfigSynchronizer_ForceUpdateConfigJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/service/impl/ForceUpdateConfigSynchronizer_ForceUpdateConfigJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/service/impl/ForceUpdateConfigSynchronizer$ForceUpdateConfig;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "nullableStringAdapter", "", "nullableListOfStringAdapter", "", "nullableBooleanAdapter", "", "nullableIntAdapter", "", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<ForceUpdateConfigSynchronizer.ForceUpdateConfig> {
    private volatile Constructor<ForceUpdateConfigSynchronizer.ForceUpdateConfig> constructorRef;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<List<String>> nullableListOfStringAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of("min_supported_version", "unsupported_versions", "gql_validation_enabled", "gql_validation_start_after_months");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<String> jsonAdapterAdapter = moshi.adapter(String.class, SetsKt.emptySet(), "minSupportedVersion");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.nullableStringAdapter = jsonAdapterAdapter;
        JsonAdapter<List<String>> jsonAdapterAdapter2 = moshi.adapter(Types.newParameterizedType(List.class, String.class), SetsKt.emptySet(), "unsupportedVersions");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.nullableListOfStringAdapter = jsonAdapterAdapter2;
        JsonAdapter<Boolean> jsonAdapterAdapter3 = moshi.adapter(Boolean.class, SetsKt.emptySet(), "gqlValidationEnabled");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.nullableBooleanAdapter = jsonAdapterAdapter3;
        JsonAdapter<Integer> jsonAdapterAdapter4 = moshi.adapter(Integer.class, SetsKt.emptySet(), "gqlValidationStartAfterMonths");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter4, "adapter(...)");
        this.nullableIntAdapter = jsonAdapterAdapter4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(69);
        sb.append("GeneratedJsonAdapter(ForceUpdateConfigSynchronizer.ForceUpdateConfig)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ForceUpdateConfigSynchronizer.ForceUpdateConfig fromJson(JsonReader reader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        String strFromJson = null;
        List<String> listFromJson = null;
        Boolean boolFromJson = null;
        Integer numFromJson = null;
        int i = -1;
        while (reader.hasNext()) {
            int iSelectName = reader.selectName(this.options);
            if (iSelectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (iSelectName == 0) {
                strFromJson = this.nullableStringAdapter.fromJson(reader);
                i &= -2;
            } else if (iSelectName == 1) {
                listFromJson = this.nullableListOfStringAdapter.fromJson(reader);
                i &= -3;
            } else if (iSelectName == 2) {
                boolFromJson = this.nullableBooleanAdapter.fromJson(reader);
                i &= -5;
            } else if (iSelectName == 3) {
                numFromJson = this.nullableIntAdapter.fromJson(reader);
                i &= -9;
            }
        }
        reader.endObject();
        if (i == -16) {
            return new ForceUpdateConfigSynchronizer.ForceUpdateConfig(strFromJson, listFromJson, boolFromJson, numFromJson);
        }
        Constructor<ForceUpdateConfigSynchronizer.ForceUpdateConfig> declaredConstructor = this.constructorRef;
        if (declaredConstructor == null) {
            declaredConstructor = ForceUpdateConfigSynchronizer.ForceUpdateConfig.class.getDeclaredConstructor(String.class, List.class, Boolean.class, Integer.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = declaredConstructor;
            Intrinsics.checkNotNullExpressionValue(declaredConstructor, "also(...)");
        }
        ForceUpdateConfigSynchronizer.ForceUpdateConfig forceUpdateConfigNewInstance = declaredConstructor.newInstance(strFromJson, listFromJson, boolFromJson, numFromJson, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(forceUpdateConfigNewInstance, "newInstance(...)");
        return forceUpdateConfigNewInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ForceUpdateConfigSynchronizer.ForceUpdateConfig value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("min_supported_version");
        this.nullableStringAdapter.toJson(writer, value_.getMinSupportedVersion());
        writer.name("unsupported_versions");
        this.nullableListOfStringAdapter.toJson(writer, value_.getUnsupportedVersions());
        writer.name("gql_validation_enabled");
        this.nullableBooleanAdapter.toJson(writer, value_.getGqlValidationEnabled());
        writer.name("gql_validation_start_after_months");
        this.nullableIntAdapter.toJson(writer, value_.getGqlValidationStartAfterMonths());
        writer.endObject();
    }
}
