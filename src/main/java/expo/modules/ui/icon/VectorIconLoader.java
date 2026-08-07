package expo.modules.ui.icon;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.util.Xml;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathParser;
import androidx.compose.ui.unit.Dp;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.common.util.UriUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: VectorIconLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\u0017\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lexpo/modules/ui/icon/VectorIconLoader;", "", "context", "Landroid/content/Context;", "okHttpClient", "Lokhttp3/OkHttpClient;", "<init>", "(Landroid/content/Context;Lokhttp3/OkHttpClient;)V", "loadFromUri", "Lexpo/modules/ui/icon/VectorIconLoader$IconResult;", "uriString", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getInputStreamForUri", "Ljava/io/InputStream;", "uri", "Landroid/net/Uri;", "downloadFromHttp", "url", "loadFromResourceId", "parseIconFromStream", "inputStream", "isXmlContent", "", "bytes", "", "parseXmlToImageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseVectorElement", "parsePathElement", "", "builder", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "parseDimension", "Landroidx/compose/ui/unit/Dp;", "value", "parseDimension-u2uoSUM", "(Ljava/lang/String;)F", "parseColor", "Landroidx/compose/ui/graphics/Color;", "colorValue", "parseColor-vNxB06k", "(Ljava/lang/String;)J", "IconResult", "Companion", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VectorIconLoader {
    private static final String TAG = "VectorIconLoader";
    private final Context context;
    private final OkHttpClient okHttpClient;
    public static final int $stable = 8;

    public VectorIconLoader(Context context, OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
        this.context = context;
        this.okHttpClient = okHttpClient;
    }

    /* JADX INFO: compiled from: VectorIconLoader.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lexpo/modules/ui/icon/VectorIconLoader$IconResult;", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "drawable", "Landroid/graphics/drawable/Drawable;", "<init>", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroid/graphics/drawable/Drawable;)V", "getImageVector", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class IconResult {
        public static final int $stable = 8;
        private final Drawable drawable;
        private final ImageVector imageVector;

        /* JADX WARN: Multi-variable type inference failed */
        public IconResult() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ IconResult copy$default(IconResult iconResult, ImageVector imageVector, Drawable drawable, int i, Object obj) {
            if ((i & 1) != 0) {
                imageVector = iconResult.imageVector;
            }
            if ((i & 2) != 0) {
                drawable = iconResult.drawable;
            }
            return iconResult.copy(imageVector, drawable);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ImageVector getImageVector() {
            return this.imageVector;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }

        public final IconResult copy(ImageVector imageVector, Drawable drawable) {
            return new IconResult(imageVector, drawable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IconResult)) {
                return false;
            }
            IconResult iconResult = (IconResult) other;
            return Intrinsics.areEqual(this.imageVector, iconResult.imageVector) && Intrinsics.areEqual(this.drawable, iconResult.drawable);
        }

        public int hashCode() {
            ImageVector imageVector = this.imageVector;
            int iHashCode = (imageVector == null ? 0 : imageVector.hashCode()) * 31;
            Drawable drawable = this.drawable;
            return iHashCode + (drawable != null ? drawable.hashCode() : 0);
        }

        public String toString() {
            return "IconResult(imageVector=" + this.imageVector + ", drawable=" + this.drawable + ")";
        }

        public IconResult(ImageVector imageVector, Drawable drawable) {
            this.imageVector = imageVector;
            this.drawable = drawable;
        }

        public /* synthetic */ IconResult(ImageVector imageVector, Drawable drawable, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : imageVector, (i & 2) != 0 ? null : drawable);
        }

        public final ImageVector getImageVector() {
            return this.imageVector;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }
    }

    /* JADX INFO: renamed from: expo.modules.ui.icon.VectorIconLoader$loadFromUri$2, reason: invalid class name */
    /* JADX INFO: compiled from: VectorIconLoader.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lexpo/modules/ui/icon/VectorIconLoader$IconResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.ui.icon.VectorIconLoader$loadFromUri$2", f = "VectorIconLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IconResult>, Object> {
        final /* synthetic */ String $uriString;
        int label;
        final /* synthetic */ VectorIconLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, VectorIconLoader vectorIconLoader, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$uriString = str;
            this.this$0 = vectorIconLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$uriString, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super IconResult> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$uriString;
            int i = 3;
            ImageVector imageVector = null;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            Object[] objArr4 = 0;
            Object[] objArr5 = 0;
            Object[] objArr6 = 0;
            Object[] objArr7 = 0;
            Object[] objArr8 = 0;
            Object[] objArr9 = 0;
            Object[] objArr10 = 0;
            Object[] objArr11 = 0;
            if (str == null || str.length() == 0) {
                return new IconResult(objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
            }
            try {
                Uri uri = Uri.parse(this.$uriString);
                try {
                    if (Intrinsics.areEqual(uri.getScheme(), UriUtil.LOCAL_RESOURCE_SCHEME)) {
                        VectorIconLoader vectorIconLoader = this.this$0;
                        Intrinsics.checkNotNull(uri);
                        return vectorIconLoader.loadFromResourceId(uri);
                    }
                    VectorIconLoader vectorIconLoader2 = this.this$0;
                    Intrinsics.checkNotNull(uri);
                    InputStream inputStreamForUri = vectorIconLoader2.getInputStreamForUri(uri);
                    if (inputStreamForUri == null) {
                        return new IconResult(imageVector, objArr11 == true ? 1 : 0, i, objArr10 == true ? 1 : 0);
                    }
                    InputStream inputStream = inputStreamForUri;
                    try {
                        IconResult iconFromStream = this.this$0.parseIconFromStream(inputStream);
                        CloseableKt.closeFinally(inputStream, null);
                        return iconFromStream;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStream, th);
                            throw th2;
                        }
                    }
                } catch (Exception e) {
                    Log.e(VectorIconLoader.TAG, "Failed to load icon from URI: " + uri, e);
                    return new IconResult(objArr9 == true ? 1 : 0, objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
                }
            } catch (Exception e2) {
                Log.e(VectorIconLoader.TAG, "Failed to parse URI: " + this.$uriString, e2);
                return new IconResult(objArr6 == true ? 1 : 0, objArr5 == true ? 1 : 0, i, objArr4 == true ? 1 : 0);
            }
        }
    }

    public final Object loadFromUri(String str, Continuation<? super IconResult> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (r0.equals("https") == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r0.equals("http") == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        r3 = r3.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "toString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        return downloadFromHttp(r3);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.InputStream getInputStreamForUri(android.net.Uri r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.getScheme()
            if (r0 == 0) goto L74
            int r1 = r0.hashCode()
            switch(r1) {
                case -368816979: goto L60;
                case 3143036: goto L42;
                case 3213448: goto L2b;
                case 99617003: goto L22;
                case 951530617: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L74
        Le:
            java.lang.String r1 = "content"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L17
            goto L74
        L17:
            android.content.Context r2 = r2.context
            android.content.ContentResolver r2 = r2.getContentResolver()
            java.io.InputStream r2 = com.microsoft.intune.mam.client.content.MAMContentResolverManagement.openInputStream(r2, r3)
            return r2
        L22:
            java.lang.String r1 = "https"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L34
            goto L74
        L2b:
            java.lang.String r1 = "http"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L34
            goto L74
        L34:
            java.lang.String r3 = r3.toString()
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            java.io.InputStream r2 = r2.downloadFromHttp(r3)
            return r2
        L42:
            java.lang.String r1 = "file"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L4b
            goto L74
        L4b:
            java.lang.String r2 = r3.getPath()
            if (r2 != 0) goto L53
            r2 = 0
            return r2
        L53:
            java.io.FileInputStream r3 = new java.io.FileInputStream
            java.io.File r0 = new java.io.File
            r0.<init>(r2)
            r3.<init>(r0)
            java.io.InputStream r3 = (java.io.InputStream) r3
            return r3
        L60:
            java.lang.String r1 = "android.resource"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L69
            goto L74
        L69:
            android.content.Context r2 = r2.context
            android.content.ContentResolver r2 = r2.getContentResolver()
            java.io.InputStream r2 = com.microsoft.intune.mam.client.content.MAMContentResolverManagement.openInputStream(r2, r3)
            return r2
        L74:
            android.content.Context r2 = r2.context
            android.content.ContentResolver r2 = r2.getContentResolver()
            java.io.InputStream r2 = com.microsoft.intune.mam.client.content.MAMContentResolverManagement.openInputStream(r2, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.ui.icon.VectorIconLoader.getInputStreamForUri(android.net.Uri):java.io.InputStream");
    }

    private final InputStream downloadFromHttp(String url) {
        try {
            Response responseExecute = this.okHttpClient.newCall(new Request.Builder().url(url).build()).execute();
            if (responseExecute.isSuccessful()) {
                ResponseBody responseBodyBody = responseExecute.body();
                if (responseBodyBody != null) {
                    return responseBodyBody.byteStream();
                }
                return null;
            }
            Log.e(TAG, "Failed to download icon from " + url + ": " + responseExecute.code());
            responseExecute.close();
            return null;
        } catch (Exception e) {
            Log.e(TAG, "HTTP download failed: " + url, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final IconResult loadFromResourceId(Uri uri) {
        Integer intOrNull;
        String strTrimStart;
        String lastPathSegment = uri.getLastPathSegment();
        int i = 1;
        Drawable drawable = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        if (lastPathSegment == null || (intOrNull = StringsKt.toIntOrNull(lastPathSegment)) == null) {
            String path = uri.getPath();
            intOrNull = (path == null || (strTrimStart = StringsKt.trimStart(path, '/')) == null) ? null : StringsKt.toIntOrNull(strTrimStart);
        }
        int i2 = 3;
        if (intOrNull == null || intOrNull.intValue() <= 0) {
            Log.w(TAG, "Invalid resource ID in URI: " + uri);
            return new IconResult(objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0, i2, objArr == true ? 1 : 0);
        }
        try {
            XmlResourceParser xml = this.context.getResources().getXml(intOrNull.intValue());
            Intrinsics.checkNotNullExpressionValue(xml, "getXml(...)");
            XmlResourceParser xmlResourceParser = xml;
            try {
                ImageVector xmlToImageVector = parseXmlToImageVector(xmlResourceParser);
                if (xmlToImageVector != null) {
                    IconResult iconResult = new IconResult(xmlToImageVector, drawable, 2, objArr9 == true ? 1 : 0);
                    AutoCloseableKt.closeFinally(xmlResourceParser, null);
                    return iconResult;
                }
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(xmlResourceParser, null);
                try {
                    InputStream inputStreamOpenRawResource = this.context.getResources().openRawResource(intOrNull.intValue());
                    try {
                        IconResult iconResult2 = new IconResult(objArr8 == true ? 1 : 0, Drawable.createFromStream(inputStreamOpenRawResource, null), i, objArr7 == true ? 1 : 0);
                        CloseableKt.closeFinally(inputStreamOpenRawResource, null);
                        return iconResult2;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStreamOpenRawResource, th);
                            throw th2;
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Failed to load resource " + intOrNull, e);
                    return new IconResult(objArr6 == true ? 1 : 0, objArr5 == true ? 1 : 0, i2, objArr4 == true ? 1 : 0);
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    AutoCloseableKt.closeFinally(xmlResourceParser, th3);
                    throw th4;
                }
            }
        } catch (Exception e2) {
            Log.d(TAG, "Resource " + intOrNull + " is not XML, trying as raw resource", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final IconResult parseIconFromStream(InputStream inputStream) {
        byte[] bytes = ByteStreamsKt.readBytes(inputStream);
        Drawable drawable = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (isXmlContent(bytes)) {
            return new IconResult(parseXmlToImageVector(bytes), drawable, 2, objArr3 == true ? 1 : 0);
        }
        return new IconResult(objArr2 == true ? 1 : 0, Drawable.createFromStream(new ByteArrayInputStream(bytes), null), 1, objArr == true ? 1 : 0);
    }

    private final boolean isXmlContent(byte[] bytes) {
        if (bytes.length < 5) {
            return false;
        }
        int i = (bytes.length >= 3 && bytes[0] == -17 && bytes[1] == -69 && bytes[2] == -65) ? 3 : 0;
        int iMin = Math.min(i + 10, bytes.length);
        while (i < iMin) {
            byte b = bytes[i];
            if (b == 60) {
                return true;
            }
            if (b != 32 && b != 9 && b != 10 && b != 13) {
                return false;
            }
            i++;
        }
        return false;
    }

    public final ImageVector parseXmlToImageVector(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bytes), "UTF-8");
            Intrinsics.checkNotNull(xmlPullParserNewPullParser);
            return parseXmlToImageVector(xmlPullParserNewPullParser);
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse XML to ImageVector", e);
            return null;
        }
    }

    public final ImageVector parseXmlToImageVector(XmlPullParser parser) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        try {
            int eventType = parser.getEventType();
            while (eventType != 1) {
                if (eventType == 2 && Intrinsics.areEqual(parser.getName(), "vector")) {
                    return parseVectorElement(parser);
                }
                eventType = parser.next();
            }
            Log.w(TAG, "No <vector> element found in XML");
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse XML to ImageVector", e);
            return null;
        }
    }

    private final void parsePathElement(XmlPullParser parser, ImageVector.Builder builder) {
        try {
            String attributeValue = "";
            int attributeCount = parser.getAttributeCount();
            Color colorM6804boximpl = null;
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = parser.getAttributeName(i);
                if (Intrinsics.areEqual(attributeName, "pathData")) {
                    attributeValue = parser.getAttributeValue(i);
                    Intrinsics.checkNotNullExpressionValue(attributeValue, "getAttributeValue(...)");
                } else {
                    if (Intrinsics.areEqual(attributeName, "fillColor")) {
                        String attributeValue2 = parser.getAttributeValue(i);
                        Intrinsics.checkNotNullExpressionValue(attributeValue2, "getAttributeValue(...)");
                        colorM6804boximpl = Color.m6804boximpl(m14687parseColorvNxB06k(attributeValue2));
                    }
                }
            }
            if (attributeValue.length() > 0) {
                ImageVector.Builder.m7552addPathoIyEayM$default(builder, new PathParser().parsePathString(attributeValue).toNodes(), 0, null, colorM6804boximpl != null ? new SolidColor(colorM6804boximpl.m6824unboximpl(), null) : null, 0.0f, null, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 16374, null);
            }
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse <path> element", e);
        }
    }

    /* JADX INFO: renamed from: parseDimension-u2uoSUM, reason: not valid java name */
    private final float m14688parseDimensionu2uoSUM(String value) {
        try {
            return Dp.m9687constructorimpl(Float.parseFloat(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(value, "dp", "", false, 4, (Object) null), "dip", "", false, 4, (Object) null), "px", "", false, 4, (Object) null)));
        } catch (Exception unused) {
            Log.w(TAG, "Failed to parse dimension: " + value + ", using default 24dp");
            return Dp.m9687constructorimpl(24);
        }
    }

    /* JADX INFO: renamed from: parseColor-vNxB06k, reason: not valid java name */
    private final long m14687parseColorvNxB06k(String colorValue) {
        try {
            if (StringsKt.startsWith$default(colorValue, "#", false, 2, (Object) null)) {
                return ColorKt.Color(android.graphics.Color.parseColor(colorValue));
            }
            if (!StringsKt.startsWith$default(colorValue, "@android:color/", false, 2, (Object) null) && !StringsKt.startsWith$default(colorValue, "?attr/", false, 2, (Object) null)) {
                Log.w(TAG, "Unknown color format: " + colorValue + ", using black");
                return Color.INSTANCE.m6840getBlack0d7_KjU();
            }
            Log.d(TAG, "Theme color attribute not resolved: " + colorValue + ", using black");
            return Color.INSTANCE.m6840getBlack0d7_KjU();
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse color: " + colorValue, e);
            return Color.INSTANCE.m6840getBlack0d7_KjU();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final ImageVector parseVectorElement(XmlPullParser parser) {
        float f = 24;
        try {
            float fM9687constructorimpl = Dp.m9687constructorimpl(f);
            float fM9687constructorimpl2 = Dp.m9687constructorimpl(f);
            int attributeCount = parser.getAttributeCount();
            float fM14688parseDimensionu2uoSUM = fM9687constructorimpl2;
            float fM14688parseDimensionu2uoSUM2 = fM9687constructorimpl;
            float fFloatValue = 24.0f;
            float fFloatValue2 = 24.0f;
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = parser.getAttributeName(i);
                if (attributeName != null) {
                    switch (attributeName.hashCode()) {
                        case -1499022144:
                            if (attributeName.equals("viewportWidth")) {
                                String attributeValue = parser.getAttributeValue(i);
                                Intrinsics.checkNotNullExpressionValue(attributeValue, "getAttributeValue(...)");
                                Float floatOrNull = StringsKt.toFloatOrNull(attributeValue);
                                fFloatValue = floatOrNull != null ? floatOrNull.floatValue() : 24.0f;
                            }
                            break;
                        case -1221029593:
                            if (attributeName.equals("height")) {
                                String attributeValue2 = parser.getAttributeValue(i);
                                Intrinsics.checkNotNullExpressionValue(attributeValue2, "getAttributeValue(...)");
                                fM14688parseDimensionu2uoSUM = m14688parseDimensionu2uoSUM(attributeValue2);
                            }
                            break;
                        case 113126854:
                            if (attributeName.equals("width")) {
                                String attributeValue3 = parser.getAttributeValue(i);
                                Intrinsics.checkNotNullExpressionValue(attributeValue3, "getAttributeValue(...)");
                                fM14688parseDimensionu2uoSUM2 = m14688parseDimensionu2uoSUM(attributeValue3);
                            }
                            break;
                        case 341959021:
                            if (attributeName.equals("viewportHeight")) {
                                String attributeValue4 = parser.getAttributeValue(i);
                                Intrinsics.checkNotNullExpressionValue(attributeValue4, "getAttributeValue(...)");
                                Float floatOrNull2 = StringsKt.toFloatOrNull(attributeValue4);
                                fFloatValue2 = floatOrNull2 != null ? floatOrNull2.floatValue() : 24.0f;
                            }
                            break;
                    }
                }
            }
            ImageVector.Builder builder = new ImageVector.Builder(null, fM14688parseDimensionu2uoSUM2, fM14688parseDimensionu2uoSUM, fFloatValue, fFloatValue2, 0L, 0, false, JfifUtil.MARKER_APP1, null);
            int next = parser.next();
            while (next != 1) {
                if (next != 2) {
                    if (next == 3 && Intrinsics.areEqual(parser.getName(), "vector")) {
                        return builder.build();
                    }
                } else if (Intrinsics.areEqual(parser.getName(), "path")) {
                    parsePathElement(parser, builder);
                }
                next = parser.next();
            }
            return builder.build();
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse <vector> element", e);
            return null;
        }
    }
}
