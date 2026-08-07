package com.box.android.data.service.impl;

import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivityKt;
import com.box.android.data.api.models.auth.AccessTokenDTO;
import com.box.android.data.datasource.auth.AuthenticationRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.mappers.AccessTokenDTODomainMapper;
import com.box.android.domain.models.AuthenticationInfoModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.IAuthenticationCredentialsProvider;
import com.box.android.domain.services.IAuthenticationService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: AuthenticationService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0096@¢\u0006\u0002\u0010\fJ,\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0096@¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/service/impl/AuthenticationService;", "Lcom/box/android/domain/services/IAuthenticationService;", "authenticationRemoteDataSource", "Lcom/box/android/data/datasource/auth/AuthenticationRemoteDataSource;", "authenticationCredentialsProvider", "Lcom/box/android/domain/services/IAuthenticationCredentialsProvider;", "<init>", "(Lcom/box/android/data/datasource/auth/AuthenticationRemoteDataSource;Lcom/box/android/domain/services/IAuthenticationCredentialsProvider;)V", "authenticateAnonymously", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/AuthenticationInfoModel;", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateWithMsal", "", "externalToken", BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthenticationService implements IAuthenticationService {
    private final IAuthenticationCredentialsProvider authenticationCredentialsProvider;
    private final AuthenticationRemoteDataSource authenticationRemoteDataSource;

    @Inject
    public AuthenticationService(AuthenticationRemoteDataSource authenticationRemoteDataSource, IAuthenticationCredentialsProvider authenticationCredentialsProvider) {
        Intrinsics.checkNotNullParameter(authenticationRemoteDataSource, "authenticationRemoteDataSource");
        Intrinsics.checkNotNullParameter(authenticationCredentialsProvider, "authenticationCredentialsProvider");
        this.authenticationRemoteDataSource = authenticationRemoteDataSource;
        this.authenticationCredentialsProvider = authenticationCredentialsProvider;
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.AuthenticationService$authenticateAnonymously$2, reason: invalid class name */
    /* JADX INFO: compiled from: AuthenticationService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/AuthenticationInfoModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.AuthenticationService$authenticateAnonymously$2", f = "AuthenticationService.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends AuthenticationInfoModel, ? extends DomainError>>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AuthenticationService.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends AuthenticationInfoModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<AuthenticationInfoModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<AuthenticationInfoModel, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AuthenticationService.this.authenticationRemoteDataSource.authenticateAnonymously(AuthenticationService.this.authenticationCredentialsProvider.getClientId(), AuthenticationService.this.authenticationCredentialsProvider.getSecret(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.Success success = (Result) obj;
            AuthenticationService authenticationService = AuthenticationService.this;
            if (success instanceof Result.Success) {
                success = new Result.Success(new AccessTokenDTODomainMapper(authenticationService.authenticationCredentialsProvider.getClientId(), null).toDomain((AccessTokenDTO) ((Result.Success) success).getValue()));
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (success instanceof Result.Success) {
                return success;
            }
            if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
        }
    }

    @Override // com.box.android.domain.services.IAuthenticationService
    public Object authenticateAnonymously(Continuation<? super Result<AuthenticationInfoModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.AuthenticationService$authenticateWithMsal$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthenticationService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.AuthenticationService$authenticateWithMsal$2", f = "AuthenticationService.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C13972 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends String, ? extends DomainError>>, Object> {
        final /* synthetic */ String $codeChallenge;
        final /* synthetic */ String $externalToken;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C13972(String str, String str2, Continuation<? super C13972> continuation) {
            super(2, continuation);
            this.$externalToken = str;
            this.$codeChallenge = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return AuthenticationService.this.new C13972(this.$externalToken, this.$codeChallenge, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends String, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<String, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<String, ? extends DomainError>> continuation) {
            return ((C13972) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AuthenticationService.this.authenticationRemoteDataSource.authenticateWithMsal(this.$externalToken, this.$codeChallenge, AuthenticationService.this.authenticationCredentialsProvider.getClientId(), this);
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
                return result;
            }
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) result).getValue(), null, 2, null));
        }
    }

    @Override // com.box.android.domain.services.IAuthenticationService
    public Object authenticateWithMsal(String str, String str2, Continuation<? super Result<String, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C13972(str, str2, null), continuation);
    }
}
