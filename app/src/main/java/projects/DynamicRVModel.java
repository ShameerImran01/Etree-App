package projects;

public class DynamicRVModel {


    String name, desc;
    int image;




    public DynamicRVModel(String name, int image, String desc) {
        this.name = name;
        this.image = image;
        this.desc = desc;


    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
    public String getDesc() {
        return desc;
    }

}
