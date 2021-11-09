package uz.pdp.avto_raqam.entity.region;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.avto_raqam.entity.base.BaseDatabase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class CityDatabase extends BaseDatabase {

    @ManyToOne
    private RegionDatabase regionDatabase;


}
