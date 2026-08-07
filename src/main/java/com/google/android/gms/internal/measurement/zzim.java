package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzi' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.3 */
/* JADX INFO: loaded from: classes13.dex */
public class zzim {
    public static final zzim zza;
    public static final zzim zzb;
    public static final zzim zzc;
    public static final zzim zzd;
    public static final zzim zze;
    public static final zzim zzf;
    public static final zzim zzg;
    public static final zzim zzh;
    public static final zzim zzi;
    public static final zzim zzj;
    public static final zzim zzk;
    public static final zzim zzl;
    public static final zzim zzm;
    public static final zzim zzn;
    public static final zzim zzo;
    public static final zzim zzp;
    public static final zzim zzq;
    public static final zzim zzr;
    private static final /* synthetic */ zzim[] zzu;
    private final zzip zzs;
    private final int zzt;

    public static zzim[] values() {
        return (zzim[]) zzu.clone();
    }

    private zzim(String str, int i, zzip zzipVar, int i2) {
        super(str, i);
        this.zzs = zzipVar;
        this.zzt = i2;
    }

    public final zzip zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* synthetic */ zzim(String str, int i, zzip zzipVar, int i2, zzij zzijVar) {
        this(str, i, zzipVar, i2);
    }

    static {
        zzim zzimVar = new zzim("DOUBLE", 0, zzip.DOUBLE, 1);
        zza = zzimVar;
        zzim zzimVar2 = new zzim("FLOAT", 1, zzip.FLOAT, 5);
        zzb = zzimVar2;
        final int i = 2;
        zzim zzimVar3 = new zzim("INT64", 2, zzip.LONG, 0);
        zzc = zzimVar3;
        final int i2 = 3;
        zzim zzimVar4 = new zzim("UINT64", 3, zzip.LONG, 0);
        zzd = zzimVar4;
        zzim zzimVar5 = new zzim("INT32", 4, zzip.INT, 0);
        zze = zzimVar5;
        zzim zzimVar6 = new zzim("FIXED64", 5, zzip.LONG, 1);
        zzf = zzimVar6;
        zzim zzimVar7 = new zzim("FIXED32", 6, zzip.INT, 5);
        zzg = zzimVar7;
        zzim zzimVar8 = new zzim("BOOL", 7, zzip.BOOLEAN, 0);
        zzh = zzimVar8;
        final zzip zzipVar = zzip.STRING;
        final String str = "STRING";
        final int i3 = 8;
        zzim zzimVar9 = new zzim(str, i3, zzipVar, i) { // from class: com.google.android.gms.internal.measurement.zzil
            {
                int i4 = 2;
                zzij zzijVar = null;
                int i5 = 8;
            }
        };
        zzi = zzimVar9;
        final zzip zzipVar2 = zzip.MESSAGE;
        final String str2 = "GROUP";
        final int i4 = 9;
        zzim zzimVar10 = new zzim(str2, i4, zzipVar2, i2) { // from class: com.google.android.gms.internal.measurement.zzio
            {
                int i5 = 3;
                zzij zzijVar = null;
                int i6 = 9;
            }
        };
        zzj = zzimVar10;
        final zzip zzipVar3 = zzip.MESSAGE;
        final String str3 = "MESSAGE";
        final int i5 = 10;
        zzim zzimVar11 = new zzim(str3, i5, zzipVar3, i) { // from class: com.google.android.gms.internal.measurement.zzin
            {
                int i6 = 2;
                zzij zzijVar = null;
                int i7 = 10;
            }
        };
        zzk = zzimVar11;
        final zzip zzipVar4 = zzip.BYTE_STRING;
        final String str4 = "BYTES";
        final int i6 = 11;
        zzim zzimVar12 = new zzim(str4, i6, zzipVar4, i) { // from class: com.google.android.gms.internal.measurement.zziq
            {
                int i7 = 2;
                zzij zzijVar = null;
                int i8 = 11;
            }
        };
        zzl = zzimVar12;
        zzim zzimVar13 = new zzim("UINT32", 12, zzip.INT, 0);
        zzm = zzimVar13;
        zzim zzimVar14 = new zzim("ENUM", 13, zzip.ENUM, 0);
        zzn = zzimVar14;
        zzim zzimVar15 = new zzim("SFIXED32", 14, zzip.INT, 5);
        zzo = zzimVar15;
        zzim zzimVar16 = new zzim("SFIXED64", 15, zzip.LONG, 1);
        zzp = zzimVar16;
        zzim zzimVar17 = new zzim("SINT32", 16, zzip.INT, 0);
        zzq = zzimVar17;
        zzim zzimVar18 = new zzim("SINT64", 17, zzip.LONG, 0);
        zzr = zzimVar18;
        zzu = new zzim[]{zzimVar, zzimVar2, zzimVar3, zzimVar4, zzimVar5, zzimVar6, zzimVar7, zzimVar8, zzimVar9, zzimVar10, zzimVar11, zzimVar12, zzimVar13, zzimVar14, zzimVar15, zzimVar16, zzimVar17, zzimVar18};
    }
}
