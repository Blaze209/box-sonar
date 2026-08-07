package com.box.androidsdk.content.utils.logging;

import android.content.Context;
import com.box.androidsdk.content.BoxConstants;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.logging.LogFactory;
import timber.log.Timber;

/* JADX INFO: compiled from: FileTree.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J,\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/androidsdk/content/utils/logging/FileTree;", "Ltimber/log/Timber$Tree;", "appContext", "Landroid/content/Context;", "logLevel", "", "<init>", "(Landroid/content/Context;I)V", "getLogLevel", "()I", "setLogLevel", "(I)V", "configure", "", "logFileName", "", "log", LogFactory.PRIORITY_KEY, "tag", "message", "t", "", "Companion", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileTree extends Timber.Tree {
    public static final String CONFIG_FILE_KEY = "writer.file";
    public static final String LOGS_DIR = "logs";
    public static final int MAX_LOG_LINE_LENGTH = 4000;
    private int logLevel;

    public FileTree(Context appContext, int i) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.logLevel = i;
        configure(appContext);
    }

    public final int getLogLevel() {
        return this.logLevel;
    }

    public final void setLogLevel(int i) {
        this.logLevel = i;
    }

    private final void configure(Context appContext) {
        try {
            org.tinylog.configuration.Configuration.set(CONFIG_FILE_KEY, new File(appContext.getFilesDir(), LOGS_DIR).getAbsolutePath() + logFileName(appContext));
        } catch (UnsupportedOperationException e) {
            BoxLogUtils.e(BoxConstants.TAG, e);
        }
    }

    private final String logFileName(Context appContext) {
        return "/" + appContext.getPackageName() + "-{date: yyyy-MM-dd_HH-mm-ss}-{count}.txt";
    }

    @Override // timber.log.Timber.Tree
    protected void log(int priority, String tag, String message, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (priority < this.logLevel) {
            return;
        }
        String strTake = StringsKt.take(message, 4000);
        if (priority == 2) {
            if (t == null) {
                FileLogger fileLogger = FileLogger.INSTANCE;
                Intrinsics.checkNotNull(strTake, "null cannot be cast to non-null type kotlin.Any");
                fileLogger.trace(strTake);
                return;
            }
            FileLogger.INSTANCE.trace(t, strTake);
            return;
        }
        if (priority == 3) {
            if (t == null) {
                FileLogger fileLogger2 = FileLogger.INSTANCE;
                Intrinsics.checkNotNull(strTake, "null cannot be cast to non-null type kotlin.Any");
                fileLogger2.debug(strTake);
                return;
            }
            FileLogger.INSTANCE.debug(t, strTake);
            return;
        }
        if (priority == 4) {
            if (t == null) {
                FileLogger fileLogger3 = FileLogger.INSTANCE;
                Intrinsics.checkNotNull(strTake, "null cannot be cast to non-null type kotlin.Any");
                fileLogger3.info(strTake);
                return;
            }
            FileLogger.INSTANCE.info(t, strTake);
            return;
        }
        if (priority == 5) {
            if (t == null) {
                FileLogger fileLogger4 = FileLogger.INSTANCE;
                Intrinsics.checkNotNull(strTake, "null cannot be cast to non-null type kotlin.Any");
                fileLogger4.warn(strTake);
                return;
            }
            FileLogger.INSTANCE.warn(t, strTake);
            return;
        }
        if (priority != 6) {
            return;
        }
        if (t == null) {
            FileLogger fileLogger5 = FileLogger.INSTANCE;
            Intrinsics.checkNotNull(strTake, "null cannot be cast to non-null type kotlin.Any");
            fileLogger5.error(strTake);
            return;
        }
        FileLogger.INSTANCE.error(t, strTake);
    }
}
