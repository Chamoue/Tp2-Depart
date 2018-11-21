package ca.csf.pobj.tp2;

public class ConvertIntToRoman {

    private StringBuilder convertedRomanNumber;
    private int whatsLeftToConvert;

    public String convertIntToRoman(int numberToConvert) {

        checkForIllegalArgumentException(numberToConvert);

        this.whatsLeftToConvert = numberToConvert;
        this.convertedRomanNumber = new StringBuilder();
        this.startConversionToRomanNumbers();
        FormatRomanConversion formatRomanConversionToRoman = new FormatRomanConversion();

        return formatRomanConversionToRoman.formatToRomanStyle(this.convertedRomanNumber.toString());
    }

    private void checkForIllegalArgumentException(int numberToConvert) {
        if (numberToConvert <= 0 || numberToConvert >= 5000) {
            throw new IllegalArgumentException("Value must be within 1 and 4999");
        }
    }

    private void startConversionToRomanNumbers() {
        for (RomanLetters letters : RomanLetters.values()) {
            convertFromIntToRomanLetter(letters.getValue(), letters.getText());
        }
    }

    private void convertFromIntToRomanLetter(int substract, String romanLetter) {
        while (this.whatsLeftToConvert >= substract) {
            this.convertedRomanNumber.append(romanLetter);
            this.whatsLeftToConvert -= substract;
        }
    }
}
