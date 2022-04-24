package ru.epopov.legitcheckportal.model;

import java.math.BigInteger;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ITEMS")
@Data
public class Item {

  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "item_id")
  @Id
  int id;

  @Column(name = "item_price")
  private BigInteger itemPrice;
  @Column(name = "size")
  private String sizeTag;
  @Column(name = "name")
  private String itemName;
  @Column(name = "release_date")
  private Date releaseDate;
  @Column(name = "SKU")
  private String stockKeepingUnit;
  @Column(name = "description")
  private String description;
  @Column(name = "color_name")
  private String colorName;

  // Might want to create one more entity for categories
  @Column(name = "categories")
  private String categories;
  @Column(name = "item_photo")
  private byte[] itemPhoto;
  @Column(name = "manufacture")
  private String manufacture;
}