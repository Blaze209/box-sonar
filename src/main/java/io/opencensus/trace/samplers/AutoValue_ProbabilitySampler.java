package io.opencensus.trace.samplers;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ProbabilitySampler extends ProbabilitySampler {
    private final long idUpperBound;
    private final double probability;

    AutoValue_ProbabilitySampler(double d, long j) {
        this.probability = d;
        this.idUpperBound = j;
    }

    @Override // io.opencensus.trace.samplers.ProbabilitySampler
    double getProbability() {
        return this.probability;
    }

    @Override // io.opencensus.trace.samplers.ProbabilitySampler
    long getIdUpperBound() {
        return this.idUpperBound;
    }

    public String toString() {
        return "ProbabilitySampler{probability=" + this.probability + ", idUpperBound=" + this.idUpperBound + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ProbabilitySampler) {
            ProbabilitySampler probabilitySampler = (ProbabilitySampler) obj;
            if (Double.doubleToLongBits(this.probability) == Double.doubleToLongBits(probabilitySampler.getProbability()) && this.idUpperBound == probabilitySampler.getIdUpperBound()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long jDoubleToLongBits = ((int) (((long) 1000003) ^ ((Double.doubleToLongBits(this.probability) >>> 32) ^ Double.doubleToLongBits(this.probability)))) * 1000003;
        long j = this.idUpperBound;
        return (int) (jDoubleToLongBits ^ (j ^ (j >>> 32)));
    }
}
