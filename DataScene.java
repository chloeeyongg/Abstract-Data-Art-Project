import org.code.theater.*;

public class DataScene extends Scene {

    // Arrays to store mountain data
    private String[] names;
    private String[] ranges;
    private String[] countries;
    private double[] heights_meters;

    // Array to store heights converted to feet
    private double[] heights_feet;

    // Colors and images for the visualization
    private String[] colors = {"white", "yellow", "orange", "red"};
    private String[] images = {"images-Everest.jpg", "images-K2.jpg", "images-Kangchenjunga.jpg", "images-Lhotse.jpg"};

    /**
     * Constructor initializes the data arrays and converts heights to feet.
     */
    public DataScene() {
        names = FileReader.toStringArray("mountainNames.txt");
        ranges = FileReader.toStringArray("ranges.txt");
        countries = FileReader.toStringArray("countries.txt");
        heights_meters = FileReader.toDoubleArray("heightsInMeters.txt");

        heights_feet = convertToFeet(heights_meters);
    }

    /**
     * Main visualization method.
     * Displays a random mountain with its details, plays background sound,
     * and uses colors based on height.
     */
    public void drawScene() {
        int shown = (int) (Math.random() * 4);

        // Display the selected mountain's image
        drawImage(images[shown], 0, 0, 450);

        // Draw a rectangle with color based on height
        setFillColor(colorAlgorithm(heights_meters[shown]));
        drawRectangle(0, 300, 410, 110);

        // Display mountain details
        setTextColor("black");
        setTextHeight(25);
        drawText(names[shown], 80, 50);
        drawText(ranges[shown], 25, 325);
        drawText(countries[shown], 25, 360);
        drawText("Height in Meters: " + heights_meters[shown], 50, 380);
        drawText("Height in Feet: " + heights_feet[shown], 50, 400);

        // Play random background sound
        int[] music = generateRandomBackgoundSound();
        for (int i = 0; i < music.length; i++) {
            playNoteAndPause(music[i], 1);
        }
    }

    /**
     * Converts heights from meters to feet.
     * Multiplies each height by 3.28.
     */
    private double[] convertToFeet(double[] list) {
        heights_feet = new double[names.length];
        for (int i = 0; i < names.length; i++) {
            heights_feet[i] = list[i] * 3.28;
        }
        return heights_feet;
    }

    /**
     * Generates a random sound sequence.
     * Returns an array of 10 random note frequencies.
     */
    private int[] generateRandomBackgoundSound() {
        int[] track = new int[10];
        for (int i = 0; i < 10; i++) {
            track[i] = (int) (Math.random() * 30 + 50);
        }
        return track;
    }

    /**
     * Determines the rectangle color based on the mountain's height.
     */
    private String colorAlgorithm(double height) {
        if (height > 8800) {
            return colors[0];
        } else if ((height <= 8800) && (height > 8600)) {
            return colors[1];
        } else if ((height <= 8600) && (height > 8550)) {
            return colors[2];
        } else {
            return colors[3];
        }
    }
}