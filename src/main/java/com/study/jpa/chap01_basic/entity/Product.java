package com.study.jpa.chap01_basic.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@ToString @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //오라클의 시퀀스의 개념
    @Column(name = "prod_id")
    private long id;

    @Column(name = "prod_name", nullable = false, length = 30)
    private String name;

    private int price = 0; //기본값 세팅 0

    @Enumerated(EnumType.STRING)
    private Category category;

    @CreationTimestamp // 생성 시 시간 등록
    @Column(updatable = false) //등록시간이 등록되면 수정 불가.
    private LocalDateTime createDate;

    @UpdateTimestamp //업데이트 시 시간등록
    private LocalDateTime updateDate;

    public enum Category {
        FOOD, FASHION, ELECTRONIC
    }



}
