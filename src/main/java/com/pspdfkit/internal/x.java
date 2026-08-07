package com.pspdfkit.internal;

import android.util.Log;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.jni.NativeLicense;
import io.nutrient.data.models.AdditionalContext;
import io.nutrient.data.models.AgentCompletionRequest;
import io.nutrient.data.models.AgentCompletionRequestParameters;
import io.nutrient.data.models.AiAssistantConfiguration;
import io.nutrient.data.models.AiAssistantError;
import io.nutrient.data.models.AiAssistantEvents;
import io.nutrient.data.models.CompletionRequest;
import io.nutrient.data.models.CompletionResponse;
import io.nutrient.data.models.Context;
import io.nutrient.data.models.Document;
import io.nutrient.data.models.DocumentErrorStates;
import io.nutrient.data.models.DocumentIdentifiers;
import io.nutrient.data.models.IngestionResponse;
import io.nutrient.data.models.InitializationRequest;
import io.nutrient.data.models.Issuer;
import io.nutrient.data.models.None;
import io.nutrient.data.models.RestApiError;
import io.nutrient.domain.ai.AiAssistant;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.json.Json;
import org.apache.hc.core5.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements AiAssistant {
    public AiAssistantConfiguration a;
    public List<DocumentIdentifiers> b;
    public final CoroutineDispatcher c;
    public y d;
    public Socket e;
    public boolean f;
    public Channel<CompletionResponse> g;
    public final Flow<CompletionResponse> h;
    public final Lazy i;
    public final MutableState<Boolean> j;

    @DebugMetadata(c = "io.nutrient.internal.data.core.AiAssistantImpl$initialize$2", f = "AiAssistantImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4}, l = {BoxRequestsFile.DownloadThumbnail.SIZE_320, 331, 347, 354, 370}, m = "invokeSuspend", n = {"responses", "$this$forEach$iv", "element$iv", "documentIdentifier", "layerName", "$i$f$forEach", "$i$a$-forEach-AiAssistantImpl$initialize$2$1", "$i$a$-let-AiAssistantImpl$initialize$2$1$1", "responses", "$this$forEach$iv", "element$iv", "documentIdentifier", "layerName", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$i$f$forEach", "$i$a$-forEach-AiAssistantImpl$initialize$2$1", "$i$a$-let-AiAssistantImpl$initialize$2$1$1", "responses", "$this$forEach$iv", "element$iv", "documentIdentifier", "$i$f$forEach", "$i$a$-forEach-AiAssistantImpl$initialize$2$1", "responses", "$this$forEach$iv", "element$iv", "documentIdentifier", "check", "$i$f$forEach", "$i$a$-forEach-AiAssistantImpl$initialize$2$1", "responses", "it", "$i$a$-also-AiAssistantImpl$initialize$2$2"}, nl = {319, 334, 346, 357, 372}, s = {"L$0", "L$1", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$1", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "L$0", "L$1", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$4", "L$5", "L$6", "I$0", "I$1", "L$0", "L$2", "I$0"}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object a;
        public Object b;
        public Object c;
        public Iterator d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public int i;
        public int j;
        public int k;
        public int l;
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, Continuation<? super a> continuation) {
            super(2, continuation);
            this.n = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return x.this.new a(this.n, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return x.this.new a(this.n, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:54:0x0226  */
        /* JADX WARN: Code duplicated, block: B:58:0x0257  */
        /* JADX WARN: Code duplicated, block: B:62:0x026f  */
        /* JADX WARN: Code duplicated, block: B:64:0x0273  */
        /* JADX WARN: Code duplicated, block: B:67:0x02a3  */
        /* JADX WARN: Code duplicated, block: B:69:0x02ae  */
        /* JADX WARN: Code duplicated, block: B:71:0x02b3  */
        /* JADX WARN: Code duplicated, block: B:73:0x02c3  */
        /* JADX WARN: Code duplicated, block: B:74:0x02c6  */
        /* JADX WARN: Code duplicated, block: B:78:0x0305  */
        /* JADX WARN: Code duplicated, block: B:98:0x021b A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x02a3 -> B:68:0x02a8). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r35) {
            /*
                Method dump skipped, instruction units count: 859
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pspdfkit.internal.x.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "io.nutrient.internal.data.core.AiAssistantImpl$update$2", f = "AiAssistantImpl.kt", i = {}, l = {HttpStatus.SC_UNAVAILABLE_FOR_LEGAL_REASONS}, m = "invokeSuspend", n = {}, nl = {452}, s = {}, v = 2)
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ List<DocumentIdentifiers> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List<DocumentIdentifiers> list, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return x.this.new c(this.c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return x.this.new c(this.c, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                x xVar = x.this;
                List<DocumentIdentifiers> list = this.c;
                list.getClass();
                xVar.b = list;
                x xVar2 = x.this;
                this.a = 1;
                if (AiAssistant.initialize$default(xVar2, false, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "io.nutrient.internal.data.core.AiAssistantImpl$update$4", f = "AiAssistantImpl.kt", i = {0}, l = {464}, m = "invokeSuspend", n = {"existingBundleIdentifier"}, nl = {465}, s = {"L$0"}, v = 2)
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public Object a;
        public int b;
        public final /* synthetic */ AiAssistantConfiguration d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AiAssistantConfiguration aiAssistantConfiguration, Continuation<? super d> continuation) {
            super(2, continuation);
            this.d = aiAssistantConfiguration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return x.this.new d(this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return x.this.new d(this.d, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                x xVar = x.this;
                AiAssistantConfiguration aiAssistantConfiguration = this.d;
                aiAssistantConfiguration.getClass();
                xVar.a = aiAssistantConfiguration;
                x xVar2 = x.this;
                String str = xVar2.d.a;
                xVar2.d = new y(str, this.d.getServerUrl());
                x xVar3 = x.this;
                this.a = SpillingKt.nullOutSpilledVariable(str);
                this.b = 1;
                if (AiAssistant.initialize$default(xVar3, false, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public x(String str, AiAssistantConfiguration aiAssistantConfiguration, List<DocumentIdentifiers> list, CoroutineDispatcher coroutineDispatcher) {
        str.getClass();
        aiAssistantConfiguration.getClass();
        list.getClass();
        coroutineDispatcher.getClass();
        this.a = aiAssistantConfiguration;
        this.b = list;
        this.c = coroutineDispatcher;
        this.d = new y(str, aiAssistantConfiguration.getServerUrl());
        Channel<CompletionResponse> channelChannel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.g = channelChannel$default;
        this.h = FlowKt.receiveAsFlow(channelChannel$default);
        uw.a(this.b, "DocumentIdentifiers are empty");
        this.i = LazyKt.lazy(new Function0() { // from class: com.pspdfkit.internal.x$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return x.a(this.f$0);
            }
        });
        this.j = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(x xVar, y.a.C0295a c0295a, DocumentIdentifiers documentIdentifiers, List list, ContinuationImpl continuationImpl) {
        w wVar;
        DocumentIdentifiers documentIdentifiers2;
        List list2;
        AiAssistantEvents.Error error;
        xVar.getClass();
        if (continuationImpl instanceof w) {
            wVar = (w) continuationImpl;
            int i = wVar.f;
            if ((i & Integer.MIN_VALUE) != 0) {
                wVar.f = i - Integer.MIN_VALUE;
            } else {
                wVar = new w(xVar, continuationImpl);
            }
        } else {
            wVar = new w(xVar, continuationImpl);
        }
        Object objA = wVar.d;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = wVar.f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            if (c0295a.a != DocumentErrorStates.INGESTED.getCode()) {
                DataProvider dataProvider = documentIdentifiers.getDataProvider();
                String jwt = xVar.a.getJwt();
                wVar.a = SpillingKt.nullOutSpilledVariable(c0295a);
                documentIdentifiers2 = documentIdentifiers;
                wVar.b = documentIdentifiers2;
                list2 = list;
                wVar.c = list2;
                wVar.f = 1;
                objA = xVar.d.a(dataProvider, jwt);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Object[] objArr = 0 == true ? 1 : 0;
                ChannelResult.m16334boximpl(xVar.g.mo11206trySendJP2dKIU(new CompletionResponse((String) null, (String) null, (List) null, 0L, 0, (String) objArr, true, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) new AiAssistantEvents.Error(c0295a.b, DocumentErrorStates.INSTANCE.getStateByCode(c0295a.a), false, 4, null), 959, (DefaultConstructorMarker) null)));
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        List list3 = wVar.c;
        DocumentIdentifiers documentIdentifiers3 = wVar.b;
        ResultKt.throwOnFailure(objA);
        list2 = list3;
        documentIdentifiers2 = documentIdentifiers3;
        y.a aVar = (y.a) objA;
        if (aVar instanceof y.a.c) {
            IngestionResponse ingestionResponse = (IngestionResponse) ((y.a.c) aVar).a;
            AiAssistantConfiguration aiAssistantConfiguration = xVar.a;
            String token = ingestionResponse.getToken();
            if (token == null) {
                token = xVar.a.getJwt();
            }
            AiAssistantConfiguration aiAssistantConfigurationCopy$default = AiAssistantConfiguration.copy$default(aiAssistantConfiguration, null, token, null, null, 13, null);
            aiAssistantConfigurationCopy$default.getClass();
            xVar.a = aiAssistantConfigurationCopy$default;
            List<DocumentIdentifiers> list4 = xVar.b;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
            for (DocumentIdentifiers documentIdentifiersCopy$default : list4) {
                if (Intrinsics.areEqual(documentIdentifiersCopy$default, documentIdentifiers2)) {
                    String permanentId = ingestionResponse.getPermanentId();
                    documentIdentifiersCopy$default = DocumentIdentifiers.copy$default(documentIdentifiersCopy$default, null, permanentId == null ? "" : permanentId, documentIdentifiersCopy$default.getSourcePdfSha256(), ingestionResponse.getChangingId(), documentIdentifiersCopy$default.getLayerName(), 1, null);
                }
                arrayList.add(documentIdentifiersCopy$default);
            }
            xVar.b = arrayList;
            Unit unit = Unit.INSTANCE;
            list2.add(aVar);
        } else if (aVar instanceof y.a.C0295a) {
            Channel<CompletionResponse> channel = xVar.g;
            try {
                Json.Companion companion = Json.INSTANCE;
                String str = ((y.a.C0295a) aVar).b;
                companion.getSerializersModule();
                String message = ((RestApiError) companion.decodeFromString(RestApiError.INSTANCE.serializer(), str)).getMessage();
                if (message == null) {
                    message = ((y.a.C0295a) aVar).b;
                }
                error = new AiAssistantEvents.Error(message, DocumentErrorStates.INSTANCE.getStateByCode(((y.a.C0295a) aVar).a), false, 4, null);
            } catch (Exception unused) {
                error = new AiAssistantEvents.Error(((y.a.C0295a) aVar).b, DocumentErrorStates.EVALUATION_EXPIRED, false, 4, null);
            }
            ChannelResult.m16334boximpl(channel.mo11206trySendJP2dKIU(new CompletionResponse((String) null, (String) null, (List) null, 0L, 0, (String) null, true, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) error, 959, (DefaultConstructorMarker) null)));
        } else {
            if (!(aVar instanceof y.a.b)) {
                throw new NoWhenBranchMatchedException();
            }
            Channel<CompletionResponse> channel2 = xVar.g;
            String localizedMessage = ((y.a.b) aVar).a.getLocalizedMessage();
            ChannelResult.m16334boximpl(channel2.mo11206trySendJP2dKIU(new CompletionResponse((String) null, (String) null, (List) null, 0L, 0, (String) null, true, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) new AiAssistantEvents.Error(localizedMessage == null ? "" : localizedMessage, DocumentErrorStates.SERVER_ERROR, false, 4, null), 959, (DefaultConstructorMarker) null)));
        }
        return Unit.INSTANCE;
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final Object checkIfDocumentIsAlreadyIngested(String str, String str2, Continuation<? super y.a<? extends None>> continuation) {
        return this.d.a(str, str2, this.a.getJwt());
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final void emitContextSpecificMessage(String str, String str2) throws JSONException {
        str.getClass();
        str2.getClass();
        if (this.f) {
            Channel<CompletionResponse> channel = this.g;
            Issuer.Companion companion = Issuer.INSTANCE;
            channel.mo11206trySendJP2dKIU(new CompletionResponse((String) null, companion.value(Issuer.HUMAN), (List) null, 0L, 0, str, true, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) AiAssistantEvents.Loading.INSTANCE, 925, (DefaultConstructorMarker) null));
            AgentCompletionRequestParameters agentCompletionRequestParameters = new AgentCompletionRequestParameters(str, new Context(0, str2));
            String string = UUID.randomUUID().toString();
            string.getClass();
            String strValue = companion.value(Issuer.USER);
            List list = (List) this.i.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Document((String) it.next(), (String) null, 2, (DefaultConstructorMarker) null));
            }
            JSONObject jsonObject = new AgentCompletionRequest(string, strValue, arrayList, agentCompletionRequestParameters, this.a.getSessionId(), "ContextSpecificQA").toJsonObject();
            Socket socket = this.e;
            if (socket != null) {
                socket.emit("agent-completion", new Object[]{jsonObject});
            }
        }
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final void emitMessage(String str) {
        str.getClass();
        if (this.f) {
            Channel<CompletionResponse> channel = this.g;
            Issuer.Companion companion = Issuer.INSTANCE;
            channel.mo11206trySendJP2dKIU(new CompletionResponse((String) null, companion.value(Issuer.HUMAN), (List) null, 0L, 0, str, true, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) AiAssistantEvents.Loading.INSTANCE, 925, (DefaultConstructorMarker) null));
            String string = UUID.randomUUID().toString();
            string.getClass();
            String strValue = companion.value(Issuer.USER);
            List list = (List) this.i.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Document((String) it.next(), (String) null, 2, (DefaultConstructorMarker) null));
            }
            CompletionRequest completionRequest = new CompletionRequest(string, strValue, arrayList, MapsKt.mapOf(TuplesKt.to("input", str)), this.a.getSessionId(), (String) null, 32, (DefaultConstructorMarker) null);
            Socket socket = this.e;
            if (socket != null) {
                socket.emit("completion", new Object[]{completionRequest.toJsonObject()});
            }
        }
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final Object emitSelectedText(String str, Continuation<? super Unit> continuation) throws JSONException {
        AgentCompletionRequestParameters agentCompletionRequestParameters = new AgentCompletionRequestParameters((String) null, new Context(0, str), 1, (DefaultConstructorMarker) null);
        String string = UUID.randomUUID().toString();
        string.getClass();
        String strValue = Issuer.INSTANCE.value(Issuer.SYSTEM);
        List list = (List) this.i.getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Document((String) it.next(), (String) null, 2, (DefaultConstructorMarker) null));
        }
        JSONObject jsonObject = new AgentCompletionRequest(string, strValue, arrayList, agentCompletionRequestParameters, this.a.getSessionId(), "SelectedTextSuggestedActions").toJsonObject();
        Socket socket = this.e;
        if (socket != null) {
            socket.emit("agent-completion", new Object[]{jsonObject});
        }
        return Unit.INSTANCE;
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final void enableTextSelection(boolean z) {
        this.j.setValue(Boolean.valueOf(z));
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final AiAssistantConfiguration getConfiguration() {
        return this.a;
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final List<DocumentIdentifiers> getIdentifiers() {
        return this.b;
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final Flow<CompletionResponse> getResponseState() {
        return this.h;
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final Object getSessionHistory(Continuation<? super y.a<? extends List<CompletionResponse>>> continuation) {
        return this.d.a(this.a.getSessionId(), this.a.getJwt());
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final Object ingestDocument(DataProvider dataProvider, String str, Continuation<? super y.a<IngestionResponse>> continuation) {
        return this.d.a(dataProvider, str);
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final Object initialize(boolean z, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.c, new a(z, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final Object initializeSocketConnection(boolean z, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.c, new b(z, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final Object instantIngestion(String str, String str2, String str3, Continuation<? super y.a<? extends None>> continuation) {
        return this.d.a(str, this.a.getJwt(), str2, str3);
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final boolean isTextSelectionEnabled() {
        return this.j.getValue().booleanValue();
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final void terminate() {
        Socket socket = this.e;
        if (socket != null) {
            socket.disconnect();
        }
        SendChannel.DefaultImpls.close$default(this.g, null, 1, null);
        this.g = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final Object update(List<DocumentIdentifiers> list, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.c, new c(list, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // io.nutrient.domain.ai.AiAssistant
    public final Object update(AiAssistantConfiguration aiAssistantConfiguration, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.c, new d(aiAssistantConfiguration, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @DebugMetadata(c = "io.nutrient.internal.data.core.AiAssistantImpl$initializeSocketConnection$2", f = "AiAssistantImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Emitter>, Object> {
        public final /* synthetic */ boolean b;

        @DebugMetadata(c = "io.nutrient.internal.data.core.AiAssistantImpl$initializeSocketConnection$2$1$1$1", f = "AiAssistantImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public /* synthetic */ Object a;
            public final /* synthetic */ x b;

            /* JADX INFO: renamed from: com.pspdfkit.internal.x$b$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "io.nutrient.internal.data.core.AiAssistantImpl$initializeSocketConnection$2$1$1$1$1", f = "AiAssistantImpl.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, nl = {123}, s = {}, v = 2)
            public static final class C0294a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                public int a;
                public final /* synthetic */ x b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0294a(x xVar, Continuation<? super C0294a> continuation) {
                    super(2, continuation);
                    this.b = xVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0294a(this.b, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return new C0294a(this.b, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object sessionHistory;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        x xVar = this.b;
                        this.a = 1;
                        sessionHistory = xVar.getSessionHistory(this);
                        if (sessionHistory == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        sessionHistory = obj;
                    }
                    y.a aVar = (y.a) sessionHistory;
                    if (aVar instanceof y.a.c) {
                        y.a.c cVar = (y.a.c) aVar;
                        Iterable iterable = (Iterable) cVar.a;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : iterable) {
                            if (!Intrinsics.areEqual(((CompletionResponse) obj2).getRequestId(), "evaluation-license")) {
                                arrayList.add(obj2);
                            }
                        }
                        if (arrayList.isEmpty()) {
                            x xVar2 = this.b;
                            String string = UUID.randomUUID().toString();
                            string.getClass();
                            String strValue = Issuer.INSTANCE.value(Issuer.SYSTEM);
                            List list = (List) this.b.i.getValue();
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(new Document((String) it.next(), (String) null, 2, (DefaultConstructorMarker) null));
                            }
                            CompletionRequest completionRequest = new CompletionRequest(string, strValue, arrayList2, MapsKt.mapOf(TuplesKt.to("input", "")), this.b.a.getSessionId(), "SuggestedQuestions");
                            Socket socket = xVar2.e;
                            if (socket != null) {
                                socket.emit("agent-completion", new Object[]{completionRequest.toJsonObject()});
                            }
                        }
                        Iterable iterable2 = (Iterable) cVar.a;
                        x xVar3 = this.b;
                        Iterator it2 = iterable2.iterator();
                        while (it2.hasNext()) {
                            xVar3.g.mo11206trySendJP2dKIU(CompletionResponse.copy$default((CompletionResponse) it2.next(), null, null, null, 0L, 0, null, false, null, null, null, AiAssistantEvents.Success.INSTANCE, 1023, null));
                        }
                        Unit unit = Unit.INSTANCE;
                    } else if (aVar instanceof y.a.C0295a) {
                        Boxing.boxInt(Log.e("SessionHistory", "sessionResponse Error: " + aVar));
                    } else {
                        if (!(aVar instanceof y.a.b)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Boxing.boxInt(Log.e("SessionHistory", "sessionResponse Exception: " + aVar));
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(x xVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = xVar;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.b, continuation);
                aVar.a = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                a aVar = new a(this.b, continuation);
                aVar.a = coroutineScope;
                return aVar.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineScope coroutineScope = (CoroutineScope) this.a;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C0294a(this.b, null), 3, null);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = z;
        }

        public static final void a(final x xVar, final boolean z, Object[] objArr) throws JSONException {
            Socket socket = xVar.e;
            if (socket != null) {
                socket.once("document-assistant-ready", new Emitter.Listener() { // from class: com.pspdfkit.internal.x$b$$ExternalSyntheticLambda1
                    public final void call(Object[] objArr2) throws InterruptedException {
                        x.b.b(xVar, z, objArr2);
                    }
                });
            }
            String string = UUID.randomUUID().toString();
            String sessionId = xVar.a.getSessionId();
            String userId = xVar.a.getUserId();
            ArrayList<String> arrayListJsonFeatures = NativeLicense.license().jsonFeatures();
            arrayListJsonFeatures.getClass();
            JSONObject jsonObject = new InitializationRequest(string, userId, sessionId, (String[]) arrayListJsonFeatures.toArray(new String[0])).toJsonObject();
            Socket socket2 = xVar.e;
            if (socket2 != null) {
                socket2.emit("initialize", new Object[]{jsonObject});
            }
            Socket socket3 = xVar.e;
            if (socket3 != null) {
                socket3.on("disconnect", new Emitter.Listener() { // from class: com.pspdfkit.internal.x$b$$ExternalSyntheticLambda2
                    public final void call(Object[] objArr2) {
                        x.b.a(xVar, objArr2);
                    }
                });
            }
            Socket socket4 = xVar.e;
            if (socket4 != null) {
                socket4.on("chat-block", new Emitter.Listener() { // from class: com.pspdfkit.internal.x$b$$ExternalSyntheticLambda3
                    public final void call(Object[] objArr2) {
                        x.b.b(xVar, objArr2);
                    }
                });
            }
            Socket socket5 = xVar.e;
            if (socket5 != null) {
                socket5.on("error", new Emitter.Listener() { // from class: com.pspdfkit.internal.x$b$$ExternalSyntheticLambda4
                    public final void call(Object[] objArr2) {
                        x.b.c(xVar, objArr2);
                    }
                });
            }
            Socket socket6 = xVar.e;
            if (socket6 != null) {
                socket6.on("connect_error", new Emitter.Listener() { // from class: com.pspdfkit.internal.x$b$$ExternalSyntheticLambda5
                    public final void call(Object[] objArr2) {
                        x.b.d(xVar, objArr2);
                    }
                });
            }
        }

        public static final void b(x xVar, boolean z, Object[] objArr) throws InterruptedException {
            xVar.f = true;
            xVar.g.mo11206trySendJP2dKIU(new CompletionResponse((String) null, (String) null, (List) null, 0L, 0, "document-assistant-ready", true, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) AiAssistantEvents.SocketConnected.INSTANCE, 927, (DefaultConstructorMarker) null));
            if (z) {
                BuildersKt__BuildersKt.runBlocking$default(null, new a(xVar, null), 1, null);
            }
        }

        public static final void c(x xVar, Object[] objArr) {
            String requestId;
            String issuer;
            try {
                Json.Companion companion = Json.INSTANCE;
                String string = objArr[0].toString();
                companion.getSerializersModule();
                AiAssistantError aiAssistantError = (AiAssistantError) companion.decodeFromString(AiAssistantError.INSTANCE.serializer(), string);
                CompletionRequest request = aiAssistantError.getRequest();
                Channel<CompletionResponse> channel = xVar.g;
                String str = "";
                if (request == null || (requestId = request.getRequestId()) == null) {
                    requestId = "";
                }
                String str2 = (request == null || (issuer = request.getIssuer()) == null) ? "" : issuer;
                String message = aiAssistantError.getMessage();
                if (message != null) {
                    str = message;
                }
                channel.mo11206trySendJP2dKIU(new CompletionResponse(requestId, str2, (List) null, 0L, 0, aiAssistantError.getMessage(), true, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) new AiAssistantEvents.Error(str, DocumentErrorStates.EXCEEDS_LIMIT, false), 924, (DefaultConstructorMarker) null));
            } catch (Exception e) {
                e.printStackTrace();
                xVar.g.mo11206trySendJP2dKIU(new CompletionResponse((String) null, (String) null, (List) null, 0L, 0, (String) null, true, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) new AiAssistantEvents.Error("Server error", DocumentErrorStates.SERVER_ERROR, false, 4, null), 959, (DefaultConstructorMarker) null));
            }
        }

        public static final void d(x xVar, Object[] objArr) {
            objArr.getClass();
            Log.e("AiAssistant", "EVENT_CONNECT_ERROR initializeSocketConnection: " + ArraysKt.joinToString$default(objArr, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            Socket socket = xVar.e;
            if (socket != null) {
                socket.disconnect();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return x.this.new b(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Emitter> continuation) {
            return x.this.new b(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            x xVar = x.this;
            y yVar = xVar.d;
            String serverUrl = xVar.a.getServerUrl();
            String jwt = x.this.a.getJwt();
            yVar.getClass();
            xVar.e = y.b(serverUrl, jwt).connect();
            final x xVar2 = x.this;
            Socket socket = xVar2.e;
            if (socket == null) {
                return null;
            }
            final boolean z = this.b;
            return socket.on("connect", new Emitter.Listener() { // from class: com.pspdfkit.internal.x$b$$ExternalSyntheticLambda0
                public final void call(Object[] objArr) throws JSONException {
                    x.b.a(xVar2, z, objArr);
                }
            });
        }

        public static final void b(x xVar, Object[] objArr) {
            Json.Companion companion = Json.INSTANCE;
            String string = objArr[0].toString();
            companion.getSerializersModule();
            xVar.g.mo11206trySendJP2dKIU(CompletionResponse.copy$default((CompletionResponse) companion.decodeFromString(CompletionResponse.INSTANCE.serializer(), string), null, null, null, 0L, 0, null, false, null, null, null, AiAssistantEvents.Chat.INSTANCE, 1023, null));
        }

        public static final void a(x xVar, Object[] objArr) {
            Socket socket = xVar.e;
            if (socket != null) {
                socket.disconnect();
            }
            xVar.g.mo11206trySendJP2dKIU(new CompletionResponse((String) null, (String) null, (List) null, 0L, 0, (String) null, true, (List) null, (AdditionalContext) null, (List) null, (AiAssistantEvents) AiAssistantEvents.SocketDisconnected.INSTANCE, 959, (DefaultConstructorMarker) null));
        }
    }

    public static final List a(x xVar) {
        List<DocumentIdentifiers> list = xVar.b;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((DocumentIdentifiers) it.next()).getPermanentId());
        }
        return arrayList;
    }
}
