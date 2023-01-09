/**
 * 房间中的物品
 */
package test.java.cn.edu.whut.sept.zuul;

public class Material {
    private String name;
    private String description;
    private double weight; // 单位为g

    @Override
    public String toString() {
        return "有" + weight + "g的" + name + "," + description + ".\n";
    }

    public Material(String name, String description, double weight) {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
