package sdk.pendo.io.models;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sdk.pendo.io.actions.GuideActionConfiguration;
import sdk.pendo.io.actions.PendoCommandParameterInjector;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u000b\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/models/GuideStatus;", "", "()V", "hasError", "", "getHasError", "()Z", "status", "", "getStatus", "()I", "sendError", "", GuideActionConfiguration.GUIDE_SCREEN_CONTENT_GUIDE, "Lsdk/pendo/io/models/GuideModel;", "pcpi", "Lsdk/pendo/io/actions/PendoCommandParameterInjector;", "terminateGuide", "Companion", "Lsdk/pendo/io/models/Cancelled;", "Lsdk/pendo/io/models/Completed;", "Lsdk/pendo/io/models/ContentError;", "Lsdk/pendo/io/models/ContentNotReady;", "Lsdk/pendo/io/models/ContentReady;", "Lsdk/pendo/io/models/ErrorSent;", "Lsdk/pendo/io/models/GuideShown;", "Lsdk/pendo/io/models/ImageError;", "Lsdk/pendo/io/models/ImageNotReady;", "Lsdk/pendo/io/models/ImageReady;", "Lsdk/pendo/io/models/Ready;", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class GuideStatus {
    private static final int COMPLETED = 0;
    private final boolean hasError;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int CONTENT_NOT_READY = 1;
    private static final int CONTENT_READY = 2;
    private static final int IMAGES_NOT_READY = 3;
    private static final int IMAGES_READY = 4;
    private static final int READY = 1000;
    private static final int GUIDE_SHOWN = 2000;
    private static final int CONTENT_ERROR = 5000;
    private static final int IMAGES_ERROR = 6000;
    private static final int ERROR_SENT = 7000;
    private static final int CANCELLED = Integer.MAX_VALUE;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\"\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007R\u001c\u0010\u0014\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u0007R\u001c\u0010\u001a\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0002\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010\u001d\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010 \u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u0007R\u001c\u0010#\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010\u0007¨\u0006&"}, d2 = {"Lsdk/pendo/io/models/GuideStatus$Companion;", "", "()V", "CANCELLED", "", "getCANCELLED$annotations", "getCANCELLED", "()I", "COMPLETED", "getCOMPLETED$annotations", "getCOMPLETED", "CONTENT_ERROR", "getCONTENT_ERROR$annotations", "getCONTENT_ERROR", "CONTENT_NOT_READY", "getCONTENT_NOT_READY$annotations", "getCONTENT_NOT_READY", "CONTENT_READY", "getCONTENT_READY$annotations", "getCONTENT_READY", "ERROR_SENT", "getERROR_SENT$annotations", "getERROR_SENT", "GUIDE_SHOWN", "getGUIDE_SHOWN$annotations", "getGUIDE_SHOWN", "IMAGES_ERROR", "getIMAGES_ERROR$annotations", "getIMAGES_ERROR", "IMAGES_NOT_READY", "getIMAGES_NOT_READY$annotations", "getIMAGES_NOT_READY", "IMAGES_READY", "getIMAGES_READY$annotations", "getIMAGES_READY", "READY", "getREADY$annotations", "getREADY", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getCANCELLED$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getCOMPLETED$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getCONTENT_ERROR$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getCONTENT_NOT_READY$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getCONTENT_READY$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getERROR_SENT$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getGUIDE_SHOWN$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getIMAGES_ERROR$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getIMAGES_NOT_READY$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getIMAGES_READY$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getREADY$annotations() {
        }

        public final int getCANCELLED() {
            return GuideStatus.CANCELLED;
        }

        public final int getCOMPLETED() {
            return GuideStatus.COMPLETED;
        }

        public final int getCONTENT_ERROR() {
            return GuideStatus.CONTENT_ERROR;
        }

        public final int getCONTENT_NOT_READY() {
            return GuideStatus.CONTENT_NOT_READY;
        }

        public final int getCONTENT_READY() {
            return GuideStatus.CONTENT_READY;
        }

        public final int getERROR_SENT() {
            return GuideStatus.ERROR_SENT;
        }

        public final int getGUIDE_SHOWN() {
            return GuideStatus.GUIDE_SHOWN;
        }

        public final int getIMAGES_ERROR() {
            return GuideStatus.IMAGES_ERROR;
        }

        public final int getIMAGES_NOT_READY() {
            return GuideStatus.IMAGES_NOT_READY;
        }

        public final int getIMAGES_READY() {
            return GuideStatus.IMAGES_READY;
        }

        public final int getREADY() {
            return GuideStatus.READY;
        }
    }

    private GuideStatus() {
    }

    public /* synthetic */ GuideStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final int getCANCELLED() {
        return INSTANCE.getCANCELLED();
    }

    public static final int getCOMPLETED() {
        return INSTANCE.getCOMPLETED();
    }

    public static final int getCONTENT_ERROR() {
        return INSTANCE.getCONTENT_ERROR();
    }

    public static final int getCONTENT_NOT_READY() {
        return INSTANCE.getCONTENT_NOT_READY();
    }

    public static final int getCONTENT_READY() {
        return INSTANCE.getCONTENT_READY();
    }

    public static final int getERROR_SENT() {
        return INSTANCE.getERROR_SENT();
    }

    public static final int getGUIDE_SHOWN() {
        return INSTANCE.getGUIDE_SHOWN();
    }

    public static final int getIMAGES_ERROR() {
        return INSTANCE.getIMAGES_ERROR();
    }

    public static final int getIMAGES_NOT_READY() {
        return INSTANCE.getIMAGES_NOT_READY();
    }

    public static final int getIMAGES_READY() {
        return INSTANCE.getIMAGES_READY();
    }

    public static final int getREADY() {
        return INSTANCE.getREADY();
    }

    public boolean getHasError() {
        return this.hasError;
    }

    public abstract int getStatus();

    public abstract void sendError(GuideModel guide, PendoCommandParameterInjector pcpi);

    public void terminateGuide(GuideModel guide) {
        if (guide != null) {
            guide.terminateStatus();
        }
    }
}
