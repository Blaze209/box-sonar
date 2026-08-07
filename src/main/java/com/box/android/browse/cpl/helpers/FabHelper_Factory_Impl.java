package com.box.android.browse.cpl.helpers;

import com.box.android.base.presentation.activities.BoxFragmentActivity;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class FabHelper_Factory_Impl implements FabHelper.Factory {
    private final C0950FabHelper_Factory delegateFactory;

    FabHelper_Factory_Impl(C0950FabHelper_Factory c0950FabHelper_Factory) {
        this.delegateFactory = c0950FabHelper_Factory;
    }

    @Override // com.box.android.browse.cpl.helpers.FabHelper.Factory
    public FabHelper create(BoxFragmentActivity boxFragmentActivity) {
        return this.delegateFactory.get(boxFragmentActivity);
    }

    public static Provider<FabHelper.Factory> create(C0950FabHelper_Factory c0950FabHelper_Factory) {
        return InstanceFactory.create(new FabHelper_Factory_Impl(c0950FabHelper_Factory));
    }

    public static dagger.internal.Provider<FabHelper.Factory> createFactoryProvider(C0950FabHelper_Factory c0950FabHelper_Factory) {
        return InstanceFactory.create(new FabHelper_Factory_Impl(c0950FabHelper_Factory));
    }
}
