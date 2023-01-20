package com.kokochi.tech.dbshard.service.product.repository;

import com.kokochi.tech.dbshard.domain.product.ProductImg;
import com.kokochi.tech.dbshard.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImgRepository extends JpaRepository<ProductImg, Long> {

    @Query("select pi " +
            " from ProductImgScore ps left join ProductImg pi on pi.productImgId = ps.productImgId" +
            " group by ps.productImgId" +
            " order by (sum(ps.score) / count(ps.score)) desc")
    Page<ProductImg> findByPaging(Pageable pageable);

    @Query("select pi " +
            " from ProductImgScore ps left join ProductImg pi on pi.productImgId = ps.productImgId" +
            " where pi.uploadUser = :user" +
            " group by ps.productImgId" +
            " order by (sum(ps.score) / count(ps.score)) desc")
    Page<ProductImg> findByUploadUserPaging(User user, Pageable pageable);

}
