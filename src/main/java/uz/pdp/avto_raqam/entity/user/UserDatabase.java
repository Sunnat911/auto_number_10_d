package uz.pdp.avto_raqam.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.avto_raqam.entity.base.BaseDatabase;
import uz.pdp.avto_raqam.entity.role.RoleDatabase;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class UserDatabase extends BaseDatabase {

    private String phoneNumber;
    private String password;
    private String passport;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String pinfl;

    @ManyToMany
    private List<RoleDatabase> roleDatabases;

}
