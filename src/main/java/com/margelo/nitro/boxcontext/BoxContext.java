package com.margelo.nitro.boxcontext;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.margelo.nitro.boxcontext.providers.AccountSettingsProvider;
import com.margelo.nitro.boxcontext.providers.AnalyticsProvider;
import com.margelo.nitro.boxcontext.providers.AuthProvider;
import com.margelo.nitro.boxcontext.providers.ConfigProvider;
import com.margelo.nitro.boxcontext.providers.HelloWorldProvider;
import com.margelo.nitro.boxcontext.providers.LoggingProvider;
import com.margelo.nitro.boxcontext.providers.UuidProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxContext.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00050\u0007¢\u0006\u0002\b\t¢\u0006\u0002\u0010\n¨\u0006\r"}, d2 = {"Lcom/margelo/nitro/boxcontext/BoxContext;", "", "<init>", "()V", "require", ExifInterface.GPS_DIRECTION_TRUE, "dep", "Lkotlin/Function1;", "Lcom/margelo/nitro/boxcontext/BoxContext$Dependencies;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Dependencies", "ServiceRegistry", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BoxContext {
    public static final BoxContext INSTANCE = new BoxContext();

    /* JADX INFO: compiled from: BoxContext.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\u000fHÆ\u0003J\t\u0010/\u001a\u00020\u0011HÆ\u0003J\t\u00100\u001a\u00020\u0013HÆ\u0003Jc\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u000208HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/margelo/nitro/boxcontext/BoxContext$Dependencies;", "", "applicationContext", "Landroid/content/Context;", "analyticsProvider", "Lcom/margelo/nitro/boxcontext/providers/AnalyticsProvider;", "helloWorldProvider", "Lcom/margelo/nitro/boxcontext/providers/HelloWorldProvider;", "loggingProvider", "Lcom/margelo/nitro/boxcontext/providers/LoggingProvider;", "authProvider", "Lcom/margelo/nitro/boxcontext/providers/AuthProvider;", "configProvider", "Lcom/margelo/nitro/boxcontext/providers/ConfigProvider;", "uuidProvider", "Lcom/margelo/nitro/boxcontext/providers/UuidProvider;", "contentUploadService", "Lcom/margelo/nitro/boxcontext/providers/ContentUploadService;", "accountSettingsProvider", "Lcom/margelo/nitro/boxcontext/providers/AccountSettingsProvider;", "<init>", "(Landroid/content/Context;Lcom/margelo/nitro/boxcontext/providers/AnalyticsProvider;Lcom/margelo/nitro/boxcontext/providers/HelloWorldProvider;Lcom/margelo/nitro/boxcontext/providers/LoggingProvider;Lcom/margelo/nitro/boxcontext/providers/AuthProvider;Lcom/margelo/nitro/boxcontext/providers/ConfigProvider;Lcom/margelo/nitro/boxcontext/providers/UuidProvider;Lcom/margelo/nitro/boxcontext/providers/ContentUploadService;Lcom/margelo/nitro/boxcontext/providers/AccountSettingsProvider;)V", "getApplicationContext", "()Landroid/content/Context;", "getAnalyticsProvider", "()Lcom/margelo/nitro/boxcontext/providers/AnalyticsProvider;", "getHelloWorldProvider", "()Lcom/margelo/nitro/boxcontext/providers/HelloWorldProvider;", "getLoggingProvider", "()Lcom/margelo/nitro/boxcontext/providers/LoggingProvider;", "getAuthProvider", "()Lcom/margelo/nitro/boxcontext/providers/AuthProvider;", "getConfigProvider", "()Lcom/margelo/nitro/boxcontext/providers/ConfigProvider;", "getUuidProvider", "()Lcom/margelo/nitro/boxcontext/providers/UuidProvider;", "getContentUploadService", "()Lcom/margelo/nitro/boxcontext/providers/ContentUploadService;", "getAccountSettingsProvider", "()Lcom/margelo/nitro/boxcontext/providers/AccountSettingsProvider;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Dependencies {
        private final AccountSettingsProvider accountSettingsProvider;
        private final AnalyticsProvider analyticsProvider;
        private final Context applicationContext;
        private final AuthProvider authProvider;
        private final ConfigProvider configProvider;
        private final com.margelo.nitro.boxcontext.providers.ContentUploadService contentUploadService;
        private final HelloWorldProvider helloWorldProvider;
        private final LoggingProvider loggingProvider;
        private final UuidProvider uuidProvider;

        public static /* synthetic */ Dependencies copy$default(Dependencies dependencies, Context context, AnalyticsProvider analyticsProvider, HelloWorldProvider helloWorldProvider, LoggingProvider loggingProvider, AuthProvider authProvider, ConfigProvider configProvider, UuidProvider uuidProvider, com.margelo.nitro.boxcontext.providers.ContentUploadService contentUploadService, AccountSettingsProvider accountSettingsProvider, int i, Object obj) {
            if ((i & 1) != 0) {
                context = dependencies.applicationContext;
            }
            if ((i & 2) != 0) {
                analyticsProvider = dependencies.analyticsProvider;
            }
            if ((i & 4) != 0) {
                helloWorldProvider = dependencies.helloWorldProvider;
            }
            if ((i & 8) != 0) {
                loggingProvider = dependencies.loggingProvider;
            }
            if ((i & 16) != 0) {
                authProvider = dependencies.authProvider;
            }
            if ((i & 32) != 0) {
                configProvider = dependencies.configProvider;
            }
            if ((i & 64) != 0) {
                uuidProvider = dependencies.uuidProvider;
            }
            if ((i & 128) != 0) {
                contentUploadService = dependencies.contentUploadService;
            }
            if ((i & 256) != 0) {
                accountSettingsProvider = dependencies.accountSettingsProvider;
            }
            com.margelo.nitro.boxcontext.providers.ContentUploadService contentUploadService2 = contentUploadService;
            AccountSettingsProvider accountSettingsProvider2 = accountSettingsProvider;
            ConfigProvider configProvider2 = configProvider;
            UuidProvider uuidProvider2 = uuidProvider;
            AuthProvider authProvider2 = authProvider;
            HelloWorldProvider helloWorldProvider2 = helloWorldProvider;
            return dependencies.copy(context, analyticsProvider, helloWorldProvider2, loggingProvider, authProvider2, configProvider2, uuidProvider2, contentUploadService2, accountSettingsProvider2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Context getApplicationContext() {
            return this.applicationContext;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AnalyticsProvider getAnalyticsProvider() {
            return this.analyticsProvider;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final HelloWorldProvider getHelloWorldProvider() {
            return this.helloWorldProvider;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final LoggingProvider getLoggingProvider() {
            return this.loggingProvider;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final AuthProvider getAuthProvider() {
            return this.authProvider;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ConfigProvider getConfigProvider() {
            return this.configProvider;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final UuidProvider getUuidProvider() {
            return this.uuidProvider;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final com.margelo.nitro.boxcontext.providers.ContentUploadService getContentUploadService() {
            return this.contentUploadService;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final AccountSettingsProvider getAccountSettingsProvider() {
            return this.accountSettingsProvider;
        }

        public final Dependencies copy(Context applicationContext, AnalyticsProvider analyticsProvider, HelloWorldProvider helloWorldProvider, LoggingProvider loggingProvider, AuthProvider authProvider, ConfigProvider configProvider, UuidProvider uuidProvider, com.margelo.nitro.boxcontext.providers.ContentUploadService contentUploadService, AccountSettingsProvider accountSettingsProvider) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            Intrinsics.checkNotNullParameter(analyticsProvider, "analyticsProvider");
            Intrinsics.checkNotNullParameter(helloWorldProvider, "helloWorldProvider");
            Intrinsics.checkNotNullParameter(loggingProvider, "loggingProvider");
            Intrinsics.checkNotNullParameter(authProvider, "authProvider");
            Intrinsics.checkNotNullParameter(configProvider, "configProvider");
            Intrinsics.checkNotNullParameter(uuidProvider, "uuidProvider");
            Intrinsics.checkNotNullParameter(contentUploadService, "contentUploadService");
            Intrinsics.checkNotNullParameter(accountSettingsProvider, "accountSettingsProvider");
            return new Dependencies(applicationContext, analyticsProvider, helloWorldProvider, loggingProvider, authProvider, configProvider, uuidProvider, contentUploadService, accountSettingsProvider);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dependencies)) {
                return false;
            }
            Dependencies dependencies = (Dependencies) other;
            return Intrinsics.areEqual(this.applicationContext, dependencies.applicationContext) && Intrinsics.areEqual(this.analyticsProvider, dependencies.analyticsProvider) && Intrinsics.areEqual(this.helloWorldProvider, dependencies.helloWorldProvider) && Intrinsics.areEqual(this.loggingProvider, dependencies.loggingProvider) && Intrinsics.areEqual(this.authProvider, dependencies.authProvider) && Intrinsics.areEqual(this.configProvider, dependencies.configProvider) && Intrinsics.areEqual(this.uuidProvider, dependencies.uuidProvider) && Intrinsics.areEqual(this.contentUploadService, dependencies.contentUploadService) && Intrinsics.areEqual(this.accountSettingsProvider, dependencies.accountSettingsProvider);
        }

        public int hashCode() {
            return (((((((((((((((this.applicationContext.hashCode() * 31) + this.analyticsProvider.hashCode()) * 31) + this.helloWorldProvider.hashCode()) * 31) + this.loggingProvider.hashCode()) * 31) + this.authProvider.hashCode()) * 31) + this.configProvider.hashCode()) * 31) + this.uuidProvider.hashCode()) * 31) + this.contentUploadService.hashCode()) * 31) + this.accountSettingsProvider.hashCode();
        }

        public String toString() {
            return "Dependencies(applicationContext=" + this.applicationContext + ", analyticsProvider=" + this.analyticsProvider + ", helloWorldProvider=" + this.helloWorldProvider + ", loggingProvider=" + this.loggingProvider + ", authProvider=" + this.authProvider + ", configProvider=" + this.configProvider + ", uuidProvider=" + this.uuidProvider + ", contentUploadService=" + this.contentUploadService + ", accountSettingsProvider=" + this.accountSettingsProvider + ")";
        }

        public Dependencies(Context applicationContext, AnalyticsProvider analyticsProvider, HelloWorldProvider helloWorldProvider, LoggingProvider loggingProvider, AuthProvider authProvider, ConfigProvider configProvider, UuidProvider uuidProvider, com.margelo.nitro.boxcontext.providers.ContentUploadService contentUploadService, AccountSettingsProvider accountSettingsProvider) {
            Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
            Intrinsics.checkNotNullParameter(analyticsProvider, "analyticsProvider");
            Intrinsics.checkNotNullParameter(helloWorldProvider, "helloWorldProvider");
            Intrinsics.checkNotNullParameter(loggingProvider, "loggingProvider");
            Intrinsics.checkNotNullParameter(authProvider, "authProvider");
            Intrinsics.checkNotNullParameter(configProvider, "configProvider");
            Intrinsics.checkNotNullParameter(uuidProvider, "uuidProvider");
            Intrinsics.checkNotNullParameter(contentUploadService, "contentUploadService");
            Intrinsics.checkNotNullParameter(accountSettingsProvider, "accountSettingsProvider");
            this.applicationContext = applicationContext;
            this.analyticsProvider = analyticsProvider;
            this.helloWorldProvider = helloWorldProvider;
            this.loggingProvider = loggingProvider;
            this.authProvider = authProvider;
            this.configProvider = configProvider;
            this.uuidProvider = uuidProvider;
            this.contentUploadService = contentUploadService;
            this.accountSettingsProvider = accountSettingsProvider;
        }

        public final Context getApplicationContext() {
            return this.applicationContext;
        }

        public final AnalyticsProvider getAnalyticsProvider() {
            return this.analyticsProvider;
        }

        public final HelloWorldProvider getHelloWorldProvider() {
            return this.helloWorldProvider;
        }

        public final LoggingProvider getLoggingProvider() {
            return this.loggingProvider;
        }

        public final AuthProvider getAuthProvider() {
            return this.authProvider;
        }

        public final ConfigProvider getConfigProvider() {
            return this.configProvider;
        }

        public final UuidProvider getUuidProvider() {
            return this.uuidProvider;
        }

        public final com.margelo.nitro.boxcontext.providers.ContentUploadService getContentUploadService() {
            return this.contentUploadService;
        }

        public final AccountSettingsProvider getAccountSettingsProvider() {
            return this.accountSettingsProvider;
        }
    }

    private BoxContext() {
    }

    /* JADX INFO: compiled from: BoxContext.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/margelo/nitro/boxcontext/BoxContext$ServiceRegistry;", "", "<init>", "()V", "initialized", "", "dependencies", "Lcom/margelo/nitro/boxcontext/BoxContext$Dependencies;", "register", "", "deps", "isInitialized", "getDependencies", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ServiceRegistry {
        public static final ServiceRegistry INSTANCE = new ServiceRegistry();
        private static Dependencies dependencies;
        private static volatile boolean initialized;

        private ServiceRegistry() {
        }

        public final void register(Dependencies deps) {
            Intrinsics.checkNotNullParameter(deps, "deps");
            if (initialized) {
                throw new IllegalStateException("BoxContext is already initialized");
            }
            dependencies = deps;
            initialized = true;
        }

        public final boolean isInitialized() {
            return initialized;
        }

        public final Dependencies getDependencies() {
            if (!isInitialized()) {
                throw new IllegalStateException("BoxContext is not initialized");
            }
            Dependencies dependencies2 = dependencies;
            if (dependencies2 != null) {
                return dependencies2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dependencies");
            return null;
        }
    }

    public final <T> T require(Function1<? super Dependencies, ? extends T> dep) {
        Intrinsics.checkNotNullParameter(dep, "dep");
        return dep.invoke(ServiceRegistry.INSTANCE.getDependencies());
    }
}
