package com.box.android.domain.models;

import com.box.androidsdk.content.models.BoxRepresentation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/box/android/domain/models/RepresentationType;", "", "<init>", "(Ljava/lang/String;I)V", "PDF", "JPG", "PNG", "MP4", "DASH", "FILMSTRIP", "THREED", "MP3", "UNKNOWN", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum RepresentationType {
    PDF,
    JPG,
    PNG,
    MP4,
    DASH,
    FILMSTRIP,
    THREED,
    MP3,
    UNKNOWN;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<RepresentationType> getEntries() {
        return $ENTRIES;
    }

    /* JADX INFO: compiled from: RepresentationModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\n\u0010\b\u001a\u00020\u0007*\u00020\u0005¨\u0006\t"}, d2 = {"Lcom/box/android/domain/models/RepresentationType$Companion;", "", "<init>", "()V", "fromString", "Lcom/box/android/domain/models/RepresentationType;", "rep", "", "toBoxRepType", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: RepresentationModel.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RepresentationType.values().length];
                try {
                    iArr[RepresentationType.PDF.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RepresentationType.JPG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RepresentationType.PNG.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RepresentationType.MP4.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[RepresentationType.DASH.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[RepresentationType.FILMSTRIP.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[RepresentationType.THREED.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[RepresentationType.MP3.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[RepresentationType.UNKNOWN.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final RepresentationType fromString(String rep) {
            Intrinsics.checkNotNullParameter(rep, "rep");
            switch (rep.hashCode()) {
                case -1068769260:
                    if (rep.equals(BoxRepresentation.TYPE_FILMSTRIP)) {
                        return RepresentationType.FILMSTRIP;
                    }
                    break;
                case 1681:
                    if (rep.equals("3d")) {
                        return RepresentationType.THREED;
                    }
                    break;
                case 105441:
                    if (rep.equals(BoxRepresentation.TYPE_JPG)) {
                        return RepresentationType.JPG;
                    }
                    break;
                case 108272:
                    if (rep.equals(BoxRepresentation.TYPE_MP3)) {
                        return RepresentationType.MP3;
                    }
                    break;
                case 108273:
                    if (rep.equals(BoxRepresentation.TYPE_MP4)) {
                        return RepresentationType.MP4;
                    }
                    break;
                case 110834:
                    if (rep.equals("pdf")) {
                        return RepresentationType.PDF;
                    }
                    break;
                case 111145:
                    if (rep.equals(BoxRepresentation.TYPE_PNG)) {
                        return RepresentationType.PNG;
                    }
                    break;
                case 3075986:
                    if (rep.equals(BoxRepresentation.TYPE_DASH)) {
                        return RepresentationType.DASH;
                    }
                    break;
            }
            return RepresentationType.UNKNOWN;
        }

        public final String toBoxRepType(RepresentationType representationType) {
            Intrinsics.checkNotNullParameter(representationType, "<this>");
            switch (WhenMappings.$EnumSwitchMapping$0[representationType.ordinal()]) {
                case 1:
                    return "pdf";
                case 2:
                    return BoxRepresentation.TYPE_JPG;
                case 3:
                    return BoxRepresentation.TYPE_PNG;
                case 4:
                    return BoxRepresentation.TYPE_MP4;
                case 5:
                    return BoxRepresentation.TYPE_DASH;
                case 6:
                    return BoxRepresentation.TYPE_FILMSTRIP;
                case 7:
                    return "3d";
                case 8:
                    return BoxRepresentation.TYPE_MP3;
                case 9:
                    return "";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
    }
}
