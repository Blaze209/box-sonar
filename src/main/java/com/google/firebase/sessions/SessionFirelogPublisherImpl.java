package com.google.firebase.sessions;

import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: SessionFirelogPublisher.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0011\u0010\u0016\u001a\u00020\u0015H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisherImpl;", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallations", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "sessionSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "eventGDTLogger", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/settings/SessionsSettings;Lcom/google/firebase/sessions/EventGDTLoggerInterface;Lkotlin/coroutines/CoroutineContext;)V", "attemptLoggingSessionEvent", "", "sessionEvent", "Lcom/google/firebase/sessions/SessionEvent;", "logSession", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "shouldCollectEvents", "", "shouldLogSession", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {
    private static final String TAG = "SessionFirelogPublisher";
    private final CoroutineContext backgroundDispatcher;
    private final EventGDTLoggerInterface eventGDTLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final SessionsSettings sessionSettings;
    private static final double randomValueForSampling = Math.random();

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SessionFirelogPublisher.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", i = {0}, l = {94}, m = "shouldLogSession", n = {"this"}, s = {"L$0"})
    static final class C18011 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C18011(Continuation<? super C18011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionFirelogPublisherImpl.this.shouldLogSession(this);
        }
    }

    public SessionFirelogPublisherImpl(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallations, SessionsSettings sessionSettings, EventGDTLoggerInterface eventGDTLogger, CoroutineContext backgroundDispatcher) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(firebaseInstallations, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(sessionSettings, "sessionSettings");
        Intrinsics.checkNotNullParameter(eventGDTLogger, "eventGDTLogger");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallations;
        this.sessionSettings = sessionSettings;
        this.eventGDTLogger = eventGDTLogger;
        this.backgroundDispatcher = backgroundDispatcher;
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: SessionFirelogPublisher.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", i = {2}, l = {63, 64, 70}, m = "invokeSuspend", n = {"installationId"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SessionDetails $sessionDetails;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SessionDetails sessionDetails, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sessionDetails = sessionDetails;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SessionFirelogPublisherImpl.this.new AnonymousClass1(this.$sessionDetails, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00a0  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            InstallationId installationId;
            SessionFirelogPublisherImpl sessionFirelogPublisherImpl;
            SessionEvents sessionEvents;
            FirebaseApp firebaseApp;
            SessionDetails sessionDetails;
            SessionsSettings sessionsSettings;
            Object registeredSubscribers$com_google_firebase_firebase_sessions;
            InstallationId installationId2;
            SessionEvents sessionEvents2;
            SessionDetails sessionDetails2;
            SessionsSettings sessionsSettings2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        installationId = (InstallationId) obj;
                        sessionFirelogPublisherImpl = SessionFirelogPublisherImpl.this;
                        sessionEvents = SessionEvents.INSTANCE;
                        firebaseApp = SessionFirelogPublisherImpl.this.firebaseApp;
                        sessionDetails = this.$sessionDetails;
                        sessionsSettings = SessionFirelogPublisherImpl.this.sessionSettings;
                        this.L$0 = installationId;
                        this.L$1 = sessionFirelogPublisherImpl;
                        this.L$2 = sessionEvents;
                        this.L$3 = firebaseApp;
                        this.L$4 = sessionDetails;
                        this.L$5 = sessionsSettings;
                        this.label = 3;
                        registeredSubscribers$com_google_firebase_firebase_sessions = FirebaseSessionsDependencies.INSTANCE.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
                        if (registeredSubscribers$com_google_firebase_firebase_sessions != coroutine_suspended) {
                            obj = registeredSubscribers$com_google_firebase_firebase_sessions;
                            installationId2 = installationId;
                            sessionEvents2 = sessionEvents;
                            sessionDetails2 = sessionDetails;
                            sessionsSettings2 = sessionsSettings;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    SessionsSettings sessionsSettings3 = (SessionsSettings) this.L$5;
                    SessionDetails sessionDetails3 = (SessionDetails) this.L$4;
                    FirebaseApp firebaseApp2 = (FirebaseApp) this.L$3;
                    SessionEvents sessionEvents3 = (SessionEvents) this.L$2;
                    sessionFirelogPublisherImpl = (SessionFirelogPublisherImpl) this.L$1;
                    installationId2 = (InstallationId) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    sessionsSettings2 = sessionsSettings3;
                    sessionEvents2 = sessionEvents3;
                    sessionDetails2 = sessionDetails3;
                    firebaseApp = firebaseApp2;
                }
                sessionFirelogPublisherImpl.attemptLoggingSessionEvent(sessionEvents2.buildSession(firebaseApp, sessionDetails2, sessionsSettings2, (Map) obj, installationId2.getFid(), installationId2.getAuthToken()));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = SessionFirelogPublisherImpl.this.shouldLogSession(this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
            if (((Boolean) obj).booleanValue()) {
                this.label = 2;
                obj = InstallationId.INSTANCE.create(SessionFirelogPublisherImpl.this.firebaseInstallations, this);
                if (obj != coroutine_suspended) {
                    installationId = (InstallationId) obj;
                    sessionFirelogPublisherImpl = SessionFirelogPublisherImpl.this;
                    sessionEvents = SessionEvents.INSTANCE;
                    firebaseApp = SessionFirelogPublisherImpl.this.firebaseApp;
                    sessionDetails = this.$sessionDetails;
                    sessionsSettings = SessionFirelogPublisherImpl.this.sessionSettings;
                    this.L$0 = installationId;
                    this.L$1 = sessionFirelogPublisherImpl;
                    this.L$2 = sessionEvents;
                    this.L$3 = firebaseApp;
                    this.L$4 = sessionDetails;
                    this.L$5 = sessionsSettings;
                    this.label = 3;
                    registeredSubscribers$com_google_firebase_firebase_sessions = FirebaseSessionsDependencies.INSTANCE.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
                    if (registeredSubscribers$com_google_firebase_firebase_sessions != coroutine_suspended) {
                        obj = registeredSubscribers$com_google_firebase_firebase_sessions;
                        installationId2 = installationId;
                        sessionEvents2 = sessionEvents;
                        sessionDetails2 = sessionDetails;
                        sessionsSettings2 = sessionsSettings;
                        sessionFirelogPublisherImpl.attemptLoggingSessionEvent(sessionEvents2.buildSession(firebaseApp, sessionDetails2, sessionsSettings2, (Map) obj, installationId2.getFid(), installationId2.getAuthToken()));
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.google.firebase.sessions.SessionFirelogPublisher
    public void logSession(SessionDetails sessionDetails) {
        Intrinsics.checkNotNullParameter(sessionDetails, "sessionDetails");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new AnonymousClass1(sessionDetails, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attemptLoggingSessionEvent(SessionEvent sessionEvent) {
        try {
            this.eventGDTLogger.log(sessionEvent);
            Log.d(TAG, "Successfully logged Session Start event: " + sessionEvent.getSessionData().getSessionId());
        } catch (RuntimeException e) {
            Log.e(TAG, "Error logging Session Start event to DataTransport: ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object shouldLogSession(Continuation<? super Boolean> continuation) {
        C18011 c18011;
        if (continuation instanceof C18011) {
            c18011 = (C18011) continuation;
            if ((c18011.label & Integer.MIN_VALUE) != 0) {
                c18011.label -= Integer.MIN_VALUE;
            } else {
                c18011 = new C18011(continuation);
            }
        } else {
            c18011 = new C18011(continuation);
        }
        Object obj = c18011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18011.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Log.d(TAG, "Data Collection is enabled for at least one Subscriber");
            SessionsSettings sessionsSettings = this.sessionSettings;
            c18011.L$0 = this;
            c18011.label = 1;
            if (sessionsSettings.updateSettings(c18011) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (SessionFirelogPublisherImpl) c18011.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (!this.sessionSettings.getSessionsEnabled()) {
            Log.d(TAG, "Sessions SDK disabled. Events will not be sent.");
            return Boxing.boxBoolean(false);
        }
        if (!this.shouldCollectEvents()) {
            Log.d(TAG, "Sessions SDK has dropped this session due to sampling.");
            return Boxing.boxBoolean(false);
        }
        return Boxing.boxBoolean(true);
    }

    private final boolean shouldCollectEvents() {
        return randomValueForSampling <= this.sessionSettings.getSamplingRate();
    }
}
