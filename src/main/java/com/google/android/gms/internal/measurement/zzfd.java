package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfd.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public abstract class zzfd<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdl<MessageType, BuilderType> {
    private static Map<Object, zzfd<?, ?>> zzd = new ConcurrentHashMap();
    protected zzhy zzb = zzhy.zza();
    private int zzc = -1;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    public static class zza<T extends zzfd<T, ?>> extends zzdp<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    static final class zzc implements zzey<zzc> {
        @Override // com.google.android.gms.internal.measurement.zzey
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzim zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzip zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzgn zza(zzgn zzgnVar, zzgo zzgoVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzey
        public final zzgt zza(zzgt zzgtVar, zzgt zzgtVar2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    public static final enum zze {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzl = {1, 2, 3, 4, 5, 6, 7};
        public static final int zzh = 1;
        public static final int zzi = 2;
        private static final /* synthetic */ int[] zzm = {1, 2};
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzn = {1, 2};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    public static class zzf<ContainingType extends zzgo, Type> extends zzer<ContainingType, Type> {
    }

    protected abstract Object zza(int i, Object obj, Object obj2);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzfd<MessageType, BuilderType> implements zzgq {
        protected zzew<zzc> zzc = zzew.zza();

        final zzew<zzc> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzew) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        return zzgp.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzgz.zza().zza(this).zza(this);
        return this.zza;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
    public static abstract class zzb<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdn<MessageType, BuilderType> {
        protected MessageType zza;
        protected boolean zzb = false;
        private final MessageType zzc;

        protected zzb(MessageType messagetype) {
            this.zzc = messagetype;
            this.zza = (MessageType) messagetype.zza(zze.zzd, null, null);
        }

        protected void zzq() {
            MessageType messagetype = (MessageType) this.zza.zza(zze.zzd, null, null);
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.measurement.zzgq
        public final boolean zzbl() {
            return zzfd.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzgn
        /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public MessageType zzt() {
            if (this.zzb) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzgz.zza().zza(messagetype).zzc(messagetype);
            this.zzb = true;
            return this.zza;
        }

        @Override // com.google.android.gms.internal.measurement.zzgn
        /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public final MessageType zzu() {
            MessageType messagetype = (MessageType) zzt();
            if (messagetype.zzbl()) {
                return messagetype;
            }
            throw new zzhw(messagetype);
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgz.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzeq zzeqVar) throws zzfo {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzgz.zza().zza(this.zza).zza(this.zza, bArr, 0, i2, new zzdt(zzeqVar));
                return this;
            } catch (zzfo e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzfo.zza();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.measurement.zzdn
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public final BuilderType zza(zzeg zzegVar, zzeq zzeqVar) throws IOException {
            if (this.zzb) {
                zzq();
                this.zzb = false;
            }
            try {
                zzgz.zza().zza(this.zza).zza(this.zza, zzel.zza(zzegVar), zzeqVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        public final /* synthetic */ zzdn zza(byte[] bArr, int i, int i2, zzeq zzeqVar) throws zzfo {
            return zzb(bArr, 0, i2, zzeqVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        public final /* synthetic */ zzdn zza(byte[] bArr, int i, int i2) throws zzfo {
            return zzb(bArr, 0, i2, zzeq.zza());
        }

        @Override // com.google.android.gms.internal.measurement.zzdn
        /* JADX INFO: renamed from: zzp */
        public final /* synthetic */ zzdn clone() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzgq
        public final /* synthetic */ zzgo zzbt() {
            return this.zzc;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzdn
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzc.zza(zze.zze, null, null);
            zzbVar.zza((zzfd) zzt());
            return zzbVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzgz.zza().zza(this).zza(this, (zzfd) obj);
        }
        return false;
    }

    protected final <MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbk() {
        return (BuilderType) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final boolean zzbl() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbm() {
        BuilderType buildertype = (BuilderType) zza(zze.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    final int zzbj() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzdl
    final void zzc(int i) {
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final void zza(zzen zzenVar) throws IOException {
        zzgz.zza().zza(this).zza(this, zzep.zza(zzenVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final int zzbn() {
        if (this.zzc == -1) {
            this.zzc = zzgz.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzfd<?, ?>> T zza(Class<T> cls) {
        T t = (T) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        T t2 = (T) ((zzfd) zzib.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
        if (t2 == null) {
            throw new IllegalStateException();
        }
        zzd.put(cls, t2);
        return t2;
    }

    protected static <T extends zzfd<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzgo zzgoVar, String str, Object[] objArr) {
        return new zzhb(zzgoVar, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends zzfd<T, ?>> boolean zza(T t, boolean z) {
        byte bByteValue = ((Byte) t.zza(zze.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzd = zzgz.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zze.zzb, zZzd ? t : null, null);
        }
        return zZzd;
    }

    protected static zzfj zzbo() {
        return zzfg.zzd();
    }

    protected static zzfm zzbp() {
        return zzgc.zzd();
    }

    protected static zzfm zza(zzfm zzfmVar) {
        int size = zzfmVar.size();
        return zzfmVar.zza(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzfl<E> zzbq() {
        return zzhc.zzd();
    }

    protected static <E> zzfl<E> zza(zzfl<E> zzflVar) {
        int size = zzflVar.size();
        return zzflVar.zza(size == 0 ? 10 : size << 1);
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final /* synthetic */ zzgn zzbr() {
        zzb zzbVar = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzbVar.zza(this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final /* synthetic */ zzgn zzbs() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    public final /* synthetic */ zzgo zzbt() {
        return (zzfd) zza(zze.zzf, (Object) null, (Object) null);
    }
}
