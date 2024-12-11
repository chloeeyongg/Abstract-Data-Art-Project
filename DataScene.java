import org.code.theater.*;

public class DataScene extends Scene {
  private double[] heightsInMeters;
  private String[] mountainNames;
  private String[] ranges;
    private String[] countries;
  private String[] textColors;
    private String[] mountainImages;

    private double highestPeak;

    /**
     * Constructor for initializing the DataScene object with the given data
     */
    public DataScene(double[] heightsInMeters, String[] mountainNames, String[] ranges, String[] countries, String[] colors, String[] images) {
         this.heightsInMeters = heightsInMeters;
        this.mountainNames = mountainNames;
        this.ranges = ranges;
         this.countries = countries;
          this.textColors = colors;
         this.mountainImages = images;
        calculateHighestPeak();
    }

    /**
     * Calculates the highest peak in the dataset
     */
    private void calculateHighestPeak() {
      highestPeak = findMax(heightsInMeters);
    }

    /**
     * Displays all mountain details 
     */
    public void showAllMountainDetails() {
    for (int i = 0; i < mountainNames.length; i++) {
        showMountainDetails(i);
        }
    }

      /**
     * *Finds the maximum value
     */
    private double findMax(double[] array) {
        double max = array[0];
        for (double value : array) {
            max = Math.max(max, value);
        }
       
return max;
    }

    /**
     * Displays details for each mountain
     */
    private void showMountainDetails(int index) {
        String message = getMessage(index);
     String image = getImageForMountain(index);
  drawMountainDetails("Mountain Details", message, mountainNames[index], heightsInMeters[index], ranges[index], countries[index], image, "silver");
    }



    /**
     * Makes a message for the mountain based on its height
     */
    private String getMessage(int index) {
        if (heightsInMeters[index] == highestPeak) {
      return "Highest peak!";
        } else {
      return "Impressive height!";
        }
    }

    /**
     * Create visual scenes
     */
    public void createScene() {
        for (int i = 0; i < heightsInMeters.length; i++) {
        createMountainScene(i);
        }
    }
  
    /**
     * Draws detailed information about a mountain
     */
    private void drawMountainDetails(String title, String message, String name, double height, String range, String country, String image, String color) {
        drawImage(image, 0, 0, 450);
       setFillColor(color);
        drawRectangle(0, 0, 410, 50);
        drawRectangle(0, 300, 410, 110);
    setTextColor("black");
        setTextHeight(34);
        drawText(title, 65, 40);
       setTextHeight(25);
        drawText(message, 20, 325);
        setTextHeight(18);
       drawText(name, 20, 350);
        drawText("Height: " + Math.round(height) + " m", 20, 375);
        drawText("Range: " + range, 20, 400);
       drawText("Country: " + country, 20, 425);
        playSound("chime.wav");
      pause(2);
    }

    /**
     * Creates a scene for a specific mountain
     */
    private void createMountainScene(int index) {
     String image = getImageForMountain(index);
      drawMountainDetails("Mountain Details", getMessage(index), mountainNames[index], heightsInMeters[index], ranges[index], countries[index], image, "silver");
    }
}
