package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceTestData_HW {
    public static Map<String, Object> expectedDataMap(String name, String job, int id,String createdAt) {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("Name", name);
        expectedData.put("Job", job);
        expectedData.put("Id", id);
        expectedData.put("createdAt",createdAt);

        return expectedData;
}}
