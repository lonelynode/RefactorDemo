package rentalstore;

class Rental {
    private Movie movie;
    private int dayRented;

    Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    Movie getMovie() {
        return movie;
    }

    private int getDayRented() {
        return dayRented;
    }

    double getCharge() {
        double result = 0;
        switch (this.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (this.getDayRented() > 2) {
                    result += (this.getDayRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += this.getDayRented() * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (this.getDayRented() > 3) {
                    result += (this.getDayRented() - 3) * 1.5;
                }
                break;
        }
        return result;
    }

    int getFrequentRentalPoints() {
        if ((this.getMovie().getPriceCode() == Movie.NEW_RELEASE) && this.getDayRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
