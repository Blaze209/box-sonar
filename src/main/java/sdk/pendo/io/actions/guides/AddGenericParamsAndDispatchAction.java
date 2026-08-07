package sdk.pendo.io.actions.guides;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommand;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.PendoCommandParameterInjector;
import sdk.pendo.io.actions.PendoCommandsEventBus;
import sdk.pendo.io.i6.a;
import sdk.pendo.io.models.GuideModel;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/actions/guides/AddGenericParamsAndDispatchAction;", "Lsdk/pendo/io/i6/a;", "", "execute", "Lsdk/pendo/io/models/GuideModel;", "guideModel", "Lsdk/pendo/io/models/GuideModel;", "", "analyticsActionEventType", "Ljava/lang/String;", "", "Lsdk/pendo/io/actions/PendoCommandsEventBus$Parameter;", "specificInjectionParameters", "Ljava/util/List;", "<init>", "(Lsdk/pendo/io/models/GuideModel;Ljava/lang/String;Ljava/util/List;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class AddGenericParamsAndDispatchAction extends a {
    private final String analyticsActionEventType;
    private final GuideModel guideModel;
    private final List<PendoCommandsEventBus.Parameter> specificInjectionParameters;

    public AddGenericParamsAndDispatchAction(GuideModel guideModel, String analyticsActionEventType, List<PendoCommandsEventBus.Parameter> specificInjectionParameters) {
        Intrinsics.checkNotNullParameter(guideModel, "guideModel");
        Intrinsics.checkNotNullParameter(analyticsActionEventType, "analyticsActionEventType");
        Intrinsics.checkNotNullParameter(specificInjectionParameters, "specificInjectionParameters");
        this.guideModel = guideModel;
        this.analyticsActionEventType = analyticsActionEventType;
        this.specificInjectionParameters = specificInjectionParameters;
    }

    @Override // sdk.pendo.io.i6.a
    public void execute() {
        List<PendoCommand> guideActions = GuidesManager.INSTANCE.getGuideActions();
        ArrayList arrayList = new ArrayList();
        PendoCommandEventType eventType = PendoCommandEventType.getEventType(this.analyticsActionEventType);
        for (PendoCommand pendoCommand : guideActions) {
            if (Intrinsics.areEqual(pendoCommand.getEventType().eventType, this.analyticsActionEventType)) {
                pendoCommand.setContext(PendoCommandParameterInjector.getInstance().generateCommandContext(this.guideModel, this.specificInjectionParameters, eventType));
                arrayList.add(pendoCommand);
            }
        }
        PendoCommandDispatcher.getInstance().dispatchCommands(arrayList, eventType, false);
    }
}
