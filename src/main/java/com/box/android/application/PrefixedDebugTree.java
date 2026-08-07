package com.box.android.application;

import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.logging.LogFactory;
import timber.log.Timber;

/* JADX INFO: compiled from: PrefixedDebugTree.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0017\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002¨\u0006\u0012"}, d2 = {"Lcom/box/android/application/PrefixedDebugTree;", "Ltimber/log/Timber$DebugTree;", "<init>", "()V", "log", "", LogFactory.PRIORITY_KEY, "", "tag", "", "message", "t", "", "resolveTag", "resolveTag$box_generalProdRelease", "isIgnoredTag", "", "resolveCallerTag", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PrefixedDebugTree extends Timber.DebugTree {
    public static final int $stable = 8;

    @Override // timber.log.Timber.DebugTree, timber.log.Timber.Tree
    protected void log(int priority, String tag, String message, Throwable t) {
        Intrinsics.checkNotNullParameter(message, "message");
        super.log(priority, resolveTag$box_generalProdRelease(tag), message, t);
    }

    public final String resolveTag$box_generalProdRelease(String tag) {
        String str;
        if (tag != null) {
            if (isIgnoredTag(tag)) {
                tag = null;
            }
            if (tag != null && (str = "Box/" + tag) != null) {
                return str;
            }
        }
        return resolveCallerTag();
    }

    private final boolean isIgnoredTag(String tag) {
        Set<String> set = PrefixedDebugTreeKt.IGNORED_CLASS_NAMES;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (String str : set) {
            if (Intrinsics.areEqual(str, tag)) {
                return true;
            }
            Intrinsics.checkNotNull(str);
            if (StringsKt.endsWith$default(str, "." + tag, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private final String resolveCallerTag() {
        StackTraceElement stackTraceElement;
        String strSubstringBefore$default;
        String className;
        String strSubstringAfterLast$default;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
        StackTraceElement[] stackTraceElementArr = stackTrace;
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                stackTraceElement = null;
                break;
            }
            stackTraceElement = stackTraceElementArr[i];
            if (!PrefixedDebugTreeKt.IGNORED_CLASS_NAMES.contains(stackTraceElement.getClassName())) {
                break;
            }
            i++;
        }
        StackTraceElement stackTraceElement2 = stackTraceElement;
        if (stackTraceElement2 == null || (className = stackTraceElement2.getClassName()) == null || (strSubstringAfterLast$default = StringsKt.substringAfterLast$default(className, '.', (String) null, 2, (Object) null)) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(strSubstringAfterLast$default, '$', (String) null, 2, (Object) null)) == null) {
            strSubstringBefore$default = "Unknown";
        }
        return "Box/" + strSubstringBefore$default;
    }
}
