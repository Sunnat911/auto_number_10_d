package uz.pdp.avto_raqam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.avto_raqam.entity.autoNumber.AutoNumberDatabase;

public interface AutoNumberRepository extends JpaRepository<AutoNumberDatabase,Integer> {

}
