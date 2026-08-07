package com.box.android.capture.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.JobInfosSummary;
import com.box.android.domain.services.ICaptureThumbnailService;
import com.box.android.domain.usecases.capture.CaptureHistoryUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: compiled from: CaptureHistoryButtonViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\b\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel;", "Landroidx/lifecycle/ViewModel;", "captureHistoryInteractor", "Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;", "captureThumbnailService", "Lcom/box/android/domain/services/ICaptureThumbnailService;", "<init>", "(Lcom/box/android/domain/usecases/capture/CaptureHistoryUseCase;Lcom/box/android/domain/services/ICaptureThumbnailService;)V", "setupCaptureHistory", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "", "Lcom/box/android/domain/models/CaptureHistoryModel;", "jobInfosSummary", "Lcom/box/android/domain/models/JobInfosSummary;", "getJobInfosSummary", "()Landroidx/lifecycle/LiveData;", "lastCaptureThumbnail", "Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel$CaptureThumbnailResource;", "getLastCaptureThumbnail", "CaptureThumbnailResource", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureHistoryButtonViewModel extends ViewModel {
    public static final int $stable = 8;
    private final CaptureHistoryUseCase captureHistoryInteractor;
    private final ICaptureThumbnailService captureThumbnailService;
    private final LiveData<JobInfosSummary> jobInfosSummary;
    private final LiveData<CaptureThumbnailResource> lastCaptureThumbnail;
    private final LiveData<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>> setupCaptureHistory;

    @Inject
    public CaptureHistoryButtonViewModel(CaptureHistoryUseCase captureHistoryInteractor, ICaptureThumbnailService captureThumbnailService) {
        Intrinsics.checkNotNullParameter(captureHistoryInteractor, "captureHistoryInteractor");
        Intrinsics.checkNotNullParameter(captureThumbnailService, "captureThumbnailService");
        this.captureHistoryInteractor = captureHistoryInteractor;
        this.captureThumbnailService = captureThumbnailService;
        LiveData<Pair<List<CaptureHistoryModel>, List<CaptureHistoryModel>>> liveDataLiveData$default = CoroutineLiveDataKt.liveData$default(ViewModelKt.getViewModelScope(this).getCoroutineContext(), 0L, new CaptureHistoryButtonViewModel$setupCaptureHistory$1(this, null), 2, (Object) null);
        this.setupCaptureHistory = liveDataLiveData$default;
        this.jobInfosSummary = Transformations.switchMap(liveDataLiveData$default, new Function1() { // from class: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryButtonViewModel.jobInfosSummary$lambda$0(this.f$0, (Pair) obj);
            }
        });
        this.lastCaptureThumbnail = Transformations.switchMap(liveDataLiveData$default, new Function1() { // from class: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryButtonViewModel.lastCaptureThumbnail$lambda$0(this.f$0, (Pair) obj);
            }
        });
    }

    public final LiveData<JobInfosSummary> getJobInfosSummary() {
        return this.jobInfosSummary;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData jobInfosSummary$lambda$0(CaptureHistoryButtonViewModel captureHistoryButtonViewModel, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        final List list = (List) pair.component1();
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            JobInfo jobInfo = ((CaptureHistoryModel) it.next()).getJobInfo();
            Intrinsics.checkNotNull(jobInfo);
            arrayList.add(jobInfo.getStatus());
        }
        final Flow[] flowArr = (Flow[]) CollectionsKt.toList(arrayList).toArray(new Flow[0]);
        return FlowLiveDataConversions.asLiveData(FlowKt.onEmpty(new Flow<JobInfosSummary>() { // from class: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$jobInfosSummary$lambda$0$$inlined$combine$1

            /* JADX INFO: renamed from: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$jobInfosSummary$lambda$0$$inlined$combine$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: Zip.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n¨\u0006\u0007"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$jobInfosSummary$lambda$0$$inlined$combine$1$3", f = "CaptureHistoryButtonViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2}, l = {BoxCommonConstants.REQUEST_RETRY_SHARED_LINK, 308, 288}, m = "invokeSuspend", n = {"$this$combineInternal", "it", "$completion", "it", "currJob", "$i$a$-combine-CaptureHistoryButtonViewModel$jobInfosSummary$1$2", "jobCount", "hasError", "$i$a$-sumOfDouble-CaptureHistoryButtonViewModel$jobInfosSummary$1$2$estimatedDone$1", "$this$combineInternal", "it", "$completion", "it", "currJob", "$i$a$-combine-CaptureHistoryButtonViewModel$jobInfosSummary$1$2", "jobCount", "hasError", "$i$a$-sumOfDouble-CaptureHistoryButtonViewModel$jobInfosSummary$1$2$estimatedTotal$1", "estimatedDone", "$this$combineInternal", "it"}, s = {"L$0", "L$1", "L$3", "L$4", "L$6", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$3", "L$4", "L$6", "I$0", "I$1", "I$2", "I$3", "D$1", "L$0", "L$1"}, v = 1)
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super JobInfosSummary>, JobInfo.Status[], Continuation<? super Unit>, Object> {
                final /* synthetic */ List $jobs$inlined;
                double D$0;
                double D$1;
                int I$0;
                int I$1;
                int I$2;
                int I$3;
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                Object L$5;
                Object L$6;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(Continuation continuation, List list) {
                    super(3, continuation);
                    this.$jobs$inlined = list;
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(FlowCollector<? super JobInfosSummary> flowCollector, JobInfo.Status[] statusArr, Continuation<? super Unit> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation, this.$jobs$inlined);
                    anonymousClass3.L$0 = flowCollector;
                    anonymousClass3.L$1 = statusArr;
                    return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code duplicated, block: B:48:0x016d  */
                /* JADX WARN: Code duplicated, block: B:51:0x01b8  */
                /* JADX WARN: Code duplicated, block: B:54:0x01ca  */
                /* JADX WARN: Code duplicated, block: B:57:0x01dd  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0123 -> B:35:0x0127). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x01b8 -> B:52:0x01c4). Please report as a decompilation issue!!! */
                /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                    jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                    	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                    	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                    	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                    */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final java.lang.Object invokeSuspend(java.lang.Object r21) {
                    /*
                        Method dump skipped, instruction units count: 552
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$jobInfosSummary$lambda$0$$inlined$combine$1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super JobInfosSummary> flowCollector, Continuation continuation) {
                Flow[] flowArr2 = flowArr;
                final Flow[] flowArr3 = flowArr;
                Object objCombineInternal = CombineKt.combineInternal(flowCollector, flowArr2, new Function0<JobInfo.Status[]>() { // from class: com.box.android.capture.viewmodel.CaptureHistoryButtonViewModel$jobInfosSummary$lambda$0$$inlined$combine$1.2
                    @Override // kotlin.jvm.functions.Function0
                    public final JobInfo.Status[] invoke() {
                        return new JobInfo.Status[flowArr3.length];
                    }
                }, new AnonymousClass3(null, list), continuation);
                return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : Unit.INSTANCE;
            }
        }, new CaptureHistoryButtonViewModel$jobInfosSummary$1$3(null)), ViewModelKt.getViewModelScope(captureHistoryButtonViewModel).getCoroutineContext(), 0L);
    }

    public final LiveData<CaptureThumbnailResource> getLastCaptureThumbnail() {
        return this.lastCaptureThumbnail;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LiveData lastCaptureThumbnail$lambda$0(CaptureHistoryButtonViewModel captureHistoryButtonViewModel, Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<destruct>");
        return CoroutineLiveDataKt.liveData$default(ViewModelKt.getViewModelScope(captureHistoryButtonViewModel).getCoroutineContext(), 0L, new CaptureHistoryButtonViewModel$lastCaptureThumbnail$1$1((List) pair.component1(), (List) pair.component2(), captureHistoryButtonViewModel, null), 2, (Object) null);
    }

    /* JADX INFO: compiled from: CaptureHistoryButtonViewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel$CaptureThumbnailResource;", "", "<init>", "()V", "ThumbnailUrl", "ThumbnailResourceId", "Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel$CaptureThumbnailResource$ThumbnailResourceId;", "Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel$CaptureThumbnailResource$ThumbnailUrl;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class CaptureThumbnailResource {
        public static final int $stable = 0;

        public /* synthetic */ CaptureThumbnailResource(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CaptureHistoryButtonViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel$CaptureThumbnailResource$ThumbnailUrl;", "Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel$CaptureThumbnailResource;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ThumbnailUrl extends CaptureThumbnailResource {
            public static final int $stable = 0;
            private final String url;

            public static /* synthetic */ ThumbnailUrl copy$default(ThumbnailUrl thumbnailUrl, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = thumbnailUrl.url;
                }
                return thumbnailUrl.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final ThumbnailUrl copy(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new ThumbnailUrl(url);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ThumbnailUrl) && Intrinsics.areEqual(this.url, ((ThumbnailUrl) other).url);
            }

            public int hashCode() {
                return this.url.hashCode();
            }

            public String toString() {
                return "ThumbnailUrl(url=" + this.url + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThumbnailUrl(String url) {
                super(null);
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
            }

            public final String getUrl() {
                return this.url;
            }
        }

        private CaptureThumbnailResource() {
        }

        /* JADX INFO: compiled from: CaptureHistoryButtonViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel$CaptureThumbnailResource$ThumbnailResourceId;", "Lcom/box/android/capture/viewmodel/CaptureHistoryButtonViewModel$CaptureThumbnailResource;", "resourceId", "", "<init>", "(I)V", "getResourceId", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ThumbnailResourceId extends CaptureThumbnailResource {
            public static final int $stable = 0;
            private final int resourceId;

            public static /* synthetic */ ThumbnailResourceId copy$default(ThumbnailResourceId thumbnailResourceId, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = thumbnailResourceId.resourceId;
                }
                return thumbnailResourceId.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getResourceId() {
                return this.resourceId;
            }

            public final ThumbnailResourceId copy(int resourceId) {
                return new ThumbnailResourceId(resourceId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ThumbnailResourceId) && this.resourceId == ((ThumbnailResourceId) other).resourceId;
            }

            public int hashCode() {
                return Integer.hashCode(this.resourceId);
            }

            public String toString() {
                return "ThumbnailResourceId(resourceId=" + this.resourceId + ")";
            }

            public ThumbnailResourceId(int i) {
                super(null);
                this.resourceId = i;
            }

            public final int getResourceId() {
                return this.resourceId;
            }
        }
    }
}
