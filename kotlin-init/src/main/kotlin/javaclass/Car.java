package javaclass;

public class Car {
    private String id;
    private String modelName;
    private CarType carType;

    public Car(String id, String modelName, CarType carType) {
        this.id = id;
        this.modelName = modelName;
        this.carType = carType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
