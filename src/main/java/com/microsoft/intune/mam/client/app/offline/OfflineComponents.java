package com.microsoft.intune.mam.client.app.offline;

import android.content.Context;
import android.os.Build;
import com.microsoft.intune.mam.Version;
import com.microsoft.intune.mam.client.OutdatedAgentChecker;
import com.microsoft.intune.mam.client.app.ActivityBehavior;
import com.microsoft.intune.mam.client.app.ActivityLifecycleMonitorBase;
import com.microsoft.intune.mam.client.app.AllowedAccountsBehavior;
import com.microsoft.intune.mam.client.app.AllowedAccountsBehaviorImpl;
import com.microsoft.intune.mam.client.app.DialogFragmentBehavior;
import com.microsoft.intune.mam.client.app.DownloadManagementBehavior;
import com.microsoft.intune.mam.client.app.FragmentBehavior;
import com.microsoft.intune.mam.client.app.IntentServiceBehavior;
import com.microsoft.intune.mam.client.app.JobIntentServiceBehavior;
import com.microsoft.intune.mam.client.app.LazyInit;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.client.app.MAMDownloadQueryFactory;
import com.microsoft.intune.mam.client.app.MAMDownloadRequestFactory;
import com.microsoft.intune.mam.client.app.NotificationManagementBehavior;
import com.microsoft.intune.mam.client.app.OfflineDownloadManagementBehavior;
import com.microsoft.intune.mam.client.app.OfflineLocalSettings;
import com.microsoft.intune.mam.client.app.OfflineThemeManagerBehavior;
import com.microsoft.intune.mam.client.app.ServiceBehavior;
import com.microsoft.intune.mam.client.app.ThemeManagerBehavior;
import com.microsoft.intune.mam.client.app.UserLocalSettings;
import com.microsoft.intune.mam.client.app.WrappedAppReflectionUtilsBehavior;
import com.microsoft.intune.mam.client.app.appsearch.SearchResultsManagementBehavior;
import com.microsoft.intune.mam.client.app.appsearch.SearchSessionManagementBehavior;
import com.microsoft.intune.mam.client.app.backup.BackupAgentBehavior;
import com.microsoft.intune.mam.client.app.backup.BackupAgentHelperBehavior;
import com.microsoft.intune.mam.client.app.backup.FileBackupHelperBehavior;
import com.microsoft.intune.mam.client.app.backup.SharedPreferencesBackupHelperBehavior;
import com.microsoft.intune.mam.client.app.data.OfflineUserDataWiper;
import com.microsoft.intune.mam.client.app.job.JobServiceBehavior;
import com.microsoft.intune.mam.client.app.job.OfflineJobServiceBehavior;
import com.microsoft.intune.mam.client.app.ui.MAMUIHelper;
import com.microsoft.intune.mam.client.app.ui.OfflineMAMUIHelperBehavior;
import com.microsoft.intune.mam.client.blobstore.BlobStoreManagerBehavior;
import com.microsoft.intune.mam.client.blobstore.OfflineBlobStoreManagerBehavior;
import com.microsoft.intune.mam.client.config.ConfigOnlyModeBehavior;
import com.microsoft.intune.mam.client.content.ClipboardBehavior;
import com.microsoft.intune.mam.client.content.CloudMediaProviderBehavior;
import com.microsoft.intune.mam.client.content.ContentProviderBehavior;
import com.microsoft.intune.mam.client.content.ContentProviderBehaviorJellyBean;
import com.microsoft.intune.mam.client.content.ContentProviderClientManagementBehavior;
import com.microsoft.intune.mam.client.content.ContentResolverManagementBehavior;
import com.microsoft.intune.mam.client.content.DocumentsProviderBehavior;
import com.microsoft.intune.mam.client.content.FileProviderBehavior;
import com.microsoft.intune.mam.client.content.FileProviderBehaviorJellyBean;
import com.microsoft.intune.mam.client.content.PassthroughContentProviderClientManagementBehavior;
import com.microsoft.intune.mam.client.content.PassthroughContentResolverManagementBehavior;
import com.microsoft.intune.mam.client.content.offline.OfflineClipboardBehavior;
import com.microsoft.intune.mam.client.content.pm.OfflinePackageManagementBehavior;
import com.microsoft.intune.mam.client.content.pm.OfflinePackageManagementBehaviorTiramisu;
import com.microsoft.intune.mam.client.content.pm.OfflinePackageManagementBehaviorVanillaIceCream;
import com.microsoft.intune.mam.client.content.pm.PackageManagementBehavior;
import com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorTiramisu;
import com.microsoft.intune.mam.client.content.pm.PackageManagementBehaviorVanillaIceCream;
import com.microsoft.intune.mam.client.identity.DataProtectionManagerBehavior;
import com.microsoft.intune.mam.client.identity.IdentityParamConverter;
import com.microsoft.intune.mam.client.identity.IdentityParamConverterBase;
import com.microsoft.intune.mam.client.identity.MAMIdentityManager;
import com.microsoft.intune.mam.client.identity.MAMPolicyManagerBehavior;
import com.microsoft.intune.mam.client.identity.OfflineDataProtectionManagerBehavior;
import com.microsoft.intune.mam.client.ipcclient.MAMNotificationReceiverRegistryImpl;
import com.microsoft.intune.mam.client.lifecycle.LifecycleSuppressionRegistry;
import com.microsoft.intune.mam.client.lifecycle.OfflineActivityLifecycleCallbacksFactory;
import com.microsoft.intune.mam.client.lifecycle.OfflineLifecycleSuppressionRegistry;
import com.microsoft.intune.mam.client.media.MediaRecorderBehavior;
import com.microsoft.intune.mam.client.media.OfflineMediaRecorderBehavior;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistry;
import com.microsoft.intune.mam.client.notification.MAMNotificationReceiverRegistryInternal;
import com.microsoft.intune.mam.client.notification.OfflineCompanyPortalInstallReceiver;
import com.microsoft.intune.mam.client.print.OfflinePrintManagementBehavior;
import com.microsoft.intune.mam.client.print.PrintManagementBehavior;
import com.microsoft.intune.mam.client.service.MAMBackgroundJobServiceBehavior;
import com.microsoft.intune.mam.client.strict.OfflineStrictGlobalSettings;
import com.microsoft.intune.mam.client.strict.OfflineStrictThreadSettings;
import com.microsoft.intune.mam.client.strict.StrictGlobalSettings;
import com.microsoft.intune.mam.client.strict.StrictThreadSettings;
import com.microsoft.intune.mam.client.telemetry.FileCacheTelemetryLogger;
import com.microsoft.intune.mam.client.telemetry.SessionDurationStore;
import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import com.microsoft.intune.mam.client.view.DragEventManagementBehavior;
import com.microsoft.intune.mam.client.view.LayoutInflaterManagementBehavior;
import com.microsoft.intune.mam.client.view.OfflineDragEventManagementBehavior;
import com.microsoft.intune.mam.client.view.OfflineLayoutInflaterManagementBehavior;
import com.microsoft.intune.mam.client.view.OfflineSurfaceViewBehavior;
import com.microsoft.intune.mam.client.view.OfflineTextViewBehavior;
import com.microsoft.intune.mam.client.view.OfflineViewGroupBehavior;
import com.microsoft.intune.mam.client.view.OfflineViewManagementBehavior;
import com.microsoft.intune.mam.client.view.OfflineWebViewBehavior;
import com.microsoft.intune.mam.client.view.OfflineWindowManagementBehavior;
import com.microsoft.intune.mam.client.view.SurfaceViewBehavior;
import com.microsoft.intune.mam.client.view.TextViewBehavior;
import com.microsoft.intune.mam.client.view.ViewGroupBehavior;
import com.microsoft.intune.mam.client.view.ViewManagementBehavior;
import com.microsoft.intune.mam.client.view.WebViewBehavior;
import com.microsoft.intune.mam.client.view.WindowManagementBehavior;
import com.microsoft.intune.mam.client.widget.OfflinePopupInstanceBehavior;
import com.microsoft.intune.mam.client.widget.OfflinePopupStaticBehavior;
import com.microsoft.intune.mam.client.widget.PopupInstanceBehavior;
import com.microsoft.intune.mam.client.widget.PopupStaticBehavior;
import com.microsoft.intune.mam.http.CertChainValidatorFactory;
import com.microsoft.intune.mam.http.OfflineCertChainValidatorFactory;
import com.microsoft.intune.mam.http.OfflineTrustedRootCertsManagerBehavior;
import com.microsoft.intune.mam.http.OfflineWebViewClientBehavior;
import com.microsoft.intune.mam.http.TrustedRootCertsManagerBehavior;
import com.microsoft.intune.mam.http.WebViewClientBehavior;
import com.microsoft.intune.mam.log.MAMLogHandlerWrapper;
import com.microsoft.intune.mam.log.MAMLogHandlerWrapperImpl;
import com.microsoft.intune.mam.log.MAMLogManager;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.policy.AppPolicy;
import com.microsoft.intune.mam.policy.MAMComplianceManager;
import com.microsoft.intune.mam.policy.MAMDiagnosticLogManager;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import com.microsoft.intune.mam.policy.MAMEnrollmentStatusCache;
import com.microsoft.intune.mam.policy.MAMUserInfo;
import com.microsoft.intune.mam.policy.MAMWEAccountManager;
import com.microsoft.intune.mam.policy.MAMWEEnroller;
import com.microsoft.intune.mam.policy.UserStatusManagerBehavior;
import com.microsoft.intune.mam.policy.appconfig.MAMAppConfigManager;
import com.microsoft.intune.mam.policy.cache.MAMEnrolledIdentitiesCache;
import com.microsoft.intune.mam.policy.cache.MAMServiceUrlCache;
import com.microsoft.intune.mam.policy.notification.NotificationReceiverBinderFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class OfflineComponents {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(OfflineComponents.class);
    private static final MAMNotificationReceiverRegistryImpl NOTIFICATION_RECEIVER_REGISTRY = new MAMNotificationReceiverRegistryImpl();
    private static LazyInit<FileCacheTelemetryLogger> mOfflineTelemetryLogger = new LazyInit<>(new LazyInit.Provider<FileCacheTelemetryLogger>() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public FileCacheTelemetryLogger get() {
            return new FileCacheTelemetryLogger(OfflineComponents.mContext.get(), true, new Version(11, 0, 0), (SessionDurationStore) OfflineComponents.mSessionDurationStore.get());
        }
    });
    private static volatile ContextProvider mContext = new UninitializedContextProvider();
    private static LazyInit<OfflineMAMEnrollmentManager> mEnrollmentManager = new LazyInit<>(new LazyInit.Provider<OfflineMAMEnrollmentManager>() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public OfflineMAMEnrollmentManager get() {
            return new OfflineMAMEnrollmentManager(OfflineComponents.mContext.get(), OfflineComponents.NOTIFICATION_RECEIVER_REGISTRY, (MAMIdentityManager) OfflineComponents.mMAMIdentityManager.get(), (TelemetryLogger) OfflineComponents.mOfflineTelemetryLogger.get(), (MAMLogPIIFactory) OfflineComponents.mMAMLogPIIFactory.get(), (MAMEnrollmentStatusCache) OfflineComponents.mMAMEnrollmentStatusCache.get(), (MAMServiceUrlCache) OfflineComponents.mMAMServiceUrlCache.get());
        }
    });
    private static LazyInit<MAMWEAccountManager> mMAMWEAccountManager = new LazyInit<>(new LazyInit.Provider<MAMWEAccountManager>() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public MAMWEAccountManager get() {
            return MAMWEAccountManager.create(OfflineComponents.mContext.get(), (MAMLogPIIFactory) OfflineComponents.mMAMLogPIIFactory.get(), new OfflineMAMWERetryScheduler((MAMWEEnroller) OfflineComponents.mEnrollmentManager.get(), (MAMIdentityManager) OfflineComponents.mMAMIdentityManager.get(), (MAMLogPIIFactory) OfflineComponents.mMAMLogPIIFactory.get(), OfflineComponents.mContext.get(), (MAMServiceUrlCache) OfflineComponents.mMAMServiceUrlCache.get()));
        }
    });
    private static LazyInit<OfflineMAMIdentityManager> mMAMIdentityManager = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda0
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return OfflineComponents.lambda$static$0();
        }
    });
    private static LazyInit<MAMLogPIIFactory> mMAMLogPIIFactory = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda14
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return OfflineComponents.lambda$static$1();
        }
    });
    private static LazyInit<IdentityParamConverter> mIdentityParamConverter = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda15
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return OfflineComponents.lambda$static$2();
        }
    });
    private static LazyInit<MAMLogHandlerWrapper> mMAMLogHandlerWrapper = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda16
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return new MAMLogHandlerWrapperImpl();
        }
    });
    private static LazyInit<OfflineMAMLogManager> mMAMLogManager = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda1
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return OfflineComponents.lambda$static$3();
        }
    });
    private static LazyInit<OfflineActivityLifecycleMonitor> mActivityLifecycleMonitor = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda2
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return new OfflineActivityLifecycleMonitor();
        }
    });
    private static LazyInit<OfflineLocalSettings> mLocalSettings = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda3
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return OfflineComponents.lambda$static$4();
        }
    });
    private static LazyInit<UserLocalSettings> mUserLocalSettings = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda4
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return OfflineComponents.lambda$static$5();
        }
    });
    private static LazyInit<MAMEnrollmentStatusCache> mMAMEnrollmentStatusCache = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda5
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return OfflineComponents.lambda$static$6();
        }
    });
    private static LazyInit<MAMEnrolledIdentitiesCache> mMAMEnrolledIdentitiesCache = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda6
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return OfflineComponents.lambda$static$7();
        }
    });
    private static LazyInit<MAMServiceUrlCache> mMAMServiceUrlCache = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda8
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return OfflineComponents.lambda$static$8();
        }
    });
    private static LazyInit<SessionDurationStore> mSessionDurationStore = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda9
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return OfflineComponents.lambda$static$9();
        }
    });
    private static LazyInit<OfflineCompanyPortalInstallReceiver> mInstallReceiver = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda10
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return new OfflineCompanyPortalInstallReceiver();
        }
    });
    private static LazyInit<OfflineThemeManagerBehavior> mThemeManager = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda11
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return new OfflineThemeManagerBehavior();
        }
    });
    private static LazyInit<LifecycleSuppressionRegistry> mLifecycleSuppressionRegistry = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda12
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return new OfflineLifecycleSuppressionRegistry();
        }
    });
    private static LazyInit<OfflineMAMDiagnosticLogManager> mMAMDiagnosticLogManager = new LazyInit<>(new LazyInit.Provider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda13
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public final Object get() {
            return new OfflineMAMDiagnosticLogManager();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    interface ContextProvider {
        Context get();
    }

    static /* synthetic */ Context lambda$initialize$10(Context context) {
        return context;
    }

    static /* synthetic */ OfflineMAMIdentityManager lambda$static$0() {
        return new OfflineMAMIdentityManager(new OfflineMAMIdentityPersistenceManager(mMAMWEAccountManager));
    }

    static /* synthetic */ MAMLogPIIFactory lambda$static$1() {
        return new OfflineMAMLogPIIFactory();
    }

    static /* synthetic */ IdentityParamConverter lambda$static$2() {
        return new IdentityParamConverterBase(mMAMIdentityManager.get(), mMAMLogPIIFactory.get());
    }

    static /* synthetic */ OfflineMAMLogManager lambda$static$3() {
        return new OfflineMAMLogManager(mMAMLogHandlerWrapper.get());
    }

    static /* synthetic */ OfflineLocalSettings lambda$static$4() {
        return new OfflineLocalSettings(mContext.get());
    }

    static /* synthetic */ UserLocalSettings lambda$static$5() {
        return new UserLocalSettings(mContext.get());
    }

    static /* synthetic */ MAMEnrollmentStatusCache lambda$static$6() {
        return new MAMEnrollmentStatusCache(mContext.get(), mMAMLogPIIFactory.get());
    }

    static /* synthetic */ MAMEnrolledIdentitiesCache lambda$static$7() {
        return new MAMEnrolledIdentitiesCache(mContext.get(), MAMComponents.getManifestData(), mMAMIdentityManager.get(), mMAMEnrollmentStatusCache.get(), mMAMLogPIIFactory.get());
    }

    static /* synthetic */ MAMServiceUrlCache lambda$static$8() {
        return new MAMServiceUrlCache(mContext.get(), MAMComponents.getManifestData(), mMAMIdentityManager.get(), mMAMEnrollmentStatusCache.get(), mMAMLogPIIFactory.get());
    }

    static /* synthetic */ SessionDurationStore lambda$static$9() {
        return new SessionDurationStore(mContext.get());
    }

    private OfflineComponents() {
    }

    public static void initialize(final Context context) {
        mContext = new ContextProvider() { // from class: com.microsoft.intune.mam.client.app.offline.OfflineComponents$$ExternalSyntheticLambda7
            @Override // com.microsoft.intune.mam.client.app.offline.OfflineComponents.ContextProvider
            public final Context get() {
                return OfflineComponents.lambda$initialize$10(context);
            }
        };
    }

    public static <T> T get(Class<T> cls) {
        Object offlineContentProviderBehavior;
        Object offlineUserDataWiper;
        if (AppPolicy.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineAppPolicy(mIdentityParamConverter.get());
        } else if (MAMUserInfo.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineMAMUserInfo(mMAMIdentityManager.get(), mMAMWEAccountManager.get());
        } else if (MAMNotificationReceiverRegistry.class.equals(cls) || MAMNotificationReceiverRegistryInternal.class.equals(cls)) {
            offlineContentProviderBehavior = NOTIFICATION_RECEIVER_REGISTRY;
        } else if (BackupAgentBehavior.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineBackupAgentBehavior();
        } else if (BackupAgentHelperBehavior.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineBackupAgentHelperBehavior();
        } else if (ActivityBehavior.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineActivityBehavior(mMAMIdentityManager.get(), mMAMEnrollmentStatusCache.get(), mIdentityParamConverter.get());
        } else if (ServiceBehavior.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineServiceBehavior();
        } else if (IntentServiceBehavior.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineIntentServiceBehavior();
        } else if (DocumentsProviderBehavior.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineDocumentsProviderBehavior(mIdentityParamConverter.get());
        } else if (CloudMediaProviderBehavior.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineCloudMediaProviderBehavior();
        } else if (ContentProviderBehavior.class.equals(cls) || ContentProviderBehaviorJellyBean.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineContentProviderBehavior(mIdentityParamConverter.get());
        } else if (FileProviderBehavior.class.equals(cls) || FileProviderBehaviorJellyBean.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineFileProviderBehavior(mIdentityParamConverter.get());
        } else if (MAMDownloadRequestFactory.class.equals(cls) || MAMDownloadQueryFactory.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineDownloadFactory();
        } else if (FragmentBehavior.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineFragmentBehavior();
        } else if (DialogFragmentBehavior.class.equals(cls)) {
            offlineContentProviderBehavior = new OfflineDialogFragmentBehavior();
        } else {
            if (MAMPolicyManagerBehavior.class.equals(cls)) {
                offlineUserDataWiper = new OfflineMAMPolicyManagerBehavior(mContext.get(), mMAMIdentityManager.get(), mMAMWEAccountManager.get(), mMAMEnrolledIdentitiesCache.get(), mIdentityParamConverter.get());
            } else if (DataProtectionManagerBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineDataProtectionManagerBehavior(mMAMIdentityManager.get(), mIdentityParamConverter.get());
            } else if (OutdatedAgentChecker.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineOutdatedAgentChecker();
            } else if (OfflineUserDataWiper.class.equals(cls)) {
                offlineUserDataWiper = new OfflineUserDataWiper(NOTIFICATION_RECEIVER_REGISTRY, mMAMLogPIIFactory.get(), mLocalSettings.get(), mMAMEnrollmentStatusCache.get(), mMAMEnrolledIdentitiesCache.get(), mUserLocalSettings.get());
            } else if (FileBackupHelperBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineFileBackupHelperBehavior();
            } else if (SharedPreferencesBackupHelperBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineSharedPreferencesBackupHelperBehavior();
            } else if (MAMEnrollmentManager.class.equals(cls) || MAMComplianceManager.class.equals(cls) || OfflineMAMEnrollmentManager.class.equals(cls)) {
                offlineContentProviderBehavior = mEnrollmentManager.get();
            } else if (WrappedAppReflectionUtilsBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineWrappedAppReflectionUtilsBehavior();
            } else if (MAMLogManager.class.equals(cls)) {
                offlineContentProviderBehavior = mMAMLogManager.get();
            } else if (MAMLogHandlerWrapper.class.equals(cls)) {
                offlineContentProviderBehavior = mMAMLogHandlerWrapper.get();
            } else if (MAMLogPIIFactory.class.equals(cls)) {
                offlineContentProviderBehavior = mMAMLogPIIFactory.get();
            } else if (NotificationReceiverBinderFactory.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineNotificationReceiver(mContext.get());
            } else if (MAMEnrollmentStatusCache.class.equals(cls)) {
                offlineContentProviderBehavior = mMAMEnrollmentStatusCache.get();
            } else if (MAMEnrolledIdentitiesCache.class.equals(cls)) {
                offlineContentProviderBehavior = mMAMEnrolledIdentitiesCache.get();
            } else if (MAMAppConfigManager.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineMAMAppConfigManager(mContext.get(), NOTIFICATION_RECEIVER_REGISTRY, mIdentityParamConverter.get());
            } else if (MAMIdentityManager.class.equals(cls)) {
                offlineContentProviderBehavior = mMAMIdentityManager.get();
            } else if (MAMWEAccountManager.class.equals(cls)) {
                offlineContentProviderBehavior = mMAMWEAccountManager.get();
            } else if (ActivityLifecycleMonitorBase.class.equals(cls)) {
                offlineContentProviderBehavior = mActivityLifecycleMonitor.get();
            } else if (MAMBackgroundJobServiceBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineMAMBackgroundJobServiceBehavior();
            } else if (OfflineCompanyPortalInstallReceiver.class.equals(cls)) {
                offlineContentProviderBehavior = mInstallReceiver.get();
            } else if (JobIntentServiceBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineJobIntentServiceBehavior();
            } else if (AllowedAccountsBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new AllowedAccountsBehaviorImpl(mContext.get(), mMAMLogPIIFactory.get());
            } else if (ClipboardBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineClipboardBehavior();
            } else if (PackageManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflinePackageManagementBehavior();
            } else if (Build.VERSION.SDK_INT >= 33 && PackageManagementBehaviorTiramisu.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflinePackageManagementBehaviorTiramisu();
            } else if (Build.VERSION.SDK_INT >= 35 && PackageManagementBehaviorVanillaIceCream.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflinePackageManagementBehaviorVanillaIceCream();
            } else if (DownloadManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineDownloadManagementBehavior();
            } else if (TextViewBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineTextViewBehavior();
            } else if (ViewGroupBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineViewGroupBehavior();
            } else if (WebViewBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineWebViewBehavior();
            } else if (SurfaceViewBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineSurfaceViewBehavior();
            } else if (PrintManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflinePrintManagementBehavior();
            } else if (ContentResolverManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new PassthroughContentResolverManagementBehavior();
            } else if (ContentProviderClientManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new PassthroughContentProviderClientManagementBehavior();
            } else if (ViewManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineViewManagementBehavior();
            } else if (WindowManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineWindowManagementBehavior();
            } else if (DragEventManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineDragEventManagementBehavior();
            } else if (NotificationManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineNotificationManagementBehavior();
            } else if (StrictGlobalSettings.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineStrictGlobalSettings();
            } else if (StrictThreadSettings.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineStrictThreadSettings();
            } else if (ThemeManagerBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = mThemeManager.get();
            } else if (MAMUIHelper.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineMAMUIHelperBehavior();
            } else if (PopupStaticBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflinePopupStaticBehavior();
            } else if (PopupInstanceBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflinePopupInstanceBehavior();
            } else if (MediaRecorderBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineMediaRecorderBehavior();
            } else if (BlobStoreManagerBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineBlobStoreManagerBehavior();
            } else if (ConfigOnlyModeBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineConfigOnlyModeBehavior(mMAMEnrolledIdentitiesCache.get());
            } else if (CertChainValidatorFactory.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineCertChainValidatorFactory(mIdentityParamConverter.get());
            } else if (Build.VERSION.SDK_INT >= 31 && SearchSessionManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineSearchSessionManagementBehavior();
            } else if (Build.VERSION.SDK_INT >= 31 && SearchResultsManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineSearchResultsManagementBehavior();
            } else if (LayoutInflaterManagementBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineLayoutInflaterManagementBehavior();
            } else if (JobServiceBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineJobServiceBehavior();
            } else if (UserStatusManagerBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineUserStatusManagerBehavior(mIdentityParamConverter.get());
            } else if (TelemetryLogger.class.equals(cls)) {
                offlineContentProviderBehavior = mOfflineTelemetryLogger.get();
            } else if (OfflineActivityLifecycleCallbacksFactory.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineActivityLifecycleCallbacksFactory(mLifecycleSuppressionRegistry.get());
            } else if (LifecycleSuppressionRegistry.class.equals(cls)) {
                offlineContentProviderBehavior = mLifecycleSuppressionRegistry.get();
            } else if (TrustedRootCertsManagerBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineTrustedRootCertsManagerBehavior(mIdentityParamConverter.get());
            } else if (WebViewClientBehavior.class.equals(cls)) {
                offlineContentProviderBehavior = new OfflineWebViewClientBehavior();
            } else if (MAMDiagnosticLogManager.class.equals(cls)) {
                offlineContentProviderBehavior = mMAMDiagnosticLogManager.get();
            } else {
                if (!IdentityParamConverter.class.equals(cls)) {
                    return null;
                }
                offlineContentProviderBehavior = mIdentityParamConverter.get();
            }
            offlineContentProviderBehavior = offlineUserDataWiper;
        }
        return cls.cast(offlineContentProviderBehavior);
    }

    private static class UninitializedContextProvider implements ContextProvider {
        private UninitializedContextProvider() {
        }

        @Override // com.microsoft.intune.mam.client.app.offline.OfflineComponents.ContextProvider
        public Context get() {
            throw new AssertionError("Attempt to access uninitialized OfflineComponents");
        }
    }
}
