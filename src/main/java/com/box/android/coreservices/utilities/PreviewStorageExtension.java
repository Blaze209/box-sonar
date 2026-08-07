package com.box.android.coreservices.utilities;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.coreservices.models.PreviewFileAttributes;
import com.box.android.domain.analytics.WopiPropertyBuilder;
import com.box.android.domain.models.RepresentationType;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.preview.PreviewContentType;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PreviewStorageExtension.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J(\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0012J,\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\f\u0010\u0018\u001a\u00020\u0005*\u00020\fH\u0002J\f\u0010\u0019\u001a\u00020\u0005*\u00020\fH\u0002J\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0005*\u00020\fH\u0002J\f\u0010\u001b\u001a\u00020\u0005*\u00020\u000eH\u0002J\u000e\u0010\u001c\u001a\u0004\u0018\u00010\u0005*\u00020\u000eH\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/box/android/coreservices/utilities/PreviewStorageExtension;", "", "<init>", "()V", "ORIGINAL", "", "REPRESENTATION", "FILE_NAME_SEPARATOR", "EXT_SEPARATOR", "DIMEN_DELIM", "getCacheName", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewContentType", "Lcom/box/android/domain/preview/PreviewContentType;", "tag", "previewFileExt", "directory", "Ljava/io/File;", "createCacheName", "extractPreviewFileAttributes", "Lcom/box/android/coreservices/models/PreviewFileAttributes;", "cachedFile", "findCacheName", "fileId", "sha1", "fileVersionId", "origin", TypedValues.Custom.S_DIMENSION, "fileModelExt", WopiPropertyBuilder.FILE_EXT_PROPERTY, "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewStorageExtension {
    private static final String DIMEN_DELIM = "x";
    private static final String EXT_SEPARATOR = ".";
    private static final String FILE_NAME_SEPARATOR = "_";
    public static final PreviewStorageExtension INSTANCE = new PreviewStorageExtension();
    private static final String ORIGINAL = "orig";
    private static final String REPRESENTATION = "rep";

    private PreviewStorageExtension() {
    }

    public final String getCacheName(FileModel fileModel, PreviewContentType previewContentType, String tag, String previewFileExt, File directory) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewFileExt, "previewFileExt");
        Intrinsics.checkNotNullParameter(directory, "directory");
        if (previewContentType == null) {
            return findCacheName(fileModel, tag, previewFileExt, directory);
        }
        return createCacheName(fileModel, previewContentType, tag, previewFileExt);
    }

    public final String createCacheName(FileModel fileModel, PreviewContentType previewContentType, String tag, String previewFileExt) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewContentType, "previewContentType");
        Intrinsics.checkNotNullParameter(previewFileExt, "previewFileExt");
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{fileId(fileModel), sha1(fileModel), fileVersionId(fileModel), origin(previewContentType), dimension(previewContentType), fileModelExt(fileModel, previewContentType), tag}), FILE_NAME_SEPARATOR, null, null, 0, null, null, 62, null) + EXT_SEPARATOR + fileExt(previewFileExt);
    }

    public final PreviewFileAttributes extractPreviewFileAttributes(File cachedFile) {
        PreviewContentType.Representation representationRepresentationWithExtension$default;
        PreviewContentType.Representation representationOriginal;
        Intrinsics.checkNotNullParameter(cachedFile, "cachedFile");
        String name = cachedFile.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        List listSplit$default = StringsKt.split$default((CharSequence) StringsKt.split$default((CharSequence) name, new String[]{EXT_SEPARATOR}, false, 0, 6, (Object) null).get(0), new String[]{FILE_NAME_SEPARATOR}, false, 0, 6, (Object) null);
        if (listSplit$default.size() < 5) {
            BoxLogUtils.e(com.box.android.domain.utils.ExtensionsKt.getTAG(this), "Unable to extract preview file attributes from legacy cached file: " + cachedFile.getName());
            return null;
        }
        String str = (String) listSplit$default.get(2);
        String str2 = (String) listSplit$default.get(3);
        if (Intrinsics.areEqual(str2, ORIGINAL)) {
            representationOriginal = PreviewOrigin.INSTANCE.original();
        } else if (Intrinsics.areEqual(str2, REPRESENTATION)) {
            if (StringsKt.contains$default((CharSequence) listSplit$default.get(4), (CharSequence) "x", false, 2, (Object) null)) {
                representationRepresentationWithExtension$default = PreviewOrigin.INSTANCE.representationWithExtension((String) listSplit$default.get(5), StringsKt.toIntOrNull((String) StringsKt.split$default((CharSequence) listSplit$default.get(4), new String[]{"x"}, false, 0, 6, (Object) null).get(0)));
            } else {
                representationRepresentationWithExtension$default = PreviewOrigin.representationWithExtension$default(PreviewOrigin.INSTANCE, (String) listSplit$default.get(4), null, 2, null);
            }
            representationOriginal = representationRepresentationWithExtension$default;
        } else {
            BoxLogUtils.e(com.box.android.domain.utils.ExtensionsKt.getTAG(str2), "Unrecognized preview content type: " + str2);
            return null;
        }
        return new PreviewFileAttributes(representationOriginal, str);
    }

    public final String findCacheName(FileModel fileModel, String tag, String previewFileExt, File directory) {
        File file;
        Object next;
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(previewFileExt, "previewFileExt");
        Intrinsics.checkNotNullParameter(directory, "directory");
        String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{fileId(fileModel), sha1(fileModel)}), FILE_NAME_SEPARATOR, null, null, 0, null, null, 62, null);
        String str = tag != null ? FILE_NAME_SEPARATOR + tag + EXT_SEPARATOR + fileExt(previewFileExt) : EXT_SEPARATOR + fileExt(previewFileExt);
        File[] fileArrListFiles = directory.listFiles();
        if (fileArrListFiles != null) {
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (StringsKt.startsWith$default(name, strJoinToString$default + FILE_NAME_SEPARATOR, false, 2, (Object) null)) {
                    String name2 = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    if (StringsKt.endsWith$default(name2, str, false, 2, (Object) null)) {
                        arrayList.add(file2);
                    }
                }
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    long jLastModified = ((File) next).lastModified();
                    do {
                        Object next2 = it.next();
                        long jLastModified2 = ((File) next2).lastModified();
                        if (jLastModified < jLastModified2) {
                            next = next2;
                            jLastModified = jLastModified2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            file = (File) next;
        } else {
            file = null;
        }
        if (file != null) {
            return file.getName();
        }
        return null;
    }

    private final String fileId(FileModel fileModel) {
        String strBoxIdOrNull = fileModel.boxIdOrNull();
        if (strBoxIdOrNull == null) {
            strBoxIdOrNull = "";
        }
        String str = strBoxIdOrNull;
        if (str.length() != 0) {
            return str;
        }
        throw new IllegalArgumentException("FileModel must contain an id");
    }

    private final String sha1(FileModel fileModel) {
        String sha1 = fileModel.getSha1();
        if (sha1.length() != 0) {
            return sha1;
        }
        throw new IllegalArgumentException("FileModel must contain a non-null sha1");
    }

    private final String fileVersionId(FileModel fileModel) {
        FileVersionMiniModel fileVersion = fileModel.getFileVersion();
        if (fileVersion != null) {
            return fileVersion.getId();
        }
        return null;
    }

    private final String origin(PreviewContentType previewContentType) {
        if (previewContentType instanceof PreviewContentType.Original) {
            return ORIGINAL;
        }
        if (previewContentType instanceof PreviewContentType.Representation) {
            return REPRESENTATION;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String dimension(PreviewContentType previewContentType) {
        if (previewContentType instanceof PreviewContentType.Representation) {
            return ((PreviewContentType.Representation) previewContentType).getModel().getProperties().getDimensions();
        }
        return null;
    }

    private final String fileModelExt(FileModel fileModel, PreviewContentType previewContentType) {
        if (previewContentType instanceof PreviewContentType.Original) {
            String extension = fileModel.getExtension();
            return extension.length() != 0 ? extension : null;
        }
        if (!(previewContentType instanceof PreviewContentType.Representation)) {
            throw new NoWhenBranchMatchedException();
        }
        String boxRepType = RepresentationType.INSTANCE.toBoxRepType(((PreviewContentType.Representation) previewContentType).getModel().getRepresentationType());
        return boxRepType.length() != 0 ? boxRepType : null;
    }

    private final String fileExt(String previewFileExt) {
        if (previewFileExt.length() == 0) {
            throw new IllegalArgumentException("A non-empty preview file extension must be provided");
        }
        if (!StringsKt.startsWith$default(previewFileExt, EXT_SEPARATOR, false, 2, (Object) null)) {
            return previewFileExt;
        }
        String strSubstring = previewFileExt.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }
}
