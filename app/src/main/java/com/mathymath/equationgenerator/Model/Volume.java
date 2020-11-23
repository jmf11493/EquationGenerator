package com.mathymath.equationgenerator.Model;

import com.mathymath.equationgenerator.Model.Selection.VolumeSelection;

import java.math.BigDecimal;

public class Volume extends Generator {

    private BigDecimal radius, diameter, height, volume, rCubed, rSquared;
    private final BigDecimal two = new BigDecimal( "2" );
    private final BigDecimal oneThird = new BigDecimal( "1" ).divide( new BigDecimal( "3" ), 200, BigDecimal.ROUND_HALF_UP );
    private final BigDecimal twoThird = two.divide( new BigDecimal( "3" ), 200, BigDecimal.ROUND_HALF_UP );
    private final BigDecimal fourThirds = new BigDecimal( "4" ).divide( new BigDecimal( "3" ), 200, BigDecimal.ROUND_HALF_UP );
    private final BigDecimal pi = new BigDecimal( Math.PI + "" );

    public Volume() {
        super();
        selectionList = new VolumeSelection();
    }

    @Override
    public String getEquation() {
        return util.cleanEquation( util.removeDoubleSigns( equation ) );
    }

    @Override
    public String getAnswer() {
        return util.cleanEquation( util.removeDoubleSigns( answer ) );
    }

    @Override
    public void generate() {
        radius = util.randomDecimal( new BigDecimal( "0.5"), new BigDecimal( "5" ), 1 );
        rCubed = radius.pow( 3 );
        rSquared = radius.pow( 2 );
        diameter = radius.multiply( two );
        height = util.randomDecimal( two, new BigDecimal( "10" ), 1 );

        switch ( ( VolumeSelection.Equation ) type ) {
            case FINDING_VOLUME:
                findingVolume();
                break;
            case WORKING_BACKWARDS:
                workingBackwards();
                break;
            default:
                // Nothing
        }
    }

    private void findingVolume() {
        equation = "Determine the volume of a ";
        String part = "";

        // Determine whether to give the radius or the diameter
        switch ( util.randomInt( 0, 1 ) ) {
            // give radius
            case 0:
                part = "radius is \\(" + radius + "~cm\\)";
                break;

            // give diameter
            case 1:
                part = "diameter is \\(" + diameter + "~cm\\)";
                break;
            default:
                // Nothing
        }

        // Determine the 3D Shape
        switch ( util.randomInt( 0, 3 ) ) {

            // Cylinder
            case 0:
                equation += "cylinder whose " + part + " and height is \\(" + height + "~cm\\)";
                volume = rSquared.multiply( two ).multiply( height ).multiply( pi );
                answer = "\\(" + ( rSquared.multiply( height ) ) + "\\pi\\approx" + volume + "~cm^{3}\\)";
                break;

            // Cone
            case 1:
                equation += "cone whose " + part + " and height is \\(" + height + "~cm\\)";
                volume = oneThird.multiply( rSquared ).multiply( height ).multiply( pi );
                answer = "\\(" + ( oneThird.multiply( rSquared ).multiply( height ) ) + "\\pi\\approx" + volume + "~cm^{3}\\)";
                break;

            // Sphere
            case 2:
                equation += "sphere whose " + part;
                volume = fourThirds.multiply( rCubed ).multiply( pi );
                answer = "\\(" + ( fourThirds.multiply( rCubed ) ) + "\\pi\\approx" + volume + "~cm^{3}\\)";
                break;

            // Hemisphere (half a sphere)
            case 3:
                equation += "hemisphere whose " + part;
                volume = twoThird.multiply( rCubed ).multiply( pi );
                answer = "\\(" + ( twoThird.multiply( rCubed ) ) + "\\pi\\approx" + volume + "~cm^{3}\\)";
                break;
            default:
                // Nothing
        }
    }

    private void workingBackwards() {
        // Determine the 3D Shape
        switch ( util.randomInt( 0, 4 ) ) {

            // Cylinder - find radius
            case 0:
                equation = "Determine the radius of a cylinder whose height is \\(" + height + "~cm\\) and volume is \\(" + ( height.multiply( rSquared ) ) + "\\pi\\)";
                answer = "\\(radius = " + radius + "\\)";
                break;

            // Cylinder - find height
            case 1:
                equation = "Determine the height of a cylinder whose radius is \\(" + radius + "~cm\\) and volume is \\(" + ( height.multiply( rSquared ) ) + "\\pi\\)";
                answer = "\\(height = " + height + "\\)";
                break;

            // Cone - find radius
            case 2:
                equation = "Determine the radius of a cone whose height is \\(" + height + "~cm\\) and volume is \\(" + ( oneThird.multiply( height ).multiply( rSquared ) ) + "\\pi\\)";
                answer = "\\(radius = " + radius + "\\)";
                break;

            // Cone - find height
            case 3:
                equation = "Determine the height of a cone whose radius is \\(" + radius + "~cm\\) and volume is \\(" + ( oneThird.multiply( height ).multiply( rSquared ) ) + "\\pi\\)";
                answer = "\\(height = " + height + "\\)";
                break;

            // Sphere
            case 4:
                equation = "Determine the radius of a sphere whose volume is \\(" + ( fourThirds.multiply( rCubed ) ) + "\\pi\\)";
                answer = "\\(radius = " + radius + "\\)";
                break;
            default:
                // Nothing
        }
    }
}
