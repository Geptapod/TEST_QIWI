public class ArgsParser {
    public static CurrencyArgs getArgs(String[] args) throws Exception {
        if (args.length != 3)
            throw new Exception(
                    "Wrong number of arguments\nCommand format: currency_rates --code=CCC --date=yyyy-MM-dd");
        if (!"currency_rates".equals(args[0].trim()))
            throw new Exception("Invalid command: " + args[0]);
        String[] code = args[1].split("=");
        if (!"--code".equals(code[0].trim()))
            throw new Exception("Invalid command arg: " + code[0]);
        String[] date = args[2].split("=");
        if (!"--date".equals(date[0].trim()))
            throw new Exception("Invalid command arg: " + date[0]);
        return new CurrencyArgs(code[1], date[1]);
    }
}
