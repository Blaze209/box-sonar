package com.pspdfkit.annotations.actions;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.document.DocumentActionListener;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/pspdfkit/annotations/actions/ActionResolver;", "", "executeAction", "", Analytics.Data.ACTION, "Lcom/pspdfkit/annotations/actions/Action;", "actionSender", "Lcom/pspdfkit/annotations/actions/ActionSender;", "addDocumentActionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pspdfkit/document/DocumentActionListener;", "removeDocumentActionListener", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface ActionResolver {
    void addDocumentActionListener(DocumentActionListener listener);

    void executeAction(Action action);

    void executeAction(Action action, ActionSender actionSender);

    void removeDocumentActionListener(DocumentActionListener listener);
}
