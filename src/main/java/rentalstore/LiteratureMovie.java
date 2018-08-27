package rentalstore;

public class LiteratureMovie extends Movie {
    public LiteratureMovie(String title) {
        super(title, Movie.LITERATURE);
    }

    double getCharge(int dayRented) {
        double result = 0;
        result += dayRented*6;
        return result;
    }
}