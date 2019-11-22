public class Number2Text {
    private static final String units[][] = {{"одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"один", "два"}};
    private static final String number10_19[] = {"десять","одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String tens[] = {"двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String hundreds[] = {"сто","двести", "триста", "четыреста", "пятьсот",
            "шестьсот", "семьсот", "восемьсот", "девятьсот"};
    private static final String category[][] = {
            {" ", " ", " ", "1"},
            {"тысяча", "тысячи", "тысяч", "0"},
            {"миллион", "миллиона", "миллионов", "1"},
            {"миллиард", "миллиарда", "миллиардов", "1"},
            {"триллион", "триллиона", "триллионов", "1"}};

    private static String number2words(long inputNumber, int level) {
        StringBuilder number2text = new StringBuilder();

        if (inputNumber == 0){
            number2text.append("ноль ");
        }

        int gender;

        if(category[level][3].equals("1")){
            gender = 1;
        }else {
            gender = 0;
        }

        //h-hundreds
        //t-tens
        //u-units
        int h = (int)(inputNumber % 1000);
        int t = h / 100;

        if (t > 0) {
            number2text.append(hundreds[t-1]).append(" ");
        }

        int u = h % 100;
        t = u / 10;
        u = u % 10;

        switch(t) {
            case 0: break;
            case 1: number2text.append(number10_19[u]).append(" ");
                break;
            default: number2text.append(tens[t-2]).append(" ");
        }

        if (t == 1) u=0;

        switch(u) {
            case 0: break;
            case 1:
            case 2: number2text.append(units[gender][u-1]).append(" ");
                break;
            default: number2text.append(units[0][u-1]).append(" ");
        }

        switch(u) {
            case 1: number2text.append(category[level][0]);
                break;
            case 2:
            case 3:
            case 4: number2text.append(category[level][1]);
                break;
            default:
                if((h != 0)||((h == 0) && (level == 1))){
                    number2text.append(category[level][2]); //если трехзначный сегмент = 0, то добавлять нужно только "рублей"
                }
        }

        long nextPartOfInputNumber = inputNumber/1000;

        if(nextPartOfInputNumber > 0) {
            return (number2words(nextPartOfInputNumber, level+1) + " " + number2text.toString()).trim();
        } else {
            return number2text.toString().trim();
        }
    }

    public static String inputValidation(long inputNumber){
        if (inputNumber < 1000000000000000l && inputNumber > -1000000000000000l) {
            if(inputNumber < 0){
                return "минус " + Number2Text.number2words(Math.abs(inputNumber), 0);
            }else {
                return Number2Text.number2words(inputNumber, 0);
            }
        } else{
            return "Извините, но введено слишком большое число";
        }
    }
}
