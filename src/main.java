import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class main {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв.");
        System.out.println(decode(reader,11 ));
    }


    public static String decode(StringReader reader, int key) throws IOException {
        char[] lCh = { 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и','й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э','ю', 'я' };
        char[] upCh = { 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
                'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
                'Ц', 'Ч', 'Ш', 'Щ', 'Ы', 'Ь', 'Э', 'Ю', 'Я' };

        if (reader == null) return "";
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(reader);
        String string = bufferedReader.readLine();

        char[] charArray = string.toCharArray();


        for(int i=0; i<charArray.length; i++){
        int index = 0;
        boolean isNOTLetter = Character.isWhitespace(charArray[i]);
        if (!isNOTLetter){
            if (Character.isLowerCase(charArray[i])){
                while (charArray[i] != lCh[index]) index++;
                index +=key;
                if (index > 32){
                    index -= 33;
                }
                charArray[i] = lCh[index];
            }else if (Character.isUpperCase(charArray[i])){
                while (charArray[i] != upCh[index]) index++;
                index +=key;
                if (index > 32){
                    index -= 33;
                }
                charArray[i] = upCh[index];
            }
        }
    }
    for (char c:charArray) {
        sb.append(c);
    }
    return sb.toString();
}
             }







