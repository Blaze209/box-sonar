package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ListItemDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cBQ\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010%J%\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020A¢\u0006\u0004\bD\u0010EJ%\u0010\u0004\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020A¢\u0006\u0004\bF\u0010EJ%\u0010\u0005\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020A¢\u0006\u0004\bG\u0010EJ%\u0010\u0006\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020A¢\u0006\u0004\bH\u0010EJ%\u0010\u0007\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020A¢\u0006\u0004\bI\u0010EJ%\u0010\b\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020A¢\u0006\u0004\bJ\u0010EJý\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\bL\u0010MJ\u0013\u0010N\u001a\u00020A2\b\u0010O\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010P\u001a\u00020QH\u0016Ji\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u0003H\u0007¢\u0006\u0004\bc\u0010dR\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010'R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b+\u0010'R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b,\u0010'R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b-\u0010'R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b.\u0010'R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b/\u0010'R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b0\u0010'R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b1\u0010'R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b2\u0010'R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b3\u0010'R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b4\u0010'R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b5\u0010'R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b6\u0010'R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b7\u0010'R\u0013\u0010\u0013\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b8\u0010'R\u0013\u0010\u0014\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b9\u0010'R\u0013\u0010\u0015\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b:\u0010'R\u0013\u0010\u0016\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b;\u0010'R\u0013\u0010\u0017\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b<\u0010'R\u0013\u0010\u0018\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b=\u0010'R\u0013\u0010\u0019\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b>\u0010'R\u0013\u0010\u001a\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010(\u001a\u0004\b?\u0010'R\u001a\u0010\u001d\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\bR\u0010S\u001a\u0004\bT\u0010'R\u001a\u0010\u001e\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\bU\u0010S\u001a\u0004\bV\u0010'R\u001a\u0010\u001f\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\bW\u0010S\u001a\u0004\bX\u0010'R\u001a\u0010 \u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\bY\u0010S\u001a\u0004\bZ\u0010'R\u001a\u0010!\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010S\u001a\u0004\b\\\u0010'R\u001a\u0010\"\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b]\u0010S\u001a\u0004\b^\u0010'R\u001a\u0010#\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010S\u001a\u0004\b`\u0010'R\u001a\u0010$\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010S\u001a\u0004\bb\u0010'¨\u0006e"}, d2 = {"Landroidx/compose/material3/ListItemColors;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingContentColor", "trailingContentColor", "overlineContentColor", "supportingContentColor", "disabledContainerColor", "disabledContentColor", "disabledLeadingContentColor", "disabledTrailingContentColor", "disabledOverlineContentColor", "disabledSupportingContentColor", "selectedContainerColor", "selectedContentColor", "selectedLeadingContentColor", "selectedTrailingContentColor", "selectedOverlineContentColor", "selectedSupportingContentColor", "draggedContainerColor", "draggedContentColor", "draggedLeadingContentColor", "draggedTrailingContentColor", "draggedOverlineContentColor", "draggedSupportingContentColor", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "headlineColor", "leadingIconColor", "overlineColor", "supportingTextColor", "trailingIconColor", "disabledHeadlineColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "(JJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getContentColor-0d7_KjU", "getLeadingContentColor-0d7_KjU", "getTrailingContentColor-0d7_KjU", "getOverlineContentColor-0d7_KjU", "getSupportingContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "getDisabledLeadingContentColor-0d7_KjU", "getDisabledTrailingContentColor-0d7_KjU", "getDisabledOverlineContentColor-0d7_KjU", "getDisabledSupportingContentColor-0d7_KjU", "getSelectedContainerColor-0d7_KjU", "getSelectedContentColor-0d7_KjU", "getSelectedLeadingContentColor-0d7_KjU", "getSelectedTrailingContentColor-0d7_KjU", "getSelectedOverlineContentColor-0d7_KjU", "getSelectedSupportingContentColor-0d7_KjU", "getDraggedContainerColor-0d7_KjU", "getDraggedContentColor-0d7_KjU", "getDraggedLeadingContentColor-0d7_KjU", "getDraggedTrailingContentColor-0d7_KjU", "getDraggedOverlineContentColor-0d7_KjU", "getDraggedSupportingContentColor-0d7_KjU", "enabled", "", "selected", "dragged", "containerColor-XeAY9LY", "(ZZZ)J", "contentColor-XeAY9LY", "leadingContentColor-XeAY9LY", "trailingContentColor-XeAY9LY", "overlineContentColor-XeAY9LY", "supportingContentColor-XeAY9LY", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-KKJ9vVU", "(JJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ListItemColors;", "equals", "other", "hashCode", "", "getHeadlineColor-0d7_KjU$annotations", "()V", "getHeadlineColor-0d7_KjU", "getLeadingIconColor-0d7_KjU$annotations", "getLeadingIconColor-0d7_KjU", "getOverlineColor-0d7_KjU$annotations", "getOverlineColor-0d7_KjU", "getSupportingTextColor-0d7_KjU$annotations", "getSupportingTextColor-0d7_KjU", "getTrailingIconColor-0d7_KjU$annotations", "getTrailingIconColor-0d7_KjU", "getDisabledHeadlineColor-0d7_KjU$annotations", "getDisabledHeadlineColor-0d7_KjU", "getDisabledLeadingIconColor-0d7_KjU$annotations", "getDisabledLeadingIconColor-0d7_KjU", "getDisabledTrailingIconColor-0d7_KjU$annotations", "getDisabledTrailingIconColor-0d7_KjU", "copy-5r9EGqc", "(JJJJJJJJJ)Landroidx/compose/material3/ListItemColors;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ListItemColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;
    private final long disabledLeadingContentColor;
    private final long disabledOverlineContentColor;
    private final long disabledSupportingContentColor;
    private final long disabledTrailingContentColor;
    private final long draggedContainerColor;
    private final long draggedContentColor;
    private final long draggedLeadingContentColor;
    private final long draggedOverlineContentColor;
    private final long draggedSupportingContentColor;
    private final long draggedTrailingContentColor;
    private final long leadingContentColor;
    private final long overlineContentColor;
    private final long selectedContainerColor;
    private final long selectedContentColor;
    private final long selectedLeadingContentColor;
    private final long selectedOverlineContentColor;
    private final long selectedSupportingContentColor;
    private final long selectedTrailingContentColor;
    private final long supportingContentColor;
    private final long trailingContentColor;

    public /* synthetic */ ListItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24);
    }

    public /* synthetic */ ListItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9);
    }

    @Deprecated(message = "Renamed to disabledContentColor")
    /* JADX INFO: renamed from: getDisabledHeadlineColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3618getDisabledHeadlineColor0d7_KjU$annotations() {
    }

    @Deprecated(message = "Renamed to disabledLeadingContentColor")
    /* JADX INFO: renamed from: getDisabledLeadingIconColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3619getDisabledLeadingIconColor0d7_KjU$annotations() {
    }

    @Deprecated(message = "Renamed to disabledTrailingContentColor")
    /* JADX INFO: renamed from: getDisabledTrailingIconColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3620getDisabledTrailingIconColor0d7_KjU$annotations() {
    }

    @Deprecated(message = "Renamed to contentColor")
    /* JADX INFO: renamed from: getHeadlineColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3621getHeadlineColor0d7_KjU$annotations() {
    }

    @Deprecated(message = "Renamed to leadingContentColor")
    /* JADX INFO: renamed from: getLeadingIconColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3622getLeadingIconColor0d7_KjU$annotations() {
    }

    @Deprecated(message = "Renamed to overlineContentColor")
    /* JADX INFO: renamed from: getOverlineColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3623getOverlineColor0d7_KjU$annotations() {
    }

    @Deprecated(message = "Renamed to supportingContentColor")
    /* JADX INFO: renamed from: getSupportingTextColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3624getSupportingTextColor0d7_KjU$annotations() {
    }

    @Deprecated(message = "Renamed to trailingContentColor")
    /* JADX INFO: renamed from: getTrailingIconColor-0d7_KjU$annotations, reason: not valid java name */
    public static /* synthetic */ void m3625getTrailingIconColor0d7_KjU$annotations() {
    }

    private ListItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24) {
        this.containerColor = j;
        this.contentColor = j2;
        this.leadingContentColor = j3;
        this.trailingContentColor = j4;
        this.overlineContentColor = j5;
        this.supportingContentColor = j6;
        this.disabledContainerColor = j7;
        this.disabledContentColor = j8;
        this.disabledLeadingContentColor = j9;
        this.disabledTrailingContentColor = j10;
        this.disabledOverlineContentColor = j11;
        this.disabledSupportingContentColor = j12;
        this.selectedContainerColor = j13;
        this.selectedContentColor = j14;
        this.selectedLeadingContentColor = j15;
        this.selectedTrailingContentColor = j16;
        this.selectedOverlineContentColor = j17;
        this.selectedSupportingContentColor = j18;
        this.draggedContainerColor = j19;
        this.draggedContentColor = j20;
        this.draggedLeadingContentColor = j21;
        this.draggedTrailingContentColor = j22;
        this.draggedOverlineContentColor = j23;
        this.draggedSupportingContentColor = j24;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentColor() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getLeadingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getLeadingContentColor() {
        return this.leadingContentColor;
    }

    /* JADX INFO: renamed from: getTrailingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTrailingContentColor() {
        return this.trailingContentColor;
    }

    /* JADX INFO: renamed from: getOverlineContentColor-0d7_KjU, reason: not valid java name */
    public final long m3651getOverlineContentColor0d7_KjU() {
        return this.overlineContentColor;
    }

    /* JADX INFO: renamed from: getSupportingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSupportingContentColor() {
        return this.supportingContentColor;
    }

    /* JADX INFO: renamed from: getDisabledContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledContainerColor() {
        return this.disabledContainerColor;
    }

    /* JADX INFO: renamed from: getDisabledContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledContentColor() {
        return this.disabledContentColor;
    }

    /* JADX INFO: renamed from: getDisabledLeadingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledLeadingContentColor() {
        return this.disabledLeadingContentColor;
    }

    /* JADX INFO: renamed from: getDisabledTrailingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledTrailingContentColor() {
        return this.disabledTrailingContentColor;
    }

    /* JADX INFO: renamed from: getDisabledOverlineContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledOverlineContentColor() {
        return this.disabledOverlineContentColor;
    }

    /* JADX INFO: renamed from: getDisabledSupportingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledSupportingContentColor() {
        return this.disabledSupportingContentColor;
    }

    /* JADX INFO: renamed from: getSelectedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedContainerColor() {
        return this.selectedContainerColor;
    }

    /* JADX INFO: renamed from: getSelectedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedContentColor() {
        return this.selectedContentColor;
    }

    /* JADX INFO: renamed from: getSelectedLeadingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedLeadingContentColor() {
        return this.selectedLeadingContentColor;
    }

    /* JADX INFO: renamed from: getSelectedTrailingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedTrailingContentColor() {
        return this.selectedTrailingContentColor;
    }

    /* JADX INFO: renamed from: getSelectedOverlineContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedOverlineContentColor() {
        return this.selectedOverlineContentColor;
    }

    /* JADX INFO: renamed from: getSelectedSupportingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedSupportingContentColor() {
        return this.selectedSupportingContentColor;
    }

    /* JADX INFO: renamed from: getDraggedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDraggedContainerColor() {
        return this.draggedContainerColor;
    }

    /* JADX INFO: renamed from: getDraggedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDraggedContentColor() {
        return this.draggedContentColor;
    }

    /* JADX INFO: renamed from: getDraggedLeadingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDraggedLeadingContentColor() {
        return this.draggedLeadingContentColor;
    }

    /* JADX INFO: renamed from: getDraggedTrailingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDraggedTrailingContentColor() {
        return this.draggedTrailingContentColor;
    }

    /* JADX INFO: renamed from: getDraggedOverlineContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDraggedOverlineContentColor() {
        return this.draggedOverlineContentColor;
    }

    /* JADX INFO: renamed from: getDraggedSupportingContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDraggedSupportingContentColor() {
        return this.draggedSupportingContentColor;
    }

    private ListItemColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9) {
        this(j, j2, j3, j6, j4, j5, Color.INSTANCE.m6850getUnspecified0d7_KjU(), j7, j8, j9, Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), Color.INSTANCE.m6850getUnspecified0d7_KjU(), null);
    }

    /* JADX INFO: renamed from: containerColor-XeAY9LY, reason: not valid java name */
    public final long m3626containerColorXeAY9LY(boolean enabled, boolean selected, boolean dragged) {
        if (!enabled) {
            return this.disabledContainerColor;
        }
        if (dragged) {
            return this.draggedContainerColor;
        }
        if (selected) {
            return this.selectedContainerColor;
        }
        return this.containerColor;
    }

    /* JADX INFO: renamed from: contentColor-XeAY9LY, reason: not valid java name */
    public final long m3627contentColorXeAY9LY(boolean enabled, boolean selected, boolean dragged) {
        if (!enabled) {
            return this.disabledContentColor;
        }
        if (dragged) {
            return this.draggedContentColor;
        }
        if (selected) {
            return this.selectedContentColor;
        }
        return this.contentColor;
    }

    /* JADX INFO: renamed from: leadingContentColor-XeAY9LY, reason: not valid java name */
    public final long m3662leadingContentColorXeAY9LY(boolean enabled, boolean selected, boolean dragged) {
        if (!enabled) {
            return this.disabledLeadingContentColor;
        }
        if (dragged) {
            return this.draggedLeadingContentColor;
        }
        if (selected) {
            return this.selectedLeadingContentColor;
        }
        return this.leadingContentColor;
    }

    /* JADX INFO: renamed from: trailingContentColor-XeAY9LY, reason: not valid java name */
    public final long m3665trailingContentColorXeAY9LY(boolean enabled, boolean selected, boolean dragged) {
        if (!enabled) {
            return this.disabledTrailingContentColor;
        }
        if (dragged) {
            return this.draggedTrailingContentColor;
        }
        if (selected) {
            return this.selectedTrailingContentColor;
        }
        return this.trailingContentColor;
    }

    /* JADX INFO: renamed from: overlineContentColor-XeAY9LY, reason: not valid java name */
    public final long m3663overlineContentColorXeAY9LY(boolean enabled, boolean selected, boolean dragged) {
        if (!enabled) {
            return this.disabledOverlineContentColor;
        }
        if (dragged) {
            return this.draggedOverlineContentColor;
        }
        if (selected) {
            return this.selectedOverlineContentColor;
        }
        return this.overlineContentColor;
    }

    /* JADX INFO: renamed from: supportingContentColor-XeAY9LY, reason: not valid java name */
    public final long m3664supportingContentColorXeAY9LY(boolean enabled, boolean selected, boolean dragged) {
        if (!enabled) {
            return this.disabledSupportingContentColor;
        }
        if (dragged) {
            return this.draggedSupportingContentColor;
        }
        if (selected) {
            return this.selectedSupportingContentColor;
        }
        return this.supportingContentColor;
    }

    /* JADX INFO: renamed from: copy-KKJ9vVU$default, reason: not valid java name */
    public static /* synthetic */ ListItemColors m3617copyKKJ9vVU$default(ListItemColors listItemColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, int i, Object obj) {
        long j25;
        long j26;
        long j27 = (i & 1) != 0 ? listItemColors.containerColor : j;
        long j28 = (i & 2) != 0 ? listItemColors.contentColor : j2;
        long j29 = (i & 4) != 0 ? listItemColors.leadingContentColor : j3;
        long j30 = (i & 8) != 0 ? listItemColors.trailingContentColor : j4;
        long j31 = (i & 16) != 0 ? listItemColors.overlineContentColor : j5;
        long j32 = (i & 32) != 0 ? listItemColors.supportingContentColor : j6;
        long j33 = (i & 64) != 0 ? listItemColors.disabledContainerColor : j7;
        long j34 = j27;
        long j35 = (i & 128) != 0 ? listItemColors.disabledContentColor : j8;
        long j36 = (i & 256) != 0 ? listItemColors.disabledLeadingContentColor : j9;
        long j37 = (i & 512) != 0 ? listItemColors.disabledTrailingContentColor : j10;
        long j38 = (i & 1024) != 0 ? listItemColors.disabledOverlineContentColor : j11;
        long j39 = (i & 2048) != 0 ? listItemColors.disabledSupportingContentColor : j12;
        long j40 = (i & 4096) != 0 ? listItemColors.selectedContainerColor : j13;
        long j41 = (i & 8192) != 0 ? listItemColors.selectedContentColor : j14;
        long j42 = (i & 16384) != 0 ? listItemColors.selectedLeadingContentColor : j15;
        long j43 = (i & 32768) != 0 ? listItemColors.selectedTrailingContentColor : j16;
        long j44 = (i & 65536) != 0 ? listItemColors.selectedOverlineContentColor : j17;
        long j45 = (i & 131072) != 0 ? listItemColors.selectedSupportingContentColor : j18;
        long j46 = (i & 262144) != 0 ? listItemColors.draggedContainerColor : j19;
        long j47 = (i & 524288) != 0 ? listItemColors.draggedContentColor : j20;
        long j48 = (i & 1048576) != 0 ? listItemColors.draggedLeadingContentColor : j21;
        long j49 = (i & 2097152) != 0 ? listItemColors.draggedTrailingContentColor : j22;
        long j50 = (i & 4194304) != 0 ? listItemColors.draggedOverlineContentColor : j23;
        if ((i & 8388608) != 0) {
            j26 = j50;
            j25 = listItemColors.draggedSupportingContentColor;
        } else {
            j25 = j24;
            j26 = j50;
        }
        return listItemColors.m3629copyKKJ9vVU(j34, j28, j29, j30, j31, j32, j33, j35, j36, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, j49, j26, j25);
    }

    /* JADX INFO: renamed from: copy-KKJ9vVU, reason: not valid java name */
    public final ListItemColors m3629copyKKJ9vVU(long containerColor, long contentColor, long leadingContentColor, long trailingContentColor, long overlineContentColor, long supportingContentColor, long disabledContainerColor, long disabledContentColor, long disabledLeadingContentColor, long disabledTrailingContentColor, long disabledOverlineContentColor, long disabledSupportingContentColor, long selectedContainerColor, long selectedContentColor, long selectedLeadingContentColor, long selectedTrailingContentColor, long selectedOverlineContentColor, long selectedSupportingContentColor, long draggedContainerColor, long draggedContentColor, long draggedLeadingContentColor, long draggedTrailingContentColor, long draggedOverlineContentColor, long draggedSupportingContentColor) {
        return new ListItemColors(containerColor != 16 ? containerColor : this.containerColor, contentColor != 16 ? contentColor : this.contentColor, leadingContentColor != 16 ? leadingContentColor : this.leadingContentColor, trailingContentColor != 16 ? trailingContentColor : this.trailingContentColor, overlineContentColor != 16 ? overlineContentColor : this.overlineContentColor, supportingContentColor != 16 ? supportingContentColor : this.supportingContentColor, disabledContainerColor != 16 ? disabledContainerColor : this.disabledContainerColor, disabledContentColor != 16 ? disabledContentColor : this.disabledContentColor, disabledLeadingContentColor != 16 ? disabledLeadingContentColor : this.disabledLeadingContentColor, disabledTrailingContentColor != 16 ? disabledTrailingContentColor : this.disabledTrailingContentColor, disabledOverlineContentColor != 16 ? disabledOverlineContentColor : this.disabledOverlineContentColor, disabledSupportingContentColor != 16 ? disabledSupportingContentColor : this.disabledSupportingContentColor, selectedContainerColor != 16 ? selectedContainerColor : this.selectedContainerColor, selectedContentColor != 16 ? selectedContentColor : this.selectedContentColor, selectedLeadingContentColor != 16 ? selectedLeadingContentColor : this.selectedLeadingContentColor, selectedTrailingContentColor != 16 ? selectedTrailingContentColor : this.selectedTrailingContentColor, selectedOverlineContentColor != 16 ? selectedOverlineContentColor : this.selectedOverlineContentColor, selectedSupportingContentColor != 16 ? selectedSupportingContentColor : this.selectedSupportingContentColor, draggedContainerColor != 16 ? draggedContainerColor : this.draggedContainerColor, draggedContentColor != 16 ? draggedContentColor : this.draggedContentColor, draggedLeadingContentColor != 16 ? draggedLeadingContentColor : this.draggedLeadingContentColor, draggedTrailingContentColor != 16 ? draggedTrailingContentColor : this.draggedTrailingContentColor, draggedOverlineContentColor != 16 ? draggedOverlineContentColor : this.draggedOverlineContentColor, draggedSupportingContentColor != 16 ? draggedSupportingContentColor : this.draggedSupportingContentColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof ListItemColors)) {
            return false;
        }
        ListItemColors listItemColors = (ListItemColors) other;
        return Color.m6815equalsimpl0(this.containerColor, listItemColors.containerColor) && Color.m6815equalsimpl0(this.contentColor, listItemColors.contentColor) && Color.m6815equalsimpl0(this.leadingContentColor, listItemColors.leadingContentColor) && Color.m6815equalsimpl0(this.trailingContentColor, listItemColors.trailingContentColor) && Color.m6815equalsimpl0(this.overlineContentColor, listItemColors.overlineContentColor) && Color.m6815equalsimpl0(this.supportingContentColor, listItemColors.supportingContentColor) && Color.m6815equalsimpl0(this.disabledContainerColor, listItemColors.disabledContainerColor) && Color.m6815equalsimpl0(this.disabledContentColor, listItemColors.disabledContentColor) && Color.m6815equalsimpl0(this.disabledLeadingContentColor, listItemColors.disabledLeadingContentColor) && Color.m6815equalsimpl0(this.disabledTrailingContentColor, listItemColors.disabledTrailingContentColor) && Color.m6815equalsimpl0(this.disabledOverlineContentColor, listItemColors.disabledOverlineContentColor) && Color.m6815equalsimpl0(this.disabledSupportingContentColor, listItemColors.disabledSupportingContentColor) && Color.m6815equalsimpl0(this.selectedContainerColor, listItemColors.selectedContainerColor) && Color.m6815equalsimpl0(this.selectedContentColor, listItemColors.selectedContentColor) && Color.m6815equalsimpl0(this.selectedLeadingContentColor, listItemColors.selectedLeadingContentColor) && Color.m6815equalsimpl0(this.selectedTrailingContentColor, listItemColors.selectedTrailingContentColor) && Color.m6815equalsimpl0(this.selectedOverlineContentColor, listItemColors.selectedOverlineContentColor) && Color.m6815equalsimpl0(this.selectedSupportingContentColor, listItemColors.selectedSupportingContentColor) && Color.m6815equalsimpl0(this.draggedContainerColor, listItemColors.draggedContainerColor) && Color.m6815equalsimpl0(this.draggedContentColor, listItemColors.draggedContentColor) && Color.m6815equalsimpl0(this.draggedLeadingContentColor, listItemColors.draggedLeadingContentColor) && Color.m6815equalsimpl0(this.draggedTrailingContentColor, listItemColors.draggedTrailingContentColor) && Color.m6815equalsimpl0(this.draggedOverlineContentColor, listItemColors.draggedOverlineContentColor) && Color.m6815equalsimpl0(this.draggedSupportingContentColor, listItemColors.draggedSupportingContentColor);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((Color.m6821hashCodeimpl(this.containerColor) * 31) + Color.m6821hashCodeimpl(this.contentColor)) * 31) + Color.m6821hashCodeimpl(this.leadingContentColor)) * 31) + Color.m6821hashCodeimpl(this.trailingContentColor)) * 31) + Color.m6821hashCodeimpl(this.overlineContentColor)) * 31) + Color.m6821hashCodeimpl(this.supportingContentColor)) * 31) + Color.m6821hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m6821hashCodeimpl(this.disabledContentColor)) * 31) + Color.m6821hashCodeimpl(this.disabledLeadingContentColor)) * 31) + Color.m6821hashCodeimpl(this.disabledTrailingContentColor)) * 31) + Color.m6821hashCodeimpl(this.disabledOverlineContentColor)) * 31) + Color.m6821hashCodeimpl(this.disabledSupportingContentColor)) * 31) + Color.m6821hashCodeimpl(this.selectedContainerColor)) * 31) + Color.m6821hashCodeimpl(this.selectedContentColor)) * 31) + Color.m6821hashCodeimpl(this.selectedLeadingContentColor)) * 31) + Color.m6821hashCodeimpl(this.selectedTrailingContentColor)) * 31) + Color.m6821hashCodeimpl(this.selectedOverlineContentColor)) * 31) + Color.m6821hashCodeimpl(this.selectedSupportingContentColor)) * 31) + Color.m6821hashCodeimpl(this.draggedContainerColor)) * 31) + Color.m6821hashCodeimpl(this.draggedContentColor)) * 31) + Color.m6821hashCodeimpl(this.draggedLeadingContentColor)) * 31) + Color.m6821hashCodeimpl(this.draggedTrailingContentColor)) * 31) + Color.m6821hashCodeimpl(this.draggedOverlineContentColor)) * 31) + Color.m6821hashCodeimpl(this.draggedSupportingContentColor);
    }

    /* JADX INFO: renamed from: getHeadlineColor-0d7_KjU, reason: not valid java name */
    public final long m3647getHeadlineColor0d7_KjU() {
        return this.contentColor;
    }

    /* JADX INFO: renamed from: getLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3649getLeadingIconColor0d7_KjU() {
        return this.leadingContentColor;
    }

    /* JADX INFO: renamed from: getOverlineColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getOverlineContentColor() {
        return this.overlineContentColor;
    }

    /* JADX INFO: renamed from: getSupportingTextColor-0d7_KjU, reason: not valid java name */
    public final long m3659getSupportingTextColor0d7_KjU() {
        return this.supportingContentColor;
    }

    /* JADX INFO: renamed from: getTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3661getTrailingIconColor0d7_KjU() {
        return this.trailingContentColor;
    }

    /* JADX INFO: renamed from: getDisabledHeadlineColor-0d7_KjU, reason: not valid java name */
    public final long m3634getDisabledHeadlineColor0d7_KjU() {
        return this.disabledContentColor;
    }

    /* JADX INFO: renamed from: getDisabledLeadingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3636getDisabledLeadingIconColor0d7_KjU() {
        return this.disabledLeadingContentColor;
    }

    /* JADX INFO: renamed from: getDisabledTrailingIconColor-0d7_KjU, reason: not valid java name */
    public final long m3640getDisabledTrailingIconColor0d7_KjU() {
        return this.disabledTrailingContentColor;
    }

    /* JADX INFO: renamed from: copy-5r9EGqc$default, reason: not valid java name */
    public static /* synthetic */ ListItemColors m3616copy5r9EGqc$default(ListItemColors listItemColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, int i, Object obj) {
        ListItemColors listItemColors2;
        long j10;
        if ((i & 1) != 0) {
            listItemColors2 = listItemColors;
            j10 = listItemColors2.containerColor;
        } else {
            listItemColors2 = listItemColors;
            j10 = j;
        }
        return listItemColors.m3628copy5r9EGqc(j10, (i & 2) != 0 ? listItemColors2.m3647getHeadlineColor0d7_KjU() : j2, (i & 4) != 0 ? listItemColors2.m3649getLeadingIconColor0d7_KjU() : j3, (i & 8) != 0 ? listItemColors2.getOverlineContentColor() : j4, (i & 16) != 0 ? listItemColors2.m3659getSupportingTextColor0d7_KjU() : j5, (i & 32) != 0 ? listItemColors2.m3661getTrailingIconColor0d7_KjU() : j6, (i & 64) != 0 ? listItemColors2.m3634getDisabledHeadlineColor0d7_KjU() : j7, (i & 128) != 0 ? listItemColors.m3636getDisabledLeadingIconColor0d7_KjU() : j8, (i & 256) != 0 ? listItemColors.m3640getDisabledTrailingIconColor0d7_KjU() : j9);
    }

    @Deprecated(message = "Use overload with parameters for selected and dragged colors")
    /* JADX INFO: renamed from: copy-5r9EGqc, reason: not valid java name */
    public final ListItemColors m3628copy5r9EGqc(long containerColor, long headlineColor, long leadingIconColor, long overlineColor, long supportingTextColor, long trailingIconColor, long disabledHeadlineColor, long disabledLeadingIconColor, long disabledTrailingIconColor) {
        ListItemColors listItemColors;
        long j;
        if (containerColor != 16) {
            listItemColors = this;
            j = containerColor;
        } else {
            listItemColors = this;
            j = listItemColors.containerColor;
        }
        return new ListItemColors(j, headlineColor != 16 ? headlineColor : listItemColors.m3647getHeadlineColor0d7_KjU(), leadingIconColor != 16 ? leadingIconColor : listItemColors.m3649getLeadingIconColor0d7_KjU(), overlineColor != 16 ? overlineColor : listItemColors.getOverlineContentColor(), supportingTextColor != 16 ? supportingTextColor : listItemColors.m3659getSupportingTextColor0d7_KjU(), trailingIconColor != 16 ? trailingIconColor : listItemColors.m3661getTrailingIconColor0d7_KjU(), disabledHeadlineColor != 16 ? disabledHeadlineColor : listItemColors.m3634getDisabledHeadlineColor0d7_KjU(), disabledLeadingIconColor != 16 ? disabledLeadingIconColor : listItemColors.m3636getDisabledLeadingIconColor0d7_KjU(), disabledTrailingIconColor != 16 ? disabledTrailingIconColor : listItemColors.m3640getDisabledTrailingIconColor0d7_KjU(), null);
    }
}
