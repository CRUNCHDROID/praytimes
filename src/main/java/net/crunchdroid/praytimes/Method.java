/*  Copyright (c) 2003-2006, 2009-2010 Arabeyes, Thamer Mahmoud, Fikrul Arif
 * (www.arabeyes.org - under LGPL license - see COPYING file)
 */
package net.crunchdroid.praytimes;

/**
 * This holds the calculation method used. NOTE: Before explicitly
 * setting any of these values, it is more safe to default initialize them
 * by calling {@link #fromStandard(StandardMethod)}.
 */
public class Method {

    /**
     * Chosen calculation method
     */
    StandardMethod method;

    /**
     * Fajr angle
     */
    double fajrAng;

    /**
     * Ishaa angle
     */
    double ishaaAng;

    /**
     * The angle difference between Imsaak and Fajr
     * (default is 1.5)
     */
    double imsaakAng = 1.5;

    /**
     * Fajr Interval is the amount of minutes between
     * Fajr and Shurooq (0 if not used)
     */
    int fajrInv;

    /**
     * Ishaa Interval is the amount if minutes between
     * Ishaa and Maghrib (0 if not used)
     */
    int ishaaInv;

    /**
     * Imsaak Interval is the amount of minutes between
     * Imsaak and Fajr. The default is 10 minutes before
     * Fajr if Fajr Interval is set
     */
    int imsaakInv = 10;

    /**
     * Method used for rounding seconds:
     * 0: No Rounding. "seconds" is set to the
     * amount of computed seconds.
     * 1: Normal Rounding. If seconds are equal to
     * 30 or above, add 1 minute. Sets
     * "seconds" to zero.
     * 2: Special Rounding (default). Similar to normal rounding
     * but we always round down for Shurooq and
     * Imsaak times.
     * 3: Aggressive Rounding. Similar to Special
     * Rounding but we add 1 minute if the seconds
     * value is equal to 1 second or more.
     */
    Rounding round = Rounding.SPECIAL;

    /**
     * Assr prayer shadow assrRatio:
     * 1: Shaf'i (default).
     * 2: Hanafi.
     */
    Mathhab mathhab = Mathhab.SHAFII;

    /**
     * Latitude Used for the 'Nearest Latitude' extreme
     * methods. The default is 48.5
     */
    double nearestLat = 48.5;

    /**
     * Extreme latitude calculation method
     */
    ExtremeMethod extreme;

    /**
     * Latitude at which the extreme method should
     * always be used. The default is 55
     */
    double extremeLat = 55;

    /**
     * Enable Offsets switch (set this to 1 to
     * activate). This option allows you to add or
     * subtract any amount of minutes to the daily
     * computed prayer times based on values (in
     * minutes) for each prayer in the offList array
     */
    int offset;

    /**
     * For Example: If you want to add 30 seconds to
     * Maghrib and subtract 2 minutes from Ishaa:
     * offset = 1
     * offList[4] = 0.5
     * offList[5] = -2
     * ..and than call getPrayerTimes as usual.
     */
    double[] offList = new double[6];

    /**
     *
     */
    Method() {
    }

    /**
     * @param src {@link Method}
     */
    @SuppressWarnings("WeakerAccess")
    public Method(Method src) {
        this.method = src.method;
        this.fajrAng = src.fajrAng;
        this.ishaaAng = src.ishaaAng;
        this.imsaakAng = src.imsaakAng;
        this.fajrInv = src.fajrInv;
        this.ishaaInv = src.ishaaInv;
        this.imsaakInv = src.imsaakInv;
        this.round = src.round;
        this.mathhab = src.mathhab;
        this.nearestLat = src.nearestLat;
        this.extreme = src.extreme;
        this.extremeLat = src.extremeLat;
        this.offset = src.offset;
        this.offList = src.offList;
    }

    /**
     * Create new instance of this class by using values from a standard method.
     *
     * @param method {@link StandardMethod}
     * @return method {@link Method}
     */
    @SuppressWarnings("WeakerAccess")
    public static Method fromStandard(StandardMethod method) {
        return PrayerModule.getMethod(method);
    }

    /**
     * @return fajrAng double
     */
    public double getFajrAngle() {
        return fajrAng;
    }

    /**
     * @param fajrAng double
     * @return method {@link Method}
     */
    public Method setFajrAngle(double fajrAng) {
        this.fajrAng = fajrAng;
        return this;
    }

    /**
     * @return ishaaAng double
     */
    public double getIshaaAngle() {
        return ishaaAng;
    }

    /**
     * @param ishaaAng double
     * @return method {@link Method}
     */
    public Method setIshaaAngle(double ishaaAng) {
        this.ishaaAng = ishaaAng;
        return this;
    }

    /**
     * @return imsaakAng double
     */
    public double getImsaakAngle() {
        return imsaakAng;
    }

