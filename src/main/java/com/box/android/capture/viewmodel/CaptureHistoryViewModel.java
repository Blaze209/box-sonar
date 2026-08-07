package com.box.android.capture.viewmodel;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.box.android.base.vm.BaseListingViewModel;
import com.box.android.capture.R;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.data.jobs.JobWorker;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.usecases.capture.CaptureHistoryUseCase;
import com.box.android.domain.usecases.capture.DeleteCaptureHistoryUseCase;
import com.box.android.domain.utils.result.Result;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CaptureHistoryViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0096@¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001dJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$J\u001e\u0010%\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020$2\u0006\u0010#\u001a\u00020$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\b\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006'"}, d2 = {"Lcom/box/android/capture/viewmodel/CaptureHistoryViewModel;", "Lcom/box/android/base/vm/BaseListingViewModel;", "captureHistoryInteractor", "Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;", "deleteCaptureHistoryUseCase", "Lcom/box/android/domain/usecases/capture/DeleteCaptureHistoryUseCase;", "<init>", "(Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;Lcom/box/android/domain/usecases/capture/DeleteCaptureHistoryUseCase;)V", "setupCaptureHistory", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "", "Lcom/box/android/domain/models/CaptureHistoryModel;", "pendingJobs", "getPendingJobs", "()Landroidx/lifecycle/LiveData;", "uploadedFiles", "getUploadedFiles", "errorHelper", "Lcom/box/android/common/utilities/ErrorEvent;", "error", "Lcom/box/android/domain/models/DomainError;", "fetchItems", "Lcom/box/android/domain/utils/result/Result;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCaptureHistoryItems", "", "selectedJobs", "", "retryAllFailedJobs", "retryJob", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "changeFolderForNonRunningJobsAndRetry", "folderId", "Lcom/box/android/domain/models/ItemId;", "changeParentFolderOfJobAndRetry", "itemId", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureHistoryViewModel extends BaseListingViewModel {
    public static final int $stable = 8;
    private final CaptureHistoryUseCase captureHistoryInteractor;
    private final DeleteCaptureHistoryUseCase deleteCaptureHistoryUseCase;
    private final LiveData<List<CaptureHistoryModel>> pendingJobs;
    private final LiveData<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>> setupCaptureHistory;
    private final LiveData<List<CaptureHistoryModel>> uploadedFiles;

    @Override // com.box.android.base.vm.BaseListingViewModel
    public Object fetchItems(Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        return null;
    }

    @Inject
    public CaptureHistoryViewModel(CaptureHistoryUseCase captureHistoryInteractor, DeleteCaptureHistoryUseCase deleteCaptureHistoryUseCase) {
        Intrinsics.checkNotNullParameter(captureHistoryInteractor, "captureHistoryInteractor");
        Intrinsics.checkNotNullParameter(deleteCaptureHistoryUseCase, "deleteCaptureHistoryUseCase");
        this.captureHistoryInteractor = captureHistoryInteractor;
        this.deleteCaptureHistoryUseCase = deleteCaptureHistoryUseCase;
        LiveData<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>> liveDataLiveData$default = CoroutineLiveDataKt.liveData$default(ViewModelKt.getViewModelScope(this).getCoroutineContext(), 0L, new CaptureHistoryViewModel$setupCaptureHistory$1(this, null), 2, (Object) null);
        this.setupCaptureHistory = liveDataLiveData$default;
        this.pendingJobs = Transformations.map(liveDataLiveData$default, new Function1() { // from class: com.box.android.capture.viewmodel.CaptureHistoryViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryViewModel.pendingJobs$lambda$0((Pair) obj);
            }
        });
        this.uploadedFiles = Transformations.map(liveDataLiveData$default, new Function1() { // from class: com.box.android.capture.viewmodel.CaptureHistoryViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryViewModel.uploadedFiles$lambda$0((Pair) obj);
            }
        });
    }

    public final LiveData<List<CaptureHistoryModel>> getPendingJobs() {
        return this.pendingJobs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List pendingJobs$lambda$0(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        return CollectionsKt.sortedWith((List) pair.component1(), new Comparator() { // from class: com.box.android.capture.viewmodel.CaptureHistoryViewModel$pendingJobs$lambda$0$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((CaptureHistoryModel) t2).getFileModel().getContentCreatedDate(), ((CaptureHistoryModel) t).getFileModel().getContentCreatedDate());
            }
        });
    }

    public final LiveData<List<CaptureHistoryModel>> getUploadedFiles() {
        return this.uploadedFiles;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List uploadedFiles$lambda$0(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        return CollectionsKt.sortedWith((List) pair.component2(), new Comparator() { // from class: com.box.android.capture.viewmodel.CaptureHistoryViewModel$uploadedFiles$lambda$0$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((CaptureHistoryModel) t2).getFileModel().getContentCreatedDate(), ((CaptureHistoryModel) t).getFileModel().getContentCreatedDate());
            }
        });
    }

    @Override // com.box.android.base.vm.BaseListingViewModel
    protected ErrorEvent errorHelper(DomainError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new ErrorEvent.Toast(R.string.box_sharesdk_generic_error, new String[0]);
    }

    /* JADX INFO: renamed from: com.box.android.capture.viewmodel.CaptureHistoryViewModel$deleteCaptureHistoryItems$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryViewModel$deleteCaptureHistoryItems$1", f = "CaptureHistoryViewModel.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09971 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<CaptureHistoryModel> $selectedJobs;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09971(Set<CaptureHistoryModel> set, Continuation<? super C09971> continuation) {
            super(2, continuation);
            this.$selectedJobs = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureHistoryViewModel.this.new C09971(this.$selectedJobs, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09971) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = CaptureHistoryViewModel.this.deleteCaptureHistoryUseCase.deleteCaptureHistoryItems(this.$selectedJobs, this);
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
            CaptureHistoryViewModel captureHistoryViewModel = CaptureHistoryViewModel.this;
            if (!(result instanceof Result.Success)) {
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                captureHistoryViewModel.get_errorLiveData().setValue(captureHistoryViewModel.errorHelper((DomainError) ((Result.Error) result).getValue()));
            }
            return Unit.INSTANCE;
        }
    }

    public final void deleteCaptureHistoryItems(Set<CaptureHistoryModel> selectedJobs) {
        Intrinsics.checkNotNullParameter(selectedJobs, "selectedJobs");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09971(selectedJobs, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.viewmodel.CaptureHistoryViewModel$retryAllFailedJobs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryViewModel$retryAllFailedJobs$1", f = "CaptureHistoryViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {66}, m = "invokeSuspend", n = {"$this$filter$iv", "$this$filterTo$iv$iv", "destination$iv$iv", "element$iv$iv", "it", "$i$f$filter", "$i$f$filterTo", "$i$a$-filter-CaptureHistoryViewModel$retryAllFailedJobs$1$1"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 1)
    static final class C09981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        C09981(Continuation<? super C09981> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureHistoryViewModel.this.new C09981(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0066  */
        /* JADX WARN: Code duplicated, block: B:17:0x0073  */
        /* JADX WARN: Code duplicated, block: B:26:0x00ac  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0071 -> B:24:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0077 -> B:24:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a0 -> B:23:0x00a3). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 239
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.viewmodel.CaptureHistoryViewModel.C09981.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void retryAllFailedJobs() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09981(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.viewmodel.CaptureHistoryViewModel$retryJob$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryViewModel$retryJob$1", f = "CaptureHistoryViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobId $jobId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09991(JobId jobId, Continuation<? super C09991> continuation) {
            super(2, continuation);
            this.$jobId = jobId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureHistoryViewModel.this.new C09991(this.$jobId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CaptureHistoryViewModel.this.captureHistoryInteractor.retryJob(this.$jobId, this) == coroutine_suspended) {
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

    public final void retryJob(JobId jobId) {
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09991(jobId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.viewmodel.CaptureHistoryViewModel$changeFolderForNonRunningJobsAndRetry$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryViewModel$changeFolderForNonRunningJobsAndRetry$1", f = "CaptureHistoryViewModel.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId $folderId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ItemId itemId, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$folderId = itemId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureHistoryViewModel.this.new AnonymousClass1(this.$folderId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CaptureHistoryViewModel.this.captureHistoryInteractor.changeParentFolderForNonRunningJobsAndRetry(this.$folderId, this) == coroutine_suspended) {
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

    public final void changeFolderForNonRunningJobsAndRetry(ItemId folderId) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(folderId, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.capture.viewmodel.CaptureHistoryViewModel$changeParentFolderOfJobAndRetry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptureHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryViewModel$changeParentFolderOfJobAndRetry$1", f = "CaptureHistoryViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ItemId $folderId;
        final /* synthetic */ ItemId $itemId;
        final /* synthetic */ JobId $jobId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09961(JobId jobId, ItemId itemId, ItemId itemId2, Continuation<? super C09961> continuation) {
            super(2, continuation);
            this.$jobId = jobId;
            this.$itemId = itemId;
            this.$folderId = itemId2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureHistoryViewModel.this.new C09961(this.$jobId, this.$itemId, this.$folderId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (CaptureHistoryViewModel.this.captureHistoryInteractor.changeParentFolderOfJobAndRetry(this.$jobId, this.$itemId, this.$folderId, this) == coroutine_suspended) {
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

    public final void changeParentFolderOfJobAndRetry(JobId jobId, ItemId itemId, ItemId folderId) {
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C09961(jobId, itemId, folderId, null), 3, null);
    }
}
