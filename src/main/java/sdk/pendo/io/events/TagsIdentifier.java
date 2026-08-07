package sdk.pendo.io.events;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/events/TagsIdentifier;", "", "id", "", "text", "source", "Lsdk/pendo/io/events/TagsIdentifier$Source;", "(Ljava/lang/String;Ljava/lang/String;Lsdk/pendo/io/events/TagsIdentifier$Source;)V", "getId", "()Ljava/lang/String;", "getSource", "()Lsdk/pendo/io/events/TagsIdentifier$Source;", "getText", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toJSON", "Lorg/json/JSONObject;", "toString", "Companion", "Source", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class TagsIdentifier {
    public static final String FIELD_ID = "id";
    public static final String FIELD_IDS_ARRAY = "ids";
    public static final String FIELD_LABEL = "label";
    public static final String FIELD_TEXT = "text";
    private final String id;
    private final Source source;
    private final String text;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lsdk/pendo/io/events/TagsIdentifier$Source;", "", "label", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "VIEW_TAG", "TEST_TAG", "PENDO_TAG", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public enum Source {
        VIEW_TAG("viewTag"),
        TEST_TAG(ComposeIdentificationData.FIELD_TEST_TAG_HASHED),
        PENDO_TAG(ComposeIdentificationData.PENDO_TAG_HASHED);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String label;

        Source(String str) {
            this.label = str;
        }

        public static EnumEntries<Source> getEntries() {
            return $ENTRIES;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    public TagsIdentifier(String id, String text, Source source) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(source, "source");
        this.id = id;
        this.text = text;
        this.source = source;
    }

    public static /* synthetic */ TagsIdentifier copy$default(TagsIdentifier tagsIdentifier, String str, String str2, Source source, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tagsIdentifier.id;
        }
        if ((i & 2) != 0) {
            str2 = tagsIdentifier.text;
        }
        if ((i & 4) != 0) {
            source = tagsIdentifier.source;
        }
        return tagsIdentifier.copy(str, str2, source);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    public final TagsIdentifier copy(String id, String text, Source source) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(source, "source");
        return new TagsIdentifier(id, text, source);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagsIdentifier)) {
            return false;
        }
        TagsIdentifier tagsIdentifier = (TagsIdentifier) other;
        return Intrinsics.areEqual(this.id, tagsIdentifier.id) && Intrinsics.areEqual(this.text, tagsIdentifier.text) && this.source == tagsIdentifier.source;
    }

    public final String getId() {
        return this.id;
    }

    public final Source getSource() {
        return this.source;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.text.hashCode()) * 31) + this.source.hashCode();
    }

    public final JSONObject toJSON() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("id", this.id).put("text", this.text).put("label", this.source.getLabel());
        Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "put(...)");
        return jSONObjectPut;
    }

    public String toString() {
        return "TagsIdentifier(id=" + this.id + ", text=" + this.text + ", source=" + this.source + ")";
    }
}
