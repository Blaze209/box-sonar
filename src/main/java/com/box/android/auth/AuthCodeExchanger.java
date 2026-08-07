package com.box.android.auth;

import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthCodeExchanger.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/auth/AuthCodeExchanger;", "", "executor", "Ljava/util/concurrent/Executor;", "<init>", "(Ljava/util/concurrent/Executor;)V", "()V", "exchange", "", "session", "Lcom/box/android/coreservices/models/CustomBoxSession;", BoxNoteConstants.NOTES_BUILDER_AUTH_CODE, "", "devpodAuthority", "onComplete", "Lkotlin/Function0;", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthCodeExchanger {

    @Deprecated
    public static final String EXCHANGE_FAILURE_MESSAGE = "auth_code exchange failed";

    @Deprecated
    public static final String TAG = "AuthCodeExchanger";
    private final Executor executor;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public AuthCodeExchanger(Executor executor) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.executor = executor;
    }

    public AuthCodeExchanger() {
        this(new Executor() { // from class: com.box.android.auth.AuthCodeExchanger$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                AuthCodeExchanger._init_$lambda$0(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(Runnable runnable) {
        new Thread(runnable).start();
    }

    public final void exchange(final CustomBoxSession session, final String authCode, final String devpodAuthority, final Function0<Unit> onComplete) {
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(authCode, "authCode");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        this.executor.execute(new Runnable() { // from class: com.box.android.auth.AuthCodeExchanger$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthCodeExchanger.exchange$lambda$0(devpodAuthority, session, authCode, onComplete);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exchange$lambda$0(String str, CustomBoxSession customBoxSession, String str2, Function0 function0) {
        if (str != null) {
            customBoxSession.getAuthInfo().setBaseDomain(str);
        }
        try {
            BoxAuthentication.getInstance().create(customBoxSession, str2, null).get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            BoxLogUtils.e(TAG, EXCHANGE_FAILURE_MESSAGE, e);
        } catch (ExecutionException e2) {
            ExecutionException cause = e2.getCause();
            if (cause == null) {
                cause = e2;
            }
            BoxLogUtils.e(TAG, EXCHANGE_FAILURE_MESSAGE, cause);
        }
        function0.invoke();
    }

    /* JADX INFO: compiled from: AuthCodeExchanger.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/box/android/auth/AuthCodeExchanger$Companion;", "", "<init>", "()V", "TAG", "", "EXCHANGE_FAILURE_MESSAGE", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
