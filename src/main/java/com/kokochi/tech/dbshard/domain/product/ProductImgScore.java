package com.kokochi.tech.dbshard.domain.product;

import com.kokochi.tech.dbshard.domain.shard.ShardKeyObject;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
@IdClass(ProductImgScorePK.class)
@Table(name = "dss_product_img_score", indexes =  {
        @Index(name = "idx_product_img_id", columnList = "productImgId"),
        @Index(name = "idx_user_id", columnList = "userId"),
})
public class ProductImgScore implements ShardKeyObject {
    @Id
    private Long productImgId;
    @Id
    private String userId;
    private int score;
}
