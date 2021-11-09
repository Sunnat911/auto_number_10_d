package uz.pdp.avto_raqam.entity.auksion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.avto_raqam.entity.autoNumber.AutoNumberDatabase;
import uz.pdp.avto_raqam.entity.user.UserType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "auksion_db")
public class AuctionDatabase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private AutoNumberDatabase autoNumberDatabase;

    private BigDecimal startPrice;
    private BigDecimal currentPrice;

    private double disCount;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private Date startedDate;
    private Date endDate;

    private String params;

    private int stateId;

    private boolean active;

}
