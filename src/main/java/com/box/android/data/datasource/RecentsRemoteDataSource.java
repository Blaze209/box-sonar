package com.box.android.data.datasource;

import android.text.TextUtils;
import com.box.android.data.api.models.AddToRecentsDTO;
import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.data.api.requests.RecentsRequest;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.usecases.InteractionType;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.squareup.moshi.Moshi;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: RecentsRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J<\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/datasource/RecentsRemoteDataSource;", "", "recentsRequest", "Lcom/box/android/data/api/requests/RecentsRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/RecentsRequest;Lcom/squareup/moshi/Moshi;)V", "addToRecents", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/errors/RemoteError;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "interactionType", "Lcom/box/android/domain/usecases/InteractionType;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "password", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/usecases/InteractionType;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentsRemoteDataSource {
    private final Moshi moshi;
    private final RecentsRequest recentsRequest;

    /* JADX INFO: renamed from: com.box.android.data.datasource.RecentsRemoteDataSource$addToRecents$1, reason: invalid class name */
    /* JADX INFO: compiled from: RecentsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.RecentsRemoteDataSource", f = "RecentsRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {36}, m = "addToRecents", n = {"remoteId", "interactionType", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "password", "shareLinkHeader", "$i$f$resultOf", "$i$a$-resultOf-RecentsRemoteDataSource$addToRecents$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecentsRemoteDataSource.this.addToRecents(null, null, null, null, this);
        }
    }

    @Inject
    public RecentsRemoteDataSource(RecentsRequest recentsRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(recentsRequest, "recentsRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.recentsRequest = recentsRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object addToRecents(ItemId.Remote remote, InteractionType interactionType, String str, String str2, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str3 = String.format("shared_link=%s", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                if (!TextUtils.isEmpty(str2)) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String str4 = String.format("&shared_link_password=%s", Arrays.copyOf(new Object[]{str2}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    str3 = str3 + str4;
                }
                RecentsRequest recentsRequest = this.recentsRequest;
                AddToRecentsDTO addToRecentsDTO = new AddToRecentsDTO(new ItemIdDTO(remote.getBoxId(), remote.getType()), interactionType.getValue());
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(remote);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(interactionType);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(str3);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                if (recentsRequest.addToRecents(addToRecentsDTO, str3, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
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
