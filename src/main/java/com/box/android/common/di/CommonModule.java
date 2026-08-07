package com.box.android.common.di;

import com.box.android.common.utilities.AndroidResourcesProvider;
import com.box.android.common.utilities.Clock;
import com.box.android.common.utilities.ResourcesProvider;
import com.box.android.common.utilities.SystemClock;
import com.box.android.cpl.IStoreFactory;
import com.box.android.cpl.StoreFactory;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CommonModule.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/box/android/common/di/CommonModule;", "", "<init>", "()V", "providesDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "providesIoDispatcher", "providesMainDispatcher", "providesStoreFactory", "Lcom/box/android/cpl/IStoreFactory;", "providesClock", "Lcom/box/android/common/utilities/Clock;", "providesResourcesProvider", "Lcom/box/android/common/utilities/ResourcesProvider;", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public final class CommonModule {
    public static final CommonModule INSTANCE = new CommonModule();

    private CommonModule() {
    }

    @Provides
    public final CoroutineDispatcher providesDefaultDispatcher() {
        return Dispatchers.getDefault();
    }

    @Provides
    public final CoroutineDispatcher providesIoDispatcher() {
        return Dispatchers.getIO();
    }

    @Provides
    public final CoroutineDispatcher providesMainDispatcher() {
        return Dispatchers.getMain();
    }

    @Provides
    public final IStoreFactory providesStoreFactory() {
        return new StoreFactory();
    }

    @Provides
    public final Clock providesClock() {
        return SystemClock.INSTANCE;
    }

    @Provides
    public final ResourcesProvider providesResourcesProvider() {
        return new AndroidResourcesProvider();
    }
}
