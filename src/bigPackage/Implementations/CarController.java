package bigPackage.Implementations;

import bigPackage.Interfaces.IHasFlatbed;
import bigPackage.Interfaces.ITurbo;
import bigPackage.models.AbstractModels.ACar;
import bigPackage.models.AbstractModels.AMotorisedVehicle;
import bigPackage.models.MotorizedVehicleFactory;
import bigPackage.models.Saab95;
import bigPackage.models.Scania;
import bigPackage.models.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 100 updates a sec (hz)
    private final int delay = 10;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer( delay, new TimerListener() );

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of ACars, modify if needed
    private List<AMotorisedVehicle> motorizedVehicles = new ArrayList<>();

    //methods:

    public static void main( String[] args ) {
        // Instance of this class
        CarController cc = new CarController();

    }

    private CarController() {
        initCars();
        // Start a new view and send a reference of self
        frame = new CarView( "CarSim 1.0", getCarList());
        // Start the timer
        timer.start();

        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                gas( frame.getGasAmount() );
            } });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                brake( frame.getGasAmount() );
            } });

        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                stopEngine();
            } });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                startEngine();
            } });

        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                setTurboOn();
            } });

        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                setTurboOff();
            } });

        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                raiseFlatbed();
            } });

        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                lowerFlatbed();
            } });
    }

    private List<AMotorisedVehicle> getCarList() {
        return motorizedVehicles;
    }

    private void initCars() {
        motorizedVehicles.add(MotorizedVehicleFactory.createVolvo());
        motorizedVehicles.add(MotorizedVehicleFactory.createScania());
        motorizedVehicles.add(MotorizedVehicleFactory.createSaab());
        motorizedVehicles.add(MotorizedVehicleFactory.createVolvo());
        for ( int i = 0; i < motorizedVehicles.size(); i++ ) {
            motorizedVehicles.get( i ).getPosition()[0] += 100 * i;
        }
    }

    /* Each step the TimerListener moves all the ACars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed( ActionEvent e ) {
            for ( AMotorisedVehicle motorizedVehicle : motorizedVehicles ) {
                motorizedVehicle.move();
                int x = (int) Math.round( motorizedVehicle.getPosition()[0] );
                x = x <= 800 - 100 ? ( x <= 0 ? 0 : x ) : 800 - 100;
                int y = (int) Math.round( motorizedVehicle.getPosition()[1] );
                y = y <= 800 - 300 ? ( y <= 0 ? 0 : y ) : 800 - 300;

                //                frame.drawPanel.moveIt( x, y , motorizedVehicle);
                // repaint() calls the paintComponent method of the panel
                outOfBounds( motorizedVehicle );
            }
            frame.drawPanel.repaint();
        }

        private void outOfBounds( AMotorisedVehicle motorisedVehicle ) {
            int x = (int) Math.round( motorisedVehicle.getPosition()[0] );
            int y = (int) Math.round( motorisedVehicle.getPosition()[1] );
            if ( x > CarView.getMaxX() - 100 || y > CarView.getMaxY() - 60 || x < 0 || y < 0 ) {
                motorisedVehicle.turnLeft();
                motorisedVehicle.turnLeft();
            }
        }
    }

    // Calls the gas method for each car once
    void gas( int amount ) {
        double gas = ( (double) amount ) / 100;
        for ( AMotorisedVehicle motorisedVehicle : motorizedVehicles ) {
            try {
                motorisedVehicle.gas( gas );
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    void brake( int amount ) {
        double brake = ( (double) amount ) / 100;
        for ( AMotorisedVehicle motorisedVehicle : motorizedVehicles ) {
            motorisedVehicle.brake( brake );
        }
    }

    void stopEngine() {
        for ( AMotorisedVehicle motorisedVehicle : motorizedVehicles ) {
            motorisedVehicle.stopEngine();
        }
    }

    void startEngine() {
        for ( AMotorisedVehicle motorisedVehicle : motorizedVehicles ) {
            motorisedVehicle.startEngine();
        }
    }

    void setTurboOn() {
        for ( AMotorisedVehicle motorisedVehicle : motorizedVehicles ) {
            if ( motorisedVehicle instanceof ITurbo ) {
                ( (ITurbo) motorisedVehicle ).setTurboOn();
            }
        }
    }

    void setTurboOff() {
        for ( AMotorisedVehicle motorisedVehicle : motorizedVehicles ) {
            if ( motorisedVehicle instanceof ITurbo ) {
                ( (ITurbo) motorisedVehicle ).setTurboOff();
            }
        }
    }

    void raiseFlatbed() {
        for ( AMotorisedVehicle motorisedVehicle : motorizedVehicles ) {
            if ( motorisedVehicle instanceof IHasFlatbed ) {
                ( (IHasFlatbed) motorisedVehicle ).raiseFlatbed();
            }
        }
    }

    void lowerFlatbed() {
        for ( AMotorisedVehicle motorisedVehicle : motorizedVehicles ) {
            if ( motorisedVehicle instanceof IHasFlatbed ) {
                ( (IHasFlatbed) motorisedVehicle ).lowerFlatbed();
            }
        }
    }
}