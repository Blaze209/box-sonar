package expo.modules.filesystem;

import android.content.Context;
import android.net.Uri;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.filesystem.unifiedfile.AssetFile;
import expo.modules.filesystem.unifiedfile.JavaFile;
import expo.modules.filesystem.unifiedfile.SAFDocumentFile;
import expo.modules.filesystem.unifiedfile.UnifiedFileInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.services.FilePermissionService;
import expo.modules.kotlin.sharedobjects.SharedObject;
import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileSystemPath.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H&J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0000J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0000J\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010%\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b*\u0010(¨\u0006+"}, d2 = {"Lexpo/modules/filesystem/FileSystemPath;", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", "uri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "setUri", "fileAdapter", "Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "file", "getFile", "()Lexpo/modules/filesystem/unifiedfile/UnifiedFileInterface;", "javaFile", "Ljava/io/File;", "getJavaFile", "()Ljava/io/File;", "delete", "", "validateType", "getMoveOrCopyPath", FirebaseAnalytics.Param.DESTINATION, "validatePermission", "permission", "Lexpo/modules/kotlin/services/FilePermissionService$Permission;", "checkPermission", "", "validateCanCreate", "options", "Lexpo/modules/filesystem/CreateOptions;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, TypedValues.TransitionType.S_TO, BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_MOVE_JOB, "rename", "newName", "", "modificationTime", "", "getModificationTime", "()Ljava/lang/Long;", "creationTime", "getCreationTime", "expo-file-system_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class FileSystemPath extends SharedObject {
    private UnifiedFileInterface fileAdapter;
    private Uri uri;

    public abstract void validateType();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FileSystemPath(Uri uri) {
        super(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final void setUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<set-?>");
        this.uri = uri;
    }

    public final UnifiedFileInterface getFile() throws Exception {
        JavaFile javaFile;
        Context reactContext;
        Context reactContext2;
        UnifiedFileInterface unifiedFileInterface = this.fileAdapter;
        if (Intrinsics.areEqual(unifiedFileInterface != null ? unifiedFileInterface.getUri() : null, this.uri)) {
            return unifiedFileInterface;
        }
        if (FileSystemPathKt.isContentUri(this.uri)) {
            AppContext appContext = getAppContext();
            if (appContext == null || (reactContext2 = appContext.getReactContext()) == null) {
                throw new Exception("No context");
            }
            javaFile = new SAFDocumentFile(reactContext2, this.uri);
        } else if (FileSystemPathKt.isAssetUri(this.uri)) {
            AppContext appContext2 = getAppContext();
            if (appContext2 == null || (reactContext = appContext2.getReactContext()) == null) {
                throw new Exception("No context");
            }
            javaFile = new AssetFile(reactContext, this.uri);
        } else {
            javaFile = new JavaFile(this.uri);
        }
        this.fileAdapter = javaFile;
        return javaFile;
    }

    public final File getJavaFile() throws Exception {
        if (FileSystemPathKt.isContentUri(this.uri)) {
            throw new Exception("This method cannot be used with content URIs: " + this.uri);
        }
        Object file = getFile();
        Intrinsics.checkNotNull(file, "null cannot be cast to non-null type java.io.File");
        return (File) file;
    }

    public final void delete() throws UnableToDeleteException {
        if (!getFile().exists()) {
            throw new UnableToDeleteException("uri '" + getFile().getUri() + "' does not exist");
        }
        if (getFile().isDirectory()) {
            if (getFile().deleteRecursively()) {
                return;
            }
            throw new UnableToDeleteException("failed to delete '" + getFile().getUri() + "'");
        }
        if (getFile().delete()) {
            return;
        }
        throw new UnableToDeleteException("failed to delete '" + getFile().getUri() + "'");
    }

    public final File getMoveOrCopyPath(FileSystemPath destination) throws CopyOrMoveDirectoryToFileException, DestinationDoesNotExistException {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination instanceof FileSystemDirectory) {
            if (this instanceof FileSystemFile) {
                if (!((FileSystemDirectory) destination).getExists()) {
                    throw new DestinationDoesNotExistException();
                }
                return new File(destination.getJavaFile(), getJavaFile().getName());
            }
            if (((FileSystemDirectory) destination).getExists()) {
                return new File(destination.getJavaFile(), getJavaFile().getName());
            }
            File parentFile = destination.getJavaFile().getParentFile();
            if (parentFile == null || !parentFile.exists()) {
                throw new DestinationDoesNotExistException();
            }
            return destination.getJavaFile();
        }
        if (!(this instanceof FileSystemFile)) {
            throw new CopyOrMoveDirectoryToFileException();
        }
        File parentFile2 = destination.getJavaFile().getParentFile();
        if (parentFile2 == null || !parentFile2.exists()) {
            throw new DestinationDoesNotExistException();
        }
        return destination.getJavaFile();
    }

    public final void validatePermission(FilePermissionService.Permission permission) throws InvalidPermissionException {
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (!checkPermission(permission)) {
            throw new InvalidPermissionException(permission);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004a  */
    public final boolean checkPermission(FilePermissionService.Permission permission) throws Exceptions.ReactContextLost {
        EnumSet<FilePermissionService.Permission> enumSetNoneOf;
        FilePermissionService filePermission;
        Context reactContext;
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (FileSystemPathKt.isContentUri(this.uri) || FileSystemPathKt.isAssetUri(this.uri)) {
            return true;
        }
        AppContext appContext = getAppContext();
        if (appContext != null && (filePermission = appContext.getFilePermission()) != null) {
            AppContext appContext2 = getAppContext();
            if (appContext2 != null && (reactContext = appContext2.getReactContext()) != null) {
                String path = getJavaFile().getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                enumSetNoneOf = filePermission.getPathPermissions(reactContext, path);
                if (enumSetNoneOf == null) {
                    enumSetNoneOf = EnumSet.noneOf(FilePermissionService.Permission.class);
                }
            } else {
                throw new Exceptions.ReactContextLost();
            }
        } else {
            enumSetNoneOf = EnumSet.noneOf(FilePermissionService.Permission.class);
        }
        return enumSetNoneOf.contains(permission);
    }

    public final void validateCanCreate(CreateOptions options) throws UnableToCreateException {
        Intrinsics.checkNotNullParameter(options, "options");
        if (!options.getOverwrite() && getFile().exists()) {
            throw new UnableToCreateException("it already exists");
        }
    }

    public final void copy(FileSystemPath to) throws InvalidPermissionException {
        Intrinsics.checkNotNullParameter(to, "to");
        validateType();
        to.validateType();
        validatePermission(FilePermissionService.Permission.READ);
        to.validatePermission(FilePermissionService.Permission.WRITE);
        FilesKt.copyRecursively$default(getJavaFile(), getMoveOrCopyPath(to), false, null, 6, null);
    }

    public final void move(FileSystemPath to) throws CopyOrMoveDirectoryToFileException, DestinationDoesNotExistException, InvalidPermissionException {
        Intrinsics.checkNotNullParameter(to, "to");
        validateType();
        to.validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        to.validatePermission(FilePermissionService.Permission.WRITE);
        File moveOrCopyPath = getMoveOrCopyPath(to);
        Path path = getJavaFile().toPath();
        Intrinsics.checkNotNullExpressionValue(path, "toPath(...)");
        Path path2 = moveOrCopyPath.toPath();
        Intrinsics.checkNotNullExpressionValue(path2, "toPath(...)");
        Intrinsics.checkNotNullExpressionValue(Files.move(path, path2, (CopyOption[]) Arrays.copyOf(new CopyOption[0], 0)), "move(...)");
        this.uri = Uri.fromFile(moveOrCopyPath);
    }

    public final void rename(String newName) throws InvalidPermissionException {
        Intrinsics.checkNotNullParameter(newName, "newName");
        validateType();
        validatePermission(FilePermissionService.Permission.WRITE);
        File file = new File(getJavaFile().getParent(), newName);
        Path path = getJavaFile().toPath();
        Intrinsics.checkNotNullExpressionValue(path, "toPath(...)");
        Path path2 = file.toPath();
        Intrinsics.checkNotNullExpressionValue(path2, "toPath(...)");
        Intrinsics.checkNotNullExpressionValue(Files.move(path, path2, (CopyOption[]) Arrays.copyOf(new CopyOption[0], 0)), "move(...)");
        this.uri = Uri.fromFile(file);
    }

    public final Long getModificationTime() {
        validateType();
        return getFile().lastModified();
    }

    public final Long getCreationTime() {
        return getFile().getCreationTime();
    }
}
