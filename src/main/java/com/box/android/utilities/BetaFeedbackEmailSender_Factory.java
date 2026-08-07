package com.box.android.utilities;

import com.box.android.domain.services.IAppInfoService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class BetaFeedbackEmailSender_Factory implements Factory<BetaFeedbackEmailSender> {
    private final Provider<IAppInfoService> appInfoServiceProvider;
    private final Provider<EmailChooserHelper> emailChooserHelperProvider;

    private BetaFeedbackEmailSender_Factory(Provider<IAppInfoService> provider, Provider<EmailChooserHelper> provider2) {
        this.appInfoServiceProvider = provider;
        this.emailChooserHelperProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BetaFeedbackEmailSender get() {
        return newInstance(this.appInfoServiceProvider.get(), this.emailChooserHelperProvider.get());
    }

    public static BetaFeedbackEmailSender_Factory create(Provider<IAppInfoService> provider, Provider<EmailChooserHelper> provider2) {
        return new BetaFeedbackEmailSender_Factory(provider, provider2);
    }

    public static BetaFeedbackEmailSender newInstance(IAppInfoService iAppInfoService, EmailChooserHelper emailChooserHelper) {
        return new BetaFeedbackEmailSender(iAppInfoService, emailChooserHelper);
    }
}
