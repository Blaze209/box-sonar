package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzck {
    public static zzcy<zzch> zza(Context context) {
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        String str3 = Build.HARDWARE;
        if ((!str.equals("eng") && !str.equals("userdebug")) || ((!str3.equals("goldfish") && !str3.equals("ranchu") && !str3.equals("robolectric")) || (!str2.contains("dev-keys") && !str2.contains("test-keys")))) {
            return zzcy.zzc();
        }
        if (zzby.zza() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        zzcy<File> zzcyVarZzb = zzb(context);
        return zzcyVarZzb.zza() ? zzcy.zza(zza(zzcyVarZzb.zzb())) : zzcy.zzc();
    }

    private static zzcy<File> zzb(Context context) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            try {
                File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
                zzcy<File> zzcyVarZza = file.exists() ? zzcy.zza(file) : zzcy.zzc();
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return zzcyVarZza;
            } catch (RuntimeException e) {
                Log.e("HermeticFileOverrides", "no data dir", e);
                zzcy<File> zzcyVarZzc = zzcy.zzc();
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return zzcyVarZzc;
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    private static zzch zza(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                HashMap map = new HashMap();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        String[] strArrSplit = line.split(" ", 3);
                        if (strArrSplit.length != 3) {
                            String strValueOf = String.valueOf(line);
                            Log.e("HermeticFileOverrides", strValueOf.length() != 0 ? "Invalid: ".concat(strValueOf) : new String("Invalid: "));
                        } else {
                            String str = strArrSplit[0];
                            String strDecode = Uri.decode(strArrSplit[1]);
                            String strDecode2 = Uri.decode(strArrSplit[2]);
                            if (!map.containsKey(str)) {
                                map.put(str, new HashMap());
                            }
                            ((Map) map.get(str)).put(strDecode, strDecode2);
                        }
                    } else {
                        String strValueOf2 = String.valueOf(file);
                        Log.i("HermeticFileOverrides", new StringBuilder(String.valueOf(strValueOf2).length() + 7).append("Parsed ").append(strValueOf2).toString());
                        zzch zzchVar = new zzch(map);
                        bufferedReader.close();
                        return zzchVar;
                    }
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    zzdg.zza(th, th2);
                }
                throw th;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
