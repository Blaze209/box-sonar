package com.box.android.data.datasource.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationActionRequestDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationActionResponseDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationIteratorDTO;
import com.box.android.data.api.models.inboxnotifications.InboxNotificationUnseenCountsDTO;
import com.box.android.data.api.models.inboxnotifications.LastNotificationSeenDTO;
import com.box.android.data.api.models.inboxnotifications.MarkAllNotificationsAsSeenDTO;
import com.box.android.data.api.models.inboxnotifications.MarkNotificationAsReadDTO;
import com.box.android.data.api.requests.InboxNotificationRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxNotificationRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u0001:\u0001!B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fJF\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0019\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u001aJ,\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fJ*\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/box/android/data/datasource/inboxnotifications/InboxNotificationRemoteDataSource;", "", "inboxNotificationRequest", "Lcom/box/android/data/api/requests/InboxNotificationRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/InboxNotificationRequest;Lcom/squareup/moshi/Moshi;)V", "getUnseenCounts", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationUnseenCountsDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "platform", "", "notificationIdStart", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInboxNotifications", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationIteratorDTO;", BoxIterator.FIELD_LIMIT, "", "filterEventType", "nextMarker", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markNotificationAsRead", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationDTO;", "notificationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAllNotificationsAsSeen", "", "lastNotificationId", "executeAction", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationActionResponseDTO;", "actionId", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationRemoteDataSource {
    private static final String LOGTAG = "InboxNotificationRemoteDataSource";
    private final InboxNotificationRequest inboxNotificationRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource$executeAction$1, reason: invalid class name */
    /* JADX INFO: compiled from: InboxNotificationRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource", f = "InboxNotificationRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {125}, m = "executeAction", n = {"notificationId", "actionId", "$i$f$resultOf", "$i$a$-resultOf-InboxNotificationRemoteDataSource$executeAction$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return InboxNotificationRemoteDataSource.this.executeAction(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource$getInboxNotifications$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource", f = "InboxNotificationRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {65}, m = "getInboxNotifications", n = {"platform", "filterEventType", "nextMarker", BoxIterator.FIELD_LIMIT, "$i$f$resultOf", "$i$a$-resultOf-InboxNotificationRemoteDataSource$getInboxNotifications$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2"}, v = 1)
    static final class C11621 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11621(Continuation<? super C11621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationRemoteDataSource.this.getInboxNotifications(null, 0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource$getUnseenCounts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource", f = "InboxNotificationRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {40}, m = "getUnseenCounts", n = {"platform", "notificationIdStart", "$i$f$resultOf", "$i$a$-resultOf-InboxNotificationRemoteDataSource$getUnseenCounts$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C11631 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11631(Continuation<? super C11631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationRemoteDataSource.this.getUnseenCounts(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource$markAllNotificationsAsSeen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource", f = "InboxNotificationRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {102}, m = "markAllNotificationsAsSeen", n = {"lastNotificationId", "platform", "$i$f$resultOf", "$i$a$-resultOf-InboxNotificationRemoteDataSource$markAllNotificationsAsSeen$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class C11641 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11641(Continuation<? super C11641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationRemoteDataSource.this.markAllNotificationsAsSeen(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource$markNotificationAsRead$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.inboxnotifications.InboxNotificationRemoteDataSource", f = "InboxNotificationRemoteDataSource.kt", i = {0, 0, 0}, l = {84}, m = "markNotificationAsRead", n = {"notificationId", "$i$f$resultOf", "$i$a$-resultOf-InboxNotificationRemoteDataSource$markNotificationAsRead$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C11651 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11651(Continuation<? super C11651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationRemoteDataSource.this.markNotificationAsRead(null, this);
        }
    }

    @Inject
    public InboxNotificationRemoteDataSource(InboxNotificationRequest inboxNotificationRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(inboxNotificationRequest, "inboxNotificationRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.inboxNotificationRequest = inboxNotificationRequest;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getUnseenCounts(String str, String str2, Continuation<? super Result<InboxNotificationUnseenCountsDTO, ? extends RemoteError>> continuation) {
        C11631 c11631;
        Result.Error error;
        if (continuation instanceof C11631) {
            c11631 = (C11631) continuation;
            if ((c11631.label & Integer.MIN_VALUE) != 0) {
                c11631.label -= Integer.MIN_VALUE;
            } else {
                c11631 = new C11631(continuation);
            }
        } else {
            c11631 = new C11631(continuation);
        }
        Object unseenCounts = c11631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11631.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(unseenCounts);
                InboxNotificationRequest inboxNotificationRequest = this.inboxNotificationRequest;
                c11631.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11631.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c11631.I$0 = 0;
                c11631.I$1 = 0;
                c11631.label = 1;
                unseenCounts = inboxNotificationRequest.getUnseenCounts(str, str2, c11631);
                if (unseenCounts == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11631.I$1;
                int i3 = c11631.I$0;
                ResultKt.throwOnFailure(unseenCounts);
            }
            error = new Result.Success((InboxNotificationUnseenCountsDTO) unseenCounts);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception attempting to get notifications unseen count", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object getUnseenCounts$default(InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "android";
        }
        return inboxNotificationRemoteDataSource.getUnseenCounts(str, str2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getInboxNotifications(String str, int i, String str2, String str3, Continuation<? super Result<InboxNotificationIteratorDTO, ? extends RemoteError>> continuation) {
        C11621 c11621;
        Result.Error error;
        if (continuation instanceof C11621) {
            c11621 = (C11621) continuation;
            if ((c11621.label & Integer.MIN_VALUE) != 0) {
                c11621.label -= Integer.MIN_VALUE;
            } else {
                c11621 = new C11621(continuation);
            }
        } else {
            c11621 = new C11621(continuation);
        }
        C11621 c11622 = c11621;
        Object pushNotificationsV2 = c11622.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c11622.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(pushNotificationsV2);
                InboxNotificationRequest inboxNotificationRequest = this.inboxNotificationRequest;
                c11622.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11622.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c11622.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                c11622.I$0 = i;
                c11622.I$1 = 0;
                c11622.I$2 = 0;
                c11622.label = 1;
                pushNotificationsV2 = inboxNotificationRequest.getPushNotificationsV2(str, i, str2, str3, c11622);
                if (pushNotificationsV2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c11622.I$2;
                int i4 = c11622.I$1;
                int i5 = c11622.I$0;
                ResultKt.throwOnFailure(pushNotificationsV2);
            }
            error = new Result.Success((InboxNotificationIteratorDTO) pushNotificationsV2);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception attempting to get inbox notifications", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object getInboxNotifications$default(InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource, String str, int i, String str2, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "android";
        }
        if ((i2 & 2) != 0) {
            i = 20;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        return inboxNotificationRemoteDataSource.getInboxNotifications(str, i, str2, (i2 & 8) != 0 ? null : str3, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object markNotificationAsRead(String str, Continuation<? super Result<InboxNotificationDTO, ? extends RemoteError>> continuation) {
        C11651 c11651;
        Result.Error error;
        if (continuation instanceof C11651) {
            c11651 = (C11651) continuation;
            if ((c11651.label & Integer.MIN_VALUE) != 0) {
                c11651.label -= Integer.MIN_VALUE;
            } else {
                c11651 = new C11651(continuation);
            }
        } else {
            c11651 = new C11651(continuation);
        }
        Object objMarkNotificationAsRead = c11651.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11651.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objMarkNotificationAsRead);
                InboxNotificationRequest inboxNotificationRequest = this.inboxNotificationRequest;
                MarkNotificationAsReadDTO markNotificationAsReadDTO = new MarkNotificationAsReadDTO(null, null, null, 7, null);
                c11651.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11651.I$0 = 0;
                c11651.I$1 = 0;
                c11651.label = 1;
                objMarkNotificationAsRead = inboxNotificationRequest.markNotificationAsRead(str, markNotificationAsReadDTO, c11651);
                if (objMarkNotificationAsRead == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11651.I$1;
                int i3 = c11651.I$0;
                ResultKt.throwOnFailure(objMarkNotificationAsRead);
            }
            error = new Result.Success((InboxNotificationDTO) objMarkNotificationAsRead);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception attempting to mark notification as read", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ Object markAllNotificationsAsSeen$default(InboxNotificationRemoteDataSource inboxNotificationRemoteDataSource, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "android";
        }
        return inboxNotificationRemoteDataSource.markAllNotificationsAsSeen(str, str2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object markAllNotificationsAsSeen(String str, String str2, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) {
        C11641 c11641;
        Result.Error error;
        if (continuation instanceof C11641) {
            c11641 = (C11641) continuation;
            if ((c11641.label & Integer.MIN_VALUE) != 0) {
                c11641.label -= Integer.MIN_VALUE;
            } else {
                c11641 = new C11641(continuation);
            }
        } else {
            c11641 = new C11641(continuation);
        }
        Object obj = c11641.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11641.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InboxNotificationRequest inboxNotificationRequest = this.inboxNotificationRequest;
                MarkAllNotificationsAsSeenDTO markAllNotificationsAsSeenDTO = new MarkAllNotificationsAsSeenDTO(new LastNotificationSeenDTO(str, null, 2, null));
                c11641.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11641.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c11641.I$0 = 0;
                c11641.I$1 = 0;
                c11641.label = 1;
                if (inboxNotificationRequest.markAllNotificationsAsSeen(str2, markAllNotificationsAsSeenDTO, c11641) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11641.I$1;
                int i3 = c11641.I$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception attempting to mark all notifications as seen", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object executeAction(String str, String str2, Continuation<? super Result<InboxNotificationActionResponseDTO, ? extends RemoteError>> continuation) {
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
        Object objExecuteAction = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objExecuteAction);
                InboxNotificationRequest inboxNotificationRequest = this.inboxNotificationRequest;
                InboxNotificationActionRequestDTO inboxNotificationActionRequestDTO = new InboxNotificationActionRequestDTO(null, str, str2, 1, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                objExecuteAction = inboxNotificationRequest.executeAction(inboxNotificationActionRequestDTO, anonymousClass1);
                if (objExecuteAction == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(objExecuteAction);
            }
            error = new Result.Success((InboxNotificationActionResponseDTO) objExecuteAction);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception attempting to execute notification action", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }
}
