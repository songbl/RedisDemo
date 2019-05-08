//package utils;
//
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import entry.Area;
//import entry.City;
//import entry.Province;
//
//public class jackSonTest {
//
//    public static void main(String args[]) {
//        String province_json ;
//        Area area = new Area();
//        City city1 = new City(1,"枣庄");
//        City city2 = new City(2,"菏泽");
//        Province province = new Province(1,"山东");
//       area.getCityList().add(city1);
//       area.getCityList().add(city2);
//       area.getProviceList().add(province);
//        //2.2将list序列化为json
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            province_json = mapper.writeValueAsString(area);
//            System.out.println(province_json);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
