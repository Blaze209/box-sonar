package com.box.android.base.di;

import com.box.android.base.presentation.utilities.IPermissionsHandler;
import com.box.android.base.presentation.utilities.PermissionsHandler;
import com.box.android.common.utilities.threading.NamingThreadFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BaseModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\t"}, d2 = {"Lcom/box/android/base/di/BaseModule;", "", "<init>", "()V", "providePermissionsHandler", "Lcom/box/android/base/presentation/utilities/IPermissionsHandler;", "permissionsHandler", "Lcom/box/android/base/presentation/utilities/PermissionsHandler;", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class BaseModule {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Binds
    public abstract IPermissionsHandler providePermissionsHandler(PermissionsHandler permissionsHandler);

    /* JADX INFO: compiled from: BaseModule.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lcom/box/android/base/di/BaseModule$Companion;", "", "<init>", "()V", "provideApiExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Provides
        @Named("biometrics-executor")
        public final ThreadPoolExecutor provideApiExecutor() {
            return new ThreadPoolExecutor(1, 1, 3600L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamingThreadFactory("mBiometricExecutor"));
        }
    }
}
