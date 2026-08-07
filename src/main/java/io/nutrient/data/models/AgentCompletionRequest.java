package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdProviderConfiguration;
import com.pspdfkit.internal.lv;
import com.pspdfkit.internal.z40;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000223BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rB]\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0001¢\u0006\u0002\b1R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014¨\u00064"}, d2 = {"Lio/nutrient/data/models/AgentCompletionRequest;", "", "requestId", "", OpenIdProviderConfiguration.SerializedNames.ISSUER, "documents", "", "Lio/nutrient/data/models/Document;", "parameters", "Lio/nutrient/data/models/AgentCompletionRequestParameters;", "chatId", "agent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lio/nutrient/data/models/AgentCompletionRequestParameters;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lio/nutrient/data/models/AgentCompletionRequestParameters;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRequestId", "()Ljava/lang/String;", "getIssuer", "getDocuments", "()Ljava/util/List;", "getParameters", "()Lio/nutrient/data/models/AgentCompletionRequestParameters;", "getChatId", "getAgent", "toJsonObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sdk_nutrient", "$serializer", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class AgentCompletionRequest {
    private final String agent;
    private final String chatId;
    private final List<Document> documents;
    private final String issuer;
    private final AgentCompletionRequestParameters parameters;
    private final String requestId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.nutrient.data.models.AgentCompletionRequest$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AgentCompletionRequest._childSerializers$_anonymous_();
        }
    }), null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/nutrient/data/models/AgentCompletionRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/nutrient/data/models/AgentCompletionRequest;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<AgentCompletionRequest> serializer() {
            return AgentCompletionRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AgentCompletionRequest(int i, String str, String str2, List list, AgentCompletionRequestParameters agentCompletionRequestParameters, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, AgentCompletionRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.requestId = str;
        this.issuer = str2;
        this.documents = list;
        this.parameters = agentCompletionRequestParameters;
        this.chatId = str3;
        if ((i & 32) == 0) {
            this.agent = null;
        } else {
            this.agent = str4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(Document$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AgentCompletionRequest copy$default(AgentCompletionRequest agentCompletionRequest, String str, String str2, List list, AgentCompletionRequestParameters agentCompletionRequestParameters, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = agentCompletionRequest.requestId;
        }
        if ((i & 2) != 0) {
            str2 = agentCompletionRequest.issuer;
        }
        if ((i & 4) != 0) {
            list = agentCompletionRequest.documents;
        }
        if ((i & 8) != 0) {
            agentCompletionRequestParameters = agentCompletionRequest.parameters;
        }
        if ((i & 16) != 0) {
            str3 = agentCompletionRequest.chatId;
        }
        if ((i & 32) != 0) {
            str4 = agentCompletionRequest.agent;
        }
        String str5 = str3;
        String str6 = str4;
        return agentCompletionRequest.copy(str, str2, list, agentCompletionRequestParameters, str5, str6);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sdk_nutrient(AgentCompletionRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.requestId);
        output.encodeStringElement(serialDesc, 1, self.issuer);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.documents);
        output.encodeSerializableElement(serialDesc, 3, AgentCompletionRequestParameters$$serializer.INSTANCE, self.parameters);
        output.encodeStringElement(serialDesc, 4, self.chatId);
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.agent == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.agent);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getIssuer() {
        return this.issuer;
    }

    public final List<Document> component3() {
        return this.documents;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final AgentCompletionRequestParameters getParameters() {
        return this.parameters;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getChatId() {
        return this.chatId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getAgent() {
        return this.agent;
    }

    public final AgentCompletionRequest copy(String requestId, String issuer, List<Document> documents, AgentCompletionRequestParameters parameters, String chatId, String agent) {
        requestId.getClass();
        issuer.getClass();
        documents.getClass();
        parameters.getClass();
        chatId.getClass();
        return new AgentCompletionRequest(requestId, issuer, documents, parameters, chatId, agent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentCompletionRequest)) {
            return false;
        }
        AgentCompletionRequest agentCompletionRequest = (AgentCompletionRequest) other;
        return Intrinsics.areEqual(this.requestId, agentCompletionRequest.requestId) && Intrinsics.areEqual(this.issuer, agentCompletionRequest.issuer) && Intrinsics.areEqual(this.documents, agentCompletionRequest.documents) && Intrinsics.areEqual(this.parameters, agentCompletionRequest.parameters) && Intrinsics.areEqual(this.chatId, agentCompletionRequest.chatId) && Intrinsics.areEqual(this.agent, agentCompletionRequest.agent);
    }

    public final String getAgent() {
        return this.agent;
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final List<Document> getDocuments() {
        return this.documents;
    }

    public final String getIssuer() {
        return this.issuer;
    }

    public final AgentCompletionRequestParameters getParameters() {
        return this.parameters;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public int hashCode() {
        int iA = z40.a(this.chatId, (this.parameters.hashCode() + lv.a(this.documents, z40.a(this.issuer, this.requestId.hashCode() * 31, 31), 31)) * 31, 31);
        String str = this.agent;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public final JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestId", this.requestId);
        jSONObject.put(OpenIdProviderConfiguration.SerializedNames.ISSUER, this.issuer);
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = this.documents.iterator();
        while (it.hasNext()) {
            jSONArray.put(((Document) it.next()).toJsonObject());
        }
        Unit unit = Unit.INSTANCE;
        jSONObject.put("documents", jSONArray);
        jSONObject.put("parameters", this.parameters.toJsonObject());
        jSONObject.put("chatId", this.chatId);
        String str = this.agent;
        if (str != null) {
            jSONObject.put("agent", str);
        }
        return jSONObject;
    }

    public String toString() {
        return "AgentCompletionRequest(requestId=" + this.requestId + ", issuer=" + this.issuer + ", documents=" + this.documents + ", parameters=" + this.parameters + ", chatId=" + this.chatId + ", agent=" + this.agent + ")";
    }

    public AgentCompletionRequest(String str, String str2, List<Document> list, AgentCompletionRequestParameters agentCompletionRequestParameters, String str3, String str4) {
        str.getClass();
        str2.getClass();
        list.getClass();
        agentCompletionRequestParameters.getClass();
        str3.getClass();
        this.requestId = str;
        this.issuer = str2;
        this.documents = list;
        this.parameters = agentCompletionRequestParameters;
        this.chatId = str3;
        this.agent = str4;
    }

    public /* synthetic */ AgentCompletionRequest(String str, String str2, List list, AgentCompletionRequestParameters agentCompletionRequestParameters, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, list, agentCompletionRequestParameters, str3, (i & 32) != 0 ? null : str4);
    }
}
