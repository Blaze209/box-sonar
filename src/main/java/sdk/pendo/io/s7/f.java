package sdk.pendo.io.s7;

import external.sdk.pendo.io.yoyo.Techniques;
import sdk.pendo.io.actions.configurations.GuideTransition;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[GuideTransition.GuideTransitionDirection.values().length];
            c = iArr;
            try {
                iArr[GuideTransition.GuideTransitionDirection.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[GuideTransition.GuideTransitionDirection.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[GuideTransition.GuideTransitionDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[GuideTransition.GuideTransitionDirection.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[GuideTransition.GuideTransitionType.values().length];
            b = iArr2;
            try {
                iArr2[GuideTransition.GuideTransitionType.IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[GuideTransition.GuideTransitionType.REVERSE_IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[GuideTransition.GuideTransitionType.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[GuideTransition.GuideTransitionType.REVERSE_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[GuideTransition.GuideTransitionEffect.values().length];
            a = iArr3;
            try {
                iArr3[GuideTransition.GuideTransitionEffect.POP.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[GuideTransition.GuideTransitionEffect.FADE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[GuideTransition.GuideTransitionEffect.SLIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[GuideTransition.GuideTransitionEffect.LAND.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static Techniques a(GuideTransition guideTransition) {
        int i = a.a[guideTransition.getEffect().ordinal()];
        if (i == 1) {
            return d(guideTransition);
        }
        if (i == 2) {
            return b(guideTransition);
        }
        if (i != 3) {
            return i != 4 ? Techniques.FadeIn : c(guideTransition);
        }
        return e(guideTransition);
    }

    private static Techniques b(GuideTransition guideTransition) {
        int i = a.b[guideTransition.getType().ordinal()];
        if (i == 1 || i == 2) {
            return Techniques.FadeIn;
        }
        return (i == 3 || i == 4) ? Techniques.FadeOut : Techniques.FadeIn;
    }

    private static Techniques c(GuideTransition guideTransition) {
        int i = a.b[guideTransition.getType().ordinal()];
        if (i == 1 || i == 2) {
            return Techniques.Landing;
        }
        return (i == 3 || i == 4) ? Techniques.TakingOff : Techniques.FadeIn;
    }

    private static Techniques d(GuideTransition guideTransition) {
        int i = a.b[guideTransition.getType().ordinal()];
        if (i == 1 || i == 2) {
            return Techniques.BounceIn;
        }
        return (i == 3 || i == 4) ? Techniques.ZoomOut : Techniques.FadeIn;
    }

    private static Techniques e(GuideTransition guideTransition) {
        int i = a.c[guideTransition.getDirection().ordinal()];
        if (i == 1) {
            return i(guideTransition);
        }
        if (i == 2) {
            return f(guideTransition);
        }
        if (i != 3) {
            return i != 4 ? Techniques.FadeIn : g(guideTransition);
        }
        return h(guideTransition);
    }

    private static Techniques f(GuideTransition guideTransition) {
        return (guideTransition.getType().equals(GuideTransition.GuideTransitionType.IN) || guideTransition.getType().equals(GuideTransition.GuideTransitionType.REVERSE_IN)) ? Techniques.SlideInUp : Techniques.SlideOutDown;
    }

    private static Techniques g(GuideTransition guideTransition) {
        return (guideTransition.getType().equals(GuideTransition.GuideTransitionType.IN) || guideTransition.getType().equals(GuideTransition.GuideTransitionType.REVERSE_IN)) ? Techniques.SlideInRight : Techniques.SlideOutRight;
    }

    private static Techniques h(GuideTransition guideTransition) {
        return (guideTransition.getType().equals(GuideTransition.GuideTransitionType.IN) || guideTransition.getType().equals(GuideTransition.GuideTransitionType.REVERSE_IN)) ? Techniques.SlideInLeft : Techniques.SlideOutLeft;
    }

    private static Techniques i(GuideTransition guideTransition) {
        return (guideTransition.getType().equals(GuideTransition.GuideTransitionType.IN) || guideTransition.getType().equals(GuideTransition.GuideTransitionType.REVERSE_IN)) ? Techniques.SlideInDown : Techniques.SlideOutUp;
    }
}
