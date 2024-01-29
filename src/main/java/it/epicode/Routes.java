package it.epicode;

import javax.persistence.*;

@Entity
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "route_number", nullable = false)
    private Long routeNumber;
    private String routeStart;
    private String routeEnd;
    private Integer averageTravelTime;
    @ManyToOne
    @JoinTable(name = "vehicle_number")
    private Long vehicle;

    public Routes() {
    }

    public Routes(String routeStart, String routeEnd, Integer averageTravelTime, Long vehicle) {
        this.routeStart = routeStart;
        this.routeEnd = routeEnd;
        this.averageTravelTime = averageTravelTime;
        this.vehicle = vehicle;
    }

    public Long getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(Long routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getRouteStart() {
        return routeStart;
    }

    public void setRouteStart(String routeStart) {
        this.routeStart = routeStart;
    }

    public String getRouteEnd() {
        return routeEnd;
    }

    public void setRouteEnd(String routeEnd) {
        this.routeEnd = routeEnd;
    }

    public Integer getAverageTravelTime() {
        return averageTravelTime;
    }

    public void setAverageTravelTime(Integer averageTravelTime) {
        this.averageTravelTime = averageTravelTime;
    }

    public Long getVehicle() {
        return vehicle;
    }

    public void setVehicle(Long vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "routeNumber=" + routeNumber +
                ", routeStart='" + routeStart + '\'' +
                ", routeEnd='" + routeEnd + '\'' +
                ", averageTravelTime=" + averageTravelTime +
                ", vehicle=" + vehicle +
                '}';
    }
}
