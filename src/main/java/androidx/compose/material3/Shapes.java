package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Shapes.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001BY\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fB;\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\rJX\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007J8\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u000fR\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u000fR\"\u0010#\u001a\u0004\u0018\u00010$X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010*\u001a\u0004\u0018\u00010+X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u00107\u001a\u0004\u0018\u000108X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u0015\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u0004\u0018\u00010?X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b@\u0010\u0015\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010E\u001a\u0004\u0018\u00010FX\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bG\u0010\u0015\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u0004\u0018\u00010MX\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010\u0015\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010S\u001a\u0004\u0018\u00010MX\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bT\u0010\u0015\u001a\u0004\bU\u0010P\"\u0004\bV\u0010RR\"\u0010W\u001a\u0004\u0018\u00010MX\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bX\u0010\u0015\u001a\u0004\bY\u0010P\"\u0004\bZ\u0010RR\"\u0010[\u001a\u0004\u0018\u00010MX\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\\\u0010\u0015\u001a\u0004\b]\u0010P\"\u0004\b^\u0010RR\"\u0010_\u001a\u0004\u0018\u00010`X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\ba\u0010\u0015\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010f\u001a\u0004\u0018\u00010`X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bg\u0010\u0015\u001a\u0004\bh\u0010c\"\u0004\bi\u0010eR\"\u0010j\u001a\u0004\u0018\u00010`X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bk\u0010\u0015\u001a\u0004\bl\u0010c\"\u0004\bm\u0010eR\"\u0010n\u001a\u0004\u0018\u00010`X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bo\u0010\u0015\u001a\u0004\bp\u0010c\"\u0004\bq\u0010e¨\u0006r"}, d2 = {"Landroidx/compose/material3/Shapes;", "", "extraSmall", "Landroidx/compose/foundation/shape/CornerBasedShape;", BoxRequestsFile.DownloadAvatar.SMALL, FirebaseAnalytics.Param.MEDIUM, BoxRequestsFile.DownloadAvatar.LARGE, "extraLarge", "largeIncreased", "extraLargeIncreased", "extraExtraLarge", "<init>", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getExtraSmall", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getSmall", "getMedium", "getLarge", "getExtraLarge", "getLargeIncreased$annotations", "()V", "getLargeIncreased", "getExtraLargeIncreased$annotations", "getExtraLargeIncreased", "getExtraExtraLarge$annotations", "getExtraExtraLarge", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "defaultButtonShapesCached", "Landroidx/compose/material3/ButtonShapes;", "getDefaultButtonShapesCached$material3$annotations", "getDefaultButtonShapesCached$material3", "()Landroidx/compose/material3/ButtonShapes;", "setDefaultButtonShapesCached$material3", "(Landroidx/compose/material3/ButtonShapes;)V", "defaultToggleButtonShapesCached", "Landroidx/compose/material3/ToggleButtonShapes;", "getDefaultToggleButtonShapesCached$material3$annotations", "getDefaultToggleButtonShapesCached$material3", "()Landroidx/compose/material3/ToggleButtonShapes;", "setDefaultToggleButtonShapesCached$material3", "(Landroidx/compose/material3/ToggleButtonShapes;)V", "defaultVerticalDragHandleShapesCached", "Landroidx/compose/material3/DragHandleShapes;", "getDefaultVerticalDragHandleShapesCached$material3", "()Landroidx/compose/material3/DragHandleShapes;", "setDefaultVerticalDragHandleShapesCached$material3", "(Landroidx/compose/material3/DragHandleShapes;)V", "defaultIconToggleButtonShapesCached", "Landroidx/compose/material3/IconToggleButtonShapes;", "getDefaultIconToggleButtonShapesCached$material3$annotations", "getDefaultIconToggleButtonShapesCached$material3", "()Landroidx/compose/material3/IconToggleButtonShapes;", "setDefaultIconToggleButtonShapesCached$material3", "(Landroidx/compose/material3/IconToggleButtonShapes;)V", "defaultIconButtonShapesCached", "Landroidx/compose/material3/IconButtonShapes;", "getDefaultIconButtonShapesCached$material3$annotations", "getDefaultIconButtonShapesCached$material3", "()Landroidx/compose/material3/IconButtonShapes;", "setDefaultIconButtonShapesCached$material3", "(Landroidx/compose/material3/IconButtonShapes;)V", "defaultListItemShapesCached", "Landroidx/compose/material3/ListItemShapes;", "getDefaultListItemShapesCached$material3$annotations", "getDefaultListItemShapesCached$material3", "()Landroidx/compose/material3/ListItemShapes;", "setDefaultListItemShapesCached$material3", "(Landroidx/compose/material3/ListItemShapes;)V", "defaultMenuStandaloneItemShapesCached", "Landroidx/compose/material3/MenuItemShapes;", "getDefaultMenuStandaloneItemShapesCached$material3$annotations", "getDefaultMenuStandaloneItemShapesCached$material3", "()Landroidx/compose/material3/MenuItemShapes;", "setDefaultMenuStandaloneItemShapesCached$material3", "(Landroidx/compose/material3/MenuItemShapes;)V", "defaultMenuLeadingItemShapesCached", "getDefaultMenuLeadingItemShapesCached$material3$annotations", "getDefaultMenuLeadingItemShapesCached$material3", "setDefaultMenuLeadingItemShapesCached$material3", "defaultMenuMiddleItemShapesCached", "getDefaultMenuMiddleItemShapesCached$material3$annotations", "getDefaultMenuMiddleItemShapesCached$material3", "setDefaultMenuMiddleItemShapesCached$material3", "defaultMenuTrailingItemShapesCached", "getDefaultMenuTrailingItemShapesCached$material3$annotations", "getDefaultMenuTrailingItemShapesCached$material3", "setDefaultMenuTrailingItemShapesCached$material3", "defaultMenuStandaloneGroupShapesCached", "Landroidx/compose/material3/MenuGroupShapes;", "getDefaultMenuStandaloneGroupShapesCached$material3$annotations", "getDefaultMenuStandaloneGroupShapesCached$material3", "()Landroidx/compose/material3/MenuGroupShapes;", "setDefaultMenuStandaloneGroupShapesCached$material3", "(Landroidx/compose/material3/MenuGroupShapes;)V", "defaultMenuLeadingGroupShapesCached", "getDefaultMenuLeadingGroupShapesCached$material3$annotations", "getDefaultMenuLeadingGroupShapesCached$material3", "setDefaultMenuLeadingGroupShapesCached$material3", "defaultMenuMiddleGroupShapesCached", "getDefaultMenuMiddleGroupShapesCached$material3$annotations", "getDefaultMenuMiddleGroupShapesCached$material3", "setDefaultMenuMiddleGroupShapesCached$material3", "defaultMenuTrailingGroupShapesCached", "getDefaultMenuTrailingGroupShapesCached$material3$annotations", "getDefaultMenuTrailingGroupShapesCached$material3", "setDefaultMenuTrailingGroupShapesCached$material3", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Shapes {
    public static final int $stable = 0;
    private ButtonShapes defaultButtonShapesCached;
    private IconButtonShapes defaultIconButtonShapesCached;
    private IconToggleButtonShapes defaultIconToggleButtonShapesCached;
    private ListItemShapes defaultListItemShapesCached;
    private MenuGroupShapes defaultMenuLeadingGroupShapesCached;
    private MenuItemShapes defaultMenuLeadingItemShapesCached;
    private MenuGroupShapes defaultMenuMiddleGroupShapesCached;
    private MenuItemShapes defaultMenuMiddleItemShapesCached;
    private MenuGroupShapes defaultMenuStandaloneGroupShapesCached;
    private MenuItemShapes defaultMenuStandaloneItemShapesCached;
    private MenuGroupShapes defaultMenuTrailingGroupShapesCached;
    private MenuItemShapes defaultMenuTrailingItemShapesCached;
    private ToggleButtonShapes defaultToggleButtonShapesCached;
    private DragHandleShapes defaultVerticalDragHandleShapesCached;
    private final CornerBasedShape extraExtraLarge;
    private final CornerBasedShape extraLarge;
    private final CornerBasedShape extraLargeIncreased;
    private final CornerBasedShape extraSmall;
    private final CornerBasedShape large;
    private final CornerBasedShape largeIncreased;
    private final CornerBasedShape medium;
    private final CornerBasedShape small;

    public Shapes() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ void getDefaultButtonShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultIconButtonShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultIconToggleButtonShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultListItemShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultMenuLeadingGroupShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultMenuLeadingItemShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultMenuMiddleGroupShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultMenuMiddleItemShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultMenuStandaloneGroupShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultMenuStandaloneItemShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultMenuTrailingGroupShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultMenuTrailingItemShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getDefaultToggleButtonShapesCached$material3$annotations() {
    }

    public static /* synthetic */ void getExtraExtraLarge$annotations() {
    }

    public static /* synthetic */ void getExtraLargeIncreased$annotations() {
    }

    public static /* synthetic */ void getLargeIncreased$annotations() {
    }

    public Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, CornerBasedShape cornerBasedShape6, CornerBasedShape cornerBasedShape7, CornerBasedShape cornerBasedShape8) {
        this.extraSmall = cornerBasedShape;
        this.small = cornerBasedShape2;
        this.medium = cornerBasedShape3;
        this.large = cornerBasedShape4;
        this.extraLarge = cornerBasedShape5;
        this.largeIncreased = cornerBasedShape6;
        this.extraLargeIncreased = cornerBasedShape7;
        this.extraExtraLarge = cornerBasedShape8;
    }

    public /* synthetic */ Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, CornerBasedShape cornerBasedShape6, CornerBasedShape cornerBasedShape7, CornerBasedShape cornerBasedShape8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ShapeDefaults.INSTANCE.getExtraSmall() : cornerBasedShape, (i & 2) != 0 ? ShapeDefaults.INSTANCE.getSmall() : cornerBasedShape2, (i & 4) != 0 ? ShapeDefaults.INSTANCE.getMedium() : cornerBasedShape3, (i & 8) != 0 ? ShapeDefaults.INSTANCE.getLarge() : cornerBasedShape4, (i & 16) != 0 ? ShapeDefaults.INSTANCE.getExtraLarge() : cornerBasedShape5, (i & 32) != 0 ? ShapeDefaults.INSTANCE.getLargeIncreased() : cornerBasedShape6, (i & 64) != 0 ? ShapeDefaults.INSTANCE.getExtraLargeIncreased() : cornerBasedShape7, (i & 128) != 0 ? ShapeDefaults.INSTANCE.getExtraExtraLarge() : cornerBasedShape8);
    }

    public final CornerBasedShape getExtraSmall() {
        return this.extraSmall;
    }

    public final CornerBasedShape getSmall() {
        return this.small;
    }

    public final CornerBasedShape getMedium() {
        return this.medium;
    }

    public final CornerBasedShape getLarge() {
        return this.large;
    }

    public final CornerBasedShape getExtraLarge() {
        return this.extraLarge;
    }

    public final CornerBasedShape getLargeIncreased() {
        return this.largeIncreased;
    }

    public final CornerBasedShape getExtraLargeIncreased() {
        return this.extraLargeIncreased;
    }

    public final CornerBasedShape getExtraExtraLarge() {
        return this.extraExtraLarge;
    }

    public /* synthetic */ Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ShapeDefaults.INSTANCE.getExtraSmall() : cornerBasedShape, (i & 2) != 0 ? ShapeDefaults.INSTANCE.getSmall() : cornerBasedShape2, (i & 4) != 0 ? ShapeDefaults.INSTANCE.getMedium() : cornerBasedShape3, (i & 8) != 0 ? ShapeDefaults.INSTANCE.getLarge() : cornerBasedShape4, (i & 16) != 0 ? ShapeDefaults.INSTANCE.getExtraLarge() : cornerBasedShape5);
    }

    public Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5) {
        this(cornerBasedShape, cornerBasedShape2, cornerBasedShape3, cornerBasedShape4, cornerBasedShape5, ShapeDefaults.INSTANCE.getLargeIncreased(), ShapeDefaults.INSTANCE.getExtraLargeIncreased(), ShapeDefaults.INSTANCE.getExtraExtraLarge());
    }

    public static /* synthetic */ Shapes copy$default(Shapes shapes, CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, CornerBasedShape cornerBasedShape6, CornerBasedShape cornerBasedShape7, CornerBasedShape cornerBasedShape8, int i, Object obj) {
        if ((i & 1) != 0) {
            cornerBasedShape = shapes.extraSmall;
        }
        if ((i & 2) != 0) {
            cornerBasedShape2 = shapes.small;
        }
        if ((i & 4) != 0) {
            cornerBasedShape3 = shapes.medium;
        }
        if ((i & 8) != 0) {
            cornerBasedShape4 = shapes.large;
        }
        if ((i & 16) != 0) {
            cornerBasedShape5 = shapes.extraLarge;
        }
        if ((i & 32) != 0) {
            cornerBasedShape6 = shapes.largeIncreased;
        }
        if ((i & 64) != 0) {
            cornerBasedShape7 = shapes.extraLargeIncreased;
        }
        if ((i & 128) != 0) {
            cornerBasedShape8 = shapes.extraExtraLarge;
        }
        CornerBasedShape cornerBasedShape9 = cornerBasedShape7;
        CornerBasedShape cornerBasedShape10 = cornerBasedShape8;
        CornerBasedShape cornerBasedShape11 = cornerBasedShape5;
        CornerBasedShape cornerBasedShape12 = cornerBasedShape6;
        return shapes.copy(cornerBasedShape, cornerBasedShape2, cornerBasedShape3, cornerBasedShape4, cornerBasedShape11, cornerBasedShape12, cornerBasedShape9, cornerBasedShape10);
    }

    public final Shapes copy(CornerBasedShape extraSmall, CornerBasedShape small, CornerBasedShape medium, CornerBasedShape large, CornerBasedShape extraLarge, CornerBasedShape largeIncreased, CornerBasedShape extraLargeIncreased, CornerBasedShape extraExtraLarge) {
        return new Shapes(extraSmall, small, medium, large, extraLarge, largeIncreased, extraLargeIncreased, extraExtraLarge);
    }

    public static /* synthetic */ Shapes copy$default(Shapes shapes, CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, int i, Object obj) {
        if ((i & 1) != 0) {
            cornerBasedShape = shapes.extraSmall;
        }
        if ((i & 2) != 0) {
            cornerBasedShape2 = shapes.small;
        }
        if ((i & 4) != 0) {
            cornerBasedShape3 = shapes.medium;
        }
        if ((i & 8) != 0) {
            cornerBasedShape4 = shapes.large;
        }
        if ((i & 16) != 0) {
            cornerBasedShape5 = shapes.extraLarge;
        }
        CornerBasedShape cornerBasedShape6 = cornerBasedShape5;
        CornerBasedShape cornerBasedShape7 = cornerBasedShape3;
        return shapes.copy(cornerBasedShape, cornerBasedShape2, cornerBasedShape7, cornerBasedShape4, cornerBasedShape6);
    }

    public final Shapes copy(CornerBasedShape extraSmall, CornerBasedShape small, CornerBasedShape medium, CornerBasedShape large, CornerBasedShape extraLarge) {
        return new Shapes(extraSmall, small, medium, large, extraLarge);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Shapes)) {
            return false;
        }
        Shapes shapes = (Shapes) other;
        return Intrinsics.areEqual(this.extraSmall, shapes.extraSmall) && Intrinsics.areEqual(this.small, shapes.small) && Intrinsics.areEqual(this.medium, shapes.medium) && Intrinsics.areEqual(this.large, shapes.large) && Intrinsics.areEqual(this.extraLarge, shapes.extraLarge) && Intrinsics.areEqual(this.largeIncreased, shapes.largeIncreased) && Intrinsics.areEqual(this.extraLargeIncreased, shapes.extraLargeIncreased) && Intrinsics.areEqual(this.extraExtraLarge, shapes.extraExtraLarge);
    }

    public int hashCode() {
        return (((((((((((((this.extraSmall.hashCode() * 31) + this.small.hashCode()) * 31) + this.medium.hashCode()) * 31) + this.large.hashCode()) * 31) + this.extraLarge.hashCode()) * 31) + this.largeIncreased.hashCode()) * 31) + this.extraLargeIncreased.hashCode()) * 31) + this.extraExtraLarge.hashCode();
    }

    public String toString() {
        return "Shapes(extraSmall=" + this.extraSmall + ", small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ", largeIncreased=" + this.largeIncreased + ", extraLarge=" + this.extraLarge + ", extralargeIncreased=" + this.extraLargeIncreased + ", extraExtraLarge=" + this.extraExtraLarge + ')';
    }

    /* JADX INFO: renamed from: getDefaultButtonShapesCached$material3, reason: from getter */
    public final ButtonShapes getDefaultButtonShapesCached() {
        return this.defaultButtonShapesCached;
    }

    public final void setDefaultButtonShapesCached$material3(ButtonShapes buttonShapes) {
        this.defaultButtonShapesCached = buttonShapes;
    }

    /* JADX INFO: renamed from: getDefaultToggleButtonShapesCached$material3, reason: from getter */
    public final ToggleButtonShapes getDefaultToggleButtonShapesCached() {
        return this.defaultToggleButtonShapesCached;
    }

    public final void setDefaultToggleButtonShapesCached$material3(ToggleButtonShapes toggleButtonShapes) {
        this.defaultToggleButtonShapesCached = toggleButtonShapes;
    }

    /* JADX INFO: renamed from: getDefaultVerticalDragHandleShapesCached$material3, reason: from getter */
    public final DragHandleShapes getDefaultVerticalDragHandleShapesCached() {
        return this.defaultVerticalDragHandleShapesCached;
    }

    public final void setDefaultVerticalDragHandleShapesCached$material3(DragHandleShapes dragHandleShapes) {
        this.defaultVerticalDragHandleShapesCached = dragHandleShapes;
    }

    /* JADX INFO: renamed from: getDefaultIconToggleButtonShapesCached$material3, reason: from getter */
    public final IconToggleButtonShapes getDefaultIconToggleButtonShapesCached() {
        return this.defaultIconToggleButtonShapesCached;
    }

    public final void setDefaultIconToggleButtonShapesCached$material3(IconToggleButtonShapes iconToggleButtonShapes) {
        this.defaultIconToggleButtonShapesCached = iconToggleButtonShapes;
    }

    /* JADX INFO: renamed from: getDefaultIconButtonShapesCached$material3, reason: from getter */
    public final IconButtonShapes getDefaultIconButtonShapesCached() {
        return this.defaultIconButtonShapesCached;
    }

    public final void setDefaultIconButtonShapesCached$material3(IconButtonShapes iconButtonShapes) {
        this.defaultIconButtonShapesCached = iconButtonShapes;
    }

    /* JADX INFO: renamed from: getDefaultListItemShapesCached$material3, reason: from getter */
    public final ListItemShapes getDefaultListItemShapesCached() {
        return this.defaultListItemShapesCached;
    }

    public final void setDefaultListItemShapesCached$material3(ListItemShapes listItemShapes) {
        this.defaultListItemShapesCached = listItemShapes;
    }

    /* JADX INFO: renamed from: getDefaultMenuStandaloneItemShapesCached$material3, reason: from getter */
    public final MenuItemShapes getDefaultMenuStandaloneItemShapesCached() {
        return this.defaultMenuStandaloneItemShapesCached;
    }

    public final void setDefaultMenuStandaloneItemShapesCached$material3(MenuItemShapes menuItemShapes) {
        this.defaultMenuStandaloneItemShapesCached = menuItemShapes;
    }

    /* JADX INFO: renamed from: getDefaultMenuLeadingItemShapesCached$material3, reason: from getter */
    public final MenuItemShapes getDefaultMenuLeadingItemShapesCached() {
        return this.defaultMenuLeadingItemShapesCached;
    }

    public final void setDefaultMenuLeadingItemShapesCached$material3(MenuItemShapes menuItemShapes) {
        this.defaultMenuLeadingItemShapesCached = menuItemShapes;
    }

    /* JADX INFO: renamed from: getDefaultMenuMiddleItemShapesCached$material3, reason: from getter */
    public final MenuItemShapes getDefaultMenuMiddleItemShapesCached() {
        return this.defaultMenuMiddleItemShapesCached;
    }

    public final void setDefaultMenuMiddleItemShapesCached$material3(MenuItemShapes menuItemShapes) {
        this.defaultMenuMiddleItemShapesCached = menuItemShapes;
    }

    /* JADX INFO: renamed from: getDefaultMenuTrailingItemShapesCached$material3, reason: from getter */
    public final MenuItemShapes getDefaultMenuTrailingItemShapesCached() {
        return this.defaultMenuTrailingItemShapesCached;
    }

    public final void setDefaultMenuTrailingItemShapesCached$material3(MenuItemShapes menuItemShapes) {
        this.defaultMenuTrailingItemShapesCached = menuItemShapes;
    }

    /* JADX INFO: renamed from: getDefaultMenuStandaloneGroupShapesCached$material3, reason: from getter */
    public final MenuGroupShapes getDefaultMenuStandaloneGroupShapesCached() {
        return this.defaultMenuStandaloneGroupShapesCached;
    }

    public final void setDefaultMenuStandaloneGroupShapesCached$material3(MenuGroupShapes menuGroupShapes) {
        this.defaultMenuStandaloneGroupShapesCached = menuGroupShapes;
    }

    /* JADX INFO: renamed from: getDefaultMenuLeadingGroupShapesCached$material3, reason: from getter */
    public final MenuGroupShapes getDefaultMenuLeadingGroupShapesCached() {
        return this.defaultMenuLeadingGroupShapesCached;
    }

    public final void setDefaultMenuLeadingGroupShapesCached$material3(MenuGroupShapes menuGroupShapes) {
        this.defaultMenuLeadingGroupShapesCached = menuGroupShapes;
    }

    /* JADX INFO: renamed from: getDefaultMenuMiddleGroupShapesCached$material3, reason: from getter */
    public final MenuGroupShapes getDefaultMenuMiddleGroupShapesCached() {
        return this.defaultMenuMiddleGroupShapesCached;
    }

    public final void setDefaultMenuMiddleGroupShapesCached$material3(MenuGroupShapes menuGroupShapes) {
        this.defaultMenuMiddleGroupShapesCached = menuGroupShapes;
    }

    /* JADX INFO: renamed from: getDefaultMenuTrailingGroupShapesCached$material3, reason: from getter */
    public final MenuGroupShapes getDefaultMenuTrailingGroupShapesCached() {
        return this.defaultMenuTrailingGroupShapesCached;
    }

    public final void setDefaultMenuTrailingGroupShapesCached$material3(MenuGroupShapes menuGroupShapes) {
        this.defaultMenuTrailingGroupShapesCached = menuGroupShapes;
    }
}
