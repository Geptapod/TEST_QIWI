
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrencyArgs {
    private String code;
    private Date date;
    private String format = "yyyy-MM-dd";

    CurrencyArgs(String code, String date) throws Exception {
        setCode(code);
        setDate(date);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDate(String date) throws Exception {
        Date dateD;
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            dateD = formatter.parse(date);
            this.date = dateD;
        } catch (Exception e) {
            throw new Exception("Wrong date format");
        }
    }

    public Date getDate() {
        return date;
    }
}
