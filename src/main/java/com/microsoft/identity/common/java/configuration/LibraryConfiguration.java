package com.microsoft.identity.common.java.configuration;

import com.microsoft.identity.common.java.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class LibraryConfiguration {
    private static final String TAG = "LibraryConfiguration";
    private static LibraryConfiguration sInstance;
    private boolean authorizationInCurrentTask;
    private boolean refreshInEnabled;

    public static class LibraryConfigurationBuilder {
        private boolean authorizationInCurrentTask;
        private boolean refreshInEnabled;

        LibraryConfigurationBuilder() {
        }

        public LibraryConfigurationBuilder authorizationInCurrentTask(boolean z) {
            this.authorizationInCurrentTask = z;
            return this;
        }

        public LibraryConfiguration build() {
            return new LibraryConfiguration(this.authorizationInCurrentTask, this.refreshInEnabled);
        }

        public LibraryConfigurationBuilder refreshInEnabled(boolean z) {
            this.refreshInEnabled = z;
            return this;
        }

        public String toString() {
            return "LibraryConfiguration.LibraryConfigurationBuilder(authorizationInCurrentTask=" + this.authorizationInCurrentTask + ", refreshInEnabled=" + this.refreshInEnabled + ")";
        }
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof LibraryConfiguration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryConfiguration)) {
            return false;
        }
        LibraryConfiguration libraryConfiguration = (LibraryConfiguration) obj;
        return libraryConfiguration.canEqual(this) && isAuthorizationInCurrentTask() == libraryConfiguration.isAuthorizationInCurrentTask() && isRefreshInEnabled() == libraryConfiguration.isRefreshInEnabled();
    }

    public int hashCode() {
        return (((isAuthorizationInCurrentTask() ? 79 : 97) + 59) * 59) + (isRefreshInEnabled() ? 79 : 97);
    }

    LibraryConfiguration(boolean z, boolean z2) {
        this.authorizationInCurrentTask = z;
        this.refreshInEnabled = z2;
    }

    public static LibraryConfigurationBuilder builder() {
        return new LibraryConfigurationBuilder();
    }

    public static synchronized LibraryConfiguration getInstance() {
        if (sInstance == null) {
            sInstance = createDefaultInstance();
        }
        return sInstance;
    }

    public static synchronized void intializeLibraryConfiguration(LibraryConfiguration libraryConfiguration) {
        try {
            if (libraryConfiguration == null) {
                throw new NullPointerException("config is marked non-null but is null");
            }
            if (sInstance == null) {
                sInstance = libraryConfiguration;
            } else {
                Logger.warn(TAG, "MsalConfiguration was already initialized");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static synchronized LibraryConfiguration createDefaultInstance() {
        return builder().authorizationInCurrentTask(false).refreshInEnabled(false).build();
    }

    public boolean isAuthorizationInCurrentTask() {
        return this.authorizationInCurrentTask;
    }

    public boolean isRefreshInEnabled() {
        return this.refreshInEnabled;
    }
}
