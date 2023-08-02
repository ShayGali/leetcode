package algorithms.easy.excel_sheet_column_title_168;

public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber != 0) {
            sb.append((char) (((--columnNumber) % 26) + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
