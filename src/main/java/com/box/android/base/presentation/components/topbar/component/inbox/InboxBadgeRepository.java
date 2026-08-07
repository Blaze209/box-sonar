package com.box.android.base.presentation.components.topbar.component.inbox;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.domain.identity.IUserContextComponentListener;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IInboxNotificationService;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxTaskBadge;
import com.box.boxandroidlibv2private.requests.BoxRequestGetTaskBadge;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: InboxBadgeRepository.kt */
/* JADX INFO: loaded from: classes9.dex */
@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0014\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\u0017J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002J\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0017J\u0006\u0010\u001a\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/android/base/presentation/components/topbar/component/inbox/InboxBadgeRepository;", "", "baseMoCo", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "boxApiPrivate", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "inboxNotificationService", "Lcom/box/android/domain/services/IInboxNotificationService;", "<init>", "(Lcom/box/android/coreservices/modelcontroller/IBaseModelController;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/domain/services/IInboxNotificationService;)V", "statusLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/box/androidsdk/content/requests/BoxResponse;", "Lcom/box/boxandroidlibv2private/model/BoxTaskBadge;", "unseenNotificationsCountLiveData", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "updateBothBadgeCounts", "", "getTaskBadge", "Landroidx/lifecycle/LiveData;", "fetchTaskBadgeCount", "getNotificationBadgeCount", "updateNotificationBadgeCount", "fetchNotificationBadgeCount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxBadgeRepository {
    private static final String NOTIFICATIONS_BADGE_LISTENER_NAME = "NotificationsBadge";
    private final IBaseModelController baseMoCo;
    private final BoxApiPrivate boxApiPrivate;
    private final CoroutineScope coroutineScope;
    private final IInboxNotificationService inboxNotificationService;
    private final MutableLiveData<BoxResponse<BoxTaskBadge>> statusLiveData;
    private final MutableLiveData<Integer> unseenNotificationsCountLiveData;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository$fetchNotificationBadgeCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxBadgeRepository.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository", f = "InboxBadgeRepository.kt", i = {1, 1}, l = {94, 100}, m = "fetchNotificationBadgeCount", n = {"notificationsResult", "topNotificationId"}, s = {"L$0", "L$1"}, v = 1)
    static final class C09231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09231(Continuation<? super C09231> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InboxBadgeRepository.this.fetchNotificationBadgeCount(this);
        }
    }

    @Inject
    public InboxBadgeRepository(IBaseModelController baseMoCo, BoxApiPrivate boxApiPrivate, IUserContextManager userContextManager, IInboxNotificationService inboxNotificationService) {
        Intrinsics.checkNotNullParameter(baseMoCo, "baseMoCo");
        Intrinsics.checkNotNullParameter(boxApiPrivate, "boxApiPrivate");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(inboxNotificationService, "inboxNotificationService");
        this.baseMoCo = baseMoCo;
        this.boxApiPrivate = boxApiPrivate;
        this.inboxNotificationService = inboxNotificationService;
        this.statusLiveData = new MutableLiveData<>();
        this.unseenNotificationsCountLiveData = new MutableLiveData<>();
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        userContextManager.addUserContextListener(NOTIFICATIONS_BADGE_LISTENER_NAME, new IUserContextComponentListener() { // from class: com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository.1
            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onCreate(String contextId) {
                Intrinsics.checkNotNullParameter(contextId, "contextId");
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onSoftDestroy() {
                InboxBadgeRepository.this.statusLiveData.postValue(null);
                InboxBadgeRepository.this.unseenNotificationsCountLiveData.postValue(null);
            }

            @Override // com.box.android.domain.identity.IUserContextComponentListener
            public void onHardDestroy() {
                InboxBadgeRepository.this.statusLiveData.postValue(null);
                InboxBadgeRepository.this.unseenNotificationsCountLiveData.postValue(null);
            }
        });
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository$updateBothBadgeCounts$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxBadgeRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository$updateBothBadgeCounts$1", f = "InboxBadgeRepository.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {69, 70}, m = "invokeSuspend", n = {"$this$launch", "taskDeferred", "notificationDeferred", "$this$launch", "taskDeferred", "notificationDeferred", "taskResult"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C09241 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C09241(Continuation<? super C09241> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09241 c09241 = InboxBadgeRepository.this.new C09241(continuation);
            c09241.L$0 = obj;
            return c09241;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09241) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Deferred deferredAsync$default;
            Deferred deferred;
            BoxResponse boxResponse;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Deferred deferredAsync$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new InboxBadgeRepository$updateBothBadgeCounts$1$taskDeferred$1(InboxBadgeRepository.this, null), 3, null);
                deferredAsync$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new InboxBadgeRepository$updateBothBadgeCounts$1$notificationDeferred$1(InboxBadgeRepository.this, null), 3, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(deferredAsync$default2);
                this.L$2 = deferredAsync$default;
                this.label = 1;
                Object objAwait = deferredAsync$default2.await(this);
                if (objAwait != coroutine_suspended) {
                    deferred = deferredAsync$default2;
                    obj = objAwait;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                deferredAsync$default = (Deferred) this.L$2;
                deferred = (Deferred) this.L$1;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boxResponse = (BoxResponse) this.L$3;
                ResultKt.throwOnFailure(obj);
            }
            int iIntValue = ((Number) obj).intValue();
            InboxBadgeRepository.this.statusLiveData.postValue(boxResponse);
            InboxBadgeRepository.this.unseenNotificationsCountLiveData.postValue(Boxing.boxInt(iIntValue));
            return Unit.INSTANCE;
            BoxResponse boxResponse2 = (BoxResponse) obj;
            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.L$1 = SpillingKt.nullOutSpilledVariable(deferred);
            this.L$2 = SpillingKt.nullOutSpilledVariable(deferredAsync$default);
            this.L$3 = boxResponse2;
            this.label = 2;
            Object objAwait2 = deferredAsync$default.await(this);
            if (objAwait2 != coroutine_suspended) {
                boxResponse = boxResponse2;
                obj = objAwait2;
                int iIntValue2 = ((Number) obj).intValue();
                InboxBadgeRepository.this.statusLiveData.postValue(boxResponse);
                InboxBadgeRepository.this.unseenNotificationsCountLiveData.postValue(Boxing.boxInt(iIntValue2));
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
    }

    public final void updateBothBadgeCounts() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C09241(null), 3, null);
    }

    public final LiveData<BoxResponse<BoxTaskBadge>> getTaskBadge() {
        return this.statusLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BoxResponse<BoxTaskBadge> fetchTaskBadgeCount() {
        BoxRequestGetTaskBadge taskBadge = this.boxApiPrivate.getTaskBadge();
        IBaseModelController iBaseModelController = this.baseMoCo;
        Intrinsics.checkNotNull(taskBadge);
        return (BoxResponse) iBaseModelController.performRemote(taskBadge).get();
    }

    public final LiveData<Integer> getNotificationBadgeCount() {
        return this.unseenNotificationsCountLiveData;
    }

    /* JADX INFO: renamed from: com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository$updateNotificationBadgeCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxBadgeRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository$updateNotificationBadgeCount$1", f = "InboxBadgeRepository.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C09251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09251(Continuation<? super C09251> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InboxBadgeRepository.this.new C09251(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = InboxBadgeRepository.this.fetchNotificationBadgeCount(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            InboxBadgeRepository.this.unseenNotificationsCountLiveData.postValue(Boxing.boxInt(((Number) obj).intValue()));
            return Unit.INSTANCE;
        }
    }

    public final void updateNotificationBadgeCount() {
        BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new C09251(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a9, code lost:
    
        if (r12 == r0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchNotificationBadgeCount(kotlin.coroutines.Continuation<? super java.lang.Integer> r12) {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.base.presentation.components.topbar.component.inbox.InboxBadgeRepository.fetchNotificationBadgeCount(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
