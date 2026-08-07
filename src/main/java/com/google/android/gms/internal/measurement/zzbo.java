package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzbo {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
    public static final class zza extends zzfd<zza, C0205zza> implements zzgq {
        private static final zza zzh;
        private static volatile zzgx<zza> zzi;
        private int zzc;
        private String zzd = "";
        private boolean zze;
        private boolean zzf;
        private int zzg;

        private zza() {
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.measurement.zzbo$zza$zza, reason: collision with other inner class name */
        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
        public static final class C0205zza extends zzfd.zzb<zza, C0205zza> implements zzgq {
            private C0205zza() {
                super(zza.zzh);
            }

            public final String zza() {
                return ((zza) this.zza).zza();
            }

            public final C0205zza zza(String str) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final boolean zzb() {
                return ((zza) this.zza).zzb();
            }

            public final boolean zzc() {
                return ((zza) this.zza).zzc();
            }

            public final boolean zzd() {
                return ((zza) this.zza).zzd();
            }

            public final int zze() {
                return ((zza) this.zza).zze();
            }

            /* synthetic */ C0205zza(zzbq zzbqVar) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public final boolean zzb() {
            return this.zze;
        }

        public final boolean zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return (this.zzc & 8) != 0;
        }

        public final int zze() {
            return this.zzg;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgx zzaVar;
            int i2 = zzbq.zza[i - 1];
            zzbq zzbqVar = null;
            switch (i2) {
                case 1:
                    return new zza();
                case 2:
                    return new C0205zza(zzbqVar);
                case 3:
                    return zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0004\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgx<zza> zzgxVar = zzi;
                    if (zzgxVar != null) {
                        return zzgxVar;
                    }
                    synchronized (zza.class) {
                        zzaVar = zzi;
                        if (zzaVar == null) {
                            zzaVar = new zzfd.zza(zzh);
                            zzi = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zzaVar = new zza();
            zzh = zzaVar;
            zzfd.zza((Class<zza>) zza.class, zzaVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
    public static final class zzb extends zzfd<zzb, zza> implements zzgq {
        private static final zzb zzl;
        private static volatile zzgx<zzb> zzm;
        private int zzc;
        private long zzd;
        private int zzf;
        private boolean zzk;
        private String zze = "";
        private zzfl<zzc> zzg = zzbq();
        private zzfl<zza> zzh = zzbq();
        private zzfl<zzbj.zza> zzi = zzbq();
        private String zzj = "";

        private zzb() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
        public static final class zza extends zzfd.zzb<zzb, zza> implements zzgq {
            private zza() {
                super(zzb.zzl);
            }

            public final int zza() {
                return ((zzb) this.zza).zzf();
            }

            public final zza zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zza.C0205zza c0205zza) {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, (zza) ((zzfd) c0205zza.zzu()));
                return this;
            }

            public final List<zzbj.zza> zzb() {
                return Collections.unmodifiableList(((zzb) this.zza).zzg());
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzq();
                    this.zzb = false;
                }
                ((zzb) this.zza).zzl();
                return this;
            }

            /* synthetic */ zza(zzbq zzbqVar) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final List<zzc> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzh.size();
        }

        public final zza zza(int i) {
            return this.zzh.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i, zza zzaVar) {
            zzaVar.getClass();
            if (!this.zzh.zza()) {
                this.zzh = zzfd.zza(this.zzh);
            }
            this.zzh.set(i, zzaVar);
        }

        public final List<zzbj.zza> zzg() {
            return this.zzi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzl() {
            this.zzi = zzbq();
        }

        public final boolean zzh() {
            return this.zzk;
        }

        public static zza zzi() {
            return zzl.zzbk();
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgx zzaVar;
            int i2 = zzbq.zza[i - 1];
            zzbq zzbqVar = null;
            switch (i2) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(zzbqVar);
                case 3:
                    return zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\u0004\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007\b\u0003\b\u0007\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbj.zza.class, "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgx<zzb> zzgxVar = zzm;
                    if (zzgxVar != null) {
                        return zzgxVar;
                    }
                    synchronized (zzb.class) {
                        zzaVar = zzm;
                        if (zzaVar == null) {
                            zzaVar = new zzfd.zza(zzl);
                            zzm = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzb zzj() {
            return zzl;
        }

        static {
            zzb zzbVar = new zzb();
            zzl = zzbVar;
            zzfd.zza((Class<zzb>) zzb.class, zzbVar);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
    public static final class zzc extends zzfd<zzc, zza> implements zzgq {
        private static final zzc zzf;
        private static volatile zzgx<zzc> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private zzc() {
        }

        /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.3 */
        public static final class zza extends zzfd.zzb<zzc, zza> implements zzgq {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzbq zzbqVar) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        @Override // com.google.android.gms.internal.measurement.zzfd
        protected final Object zza(int i, Object obj, Object obj2) {
            zzgx zzaVar;
            int i2 = zzbq.zza[i - 1];
            zzbq zzbqVar = null;
            switch (i2) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(zzbqVar);
                case 3:
                    return zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgx<zzc> zzgxVar = zzg;
                    if (zzgxVar != null) {
                        return zzgxVar;
                    }
                    synchronized (zzc.class) {
                        zzaVar = zzg;
                        if (zzaVar == null) {
                            zzaVar = new zzfd.zza(zzf);
                            zzg = zzaVar;
                        }
                        break;
                    }
                    return zzaVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzf = zzcVar;
            zzfd.zza((Class<zzc>) zzc.class, zzcVar);
        }
    }
}
