package com.box.android.updates.di;

import android.content.Context;
import com.box.android.domain.services.IForceUpdateCoordinator;
import com.box.android.updates.force.ForceUpdateCoordinator;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppUpdatesModule.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\t"}, d2 = {"Lcom/box/android/updates/di/AppUpdatesModule;", "", "<init>", "()V", "bindForceUpdateCoordinator", "Lcom/box/android/domain/services/IForceUpdateCoordinator;", "forceUpdateCoordinator", "Lcom/box/android/updates/force/ForceUpdateCoordinator;", "Companion", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class AppUpdatesModule {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Singleton
    @Binds
    public abstract IForceUpdateCoordinator bindForceUpdateCoordinator(ForceUpdateCoordinator forceUpdateCoordinator);

    /* JADX INFO: compiled from: AppUpdatesModule.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/updates/di/AppUpdatesModule$Companion;", "", "<init>", "()V", "provideAppUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "context", "Landroid/content/Context;", "app-updates_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Provides
        @Singleton
        public final AppUpdateManager provideAppUpdateManager(@ApplicationContext Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppUpdateManager appUpdateManagerCreate = AppUpdateManagerFactory.create(context);
            Intrinsics.checkNotNullExpressionValue(appUpdateManagerCreate, "create(...)");
            return appUpdateManagerCreate;
        }
    }
}
