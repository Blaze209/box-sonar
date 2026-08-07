package com.box.android.fragments;

import com.box.android.usercontext.UserContextManager;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class EmailSupportFragment_MembersInjector implements MembersInjector<EmailSupportFragment> {
    private final Provider<UserContextManager> mUserContextManagerProvider;

    private EmailSupportFragment_MembersInjector(Provider<UserContextManager> provider) {
        this.mUserContextManagerProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(EmailSupportFragment emailSupportFragment) {
        injectMUserContextManager(emailSupportFragment, this.mUserContextManagerProvider.get());
    }

    public static MembersInjector<EmailSupportFragment> create(Provider<UserContextManager> provider) {
        return new EmailSupportFragment_MembersInjector(provider);
    }

    public static void injectMUserContextManager(EmailSupportFragment emailSupportFragment, UserContextManager userContextManager) {
        emailSupportFragment.mUserContextManager = userContextManager;
    }
}
