package com.box.android.activities;

import com.box.android.base.presentation.shake.BetaFeedbackManager;
import com.box.android.usercontext.UserContextManager;
import com.box.android.utilities.BetaFeedbackEmailSender;
import dagger.MembersInjector;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class BetaFeedbackActivity_MembersInjector implements MembersInjector<BetaFeedbackActivity> {
    private final Provider<BetaFeedbackEmailSender> betaFeedbackEmailSenderProvider;
    private final Provider<BetaFeedbackManager> betaFeedbackManagerProvider;
    private final Provider<UserContextManager> userContextManagerProvider;

    private BetaFeedbackActivity_MembersInjector(Provider<UserContextManager> provider, Provider<BetaFeedbackManager> provider2, Provider<BetaFeedbackEmailSender> provider3) {
        this.userContextManagerProvider = provider;
        this.betaFeedbackManagerProvider = provider2;
        this.betaFeedbackEmailSenderProvider = provider3;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BetaFeedbackActivity betaFeedbackActivity) {
        injectUserContextManager(betaFeedbackActivity, this.userContextManagerProvider.get());
        injectBetaFeedbackManager(betaFeedbackActivity, this.betaFeedbackManagerProvider.get());
        injectBetaFeedbackEmailSender(betaFeedbackActivity, this.betaFeedbackEmailSenderProvider.get());
    }

    public static MembersInjector<BetaFeedbackActivity> create(Provider<UserContextManager> provider, Provider<BetaFeedbackManager> provider2, Provider<BetaFeedbackEmailSender> provider3) {
        return new BetaFeedbackActivity_MembersInjector(provider, provider2, provider3);
    }

    public static void injectUserContextManager(BetaFeedbackActivity betaFeedbackActivity, UserContextManager userContextManager) {
        betaFeedbackActivity.userContextManager = userContextManager;
    }

    public static void injectBetaFeedbackManager(BetaFeedbackActivity betaFeedbackActivity, BetaFeedbackManager betaFeedbackManager) {
        betaFeedbackActivity.betaFeedbackManager = betaFeedbackManager;
    }

    public static void injectBetaFeedbackEmailSender(BetaFeedbackActivity betaFeedbackActivity, BetaFeedbackEmailSender betaFeedbackEmailSender) {
        betaFeedbackActivity.betaFeedbackEmailSender = betaFeedbackEmailSender;
    }
}
