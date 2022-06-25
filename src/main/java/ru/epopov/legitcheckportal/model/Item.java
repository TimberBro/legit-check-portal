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

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "item_id")
  @Id
  int id;

  // Which currency? By default, might be USD
  @Column(name = "item_price")
  private BigInteger itemPrice;
  // Should it be stored here or in Order?
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
  /*
  To store photos, I'll use folder on same machine and keep path to image on local disk
  In the future photos should be uploaded to cloud-object storage like s3 or ceph
  and keep URLs to images.
   */
  @Column(name = "item_photo")
  private String itemPhotoPath;
  @Column(name = "manufacture")
  private String manufacture;
}