package com.box.android.domain.usecases.capture;

import android.content.SharedPreferences;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.services.IAppInBackgroundService;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LaunchIntoCaptureInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/box/android/domain/usecases/capture/LaunchIntoCaptureInteractor;", "Lcom/box/android/domain/usecases/capture/LaunchIntoCaptureUseCase;", "prefs", "Lcom/box/android/domain/localrepo/ILocalSharedPreferences;", "appInBackgroundService", "Lcom/box/android/domain/services/IAppInBackgroundService;", "<init>", "(Lcom/box/android/domain/localrepo/ILocalSharedPreferences;Lcom/box/android/domain/services/IAppInBackgroundService;)V", "launchIntoCapturePrefs", "Landroid/content/SharedPreferences;", "appStateListener", "Lcom/box/android/domain/services/IAppInBackgroundService$Listener;", "getAppStateListener$domain_prodRelease", "()Lcom/box/android/domain/services/IAppInBackgroundService$Listener;", "value", "", "launchIntoCapturePreference", "getLaunchIntoCapturePreference", "()Z", "setLaunchIntoCapturePreference", "(Z)V", "isPending", "clearPending", "", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LaunchIntoCaptureInteractor implements LaunchIntoCaptureUseCase {
    private static final Companion Companion = new Companion(null);
    private static boolean pendingCaptureLaunch = true;
    private final IAppInBackgroundService.Listener appStateListener;
    private final SharedPreferences launchIntoCapturePrefs;

    @Inject
    public LaunchIntoCaptureInteractor(ILocalSharedPreferences prefs, IAppInBackgroundService appInBackgroundService) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(appInBackgroundService, "appInBackgroundService");
        this.launchIntoCapturePrefs = prefs.getSharedPreferences(ILocalSharedPreferences.PreferenceName.LAUNCH_INTO_CAPTURE);
        IAppInBackgroundService.Listener listener = new IAppInBackgroundService.Listener() { // from class: com.box.android.domain.usecases.capture.LaunchIntoCaptureInteractor$appStateListener$1
            @Override // com.box.android.domain.services.IAppInBackgroundService.Listener
            public /* bridge */ void onMoveToForeground() {
                super.onMoveToForeground();
            }

            @Override // com.box.android.domain.services.IAppInBackgroundService.Listener
            public void onMoveToBackground() {
                LaunchIntoCaptureInteractor.Companion.setPendingCaptureLaunch(true);
            }
        };
        this.appStateListener = listener;
        appInBackgroundService.add(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: LaunchIntoCaptureInteractor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/box/android/domain/usecases/capture/LaunchIntoCaptureInteractor$Companion;", "", "<init>", "()V", "pendingCaptureLaunch", "", "getPendingCaptureLaunch", "()Z", "setPendingCaptureLaunch", "(Z)V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized boolean getPendingCaptureLaunch() {
            return LaunchIntoCaptureInteractor.pendingCaptureLaunch;
        }

        public final synchronized void setPendingCaptureLaunch(boolean z) {
            LaunchIntoCaptureInteractor.pendingCaptureLaunch = z;
        }
    }

    /* JADX INFO: renamed from: getAppStateListener$domain_prodRelease, reason: from getter */
    public final IAppInBackgroundService.Listener getAppStateListener() {
        return this.appStateListener;
    }

    @Override // com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase
    public boolean getLaunchIntoCapturePreference() {
        return this.launchIntoCapturePrefs.getBoolean("always_open_capture", false);
    }

    @Override // com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase
    public void setLaunchIntoCapturePreference(boolean z) {
        this.launchIntoCapturePrefs.edit().putBoolean("always_open_capture", z).apply();
    }

    @Override // com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase
    public boolean isPending() {
        return pendingCaptureLaunch && getLaunchIntoCapturePreference();
    }

    @Override // com.box.android.domain.usecases.capture.LaunchIntoCaptureUseCase
    public void clearPending() {
        pendingCaptureLaunch = false;
    }
}
