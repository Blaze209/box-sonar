package com.box.android.domain.usecases.pushnotifications;

import androidx.core.app.NotificationCompat;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.pushnotifications.PushDeviceModel;
import com.box.android.domain.services.IPushNotificationSettingsService;
import com.box.android.domain.utils.result.Result;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: UpdateDeviceRegistrationInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ0\u0010\u0006\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u001e\u0010\r\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0004\u0012\u00020\b0\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/usecases/pushnotifications/UpdateDeviceRegistrationInteractor;", "Lcom/box/android/domain/usecases/pushnotifications/UpdateDeviceRegistrationUseCase;", NotificationCompat.CATEGORY_SERVICE, "Lcom/box/android/domain/services/IPushNotificationSettingsService;", "<init>", "(Lcom/box/android/domain/services/IPushNotificationSettingsService;)V", "updateDeviceRegistration", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "deviceModel", "Lcom/box/android/domain/models/pushnotifications/PushDeviceModel;", "(Lcom/box/android/domain/models/pushnotifications/PushDeviceModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callback", "Lkotlin/Function1;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateDeviceRegistrationInteractor implements UpdateDeviceRegistrationUseCase {
    private final IPushNotificationSettingsService service;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationInteractor$updateDeviceRegistration$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateDeviceRegistrationInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationInteractor", f = "UpdateDeviceRegistrationInteractor.kt", i = {0}, l = {16}, m = "updateDeviceRegistration", n = {"deviceModel"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdateDeviceRegistrationInteractor.this.updateDeviceRegistration((PushDeviceModel) null, this);
        }
    }

    @Inject
    public UpdateDeviceRegistrationInteractor(IPushNotificationSettingsService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationUseCase
    public Object updateDeviceRegistration(PushDeviceModel pushDeviceModel, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
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
        Object objUpdateDeviceRegistration = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateDeviceRegistration);
            IPushNotificationSettingsService iPushNotificationSettingsService = this.service;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(pushDeviceModel);
            anonymousClass1.label = 1;
            objUpdateDeviceRegistration = iPushNotificationSettingsService.updateDeviceRegistration(pushDeviceModel, anonymousClass1);
            if (objUpdateDeviceRegistration == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateDeviceRegistration);
        }
        Result result = (Result) objUpdateDeviceRegistration;
        if (result instanceof Result.Success) {
            return new Result.Success(Unit.INSTANCE);
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationInteractor$updateDeviceRegistration$3, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateDeviceRegistrationInteractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationInteractor$updateDeviceRegistration$3", f = "UpdateDeviceRegistrationInteractor.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Unit, ? extends DomainError>, Unit> $callback;
        final /* synthetic */ PushDeviceModel $deviceModel;
        Object L$0;
        int label;
        final /* synthetic */ UpdateDeviceRegistrationInteractor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Function1<? super Result<Unit, ? extends DomainError>, Unit> function1, UpdateDeviceRegistrationInteractor updateDeviceRegistrationInteractor, PushDeviceModel pushDeviceModel, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.this$0 = updateDeviceRegistrationInteractor;
            this.$deviceModel = pushDeviceModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$callback, this.this$0, this.$deviceModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function1 function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Result<Unit, ? extends DomainError>, Unit> function2 = this.$callback;
                this.L$0 = function2;
                this.label = 1;
                Object objUpdateDeviceRegistration = this.this$0.updateDeviceRegistration(this.$deviceModel, this);
                if (objUpdateDeviceRegistration == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objUpdateDeviceRegistration;
                function1 = function2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            function1.invoke(obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.box.android.domain.usecases.pushnotifications.UpdateDeviceRegistrationUseCase
    public void updateDeviceRegistration(PushDeviceModel deviceModel, Function1<? super Result<Unit, ? extends DomainError>, Unit> callback) {
        Intrinsics.checkNotNullParameter(deviceModel, "deviceModel");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass3(callback, this, deviceModel, null), 3, null);
    }
}
