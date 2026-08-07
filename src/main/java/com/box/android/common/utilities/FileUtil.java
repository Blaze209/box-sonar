package com.box.android.common.utilities;

import android.content.Context;
import android.net.Uri;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes10.dex */
public final class FileUtil {
    private static final String PRIMARY_VOLUME_NAME = "primary";

    public static String getFullPathFromTreeUri(Uri uri, Context context) {
        String volumePath;
        if (uri == null || (volumePath = getVolumePath(getVolumeIdFromTreeUri(uri), context)) == null) {
            return null;
        }
        if (volumePath.endsWith(File.separator)) {
            volumePath = volumePath.substring(0, volumePath.length() - 1);
        }
        String documentPathFromTreeUri = getDocumentPathFromTreeUri(uri);
        if (documentPathFromTreeUri.endsWith(File.separator)) {
            documentPathFromTreeUri = documentPathFromTreeUri.substring(0, documentPathFromTreeUri.length() - 1);
        }
        if (documentPathFromTreeUri.length() <= 0) {
            return volumePath;
        }
        if (documentPathFromTreeUri.startsWith(File.separator)) {
            return volumePath + documentPathFromTreeUri;
        }
        return volumePath + File.separator + documentPathFromTreeUri;
    }

    private static String getVolumePath(String str, Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getUuid", new Class[0]);
            Method method3 = cls.getMethod("getPath", new Class[0]);
            Method method4 = cls.getMethod("isPrimary", new Class[0]);
            Object objInvoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(objInvoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(objInvoke, i);
                String str2 = (String) method2.invoke(obj, new Object[0]);
                if (((Boolean) method4.invoke(obj, new Object[0])).booleanValue() && PRIMARY_VOLUME_NAME.equals(str)) {
                    return (String) method3.invoke(obj, new Object[0]);
                }
                if (str2 != null && str2.equals(str)) {
                    return (String) method3.invoke(obj, new Object[0]);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String getVolumeIdFromTreeUri(Uri uri) {
        try {
            String[] strArrSplit = DocumentsContract.getTreeDocumentId(uri).split(":");
            if (strArrSplit.length > 0) {
                return strArrSplit[0];
            }
        } catch (IllegalArgumentException unused) {
        }
        return null;
    }

    private static String getDocumentPathFromTreeUri(Uri uri) {
        String str;
        String[] strArrSplit = DocumentsContract.getTreeDocumentId(uri).split(":");
        return (strArrSplit.length < 2 || (str = strArrSplit[1]) == null) ? File.separator : str;
    }

    public static boolean isTreeUri(Uri uri) {
        return DocumentsContract.isTreeUri(uri);
    }

    public static Uri formatTreeUriForFolder(Uri uri, Context context) {
        return (!isTreeUri(uri) || DocumentsContract.isDocumentUri(context, uri)) ? uri : DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
    }

    public static File createFileWithUri(String str) {
        return new File(str);
    }

    public static void deleteFilesRecursively(File file) {
        File[] fileArrListFiles;
        if (file != null) {
            if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    deleteFilesRecursively(file2);
                }
            }
            file.delete();
        }
    }
}
