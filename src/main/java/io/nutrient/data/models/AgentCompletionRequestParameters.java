package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"Lio/nutrient/data/models/AgentCompletionRequestParameters;", "", "input", "", "context", "Lio/nutrient/data/models/Context;", "<init>", "(Ljava/lang/String;Lio/nutrient/data/models/Context;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lio/nutrient/data/models/Context;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInput", "()Ljava/lang/String;", "getContext", "()Lio/nutrient/data/models/Context;", "toJsonObject", "Lorg/json/JSONObject;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sdk_nutrient", "$serializer", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class AgentCompletionRequestParameters {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final String input;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/nutrient/data/models/AgentCompletionRequestParameters$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/nutrient/data/models/AgentCompletionRequestParameters;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AgentCompletionRequestParameters> serializer() {
            return AgentCompletionRequestParameters$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AgentCompletionRequestParameters(int i, String str, Context context, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (i & 2)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2, AgentCompletionRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.input = null;
        } else {
            this.input = str;
        }
        this.context = context;
    }

    public static /* synthetic */ AgentCompletionRequestParameters copy$default(AgentCompletionRequestParameters agentCompletionRequestParameters, String str, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            str = agentCompletionRequestParameters.input;
        }
        if ((i & 2) != 0) {
            context = agentCompletionRequestParameters.context;
        }
        return agentCompletionRequestParameters.copy(str, context);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sdk_nutrient(AgentCompletionRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.input != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.input);
        }
        output.encodeSerializableElement(serialDesc, 1, Context$$serializer.INSTANCE, self.context);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getInput() {
        return this.input;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final AgentCompletionRequestParameters copy(String input, Context context) {
        context.getClass();
        return new AgentCompletionRequestParameters(input, context);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentCompletionRequestParameters)) {
            return false;
        }
        AgentCompletionRequestParameters agentCompletionRequestParameters = (AgentCompletionRequestParameters) other;
        return Intrinsics.areEqual(this.input, agentCompletionRequestParameters.input) && Intrinsics.areEqual(this.context, agentCompletionRequestParameters.context);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getInput() {
        return this.input;
    }

    public int hashCode() {
        String str = this.input;
        return this.context.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
    }

    public final JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("context", this.context.toJsonObject());
        String str = this.input;
        if (str != null) {
            jSONObject.put("input", str);
        }
        return jSONObject;
    }

    public String toString() {
        return "AgentCompletionRequestParameters(input=" + this.input + ", context=" + this.context + ")";
    }

    public AgentCompletionRequestParameters(String str, Context context) {
        context.getClass();
        this.input = str;
        this.context = context;
    }

    public /* synthetic */ AgentCompletionRequestParameters(String str, Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, context);
    }
}
