package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public abstract class zzdu implements Serializable, Iterable<Byte> {
    public static final zzdu zza = new zzee(zzff.zzb);
    private static final zzea zzb;
    private static final Comparator<zzdu> zzd;
    private int zzc = 0;

    zzdu() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzb(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract int zza();

    protected abstract int zza(int i, int i2, int i3);

    public abstract zzdu zza(int i, int i2);

    protected abstract String zza(Charset charset);

    abstract void zza(zzdv zzdvVar) throws IOException;

    abstract byte zzb(int i);

    public abstract boolean zzc();

    public static zzdu zza(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzee(zzb.zza(bArr, i, i2));
    }

    static zzdu zza(byte[] bArr) {
        return new zzee(bArr);
    }

    public static zzdu zza(String str) {
        return new zzee(str.getBytes(zzff.zza));
    }

    public final String zzb() {
        return zza() == 0 ? "" : zza(zzff.zza);
    }

    public final int hashCode() {
        int iZza = this.zzc;
        if (iZza == 0) {
            int iZza2 = zza();
            iZza = zza(iZza2, 0, iZza2);
            if (iZza == 0) {
                iZza = 1;
            }
            this.zzc = iZza;
        }
        return iZza;
    }

    static zzec zzc(int i) {
        return new zzec(i, null);
    }

    protected final int zzd() {
        return this.zzc;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(i).append(" < 0").toString());
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(i).append(", ").append(i2).toString());
        }
        throw new IndexOutOfBoundsException(new StringBuilder(37).append("End index: ").append(i2).append(" >= ").append(i3).toString());
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(zza()), zza() <= 50 ? zzhr.zza(this) : String.valueOf(zzhr.zza(zza(0, 47))).concat("..."));
    }

    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzdx(this);
    }

    static {
        zzdx zzdxVar = null;
        zzb = zzdr.zza() ? new zzeh(zzdxVar) : new zzdy(zzdxVar);
        zzd = new zzdw();
    }
}
