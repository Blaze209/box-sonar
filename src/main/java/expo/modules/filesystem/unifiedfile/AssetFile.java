package expo.modules.filesystem.unifiedfile;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.box.android.common.utilities.BoxCommonConstants;
import com.pspdfkit.analytics.Analytics;
import expo.modules.kotlin.AppContext;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AssetFile.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\"H\u0016J\u000f\u0010%\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0002\u0010'J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020&H\u0016J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u000003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010#\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\rR\u0016\u0010(\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\rR\u0016\u0010*\u001a\u0004\u0018\u00010&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'¨\u00064"}, d2 = {"Lexpo/modules/filesystem/unifiedfile/AssetFile;", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/content/Context;Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "path", "", "getPath", "()Ljava/lang/String;", "exists", "", "isDirectory", "isFile", "contentUri", "getContentUri", "setContentUri", "(Landroid/net/Uri;)V", "appContext", "Lexpo/modules/kotlin/AppContext;", "parentFile", "getParentFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "createFile", "mimeType", "displayName", "createDirectory", "delete", "deleteRecursively", "listFilesAsUnified", "", "type", "getType", "lastModified", "", "()Ljava/lang/Long;", BoxCommonConstants.EXTRA_FILE_NAME, "getFileName", "creationTime", "getCreationTime", "outputStream", "Ljava/io/OutputStream;", "append", "inputStream", "Ljava/io/InputStream;", Analytics.Data.LENGTH, "walkTopDown", "Lkotlin/sequences/Sequence;", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssetFile implements UnifiedFileInterface {
    private Uri contentUri;
    private final Context context;
    private final String path;
    private final Uri uri;

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Long getCreationTime() {
        return null;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Long lastModified() {
        return null;
    }

    public AssetFile(Context context, Uri uri) {
        String strTrimStart;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.context = context;
        this.uri = uri;
        String path = getUri().getPath();
        if (path == null || (strTrimStart = StringsKt.trimStart(path, '/')) == null) {
            throw new IllegalArgumentException("Invalid asset URI: " + getUri());
        }
        this.path = strTrimStart;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Uri getUri() {
        return this.uri;
    }

    public final String getPath() {
        return this.path;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean exists() {
        return isDirectory() || isFile();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean isDirectory() throws IOException {
        String[] list = this.context.getAssets().list(this.path);
        if (list != null) {
            if (!(list.length == 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean isFile() {
        Object objM14780constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AssetFile assetFile = this;
            InputStream inputStreamOpen = this.context.getAssets().open(this.path);
            try {
                InputStream inputStream = inputStreamOpen;
                CloseableKt.closeFinally(inputStreamOpen, null);
                objM14780constructorimpl = Result.m14780constructorimpl(true);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(inputStreamOpen, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.INSTANCE;
            objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m14783exceptionOrNullimpl(objM14780constructorimpl) != null) {
            objM14780constructorimpl = false;
        }
        return ((Boolean) objM14780constructorimpl).booleanValue();
    }

    public final Uri getContentUri() {
        return this.contentUri;
    }

    public final void setContentUri(Uri uri) {
        this.contentUri = uri;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Uri getContentUri(AppContext appContext) throws IOException {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        InputStream inputStream = inputStream();
        try {
            InputStream inputStream2 = inputStream;
            File file = new File(this.context.getCacheDir(), "expo_shared_assets/" + getFileName());
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream, 0, 2, null);
                CloseableKt.closeFinally(fileOutputStream, null);
                Uri contentUri = new JavaFile(Uri.fromFile(file)).getContentUri(appContext);
                this.contentUri = contentUri;
                CloseableKt.closeFinally(inputStream, null);
                return contentUri;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(inputStream, th3);
                throw th4;
            }
        }
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface getParentFile() {
        String path = getUri().getPath();
        if (path == null) {
            path = "";
        }
        if (path.length() == 0) {
            return null;
        }
        return new AssetFile(this.context, Uri.parse("asset:///" + StringsKt.substringBeforeLast$default(path, '/', (String) null, 2, (Object) null)));
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface createFile(String mimeType, String displayName) {
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        throw new UnsupportedOperationException("Asset files are not writable and cannot be created");
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public UnifiedFileInterface createDirectory(String displayName) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        throw new UnsupportedOperationException("Asset directories are not writable and cannot be created");
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean delete() {
        throw new UnsupportedOperationException("Asset files are not writable and cannot be deleted");
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public boolean deleteRecursively() {
        throw new UnsupportedOperationException("Asset files are not writable and cannot be deleted");
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public List<UnifiedFileInterface> listFilesAsUnified() throws IOException {
        String[] list = this.context.getAssets().list(this.path);
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.length);
        for (String str : list) {
            if (this.path.length() != 0) {
                str = this.path + "/" + str;
            }
            arrayList.add(new AssetFile(this.context, Uri.parse("asset:///" + str)));
        }
        return arrayList;
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public String getType() {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(getUri().toString());
        Intrinsics.checkNotNull(fileExtensionFromUrl);
        if (fileExtensionFromUrl.length() <= 0) {
            return null;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String lowerCase = fileExtensionFromUrl.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return singleton.getMimeTypeFromExtension(lowerCase);
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public String getFileName() {
        return getUri().getLastPathSegment();
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public OutputStream outputStream(boolean append) {
        throw new UnsupportedOperationException("Asset files are not writable");
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public InputStream inputStream() throws IOException {
        InputStream inputStreamOpen = this.context.getAssets().open(this.path);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        return inputStreamOpen;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0063 A[Catch: all -> 0x006c, LOOP:0: B:21:0x005c->B:23:0x0063, LOOP_END, TryCatch #4 {all -> 0x006c, blocks: (B:20:0x0054, B:21:0x005c, B:23:0x0063, B:24:0x0066), top: B:41:0x0054, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0066 A[SYNTHETIC] */
    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public long length() {
        InputStream inputStreamOpen;
        InputStream inputStream;
        byte[] bArr;
        long j;
        int i;
        try {
            try {
                Result.Companion companion = Result.INSTANCE;
                AssetFile assetFile = this;
                AssetFileDescriptor assetFileDescriptorOpenFd = this.context.getAssets().openFd(this.path);
                try {
                    long length = assetFileDescriptorOpenFd.getLength();
                    try {
                        if (length > 0) {
                            CloseableKt.closeFinally(assetFileDescriptorOpenFd, null);
                            return length;
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(assetFileDescriptorOpenFd, null);
                        Result.m14780constructorimpl(Unit.INSTANCE);
                        Result.Companion companion2 = Result.INSTANCE;
                        AssetFile assetFile2 = this;
                        inputStreamOpen = this.context.getAssets().open(this.path);
                        inputStream = inputStreamOpen;
                        bArr = new byte[8192];
                        j = 0;
                        while (true) {
                            i = inputStream.read(bArr);
                            if (i != -1) {
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStreamOpen, null);
                                return j;
                            }
                            j += (long) i;
                        }
                        inputStream = inputStreamOpen;
                        bArr = new byte[8192];
                        j = 0;
                        while (true) {
                            i = inputStream.read(bArr);
                            if (i != -1) {
                                Unit unit3 = Unit.INSTANCE;
                                CloseableKt.closeFinally(inputStreamOpen, null);
                                return j;
                            }
                            j += (long) i;
                            Result.Companion companion3 = Result.INSTANCE;
                            Result.m14780constructorimpl(ResultKt.createFailure(th));
                            return 0L;
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStreamOpen, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(assetFileDescriptorOpenFd, th3);
                        throw th4;
                    }
                }
            } catch (Throwable th5) {
                Result.Companion companion4 = Result.INSTANCE;
                Result.m14780constructorimpl(ResultKt.createFailure(th5));
            }
            Result.Companion companion5 = Result.INSTANCE;
            AssetFile assetFile3 = this;
            inputStreamOpen = this.context.getAssets().open(this.path);
        } catch (Throwable th6) {
            Result.Companion companion6 = Result.INSTANCE;
            Result.m14780constructorimpl(ResultKt.createFailure(th6));
            return 0L;
        }
        Result.Companion companion7 = Result.INSTANCE;
        Result.m14780constructorimpl(ResultKt.createFailure(th5));
    }

    /* JADX INFO: renamed from: expo.modules.filesystem.unifiedfile.AssetFile$walkTopDown$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssetFile.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lexpo/modules/filesystem/unifiedfile/AssetFile;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "expo.modules.filesystem.unifiedfile.AssetFile$walkTopDown$1", f = "AssetFile.kt", i = {0, 1, 1}, l = {Token.LOOP, 139}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "$this$forEach$iv"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super AssetFile>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = AssetFile.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super AssetFile> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0075  */
        /* JADX WARN: Code duplicated, block: B:22:0x0084  */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
        
            if (r1.yield(r12.this$0, r12) == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x00cf, code lost:
        
            if (r7.yieldAll(r13, r12) == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00d1, code lost:
        
            return r0;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00cf -> B:26:0x00d2). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 215
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.unifiedfile.AssetFile.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // expo.modules.filesystem.unifiedfile.UnifiedFileInterface
    public Sequence<AssetFile> walkTopDown() {
        return SequencesKt.sequence(new AnonymousClass1(null));
    }
}
