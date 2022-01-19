package com.vektorel.musteritakip.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tblcategory")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    // Ana kategoriye bağlanma
    long parentid;
    String ad;
    String url;
    String image;
    String description;
    int state;
}
