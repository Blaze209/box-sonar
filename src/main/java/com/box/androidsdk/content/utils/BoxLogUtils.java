package com.box.androidsdk.content.utils;

import androidx.core.app.NotificationCompat;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.box.androidsdk.content.utils.logging.CrashlyticsTree;
import com.box.androidsdk.content.utils.logging.FileTree;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* JADX INFO: compiled from: BoxLogUtils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\"\u00020\fH\u0007¢\u0006\u0002\u0010\rJ\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007H\u0007J \u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J0\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J0\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0018H\u0007J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J0\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0018H\u0007J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J \u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0007J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J \u0010\u001e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\"\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/box/androidsdk/content/utils/BoxLogUtils;", "", "<init>", "()V", "MIN_FILE_LOGGING_LEVEL", "", "DEFAULT_FILE_LOGGING_LEVEL", "", "setLoggers", "", "trees", "", "Ltimber/log/Timber$Tree;", "([Ltimber/log/Timber$Tree;)V", "logUserProperties", OAuthActivity.USER_ID, "enterpriseId", "setFileLoggingLevel", "logLevel", "log", "tag", NotificationCompat.CATEGORY_MESSAGE, "i", "map", "", "d", "v", "w", "t", "", "e", "logException", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxLogUtils {
    public static final int DEFAULT_FILE_LOGGING_LEVEL = 4;
    public static final BoxLogUtils INSTANCE = new BoxLogUtils();
    public static final String MIN_FILE_LOGGING_LEVEL = "shared_pref_min_file_logging_level";

    private BoxLogUtils() {
    }

    @JvmStatic
    public static final void setLoggers(Timber.Tree... trees) {
        Intrinsics.checkNotNullParameter(trees, "trees");
        Timber.INSTANCE.plant((Timber.Tree[]) Arrays.copyOf(trees, trees.length));
    }

    @JvmStatic
    public static final void logUserProperties(String userId, String enterpriseId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        for (Timber.Tree tree : Timber.INSTANCE.forest()) {
            if (tree instanceof CrashlyticsTree) {
                CrashlyticsTree crashlyticsTree = (CrashlyticsTree) tree;
                crashlyticsTree.setUserId(userId);
                if (enterpriseId != null) {
                    crashlyticsTree.setEnterpriseId(enterpriseId);
                }
            }
        }
    }

    @JvmStatic
    public static final void setFileLoggingLevel(int logLevel) {
        if (2 > logLevel || logLevel >= 7) {
            return;
        }
        for (Timber.Tree tree : Timber.INSTANCE.forest()) {
            if (tree instanceof FileTree) {
                ((FileTree) tree).setLogLevel(logLevel);
                i("File Logging updated to " + logLevel);
            }
        }
    }

    @JvmStatic
    public static final void log(int logLevel, String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (logLevel == 2) {
            v(tag, msg);
            return;
        }
        if (logLevel == 3) {
            d(tag, msg);
            return;
        }
        if (logLevel == 4) {
            i(tag, msg);
        } else if (logLevel == 5) {
            w(tag, msg);
        } else {
            if (logLevel != 6) {
                return;
            }
            e(tag, msg);
        }
    }

    @JvmStatic
    public static final void i(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.i(msg, new Object[0]);
    }

    @JvmStatic
    public static final void i(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.tag(tag);
        Timber.INSTANCE.i(msg, new Object[0]);
    }

    @JvmStatic
    public static final void i(String tag, String msg, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(map, "map");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null || value != null) {
                Timber.INSTANCE.tag(tag);
                Timber.INSTANCE.i("%s:  %s:%s", msg, key, value);
            }
        }
    }

    @JvmStatic
    public static final void d(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.d(msg, new Object[0]);
    }

    @JvmStatic
    public static final void d(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.tag(tag);
        Timber.INSTANCE.d(msg, new Object[0]);
    }

    @JvmStatic
    public static final void d(String tag, String msg, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(map, "map");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null || value != null) {
                Timber.INSTANCE.tag(tag);
                Timber.INSTANCE.d("%s:  %s:%s", msg, key, value);
            }
        }
    }

    @JvmStatic
    public static final void v(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.v(msg, new Object[0]);
    }

    @JvmStatic
    public static final void v(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.tag(tag);
        Timber.INSTANCE.v(msg, new Object[0]);
    }

    @JvmStatic
    public static final void v(String tag, String msg, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(map, "map");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Timber.INSTANCE.tag(tag);
            Timber.INSTANCE.v("%s:  %s:%s", msg, key, value);
        }
    }

    @JvmStatic
    public static final void w(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.w(msg, new Object[0]);
    }

    @JvmStatic
    public static final void w(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.tag(tag);
        Timber.INSTANCE.w(msg, new Object[0]);
    }

    @JvmStatic
    public static final void w(String tag, String msg, Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(t, "t");
        Timber.INSTANCE.tag(tag);
        Timber.INSTANCE.w(t, msg, new Object[0]);
    }

    @JvmStatic
    public static final void e(String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.e(msg, new Object[0]);
    }

    @JvmStatic
    public static final void e(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        Timber.INSTANCE.e(t);
    }

    @JvmStatic
    public static final void e(String tag, String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.tag(tag);
        Timber.INSTANCE.e(msg, new Object[0]);
    }

    @JvmStatic
    public static final void e(String tag, Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(t, "t");
        Timber.INSTANCE.tag(tag);
        Timber.INSTANCE.e(t);
    }

    @JvmStatic
    public static final void e(String tag, String msg, Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Intrinsics.checkNotNullParameter(t, "t");
        Timber.INSTANCE.tag(tag);
        Timber.INSTANCE.e(t, msg, new Object[0]);
    }

    @JvmStatic
    public static final void logException(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        Timber.INSTANCE.e(t);
    }

    @JvmStatic
    public static final void logException(String tag, Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(t, "t");
        Timber.INSTANCE.tag(tag);
        Timber.INSTANCE.e(t);
    }

    @JvmStatic
    public static final void logException(String tag, String msg, Throwable t) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Timber.INSTANCE.tag(tag);
        if (t == null) {
            Timber.INSTANCE.e(msg, new Object[0]);
        } else {
            Timber.INSTANCE.e(t, msg, new Object[0]);
        }
    }
}
