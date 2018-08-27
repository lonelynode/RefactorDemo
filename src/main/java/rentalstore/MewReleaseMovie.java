package rentalstore;

class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    double getCharge(int dayRented) {
        double result = 0;
        result += dayRented*3;
        return result;
    }
}