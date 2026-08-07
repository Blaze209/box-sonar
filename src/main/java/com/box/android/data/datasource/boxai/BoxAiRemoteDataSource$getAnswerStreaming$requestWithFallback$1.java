package com.box.android.data.datasource.boxai;

import com.box.android.data.api.models.auth.AccessTokenDTO;
import com.box.android.data.api.models.boxai.AiGetAnswerDTO;
import com.box.android.data.api.models.boxai.AiMode;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: BoxAiRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/boxai/AiGetAnswerDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1", f = "BoxAiRemoteDataSource.kt", i = {0}, l = {194}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
final class BoxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends AiGetAnswerDTO, ? extends RemoteError>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $agentId;
    final /* synthetic */ String $contextSession;
    final /* synthetic */ Function1<RemoteError, AiMode> $getFallbackMode;
    final /* synthetic */ List<ItemId.Remote> $itemIds;
    final /* synthetic */ String $itemSession;
    final /* synthetic */ AiMode $mode;
    final /* synthetic */ String $prompt;
    final /* synthetic */ AccessTokenDTO $token;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BoxAiRemoteDataSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    BoxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1(AiMode aiMode, AccessTokenDTO accessTokenDTO, BoxAiRemoteDataSource boxAiRemoteDataSource, List<ItemId.Remote> list, String str, String str2, String str3, String str4, Function1<? super RemoteError, ? extends AiMode> function1, Continuation<? super BoxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1> continuation) {
        super(2, continuation);
        this.$mode = aiMode;
        this.$token = accessTokenDTO;
        this.this$0 = boxAiRemoteDataSource;
        this.$itemIds = list;
        this.$prompt = str;
        this.$itemSession = str2;
        this.$contextSession = str3;
        this.$agentId = str4;
        this.$getFallbackMode = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BoxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1 boxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1 = new BoxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1(this.$mode, this.$token, this.this$0, this.$itemIds, this.$prompt, this.$itemSession, this.$contextSession, this.$agentId, this.$getFallbackMode, continuation);
        boxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1.L$0 = obj;
        return boxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends AiGetAnswerDTO, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
        return invoke2((FlowCollector<? super Result<AiGetAnswerDTO, ? extends RemoteError>>) flowCollector, continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Result<AiGetAnswerDTO, ? extends RemoteError>> flowCollector, Continuation<? super Unit> continuation) {
        return ((BoxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        final FlowCollector flowCollector = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow answerStreaming$request = BoxAiRemoteDataSource.getAnswerStreaming$request(this.this$0, this.$itemIds, this.$prompt, this.$itemSession, this.$contextSession, this.$agentId, this.$mode, this.$token);
            final Function1<RemoteError, AiMode> function1 = this.$getFallbackMode;
            final AccessTokenDTO accessTokenDTO = this.$token;
            final BoxAiRemoteDataSource boxAiRemoteDataSource = this.this$0;
            final List<ItemId.Remote> list = this.$itemIds;
            final String str = this.$prompt;
            final String str2 = this.$itemSession;
            final String str3 = this.$contextSession;
            final String str4 = this.$agentId;
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (answerStreaming$request.collect(new FlowCollector() { // from class: com.box.android.data.datasource.boxai.BoxAiRemoteDataSource$getAnswerStreaming$requestWithFallback$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Result<AiGetAnswerDTO, ? extends RemoteError>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Result<AiGetAnswerDTO, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
                    if (result instanceof Result.Error) {
                        AiMode aiModeInvoke = function1.invoke((RemoteError) ((Result.Error) result).getValue());
                        if (aiModeInvoke != null) {
                            Object objEmitAll = FlowKt.emitAll(flowCollector, BoxAiRemoteDataSource.getAnswerStreaming$request(boxAiRemoteDataSource, list, str, str2, str3, str4, aiModeInvoke, accessTokenDTO), continuation);
                            return objEmitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmitAll : Unit.INSTANCE;
                        }
                        Object objEmit = flowCollector.emit(result, continuation);
                        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                    }
                    Object objEmit2 = flowCollector.emit(result, continuation);
                    return objEmit2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit2 : Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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
