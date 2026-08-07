package expo.modules.filesystem;

import android.net.Uri;
import android.util.Base64;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.typedarray.TypedArray;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: compiled from: FileSystemFile.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00142\b\b\u0002\u0010\u0013\u001a\u00020\nJ\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00152\b\b\u0002\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\u0012J\u0006\u0010\u0017\u001a\u00020\u0012J\u0006\u0010\u0018\u001a\u00020\u0012J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0003J\u0010\u0010&\u001a\u00020'2\b\u0010\u000e\u001a\u0004\u0018\u00010(R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00128F¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b%\u0010\u001f¨\u0006)"}, d2 = {"Lexpo/modules/filesystem/FileSystemFile;", "Lexpo/modules/filesystem/FileSystemPath;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "validatePath", "", "validateType", "exists", "", "getExists", "()Z", PasskeyWebListener.CREATE_UNIQUE_KEY, "options", "Lexpo/modules/filesystem/CreateOptions;", "write", "content", "", "append", "Lexpo/modules/kotlin/typedarray/TypedArray;", "", "asString", "text", "base64", "bytes", "asContentUri", "md5", "getMd5$annotations", "()V", "getMd5", "()Ljava/lang/String;", "size", "", "getSize", "()Ljava/lang/Long;", "type", "getType", BoxRepresentation.FIELD_INFO, "Lexpo/modules/filesystem/FileInfo;", "Lexpo/modules/filesystem/InfoOptions;", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileSystemFile extends FileSystemPath {
    public static /* synthetic */ void getMd5$annotations() {
    }

    public final void validatePath() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemFile(Uri uri) {
        super(uri);
        Intrinsics.checkNotNullParameter(uri, "uri");
    }

    @Override // expo.modules.filesystem.FileSystemPath
    public void validateType() throws InvalidTypeFileException {
        validatePermission(FilePermissionService.Permission.READ);
        if (getFile().exists() && getFile().isDirectory()) {
            throw new InvalidTypeFileException();
        }
    }

    public final boolean getExists() {
        if (checkPermission(FilePermissionService.Permission.READ)) {
            return getFile().isFile();
        }
        return false;
    }

    public static /* synthetic */ void create$default(FileSystemFile fileSystemFile, CreateOptions createOptions, int i, Object obj) throws InvalidTypeFileException, UnableToCreateException {
        if ((i & 1) != 0) {
            createOptions = new CreateOptions(false, false, false, 7, null);
        }
        fileSystemFile.create(createOptions);
    }

    public final void create(CreateOptions options) throws InvalidTypeFileException, UnableToCreateException {
        File parentFile;
        Intrinsics.checkNotNullParameter(options, "options");
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        validateCanCreate(options);
        if (FileSystemPathKt.isContentUri(getUri())) {
            throw new UnableToCreateException("create function does not work with SAF Uris, use `createDirectory` and `createFile` instead");
        }
        if (options.getOverwrite() && getExists()) {
            getJavaFile().delete();
        }
        if (options.getIntermediates() && (parentFile = getJavaFile().getParentFile()) != null) {
            parentFile.mkdirs();
        }
        if (!getJavaFile().createNewFile()) {
            throw new UnableToCreateException("file already exists or could not be created");
        }
    }

    public static /* synthetic */ void write$default(FileSystemFile fileSystemFile, String str, boolean z, int i, Object obj) throws InvalidTypeFileException, IOException, UnableToCreateException {
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystemFile.write(str, z);
    }

    public final void write(String content, boolean append) throws InvalidTypeFileException, IOException, UnableToCreateException {
        Intrinsics.checkNotNullParameter(content, "content");
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        if (!getExists()) {
            create$default(this, null, 1, null);
        }
        OutputStream outputStream = getFile().outputStream(append);
        try {
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            outputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(outputStream, th);
                throw th2;
            }
        }
    }

    public static /* synthetic */ void write$default(FileSystemFile fileSystemFile, TypedArray typedArray, boolean z, int i, Object obj) throws InvalidTypeFileException, IOException, UnableToCreateException {
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystemFile.write(typedArray, z);
    }

    public final void write(TypedArray content, boolean append) throws InvalidTypeFileException, IOException, UnableToCreateException {
        Intrinsics.checkNotNullParameter(content, "content");
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        if (!getExists()) {
            create$default(this, null, 1, null);
        }
        if (FileSystemPathKt.isContentUri(getUri())) {
            OutputStream outputStream = getFile().outputStream(append);
            try {
                byte[] bArr = new byte[content.getLength()];
                content.toDirectBuffer().get(bArr);
                outputStream.write(bArr);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStream, th);
                    throw th2;
                }
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(getJavaFile(), append);
        try {
            Integer.valueOf(fileOutputStream.getChannel().write(content.toDirectBuffer()));
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(fileOutputStream, th3);
                throw th4;
            }
        }
    }

    public static /* synthetic */ void write$default(FileSystemFile fileSystemFile, byte[] bArr, boolean z, int i, Object obj) throws InvalidTypeFileException, IOException, UnableToCreateException {
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystemFile.write(bArr, z);
    }

    public final void write(byte[] content, boolean append) throws InvalidTypeFileException, IOException, UnableToCreateException {
        Intrinsics.checkNotNullParameter(content, "content");
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        if (!getExists()) {
            create$default(this, null, 1, null);
        }
        if (FileSystemPathKt.isContentUri(getUri())) {
            OutputStream outputStream = getFile().outputStream(append);
            try {
                outputStream.write(content);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(outputStream, null);
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(outputStream, th);
                    throw th2;
                }
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(getJavaFile(), append);
        try {
            fileOutputStream.write(content);
            Unit unit2 = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(fileOutputStream, th3);
                throw th4;
            }
        }
    }

    public final String asString() {
        String string = getFile().getUri().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.endsWith$default(string, "/", false, 2, (Object) null) ? StringsKt.dropLast(string, 1) : string;
    }

    public final String text() throws InvalidTypeFileException, IOException {
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        InputStream inputStream = getFile().inputStream();
        try {
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                CloseableKt.closeFinally(inputStream, null);
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
                CloseableKt.closeFinally(inputStream, th3);
                throw th4;
            }
        }
    }

    public final String base64() throws InvalidTypeFileException, IOException {
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        InputStream inputStream = getFile().inputStream();
        try {
            String strEncodeToString = Base64.encodeToString(ByteStreamsKt.readBytes(inputStream), 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            CloseableKt.closeFinally(inputStream, null);
            return strEncodeToString;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    public final byte[] bytes() throws InvalidTypeFileException, IOException {
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        InputStream inputStream = getFile().inputStream();
        try {
            byte[] bytes = ByteStreamsKt.readBytes(inputStream);
            CloseableKt.closeFinally(inputStream, null);
            return bytes;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    public final Uri asContentUri() throws InvalidTypeFileException, MissingAppContextException {
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        UnifiedFileInterface file = getFile();
        AppContext appContext = getAppContext();
        if (appContext != null) {
            return file.getContentUri(appContext);
        }
        throw new MissingAppContextException();
    }

    public final String getMd5() throws NoSuchAlgorithmException, IOException {
        validatePermission(FilePermissionService.Permission.READ);
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        InputStream inputStream = getFile().inputStream();
        try {
            byte[] bArrDigest = messageDigest.digest(ByteStreamsKt.readBytes(inputStream));
            Intrinsics.checkNotNull(bArrDigest);
            String hexString$default = HexExtensionsKt.toHexString$default(bArrDigest, (HexFormat) null, 1, (Object) null);
            CloseableKt.closeFinally(inputStream, null);
            return hexString$default;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStream, th);
                throw th2;
            }
        }
    }

    public final Long getSize() {
        if (getFile().exists()) {
            return Long.valueOf(getFile().length());
        }
        return null;
    }

    public final String getType() {
        return getFile().getType();
    }

    public final FileInfo info(InfoOptions options) throws InvalidTypeFileException {
        validateType();
        validatePermission(FilePermissionService.Permission.READ);
        if (!getFile().exists()) {
            return new FileInfo(false, FileSystemPathKt.slashifyFilePath(getFile().getUri().toString()), null, null, null, null, 60, null);
        }
        FileInfo fileInfo = new FileInfo(true, FileSystemPathKt.slashifyFilePath(getFile().getUri().toString()), null, getSize(), getModificationTime(), getCreationTime(), 4, null);
        if (options != null && Intrinsics.areEqual((Object) options.getMd5(), (Object) true)) {
            fileInfo.setMd5(getMd5());
        }
        return fileInfo;
    }
}
