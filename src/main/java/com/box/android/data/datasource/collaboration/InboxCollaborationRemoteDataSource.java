package com.box.android.data.datasource.collaboration;

import com.box.android.data.api.models.InboxCollaborationResponseDTO;
import com.box.android.data.api.models.inboxnotifications.UpdateInboxCollaborationDTO;
import com.box.android.data.api.requests.InboxCollaborationRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.squareup.moshi.Moshi;
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

/* JADX INFO: compiled from: InboxCollaborationRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/datasource/collaboration/InboxCollaborationRemoteDataSource;", "", "inboxCollaborationRequest", "Lcom/box/android/data/api/requests/InboxCollaborationRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/InboxCollaborationRequest;Lcom/squareup/moshi/Moshi;)V", "updateCollaboration", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/InboxCollaborationResponseDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "collaborationId", "", "status", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxCollaborationRemoteDataSource {
    private final InboxCollaborationRequest inboxCollaborationRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.collaboration.InboxCollaborationRemoteDataSource$updateCollaboration$1, reason: invalid class name */
    /* JADX INFO: compiled from: InboxCollaborationRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collaboration.InboxCollaborationRemoteDataSource", f = "InboxCollaborationRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {21}, m = "updateCollaboration", n = {"collaborationId", "status", "$i$f$resultOf", "$i$a$-resultOf-InboxCollaborationRemoteDataSource$updateCollaboration$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return InboxCollaborationRemoteDataSource.this.updateCollaboration(null, null, this);
        }
    }

    @Inject
    public InboxCollaborationRemoteDataSource(InboxCollaborationRequest inboxCollaborationRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(inboxCollaborationRequest, "inboxCollaborationRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.inboxCollaborationRequest = inboxCollaborationRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateCollaboration(String str, String str2, Continuation<? super Result<InboxCollaborationResponseDTO, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
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
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUpdateCollaboration);
                InboxCollaborationRequest inboxCollaborationRequest = this.inboxCollaborationRequest;
                UpdateInboxCollaborationDTO updateInboxCollaborationDTO = new UpdateInboxCollaborationDTO(str2);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                objUpdateCollaboration = inboxCollaborationRequest.updateCollaboration(str, updateInboxCollaborationDTO, anonymousClass1);
                if (objUpdateCollaboration == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(objUpdateCollaboration);
            }
            error = new Result.Success((InboxCollaborationResponseDTO) objUpdateCollaboration);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }
}
