package com.flygram.Domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("video")
public class VideoPost extends Post {

}
