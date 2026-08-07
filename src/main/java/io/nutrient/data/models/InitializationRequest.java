package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.pspdfkit.internal.z40;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tBI\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u0006\u0010\u0016\u001a\u00020\u0017J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003¢\u0006\u0002\u0010\u0014J@\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006-"}, d2 = {"Lio/nutrient/data/models/InitializationRequest;", "", "requestId", "", OAuthActivity.USER_ID, "sessionId", "clientFeatures", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRequestId", "()Ljava/lang/String;", "getUserId", "getSessionId", "getClientFeatures", "()[Ljava/lang/String;", "[Ljava/lang/String;", "toJsonObject", "Lorg/json/JSONObject;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Lio/nutrient/data/models/InitializationRequest;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sdk_nutrient", "$serializer", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class InitializationRequest {
    private final String[] clientFeatures;
    private final String requestId;
    private final String sessionId;
    private final String userId;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: io.nutrient.data.models.InitializationRequest$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return InitializationRequest._childSerializers$_anonymous_();
        }
    })};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/nutrient/data/models/InitializationRequest$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/nutrient/data/models/InitializationRequest;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<InitializationRequest> serializer() {
            return InitializationRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ InitializationRequest(int i, String str, String str2, String str3, String[] strArr, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, InitializationRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.requestId = str;
        this.userId = str2;
        this.sessionId = str3;
        this.clientFeatures = strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), StringSerializer.INSTANCE);
    }

    public static /* synthetic */ InitializationRequest copy$default(InitializationRequest initializationRequest, String str, String str2, String str3, String[] strArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = initializationRequest.requestId;
        }
        if ((i & 2) != 0) {
            str2 = initializationRequest.userId;
        }
        if ((i & 4) != 0) {
            str3 = initializationRequest.sessionId;
        }
        if ((i & 8) != 0) {
            strArr = initializationRequest.clientFeatures;
        }
        return initializationRequest.copy(str, str2, str3, strArr);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sdk_nutrient(InitializationRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.requestId);
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.userId);
        output.encodeStringElement(serialDesc, 2, self.sessionId);
        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.clientFeatures);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String[] getClientFeatures() {
        return this.clientFeatures;
    }

    public final InitializationRequest copy(String requestId, String userId, String sessionId, String[] clientFeatures) {
        sessionId.getClass();
        clientFeatures.getClass();
        return new InitializationRequest(requestId, userId, sessionId, clientFeatures);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitializationRequest)) {
            return false;
        }
        InitializationRequest initializationRequest = (InitializationRequest) other;
        return Intrinsics.areEqual(this.requestId, initializationRequest.requestId) && Intrinsics.areEqual(this.userId, initializationRequest.userId) && Intrinsics.areEqual(this.sessionId, initializationRequest.sessionId) && Intrinsics.areEqual(this.clientFeatures, initializationRequest.clientFeatures);
    }

    public final String[] getClientFeatures() {
        return this.clientFeatures;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.requestId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userId;
        return z40.a(this.sessionId, (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31, 31) + Arrays.hashCode(this.clientFeatures);
    }

    public final JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("requestId", this.requestId);
        String str = this.userId;
        if (str != null) {
            jSONObject.put(OAuthActivity.USER_ID, str);
        }
        jSONObject.put("sessionId", this.sessionId);
        jSONObject.put("clientFeatures", this.clientFeatures);
        return jSONObject;
    }

    public String toString() {
        return "InitializationRequest(requestId=" + this.requestId + ", userId=" + this.userId + ", sessionId=" + this.sessionId + ", clientFeatures=" + Arrays.toString(this.clientFeatures) + ")";
    }

    public InitializationRequest(String str, String str2, String str3, String[] strArr) {
        str3.getClass();
        strArr.getClass();
        this.requestId = str;
        this.userId = str2;
        this.sessionId = str3;
        this.clientFeatures = strArr;
    }
}
