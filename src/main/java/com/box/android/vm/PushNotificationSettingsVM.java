package com.box.android.vm;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.coreservices.models.ui.pushnotifications.PushNotificationCategoriesUIModel;
import com.box.android.domain.models.pushnotifications.NotificationCategoriesModel;
import com.box.android.domain.models.pushnotifications.NotificationCategory;
import com.box.android.domain.usecases.pushnotifications.NotificationCategoriesUseCase;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: PushNotificationSettingsVM.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00160\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/vm/PushNotificationSettingsVM;", "Landroidx/lifecycle/ViewModel;", "notificationCategoriesUseCase", "Lcom/box/android/domain/usecases/pushnotifications/NotificationCategoriesUseCase;", "<init>", "(Lcom/box/android/domain/usecases/pushnotifications/NotificationCategoriesUseCase;)V", "mutableErrorLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/box/android/common/utilities/ErrorEvent;", "errorLiveData", "Landroidx/lifecycle/LiveData;", "getErrorLiveData", "()Landroidx/lifecycle/LiveData;", "categories", "Lcom/box/android/coreservices/models/ui/pushnotifications/PushNotificationCategoriesUIModel;", "getCategories", "fetchCategoriesFromRemote", "", "updateNotificationCategory", "category", "Lcom/box/android/domain/models/pushnotifications/NotificationCategory;", "enabled", "", "categoryMap", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PushNotificationSettingsVM extends ViewModel {
    public static final int $stable = 8;
    private final LiveData<PushNotificationCategoriesUIModel> categories;
    private final MutableLiveData<ErrorEvent> mutableErrorLiveData;
    private final NotificationCategoriesUseCase notificationCategoriesUseCase;

    @Inject
    public PushNotificationSettingsVM(NotificationCategoriesUseCase notificationCategoriesUseCase) {
        Intrinsics.checkNotNullParameter(notificationCategoriesUseCase, "notificationCategoriesUseCase");
        this.notificationCategoriesUseCase = notificationCategoriesUseCase;
        this.mutableErrorLiveData = new MutableLiveData<>();
        final Flow<NotificationCategoriesModel> flowNotificationCategories = notificationCategoriesUseCase.notificationCategories();
        this.categories = FlowLiveDataConversions.asLiveData$default(new Flow<PushNotificationCategoriesUIModel>() { // from class: com.box.android.vm.PushNotificationSettingsVM$special$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.vm.PushNotificationSettingsVM$special$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.vm.PushNotificationSettingsVM$special$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.vm.PushNotificationSettingsVM$special$$inlined$map$1$2", f = "PushNotificationSettingsVM.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        NotificationCategoriesModel notificationCategoriesModel = (NotificationCategoriesModel) obj;
                        PushNotificationCategoriesUIModel pushNotificationCategoriesUIModel = new PushNotificationCategoriesUIModel(notificationCategoriesModel.getComment(), notificationCategoriesModel.getCollaborationInvite(), notificationCategoriesModel.getEdit(), notificationCategoriesModel.getUpload());
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(pushNotificationCategoriesUIModel, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super PushNotificationCategoriesUIModel> flowCollector, Continuation continuation) {
                Object objCollect = flowNotificationCategories.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, (CoroutineContext) null, 0L, 3, (Object) null);
    }

    public final LiveData<ErrorEvent> getErrorLiveData() {
        return this.mutableErrorLiveData;
    }

    public final LiveData<PushNotificationCategoriesUIModel> getCategories() {
        return this.categories;
    }

    /* JADX INFO: renamed from: com.box.android.vm.PushNotificationSettingsVM$fetchCategoriesFromRemote$1, reason: invalid class name */
    /* JADX INFO: compiled from: PushNotificationSettingsVM.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.vm.PushNotificationSettingsVM$fetchCategoriesFromRemote$1", f = "PushNotificationSettingsVM.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PushNotificationSettingsVM.this.new AnonymousClass1(continuation);
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
                if (PushNotificationSettingsVM.this.notificationCategoriesUseCase.fetchNotificationCategoriesFromRemote(this) == coroutine_suspended) {
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

    public final void fetchCategoriesFromRemote() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.vm.PushNotificationSettingsVM$updateNotificationCategory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PushNotificationSettingsVM.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.vm.PushNotificationSettingsVM$updateNotificationCategory$1", f = "PushNotificationSettingsVM.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C17301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NotificationCategory $category;
        final /* synthetic */ boolean $enabled;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C17301(NotificationCategory notificationCategory, boolean z, Continuation<? super C17301> continuation) {
            super(2, continuation);
            this.$category = notificationCategory;
            this.$enabled = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PushNotificationSettingsVM.this.new C17301(this.$category, this.$enabled, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C17301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PushNotificationSettingsVM.this.notificationCategoriesUseCase.updateNotificationCategories(MapsKt.mapOf(TuplesKt.to(this.$category, Boxing.boxBoolean(this.$enabled))), this) == coroutine_suspended) {
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

    public final void updateNotificationCategory(NotificationCategory category, boolean enabled) {
        Intrinsics.checkNotNullParameter(category, "category");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C17301(category, enabled, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.vm.PushNotificationSettingsVM$updateNotificationCategory$2, reason: invalid class name */
    /* JADX INFO: compiled from: PushNotificationSettingsVM.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.vm.PushNotificationSettingsVM$updateNotificationCategory$2", f = "PushNotificationSettingsVM.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<NotificationCategory, Boolean> $categoryMap;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Map<NotificationCategory, Boolean> map, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$categoryMap = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PushNotificationSettingsVM.this.new AnonymousClass2(this.$categoryMap, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (PushNotificationSettingsVM.this.notificationCategoriesUseCase.updateNotificationCategories(this.$categoryMap, this) == coroutine_suspended) {
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

    public final void updateNotificationCategory(Map<NotificationCategory, Boolean> categoryMap) {
        Intrinsics.checkNotNullParameter(categoryMap, "categoryMap");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(categoryMap, null), 3, null);
    }
}
