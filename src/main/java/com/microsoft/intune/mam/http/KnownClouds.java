package com.microsoft.intune.mam.http;

import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;

/* JADX INFO: loaded from: classes3.dex */
public enum KnownClouds {
    WORLDWIDE("https://login.windows.net", "https://go.microsoft.com/fwlink/?linkid=2138939", "https://go.microsoft.com/fwlink/?linkid=2131071", WorldwideCerts.WORLDWIDE_INTERMEDIATE_CERT_HASHES, "sha256"),
    ARLINGTON("https://login.microsoftonline.us", "https://go.microsoft.com/fwlink/?linkid=851103", "https://go.microsoft.com/fwlink/?linkid=2130378", ArlingtonCerts.ARLINGTON_INTERMEDIATE_CERT_HASHES, "sha256"),
    GALLATIN("https://login.chinacloudapi.cn", "https://go.microsoft.com/fwlink/?linkid=2112757&clcid=0x804", "https://go.microsoft.com/fwlink/?linkid=2131070", GallatinCerts.GALLATIN_INTERMEDIATE_CERT_HASHES, "sha256"),
    MOONCAKE("https://login.partner.microsoftonline.cn", "https://go.microsoft.com/fwlink/?linkid=2112757&clcid=0x804", "https://go.microsoft.com/fwlink/?linkid=2131070", GallatinCerts.GALLATIN_INTERMEDIATE_CERT_HASHES, "sha256"),
    BLACKFOREST("https://login.microsoftonline.de", null, null, null, null);

    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(KnownClouds.class);
    private final String mAuthority;
    private final String mHashAlgorithm;
    private final String mInstallationFWLink;
    private final String[] mIntermediateCertHashes;
    private final String mMAMServiceFWLink;

    KnownClouds(String str, String str2, String str3, String[] strArr, String str4) {
        this.mAuthority = str;
        this.mMAMServiceFWLink = str2;
        this.mInstallationFWLink = str3;
        this.mIntermediateCertHashes = strArr;
        this.mHashAlgorithm = str4;
    }

    public String getAuthority() {
        return this.mAuthority;
    }

    public String getMAMServiceFWLink() {
        return this.mMAMServiceFWLink;
    }

    public String getInstallationFWLink() {
        return this.mInstallationFWLink;
    }

    public String[] getIntermediateCertHashes() {
        return this.mIntermediateCertHashes;
    }

    public String getHashAlgorithm() {
        return this.mHashAlgorithm;
    }

    public static KnownClouds fromAuthority(String str) {
        if (str == null) {
            LOGGER.info("null authority, using worldwide", new Object[0]);
            return WORLDWIDE;
        }
        KnownClouds knownClouds = ARLINGTON;
        if (str.startsWith(knownClouds.mAuthority)) {
            LOGGER.info("detected arlington authority", new Object[0]);
            return knownClouds;
        }
        KnownClouds knownClouds2 = GALLATIN;
        if (str.startsWith(knownClouds2.mAuthority)) {
            LOGGER.info("detected gallatin authority", new Object[0]);
            return knownClouds2;
        }
        KnownClouds knownClouds3 = MOONCAKE;
        if (str.startsWith(knownClouds3.mAuthority)) {
            LOGGER.info("detected mooncake authority", new Object[0]);
            return knownClouds3;
        }
        KnownClouds knownClouds4 = BLACKFOREST;
        if (str.startsWith(knownClouds4.mAuthority)) {
            LOGGER.info("detected unsupported blackforest authority", new Object[0]);
            return knownClouds4;
        }
        LOGGER.info("defaulting to worldwide", new Object[0]);
        return WORLDWIDE;
    }

    public static boolean isSupported(String str) {
        int i = AnonymousClass1.$SwitchMap$com$microsoft$intune$mam$http$KnownClouds[fromAuthority(str).ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 4) {
            return true;
        }
        if (i == 5) {
            LOGGER.info("Attempting to enroll into an unsupported cloud", new Object[0]);
            return false;
        }
        LOGGER.error(MAMInterfaceError.KNOWN_CLOUDS_UNSUPPORTED, "Unknown cloud detected for authority - programmer error: " + str, new Object[0]);
        return false;
    }

    /* JADX INFO: renamed from: com.microsoft.intune.mam.http.KnownClouds$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$intune$mam$http$KnownClouds;

        static {
            int[] iArr = new int[KnownClouds.values().length];
            $SwitchMap$com$microsoft$intune$mam$http$KnownClouds = iArr;
            try {
                iArr[KnownClouds.WORLDWIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$http$KnownClouds[KnownClouds.ARLINGTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$http$KnownClouds[KnownClouds.GALLATIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$http$KnownClouds[KnownClouds.MOONCAKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$http$KnownClouds[KnownClouds.BLACKFOREST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
