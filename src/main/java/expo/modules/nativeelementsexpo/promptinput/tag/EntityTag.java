package expo.modules.nativeelementsexpo.promptinput.tag;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TagSpan.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/tag/EntityTag;", "", "name", "", "id", "type", "Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType;)V", "getName", "()Ljava/lang/String;", "getId", "getType", "()Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class EntityTag {
    public static final int $stable = 0;
    private final String id;
    private final String name;
    private final TagType type;

    public static /* synthetic */ EntityTag copy$default(EntityTag entityTag, String str, String str2, TagType tagType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = entityTag.name;
        }
        if ((i & 2) != 0) {
            str2 = entityTag.id;
        }
        if ((i & 4) != 0) {
            tagType = entityTag.type;
        }
        return entityTag.copy(str, str2, tagType);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final TagType getType() {
        return this.type;
    }

    public final EntityTag copy(String name, String id, TagType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        return new EntityTag(name, id, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntityTag)) {
            return false;
        }
        EntityTag entityTag = (EntityTag) other;
        return Intrinsics.areEqual(this.name, entityTag.name) && Intrinsics.areEqual(this.id, entityTag.id) && this.type == entityTag.type;
    }

    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.id.hashCode()) * 31;
        TagType tagType = this.type;
        return iHashCode + (tagType == null ? 0 : tagType.hashCode());
    }

    public String toString() {
        return "EntityTag(name=" + this.name + ", id=" + this.id + ", type=" + this.type + ")";
    }

    public EntityTag(String name, String id, TagType tagType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        this.name = name;
        this.id = id;
        this.type = tagType;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final TagType getType() {
        return this.type;
    }
}
