package com.google.mlkit.common.internal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzh;
import com.google.android.gms.internal.mlkit_common.zzi;
import com.google.android.gms.internal.mlkit_common.zzu;
import com.google.mlkit.common.model.LocalModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.11.0 */
/* JADX INFO: loaded from: classes14.dex */
public class ModelUtils {
    private static final GmsLogger zza = new GmsLogger("ModelUtils", "");

    /* JADX INFO: compiled from: com.google.mlkit:common@@18.11.0 */
    public static abstract class AutoMLManifest {
        public abstract String getLabelsFile();

        public abstract String getModelFile();

        public abstract String getModelType();
    }

    /* JADX INFO: compiled from: com.google.mlkit:common@@18.11.0 */
    public static abstract class ModelLoggingInfo {
        static ModelLoggingInfo zza(long j, String str, boolean z) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j, zzu.zzb(str), z);
        }

        public abstract String getHash();

        public abstract long getSize();

        public abstract boolean isManifestModel();
    }

    private ModelUtils() {
    }

    /* JADX WARN: Code duplicated, block: B:104:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2 */
    public static ModelLoggingInfo getModelLoggingInfo(Context context, LocalModel localModel) throws Throwable {
        long length;
        String string;
        Throwable th;
        IOException e;
        InputStream inputStreamZzb;
        String strZzc;
        String assetFilePath = localModel.getAssetFilePath();
        String absoluteFilePath = localModel.getAbsoluteFilePath();
        Uri uri = localModel.getUri();
        ?? r5 = 0;
        if (assetFilePath != null) {
            if (localModel.isManifestFile() && (assetFilePath = zzb(context, assetFilePath, true)) == null) {
                return null;
            }
            try {
                AssetFileDescriptor assetFileDescriptorOpenFd = context.getAssets().openFd(assetFilePath);
                try {
                    length = assetFileDescriptorOpenFd.getLength();
                    if (assetFileDescriptorOpenFd != null) {
                        assetFileDescriptorOpenFd.close();
                    }
                } catch (Throwable th2) {
                    if (assetFileDescriptorOpenFd != null) {
                        try {
                            assetFileDescriptorOpenFd.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (IOException e2) {
                zza.e("ModelUtils", "Failed to open model file", e2);
                return null;
            }
        } else if (absoluteFilePath != null) {
            if (localModel.isManifestFile() && (absoluteFilePath = zzb(context, absoluteFilePath, false)) == null) {
                return null;
            }
            length = new File(absoluteFilePath).length();
        } else {
            if (uri == null) {
                zza.e("ModelUtils", "Local model doesn't have any valid path.");
                return null;
            }
            try {
                AssetFileDescriptor assetFileDescriptorZza = zzi.zza(context, uri, "r");
                try {
                    length = assetFileDescriptorZza.getLength();
                    if (assetFileDescriptorZza != null) {
                        assetFileDescriptorZza.close();
                    }
                } catch (Throwable th4) {
                    if (assetFileDescriptorZza != null) {
                        try {
                            assetFileDescriptorZza.close();
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                        }
                    }
                    throw th4;
                }
            } catch (IOException e3) {
                zza.e("ModelUtils", "Failed to open model file", e3);
                return null;
            }
        }
        SharedPrefManager sharedPrefManager = (SharedPrefManager) MlKitContext.getInstance().get(SharedPrefManager.class);
        if (assetFilePath != null) {
            string = assetFilePath;
        } else {
            string = absoluteFilePath != null ? absoluteFilePath : ((Uri) Preconditions.checkNotNull(uri)).toString();
        }
        String strZzb = sharedPrefManager.zzb(string, length);
        if (strZzb != null) {
            return ModelLoggingInfo.zza(length, strZzb, localModel.isManifestFile());
        }
        try {
            try {
                if (assetFilePath != null) {
                    inputStreamZzb = context.getAssets().open(assetFilePath);
                } else if (absoluteFilePath != null) {
                    inputStreamZzb = new FileInputStream(new File(absoluteFilePath));
                } else {
                    Uri uri2 = (Uri) Preconditions.checkNotNull(uri);
                    int i = zzi.zza;
                    inputStreamZzb = zzi.zzb(context, uri2, zzh.zza);
                }
                if (inputStreamZzb != null) {
                    try {
                        strZzc = zzc(inputStreamZzb);
                    } catch (IOException e4) {
                        e = e4;
                        zza.e("ModelUtils", "Failed to open model file", e);
                        if (inputStreamZzb != null) {
                            try {
                                inputStreamZzb.close();
                            } catch (IOException e5) {
                                zza.e("ModelUtils", "Failed to close model file", e5);
                            }
                        }
                        return null;
                    }
                } else {
                    strZzc = null;
                }
                if (strZzc != null) {
                    sharedPrefManager.zzc(string, length, strZzc);
                }
                ModelLoggingInfo modelLoggingInfoZza = ModelLoggingInfo.zza(length, strZzc, localModel.isManifestFile());
                if (inputStreamZzb != null) {
                    try {
                        inputStreamZzb.close();
                        return modelLoggingInfoZza;
                    } catch (IOException e6) {
                        zza.e("ModelUtils", "Failed to close model file", e6);
                    }
                }
                return modelLoggingInfoZza;
            } catch (Throwable th6) {
                th = th6;
                r5 = context;
                if (r5 != 0) {
                    try {
                        r5.close();
                    } catch (IOException e7) {
                        zza.e("ModelUtils", "Failed to close model file", e7);
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            inputStreamZzb = null;
        } catch (Throwable th7) {
            th = th7;
            if (r5 != 0) {
                r5.close();
            }
            throw th;
        }
    }

    public static String getSHA256(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String strZzc = zzc(fileInputStream);
                fileInputStream.close();
                return strZzc;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            zza.e("ModelUtils", "Failed to create FileInputStream for model: ".concat(e.toString()));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        if (new java.io.File(r6).exists() == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest parseManifestFile(java.lang.String r6, boolean r7, android.content.Context r8) {
        /*
            java.lang.String r0 = "Json string from the manifest file: "
            java.lang.String r1 = java.lang.String.valueOf(r6)
            com.google.android.gms.common.internal.GmsLogger r2 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r3 = "Manifest file path: "
            java.lang.String r1 = r3.concat(r1)
            java.lang.String r3 = "ModelUtils"
            r2.d(r3, r1)
            r1 = 0
            if (r7 == 0) goto L24
            android.content.res.AssetManager r4 = r8.getAssets()     // Catch: java.io.IOException -> L2f
            java.io.InputStream r4 = r4.open(r6)     // Catch: java.io.IOException -> L2f
            if (r4 == 0) goto L37
            r4.close()     // Catch: java.io.IOException -> L2f
            goto L37
        L24:
            java.io.File r4 = new java.io.File
            r4.<init>(r6)
            boolean r4 = r4.exists()
            if (r4 != 0) goto L37
        L2f:
            com.google.android.gms.common.internal.GmsLogger r6 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r7 = "Manifest file does not exist."
            r6.e(r3, r7)
            return r1
        L37:
            boolean r4 = r6.isEmpty()     // Catch: java.lang.Throwable -> L9d
            r5 = 0
            if (r4 == 0) goto L41
            byte[] r6 = new byte[r5]     // Catch: java.lang.Throwable -> L9d
            goto L66
        L41:
            if (r7 == 0) goto L4c
            android.content.res.AssetManager r7 = r8.getAssets()     // Catch: java.lang.Throwable -> L9d
            java.io.InputStream r6 = r7.open(r6)     // Catch: java.lang.Throwable -> L9d
            goto L57
        L4c:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L9d
            java.io.File r8 = new java.io.File     // Catch: java.lang.Throwable -> L9d
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L9d
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L9d
            r6 = r7
        L57:
            int r7 = r6.available()     // Catch: java.lang.Throwable -> L91
            byte[] r8 = new byte[r7]     // Catch: java.lang.Throwable -> L91
            r6.read(r8, r5, r7)     // Catch: java.lang.Throwable -> L91
            if (r6 == 0) goto L65
            r6.close()     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
        L65:
            r6 = r8
        L66:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            java.lang.String r8 = "UTF-8"
            r7.<init>(r6, r8)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            java.lang.String r6 = r0.concat(r7)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            r2.d(r3, r6)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            java.lang.String r7 = "modelType"
            java.lang.String r7 = r6.getString(r7)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            java.lang.String r8 = "modelFile"
            java.lang.String r8 = r6.getString(r8)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            java.lang.String r0 = "labelsFile"
            java.lang.String r6 = r6.getString(r0)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest r0 = new com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            r0.<init>(r7, r8, r6)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
            return r0
        L91:
            r7 = move-exception
            if (r6 == 0) goto L9c
            r6.close()     // Catch: java.lang.Throwable -> L98
            goto L9c
        L98:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
        L9c:
            throw r7     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9d
        L9d:
            r6 = move-exception
            com.google.android.gms.common.internal.GmsLogger r7 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r8 = "Error parsing the manifest file."
            r7.e(r3, r8, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.parseManifestFile(java.lang.String, boolean, android.content.Context):com.google.mlkit.common.internal.model.ModelUtils$AutoMLManifest");
    }

    public static boolean zza(File file, String str) {
        String sha256 = getSHA256(file);
        zza.d("ModelUtils", "Calculated hash value is: ".concat(String.valueOf(sha256)));
        return str.equals(sha256);
    }

    private static String zzb(Context context, String str, boolean z) {
        AutoMLManifest manifestFile = parseManifestFile(str, z, context);
        if (manifestFile != null) {
            return new File(new File(str).getParent(), manifestFile.getModelFile()).toString();
        }
        zza.e("ModelUtils", "Failed to parse manifest file.");
        return null;
    }

    private static String zzc(InputStream inputStream) {
        int i;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            zza.e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            zza.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }
}
