package game.board;

class FieldConverter implements Converter<Field, String> {


    @Override
    public Field read(String input) {
        int rowIndex = getRowIndex(input);
        int columnIndex = getColumnIndex(input);
        return new Field(rowIndex, columnIndex);
    }

    private int getRowIndex(String begin) {
        String beginRowLetter = String.valueOf(begin.charAt(0));
        return Rows.valueOf(beginRowLetter).getIndex();
    }

    private int getColumnIndex(String begin) {
        return Integer.parseInt(removeLetters(begin)) - 1;
    }

    private String removeLetters(String begin) {
        return begin.replaceAll("\\D", "");
    }
}
