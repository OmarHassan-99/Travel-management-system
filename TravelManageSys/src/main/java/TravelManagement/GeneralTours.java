/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TravelManagement;

import java.util.Date;

/**
 *
 * @author bmood
 */
public class GeneralTours extends Trip {

    public GeneralTours() {
        super();
    }

    public GeneralTours(String tripId, String title, String tripType, double initPrice, Date[] startDate,
            Date[] endDate,
            String Description, String tourGuide, int Capacity, String activities[], String hotelName,
            String transportationType) {
        super(tripId, title, tripType, initPrice, startDate, endDate, Description, tourGuide, Capacity, activities,
                hotelName, transportationType);
    }

}
