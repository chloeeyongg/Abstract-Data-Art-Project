import org.code.theater.*;

public class TheaterRunner {
    public static void main(String[] args) {
        /**
         * Read data from data files
         */
        String[] mountainNames = FileReader.toStringArray("mountainNames.txt");
         String[] ranges = FileReader.toStringArray("ranges.txt");
        String[] countries = FileReader.toStringArray("countries.txt");

         double[] heightsInMeters = FileReader.toDoubleArray("heightsInMeters.txt");

         String[] colorsArray = {"white", "silver", "gold", "blue", "green"};

        /**
         * Create a DataScene object
         */
        DataScene mountainScene = new DataScene(heightsInMeters, mountainNames, ranges, countries, colorsArray, mountainImages);

        // Display all mountain details sequentially
        mountainScene.showAllMountainDetails();

        // Create and play scenes
        mountainScene.createScene();
        Theater.playScenes(mountainScene);
    }
}
