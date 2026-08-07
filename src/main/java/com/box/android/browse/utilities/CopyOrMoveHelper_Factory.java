package com.box.android.browse.utilities;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes10.dex */
public final class CopyOrMoveHelper_Factory implements Factory<CopyOrMoveHelper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CopyOrMoveHelper get() {
        return newInstance();
    }

    public static CopyOrMoveHelper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CopyOrMoveHelper newInstance() {
        return new CopyOrMoveHelper();
    }

    private static final class InstanceHolder {
        static final CopyOrMoveHelper_Factory INSTANCE = new CopyOrMoveHelper_Factory();

        private InstanceHolder() {
        }
    }
}
