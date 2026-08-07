package com.box.android.data.mappers.annotation;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class CommentDTODomainMapper_Factory implements Factory<CommentDTODomainMapper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CommentDTODomainMapper get() {
        return newInstance();
    }

    public static CommentDTODomainMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CommentDTODomainMapper newInstance() {
        return new CommentDTODomainMapper();
    }

    private static final class InstanceHolder {
        static final CommentDTODomainMapper_Factory INSTANCE = new CommentDTODomainMapper_Factory();

        private InstanceHolder() {
        }
    }
}
