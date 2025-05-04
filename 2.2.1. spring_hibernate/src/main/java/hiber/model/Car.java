package hiber.model;

import javax.persistence.*;

@Entity
@Table(name="car")
public class Car {

    @Id
    @Column(name="user_id")
    private Long id;

    @Column(name="model")
    private String model;

    @Column(name="series")
    private int series;

    @OneToOne
    @MapsId
    @JoinColumn(name="user_id")
    private User user;

    public Car() {

    }

    public String getModel() {

        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {

        return this.series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
