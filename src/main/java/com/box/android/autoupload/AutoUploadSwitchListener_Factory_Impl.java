package com.box.android.autoupload;

import androidx.fragment.app.FragmentActivity;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class AutoUploadSwitchListener_Factory_Impl implements AutoUploadSwitchListener.Factory {
    private final C0920AutoUploadSwitchListener_Factory delegateFactory;

    AutoUploadSwitchListener_Factory_Impl(C0920AutoUploadSwitchListener_Factory c0920AutoUploadSwitchListener_Factory) {
        this.delegateFactory = c0920AutoUploadSwitchListener_Factory;
    }

    @Override // com.box.android.autoupload.AutoUploadSwitchListener.Factory
    public AutoUploadSwitchListener createListener(FragmentActivity fragmentActivity, Function1<? super Boolean, Unit> function1, Function0<Unit> function0) {
        return this.delegateFactory.get(fragmentActivity, function1, function0);
    }

    public static Provider<AutoUploadSwitchListener.Factory> create(C0920AutoUploadSwitchListener_Factory c0920AutoUploadSwitchListener_Factory) {
        return InstanceFactory.create(new AutoUploadSwitchListener_Factory_Impl(c0920AutoUploadSwitchListener_Factory));
    }

    public static dagger.internal.Provider<AutoUploadSwitchListener.Factory> createFactoryProvider(C0920AutoUploadSwitchListener_Factory c0920AutoUploadSwitchListener_Factory) {
        return InstanceFactory.create(new AutoUploadSwitchListener_Factory_Impl(c0920AutoUploadSwitchListener_Factory));
    }
}
