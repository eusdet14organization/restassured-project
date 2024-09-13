package utils;

import dto.Data;
import dto.GadgetPost;

import static java.time.LocalTime.now;

public class TestDataHelper {
    public static GadgetPost createSampleGadgetPost(String name) {
        GadgetPost gadgetPost = new GadgetPost();
        Data data = new Data();
        data.setYear(2019);
        data.setPrice(1849.99);
        data.setCpuModel("Intel Core i9");
        data.setHardDiskSize("1 TB");
        gadgetPost.setName(name + now());
        gadgetPost.setData(data);
        return gadgetPost;
    }

    public static GadgetPost createSampleGadgetPost() {
        return createSampleGadgetPost("Apple MacBook Pro 16 ");
    }
}
