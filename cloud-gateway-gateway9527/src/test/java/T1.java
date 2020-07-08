import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author flytiger
 * @since 2020-07-07 18:38
 */
public class T1 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());
        System.out.println(zonedDateTime.toString());
    }
}
