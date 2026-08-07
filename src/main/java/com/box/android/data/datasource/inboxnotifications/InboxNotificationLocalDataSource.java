package com.box.android.data.datasource.inboxnotifications;

import com.box.android.data.api.models.inboxnotifications.InboxNotificationDTO;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.inboxnotifications.InboxNotificationDao;
import com.box.android.data.persistence.inboxnotifications.InboxNotificationEntity;
import com.box.android.data.persistence.inboxnotifications.NotificationSource;
import com.box.android.data.user.UserData;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxIterator;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: InboxNotificationLocalDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0082@¢\u0006\u0002\u0010%J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\f2\u0006\u0010*\u001a\u00020'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/box/android/data/datasource/inboxnotifications/InboxNotificationLocalDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/user/UserData;Lcom/box/android/domain/identity/IUserContextManager;Lcom/squareup/moshi/Moshi;)V", "adapter", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/box/android/data/api/models/inboxnotifications/InboxNotificationDTO;", "kotlin.jvm.PlatformType", "lastCleanedUserId", "", "saveNotifications", "", "notifications", "", "source", "Lcom/box/android/data/persistence/inboxnotifications/NotificationSource;", "(Ljava/util/List;Lcom/box/android/data/persistence/inboxnotifications/NotificationSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApiNotifications", BoxIterator.FIELD_LIMIT, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateReadStatus", "notificationId", "isRead", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanupIfNeeded", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldNotifications", "maxAgeMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notificationDtoToEntity", "Lcom/box/android/data/persistence/inboxnotifications/InboxNotificationEntity;", "dto", "entityToNotificationDto", "entity", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxNotificationLocalDataSource {
    private static final int MAX_CACHE_AGE_DAYS = 90;
    private static final long MAX_CACHE_AGE_MILLIS = 7776000000L;
    private final JsonAdapter<InboxNotificationDTO> adapter;
    private String lastCleanedUserId;
    private final IUserContextManager userContextManager;
    private final UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.inboxnotifications.InboxNotificationLocalDataSource$cleanupIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: InboxNotificationLocalDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.inboxnotifications.InboxNotificationLocalDataSource", f = "InboxNotificationLocalDataSource.kt", i = {0}, l = {89}, m = "cleanupIfNeeded", n = {"currentUserId"}, s = {"L$0"}, v = 1)
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
            return InboxNotificationLocalDataSource.this.cleanupIfNeeded(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.inboxnotifications.InboxNotificationLocalDataSource$getApiNotifications$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationLocalDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.inboxnotifications.InboxNotificationLocalDataSource", f = "InboxNotificationLocalDataSource.kt", i = {0, 0}, l = {59}, m = "getApiNotifications", n = {"dbResult", BoxIterator.FIELD_LIMIT}, s = {"L$0", "I$0"}, v = 1)
    static final class C11601 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11601(Continuation<? super C11601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationLocalDataSource.this.getApiNotifications(0, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.inboxnotifications.InboxNotificationLocalDataSource$saveNotifications$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxNotificationLocalDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.inboxnotifications.InboxNotificationLocalDataSource", f = "InboxNotificationLocalDataSource.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {41, 43}, m = "saveNotifications", n = {"notifications", "source", "dbResult", "notifications", "source", "dbResult", "entities"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C11611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C11611(Continuation<? super C11611> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxNotificationLocalDataSource.this.saveNotifications(null, null, this);
        }
    }

    @Inject
    public InboxNotificationLocalDataSource(UserData userData, IUserContextManager userContextManager, Moshi moshi) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.userData = userData;
        this.userContextManager = userContextManager;
        this.adapter = moshi.adapter(InboxNotificationDTO.class);
    }

    public static /* synthetic */ Object saveNotifications$default(InboxNotificationLocalDataSource inboxNotificationLocalDataSource, List list, NotificationSource notificationSource, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            notificationSource = NotificationSource.API;
        }
        return inboxNotificationLocalDataSource.saveNotifications(list, notificationSource, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c9, code lost:
    
        if (r6.insertNotifications(r4, r0) == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object saveNotifications(java.util.List<com.box.android.data.api.models.inboxnotifications.InboxNotificationDTO> r7, com.box.android.data.persistence.inboxnotifications.NotificationSource r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.inboxnotifications.InboxNotificationLocalDataSource.saveNotifications(java.util.List, com.box.android.data.persistence.inboxnotifications.NotificationSource, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object getApiNotifications$default(InboxNotificationLocalDataSource inboxNotificationLocalDataSource, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        return inboxNotificationLocalDataSource.getApiNotifications(i, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getApiNotifications(int i, Continuation<? super List<InboxNotificationDTO>> continuation) {
        C11601 c11601;
        if (continuation instanceof C11601) {
            c11601 = (C11601) continuation;
            if ((c11601.label & Integer.MIN_VALUE) != 0) {
                c11601.label -= Integer.MIN_VALUE;
            } else {
                c11601 = new C11601(continuation);
            }
        } else {
            c11601 = new C11601(continuation);
        }
        Object apiNotifications = c11601.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c11601.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(apiNotifications);
            Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
            if (boxDatabase instanceof Result.Success) {
                InboxNotificationDao inboxNotificationDao = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).inboxNotificationDao();
                c11601.L$0 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                c11601.I$0 = i;
                c11601.label = 1;
                apiNotifications = inboxNotificationDao.getApiNotifications(i, c11601);
                if (apiNotifications == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (boxDatabase instanceof Result.Error) {
                    return CollectionsKt.emptyList();
                }
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c11601.I$0;
            ResultKt.throwOnFailure(apiNotifications);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) apiNotifications).iterator();
        while (it.hasNext()) {
            InboxNotificationDTO inboxNotificationDTOEntityToNotificationDto = entityToNotificationDto((InboxNotificationEntity) it.next());
            if (inboxNotificationDTOEntityToNotificationDto != null) {
                arrayList.add(inboxNotificationDTOEntityToNotificationDto);
            }
        }
        return arrayList;
    }

    public final Object updateReadStatus(String str, boolean z, Continuation<? super Unit> continuation) {
        Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
        if (boxDatabase instanceof Result.Success) {
            Object objUpdateReadStatus = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).inboxNotificationDao().updateReadStatus(str, z, continuation);
            return objUpdateReadStatus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateReadStatus : Unit.INSTANCE;
        }
        if (!(boxDatabase instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object cleanupIfNeeded(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        String str;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String currentContextId = this.userContextManager.getCurrentContextId();
            if (!Intrinsics.areEqual(currentContextId, this.lastCleanedUserId)) {
                anonymousClass1.L$0 = currentContextId;
                anonymousClass1.label = 1;
                if (deleteOldNotifications(MAX_CACHE_AGE_MILLIS, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = currentContextId;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) anonymousClass1.L$0;
        ResultKt.throwOnFailure(obj);
        this.lastCleanedUserId = str;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object deleteOldNotifications(long j, Continuation<? super Unit> continuation) {
        Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
        if (boxDatabase instanceof Result.Success) {
            Object objDeleteOldNotifications = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).inboxNotificationDao().deleteOldNotifications(System.currentTimeMillis() - j, continuation);
            return objDeleteOldNotifications == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteOldNotifications : Unit.INSTANCE;
        }
        if (!(boxDatabase instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    private final InboxNotificationEntity notificationDtoToEntity(InboxNotificationDTO dto, NotificationSource source) {
        Date date;
        String json = this.adapter.toJson(dto);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        try {
            Date date2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault()).parse(dto.getCreatedAt());
            date = new Date(date2 != null ? date2.getTime() : System.currentTimeMillis());
        } catch (Exception unused) {
            date = new Date();
        }
        return new InboxNotificationEntity(dto.getId(), dto.getType(), date, dto.isSeen(), dto.isRead(), bytes, new Date(), source);
    }

    private final InboxNotificationDTO entityToNotificationDto(InboxNotificationEntity entity) {
        try {
            InboxNotificationDTO inboxNotificationDTOFromJson = this.adapter.fromJson(new String(entity.getJsonData(), Charsets.UTF_8));
            if (inboxNotificationDTOFromJson != null) {
                return InboxNotificationDTO.copy$default(inboxNotificationDTOFromJson, null, null, null, entity.isSeen(), entity.isRead(), null, null, null, 231, null);
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
