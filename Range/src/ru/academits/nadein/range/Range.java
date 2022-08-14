package ru.academits.nadein.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    @Override
    public String toString() {
        return "(" + from + ", " + to + ")";
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range2) {
        if (Math.max(range2.from, from) >= Math.min(range2.from, from)
                && Math.max(range2.from, from) < Math.min(to, range2.to)) {
            return new Range(Math.max(range2.from, from), Math.min(to, range2.to));
        }

        return null;
    }

    public Range[] getUnion(Range range2) {
        if (Math.max(range2.from, from) >= Math.min(range2.from, from)
                && Math.max(range2.from, from) <= Math.min(to, range2.to)) {
            return new Range[]{new Range(Math.min(from, range2.from), Math.max(to, range2.to))};
        }

        return new Range[]{new Range(from, to), new Range(range2.from, range2.to)};
    }

    public Range[] getDifference(Range range2) {
        if (range2.from <= from && range2.to >= to) {
            return new Range[0];
        }

        if (range2.from <= from && range2.to > from) {
            return new Range[]{new Range(range2.to, to)};
        }

        if (range2.from >= from && range2.from < to && range2.to >= to) {
            return new Range[]{new Range(from, range2.from)};
        }

        if (range2.from > from && range2.to > from && range2.to < to) {
            return new Range[]{new Range(from, range2.from), new Range(range2.to, to)};
        }

        return new Range[]{new Range(from, to)};
    }
}