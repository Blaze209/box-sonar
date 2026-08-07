package external.sdk.pendo.io.yoyo;

import external.sdk.pendo.io.yoyo.attention.BounceAnimator;
import external.sdk.pendo.io.yoyo.attention.FlashAnimator;
import external.sdk.pendo.io.yoyo.attention.PulseAnimator;
import external.sdk.pendo.io.yoyo.attention.RubberBandAnimator;
import external.sdk.pendo.io.yoyo.attention.ShakeAnimator;
import external.sdk.pendo.io.yoyo.attention.StandUpAnimator;
import external.sdk.pendo.io.yoyo.attention.SwingAnimator;
import external.sdk.pendo.io.yoyo.attention.TadaAnimator;
import external.sdk.pendo.io.yoyo.attention.WaveAnimator;
import external.sdk.pendo.io.yoyo.attention.WobbleAnimator;
import external.sdk.pendo.io.yoyo.bouncing_entrances.BounceInAnimator;
import external.sdk.pendo.io.yoyo.bouncing_entrances.BounceInDownAnimator;
import external.sdk.pendo.io.yoyo.bouncing_entrances.BounceInLeftAnimator;
import external.sdk.pendo.io.yoyo.bouncing_entrances.BounceInRightAnimator;
import external.sdk.pendo.io.yoyo.bouncing_entrances.BounceInUpAnimator;
import external.sdk.pendo.io.yoyo.fading_entrances.FadeInAnimator;
import external.sdk.pendo.io.yoyo.fading_entrances.FadeInDownAnimator;
import external.sdk.pendo.io.yoyo.fading_entrances.FadeInLeftAnimator;
import external.sdk.pendo.io.yoyo.fading_entrances.FadeInRightAnimator;
import external.sdk.pendo.io.yoyo.fading_entrances.FadeInUpAnimator;
import external.sdk.pendo.io.yoyo.fading_exits.FadeOutAnimator;
import external.sdk.pendo.io.yoyo.fading_exits.FadeOutDownAnimator;
import external.sdk.pendo.io.yoyo.fading_exits.FadeOutLeftAnimator;
import external.sdk.pendo.io.yoyo.fading_exits.FadeOutRightAnimator;
import external.sdk.pendo.io.yoyo.fading_exits.FadeOutUpAnimator;
import external.sdk.pendo.io.yoyo.flippers.FlipInXAnimator;
import external.sdk.pendo.io.yoyo.flippers.FlipInYAnimator;
import external.sdk.pendo.io.yoyo.flippers.FlipOutXAnimator;
import external.sdk.pendo.io.yoyo.flippers.FlipOutYAnimator;
import external.sdk.pendo.io.yoyo.rotating_entrances.RotateInAnimator;
import external.sdk.pendo.io.yoyo.rotating_entrances.RotateInDownLeftAnimator;
import external.sdk.pendo.io.yoyo.rotating_entrances.RotateInDownRightAnimator;
import external.sdk.pendo.io.yoyo.rotating_entrances.RotateInUpLeftAnimator;
import external.sdk.pendo.io.yoyo.rotating_entrances.RotateInUpRightAnimator;
import external.sdk.pendo.io.yoyo.rotating_exits.RotateOutAnimator;
import external.sdk.pendo.io.yoyo.rotating_exits.RotateOutDownLeftAnimator;
import external.sdk.pendo.io.yoyo.rotating_exits.RotateOutDownRightAnimator;
import external.sdk.pendo.io.yoyo.rotating_exits.RotateOutUpLeftAnimator;
import external.sdk.pendo.io.yoyo.rotating_exits.RotateOutUpRightAnimator;
import external.sdk.pendo.io.yoyo.sliders.SlideInDownAnimator;
import external.sdk.pendo.io.yoyo.sliders.SlideInLeftAnimator;
import external.sdk.pendo.io.yoyo.sliders.SlideInRightAnimator;
import external.sdk.pendo.io.yoyo.sliders.SlideInUpAnimator;
import external.sdk.pendo.io.yoyo.sliders.SlideOutDownAnimator;
import external.sdk.pendo.io.yoyo.sliders.SlideOutLeftAnimator;
import external.sdk.pendo.io.yoyo.sliders.SlideOutRightAnimator;
import external.sdk.pendo.io.yoyo.sliders.SlideOutUpAnimator;
import external.sdk.pendo.io.yoyo.specials.HingeAnimator;
import external.sdk.pendo.io.yoyo.specials.RollInAnimator;
import external.sdk.pendo.io.yoyo.specials.RollOutAnimator;
import external.sdk.pendo.io.yoyo.specials.in.DropOutAnimator;
import external.sdk.pendo.io.yoyo.specials.in.LandingAnimator;
import external.sdk.pendo.io.yoyo.specials.out.TakingOffAnimator;
import external.sdk.pendo.io.yoyo.zooming_entrances.ZoomInAnimator;
import external.sdk.pendo.io.yoyo.zooming_entrances.ZoomInDownAnimator;
import external.sdk.pendo.io.yoyo.zooming_entrances.ZoomInLeftAnimator;
import external.sdk.pendo.io.yoyo.zooming_entrances.ZoomInRightAnimator;
import external.sdk.pendo.io.yoyo.zooming_entrances.ZoomInUpAnimator;
import external.sdk.pendo.io.yoyo.zooming_exits.ZoomOutAnimator;
import external.sdk.pendo.io.yoyo.zooming_exits.ZoomOutDownAnimator;
import external.sdk.pendo.io.yoyo.zooming_exits.ZoomOutLeftAnimator;
import external.sdk.pendo.io.yoyo.zooming_exits.ZoomOutRightAnimator;
import external.sdk.pendo.io.yoyo.zooming_exits.ZoomOutUpAnimator;

