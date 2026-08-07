package com.pspdfkit.internal;

import android.view.ViewGroup;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.special_mode.controller.ContentEditingController;
import com.pspdfkit.ui.special_mode.manager.ContentEditingManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class ma implements ContentEditingManager.OnContentEditingModeChangeListener {
    public final /* synthetic */ na a;

    public ma(na naVar) {
        this.a = naVar;
    }

    public static final Unit a(na naVar) {
        int i = naVar.d;
        naVar.a(naVar.b.getMainPageCreateTextBlockButton(), i);
        naVar.a(naVar.b.getSecondPageCreateTextBlockButton(), naVar.a.getSiblingPageIndex(i));
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingModeChangeListener
    public final void onEnterContentEditingMode(ContentEditingController contentEditingController) {
        ab contentEditingHandler;
        contentEditingController.getClass();
        na naVar = this.a;
        naVar.a.addDocumentListener(naVar);
        DocumentView documentViewA = this.a.a.getInternal().getViewCoordinator().a(false);
        if (documentViewA != null && (contentEditingHandler = documentViewA.getContentEditingHandler()) != null) {
            final na naVar2 = this.a;
            contentEditingHandler.n = new Function0() { // from class: com.pspdfkit.internal.ma$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ma.a(naVar2);
                }
            };
        }
        na naVar3 = this.a;
        int i = naVar3.d;
        naVar3.a(naVar3.b.getMainPageCreateTextBlockButton(), i);
        naVar3.a(naVar3.b.getSecondPageCreateTextBlockButton(), naVar3.a.getSiblingPageIndex(i));
        na naVar4 = this.a;
        naVar4.a(naVar4.a.getPageIndex());
        ViewGroup createTextBlockButtonsContainer = this.a.b.getCreateTextBlockButtonsContainer();
        if (createTextBlockButtonsContainer != null) {
            createTextBlockButtonsContainer.setVisibility(0);
        }
    }

    @Override // com.pspdfkit.ui.special_mode.manager.ContentEditingManager.OnContentEditingModeChangeListener
    public final void onExitContentEditingMode(ContentEditingController contentEditingController) {
        contentEditingController.getClass();
        na naVar = this.a;
        naVar.a.removeDocumentListener(naVar);
        ViewGroup createTextBlockButtonsContainer = this.a.b.getCreateTextBlockButtonsContainer();
        if (createTextBlockButtonsContainer != null) {
            createTextBlockButtonsContainer.setVisibility(4);
        }
    }
}
