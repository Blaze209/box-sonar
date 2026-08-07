package com.pspdfkit.annotations.actions;

import com.pspdfkit.internal.f4;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/pspdfkit/annotations/actions/ActionAccessors;", "", "<init>", "()V", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ActionAccessors {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0017\u001a\u00020\u00162\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00132\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\u00020&2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004¢\u0006\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/pspdfkit/annotations/actions/ActionAccessors$Companion;", "", "<init>", "()V", "", "Lcom/pspdfkit/internal/f4;", "annotationReferences", "", "shouldHide", "Lcom/pspdfkit/annotations/actions/Action;", "subActions", "Lcom/pspdfkit/annotations/actions/HideAction;", "createHideAction", "(Ljava/util/List;ZLjava/util/List;)Lcom/pspdfkit/annotations/actions/HideAction;", "hideAction", "getAnnotationReferences", "(Lcom/pspdfkit/annotations/actions/HideAction;)Ljava/util/List;", "", "pdfPath", "", "pageIndex", "newWindow", "Lcom/pspdfkit/annotations/actions/GoToEmbeddedAction;", "createGoToEmbeddedAction", "(Ljava/lang/String;IZLjava/util/List;)Lcom/pspdfkit/annotations/actions/GoToEmbeddedAction;", "Lcom/pspdfkit/annotations/actions/RenditionAction$RenditionActionType;", "renditionActionType", "screenAnnotationObjectNumber", JavascriptRunner.JAVA_SCRIPT_TYPE, "Lcom/pspdfkit/annotations/actions/RenditionAction;", "createRenditionAction", "(Lcom/pspdfkit/annotations/actions/RenditionAction$RenditionActionType;ILjava/lang/String;Ljava/util/List;)Lcom/pspdfkit/annotations/actions/RenditionAction;", "Lcom/pspdfkit/annotations/actions/RichMediaExecuteAction$RichMediaExecuteActionType;", "actionType", "richMediaAnnotationObjectNumber", "Lcom/pspdfkit/annotations/actions/RichMediaExecuteAction;", "createRichMediaExecuteAction", "(Lcom/pspdfkit/annotations/actions/RichMediaExecuteAction$RichMediaExecuteActionType;ILjava/util/List;)Lcom/pspdfkit/annotations/actions/RichMediaExecuteAction;", "Lcom/pspdfkit/annotations/actions/ImportDataAction;", "createImportDataAction", "(Ljava/util/List;)Lcom/pspdfkit/annotations/actions/ImportDataAction;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GoToEmbeddedAction createGoToEmbeddedAction(String pdfPath, int pageIndex, boolean newWindow, List<? extends Action> subActions) {
            if (subActions == null) {
                subActions = CollectionsKt.emptyList();
            }
            return new GoToEmbeddedAction(pdfPath, pageIndex, newWindow, subActions, null, 16, null);
        }

        public final HideAction createHideAction(List<f4> annotationReferences, boolean shouldHide, List<? extends Action> subActions) {
            annotationReferences.getClass();
            if (subActions == null) {
                subActions = CollectionsKt.emptyList();
            }
            return new HideAction(annotationReferences, shouldHide, subActions);
        }

        public final ImportDataAction createImportDataAction(List<? extends Action> subActions) {
            if (subActions == null) {
                subActions = CollectionsKt.emptyList();
            }
            return new ImportDataAction(subActions);
        }

        public final RenditionAction createRenditionAction(RenditionAction.RenditionActionType renditionActionType, int screenAnnotationObjectNumber, String javascript, List<? extends Action> subActions) {
            renditionActionType.getClass();
            if (subActions == null) {
                subActions = CollectionsKt.emptyList();
            }
            return new RenditionAction(renditionActionType, screenAnnotationObjectNumber, javascript, subActions);
        }

        public final RichMediaExecuteAction createRichMediaExecuteAction(RichMediaExecuteAction.RichMediaExecuteActionType actionType, int richMediaAnnotationObjectNumber, List<? extends Action> subActions) {
            actionType.getClass();
            if (subActions == null) {
                subActions = CollectionsKt.emptyList();
            }
            return new RichMediaExecuteAction(actionType, richMediaAnnotationObjectNumber, subActions);
        }

        public final List<f4> getAnnotationReferences(HideAction hideAction) {
            hideAction.getClass();
            return hideAction.getAnnotationReferences();
        }

        private Companion() {
        }
    }
}
