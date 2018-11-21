package ca.csf.pobj.tp2;

public class ConvertIntToRoman {

    private StringBuilder convertedRomanNumber;

    public String convertIntToRoman(int numberToConvert) {

        checkForIllegalArgumentException(numberToConvert);

        this.convertedRomanNumber = new StringBuilder();
        this.convertThousand(numberToConvert);
        FormatRomanConversion formatRomanConversionToRoman = new FormatRomanConversion();

        return formatRomanConversionToRoman.formatToRomanStyle(this.convertedRomanNumber.toString());
    }

    private void checkForIllegalArgumentException(int numberToConvert) {
        if (numberToConvert <= 0 || numberToConvert >= 5000) {
            throw new IllegalArgumentException("Value must be within 1 and 4999");
        }
    }

    private void convertThousand(int whatslLeftToConvert) {
        while (whatslLeftToConvert >= 1000) {
            this.convertedRomanNumber.append("M");
            whatslLeftToConvert -= 1000;
        }
        this.convertFiveHundred(whatslLeftToConvert);
    }

    private void convertFiveHundred(int whatslLeftToConvert) {
        while (whatslLeftToConvert >= 500) {
            this.convertedRomanNumber.append("D");
            whatslLeftToConvert -= 500;
        }
        this.converthundred(whatslLeftToConvert);
    }

    private void converthundred(int whatslLeftToConvert) {
        while (whatslLeftToConvert >= 100) {
            this.convertedRomanNumber.append("C");
            whatslLeftToConvert -= 100;
        }
        this.convertFifty(whatslLeftToConvert);
    }

    private void convertFifty(int whatslLeftToConvert) {
        while (whatslLeftToConvert >= 50) {
            this.convertedRomanNumber.append("L");
            whatslLeftToConvert -= 50;
        }
        this.convertTen(whatslLeftToConvert);
    }

    private void convertTen(int whatslLeftToConvert) {
        while (whatslLeftToConvert >= 10) {
            this.convertedRomanNumber.append("X");
            whatslLeftToConvert -= 10;
        }
        this.convertFive(whatslLeftToConvert);
    }

    private void convertFive(int whatslLeftToConvert) {
        while (whatslLeftToConvert >= 5) {
            this.convertedRomanNumber.append("V");
            whatslLeftToConvert -= 5;
        }
        this.convertOne(whatslLeftToConvert);
    }

    private void convertOne(int whatslLeftToConvert) {
        while (whatslLeftToConvert >= 1) {
            this.convertedRomanNumber.append("I");
            whatslLeftToConvert -= 1;
        }
    }
}
