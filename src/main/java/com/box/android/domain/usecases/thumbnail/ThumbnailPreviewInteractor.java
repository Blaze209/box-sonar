package com.box.android.domain.usecases.thumbnail;

import android.graphics.Bitmap;
import com.box.android.common.prefetch.PrefetchCoordinator;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IThumbnailService;
import com.box.android.domain.utils.result.Result;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ThumbnailPreviewInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/domain/usecases/thumbnail/ThumbnailPreviewInteractor;", "Lcom/box/android/domain/usecases/thumbnail/ThumbnailPreviewUseCase;", "thumbnailService", "Lcom/box/android/domain/services/IThumbnailService;", "itemService", "Lcom/box/android/domain/services/ILocalItemService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/services/IThumbnailService;Lcom/box/android/domain/services/ILocalItemService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "prefetchCoordinator", "Lcom/box/android/common/prefetch/PrefetchCoordinator;", "Landroid/graphics/Bitmap;", "activeThumbnailJobs", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/box/android/domain/models/ItemId;", "Lkotlinx/coroutines/Job;", "prefetchThumbnail", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "getThumbnail", "Lkotlinx/coroutines/flow/Flow;", "cancelThumbnailUpdate", "itemId", "cancelPrefetch", "prefetchKey", "", "getThumbnailPathInternal", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ThumbnailPreviewInteractor implements ThumbnailPreviewUseCase {
    private final ConcurrentHashMap<ItemId, Job> activeThumbnailJobs;
    private final CoroutineDispatcher dispatcher;
    private final ILocalItemService itemService;
    private final PrefetchCoordinator<Bitmap> prefetchCoordinator;
    private final IThumbnailService thumbnailService;

    @Inject
    public ThumbnailPreviewInteractor(IThumbnailService thumbnailService, ILocalItemService itemService, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(thumbnailService, "thumbnailService");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.thumbnailService = thumbnailService;
        this.itemService = itemService;
        this.dispatcher = dispatcher;
        this.prefetchCoordinator = new PrefetchCoordinator<>(dispatcher);
        this.activeThumbnailJobs = new ConcurrentHashMap<>();
    }

    @Override // com.box.android.domain.usecases.thumbnail.ThumbnailPreviewUseCase
    public void prefetchThumbnail(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        this.prefetchCoordinator.store(prefetchKey(fileModel.getItemId()), getThumbnailPathInternal(fileModel));
    }

    @Override // com.box.android.domain.usecases.thumbnail.ThumbnailPreviewUseCase
    public Flow<Bitmap> getThumbnail(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Flow<Bitmap> flowConsume = this.prefetchCoordinator.consume(prefetchKey(fileModel.getItemId()));
        return flowConsume == null ? getThumbnailPathInternal(fileModel) : flowConsume;
    }

    @Override // com.box.android.domain.usecases.thumbnail.ThumbnailPreviewUseCase
    public void cancelThumbnailUpdate(ItemId itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Job jobRemove = this.activeThumbnailJobs.remove(itemId);
        if (jobRemove != null) {
            Job.DefaultImpls.cancel$default(jobRemove, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.box.android.domain.usecases.thumbnail.ThumbnailPreviewUseCase
    public void cancelPrefetch(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        this.prefetchCoordinator.cancelPrefetch(prefetchKey(fileModel.getItemId()));
    }

    private final String prefetchKey(ItemId itemId) {
        return itemId.toString();
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.thumbnail.ThumbnailPreviewInteractor$getThumbnailPathInternal$1, reason: invalid class name */
    /* JADX INFO: compiled from: ThumbnailPreviewInteractor.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroid/graphics/Bitmap;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.thumbnail.ThumbnailPreviewInteractor$getThumbnailPathInternal$1", f = "ThumbnailPreviewInteractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {60, 61, 67}, m = "invokeSuspend", n = {"$this$flow", "job", "itemId", "previous", "$this$flow", "job", "itemId", "previous", "initialPath", "$this$flow", "job", "itemId", "previous", "lastFileModel"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Bitmap>, Continuation<? super Unit>, Object> {
        final /* synthetic */ FileModel $fileModel;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ ThumbnailPreviewInteractor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FileModel fileModel, ThumbnailPreviewInteractor thumbnailPreviewInteractor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$fileModel = fileModel;
            this.this$0 = thumbnailPreviewInteractor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$fileModel, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Bitmap> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:49:0x0137  */
        /* JADX WARN: Type inference failed for: r5v5, types: [T, com.box.android.domain.models.item.FileModel] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Job job;
            ItemId itemId;
            Job job2;
            Job job3;
            Job job4;
            Throwable th;
            ItemId itemId2;
            Job job5;
            ItemId itemId3;
            Job job6;
            Job job7;
            Ref.ObjectRef objectRef;
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i != 1) {
                        if (i == 2) {
                            job6 = (Job) this.L$3;
                            itemId3 = (ItemId) this.L$2;
                            job7 = (Job) this.L$1;
                            try {
                                ResultKt.throwOnFailure(obj);
                                job2 = job6;
                                itemId = itemId3;
                                job = job7;
                                objectRef = new Ref.ObjectRef();
                                objectRef.element = this.$fileModel;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                this.L$1 = job;
                                this.L$2 = itemId;
                                this.L$3 = SpillingKt.nullOutSpilledVariable(job2);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(objectRef);
                                this.label = 3;
                                if (this.this$0.itemService.observeItem(this.$fileModel.getItemId(), DataPolicy.CACHE).collect(new C01751(objectRef, flowCollector, this.this$0), this) != coroutine_suspended) {
                                    job5 = job;
                                    itemId2 = itemId;
                                }
                                return coroutine_suspended;
                            } catch (Throwable th2) {
                                th = th2;
                                itemId2 = itemId3;
                                job5 = job7;
                            }
                        } else {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            itemId2 = (ItemId) this.L$2;
                            job5 = (Job) this.L$1;
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        this.this$0.activeThumbnailJobs.remove(itemId2, job5);
                        throw th;
                    }
                    Job job8 = (Job) this.L$3;
                    ItemId itemId4 = (ItemId) this.L$2;
                    job3 = (Job) this.L$1;
                    try {
                        ResultKt.throwOnFailure(obj);
                        job4 = job8;
                        itemId = itemId4;
                    } catch (Throwable th4) {
                        th = th4;
                        itemId2 = itemId4;
                        job5 = job3;
                        this.this$0.activeThumbnailJobs.remove(itemId2, job5);
                        throw th;
                    }
                    this.this$0.activeThumbnailJobs.remove(itemId2, job5);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                job = (Job) getContext().get(Job.INSTANCE);
                if (job == null) {
                    return Unit.INSTANCE;
                }
                itemId = this.$fileModel.getItemId();
                job2 = (Job) this.this$0.activeThumbnailJobs.put(itemId, job);
                if (job2 != null && job2 != job) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                try {
                    if (!FileModel.INSTANCE.isWatermarked(this.$fileModel)) {
                        this.L$0 = flowCollector;
                        this.L$1 = job;
                        this.L$2 = itemId;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(job2);
                        this.label = 1;
                        Object bestThumbnail = this.this$0.thumbnailService.getBestThumbnail(this.$fileModel, this);
                        if (bestThumbnail != coroutine_suspended) {
                            job3 = job;
                            obj = bestThumbnail;
                            job4 = job2;
                        }
                    } else {
                        objectRef = new Ref.ObjectRef();
                        objectRef.element = this.$fileModel;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.L$1 = job;
                        this.L$2 = itemId;
                        this.L$3 = SpillingKt.nullOutSpilledVariable(job2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(objectRef);
                        this.label = 3;
                        if (this.this$0.itemService.observeItem(this.$fileModel.getItemId(), DataPolicy.CACHE).collect(new C01751(objectRef, flowCollector, this.this$0), this) != coroutine_suspended) {
                            job5 = job;
                            itemId2 = itemId;
                            this.this$0.activeThumbnailJobs.remove(itemId2, job5);
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                } catch (Throwable th5) {
                    job5 = job;
                    th = th5;
                    itemId2 = itemId;
                }
                Bitmap bitmap = (Bitmap) obj;
                this.L$0 = flowCollector;
                this.L$1 = job3;
                this.L$2 = itemId;
                this.L$3 = SpillingKt.nullOutSpilledVariable(job4);
                this.L$4 = SpillingKt.nullOutSpilledVariable(bitmap);
                this.label = 2;
                if (flowCollector.emit(bitmap, this) != coroutine_suspended) {
                    itemId3 = itemId;
                    job6 = job4;
                    job7 = job3;
                    job2 = job6;
                    itemId = itemId3;
                    job = job7;
                    objectRef = new Ref.ObjectRef();
                    objectRef.element = this.$fileModel;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.L$1 = job;
                    this.L$2 = itemId;
                    this.L$3 = SpillingKt.nullOutSpilledVariable(job2);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(objectRef);
                    this.label = 3;
                    if (this.this$0.itemService.observeItem(this.$fileModel.getItemId(), DataPolicy.CACHE).collect(new C01751(objectRef, flowCollector, this.this$0), this) != coroutine_suspended) {
                        job5 = job;
                        itemId2 = itemId;
                        this.this$0.activeThumbnailJobs.remove(itemId2, job5);
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            } catch (Throwable th6) {
                th = th6;
                itemId2 = itemId;
                job5 = job3;
                this.this$0.activeThumbnailJobs.remove(itemId2, job5);
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.box.android.domain.usecases.thumbnail.ThumbnailPreviewInteractor$getThumbnailPathInternal$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ThumbnailPreviewInteractor.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final class C01751<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<Bitmap> $$this$flow;
            final /* synthetic */ Ref.ObjectRef<FileModel> $lastFileModel;
            final /* synthetic */ ThumbnailPreviewInteractor this$0;

            /* JADX WARN: Multi-variable type inference failed */
            C01751(Ref.ObjectRef<FileModel> objectRef, FlowCollector<? super Bitmap> flowCollector, ThumbnailPreviewInteractor thumbnailPreviewInteractor) {
                this.$lastFileModel = objectRef;
                this.$$this$flow = flowCollector;
                this.this$0 = thumbnailPreviewInteractor;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:49:0x0131, code lost:
            
                if (r13.emit(r15, r0) == r1) goto L55;
             */
            /* JADX WARN: Code restructure failed: missing block: B:54:0x0151, code lost:
            
                if (r13.emit(null, r0) == r1) goto L55;
             */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.box.android.domain.utils.result.Result<? extends com.box.android.domain.models.item.ItemModel, ? extends com.box.android.domain.models.DomainError> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
                /*
                    Method dump skipped, instruction units count: 343
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.thumbnail.ThumbnailPreviewInteractor.AnonymousClass1.C01751.emit(com.box.android.domain.utils.result.Result, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Result<? extends ItemModel, ? extends DomainError>) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    private final Flow<Bitmap> getThumbnailPathInternal(FileModel fileModel) {
        return FlowKt.flowOn(FlowKt.flow(new AnonymousClass1(fileModel, this, null)), this.dispatcher);
    }
}
