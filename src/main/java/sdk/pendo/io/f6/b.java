package sdk.pendo.io.f6;

import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.microsoft.identity.common.java.platform.AbstractDevicePopManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'Test' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b-\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0¨\u00061"}, d2 = {"Lsdk/pendo/io/f6/b;", "", "", "c", "Lsdk/pendo/io/f6/c;", "e", "toString", "endPointName", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "endPointType", "Lsdk/pendo/io/f6/c;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lsdk/pendo/io/f6/c;)V", AbstractDevicePopManager.CertificateProperties.COUNTRY, "US1", "GOV", "JP", "EU", "HSBC", "AU", "Automation", "Test", "Apollo", "Armada", "Atlas", "Batman", "Calypso", "Dap", "Dev", "EuDev", "Freeze", "Helix", "Ionchef", "Link", "Magic", "Mcfly", "Ml", "MobileFbi", "MobileGuides", "MobileHummus", "MobilePlat", "Perfserf", "ScrumOps", "Security", "Uat", "Voc", "Wildlings", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public class b {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ b[] $VALUES;
    public static final b Apollo;
    public static final b Armada;
    public static final b Atlas;
    public static final b Batman;
    public static final b Calypso;
    public static final b Dap;
    public static final b Dev;
    public static final b EuDev;
    public static final b Freeze;
    public static final b Helix;
    public static final b Ionchef;
    public static final b Link;
    public static final b Magic;
    public static final b Mcfly;
    public static final b Ml;
    public static final b MobileFbi;
    public static final b MobileGuides;
    public static final b MobileHummus;
    public static final b MobilePlat;
    public static final b Perfserf;
    public static final b ScrumOps;
    public static final b Security;
    public static final b Test;
    public static final b Uat;
    public static final b Voc;
    public static final b Wildlings;
    private final String endPointName;
    private final sdk.pendo.io.f6.c endPointType;
    public static final b US = new b(AbstractDevicePopManager.CertificateProperties.COUNTRY, 0) { // from class: sdk.pendo.io.f6.b.h
        {
            sdk.pendo.io.f6.c cVar = sdk.pendo.io.f6.c.PROD;
            String str = "us";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // sdk.pendo.io.f6.b
        public String c() {
            return "https://data.pendo.io";
        }
    };
    public static final b US1 = new b("US1", 1) { // from class: sdk.pendo.io.f6.b.g
        {
            sdk.pendo.io.f6.c cVar = sdk.pendo.io.f6.c.PROD;
            String str = "us1";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // sdk.pendo.io.f6.b
        public String c() {
            return "https://us1.data.pendo.io";
        }
    };
    public static final b GOV = new b("GOV", 2) { // from class: sdk.pendo.io.f6.b.d
        {
            sdk.pendo.io.f6.c cVar = sdk.pendo.io.f6.c.PROD;
            String str = "gov";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // sdk.pendo.io.f6.b
        public String c() {
            return "https://data.gov.pendo.io";
        }
    };
    public static final b JP = new b("JP", 3) { // from class: sdk.pendo.io.f6.b.f
        {
            sdk.pendo.io.f6.c cVar = sdk.pendo.io.f6.c.PROD;
            String str = "jp";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // sdk.pendo.io.f6.b
        public String c() {
            return "https://data.jpn.pendo.io";
        }
    };
    public static final b EU = new b("EU", 4) { // from class: sdk.pendo.io.f6.b.c
        {
            sdk.pendo.io.f6.c cVar = sdk.pendo.io.f6.c.PROD;
            String str = "eu";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // sdk.pendo.io.f6.b
        public String c() {
            return "https://data.eu.pendo.io";
        }
    };
    public static final b HSBC = new b("HSBC", 5) { // from class: sdk.pendo.io.f6.b.e
        {
            sdk.pendo.io.f6.c cVar = sdk.pendo.io.f6.c.PROD;
            String str = "hsbc";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // sdk.pendo.io.f6.b
        public String c() {
            return "https://data.hsbc.pendo.io";
        }
    };
    public static final b AU = new b("AU", 6) { // from class: sdk.pendo.io.f6.b.a
        {
            sdk.pendo.io.f6.c cVar = sdk.pendo.io.f6.c.PROD;
            String str = "au";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // sdk.pendo.io.f6.b
        public String c() {
            return "https://data.au.pendo.io";
        }
    };
    public static final b Automation = new b("Automation", 7) { // from class: sdk.pendo.io.f6.b.b
        {
            sdk.pendo.io.f6.c cVar = sdk.pendo.io.f6.c.STAGING;
            String str = "automation";
            DefaultConstructorMarker defaultConstructorMarker = null;
        }

        @Override // sdk.pendo.io.f6.b
        public String c() {
            return "http://10.0.2.2:8443";
        }
    };

    static {
        sdk.pendo.io.f6.c cVar = sdk.pendo.io.f6.c.STAGING;
        Test = new b("Test", 8, "test", cVar);
        sdk.pendo.io.f6.c cVar2 = sdk.pendo.io.f6.c.DEV;
        Apollo = new b("Apollo", 9, "apollo", cVar2);
        Armada = new b("Armada", 10, "armada", cVar2);
        Atlas = new b("Atlas", 11, "atlas", cVar2);
        Batman = new b("Batman", 12, "batman", cVar2);
        Calypso = new b("Calypso", 13, "calypso", cVar2);
        Dap = new b("Dap", 14, "dap", cVar2);
        Dev = new b("Dev", 15, "dev", cVar2);
        EuDev = new b("EuDev", 16, "eu-dev", cVar2);
        Freeze = new b("Freeze", 17, "freeze", cVar2);
        Helix = new b("Helix", 18, "helix", cVar2);
        Ionchef = new b("Ionchef", 19, "ionchef", cVar2);
        Link = new b("Link", 20, BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_LINK, cVar2);
        Magic = new b("Magic", 21, "magic", cVar2);
        Mcfly = new b("Mcfly", 22, "mcfly", cVar2);
        Ml = new b("Ml", 23, "ml", cVar2);
        MobileFbi = new b("MobileFbi", 24, "mobile-fbi", cVar2);
        MobileGuides = new b("MobileGuides", 25, "mobile-guides", cVar2);
        MobileHummus = new b("MobileHummus", 26, "mobile-hummus", cVar2);
        MobilePlat = new b("MobilePlat", 27, "mobile-plat", cVar2);
        Perfserf = new b("Perfserf", 28, "perfserf", cVar2);
        ScrumOps = new b("ScrumOps", 29, "scrum-ops", cVar2);
        Security = new b("Security", 30, "security", cVar2);
        Uat = new b("Uat", 31, "uat", cVar);
        Voc = new b("Voc", 32, "voc", cVar2);
        Wildlings = new b("Wildlings", 33, "wildlings", cVar2);
        b[] bVarArrA = a();
        $VALUES = bVarArrA;
        $ENTRIES = EnumEntriesKt.enumEntries(bVarArrA);
    }

    private b(String str, int i, String str2, sdk.pendo.io.f6.c cVar) {
        super(str, i);
        this.endPointName = str2;
        this.endPointType = cVar;
    }

    private static final /* synthetic */ b[] a() {
        return new b[]{US, US1, GOV, JP, EU, HSBC, AU, Automation, Test, Apollo, Armada, Atlas, Batman, Calypso, Dap, Dev, EuDev, Freeze, Helix, Ionchef, Link, Magic, Mcfly, Ml, MobileFbi, MobileGuides, MobileHummus, MobilePlat, Perfserf, ScrumOps, Security, Uat, Voc, Wildlings};
    }

    public static EnumEntries<b> d() {
        return $ENTRIES;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getEndPointName() {
        return this.endPointName;
    }

    public String c() {
        String lowerCase = this.endPointName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return "https://app.pendo-" + lowerCase + ".pendo-dev.com";
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final sdk.pendo.io.f6.c getEndPointType() {
        return this.endPointType;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EndPoint: " + this.endPointName + " url: " + c() + " type: " + this.endPointType.name();
    }

    public /* synthetic */ b(String str, int i, String str2, sdk.pendo.io.f6.c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, cVar);
    }
}
