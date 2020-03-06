package com.flygram.Domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("photo")
public class PhotoPost extends Post {

}
