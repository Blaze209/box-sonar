package com.microsoft.intune.mam.client.app.offline;

import com.microsoft.intune.mam.client.MAMInfo;
import com.microsoft.intune.mam.client.app.MAMBuildUtils;
import com.microsoft.intune.mam.log.LogCatHandler;
import com.microsoft.intune.mam.log.MAMLogHandlerWrapper;
import com.microsoft.intune.mam.log.MAMLogHandlerWrapperImpl;
import com.microsoft.intune.mam.log.MAMLogManager;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineMAMLogManager implements MAMLogManager {
    private static final Logger LOGGER = Logger.getLogger(MAMLogHandlerWrapperImpl.MSMAM_PACKAGE_NAME);
    private static LogCatHandler mLogcatHandler = null;
    private MAMLogHandlerWrapper mMAMLogHandlerWrapper;

    public OfflineMAMLogManager(MAMLogHandlerWrapper mAMLogHandlerWrapper) {
        this.mMAMLogHandlerWrapper = mAMLogHandlerWrapper;
    }

    @Override // com.microsoft.intune.mam.log.MAMLogManager
    public void init() {
        try {
            initOnce();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Unable to log to logcat.", (Throwable) e);
        }
        LogCatHandler logCatHandler = mLogcatHandler;
        if (logCatHandler != null) {
            this.mMAMLogHandlerWrapper.addHandler(logCatHandler, true);
        }
    }

    @Override // com.microsoft.intune.mam.log.MAMLogManager
    public File[] getLogFiles() {
        return new File[0];
    }

    private synchronized void initOnce() throws IOException {
        if (mLogcatHandler == null && shouldUseLogcat()) {
            mLogcatHandler = new LogCatHandler();
            if (MAMInfo.isDebug()) {
                mLogcatHandler.setLevel(Level.FINEST);
            }
        }
    }

    private boolean shouldUseLogcat() {
        return MAMInfo.isDebug() || MAMInfo.isDebuggable() || MAMBuildUtils.isDeveloperBuild();
    }
}
