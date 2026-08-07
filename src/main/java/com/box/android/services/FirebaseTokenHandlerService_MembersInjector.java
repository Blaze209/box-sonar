package com.box.android.services;

import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class FirebaseTokenHandlerService_MembersInjector implements MembersInjector<FirebaseTokenHandlerService> {
    private final Provider<FirebaseTokenRegistration> firebaseTokenRegistrationProvider;

    private FirebaseTokenHandlerService_MembersInjector(Provider<FirebaseTokenRegistration> provider) {
        this.firebaseTokenRegistrationProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FirebaseTokenHandlerService firebaseTokenHandlerService) {
        injectFirebaseTokenRegistration(firebaseTokenHandlerService, this.firebaseTokenRegistrationProvider.get());
    }

    public static MembersInjector<FirebaseTokenHandlerService> create(Provider<FirebaseTokenRegistration> provider) {
        return new FirebaseTokenHandlerService_MembersInjector(provider);
    }

    public static void injectFirebaseTokenRegistration(FirebaseTokenHandlerService firebaseTokenHandlerService, FirebaseTokenRegistration firebaseTokenRegistration) {
        firebaseTokenHandlerService.firebaseTokenRegistration = firebaseTokenRegistration;
    }
}
