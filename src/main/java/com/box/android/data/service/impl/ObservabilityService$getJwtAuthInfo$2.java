package com.box.android.data.service.impl;

import com.box.android.data.api.models.ClientSettingsDTO;
import com.box.android.data.api.models.JWTAppSettings;
import com.box.android.data.api.models.JWTAuthInfo;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.AuthenticationInfoModel;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ObservabilityService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/JWTAuthInfo;", "Lcom/box/android/data/datasource/errors/RemoteError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.ObservabilityService$getJwtAuthInfo$2", f = "ObservabilityService.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ObservabilityService$getJwtAuthInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends JWTAuthInfo, ? extends RemoteError>>, Object> {
    final /* synthetic */ AuthenticationInfoModel $authInfoModel;
    int label;
    final /* synthetic */ ObservabilityService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ObservabilityService$getJwtAuthInfo$2(ObservabilityService observabilityService, AuthenticationInfoModel authenticationInfoModel, Continuation<? super ObservabilityService$getJwtAuthInfo$2> continuation) {
        super(2, continuation);
        this.this$0 = observabilityService;
        this.$authInfoModel = authenticationInfoModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ObservabilityService$getJwtAuthInfo$2(this.this$0, this.$authInfoModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends JWTAuthInfo, ? extends RemoteError>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<JWTAuthInfo, ? extends RemoteError>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<JWTAuthInfo, ? extends RemoteError>> continuation) {
        return ((ObservabilityService$getJwtAuthInfo$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.clientSettingsRemoteDataSource.getClientSettings(this.$authInfoModel.getAccessToken(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Result result = (Result) obj;
        if (result instanceof Result.Success) {
            JWTAppSettings jwtAppSettings = ((ClientSettingsDTO) ((Result.Success) result).getValue()).getJwtAppSettings();
            return new Result.Success(jwtAppSettings != null ? jwtAppSettings.getDefault() : null);
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }
}
