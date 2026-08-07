package com.pspdfkit.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.annotations.actions.Action;
import com.pspdfkit.annotations.actions.ActionResolver;
import com.pspdfkit.annotations.actions.ActionSender;
import com.pspdfkit.annotations.actions.ActionType;
import com.pspdfkit.document.DocumentActionListener;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.utils.PdfLog;
import java.util.EnumMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements ActionResolver {
    public final EnumMap a;
    public final go<DocumentActionListener> b;

    public i(PdfFragment pdfFragment, DocumentView documentView) {
        EnumMap enumMap = new EnumMap(ActionType.class);
        this.a = enumMap;
        this.b = new go<>();
        enumMap.put(ActionType.GOTO, new cj(pdfFragment));
        enumMap.put(ActionType.GOTO_EMBEDDED, new gj(pdfFragment));
        enumMap.put(ActionType.NAMED, new fr(pdfFragment));
        enumMap.put(ActionType.URI, new j70(documentView));
        enumMap.put(ActionType.RESET_FORM, new iz(documentView));
        enumMap.put(ActionType.HIDE, new nj(documentView));
        enumMap.put(ActionType.RENDITION, new ez(documentView));
        enumMap.put(ActionType.RICH_MEDIA_EXECUTE, new sz(documentView));
        enumMap.put(ActionType.JAVASCRIPT, new ym(documentView));
    }

    @Override // com.pspdfkit.annotations.actions.ActionResolver
    public final void addDocumentActionListener(DocumentActionListener documentActionListener) {
        uw.a(documentActionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.b.addFirst(documentActionListener);
    }

    @Override // com.pspdfkit.annotations.actions.ActionResolver
    public final void executeAction(Action action, ActionSender actionSender) {
        boolean z;
        uw.a(action, Analytics.Data.ACTION, null);
        PdfLog.d("Nutri.ActionResolverImp", "Execute action %s.", action.toString());
        Iterator<DocumentActionListener> it = this.b.iterator();
        loop0: while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                DocumentActionListener next = it.next();
                if (z || next.onExecuteAction(action)) {
                    z = true;
                }
            }
        }
        if (z) {
            return;
        }
        c cVar = (c) this.a.get(action.getType());
        if (cVar != null) {
            cVar.executeAction(action, actionSender);
        } else {
            PdfLog.w("Nutri.ActionResolverImp", "Unknown action " + action + " of type " + action.getType(), new Object[0]);
        }
        Iterator<Action> it2 = action.getSubActions().iterator();
        while (it2.hasNext()) {
            executeAction(it2.next(), actionSender);
        }
    }

    @Override // com.pspdfkit.annotations.actions.ActionResolver
    public final void removeDocumentActionListener(DocumentActionListener documentActionListener) {
        uw.a(documentActionListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.b.b(documentActionListener);
    }

    @Override // com.pspdfkit.annotations.actions.ActionResolver
    public final void executeAction(Action action) {
        executeAction(action, null);
    }
}
