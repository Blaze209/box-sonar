package com.box.android.domain.models.observability;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApdexType.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/domain/models/observability/AppStartupApdex;", "Lcom/box/android/domain/models/observability/ApdexType;", "<init>", "()V", "Cold", "Warm", "Hot", "Lcom/box/android/domain/models/observability/AppStartupApdex$Cold;", "Lcom/box/android/domain/models/observability/AppStartupApdex$Hot;", "Lcom/box/android/domain/models/observability/AppStartupApdex$Warm;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class AppStartupApdex implements ApdexType {
    public /* synthetic */ AppStartupApdex(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AppStartupApdex() {
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/box/android/domain/models/observability/AppStartupApdex$Cold;", "Lcom/box/android/domain/models/observability/AppStartupApdex;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "AppFirstCodeExecuted", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Cold extends AppStartupApdex {
        public static final Cold INSTANCE = new Cold();
        private static final String name = "app_startup_cold";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Cold)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1128270788;
        }

        public String toString() {
            return "Cold";
        }

        private Cold() {
            super(null);
        }

        @Override // com.box.android.domain.models.observability.ApdexType
        public String getName() {
            return name;
        }

        /* JADX INFO: compiled from: ApdexType.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/observability/AppStartupApdex$Cold$AppFirstCodeExecuted;", "Lcom/box/android/domain/models/observability/ApdexType$Milestone;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AppFirstCodeExecuted implements ApdexType.Milestone {
            public static final AppFirstCodeExecuted INSTANCE = new AppFirstCodeExecuted();
            private static final String name = "app_first_code_executed";

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AppFirstCodeExecuted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 683553245;
            }

            public String toString() {
                return "AppFirstCodeExecuted";
            }

            private AppFirstCodeExecuted() {
            }

            @Override // com.box.android.domain.models.observability.ApdexType.Milestone
            public String getName() {
                return name;
            }
        }
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/observability/AppStartupApdex$Warm;", "Lcom/box/android/domain/models/observability/AppStartupApdex;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Warm extends AppStartupApdex {
        public static final Warm INSTANCE = new Warm();
        private static final String name = "app_startup_warm";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Warm)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1127688227;
        }

        public String toString() {
            return "Warm";
        }

        private Warm() {
            super(null);
        }

        @Override // com.box.android.domain.models.observability.ApdexType
        public String getName() {
            return name;
        }
    }

    /* JADX INFO: compiled from: ApdexType.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/box/android/domain/models/observability/AppStartupApdex$Hot;", "Lcom/box/android/domain/models/observability/AppStartupApdex;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "", "toString", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Hot extends AppStartupApdex {
        public static final Hot INSTANCE = new Hot();
        private static final String name = "app_startup_hot";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hot)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1006222347;
        }

        public String toString() {
            return "Hot";
        }

        private Hot() {
            super(null);
        }

        @Override // com.box.android.domain.models.observability.ApdexType
        public String getName() {
            return name;
        }
    }
}
