package expo.modules.ui.convertibles;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.types.Either;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: Arrangement.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0006\u001a\u001a\u0010\u0004\u001a\u00020\n*\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\u000b*\"\u0010\u0000\"\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\"\u0010\u0007\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0001¨\u0006\f"}, d2 = {"HorizontalArrangement", "Lexpo/modules/kotlin/types/Either;", "Lexpo/modules/ui/convertibles/HorizontalArrangementDefault;", "Lexpo/modules/ui/convertibles/HorizontalArrangementCustom;", "toComposeArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Lexpo/modules/ui/convertibles/HorizontalArrangement;", "VerticalArrangement", "Lexpo/modules/ui/convertibles/VerticalArrangementDefault;", "Lexpo/modules/ui/convertibles/VerticalArrangementCustom;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Lexpo/modules/ui/convertibles/VerticalArrangement;", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ArrangementKt {
    public static final Arrangement.Horizontal toComposeArrangement(Either<HorizontalArrangementDefault, HorizontalArrangementCustom> either) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        if (either.isFirstType(Reflection.getOrCreateKotlinClass(HorizontalArrangementDefault.class))) {
            return either.first().toComposeArrangement();
        }
        Integer spacedBy = either.second().getSpacedBy();
        if (spacedBy != null) {
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(spacedBy.intValue()));
            if (horizontalOrVerticalM1073spacedBy0680j_4 != null) {
                return horizontalOrVerticalM1073spacedBy0680j_4;
            }
        }
        return Arrangement.INSTANCE.getStart();
    }

    /* JADX INFO: renamed from: toComposeArrangement, reason: collision with other method in class */
    public static final Arrangement.Vertical m14684toComposeArrangement(Either<VerticalArrangementDefault, VerticalArrangementCustom> either) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        if (either.isFirstType(Reflection.getOrCreateKotlinClass(VerticalArrangementDefault.class))) {
            return either.first().toComposeArrangement();
        }
        Integer spacedBy = either.second().getSpacedBy();
        if (spacedBy != null) {
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(spacedBy.intValue()));
            if (horizontalOrVerticalM1073spacedBy0680j_4 != null) {
                return horizontalOrVerticalM1073spacedBy0680j_4;
            }
        }
        return Arrangement.INSTANCE.getTop();
    }
}
