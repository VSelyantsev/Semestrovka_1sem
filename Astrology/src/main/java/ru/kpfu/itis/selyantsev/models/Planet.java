package ru.kpfu.itis.selyantsev.models;

public class Planet {

    private Long planetId;
    private String planetName;
    private String planetDetection;
    private String planetDistance;

    public Planet(Long planetId,
                  String planetName,
                  String planetDetection,
                  String planetDistance) {
        this.planetId = planetId;
        this.planetName = planetName;
        this.planetDetection = planetDetection;
        this.planetDistance = planetDistance;
    }

    public Planet(String planetName, String planetDetection, String planetDistance) {
        this.planetName = planetName;
        this.planetDetection = planetDetection;
        this.planetDistance = planetDistance;
    }

    public Long getPlanetId() {
        return planetId;
    }

    public void setPlanetId(Long planetId) {
        this.planetId = planetId;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getPlanetDetection() {
        return planetDetection;
    }

    public void setPlanetDetection(String planetDetection) {
        this.planetDetection = planetDetection;
    }

    public String getPlanetDistance() {
        return planetDistance;
    }

    public void setPlanetDistance(String planetDistance) {
        this.planetDistance = planetDistance;
    }
}
