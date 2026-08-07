package com.box.android.domain.configuration;

import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: compiled from: IProductFlavorConfig.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/configuration/IProductFlavorConfig;", "", "provideClientId", "Lkotlin/Pair;", "", "provideClientSecret", "provideAppName", "isAccountSwitchingEnabled", "", "shouldKillAppOnLogout", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IProductFlavorConfig {
    boolean isAccountSwitchingEnabled();

    String provideAppName();

    Pair<String, String> provideClientId();

    Pair<String, String> provideClientSecret();

    boolean shouldKillAppOnLogout();
}
