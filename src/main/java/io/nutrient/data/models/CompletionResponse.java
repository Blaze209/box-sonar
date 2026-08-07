package io.nutrient.data.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pspdfkit.internal.lv;
import com.pspdfkit.internal.mv;
import com.pspdfkit.internal.nd;
import com.pspdfkit.internal.z40;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 J2\u00020\u0001:\u0002IJB\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018B\u0095\u0001\b\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u0017\u0010\u001cJ\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\u0011\u00108\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006HÆ\u0003J\t\u0010;\u001a\u00020\u0016HÆ\u0003J\u008f\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001J\u0014\u0010=\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010?\u001a\u00020\u000bHÖ\u0081\u0004J\n\u0010@\u001a\u00020\u0003HÖ\u0081\u0004J%\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010/\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b0\u0010\u001e¨\u0006K"}, d2 = {"Lio/nutrient/data/models/CompletionResponse;", "", "requestId", "", "sender", "documents", "", "Lio/nutrient/data/models/Document;", "timestamp", "", FirebaseAnalytics.Param.INDEX, "", "content", "end", "", "suggestions", "Lio/nutrient/data/models/Suggestion;", "additionalContext", "Lio/nutrient/data/models/AdditionalContext;", "links", "Lio/nutrient/data/models/Link;", "state", "Lio/nutrient/data/models/AiAssistantEvents;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;JILjava/lang/String;ZLjava/util/List;Lio/nutrient/data/models/AdditionalContext;Ljava/util/List;Lio/nutrient/data/models/AiAssistantEvents;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;JILjava/lang/String;ZLjava/util/List;Lio/nutrient/data/models/AdditionalContext;Ljava/util/List;Lio/nutrient/data/models/AiAssistantEvents;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRequestId", "()Ljava/lang/String;", "getSender", "getDocuments", "()Ljava/util/List;", "getTimestamp", "()J", "getIndex", "()I", "getContent", "getEnd", "()Z", "getSuggestions", "getAdditionalContext", "()Lio/nutrient/data/models/AdditionalContext;", "getLinks", "getState", "()Lio/nutrient/data/models/AiAssistantEvents;", "quotedContext", "getQuotedContext", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sdk_nutrient", "$serializer", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
@Serializable
public final /* data */ class CompletionResponse {
    private static final Lazy<KSerializer<Object>>[] $childSerializers;
    private final AdditionalContext additionalContext;
    private final String content;
    private final List<Document> documents;
    private final boolean end;
    private final int index;
    private final List<Link> links;
    private final String requestId;
    private final String sender;
    private final AiAssistantEvents state;
    private final List<Suggestion> suggestions;
    private final long timestamp;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lio/nutrient/data/models/CompletionResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/nutrient/data/models/CompletionResponse;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<CompletionResponse> serializer() {
            return CompletionResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        $childSerializers = new Lazy[]{null, null, LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.nutrient.data.models.CompletionResponse$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CompletionResponse._childSerializers$_anonymous_();
            }
        }), null, null, null, null, LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.nutrient.data.models.CompletionResponse$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CompletionResponse._childSerializers$_anonymous_$0();
            }
        }), null, LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.nutrient.data.models.CompletionResponse$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CompletionResponse._childSerializers$_anonymous_$1();
            }
        }), LazyKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: io.nutrient.data.models.CompletionResponse$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CompletionResponse._childSerializers$_anonymous_$2();
            }
        })};
    }

    public CompletionResponse() {
        this((String) null, (String) null, (List) null, 0L, 0, (String) null, false, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) null, 2047, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(Document$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(Suggestion$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(Link$$serializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return AiAssistantEvents.INSTANCE.serializer();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CompletionResponse copy$default(CompletionResponse completionResponse, String str, String str2, List list, long j, int i, String str3, boolean z, List list2, AdditionalContext additionalContext, List list3, AiAssistantEvents aiAssistantEvents, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = completionResponse.requestId;
        }
        if ((i2 & 2) != 0) {
            str2 = completionResponse.sender;
        }
        if ((i2 & 4) != 0) {
            list = completionResponse.documents;
        }
        if ((i2 & 8) != 0) {
            j = completionResponse.timestamp;
        }
        if ((i2 & 16) != 0) {
            i = completionResponse.index;
        }
        if ((i2 & 32) != 0) {
            str3 = completionResponse.content;
        }
        if ((i2 & 64) != 0) {
            z = completionResponse.end;
        }
        if ((i2 & 128) != 0) {
            list2 = completionResponse.suggestions;
        }
        if ((i2 & 256) != 0) {
            additionalContext = completionResponse.additionalContext;
        }
        if ((i2 & 512) != 0) {
            list3 = completionResponse.links;
        }
        if ((i2 & 1024) != 0) {
            aiAssistantEvents = completionResponse.state;
        }
        List list4 = list3;
        AiAssistantEvents aiAssistantEvents2 = aiAssistantEvents;
        AdditionalContext additionalContext2 = additionalContext;
        boolean z2 = z;
        int i3 = i;
        long j2 = j;
        List list5 = list;
        return completionResponse.copy(str, str2, list5, j2, i3, str3, z2, list2, additionalContext2, list4, aiAssistantEvents2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001d  */
    @JvmStatic
    public static final /* synthetic */ void write$Self$sdk_nutrient(CompletionResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0)) {
            output.encodeStringElement(serialDesc, 0, self.requestId);
        } else {
            String str = self.requestId;
            String string = UUID.randomUUID().toString();
            string.getClass();
            if (!Intrinsics.areEqual(str, string)) {
                output.encodeStringElement(serialDesc, 0, self.requestId);
            }
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.sender, "")) {
            output.encodeStringElement(serialDesc, 1, self.sender);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.documents, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.documents);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.timestamp != 0) {
            output.encodeLongElement(serialDesc, 3, self.timestamp);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.index != 0) {
            output.encodeIntElement(serialDesc, 4, self.index);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.content != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !self.end) {
            output.encodeBooleanElement(serialDesc, 6, self.end);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.suggestions != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.suggestions);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.additionalContext != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, AdditionalContext$$serializer.INSTANCE, self.additionalContext);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.links, CollectionsKt.emptyList())) {
            output.encodeSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.links);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 10) && Intrinsics.areEqual(self.state, AiAssistantEvents.Loading.INSTANCE)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.state);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    public final List<Link> component10() {
        return this.links;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final AiAssistantEvents getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSender() {
        return this.sender;
    }

    public final List<Document> component3() {
        return this.documents;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getEnd() {
        return this.end;
    }

    public final List<Suggestion> component8() {
        return this.suggestions;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final AdditionalContext getAdditionalContext() {
        return this.additionalContext;
    }

    public final CompletionResponse copy(String requestId, String sender, List<Document> documents, long timestamp, int index, String content, boolean end, List<Suggestion> suggestions, AdditionalContext additionalContext, List<Link> links, AiAssistantEvents state) {
        requestId.getClass();
        sender.getClass();
        documents.getClass();
        links.getClass();
        state.getClass();
        return new CompletionResponse(requestId, sender, documents, timestamp, index, content, end, suggestions, additionalContext, links, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompletionResponse)) {
            return false;
        }
        CompletionResponse completionResponse = (CompletionResponse) other;
        return Intrinsics.areEqual(this.requestId, completionResponse.requestId) && Intrinsics.areEqual(this.sender, completionResponse.sender) && Intrinsics.areEqual(this.documents, completionResponse.documents) && this.timestamp == completionResponse.timestamp && this.index == completionResponse.index && Intrinsics.areEqual(this.content, completionResponse.content) && this.end == completionResponse.end && Intrinsics.areEqual(this.suggestions, completionResponse.suggestions) && Intrinsics.areEqual(this.additionalContext, completionResponse.additionalContext) && Intrinsics.areEqual(this.links, completionResponse.links) && Intrinsics.areEqual(this.state, completionResponse.state);
    }

    public final AdditionalContext getAdditionalContext() {
        return this.additionalContext;
    }

    public final String getContent() {
        return this.content;
    }

    public final List<Document> getDocuments() {
        return this.documents;
    }

    public final boolean getEnd() {
        return this.end;
    }

    public final int getIndex() {
        return this.index;
    }

    public final List<Link> getLinks() {
        return this.links;
    }

    public final String getQuotedContext() {
        AdditionalContext additionalContext = this.additionalContext;
        if (additionalContext == null || this.suggestions == null) {
            return null;
        }
        return additionalContext.getText();
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getSender() {
        return this.sender;
    }

    public final AiAssistantEvents getState() {
        return this.state;
    }

    public final List<Suggestion> getSuggestions() {
        return this.suggestions;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iA = nd.a(this.index, (Long.hashCode(this.timestamp) + lv.a(this.documents, z40.a(this.sender, this.requestId.hashCode() * 31, 31), 31)) * 31, 31);
        String str = this.content;
        int iA2 = mv.a(this.end, (iA + (str == null ? 0 : str.hashCode())) * 31, 31);
        List<Suggestion> list = this.suggestions;
        int iHashCode = (iA2 + (list == null ? 0 : list.hashCode())) * 31;
        AdditionalContext additionalContext = this.additionalContext;
        return this.state.hashCode() + lv.a(this.links, (iHashCode + (additionalContext != null ? additionalContext.hashCode() : 0)) * 31, 31);
    }

    public String toString() {
        return "CompletionResponse(requestId=" + this.requestId + ", sender=" + this.sender + ", documents=" + this.documents + ", timestamp=" + this.timestamp + ", index=" + this.index + ", content=" + this.content + ", end=" + this.end + ", suggestions=" + this.suggestions + ", additionalContext=" + this.additionalContext + ", links=" + this.links + ", state=" + this.state + ")";
    }

    public /* synthetic */ CompletionResponse(int i, String str, String str2, List list, long j, int i2, String str3, boolean z, List list2, AdditionalContext additionalContext, List list3, AiAssistantEvents aiAssistantEvents, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            str = UUID.randomUUID().toString();
            str.getClass();
        }
        this.requestId = str;
        if ((i & 2) == 0) {
            this.sender = "";
        } else {
            this.sender = str2;
        }
        if ((i & 4) == 0) {
            this.documents = CollectionsKt.emptyList();
        } else {
            this.documents = list;
        }
        if ((i & 8) == 0) {
            this.timestamp = 0L;
        } else {
            this.timestamp = j;
        }
        if ((i & 16) == 0) {
            this.index = 0;
        } else {
            this.index = i2;
        }
        if ((i & 32) == 0) {
            this.content = null;
        } else {
            this.content = str3;
        }
        if ((i & 64) == 0) {
            this.end = true;
        } else {
            this.end = z;
        }
        if ((i & 128) == 0) {
            this.suggestions = null;
        } else {
            this.suggestions = list2;
        }
        if ((i & 256) == 0) {
            this.additionalContext = null;
        } else {
            this.additionalContext = additionalContext;
        }
        if ((i & 512) == 0) {
            this.links = CollectionsKt.emptyList();
        } else {
            this.links = list3;
        }
        if ((i & 1024) == 0) {
            this.state = AiAssistantEvents.Loading.INSTANCE;
        } else {
            this.state = aiAssistantEvents;
        }
    }

    public CompletionResponse(String str, String str2, List<Document> list, long j, int i, String str3, boolean z, List<Suggestion> list2, AdditionalContext additionalContext, List<Link> list3, AiAssistantEvents aiAssistantEvents) {
        str.getClass();
        str2.getClass();
        list.getClass();
        list3.getClass();
        aiAssistantEvents.getClass();
        this.requestId = str;
        this.sender = str2;
        this.documents = list;
        this.timestamp = j;
        this.index = i;
        this.content = str3;
        this.end = z;
        this.suggestions = list2;
        this.additionalContext = additionalContext;
        this.links = list3;
        this.state = aiAssistantEvents;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CompletionResponse(String str, String str2, List list, long j, int i, String str3, boolean z, List list2, AdditionalContext additionalContext, List list3, AiAssistantEvents aiAssistantEvents, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 1) != 0) {
            str = UUID.randomUUID().toString();
            str.getClass();
        }
        this(str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (i2 & 8) != 0 ? 0L : j, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? true : z, (i2 & 128) != 0 ? null : list2, (i2 & 256) != 0 ? null : additionalContext, (i2 & 512) != 0 ? CollectionsKt.emptyList() : list3, (i2 & 1024) != 0 ? AiAssistantEvents.Loading.INSTANCE : aiAssistantEvents);
    }
}