/* JADX INFO: loaded from: classes4.dex */
public enum Techniques {
    DropOut(DropOutAnimator.class),
    Landing(LandingAnimator.class),
    TakingOff(TakingOffAnimator.class),
    Flash(FlashAnimator.class),
    Pulse(PulseAnimator.class),
    RubberBand(RubberBandAnimator.class),
    Shake(ShakeAnimator.class),
    Swing(SwingAnimator.class),
    Wobble(WobbleAnimator.class),
    Bounce(BounceAnimator.class),
    Tada(TadaAnimator.class),
    StandUp(StandUpAnimator.class),
    Wave(WaveAnimator.class),
    Hinge(HingeAnimator.class),
    RollIn(RollInAnimator.class),
    RollOut(RollOutAnimator.class),
    BounceIn(BounceInAnimator.class),
    BounceInDown(BounceInDownAnimator.class),
    BounceInLeft(BounceInLeftAnimator.class),
    BounceInRight(BounceInRightAnimator.class),
    BounceInUp(BounceInUpAnimator.class),
    FadeIn(FadeInAnimator.class),
    FadeInUp(FadeInUpAnimator.class),
    FadeInDown(FadeInDownAnimator.class),
    FadeInLeft(FadeInLeftAnimator.class),
    FadeInRight(FadeInRightAnimator.class),
    FadeOut(FadeOutAnimator.class),
    FadeOutDown(FadeOutDownAnimator.class),
    FadeOutLeft(FadeOutLeftAnimator.class),
    FadeOutRight(FadeOutRightAnimator.class),
    FadeOutUp(FadeOutUpAnimator.class),
    FlipInX(FlipInXAnimator.class),
    FlipOutX(FlipOutXAnimator.class),
    FlipInY(FlipInYAnimator.class),
    FlipOutY(FlipOutYAnimator.class),
    RotateIn(RotateInAnimator.class),
    RotateInDownLeft(RotateInDownLeftAnimator.class),
    RotateInDownRight(RotateInDownRightAnimator.class),
    RotateInUpLeft(RotateInUpLeftAnimator.class),
    RotateInUpRight(RotateInUpRightAnimator.class),
    RotateOut(RotateOutAnimator.class),
    RotateOutDownLeft(RotateOutDownLeftAnimator.class),
    RotateOutDownRight(RotateOutDownRightAnimator.class),
    RotateOutUpLeft(RotateOutUpLeftAnimator.class),
    RotateOutUpRight(RotateOutUpRightAnimator.class),
    SlideInLeft(SlideInLeftAnimator.class),
    SlideInRight(SlideInRightAnimator.class),
    SlideInUp(SlideInUpAnimator.class),
    SlideInDown(SlideInDownAnimator.class),
    SlideOutLeft(SlideOutLeftAnimator.class),
    SlideOutRight(SlideOutRightAnimator.class),
    SlideOutUp(SlideOutUpAnimator.class),
    SlideOutDown(SlideOutDownAnimator.class),
    ZoomIn(ZoomInAnimator.class),
    ZoomInDown(ZoomInDownAnimator.class),
    ZoomInLeft(ZoomInLeftAnimator.class),
    ZoomInRight(ZoomInRightAnimator.class),
    ZoomInUp(ZoomInUpAnimator.class),
    ZoomOut(ZoomOutAnimator.class),
    ZoomOutDown(ZoomOutDownAnimator.class),
    ZoomOutLeft(ZoomOutLeftAnimator.class),
    ZoomOutRight(ZoomOutRightAnimator.class),
    ZoomOutUp(ZoomOutUpAnimator.class);

    private Class animatorClazz;

    Techniques(Class cls) {
        this.animatorClazz = cls;
    }

    public BaseViewAnimator getAnimator() {
        try {
            return (BaseViewAnimator) this.animatorClazz.newInstance();
        } catch (Exception unused) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
