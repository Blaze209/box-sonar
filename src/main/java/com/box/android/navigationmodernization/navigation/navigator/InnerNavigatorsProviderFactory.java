package com.box.android.navigationmodernization.navigation.navigator;

import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.NavHostController;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import kotlin.Metadata;

/* JADX INFO: compiled from: InnerNavigatorsProviderFactory.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/navigator/InnerNavigatorsProviderFactory;", ExifInterface.GPS_DIRECTION_TRUE, "", PasskeyWebListener.CREATE_UNIQUE_KEY, "navController", "Landroidx/navigation/NavHostController;", "(Landroidx/navigation/NavHostController;)Ljava/lang/Object;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface InnerNavigatorsProviderFactory<T> {
    T create(NavHostController navController);
}
