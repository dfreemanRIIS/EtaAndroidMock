package com.example.dfreeman.etaandroidmock;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class ParserUnitTest {

    private final String routesTest = "[{\"company\":{\"id\":1,\"name\":\"SmartBus\",\"brandcolor\":\"#BC0E29\",\"busImgURL\":\"http://ec2-204-236-211-33.compute-1.amazonaws.com:8080/assets/images/Smart-Bus.png\",\"logoImgURL\":null},\"companyID\":1,\"routeID\":\"125\",\"routeName\":\"FORT ST-EUREKA RD\",\"routeNumber\":\"125\",\"direction1\":\"Northbound\",\"direction2\":\"Southbound\",\"daysActive\":\"Weekday,Saturday,Sunday\",\"id\":1},{\"company\":{\"id\":1,\"name\":\"SmartBus\",\"brandcolor\":\"#BC0E29\",\"busImgURL\":\"http://ec2-204-236-211-33.compute-1.amazonaws.com:8080/assets/images/Smart-Bus.png\",\"logoImgURL\":null},\"companyID\":1,\"routeID\":\"140\",\"routeName\":\"SOUTHSHORE\",\"routeNumber\":\"140\",\"direction1\":\"Northbound\",\"direction2\":\"Southbound\",\"daysActive\":\"Weekday\",\"id\":2}]";
    private final String stopsTest = "[{\"stopID\":\"22362\",\"stopName\":\"METRO AIRPORT MCNAMARA TERMINAL\",\"latitude\":\"42.20785791\",\"longitude\":\"-83.35596167\",\"order\":1,\"stopTimes\":[\"4:34AM\",\"5:29AM\",\"6:23AM\",\"7:24AM\",\"8:25AM\",\"9:21AM\",\"10:16AM\",\"11:27AM\",\"12:30PM\",\"1:24PM\",\"2:25PM\",\"3:26PM\",\"4:31PM\",\"5:32PM\",\"6:29PM\",\"7:48PM\",\"10:05PM\",\"11:13PM\"]},{\"stopID\":\"22361\",\"stopName\":\"METRO AIRPORT NORTH TERMINAL\",\"latitude\":\"42.22625663\",\"longitude\":\"-83.34620333\",\"order\":2,\"stopTimes\":[\"5:00AM\",\"6:01AM\",\"6:59AM\",\"7:55AM\",\"8:45AM\",\"9:39AM\",\"11:01AM\",\"12:02PM\",\"1:01PM\",\"1:54PM\",\"2:54PM\",\"3:53PM\",\"5:06PM\",\"6:06PM\",\"6:58PM\",\"8:35PM\",\"9:14PM\",\"6:00AM\",\"7:00AM\",\"8:00AM\",\"9:00AM\",\"10:00AM\",\"11:00AM\",\"12:00PM\",\"1:00PM\",\"2:00PM\",\"3:00PM\",\"4:00PM\",\"5:00PM\",\"6:00PM\",\"7:00PM\",\"8:00PM\",\"9:00PM\",\"10:00PM\",\"11:00PM\"]}]";
    private JsonParser parser;

    public ParserUnitTest() {
        parser = new JsonParser();
    }

    @Test
    public void testParseRoutes() throws Exception {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("125");
        temp.add("140");
        assertEquals(parser.parseRoutes(routesTest), temp);
    }

    @Test
    public void getDirection() throws Exception {
        assertEquals(parser.getDirection(routesTest, 1), "Northbound");
    }

    @Test
    public void getRouteId() throws Exception {
        assertEquals(parser.getRouteId(routesTest, 1), "2");
    }

    @Test
    public void getDaysActive() throws Exception {
        assertEquals(parser.getDaysActive(routesTest, 1), "Weekday");
    }

    @Test
    public void getStops() throws Exception {
        ArrayList<String> temp = new ArrayList<>();
        temp.add("METRO AIRPORT MCNAMARA TERMINAL");
        temp.add("METRO AIRPORT NORTH TERMINAL");
        assertEquals(parser.getStops(stopsTest), temp);
    }
}