package com.box.android.data.api.models.error;

import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
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

/* JADX INFO: renamed from: com.box.android.data.api.models.error.GQLHttpErrorEnvelopeJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: GQLHttpErrorEnvelopeJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/api/models/error/GQLHttpErrorEnvelopeJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/error/GQLHttpErrorEnvelope;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "listOfGQLHttpErrorAdapter", "", "Lcom/box/android/data/api/models/error/GQLHttpError;", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<GQLHttpErrorEnvelope> {
    private volatile Constructor<GQLHttpErrorEnvelope> constructorRef;
    private final JsonAdapter<List<GQLHttpError>> listOfGQLHttpErrorAdapter;
    private final JsonReader.Options options;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of(BoxAnalyticsParams.CATEGORY_ERRORS);
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<List<GQLHttpError>> jsonAdapterAdapter = moshi.adapter(Types.newParameterizedType(List.class, GQLHttpError.class), SetsKt.emptySet(), BoxAnalyticsParams.CATEGORY_ERRORS);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.listOfGQLHttpErrorAdapter = jsonAdapterAdapter;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(42);
        sb.append("GeneratedJsonAdapter(GQLHttpErrorEnvelope)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public GQLHttpErrorEnvelope fromJson(JsonReader reader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        List<GQLHttpError> listFromJson = null;
        int i = -1;
        while (reader.hasNext()) {
            int iSelectName = reader.selectName(this.options);
            if (iSelectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (iSelectName == 0) {
                listFromJson = this.listOfGQLHttpErrorAdapter.fromJson(reader);
                if (listFromJson == null) {
                    JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull(BoxAnalyticsParams.CATEGORY_ERRORS, BoxAnalyticsParams.CATEGORY_ERRORS, reader);
                    Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                    throw jsonDataExceptionUnexpectedNull;
                }
                i = -2;
            } else {
                continue;
            }
        }
        reader.endObject();
        if (i == -2) {
            Intrinsics.checkNotNull(listFromJson, "null cannot be cast to non-null type kotlin.collections.List<com.box.android.data.api.models.error.GQLHttpError>");
            return new GQLHttpErrorEnvelope(listFromJson);
        }
        Constructor<GQLHttpErrorEnvelope> declaredConstructor = this.constructorRef;
        if (declaredConstructor == null) {
            declaredConstructor = GQLHttpErrorEnvelope.class.getDeclaredConstructor(List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = declaredConstructor;
            Intrinsics.checkNotNullExpressionValue(declaredConstructor, "also(...)");
        }
        GQLHttpErrorEnvelope gQLHttpErrorEnvelopeNewInstance = declaredConstructor.newInstance(listFromJson, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(gQLHttpErrorEnvelopeNewInstance, "newInstance(...)");
        return gQLHttpErrorEnvelopeNewInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, GQLHttpErrorEnvelope value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name(BoxAnalyticsParams.CATEGORY_ERRORS);
        this.listOfGQLHttpErrorAdapter.toJson(writer, value_.getErrors());
        writer.endObject();
    }
}
