package com.microsoft.intune.mam.client;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import com.microsoft.intune.mam.client.app.LazyInit;
import com.microsoft.intune.mam.client.content.pm.PackageManagerCompat;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMInfo {
    public static final String COMPANY_PORTAL_PACKAGE_NAME = "com.microsoft.windowsintune.companyportal";
    private static final int COMPANY_PORTAL_PROD_VERSION_CODE_BIT = 1073741824;
    private static final String DEBUG_CONFIG_AGENT_NAME_CP = "CompanyPortal";
    private static final String DEBUG_CONFIG_AGENT_XPATH = "/MAM/Agent";
    private static final String DEBUG_CONFIG_FILE_NAME = "com.microsoft.intune.mam.Overrides.xml";
    private static final String DEBUG_EXCEPT_ON_INIT_XPATH = "/MAM/ExceptOnInit";
    private static final String DEBUG_MANAGED_DIALOG_XPATH = "/MAM/ManagedDialogDismissed";
    private static final String TEST_AGENT_APP_CLASS = "com.microsoft.mdm.testappclient.AgentApplication";
    public static final String TEST_AGENT_PACKAGE_NAME = "com.microsoft.mdm.testappclient";
    private static AgentType mAgentType;
    private static boolean mAllowIsolatedProcesses;
    private static boolean mConfigOnlyMode;
    private static int mDataExtractionRules;
    private static boolean mDebug;
    private static boolean mDebuggable;
    private static boolean mExceptOnInit;
    private static int mFullBackupContent;
    private static boolean mInitialized;
    private static boolean mManagedDialogDisabled;
    private static boolean mMultiIdentityEnabled;
    private static boolean mMultiManagedIdentitiesEnabled;
    private static boolean mPolicyRequired;
    private static boolean mUseDefaultMamEnrollment;
    private static boolean mWorkingTimeSupported;
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMInfo.class);
    private static String mAgent = "com.microsoft.windowsintune.companyportal";
    public static final String PROD_POLICY_AUTHORITY = "com.microsoft.intune.mam.policy";
    private static String mProviderAuthority = PROD_POLICY_AUTHORITY;
    private static boolean mDisableOfflineLogging = false;
    private static LazyInit<Boolean> mIsAgentProdBuild = new LazyInit<>(new LazyInit.Provider<Boolean>() { // from class: com.microsoft.intune.mam.client.MAMInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
        public Boolean get() {
            return true;
        }
    });

    public static String getPackageName() {
        return mAgent;
    }

    public static String getPolicyProviderAuthority() {
        return mProviderAuthority;
    }

    public static boolean isDebug() {
        return mDebug;
    }

    public static boolean isDebuggable() {
        return mDebuggable;
    }

    public static boolean isConfigOnlyMode() {
        return mConfigOnlyMode;
    }

    public static boolean isPolicyRequired() {
        return mPolicyRequired;
    }

    public static boolean isMultiIdentityEnabled() {
        return mMultiIdentityEnabled;
    }

    public static boolean isMMAEnabled() {
        if (isAppOrAgentNonProd()) {
            return mMultiManagedIdentitiesEnabled;
        }
        return false;
    }

    public static boolean allowIsolatedProcesses() {
        return mAllowIsolatedProcesses;
    }

    public static boolean isManagedDialogDisabled() {
        return mManagedDialogDisabled;
    }

    public static int getFullBackupContent() {
        return mFullBackupContent;
    }

    public static int getDataExtractionRules() {
        return mDataExtractionRules;
    }

    public static boolean isDefaultMAMEnrollmentEnabled() {
        return mUseDefaultMamEnrollment;
    }

    public static boolean isOfflineLoggingDisabled() {
        return mDisableOfflineLogging;
    }

    public static boolean isWorkingTimeSupported() {
        return mWorkingTimeSupported;
    }

    public static boolean getExceptOnInit() {
        return mExceptOnInit;
    }

    public static boolean isAppOrAgentNonProd() {
        return mDebug || mDebuggable || mAgentType == AgentType.TEST || !mIsAgentProdBuild.get().booleanValue();
    }

    public static boolean isProdAgent() {
        return mIsAgentProdBuild.get().booleanValue();
    }

    public static synchronized void initializeFromContext(Context context) {
        if (!mInitialized) {
            initialize(new MetaDataReader(context));
            setAgentProdBuild(context);
        }
    }

    public static synchronized void initialize(MetaDataReader metaDataReader) {
        mPolicyRequired = metaDataReader.isPolicyRequired().booleanValue();
        mMultiIdentityEnabled = metaDataReader.isMultiIdentityEnabled().booleanValue();
        mMultiManagedIdentitiesEnabled = metaDataReader.isMultiManagedIdentitiesEnabled().booleanValue();
        mDebug = metaDataReader.isTestOnly().booleanValue();
        mFullBackupContent = metaDataReader.getFullBackupContent();
        mDataExtractionRules = metaDataReader.getDataExtractionRules();
        mUseDefaultMamEnrollment = metaDataReader.isDefaultMAMEnrollmentEnabled().booleanValue();
        mDisableOfflineLogging = metaDataReader.isOfflineLoggingDisabled();
        mDebuggable = metaDataReader.isDebuggable();
        mConfigOnlyMode = metaDataReader.isConfigOnlyMode();
        mAllowIsolatedProcesses = metaDataReader.allowIsolatedProcesses().booleanValue();
        mWorkingTimeSupported = metaDataReader.isWorkingTimeSupported().booleanValue();
        AgentType agentType = metaDataReader.getAgentType();
        mAgentType = agentType;
        boolean z = mDebug;
        if (!z) {
            if (agentType != null && agentType != AgentType.PRODUCTION) {
                LOGGER.info("Production builds (non testOnly) must use the Company Portal as the agent", new Object[0]);
            }
            mAgentType = AgentType.PRODUCTION;
        } else if (z && isTestAgent()) {
            mAgentType = AgentType.TEST;
        } else if (mAgentType == null) {
            mAgentType = AgentType.PRODUCTION;
        }
        mManagedDialogDisabled = false;
        mExceptOnInit = false;
        getOverrides();
        if (AnonymousClass3.$SwitchMap$com$microsoft$intune$mam$client$AgentType[mAgentType.ordinal()] == 1) {
            mAgent = TEST_AGENT_PACKAGE_NAME;
            mProviderAuthority = "com.microsoft.intune.mam.mock.policy";
        } else {
            mAgent = "com.microsoft.windowsintune.companyportal";
            mProviderAuthority = PROD_POLICY_AUTHORITY;
        }
        mInitialized = true;
        LOGGER.info(String.format("MAMInfo initialized. Debug=%b, Agent=%s, ManagedDialogDisabled=%b, PolicyRequired=%b, MultiIdentityEnabled=%b, FullBackupContent=%b, DataExtractionRules=%b, UseDefaultEnrollment=%b, ExceptionOnInit=%b, Debuggable=%b, IsolatedProcessesAllowed=%b", Boolean.valueOf(mDebug), mAgentType, Boolean.valueOf(mManagedDialogDisabled), Boolean.valueOf(mPolicyRequired), Boolean.valueOf(mMultiIdentityEnabled), Integer.valueOf(mFullBackupContent), Integer.valueOf(mDataExtractionRules), Boolean.valueOf(mUseDefaultMamEnrollment), Boolean.valueOf(mExceptOnInit), Boolean.valueOf(mDebuggable), Boolean.valueOf(mAllowIsolatedProcesses)), new Object[0]);
    }

    /* JADX INFO: renamed from: com.microsoft.intune.mam.client.MAMInfo$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$intune$mam$client$AgentType;

        static {
            int[] iArr = new int[AgentType.values().length];
            $SwitchMap$com$microsoft$intune$mam$client$AgentType = iArr;
            try {
                iArr[AgentType.TEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$client$AgentType[AgentType.PRODUCTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static void setAgentProdBuild(final Context context) {
        mIsAgentProdBuild = new LazyInit<>(new LazyInit.Provider<Boolean>() { // from class: com.microsoft.intune.mam.client.MAMInfo.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.intune.mam.client.app.LazyInit.Provider
            public Boolean get() {
                try {
                    return Boolean.valueOf((PackageManagerCompat.getPackageInfo(context.getPackageManager(), MAMInfo.mAgent, 0L).versionCode & 1073741824) == 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    MAMInfo.LOGGER.info("Agent not installed, setting mIsAgentProdBuild to false", new Object[0]);
                    return false;
                }
            }
        });
    }

    public static void overrideAgent(String str, String str2) {
        if (!mDebug) {
            throw new AssertionError("Cannot override agent in production");
        }
        mAgent = str;
        mProviderAuthority = str2;
    }

    public static void overrideAsDefaultEnrollment() {
        if (!mDebug) {
            throw new AssertionError("Cannot override as default enrollment in production");
        }
        LOGGER.info("Overriding app as default enrollment", new Object[0]);
        mUseDefaultMamEnrollment = true;
        mPolicyRequired = true;
    }

    private static boolean isTestAgent() {
        if (!mDebug) {
            throw new AssertionError("This test is not suitable for production");
        }
        try {
            return MAMInfo.class.getClassLoader().loadClass(TEST_AGENT_APP_CLASS) != null;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static void getOverrides() {
        if (mDebug) {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), DEBUG_CONFIG_FILE_NAME);
                try {
                    if (!file.exists()) {
                        LOGGER.info("Agent config file does not exist", new Object[0]);
                        return;
                    }
                    try {
                        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
                        documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
                        Document document = documentBuilderFactoryNewInstance.newDocumentBuilder().parse(file);
                        XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
                        Node node = (Node) xPathNewXPath.evaluate(DEBUG_CONFIG_AGENT_XPATH, document, XPathConstants.NODE);
                        if (node == null) {
                            mAgentType = AgentType.TEST;
                            LOGGER.info("Agent config file is present but does not specify to use the Company Portal, using test agent", new Object[0]);
                        } else if (!DEBUG_CONFIG_AGENT_NAME_CP.equals(node.getTextContent())) {
                            LOGGER.info("Agent config file is present but does not specify to use the Company Portal, using test agent", new Object[0]);
                            mAgentType = AgentType.TEST;
                        } else {
                            LOGGER.info("Agent config file specifies to use Company Portal as the agent even though the app is testOnly", new Object[0]);
                            mAgentType = AgentType.PRODUCTION;
                        }
                        if (((Node) xPathNewXPath.evaluate(DEBUG_MANAGED_DIALOG_XPATH, document, XPathConstants.NODE)) != null) {
                            LOGGER.info("Agent config file setting managed dialog disabled", new Object[0]);
                            mManagedDialogDisabled = true;
                        }
                        if (((Node) xPathNewXPath.evaluate(DEBUG_EXCEPT_ON_INIT_XPATH, document, XPathConstants.NODE)) != null) {
                            LOGGER.info("Agent config file setting MAM to except during initialization", new Object[0]);
                            mExceptOnInit = true;
                        }
                    } catch (IOException | ParserConfigurationException | XPathExpressionException | SAXException e) {
                        LOGGER.log(Level.WARNING, "Failed to parse agent configuration file, using test agent", e);
                        mAgentType = AgentType.TEST;
                    }
                } catch (SecurityException e2) {
                    LOGGER.warning("Failed to check existence of agent config file.", e2);
                }
            } catch (ArrayIndexOutOfBoundsException e3) {
                LOGGER.warning("Failed to detect agent config file.", e3);
            }
        }
    }

    private MAMInfo() {
    }
}
