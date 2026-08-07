package expo.modules.nativeelementsexpo.promptinput.tag;

import com.box.rnBrownfield.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TagSpan.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0015\b\u0002\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType;", "", "iconResId", "", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getIconResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "PERSON", "FILE", "FOLDER", "Companion", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum TagType {
    PERSON(null),
    FILE(Integer.valueOf(R.drawable.ic_mention_file)),
    FOLDER(Integer.valueOf(R.drawable.ic_mention_folder));

    private final Integer iconResId;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<TagType> getEntries() {
        return $ENTRIES;
    }

    TagType(Integer num) {
        this.iconResId = num;
    }

    public final Integer getIconResId() {
        return this.iconResId;
    }

    /* JADX INFO: compiled from: TagSpan.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType$Companion;", "", "<init>", "()V", "fromString", "Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType;", "type", "", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TagType fromString(String type) {
            Intrinsics.checkNotNullParameter(type, "type");
            int iHashCode = type.hashCode();
            if (iHashCode == -1268966290) {
                if (type.equals("folder")) {
                    return TagType.FOLDER;
                }
                return null;
            }
            if (iHashCode == -991716523) {
                if (type.equals("person")) {
                    return TagType.PERSON;
                }
                return null;
            }
            if (iHashCode == 3143036 && type.equals("file")) {
                return TagType.FILE;
            }
            return null;
        }
    }
}
