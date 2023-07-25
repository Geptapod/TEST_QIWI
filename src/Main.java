public class Main {
    public static void main(String[] args) {
        InputCommandImp input = new InputCommandImp();
        try {
            String[] commandArgs = input.getCommandArgs();
            CurrencyArgs currencyArgs = ArgsParser.getArgs(commandArgs);

            String response = RequestSender.executeGet("https://www.cbr.ru/scripts/XML_daily.asp", currencyArgs);

            String output = GetCurrencyData.findCurrencyData(response, currencyArgs.getCode());
            System.out.println(output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}