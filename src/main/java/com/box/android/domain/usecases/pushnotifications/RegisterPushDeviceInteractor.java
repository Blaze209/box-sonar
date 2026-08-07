package com.box.android.domain.usecases.pushnotifications;

import androidx.core.app.NotificationCompat;
import com.box.android.domain.models.DomainError;
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

/* JADX INFO: compiled from: RegisterPushDeviceInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\rJ8\u0010\u0006\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u001e\u0010\u000e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0004\u0012\u00020\b0\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/domain/usecases/pushnotifications/RegisterPushDeviceInteractor;", "Lcom/box/android/domain/usecases/pushnotifications/RegisterPushDeviceUseCase;", NotificationCompat.CATEGORY_SERVICE, "Lcom/box/android/domain/services/IPushNotificationSettingsService;", "<init>", "(Lcom/box/android/domain/services/IPushNotificationSettingsService;)V", "registerPushDevice", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "deviceToken", "", "language", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callback", "Lkotlin/Function1;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RegisterPushDeviceInteractor implements RegisterPushDeviceUseCase {
    private final IPushNotificationSettingsService service;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceInteractor$registerPushDevice$1, reason: invalid class name */
    /* JADX INFO: compiled from: RegisterPushDeviceInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceInteractor", f = "RegisterPushDeviceInteractor.kt", i = {0, 0}, l = {14}, m = "registerPushDevice", n = {"deviceToken", "language"}, s = {"L$0", "L$1"}, v = 1)
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
            return RegisterPushDeviceInteractor.this.registerPushDevice((String) null, (String) null, this);
        }
    }

    @Inject
    public RegisterPushDeviceInteractor(IPushNotificationSettingsService service) {
        Intrinsics.checkNotNullParameter(service, "service");
        this.service = service;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceUseCase
    public Object registerPushDevice(String str, String str2, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
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
        Object objRegisterDevice = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objRegisterDevice);
            IPushNotificationSettingsService iPushNotificationSettingsService = this.service;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.label = 1;
            objRegisterDevice = iPushNotificationSettingsService.registerDevice(str, str2, anonymousClass1);
            if (objRegisterDevice == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objRegisterDevice);
        }
        Result result = (Result) objRegisterDevice;
        if (result instanceof Result.Success) {
            return new Result.Success(Unit.INSTANCE);
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceInteractor$registerPushDevice$3, reason: invalid class name */
    /* JADX INFO: compiled from: RegisterPushDeviceInteractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceInteractor$registerPushDevice$3", f = "RegisterPushDeviceInteractor.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Unit, ? extends DomainError>, Unit> $callback;
        final /* synthetic */ String $deviceToken;
        final /* synthetic */ String $language;
        Object L$0;
        int label;
        final /* synthetic */ RegisterPushDeviceInteractor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Function1<? super Result<Unit, ? extends DomainError>, Unit> function1, RegisterPushDeviceInteractor registerPushDeviceInteractor, String str, String str2, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.this$0 = registerPushDeviceInteractor;
            this.$deviceToken = str;
            this.$language = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$callback, this.this$0, this.$deviceToken, this.$language, continuation);
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
                Object objRegisterPushDevice = this.this$0.registerPushDevice(this.$deviceToken, this.$language, this);
                if (objRegisterPushDevice == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objRegisterPushDevice;
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

    @Override // com.box.android.domain.usecases.pushnotifications.RegisterPushDeviceUseCase
    public void registerPushDevice(String deviceToken, String language, Function1<? super Result<Unit, ? extends DomainError>, Unit> callback) {
        Intrinsics.checkNotNullParameter(deviceToken, "deviceToken");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass3(callback, this, deviceToken, language, null), 3, null);
    }
}
