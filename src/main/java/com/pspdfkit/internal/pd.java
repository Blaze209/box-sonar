package com.pspdfkit.internal;

import android.content.Context;
import android.text.format.Formatter;
import androidx.core.os.ConfigurationCompat;
import com.pspdfkit.R;
import com.pspdfkit.document.DocumentSource;
import com.pspdfkit.internal.jni.NativeProcessorConfiguration;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;

/* JADX INFO: loaded from: classes3.dex */
public final class pd {
    public static final List<ld> a(Context context, lm lmVar) {
        String str;
        String str2;
        Locale locale;
        DateFormat dateTimeInstance;
        Locale locale2;
        DateFormat dateTimeInstance2;
        lmVar.getClass();
        String string = context.getString(R.string.pspdf__document_info_content);
        int i = R.drawable.pspdf__ic_outline;
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        listCreateListBuilder.add(new od(1, context.getString(R.string.pspdf__document_info_title), Objects.toString((String) lmVar.i.c.get(NativeProcessorConfiguration.METADATA_TITLE), ""), true));
        listCreateListBuilder.add(new od(2, context.getString(R.string.pspdf__document_info_author), Objects.toString((String) lmVar.i.c.get(NativeProcessorConfiguration.METADATA_AUTHOR), ""), true));
        listCreateListBuilder.add(new od(3, context.getString(R.string.pspdf__document_info_subject), Objects.toString((String) lmVar.i.c.get(NativeProcessorConfiguration.METADATA_SUBJECT), ""), true));
        listCreateListBuilder.add(new tt(context, lmVar.getPageBinding()));
        StringBuilder sb = new StringBuilder();
        List<String> keywords = lmVar.i.getKeywords();
        if (keywords == null) {
            keywords = CollectionsKt.emptyList();
        }
        Iterator<Integer> it = CollectionsKt.getIndices(keywords).iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            sb.append(keywords.get(iNextInt));
            if (iNextInt < keywords.size() - 1) {
                sb.append(", ");
            }
        }
        listCreateListBuilder.add(new od(4, context.getString(R.string.pspdf__document_info_keywords), sb.toString(), true));
        Unit unit = Unit.INSTANCE;
        ld ldVar = new ld(1, string, i, CollectionsKt.build(listCreateListBuilder));
        String string2 = context.getString(R.string.pspdf__document_info_changes);
        int i2 = R.drawable.pspdf__ic_info;
        List listCreateListBuilder2 = CollectionsKt.createListBuilder();
        String string3 = context.getString(R.string.pspdf__document_info_creation_date);
        Date creationDate = lmVar.i.getCreationDate();
        if (creationDate == null || (locale2 = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0)) == null || (dateTimeInstance2 = DateFormat.getDateTimeInstance(1, 3, locale2)) == null || (str = dateTimeInstance2.format(creationDate)) == null) {
            str = "";
        }
        listCreateListBuilder2.add(new od(7, string3, str, false));
        String string4 = context.getString(R.string.pspdf__document_info_mod_date);
        Date modificationDate = lmVar.i.getModificationDate();
        if (modificationDate == null || (locale = ConfigurationCompat.getLocales(context.getResources().getConfiguration()).get(0)) == null || (dateTimeInstance = DateFormat.getDateTimeInstance(1, 3, locale)) == null || (str2 = dateTimeInstance.format(modificationDate)) == null) {
            str2 = "";
        }
        listCreateListBuilder2.add(new od(8, string4, str2, false));
        listCreateListBuilder2.add(new od(5, context.getString(R.string.pspdf__document_info_content_creator), Objects.toString((String) lmVar.i.c.get(NativeProcessorConfiguration.METADATA_CREATOR), ""), false));
        listCreateListBuilder2.add(new od(6, context.getString(R.string.pspdf__document_info_producer), Objects.toString((String) lmVar.i.c.get(NativeProcessorConfiguration.METADATA_PRODUCER), ""), false));
        ld ldVar2 = new ld(2, string2, i2, CollectionsKt.build(listCreateListBuilder2));
        String string5 = context.getString(R.string.pspdf__size);
        int i3 = R.drawable.pspdf__ic_size;
        List listCreateListBuilder3 = CollectionsKt.createListBuilder();
        listCreateListBuilder3.add(new od(9, context.getString(R.string.pspdf__document_info_number_pf_pages), Objects.toString(Integer.valueOf(lmVar.s), ""), false));
        DocumentSource documentSource = lmVar.A.get(0);
        listCreateListBuilder3.add(new od(10, context.getString(R.string.pspdf__document_info_file_size), Objects.toString(Formatter.formatFileSize(context, documentSource.isFileSource() ? new File(documentSource.getFileUri().getPath()).length() : documentSource.getDataProvider().getSize()), ""), false));
        ld ldVar3 = new ld(3, string5, i3, CollectionsKt.build(listCreateListBuilder3));
        List listCreateListBuilder4 = CollectionsKt.createListBuilder();
        listCreateListBuilder4.add(ldVar);
        listCreateListBuilder4.add(ldVar2);
        listCreateListBuilder4.add(ldVar3);
        return CollectionsKt.build(listCreateListBuilder4);
    }
}
