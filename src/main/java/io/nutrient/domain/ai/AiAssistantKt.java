package io.nutrient.domain.ai;

import android.content.Context;
import com.pspdfkit.internal.x;
import io.nutrient.data.models.AiAssistantConfiguration;
import io.nutrient.data.models.DocumentIdentifiers;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"standaloneAiAssistant", "Lio/nutrient/domain/ai/AiAssistant;", "context", "Landroid/content/Context;", "aiAssistantConfiguration", "Lio/nutrient/data/models/AiAssistantConfiguration;", "listOfDocumentIdentifiers", "", "Lio/nutrient/data/models/DocumentIdentifiers;", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AiAssistantKt {
    public static final AiAssistant standaloneAiAssistant(Context context, AiAssistantConfiguration aiAssistantConfiguration, List<DocumentIdentifiers> list) {
        context.getClass();
        aiAssistantConfiguration.getClass();
        list.getClass();
        String packageName = context.getPackageName();
        packageName.getClass();
        return new x(packageName, aiAssistantConfiguration, list, Dispatchers.getIO());
    }
}
