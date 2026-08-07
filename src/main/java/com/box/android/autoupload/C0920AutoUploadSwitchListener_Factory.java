package com.box.android.autoupload;

import androidx.fragment.app.FragmentActivity;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IJobService;
import dagger.internal.Provider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.box.android.autoupload.AutoUploadSwitchListener_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C0920AutoUploadSwitchListener_Factory {
    private final Provider<IJobService> jobServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private C0920AutoUploadSwitchListener_Factory(Provider<IUserContextManager> provider, Provider<IJobService> provider2) {
        this.userContextManagerProvider = provider;
        this.jobServiceProvider = provider2;
    }

    public AutoUploadSwitchListener get(FragmentActivity fragmentActivity, Function1<? super Boolean, Unit> function1, Function0<Unit> function0) {
        return newInstance(fragmentActivity, function1, function0, this.userContextManagerProvider.get(), this.jobServiceProvider.get());
    }

    public static C0920AutoUploadSwitchListener_Factory create(Provider<IUserContextManager> provider, Provider<IJobService> provider2) {
        return new C0920AutoUploadSwitchListener_Factory(provider, provider2);
    }

    public static AutoUploadSwitchListener newInstance(FragmentActivity fragmentActivity, Function1<? super Boolean, Unit> function1, Function0<Unit> function0, IUserContextManager iUserContextManager, IJobService iJobService) {
        return new AutoUploadSwitchListener(fragmentActivity, function1, function0, iUserContextManager, iJobService);
    }
}
