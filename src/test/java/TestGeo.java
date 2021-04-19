
import com.study.map.ParseUtil;
import com.study.model.Geo;
import org.junit.Test;

public class TestGeo {
    @Test
    public void test1() throws Exception {
        Geo geo = ParseUtil.getGeoByName("松山機場");
        System.out.println(geo);
    }
}
