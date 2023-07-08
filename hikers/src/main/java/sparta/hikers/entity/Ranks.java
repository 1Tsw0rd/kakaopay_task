package sparta.hikers.entity;

import lombok.Getter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Subselect("SELECT DENSE_RANK() OVER(ORDER BY COUNT(o.menu_id) DESC) ranking, o.menu_id, m.menu_name, m.price, COUNT(o.menu_id) order_count\n" +
        "FROM menus m, orders o\n" +
        "WHERE m.menu_id = o.menu_id \n" +
        "AND ordered_date BETWEEN DATE_ADD(NOW(), INTERVAL -1 WEEK) AND NOW()\n" +
        "GROUP BY o.menu_id\n" +
        "ORDER BY 1, 2")
@Getter
@Immutable
@Entity
public class Ranks {

    @Id
    private Long ranking;
    @Column(nullable = false, name = "menu_id")
    private Long menuId;
    @Column(nullable = false, name = "menu_name")
    private String menuName;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false, name = "order_count")
    private Long orderCount;
}
