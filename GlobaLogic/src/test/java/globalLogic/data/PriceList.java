package globalLogic.data;
import java.util.HashMap;

public class PriceList {
    public static final HashMap<String,Double> PROCESSOR=new HashMap<String,Double>(){
        {
            put(CharacteristicName.Slow,0.00);
            put(CharacteristicName.Medium,15.00);
            put(CharacteristicName.Fast,100.00);
        }
    };
    public static final HashMap<String,Double> RAM=new HashMap<String,Double>(){{
        put(CharacteristicName.Two,0.00);
        put(CharacteristicName.Four,20.00);
        put(CharacteristicName.Eight,60.00);}
    };
    public static final HashMap<String,Double> SOFTWARE=new HashMap<String ,Double>(){{
        put(CharacteristicName.Image,5.00);
        put(CharacteristicName.OfficeSuite,100.00);
        put(CharacteristicName.OtherOfficeSuite,40.00);}
    };

}
