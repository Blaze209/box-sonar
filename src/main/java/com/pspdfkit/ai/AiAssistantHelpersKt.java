package com.pspdfkit.ai;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.RectF;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.R;
import com.pspdfkit.configuration.rendering.PageRenderConfiguration;
import com.pspdfkit.datastructures.TextSelection;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.document.providers.DataProvidersHelperKt;
import com.pspdfkit.exceptions.InvalidPasswordException;
import com.pspdfkit.instant.client.InstantClient;
import com.pspdfkit.instant.client.InstantDocumentDescriptor;
import com.pspdfkit.internal.da;
import com.pspdfkit.internal.jni.NativeDocumentProvider;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.q10;
import com.pspdfkit.internal.s;
import com.pspdfkit.ui.DocumentDescriptor;
import com.pspdfkit.utils.PdfLog;
import io.nutrient.data.models.AiAssistantConfiguration;
import io.nutrient.data.models.DocumentIdentifiers;
import io.nutrient.domain.ai.AiAssistant;
import io.nutrient.domain.ai.AiAssistantKt;
import io.nutrient.domain.ai.AiAssistantNavigationListener;
import io.nutrient.domain.ai.AiAssistantProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.HexExtensionsKt;
import kotlin.text.HexFormat;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a,\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001aF\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0004\u0012\u00020\u00010\u0016\u001aN\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\u0018\u0010\u0015\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0004\u0012\u00020\u00010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"LOG_TAG", "", "showAiAssistant", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "textSelection", "Lcom/pspdfkit/datastructures/TextSelection;", "internalShowAiAssistant", "aiAssistant", "Lio/nutrient/domain/ai/AiAssistant;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/nutrient/domain/ai/AiAssistantNavigationListener;", "createAiAssistant", "context", "Landroid/content/Context;", "documentsDescriptors", "", "Lcom/pspdfkit/ui/DocumentDescriptor;", "serverUrl", "sessionId", "jwtToken", "Lkotlin/Function1;", "createAiAssistantForInstant", "instantServerUrl", "documentLayerJwts", "aiAssistantServerUrl", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AiAssistantHelpersKt {
    private static final String LOG_TAG = "AiAssistantHelpers";

    public static final AiAssistant createAiAssistant(Context context, List<? extends DocumentDescriptor> list, String str, String str2, Function1<? super List<String>, String> function1) {
        byte[] permanentFileId;
        DocumentSource documentSource;
        byte[] permanentId;
        context.getClass();
        list.getClass();
        str.getClass();
        str2.getClass();
        function1.getClass();
        int i = 0;
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((DocumentDescriptor) it.next()).getDocumentSources().size() > 1) {
                    PdfLog.w(LOG_TAG, "AI Assistant does not support compound documents. Provide one DocumentDescriptor per DocumentSource.", new Object[0]);
                    throw new IllegalArgumentException("AI Assistant does not support compound documents. Provide one DocumentDescriptor per DocumentSource.");
                }
            }
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (DocumentDescriptor documentDescriptor : list) {
            PdfDocument document = documentDescriptor.getDocument();
            String hexString$default = null;
            if (document == null || (permanentId = document.getPermanentId()) == null || (hexString$default = HexExtensionsKt.toHexString$default(permanentId, (HexFormat) null, 1, (Object) null)) == null) {
                try {
                    PageRenderConfiguration pageRenderConfiguration = lm.Q;
                    List<DocumentSource> documentSources = documentDescriptor.getDocumentSources();
                    documentSources.getClass();
                    ArrayList<NativeDocumentProvider> documentProviders = lm.b.a(documentSources).getDocumentProviders();
                    documentProviders.getClass();
                    NativeDocumentProvider nativeDocumentProvider = (NativeDocumentProvider) CollectionsKt.firstOrNull((List) documentProviders);
                    if (nativeDocumentProvider != null && (permanentFileId = nativeDocumentProvider.getPermanentFileId()) != null) {
                        hexString$default = HexExtensionsKt.toHexString$default(permanentFileId, (HexFormat) null, 1, (Object) null);
                    }
                    if (hexString$default == null) {
                        String hexString$default2 = "";
                        hexString$default = hexString$default2;
                    }
                } catch (InvalidPasswordException e) {
                    throw new IllegalStateException("AI Assistant requires an unlocked document when using password-protected PDFs. Either provide a loaded document descriptor, or include the password in DocumentSource.", e);
                }
            } else {
                hexString$default = hexString$default2;
            }
            PdfDocument document2 = documentDescriptor.getDocument();
            if (document2 == null || (documentSource = document2.getDocumentSource()) == null) {
                documentSource = documentDescriptor.getDocumentSource();
                documentSource.getClass();
            }
            arrayList.add(new DocumentIdentifiers(DataProvidersHelperKt.getDataProviderFromDocumentSource(documentSource), hexString$default, null, hexString$default, null));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            arrayList2.add(((DocumentIdentifiers) obj).getPermanentId());
        }
        return AiAssistantKt.standaloneAiAssistant(context, new AiAssistantConfiguration(str, function1.invoke(arrayList2), str2, null, 8, null), arrayList);
    }

    public static final AiAssistant createAiAssistantForInstant(Context context, String str, List<String> list, String str2, String str3, Function1<? super List<String>, String> function1) {
        context.getClass();
        str.getClass();
        list.getClass();
        str2.getClass();
        str3.getClass();
        function1.getClass();
        InstantClient instantClientCreate = InstantClient.create(context, str);
        instantClientCreate.getClass();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (String str4 : list) {
            InstantDocumentDescriptor instantDocumentDescriptorForJwt = instantClientCreate.getInstantDocumentDescriptorForJwt(str4);
            instantDocumentDescriptorForJwt.getClass();
            String documentId = instantDocumentDescriptorForJwt.getDocumentId();
            documentId.getClass();
            arrayList.add(documentId);
            DocumentSource documentSource = instantDocumentDescriptorForJwt.openDocument(str4).getDocumentSource();
            documentSource.getClass();
            DataProvider dataProviderFromDocumentSource = DataProvidersHelperKt.getDataProviderFromDocumentSource(documentSource);
            String documentId2 = instantDocumentDescriptorForJwt.getDocumentId();
            documentId2.getClass();
            arrayList2.add(new DocumentIdentifiers(dataProviderFromDocumentSource, documentId2, instantDocumentDescriptorForJwt.getSourcePdfSha(), null, instantDocumentDescriptorForJwt.getLayerName()));
        }
        return AiAssistantKt.standaloneAiAssistant(context, new AiAssistantConfiguration(str2, function1.invoke(arrayList), str3, null, 8, null), arrayList2);
    }

    public static final void internalShowAiAssistant(FragmentActivity fragmentActivity, TextSelection textSelection, AiAssistant aiAssistant, AiAssistantNavigationListener aiAssistantNavigationListener) {
        da daVarA;
        fragmentActivity.getClass();
        aiAssistantNavigationListener.getClass();
        synchronized (q10.class) {
            daVarA = q10.e;
        }
        if (daVarA == null) {
            daVarA = q10.a(fragmentActivity);
        }
        if (aiAssistant == null) {
            throw new IllegalArgumentException("AI Assistant is required to be not null, please make sure you override AiAssistantListener.createAiAssistant in your activity");
        }
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        supportFragmentManager.getClass();
        if (!daVarA.isConnectionAvailable()) {
            new AlertDialog.Builder(fragmentActivity).setTitle(R.string.pspdf__ai_assistant_unavailable_title).setMessage(R.string.pspdf__ai_assistant_unavailable_message).setPositiveButton(fragmentActivity.getString(R.string.pspdf__ok), new DialogInterface.OnClickListener() { // from class: com.pspdfkit.ai.AiAssistantHelpersKt$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AiAssistantHelpersKt.internalShowAiAssistant$lambda$2(dialogInterface, i);
                }
            }).setCancelable(true).show();
            return;
        }
        int i = s.f;
        s sVar = null;
        String str = textSelection != null ? textSelection.text : null;
        s sVar2 = (s) supportFragmentManager.findFragmentByTag("com.pspdfkit.internal.ai.AiAssistantDialog.FRAGMENT_TAG");
        if (sVar2 != null) {
            sVar2.c = aiAssistantNavigationListener;
            sVar = sVar2;
        }
        if (sVar == null) {
            sVar = new s();
            sVar.c = aiAssistantNavigationListener;
        }
        sVar.d = aiAssistant;
        sVar.e = str;
        if (sVar.isAdded()) {
            return;
        }
        sVar.show(supportFragmentManager, "com.pspdfkit.internal.ai.AiAssistantDialog.FRAGMENT_TAG");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void internalShowAiAssistant$lambda$2(DialogInterface dialogInterface, int i) {
        dialogInterface.getClass();
        dialogInterface.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void showAiAssistant(FragmentActivity fragmentActivity, TextSelection textSelection) {
        fragmentActivity.getClass();
        final AiAssistantProvider aiAssistantProvider = fragmentActivity instanceof AiAssistantProvider ? (AiAssistantProvider) fragmentActivity : null;
        if (aiAssistantProvider == null) {
            throw new IllegalStateException("Please override AiAssistantListener.createAiAssistant in your Activity or Enable AI Assistant in the configuration");
        }
        internalShowAiAssistant(fragmentActivity, textSelection, aiAssistantProvider.getAiAssistant(), new AiAssistantNavigationListener() { // from class: com.pspdfkit.ai.AiAssistantHelpersKt.showAiAssistant.1
            @Override // io.nutrient.domain.ai.AiAssistantNavigationListener
            public void navigateTo(List<? extends RectF> documentRect, int pageIndex, int documentIndex) {
                documentRect.getClass();
                aiAssistantProvider.navigateTo(documentRect, pageIndex, documentIndex);
            }
        });
    }

    public static /* synthetic */ void showAiAssistant$default(FragmentActivity fragmentActivity, TextSelection textSelection, int i, Object obj) {
        if ((i & 2) != 0) {
            textSelection = null;
        }
        showAiAssistant(fragmentActivity, textSelection);
    }
}
