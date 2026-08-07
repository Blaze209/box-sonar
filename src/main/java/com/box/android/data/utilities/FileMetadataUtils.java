package com.box.android.data.utilities;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.exifinterface.media.ExifInterface;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.microsoft.intune.mam.client.media.MAMMediaMetadataRetriever;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FileMetadataUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001c\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J$\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/utilities/FileMetadataUtils;", "", "<init>", "()V", "extractAndFormat", "", "", "context", "Landroid/content/Context;", "uriOrPath", BoxCommonConstants.EXTRA_FILE_NAME, "extractImageMetadata", "file", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "buildImageMetadata", "exif", "Landroidx/exifinterface/media/ExifInterface;", "extractVideoMetadata", "buildVideoMetadata", "retriever", "Landroid/media/MediaMetadataRetriever;", "extractAudioMetadata", "buildAudioMetadata", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileMetadataUtils {
    public static final FileMetadataUtils INSTANCE = new FileMetadataUtils();

    private FileMetadataUtils() {
    }

    @JvmStatic
    public static final Map<String, String> extractAndFormat(Context context, String uriOrPath, String fileName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uriOrPath, "uriOrPath");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String fileExtension = CommonBoxUtil.getFileExtension(fileName, "");
        boolean zStartsWith$default = StringsKt.startsWith$default(uriOrPath, AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME, false, 2, (Object) null);
        if (SupportedFileExtensions.INSTANCE.isImageExtension(fileExtension)) {
            if (zStartsWith$default) {
                return INSTANCE.extractImageMetadata(context, Uri.parse(uriOrPath));
            }
            return INSTANCE.extractImageMetadata(new File(uriOrPath));
        }
        if (SupportedFileExtensions.INSTANCE.isVideoExtension(fileExtension)) {
            if (zStartsWith$default) {
                return INSTANCE.extractVideoMetadata(context, Uri.parse(uriOrPath));
            }
            return INSTANCE.extractVideoMetadata(new File(uriOrPath));
        }
        if (!SupportedFileExtensions.INSTANCE.isAudioExtension(fileExtension)) {
            return MapsKt.emptyMap();
        }
        if (zStartsWith$default) {
            return INSTANCE.extractAudioMetadata(context, Uri.parse(uriOrPath));
        }
        return INSTANCE.extractAudioMetadata(new File(uriOrPath));
    }

    private final Map<String, String> extractImageMetadata(File file) {
        try {
            if (file.exists() && file.canRead()) {
                return buildImageMetadata(new ExifInterface(file.getAbsolutePath()));
            }
            return MapsKt.emptyMap();
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "EXIF extraction failed", e);
            return MapsKt.emptyMap();
        }
    }

    private final Map<String, String> extractImageMetadata(Context context, Uri uri) {
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = MAMContentResolverManagement.openFileDescriptor(context.getContentResolver(), uri, "r");
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                ParcelFileDescriptor parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                try {
                    Map<String, String> mapBuildImageMetadata = INSTANCE.buildImageMetadata(new ExifInterface(parcelFileDescriptor.getFileDescriptor()));
                    CloseableKt.closeFinally(parcelFileDescriptor, null);
                    if (mapBuildImageMetadata != null) {
                        return mapBuildImageMetadata;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(parcelFileDescriptor, th);
                        throw th2;
                    }
                }
            }
            return MapsKt.emptyMap();
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "EXIF extraction failed", e);
            return MapsKt.emptyMap();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x0185  */
    private final Map<String, String> buildImageMetadata(ExifInterface exif) {
        String attribute;
        String exifGpsLocation;
        String str;
        String str2;
        String str3;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        String attribute2 = exif.getAttribute(ExifInterface.TAG_MAKE);
        String str4 = null;
        if (attribute2 != null) {
            if (StringsKt.isBlank(attribute2)) {
                attribute2 = null;
            }
            if (attribute2 != null) {
            }
        }
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.TAG_EXPOSURE_MODE, ExifInterface.TAG_EXPOSURE_PROGRAM, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_WHITE_BALANCE});
        ArrayList arrayList = new ArrayList();
        for (String str5 : listListOf) {
            String attribute3 = exif.getAttribute(str5);
            if (attribute3 == null) {
                str3 = null;
            } else {
                if (StringsKt.isBlank(attribute3)) {
                    attribute3 = null;
                }
                if (attribute3 != null) {
                    str3 = FileMetadataFormattingUtils.INSTANCE.formatExifTagLabel(str5) + " " + FileMetadataFormattingUtils.INSTANCE.formatExifTagValue(str5, attribute3);
                } else {
                    str3 = null;
                }
            }
            if (str3 != null) {
                arrayList.add(str3);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            arrayList2 = null;
        }
        String strJoinToString$default = arrayList2 != null ? CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null) : null;
        if (strJoinToString$default != null) {
        }
        String attribute4 = exif.getAttribute(ExifInterface.TAG_IMAGE_WIDTH);
        String attribute5 = exif.getAttribute(ExifInterface.TAG_IMAGE_LENGTH);
        if (attribute4 != null && attribute5 != null) {
            mapCreateMapBuilder.put("resolution", attribute4 + " x " + attribute5);
        }
        String attribute6 = exif.getAttribute(ExifInterface.TAG_FLASH);
        if (attribute6 != null) {
            Integer intOrNull = StringsKt.toIntOrNull(attribute6);
            if (intOrNull != null) {
                str2 = (intOrNull.intValue() & 1) != 0 ? "On" : "Off";
            } else {
                str2 = "Unknown";
            }
        }
        List<String> listListOf2 = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.TAG_LENS_MAKE, ExifInterface.TAG_LENS_MODEL, ExifInterface.TAG_FOCAL_LENGTH});
        ArrayList arrayList3 = new ArrayList();
        for (String str6 : listListOf2) {
            String attribute7 = exif.getAttribute(str6);
            if (attribute7 == null) {
                str = null;
            } else {
                if (StringsKt.isBlank(attribute7)) {
                    attribute7 = null;
                }
                if (attribute7 != null) {
                    str = FileMetadataFormattingUtils.INSTANCE.formatExifTagLabel(str6) + " " + FileMetadataFormattingUtils.INSTANCE.formatExifTagValue(str6, attribute7);
                } else {
                    str = null;
                }
            }
            if (str != null) {
                arrayList3.add(str);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            arrayList4 = null;
        }
        String strJoinToString$default2 = arrayList4 != null ? CollectionsKt.joinToString$default(arrayList4, ", ", null, null, 0, null, null, 62, null) : null;
        if (strJoinToString$default2 != null) {
        }
        String attribute8 = exif.getAttribute(ExifInterface.TAG_GPS_LATITUDE);
        if (attribute8 != null) {
            if (StringsKt.isBlank(attribute8)) {
                attribute8 = null;
            }
            if (attribute8 != null) {
                String attribute9 = exif.getAttribute(ExifInterface.TAG_GPS_LATITUDE_REF);
                if (attribute9 == null || StringsKt.isBlank(attribute9)) {
                    attribute9 = null;
                }
                String attribute10 = exif.getAttribute(ExifInterface.TAG_GPS_LONGITUDE);
                if (attribute10 == null || StringsKt.isBlank(attribute10)) {
                    attribute10 = null;
                }
                String attribute11 = exif.getAttribute(ExifInterface.TAG_GPS_LONGITUDE_REF);
                if (attribute11 == null || StringsKt.isBlank(attribute11)) {
                    attribute11 = null;
                }
                if (attribute9 != null && attribute10 != null && attribute11 != null && (exifGpsLocation = FileMetadataFormattingUtils.INSTANCE.formatExifGpsLocation(attribute8, attribute9, attribute10, attribute11)) != null) {
                }
            }
        }
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.TAG_DATETIME_ORIGINAL, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_DATETIME}).iterator();
        do {
            if (!it.hasNext()) {
                attribute = null;
                break;
            }
            attribute = exif.getAttribute((String) it.next());
            if (attribute == null || StringsKt.isBlank(attribute)) {
                attribute = null;
            }
        } while (attribute == null);
        if (attribute != null) {
            Iterator it2 = CollectionsKt.listOf((Object[]) new String[]{ExifInterface.TAG_OFFSET_TIME_ORIGINAL, ExifInterface.TAG_OFFSET_TIME_DIGITIZED, ExifInterface.TAG_OFFSET_TIME}).iterator();
            while (it2.hasNext()) {
                String attribute12 = exif.getAttribute((String) it2.next());
                if (attribute12 == null || StringsKt.isBlank(attribute12)) {
                    attribute12 = null;
                }
                if (attribute12 != null) {
                    str4 = attribute12;
                    break;
                }
            }
            String imageTimestamp = FileMetadataFormattingUtils.INSTANCE.formatImageTimestamp(attribute, str4);
            if (imageTimestamp != null) {
                mapCreateMapBuilder.put("captureTimestamp", imageTimestamp);
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    private final Map<String, String> extractVideoMetadata(File file) {
        try {
            if (file.exists() && file.canRead()) {
                MAMMediaMetadataRetriever mAMMediaMetadataRetriever = new MAMMediaMetadataRetriever();
                try {
                    MAMMediaMetadataRetriever mAMMediaMetadataRetriever2 = mAMMediaMetadataRetriever;
                    mAMMediaMetadataRetriever2.setDataSource(file.getAbsolutePath());
                    Map<String, String> mapBuildVideoMetadata = INSTANCE.buildVideoMetadata(mAMMediaMetadataRetriever2);
                    AutoCloseableKt.closeFinally(mAMMediaMetadataRetriever, null);
                    return mapBuildVideoMetadata;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(mAMMediaMetadataRetriever, th);
                        throw th2;
                    }
                }
            }
            return MapsKt.emptyMap();
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Video metadata extraction failed", e);
            return MapsKt.emptyMap();
        }
    }

    private final Map<String, String> extractVideoMetadata(Context context, Uri uri) {
        try {
            MAMMediaMetadataRetriever mAMMediaMetadataRetriever = new MAMMediaMetadataRetriever();
            try {
                MAMMediaMetadataRetriever mAMMediaMetadataRetriever2 = mAMMediaMetadataRetriever;
                mAMMediaMetadataRetriever2.setDataSource(context, uri);
                Map<String, String> mapBuildVideoMetadata = INSTANCE.buildVideoMetadata(mAMMediaMetadataRetriever2);
                AutoCloseableKt.closeFinally(mAMMediaMetadataRetriever, null);
                return mapBuildVideoMetadata;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(mAMMediaMetadataRetriever, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Video metadata extraction failed", e);
            return MapsKt.emptyMap();
        }
    }

    private final Map<String, String> buildVideoMetadata(MediaMetadataRetriever retriever) {
        String mediaTimestamp;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        String strExtractMetadata = retriever.extractMetadata(18);
        String strExtractMetadata2 = retriever.extractMetadata(19);
        if (strExtractMetadata != null && strExtractMetadata2 != null) {
            mapCreateMapBuilder.put("resolution", strExtractMetadata + " x " + strExtractMetadata2);
        }
        String strExtractMetadata3 = retriever.extractMetadata(23);
        if (strExtractMetadata3 != null) {
            if (StringsKt.isBlank(strExtractMetadata3)) {
                strExtractMetadata3 = null;
            }
            if (strExtractMetadata3 != null) {
                String iso6709LocationToHumanReadable = FileMetadataFormattingUtils.INSTANCE.formatIso6709LocationToHumanReadable(strExtractMetadata3);
                if (iso6709LocationToHumanReadable != null) {
                    strExtractMetadata3 = iso6709LocationToHumanReadable;
                }
                if (strExtractMetadata3 != null) {
                }
            }
        }
        String strExtractMetadata4 = retriever.extractMetadata(5);
        if (strExtractMetadata4 != null && (mediaTimestamp = FileMetadataFormattingUtils.INSTANCE.formatMediaTimestamp(strExtractMetadata4)) != null) {
            mapCreateMapBuilder.put("captureTimestamp", mediaTimestamp);
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    private final Map<String, String> extractAudioMetadata(File file) {
        try {
            if (file.exists() && file.canRead()) {
                MAMMediaMetadataRetriever mAMMediaMetadataRetriever = new MAMMediaMetadataRetriever();
                try {
                    MAMMediaMetadataRetriever mAMMediaMetadataRetriever2 = mAMMediaMetadataRetriever;
                    mAMMediaMetadataRetriever2.setDataSource(file.getAbsolutePath());
                    Map<String, String> mapBuildAudioMetadata = INSTANCE.buildAudioMetadata(mAMMediaMetadataRetriever2);
                    AutoCloseableKt.closeFinally(mAMMediaMetadataRetriever, null);
                    return mapBuildAudioMetadata;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        AutoCloseableKt.closeFinally(mAMMediaMetadataRetriever, th);
                        throw th2;
                    }
                }
            }
            return MapsKt.emptyMap();
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Audio metadata extraction failed", e);
            return MapsKt.emptyMap();
        }
    }

    private final Map<String, String> extractAudioMetadata(Context context, Uri uri) {
        try {
            MAMMediaMetadataRetriever mAMMediaMetadataRetriever = new MAMMediaMetadataRetriever();
            try {
                MAMMediaMetadataRetriever mAMMediaMetadataRetriever2 = mAMMediaMetadataRetriever;
                mAMMediaMetadataRetriever2.setDataSource(context, uri);
                Map<String, String> mapBuildAudioMetadata = INSTANCE.buildAudioMetadata(mAMMediaMetadataRetriever2);
                AutoCloseableKt.closeFinally(mAMMediaMetadataRetriever, null);
                return mapBuildAudioMetadata;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(mAMMediaMetadataRetriever, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Audio metadata extraction failed", e);
            return MapsKt.emptyMap();
        }
    }

    private final Map<String, String> buildAudioMetadata(MediaMetadataRetriever retriever) {
        String mediaTimestamp;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        String strExtractMetadata = retriever.extractMetadata(5);
        if (strExtractMetadata != null && (mediaTimestamp = FileMetadataFormattingUtils.INSTANCE.formatMediaTimestamp(strExtractMetadata)) != null) {
            mapCreateMapBuilder.put("captureTimestamp", mediaTimestamp);
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}
