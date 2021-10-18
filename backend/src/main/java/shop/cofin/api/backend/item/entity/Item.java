package shop.cofin.api.backend.item.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;
import shop.cofin.api.backend.board.entity.Article;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @Component @Table(name = "items")
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue
    private Long itemId;

    @Column(name = "item_brand", length = 20) @NotNull private String itemBrand;
    @Column(name = "item_name", length = 50) @NotNull private String itemName;
    @Column(name = "item_color", length = 20) @NotNull private String itemColor;
    @Column(name = "released_date", length = 20) @NotNull private String releasedDate;
    @OneToMany(mappedBy = "item")
    private List<Article> articleList = new ArrayList<>();
}
