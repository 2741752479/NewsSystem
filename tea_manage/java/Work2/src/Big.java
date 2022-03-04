public class Big {
    private String id;
    private String name;
    private String adress;
    private String produce;

    public Big() {
    }

    public Big(String id, String name, String adress, String produce) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.produce = produce;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    @Override
    public String toString() {
        return "Big{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", produce='" + produce + '\'' +
                '}';
    }
}
