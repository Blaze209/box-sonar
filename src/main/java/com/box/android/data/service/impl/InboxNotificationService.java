package com.box.android.data.service.impl;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationActionResponseDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationIteratorDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationUnseenCountsDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.inboxnotifications.InboxNotificationLocalDataSource;
import com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource;
import com.box.android.data.mappers.inboxnotifications.InboxNotificationActionResponseDTODomainMapper;
import com.box.android.data.mappers.inboxnotifications.InboxNotificationDTODomainMapper;
import com.box.android.data.mappers.inboxnotifications.InboxNotificationIteratorDTODomainMapper;
import com.box.android.data.mappers.inboxnotifications.InboxNotificationUnseenCountsDTODomainMapper;
import com.box.android.data.persistence.inboxnotifications.NotificationSource;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.inboxnotifications.InboxNotificationActionResponseModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationIteratorModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationUnseenCountsModel;
import com.box.android.domain.services.IInboxNotificationService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: InboxNotificationService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000fJ>\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u0016J>\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0082@¢\u0006\u0002\u0010\u0016J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0019\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001d\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u001eJ*\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000fJ*\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010$\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/box/android/data/service/impl/InboxNotificationService;", "Lcom/box/android/domain/services/IInboxNotificationService;", "inboxNotificationRemoteDataSource", "Lcom/box/android/data/datasource/inboxnotifications/InboxNotificationRemoteDataSource;", "inboxNotificationLocalDataSource", "Lcom/box/android/data/datasource/inboxnotifications/InboxNotificationLocalDataSource;", "<init>", "(Lcom/box/android/data/datasource/inboxnotifications/InboxNotificationRemoteDataSource;Lcom/box/android/data/datasource/inboxnotifications/InboxNotificationLocalDataSource;)V", "getUnseenCounts", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationUnseenCountsModel;", "Lcom/box/android/domain/models/DomainError;", "platform", "", "notificationIdStart", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInboxNotifications", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationIteratorModel;", BoxIterator.FIELD_LIMIT, "", "filterEventType", "nextMarker", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchAndCacheNotifications", "getCachedNotificationsOrError", "networkError", "(Lcom/box/android/domain/models/DomainError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markNotificationAsRead", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "notificationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAllNotificationsAsSeen", "", "lastNotificationId", "executeAction", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationActionResponseModel;", "actionId", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationService implements IInboxNotificationService {
    private final InboxNotificationLocalDataSource inboxNotificationLocalDataSource;
    private final InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.InboxNotificationService$executeAction$1, reason: invalid class name */
    /* JADX INFO: compiled from: InboxNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.InboxNotificationService", f = "InboxNotificationService.kt", i = {0, 0}, l = {Token.COLONCOLON}, m = "executeAction", n = {"notificationId", "actionId"}, s = {"L$0", "L$1"}, v = 1)
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
            return InboxNotificationService.this.executeAction(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.InboxNotificationService$fetchAndCacheNotifications$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.InboxNotificationService", f = "InboxNotificationService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {70, 80, 87}, m = "fetchAndCacheNotifications", n = {"platform", "filterEventType", "nextMarker", BoxIterator.FIELD_LIMIT, "platform", "filterEventType", "nextMarker", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, BoxIterator.FIELD_LIMIT, "platform", "filterEventType", "nextMarker", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "networkError", BoxIterator.FIELD_LIMIT}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
    static final class C14351 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C14351(Continuation<? super C14351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationService.this.fetchAndCacheNotifications(null, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.InboxNotificationService$getCachedNotificationsOrError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.InboxNotificationService", f = "InboxNotificationService.kt", i = {0}, l = {93}, m = "getCachedNotificationsOrError", n = {"networkError"}, s = {"L$0"}, v = 1)
    static final class C14361 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C14361(Continuation<? super C14361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationService.this.getCachedNotificationsOrError(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.InboxNotificationService$getUnseenCounts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.InboxNotificationService", f = "InboxNotificationService.kt", i = {0, 0}, l = {39}, m = "getUnseenCounts", n = {"platform", "notificationIdStart"}, s = {"L$0", "L$1"}, v = 1)
    static final class C14371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14371(Continuation<? super C14371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationService.this.getUnseenCounts(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.InboxNotificationService$markAllNotificationsAsSeen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.InboxNotificationService", f = "InboxNotificationService.kt", i = {0, 0}, l = {130}, m = "markAllNotificationsAsSeen", n = {"lastNotificationId", "platform"}, s = {"L$0", "L$1"}, v = 1)
    static final class C14381 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14381(Continuation<? super C14381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationService.this.markAllNotificationsAsSeen(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.InboxNotificationService$markNotificationAsRead$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.InboxNotificationService", f = "InboxNotificationService.kt", i = {0, 1, 1}, l = {117, 123}, m = "markNotificationAsRead", n = {"notificationId", "notificationId", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$1"}, v = 1)
    static final class C14391 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C14391(Continuation<? super C14391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationService.this.markNotificationAsRead(null, this);
        }
    }

    @Inject
    public InboxNotificationService(InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource, InboxNotificationLocalDataSource inboxNotificationLocalDataSource) {
        Intrinsics.checkNotNullParameter(inboxNotificationRemoteDataSource, "inboxNotificationRemoteDataSource");
        Intrinsics.checkNotNullParameter(inboxNotificationLocalDataSource, "inboxNotificationLocalDataSource");
        this.inboxNotificationRemoteDataSource = inboxNotificationRemoteDataSource;
        this.inboxNotificationLocalDataSource = inboxNotificationLocalDataSource;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IInboxNotificationService
    public Object getUnseenCounts(String str, String str2, Continuation<? super Result<InboxNotificationUnseenCountsModel, ? extends DomainError>> continuation) {
        C14371 c14371;
        if (continuation instanceof C14371) {
            c14371 = (C14371) continuation;
            if ((c14371.label & Integer.MIN_VALUE) != 0) {
                c14371.label -= Integer.MIN_VALUE;
            } else {
                c14371 = new C14371(continuation);
            }
        } else {
            c14371 = new C14371(continuation);
        }
        Object unseenCounts = c14371.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14371.label;
        if (i == 0) {
            ResultKt.throwOnFailure(unseenCounts);
            InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource = this.inboxNotificationRemoteDataSource;
            c14371.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c14371.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c14371.label = 1;
            unseenCounts = inboxNotificationRemoteDataSource.getUnseenCounts(str, str2, c14371);
            if (unseenCounts == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(unseenCounts);
        }
        Result.Error error = (Result) unseenCounts;
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) error).getValue(), null, 2, null));
        }
        if (error instanceof Result.Success) {
            return new Result.Success(InboxNotificationUnseenCountsDTODomainMapper.INSTANCE.toDomain((InboxNotificationUnseenCountsDTO) ((Result.Success) error).getValue()));
        }
        if (error instanceof Result.Error) {
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.InboxNotificationService$getInboxNotifications$2, reason: invalid class name */
    /* JADX INFO: compiled from: InboxNotificationService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationIteratorModel;", "Lcom/box/android/domain/models/DomainError;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.InboxNotificationService$getInboxNotifications$2", f = "InboxNotificationService.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends InboxNotificationIteratorModel, ? extends DomainError>>, Object> {
        final /* synthetic */ String $filterEventType;
        final /* synthetic */ int $limit;
        final /* synthetic */ String $nextMarker;
        final /* synthetic */ String $platform;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, int i, String str2, String str3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$platform = str;
            this.$limit = i;
            this.$filterEventType = str2;
            this.$nextMarker = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InboxNotificationService.this.new AnonymousClass2(this.$platform, this.$limit, this.$filterEventType, this.$nextMarker, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends InboxNotificationIteratorModel, ? extends DomainError>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<InboxNotificationIteratorModel, ? extends DomainError>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<InboxNotificationIteratorModel, ? extends DomainError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objFetchAndCacheNotifications = InboxNotificationService.this.fetchAndCacheNotifications(this.$platform, this.$limit, this.$filterEventType, this.$nextMarker, this);
            return objFetchAndCacheNotifications == coroutine_suspended ? coroutine_suspended : objFetchAndCacheNotifications;
        }
    }

    @Override // com.box.android.domain.services.IInboxNotificationService
    public Object getInboxNotifications(String str, int i, String str2, String str3, Continuation<? super Result<InboxNotificationIteratorModel, ? extends DomainError>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, i, str2, str3, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchAndCacheNotifications(String str, int i, String str2, String str3, Continuation<? super Result<InboxNotificationIteratorModel, ? extends DomainError>> continuation) {
        C14351 c14351;
        String str4;
        int i2;
        String str5;
        String str6;
        Result result;
        if (continuation instanceof C14351) {
            c14351 = (C14351) continuation;
            if ((c14351.label & Integer.MIN_VALUE) != 0) {
                c14351.label -= Integer.MIN_VALUE;
            } else {
                c14351 = new C14351(continuation);
            }
        } else {
            c14351 = new C14351(continuation);
        }
        C14351 c14352 = c14351;
        Object inboxNotifications = c14352.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c14352.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(inboxNotifications);
            InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource = this.inboxNotificationRemoteDataSource;
            c14352.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c14352.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c14352.L$2 = SpillingKt.nullOutSpilledVariable(str3);
            c14352.I$0 = i;
            c14352.label = 1;
            inboxNotifications = inboxNotificationRemoteDataSource.getInboxNotifications(str, i, str2, str3, c14352);
            if (inboxNotifications != coroutine_suspended) {
                str4 = str;
                i2 = i;
                str5 = str2;
                str6 = str3;
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            i2 = c14352.I$0;
            str6 = (String) c14352.L$2;
            str5 = (String) c14352.L$1;
            str4 = (String) c14352.L$0;
            ResultKt.throwOnFailure(inboxNotifications);
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = c14352.I$0;
                ResultKt.throwOnFailure(inboxNotifications);
                return inboxNotifications;
            }
            int i5 = c14352.I$0;
            result = (Result) c14352.L$3;
            ResultKt.throwOnFailure(inboxNotifications);
        }
        return new Result.Success(InboxNotificationIteratorDTODomainMapper.INSTANCE.toDomain((InboxNotificationIteratorDTO) ((Result.Success) result).getValue()));
        Result result2 = (Result) inboxNotifications;
        if (result2 instanceof Result.Success) {
            InboxNotificationLocalDataSource inboxNotificationLocalDataSource = this.inboxNotificationLocalDataSource;
            List<InboxNotificationDTO> entries = ((InboxNotificationIteratorDTO) ((Result.Success) result2).getValue()).getEntries();
            NotificationSource notificationSource = NotificationSource.API;
            c14352.L$0 = SpillingKt.nullOutSpilledVariable(str4);
            c14352.L$1 = SpillingKt.nullOutSpilledVariable(str5);
            c14352.L$2 = SpillingKt.nullOutSpilledVariable(str6);
            c14352.L$3 = result2;
            c14352.I$0 = i2;
            c14352.label = 2;
            if (inboxNotificationLocalDataSource.saveNotifications(entries, notificationSource, c14352) != coroutine_suspended) {
                result = result2;
                return new Result.Success(InboxNotificationIteratorDTODomainMapper.INSTANCE.toDomain((InboxNotificationIteratorDTO) ((Result.Success) result).getValue()));
            }
        } else {
            if (!(result2 instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            DomainError domainError$default = DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) result2).getValue(), null, 2, null);
            c14352.L$0 = SpillingKt.nullOutSpilledVariable(str4);
            c14352.L$1 = SpillingKt.nullOutSpilledVariable(str5);
            c14352.L$2 = SpillingKt.nullOutSpilledVariable(str6);
            c14352.L$3 = SpillingKt.nullOutSpilledVariable(result2);
            c14352.L$4 = SpillingKt.nullOutSpilledVariable(domainError$default);
            c14352.I$0 = i2;
            c14352.label = 3;
            Object cachedNotificationsOrError = getCachedNotificationsOrError(domainError$default, c14352);
            if (cachedNotificationsOrError != coroutine_suspended) {
                return cachedNotificationsOrError;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getCachedNotificationsOrError(DomainError domainError, Continuation<? super Result<InboxNotificationIteratorModel, ? extends DomainError>> continuation) {
        C14361 c14361;
        if (continuation instanceof C14361) {
            c14361 = (C14361) continuation;
            if ((c14361.label & Integer.MIN_VALUE) != 0) {
                c14361.label -= Integer.MIN_VALUE;
            } else {
                c14361 = new C14361(continuation);
            }
        } else {
            c14361 = new C14361(continuation);
        }
        Object apiNotifications$default = c14361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14361.label;
        if (i == 0) {
            ResultKt.throwOnFailure(apiNotifications$default);
            InboxNotificationLocalDataSource inboxNotificationLocalDataSource = this.inboxNotificationLocalDataSource;
            c14361.L$0 = domainError;
            c14361.label = 1;
            apiNotifications$default = InboxNotificationLocalDataSource.getApiNotifications$default(inboxNotificationLocalDataSource, 0, c14361, 1, null);
            if (apiNotifications$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            domainError = (DomainError) c14361.L$0;
            ResultKt.throwOnFailure(apiNotifications$default);
        }
        List list = (List) apiNotifications$default;
        if (list.isEmpty()) {
            return new Result.Error(domainError);
        }
        int size = list.size();
        InboxNotificationDTO inboxNotificationDTO = (InboxNotificationDTO) CollectionsKt.firstOrNull(list);
        return new Result.Error(new DomainError.CachedDomainError(InboxNotificationIteratorDTODomainMapper.INSTANCE.toDomain(new InboxNotificationIteratorDTO(null, size, list, inboxNotificationDTO != null ? inboxNotificationDTO.getId() : null)), domainError));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IInboxNotificationService
    public Object markNotificationAsRead(String str, Continuation<? super Result<InboxNotificationModel, ? extends DomainError>> continuation) {
        C14391 c14391;
        if (continuation instanceof C14391) {
            c14391 = (C14391) continuation;
            if ((c14391.label & Integer.MIN_VALUE) != 0) {
                c14391.label -= Integer.MIN_VALUE;
            } else {
                c14391 = new C14391(continuation);
            }
        } else {
            c14391 = new C14391(continuation);
        }
        Object objMarkNotificationAsRead = c14391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14391.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMarkNotificationAsRead);
            InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource = this.inboxNotificationRemoteDataSource;
            c14391.L$0 = str;
            c14391.label = 1;
            objMarkNotificationAsRead = inboxNotificationRemoteDataSource.markNotificationAsRead(str, c14391);
            if (objMarkNotificationAsRead != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result result = (Result) c14391.L$1;
            ResultKt.throwOnFailure(objMarkNotificationAsRead);
            return result;
        }
        str = (String) c14391.L$0;
        ResultKt.throwOnFailure(objMarkNotificationAsRead);
        Result.Success success = (Result) objMarkNotificationAsRead;
        if (!(success instanceof Result.Success)) {
            if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            success = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) success).getValue(), null, 2, null));
        }
        if (success instanceof Result.Success) {
            success = new Result.Success(InboxNotificationDTODomainMapper.INSTANCE.toDomain((InboxNotificationDTO) ((Result.Success) success).getValue()));
        } else if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            InboxNotificationLocalDataSource inboxNotificationLocalDataSource = this.inboxNotificationLocalDataSource;
            c14391.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c14391.L$1 = success;
            c14391.label = 2;
            if (inboxNotificationLocalDataSource.updateReadStatus(str, true, c14391) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return success;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IInboxNotificationService
    public Object markAllNotificationsAsSeen(String str, String str2, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14381 c14381;
        if (continuation instanceof C14381) {
            c14381 = (C14381) continuation;
            if ((c14381.label & Integer.MIN_VALUE) != 0) {
                c14381.label -= Integer.MIN_VALUE;
            } else {
                c14381 = new C14381(continuation);
            }
        } else {
            c14381 = new C14381(continuation);
        }
        Object objMarkAllNotificationsAsSeen = c14381.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14381.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMarkAllNotificationsAsSeen);
            InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource = this.inboxNotificationRemoteDataSource;
            c14381.L$0 = SpillingKt.nullOutSpilledVariable(str);
            c14381.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c14381.label = 1;
            objMarkAllNotificationsAsSeen = inboxNotificationRemoteDataSource.markAllNotificationsAsSeen(str, str2, c14381);
            if (objMarkAllNotificationsAsSeen == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objMarkAllNotificationsAsSeen);
        }
        Result result = (Result) objMarkAllNotificationsAsSeen;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) result).getValue(), null, 2, null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IInboxNotificationService
    public Object executeAction(String str, String str2, Continuation<? super Result<InboxNotificationActionResponseModel, ? extends DomainError>> continuation) {
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
        Object objExecuteAction = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objExecuteAction);
            InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource = this.inboxNotificationRemoteDataSource;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.label = 1;
            objExecuteAction = inboxNotificationRemoteDataSource.executeAction(str, str2, anonymousClass1);
            if (objExecuteAction == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objExecuteAction);
        }
        Result.Error error = (Result) objExecuteAction;
        if (!(error instanceof Result.Success)) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            error = new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (RemoteError) ((Result.Error) error).getValue(), null, 2, null));
        }
        if (error instanceof Result.Success) {
            return new Result.Success(InboxNotificationActionResponseDTODomainMapper.INSTANCE.toDomain((InboxNotificationActionResponseDTO) ((Result.Success) error).getValue()));
        }
        if (error instanceof Result.Error) {
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }
}
