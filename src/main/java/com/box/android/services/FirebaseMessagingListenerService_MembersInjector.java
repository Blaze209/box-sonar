package com.box.android.services;

import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class FirebaseMessagingListenerService_MembersInjector implements MembersInjector<FirebaseMessagingListenerService> {
    private final Provider<FirebaseMessagingListenerServiceHelper> helperProvider;

    private FirebaseMessagingListenerService_MembersInjector(Provider<FirebaseMessagingListenerServiceHelper> provider) {
        this.helperProvider = provider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(FirebaseMessagingListenerService firebaseMessagingListenerService) {
        injectHelper(firebaseMessagingListenerService, this.helperProvider.get());
    }

    public static MembersInjector<FirebaseMessagingListenerService> create(Provider<FirebaseMessagingListenerServiceHelper> provider) {
        return new FirebaseMessagingListenerService_MembersInjector(provider);
    }

    public static void injectHelper(FirebaseMessagingListenerService firebaseMessagingListenerService, FirebaseMessagingListenerServiceHelper firebaseMessagingListenerServiceHelper) {
        firebaseMessagingListenerService.helper = firebaseMessagingListenerServiceHelper;
    }
}
