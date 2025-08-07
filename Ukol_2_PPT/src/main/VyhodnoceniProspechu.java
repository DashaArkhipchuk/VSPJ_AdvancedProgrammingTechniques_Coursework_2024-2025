package main;

/**
 * Evaluates student performance based on grades.
 */
public class VyhodnoceniProspechu {

    private String[] slovniHodnoceni = new String[] {"výborně", "chvalitebně", "dobře", "dostatečně", "nedostatečně"};

    /**
     * Computes the verbal evaluation of the student's performance.
     *
     * @param znamky array of grades (1-5 scale)
     * @return String representing the performance evaluation
     */
    public String prospech(int znamky[]) {
        double avg = prumer(znamky);

        if (avg >= 1.0 && avg < 1.5) {
            return slovniHodnoceni[0];
        } else if (avg < 2.5) {
            return slovniHodnoceni[1];
        } else if (avg < 3.5) {
            return slovniHodnoceni[2];
        } else if (avg < 4.5) {
            return slovniHodnoceni[3];
        } else {
            return slovniHodnoceni[4];
        }
    }

    /**
     * Calculates the average of the given grades.
     *
     * @param znamky array of grades
     * @return the average grade as a double
     */
    public double prumer(int znamky[]) {
        if (znamky == null || znamky.length == 0) {
            throw new IllegalArgumentException("Grades array cannot be empty.");
        }

        int sum = 0;
        for (int grade : znamky) {
            if (grade < 1 || grade > 5) {
                throw new IllegalArgumentException("Grades must be between 1 and 5.");
            }
            sum += grade;
        }
        return (double) sum / znamky.length;
    }
}
