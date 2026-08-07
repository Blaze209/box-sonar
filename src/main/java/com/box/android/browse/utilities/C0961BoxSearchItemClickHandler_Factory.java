package com.box.android.browse.utilities;

import androidx.appcompat.app.AppCompatActivity;
import com.box.android.base.presentation.utilities.IItemClickHandler;
import com.box.android.domain.identity.IUserContextManager;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.browse.utilities.BoxSearchItemClickHandler_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C0961BoxSearchItemClickHandler_Factory {
    private final Provider<IUserContextManager> userContextManagerProvider;

    private C0961BoxSearchItemClickHandler_Factory(Provider<IUserContextManager> provider) {
        this.userContextManagerProvider = provider;
    }

    public BoxSearchItemClickHandler get(IItemClickHandler iItemClickHandler, AppCompatActivity appCompatActivity) {
        return newInstance(this.userContextManagerProvider.get(), iItemClickHandler, appCompatActivity);
    }

    public static C0961BoxSearchItemClickHandler_Factory create(Provider<IUserContextManager> provider) {
        return new C0961BoxSearchItemClickHandler_Factory(provider);
    }

    public static BoxSearchItemClickHandler newInstance(IUserContextManager iUserContextManager, IItemClickHandler iItemClickHandler, AppCompatActivity appCompatActivity) {
        return new BoxSearchItemClickHandler(iUserContextManager, iItemClickHandler, appCompatActivity);
    }
}
