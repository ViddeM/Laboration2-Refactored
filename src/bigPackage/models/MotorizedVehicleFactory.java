package bigPackage.models;

import bigPackage.models.AbstractModels.AMotorisedVehicle;

public class MotorizedVehicleFactory {
    public static AMotorisedVehicle createVolvo () {
        return new Volvo240();
    }

    public static AMotorisedVehicle createSaab () {
        return new Saab95();
    }

    public static AMotorisedVehicle createScania () {
        return new Scania();
    }
}
