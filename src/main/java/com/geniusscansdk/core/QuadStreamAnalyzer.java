package com.geniusscansdk.core;

/* JADX INFO: loaded from: classes13.dex */
public class QuadStreamAnalyzer {
    private static native int GSLAnalyzeQuadStream(float[] fArr, float[] fArr2);

    private static native int GSLInitQuadrangleAnalyzer();

    private static native int GSLMinDurationInAboutToTriggerForTrigger();

    public enum Status {
        NOT_FOUND(0),
        SEARCHING(1),
        ABOUT_TO_TRIGGER(2),
        TRIGGER(3);

        private int status;

        Status(int i) {
            this.status = i;
        }

        public static Status fromStatus(int i) {
            for (Status status : values()) {
                if (i == status.status) {
                    return status;
                }
            }
            return null;
        }
    }

    public static class Result {
        public Quadrangle resultQuadrangle;
        public Status status;

        public Result(int i, Quadrangle quadrangle) {
            Status statusFromStatus = Status.fromStatus(i);
            this.status = statusFromStatus;
            if (statusFromStatus == Status.NOT_FOUND || quadrangle == null || quadrangle.isEmpty()) {
                return;
            }
            this.resultQuadrangle = quadrangle;
        }

        public Result(Status status, Quadrangle quadrangle) {
            this.status = status;
            this.resultQuadrangle = quadrangle;
        }
    }

    public static Result analyzeQuadStream(Quadrangle quadrangle) {
        float[] fArr = new float[8];
        return new Result(GSLAnalyzeQuadStream(quadrangle.getPoints(), fArr), new Quadrangle(fArr));
    }

    public static void initQuadrangleAnalyzer() {
        GSLInitQuadrangleAnalyzer();
    }

    public static int getMinDurationInAboutToTriggerForTrigger() {
        return GSLMinDurationInAboutToTriggerForTrigger();
    }
}
