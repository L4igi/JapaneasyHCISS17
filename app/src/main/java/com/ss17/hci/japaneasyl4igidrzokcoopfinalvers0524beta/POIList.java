package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;

import android.location.Location;
import android.location.LocationManager;

/**
 * Created by jakob on 08.05.17.
 */

public class POIList {
    protected Location park, restaurant, uni;

    public POIList() {
        park = new Location(LocationManager.GPS_PROVIDER);
        restaurant = new Location(LocationManager.GPS_PROVIDER);
        uni = new Location(LocationManager.GPS_PROVIDER);

        // Votivpark
        park.setLatitude(48.215);
        park.setLongitude(16.36);
        park.setAccuracy(20);

        // Gagarin
        restaurant.setLatitude(48.218);
        restaurant.setLongitude(16.356);
        restaurant.setAccuracy(20);

        // Informatik
        uni.setLatitude(48.22);
        uni.setLongitude(16.356);
        uni.setAccuracy(20);
    }
}
