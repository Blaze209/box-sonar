package sdk.pendo.io.logging;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.androidsdk.content.models.BoxFile;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0017J,\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H\u0007R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lsdk/pendo/io/logging/c;", "Lsdk/pendo/io/logging/PendoLogger$b;", "", BoxCommonConstants.EXTRA_FILE_NAME, "Ljava/io/File;", "fileLocation", "Lsdk/pendo/io/w7/b$d;", "openMode", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/StackTraceElement;", "element", "", LogFactory.PRIORITY_KEY, "tag", "message", "", "t", "text", "Lsdk/pendo/io/w7/a;", "b", "Lsdk/pendo/io/w7/a;", "getFile", "()Lsdk/pendo/io/w7/a;", "setFile", "(Lsdk/pendo/io/w7/a;)V", "file", "<init>", "()V", "c", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class c extends PendoLogger.b {
    private static volatile WeakReference<c> d;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private sdk.pendo.io.w7.a file;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Object e = new Object();

    /* JADX INFO: renamed from: sdk.pendo.io.logging.c$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/logging/c$a;", "", "Lsdk/pendo/io/logging/c;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/ref/WeakReference;", "instanceRef", "Ljava/lang/ref/WeakReference;", BoxFile.FIELD_LOCK, "Ljava/lang/Object;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            c cVar;
            c cVar2;
            WeakReference weakReference = c.d;
            if (weakReference != null && (cVar2 = (c) weakReference.get()) != null) {
                return cVar2;
            }
            synchronized (c.e) {
                WeakReference weakReference2 = c.d;
                if (weakReference2 != null && (cVar = (c) weakReference2.get()) != null) {
                    Intrinsics.checkNotNull(cVar);
                    return cVar;
                }
                c cVar3 = new c(null);
                c.d = new WeakReference(cVar3);
                return cVar3;
            }
        }
    }

    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // sdk.pendo.io.logging.PendoLogger.b
    public String a(StackTraceElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        String className = element.getClassName();
        String methodName = element.getMethodName();
        int lineNumber = element.getLineNumber();
        Matcher matcher = PendoLogger.ANONYMOUS_CLASS.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        String str = className;
        Intrinsics.checkNotNull(str);
        Intrinsics.checkNotNull(str);
        String strSubstring = str.substring(StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
        return "Pendo::" + strSubstring + ":" + methodName + "():" + lineNumber + ":";
    }

    @Override // sdk.pendo.io.logging.PendoLogger.b, sdk.pendo.io.logging.PendoLogger.d
    public void a(int priority, String tag, String message, Throwable t) {
        StringBuilder sbAppend;
        Intrinsics.checkNotNullParameter(message, "message");
        if (priority == 7) {
            sbAppend = new StringBuilder("{tag: \"").append(tag).append("\", message: \"").append(message).append("\", t:\"").append(t != null ? t.getStackTrace() : null);
        } else {
            sbAppend = new StringBuilder("{priority: \"").append(priority).append("\", tag: \"").append(tag).append("\", message: \"").append(message).append("\", t:\"").append(t != null ? t.getStackTrace() : null);
        }
        a(sbAppend.append("\"}\n").toString());
    }

    public final void a(String fileName, File fileLocation, sdk.pendo.io.w7.b.d openMode) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(fileLocation, "fileLocation");
        Intrinsics.checkNotNullParameter(openMode, "openMode");
        this.file = sdk.pendo.io.w7.b.a(sdk.pendo.io.w7.b.INSTANCE.a(), fileName, fileLocation, openMode, false, 8, null);
    }

    public final void a(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        sdk.pendo.io.w7.a aVar = this.file;
        if (aVar != null) {
            aVar.a(text);
        }
    }
}
