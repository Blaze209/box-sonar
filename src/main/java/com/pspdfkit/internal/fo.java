package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import com.pspdfkit.R;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.forms.ChoiceFormElement;
import com.pspdfkit.forms.FormElement;
import com.pspdfkit.forms.FormType;
import com.pspdfkit.forms.TextFormElement;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class fo {
    public final boolean a;

    public static final class b extends fo {
        public static final List<String> f = CollectionsKt.listOf((Object[]) new String[]{"Form", "Check Box", "Combo Box", "List", "Text"});
        public final WidgetAnnotation b;
        public final FormElement c;
        public final String d;
        public final long e;

        public static final class a {

            /* JADX INFO: renamed from: com.pspdfkit.internal.fo$b$a$a, reason: collision with other inner class name */
            public static final /* synthetic */ class C0272a {
                public static final /* synthetic */ int[] a;

                static {
                    int[] iArr = new int[FormType.values().length];
                    try {
                        iArr[FormType.PUSHBUTTON.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[FormType.TEXT.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[FormType.SIGNATURE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[FormType.COMBOBOX.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    a = iArr;
                }
            }

            public static String a(Context context, FormElement formElement) {
                context.getClass();
                FormType type = formElement.getType();
                type.getClass();
                int i = C0272a.a[type.ordinal()];
                String strA = null;
                if (i == 1) {
                    strA = no.a(context, R.string.pspdf__form_type_button, null);
                } else if (i == 2) {
                    strA = no.a(context, R.string.pspdf__form_type_text_field, null);
                } else if (i == 3) {
                    strA = no.a(context, R.string.pspdf__form_type_signature_field, null);
                } else if (i == 4) {
                    strA = no.a(context, R.string.pspdf__form_type_choice_field, null);
                }
                String name = formElement.getName();
                name.getClass();
                if (name.length() <= 0) {
                    return strA;
                }
                Iterator it = CollectionsKt.plus((Collection<? extends String>) b.f, strA == null ? "" : strA).iterator();
                boolean zContains = false;
                while (it.hasNext() && !(zContains = StringsKt.contains((CharSequence) name, (CharSequence) it.next(), true))) {
                }
                return zContains ? name : strA + ": " + name;
            }
        }

        /* JADX INFO: renamed from: com.pspdfkit.internal.fo$b$b, reason: collision with other inner class name */
        public static final /* synthetic */ class C0273b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[FormType.values().length];
                try {
                    iArr[FormType.PUSHBUTTON.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FormType.TEXT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FormType.SIGNATURE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FormType.COMBOBOX.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
            }
        }

        public b(WidgetAnnotation widgetAnnotation, FormElement formElement, boolean z, String str) {
            super(z);
            this.b = widgetAnnotation;
            this.c = formElement;
            this.d = str;
            this.e = widgetAnnotation.getUuid().hashCode();
        }

        @Override // com.pspdfkit.internal.fo
        public final boolean a(PdfConfiguration pdfConfiguration, int i) {
            pdfConfiguration.getClass();
            return false;
        }

        @Override // com.pspdfkit.internal.fo
        public final boolean b(PdfConfiguration pdfConfiguration) {
            pdfConfiguration.getClass();
            return this.a;
        }

        @Override // com.pspdfkit.internal.fo
        public final int c() {
            return this.b.getPageIndex();
        }

        @Override // com.pspdfkit.internal.fo
        public final Annotation a() {
            return this.b;
        }

        @Override // com.pspdfkit.internal.fo
        public final String b(Context context) {
            context.getClass();
            String str = this.d;
            return str != null ? str : a.a(context, this.c);
        }

        @Override // com.pspdfkit.internal.fo
        public final Drawable a(Context context, int i) {
            int i2;
            context.getClass();
            FormType type = this.c.getType();
            type.getClass();
            int i3 = C0273b.a[type.ordinal()];
            if (i3 == 1) {
                i2 = R.drawable.pspdf__ic_form_button;
            } else if (i3 == 2) {
                i2 = R.drawable.pspdf__ic_form_textfield;
            } else if (i3 == 3) {
                i2 = R.drawable.pspdf__ic_form_signature;
            } else if (i3 != 4) {
                i2 = R.drawable.pspdf__ic_form_button;
            } else {
                i2 = R.drawable.pspdf__ic_form_choice;
            }
            Drawable drawable = AppCompatResources.getDrawable(context, i2);
            if (drawable == null) {
                return null;
            }
            drawable.mutate();
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            drawableWrap.getClass();
            DrawableCompat.setTint(drawableWrap, i);
            return drawableWrap;
        }

        @Override // com.pspdfkit.internal.fo
        public final long b() {
            return this.e;
        }

        @Override // com.pspdfkit.internal.fo
        public final boolean a(PdfConfiguration pdfConfiguration) {
            pdfConfiguration.getClass();
            FormElement formElement = this.c;
            return ((formElement instanceof ChoiceFormElement) || (formElement instanceof TextFormElement)) && !formElement.isReadOnly();
        }
    }

    public static final class c extends fo {
        public final int b;
        public final long c;

        public c(int i) {
            super(false);
            this.b = i;
            this.c = i;
        }

        @Override // com.pspdfkit.internal.fo
        public final String b(Context context) {
            context.getClass();
            String strA = no.a(context, R.string.pspdf__annotation_list_page, (View) null, Integer.valueOf(this.b + 1));
            strA.getClass();
            return strA;
        }

        @Override // com.pspdfkit.internal.fo
        public final int c() {
            return this.b;
        }

        @Override // com.pspdfkit.internal.fo
        public final long b() {
            return this.c;
        }
    }

    public fo(boolean z) {
        this.a = z;
    }

    public Annotation a() {
        return null;
    }

    public boolean a(PdfConfiguration pdfConfiguration, int i) {
        pdfConfiguration.getClass();
        return false;
    }

    public abstract long b();

    public boolean b(PdfConfiguration pdfConfiguration) {
        pdfConfiguration.getClass();
        return false;
    }

    public int c() {
        return -1;
    }

    public boolean a(PdfConfiguration pdfConfiguration) {
        pdfConfiguration.getClass();
        return false;
    }

    public String b(Context context) {
        context.getClass();
        return null;
    }

    public Drawable a(Context context, int i) {
        context.getClass();
        return null;
    }

    public String a(Context context) {
        context.getClass();
        return null;
    }

    public static final class a extends fo {
        public final Annotation b;
        public final String c;
        public final long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Annotation annotation, boolean z, String str) {
            super(z);
            annotation.getClass();
            this.b = annotation;
            this.c = str;
            this.d = annotation.getUuid().hashCode();
        }

        @Override // com.pspdfkit.internal.fo
        public final boolean a(PdfConfiguration pdfConfiguration) {
            pdfConfiguration.getClass();
            return (this.b.isLocked() || !ar.b().a(pdfConfiguration, this.b) || this.b.getType() == AnnotationType.WIDGET) ? false : true;
        }

        @Override // com.pspdfkit.internal.fo
        public final String b(Context context) {
            context.getClass();
            String str = this.c;
            if (str != null) {
                return str;
            }
            Annotation annotation = this.b;
            float f = ww.a;
            annotation.getClass();
            return ww.a(context, annotation, true);
        }

        @Override // com.pspdfkit.internal.fo
        public final int c() {
            return this.b.getPageIndex();
        }

        @Override // com.pspdfkit.internal.fo
        public final Annotation a() {
            return this.b;
        }

        @Override // com.pspdfkit.internal.fo
        public final String a(Context context) {
            String str;
            String str2;
            context.getClass();
            String creator = this.b.getCreator();
            Date modifiedDate = this.b.getModifiedDate();
            if (modifiedDate == null) {
                modifiedDate = this.b.getCreatedDate();
            }
            if (modifiedDate != null) {
                str2 = DateFormat.getMediumDateFormat(context).format(modifiedDate);
                str = DateFormat.getTimeFormat(context).format(modifiedDate);
            } else {
                str = null;
                str2 = null;
            }
            if (TextUtils.isEmpty(creator) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            String[] strArr = {creator, str2, str};
            Charset charset = u40.a;
            return u40.a(", ", Arrays.asList(strArr));
        }

        @Override // com.pspdfkit.internal.fo
        public final Drawable a(Context context, int i) {
            Integer numValueOf;
            int i2;
            Drawable drawable;
            int color;
            context.getClass();
            float f = ww.a;
            Annotation annotation = this.b;
            annotation.getClass();
            if (annotation.getInternal().isInstantCommentThreadRoot()) {
                numValueOf = Integer.valueOf(R.drawable.pspdf__ic_instant_comment);
            } else {
                switch (ww.a.a[annotation.getType().ordinal()]) {
                    case 1:
                        String iconName = ((NoteAnnotation) annotation).getIconName();
                        iconName.getClass();
                        Integer num = ww.l.get(iconName);
                        numValueOf = Integer.valueOf(num != null ? num.intValue() : ww.m);
                        break;
                    case 2:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_highlight);
                        break;
                    case 3:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_strikeout);
                        break;
                    case 4:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_underline);
                        break;
                    case 5:
                        if (((FreeTextAnnotation) annotation).getIntent() == FreeTextAnnotation.FreeTextAnnotationIntent.FREE_TEXT_CALLOUT) {
                            i2 = R.drawable.pspdf__ic_freetext_callout;
                        } else {
                            i2 = R.drawable.pspdf__ic_freetext;
                        }
                        numValueOf = Integer.valueOf(i2);
                        break;
                    case 6:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_squiggly);
                        break;
                    case 7:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_stylus);
                        break;
                    case 8:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_link);
                        break;
                    case 9:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_circle);
                        break;
                    case 10:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_line);
                        break;
                    case 11:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_stamp);
                        break;
                    case 12:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_caret);
                        break;
                    case 13:
                    case 14:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_richmedia);
                        break;
                    case 15:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_widget);
                        break;
                    case 16:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_file);
                        break;
                    case 17:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_square);
                        break;
                    case 18:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_sound);
                        break;
                    case 19:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_polygon);
                        break;
                    case 20:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_polyline);
                        break;
                    case 21:
                        numValueOf = Integer.valueOf(R.drawable.pspdf__ic_redaction);
                        break;
                    default:
                        numValueOf = null;
                        break;
                }
            }
            if (numValueOf == null || (drawable = AppCompatResources.getDrawable(context, numValueOf.intValue())) == null) {
                return null;
            }
            drawable.mutate();
            Annotation annotation2 = this.b;
            annotation2.getClass();
            if (annotation2.getType() == AnnotationType.STAMP) {
                color = a40.a((StampAnnotation) annotation2);
            } else {
                color = annotation2.getColor();
            }
            if (color != 0) {
                i = color;
            }
            Drawable drawableWrap = DrawableCompat.wrap(drawable);
            drawableWrap.getClass();
            DrawableCompat.setTint(drawableWrap, i);
            return drawableWrap;
        }

        @Override // com.pspdfkit.internal.fo
        public final long b() {
            return this.d;
        }

        @Override // com.pspdfkit.internal.fo
        public final boolean b(PdfConfiguration pdfConfiguration) {
            pdfConfiguration.getClass();
            return ar.b().a(pdfConfiguration, this.b) && this.a;
        }

        @Override // com.pspdfkit.internal.fo
        public final boolean a(PdfConfiguration pdfConfiguration, int i) {
            pdfConfiguration.getClass();
            return a(pdfConfiguration) && this.a && i >= 2;
        }
    }
}
