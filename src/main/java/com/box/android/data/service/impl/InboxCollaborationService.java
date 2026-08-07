package com.box.android.data.service.impl;

import com.box.android.data.api.models.InboxCollaborationResponseDTO;
import com.box.android.data.datasource.collaboration.InboxCollaborationRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.mappers.InboxCollaborationResponseMapper;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.InboxCollaborationResponseModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationStatus;
import com.box.android.domain.services.IInboxCollaborationService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxCollaborationService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/service/impl/InboxCollaborationService;", "Lcom/box/android/domain/services/IInboxCollaborationService;", "inboxCollaborationRemoteDataSource", "Lcom/box/android/data/datasource/collaboration/InboxCollaborationRemoteDataSource;", "<init>", "(Lcom/box/android/data/datasource/collaboration/InboxCollaborationRemoteDataSource;)V", "updateCollaborationStatus", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/InboxCollaborationResponseModel;", "Lcom/box/android/domain/models/DomainError;", "collaborationId", "", "status", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;", "(Ljava/lang/String;Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxCollaborationService implements IInboxCollaborationService {
    private final InboxCollaborationRemoteDataSource inboxCollaborationRemoteDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.InboxCollaborationService$updateCollaborationStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: InboxCollaborationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.InboxCollaborationService", f = "InboxCollaborationService.kt", i = {0, 0}, l = {20}, m = "updateCollaborationStatus", n = {"collaborationId", "status"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxCollaborationService.this.updateCollaborationStatus(null, null, this);
        }
    }

    @Inject
    public InboxCollaborationService(InboxCollaborationRemoteDataSource inboxCollaborationRemoteDataSource) {
        Intrinsics.checkNotNullParameter(inboxCollaborationRemoteDataSource, "inboxCollaborationRemoteDataSource");
        this.inboxCollaborationRemoteDataSource = inboxCollaborationRemoteDataSource;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IInboxCollaborationService
    public Object updateCollaborationStatus(String str, InboxNotificationCollaborationStatus inboxNotificationCollaborationStatus, Continuation<? super Result<InboxCollaborationResponseModel, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objUpdateCollaboration = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateCollaboration);
            InboxCollaborationRemoteDataSource inboxCollaborationRemoteDataSource = this.inboxCollaborationRemoteDataSource;
            String jsonValue = inboxNotificationCollaborationStatus.getJsonValue();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(inboxNotificationCollaborationStatus);
            anonymousClass1.label = 1;
            objUpdateCollaboration = inboxCollaborationRemoteDataSource.updateCollaboration(str, jsonValue, anonymousClass1);
            if (objUpdateCollaboration == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateCollaboration);
        }
        Result.Success success = (Result) objUpdateCollaboration;
        if (success instanceof Result.Success) {
            success = new Result.Success(InboxCollaborationResponseMapper.INSTANCE.toDomain((InboxCollaborationResponseDTO) ((Result.Success) success).getValue()));
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
