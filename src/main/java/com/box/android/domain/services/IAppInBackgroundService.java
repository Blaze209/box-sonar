package com.box.android.domain.services;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* JADX INFO: compiled from: IAppInBackgroundService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IAppInBackgroundService;", "", "isAppInBackground", "", "add", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/box/android/domain/services/IAppInBackgroundService$Listener;", "remove", "Listener", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAppInBackgroundService {
    void add(Listener listener);

    boolean isAppInBackground();

    void remove(Listener listener);

    /* JADX INFO: compiled from: IAppInBackgroundService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IAppInBackgroundService$Listener;", "", "onMoveToForeground", "", "onMoveToBackground", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Listener {
        default void onMoveToBackground() {
        }

        default void onMoveToForeground() {
        }

        /* JADX INFO: compiled from: IAppInBackgroundService.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class DefaultImpls {
            @Deprecated
            public static void onMoveToForeground(Listener listener) {
                Listener.super.onMoveToForeground();
            }

            @Deprecated
            public static void onMoveToBackground(Listener listener) {
                Listener.super.onMoveToBackground();
            }
        }
    }
}
