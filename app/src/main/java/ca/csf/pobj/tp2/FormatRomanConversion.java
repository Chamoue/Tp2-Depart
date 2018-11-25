package ca.csf.pobj.tp2;

//BEN_CORRECTION : Je vois pas pourquoi cela ne fait pas directement partie de la classe "ConvertIntToRoman".

public class FormatRomanConversion {

    private String formattedString;

    public String formatToRomanStyle(String fullRomanValue) {

        this.formattedString = fullRomanValue;
        return formatRomanExceptions();
    }

    private String formatRomanExceptions() {

        formatNinehundred(this.formattedString);
        formatFourHundred(this.formattedString);
        formatNinety(this.formattedString);
        formatForty(this.formattedString);
        formatNine(this.formattedString);
        formatFour(this.formattedString);

        return this.formattedString;
    }

    //BEN_CORRECTION : Ces fonctions aurait du retourner "formattedString" et non pas le stocker
    //                 en attribut de classe.
    private void formatNinehundred(String whatsLeftToFormat) {
        if (whatsLeftToFormat.contains("DCCCC")) {
            this.formattedString = whatsLeftToFormat.replaceAll("DCCCC", "CM");
        }
    }

    private void formatFourHundred(String whatsLeftToFormat) {
        if (whatsLeftToFormat.contains("CCCC")) {
            this.formattedString = whatsLeftToFormat.replaceAll("CCCC", "CD");
        }
    }

    private void formatNinety(String whatsLeftToFormat) {
        if (whatsLeftToFormat.contains("LXXXX")) {
            this.formattedString = whatsLeftToFormat.replaceAll("LXXXX", "XC");
        }
    }

    private void formatForty(String whatsLeftToFormat) {
        if (whatsLeftToFormat.contains("XXXX")) {
            this.formattedString = whatsLeftToFormat.replaceAll("XXXX", "XL");
        }
    }

    private void formatNine(String whatsLeftToFormat) {
        if (whatsLeftToFormat.contains("VIIII")) {
            this.formattedString = whatsLeftToFormat.replaceAll("VIIII", "IX");
        }
    }

    private void formatFour(String whatsLeftToFormat) {
        if (whatsLeftToFormat.contains("IIII")) {
            this.formattedString = whatsLeftToFormat.replaceAll("IIII", "IV");
        }
    }

}
