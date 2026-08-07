package com.box.android.domain.usecases.fileactivities;

import androidx.paging.DataSource;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.services.IFileActivitiesService;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: GetFileActivitiesInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010\fJ(\u0010\r\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012\u0004\u0012\u00020\t0\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J&\u0010\u0013\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0004\u0012\u00020\t0\u00070\u00142\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/domain/usecases/fileactivities/GetFileActivitiesInteractor;", "", "fileActivitiesService", "Lcom/box/android/domain/services/IFileActivitiesService;", "<init>", "(Lcom/box/android/domain/services/IFileActivitiesService;)V", "refreshFileActivities", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "fileItemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileActivities", "Landroidx/paging/DataSource$Factory;", "", "Lcom/box/android/domain/models/annotations/FileActivityModel;", "fileId", "", "getFileActivitiesV2", "Lkotlinx/coroutines/flow/Flow;", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetFileActivitiesInteractor {
    private final IFileActivitiesService fileActivitiesService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.GetFileActivitiesInteractor$refreshFileActivities$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetFileActivitiesInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.GetFileActivitiesInteractor", f = "GetFileActivitiesInteractor.kt", i = {0, 0, 0}, l = {15}, m = "refreshFileActivities", n = {"fileItemId", "it", "$i$a$-let-GetFileActivitiesInteractor$refreshFileActivities$2"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
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
            return GetFileActivitiesInteractor.this.refreshFileActivities(null, this);
        }
    }

    @Inject
    public GetFileActivitiesInteractor(IFileActivitiesService fileActivitiesService) {
        Intrinsics.checkNotNullParameter(fileActivitiesService, "fileActivitiesService");
        this.fileActivitiesService = fileActivitiesService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object refreshFileActivities(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
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
        Object objFetchActivitiesFromRemote = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchActivitiesFromRemote);
            if (itemId != null) {
                IFileActivitiesService iFileActivitiesService = this.fileActivitiesService;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId);
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                objFetchActivitiesFromRemote = iFileActivitiesService.fetchActivitiesFromRemote(itemId, anonymousClass1);
                if (objFetchActivitiesFromRemote == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return new Result.Error(new DomainError.NoResultFoundError(null, 1, null));
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = anonymousClass1.I$0;
        ResultKt.throwOnFailure(objFetchActivitiesFromRemote);
        Result result = (Result) objFetchActivitiesFromRemote;
        if (result != null) {
            return result;
        }
        return new Result.Error(new DomainError.NoResultFoundError(null, 1, null));
    }

    public final Result<DataSource.Factory<Integer, FileActivityModel>, DomainError> getFileActivities(String fileId) {
        Result<DataSource.Factory<Integer, FileActivityModel>, DomainError> resultActivities;
        return (fileId == null || (resultActivities = this.fileActivitiesService.activities(fileId)) == null) ? new Result.Error(new DomainError.NoResultFoundError(null, 1, null)) : resultActivities;
    }

    public final Flow<Result<List<FileActivityModel>, DomainError>> getFileActivitiesV2(ItemId fileItemId) {
        Intrinsics.checkNotNullParameter(fileItemId, "fileItemId");
        return this.fileActivitiesService.activitiesV2(fileItemId);
    }
}
