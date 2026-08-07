package com.box.android.domain.usecases.capture;

import kotlin.Metadata;

/* JADX INFO: compiled from: LaunchIntoCaptureUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\nH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/capture/LaunchIntoCaptureUseCase;", "", "launchIntoCapturePreference", "", "getLaunchIntoCapturePreference", "()Z", "setLaunchIntoCapturePreference", "(Z)V", "isPending", "clearPending", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface LaunchIntoCaptureUseCase {
    void clearPending();

    boolean getLaunchIntoCapturePreference();

    boolean isPending();

    void setLaunchIntoCapturePreference(boolean z);
}
