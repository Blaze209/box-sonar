package expo.modules.constants;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.media3.common.C;
import expo.modules.interfaces.constants.ConstantsInterface;
import expo.modules.kotlin.services.ServiceInterface;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: ConstantsService.kt */
/* JADX INFO: loaded from: classes3.dex */
@ServiceInterface(clazz = ConstantsInterface.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0007\b\u0017\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lexpo/modules/constants/ConstantsService;", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "statusBarHeightInternal", "", "getStatusBarHeightInternal", "()I", "setStatusBarHeightInternal", "(I)V", "sessionId", "", "constants", "", "", "getConstants", "()Ljava/util/Map;", "appScopeKey", "getAppScopeKey", "()Ljava/lang/String;", "deviceName", "getDeviceName", "statusBarHeight", "getStatusBarHeight", "systemVersion", "getSystemVersion", "systemFonts", "", "getSystemFonts", "()Ljava/util/List;", "appConfig", "getAppConfig", "ExecutionEnvironment", "Companion", "expo-constants_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ConstantsService implements ConstantsInterface {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final String sessionId;
    private int statusBarHeightInternal;

    public ConstantsService(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Integer numValueOf = Integer.valueOf(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        numValueOf = numValueOf.intValue() <= 0 ? null : numValueOf;
        this.statusBarHeightInternal = numValueOf != null ? INSTANCE.convertPixelsToDp(context.getResources().getDimensionPixelSize(numValueOf.intValue()), context) : 0;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.sessionId = string;
    }

    public final int getStatusBarHeightInternal() {
        return this.statusBarHeightInternal;
    }

    public final void setStatusBarHeightInternal(int i) {
        this.statusBarHeightInternal = i;
    }

    /* JADX INFO: compiled from: ConstantsService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lexpo/modules/constants/ConstantsService$ExecutionEnvironment;", "", "string", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getString", "()Ljava/lang/String;", "BARE", "STANDALONE", "STORE_CLIENT", "expo-constants_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum ExecutionEnvironment {
        BARE("bare"),
        STANDALONE("standalone"),
        STORE_CLIENT("storeClient");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String string;

        public static EnumEntries<ExecutionEnvironment> getEntries() {
            return $ENTRIES;
        }

        ExecutionEnvironment(String str) {
            this.string = str;
        }

        public final String getString() {
            return this.string;
        }
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public Map<String, Object> getConstants() {
        return MapsKt.mapOf(TuplesKt.to("sessionId", this.sessionId), TuplesKt.to("executionEnvironment", ExecutionEnvironment.BARE.getString()), TuplesKt.to("statusBarHeight", Integer.valueOf(this.statusBarHeightInternal)), TuplesKt.to("deviceName", getDeviceName()), TuplesKt.to("systemFonts", getSystemFonts()), TuplesKt.to("systemVersion", getSystemVersion()), TuplesKt.to("manifest", getAppConfig()), TuplesKt.to("platform", MapsKt.mapOf(TuplesKt.to("android", MapsKt.emptyMap()))));
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public String getAppScopeKey() {
        return this.context.getPackageName();
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public String getDeviceName() {
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    /* JADX INFO: renamed from: getStatusBarHeight, reason: from getter */
    public int getStatusBarHeightInternal() {
        return this.statusBarHeightInternal;
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public String getSystemVersion() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }

    @Override // expo.modules.interfaces.constants.ConstantsInterface
    public List<String> getSystemFonts() {
        return CollectionsKt.listOf((Object[]) new String[]{SemanticAttributes.MessagingRocketmqMessageTypeValues.NORMAL, "notoserif", C.SANS_SERIF_NAME, "sans-serif-light", "sans-serif-thin", "sans-serif-condensed", "sans-serif-medium", C.SERIF_NAME, "Roboto", "monospace"});
    }

    private final String getAppConfig() {
        try {
            InputStream inputStreamOpen = this.context.getAssets().open("app.config");
            try {
                InputStream inputStream = inputStreamOpen;
                Intrinsics.checkNotNull(inputStream);
                Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    String text = TextStreamsKt.readText(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    CloseableKt.closeFinally(inputStreamOpen, null);
                    return text;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStreamOpen, th3);
                    throw th4;
                }
            }
        } catch (FileNotFoundException unused) {
            return null;
        } catch (Exception e) {
            Log.e(ConstantsServiceKt.TAG, "Error reading embedded app config", e);
            return null;
        }
    }

    /* JADX INFO: compiled from: ConstantsService.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"Lexpo/modules/constants/ConstantsService$Companion;", "", "<init>", "()V", "convertPixelsToDp", "", "px", "", "context", "Landroid/content/Context;", "expo-constants_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int convertPixelsToDp(float px, Context context) {
            return (int) (px / (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
        }
    }
}
