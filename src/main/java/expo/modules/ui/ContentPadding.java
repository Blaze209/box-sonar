package expo.modules.ui;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyColumnView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lexpo/modules/ui/ContentPadding;", "Lexpo/modules/kotlin/records/Record;", "start", "", ViewProps.TOP, "end", ViewProps.BOTTOM, "<init>", "(IIII)V", "getStart$annotations", "()V", "getStart", "()I", "getTop$annotations", "getTop", "getEnd$annotations", "getEnd", "getBottom$annotations", "getBottom", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class ContentPadding implements Record {
    public static final int $stable = 0;
    private final int bottom;
    private final int end;
    private final int start;
    private final int top;

    public ContentPadding() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ContentPadding copy$default(ContentPadding contentPadding, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = contentPadding.start;
        }
        if ((i5 & 2) != 0) {
            i2 = contentPadding.top;
        }
        if ((i5 & 4) != 0) {
            i3 = contentPadding.end;
        }
        if ((i5 & 8) != 0) {
            i4 = contentPadding.bottom;
        }
        return contentPadding.copy(i, i2, i3, i4);
    }

    @Field
    public static /* synthetic */ void getBottom$annotations() {
    }

    @Field
    public static /* synthetic */ void getEnd$annotations() {
    }

    @Field
    public static /* synthetic */ void getStart$annotations() {
    }

    @Field
    public static /* synthetic */ void getTop$annotations() {
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStart() {
        return this.start;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    public final ContentPadding copy(int start, int top, int end, int bottom) {
        return new ContentPadding(start, top, end, bottom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentPadding)) {
            return false;
        }
        ContentPadding contentPadding = (ContentPadding) other;
        return this.start == contentPadding.start && this.top == contentPadding.top && this.end == contentPadding.end && this.bottom == contentPadding.bottom;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.top)) * 31) + Integer.hashCode(this.end)) * 31) + Integer.hashCode(this.bottom);
    }

    public String toString() {
        return "ContentPadding(start=" + this.start + ", top=" + this.top + ", end=" + this.end + ", bottom=" + this.bottom + ")";
    }

    public ContentPadding(int i, int i2, int i3, int i4) {
        this.start = i;
        this.top = i2;
        this.end = i3;
        this.bottom = i4;
    }

    public /* synthetic */ ContentPadding(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    public final int getStart() {
        return this.start;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getEnd() {
        return this.end;
    }

    public final int getBottom() {
        return this.bottom;
    }
}
