package com.box.android.data.datasource.boxai;

import androidx.media3.extractor.ts.PsExtractor;
import com.box.android.data.api.models.auth.AccessTokenDTO;
import com.box.android.data.api.models.boxai.AiGetAnswerDTO;
import com.box.android.data.api.models.boxai.AiMode;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import external.sdk.pendo.io.mozilla.javascript.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: BoxAiRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/boxai/AiGetAnswerDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$getAnswerStreaming$request$1", f = "BoxAiRemoteDataSource.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {Context.VERSION_1_7, 185, PsExtractor.PRIVATE_STREAM_1}, m = "invokeSuspend", n = {"$this$flow", "$i$f$resultOf", "$i$a$-resultOf-BoxAiRemoteDataSource$getAnswerStreaming$request$1$1", "$this$flow", "$this$onSuccess$iv", "responseStream", "it", "$i$f$onSuccess", "$i$a$-onSuccess-BoxAiRemoteDataSource$getAnswerStreaming$request$1$2", "$i$a$-use-BoxAiRemoteDataSource$getAnswerStreaming$request$1$2$1", "$this$flow", "$this$mapError$iv", "it", "$i$f$mapError", "$i$a$-mapError-BoxAiRemoteDataSource$getAnswerStreaming$request$1$3"}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$4", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
final class BoxAiRemoteDataSource$getAnswerStreaming$request$1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends AiGetAnswerDTO, ? extends RemoteError>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $agentId;
    final /* synthetic */ String $contextSession;
    final /* synthetic */ List<ItemId.Remote> $itemIds;
    final /* synthetic */ String $itemSession;
    final /* synthetic */ String $prompt;
    final /* synthetic */ AiMode $requestMode;
    final /* synthetic */ AccessTokenDTO $token;
    int I$0;
    int I$1;
    int I$2;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ BoxAiRemoteDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoxAiRemoteDataSource$getAnswerStreaming$request$1(BoxAiRemoteDataSource boxAiRemoteDataSource, AiMode aiMode, List<ItemId.Remote> list, String str, String str2, String str3, String str4, AccessTokenDTO accessTokenDTO, Continuation<? super BoxAiRemoteDataSource$getAnswerStreaming$request$1> continuation) {
        super(2, continuation);
        this.this$0 = boxAiRemoteDataSource;
        this.$requestMode = aiMode;
        this.$itemIds = list;
        this.$prompt = str;
        this.$itemSession = str2;
        this.$contextSession = str3;
        this.$agentId = str4;
        this.$token = accessTokenDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BoxAiRemoteDataSource$getAnswerStreaming$request$1 boxAiRemoteDataSource$getAnswerStreaming$request$1 = new BoxAiRemoteDataSource$getAnswerStreaming$request$1(this.this$0, this.$requestMode, this.$itemIds, this.$prompt, this.$itemSession, this.$contextSession, this.$agentId, this.$token, continuation);
        boxAiRemoteDataSource$getAnswerStreaming$request$1.L$0 = obj;
        return boxAiRemoteDataSource$getAnswerStreaming$request$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends AiGetAnswerDTO, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super Result<AiGetAnswerDTO, ? extends RemoteError>>) flowCollector, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Result<AiGetAnswerDTO, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
        return ((BoxAiRemoteDataSource$getAnswerStreaming$request$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0157  */
    /* JADX WARN: Code duplicated, block: B:62:0x015b  */
    /* JADX WARN: Code duplicated, block: B:66:0x01a6  */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0199, code lost:
    
        if (r7.emit(r3, r22) == r8) goto L64;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$getAnswerStreaming$request$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
