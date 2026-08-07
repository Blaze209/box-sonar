package com.box.android.data.service.impl;

import android.content.SharedPreferences;
import com.box.android.data.api.models.pushnotifications.NotificationCategoriesDTO;
import com.box.android.data.api.models.pushnotifications.PushDeviceDTO;
import com.box.android.data.api.models.pushnotifications.RegisterPushDeviceDTO;
import com.box.android.data.datasource.PushNotificationSettingsRemoteDataSource;
import com.box.android.data.datasource.errors.PushNotificationSettingsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.mappers.pushnotifications.NotificationCategoriesDTODomainMapper;
import com.box.android.data.mappers.pushnotifications.PushDeviceDTODomainMapper;
import com.box.android.data.mappers.pushnotifications.RegisterPushDeviceDTODomainMapper;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.PushNotificationSettingsDomainError;
import com.box.android.domain.models.pushnotifications.NotificationCategoriesModel;
import com.box.android.domain.models.pushnotifications.NotificationCategoriesModelKt;
import com.box.android.domain.models.pushnotifications.NotificationCategory;
import com.box.android.domain.models.pushnotifications.PushDeviceModel;
import com.box.android.domain.services.IPushNotificationSettingsService;
import com.box.android.domain.utils.result.Result;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: PushNotificationSettingsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001&B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0096@¢\u0006\u0002\u0010\u0011J.\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0096@¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0019H\u0002J*\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0096@¢\u0006\u0002\u0010\u001fJ\"\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010!\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\"J \u0010#\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/box/android/data/service/impl/PushNotificationSettingsService;", "Lcom/box/android/domain/services/IPushNotificationSettingsService;", "pushNotificationSettingsRemoteDataSource", "Lcom/box/android/data/datasource/PushNotificationSettingsRemoteDataSource;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Lcom/box/android/data/datasource/PushNotificationSettingsRemoteDataSource;Lcom/box/android/domain/identity/IUserContextManager;)V", "localSharedPreferences", "Lcom/box/android/domain/localrepo/ILocalSharedPreferences;", "categories", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/models/pushnotifications/NotificationCategoriesModel;", "fetchCategoriesFromRemote", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCategories", "updates", "", "Lcom/box/android/domain/models/pushnotifications/NotificationCategory;", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCategoriesFromRemote", "Lcom/box/android/data/api/models/pushnotifications/NotificationCategoriesDTO;", "registerDevice", "Lcom/box/android/domain/models/pushnotifications/PushDeviceModel;", "deviceToken", "", "language", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeviceRegistration", "deviceModel", "(Lcom/box/android/domain/models/pushnotifications/PushDeviceModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDeviceFromRemote", "settingsId", "token", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PushNotificationSettingsService implements IPushNotificationSettingsService {
    public static final String LOGTAG = "PushNotificationSettingsService";
    private final ILocalSharedPreferences localSharedPreferences;
    private final PushNotificationSettingsRemoteDataSource pushNotificationSettingsRemoteDataSource;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.PushNotificationSettingsService$fetchCategoriesFromRemote$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PushNotificationSettingsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.PushNotificationSettingsService", f = "PushNotificationSettingsService.kt", i = {}, l = {94}, m = "fetchCategoriesFromRemote", n = {}, s = {}, v = 1)
    static final class C14821 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C14821(Continuation<? super C14821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushNotificationSettingsService.this.fetchCategoriesFromRemote(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.PushNotificationSettingsService$registerDevice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PushNotificationSettingsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.PushNotificationSettingsService", f = "PushNotificationSettingsService.kt", i = {0, 0, 0}, l = {190}, m = "registerDevice", n = {"deviceToken", "language", SemanticAttributes.EventDomainValues.DEVICE}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C14831 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C14831(Continuation<? super C14831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushNotificationSettingsService.this.registerDevice(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.PushNotificationSettingsService$updateCategories$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PushNotificationSettingsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.PushNotificationSettingsService", f = "PushNotificationSettingsService.kt", i = {0, 0, 0, 0}, l = {139}, m = "updateCategories", n = {"updates", "preferences", "currentCategories", "updatedCategories"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C14841 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C14841(Continuation<? super C14841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushNotificationSettingsService.this.updateCategories(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.PushNotificationSettingsService$updateDeviceRegistration$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PushNotificationSettingsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.PushNotificationSettingsService", f = "PushNotificationSettingsService.kt", i = {0, 0}, l = {213}, m = "updateDeviceRegistration", n = {"deviceModel", SemanticAttributes.EventDomainValues.DEVICE}, s = {"L$0", "L$1"}, v = 1)
    static final class C14851 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14851(Continuation<? super C14851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PushNotificationSettingsService.this.updateDeviceRegistration(null, this);
        }
    }

    @Inject
    public PushNotificationSettingsService(PushNotificationSettingsRemoteDataSource pushNotificationSettingsRemoteDataSource, IUserContextManager userContextManager) {
        Intrinsics.checkNotNullParameter(pushNotificationSettingsRemoteDataSource, "pushNotificationSettingsRemoteDataSource");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        this.pushNotificationSettingsRemoteDataSource = pushNotificationSettingsRemoteDataSource;
        this.userContextManager = userContextManager;
        IUserContextComponent userContextComponent = userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.localrepo.ILocalSharedPreferences");
        this.localSharedPreferences = (ILocalSharedPreferences) userContextComponent;
    }

    @Override // com.box.android.domain.services.IPushNotificationSettingsService
    public Flow<NotificationCategoriesModel> categories() {
        SharedPreferences sharedPreferences = this.localSharedPreferences.getSharedPreferences(ILocalSharedPreferences.PreferenceName.PUSH_NOTIFICATION);
        return FlowKt.combine(PushNotificationSettingsServiceKt.observe$default(sharedPreferences, ILocalSharedPreferences.PushNotificationPreferenceKey.COLLABORATION_INVITE_CATEGORY_ENABLED.getKey(), false, 2, null), PushNotificationSettingsServiceKt.observe$default(sharedPreferences, ILocalSharedPreferences.PushNotificationPreferenceKey.COMMENT_CATEGORY_ENABLED.getKey(), false, 2, null), PushNotificationSettingsServiceKt.observe$default(sharedPreferences, ILocalSharedPreferences.PushNotificationPreferenceKey.MENTIONS_CATEGORY_ENABLED.getKey(), false, 2, null), PushNotificationSettingsServiceKt.observe$default(sharedPreferences, ILocalSharedPreferences.PushNotificationPreferenceKey.EDIT_CATEGORY_ENABLED.getKey(), false, 2, null), PushNotificationSettingsServiceKt.observe$default(sharedPreferences, ILocalSharedPreferences.PushNotificationPreferenceKey.UPLOAD_CATEGORY_ENABLED.getKey(), false, 2, null), new AnonymousClass1(null));
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.PushNotificationSettingsService$categories$1, reason: invalid class name */
    /* JADX INFO: compiled from: PushNotificationSettingsService.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/models/pushnotifications/NotificationCategoriesModel;", "collabEnabled", "", "commentEnabled", "mentionsEnabled", "editEnabled", "uploadEnabled"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.PushNotificationSettingsService$categories$1", f = "PushNotificationSettingsService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function6<Boolean, Boolean, Boolean, Boolean, Boolean, Continuation<? super NotificationCategoriesModel>, Object> {
        /* synthetic */ boolean Z$0;
        /* synthetic */ boolean Z$1;
        /* synthetic */ boolean Z$2;
        /* synthetic */ boolean Z$3;
        /* synthetic */ boolean Z$4;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(6, continuation);
        }

        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Continuation<? super NotificationCategoriesModel> continuation) {
            return invoke(bool.booleanValue(), bool2.booleanValue(), bool3.booleanValue(), bool4.booleanValue(), bool5.booleanValue(), continuation);
        }

        public final Object invoke(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Continuation<? super NotificationCategoriesModel> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.Z$0 = z;
            anonymousClass1.Z$1 = z2;
            anonymousClass1.Z$2 = z3;
            anonymousClass1.Z$3 = z4;
            anonymousClass1.Z$4 = z5;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z = this.Z$0;
            boolean z2 = this.Z$1;
            boolean z3 = this.Z$2;
            boolean z4 = this.Z$3;
            boolean z5 = this.Z$4;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new NotificationCategoriesModel(false, z3, false, false, z2, z, z4, z5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IPushNotificationSettingsService
    public Object fetchCategoriesFromRemote(Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14821 c14821;
        if (continuation instanceof C14821) {
            c14821 = (C14821) continuation;
            if ((c14821.label & Integer.MIN_VALUE) != 0) {
                c14821.label -= Integer.MIN_VALUE;
            } else {
                c14821 = new C14821(continuation);
            }
        } else {
            c14821 = new C14821(continuation);
        }
        Object notificationCategories = c14821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14821.label;
        if (i == 0) {
            ResultKt.throwOnFailure(notificationCategories);
            PushNotificationSettingsRemoteDataSource pushNotificationSettingsRemoteDataSource = this.pushNotificationSettingsRemoteDataSource;
            c14821.label = 1;
            notificationCategories = pushNotificationSettingsRemoteDataSource.getNotificationCategories(c14821);
            if (notificationCategories == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(notificationCategories);
        }
        Result.Error error = (Result) notificationCategories;
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) error).getValue(), null, 2, null));
        }
        boolean z = error instanceof Result.Success;
        if (z) {
            updateCategoriesFromRemote((NotificationCategoriesDTO) ((Result.Success) error).getValue());
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return new Result.Success(Unit.INSTANCE);
        }
        if (error instanceof Result.Error) {
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IPushNotificationSettingsService
    public Object updateCategories(Map<NotificationCategory, Boolean> map, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14841 c14841;
        if (continuation instanceof C14841) {
            c14841 = (C14841) continuation;
            if ((c14841.label & Integer.MIN_VALUE) != 0) {
                c14841.label -= Integer.MIN_VALUE;
            } else {
                c14841 = new C14841(continuation);
            }
        } else {
            c14841 = new C14841(continuation);
        }
        Object objUpdateNotificationCategories = c14841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14841.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateNotificationCategories);
            SharedPreferences sharedPreferences = this.localSharedPreferences.getSharedPreferences(ILocalSharedPreferences.PreferenceName.PUSH_NOTIFICATION);
            NotificationCategoriesModel notificationCategoriesModel = new NotificationCategoriesModel(false, sharedPreferences.getBoolean(ILocalSharedPreferences.PushNotificationPreferenceKey.MENTIONS_CATEGORY_ENABLED.getKey(), false), false, false, sharedPreferences.getBoolean(ILocalSharedPreferences.PushNotificationPreferenceKey.COMMENT_CATEGORY_ENABLED.getKey(), false), sharedPreferences.getBoolean(ILocalSharedPreferences.PushNotificationPreferenceKey.COLLABORATION_INVITE_CATEGORY_ENABLED.getKey(), false), sharedPreferences.getBoolean(ILocalSharedPreferences.PushNotificationPreferenceKey.EDIT_CATEGORY_ENABLED.getKey(), false), sharedPreferences.getBoolean(ILocalSharedPreferences.PushNotificationPreferenceKey.UPLOAD_CATEGORY_ENABLED.getKey(), false));
            NotificationCategoriesDTO notificationCategoriesDTOFromDomain = NotificationCategoriesDTODomainMapper.INSTANCE.fromDomain(NotificationCategoriesModelKt.copyWithChanges(notificationCategoriesModel, map));
            PushNotificationSettingsRemoteDataSource pushNotificationSettingsRemoteDataSource = this.pushNotificationSettingsRemoteDataSource;
            c14841.L$0 = SpillingKt.nullOutSpilledVariable(map);
            c14841.L$1 = SpillingKt.nullOutSpilledVariable(sharedPreferences);
            c14841.L$2 = SpillingKt.nullOutSpilledVariable(notificationCategoriesModel);
            c14841.L$3 = SpillingKt.nullOutSpilledVariable(notificationCategoriesDTOFromDomain);
            c14841.label = 1;
            objUpdateNotificationCategories = pushNotificationSettingsRemoteDataSource.updateNotificationCategories(notificationCategoriesDTOFromDomain, c14841);
            if (objUpdateNotificationCategories == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateNotificationCategories);
        }
        Result.Error error = (Result) objUpdateNotificationCategories;
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) error).getValue(), null, 2, null));
        }
        boolean z = error instanceof Result.Success;
        if (z) {
            updateCategoriesFromRemote((NotificationCategoriesDTO) ((Result.Success) error).getValue());
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return new Result.Success(Unit.INSTANCE);
        }
        if (error instanceof Result.Error) {
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void updateCategoriesFromRemote(NotificationCategoriesDTO categories) {
        NotificationCategoriesModel domain = NotificationCategoriesDTODomainMapper.INSTANCE.toDomain(categories);
        SharedPreferences.Editor editorEdit = this.localSharedPreferences.getSharedPreferences(ILocalSharedPreferences.PreferenceName.PUSH_NOTIFICATION).edit();
        editorEdit.putBoolean(ILocalSharedPreferences.PushNotificationPreferenceKey.COLLABORATION_INVITE_CATEGORY_ENABLED.getKey(), domain.getCollaborationInvite());
        editorEdit.putBoolean(ILocalSharedPreferences.PushNotificationPreferenceKey.COMMENT_CATEGORY_ENABLED.getKey(), domain.getComment());
        editorEdit.putBoolean(ILocalSharedPreferences.PushNotificationPreferenceKey.MENTIONS_CATEGORY_ENABLED.getKey(), domain.getMentions());
        editorEdit.putBoolean(ILocalSharedPreferences.PushNotificationPreferenceKey.EDIT_CATEGORY_ENABLED.getKey(), domain.getEdit());
        editorEdit.putBoolean(ILocalSharedPreferences.PushNotificationPreferenceKey.UPLOAD_CATEGORY_ENABLED.getKey(), domain.getUpload());
        editorEdit.apply();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // com.box.android.domain.services.IPushNotificationSettingsService
    public Object registerDevice(String str, String str2, Continuation<? super Result<PushDeviceModel, ? extends DomainError>> continuation) {
        C14831 c14831;
        String str3;
        String str4;
        PushNotificationSettingsDomainError.DeviceAlreadyExists domainError$default;
        if (continuation instanceof C14831) {
            c14831 = (C14831) continuation;
            if ((c14831.label & Integer.MIN_VALUE) != 0) {
                c14831.label -= Integer.MIN_VALUE;
            } else {
                c14831 = new C14831(continuation);
            }
        } else {
            c14831 = new C14831(continuation);
        }
        Object objRegisterDevice = c14831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14831.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objRegisterDevice);
            RegisterPushDeviceDTO registerPushDeviceDTO = new RegisterPushDeviceDTO(str, null, str2, null, Boxing.boxBoolean(true), Boxing.boxBoolean(true), 10, null);
            PushNotificationSettingsRemoteDataSource pushNotificationSettingsRemoteDataSource = this.pushNotificationSettingsRemoteDataSource;
            c14831.L$0 = str;
            c14831.L$1 = str2;
            c14831.L$2 = SpillingKt.nullOutSpilledVariable(registerPushDeviceDTO);
            c14831.label = 1;
            objRegisterDevice = pushNotificationSettingsRemoteDataSource.registerDevice(registerPushDeviceDTO, c14831);
            if (objRegisterDevice == coroutine_suspended) {
                return coroutine_suspended;
            }
            str3 = str;
            str4 = str2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str4 = (String) c14831.L$1;
            str3 = (String) c14831.L$0;
            ResultKt.throwOnFailure(objRegisterDevice);
        }
        Result.Error error = (Result) objRegisterDevice;
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                RemoteError remoteError = (RemoteError) ((Result.Error) error).getValue();
                if (remoteError instanceof PushNotificationSettingsRemoteError.DeviceAlreadyExists) {
                    PushNotificationSettingsRemoteError.DeviceAlreadyExists deviceAlreadyExists = (PushNotificationSettingsRemoteError.DeviceAlreadyExists) remoteError;
                    updateDeviceFromRemote(str4, deviceAlreadyExists.getDeviceID(), str3);
                    domainError$default = new PushNotificationSettingsDomainError.DeviceAlreadyExists(deviceAlreadyExists.getDeviceID());
                } else {
                    domainError$default = DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, remoteError, null, 2, null);
                }
                error = new Result.Error(domainError$default);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        boolean z = error instanceof Result.Success;
        if (z) {
            PushDeviceDTO pushDeviceDTO = (PushDeviceDTO) ((Result.Success) error).getValue();
            updateDeviceFromRemote(pushDeviceDTO.getLanguage(), pushDeviceDTO.getId(), pushDeviceDTO.getDeviceToken());
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return new Result.Success(PushDeviceDTODomainMapper.INSTANCE.toDomain((PushDeviceDTO) ((Result.Success) error).getValue()));
        }
        if (error instanceof Result.Error) {
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IPushNotificationSettingsService
    public Object updateDeviceRegistration(PushDeviceModel pushDeviceModel, Continuation<? super Result<PushDeviceModel, ? extends DomainError>> continuation) {
        C14851 c14851;
        if (continuation instanceof C14851) {
            c14851 = (C14851) continuation;
            if ((c14851.label & Integer.MIN_VALUE) != 0) {
                c14851.label -= Integer.MIN_VALUE;
            } else {
                c14851 = new C14851(continuation);
            }
        } else {
            c14851 = new C14851(continuation);
        }
        Object objUpdateDeviceRegistration = c14851.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14851.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateDeviceRegistration);
            RegisterPushDeviceDTO registerPushDeviceDTOFromDomain = RegisterPushDeviceDTODomainMapper.INSTANCE.fromDomain(pushDeviceModel);
            PushNotificationSettingsRemoteDataSource pushNotificationSettingsRemoteDataSource = this.pushNotificationSettingsRemoteDataSource;
            String id = pushDeviceModel.getId();
            c14851.L$0 = SpillingKt.nullOutSpilledVariable(pushDeviceModel);
            c14851.L$1 = SpillingKt.nullOutSpilledVariable(registerPushDeviceDTOFromDomain);
            c14851.label = 1;
            objUpdateDeviceRegistration = pushNotificationSettingsRemoteDataSource.updateDeviceRegistration(id, registerPushDeviceDTOFromDomain, c14851);
            if (objUpdateDeviceRegistration == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUpdateDeviceRegistration);
        }
        Result.Error error = (Result) objUpdateDeviceRegistration;
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) error).getValue(), null, 2, null));
        }
        boolean z = error instanceof Result.Success;
        if (z) {
            PushDeviceDTO pushDeviceDTO = (PushDeviceDTO) ((Result.Success) error).getValue();
            updateDeviceFromRemote(pushDeviceDTO.getLanguage(), pushDeviceDTO.getId(), pushDeviceDTO.getDeviceToken());
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (z) {
            return new Result.Success(PushDeviceDTODomainMapper.INSTANCE.toDomain((PushDeviceDTO) ((Result.Success) error).getValue()));
        }
        if (error instanceof Result.Error) {
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void updateDeviceFromRemote(String language, String settingsId, String token) {
        SharedPreferences.Editor editorEdit = this.localSharedPreferences.getSharedPreferences(ILocalSharedPreferences.PreferenceName.GLOBAL).edit();
        editorEdit.putString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_LANGUAGE.getKey(), language);
        editorEdit.putString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_BOX_NOTIFICATION_ID.getKey(), settingsId);
        editorEdit.putString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_FIREBASE_TOKEN.getKey(), token);
        editorEdit.putString(ILocalSharedPreferences.GlobalPreferenceKey.PUSH_NOTIF_FIREBASE_TOKEN_WITH_BOX.getKey(), token);
        editorEdit.apply();
    }
}
