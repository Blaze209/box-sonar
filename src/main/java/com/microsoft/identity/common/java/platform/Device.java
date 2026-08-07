package com.microsoft.identity.common.java.platform;

import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import net.jcip.annotations.GuardedBy;

/* JADX INFO: loaded from: classes14.dex */
public class Device {
    protected static final String NOT_SET = "NOT_SET";
    private static final String TAG = "Device";
    private static IDeviceMetadata sDeviceMetadata;
    private static Boolean sIsInPersonalProfileButClouddpcWorkProfileAvailable;
    private static final ReentrantReadWriteLock sLock = new ReentrantReadWriteLock();

    public static final class PlatformIdParameters {
        public static final String BROKER_VERSION = "x-client-brkrver";
        public static final String CPU_PLATFORM = "x-client-CPU";
        public static final String DEVICE_MODEL = "x-client-DM";
        public static final String MANUFACTURER = "x-client-MN";
        public static final String OS = "x-client-OS";
    }

    @GuardedBy("sLock")
    public static void setDeviceMetadata(IDeviceMetadata iDeviceMetadata) {
        if (iDeviceMetadata == null) {
            throw new NullPointerException("deviceMetadata is marked non-null but is null");
        }
        sLock.writeLock().lock();
        try {
            sDeviceMetadata = iDeviceMetadata;
        } finally {
            sLock.writeLock().unlock();
        }
    }

    @GuardedBy("sLock")
    public static void clearDeviceMetadata() {
        sLock.writeLock().lock();
        try {
            sDeviceMetadata = null;
        } finally {
            sLock.writeLock().unlock();
        }
    }

    @GuardedBy("sLock")
    public static void setIsInPersonalProfileButClouddpcWorkProfileAvailable(Boolean bool) {
        sLock.writeLock().lock();
        try {
            sIsInPersonalProfileButClouddpcWorkProfileAvailable = bool;
        } finally {
            sLock.writeLock().unlock();
        }
    }

    @GuardedBy("sLock")
    public static Boolean isInPersonalProfileButClouddpcWorkProfileAvailable() {
        sLock.readLock().lock();
        try {
            return sIsInPersonalProfileButClouddpcWorkProfileAvailable;
        } finally {
            sLock.readLock().unlock();
        }
    }

    @GuardedBy("sLock")
    public static Map<String, String> getPlatformIdParameters() {
        sLock.readLock().lock();
        try {
            HashMap map = new HashMap();
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            if (iDeviceMetadata != null) {
                map.put("x-client-CPU", iDeviceMetadata.getCpu());
                map.put("x-client-OS", sDeviceMetadata.getOsForEsts());
                map.put("x-client-DM", sDeviceMetadata.getDeviceModel());
                map.put(PlatformIdParameters.MANUFACTURER, sDeviceMetadata.getManufacturer());
            } else {
                map.put("x-client-CPU", NOT_SET);
                map.put("x-client-OS", NOT_SET);
                map.put("x-client-DM", NOT_SET);
                map.put(PlatformIdParameters.MANUFACTURER, NOT_SET);
            }
            return Collections.unmodifiableMap(map);
        } finally {
            sLock.readLock().unlock();
        }
    }

    @Deprecated
    public static String getProductVersion() {
        String str = DiagnosticContext.INSTANCE.getRequestContext().get("x-client-Ver");
        if (!StringUtil.isNullOrEmpty(str)) {
            return str;
        }
        Logger.warn(TAG + ":getProductVersion", "Product version is not set.", null);
        return "1.5.9-default";
    }

    @GuardedBy("sLock")
    public static String getDeviceType() {
        String deviceType;
        sLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            if (iDeviceMetadata != null) {
                deviceType = iDeviceMetadata.getDeviceType();
            } else {
                deviceType = NOT_SET;
            }
            return deviceType;
        } finally {
            sLock.readLock().unlock();
        }
    }

    @GuardedBy("sLock")
    public static String getCpu() {
        String cpu;
        sLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            if (iDeviceMetadata != null) {
                cpu = iDeviceMetadata.getCpu();
            } else {
                cpu = NOT_SET;
            }
            return cpu;
        } finally {
            sLock.readLock().unlock();
        }
    }

    @GuardedBy("sLock")
    public static String getOsForEsts() {
        String osForEsts;
        sLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            if (iDeviceMetadata != null) {
                osForEsts = iDeviceMetadata.getOsForEsts();
            } else {
                osForEsts = NOT_SET;
            }
            return osForEsts;
        } finally {
            sLock.readLock().unlock();
        }
    }

    @GuardedBy("sLock")
    public static String getOsForDrs() {
        String osForDrs;
        sLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            if (iDeviceMetadata != null) {
                osForDrs = iDeviceMetadata.getOsForDrs();
            } else {
                osForDrs = NOT_SET;
            }
            return osForDrs;
        } finally {
            sLock.readLock().unlock();
        }
    }

    @GuardedBy("sLock")
    public static String getAndroidReleaseOs() {
        String androidReleaseOs;
        sLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            if (iDeviceMetadata != null) {
                androidReleaseOs = iDeviceMetadata.getAndroidReleaseOs();
            } else {
                androidReleaseOs = NOT_SET;
            }
            return androidReleaseOs;
        } finally {
            sLock.readLock().unlock();
        }
    }

    @GuardedBy("sLock")
    public static String getManufacturer() {
        String manufacturer;
        sLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            if (iDeviceMetadata != null) {
                manufacturer = iDeviceMetadata.getManufacturer();
            } else {
                manufacturer = NOT_SET;
            }
            return manufacturer;
        } finally {
            sLock.readLock().unlock();
        }
    }

    @GuardedBy("sLock")
    public static String getModel() {
        String deviceModel;
        sLock.readLock().lock();
        try {
            IDeviceMetadata iDeviceMetadata = sDeviceMetadata;
            if (iDeviceMetadata != null) {
                deviceModel = iDeviceMetadata.getDeviceModel();
            } else {
                deviceModel = NOT_SET;
            }
            return deviceModel;
        } finally {
            sLock.readLock().unlock();
        }
    }

    public static String getDeviceDisplayName() {
        return getManufacturer() + getModel();
    }
}
