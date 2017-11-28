package bigPackage.Implementations;

import bigPackage.Interfaces.IHasFlatbed;
import bigPackage.models.AbstractModels.ACar;
import bigPackage.models.AbstractModels.AMotorisedVehicle;
import bigPackage.models.Saab95;
import bigPackage.models.Scania;
import bigPackage.models.Volvo240;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    // To keep track of a single ACars position
    private Map<String, BufferedImage> modelNameImgMap = new HashMap<>();
    private List<AMotorisedVehicle> motorisedVehicles;

    private void createCars( List<AMotorisedVehicle> list ) {
        motorisedVehicles = list;
        for ( AMotorisedVehicle motorisedVehicle : list ) {
            if ( !modelNameImgMap.containsKey( motorisedVehicle.getModelName() ) ) {
                try {
                    modelNameImgMap.put( motorisedVehicle.getModelName(),
                            ImageIO.read( new File( "src\\bigPackage\\pics\\" + motorisedVehicle.getClass().getSimpleName() + ".jpg" ) ) );
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        }
    }

    // TODO: Make this general for all ACars
    //    void moveIt( int x, int y, ACar c ) {
    //        //        Point point = carPointMap.get( c );
    //        volvoPoint.x = x;
    //        volvoPoint.y = y;
    //    }

    // Initializes the panel and reads the images
    public DrawPanel( int x, int y, List<AMotorisedVehicle> motorisedVehicles ) {
        this.setDoubleBuffered( true );
        this.setPreferredSize( new Dimension( x, y ) );
        this.setBackground( Color.green );
        createCars( motorisedVehicles );
        // Print an error message in case file is not found with a try/catch block
//        try {
//            // You can remove the "src\\pics" part if running outside of IntelliJ and
//            // everything is in the same main folder.
//            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
//            // if you are starting in IntelliJ.
//            // Linux users need to modify \ to / in path string
//
//            BufferedImage volvoImage = ImageIO.read( new File( "src\\bigPackage\\pics\\Volvo240.jpg" ) );
//            BufferedImage saabImage = ImageIO.read( new File( "src\\bigPackage\\pics\\Saab95.jpg" ) );
//            BufferedImage scaniaImage = ImageIO.read( new File( "src\\bigPackage\\pics\\Scania.jpg" ) );
//
//
//        } catch ( IOException ex ) {
//            ex.printStackTrace();
//        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent( g );
        for ( AMotorisedVehicle motorisedVehicle : motorisedVehicles ) {
            g.drawImage( modelNameImgMap.get( motorisedVehicle.getModelName() ),
                    (int) motorisedVehicle.getPosition()[0],
                    (int) motorisedVehicle.getPosition()[1],
                    null );
            if ( motorisedVehicle instanceof IHasFlatbed && !( (IHasFlatbed) motorisedVehicle ).isFlatbedDown()) {
                g.drawChars( new char[]{'F'}, 0, 1,
                        (int) motorisedVehicle.getPosition()[0], (int) motorisedVehicle.getPosition()[1] );
            }
        }
    }
}