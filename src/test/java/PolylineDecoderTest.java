import com.study.map.polyline.Point;
import com.study.map.polyline.PolylineDecoder;
import com.study.map.polyline.PolylineUtils;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PolylineDecoderTest {

    protected PolylineDecoder decoder = new PolylineDecoder();

    List<Point> line = new ArrayList<Point>();

    Point orange = new Point(45.20919, 5.79387);

    @Before
    public void init() {
    }

    /**
     * Address "28 chemin du vieux chene, meylan, france" gives position (45.20919, 5.79387). Once encoded : m||rGurjb@
     */
    @Test
    public void testSinglePoint() {
        line.add(orange);
        line = decoder.decode("m||rGurjb@");
        assertTrue(line.size() == 1);
        Point p = line.get(0);
        System.out.println("p : " + p);
        assertTrue(p.equals(orange));
    }

    // Caution with "\\" here to represent \...
    String polyline = "y||rGuxjb@KdDh@jEZnESRE`@Rd@\\CXjAjF~Kf@nDrAdN@dAQt@kBnCQf@G|@XbBjEsAlACd@FnB`Av@t@nAvBv@hCxA|LhI~gAhCnZbAtKhBhOMh@@XvC~F~i@h|@rKlQ|GtLpB~DhGhSnNlf@_CnQOb@o`@bd@vAvRtBhV?PqAf@";
    Point station = new Point(45.1908, 5.7156);

    @Test
    public void testPolyline() {
        line = decoder.decode("y||rGuxjb@KdDh@jEZnE");
        assertTrue(line.size() > 0);
        Point p = line.get(0);
        System.out.println("p : " + p);
        assertTrue(p.equals(orange));
        System.out.println(PolylineUtils.toString(line));

    }

    @Test
    public void test46PointPolyline() {
        line = decoder.decode(polyline);
        assertTrue(line.size() > 0);
        Point p = line.get(0);
        System.out.println("p : " + p);
        assertTrue(p.equals(orange));
        System.out.println(PolylineUtils.toString(line));
        assertTrue(line.size() == 46);
        Point destination = line.get(line.size() - 1);
        assertTrue(line.size() == 46);
        assertTrue(destination.equals(station));
    }

    @Test
    public void testPrecision6Polyline() {
        String polyline6 = "{`l`cAbsv~tCF}sAmh@cNegX`aOumHwcRoq}@xbFsxiA{dFmsJwQsBfoE{|JaV`B{dBlpV|Ib}iAngDhr}@aiFxiHz{QdgXaaOlh@bNG|sA";
        line = decoder.decode(polyline6, 1E6);
        assertTrue(line.size() > 0);
        assertTrue(line.size() == 18);
        Point p = line.get(0);
        assertTrue(Math.abs(p.getLat()) < 200);
        assertTrue(Math.abs(p.getLng()) < 200);
    }

    // 2 av Pierre Marzin, lannion, france  -->  (48.75378, -3.4611)  -->  cfqhHh_cT
    Point lannion = new Point(48.75378, -3.4611);

    @Test
    public void testNegativePoints() {
        line = decoder.decode("cfqhHh_cT");
        Point p = line.get(0);
        System.out.println("p : " + p);
        assertTrue(p.equals(lannion));

    }

    String meylan_lyon = "y||rGuxjb@^vRvHlOzBtSOzB}BvDP`DjEsA~CPze@tR`ECnViGdf@RtPvCdOjHvH~GnIbL~Z`s@rKrQzM`Px`@j]nm@zp@zQhV`GjMdHbUbFfZ`Bd]}@h_@yFvh@uAjFgN~Q}LnKkDdIcBxMMf]kCnHoCbAckEuGuIXgH`BgF|CgFzFqv@vlAsHvF_VzJuHpGiWdk@_NbQmz@vk@_bAve@oh@~\\}LjKo_@|i@qX`l@}H|Lua@vh@iI`HyNhHyo@bVoQbFqa@~HsS|BcLN{Mq@mb@aG{KDoKrAwPtGiUjN{OvLiWrV{RvUmVl`@e\\`q@q^dn@_W|o@sSn[cFdMeStm@uBbNkFdp@cJrj@gHpV{Ol`@uCvKiGhv@sDnToGjReFtJc^bf@qJ~SsLnf@qN`[cLly@mCbLcDjHgLxNu\\fTgm@hn@uQhNeMjHoV~JmWjGsy@jHaNvGyVvU{H`LaLrZsTdd@yEvSuKpv@eKr[gQnZw[n`@kKfVqNxf@s\\xm@yG~G_JfD_IPa]cHoOu@gQwDmGSgPxB}X`@ak@`NmXrAwURcg@kCom@CaXyAeQaCiSmGsP}Isc@}[wKaGeMgEkK{@_]zAgStE}EpC}HlI}J`PwIxXyItf@uW`j@_Kfy@aD`H_OnN_HzJsLnj@{NjY{Otb@uIbNiHrHgLhGwUrFgHdGwCdGyD|\\wOru@}AtW_@jn@wB|Y{CvSeIpWeGnK_IlHmJhEqc@|J{OlJuPtRqJnUiE|QeLvv@kXx~@eEfTgm@|aFmS~hAuMviByJbl@kN|f@uj@trA}`@xiAmIfRks@`sAgOf`@uLvh@uJh`Aoa@rgCqQb_BkGr`@uo@rjCwqAtmEuKbf@oWj`BkMvj@cH~UsJrVai@tfAuShg@cj@n}AsO~_@ibAniBoOd`@{Jna@_F~]e\\zfE_c@fqBgOtPyFfKsM`k@sFb^yKxIoBdDlF~Eid@z~@o[rdAqImGfCwO";

    @Test
    public void testMultiZoomLevel() {
        line = decoder.decode(meylan_lyon);
        assertTrue(line.size() > 0);
        Point p = line.get(0);
        System.out.println("p : " + p);
        assertTrue(p.equals(orange));
        System.out.println(PolylineUtils.toMarkers(line));
        System.out.println("nb of points " + line.size());
    }

    String meylan_saint_egreve = "y||rGuxjb@KdDh@jEZnESRE`@Rd@\\CXjAjF~Kf@nDrAdN@dAQt@kBnCQf@G|@XbBjEsAlACd@FnB`Av@t@nAvBv@hCxA|LhI~gAhCnZbAtKhBhOMh@@XvC~F~i@h|@rKlQ|GtLpB~DhGhSnNlf@_CnQ[p@ab@|e@kCnCRdCGlBaAv@cE`Ce@fAU`AEjDUnA]l@{AbBeBjAqAl@}Ad@_BRsCGyIgBsCGgBVcBj@{Az@uAhA}BpCsMfReCnFcBrGsBrEaBnBmB|AaCpCSFQKQFY|AoG`NcCfCmOnR}BnFqB|Gu@|AgBrCoNfMgJpH{BxAwCnC}SxPqFdFwXxUyQnVMD{HxKmKxK[j@cCtBqErCmAj@W?iFnAZa@~E_Ds@k@c@q@uAiEm@sC";

    @Test
    public void testAnotherRoute() {
        line = decoder.decode(meylan_saint_egreve);
        assertTrue(line.size() > 0);
        Point p = line.get(0);
        System.out.println("p : " + p);
        assertTrue(p.equals(orange));
        System.out.println(PolylineUtils.toMarkers(line));
        System.out.println("nb of points " + line.size());
    }

    String meylan_grenoble_gare = "y||rGuxjb@KdDh@jEZnESRE`@Rd@\\CXjAjF~Kf@nDrAdN@dAQt@kBnCQf@G|@XbBjEsAlACd@FnB`Av@t@nAvBv@hCxA|LhI~gAhCnZbAtKhBhOMh@@XvC~F~i@h|@rKlQ|GtLpB~DhGhSnNlf@_CnQOb@o`@bd@vAvRtBhV?PqAf@";

    @Test
    public void testDirectionInTown() {
        line = decoder.decode(meylan_grenoble_gare);
        assertTrue(line.size() > 0);
        Point p = line.get(0);
        System.out.println("p : " + p);
        assertTrue(p.equals(orange));
        System.out.println(PolylineUtils.toMarkers(line));
        System.out.println("nb of points " + line.size());
    }

    String concorde_trocadero = "isfiH{t}L@aBf@{@eHma@i@uFw@o_@LmAx@aDRqCMyE}@}|ABa@Vw@@_DMm@H[?mCCi@e@MqA{@";

    @Test
    public void testParis() {
        line = decoder.decode(concorde_trocadero);
        assertTrue(line.size() > 0);
        Point p = line.get(0);
        System.out.println("p : " + p);
        System.out.println(PolylineUtils.toMarkers(line));
        System.out.println("nb of points " + line.size());
    }

}