    /**
     * @param imsaakAng double
     * @return method {@link Method}
     */
    public Method setImsaakAngle(double imsaakAng) {
        this.imsaakAng = imsaakAng;
        return this;
    }

    /**
     * @return fajrInv int
     */
    public int getFajrShurooqMinutes() {
        return fajrInv;
    }

    /**
     * @param fajrInv int
     * @return method {@link Method}
     */
    public Method setFajrShurooqMinutes(int fajrInv) {
        this.fajrInv = fajrInv;
        return this;
    }

    /**
     * @return ishaaInv int
     */
    public int getIshaaMaghribMinutes() {
        return ishaaInv;
    }

    /**
     * @param ishaaInv int
     * @return method {@link Method}
     */
    public Method setIshaaMaghribMinutes(int ishaaInv) {
        this.ishaaInv = ishaaInv;
        return this;
    }

    /**
     * @return imsaakInv int
     */
    public int getImsaakFajrMinutes() {
        return imsaakInv;
    }

    /**
     * @param imsaakInv int
     * @return method {@link Method}
     */
    public Method setImsaakFajrMinutes(int imsaakInv) {
        this.imsaakInv = imsaakInv;
        return this;
    }

    /**
     * @return round {@link Rounding}
     */
    public Rounding getRounding() {
        return round;
    }

    /**
     * @param round {@link Rounding}
     * @return method {@link Method}
     */
    public Method setRounding(Rounding round) {
        this.round = round;
        return this;
    }

    /**
     * @return mathhab {@link Mathhab}
     */
    public Mathhab getMathhab() {
        return mathhab;
    }

    /**
     * @param mathhab {@link Mathhab}
     * @return method {@link Method}
     */
    public Method setMathhab(Mathhab mathhab) {
        this.mathhab = mathhab;
        return this;
    }

    /**
     * @return nearestLat double
     */
    public double getNearestLatitude() {
        return nearestLat;
    }

    /**
     * @param nearestLat double
     * @return method {@link Method}
     */
    public Method setNearestLatitude(double nearestLat) {
        this.nearestLat = nearestLat;
        return this;
    }

    /**
     * @return extreme {@link ExtremeMethod}
     */
    public ExtremeMethod getExtremeMethod() {
        return extreme;
    }

    /**
     * @param extreme {@link ExtremeMethod}
     * @return method {@link Method}
     */
    public Method setExtremeMethod(ExtremeMethod extreme) {
        this.extreme = extreme;
        return this;
    }

    /**
     * @return extremeLat double
     */
    public double getExtremeLatitude() {
        return extremeLat;
    }

    /**
     * @param extremeLat double
     * @return method {@link Method}
     */
    public Method setExtremeLatitude(double extremeLat) {
        this.extremeLat = extremeLat;
        return this;
    }

    /**
     * @return true if offset = 1 false otherwise
     */
    public boolean isUseOffset() {
        return offset != 0;
    }

    /**
     * @param offset boolean
     * @return method {@link Method}
     */
    public Method setUseOffset(boolean offset) {
        this.offset = offset ? 1 : 0;
        return this;
    }

    /**
     * @return offList double[]
     */
    public double[] getOffsetMinutes() {
        return offList;
    }

    /**
     * @param offList double[]
     * @return method {@link Method}
     */
    public Method setOffsetMinutes(double[] offList) {
        this.offList = offList;
        return this;
    }

    /**
     * @param fajr    double
     * @param shurooq double
     * @param zuhr    double
     * @param assr    double
     * @param maghrib double
     * @param ishaa   double
     * @return method {@link Method}
     */
    public Method setOffsetMinutes(double fajr, double shurooq, double zuhr, double assr, double maghrib, double ishaa) {
        double[] newOffsetMinutes = new double[6];
        newOffsetMinutes[0] = fajr;
        newOffsetMinutes[1] = shurooq;
        newOffsetMinutes[2] = zuhr;
        newOffsetMinutes[3] = assr;
        newOffsetMinutes[4] = maghrib;
        newOffsetMinutes[5] = ishaa;
        this.offList = newOffsetMinutes;
        return this;
    }

    /**
     * @param fajr    double
     * @param shurooq double
     * @param zuhr    double
     * @param assr    double
     * @param maghrib double
     * @param ishaa   double
     * @return method {@link Method}
     */
    public Method addOffsetMinutes(double fajr, double shurooq, double zuhr, double assr, double maghrib, double ishaa) {
        double[] newOffsetMinutes = new double[6];
        newOffsetMinutes[0] = offList[0] + fajr;
        newOffsetMinutes[1] = offList[1] + shurooq;
        newOffsetMinutes[2] = offList[2] + zuhr;
        newOffsetMinutes[3] = offList[3] + assr;
        newOffsetMinutes[4] = offList[4] + maghrib;
        newOffsetMinutes[5] = offList[5] + ishaa;
        this.offList = newOffsetMinutes;
        return this;
    }


}
