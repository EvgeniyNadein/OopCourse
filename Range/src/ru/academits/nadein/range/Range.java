package ru.academits.nadein.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range() {
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

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getRangeCrossover(Range object1, Range object2) {
        Range rangeCrossover = new Range();

        if (object1.getFrom() == object2.getFrom() && object1.getTo() == object2.getTo()) {
            rangeCrossover.setFrom(object1.getFrom());
            rangeCrossover.setTo(object1.getTo());

            return rangeCrossover;
        }

        if (object2.getFrom() >= object1.getFrom() && object2.getFrom() < object1.getTo()
                && object2.getTo() >= object1.getTo()) {
            rangeCrossover.setFrom(object2.getFrom());
            rangeCrossover.setTo(object1.getTo());

            return rangeCrossover;
        }

        if (object1.getFrom() >= object2.getFrom() && object1.getFrom() < object2.getTo()
                && object1.getTo() >= object2.getTo()) {
            rangeCrossover.setFrom(object2.getFrom());
            rangeCrossover.setTo(object2.getTo());

            return rangeCrossover;
        }

        return null;
    }

    public Range[] getRangeUnion(Range object1, Range object2) {
        Range unitedRange1 = new Range();
        Range unitedRange2 = new Range();
        Range[] rangeArray = {null, null};

        if (object1.getFrom() == object2.getFrom() && object1.getTo() == object2.getTo()) {
            unitedRange1.setFrom(object1.getFrom());
            unitedRange1.setTo(object1.getTo());
            rangeArray[0] = unitedRange1;
        } else if (object2.getFrom() >= object1.getFrom() && object2.getFrom() <= object1.getTo()
                && object2.getTo() >= object1.getTo()) {
            unitedRange1.setFrom(object1.getFrom());
            unitedRange1.setTo(object2.getTo());
            rangeArray[0] = unitedRange1;
        } else if (object1.getFrom() >= object2.getFrom() && object1.getFrom() <= object2.getTo()
                && object1.getTo() >= object2.getTo()) {
            unitedRange1.setFrom(object2.getFrom());
            unitedRange1.setTo(object1.getTo());
            rangeArray[0] = unitedRange1;
        } else {
            unitedRange1.setFrom(object1.getFrom());
            unitedRange1.setTo(object1.getTo());

            unitedRange2.setFrom(object2.getFrom());
            unitedRange2.setTo(object2.getTo());

            rangeArray[0] = unitedRange1;
            rangeArray[1] = unitedRange2;
        }

        return rangeArray;
    }

    public Range[] getRangeDifference(Range object1, Range object2) {
        Range rangeDifference1 = new Range();
        Range rangeDifference2 = new Range();
        Range[] rangeArray = {null, null};

        if (object2.getFrom() > object1.getFrom() && object2.getFrom() < object1.getTo()
                && object2.getTo() >= object1.getTo()) {
            rangeDifference1.setFrom(object1.getFrom());
            rangeDifference1.setTo(object2.getFrom());
            rangeArray[0] = rangeDifference1;
        } else if (object1.getFrom() > object2.getFrom() && object1.getFrom() <= object2.getTo()
                && object1.getTo() >= object2.getTo()) {
            rangeDifference1.setFrom(object2.getFrom());
            rangeDifference1.setTo(object1.getFrom());
            rangeArray[0] = rangeDifference1;
        } else if (object1.getFrom() > object2.getFrom() && object1.getTo() > object2.getTo()) {
            rangeDifference1.setFrom(object1.getFrom());
            rangeDifference1.setTo(object2.getFrom());
            rangeArray[0] = rangeDifference1;

            rangeDifference2.setFrom(object2.getTo());
            rangeDifference2.setTo(object1.getTo());
            rangeArray[1] = rangeDifference2;
        } else if (object1.getFrom() > object2.getFrom() && object1.getTo() < object2.getTo()) {
            rangeDifference1.setFrom(object2.getFrom());
            rangeDifference1.setTo(object1.getFrom());
            rangeArray[0] = rangeDifference1;

            rangeDifference2.setFrom(object1.getTo());
            rangeDifference2.setTo(object2.getTo());
            rangeArray[1] = rangeDifference2;
        }

        return rangeArray;
    }
}