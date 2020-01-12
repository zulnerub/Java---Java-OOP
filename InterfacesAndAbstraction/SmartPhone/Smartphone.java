package InterfacesAndAbstraction.SmartPhone;

import java.util.List;

public class Smartphone implements Callable, Browsable{

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        this.urls.forEach(e -> {
            boolean isLetter = true;
            char[] charArr = e.toCharArray();
            for (char c : charArr) {
                if (Character.isDigit(c)) {
                    isLetter = false;
                    break;
                }
            }
            if (isLetter){
                sb.append("Browsing: ").append(e).append("!").append(System.lineSeparator());
            }else{
                sb.append("Invalid URL!").append(System.lineSeparator());
            }
        });
        return sb.toString();    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        this.numbers.forEach(e -> {
            boolean isDigit = true;
            char[] charArr = e.toCharArray();
            for (char c : charArr) {
                if (!Character.isDigit(c)) {
                    isDigit = false;
                    break;
                }
            }
            if (isDigit){
                sb.append("Call... ").append(e).append(System.lineSeparator());
            }else{
                sb.append("Invalid number!").append(System.lineSeparator());
            }
        });
        return sb.toString();
    }
}
