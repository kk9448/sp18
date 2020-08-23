import java.util.HashMap;
import java.util.Map;

/**
 * This class provides all code necessary to take a query box and produce
 * a query result. The getMapRaster method must return a Map containing all
 * seven of the required fields, otherwise the front end code will probably
 * not draw the output correctly.
 */
public class Rasterer {

    public Rasterer(){
        // YOUR CODE HERE
//        Map<String, Double> results = new HashMap<>();
//        results.put("ullon", -122.3027284165759);
//        results.put("lrlon", -122.20908713544797);
//        results.put("ullat", 37.88708748276975);
//        results.put("lrlat", 37.848731523430196);
//        results.put("w", 305.0);
//        results.put("h", 300.0);



        Map<String, Double> results = new HashMap<>();
        results.put("ullon", -122.30410170759153);
        results.put("lrlon", -122.2104604264636);
        results.put("ullat", 37.870213571328854);
        results.put("lrlat", 37.8318576119893);
        results.put("w", 1091.0);
        results.put("h", 566.0);
        getMapRaster(results);

//        results.put("ullon",-122.241632);
//        results.put("lrlon", -122.24053);
//        results.put("ullat", 37.87655);
//        results.put("lrlat", 37.87548);
//        results.put("w", 892.0);
//        results.put("h", 875.0);
//        getMapRaster(results);

    };


    /**
     * Takes a user query and finds the grid of images that best matches the query. These
     * images will be combined into one big image (rastered) by the front end. <br>
     *
     *     The grid of images must obey the following properties, where image in the
     *     grid is referred to as a "tile".
     *     <ul>
     *         <li>The tiles collected must cover the most longitudinal distance per pixel
     *         (LonDPP) possible, while still covering less than or equal to the amount of
     *         longitudinal distance per pixel in the query box for the user viewport size. </li>
     *         <li>Contains all tiles that intersect the query bounding box that fulfill the
     *         above condition.</li>
     *         <li>The tiles must be arranged in-order to reconstruct the full image.</li>
     *     </ul>
     *
     * @param params Map of the HTTP GET request's query parameters - the query box and
     *               the user viewport width and height.
     *
     * @return A map of results for the front end as specified: <br>
     * "render_grid"   : String[][], the files to display. <br>
     * "raster_ul_lon" : Number, the bounding upper left longitude of the rastered image. <br>
     * "raster_ul_lat" : Number, the bounding upper left latitude of the rastered image. <br>
     * "raster_lr_lon" : Number, the bounding lower right longitude of the rastered image. <br>
     * "raster_lr_lat" : Number, the bounding lower right latitude of the rastered image. <br>
     * "depth"         : Number, the depth of the nodes of the rastered image <br>
     * "query_success" : Boolean, whether the query was able to successfully complete; don't
     *                    forget to set this to true on success! <br>
     */
    public Map<String, Object> getMapRaster(Map<String, Double> params) {
        double ullon = params.get("ullon");
        double lrlon = params.get("lrlon");
        double ullat = params.get("ullat");
        double lrlat = params.get("lrlat");
        double resolution = (lrlon - ullon) * 288200 / params.get("w");
        int depth = findDepth(resolution);


        int ulRowNum = getUlRowNum(depth, ullon);
        int ulColNum = getUlColNum(depth, ullat);
        int lrRowNum = getUlRowNum(depth, lrlon);
        int lrColNum = getUlColNum(depth, lrlat);

        double raster_ul_lon = MapServer.ROOT_ULLON + ulRowNum * (MapServer.ROOT_LRLON - MapServer.ROOT_ULLON) / depth;
        double raster_ul_lat = MapServer.ROOT_ULLAT - ulColNum * (MapServer.ROOT_ULLAT - MapServer.ROOT_LRLAT) / depth;
        double raster_lr_lon = MapServer.ROOT_ULLON + lrRowNum * (MapServer.ROOT_LRLON - MapServer.ROOT_ULLON) / depth;
        double raster_lr_lat = MapServer.ROOT_ULLAT - lrColNum * (MapServer.ROOT_ULLAT - MapServer.ROOT_LRLAT) / depth;


        String[][] pictureSet = new String[lrColNum - ulColNum + 1][lrRowNum - ulRowNum + 1];

        int m = 0;
        int n = 0;
        for (int i = ulColNum; i <= lrColNum; i++, n++) {
            for (int j = ulRowNum; j <= lrRowNum; j++, m++) {
                pictureSet[n][m] = picture(i, j, depth);
            }
            m = 0;
        }
        Map<String, Object> results = new HashMap<>();
        String[][] a = {{"d1_x0_y0.png", "d1_x1_y0.png"}, {"d1_x0_y1.png", "d1_x1_y1.png"}};
        results.put("raster_ul_lon", raster_ul_lon);
        results.put("raster_ul_lat", raster_ul_lat);
        results.put("raster_lr_lon", raster_lr_lon);
        results.put("raster_lr_lat", raster_lr_lat);
        results.put("render_grid", pictureSet);
        results.put("query_success", true);
        results.put("depth", depth);
        return results;

//        results.put("raster_ul_lon", -122.2998046875);
//        results.put("raster_ul_lat", 37.892195547244356);
//        results.put("raster_lr_lon", -122.2119140625);
//        results.put("raster_lr_lat", 37.82280243352756);
//        System.out.println("Since you haven't implemented getMapRaster, nothing is displayed in "
//                           + "your browser.");

    }

