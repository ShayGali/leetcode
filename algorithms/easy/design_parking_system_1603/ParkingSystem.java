package algorithms.easy.design_parking_system_1603;

public class ParkingSystem {
    int bigC;
    int mediumC;
    int smallC;

    public ParkingSystem(int big, int medium, int small) {
        bigC = big;
        mediumC = medium;
        smallC = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            return (bigC--) > 0;
        }
        if (carType == 2) {
            return (mediumC--) > 0;
        }
        return (smallC--) > 0;
    }
}
