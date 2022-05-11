package com.example.ride2taff.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookedrides")
public class BookedRideEntity {

    @Id
    @Column(name = "id")
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user_entity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ride_id")
    private RideEntity ride_entity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserEntity getUser_entity() {
        return user_entity;
    }

    public void setUser_entity(UserEntity user_entity) {
        this.user_entity = user_entity;
    }

    public RideEntity getRide_entity() {
        return ride_entity;
    }

    public void setRide_entity(RideEntity ride_entity) {
        this.ride_entity = ride_entity;
    }
}
