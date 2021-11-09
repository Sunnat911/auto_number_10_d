package uz.pdp.avto_raqam.entity.region;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.avto_raqam.entity.base.BaseDatabase;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class RegionDatabase extends BaseDatabase {

    private String code;
}
