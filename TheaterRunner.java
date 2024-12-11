import org.code.theater.*;

public class TheaterRunner {
    public static void main(String[] args) {
        /**
         * Read data from files
         */
        String[] mountainNames = FileReader.toStringArray("mountainNames.txt");
        String[] ranges = FileReader.toStringArray("ranges.txt");
        String[] countries = FileReader.toStringArray("countries.txt");

        // Heights in meters for the mountains
        double[] heightsInMeters = FileReader.toDoubleArray("heightsInMeters.txt");

        String[] colorsArray = {"white", "silver", "gold", "blue", "green"};

        // Images corresponding to mountains
        String[] mountainImages = {
            "images-Everest.jpg",      // Mount Everest
            "images-K2.jpg",           // K2
            "images-Kangchenjunga.jpg", // Kangchenjunga
            "images-Lhotse.jpg",       // Lhotse
            "images-mountainImage.jpg" // Default for others
        };

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
