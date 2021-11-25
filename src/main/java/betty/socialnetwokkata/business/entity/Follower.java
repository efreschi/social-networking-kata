package betty.socialnetwokkata.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Accessors(chain = true)
@NoArgsConstructor()
@Entity
@Table(name = "FOLLOWER")
public class Follower {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
    @SequenceGenerator(name="SEQUENCE", sequenceName = "NXTNBR", initialValue = 1 ,allocationSize = 1)
    private Long id;
    private String follower;
    private String username;
}
