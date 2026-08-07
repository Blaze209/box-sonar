package com.box.android.data.api.models.boxai;

import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.observability.DiagnosisParams;
import com.facebook.react.modules.dialog.AlertFragment;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
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

/* JADX INFO: renamed from: com.box.android.data.api.models.boxai.AiGetAnswerStreamingRequestDTOJsonAdapter, reason: from toString */
/* JADX INFO: compiled from: AiGetAnswerStreamingRequestDTOJsonAdapter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/android/data/api/models/boxai/AiGetAnswerStreamingRequestDTOJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/boxai/AiGetAnswerStreamingRequestDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "listOfItemIdDTOAdapter", "", "Lcom/box/android/data/api/models/items/mini/ItemIdDTO;", "nullableStringAdapter", "nullableAiIntelligenceConfigDTOAdapter", "Lcom/box/android/data/api/models/boxai/AiIntelligenceConfigDTO;", "aiAgentConfigDTOAdapter", "Lcom/box/android/data/api/models/boxai/AiAgentConfigDTO;", "constructorRef", "Ljava/lang/reflect/Constructor;", "toString", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeneratedJsonAdapter extends JsonAdapter<AiGetAnswerStreamingRequestDTO> {
    private final JsonAdapter<AiAgentConfigDTO> aiAgentConfigDTOAdapter;
    private volatile Constructor<AiGetAnswerStreamingRequestDTO> constructorRef;
    private final JsonAdapter<List<ItemIdDTO>> listOfItemIdDTOAdapter;
    private final JsonAdapter<AiIntelligenceConfigDTO> nullableAiIntelligenceConfigDTOAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public GeneratedJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options optionsOf = JsonReader.Options.of(DiagnosisParams.DIAGNOSIS_MODE, AlertFragment.ARG_ITEMS, AuthenticationConstants.AAD.QUERY_PROMPT, "item_session", "context_session", "config", "aiAgent");
        Intrinsics.checkNotNullExpressionValue(optionsOf, "of(...)");
        this.options = optionsOf;
        JsonAdapter<String> jsonAdapterAdapter = moshi.adapter(String.class, SetsKt.emptySet(), DiagnosisParams.DIAGNOSIS_MODE);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        this.stringAdapter = jsonAdapterAdapter;
        JsonAdapter<List<ItemIdDTO>> jsonAdapterAdapter2 = moshi.adapter(Types.newParameterizedType(List.class, ItemIdDTO.class), SetsKt.emptySet(), AlertFragment.ARG_ITEMS);
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter2, "adapter(...)");
        this.listOfItemIdDTOAdapter = jsonAdapterAdapter2;
        JsonAdapter<String> jsonAdapterAdapter3 = moshi.adapter(String.class, SetsKt.emptySet(), "itemSession");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter3, "adapter(...)");
        this.nullableStringAdapter = jsonAdapterAdapter3;
        JsonAdapter<AiIntelligenceConfigDTO> jsonAdapterAdapter4 = moshi.adapter(AiIntelligenceConfigDTO.class, SetsKt.emptySet(), "aiIntelligenceConfig");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter4, "adapter(...)");
        this.nullableAiIntelligenceConfigDTOAdapter = jsonAdapterAdapter4;
        JsonAdapter<AiAgentConfigDTO> jsonAdapterAdapter5 = moshi.adapter(AiAgentConfigDTO.class, SetsKt.emptySet(), "aiAgentConfig");
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter5, "adapter(...)");
        this.aiAgentConfigDTOAdapter = jsonAdapterAdapter5;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(52);
        sb.append("GeneratedJsonAdapter(AiGetAnswerStreamingRequestDTO)");
        return sb.toString();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public AiGetAnswerStreamingRequestDTO fromJson(JsonReader reader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, IOException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        int i = -1;
        String strFromJson = null;
        List<ItemIdDTO> listFromJson = null;
        String strFromJson2 = null;
        String strFromJson3 = null;
        String strFromJson4 = null;
        AiIntelligenceConfigDTO aiIntelligenceConfigDTOFromJson = null;
        AiAgentConfigDTO aiAgentConfigDTOFromJson = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    strFromJson = this.stringAdapter.fromJson(reader);
                    if (strFromJson == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull = Util.unexpectedNull(DiagnosisParams.DIAGNOSIS_MODE, DiagnosisParams.DIAGNOSIS_MODE, reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull;
                    }
                    break;
                    break;
                case 1:
                    listFromJson = this.listOfItemIdDTOAdapter.fromJson(reader);
                    if (listFromJson == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull2 = Util.unexpectedNull(AlertFragment.ARG_ITEMS, AlertFragment.ARG_ITEMS, reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull2, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull2;
                    }
                    break;
                    break;
                case 2:
                    strFromJson2 = this.stringAdapter.fromJson(reader);
                    if (strFromJson2 == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull3 = Util.unexpectedNull(AuthenticationConstants.AAD.QUERY_PROMPT, AuthenticationConstants.AAD.QUERY_PROMPT, reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull3, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull3;
                    }
                    break;
                    break;
                case 3:
                    strFromJson3 = this.nullableStringAdapter.fromJson(reader);
                    i &= -9;
                    break;
                case 4:
                    strFromJson4 = this.nullableStringAdapter.fromJson(reader);
                    i &= -17;
                    break;
                case 5:
                    aiIntelligenceConfigDTOFromJson = this.nullableAiIntelligenceConfigDTOAdapter.fromJson(reader);
                    i &= -33;
                    break;
                case 6:
                    aiAgentConfigDTOFromJson = this.aiAgentConfigDTOAdapter.fromJson(reader);
                    if (aiAgentConfigDTOFromJson == null) {
                        JsonDataException jsonDataExceptionUnexpectedNull4 = Util.unexpectedNull("aiAgentConfig", "aiAgent", reader);
                        Intrinsics.checkNotNullExpressionValue(jsonDataExceptionUnexpectedNull4, "unexpectedNull(...)");
                        throw jsonDataExceptionUnexpectedNull4;
                    }
                    break;
                    break;
            }
        }
        reader.endObject();
        if (i == -57) {
            if (strFromJson == null) {
                JsonDataException jsonDataExceptionMissingProperty = Util.missingProperty(DiagnosisParams.DIAGNOSIS_MODE, DiagnosisParams.DIAGNOSIS_MODE, reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty, "missingProperty(...)");
                throw jsonDataExceptionMissingProperty;
            }
            if (listFromJson == null) {
                JsonDataException jsonDataExceptionMissingProperty2 = Util.missingProperty(AlertFragment.ARG_ITEMS, AlertFragment.ARG_ITEMS, reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty2, "missingProperty(...)");
                throw jsonDataExceptionMissingProperty2;
            }
            if (strFromJson2 == null) {
                JsonDataException jsonDataExceptionMissingProperty3 = Util.missingProperty(AuthenticationConstants.AAD.QUERY_PROMPT, AuthenticationConstants.AAD.QUERY_PROMPT, reader);
                Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty3, "missingProperty(...)");
                throw jsonDataExceptionMissingProperty3;
            }
            if (aiAgentConfigDTOFromJson != null) {
                AiAgentConfigDTO aiAgentConfigDTO = aiAgentConfigDTOFromJson;
                AiIntelligenceConfigDTO aiIntelligenceConfigDTO = aiIntelligenceConfigDTOFromJson;
                String str = strFromJson4;
                return new AiGetAnswerStreamingRequestDTO(strFromJson, listFromJson, strFromJson2, strFromJson3, str, aiIntelligenceConfigDTO, aiAgentConfigDTO);
            }
            JsonDataException jsonDataExceptionMissingProperty4 = Util.missingProperty("aiAgentConfig", "aiAgent", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty4, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty4;
        }
        int i2 = i;
        Constructor<AiGetAnswerStreamingRequestDTO> declaredConstructor = this.constructorRef;
        if (declaredConstructor == null) {
            declaredConstructor = AiGetAnswerStreamingRequestDTO.class.getDeclaredConstructor(String.class, List.class, String.class, String.class, String.class, AiIntelligenceConfigDTO.class, AiAgentConfigDTO.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = declaredConstructor;
            Intrinsics.checkNotNullExpressionValue(declaredConstructor, "also(...)");
        }
        if (strFromJson == 0) {
            JsonDataException jsonDataExceptionMissingProperty5 = Util.missingProperty(DiagnosisParams.DIAGNOSIS_MODE, DiagnosisParams.DIAGNOSIS_MODE, reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty5, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty5;
        }
        if (listFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty6 = Util.missingProperty(AlertFragment.ARG_ITEMS, AlertFragment.ARG_ITEMS, reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty6, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty6;
        }
        if (strFromJson2 == null) {
            JsonDataException jsonDataExceptionMissingProperty7 = Util.missingProperty(AuthenticationConstants.AAD.QUERY_PROMPT, AuthenticationConstants.AAD.QUERY_PROMPT, reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty7, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty7;
        }
        if (aiAgentConfigDTOFromJson == null) {
            JsonDataException jsonDataExceptionMissingProperty8 = Util.missingProperty("aiAgentConfig", "aiAgent", reader);
            Intrinsics.checkNotNullExpressionValue(jsonDataExceptionMissingProperty8, "missingProperty(...)");
            throw jsonDataExceptionMissingProperty8;
        }
        AiGetAnswerStreamingRequestDTO aiGetAnswerStreamingRequestDTONewInstance = declaredConstructor.newInstance(strFromJson, listFromJson, strFromJson2, strFromJson3, strFromJson4, aiIntelligenceConfigDTOFromJson, aiAgentConfigDTOFromJson, Integer.valueOf(i2), null);
        Intrinsics.checkNotNullExpressionValue(aiGetAnswerStreamingRequestDTONewInstance, "newInstance(...)");
        return aiGetAnswerStreamingRequestDTONewInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, AiGetAnswerStreamingRequestDTO value_) throws IOException {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name(DiagnosisParams.DIAGNOSIS_MODE);
        this.stringAdapter.toJson(writer, value_.getMode());
        writer.name(AlertFragment.ARG_ITEMS);
        this.listOfItemIdDTOAdapter.toJson(writer, value_.getItems());
        writer.name(AuthenticationConstants.AAD.QUERY_PROMPT);
        this.stringAdapter.toJson(writer, value_.getPrompt());
        writer.name("item_session");
        this.nullableStringAdapter.toJson(writer, value_.getItemSession());
        writer.name("context_session");
        this.nullableStringAdapter.toJson(writer, value_.getContextSession());
        writer.name("config");
        this.nullableAiIntelligenceConfigDTOAdapter.toJson(writer, value_.getAiIntelligenceConfig());
        writer.name("aiAgent");
        this.aiAgentConfigDTOAdapter.toJson(writer, value_.getAiAgentConfig());
        writer.endObject();
    }
}
