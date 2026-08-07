package com.box.android.data.service.impl.preview;

import com.box.android.data.utilities.FileModelFilter;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: Emitters.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¨\u0006\u0004"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.service.impl.preview.GalleryItemsService$filterOutItems$$inlined$transform$1", f = "GalleryItemsService.kt", i = {0}, l = {36}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
public final class GalleryItemsService$filterOutItems$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super List<? extends FileModel>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GalleryItemsService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GalleryItemsService$filterOutItems$$inlined$transform$1(Flow flow, Continuation continuation, GalleryItemsService galleryItemsService) {
        super(2, continuation);
        this.$this_transform = flow;
        this.this$0 = galleryItemsService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GalleryItemsService$filterOutItems$$inlined$transform$1 galleryItemsService$filterOutItems$$inlined$transform$1 = new GalleryItemsService$filterOutItems$$inlined$transform$1(this.$this_transform, continuation, this.this$0);
        galleryItemsService$filterOutItems$$inlined$transform$1.L$0 = obj;
        return galleryItemsService$filterOutItems$$inlined$transform$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super List<? extends FileModel>> flowCollector, Continuation<? super Unit> continuation) {
        return ((GalleryItemsService$filterOutItems$$inlined$transform$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.GalleryItemsService$filterOutItems$$inlined$transform$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Emitters.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<List<? extends FileModel>> $$this$flow;
        final /* synthetic */ GalleryItemsService this$0;

        /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.GalleryItemsService$filterOutItems$$inlined$transform$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.service.impl.preview.GalleryItemsService$filterOutItems$$inlined$transform$1$1", f = "GalleryItemsService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {66}, m = "emit", n = {"value", "$completion", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$filterOutItems_u24lambda_u240", "$this$onSuccess$iv", "itemModels", "fileModels", "$i$a$-transform-GalleryItemsService$filterOutItems$1", "$i$f$onSuccess", "$i$a$-onSuccess-GalleryItemsService$filterOutItems$1$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
        public static final class C01731 extends ContinuationImpl {
            int I$0;
            int I$1;
            int I$2;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            int label;
            /* synthetic */ Object result;

            public C01731(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return AnonymousClass1.this.emit(null, this);
            }
        }

        public AnonymousClass1(FlowCollector flowCollector, GalleryItemsService galleryItemsService) {
            this.this$0 = galleryItemsService;
            this.$$this$flow = flowCollector;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T t, Continuation<? super Unit> continuation) {
            C01731 c01731;
            if (continuation instanceof C01731) {
                c01731 = (C01731) continuation;
                if ((c01731.label & Integer.MIN_VALUE) != 0) {
                    c01731.label -= Integer.MIN_VALUE;
                } else {
                    c01731 = new C01731(continuation);
                }
            } else {
                c01731 = new C01731(continuation);
            }
            Object obj = c01731.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = c01731.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector<List<? extends FileModel>> flowCollector = this.$$this$flow;
                C01731 c01732 = c01731;
                Result result = (Result) t;
                if (result instanceof Result.Success) {
                    List list = (List) ((Result.Success) result).getValue();
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        FileModel fileModel = ItemModelKt.fileModel((ItemModel) it.next());
                        if (fileModel != null) {
                            arrayList.add(fileModel);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (T t2 : arrayList) {
                        FileModel fileModel2 = (FileModel) t2;
                        List<FileModelFilter> galleryFilters = this.this$0.getGalleryFilters();
                        if (!(galleryFilters instanceof Collection) || !galleryFilters.isEmpty()) {
                            Iterator<T> it2 = galleryFilters.iterator();
                            while (it2.hasNext()) {
                                if (((FileModelFilter) it2.next()).shouldAccept(fileModel2)) {
                                    arrayList2.add(t2);
                                    break;
                                }
                            }
                        }
                    }
                    ArrayList arrayList3 = arrayList2;
                    c01731.L$0 = SpillingKt.nullOutSpilledVariable(t);
                    c01731.L$1 = SpillingKt.nullOutSpilledVariable(c01732);
                    c01731.L$2 = SpillingKt.nullOutSpilledVariable(result);
                    c01731.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    c01731.L$4 = result;
                    c01731.L$5 = SpillingKt.nullOutSpilledVariable(list);
                    c01731.L$6 = SpillingKt.nullOutSpilledVariable(arrayList3);
                    c01731.I$0 = 0;
                    c01731.I$1 = 0;
                    c01731.I$2 = 0;
                    c01731.label = 1;
                    if (flowCollector.emit(arrayList3, c01731) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c01731.I$2;
                int i3 = c01731.I$1;
                int i4 = c01731.I$0;
                Object obj2 = c01731.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.label = 1;
            if (this.$this_transform.collect(new AnonymousClass1(flowCollector, this.this$0), this) == coroutine_suspended) {
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
