package com.box.android.clientadmin;

import com.box.android.data.mappers.ClientSettingsDTODomainMapper;
import com.box.android.data.service.impl.ClientSettingsService;
import com.box.android.domain.models.ClientSettingsModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxException;
import com.box.boxandroidlibv2private.dao.BoxAdminSettings;
import javax.inject.Inject;
import kotlin.Deprecated;
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
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BoxAdminSettingsProvider.kt */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated(message = "Use ClientSettingsService to fetch admin settings from remote and local")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/clientadmin/BoxAdminSettingsProvider;", "", "clientSettingsService", "Lcom/box/android/data/service/impl/ClientSettingsService;", "<init>", "(Lcom/box/android/data/service/impl/ClientSettingsService;)V", "getAdminSettingsRemote", "Lcom/box/boxandroidlibv2private/dao/BoxAdminSettings;", "getAdminSettingsIfNeeded", "getAdminSettingsLocal", "shouldUpdateAdminSettings", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAdminSettingsProvider {
    public static final int $stable = 8;
    private final ClientSettingsService clientSettingsService;

    @Inject
    public BoxAdminSettingsProvider(ClientSettingsService clientSettingsService) {
        Intrinsics.checkNotNullParameter(clientSettingsService, "clientSettingsService");
        this.clientSettingsService = clientSettingsService;
    }

    /* JADX INFO: renamed from: com.box.android.clientadmin.BoxAdminSettingsProvider$getAdminSettingsRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAdminSettingsProvider.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/ClientSettingsModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.clientadmin.BoxAdminSettingsProvider$getAdminSettingsRemote$1", f = "BoxAdminSettingsProvider.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ClientSettingsModel, ? extends DomainError>>, Object> {
        int label;

        C10011(Continuation<? super C10011> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxAdminSettingsProvider.this.new C10011(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ClientSettingsModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<ClientSettingsModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<ClientSettingsModel, ? extends DomainError>> continuation) {
            return ((C10011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object clientSettingsRemote = BoxAdminSettingsProvider.this.clientSettingsService.getClientSettingsRemote(this);
            return clientSettingsRemote == coroutine_suspended ? coroutine_suspended : clientSettingsRemote;
        }
    }

    public final BoxAdminSettings getAdminSettingsRemote() throws BoxException {
        Result.Success success = (Result) BuildersKt__BuildersKt.runBlocking$default(null, new C10011(null), 1, null);
        boolean z = success instanceof Result.Success;
        if (z) {
            if (z) {
                success = new Result.Success(ClientSettingsDTODomainMapper.INSTANCE.toBoxAdminSettings((ClientSettingsModel) ((Result.Success) success).getValue()));
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            Object obj = com.box.android.domain.utils.result.ResultKt.get(success);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.box.boxandroidlibv2private.dao.BoxAdminSettings");
            return (BoxAdminSettings) obj;
        }
        if (success instanceof Result.Error) {
            throw new BoxException(((DomainError) ((Result.Error) success).getValue()).getMessage());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.clientadmin.BoxAdminSettingsProvider$getAdminSettingsIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAdminSettingsProvider.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/ClientSettingsModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.clientadmin.BoxAdminSettingsProvider$getAdminSettingsIfNeeded$1", f = "BoxAdminSettingsProvider.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ClientSettingsModel, ? extends DomainError>>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxAdminSettingsProvider.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ClientSettingsModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<ClientSettingsModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<ClientSettingsModel, ? extends DomainError>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object clientSettingsIfNeeded = BoxAdminSettingsProvider.this.clientSettingsService.getClientSettingsIfNeeded(this);
            return clientSettingsIfNeeded == coroutine_suspended ? coroutine_suspended : clientSettingsIfNeeded;
        }
    }

    public final BoxAdminSettings getAdminSettingsIfNeeded() throws BoxException {
        Result.Success success = (Result) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
        boolean z = success instanceof Result.Success;
        if (z) {
            if (z) {
                success = new Result.Success(ClientSettingsDTODomainMapper.INSTANCE.toBoxAdminSettings((ClientSettingsModel) ((Result.Success) success).getValue()));
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            Object obj = com.box.android.domain.utils.result.ResultKt.get(success);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.box.boxandroidlibv2private.dao.BoxAdminSettings");
            return (BoxAdminSettings) obj;
        }
        if (success instanceof Result.Error) {
            throw new BoxException(((DomainError) ((Result.Error) success).getValue()).getMessage());
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.clientadmin.BoxAdminSettingsProvider$getAdminSettingsLocal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxAdminSettingsProvider.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/ClientSettingsModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.clientadmin.BoxAdminSettingsProvider$getAdminSettingsLocal$1", f = "BoxAdminSettingsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C10001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ClientSettingsModel, ? extends DomainError>>, Object> {
        int label;

        C10001(Continuation<? super C10001> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BoxAdminSettingsProvider.this.new C10001(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends ClientSettingsModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<ClientSettingsModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<ClientSettingsModel, ? extends DomainError>> continuation) {
            return ((C10001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return BoxAdminSettingsProvider.this.clientSettingsService.getClientSettingsLocal();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final BoxAdminSettings getAdminSettingsLocal() throws BoxException {
        Result.Success success = (Result) BuildersKt__BuildersKt.runBlocking$default(null, new C10001(null), 1, null);
        boolean z = success instanceof Result.Success;
        if (z) {
            if (z) {
                success = new Result.Success(ClientSettingsDTODomainMapper.INSTANCE.toBoxAdminSettings((ClientSettingsModel) ((Result.Success) success).getValue()));
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            Object obj = com.box.android.domain.utils.result.ResultKt.get(success);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.box.boxandroidlibv2private.dao.BoxAdminSettings");
            return (BoxAdminSettings) obj;
        }
        if (success instanceof Result.Error) {
            throw new BoxException(((DomainError) ((Result.Error) success).getValue()).getMessage());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean shouldUpdateAdminSettings() {
        return ClientSettingsService.areClientSettingsInvalid$default(this.clientSettingsService, 0L, 1, null);
    }
}
