package sdk.pendo.io.actions.guides;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.ActivationManager;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/actions/guides/GuideContextSwitchRules;", "", "()V", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GuideContextSwitchRules {
    private static final ArrayList<ActivationManager.ActivationEvents> anyGuideCanBeInterruptedBy;
    private static final ArrayList<ActivationManager.ActivationEvents> clickEventGuideCanBeInterruptedBy;
    private static final ArrayList<ActivationManager.ActivationEvents> pageViewGuideCanBeInterruptedBy;
    private static final ArrayList<ActivationManager.ActivationEvents> previewGuideCanBeInterruptedBy;
    private static final ArrayList<ActivationManager.ActivationEvents> trackEventGuideCanBeInterruptedBy;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ArrayList<ActivationManager.ActivationEvents> appLaunchGuideCanBeInterruptedBy = new ArrayList<>();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/actions/guides/GuideContextSwitchRules$Companion;", "", "()V", "anyGuideCanBeInterruptedBy", "Ljava/util/ArrayList;", "Lsdk/pendo/io/actions/ActivationManager$ActivationEvents;", "Lkotlin/collections/ArrayList;", "appLaunchGuideCanBeInterruptedBy", "clickEventGuideCanBeInterruptedBy", "pageViewGuideCanBeInterruptedBy", "previewGuideCanBeInterruptedBy", "trackEventGuideCanBeInterruptedBy", "getInterruptionList", "event", "shouldInterruptCurrentGuide", "", "currentGuideActivationEvent", "newGuideActivationEvent", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ActivationManager.ActivationEvents.values().length];
                try {
                    iArr[ActivationManager.ActivationEvents.APP_LAUNCH.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ActivationManager.ActivationEvents.VIEW.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ActivationManager.ActivationEvents.CLICK.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ActivationManager.ActivationEvents.PREVIEW.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ActivationManager.ActivationEvents.TRACK_EVENT.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ActivationManager.ActivationEvents.ANY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ArrayList<ActivationManager.ActivationEvents> getInterruptionList(ActivationManager.ActivationEvents event) {
            switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
                case 1:
                    return GuideContextSwitchRules.appLaunchGuideCanBeInterruptedBy;
                case 2:
                    return GuideContextSwitchRules.pageViewGuideCanBeInterruptedBy;
                case 3:
                    return GuideContextSwitchRules.clickEventGuideCanBeInterruptedBy;
                case 4:
                    return GuideContextSwitchRules.previewGuideCanBeInterruptedBy;
                case 5:
                    return GuideContextSwitchRules.trackEventGuideCanBeInterruptedBy;
                case 6:
                    return GuideContextSwitchRules.anyGuideCanBeInterruptedBy;
                default:
                    return new ArrayList<>();
            }
        }

        public final boolean shouldInterruptCurrentGuide(ActivationManager.ActivationEvents currentGuideActivationEvent, ActivationManager.ActivationEvents newGuideActivationEvent) {
            Intrinsics.checkNotNullParameter(currentGuideActivationEvent, "currentGuideActivationEvent");
            Intrinsics.checkNotNullParameter(newGuideActivationEvent, "newGuideActivationEvent");
            return getInterruptionList(currentGuideActivationEvent).contains(newGuideActivationEvent);
        }
    }

    static {
        ActivationManager.ActivationEvents activationEvents = ActivationManager.ActivationEvents.VIEW;
        pageViewGuideCanBeInterruptedBy = CollectionsKt.arrayListOf(activationEvents);
        ActivationManager.ActivationEvents activationEvents2 = ActivationManager.ActivationEvents.CLICK;
        trackEventGuideCanBeInterruptedBy = CollectionsKt.arrayListOf(activationEvents, activationEvents2);
        clickEventGuideCanBeInterruptedBy = CollectionsKt.arrayListOf(activationEvents, activationEvents2);
        previewGuideCanBeInterruptedBy = CollectionsKt.arrayListOf(activationEvents);
        anyGuideCanBeInterruptedBy = new ArrayList<>();
    }
}
