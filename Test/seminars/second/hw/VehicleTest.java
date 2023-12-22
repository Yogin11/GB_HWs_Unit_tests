package seminars.second.hw;

import org.assertj.core.api.BooleanAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {

    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void initiateObjects(){
        car = new Car("Toyota","Super Saloon", 1985);
        motorcycle = new Motorcycle("Suzuki","Hayabusa", 2022);
           }

    @Test
    void carIsVehicleObjectInstance(){
        assertThat((car instanceof Vehicle)).isTrue();
    }

    @Test
    void carWheelsNumberCorrect(){
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void motorcycleWheelsNumberCorrect(){
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void carTestDriveSpeedCorrect (){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void motorcycleTestDriveSpeedCorrect () {
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void motorcycleAfterTestDriveParkingSpeedCorrect () {

        motorcycle.testDrive();
        int speedTestDrive = motorcycle.getSpeed();
        motorcycle.park();
        int speedParking = motorcycle.getSpeed();

        assertThat(speedTestDrive-speedParking).isEqualTo(75);
    }
    @Test
    void carAfterTestDriveParkingSpeedCorrect () {

        car.testDrive();
        int speedTestDrive = car.getSpeed();
        car.park();
        int speedParking = car.getSpeed();
        assertThat(speedTestDrive-speedParking).isEqualTo(60);
    }

}