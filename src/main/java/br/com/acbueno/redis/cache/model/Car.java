package br.com.acbueno.redis.cache.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "car")
@Data
public class Car implements Serializable {
	
	public static final String CACHE_NAME = "Car";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "model_mame")
	private String modelName;
	
	@Column(name = "version_name")
	private String versionName;
	
	@Column(name = "brand_name")
	private String brandName;

}
