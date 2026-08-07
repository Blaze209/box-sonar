package com.box.android.data.datasource;

import com.box.android.data.api.models.ErrorDTO;
import com.box.android.data.api.models.IContextInfo;
import com.box.android.data.api.models.pushnotifications.NotificationCategoriesDTO;
import com.box.android.data.api.models.pushnotifications.PushDeviceDTO;
import com.box.android.data.api.models.pushnotifications.RegisterPushDeviceDTO;
import com.box.android.data.api.requests.PushNotificationSettingsRequest;
import com.box.android.data.datasource.errors.PushNotificationSettingsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PushNotificationSettingsRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\tH\u0086@¢\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0017\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/data/datasource/PushNotificationSettingsRemoteDataSource;", "", "pushNotificationSettingsRequest", "Lcom/box/android/data/api/requests/PushNotificationSettingsRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/PushNotificationSettingsRequest;Lcom/squareup/moshi/Moshi;)V", "registerDevice", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/pushnotifications/PushDeviceDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", SemanticAttributes.EventDomainValues.DEVICE, "Lcom/box/android/data/api/models/pushnotifications/RegisterPushDeviceDTO;", "(Lcom/box/android/data/api/models/pushnotifications/RegisterPushDeviceDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeviceRegistration", "deviceID", "", "(Ljava/lang/String;Lcom/box/android/data/api/models/pushnotifications/RegisterPushDeviceDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotificationCategories", "Lcom/box/android/data/api/models/pushnotifications/NotificationCategoriesDTO;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNotificationCategories", "categories", "(Lcom/box/android/data/api/models/pushnotifications/NotificationCategoriesDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PushNotificationSettingsRemoteDataSource {
    private static final String LOGTAG = "PushNotificationSettingsRemoteDataSource";
    private static final PushNotificationSettingsRemoteDataSource$Companion$errorUtil$1 errorUtil = new ErrorUtil() { // from class: com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource$Companion$errorUtil$1
        @Override // com.box.android.data.datasource.ErrorUtil
        public RemoteError getRemoteError(int httpErrorStatusCode, String apiErrorReasonCode, String apiErrorMessage, IContextInfo apiErrorContextInfo) {
            List<Map<String, String>> conflicts;
            String str;
            Object obj = null;
            ErrorDTO.ContextInfo contextInfo = apiErrorContextInfo instanceof ErrorDTO.ContextInfo ? (ErrorDTO.ContextInfo) apiErrorContextInfo : null;
            if (contextInfo != null && (conflicts = contextInfo.getConflicts()) != null) {
                for (Object obj2 : conflicts) {
                    if (Intrinsics.areEqual(((Map) obj2).get("type"), "id")) {
                        obj = obj2;
                        break;
                    }
                }
                Map map = (Map) obj;
                if (map != null && (str = (String) map.get("id")) != null) {
                    return new PushNotificationSettingsRemoteError.DeviceAlreadyExists(str);
                }
            }
            return super.getRemoteError(httpErrorStatusCode, apiErrorReasonCode, apiErrorMessage, apiErrorContextInfo);
        }
    };
    private final Moshi moshi;
    private final PushNotificationSettingsRequest pushNotificationSettingsRequest;

    /* JADX INFO: renamed from: com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource$getNotificationCategories$1, reason: invalid class name */
    /* JADX INFO: compiled from: PushNotificationSettingsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource", f = "PushNotificationSettingsRemoteDataSource.kt", i = {0, 0}, l = {85}, m = "getNotificationCategories", n = {"$i$f$resultOf", "$i$a$-resultOf-PushNotificationSettingsRemoteDataSource$getNotificationCategories$2"}, s = {"I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushNotificationSettingsRemoteDataSource.this.getNotificationCategories(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource$registerDevice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PushNotificationSettingsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource", f = "PushNotificationSettingsRemoteDataSource.kt", i = {0, 0, 0}, l = {54}, m = "registerDevice", n = {SemanticAttributes.EventDomainValues.DEVICE, "$i$f$resultOf", "$i$a$-resultOf-PushNotificationSettingsRemoteDataSource$registerDevice$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C10961 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10961(Continuation<? super C10961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushNotificationSettingsRemoteDataSource.this.registerDevice(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource$updateDeviceRegistration$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PushNotificationSettingsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource", f = "PushNotificationSettingsRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {74}, m = "updateDeviceRegistration", n = {"deviceID", SemanticAttributes.EventDomainValues.DEVICE, "$i$f$resultOf", "$i$a$-resultOf-PushNotificationSettingsRemoteDataSource$updateDeviceRegistration$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C10971 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10971(Continuation<? super C10971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushNotificationSettingsRemoteDataSource.this.updateDeviceRegistration(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource$updateNotificationCategories$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PushNotificationSettingsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource", f = "PushNotificationSettingsRemoteDataSource.kt", i = {0, 0, 0}, l = {94}, m = "updateNotificationCategories", n = {"categories", "$i$f$resultOf", "$i$a$-resultOf-PushNotificationSettingsRemoteDataSource$updateNotificationCategories$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C10981 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10981(Continuation<? super C10981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushNotificationSettingsRemoteDataSource.this.updateNotificationCategories(null, this);
        }
    }

    @Inject
    public PushNotificationSettingsRemoteDataSource(PushNotificationSettingsRequest pushNotificationSettingsRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(pushNotificationSettingsRequest, "pushNotificationSettingsRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.pushNotificationSettingsRequest = pushNotificationSettingsRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object registerDevice(RegisterPushDeviceDTO registerPushDeviceDTO, Continuation<? super Result<PushDeviceDTO, ? extends RemoteError>> continuation) {
        C10961 c10961;
        Result.Error error;
        if (continuation instanceof C10961) {
            c10961 = (C10961) continuation;
            if ((c10961.label & Integer.MIN_VALUE) != 0) {
                c10961.label -= Integer.MIN_VALUE;
            } else {
                c10961 = new C10961(continuation);
            }
        } else {
            c10961 = new C10961(continuation);
        }
        Object objRegisterDevice = c10961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10961.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objRegisterDevice);
                PushNotificationSettingsRequest pushNotificationSettingsRequest = this.pushNotificationSettingsRequest;
                c10961.L$0 = SpillingKt.nullOutSpilledVariable(registerPushDeviceDTO);
                c10961.I$0 = 0;
                c10961.I$1 = 0;
                c10961.label = 1;
                objRegisterDevice = pushNotificationSettingsRequest.registerDevice(registerPushDeviceDTO, c10961);
                if (objRegisterDevice == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c10961.I$1;
                int i3 = c10961.I$0;
                ResultKt.throwOnFailure(objRegisterDevice);
            }
            error = new Result.Success((PushDeviceDTO) objRegisterDevice);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            RemoteError remoteErrorFromApiException = errorUtil.getRemoteErrorFromApiException(exc, this.moshi);
            if (remoteErrorFromApiException instanceof PushNotificationSettingsRemoteError.DeviceAlreadyExists) {
                BoxLogUtils.i(LOGTAG, "Registered device token that already exists", MapsKt.mapOf(TuplesKt.to("device ID", ((PushNotificationSettingsRemoteError.DeviceAlreadyExists) remoteErrorFromApiException).getDeviceID())));
            } else {
                BoxLogUtils.e(LOGTAG, "Exception attempting to register device", exc);
            }
            return new Result.Error(remoteErrorFromApiException);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateDeviceRegistration(String str, RegisterPushDeviceDTO registerPushDeviceDTO, Continuation<? super Result<PushDeviceDTO, ? extends RemoteError>> continuation) {
        C10971 c10971;
        Result.Error error;
        if (continuation instanceof C10971) {
            c10971 = (C10971) continuation;
            if ((c10971.label & Integer.MIN_VALUE) != 0) {
                c10971.label -= Integer.MIN_VALUE;
            } else {
                c10971 = new C10971(continuation);
            }
        } else {
            c10971 = new C10971(continuation);
        }
        Object objUpdateDeviceRegistration = c10971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10971.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUpdateDeviceRegistration);
                PushNotificationSettingsRequest pushNotificationSettingsRequest = this.pushNotificationSettingsRequest;
                c10971.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c10971.L$1 = SpillingKt.nullOutSpilledVariable(registerPushDeviceDTO);
                c10971.I$0 = 0;
                c10971.I$1 = 0;
                c10971.label = 1;
                objUpdateDeviceRegistration = pushNotificationSettingsRequest.updateDeviceRegistration(str, registerPushDeviceDTO, c10971);
                if (objUpdateDeviceRegistration == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c10971.I$1;
                int i3 = c10971.I$0;
                ResultKt.throwOnFailure(objUpdateDeviceRegistration);
            }
            error = new Result.Success((PushDeviceDTO) objUpdateDeviceRegistration);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception attempting to update device registration", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getNotificationCategories(Continuation<? super Result<NotificationCategoriesDTO, ? extends RemoteError>> continuation) {
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
        Object notificationCategories = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(notificationCategories);
                PushNotificationSettingsRequest pushNotificationSettingsRequest = this.pushNotificationSettingsRequest;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                notificationCategories = pushNotificationSettingsRequest.getNotificationCategories(anonymousClass1);
                if (notificationCategories == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(notificationCategories);
            }
            error = new Result.Success((NotificationCategoriesDTO) notificationCategories);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception attempting to get notification categories", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateNotificationCategories(NotificationCategoriesDTO notificationCategoriesDTO, Continuation<? super Result<NotificationCategoriesDTO, ? extends RemoteError>> continuation) {
        C10981 c10981;
        Result.Error error;
        if (continuation instanceof C10981) {
            c10981 = (C10981) continuation;
            if ((c10981.label & Integer.MIN_VALUE) != 0) {
                c10981.label -= Integer.MIN_VALUE;
            } else {
                c10981 = new C10981(continuation);
            }
        } else {
            c10981 = new C10981(continuation);
        }
        Object objUpdateNotificationCategories = c10981.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10981.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUpdateNotificationCategories);
                PushNotificationSettingsRequest pushNotificationSettingsRequest = this.pushNotificationSettingsRequest;
                c10981.L$0 = SpillingKt.nullOutSpilledVariable(notificationCategoriesDTO);
                c10981.I$0 = 0;
                c10981.I$1 = 0;
                c10981.label = 1;
                objUpdateNotificationCategories = pushNotificationSettingsRequest.updateNotificationCategories(notificationCategoriesDTO, c10981);
                if (objUpdateNotificationCategories == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c10981.I$1;
                int i3 = c10981.I$0;
                ResultKt.throwOnFailure(objUpdateNotificationCategories);
            }
            error = new Result.Success((NotificationCategoriesDTO) objUpdateNotificationCategories);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception attempting to update notification categories", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }
}
