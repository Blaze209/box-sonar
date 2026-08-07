package com.box.android.data.di;

import com.box.android.data.service.impl.FavoritesService;
import com.box.android.domain.services.IFavoritesService;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;

/* JADX INFO: compiled from: ActivityRetainedDataModule.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, d2 = {"Lcom/box/android/data/di/ActivityRetainedDataModule;", "", "<init>", "()V", "provideFavoritesService", "Lcom/box/android/domain/services/IFavoritesService;", "favoritesService", "Lcom/box/android/data/service/impl/FavoritesService;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module
public abstract class ActivityRetainedDataModule {
    @Binds
    public abstract IFavoritesService provideFavoritesService(FavoritesService favoritesService);
}
