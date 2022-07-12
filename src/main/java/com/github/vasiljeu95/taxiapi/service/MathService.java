package com.github.vasiljeu95.taxiapi.service;

import com.github.vasiljeu95.taxiapi.dto.user.TripCostDto;
import com.github.vasiljeu95.taxiapi.dto.order.TripCostRequestDto;
import org.springframework.stereotype.Service;

/**
 * MathServise
 *
 * @author Stepan Vasilyeu
 * @since 11.07.2022
 */
@Service
public class MathService {
    private double carSpeed = 40.0;
    private double tariff = 5;
    private double seconds = 3600;

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    private double distance (double lat1, double lon1, double lat2, double lon2) {

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        dist = dist * 1.609344;

        return (dist);
    }

    public TripCostDto tripDistance (TripCostRequestDto tripCostRequestDto) {
        double pointALatitude = Double.parseDouble(tripCostRequestDto.getStartCoordinateLatitude());
        double pointALongitude = Double.parseDouble(tripCostRequestDto.getStartCoordinateLongitude());
        double pointBLatitude = Double.parseDouble(tripCostRequestDto.getFinishCoordinateLatitude());
        double pointBLongitude = Double.parseDouble(tripCostRequestDto.getFinishCoordinateLongitude());

        double tripDistance = distance(pointALatitude, pointALongitude, pointBLatitude, pointBLongitude);

        TripCostDto tripCostDto = new TripCostDto();

        tripCostDto.setDistance(tripDistance);
        tripCostDto.setPrice(tripDistance * tariff);
        tripCostDto.setOrderTime((long) (tripDistance / carSpeed * seconds));
        tripCostDto.setStartCoordinate(tripCostRequestDto.getStartCoordinateLatitude() + ", " + tripCostRequestDto.getStartCoordinateLongitude());
        tripCostDto.setFinishCoordinate(tripCostRequestDto.getFinishCoordinateLatitude() + ", " + tripCostRequestDto.getFinishCoordinateLongitude());

        return tripCostDto;
    }
}