    private String picture(int i, int j, int d) {
        Integer row = i;
        Integer col = j;
        Integer depth = d;
        StringBuilder res = new StringBuilder("d");
        res.append(depth.toString());
        res.append("_");
        res.append("x");
        res.append(col.toString());
        res.append("_");
        res.append("y");
        res.append(row.toString());
        res.append(".png");
        return  res.toString();
    }

    private int findDepth(double resolution) {
        int res = 0;
        double depthReso = 0;
        for (int i = 0; i <= 7; i++) {
            depthReso = 49 / Math.pow(2, i - 1);
            if (i == 7) {
                return 7;
            }
            if (depthReso < resolution) {
                res = i;
                return res;
            }
        }
        return res;
    }
    private int getUlRowNum(int depth, double ullon) {
        int rowNum = 0;
        double stepLon = calStep(MapServer.ROOT_LRLON, MapServer.ROOT_ULLON, depth);
        int count = -1;
        double i = MapServer.ROOT_ULLON;
        if (i >= ullon) {
            return 0;
        }
        for (; i < ullon; i += stepLon, count++) {
            if (count == Math.pow(2, depth) - 1) {
                return (int) (Math.pow(2, depth) - 1);
            }
        }
        return count;

    }

    private int getUlColNum(int depth, double ullat) {
        double stepLat = calStep(MapServer.ROOT_ULLAT, MapServer.ROOT_LRLAT, depth);
//        double distanceLat = MapServer.ROOT_LRLAT - MapServer.ROOT_ULLAT ;
//        double stepLat = distanceLat / depth;
        double i = MapServer.ROOT_ULLAT;
        if (i <= ullat) {
            return 0;
        }
        int count = -1;
        for (; i > ullat; i -= stepLat, count++) {
            if (count == Math.pow(2, depth) - 1) {
                return (int) (Math.pow(2, depth) - 1);
            }
        }
        return count;
    }

//    private int getLrRowNum(int depth, double ullon) {
//        int rowNum = 0;
//        double stepLon = calStep(MapServer.ROOT_LRLON, MapServer.ROOT_ULLON, depth);
////        double distanceLon = MapServer.ROOT_LRLON - MapServer.ROOT_ULLON;
////        double stepLon = distanceLon / depth;
//        for (double i = MapServer.ROOT_ULLON, count = 0; i < ullon; i += stepLon) {
//            count++;
//            rowNum = (int) count;
//        }
//        return rowNum;
//
//    }
//
//    private int getLrColNum(int depth, double ullat) {
//        int colNum = 0;
//        double stepLat = calStep(MapServer.ROOT_ULLAT, MapServer.ROOT_LRLAT, depth);
////        double distanceLat = MapServer.ROOT_LRLAT - MapServer.ROOT_ULLAT ;
////        double stepLat = distanceLat / depth;
//        for (double i = MapServer.ROOT_ULLAT, count = 0; i > ullat; i -= stepLat) {
//            count++;
//            colNum = (int) count;
//        }
//        return colNum;
//    }

    private double calStep(double big, double small, int depth) {
        double distance = big - small;
        double res = distance / Math.pow(2, depth);
        return res;
    }
}
