package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxMetadata;
import com.pspdfkit.internal.z40;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\fHÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lio/nutrient/data/models/Suggestion;", "", "text", "", "type", "agent", BoxMetadata.FIELD_TEMPLATE, "parameters", "Lio/nutrient/data/models/Parameters;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/nutrient/data/models/Parameters;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/nutrient/data/models/Parameters;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getText", "()Ljava/lang/String;", "getType", "getAgent", "getTemplate", "getParameters", "()Lio/nutrient/data/models/Parameters;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sdk_nutrient", "$serializer", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class Suggestion {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String agent;
    private final Parameters parameters;
    private final String template;
    private final String text;
    private final String type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/nutrient/data/models/Suggestion$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/nutrient/data/models/Suggestion;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Suggestion> serializer() {
            return Suggestion$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Suggestion(int i, String str, String str2, String str3, String str4, Parameters parameters, SerializationConstructorMarker serializationConstructorMarker) {
        if (23 != (i & 23)) {
            PluginExceptionsKt.throwMissingFieldException(i, 23, Suggestion$$serializer.INSTANCE.getDescriptor());
        }
        this.text = str;
        this.type = str2;
        this.agent = str3;
        if ((i & 8) == 0) {
            this.template = null;
        } else {
            this.template = str4;
        }
        this.parameters = parameters;
    }

    public static /* synthetic */ Suggestion copy$default(Suggestion suggestion, String str, String str2, String str3, String str4, Parameters parameters, int i, Object obj) {
        if ((i & 1) != 0) {
            str = suggestion.text;
        }
        if ((i & 2) != 0) {
            str2 = suggestion.type;
        }
        if ((i & 4) != 0) {
            str3 = suggestion.agent;
        }
        if ((i & 8) != 0) {
            str4 = suggestion.template;
        }
        if ((i & 16) != 0) {
            parameters = suggestion.parameters;
        }
        Parameters parameters2 = parameters;
        String str5 = str3;
        return suggestion.copy(str, str2, str5, str4, parameters2);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sdk_nutrient(Suggestion self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.text);
        output.encodeStringElement(serialDesc, 1, self.type);
        output.encodeStringElement(serialDesc, 2, self.agent);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.template != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.template);
        }
        output.encodeSerializableElement(serialDesc, 4, Parameters$$serializer.INSTANCE, self.parameters);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTemplate() {
        return this.template;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Parameters getParameters() {
        return this.parameters;
    }

    public final Suggestion copy(String text, String type, String agent, String template, Parameters parameters) {
        text.getClass();
        type.getClass();
        agent.getClass();
        parameters.getClass();
        return new Suggestion(text, type, agent, template, parameters);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Suggestion)) {
            return false;
        }
        Suggestion suggestion = (Suggestion) other;
        return Intrinsics.areEqual(this.text, suggestion.text) && Intrinsics.areEqual(this.type, suggestion.type) && Intrinsics.areEqual(this.agent, suggestion.agent) && Intrinsics.areEqual(this.template, suggestion.template) && Intrinsics.areEqual(this.parameters, suggestion.parameters);
    }

    public final String getAgent() {
        return this.agent;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final String getTemplate() {
        return this.template;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int iA = z40.a(this.agent, z40.a(this.type, this.text.hashCode() * 31, 31), 31);
        String str = this.template;
        return this.parameters.hashCode() + ((iA + (str == null ? 0 : str.hashCode())) * 31);
    }

    public String toString() {
        return "Suggestion(text=" + this.text + ", type=" + this.type + ", agent=" + this.agent + ", template=" + this.template + ", parameters=" + this.parameters + ")";
    }

    public Suggestion(String str, String str2, String str3, String str4, Parameters parameters) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        parameters.getClass();
        this.text = str;
        this.type = str2;
        this.agent = str3;
        this.template = str4;
        this.parameters = parameters;
    }

    public /* synthetic */ Suggestion(String str, String str2, String str3, String str4, Parameters parameters, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, parameters);
    }
}
